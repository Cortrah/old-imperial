package org.turnstyles

import grails.test.mixin.*
import spock.lang.*

@TestFor(TerrainTypeController)
@Mock(TerrainType)
class TerrainTypeControllerSpec extends Specification {

    def populateValidParams(params) {
        assert params != null

        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
        assert false, "TODO: Provide a populateValidParams() implementation for this generated test suite"
    }

    void "Test the index action returns the correct model"() {

        when:"The index action is executed"
            controller.index()

        then:"The model is correct"
            !model.terrainTypeList
            model.terrainTypeCount == 0
    }

    void "Test the create action returns the correct model"() {
        when:"The create action is executed"
            controller.create()

        then:"The model is correctly created"
            model.terrainType!= null
    }

    void "Test the save action correctly persists an instance"() {

        when:"The save action is executed with an invalid instance"
            request.contentType = FORM_CONTENT_TYPE
            request.method = 'POST'
            def terrainType = new TerrainType()
            terrainType.validate()
            controller.save(terrainType)

        then:"The create view is rendered again with the correct model"
            model.terrainType!= null
            view == 'create'

        when:"The save action is executed with a valid instance"
            response.reset()
            populateValidParams(params)
            terrainType = new TerrainType(params)

            controller.save(terrainType)

        then:"A redirect is issued to the show action"
            response.redirectedUrl == '/terrainType/show/1'
            controller.flash.message != null
            TerrainType.count() == 1
    }

    void "Test that the show action returns the correct model"() {
        when:"The show action is executed with a null domain"
            controller.show(null)

        then:"A 404 error is returned"
            response.status == 404

        when:"A domain instance is passed to the show action"
            populateValidParams(params)
            def terrainType = new TerrainType(params)
            controller.show(terrainType)

        then:"A model is populated containing the domain instance"
            model.terrainType == terrainType
    }

    void "Test that the edit action returns the correct model"() {
        when:"The edit action is executed with a null domain"
            controller.edit(null)

        then:"A 404 error is returned"
            response.status == 404

        when:"A domain instance is passed to the edit action"
            populateValidParams(params)
            def terrainType = new TerrainType(params)
            controller.edit(terrainType)

        then:"A model is populated containing the domain instance"
            model.terrainType == terrainType
    }

    void "Test the update action performs an update on a valid domain instance"() {
        when:"Update is called for a domain instance that doesn't exist"
            request.contentType = FORM_CONTENT_TYPE
            request.method = 'PUT'
            controller.update(null)

        then:"A 404 error is returned"
            response.redirectedUrl == '/terrainType/index'
            flash.message != null

        when:"An invalid domain instance is passed to the update action"
            response.reset()
            def terrainType = new TerrainType()
            terrainType.validate()
            controller.update(terrainType)

        then:"The edit view is rendered again with the invalid instance"
            view == 'edit'
            model.terrainType == terrainType

        when:"A valid domain instance is passed to the update action"
            response.reset()
            populateValidParams(params)
            terrainType = new TerrainType(params).save(flush: true)
            controller.update(terrainType)

        then:"A redirect is issued to the show action"
            terrainType != null
            response.redirectedUrl == "/terrainType/show/$terrainType.id"
            flash.message != null
    }

    void "Test that the delete action deletes an instance if it exists"() {
        when:"The delete action is called for a null instance"
            request.contentType = FORM_CONTENT_TYPE
            request.method = 'DELETE'
            controller.delete(null)

        then:"A 404 is returned"
            response.redirectedUrl == '/terrainType/index'
            flash.message != null

        when:"A domain instance is created"
            response.reset()
            populateValidParams(params)
            def terrainType = new TerrainType(params).save(flush: true)

        then:"It exists"
            TerrainType.count() == 1

        when:"The domain instance is passed to the delete action"
            controller.delete(terrainType)

        then:"The instance is deleted"
            TerrainType.count() == 0
            response.redirectedUrl == '/terrainType/index'
            flash.message != null
    }
}
