package org.turnstyles

class Kindred {
    String name = "Unknown"
    String code = "?"
    String label = "Unknown"
    String description = "A Mystery"
    String notes = "Notes"

    Integer ageOfMajority = 18
    Integer averageLifespan = 70

    Integer averageCouth = 7
    Integer averageFerocity = 7
    Integer averageInteligence = 7
    Integer averageLoyalty = 7

    // ToDo: Replace these with hasMany KindredTraits
    // Boolean isAmphibian = false
    // Boolean isFlyer = false
    // Boolean isArmored = false
    // Boolean isVacumeProtected = false

    Boolean isSecret = false

    String toString() {"$name"}

    static graphql = true
    static constraints = {
        name blank: false
        code blank: false
        label blank: false
        description blank: true
        notes blank: true

        ageOfMajority nullable: false
        averageLifespan nullable: false

        averageCouth nullable: false
        averageFerocity nullable: false
        averageInteligence nullable: false
        averageLoyalty nullable: false

        // isAmphibian nullable: false
        // isFlyer nullable: false
        // isArmored nullable: false
        // isVacumeProtected nullable: false

        isSecret nullable: false
    }
    def seedContext (servletContext) {
        servletContext.SaurianKin = new Kindred(name: "Saurian", code: "S").save()
        servletContext.YaminionKin = new Kindred(name: "Yaminion", code: "Y").save()
        servletContext.WenemetKin = new Kindred(name: "Wenemet", code: "W").save()
        servletContext.MalebolgeKin = new Kindred(name: "Malebolge", code: "M").save()
        servletContext.HumanKin = new Kindred(name: "Human", code: "H").save()
        servletContext.ElvenKin = new Kindred(name: "Elven", code: "E").save()
        servletContext.ThalariKin = new Kindred(name: "Thalari", code: "T").save()
        servletContext.GornyaKin = new Kindred(name: "Gornya", code: "G").save()
        servletContext.MixedKin = new Kindred(name: "Mixed", code: "X").save()
    }
}
