package org.turnstyles

import org.turnstyles.MovementType

// ToDo: Add Calculations for
// nav, air, qr
// hostile
// inimical
// hasted
// spell
// mixed ?
//
// ToDo: add sharing info in bulk or by instance to generic effect

class MovementEffect {
    String name = "Uknown"
    String code = '?'
    String description = "A Mystery"

    MovementType movementType

    String targetType = "cost"
    String operator = "+"
    Integer amount = 0

    // Conditions
    // MovementRule
    // Effect

    String toString() {"$name"}

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

    def seedContext (servletContext) {
        // will always require both a MovementType and be part of one or more MovementRules
        // so we will create both in MovementRule even thought it's not a belongsTo
    }
}
