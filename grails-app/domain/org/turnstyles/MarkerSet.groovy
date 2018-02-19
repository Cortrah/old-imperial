package org.turnstyles

class MarkerSet {
    String name = "Name"
    Integer color = 0
    Boolean isVisible = true

    static belongsTo = [majorMap :MajorMap]
    static hasMany = [realms :Realm]

    String toString() {"$name"}

    static graphql = true
    static constraints = {
        name blank: false
        color()
        isVisible()
    }
}
