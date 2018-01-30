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
    // default results
    // final results

    MovementType movementType

    // String monitorLevel = "Normal"

    static graphql = true
    static constraints = {
        name blank: false
        code blank: false
        description nullable: true
    }
}
