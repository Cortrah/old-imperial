package org.turnstyles

class RegionTurnStatus {
    String name = "Region:1440-1445"
    String code = "Region:1"
    String notes = "Notes"
    String toString() {"$name"}

    String  status = "?";
    Integer resistance = 3;

    Realm realm;
    Region region;
    AllegianceType allegiance;
    TerrainType terrainType;

    Integer Gp = 0;
    Integer Ap = 0;
    Integer Nfp = 0;
    Integer Mana = 0;
    Integer Pwb = 0;
    Integer Tv = 0;

    Boolean hasRoad = false;
    Boolean isSecret = false;
    Boolean isInimical = false;

    static hasMany = [locations: Location];
    static belongsTo = [turn: Turn];

    static graphql = true
    static constraints = {
        name blank: false
        code blank: false
        notes blank: true

        realm nullable: true
        region nullable: false

        status inList: ['?','free', 'pacified', 'tributary', 'allied', 'friendly', 'homeland']
        resistance range: 1..10

        terrainType nullable: true // ToDo: init to clear terrain

    }
}
