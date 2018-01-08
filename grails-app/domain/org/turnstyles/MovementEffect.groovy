package org.turnstyles

class MovementEffect {

    String name
    String code = 'mv_e'
    String description = "movement effect"
    String toString() {"$name"}

    MovementType movementType

    String targetType = "cost"
    String operator = "+"
    Integer amount = 0;

    static graphql = true
    static constraints = {

        name blank: false
        code blank: false
        description nullable: true

        movementType nullable: true

        targetType inList: ['row', 'cost', 'benefit']
        operator inList: ['+', '-', '*']
        amount()
    }
}
