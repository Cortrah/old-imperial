package org.turnstyles

class Religion {
    String name = "Unknown"
    String code = "?"
    String label = "A Mystery"

    String description = "default description"
    String symbol = "symbol.png"
    String icon = "icon.png"
    Boolean isSecret = false

    static hasMany = [spellTypes :SpellType]

    String toString() {"$name"}

    static graphql = true
    static constraints = {
        name blank: false
        code blank: false
        label blank: false

        description nullable: true
        symbol blank: false
        icon blank: false
        isSecret nullable: false
    }

    def seedContext (servletContext) {
        servletContext.yagnarist = new Religion(name: "Yagnar: the Cleansing Storm", code: "Y", label: "Yagnar", description: "description").save();
        servletContext.illuvarian = new Religion(name: "Illuvar: Justice and Light", code: "I", label: "Illuvar", description: "description").save();
        servletContext.tarotist = new Religion(name: "Lords of the Tarot: Fate and Fortune", code: "T", label: "Tarot", description: "description").save();
        servletContext.urdan = new Religion(name: "Urda: The Earth Mother", code: "U", label: "Urda", description: "description").save();
    }
}

