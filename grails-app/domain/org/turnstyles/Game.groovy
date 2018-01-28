package org.turnstyles

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
