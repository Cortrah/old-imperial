package org.turnstyles

class RealmTurn {
    String name = "Realm:1440-1445"
    String code = "Realm:1"
    String notes = "Notes"

    // LeaderActions
    // AutoResults
    // FinalResults
    // StartingIsi
    // StartingTv
    // EndingIsi
    // EndingTv
    // Turn
    // Realm
    // RegionTurnStatus

    String toString() {"$name"}

    static graphql = true

    static constraints = {

        name blank: false
        code blank: false
        notes blank: true

    }
}
