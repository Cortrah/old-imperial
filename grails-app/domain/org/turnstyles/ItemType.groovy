package org.turnstyles

// common items of which there may be many instances

class ItemType {

    String name = "Name"
    String code = "Code"
    String description = ""

    // ex spell crystals have a blank crystal as a cost
    static hasMany = [costs :Cost, effects :Effect]

    Double cargoSpace = 0

    // ToDo: maybe a more generic Effects with a spell type and amount
    SpellType spellType

    // Artifacts or batteries with a manaCharge might be a generic resource or cargo value
    Integer manaCharge = 0

    String toString() {"$name"}

    static graphql = true
    static constraints = {
        name blank: false
        code blank: false
        description nullable: true

        manaCharge nullable: true
        spellType nullable: true
    }
    def seedContext (servletContext) {
        //servletContext.r =
    }
}
