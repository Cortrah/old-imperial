package org.turnstyles

class Herald {
    String name = "Name"
    String code = "Code"
    String label = "Label"
    String description = "default description"
    String img = "default.png"
    String toString() {"$name"}

    static belongsTo = [realm: Realm]

    // Should link to a player, which is a spring security user that also has
    // Credits & Games

    Boolean isSecret = false

    static graphql = true
    static constraints = {
        name blank: false
        code blank: false
        label blank: false
        realm nullable: false
        description nullable: true
        img blank: false
        isSecret nullable: false
    }
}
