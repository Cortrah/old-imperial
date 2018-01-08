package org.turnstyles

class AllegianceType {
    String name = "Uncontrolled"
    String code = "U"
    String description = "An independent entity"
    String toString() {"$name"}

    static graphql = true
    static constraints = {
        name blank: false
        code blank: false
        description blank: true
    }
}
