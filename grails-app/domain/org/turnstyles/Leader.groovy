package org.turnstyles

import org.grails.datastore.mapping.query.Query

class Leader {

    String name = "Name"
    String code = "Code"
    Integer command = 5
    Integer loyalty = 5
    Integer combat = 5
    Integer diplomacy = 5
    Integer sorcery = 5
    Integer age = 18
    String sex = "M"

    Integer carryingAp = 0
    Integer carryingGp = 0

    String notes = ""

    String icon = "leader.svg"
    Integer displayX = 0
    Integer displayY = 0

    Region homeRegion
    TrainingType training
    Kindred kindred
    Region atRegion
    Location atLocation

    AgentType agentType
    Realm realm

    String toString() {"$name"}

    static graphql = true
    static constraints = {
        name blank: false
        code blank: false
    }
}
