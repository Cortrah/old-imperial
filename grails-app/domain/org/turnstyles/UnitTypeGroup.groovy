package org.turnstyles

class UnitTypeGroup {

    String name = "Name"
    String code = "Code"
    String description = ""

    UnitType unitType
    Integer amount

    // cargoCapacity can be computed from unitTypes for each movementType
    // cargoUnits can be used to compute the cargo units used and remaining cargo capacity

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
