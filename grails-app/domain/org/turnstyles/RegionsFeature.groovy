package org.turnstyles

class RegionsFeature {

    String name = "Name"
    String code = "Code"
    String description = ""

    Region region
    Location location
    FeatureType featureType

    Integer x = 0
    Integer y = 0

    Boolean isSecret = false

    String toString() {"$name"}

    static graphql = true
    static constraints = {
        name blank: false
        code blank: false
        description nullable: true
        x()
        y()
        isSecret()
    }

}
