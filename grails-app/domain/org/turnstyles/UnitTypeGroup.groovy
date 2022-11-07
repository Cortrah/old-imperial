package org.turnstyles

class UnitTypeGroup {

    String name = "Name"
    String code = "Code"
    String label = "Label"
    String description = ""

    UnitType unitType
    Integer amount

    // ToDo: cargoCapacity can be computed from unitTypes for each movementType
    // ToDo: cargoUnits can be used to compute the cargo units used and remaining cargo capacity

    static hasMany = [cargoUnits :Cargo]

    Realm realm
    Region homeRegion

    String toString() {"$name"}

    static graphql = true
    static constraints = {
        name blank: false
        code blank: false
        label blank: false
        description nullable: true

        unitType()
        amount()
    }
    def seedContext (servletContext) {
        //servletContext.r =
    }
}

