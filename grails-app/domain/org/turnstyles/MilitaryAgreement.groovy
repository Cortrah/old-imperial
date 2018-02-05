package org.turnstyles

class MilitaryAgreement {
    String name = "MilitaryAgreement"
    String code = "NH"
    String label = "NonHostile"
    String description = "Troops of each realm should not be considered hostile by default"

    Realm initiatingRealm
    Realm acceptingRealm

    String toString() {"$name"}

    static graphql = true
    static constraints = {
        name blank: false
        code blank: false
        label blank: false
        description nullable: true

        initiatingRealm()
        acceptingRealm()
    }
}
