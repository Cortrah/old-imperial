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
    String  status = "?";
    Integer resistance = 3;

    double x = 0;
    double y = 0;
    double w = 100;
    double h = 100;
    double cX = 50;
    double cY = 50;
    String path = "m0,0 L100,0 L100,100 L0,100 z";

    boolean isSecret;
    boolean hasRoad;
    boolean bordersVolcano;
    boolean isInimical;

    Integer gp = 1;
    Integer ap = 1;
    Integer nfp = 1;
    Integer mana = 1;
    double  pwb = 1.0;
    double  tv = 1.0;

    static belongsTo = [majorMap: MajorMap];
    static hasMany = [locations: Location];
    TerrainType terrainType;

    String toString() { "$name"}

    static graphql = true

    static constraints = {
        name blank: false
        code blank: false
        label blank: false
        description nullable: true
        terrainType nullable: true // ToDo: init to clear terrain

        notes blank: true
        status inList: ['?','free', 'pacified', 'tributary', 'allied', 'friendly', 'homeland']
        resistance range: 1..10

        gp()
        ap()
        nfp()
        mana()
        pwb()
        tv()

        isSecret()
        hasRoad()
        bordersVolcano()
        isInimical()

        x()
        y()
        w()
        h()
        cX()
        cY()
        path()
    }
}
