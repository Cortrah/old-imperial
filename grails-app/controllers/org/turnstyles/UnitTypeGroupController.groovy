package org.turnstyles

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class UnitTypeGroupController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond UnitTypeGroup.list(params), model:[unitTypeGroupCount: UnitTypeGroup.count()]
    }

    def show(UnitTypeGroup unitTypeGroup) {
        respond unitTypeGroup
    }

    def create() {
        respond new UnitTypeGroup(params)
    }

    @Transactional
    def save(UnitTypeGroup unitTypeGroup) {
        if (unitTypeGroup == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (unitTypeGroup.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond unitTypeGroup.errors, view:'create'
            return
        }

        unitTypeGroup.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'unitTypeGroup.label', default: 'UnitTypeGroup'), unitTypeGroup.id])
                redirect unitTypeGroup
            }
            '*' { respond unitTypeGroup, [status: CREATED] }
        }
    }

    def edit(UnitTypeGroup unitTypeGroup) {
        respond unitTypeGroup
    }

    @Transactional
    def update(UnitTypeGroup unitTypeGroup) {
        if (unitTypeGroup == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (unitTypeGroup.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond unitTypeGroup.errors, view:'edit'
            return
        }

        unitTypeGroup.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'unitTypeGroup.label', default: 'UnitTypeGroup'), unitTypeGroup.id])
                redirect unitTypeGroup
            }
            '*'{ respond unitTypeGroup, [status: OK] }
        }
    }

    @Transactional
    def delete(UnitTypeGroup unitTypeGroup) {

        if (unitTypeGroup == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        unitTypeGroup.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'unitTypeGroup.label', default: 'UnitTypeGroup'), unitTypeGroup.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'unitTypeGroup.label', default: 'UnitTypeGroup'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
