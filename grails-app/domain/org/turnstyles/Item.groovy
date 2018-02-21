package org.turnstyles

// usually instances of an itemType like a spell crystal, but can be a unique typeless item as well
// ToDo: is cargo a type of cost? or it's own thing?

class Item {

    String name = "Name"
    String code = "Code"
    String description = ""

    ItemType itemType
    static hasMany = [costs :Cost, effects :Effect]

    Boolean isSecret = false

    String toString() {"$name"}

    static graphql = true
    static constraints = {
        name blank: false
        code blank: false
        description nullable: true
        itemType nullable: true
        isSecret nullable: false
    }
}
