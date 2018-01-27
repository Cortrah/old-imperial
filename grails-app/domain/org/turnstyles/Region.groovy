package org.turnstyles

// ToDo: at some point add areas as groups of regions
// Don't bother with secondTributor, Provinces, or minormap and it's quadrant yet

class Region {
    String name = "Name"
    String code = "Code"
    String label = "Label"
    String description = "default description"
    String notes = "notes"
    String toString() {"$name"}

    Turn turn
    Realm realm
    Region region
    AllegianceType allegiance
    Kindred kindred
    TerrainType terrain

    Double gp = 0.0
    Double ap = 0.0
    Double nfp = 0.0
    Double mana = 0.0
    Double pwb = 0.0
    Double tv = 0.0

    Integer resistance = 3

    boolean hasRoad = false
    boolean isSecret = false
    boolean bordersVolcano = false
    boolean isInimical = false

    Integer x = 0
    Integer y = 0
    Integer w = 100
    Integer h = 100
    Integer cX = 50
    Integer cY = 50
    String path = "m0,0 L100,0 L100,100 L0,100 z"

    static belongsTo = [majorMap: MajorMap]
    static hasMany = [locations: Location]

    static graphql = true
    static constraints = {
        name blank: false
        code blank: false
        label blank: false
        description blank: true
        notes blank: true

        kindred nullable : true
        terrain nullable: true
        isSecret nullable: false

        region nullable: false
        hasRoad nullable: false
        isSecret nullable: false
        isInimical nullable: false
        bordersVolcano()

        resistance range: 1..10

        gp()
        ap()
        nfp()
        mana()
        pwb()
        tv()

        x()
        y()
        w()
        h()
        cX()
        cY()
        path()
    }
}
