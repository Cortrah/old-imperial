package org.turnstyles

// simple relation, perhaps spells have many religions

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

