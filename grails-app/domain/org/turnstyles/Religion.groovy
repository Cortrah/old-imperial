package org.turnstyles

//Religion yagnarist = new Religion(name: "Yagnar: the Cleansing Storm", code: "Y", label: "Yagnar", description: "description").save();
//Religion illuvarian = new Religion(name: "Illuvar: Justice and Light", code: "I", label: "Illuvar", description: "description").save();
//Religion tarotist = new Religion(name: "Lords of the Tarot: Fate and Fortune", code: "T", label: "Tarot", description: "description").save();
//Religion urdan = new Religion(name: "Urda: The Earth Mother", code: "U", label: "Urda", description: "description").save();

class Religion {
    String name = "Name"
    String code = "Code"
    String label = "Label"

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
}
