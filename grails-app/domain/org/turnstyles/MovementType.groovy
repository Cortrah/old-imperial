package org.turnstyles

class MovementType {

    String name
    String code = 'mv'
    String description = "movement type"
    String toString() {"$name"}

    static graphql = true
    static constraints = {

        name blank: false
        code blank: false
        description nullable: true

    }
}
