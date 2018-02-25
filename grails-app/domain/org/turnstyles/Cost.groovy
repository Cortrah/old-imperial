package org.turnstyles

// gp, ap, nfp, sfp, mana, blankSpellCrystal
// totalManaCost for multi caster or per unit spell

class Cost {

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
