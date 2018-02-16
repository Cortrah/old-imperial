package org.turnstyles

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class CostController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Cost.list(params), model:[costCount: Cost.count()]
    }

    def show(Cost cost) {
        respond cost
    }

    def create() {
        respond new Cost(params)
    }

    @Transactional
    def save(Cost cost) {
        if (cost == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (cost.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond cost.errors, view:'create'
            return
        }

        cost.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'cost.label', default: 'Cost'), cost.id])
                redirect cost
            }
            '*' { respond cost, [status: CREATED] }
        }
    }

    def edit(Cost cost) {
        respond cost
    }

    @Transactional
    def update(Cost cost) {
        if (cost == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (cost.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond cost.errors, view:'edit'
            return
        }

        cost.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'cost.label', default: 'Cost'), cost.id])
                redirect cost
            }
            '*'{ respond cost, [status: OK] }
        }
    }

    @Transactional
    def delete(Cost cost) {

        if (cost == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        cost.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'cost.label', default: 'Cost'), cost.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'cost.label', default: 'Cost'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
