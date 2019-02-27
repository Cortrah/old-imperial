package org.turnstyles

// ToDo: this is a simple relation, but perhaps spells have many religions? Use relations or just additional instances?

class SpellsReligion {

    SpellType spellType
    Religion religion

    String toString() {"$name"}

    static graphql = true
    static constraints = {
    }
    def seedContext (servletContext) {
        //servletContext.r =
    }
}

