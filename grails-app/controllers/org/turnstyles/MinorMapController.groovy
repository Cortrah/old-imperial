package org.turnstyles

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class MinorMapController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond MinorMap.list(params), model:[minorMapCount: MinorMap.count()]
    }

    def show(MinorMap minorMap) {
        respond minorMap
    }

    def create() {
        respond new MinorMap(params)
    }

    @Transactional
    def save(MinorMap minorMap) {
        if (minorMap == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (minorMap.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond minorMap.errors, view:'create'
            return
        }

        minorMap.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'minorMap.label', default: 'MinorMap'), minorMap.id])
                redirect minorMap
            }
            '*' { respond minorMap, [status: CREATED] }
        }
    }

    def edit(MinorMap minorMap) {
        respond minorMap
    }

    @Transactional
    def update(MinorMap minorMap) {
        if (minorMap == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (minorMap.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond minorMap.errors, view:'edit'
            return
        }

        minorMap.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'minorMap.label', default: 'MinorMap'), minorMap.id])
                redirect minorMap
            }
            '*'{ respond minorMap, [status: OK] }
        }
    }

    @Transactional
    def delete(MinorMap minorMap) {

        if (minorMap == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        minorMap.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'minorMap.label', default: 'MinorMap'), minorMap.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'minorMap.label', default: 'MinorMap'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
