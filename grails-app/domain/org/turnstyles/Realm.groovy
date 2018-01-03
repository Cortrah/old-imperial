package org.turnstyles

class Realm {
    String name = "Realm Name"
    String code = "R"
    String label = "Realm"
    String description = "default description"

    Herald herald

    String toString() {"$name"}

    static graphql = true

    static constraints = {

        name blank: false
        code blank: false
        label blank: false
        description nullable: true

        herald nullable: false
    }
}
