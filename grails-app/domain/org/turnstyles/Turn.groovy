package org.turnstyles

class Turn {
    String name = "0-5"
    String code = "1"
    String label = "1"
    Integer number = 1
    String description = "The first turn which encompasses a five year span in game time"
    Integer startingYear = 0
    Integer endingYear = 5

    String status = "Staging"
    String chronicle = "Sahul-1440.pdf"
    Date dueDate = new Date()
    String notes = "Notes"

    static belongsTo = [game: Game]

    // Realm is kind of Both Realm and RealmsTurnStatus here as it is a new row for every turn
    // this is to encompass possible changes to everything
    // from the realms name to each turns realm status to each turns set of realm actions
    static hasMany = [realms: Realm, majorMaps: MajorMap, narratives: Narrative]

    String toString() {"$name"}

    static graphql = true
    static constraints = {
        name blank: false
        code blank: false
        label blank: false
        number blank: false
        description blank: true
        startingYear nullable: false
        endingYear nullable: false

        status inList: ["Staging", "Plotting", "Processing", "Editing", "Concluded"]
        notes blank: true

        dueDate()
        chronicle nullable: true
    }
}



