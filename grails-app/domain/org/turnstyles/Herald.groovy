package org.turnstyles

class Herald {
    String name = "Herald Name"
    String code = "H"
    String label = "Herald"
    String description = "default description"
    String img = "default.png"
    String toString() {"$name"}

    static belongsTo = [realm: Realm];

    static graphql = true
    static constraints = {

        name blank: false
        code blank: false
        label blank: false
        description nullable: true
        img blank: false
    }
}
