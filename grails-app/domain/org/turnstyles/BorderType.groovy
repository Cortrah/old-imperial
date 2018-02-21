package org.turnstyles

// BorderType unknownBorder = new BorderType(
//        name: "Unknown", code: "?", description: "a mystery",
//        landCost: 0, airCost: 0, navalCost:0, manaCost:0).save()
// BorderType adjBorder = new BorderType(
//        name: "Adjacent", code: ":", description: "a default land border, easy to cross at no penalty",
//        landCost: 0, airCost: 0, navalCost:0, manaCost:0).save()
// BorderType roadBorder = new BorderType(
//        name: "Road", code: "_", description: "A Road",
//        landCost: 0, airCost: 0, navalCost:0, manaCost:0).save()
// BorderType riverBorder = new BorderType(
//        name: "River", code: "~", description: "",
//        landCost: 0, airCost: 0, navalCost:0, manaCost:0).save()
// BorderType canalBorder = new BorderType(
//        name: "Canal", code: "-~-", description: "",
//        landCost: 0, airCost: 0, navalCost:0, manaCost:0).save()
// BorderType bridgeBorder = new BorderType(
//        name: "Bridge", code: "=", description: "",
//        landCost: 0, airCost: 0, navalCost:0, manaCost:0).save()
// BorderType minMtnBorder = new BorderType(
//        name: "Minor Mountain", code: "-m-", description: "",
//        landCost: 0, airCost: 0, navalCost:0, manaCost:0).save()
// BorderType majMtnBorder = new BorderType(
//        name: "Major Mountain", code: "-M-", description: "",
//        landCost: 0, airCost: 0, navalCost:0, manaCost:0).save()
// BorderType minMtnPassBorder = new BorderType(
//        name: "Minor Mountain Pass", code: "_m_", description: "",
//        landCost: 0, airCost: 0, navalCost:0, manaCost:0).save()
// BorderType majMtnPassBorder = new BorderType(
//        name: "Major Mountain Pass", code: "_M_", description: "",
//        landCost: 0, airCost: 0, navalCost:0, manaCost:0).save()
// BorderType greatWallBorder = new BorderType(
//        name: "Great Wall", code: "|", description: "",
//        landCost: 0, airCost: 0, navalCost:0, manaCost:0).save()
// BorderType tunnelBorder = new BorderType(
//        name: "Tunnel", code: "-_-", description: "",
//        landCost: 0, airCost: 0, navalCost:0, manaCost:0).save()
// BorderType blockedTunnelBorder = new BorderType(
//        name: "Blocked Tunnel", code: "-x-", description: "",
//        landCost: 0, airCost: 0, navalCost:0, manaCost:0).save()
// BorderType gateBorder = new BorderType(
//        name: "Gate", code: "@", description: "",
//        landCost: 0, airCost: 0, navalCost:0, manaCost:0).save()
// BorderType teleportationBorder = new BorderType(
//        name: "Teleportation", code: "*", description: "",
//        landCost: 0, airCost: 0, navalCost:0, manaCost:0).save()
// BorderType stairsBorder = new BorderType(
//        name: "Stairs", code: "_-", description: "",
//        landCost: 0, airCost: 0, navalCost:0, manaCost:0).save()
// BorderType cliffsBorder = new BorderType(
//        name: "Cliffs", code: "||", description: "",
//        landCost: 0, airCost: 0, navalCost:0, manaCost:0).save()
// BorderType currentBorder = new BorderType(
//        name: "Current", code: "~/", description: "",
//        landCost: 0, airCost: 0, navalCost:0, manaCost:0).save()
// BorderType monsoonCurrentBorder = new BorderType(
//        name: "Monsoon Current", code: "~%", description: "",
//        landCost: 0, airCost: 0, navalCost:0, manaCost:0).save()

class BorderType {
    String name
    String code
    String description = "default description"
    String toString() {"$name"}

    Integer landCost = null
    Integer airCost = null
    Integer navalCost = null
    Integer manaCost = null

    boolean isDirectional = false

    static graphql = true
    static constraints = {
        name blank: false
        code blank: false
        description nullable: true

        landCost()
        airCost()
        navalCost()
        manaCost()

        isDirectional()
    }
}
