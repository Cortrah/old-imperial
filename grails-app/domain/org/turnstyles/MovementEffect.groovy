package org.turnstyles

class MovementEffect {

    String name
    String code = 'mv'
    String description = "movement effect"

    static constraints = {

        name blank: false
        code blank: false
        description nullable: true

    }
}
