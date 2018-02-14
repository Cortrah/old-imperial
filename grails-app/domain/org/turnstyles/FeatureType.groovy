package org.turnstyles

// Ruins, Battlefield, GryphonNest, EleophantHerd

class FeatureType {

    String name = "Name"
    String code = "Code"
    String description = ""

    String toString() {"$name"}

    static graphql = true
    static constraints = {
        name blank: false
        code blank: false
        description nullable: true
    }
}
