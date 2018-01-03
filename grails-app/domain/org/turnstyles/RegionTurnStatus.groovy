package org.turnstyles

class RegionTurnStatus {
    String name = "Region:1440-1445"
    String code = "Region:1"
    String notes = "Notes"

    String  status = "?";
    Integer resistance = 3;

    // Gp
    // Ap
    // Nfp
    // Mana
    // pwb
    // tv
    // hasRoad
    // isSecret
    // isInimical
    // Region
    // RealmTurn
    TerrainType terrainType;

    String toString() {"$name"}

    static graphql = true

    static constraints = {

        name blank: false
        code blank: false
        notes blank: true

        status inList: ['?','free', 'pacified', 'tributary', 'allied', 'friendly', 'homeland']
        resistance range: 1..10

        terrainType nullable: true // ToDo: init to clear terrain

    }
}
