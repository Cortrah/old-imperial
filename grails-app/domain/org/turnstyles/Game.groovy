package org.turnstyles

import org.turnstyles.Realm
import org.turnstyles.Herald
import org.turnstyles.Turn
import org.turnstyles.MajorMap

class Game {
    String name = "GameName"
    String code = "GameCode"
    String label = "GameLabel"
    String notes = "Notes"
    String status = "Staging"

    Turn currentTurn
    static hasMany = [turns: Turn]

    String toString() {"$name"}

    static graphql = true
    static constraints = {
        name blank: false
        code blank: false
        label blank: false
        status inList: ["Staging", "Ploting", "Processing", "Concluded"]

        currentTurn nullable: true

        notes blank: true
    }

    def seedContext (servletContext) {
        servletContext.FireAndIce = new Game(name: "Of Fire and Ice", code: "Fie", label: "Fire Ice").save()

        // heralds belong to realms, realms belong to turns and turns belong to games so we initialize them here
        servletContext.Turn25 = new Turn(name: "1540-1545", number: 25, startingYear: 1571, endingYear: 1575,
                game: servletContext.FireAndIce).save()

        servletContext.Kommolek = new Realm(name: "Dutchy of Kommolek", code: "Kom", label: "Kommolek",
                game: servletContext.FireAndIce, turn: servletContext.Turn25).save()
        servletContext.Cortrah = new org.turnstyles.Herald(name: "Cortrah", code: "C", label: "Cort",
                realm: servletContext.Kommolek).save()

        servletContext.EThace = new Realm(name: "Electoral County Palatine of Thace", code: "ETh", label: "E Thace",
                game: servletContext.FireAndIce, turn: servletContext.Turn25).save()
        servletContext.Kolgrim = new Herald(name: "Kolgrim", label: "Gman",
                realm: servletContext.EThace).save()

        servletContext.sahulMap = new MajorMap(name: "FireAndIce: Imperial Sahul", code: "Sah", label: "Sahul", game: servletContext.FireAndIce,
                description: "The continent of Sahul is under the dubious leadership of an imperial structure called the second empire.",
                x: 0, y: 0, height: 1400, width: 2600, bg: "sahul.svg", isSecret: false).save()

        servletContext.KomRegion1 = new Region(name: "Komolek", code: "Kom", label: "Komolek",
                gp: 1, ap: 1, nfp: 1, mana: 4, pwb: 32, tv: 1, turn: servletContext.Turn25,
                realm: servletContext.Kommolek, allegiance: servletContext.Homeland,  bordersVolcano: false,
                hasRoad: true, isSecret: false, isInimical: false, resistance: 2,
                kindred: servletContext.WenemetKin, terrain: servletContext.Clear, majorMap: servletContext.sahulMap).save()

        servletContext.KomRegion2 = new Region(name: "Korev", code: "Kor", label: "Korev",
                gp: 1, ap: 1, nfp: 1, mana: 4, pwb: 32, tv: 1, turn: servletContext.Turn25,
                hasRoad: true, isSecret: false, isInimical: false, resistance: 2,
                realm:servletContext.Kommolek, allegiance: servletContext.Friendly, bordersVolcano: false,
                kindred: servletContext.SaurianKin, terrain: servletContext.Clear, majorMap: servletContext.sahulMap).save()

        servletContext.KomRegion3 = new Region(name: "Colledhu", code: "Col", label: "Colledhu",
                gp: 1, ap: 1, nfp: 1, mana: 4, pwb: 32, tv: 1, turn: servletContext.Turn25,
                hasRoad: true, isSecret: false, isInimical: false, resistance: 2,
                realm:servletContext.Kommolek, allegiance: servletContext.Friendly, bordersVolcano: false,
                kindred: servletContext.WenemetKin, terrain: servletContext.Hill, majorMap: servletContext.sahulMap).save()

        servletContext.KomRegion4 = new Region(name: "Namdynn", code: "Nam", label: "Namdynn",
                gp: 1, ap: 1, nfp: 1, mana: 4, pwb: 32, tv: 1, turn: servletContext.Turn25,
                hasRoad: true, isSecret: false, isInimical: false, resistance: 2,
                realm:servletContext.Kommolek, allegiance: servletContext.Friendly, bordersVolcano: false,
                kindred: servletContext.WenemetKin, terrain: servletContext.Hill, majorMap: servletContext.sahulMap).save()

        servletContext.komLoc1 = new Location(name: "County of Komolek", code: "Kom", label: "Kommolek", region: servletContext.KomRegion1).save()
        servletContext.komLoc2 = new Location(name: "City II of Treskaw", code: "Tres", label: "Treskaw", region: servletContext.KomRegion1).save()
        servletContext.komLoc3 = new Location(name: "County of Korev", code: "Kor", label: "Korev", region: servletContext.KomRegion2).save()
        servletContext.komLoc4 = new Location(name: "City I of Kedhlow", code: "Ked", label: "Kedhlow", region: servletContext.KomRegion2).save()
        servletContext.komLoc5 = new Location(name: "County of Colledhu", code: "Col", label: "Colledhu", region: servletContext.KomRegion3).save()
        servletContext.komLoc6 = new Location(name: "Military Academy of Bituveco", code: "Bit", label: "Bituveco", region: servletContext.KomRegion3).save()
        servletContext.komLoc7 = new Location(name: "County of Namdynn", code: "Nam", label: "Namdynn", region: servletContext.KomRegion4).save()

        servletContext.border1 = new RegionBorders(
                name: "Komolek:Korev", code: "Kom:Kor",
                source:servletContext.KomRegion1, sink:servletContext.KomRegion2, borderType: servletContext.adjBorder).save()

        servletContext.border2 = new RegionBorders(
                name: "Komolek_Korev", code: "Kom_Kor",
                source:servletContext.KomRegion1, sink:servletContext.KomRegion2, borderType: servletContext.roadBorder).save()

        servletContext.border3 = new RegionBorders(
                name: "Korev:Colledhu", code: "Kor:Col",
                source:servletContext.KomRegion2, sink:servletContext.KomRegion3, borderType: servletContext.adjBorder).save()

        servletContext.border4 = new RegionBorders(
                name: "Korev_Col", code: "Kor_Col",
                source:servletContext.KomRegion2, sink:servletContext.KomRegion3, borderType: servletContext.roadBorder).save()

        servletContext.border5 = new RegionBorders(
                name: "Colledhu-M-Namdynn", code: "Col-M-Nam",
                source:servletContext.KomRegion3, sink:servletContext.KomRegion4, borderType: servletContext.majMtnBorder).save()

        servletContext.FireAndIce.currentTurn = servletContext.Turn25
    }
}
