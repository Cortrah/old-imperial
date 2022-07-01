package org.turnstyles

class Location {

    String name = "Region:Co"
    String code = "Co"
    String label = "county"
    String tooltip = ""
    String description = ""
    String notes = ""

    String icon = "./img/glyphs/steppe.png"
    Integer x = 0
    Integer y = 0
    Integer w = 30
    Integer h = 30
    Integer cX = 15
    Integer cY = 15

    String pathData = "m0,0 L100,0 L100,100 L0,100 z"

    String toString() {"$code"}

    boolean isSecret = false;

    static belongsTo = [region :Region]
    static hasMany = [items :Item, unitTypeGroups :UnitTypeGroup, leaders :Leader, constructs :Construct]

    static graphql = true
    static constraints = {
        name blank: false
        code blank: false
        label blank: false
        tooltip blank: false
        description blank: false
        notes blank: false

        icon nullable: true
        x nullable: true
        y nullable: true
        w nullable: true
        h nullable: true
        cX nullable: true
        cY nullable: true

        pathData nullable: true

        region nullable: false
        isSecret nullable: false
    }
}
