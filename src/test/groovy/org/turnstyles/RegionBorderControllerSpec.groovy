package org.turnstyles


import spock.lang.*

@TestFor(RegionBordersController)
@Mock(RegionBorder)
class RegionBorderControllerSpec extends Specification {

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
            !model.regionBordersList
            model.regionBordersCount == 0
    }

    void "Test the create action returns the correct model"() {
        when:"The create action is executed"
            controller.create()

        then:"The model is correctly created"
            model.regionBorders!= null
    }

    void "Test the save action correctly persists an instance"() {

        when:"The save action is executed with an invalid instance"
            request.contentType = FORM_CONTENT_TYPE
            request.method = 'POST'
            def regionBorders = new RegionBorder()
            regionBorders.validate()
            controller.save(regionBorders)

        then:"The create view is rendered again with the correct model"
            model.regionBorders!= null
            view == 'create'

        when:"The save action is executed with a valid instance"
            response.reset()
            populateValidParams(params)
            regionBorders = new RegionBorder(params)

            controller.save(regionBorders)

        then:"A redirect is issued to the show action"
            response.redirectedUrl == '/regionBorders/show/1'
            controller.flash.message != null
            RegionBorder.count() == 1
    }

    void "Test that the show action returns the correct model"() {
        when:"The show action is executed with a null domain"
            controller.show(null)

        then:"A 404 error is returned"
            response.status == 404

        when:"A domain instance is passed to the show action"
            populateValidParams(params)
            def regionBorders = new RegionBorder(params)
            controller.show(regionBorders)

        then:"A model is populated containing the domain instance"
            model.regionBorders == regionBorders
    }

    void "Test that the edit action returns the correct model"() {
        when:"The edit action is executed with a null domain"
            controller.edit(null)

        then:"A 404 error is returned"
            response.status == 404

        when:"A domain instance is passed to the edit action"
            populateValidParams(params)
            def regionBorders = new RegionBorder(params)
            controller.edit(regionBorders)

        then:"A model is populated containing the domain instance"
            model.regionBorders == regionBorders
    }

    void "Test the update action performs an update on a valid domain instance"() {
        when:"Update is called for a domain instance that doesn't exist"
            request.contentType = FORM_CONTENT_TYPE
            request.method = 'PUT'
            controller.update(null)

        then:"A 404 error is returned"
            response.redirectedUrl == '/regionBorders/index'
            flash.message != null

        when:"An invalid domain instance is passed to the update action"
            response.reset()
            def regionBorders = new RegionBorder()
            regionBorders.validate()
            controller.update(regionBorders)

        then:"The edit view is rendered again with the invalid instance"
            view == 'edit'
            model.regionBorders == regionBorders

        when:"A valid domain instance is passed to the update action"
            response.reset()
            populateValidParams(params)
            regionBorders = new RegionBorder(params).save(flush: true)
            controller.update(regionBorders)

        then:"A redirect is issued to the show action"
            regionBorders != null
            response.redirectedUrl == "/regionBorders/show/$regionBorders.id"
            flash.message != null
    }

    void "Test that the delete action deletes an instance if it exists"() {
        when:"The delete action is called for a null instance"
            request.contentType = FORM_CONTENT_TYPE
            request.method = 'DELETE'
            controller.delete(null)

        then:"A 404 is returned"
            response.redirectedUrl == '/regionBorders/index'
            flash.message != null

        when:"A domain instance is created"
            response.reset()
            populateValidParams(params)
            def regionBorders = new RegionBorder(params).save(flush: true)

        then:"It exists"
            RegionBorder.count() == 1

        when:"The domain instance is passed to the delete action"
            controller.delete(regionBorders)

        then:"The instance is deleted"
            RegionBorder.count() == 0
            response.redirectedUrl == '/regionBorders/index'
            flash.message != null
    }
}
