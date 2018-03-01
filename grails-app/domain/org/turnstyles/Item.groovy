package org.turnstyles

// usually instances of an itemType like a spell crystal, but can be a unique typeless item as well
// ToDo: is cargo a type of cost? or it's own thing? LeaderMovement points or turns?
// an item might want to have hasMany cost, effect and product types
// to make it the most generic form of object in the game
// a spell may include the leaderAction movement as a part of it's cost
// a spell crystal should even use a blankcrystal as a part of it's cost.

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
    def seedContext (servletContext) {
        //servletContext.r =
    }
}
