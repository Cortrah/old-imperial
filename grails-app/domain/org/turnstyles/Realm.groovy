package org.turnstyles

class Realm {
    String name = "Name"
    String code = "Code"
    String label = "Label"
    String description = "default description"
    String toString() {"$name"}

    Herald herald

    static belongsTo = [game: Game]
    static hasMany = [realmTurns: RealmTurn]

    static graphql = true
    static constraints = {
        name blank: false
        code blank: false
        label blank: false
        description nullable: true

        herald nullable: true
    }
}
