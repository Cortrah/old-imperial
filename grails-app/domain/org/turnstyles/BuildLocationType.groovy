package org.turnstyles

// Controlled Region, Homeland, Town City, Port, Fortress,
// Controlled Forest, Controlled Swamp, Controlled Jungle,
// Gryphon Nest, ElephantRange

class BuildLocationType {

    String name = "Name"
    String code = "Code"
    String description = ""

    Boolean isSecret = false

    String toString() {"$name"}

    static graphql = true
    static constraints = {
        name blank: false
        code blank: false
        description nullable: true
        isSecret nullable: false
    }
}
