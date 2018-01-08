package org.turnstyles

class RegionBorders {

    String name;
    Region source;
    BorderType borderType;
    Region sink;
    String toString() {"$name"}

    boolean isSecret = false;
    // ToDo: calculate isHostile

    static graphql = true
    static constraints = {
        name blank: false
        source nullable: false
        borderType nullable: false
        sink nullable: false
        isSecret nullable: false
    }
}
