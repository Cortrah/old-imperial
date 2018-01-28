package org.turnstyles

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class NarrativeController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Narrative.list(params), model:[narrativeCount: Narrative.count()]
    }

    def show(Narrative narrative) {
        respond narrative
    }

    def create() {
        respond new Narrative(params)
    }

    @Transactional
    def save(Narrative narrative) {
        if (narrative == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (narrative.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond narrative.errors, view:'create'
            return
        }

        narrative.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'narrative.label', default: 'Narrative'), narrative.id])
                redirect narrative
            }
            '*' { respond narrative, [status: CREATED] }
        }
    }

    def edit(Narrative narrative) {
        respond narrative
    }

    @Transactional
    def update(Narrative narrative) {
        if (narrative == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (narrative.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond narrative.errors, view:'edit'
            return
        }

        narrative.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'narrative.label', default: 'Narrative'), narrative.id])
                redirect narrative
            }
            '*'{ respond narrative, [status: OK] }
        }
    }

    @Transactional
    def delete(Narrative narrative) {

        if (narrative == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        narrative.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'narrative.label', default: 'Narrative'), narrative.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'narrative.label', default: 'Narrative'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
