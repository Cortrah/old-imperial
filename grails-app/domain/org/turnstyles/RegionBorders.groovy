package org.turnstyles

class RegionBorders {
    String name = "Source:Sink"
    String code = "S:S"
    Region source
    BorderType borderType
    Region sink
    String toString() {"$name"}

    boolean isSecret = false;
    // ToDo: calculate isHostile

    static graphql = true
    static constraints = {
        name blank: false
        code blank: false
        source nullable: false
        borderType nullable: false
        sink nullable: false
        isSecret nullable: false
    }
    def seedContext (servletContext) {
        //servletContext.r =
        //RegionBorders border1 = new RegionBorders(
        //        name: "Komolek:Korev", code: "Kom:Kor",
        //        source:KomRegion1, sink:KomRegion2, borderType: adjBorder).save()
        //
        //RegionBorders border2 = new RegionBorders(
        //        name: "Komolek_Korev", code: "Kom_Kor",
        //        source:KomRegion1, sink:KomRegion2, borderType: roadBorder).save()
        //
        //RegionBorders border3 = new RegionBorders(
        //        name: "Korev:Colledhu", code: "Kor:Col",
        //        source:KomRegion2, sink:KomRegion3, borderType: adjBorder).save()
        //
        //RegionBorders border4 = new RegionBorders(
        //        name: "Korev_Col", code: "Kor_Col",
        //        source:KomRegion2, sink:KomRegion3, borderType: roadBorder).save()
        //
        //RegionBorders border5 = new RegionBorders(
        //        name: "Colledhu-M-Namdynn", code: "Col-M-Nam",
        //        source:KomRegion3, sink:KomRegion4, borderType: majMtnBorder).save()
    }
}
