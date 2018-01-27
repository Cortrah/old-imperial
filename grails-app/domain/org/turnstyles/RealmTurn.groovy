package org.turnstyles

class RealmTurn {
    String name = "RealmName:1440-1445"
    String code = "RealmCode:TurnNumber"
    String notes = "Notes"
    String toString() {"$name"}

    // LeaderActions
    // AutoResults
    // FinalResults

    Double startingIsi = 0.0
    Double startingTv = 0.0
    Double endingIsi = 0.0
    Double endingTv = 0.0

    Realm realm;
    static belongsTo = [turn: Turn]
    static hasMany = [regions: Region]

    static graphql = true
    static constraints = {
        name blank: false
        code blank: false
        notes blank: true

        realm nullable: true

        startingIsi()
        startingTv()
        endingIsi()
        endingTv()
    }
}
