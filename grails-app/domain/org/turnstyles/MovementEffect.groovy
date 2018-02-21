package org.turnstyles

// ToDo: Add Calculations for
// nav, air, qr
// hostile
// inimical
// hasted
// spell
// mixed ?
//
// ToDo: add sharing info in bulk or by instance to generic effect
//
//MovementEffect adjLBCost = new MovementEffect(
//        name: "Adjacent Land Border Cost", code: "adj", movementType: landMv,
//        description: "The cost for moving across an adjacent land border",
//        targetType: "cost", operator: "+", ammount:0).save()



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
