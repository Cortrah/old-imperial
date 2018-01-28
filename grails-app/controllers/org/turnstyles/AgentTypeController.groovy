package org.turnstyles

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class AgentTypeController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond AgentType.list(params), model:[agentTypeCount: AgentType.count()]
    }

    def show(AgentType agentType) {
        respond agentType
    }

    def create() {
        respond new AgentType(params)
    }

    @Transactional
    def save(AgentType agentType) {
        if (agentType == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (agentType.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond agentType.errors, view:'create'
            return
        }

        agentType.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'agentType.label', default: 'AgentType'), agentType.id])
                redirect agentType
            }
            '*' { respond agentType, [status: CREATED] }
        }
    }

    def edit(AgentType agentType) {
        respond agentType
    }

    @Transactional
    def update(AgentType agentType) {
        if (agentType == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (agentType.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond agentType.errors, view:'edit'
            return
        }

        agentType.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'agentType.label', default: 'AgentType'), agentType.id])
                redirect agentType
            }
            '*'{ respond agentType, [status: OK] }
        }
    }

    @Transactional
    def delete(AgentType agentType) {

        if (agentType == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        agentType.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'agentType.label', default: 'AgentType'), agentType.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'agentType.label', default: 'AgentType'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
