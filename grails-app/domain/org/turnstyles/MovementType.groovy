package org.turnstyles

class MovementType {

    String name
    String code = 'mv'
    String description = "movement type"

    static constraints = {

        name blank: false
        code blank: false
        description nullable: true

    }
}