package org.turnstyles

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class FeatureTypeController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond FeatureType.list(params), model:[featureTypeCount: FeatureType.count()]
    }

    def show(FeatureType featureType) {
        respond featureType
    }

    def create() {
        respond new FeatureType(params)
    }

    @Transactional
    def save(FeatureType featureType) {
        if (featureType == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (featureType.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond featureType.errors, view:'create'
            return
        }

        featureType.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'featureType.label', default: 'FeatureType'), featureType.id])
                redirect featureType
            }
            '*' { respond featureType, [status: CREATED] }
        }
    }

    def edit(FeatureType featureType) {
        respond featureType
    }

    @Transactional
    def update(FeatureType featureType) {
        if (featureType == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (featureType.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond featureType.errors, view:'edit'
            return
        }

        featureType.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'featureType.label', default: 'FeatureType'), featureType.id])
                redirect featureType
            }
            '*'{ respond featureType, [status: OK] }
        }
    }

    @Transactional
    def delete(FeatureType featureType) {

        if (featureType == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        featureType.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'featureType.label', default: 'FeatureType'), featureType.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'featureType.label', default: 'FeatureType'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
