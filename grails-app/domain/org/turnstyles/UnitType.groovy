package org.turnstyles

// ToDo: import data

class UnitType {

    String name = "Name"
    String code = "Code"
    String description = ""

    Integer manaToActivate = 0
    Integer manaToUse = 0

    // ToDo: each movementRule should have a movementType, a speed, a reactionSpeed, a cargoCost and cargoCapacity
    static hasMany = [movementRules :MovementRule, costs :Cost, buildLocationTypes :BuildLocationType]

    QualityRatingType qualityRatingType
    Integer qualityRatingAdjustment = 0
    Integer minimumQRtoBuild = 0
    Integer minimumNSRtoBuild = 0

    Boolean isAllied = false
    Boolean isSecret = false

    String toString() {"$name"}

    static graphql = true
    static constraints = {
        name blank: false
        code blank: false
        description nullable: true

        manaToActivate()
        manaToUse()

        qualityRatingType()
        qualityRatingAdjustment()
        minimumQRtoBuild()
        minimumNSRtoBuild()

        isAllied()
        isSecret()
    }

    def seedContext (servletContext) {
        //servletContext.r =
    }
}

