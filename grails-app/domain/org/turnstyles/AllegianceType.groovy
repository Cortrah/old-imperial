package org.turnstyles

// AllegianceType Unknown = new AllegianceType(name: "Unknown", code: "?").save()
// AllegianceType Homeland = new AllegianceType(name: "Homeland", code: "H").save()
// AllegianceType Friendly = new AllegianceType(name: "Friendly", code: "F").save()
// AllegianceType Pacified = new AllegianceType(name: "Pacified", code: "P").save()
// AllegianceType Allied = new AllegianceType(name: "Allied", code: "A").save()
// AllegianceType Tributary = new AllegianceType(name: "Tributary", code: "T").save()
// AllegianceType Hostile = new AllegianceType(name: "Hostile", code: "Hs").save()
// AllegianceType AtWar = new AllegianceType(name: "At War", code: "Wr").save()
// AllegianceType Occupied = new AllegianceType(name: "Occupied", code: "O").save()
// AllegianceType Contested = new AllegianceType(name: "Contested", code: "C").save()

class AllegianceType {
    String name = "Uncontrolled"
    String code = "U"
    String description = "An independent entity"
    String toString() {"$name"}

    static graphql = true
    static constraints = {
        name blank: false
        code blank: false
        description blank: true
    }
}
