package old.imperial

import org.turnstyles.AllegianceType
import org.turnstyles.BorderType
import org.turnstyles.Game
import org.turnstyles.Herald
import org.turnstyles.Kindred
import org.turnstyles.MovementEffect
import org.turnstyles.MovementRule
import org.turnstyles.MovementType
import org.turnstyles.TerrainType

import org.turnstyles.Turn
import org.turnstyles.Realm
import org.turnstyles.MajorMap
import org.turnstyles.Region
import org.turnstyles.Location
import org.turnstyles.RegionBorders

import org.turnstyles.RealmTurn
import org.turnstyles.RegionTurnStatus

class BootStrap {

    def init = { servletContext ->
        AllegianceType Unknown = new AllegianceType(name: "Unknown", code: "?").save()
        AllegianceType Homeland = new AllegianceType(name: "Homeland", code: "H").save()
        AllegianceType Friendly = new AllegianceType(name: "Friendly", code: "F").save()
        AllegianceType Pacified = new AllegianceType(name: "Pacified", code: "P").save()
        AllegianceType Allied = new AllegianceType(name: "Allied", code: "A").save()
        AllegianceType Tributary = new AllegianceType(name: "Tributary", code: "T").save()
        AllegianceType Hostile = new AllegianceType(name: "Hostile", code: "Hs").save()
        AllegianceType AtWar = new AllegianceType(name: "At War", code: "Wr").save()
        AllegianceType Occupied = new AllegianceType(name: "Occupied", code: "O").save()
        AllegianceType Contested = new AllegianceType(name: "Contested", code: "C").save()

        BorderType unknownBorder = new BorderType(
                name: "Unknown", code: "?", description: "a mystery",
                landCost: 0, airCost: 0, navalCost:0, manaCost:0).save()
        BorderType adjBorder = new BorderType(
                name: "Adjacent", code: ":", description: "a default land border, easy to cross at no penalty",
                landCost: 0, airCost: 0, navalCost:0, manaCost:0).save()
        BorderType roadBorder = new BorderType(
                name: "Road", code: "_", description: "A Road",
                landCost: 0, airCost: 0, navalCost:0, manaCost:0).save()
        BorderType riverBorder = new BorderType(
                name: "River", code: "~", description: "",
                landCost: 0, airCost: 0, navalCost:0, manaCost:0).save()
        BorderType canalBorder = new BorderType(
                name: "Canal", code: "-~-", description: "",
                landCost: 0, airCost: 0, navalCost:0, manaCost:0).save()
        BorderType bridgeBorder = new BorderType(
                name: "Bridge", code: "=", description: "",
                landCost: 0, airCost: 0, navalCost:0, manaCost:0).save()
        BorderType minMtnBorder = new BorderType(
                name: "Minor Mountain", code: "-m-", description: "",
                landCost: 0, airCost: 0, navalCost:0, manaCost:0).save()
        BorderType majMtnBorder = new BorderType(
                name: "Major Mountain", code: "-M-", description: "",
                landCost: 0, airCost: 0, navalCost:0, manaCost:0).save()
        BorderType minMtnPassBorder = new BorderType(
                name: "Minor Mountain Pass", code: "_m_", description: "",
                landCost: 0, airCost: 0, navalCost:0, manaCost:0).save()
        BorderType majMtnPassBorder = new BorderType(
                name: "Major Mountain Pass", code: "_M_", description: "",
                landCost: 0, airCost: 0, navalCost:0, manaCost:0).save()
        BorderType greatWallBorder = new BorderType(
                name: "Great Wall", code: "|", description: "",
                landCost: 0, airCost: 0, navalCost:0, manaCost:0).save()
        BorderType tunnelBorder = new BorderType(
                name: "Tunnel", code: "-_-", description: "",
                landCost: 0, airCost: 0, navalCost:0, manaCost:0).save()
        BorderType blockedTunnelBorder = new BorderType(
                name: "Blocked Tunnel", code: "-x-", description: "",
                landCost: 0, airCost: 0, navalCost:0, manaCost:0).save()
        BorderType gateBorder = new BorderType(
                name: "Gate", code: "@", description: "",
                landCost: 0, airCost: 0, navalCost:0, manaCost:0).save()
        BorderType teleportationBorder = new BorderType(
                name: "Teleportation", code: "*", description: "",
                landCost: 0, airCost: 0, navalCost:0, manaCost:0).save()
        BorderType stairsBorder = new BorderType(
                name: "Stairs", code: "_-", description: "",
                landCost: 0, airCost: 0, navalCost:0, manaCost:0).save()
        BorderType cliffsBorder = new BorderType(
                name: "Cliffs", code: "||", description: "",
                landCost: 0, airCost: 0, navalCost:0, manaCost:0).save()
        BorderType currentBorder = new BorderType(
                name: "Current", code: "~/", description: "",
                landCost: 0, airCost: 0, navalCost:0, manaCost:0).save()
        BorderType monsoonCurrentBorder = new BorderType(
                name: "Monsoon Current", code: "~%", description: "",
                landCost: 0, airCost: 0, navalCost:0, manaCost:0).save()

        Kindred UnknownKin = new Kindred(name: "Unknown", code: "?").save()
        Kindred SaurianKin = new Kindred(name: "Saurian", code: "S").save()
        Kindred YaminionKin = new Kindred(name: "Yaminion", code: "Y").save()
        Kindred WenemetKin = new Kindred(name: "Wenemet", code: "W").save()
        Kindred MalebolgeKin = new Kindred(name: "Malebolge", code: "M").save()
        Kindred HumanKin = new Kindred(name: "Human", code: "H").save()
        Kindred ElvenKin = new Kindred(name: "Elven", code: "E").save()
        Kindred ThalariKin = new Kindred(name: "Thalari", code: "T").save()
        Kindred GornyaKin = new Kindred(name: "Gornya", code: "G").save()
        Kindred MixedKin = new Kindred(name: "Mixed", code: "X").save()

        MovementType unknownMv = new MovementType(
                name: "Unknown", code: "?", description: "a mystery").save()
        MovementType landMv = new MovementType(
                name: "Land", code: "L", description: "land movement").save()
        MovementType navalMv = new MovementType(
                name: "Naval", code: "N", description: "by ocean, river or canal").save()
        MovementType airMv = new MovementType(
                name: "Air", code: "A", description: "flying").save()
        MovementType celestialMv = new MovementType(
                name: "Celestial", code: "C", description: "flying high").save()
        MovementType subterainianMv = new MovementType(
                name: "Subteranian", code: "S", description: "underground").save()
        MovementType gateMv = new MovementType(
                name: "Gate", code: "G", description: "using a magical gate").save()
        MovementType teleportMv = new MovementType(
                name: "Teleportation", code: "T", description: "via the teleportation spell").save()
        MovementType allMv = new MovementType(
                name: "All", code: "*", description: "all movement types").save()

        MovementEffect adjLBCost = new MovementEffect(
                name: "Adjacent Land Border Cost", code: "adj", movementType: landMv,
                description: "The cost for moving across an adjacent land border",
                targetType: "cost", operator: "+", ammount:0).save()


        MovementRule movementRule = new MovementRule(
                name: "Adj L Border", code: "AdjLB", description: "Going into an adjacent land region",
                preconditions: "always", movementType: landMv, movementEffect: adjLBCost).save()


        TerrainType UnknownTerrainType = new TerrainType(name: "Unknown", code: "?", description: "A Mystery", landCost: null, airCost: null, navalCost: null).save()
        TerrainType Clear = new TerrainType(name: "Clear", code: "Cl", description: "Flat terrain", landCost: 1, airCost: 1, navalCost: null).save()
        TerrainType Desert = new TerrainType(name: "Desert", code: "De", landCost: 1, airCost: 1, navalCost: null).save()
        TerrainType Steppe = new TerrainType(name: "Steppe", code: "St", landCost: 1, airCost: 1, navalCost: null).save()
        TerrainType Island = new TerrainType(name: "Island", code: "Is", landCost: 1, airCost: 1, navalCost: null).save()
        TerrainType Forest = new TerrainType(name: "Forest", code: "Fo", landCost: 1, airCost: 1, navalCost: null).save()
        TerrainType Hill = new TerrainType(name: "Hill", code: "Hi", landCost: 1, airCost: 1, navalCost: null).save()
        TerrainType Mountain = new TerrainType(name: "Mountain", code: "Mt", landCost: 1, airCost: 1, navalCost: null).save()
        TerrainType Sea = new TerrainType(name: "Sea", code: "Sea", landCost: 0, airCost: 1, navalCost: 1).save()
        TerrainType UnderSea = new TerrainType(name: "UnderSea", code: "UnS", landCost: 0, airCost: 0, navalCost: 1).save()
        TerrainType Lake = new TerrainType(name: "Lake", code: "Lk", landCost: 0, airCost: 1, navalCost: 1).save()
        TerrainType Swamp = new TerrainType(name: "Swamp", code: "Sw", landCost: 1, airCost: 1, navalCost: null).save()
        TerrainType Jungle = new TerrainType(name: "Jungle", code: "J", landCost: 1, airCost: 1, navalCost: null).save()
        TerrainType River = new TerrainType(name: "River", code: "Ri", landCost: 0, airCost: 1, navalCost: 1).save()
        TerrainType Canal = new TerrainType(name: "Canal", code: "Ca", landCost: 0, airCost: 1, navalCost: 1).save()
        TerrainType RoughSeas = new TerrainType(name: "RoughSeas", code: "RS", landCost: 0, airCost: 0, navalCost: 1).save()
        TerrainType Cavern = new TerrainType(name: "Cavern", code: "Cv", landCost: 1, airCost: 1, navalCost: null).save()
        TerrainType Digging = new TerrainType(name: "Digging", code: "Di", landCost: 1, airCost: 1, navalCost: null).save()

        Game FireAndIce = new Game(name: "Of Fire and Ice", code: "Fie", label: "Fire Ice").save()
        Turn Turn25 = new Turn(name: "1540-1545", number: 25, startingYear: 1571, endingYear: 1575, game: FireAndIce).save()

        Herald Cortrah = new Herald(name: "Cortrah", code: "C", label: "Cort").save()
        Realm Kommolek = new Realm(name: "Dutchy of Kommolek", code: "Kom", label: "Kommolek",
                game: FireAndIce, herald: Cortrah).save()

        Herald Kolgrim = new Herald(name: "Kolgrim", label: "Gman").save()
        Realm DThace = new Realm(name: "Electoral County Palatine of Thace", code: "ETh", label: "E Thace",
                game: FireAndIce, herald: Kolgrim).save()

        MajorMap sahulMap = new MajorMap(name: "FireAndIce:Sahul", code: "Sah", label: "Sahul", game: FireAndIce,
                description: "The continent of Sahul is under the dubious leadership of an imperial structure called the second empire.",
                x: 0, y: 0, height: 1400, width: 2600, bg: "sahul.svg", isSecret: false).save()

        Region KomRegion1 = new Region(name: "Komolek", code: "Kom", label: "Komolek",
                kindred: WenemetKin, terrain: Clear, majorMap: sahulMap).save()

        Region KomRegion2 = new Region(name: "Korev", code: "Kor", label: "Korev",
                kindred: SaurianKin, terrain: Clear, majorMap: sahulMap).save()

        Region KomRegion3 = new Region(name: "Colledhu", code: "Col", label: "Colledhu",
                kindred: WenemetKin, terrain: Hill, majorMap: sahulMap).save()

        Region KomRegion4 = new Region(name: "Namdynn", code: "Nam", label: "Namdynn",
                kindred: WenemetKin, terrain: Hill, majorMap: sahulMap).save()


        Location komLoc1 = new Location(name: "County of Komolek", code: "Kom", label: "Kommolek", region: KomRegion1).save()
        Location komLoc2 = new Location(name: "City II of Treskaw", code: "Tres", label: "Treskaw", region: KomRegion1).save()

        Location komLoc3 = new Location(name: "County of Korev", code: "Kor", label: "Korev", region: KomRegion2).save()
        Location komLoc4 = new Location(name: "City I of Kedhlow", code: "Ked", label: "Kedhlow", region: KomRegion2).save()

        Location komLoc5 = new Location(name: "County of Colledhu", code: "Col", label: "Colledhu", region: KomRegion3).save()
        Location komLoc6 = new Location(name: "Military Academy of Bituveco", code: "Bit", label: "Bituveco", region: KomRegion3).save()

        Location komLoc7 = new Location(name: "County of Namdynn", code: "Nam", label: "Namdynn", region: KomRegion4).save()

        RegionBorders border1 = new RegionBorders(
                name: "Komolek:Korev", code: "Kom:Kor",
                source:KomRegion1, sink:KomRegion2, borderType: adjBorder).save()

        RegionBorders border2 = new RegionBorders(
                name: "Komolek_Korev", code: "Kom_Kor",
                source:KomRegion1, sink:KomRegion2, borderType: roadBorder).save()

        RegionBorders border3 = new RegionBorders(
                name: "Korev:Colledhu", code: "Kor:Col",
                source:KomRegion2, sink:KomRegion3, borderType: adjBorder).save()

        RegionBorders border4 = new RegionBorders(
                name: "Korev_Col", code: "Kor_Col",
                source:KomRegion2, sink:KomRegion3, borderType: roadBorder).save()

        RegionBorders border5 = new RegionBorders(
                name: "Colledhu-M-Namdynn", code: "Col-M-Nam",
                source:KomRegion3, sink:KomRegion4, borderType: majMtnBorder).save()


        RealmTurn KomTurn25 = new RealmTurn(name: "Komolek Turn25", code: "Kom:1", notes: "not much",
                realm: Kommolek, turn: Turn25)
                .save()

        RegionTurnStatus kom25 = new RegionTurnStatus(
                name: "Komolek:1540-1545", code: "Kom:25", "notes": "notie noteular",
                gp: 1, ap: 1, nfp: 1, mana: 4, pwb: 32, tv: 1,
                hasRoad: true, isSecret: false, isInimical: false, resistance: 2,
                realm: Kommolek, region: KomRegion1, allegiance: Homeland)
                .save()

        RegionTurnStatus kor25 = new RegionTurnStatus(
                name: "Korev:1540-1545", code: "Kor:25", "notes": "notie noteular",
                gp: 1, ap: 1, nfp: 1, mana: 4, pwb: 32, tv: 1,
                hasRoad: true, isSecret: false, isInimical: false, resistance: 2,
                realm:Kommolek, region: KomRegion2, allegiance: Friendly)
                .save()

        RegionTurnStatus col25 = new RegionTurnStatus(
                name: "Colledhu:1540-1545", code: "Col:25", "notes": "notie noteular",
                gp: 1, ap: 1, nfp: 1, mana: 4, pwb: 32, tv: 1,
                hasRoad: true, isSecret: false, isInimical: false, resistance: 2,
                realm:Kommolek, region: KomRegion3, allegiance: Friendly)
                .save()

        RegionTurnStatus Nam25 = new RegionTurnStatus(
                name: "Namdynn:1540-1545", code: "Nam:25", "notes": "notie noteular",
                gp: 1, ap: 1, nfp: 1, mana: 4, pwb: 32, tv: 1,
                hasRoad: true, isSecret: false, isInimical: false, resistance: 2,
                realm:Kommolek, region: KomRegion4, allegiance: Friendly)
                .save()


        // Add Leaders
        // Leader Actions esp Movement
        //


        // Possibly merge Region and Realm TurnStatuses back into the main class to simplify them

        FireAndIce.currentTurn = Turn25
    }

    def destroy = {
    }
}
