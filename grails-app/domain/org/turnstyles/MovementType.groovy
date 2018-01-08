package org.turnstyles

class MovementType {
    String name = "Land"
    String code = 'L'
    String description = "movement by land"
    String toString() {"$name"}

    static graphql = true
    static constraints = {
        name blank: false
        code blank: false
        description nullable: true
    }
}
