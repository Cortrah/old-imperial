package org.turnstyles

//Kindred UnknownKin = new Kindred(name: "Unknown", code: "?").save()
//Kindred SaurianKin = new Kindred(name: "Saurian", code: "S").save()
//Kindred YaminionKin = new Kindred(name: "Yaminion", code: "Y").save()
//Kindred WenemetKin = new Kindred(name: "Wenemet", code: "W").save()
//Kindred MalebolgeKin = new Kindred(name: "Malebolge", code: "M").save()
//Kindred HumanKin = new Kindred(name: "Human", code: "H").save()
//Kindred ElvenKin = new Kindred(name: "Elven", code: "E").save()
//Kindred ThalariKin = new Kindred(name: "Thalari", code: "T").save()
//Kindred GornyaKin = new Kindred(name: "Gornya", code: "G").save()
//Kindred MixedKin = new Kindred(name: "Mixed", code: "X").save()

class Kindred {
    String name = "Name"
    String code = "Code"
    String label = "Label"
    String description = "Description"
    String notes = "Notes"

    Integer ageOfMajority = 18
    Integer averageCouth = 6
    Integer averageFerocity = 6
    Integer averagerInteligence = 6
    Integer averageLifespan = 6
    Integer averageeLoyalty = 6

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
        averageCouth nullable: false
        averageFerocity nullable: false
        averagerInteligence  nullable: false
        averageLifespan nullable: false
        averageeLoyalty nullable: false

        // isAmphibian nullable: false
        // isFlyer nullable: false
        // isArmored nullable: false
        // isVacumeProtected nullable: false

        isSecret nullable: false
    }
}