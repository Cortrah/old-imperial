package org.turnstyles

// usually instances of an itemType like a spell crystal, but can be a unique typeless item as well
class Item {

    String name = "Name"
    String code = "Code"
    String description = ""

    ItemType itemType
    static hasMany = [costs :Cost, effects :Effect]

    String toString() {"$name"}

    static graphql = true
    static constraints = {
        name blank: false
        code blank: false
        description nullable: true
        itemType nullable: true

    }
}
