package org.turnstyles

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class ReligionController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Religion.list(params), model:[religionCount: Religion.count()]
    }

    def show(Religion religion) {
        respond religion
    }

    def create() {
        respond new Religion(params)
    }

    @Transactional
    def save(Religion religion) {
        if (religion == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (religion.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond religion.errors, view:'create'
            return
        }

        religion.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'religion.label', default: 'Religion'), religion.id])
                redirect religion
            }
            '*' { respond religion, [status: CREATED] }
        }
    }

    def edit(Religion religion) {
        respond religion
    }

    @Transactional
    def update(Religion religion) {
        if (religion == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (religion.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond religion.errors, view:'edit'
            return
        }

        religion.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'religion.label', default: 'Religion'), religion.id])
                redirect religion
            }
            '*'{ respond religion, [status: OK] }
        }
    }

    @Transactional
    def delete(Religion religion) {

        if (religion == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        religion.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'religion.label', default: 'Religion'), religion.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'religion.label', default: 'Religion'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
