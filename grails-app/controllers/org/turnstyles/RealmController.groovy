package org.turnstyles

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class RealmController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Realm.list(params), model:[realmCount: Realm.count()]
    }

    def show(Realm realm) {
        respond realm
    }

    def create() {
        respond new Realm(params)
    }

    @Transactional
    def save(Realm realm) {
        if (realm == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (realm.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond realm.errors, view:'create'
            return
        }

        realm.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'realm.label', default: 'Realm'), realm.id])
                redirect realm
            }
            '*' { respond realm, [status: CREATED] }
        }
    }

    def edit(Realm realm) {
        respond realm
    }

    @Transactional
    def update(Realm realm) {
        if (realm == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (realm.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond realm.errors, view:'edit'
            return
        }

        realm.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'realm.label', default: 'Realm'), realm.id])
                redirect realm
            }
            '*'{ respond realm, [status: OK] }
        }
    }

    @Transactional
    def delete(Realm realm) {

        if (realm == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        realm.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'realm.label', default: 'Realm'), realm.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'realm.label', default: 'Realm'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
