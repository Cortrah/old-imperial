package org.turnstyles

class Location {

    String name = "RegionName:Country";
    String code = "RegionCode:cty";
    String label = "country";
    String toString() {"$code"}

    boolean isSecret = false;

    static belongsTo = [region: Region];

    static graphql = true
    static constraints = {
        name blank: false
        code blank: false
        label blank: false

        region nullable: false
        isSecret nullable: false
    }
}
