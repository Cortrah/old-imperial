package org.turnstyles

// Nsr, Bl, Ir, Rs, Cav, Inf, Sge, Nav, Air, Cel, (Rugby, Shinty ...)

class QualityRatingType {

    String name = "Name"
    String code = "Code"
    String description = ""

    String toString() {"$name"}

    static graphql = true
    static constraints = {
        name blank: false
        code blank: false
        description nullable: true
    }
    def seedContext (servletContext) {
        //servletContext.r =
    }
}

