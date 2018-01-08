package org.turnstyles

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class TurnController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Turn.list(params), model:[turnCount: Turn.count()]
    }

    def show(Turn turn) {
        respond turn
    }

    def create() {
        respond new Turn(params)
    }

    @Transactional
    def save(Turn turn) {
        if (turn == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (turn.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond turn.errors, view:'create'
            return
        }

        turn.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'turn.label', default: 'Turn'), turn.id])
                redirect turn
            }
            '*' { respond turn, [status: CREATED] }
        }
    }

    def edit(Turn turn) {
        respond turn
    }

    @Transactional
    def update(Turn turn) {
        if (turn == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (turn.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond turn.errors, view:'edit'
            return
        }

        turn.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'turn.label', default: 'Turn'), turn.id])
                redirect turn
            }
            '*'{ respond turn, [status: OK] }
        }
    }

    @Transactional
    def delete(Turn turn) {

        if (turn == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        turn.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'turn.label', default: 'Turn'), turn.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'turn.label', default: 'Turn'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
