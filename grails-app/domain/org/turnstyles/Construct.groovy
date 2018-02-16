package org.turnstyles

class Construct {

    String name = "Name"
    String code = "Code"
    String label = "Label"
    String description = ""
    String notes = ""

    Integer level = 0

    Integer currentInvestment = 0

    Integer x = 0
    Integer y = 0

    Boolean isSecret = true

    Realm realm
    Region region
    Location location

    ConstructType constructType

    Integer providesGp = 0
    Integer providesAp = 0
    Integer providesNfp = 0
    Integer providesMana = 0

    Integer cityForts = 0

    String toString() {"$name"}

    static graphql = true
    static constraints = {
        name blank: false
        code blank: false
        label blank: false
        description nullable: true
        notes nullable: true

        level nullable: true
        currentInvestment nullable: true
        x nullable: true
        y nullable: true

        isSecret()

        realm nullable: true
        region nullable: true
        location nullable: true

        constructType nullable: true

        providesGp nullable: true
        providesAp nullable: true
        providesNfp nullable: true
        providesMana nullable: true

        cityForts nullable: true

    }
}