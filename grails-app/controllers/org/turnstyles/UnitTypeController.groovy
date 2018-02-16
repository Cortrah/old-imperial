package org.turnstyles

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class UnitTypeController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond UnitType.list(params), model:[unitTypeCount: UnitType.count()]
    }

    def show(UnitType unitType) {
        respond unitType
    }

    def create() {
        respond new UnitType(params)
    }

    @Transactional
    def save(UnitType unitType) {
        if (unitType == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (unitType.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond unitType.errors, view:'create'
            return
        }

        unitType.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'unitType.label', default: 'UnitType'), unitType.id])
                redirect unitType
            }
            '*' { respond unitType, [status: CREATED] }
        }
    }

    def edit(UnitType unitType) {
        respond unitType
    }

    @Transactional
    def update(UnitType unitType) {
        if (unitType == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (unitType.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond unitType.errors, view:'edit'
            return
        }

        unitType.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'unitType.label', default: 'UnitType'), unitType.id])
                redirect unitType
            }
            '*'{ respond unitType, [status: OK] }
        }
    }

    @Transactional
    def delete(UnitType unitType) {

        if (unitType == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        unitType.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'unitType.label', default: 'UnitType'), unitType.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'unitType.label', default: 'UnitType'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
