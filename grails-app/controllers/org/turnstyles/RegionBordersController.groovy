package org.turnstyles

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class RegionBordersController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond RegionBorders.list(params), model:[regionBordersCount: RegionBorders.count()]
    }

    def show(RegionBorders regionBorders) {
        respond regionBorders
    }

    def create() {
        respond new RegionBorders(params)
    }

    @Transactional
    def save(RegionBorders regionBorders) {
        if (regionBorders == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (regionBorders.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond regionBorders.errors, view:'create'
            return
        }

        regionBorders.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'regionBorders.label', default: 'RegionBorders'), regionBorders.id])
                redirect regionBorders
            }
            '*' { respond regionBorders, [status: CREATED] }
        }
    }

    def edit(RegionBorders regionBorders) {
        respond regionBorders
    }

    @Transactional
    def update(RegionBorders regionBorders) {
        if (regionBorders == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (regionBorders.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond regionBorders.errors, view:'edit'
            return
        }

        regionBorders.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'regionBorders.label', default: 'RegionBorders'), regionBorders.id])
                redirect regionBorders
            }
            '*'{ respond regionBorders, [status: OK] }
        }
    }

    @Transactional
    def delete(RegionBorders regionBorders) {

        if (regionBorders == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        regionBorders.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'regionBorders.label', default: 'RegionBorders'), regionBorders.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'regionBorders.label', default: 'RegionBorders'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
