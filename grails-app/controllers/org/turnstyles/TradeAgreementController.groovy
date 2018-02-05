package org.turnstyles

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class TradeAgreementController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond TradeAgreement.list(params), model:[tradeAgreementCount: TradeAgreement.count()]
    }

    def show(TradeAgreement tradeAgreement) {
        respond tradeAgreement
    }

    def create() {
        respond new TradeAgreement(params)
    }

    @Transactional
    def save(TradeAgreement tradeAgreement) {
        if (tradeAgreement == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (tradeAgreement.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond tradeAgreement.errors, view:'create'
            return
        }

        tradeAgreement.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'tradeAgreement.label', default: 'TradeAgreement'), tradeAgreement.id])
                redirect tradeAgreement
            }
            '*' { respond tradeAgreement, [status: CREATED] }
        }
    }

    def edit(TradeAgreement tradeAgreement) {
        respond tradeAgreement
    }

    @Transactional
    def update(TradeAgreement tradeAgreement) {
        if (tradeAgreement == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (tradeAgreement.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond tradeAgreement.errors, view:'edit'
            return
        }

        tradeAgreement.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'tradeAgreement.label', default: 'TradeAgreement'), tradeAgreement.id])
                redirect tradeAgreement
            }
            '*'{ respond tradeAgreement, [status: OK] }
        }
    }

    @Transactional
    def delete(TradeAgreement tradeAgreement) {

        if (tradeAgreement == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        tradeAgreement.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'tradeAgreement.label', default: 'TradeAgreement'), tradeAgreement.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'tradeAgreement.label', default: 'TradeAgreement'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
