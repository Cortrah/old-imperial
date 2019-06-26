package org.turnstyles

// ToDo: use something like a lambda fn or closure for instances
// the effect of a spell, a movement rule, a leader action or realm action
// a military alliance might include troop and/or leader visibility, in total or by instance
// a feature might have the effecto allowing the creation of a troop type like gryphons

class Effect {

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
