package org.turnstyles

class MovementRule {

    String name
    String code = 'mv'
    String description = "movement rule"

    String preConditions
    MovementType movementType
    MovementEffect movementEffect

    static constraints = {

        name blank: false
        code blank: false
        description nullable: true
        preConditions nullable: true

    }
}
