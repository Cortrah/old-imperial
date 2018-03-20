package org.turnstyles

class BorderType {
    String name = "Unknown"
    String code = "?"
    String description = "A Mystery"

    Integer landCost = null
    Integer airCost = null
    Integer navalCost = null
    Integer manaCost = null

    boolean isDirectional = false

    String toString() {"$name"}

    static graphql = true
    static constraints = {
        name blank: false
        code blank: false
        description nullable: true

        landCost nullable: true
        airCost nullable: true
        navalCost nullable: true
        manaCost nullable: true

        isDirectional()
    }

    def seedContext (servletContext) {
        servletContext.adjBorder = new BorderType(
                name: "Adjacent", code: ":", description: "A default border, easy to cross at slight penalty via land or sea.",
                landCost: 1, airCost: 0, navalCost:1, manaCost:null).save()
        servletContext.roadBorder = new BorderType(
                name: "Road", code: "_", description: "A Road, makes crossing easier still.",
                landCost: 0, airCost: 0, navalCost:null, manaCost:null).save()
        servletContext.riverBorder = new BorderType(
                name: "River", code: "~", description: "Crossing a river from land to land slows land units but not air or naval units which can also go from one section of a river to another via a river border.",
                landCost: 2, airCost: 0, navalCost:0, manaCost:null).save()
        servletContext.canalBorder = new BorderType(
                name: "Canal", code: "-~-", description: "Crossing a canal from land to land slows down land units but not air or naval units which can also go from onen section of a canal to another at no cost.",
                landCost: 2, airCost: 0, navalCost:0, manaCost:null).save()
        servletContext.bridgeBorder = new BorderType(
                name: "Bridge", code: "=", description: "Like a road for crossing a river from land to land, which is why naval units don't go this way.",
                landCost: 0, airCost: 0, navalCost:null, manaCost:null).save()
        servletContext.minMtnBorder = new BorderType(
                name: "Minor Mountain", code: ".m.", description: "Minor mountains, hamper land units, not air units, naval units are blocked.",
                landCost: 2, airCost: 0, navalCost:null, manaCost:null).save()
        servletContext.majMtnBorder = new BorderType(
                name: "Major Mountain", code: ".M.", description: "Major mountains, hamper land units, not air units, naval units are blocked.",
                landCost: 3, airCost: 1, navalCost:null, manaCost:null).save()
        servletContext.minMtnPassBorder = new BorderType(
                name: "Minor Mountain Pass", code: "_m_", description: "Greatly reduce the cost for land units.",
                landCost: 1, airCost: 0, navalCost:null, manaCost:null).save()
        servletContext.majMtnPassBorder = new BorderType(
                name: "Major Mountain Pass", code: "_M_", description: "Greatly reduce the cost for land units.",
                landCost: 1, airCost: 0, navalCost:null, manaCost:null).save()
        servletContext.greatWallBorder = new BorderType(
                name: "Great Wall", code: "|", description: "Land and naval units are blocked but air units are not.",
                landCost: null, airCost: 0, navalCost:null, manaCost:null).save()
        servletContext.tunnelBorder = new BorderType(
                name: "Tunnel", code: "-_-", description: "Air and Naval units can not travel underground.",
                landCost: 1, airCost: null, navalCost:null, manaCost:null).save()
        servletContext.blockedTunnelBorder = new BorderType(
                name: "Blocked Tunnel", code: "-x-", description: "Not much movement here, needs to be dug through and unblocked.",
                landCost: null, airCost: null, navalCost:null, manaCost:null).save()
        servletContext.gateBorder = new BorderType(
                name: "Gate", code: "@", description: "After a gate is triggered, it costs 1 mana per unit to go through.",
                landCost: null, airCost: null, navalCost:null, manaCost:1).save()
        servletContext.teleportationBorder = new BorderType(
                name: "Teleportation", code: "*", description: "A unit can be teleported with 5 mana per unit.",
                landCost: null, airCost: null, navalCost:null, manaCost:5).save()
        servletContext.stairsBorder = new BorderType(
                name: "Stairs", code: "_-", description: "Movement ends when traversing underground or coming back to the surface.",
                landCost: 25, airCost: null, navalCost:null, manaCost:null).save()
        servletContext.cliffsBorder = new BorderType(
                name: "Cliffs", code: "||", description: "Cliffs slow down air travel and stop land or naval travel.",
                landCost: null, airCost: 1, navalCost:null, manaCost:null).save()
        servletContext.currentBorder = new BorderType(
                name: "Current", code: "~/", description: "A current is directional, it is free going downstream from source to sink, but costs 1 going upstream from sink to source.",
                landCost: null, airCost: 0, navalCost:0, manaCost:null).save()
        servletContext.monsoonCurrentBorder = new BorderType(
                name: "Monsoon Current", code: "~%", description: "A monsoons turbulent air slows both air and naval vessels.",
                landCost: null, airCost: 2, navalCost:2, manaCost:null).save()

    }
}