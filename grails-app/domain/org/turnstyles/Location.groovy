package org.turnstyles

class Location {

    String name = "Region:Co"
    String code = "Co"
    String label = "county"

    String icon = "leader.svg"
    Integer x = 0
    Integer y = 0

    String path = "m0,0 L100,0 L100,100 L0,100 z"

    String toString() {"$code"}

    boolean isSecret = false;

    static belongsTo = [region :Region]
    static hasMany = [items :Item, unitTypeGroups :UnitTypeGroup, leaders :Leader]

    static graphql = true
    static constraints = {
        name blank: false
        code blank: false
        label blank: false

        icon nullable: true
        x nullable: true
        y nullable: true
        path nullable: true

        region nullable: false
        isSecret nullable: false
    }
}
