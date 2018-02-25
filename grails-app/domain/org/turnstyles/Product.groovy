package org.turnstyles

// the opposite of a cost,
// regions and constructs produce
// gp, ap, nfp, sfp, mana

class Product {

    String name = "Name"
    String code = "Code"
    String description = ""

    ResourceType resourceType
    Integer amount

    String toString() {"$name"}

    static graphql = true
    static constraints = {
        name blank: false
        code blank: false
        description nullable: true

        resourceType()
        amount()
    }
    def seedContext (servletContext) {
        //servletContext.r =
    }
}

