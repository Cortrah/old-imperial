package org.turnstyles

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class LeaderController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Leader.list(params), model:[leaderCount: Leader.count()]
    }

    def show(Leader leader) {
        respond leader
    }

    def create() {
        respond new Leader(params)
    }

    @Transactional
    def save(Leader leader) {
        if (leader == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (leader.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond leader.errors, view:'create'
            return
        }

        leader.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'leader.label', default: 'Leader'), leader.id])
                redirect leader
            }
            '*' { respond leader, [status: CREATED] }
        }
    }

    def edit(Leader leader) {
        respond leader
    }

    @Transactional
    def update(Leader leader) {
        if (leader == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (leader.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond leader.errors, view:'edit'
            return
        }

        leader.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'leader.label', default: 'Leader'), leader.id])
                redirect leader
            }
            '*'{ respond leader, [status: OK] }
        }
    }

    @Transactional
    def delete(Leader leader) {

        if (leader == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        leader.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'leader.label', default: 'Leader'), leader.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'leader.label', default: 'Leader'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
