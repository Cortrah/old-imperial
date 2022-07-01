package org.turnstyles

// a chunk of the story with a title (name) label (for inline links) and secrecy status for sharing or not
// ToDo: possibly add links to related narratives

class Narrative {

    String name = "Name"
    String code = "Code"
    String label = "Label"
    String notes = ""
    String playByPlay = "" // automatically generated content
    String content = ""    // potentially hand written content

    Boolean isSecret = false

    static constraints = {
        name blank: false
        code nullable: true
        label blank: false
        notes nullable: true
        playByPlay nullable: true
        content nullable: true
        isSecret nullable: false
    }
    def seedContext (servletContext) {
        //servletContext.r =
    }
}

