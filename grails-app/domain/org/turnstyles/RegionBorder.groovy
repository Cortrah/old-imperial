package org.turnstyles

class RegionBorder {
    String name = "Source:Sink"
    String code = "S:S"

    BorderType borderType
    Region source
    Region sink
    String toString() {"$name"}

    boolean isSecret = false;

    // ToDo: calculate isHostile

    static graphql = true
    static constraints = {
        name blank: false
        code blank: false

        source nullable: false
        borderType nullable: false
        sink nullable: false

        isSecret nullable: false
    }
}
