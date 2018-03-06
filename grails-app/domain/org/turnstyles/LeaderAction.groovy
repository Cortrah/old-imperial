package org.turnstyles

class LeaderAction {

    String name = "Custom"
    String code = "!"
    String description = "A Custom Action"
    String toString() {"$name"}

    Integer gpCost = 0
    Integer apCost = 0
    Integer nfpCost = 0
    Integer sfpCost = 0
    Integer manaCost = 0
    Integer totalManaCost = 0

    // in case it's a special action, creating a spell crystal requires a blank, etc
    static hasMany = [costs :Cost, effects: Effect]

    // how to deal with movement costs of a turn or more? just 25, 50, etc?
    Integer movementCost = 0

    LeaderActionType leaderActionType

    MajorMap majorMap
    Region region
    Location atLocation
    Location toLocation
    Location otherLocation

    Boolean usingRoad = false
    Integer startingPhase  = 0

    Boolean isSecret = false
    Boolean isWithOthers = false
    Boolean isPrimaryTarget = true

    UnitType unitType
    Integer unitCount

    Item item
    ItemType itemType

    String defaultResults = ""
    String finalResults = ""

    MovementType movementType

    String monitorLevel = "Ok"

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

        majorMap nullable: false
        region nullable: false
        atLocation nullable: false
        toLocation nullable: true
        otherLocation nullable: true

        usingRoad nullable: false
        startingPhase nullable: false

        isSecret nullable: false
        isWithOthers nullable: false
        isPrimaryTarget nullable: true

        movementType nullable: true
        monitorLevel inList: ["Ok", "Probably Fine", "Check", "Probable Error"]

        defaultResults blank: true
        finalResults blank: true
    }
    def seedContext (servletContext) {
        // servletContext.move = new LeaderActionType(name: "Movement", code: "Mv", description: "").save();
        //

        // servletContext.combat = new LeaderActionType(name: "Combat", code: "Cbt", description: "").save();
        // Protect, Duel, Plunder, Slave Raid, Atttack, Assault Fortification, Attack to secure Tribute,
        // Beseige Fortification, Blockade, Genocide, Respond, Sack, Defend, Evade, Loot, Convert, Pillage

        // servletContext.intel = new LeaderActionType(name: "Inteligence", code: "Int", description: "").save();
        // Infiltrate, Receive Intel, Assasination, CounterIntel, Incite Rebelion, Kidnap Leader, Scout
        // Search and Excavate, Steal Magic, Subvert Leader

        // servletContext.diplo = new LeaderActionType(name: "Diplomacy", code: "Di", description: "").save();
        // Rule, Secret Diplomacy, Diplomacy

        // servletContext.exchange = new LeaderActionType(name: "Transfer", code: "Tr", description: "").save();
        // Split, Combine, Transfer To, Transfer From,

        // servletContext.magic = new LeaderActionType(name: "Magic", code: "Ma", description: "").save();
        // Cast Spell, Research Spell

        // servletContext.conditional = new LeaderActionType(name: "Conditional", code: "???", description: "").save();

        // servletContext.custom = new LeaderActionType(name: "Custom", code: "XX", description: "").save();

    }
}
