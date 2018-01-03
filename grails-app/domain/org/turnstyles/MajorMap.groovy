package org.turnstyles

class MajorMap {

    String name;
    String code;
    String description = "";
    Integer x = 0;
    Integer y = 0;
    Integer height = 1600;
    Integer width = 2400;
    String bg;
    boolean isSecret = false;

    static hasMany = [regions: Region];

    String toString() {"$name"}

    static graphql = true

    static constraints = {
        name blank: false
        code blank: false
        description blank: false
        x blank: false
        y blank: false
        height blank: false
        width blank: false
        bg nullable: true
        isSecret nullable: false
    }
}
