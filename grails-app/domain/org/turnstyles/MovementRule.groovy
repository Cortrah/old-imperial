package org.turnstyles

class MovementRule {
    String name
    String code = 'mv'
    String description = "movement rule"
    String toString() {"$name $movementType $movementEffect"}

    String preconditions
    MovementType movementType
    MovementEffect movementEffect

    static graphql = true
    static constraints = {
        name blank: false
        code blank: false

        description nullable: true
        preconditions nullable: true

        movementType nullable: true
        movementEffect nullable: true
    }
}
