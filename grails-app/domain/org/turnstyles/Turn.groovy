package org.turnstyles

class Turn {
    String name = "1440-1445"
    String number = "1"
    String notes = "Notes"
    String toString() {"$name"}

    static belongsTo = [game: Game];
    static hasMany = [realmTurns: RealmTurn];

    static graphql = true
    static constraints = {
        name blank: false
        number blank: false
        notes blank: true
    }
}
