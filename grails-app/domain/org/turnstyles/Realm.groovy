package org.turnstyles

import org.turnstyles.QualityRatingType
import org.turnstyles.QualityRating

// really a RealmTurn or RealmStatus
// as anything can change from turn to turn
// and so we have a new instance each turn

// what about naming conventions, only use associative name when something belongsTo the other?
// so in this case TurnsRealm? No. I don't like it. RealmStatus or RealmTurn would be better

class Realm {

    String name = "Unknown"
    String code = "?"
    String label = "Unknown"
    String description = "An Unknown Realm"
    String toString() {"$name"}

    // ------------
    // public
    // ------------
    Herald herald
    Integer color = 0
    Boolean isSecret = false

    //Location captialLocation
    //Region homeRegion
    //Religion religon
    //RealmType realmType

    Double startingIsi = 0.0
    Double startingTv = 0.0
    Double endingIsi = 0.0
    Double endingTv = 0.0

    // ------------
    // realm
    // ------------
    Double mana  = 0.0
    Double regionGp = 0.0
    Double urbanGp = 0.0
    Double ictGp = 0.0
    Double pwbGp = 0.0
    Double roadGp = 0.0
    Double savedGp = 0.0
    Double prodAp = 0.0
    Double savedAp = 0.0
    Double totalAp = 0.0
    Double nfp = 0.0
    Double sfp = 0.0
    Double armySupport = 0.0

    QualityRating cavQr
    QualityRating infQr
    QualityRating sgeQr
    QualityRating navQr
    QualityRating airQr
    QualityRating nsrQr
    QualityRating irQr
    QualityRating blQr
    QualityRating rsQr

    String realmNotes = "Notes"

    // ------------
    // Dei
    // ------------
    Integer corruptionPercentage = 0
    Integer plaguePercentage = 0
    String deiNotes = "Dei Notes"

    static belongsTo = [turn: Turn]
    static hasMany = [regions: Region, tradeAgreements: TradeAgreement, militaryAgreements: MilitaryAgreement, turnActions :RealmAction,
                      hiddenRealms: Realm, hiddenMajorMaps: MajorMap, hiddenNarratives: Narrative,
                      hiddenConstructs: Construct, hiddenLocations: Location, hiddenMinorMaps: MinorMap,
                      hiddenRegions: Region, hiddenRegionBorders: RegionBorders, hiddenFeatures: Feature,
                      hiddenHeralds: Herald, hiddenItems: Item, hiddenKindred: Kindred, hiddenReligions: Religion,
                      hiddenSpelltype: SpellType, hiddenUnitType: UnitType, hiddenBuildLocationType: BuildLocationType,
                      hiddenLeaders: Leader, hiddenUnitTypeGroups: UnitTypeGroup,
                      leaderActions: LeaderAction, realmActions: RealmAction, narratives: Narrative]

    static graphql = true
    static constraints = {
        name blank: false
        code blank: false
        label blank: false
        description nullable: true

        herald nullable: true

        startingIsi()
        startingTv()
        endingIsi()
        endingTv()
    }

    def seedContext (servletContext) {
        // for here maybe a for each on the base type instantiating each  the seedcontext
        this.cavQr = servletContext.cav = new QualityRatingType(name: "Cavalry", code: "Cav", description: "Infantry Rating");
        this.infQr = servletContext.inf = new QualityRatingType(name: "Infantry", code: "Inf", description: "Infantry Rating");
        this.airQr = servletContext.air = new QualityRatingType(name: "Air", code: "Air", description: "Air Rating");
        this.navQr = servletContext.nav = new QualityRatingType(name: "Naval", code: "Nav", description: "Naval Rating");
        this.sgeQr = servletContext.sge = new QualityRatingType(name: "Siege", code: "Sge", description: "Siege Rating");
        this.irQr = servletContext.ir = new QualityRatingType(name: "Inteligence", code: "Ir", description: "Inteligence Rating");
        this.blQr = servletContext.bl = new QualityRatingType(name: "Beaurocracy", code: "Bl", description: "Beaurocracy Level");
        this.nsrQr = servletContext.nsr = new QualityRatingType(name: "Spell", code: "Nsr", description: "National Spell Rating");
        this.rsQr = servletContext.rs = new QualityRatingType(name: "Religion", code: "Rs", description: "Religious Strength");
    }
}

