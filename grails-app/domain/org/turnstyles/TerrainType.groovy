package org.turnstyles

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