package org.turnstyles

class Realm {
    String name = "Name"
    String code = "Code"
    String label = "Label"
    String description = "default description"
    String toString() {"$name"}

    Herald herald

    // LeaderActions
    // AutoResults
    // FinalResults

    Double startingIsi = 0.0
    Double startingTv = 0.0
    Double endingIsi = 0.0
    Double endingTv = 0.0

    static belongsTo = [turn: Turn]
    static hasMany = [regions: Region]

    static graphql = true
    static constraints = {
        name blank: false
        code blank: false
        label blank: false
        description nullable: true

        herald nullable: true

        startingIsi()
        startingTv()
        endingIsi()
        endingTv()
    }
}
