package org.turnstyles

class LeaderActionType {

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
        //LeaderActionType move = new LeaderActionType(name: "Movement", code: "Mv", description: "").save();
        //LeaderActionType combat = new LeaderActionType(name: "Combat", code: "Cbt", description: "").save();
        //LeaderActionType intel = new LeaderActionType(name: "Inteligence", code: "Int", description: "").save();
        //LeaderActionType diplo = new LeaderActionType(name: "Diplomacy", code: "Di", description: "").save();
        //LeaderActionType exchange = new LeaderActionType(name: "Transfer", code: "Tr", description: "").save();
        //LeaderActionType magic = new LeaderActionType(name: "Magic", code: "Ma", description: "").save();
        //LeaderActionType custom = new LeaderActionType(name: "Custom", code: "XX", description: "").save();
    }
}

