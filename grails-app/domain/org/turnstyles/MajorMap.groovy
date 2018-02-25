package org.turnstyles

class MajorMap {

    String name = "FireAndIce:Sahul"
    String code = "Sah"
    String label = "Sahul"
    String description = ""

    Integer x = 0
    Integer y = 0
    Integer height = 1600
    Integer width = 2400
    String bg
    String toString() {"$name"}

    boolean isSecret = false

    static hasMany = [regions: Region]
    static belongsTo = [game: Game]

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
    def seedContext (servletContext) {
        //servletContext.r =

        //  MajorMap sahulMap = new MajorMap(name: "FireAndIce:Sahul", code: "Sah", label: "Sahul", game: FireAndIce,
        //        description: "The continent of Sahul is under the dubious leadership of an imperial structure called the second empire.",
        //        x: 0, y: 0, height: 1400, width: 2600, bg: "sahul.svg", isSecret: false).save()
    }
}

