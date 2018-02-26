package org.turnstyles

import org.turnstyles.Turn

class Game {
    String name = "GameName"
    String code = "GameCode"
    String label = "GameLabel"
    String notes = "Notes"
    String status = "Staging"

    Turn currentTurn
    static hasMany = [turns: Turn]

    String toString() {"$name"}

    static graphql = true
    static constraints = {
        name blank: false
        code blank: false
        label blank: false
        status inList: ["Staging", "Ploting", "Processing", "Concluded"]

        currentTurn nullable: true

        notes blank: true
    }

    def seedContext (servletContext) {
        servletContext.FireAndIce = new Game(name: "Of Fire and Ice", code: "Fie", label: "Fire Ice").save()
    }

    def seedSecondPass (servletContext, turn){
        // this part may need to be in a second pass for cyclic dependencies
        servletContext.FireAndIce.currentTurn = turn
    }
}
