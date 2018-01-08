package org.turnstyles

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class RegionTurnStatusController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond RegionTurnStatus.list(params), model:[regionTurnStatusCount: RegionTurnStatus.count()]
    }

    def show(RegionTurnStatus regionTurnStatus) {
        respond regionTurnStatus
    }

    def create() {
        respond new RegionTurnStatus(params)
    }

    @Transactional
    def save(RegionTurnStatus regionTurnStatus) {
        if (regionTurnStatus == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (regionTurnStatus.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond regionTurnStatus.errors, view:'create'
            return
        }

        regionTurnStatus.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'regionTurnStatus.label', default: 'RegionTurnStatus'), regionTurnStatus.id])
                redirect regionTurnStatus
            }
            '*' { respond regionTurnStatus, [status: CREATED] }
        }
    }

    def edit(RegionTurnStatus regionTurnStatus) {
        respond regionTurnStatus
    }

    @Transactional
    def update(RegionTurnStatus regionTurnStatus) {
        if (regionTurnStatus == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (regionTurnStatus.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond regionTurnStatus.errors, view:'edit'
            return
        }

        regionTurnStatus.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'regionTurnStatus.label', default: 'RegionTurnStatus'), regionTurnStatus.id])
                redirect regionTurnStatus
            }
            '*'{ respond regionTurnStatus, [status: OK] }
        }
    }

    @Transactional
    def delete(RegionTurnStatus regionTurnStatus) {

        if (regionTurnStatus == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        regionTurnStatus.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'regionTurnStatus.label', default: 'RegionTurnStatus'), regionTurnStatus.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'regionTurnStatus.label', default: 'RegionTurnStatus'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
