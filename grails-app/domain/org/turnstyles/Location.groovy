package org.turnstyles

//Location komLoc1 = new Location(name: "County of Komolek", code: "Kom", label: "Kommolek", region: KomRegion1).save()
//Location komLoc2 = new Location(name: "City II of Treskaw", code: "Tres", label: "Treskaw", region: KomRegion1).save()
//
//Location komLoc3 = new Location(name: "County of Korev", code: "Kor", label: "Korev", region: KomRegion2).save()
//Location komLoc4 = new Location(name: "City I of Kedhlow", code: "Ked", label: "Kedhlow", region: KomRegion2).save()
//
//Location komLoc5 = new Location(name: "County of Colledhu", code: "Col", label: "Colledhu", region: KomRegion3).save()
//Location komLoc6 = new Location(name: "Military Academy of Bituveco", code: "Bit", label: "Bituveco", region: KomRegion3).save()
//
//Location komLoc7 = new Location(name: "County of Namdynn", code: "Nam", label: "Namdynn", region: KomRegion4).save()

class Location {

    String name = "Region:Co"
    String code = "Co"
    String label = "county"
    String toString() {"$code"}

    boolean isSecret = false;

    static belongsTo = [region :Region]
    static hasMany = [items :Item, unitTypeGroups :UnitTypeGroup, leaders :Leader]

    static graphql = true
    static constraints = {
        name blank: false
        code blank: false
        label blank: false

        region nullable: false
        isSecret nullable: false
    }
}
