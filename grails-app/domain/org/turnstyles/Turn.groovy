package org.turnstyles

class Turn {
    String name = "1440-1445"
    Integer number = 1
    Integer startingYear = 1440
    Integer endingYear = 1445

    String status = "Staging"
    String chronicle = "Sahul.1440.pdf"
    Date dueDate = new Date()
    String notes = "Notes"
    String toString() {"$name"}

    static belongsTo = [game: Game]

    // Realm is kind of Both Realm and RealmsTurnStatus here as it is a new row for every turn
    // this is to encompass possible changes to everything
    // from the realms name to each turns realm status to each turns set of realm actions
    static hasMany = [realms: Realm, majorMaps: MajorMap, narratives: Narrative]

    static graphql = true
    static constraints = {
        name blank: false
        number blank: false
        startingYear nullable: false
        endingYear nullable: false

        status inList: ["Staging", "Ploting", "Processing", "Editing", "Concluded"]
        notes blank: true

        dueDate()
        chronicle nullable: true
    }
}
