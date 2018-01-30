package org.turnstyles

import org.grails.datastore.mapping.query.Query

class LeaderAction {

    String name = "Name"
    String code = "Code"
    String description = ""
    String toString() {"$name"}

    Integer gpCost = 0
    Integer apCost = 0
    Integer nfpCost = 0
    Integer sfpCost = 0
    Integer manaCost = 0
    Integer totalManaCost = 0
    Integer movementCost = 0

    LeaderActionType leaderActionType

    Region region
    Location atLocation
    Location toLocation
    Location otherLocation

    Boolean usingRoad = false
    Integer startingPhase  = 0

    Boolean isSecret = false
    Boolean isWithOthers = false
    Boolean isPrimaryTarget = true

    // unitType
    // unitCount
    // item
    // ItemType
    // effect

    String defaultResults = ""
    String finalResults = ""

    MovementType movementType

    String monitorLevel = "Normal"

    static graphql = true
    static constraints = {
        name blank: false
        code blank: false
        description nullable: true

        gpCost nullable: false
        apCost nullable: false
        nfpCost nullable: false
        sfpCost nullable: false
        manaCost nullable: false
        totalManaCost nullable: false
        movementCost nullable: false

        leaderActionType nullable: false

        region nullable: true
        atLocation nullable: true
        toLocation nullable: true
        otherLocation nullable: true

        usingRoad nullable: false
        startingPhase nullable: false

        isSecret nullable: false
        isWithOthers nullable: false
        isPrimaryTarget nullable: true

        movementType nullable: true
        monitorLevel inList: ["Fine", "Check", "Wierd", "Error"]

        defaultResults blank: true
        finalResults blank: true
    }
}
