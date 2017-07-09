package org.turnstyles

class BorderType {
    String name
    String code
    String description = "default description"

    Integer landCost = 0
    Integer airCost = 0
    Integer navalCost = 0
    Integer manaCost = 0

    boolean isDirectional

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