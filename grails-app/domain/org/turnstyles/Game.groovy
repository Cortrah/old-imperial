package org.turnstyles

// FireAndIce = new org.turnstyles.Game(name: "Of Fire and Ice", code: "Fie", label: "Fire Ice").save()
// FireAndIce.currentTurn = Turn25

class Game {
    String name = "Name"
    String code = "Code"
    String label = "Label"
    String notes = "Notes"
    String status = "Staging"
    String toString() {"$name"}

    Turn currentTurn
    static hasMany = [turns: Turn]

    static graphql = true
    static constraints = {
        name blank: false
        code blank: false
        label blank: false
        status inList: ["Staging", "Ploting", "Processing", "Concluded"]

        currentTurn nullable: true

        notes blank: true
    }
}
