package org.turnstyles

// ToDo: at some point add areas as groups of regions
// ToDo: add costs and products as well as others below (plague, corruption, ice)
// Don't bother with secondTributor, Provinces, or minormap and it's quadrant yet

class Region {
    String name = "Name"
    String code = "Code"
    String label = "Label"
    String description = ""
    String tooltip = ""
    String notes = ""
    String toString() {"$name"}

    Turn turn
    Realm realm
    AllegianceType allegiance
    Kindred kindred
    TerrainType terrain

    // Religion
    // PlagueStatus
    // CorruptionStatus
    // Other Status?

    // Features
    // Constructs

    Double gp = 0.0
    Double ap = 0.0
    Double nfp = 0.0
    Double mana = 0.0
    Double pwb = 0.0
    Double tv = 0.0

    Boolean hasRoad = false
    Boolean isSecret = false
    Boolean bordersVolcano = false
    Boolean isInimical = false

    Integer resistance = 3

    Integer x = 0
    Integer y = 0
    Integer w = 100
    Integer h = 100
    Integer cX = 50
    Integer cY = 50
    String pathId = ""
    String pathData = "m0,0 L100,0 L100,100 L0,100 z"

    static belongsTo = [majorMap: MajorMap]
    static hasMany = [locations: Location, borders: RegionBorders]

    static graphql = true
    static constraints = {
        name blank: false
        code blank: false
        label blank: false
        tooltip blank: true
        description blank: true
        notes blank: true

        kindred nullable : true
        terrain nullable: true
        isSecret nullable: false

        turn nullable: false
        realm nullable: true
        hasRoad nullable: false
        isSecret nullable: false
        isInimical nullable: false
        bordersVolcano nullable: false

        gp()
        ap()
        nfp()
        mana()
        pwb()
        tv()

        resistance range: 1..10

        x()
        y()
        w()
        h()
        cX()
        cY()
        pathId()
        pathData()
    }
}

