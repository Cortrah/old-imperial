package org.turnstyles

class Turn {
    String name = "1440-1445"
    Integer number = 1
    Integer startingYear = 1440
    Integer endingYear = 1445
    String notes = "Notes"
    String toString() {"$name"}

    static belongsTo = [game: Game]
    static hasMany = [realms: Realm, majorMaps: MajorMap]

    static graphql = true
    static constraints = {
        name blank: false
        number blank: false
        startingYear nullable: false
        endingYear nullable: false
        notes blank: true
    }
}
