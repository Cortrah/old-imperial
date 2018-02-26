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
                name: "Adjacent", code: ":", description: "a default land border, easy to cross at no penalty",
                landCost: 0, airCost: 0, navalCost:0, manaCost:0).save()
        servletContext.roadBorder = new BorderType(
                name: "Road", code: "_", description: "A Road",
                landCost: 0, airCost: 0, navalCost:0, manaCost:0).save()
        servletContext.riverBorder = new BorderType(
                name: "River", code: "~", description: "",
                landCost: 0, airCost: 0, navalCost:0, manaCost:0).save()
        servletContext.canalBorder = new BorderType(
                name: "Canal", code: "-~-", description: "",
                landCost: 0, airCost: 0, navalCost:0, manaCost:0).save()
        servletContext.bridgeBorder = new BorderType(
                name: "Bridge", code: "=", description: "",
                landCost: 0, airCost: 0, navalCost:0, manaCost:0).save()
        servletContext.minMtnBorder = new BorderType(
                name: "Minor Mountain", code: "-m-", description: "",
                landCost: 0, airCost: 0, navalCost:0, manaCost:0).save()
        servletContext.majMtnBorder = new BorderType(
                name: "Major Mountain", code: "-M-", description: "",
                landCost: 0, airCost: 0, navalCost:0, manaCost:0).save()
        servletContext.minMtnPassBorder = new BorderType(
                name: "Minor Mountain Pass", code: "_m_", description: "",
                landCost: 0, airCost: 0, navalCost:0, manaCost:0).save()
        servletContext.majMtnPassBorder = new BorderType(
                name: "Major Mountain Pass", code: "_M_", description: "",
                landCost: 0, airCost: 0, navalCost:0, manaCost:0).save()
        servletContext.greatWallBorder = new BorderType(
                name: "Great Wall", code: "|", description: "",
                landCost: 0, airCost: 0, navalCost:0, manaCost:0).save()
        servletContext.tunnelBorder = new BorderType(
                name: "Tunnel", code: "-_-", description: "",
                landCost: 0, airCost: 0, navalCost:0, manaCost:0).save()
        servletContext.blockedTunnelBorder = new BorderType(
                name: "Blocked Tunnel", code: "-x-", description: "",
                landCost: 0, airCost: 0, navalCost:0, manaCost:0).save()
        servletContext.gateBorder = new BorderType(
                name: "Gate", code: "@", description: "",
                landCost: 0, airCost: 0, navalCost:0, manaCost:0).save()
        servletContext.teleportationBorder = new BorderType(
                name: "Teleportation", code: "*", description: "",
                landCost: 0, airCost: 0, navalCost:0, manaCost:0).save()
        servletContext.stairsBorder = new BorderType(
                name: "Stairs", code: "_-", description: "",
                landCost: 0, airCost: 0, navalCost:0, manaCost:0).save()
        servletContext.cliffsBorder = new BorderType(
                name: "Cliffs", code: "||", description: "",
                landCost: 0, airCost: 0, navalCost:0, manaCost:0).save()
        servletContext.currentBorder = new BorderType(
                name: "Current", code: "~/", description: "",
                landCost: 0, airCost: 0, navalCost:0, manaCost:0).save()
        servletContext.monsoonCurrentBorder = new BorderType(
                name: "Monsoon Current", code: "~%", description: "",
                landCost: 0, airCost: 0, navalCost:0, manaCost:0).save()

    }
}