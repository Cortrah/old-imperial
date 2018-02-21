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

import org.turnstyles.TrainingType
import org.turnstyles.AgentType
import org.turnstyles.LeaderActionType

import org.turnstyles.Religion

class BootStrap {

    def init = { servletContext ->

        Religion yagnarist = new Religion(name: "Yagnar: the Cleansing Storm", code: "Y", label: "Yagnar", description: "description").save();
        Religion illuvarian = new Religion(name: "Illuvar: Justice and Light", code: "I", label: "Illuvar", description: "description").save();
        Religion tarotist = new Religion(name: "Lords of the Tarot: Fate and Fortune", code: "T", label: "Tarot", description: "description").save();
        Religion urdan = new Religion(name: "Urda: The Earth Mother", code: "U", label: "Urda", description: "description").save();

        LeaderActionType move = new LeaderActionType(name: "Movement", code: "Mv", description: "").save();
        LeaderActionType combat = new LeaderActionType(name: "Combat", code: "Cbt", description: "").save();
        LeaderActionType intel = new LeaderActionType(name: "Inteligence", code: "Int", description: "").save();
        LeaderActionType diplo = new LeaderActionType(name: "Diplomacy", code: "Di", description: "").save();
        LeaderActionType exchange = new LeaderActionType(name: "Transfer", code: "Tr", description: "").save();
        LeaderActionType magic = new LeaderActionType(name: "Magic", code: "Ma", description: "").save();
        LeaderActionType custom = new LeaderActionType(name: "Custom", code: "XX", description: "").save();

        TrainingType gn = new TrainingType(name: "General", code: "Gn", description: "").save();
        TrainingType wz = new TrainingType(name: "Wizard", code: "Wz", description: "").save();
        TrainingType sc = new TrainingType(name: "Scholar", code: "Sc", description: "").save();
        TrainingType li = new TrainingType(name: "Lich", code: "li", description: "").save();
        TrainingType ad = new TrainingType(name: "Admiral", code: "Ad", description: "").save();
        TrainingType am = new TrainingType(name: "Air Marshal", code: "AM", description: "").save();
        TrainingType sp = new TrainingType(name: "Spy", code: "Spy", description: "").save();
        TrainingType al = new TrainingType(name: "Alchemist", code: "Al", description: "").save();
        TrainingType hi = new TrainingType(name: "Historian", code: "Hi", description: "").save();
        TrainingType mm = new TrainingType(name: "Cartographer", code: "MM", description: "Map Maker").save();
        TrainingType eg = new TrainingType(name: "Diplomat", code: "Di", description: "Diplomatic Envoy").save();
        TrainingType ju = new TrainingType(name: "Jurist", code: "Ju", description: "").save();
        TrainingType en = new TrainingType(name: "Engineer", code: "En", description: "").save();
        TrainingType md = new TrainingType(name: "Doctor", code: "MD", description: "").save();
        TrainingType na = new TrainingType(name: "Navigator", code: "Na", description: "").save();
        TrainingType th = new TrainingType(name: "Theologian", code: "Th", description: "").save();
        TrainingType vp = new TrainingType(name: "Vampire", code: "Vp", description: "").save();

        AgentType F = new AgentType(name: "Friendly", code: "F", description: "").save();
        AgentType A = new AgentType(name: "Allied", code: "A", description: "").save();
        AgentType M = new AgentType(name: "Mercenary", code: "M", description: "").save();
        AgentType R = new AgentType(name: "Ruler", code: "E", description: "").save();
        AgentType H = new AgentType(name: "Heir", code: "H", description: "").save();
        AgentType He = new AgentType(name: "Hero", code: "He", description: "").save();
        AgentType Th = new AgentType(name: "Thrall", code: "Th", description: "").save();

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


        TerrainType UnkTerType = new TerrainType(name: "Unknown", code: "?", description: "A Mystery", landCost: null, airCost: null, navalCost: null).save()
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


        Realm Kommolek = new Realm(name: "Dutchy of Kommolek", code: "Kom", label: "Kommolek",
                game: FireAndIce, turn: Turn25).save()
        Herald Cortrah = new Herald(name: "Cortrah", code: "C", label: "Cort", realm: Kommolek).save()

        Realm EThace = new Realm(name: "Electoral County Palatine of Thace", code: "ETh", label: "E Thace",
                game: FireAndIce, turn: Turn25).save()
        Herald Kolgrim = new Herald(name: "Kolgrim", label: "Gman", realm: EThace).save()

        MajorMap sahulMap = new MajorMap(name: "FireAndIce:Sahul", code: "Sah", label: "Sahul", game: FireAndIce,
                description: "The continent of Sahul is under the dubious leadership of an imperial structure called the second empire.",
                x: 0, y: 0, height: 1400, width: 2600, bg: "sahul.svg", isSecret: false).save()

        Region KomRegion1 = new Region(name: "Komolek", code: "Kom", label: "Komolek",
                gp: 1, ap: 1, nfp: 1, mana: 4, pwb: 32, tv: 1, turn: Turn25,
                realm: Kommolek, allegiance: Homeland,  bordersVolcano: false,
                hasRoad: true, isSecret: false, isInimical: false, resistance: 2,
                kindred: WenemetKin, terrain: Clear, majorMap: sahulMap).save()

        Region KomRegion2 = new Region(name: "Korev", code: "Kor", label: "Korev",
                gp: 1, ap: 1, nfp: 1, mana: 4, pwb: 32, tv: 1, turn: Turn25,
                hasRoad: true, isSecret: false, isInimical: false, resistance: 2,
                realm:Kommolek, allegiance: Friendly, bordersVolcano: false,
                kindred: SaurianKin, terrain: Clear, majorMap: sahulMap).save()

        Region KomRegion3 = new Region(name: "Colledhu", code: "Col", label: "Colledhu",
                gp: 1, ap: 1, nfp: 1, mana: 4, pwb: 32, tv: 1, turn: Turn25,
                hasRoad: true, isSecret: false, isInimical: false, resistance: 2,
                realm:Kommolek, allegiance: Friendly, bordersVolcano: false,
                kindred: WenemetKin, terrain: Hill, majorMap: sahulMap).save()

        Region KomRegion4 = new Region(name: "Namdynn", code: "Nam", label: "Namdynn",
                gp: 1, ap: 1, nfp: 1, mana: 4, pwb: 32, tv: 1, turn: Turn25,
                hasRoad: true, isSecret: false, isInimical: false, resistance: 2,
                realm:Kommolek, allegiance: Friendly, bordersVolcano: false,
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


        Turn25.addToMajorMaps(sahulMap).save()
        FireAndIce.currentTurn = Turn25

    }

    def destroy = {
    }
}
