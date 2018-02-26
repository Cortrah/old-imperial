package org.turnstyles

class TerrainType {
    String name = "Unknown"
    String code = "?"
    String description = "A Mystery"

    Integer landCost = null
    Integer airCost = null
    Integer navalCost = null

    String toString() {"$name"}

    static graphql = true
    static constraints = {
        name blank: false
        code blank: false
        description nullable: true

        landCost nullable: true
        airCost nullable: true
        navalCost nullable: true
    }
    def seedContext (servletContext) {
        servletContext.Clear = new TerrainType(name: "Clear", code: "Cl", description: "Flat terrain", landCost: 1, airCost: 1, navalCost: null).save()
        servletContext.Desert = new TerrainType(name: "Desert", code: "De", landCost: 1, airCost: 1, navalCost: null).save()
        servletContext.Steppe = new TerrainType(name: "Steppe", code: "St", landCost: 1, airCost: 1, navalCost: null).save()
        servletContext.Island = new TerrainType(name: "Island", code: "Is", landCost: 1, airCost: 1, navalCost: null).save()
        servletContext.Forest = new TerrainType(name: "Forest", code: "Fo", landCost: 1, airCost: 1, navalCost: null).save()
        servletContext.Hill = new TerrainType(name: "Hill", code: "Hi", landCost: 1, airCost: 1, navalCost: null).save()
        servletContext.Mountain = new TerrainType(name: "Mountain", code: "Mt", landCost: 1, airCost: 1, navalCost: null).save()
        servletContext.Sea = new TerrainType(name: "Sea", code: "Sea", landCost: 0, airCost: 1, navalCost: 1).save()
        servletContext.UnderSea = new TerrainType(name: "UnderSea", code: "UnS", landCost: 0, airCost: 0, navalCost: 1).save()
        servletContext.Lake = new TerrainType(name: "Lake", code: "Lk", landCost: 0, airCost: 1, navalCost: 1).save()
        servletContext.Swamp = new TerrainType(name: "Swamp", code: "Sw", landCost: 1, airCost: 1, navalCost: null).save()
        servletContext.Jungle = new TerrainType(name: "Jungle", code: "J", landCost: 1, airCost: 1, navalCost: null).save()
        servletContext.River = new TerrainType(name: "River", code: "Ri", landCost: 0, airCost: 1, navalCost: 1).save()
        servletContext.Canal = new TerrainType(name: "Canal", code: "Ca", landCost: 0, airCost: 1, navalCost: 1).save()
        servletContext.RoughSeas = new TerrainType(name: "RoughSeas", code: "RS", landCost: 0, airCost: 0, navalCost: 1).save()
        servletContext.Cavern = new TerrainType(name: "Cavern", code: "Cv", landCost: 1, airCost: 1, navalCost: null).save()
        servletContext.Digging = new TerrainType(name: "Digging", code: "Di", landCost: 1, airCost: 1, navalCost: null).save()

    }
}
