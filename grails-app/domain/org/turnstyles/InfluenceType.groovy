package org.turnstyles

class InfluenceType {
    String name = "Unknown"
    String code = "?"
    String description = "A Mystery"
    String toString() {"$name"}

    static graphql = true
    static constraints = {
        name blank: false
        code blank: false
        description nullable: true
    }
    def seedContext (servletContext) {
        servletContext.hm = new InfluenceType(name: "Homeland", code: "hm", description: "our homeland").save();
        servletContext.own = new InfluenceType(name: "Owned", code: "own", description: "fully controlled").save();
        servletContext.ali = new InfluenceType(name: "Allied", code: "ali", description: "allied controlled").save();
        servletContext.fr = new InfluenceType(name: "Friendly", code: "fr", description: "friendly region").save();
        servletContext.tri = new InfluenceType(name: "Tributary", code: "tri", description: "a tributary donates gold but is otherwise autonomous").save();
    }
}

