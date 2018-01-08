package org.turnstyles

// ToDo: at some point add areas as groups of regions
// Don't bother with secondTributor, Provinces, or minormap and it's quadrant yet

class Region {
    String name = "RegionName"
    String code = "RegionCode"
    String label = "RegionLabel"
    String description = "default description"
    String notes = "notes"
    String toString() {"$name"}

    Kindred kindred
    TerrainType terrain

    boolean isSecret = false
    boolean bordersVolcano = false

    Integer x = 0
    Integer y = 0
    Integer w = 100
    Integer h = 100
    Integer cX = 50
    Integer cY = 50
    String path = "m0,0 L100,0 L100,100 L0,100 z"

    static belongsTo = [majorMap: MajorMap]
    static hasMany = [regionTurnStatuses: RegionTurnStatus]

    static graphql = true
    static constraints = {
        name blank: false
        code blank: false
        label blank: false
        description nullable: true
        notes blank: true

        kindred nullable : true
        terrainType nullable: true
        isSecret nullable: false
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
