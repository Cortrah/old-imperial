package org.turnstyles

class RegionBorders {
    String name = "Source:Sink"
    String code = "S:S"
    Region source
    BorderType borderType
    Region sink
    String toString() {"$name"}

    boolean isSecret = false;
    // ToDo: calculate isHostile
    // might want to have this belong to a majorMap or the 2 regions?

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
