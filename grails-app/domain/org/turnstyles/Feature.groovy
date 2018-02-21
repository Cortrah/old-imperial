package org.turnstyles

// a region location like a construct but without the ability to build or upgrade it
// ToDo: may still have an effect like the ability to train special troop types (e.g. gryphon aerie)

class Feature {
    String name = "Name"
    String code = "Code"
    String label = "Label"
    String description = ""
    String notes = ""

    Integer x = 0
    Integer y = 0

    Boolean isSecret = true

    Realm realmsecret
    Region region
    Location location

    FeatureType featureType

    String toString() {"$name"}

    static graphql = true
    static constraints = {
        name blank: false
        code blank: false
        label blank: false
        description nullable: true
        notes nullable: true

        x nullable: true
        y nullable: true

        isSecret()

        realm nullable: true
        region nullable: true
        location nullable: true

        featureType nullable: true
    }
}
