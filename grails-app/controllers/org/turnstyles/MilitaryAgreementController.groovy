package org.turnstyles

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class MilitaryAgreementController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond MilitaryAgreement.list(params), model:[militaryAgreementCount: MilitaryAgreement.count()]
    }

    def show(MilitaryAgreement militaryAgreement) {
        respond militaryAgreement
    }

    def create() {
        respond new MilitaryAgreement(params)
    }

    @Transactional
    def save(MilitaryAgreement militaryAgreement) {
        if (militaryAgreement == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (militaryAgreement.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond militaryAgreement.errors, view:'create'
            return
        }

        militaryAgreement.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'militaryAgreement.label', default: 'MilitaryAgreement'), militaryAgreement.id])
                redirect militaryAgreement
            }
            '*' { respond militaryAgreement, [status: CREATED] }
        }
    }

    def edit(MilitaryAgreement militaryAgreement) {
        respond militaryAgreement
    }

    @Transactional
    def update(MilitaryAgreement militaryAgreement) {
        if (militaryAgreement == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (militaryAgreement.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond militaryAgreement.errors, view:'edit'
            return
        }

        militaryAgreement.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'militaryAgreement.label', default: 'MilitaryAgreement'), militaryAgreement.id])
                redirect militaryAgreement
            }
            '*'{ respond militaryAgreement, [status: OK] }
        }
    }

    @Transactional
    def delete(MilitaryAgreement militaryAgreement) {

        if (militaryAgreement == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        militaryAgreement.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'militaryAgreement.label', default: 'MilitaryAgreement'), militaryAgreement.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'militaryAgreement.label', default: 'MilitaryAgreement'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
