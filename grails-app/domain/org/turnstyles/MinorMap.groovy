package org.turnstyles

import org.grails.datastore.mapping.query.Query

class MinorMap {

    String name = "Name"
    String code = "Code"
    String description = ""
    String fileName = "minormap.svg"
    Integer x = 0
    Integer y = 0

    Boolean isSecret = false

    String toString() {"$name"}

    static graphql = true
    static constraints = {
        name blank: false
        code blank: false
        description nullable: true
        fileName nullable: true
        x()
        y()
        isSecret()
    }
}
