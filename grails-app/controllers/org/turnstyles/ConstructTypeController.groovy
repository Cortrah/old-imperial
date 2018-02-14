package org.turnstyles

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class ConstructTypeController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond ConstructType.list(params), model:[constructTypeCount: ConstructType.count()]
    }

    def show(ConstructType constructType) {
        respond constructType
    }

    def create() {
        respond new ConstructType(params)
    }

    @Transactional
    def save(ConstructType constructType) {
        if (constructType == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (constructType.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond constructType.errors, view:'create'
            return
        }

        constructType.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'constructType.label', default: 'ConstructType'), constructType.id])
                redirect constructType
            }
            '*' { respond constructType, [status: CREATED] }
        }
    }

    def edit(ConstructType constructType) {
        respond constructType
    }

    @Transactional
    def update(ConstructType constructType) {
        if (constructType == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (constructType.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond constructType.errors, view:'edit'
            return
        }

        constructType.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'constructType.label', default: 'ConstructType'), constructType.id])
                redirect constructType
            }
            '*'{ respond constructType, [status: OK] }
        }
    }

    @Transactional
    def delete(ConstructType constructType) {

        if (constructType == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        constructType.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'constructType.label', default: 'ConstructType'), constructType.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'constructType.label', default: 'ConstructType'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
