package org.turnstyles

class Turn {
    String name = "1440-1445"
    String code = "1"
    String notes = "Notes"

    String toString() {"$name"}

    static graphql = true

    static constraints = {

        name blank: false
        code blank: false
        notes blank: true

    }
}
