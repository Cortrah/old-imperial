package org.turnstyles

// ToDo: Add Calculations for
// nav, air, qr
// hostile
// inimical
// hasted
// spell
// mixed ?

class MovementEffect {
    String name = "name"
    String code = 'code'
    String description = "movement effect"
    String toString() {"$name"}

    MovementType movementType

    // Conditions
    // MovementRule
    // Effect

    String targetType = "cost"
    String operator = "+"
    Integer amount = 0

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
