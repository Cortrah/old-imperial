package org.turnstyles



class Location {

    String name = "Region:Co"
    String code = "Co"
    String label = "county"
    String toString() {"$code"}

    boolean isSecret = false;

    static belongsTo = [region: Region]

    static graphql = true
    static constraints = {
        name blank: false
        code blank: false
        label blank: false

        region nullable: false
        isSecret nullable: false
    }
}
