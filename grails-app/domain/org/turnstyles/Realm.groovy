package org.turnstyles

import org.turnstyles.QualityRatingType
import org.turnstyles.QualityRating

// ToDo: this is really a RealmTurn or RealmStatus
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

    Location capitalLocation
    Region homeRegion
    Religion religion
    RealmType realmType

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
    QualityRating celQr

    String realmNotes = "Notes"

    // ------------
    // Dei
    // ------------
    Integer corruptionPercentage = 0
    Integer plaguePercentage = 0
    String deiNotes = "Dei Notes"

    static belongsTo = [turn: Turn]
    static hasMany = [regions: Region, tradeAgreements: TradeAgreement, militaryAgreements: MilitaryAgreement,
                      turnActions: RealmAction, specialQualityRatings: QualityRating,
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

        capitalLocation nullable: true
        homeRegion nullable: true
        religion nullable: true
        realmType nullable: true

        cavQr nullable: true
        infQr nullable: true
        airQr nullable: true
        navQr nullable: true
        sgeQr nullable: true
        irQr nullable: true
        blQr nullable: true
        nsrQr nullable: true
        rsQr nullable: true
        celQr nullable: true

        startingIsi()
        startingTv()
        endingIsi()
        endingTv()
    }

    def seedContext (servletContext) {
        // for here maybe a for each on the base type instantiating each  the seedcontext
        this.cavQr = new QualityRating( qualityRatingType = servletContext.cav, level = 0, investment = 0, realm = this );
        this.infQr = new QualityRating( qualityRatingType = servletContext.inf, level = 0, investment = 0, realm = this );
        this.airQr = new QualityRating( qualityRatingType = servletContext.air, level = 0, investment = 0, realm = this );
        this.navQr = new QualityRating( qualityRatingType = servletContext.nav, level = 0, investment = 0, realm = this );
        this.sgeQr = new QualityRating( qualityRatingType = servletContext.sge, level = 0, investment = 0, realm = this );
        this.irQr  = new QualityRating( qualityRatingType = servletContext.ir, level = 0, investment = 0, realm = this );
        this.blQr  = new QualityRating( qualityRatingType = servletContext.bl, level = 0, investment = 0, realm = this );
        this.nsrQr = new QualityRating( qualityRatingType = servletContext.nsr, level = 0, investment = 0, realm = this );
        this.rsQr  = new QualityRating( qualityRatingType = servletContext.rs, level = 0, investment = 0, realm = this );
        this.celQr = new QualityRating( qualityRatingType = servletContext.cel, level = 0, investment = 0, realm = this );
    }
}

