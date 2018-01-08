package org.turnstyles

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class KindredController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Kindred.list(params), model:[kindredCount: Kindred.count()]
    }

    def show(Kindred kindred) {
        respond kindred
    }

    def create() {
        respond new Kindred(params)
    }

    @Transactional
    def save(Kindred kindred) {
        if (kindred == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (kindred.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond kindred.errors, view:'create'
            return
        }

        kindred.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'kindred.label', default: 'Kindred'), kindred.id])
                redirect kindred
            }
            '*' { respond kindred, [status: CREATED] }
        }
    }

    def edit(Kindred kindred) {
        respond kindred
    }

    @Transactional
    def update(Kindred kindred) {
        if (kindred == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (kindred.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond kindred.errors, view:'edit'
            return
        }

        kindred.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'kindred.label', default: 'Kindred'), kindred.id])
                redirect kindred
            }
            '*'{ respond kindred, [status: OK] }
        }
    }

    @Transactional
    def delete(Kindred kindred) {

        if (kindred == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        kindred.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'kindred.label', default: 'Kindred'), kindred.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'kindred.label', default: 'Kindred'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
