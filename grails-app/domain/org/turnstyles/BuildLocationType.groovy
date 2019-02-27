package org.turnstyles

// ToDo: add the unit types that can be built
// Region, Homeland, Town, City, Port, Fortress,
// Forest, Swamp, Jungle,
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
    def seedContext (servletContext) {
        //servletContext.r =
    }
}