package org.turnstyles

// isAmphibian
// isFlyer
// isArmored
// isVacumeProtected

class KindredTrait {
    String name = "Amphibian"
    String code = "Amph"
    String label = "Amphibian"
    String description = "Able to breath underwater"

    // Point cost when creating a race
    // or Mana cost for trollspawn
    Integer cost = 100

    String toString() {"$code"}

    static graphql = true
    static constraints = {
        name blank: false
        code blank: false
        label blank: false
        cost nullable: false
    }
    def seedContext (servletContext) {
        //servletContext.r =
    }
}
