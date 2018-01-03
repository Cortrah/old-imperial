package org.turnstyles

// ToDo: calculate isHostile

class RegionBorders {

    String name;
    Region source;
    BorderType borderType;
    Region sink;
    boolean isSecret = false;

    String toString() {"$name"}

    static graphql = true

    static constraints = {
        name blank: false
        source nullable: false
        borderType nullable: false
        sink nullable: false
        isSecret nullable: false
    }
}
