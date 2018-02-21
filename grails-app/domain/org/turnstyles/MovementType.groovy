package org.turnstyles

// land = 0
// air = 0
// naval = 0
// underground = 0
// spell = 0 (teleport or gate) different?

//MovementType unknownMv = new MovementType(
//        name: "Unknown", code: "?", description: "a mystery").save()
//MovementType landMv = new MovementType(
//        name: "Land", code: "L", description: "land movement").save()
//MovementType navalMv = new MovementType(
//        name: "Naval", code: "N", description: "by ocean, river or canal").save()
//MovementType airMv = new MovementType(
//        name: "Air", code: "A", description: "flying").save()
//MovementType celestialMv = new MovementType(
//        name: "Celestial", code: "C", description: "flying high").save()
//MovementType subterainianMv = new MovementType(
//        name: "Subteranian", code: "S", description: "underground").save()
//MovementType gateMv = new MovementType(
//        name: "Gate", code: "G", description: "using a magical gate").save()
//MovementType teleportMv = new MovementType(
//        name: "Teleportation", code: "T", description: "via the teleportation spell").save()
//MovementType allMv = new MovementType(
//        name: "All", code: "*", description: "all movement types").save()


class MovementType {
    String name = "Name"
    String code = 'Code'
    String description = "description"
    String toString() {"$name"}

    static graphql = true
    static constraints = {
        name blank: false
        code blank: false
        description nullable: true
    }
}
