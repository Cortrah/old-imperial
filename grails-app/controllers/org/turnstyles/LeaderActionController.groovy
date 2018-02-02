package org.turnstyles

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class LeaderActionController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond LeaderAction.list(params), model:[leaderActionCount: LeaderAction.count()]
    }

    def show(LeaderAction leaderAction) {
        respond leaderAction
    }

    def create() {
        respond new LeaderAction(params)
    }

    @Transactional
    def save(LeaderAction leaderAction) {
        if (leaderAction == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (leaderAction.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond leaderAction.errors, view:'create'
            return
        }

        leaderAction.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'leaderAction.label', default: 'LeaderAction'), leaderAction.id])
                redirect leaderAction
            }
            '*' { respond leaderAction, [status: CREATED] }
        }
    }

    def edit(LeaderAction leaderAction) {
        respond leaderAction
    }

    @Transactional
    def update(LeaderAction leaderAction) {
        if (leaderAction == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (leaderAction.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond leaderAction.errors, view:'edit'
            return
        }

        leaderAction.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'leaderAction.label', default: 'LeaderAction'), leaderAction.id])
                redirect leaderAction
            }
            '*'{ respond leaderAction, [status: OK] }
        }
    }

    @Transactional
    def delete(LeaderAction leaderAction) {

        if (leaderAction == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        leaderAction.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'leaderAction.label', default: 'LeaderAction'), leaderAction.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'leaderAction.label', default: 'LeaderAction'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
