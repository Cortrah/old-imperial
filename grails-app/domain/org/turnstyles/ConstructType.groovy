package org.turnstyles

/*
  Abbey, Priory, Cathedral,  Port, Town, City1, City2, City3,
  Academy, University, College, Arsenal, Fortress, Granary, GreatWall,
  Library,Palace, Road, Stadium, Capital, Treasury, MarchDependencySeat,
  Bridge, Canal, Cultivation, Urbanization, Gate, Stairs, ManaBattery, Mystery

  AirAcademy, DiplomaticAcademy, InteligenceAcademy,MilitaryAcademy,
  NavalAcademy,SorceryAcademy, University CartographyCollege, EngineeringCollege,
  LawCollege, MedicineCollege, NavigationCollege, TheologyCollege, CartographyCollege,
  EngineeringCollege,LawCollege, MedicineCollege, NavigationCollege, TheologyCollege,
 */

class ConstructType {

    String name = "Name"
    String code = "Code"
    String label = "Label"
    String description = ""

    // ToDo: abstract costs?
    Integer gpCost = 0
    Integer apCost = 0
    Integer nfpCost = 0
    Integer sfpCost = 0
    Integer manaCost = 0

    ConstructType upgradeFrom
    ConstructType upgradeTo

    // ToDo: abstract producers?
    Integer providesGp = 0
    Integer providesAp = 0
    Integer providesNfp = 0
    Integer providesMana = 0

    Integer cityForts = 0

    String toString() {"$name"}

    static graphql = true
    static constraints = {
        name blank: false
        code blank: false
        label blank: false
        description nullable: true

        gpCost nullable: true
        apCost nullable: true
        nfpCost nullable: true
        sfpCost nullable: true
        manaCost nullable: true

        upgradeFrom nullable: true
        upgradeTo nullable: true

        providesGp nullable: true
        providesAp nullable: true
        providesNfp nullable: true
        providesMana nullable: true

        cityForts nullable: true

    }
    def seedContext (servletContext) {
        //servletContext.r =
    }
}
