package org.turnstyles

class AgentType {

    String name = "Unknown"
    String code = "?"
    String description = "A Mystery"
    // moveMentRules

    String toString() {"$name"}

    static graphql = true
    static constraints = {
        name blank: false
        code blank: false
        description (nullable: true, widget: 'textarea')
    }
    def seedContext (servletContext) {
        servletContext.e = new AgentType(name: "Ruler", code: "E", description: "").save();
        servletContext.h = new AgentType(name: "Heir", code: "H", description: "").save();
        servletContext.f = new AgentType(name: "Friendly", code: "F", description: "").save();
        servletContext.a = new AgentType(name: "Allied", code: "A", description: "").save();
        servletContext.m = new AgentType(name: "Mercenary", code: "M", description: "").save();
        servletContext.he = new AgentType(name: "Hero", code: "He", description: "").save();
        servletContext.th = new AgentType(name: "Thrall", code: "Th", description: "").save();
    }
}


