package org.turnstyles

class Marker {
    String name = "Name"
    String code = "Code"
    String tooltip = ""
    String description = ""

    Integer x = 0
    Integer y = 0
    String symbol = "marker.svg" // ToDo: create class

    Integer color = 0
    Integer labelColor = 0
    Integer labelBgColor = 16777215 // white
    Integer labelBgAlpha = 100

    static belongsTo = [markerSet :MarkerSet]

    String toString() {"$name"}

    static graphql = true
    static constraints = {
        name blank: false
        code blank: false
        description nullable: true
        tooltip nullable: true
    }
}
