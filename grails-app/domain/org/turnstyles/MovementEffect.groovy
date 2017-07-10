package org.turnstyles

class MovementEffect {

    String name
    String code = 'mv'
    String description = "movement effect"

    MovementType movementType

    String targetType
    String operator
    Integer amount

    String toString() {"$name $targetType $operator $amount"}

    static constraints = {

        name blank: false
        code blank: false
        description nullable: true

        targetType inList: ['row', 'cost', 'benefit']
        operator inList: ['+', '-', '*']
        amount()
    }
}
