package org.turnstyles

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class EffectController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Effect.list(params), model:[effectCount: Effect.count()]
    }

    def show(Effect effect) {
        respond effect
    }

    def create() {
        respond new Effect(params)
    }

    @Transactional
    def save(Effect effect) {
        if (effect == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (effect.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond effect.errors, view:'create'
            return
        }

        effect.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'effect.label', default: 'Effect'), effect.id])
                redirect effect
            }
            '*' { respond effect, [status: CREATED] }
        }
    }

    def edit(Effect effect) {
        respond effect
    }

    @Transactional
    def update(Effect effect) {
        if (effect == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (effect.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond effect.errors, view:'edit'
            return
        }

        effect.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'effect.label', default: 'Effect'), effect.id])
                redirect effect
            }
            '*'{ respond effect, [status: OK] }
        }
    }

    @Transactional
    def delete(Effect effect) {

        if (effect == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        effect.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'effect.label', default: 'Effect'), effect.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'effect.label', default: 'Effect'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
