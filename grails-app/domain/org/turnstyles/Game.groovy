package org.turnstyles

class Game {
    String name = "Game Name"
    String code = "G"
    String label = "Game"
    String notes = "Notes"

    String toString() {"$name"}

    static graphql = true

    static constraints = {

        name blank: false
        code blank: false
        label blank: false
        notes blank: true

    }
}
