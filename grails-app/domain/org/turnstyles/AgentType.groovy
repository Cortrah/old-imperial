package org.turnstyles

// AgentType R = new AgentType(name: "Ruler", code: "E", description: "").save();
// AgentType H = new AgentType(name: "Heir", code: "H", description: "").save();
// AgentType F = new AgentType(name: "Friendly", code: "F", description: "").save();
// AgentType A = new AgentType(name: "Allied", code: "A", description: "").save();
// AgentType M = new AgentType(name: "Mercenary", code: "M", description: "").save();
// AgentType He = new AgentType(name: "Hero", code: "He", description: "").save();
// AgentType Th = new AgentType(name: "Thrall", code: "Th", description: "").save();

class AgentType {

    String name = "Name"
    String code = "Code"
    String description = ""
    String toString() {"$name"}

    static graphql = true
    static constraints = {
        name blank: false
        code blank: false
        description nullable: true, widget: 'textarea'
    }
}
