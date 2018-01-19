package org.turnstyles

class Kindred {
    String name = "Name"
    String code = "Code"
    String label = "Label"
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