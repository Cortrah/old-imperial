package org.turnstyles

import org.turnstyles.Location
import org.turnstyles.MajorMap
import org.turnstyles.Region
import org.turnstyles.Kindred
import org.turnstyles.TrainingType
import org.turnstyles.AgentType

class Leader {

    String name = "Unknown"
    String Label = "Unknown"
    String code = "?"

    MajorMap atMajorMap
    Region atRegion
    Location atLocation

    Integer carryingAp = 0
    Integer carryingGp = 0
    String notes = "notes"

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

    static hasMany = [items :Item, unitTypeGroups :UnitTypeGroup]

    String toString() {"$name"}

    static graphql = true
    static constraints = {
        name blank: false
        code blank: false
        label blank: false
        notes blank: true

        carryingAp()
        carryingGp()

        atMajorMap nullable: true
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
    def seedContext (servletContext) {
        servletContext.pirateJenny = new Leader(name: "Pirate Jenny", code: "PJ", label:"Jenny").save()
    }
}
