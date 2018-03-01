package org.turnstyles

import org.turnstyles.Realm
import org.turnstyles.Herald
import org.turnstyles.Turn

class Game {
    String name = "GameName"
    String code = "GameCode"
    String label = "GameLabel"
    String notes = "Notes"
    String status = "Staging"

    Turn currentTurn
    static hasMany = [turns: Turn]

    String toString() {"$name"}

    static graphql = true
    static constraints = {
        name blank: false
        code blank: false
        label blank: false
        status inList: ["Staging", "Ploting", "Processing", "Concluded"]

        currentTurn nullable: true

        notes blank: true
    }

    def seedContext (servletContext) {
        servletContext.FireAndIce = new Game(name: "Of Fire and Ice", code: "Fie", label: "Fire Ice").save()

        // heralds belong to realms, realms belong to turns and turns belong to games so we initialize them here
        servletContext.Turn25 = new Turn(name: "1540-1545", number: 25, startingYear: 1571, endingYear: 1575,
                game: servletContext.FireAndIce).save()

        servletContext.Kommolek = new Realm(name: "Dutchy of Kommolek", code: "Kom", label: "Kommolek",
                game: servletContext.FireAndIce, turn: servletContext.Turn25).save()
        servletContext.Cortrah = new org.turnstyles.Herald(name: "Cortrah", code: "C", label: "Cort",
                realm: servletContext.Kommolek).save()

        servletContext.EThace = new Realm(name: "Electoral County Palatine of Thace", code: "ETh", label: "E Thace",
                game: servletContext.FireAndIce, turn: servletContext.Turn25).save()
        servletContext.Kolgrim = new Herald(name: "Kolgrim", label: "Gman",
                realm: servletContext.EThace).save()

        servletContext.FireAndIce.currentTurn = servletContext.Turn25
    }
}
