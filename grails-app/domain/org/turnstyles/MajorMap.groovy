package org.turnstyles

class MajorMap {

    String name;
    String code;
    String description;
    Integer height;
    Integer width;
    String bg;

    static hasMany = [regions: Region];

    static constraints = {
        name blank: false
        code blank: false
        description blank: false
        height blank: false
        width blank: false
        bg blank: false
    }
}
