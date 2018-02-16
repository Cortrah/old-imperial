package org.turnstyles

// land = 0
// air = 0
// naval = 0
// underground = 0
// spell = 0 (teleport or gate) different?

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
