package org.turnstyles

// really a RealmTurn or RealmStatus
// as anything can change from turn to turn
// and so we have a new instance each turn

class Realm {
    String name = "RealmName"
    String code = "RealmCode"
    String label = "RealmLabel"
    String description = "Default Description"
    String toString() {"$name"}

    // ------------
    // public
    // ------------
    Herald herald
    Integer displayColor = 0
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

    Integer cavQr = 0
    Integer infQr = 0
    Integer sgeQr = 0
    Integer navQr = 0
    Integer airQr = 0
    Integer nsrQr = 0
    Integer irQr = 0
    Integer blQr = 0
    Integer rsQr = 0

    Integer cavInvestment = 0
    Integer infInvestment = 0
    Integer sgeInvestment = 0
    Integer navInvestment = 0
    Integer airInvestment = 0
    Integer irInvestment = 0
    Integer blInvestment = 0
    Integer nsrInvestment = 0

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
    }
}

