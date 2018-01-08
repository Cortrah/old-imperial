package org.turnstyles

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class TerrainTypeController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond TerrainType.list(params), model:[terrainTypeCount: TerrainType.count()]
    }

    def show(TerrainType terrainType) {
        respond terrainType
    }

    def create() {
        respond new TerrainType(params)
    }

    @Transactional
    def save(TerrainType terrainType) {
        if (terrainType == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (terrainType.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond terrainType.errors, view:'create'
            return
        }

        terrainType.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'terrainType.label', default: 'TerrainType'), terrainType.id])
                redirect terrainType
            }
            '*' { respond terrainType, [status: CREATED] }
        }
    }

    def edit(TerrainType terrainType) {
        respond terrainType
    }

    @Transactional
    def update(TerrainType terrainType) {
        if (terrainType == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (terrainType.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond terrainType.errors, view:'edit'
            return
        }

        terrainType.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'terrainType.label', default: 'TerrainType'), terrainType.id])
                redirect terrainType
            }
            '*'{ respond terrainType, [status: OK] }
        }
    }

    @Transactional
    def delete(TerrainType terrainType) {

        if (terrainType == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        terrainType.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'terrainType.label', default: 'TerrainType'), terrainType.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'terrainType.label', default: 'TerrainType'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
