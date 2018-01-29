package org.turnstyles

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class LeaderActionTypeController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond LeaderActionType.list(params), model:[leaderActionTypeCount: LeaderActionType.count()]
    }

    def show(LeaderActionType leaderActionType) {
        respond leaderActionType
    }

    def create() {
        respond new LeaderActionType(params)
    }

    @Transactional
    def save(LeaderActionType leaderActionType) {
        if (leaderActionType == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (leaderActionType.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond leaderActionType.errors, view:'create'
            return
        }

        leaderActionType.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'leaderActionType.label', default: 'LeaderActionType'), leaderActionType.id])
                redirect leaderActionType
            }
            '*' { respond leaderActionType, [status: CREATED] }
        }
    }

    def edit(LeaderActionType leaderActionType) {
        respond leaderActionType
    }

    @Transactional
    def update(LeaderActionType leaderActionType) {
        if (leaderActionType == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (leaderActionType.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond leaderActionType.errors, view:'edit'
            return
        }

        leaderActionType.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'leaderActionType.label', default: 'LeaderActionType'), leaderActionType.id])
                redirect leaderActionType
            }
            '*'{ respond leaderActionType, [status: OK] }
        }
    }

    @Transactional
    def delete(LeaderActionType leaderActionType) {

        if (leaderActionType == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        leaderActionType.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'leaderActionType.label', default: 'LeaderActionType'), leaderActionType.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'leaderActionType.label', default: 'LeaderActionType'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
