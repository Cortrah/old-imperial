package org.turnstyles

// gp, ap, nfp, sfp, mana

class ResourceType {

    String name = "Name"
    String code = "Code"
    String description = ""

    Double cargoCost = 0.0

    String toString() {"$name"}

    static graphql = true
    static constraints = {
        name blank: false
        code blank: false
        description nullable: true

        cargoCost()
    }
    def seedContext (servletContext) {
        //servletContext.r =
    }
}
