package org.turnstyles

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class SpellsReligionController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond SpellsReligion.list(params), model:[spellsReligionCount: SpellsReligion.count()]
    }

    def show(SpellsReligion spellsReligion) {
        respond spellsReligion
    }

    def create() {
        respond new SpellsReligion(params)
    }

    @Transactional
    def save(SpellsReligion spellsReligion) {
        if (spellsReligion == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (spellsReligion.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond spellsReligion.errors, view:'create'
            return
        }

        spellsReligion.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'spellsReligion.label', default: 'SpellsReligion'), spellsReligion.id])
                redirect spellsReligion
            }
            '*' { respond spellsReligion, [status: CREATED] }
        }
    }

    def edit(SpellsReligion spellsReligion) {
        respond spellsReligion
    }

    @Transactional
    def update(SpellsReligion spellsReligion) {
        if (spellsReligion == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (spellsReligion.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond spellsReligion.errors, view:'edit'
            return
        }

        spellsReligion.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'spellsReligion.label', default: 'SpellsReligion'), spellsReligion.id])
                redirect spellsReligion
            }
            '*'{ respond spellsReligion, [status: OK] }
        }
    }

    @Transactional
    def delete(SpellsReligion spellsReligion) {

        if (spellsReligion == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        spellsReligion.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'spellsReligion.label', default: 'SpellsReligion'), spellsReligion.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'spellsReligion.label', default: 'SpellsReligion'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
