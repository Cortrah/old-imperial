package org.turnstyles

import org.turnstyles.MovementType
import org.turnstyles.MovementEffect

// ToDo: movementType speed, reactionspeed,  cargo capacity, cargo cost?
// ToDo: where the effect is a number? or a formula?

class MovementRule {
    String name = "Unknown"
    String code = '?'
    String description = "A Mystery"

    String toString() {"$name"}

    String preconditions = ""
    MovementType movementType
    MovementEffect movementEffect

    Integer speed = 0
    Integer reactionSpeed = 0
    Double cargoCost = 0
    Double cargoCapacity = 0

    static graphql = true
    static constraints = {
        name blank: false
        code blank: false

        description nullable: true
        preconditions nullable: true

        movementType nullable: true
        movementEffect nullable: true

        speed()
        reactionSpeed()
        cargoCapacity()
        cargoCost()
    }

    def seedContext (servletContext) {
        servletContext.landMv = new MovementType(
                name: "Land", code: "L", description: "land movement").save()

        servletContext.adjLBCost = new MovementEffect(
                name: "Adjacent Land Border Cost", code: "adj", movementType: servletContext.landMv,
                description: "The cost for moving across an adjacent land border",
                targetType: "cost", operator: "+", ammount:0).save()

        servletContext.movementRule = new MovementRule(
                name: "Adj L Border", code: "AdjLB", description: "Going into an adjacent land region",
                preconditions: "always", movementType: servletContext.landMv, movementEffect: servletContext.adjLBCost).save()
    }
}
