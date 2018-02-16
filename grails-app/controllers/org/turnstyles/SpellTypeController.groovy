package org.turnstyles

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class SpellTypeController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond SpellType.list(params), model:[spellTypeCount: SpellType.count()]
    }

    def show(SpellType spellType) {
        respond spellType
    }

    def create() {
        respond new SpellType(params)
    }

    @Transactional
    def save(SpellType spellType) {
        if (spellType == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (spellType.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond spellType.errors, view:'create'
            return
        }

        spellType.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'spellType.label', default: 'SpellType'), spellType.id])
                redirect spellType
            }
            '*' { respond spellType, [status: CREATED] }
        }
    }

    def edit(SpellType spellType) {
        respond spellType
    }

    @Transactional
    def update(SpellType spellType) {
        if (spellType == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (spellType.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond spellType.errors, view:'edit'
            return
        }

        spellType.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'spellType.label', default: 'SpellType'), spellType.id])
                redirect spellType
            }
            '*'{ respond spellType, [status: OK] }
        }
    }

    @Transactional
    def delete(SpellType spellType) {

        if (spellType == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        spellType.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'spellType.label', default: 'SpellType'), spellType.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'spellType.label', default: 'SpellType'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
