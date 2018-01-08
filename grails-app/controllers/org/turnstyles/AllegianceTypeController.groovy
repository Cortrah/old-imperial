package org.turnstyles

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class AllegianceTypeController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond AllegianceType.list(params), model:[allegianceTypeCount: AllegianceType.count()]
    }

    def show(AllegianceType allegianceType) {
        respond allegianceType
    }

    def create() {
        respond new AllegianceType(params)
    }

    @Transactional
    def save(AllegianceType allegianceType) {
        if (allegianceType == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (allegianceType.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond allegianceType.errors, view:'create'
            return
        }

        allegianceType.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'allegianceType.label', default: 'AllegianceType'), allegianceType.id])
                redirect allegianceType
            }
            '*' { respond allegianceType, [status: CREATED] }
        }
    }

    def edit(AllegianceType allegianceType) {
        respond allegianceType
    }

    @Transactional
    def update(AllegianceType allegianceType) {
        if (allegianceType == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (allegianceType.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond allegianceType.errors, view:'edit'
            return
        }

        allegianceType.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'allegianceType.label', default: 'AllegianceType'), allegianceType.id])
                redirect allegianceType
            }
            '*'{ respond allegianceType, [status: OK] }
        }
    }

    @Transactional
    def delete(AllegianceType allegianceType) {

        if (allegianceType == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        allegianceType.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'allegianceType.label', default: 'AllegianceType'), allegianceType.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'allegianceType.label', default: 'AllegianceType'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
