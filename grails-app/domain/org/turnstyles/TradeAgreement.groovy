package org.turnstyles

// ToDo: like military agreements, add terms and sharing/visibility mechanism

class TradeAgreement {
    String name = "Normal Trade"
    String code = "T"
    String label = "Trade"

    String description = "A basic trade agreement. Realms must be within three regions and will receive tv1*tv2/5 in gp"
    String terms = "the proposal"

    Realm initiatingRealm
    Realm acceptingRealm

    String toString() {"$name"}

    static graphql = true
    static constraints = {
        name blank: false
        code blank: false
        label blank: false

        description nullable: true
        terms nullable: true

        initiatingRealm()
        acceptingRealm()
    }
    def seedContext (servletContext) {
        //servletContext.r =
    }
}
