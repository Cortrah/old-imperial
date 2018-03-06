package org.turnstyles

class LeaderActionType {

    String name = "Unknown"
    String code = "?"
    String description = "A mystery"
    String toString() {"$name"}

    static graphql = true
    static constraints = {
        name blank: false
        code blank: false
        description nullable: true
    }
    def seedContext (servletContext) {
        servletContext.move = new LeaderActionType(name: "Movement", code: "Mv", description: "").save();
        servletContext.combat = new LeaderActionType(name: "Combat", code: "Cbt", description: "").save();
        servletContext.intel = new LeaderActionType(name: "Inteligence", code: "Int", description: "").save();
        servletContext.diplo = new LeaderActionType(name: "Diplomacy", code: "Di", description: "").save();
        servletContext.exchange = new LeaderActionType(name: "Transfer", code: "Tr", description: "").save();
        servletContext.magic = new LeaderActionType(name: "Magic", code: "Ma", description: "").save();
        servletContext.conditional = new LeaderActionType(name: "Conditional", code: "???", description: "").save();
        servletContext.custom = new LeaderActionType(name: "Custom", code: "XX", description: "").save();
    }
}

