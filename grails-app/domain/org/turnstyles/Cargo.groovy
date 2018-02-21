package org.turnstyles

// one or more units of cargo being carried,
// or garrisoned in a remote location outside of the realms trade radius

class Cargo {

    String name = "Name"
    String code = "Code"
    String description = ""

    ResourceType resourceType
    Integer amount
    Double spaceRequired

    String toString() {"$name"}

    static graphql = true
    static constraints = {
        name blank: false
        code blank: false
        description nullable: true

        resourceType()
        amount()
        spaceRequired()
    }
}
