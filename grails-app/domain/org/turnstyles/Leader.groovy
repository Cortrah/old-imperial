package org.turnstyles

import org.turnstyles.Location
import org.turnstyles.MajorMap
import org.turnstyles.Region
import org.turnstyles.Kindred
import org.turnstyles.TrainingType
import org.turnstyles.AgentType

class Leader {

    String name = "Unknown"
    String code = "?"
    String label = "Unknown"
    String notes = "notes"

    MajorMap atMajorMap
    Region atRegion
    Location atLocation

    // ToDo: possibly make this more abstract cargo to deal with items as well
    Integer carryingAp = 0
    Integer carryingGp = 0

    String icon = "leader.svg"
    String avatar = "cortrah.png"
    Integer x = 0
    Integer y = 0

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

    // note that that realm may be unknown or free wheelers or something like that, which is controlled by Dei
    // in the majority case, we want this association
    static belongsTo = [realm: Realm]
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
        avatar nullable: true
        x nullable: true
        y nullable: true

        command nullable: false
        loyalty nullable: false
        combat nullable: false
        diplomacy nullable: false
        sorcery nullable: false
        age nullable: false
        sex nullable: false

        agentType nullable: true
        realm nullable: true
        homeRegion nullable: true
        kindred nullable: true
        training nullable: true
    }
    def seedContext (servletContext) {
        servletContext.pirateJenny = new Leader(name: "Pirate Jenny", code: "PJ", label:"Jenny").save()
    }
}
