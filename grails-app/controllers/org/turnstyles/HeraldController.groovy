package org.turnstyles

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class HeraldController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Herald.list(params), model:[heraldCount: Herald.count()]
    }

    def show(Herald herald) {
        respond herald
    }

    def create() {
        respond new Herald(params)
    }

    @Transactional
    def save(Herald herald) {
        if (herald == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (herald.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond herald.errors, view:'create'
            return
        }

        herald.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'herald.label', default: 'Herald'), herald.id])
                redirect herald
            }
            '*' { respond herald, [status: CREATED] }
        }
    }

    def edit(Herald herald) {
        respond herald
    }

    @Transactional
    def update(Herald herald) {
        if (herald == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (herald.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond herald.errors, view:'edit'
            return
        }

        herald.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'herald.label', default: 'Herald'), herald.id])
                redirect herald
            }
            '*'{ respond herald, [status: OK] }
        }
    }

    @Transactional
    def delete(Herald herald) {

        if (herald == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        herald.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'herald.label', default: 'Herald'), herald.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'herald.label', default: 'Herald'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
