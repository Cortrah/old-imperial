package org.turnstyles

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class BuildLocationTypeController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond BuildLocationType.list(params), model:[buildLocationTypeCount: BuildLocationType.count()]
    }

    def show(BuildLocationType buildLocationType) {
        respond buildLocationType
    }

    def create() {
        respond new BuildLocationType(params)
    }

    @Transactional
    def save(BuildLocationType buildLocationType) {
        if (buildLocationType == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (buildLocationType.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond buildLocationType.errors, view:'create'
            return
        }

        buildLocationType.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'buildLocationType.label', default: 'BuildLocationType'), buildLocationType.id])
                redirect buildLocationType
            }
            '*' { respond buildLocationType, [status: CREATED] }
        }
    }

    def edit(BuildLocationType buildLocationType) {
        respond buildLocationType
    }

    @Transactional
    def update(BuildLocationType buildLocationType) {
        if (buildLocationType == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (buildLocationType.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond buildLocationType.errors, view:'edit'
            return
        }

        buildLocationType.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'buildLocationType.label', default: 'BuildLocationType'), buildLocationType.id])
                redirect buildLocationType
            }
            '*'{ respond buildLocationType, [status: OK] }
        }
    }

    @Transactional
    def delete(BuildLocationType buildLocationType) {

        if (buildLocationType == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        buildLocationType.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'buildLocationType.label', default: 'BuildLocationType'), buildLocationType.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'buildLocationType.label', default: 'BuildLocationType'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
