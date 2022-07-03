package org.turnstyles

class Game {
    String name = "GameName"
    String code = "GameCode"
    String label = "GameLabel"
    String description = "A Mysterious Game"
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
        description blank: false
        status inList: ["Staging", "Plotting", "Processing", "Concluded"]

        currentTurn nullable: true

        notes blank: true
    }

    def seedContext (servletContext) {
        servletContext.FireAndIce = new Game(
                name: "Of Fire and Ice",
                code: "Fie",
                label: "Fire Ice",
                description: "The prototypical game of Cruenti Dei").save()

        // heralds belong to realms, realms belong to turns and turns belong to games so we initialize them here
        servletContext.Turn25 = new Turn(
                name: "1540-1545",
                number: 25,
                startingYear: 1571,
                endingYear: 1575,
                game: servletContext.FireAndIce).save()

        servletContext.Tokatl = new Realm(
                name: "Principality of Tokatl",
                code: "tok",
                label: "Tokatl",
                game: servletContext.FireAndIce,
                turn: servletContext.Turn25).save()
        servletContext.Skipperway = new Herald(
                name: "Skipperway",
                label: "Shelly",
                img: "chitixi.jpg",
                realm: servletContext.Tokatl).save()

        servletContext.sahulMap = new MajorMap(
                name: "FireAndIce: Imperial Sahul",
                code: "Sah",
                label: "Sahul",
                turn: servletContext.Turn25,
                description: "The continent of Sahul is under the dubious leadership of an imperial structure called the second empire.",
                x: 0, y: 0,
                height: 1400, width: 2600,
                bg: "sahul.svg", isSecret: false).save()

        servletContext.TokRegion1 = new Region(
                name: "Takohn",
                code: "Tak",
                label: "Takohn",
                gp: 4, ap: 3, nfp: 3, mana: 1, pwb: 32, tv: 1,
                turn: servletContext.Turn25,
                realm: servletContext.Tokatl, allegiance: servletContext.Homeland,  bordersVolcano: false,
                hasRoad: false, isSecret: false, isInimical: false, resistance: 2,
                kindred: servletContext.WenemetKin,
                pathId: "_x38_",
                pathData: "M704.271,249.39c2.066,2.598,3.596,5.747,6.503,7.513c5.604-0.062,11.917,0.58,15.505-1.503                            c2.272,0.268,1.658,2.26,2.5,3.506c1.213,1.797,3.498,2.824,4.502,5.009c1.618,3.522-0.062,7.666,1,11.521                            c1.031,3.751,5.7,5.039,7.002,8.013c0.45,2.061-0.59,4.185,0,6.511c0.892,3.519,7.264,5.153,8.002,9.018                            c0.246,1.283-0.699,2.299-1,4.007c-0.757,4.303,0.168,7.935-2.5,10.521c-1.016,4.561,0.979,7.686,1.5,11.02                            c0.27,1.729-0.375,3.669,0,5.009c0.578,2.064,2.741,3.516,3,5.512c0.447,3.418-2.986,11.014-4.5,13.021                           c0.284,6.297-2.838,9.183-3.001,15.027c-4.927-0.758-7.486,0.851-9.003,3.506c-3,0-6.003,0-9.004,0                            c-3.742-2.287-2.574-6.918-4.001-10.519c-1.79-4.519-7.006-6.604-9.502-10.021c-1.501,0-3.002,0-4.502,0                        c-1.822-4.02-5.449-6.229-7.503-10.019c-10.562-0.777-13.388-9.311-22.014-12.021c-0.512-2.942-0.056-6.038-0.501-9.016                            c-0.182-1.224-1.141-2.841-1-4.007c0.483-3.997,5.247-5.35,3.502-12.523c9.288-6.894,17.938-14.427,24.016-24.544                           c-0.494-4.015,0.681-6.363,0-9.518c-0.729-3.356-3.53-4.55-3.501-7.012C699.816,253.563,703.552,254.01,704.271,249.39z",
                x: 640, y: 249, w: 75, h: 117, cX: 50, cY: 50,
                terrain: servletContext.Clear, majorMap: servletContext.sahulMap).save()

        servletContext.TokRegion2 = new Region(
                name: "Chakah",
                code: "Cha",
                label: "Chakah",
                gp: 1, ap: 1, nfp: 1, mana: 4, pwb: 32, tv: 1, turn: servletContext.Turn25,
                hasRoad: false, isSecret: false, isInimical: false, resistance: 2,
                realm:servletContext.Tokatl, allegiance: servletContext.Friendly, bordersVolcano: false,
                kindred: servletContext.SaurianKin,
                pathId: "_x35_0",
                pathData: "M704.771,348.067c0.823,0.84,2.937,0.399,4.502,0.502c2.563,2.646,7.281,4.498,9.004,8.519                            c0.815,1.933,0.222,4.481,1,6.51c1.001,2.608,2.537,3.743,4.501,5.509c4.43-0.588,7.42,0.824,10.503,0                            c3.143-0.837,4.938-5.836,9.002-3.003c-1.562,4.114-1.286,10.066-4,13.022c-2.398,6.015,2.938,9.748,3.001,13.521                        c0.073,4.458-5.47,8.132-7.003,12.021c-10.229,3.449-23.188,4.167-21.508,19.538c-14.069-1.569-17.344,7.681-25.514,12.02                          c-2.061-7.117-3.544-14.812-8.502-19.031c-0.637-2.196-1.312-4.354-2.501-6.014c0.661-6.34-1.686-9.666-5.002-12.021                            c0.044-9.531-11.85-17.778-18.506-8.02c-5.501,0.166-11.01,0.341-13.505-2.505c0.105-2.729-0.345-6.021,0.5-8.014                            c9.268-2.241,12.038-10.986,17.008-17.532c0.201-2.134-0.48-5.159,0.5-6.512c11.706,2.833,16.733-7.104,14.004-17.031                            c-0.854-3.104-4.547-4.437-6.002-6.51c2.242-3.436,5.037-6.312,8.003-9.02c0.671,0.33,0.938,1.071,1,2.003                            c8.854,2.826,11.812,11.551,22.515,12.523C699.47,342.358,703.114,344.217,704.771,348.067z",
                x: 676, y: 249, w: 75, h: 117, cX: 50, cY: 50,
                terrain: servletContext.Clear, majorMap: servletContext.sahulMap).save()

        servletContext.tokLoc1 = new Location(name: "Takohn:co", code: "Tak:co", label: "Takohn", region: servletContext.TokRegion1).save()
        servletContext.tokLoc2 = new Location(name: "County of Chakah", code: "Cha", label: "Chakah", region: servletContext.TokRegion2).save()
        servletContext.tokLoc3 = new Location(name: "Port of", code: "pt", label: "port", region: servletContext.TokRegion1).save()
        servletContext.tokLoc4 = new Location(name: "City of", code: "ct", label: "city", region: servletContext.TokRegion2).save()

        servletContext.SeaRegion1 = new Region(
                name: "Cape Sutrom",
                code: "C.Sut",
                label: "Cape Sutrom",
                gp: 1, ap: 1, nfp: 1, mana: 4, pwb: 32, tv: 1, turn: servletContext.Turn25,
                hasRoad: false, isSecret: false, isInimical: false, resistance: 2,
                realm:servletContext.Tokatl, allegiance: servletContext.Friendly, bordersVolcano: false,
                kindred: servletContext.WenemetKin,
                pathId: "_x35_0",
                pathData: "M704.771,348.067c0.823,0.84,2.937,0.399,4.502,0.502c2.563,2.646,7.281,4.498,9.004,8.519                            c0.815,1.933,0.222,4.481,1,6.51c1.001,2.608,2.537,3.743,4.501,5.509c4.43-0.588,7.42,0.824,10.503,0                            c3.143-0.837,4.938-5.836,9.002-3.003c-1.562,4.114-1.286,10.066-4,13.022c-2.398,6.015,2.938,9.748,3.001,13.521                        c0.073,4.458-5.47,8.132-7.003,12.021c-10.229,3.449-23.188,4.167-21.508,19.538c-14.069-1.569-17.344,7.681-25.514,12.02                          c-2.061-7.117-3.544-14.812-8.502-19.031c-0.637-2.196-1.312-4.354-2.501-6.014c0.661-6.34-1.686-9.666-5.002-12.021                            c0.044-9.531-11.85-17.778-18.506-8.02c-5.501,0.166-11.01,0.341-13.505-2.505c0.105-2.729-0.345-6.021,0.5-8.014                            c9.268-2.241,12.038-10.986,17.008-17.532c0.201-2.134-0.48-5.159,0.5-6.512c11.706,2.833,16.733-7.104,14.004-17.031                            c-0.854-3.104-4.547-4.437-6.002-6.51c2.242-3.436,5.037-6.312,8.003-9.02c0.671,0.33,0.938,1.071,1,2.003                            c8.854,2.826,11.812,11.551,22.515,12.523C699.47,342.358,703.114,344.217,704.771,348.067z",
                x: 312, y: 139, w: 592, h: 363, cX: 50, cY: 50,
                terrain: servletContext.Sea, majorMap: servletContext.sahulMap).save()

        servletContext.sealoc1 = new Location(
                name: "Cape Sutrom",
                code: "CSut",
                label: "Cape Sutrom",
                region: servletContext.SeaRegion1).save()

        servletContext.Kommolek = new Realm(name: "Dutchy of Kommolek", code: "Kom", label: "Kommolek",
                game: servletContext.FireAndIce, turn: servletContext.Turn25).save()
        servletContext.Cortrah = new org.turnstyles.Herald(name: "Cortrah", code: "C", label: "Cort",
                realm: servletContext.Kommolek).save()

        servletContext.EThace = new Realm(name: "Electoral County Palatine of Thace", code: "ETh", label: "E Thace",
                game: servletContext.FireAndIce, turn: servletContext.Turn25).save()
        servletContext.Kolgrim = new Herald(name: "Kolgrim", code: "G", label: "Gman",
                realm: servletContext.EThace).save()

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

        servletContext.komLoc1 = new Location(name: "County of Kommolek", code: "Kom", label: "Kommolek", region: servletContext.KomRegion1).save()
        servletContext.komLoc2 = new Location(name: "City II of Treskaw", code: "Tres", label: "Treskaw", region: servletContext.KomRegion1).save()
        servletContext.komLoc3 = new Location(name: "County of Korev", code: "Kor", label: "Korev", region: servletContext.KomRegion2).save()
        servletContext.komLoc4 = new Location(name: "City I of Kedhlow", code: "Ked", label: "Kedhlow", region: servletContext.KomRegion2).save()
        servletContext.komLoc5 = new Location(name: "County of Colledhu", code: "Col", label: "Colledhu", region: servletContext.KomRegion3).save()
        servletContext.komLoc6 = new Location(name: "Military Academy of Bituveco", code: "Bit", label: "Bituveco", region: servletContext.KomRegion3).save()
        servletContext.komLoc7 = new Location(name: "County of Namdynn", code: "Nam", label: "Namdynn", region: servletContext.KomRegion4).save()

        servletContext.border1 = new RegionBorder(
                name: "Komolek:Korev", code: "Kom:Kor",
                source:servletContext.KomRegion1, sink:servletContext.KomRegion2, borderType: servletContext.adjBorder).save()

        servletContext.border2 = new RegionBorder(
                name: "Komolek_Korev", code: "Kom_Kor",
                source:servletContext.KomRegion1, sink:servletContext.KomRegion2, borderType: servletContext.roadBorder).save()

        servletContext.border3 = new RegionBorder(
                name: "Korev:Colledhu", code: "Kor:Col",
                source:servletContext.KomRegion2, sink:servletContext.KomRegion3, borderType: servletContext.adjBorder).save()

        servletContext.border4 = new RegionBorder(
                name: "Korev_Col", code: "Kor_Col",
                source:servletContext.KomRegion2, sink:servletContext.KomRegion3, borderType: servletContext.roadBorder).save()

        servletContext.border5 = new RegionBorder(
                name: "Colledhu-M-Namdynn", code: "Col-M-Nam",
                source:servletContext.KomRegion3, sink:servletContext.KomRegion4, borderType: servletContext.majMtnBorder).save()

        servletContext.FireAndIce.currentTurn = servletContext.Turn25
    }
}
