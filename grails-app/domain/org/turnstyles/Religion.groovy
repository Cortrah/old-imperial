package org.turnstyles

class Religion {
    String name = "Name"
    String code = "Code"
    String label = "Label"

    String description = "default description"
    String symbol = "symbol.png"
    String icon = "icon.png"
    Boolean isSecret = false

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
