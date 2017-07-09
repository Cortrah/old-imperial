package org.turnstyles

class Region {

    String name;
    String code;
    String description;

    String  notes;
    String  status;
    Integer resistance = 3;

    double x;
    double y;
    double w;
    double h;
    double cX;
    double cY;
    String path;

    boolean isSecret;
    boolean hasRoad;
    boolean bordersVolcano;

    Integer gp;
    Integer ap;
    Integer nfp;
    Integer mana;
    double  pwb;
    double  tv;

    static belongsTo = [majorMap: MajorMap];

    static constraints = {
        name blank: false
        code blank: false
        description blank: false

        notes blank: true
        status blank: false
        resistance range: 1..10

    }
}
