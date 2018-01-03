package org.turnstyles

class BorderType {
    String name
    String code
    String description = "default description"

    Integer landCost = null
    Integer airCost = null
    Integer navalCost = null
    Integer manaCost = null

    boolean isDirectional

    String toString() {"$name"}

    static graphql = true

    static constraints = {

        name blank: false
        code blank: false
        description nullable: true

        landCost()
        airCost()
        navalCost()
        manaCost()

        isDirectional()
    }
}
