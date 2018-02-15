package org.turnstyles

//Integer landMove = 0
//Integer airMove = 0
//Integer navalMove = 0
//Integer undergroundMove = 0
//Integer gateMove = 0

class MovementType {
    String name = "Name"
    String code = 'Code'
    String description = "description"
    String toString() {"$name"}

    static graphql = true
    static constraints = {
        name blank: false
        code blank: false
        description nullable: true
    }
}
