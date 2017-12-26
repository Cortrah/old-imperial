package org.turnstyles

class MajorMap {

    String name;
    String code;
    String description = "";
    Integer height = 1600;
    Integer width = 2400;
    String bg;

    static hasMany = [regions: Region];

    String toString() {"$name"}

    static graphql = true

    static constraints = {
        name blank: false
        code blank: false
        description blank: false
        height blank: false
        width blank: false
        bg nullable: true
    }
}
