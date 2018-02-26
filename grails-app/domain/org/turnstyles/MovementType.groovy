package org.turnstyles

// land = 0
// air = 0
// naval = 0
// underground = 0
// spell = 0 (teleport or gate) different?

class MovementType {
    String name = "Unknown"
    String code = '?'
    String description = "A Mystery"

    String toString() {"$name"}

    static graphql = true
    static constraints = {
        name blank: false
        code blank: false
        description nullable: true
    }
    def seedContext (servletContext) {
        servletContext.landMv = new MovementType(
                name: "Land", code: "L", description: "land movement").save()
        servletContext.navalMv = new MovementType(
                name: "Naval", code: "N", description: "by ocean, river or canal").save()
        servletContext.airMv = new MovementType(
                name: "Air", code: "A", description: "flying").save()
        servletContext.celestialMv = new MovementType(
                name: "Celestial", code: "C", description: "flying high").save()
        servletContext.subterainianMv = new MovementType(
                name: "Subteranian", code: "S", description: "underground").save()
        servletContext.gateMv = new MovementType(
                name: "Gate", code: "G", description: "using a magical gate").save()
        servletContext.teleportMv = new MovementType(
                name: "Teleportation", code: "T", description: "via the teleportation spell").save()
        servletContext.allMv = new MovementType(
                name: "All", code: "*", description: "all movement types").save()
    }
}

