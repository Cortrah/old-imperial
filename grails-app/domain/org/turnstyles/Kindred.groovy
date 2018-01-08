package org.turnstyles

class Kindred {
    String name = "Human"
    String code = "H"
    String label = "Human"
    String description = "Description"
    String notes = "Notes"
    String toString() {"$name"}

    boolean isSecret = false

    static graphql = true
    static constraints = {
        name blank: false
        code blank: false
        label blank: false
        isSecret nullable: false
        description blank: true
        notes blank: true
    }
}