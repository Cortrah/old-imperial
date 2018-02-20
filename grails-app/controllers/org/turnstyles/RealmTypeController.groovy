package org.turnstyles

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class RealmTypeController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond RealmType.list(params), model:[realmTypeCount: RealmType.count()]
    }

    def show(RealmType realmType) {
        respond realmType
    }

    def create() {
        respond new RealmType(params)
    }

    @Transactional
    def save(RealmType realmType) {
        if (realmType == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (realmType.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond realmType.errors, view:'create'
            return
        }

        realmType.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'realmType.label', default: 'RealmType'), realmType.id])
                redirect realmType
            }
            '*' { respond realmType, [status: CREATED] }
        }
    }

    def edit(RealmType realmType) {
        respond realmType
    }

    @Transactional
    def update(RealmType realmType) {
        if (realmType == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (realmType.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond realmType.errors, view:'edit'
            return
        }

        realmType.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'realmType.label', default: 'RealmType'), realmType.id])
                redirect realmType
            }
            '*'{ respond realmType, [status: OK] }
        }
    }

    @Transactional
    def delete(RealmType realmType) {

        if (realmType == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        realmType.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'realmType.label', default: 'RealmType'), realmType.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'realmType.label', default: 'RealmType'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
