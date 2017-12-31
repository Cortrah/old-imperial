package org.turnstyles

class Location {

    String name;

    boolean isSecret = false;

    static belongsTo = [region: Region];

    String toString() {"$name"}

    static graphql = true

    static constraints = {
        name blank: false
        region nullable: false
        isSecret nullable: false
    }
}
