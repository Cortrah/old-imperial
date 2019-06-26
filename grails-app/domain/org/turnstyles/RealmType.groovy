package org.turnstyles

// ToDo: seed primacy, elector, dutchy , secret society ...

class RealmType {

    String name = "Name"
    String code = "Code"
    String description = ""
    String toString() {"$name"}

    static graphql = true
    static constraints = {
        name blank: false
        code blank: false
        description nullable: true
    }
    def seedContext (servletContext) {
        //servletContext.r =
    }
}

