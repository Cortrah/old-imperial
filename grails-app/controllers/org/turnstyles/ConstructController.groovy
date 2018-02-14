package org.turnstyles

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class ConstructController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Construct.list(params), model:[constructCount: Construct.count()]
    }

    def show(Construct construct) {
        respond construct
    }

    def create() {
        respond new Construct(params)
    }

    @Transactional
    def save(Construct construct) {
        if (construct == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (construct.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond construct.errors, view:'create'
            return
        }

        construct.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'construct.label', default: 'Construct'), construct.id])
                redirect construct
            }
            '*' { respond construct, [status: CREATED] }
        }
    }

    def edit(Construct construct) {
        respond construct
    }

    @Transactional
    def update(Construct construct) {
        if (construct == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (construct.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond construct.errors, view:'edit'
            return
        }

        construct.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'construct.label', default: 'Construct'), construct.id])
                redirect construct
            }
            '*'{ respond construct, [status: OK] }
        }
    }

    @Transactional
    def delete(Construct construct) {

        if (construct == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        construct.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'construct.label', default: 'Construct'), construct.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'construct.label', default: 'Construct'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
