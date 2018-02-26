package org.turnstyles

class AllegianceType {
    String name = "Unknown"
    String code = "?"
    String description = "A Mystery"

    String toString() {"$name"}

    static graphql = true
    static constraints = {
        name blank: false
        code blank: false
        description blank: true
    }

    def seedContext (servletContext) {
        servletContext.Unknown = new AllegianceType(name: "Uncontrolled", code: "U", description: "An independent entity").save()
        servletContext.Homeland = new AllegianceType(name: "Homeland", code: "H").save()
        servletContext.Friendly = new AllegianceType(name: "Friendly", code: "F").save()
        servletContext.Pacified = new AllegianceType(name: "Pacified", code: "P").save()
        servletContext.Allied = new AllegianceType(name: "Allied", code: "A").save()
        servletContext.Tributary = new AllegianceType(name: "Tributary", code: "T").save()
        servletContext.Hostile = new AllegianceType(name: "Hostile", code: "Hs").save()
        servletContext.AtWar = new AllegianceType(name: "At War", code: "Wr").save()
        servletContext.Occupied = new AllegianceType(name: "Occupied", code: "O").save()
        servletContext.Contested = new AllegianceType(name: "Contested", code: "C").save()
    }
}