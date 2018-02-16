package org.turnstyles

class UnitTypeGroup {

    String name = "Name"
    String code = "Code"
    String description = ""

    UnitType unitType
    Integer amount

    static hasMany = [cargoUnits :Cargo]

    Realm realm
    Region homeRegion

    String toString() {"$name"}

    static graphql = true
    static constraints = {
        name blank: false
        code blank: false
        description nullable: true

        unitType()
        amount()
    }
}
