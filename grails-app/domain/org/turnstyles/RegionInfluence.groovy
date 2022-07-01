package org.turnstyles

class RegionInfluence {

    String name = "Name"
    String code = "Code"
    String description = ""

    Region region
    InfluenceType influenceType

    Boolean isSecret = false

    String toString() {"$name"}

    static graphql = true
    static constraints = {
        name blank: false
        code blank: false
        description nullable: true
        influenceType nullable: true
        isSecret nullable: false
    }
    def seedContext (servletContext) {
        //servletContext.r =
    }
}
