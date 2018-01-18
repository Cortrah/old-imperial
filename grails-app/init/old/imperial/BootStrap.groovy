package old.imperial

import org.turnstyles.TerrainType
import org.turnstyles.AllegianceType
import org.turnstyles.MovementType
import org.turnstyles.BorderType
import org.turnstyles.Kindred
import org.turnstyles.Game
import org.turnstyles.Herald
import org.turnstyles.Realm
import org.turnstyles.Turn
import org.turnstyles.Location
import org.turnstyles.RegionBorders
import org.turnstyles.Region
import org.turnstyles.MovementRule
import org.turnstyles.MovementEffect
import org.turnstyles.MajorMap

import org.turnstyles.RealmTurn
import org.turnstyles.RegionTurnStatus

class BootStrap {

    def init = { servletContext ->

        Game FireAndIce = new Game(name: "Of Fire and Ice", code: "Fie", label: "Fire Ice").save()
        Herald Cortrah = new Herald(name: "Cortrah", code: "C", label: "Cort").save()
        Herald Kolgrim = new Herald(name: "Kolgrim", label: "Gman").save()

        Realm Kommolek = new Realm(name: "Dutchy of Kommolek", code: "Kom", label: "Kommolek").save()

        RealmTurn KomTurn1 = new RealmTurn(name: "Komolek Turn1", code: "Kom:1",
                startingIsi: 193, startingTv: 42, endingIsi: 195, endingTv: 43,
                realm: Kommolek, turn: Turn1)
                .addToRegionTurnStatuses(kom1, bre1)
                .save()

        RegionTurnStatus kom1 = new RegionTurnStatus(name: "Komolek:1", code: "Kom:1", status: "homeland", resistance: 3, realm:Kommolek,
                region: KomRegion1, hasRoad: false, isSecret: false, isInimical: false, turn: Turn1)
                .addToLocations(komLoc1, komLoc2)
                .save()
        RegionTurnStatus bre1 = new RegionTurnStatus(name: "Bregil:1", code: "Bre:1", status: "friendly", resistance: 3, realm:Kommolek,
                region: KomRegion2, hasRoad: false, isSecret: false, isInimical: false, turn: Turn1)
                .addToLocations(komLoc3, komLoc4)
                .save()

        Turn Turn1 = new Turn(name: "1540-1545", number: "1", startingYear: 1540, endingYear: 1545).save()

        Region KomRegion1 = new Region(name: "Komolek", code: "Kom", label: "Komolek", kindred: WenemetKin, terrain: Forest ).save()
        Region KomRegion2 = new Region(name: "Bregil", code: "Bre", label: "Bregil", kindred: SaurianKin, terrain: Hill ).save()

        RegionBorders border1 = new RegionBorders(name: "Komolek:Bregil", code: "Kom:Bre", source:KomRegion1, sink:KomRegion2, borderType: adjBorder).save()

        Location komLoc1 = new Location(name: "Komolek:Cy", code: "Kom:Cy", region: KomRegion1).save()
        Location komLoc2 = new Location(name: "Komolek:Ct", code: "Kom:Ct", region: KomRegion1).save()
        Location komLoc3 = new Location(name: "Bregil:Cy", code: "Bre:Cy", region: KomRegion2).save()
        Location komLoc4 = new Location(name: "Bregil:Ct", code: "Bre:Ct", region: KomRegion2).save()

        MajorMap mainMap = new MajorMap(name: "FireAndIce:Sahul", code: "Sah", label: "Sahul",
                description: "The continent of Sahul is under the dubious leadership of an imperial structure called the second empire.",
                x: 0, y: 0, height: 1400, width: 2600, bg: "sahul.svg", isSecret: false)
                .addToRegions(KomRegion1, KomRegion2)
                .save()

        MovementEffect adjLBCost = new MovementEffect(
                name: "Adjacent Land Border Cost", code: "adj",
                description: "The cost for moving across an adjacent land border",
                targetType: "cost", operator: "+", ammount:0).save()

        MovementRule movementRule = new MovementRule(
                name: "Adj L Border", code: "AdjLB", description: "Going into an adjacent land region",
                preconditions: "always", movementType: landMv, movementEffect: adjLBCost).save()

        AllegianceType Unknown = new AllegianceType(name: "Unknown", code: "?").save()
        AllegianceType Homeland = new AllegianceType(name: "Homeland", code: "Ho").save()
        AllegianceType Friendly = new AllegianceType(name: "Friendly", code: "Fr").save()
        AllegianceType Pacified = new AllegianceType(name: "Pacified", code: "Ps").save()
        AllegianceType Allied = new AllegianceType(name: "Allied", code: "A").save()
        AllegianceType Tributary = new AllegianceType(name: "Tributary", code: "T").save()
        AllegianceType Hostile = new AllegianceType(name: "Hostile", code: "Hs").save()
        AllegianceType AtWar = new AllegianceType(name: "At War", code: "Wr").save()
        AllegianceType Occupied = new AllegianceType(name: "Occupied", code: "O").save()
        AllegianceType Contested = new AllegianceType(name: "Contested", code: "C").save()

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

        BorderType unknownBorder = new BorderType(
                name: "Unknown", code: "?", description: "a mystery",
                landCost: 0, airCost: 0, navalCost:0, manaCost:0).save()
        BorderType adjBorder = new BorderType(
                name: "Adjacent", code: ":", description: "a default land border, easy to cross at no penalty",
                landCost: 0, airCost: 0, navalCost:0, manaCost:0).save()
        BorderType roadBorder = new BorderType(
                name: "Road", code: "Rd", description: "A Road",
                landCost: 0, airCost: 0, navalCost:0, manaCost:0).save()
        BorderType riverBorder = new BorderType(
                name: "River", code: "Ri", description: "",
                landCost: 0, airCost: 0, navalCost:0, manaCost:0).save()
        BorderType canalBorder = new BorderType(
                name: "Canal", code: "Can", description: "",
                landCost: 0, airCost: 0, navalCost:0, manaCost:0).save()
        BorderType bridgeBorder = new BorderType(
                name: "Bridge", code: "Br", description: "",
                landCost: 0, airCost: 0, navalCost:0, manaCost:0).save()
        BorderType minMtnBorder = new BorderType(
                name: "Minor Mountain", code: "MiMtn", description: "",
                landCost: 0, airCost: 0, navalCost:0, manaCost:0).save()
        BorderType majMtnBorder = new BorderType(
                name: "Major Mountain", code: "MaMtn", description: "",
                landCost: 0, airCost: 0, navalCost:0, manaCost:0).save()
        BorderType minMtnPassBorder = new BorderType(
                name: "Minor Mountain Pass", code: "MiMP", description: "",
                landCost: 0, airCost: 0, navalCost:0, manaCost:0).save()
        BorderType majMtnPassBorder = new BorderType(
                name: "Major Mountain Pass", code: "MaMP", description: "",
                landCost: 0, airCost: 0, navalCost:0, manaCost:0).save()
        BorderType greatWallBorder = new BorderType(
                name: "Great Wall", code: "GW", description: "",
                landCost: 0, airCost: 0, navalCost:0, manaCost:0).save()
        BorderType tunnelBorder = new BorderType(
                name: "Tunnel", code: "T", description: "",
                landCost: 0, airCost: 0, navalCost:0, manaCost:0).save()
        BorderType blockedTunnelBorder = new BorderType(
                name: "Blocked Tunnel", code: "BT", description: "",
                landCost: 0, airCost: 0, navalCost:0, manaCost:0).save()
        BorderType gateBorder = new BorderType(
                name: "Gate", code: "Gt", description: "",
                landCost: 0, airCost: 0, navalCost:0, manaCost:0).save()
        BorderType teleportationBorder = new BorderType(
                name: "Teleportation", code: "T", description: "",
                landCost: 0, airCost: 0, navalCost:0, manaCost:0).save()
        BorderType stairsBorder = new BorderType(
                name: "Stairs", code: "St", description: "",
                landCost: 0, airCost: 0, navalCost:0, manaCost:0).save()
        BorderType cliffsBorder = new BorderType(
                name: "Cliffs", code: "Cl", description: "",
                landCost: 0, airCost: 0, navalCost:0, manaCost:0).save()
        BorderType currentBorder = new BorderType(
                name: "Current", code: "Cu", description: "",
                landCost: 0, airCost: 0, navalCost:0, manaCost:0).save()
        BorderType monsoonCurrentBorder = new BorderType(
                name: "Monsoon Current", code: "MC", description: "",
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

        TerrainType unknownTt = new TerrainType(name: "Unknown", code: "?", description: "A Mystery", landCost: null, airCost: null, navalCost: null).save()
        TerrainType ClearTt = new TerrainType(name: "Clear", code: "Cl", description: "Flat terrain", landCost: 1, airCost: 1, navalCost: null).save()
        TerrainType Desert = new TerrainType(name: "Desert", code: "De", landCost: 1, airCost: 1, navalCost: null).save()
        TerrainType Steppe = new TerrainType(name: "Steppe", code: "St", landCost: 1, airCost: 1, navalCost: null).save()
        TerrainType Island = new TerrainType(name: "Island", code: "Is", landCost: 1, airCost: 1, navalCost: null).save()
        TerrainType Forest = new TerrainType(name: "Forest", code: "Fo", landCost: 1, airCost: 1, navalCost: null).save()
        TerrainType Hill = new TerrainType(name: "Hill", code: "Hi", landCost: 1, airCost: 1, navalCost: null).save()
        TerrainType Mountain = new TerrainType(name: "Mountain", code: "Mt", landCost: 1, airCost: 1, navalCost: null).save()
        TerrainType Sea = new TerrainType(name: "Sea", code: "Se", landCost: 1, airCost: 1, navalCost: null).save()
        TerrainType Lake = new TerrainType(name: "Lake", code: "Lk", landCost: 1, airCost: 1, navalCost: null).save()
        TerrainType Swamp = new TerrainType(name: "Swamp", code: "Sw", landCost: 1, airCost: 1, navalCost: null).save()
        TerrainType Jungle = new TerrainType(name: "Jungle", code: "J", landCost: 1, airCost: 1, navalCost: null).save()
        TerrainType River = new TerrainType(name: "River", code: "Ri", landCost: 1, airCost: 1, navalCost: null).save()
        TerrainType Canal = new TerrainType(name: "Canal", code: "Ca", landCost: 1, airCost: 1, navalCost: null).save()
        TerrainType RoughSeas = new TerrainType(name: "RoughSeas", code: "RS", landCost: 1, airCost: 1, navalCost: null).save()
        TerrainType Cavern = new TerrainType(name: "Cavern", code: "Cv", landCost: 1, airCost: 1, navalCost: null).save()
        TerrainType Digging = new TerrainType(name: "Digging", code: "Di", landCost: 1, airCost: 1, navalCost: null).save()
    }

    def destroy = {
    }
}
