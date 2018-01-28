package org.turnstyles

class Narrative {

    String name = "Name"
    String code = "Code"
    String notes = ""
    String playByPlay = ""
    String episode = ""

    static constraints = {
        name nullable: true
        code nullable: true
        notes nullable: true
        playByPlay nullable: true
        episode nullable: true
    }
}
