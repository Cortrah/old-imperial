package org.turnstyles

class RegionTurnStatus {
    String name = "Region:1440-1445"
    String code = "Region:1"
    String notes = "Notes"
    String toString() {"$name"}

    Realm realm
    Region region
    AllegianceType allegiance

    Double gp = 0.0
    Double ap = 0.0
    Double nfp = 0.0
    Double mana = 0.0
    Double pwb = 0.0
    Double tv = 0.0

    Boolean hasRoad = false
    Boolean isSecret = false
    Boolean isInimical = false

    Integer resistance = 3

    static hasMany = [locations: Location]

    static graphql = true
    static constraints = {
        name blank: false
        code blank: false
        notes blank: true

        region nullable: false

        gp()
        ap()
        nfp()
        mana()
        pwb()
        tv()

        hasRoad nullable: false
        isSecret nullable: false
        isInimical nullable: false

        resistance range: 1..10
    }
}
