package org.turnstyles

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
