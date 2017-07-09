package org.turnstyles

class MovementRule {

    String name
    String code = 'mv'
    String description = "movement rule"

    static constraints = {

        name blank: false
        code blank: false
        description nullable: true

    }
}
