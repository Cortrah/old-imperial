package org.turnstyles

import org.grails.datastore.mapping.query.Query

class Leader {

    String name = "Name"
    String code = "Code"

    Integer carryingAp = 0
    Integer carryingGp = 0
    Region atRegion
    Location atLocation
    String notes = ""

    String icon = "leader.svg"
    Integer displayX = 0
    Integer displayY = 0

    Integer command = 5
    Integer loyalty = 5
    Integer combat = 5
    Integer diplomacy = 5
    Integer sorcery = 5
    Integer age = 18
    String sex = "M"

    AgentType agentType
    Realm realm
    Region homeRegion
    Kindred kindred
    TrainingType training

    String toString() {"$name"}

    static graphql = true
    static constraints = {
        name blank: false
        code blank: false
        notes blank: true

        carryingAp()
        carryingGp()
        atRegion nullable: true
        atLocation nullable: true

        icon nullable: true
        displayX nullable: true
        displayY nullable: true

        command nullable: false
        loyalty nullable: false
        combat nullable: false
        diplomacy nullable: false
        sorcery nullable: false
        age nullable: false
        sex nullable: false

        agentType nullable: false
        realm nullable: true
        homeRegion nullable: true
        kindred nullable: false
        training nullable: true
    }
}
