package org.turnstyles

// ToDo: at some point add areas as groups of regions
// ToDo: add costs and products as well as others below (plague, corruption, ice)
// Don't bother with secondTributor, Provinces, or minormap and it's quadrant yet

//Region KomRegion1 = new Region(name: "Komolek", code: "Kom", label: "Komolek",
//        gp: 1, ap: 1, nfp: 1, mana: 4, pwb: 32, tv: 1, turn: Turn25,
//        realm: Kommolek, allegiance: Homeland,  bordersVolcano: false,
//        hasRoad: true, isSecret: false, isInimical: false, resistance: 2,
//        kindred: WenemetKin, terrain: Clear, majorMap: sahulMap).save()
//
//Region KomRegion2 = new Region(name: "Korev", code: "Kor", label: "Korev",
//        gp: 1, ap: 1, nfp: 1, mana: 4, pwb: 32, tv: 1, turn: Turn25,
//        hasRoad: true, isSecret: false, isInimical: false, resistance: 2,
//        realm:Kommolek, allegiance: Friendly, bordersVolcano: false,
//        kindred: SaurianKin, terrain: Clear, majorMap: sahulMap).save()
//
//Region KomRegion3 = new Region(name: "Colledhu", code: "Col", label: "Colledhu",
//        gp: 1, ap: 1, nfp: 1, mana: 4, pwb: 32, tv: 1, turn: Turn25,
//        hasRoad: true, isSecret: false, isInimical: false, resistance: 2,
//        realm:Kommolek, allegiance: Friendly, bordersVolcano: false,
//        kindred: WenemetKin, terrain: Hill, majorMap: sahulMap).save()
//
//Region KomRegion4 = new Region(name: "Namdynn", code: "Nam", label: "Namdynn",
//        gp: 1, ap: 1, nfp: 1, mana: 4, pwb: 32, tv: 1, turn: Turn25,
//        hasRoad: true, isSecret: false, isInimical: false, resistance: 2,
//        realm:Kommolek, allegiance: Friendly, bordersVolcano: false,
//        kindred: WenemetKin, terrain: Hill, majorMap: sahulMap).save()


class Region {
    String name = "Name"
    String code = "Code"
    String label = "Label"
    String description = ""
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
        path()
    }
}
