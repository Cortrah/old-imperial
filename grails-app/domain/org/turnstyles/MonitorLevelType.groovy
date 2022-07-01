package org.turnstyles

class MonitorLevelType {

    String name = "Name"
    String code = "Code"
    Integer level = 0

    String toString() {"$name"}

    static graphql = true
    static constraints = {
        name blank: false
        code blank: false
        level blank: false
    }
    def seedContext (servletContext) {
        servletContext.ok = new MonitorLevelType(name: "Ok", code: "ok", level:0).save();
        servletContext.ok = new MonitorLevelType(name: "Probably Fine", code: "fi", level:1).save();
        servletContext.ok = new MonitorLevelType(name: "Check", code: "ch", level:2).save();
        servletContext.ok = new MonitorLevelType(name: "Probable Error", code: "er", level:3).save();
    }
}
