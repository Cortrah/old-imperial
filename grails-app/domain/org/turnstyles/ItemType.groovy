package org.turnstyles

class ItemType {

    String name = "Name"
    String code = "Code"
    String description = ""

    // spell crystals have a blank crystal as a cost
    static hasMany = [costs :Cost, effects :Effect]

    // maybe a more generic Effects with a spell type and amount
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
}
