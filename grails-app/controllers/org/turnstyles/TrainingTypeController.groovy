package org.turnstyles

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class TrainingTypeController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond TrainingType.list(params), model:[trainingTypeCount: TrainingType.count()]
    }

    def show(TrainingType trainingType) {
        respond trainingType
    }

    def create() {
        respond new TrainingType(params)
    }

    @Transactional
    def save(TrainingType trainingType) {
        if (trainingType == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (trainingType.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond trainingType.errors, view:'create'
            return
        }

        trainingType.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'trainingType.label', default: 'TrainingType'), trainingType.id])
                redirect trainingType
            }
            '*' { respond trainingType, [status: CREATED] }
        }
    }

    def edit(TrainingType trainingType) {
        respond trainingType
    }

    @Transactional
    def update(TrainingType trainingType) {
        if (trainingType == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (trainingType.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond trainingType.errors, view:'edit'
            return
        }

        trainingType.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'trainingType.label', default: 'TrainingType'), trainingType.id])
                redirect trainingType
            }
            '*'{ respond trainingType, [status: OK] }
        }
    }

    @Transactional
    def delete(TrainingType trainingType) {

        if (trainingType == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        trainingType.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'trainingType.label', default: 'TrainingType'), trainingType.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'trainingType.label', default: 'TrainingType'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
