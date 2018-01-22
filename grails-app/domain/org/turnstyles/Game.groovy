package org.turnstyles

class Game {
    String name = "Name"
    String code = "Code"
    String label = "Label"
    String notes = "Notes"
    String toString() {"$name"}

    Turn currentTurn
    static hasMany = [turns: Turn, majorMap: MajorMap]

    static graphql = true
    static constraints = {
        name blank: false
        code blank: false
        label blank: false

        currentTurn nullable: true

        notes blank: true
    }
}
