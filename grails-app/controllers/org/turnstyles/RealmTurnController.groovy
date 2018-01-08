package org.turnstyles

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class RealmTurnController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond RealmTurn.list(params), model:[realmTurnCount: RealmTurn.count()]
    }

    def show(RealmTurn realmTurn) {
        respond realmTurn
    }

    def create() {
        respond new RealmTurn(params)
    }

    @Transactional
    def save(RealmTurn realmTurn) {
        if (realmTurn == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (realmTurn.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond realmTurn.errors, view:'create'
            return
        }

        realmTurn.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'realmTurn.label', default: 'RealmTurn'), realmTurn.id])
                redirect realmTurn
            }
            '*' { respond realmTurn, [status: CREATED] }
        }
    }

    def edit(RealmTurn realmTurn) {
        respond realmTurn
    }

    @Transactional
    def update(RealmTurn realmTurn) {
        if (realmTurn == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (realmTurn.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond realmTurn.errors, view:'edit'
            return
        }

        realmTurn.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'realmTurn.label', default: 'RealmTurn'), realmTurn.id])
                redirect realmTurn
            }
            '*'{ respond realmTurn, [status: OK] }
        }
    }

    @Transactional
    def delete(RealmTurn realmTurn) {

        if (realmTurn == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        realmTurn.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'realmTurn.label', default: 'RealmTurn'), realmTurn.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'realmTurn.label', default: 'RealmTurn'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
