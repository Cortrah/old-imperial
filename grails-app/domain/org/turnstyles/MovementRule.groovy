package org.turnstyles

// movementType speed, reactionspeed,  cargo capacity, cargo cost
// where the effect is the number?


class MovementRule {
    String name = "name"
    String code = 'code'
    String description = "movement rule"

    String toString() {"$name"}

    String preconditions = ""
    MovementType movementType
    Integer speed = 0
    Integer reactionSpeed = 0
    Double cargoCost = 0
    Double cargoCapacity = 0
    MovementEffect movementEffect

    static graphql = true
    static constraints = {
        name blank: false
        code blank: false

        description nullable: true
        preconditions nullable: true

        movementType nullable: true
        speed()
        reactionSpeed()
        cargoCapacity()
        cargoCost()
        movementEffect nullable: true
    }
    def seedContext (servletContext) {
        //servletContext.r =
        // MovementRule movementRule = new MovementRule(
        //        name: "Adj L Border", code: "AdjLB", description: "Going into an adjacent land region",
        //        preconditions: "always", movementType: landMv, movementEffect: adjLBCost).save()
    }
}
