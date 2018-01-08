package org.turnstyles

class RealmTurn {
    String name = "RealmName:1440-1445"
    String code = "RealmCode:TurnNumber"
    String notes = "Notes"
    String toString() {"$name"}

    // LeaderActions
    // AutoResults
    // FinalResults

    Double startingIsi = 0.0;
    Double StartingTv = 0.0;
    Double EndingIsi = 0.0;
    Double EndingTv = 0.0;

    Realm realm;
    static belongsTo = [turn: Turn];
    static hasMany = [regionTurnStatuses: RegionTurnStatus];

    static graphql = true
    static constraints = {
        name blank: false
        code blank: false
        notes blank: true

    }
}
