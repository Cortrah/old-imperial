package org.turnstyles

class MajorMap {

    String name = "Unknown"
    String code = "?"
    String label = "Unknown"
    String description = ""

    Integer x = 0
    Integer y = 0
    Integer height = 1600
    Integer width = 2400
    String bg
    String toString() {"$name"}

    boolean isSecret = false

    static hasMany = [regions: Region]
    static belongsTo = [turn: Turn]

    static graphql = true
    static constraints = {
        name blank: false
        code blank: false
        label blank: false
        description blank: true

        x blank: false
        y blank: false
        height blank: false
        width blank: false
        bg nullable: true

        isSecret nullable: false
    }
}

