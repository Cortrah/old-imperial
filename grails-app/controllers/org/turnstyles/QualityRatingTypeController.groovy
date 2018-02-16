package org.turnstyles

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class QualityRatingTypeController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond QualityRatingType.list(params), model:[qualityRatingTypeCount: QualityRatingType.count()]
    }

    def show(QualityRatingType qualityRatingType) {
        respond qualityRatingType
    }

    def create() {
        respond new QualityRatingType(params)
    }

    @Transactional
    def save(QualityRatingType qualityRatingType) {
        if (qualityRatingType == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (qualityRatingType.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond qualityRatingType.errors, view:'create'
            return
        }

        qualityRatingType.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'qualityRatingType.label', default: 'QualityRatingType'), qualityRatingType.id])
                redirect qualityRatingType
            }
            '*' { respond qualityRatingType, [status: CREATED] }
        }
    }

    def edit(QualityRatingType qualityRatingType) {
        respond qualityRatingType
    }

    @Transactional
    def update(QualityRatingType qualityRatingType) {
        if (qualityRatingType == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (qualityRatingType.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond qualityRatingType.errors, view:'edit'
            return
        }

        qualityRatingType.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'qualityRatingType.label', default: 'QualityRatingType'), qualityRatingType.id])
                redirect qualityRatingType
            }
            '*'{ respond qualityRatingType, [status: OK] }
        }
    }

    @Transactional
    def delete(QualityRatingType qualityRatingType) {

        if (qualityRatingType == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        qualityRatingType.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'qualityRatingType.label', default: 'QualityRatingType'), qualityRatingType.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'qualityRatingType.label', default: 'QualityRatingType'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
