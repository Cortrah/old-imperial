package org.turnstyles

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

    Boolean isAmphibian = false
    Boolean isFlyer = false
    Boolean isArmored = false
    Boolean isVacumeProtected = false
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

        isAmphibian nullable: false
        isFlyer nullable: false
        isArmored nullable: false
        isVacumeProtected nullable: false
        isSecret nullable: false
    }
}