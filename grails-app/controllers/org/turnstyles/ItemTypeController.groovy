package org.turnstyles

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class ItemTypeController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond ItemType.list(params), model:[itemTypeCount: ItemType.count()]
    }

    def show(ItemType itemType) {
        respond itemType
    }

    def create() {
        respond new ItemType(params)
    }

    @Transactional
    def save(ItemType itemType) {
        if (itemType == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (itemType.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond itemType.errors, view:'create'
            return
        }

        itemType.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'itemType.label', default: 'ItemType'), itemType.id])
                redirect itemType
            }
            '*' { respond itemType, [status: CREATED] }
        }
    }

    def edit(ItemType itemType) {
        respond itemType
    }

    @Transactional
    def update(ItemType itemType) {
        if (itemType == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (itemType.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond itemType.errors, view:'edit'
            return
        }

        itemType.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'itemType.label', default: 'ItemType'), itemType.id])
                redirect itemType
            }
            '*'{ respond itemType, [status: OK] }
        }
    }

    @Transactional
    def delete(ItemType itemType) {

        if (itemType == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        itemType.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'itemType.label', default: 'ItemType'), itemType.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'itemType.label', default: 'ItemType'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
