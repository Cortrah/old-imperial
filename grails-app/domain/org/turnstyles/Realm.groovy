package org.turnstyles

class Realm {
    String name = "Realm Name"
    String code = "R"
    String label = "Realm"
    String description = "default description"
    String toString() {"$name"}

    Herald herald

    static belongsTo = [game: Game];
    static hasMany = [realmTurns: RealmTurn];

    static graphql = true
    static constraints = {
        name blank: false
        code blank: false
        label blank: false
        description nullable: true

        herald nullable: false
    }
}
