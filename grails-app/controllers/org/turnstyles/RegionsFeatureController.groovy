package org.turnstyles

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class RegionsFeatureController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond RegionsFeature.list(params), model:[regionsFeatureCount: RegionsFeature.count()]
    }

    def show(RegionsFeature regionsFeature) {
        respond regionsFeature
    }

    def create() {
        respond new RegionsFeature(params)
    }

    @Transactional
    def save(RegionsFeature regionsFeature) {
        if (regionsFeature == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (regionsFeature.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond regionsFeature.errors, view:'create'
            return
        }

        regionsFeature.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'regionsFeature.label', default: 'RegionsFeature'), regionsFeature.id])
                redirect regionsFeature
            }
            '*' { respond regionsFeature, [status: CREATED] }
        }
    }

    def edit(RegionsFeature regionsFeature) {
        respond regionsFeature
    }

    @Transactional
    def update(RegionsFeature regionsFeature) {
        if (regionsFeature == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (regionsFeature.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond regionsFeature.errors, view:'edit'
            return
        }

        regionsFeature.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'regionsFeature.label', default: 'RegionsFeature'), regionsFeature.id])
                redirect regionsFeature
            }
            '*'{ respond regionsFeature, [status: OK] }
        }
    }

    @Transactional
    def delete(RegionsFeature regionsFeature) {

        if (regionsFeature == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        regionsFeature.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'regionsFeature.label', default: 'RegionsFeature'), regionsFeature.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'regionsFeature.label', default: 'RegionsFeature'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
