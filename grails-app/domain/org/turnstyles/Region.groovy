package org.turnstyles

// ToDo: add Realm, kindred, many locations, and terrain
// ToDo: at some point add 'areas' as groups of regions
// Don't bother with secondTributor, Provinces, or minormap and it's quadrant yet

class Region {

    String name;
    String code;
    String label;
    String description = "default description";
    String  notes = "notes";

    boolean bordersVolcano;

    double x = 0;
    double y = 0;
    double w = 100;
    double h = 100;
    double cX = 50;
    double cY = 50;
    String path = "m0,0 L100,0 L100,100 L0,100 z";

    static belongsTo = [majorMap: MajorMap];
    static hasMany = [locations: Location];

    String toString() { "$name"}

    static graphql = true

    static constraints = {
        name blank: false
        code blank: false
        label blank: false
        description nullable: true
        notes blank: true

        bordersVolcano()

        x()
        y()
        w()
        h()
        cX()
        cY()
        path()
    }
}
