package org.turnstyles

//TerrainType UnkTerType = new TerrainType(name: "Unknown", code: "?", description: "A Mystery", landCost: null, airCost: null, navalCost: null).save()
//TerrainType Clear = new TerrainType(name: "Clear", code: "Cl", description: "Flat terrain", landCost: 1, airCost: 1, navalCost: null).save()
//TerrainType Desert = new TerrainType(name: "Desert", code: "De", landCost: 1, airCost: 1, navalCost: null).save()
//TerrainType Steppe = new TerrainType(name: "Steppe", code: "St", landCost: 1, airCost: 1, navalCost: null).save()
//TerrainType Island = new TerrainType(name: "Island", code: "Is", landCost: 1, airCost: 1, navalCost: null).save()
//TerrainType Forest = new TerrainType(name: "Forest", code: "Fo", landCost: 1, airCost: 1, navalCost: null).save()
//TerrainType Hill = new TerrainType(name: "Hill", code: "Hi", landCost: 1, airCost: 1, navalCost: null).save()
//TerrainType Mountain = new TerrainType(name: "Mountain", code: "Mt", landCost: 1, airCost: 1, navalCost: null).save()
//TerrainType Sea = new TerrainType(name: "Sea", code: "Sea", landCost: 0, airCost: 1, navalCost: 1).save()
//TerrainType UnderSea = new TerrainType(name: "UnderSea", code: "UnS", landCost: 0, airCost: 0, navalCost: 1).save()
//TerrainType Lake = new TerrainType(name: "Lake", code: "Lk", landCost: 0, airCost: 1, navalCost: 1).save()
//TerrainType Swamp = new TerrainType(name: "Swamp", code: "Sw", landCost: 1, airCost: 1, navalCost: null).save()
//TerrainType Jungle = new TerrainType(name: "Jungle", code: "J", landCost: 1, airCost: 1, navalCost: null).save()
//TerrainType River = new TerrainType(name: "River", code: "Ri", landCost: 0, airCost: 1, navalCost: 1).save()
//TerrainType Canal = new TerrainType(name: "Canal", code: "Ca", landCost: 0, airCost: 1, navalCost: 1).save()
//TerrainType RoughSeas = new TerrainType(name: "RoughSeas", code: "RS", landCost: 0, airCost: 0, navalCost: 1).save()
//TerrainType Cavern = new TerrainType(name: "Cavern", code: "Cv", landCost: 1, airCost: 1, navalCost: null).save()
//TerrainType Digging = new TerrainType(name: "Digging", code: "Di", landCost: 1, airCost: 1, navalCost: null).save()

class TerrainType {
    String name = "Clear"
    String code = "C"
    String description = "default description"
    String toString() {"$name"}

    Integer landCost = null
    Integer airCost = null
    Integer navalCost = null

    static graphql = true
    static constraints = {
        name blank: false
        code blank: false
        description nullable: true

        landCost nullable: true
        airCost nullable: true
        navalCost nullable: true
    }
}