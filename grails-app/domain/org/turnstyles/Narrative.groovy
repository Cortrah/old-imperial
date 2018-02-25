package org.turnstyles

// a chunk of the story with a title (name) label (for inline links) and secrecy status for sharing or not
// ToDo: possibly add links to related narratives

class Narrative {

    String name = "Name"
    String code = "Code"
    String label = "Label"
    String notes = ""
    String playByPlay = ""
    String episode = ""

    Boolean isSecret = false

    static constraints = {
        name blank: false
        code nullable: true
        code blank: false
        notes nullable: true
        playByPlay nullable: true
        episode nullable: true
        isSecret nullable: false
    }
    def seedContext (servletContext) {
        //servletContext.r =
    }
}

