package org.turnstyles

// This version allows sharing of freeform markers amongst groups of realms and is meant for annotation and planning
// it is multiturn but does not include phase data yet like cartographer did
// perhaps add drawing tools
// Tokens are similar but game managed things, markers cant be used to target locations
// though that might be a good thing to tie together

class MarkerSet {
    String name = "Name"
    Integer color = 0
    Boolean isVisible = true

    static belongsTo = [majorMap :MajorMap]
    static hasMany = [realms :Realm]

    String toString() {"$name"}

    static graphql = true
    static constraints = {
        name blank: false
        color()
        isVisible()
    }
}
