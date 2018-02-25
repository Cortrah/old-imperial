package org.turnstyles

// a spell
// ToDo: add proposal, research costs and history or status of completion

class SpellType {

    String name = "Name"
    String code = "Code"
    String description = ""

    String level = "Minor"
    Integer nsr = 4
    String whenToCast = "Any"
    Integer timeToCast = 0

    Boolean allowsMultipleCasters = false

    Integer initialManaCost = 0
    Integer perUnitManaCost = 0
    Integer totalManaCost = 0

    Boolean isSecret = false

    static hasMany = [spells :SpellType]

    // Effect

    String toString() {"$name"}

    static graphql = true
    static constraints = {
        name blank: false
        code blank: false
        description nullable: true

        level()
        nsr()
        whenToCast()
        timeToCast()

        allowsMultipleCasters()
        initialManaCost()
        perUnitManaCost()
        totalManaCost()

        isSecret()
    }
    def seedContext (servletContext) {
        //servletContext.r =
    }
}

