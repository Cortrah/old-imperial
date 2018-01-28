package org.turnstyles

class Turn {
    String name = "1440-1445"
    Integer number = 1
    Integer startingYear = 1440
    Integer endingYear = 1445
    String status = "Staging"
    String chronicle = "Sahul.1440.pdf"

    String notes = "Notes"
    String toString() {"$name"}

    static belongsTo = [game: Game]
    static hasMany = [realms: Realm, majorMaps: MajorMap, narratives: String]

    static graphql = true
    static constraints = {
        name blank: false
        number blank: false
        startingYear nullable: false
        endingYear nullable: false

        status inList: ["Staging", "Ploting", "Processing", "Editing", "Concluded"]
        notes blank: true
    }
}
