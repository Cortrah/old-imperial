package old.imperial


import org.turnstyles.BorderType
import org.turnstyles.MajorMap
import org.turnstyles.MovementEffect
import org.turnstyles.MovementRule
import org.turnstyles.MovementType;
import org.turnstyles.Region

class BootStrap {

    def init = { servletContext ->
        MajorMap mainMap = new MajorMap(name: "Sahul",
                code: "Sah",
                description: "The continent of Sahul is under the dubious leadership of an imperial structure called the second empire.",
                height: 1400, width: 2600, bg: "sahul.svg")
            .addToRegions("name": "Kommolek", "code": "Kom",
                "description": "Capital of the yagnarist realm of Kommolek")
            .save();


        MovementType unknownMv = new MovementType(
                name: "Unknown", code: "?", description: "a mystery").save();
        MovementType landMv = new MovementType(
                name: "Land", code: "L", description: "land movement").save();
        MovementType navalMv = new MovementType(
                name: "Naval", code: "N", description: "by ocean, river or canal").save();
        MovementType airMv = new MovementType(
                name: "Air", code: "A", description: "flying").save();
        MovementType celestialMv = new MovementType(
                name: "Celestial", code: "C", description: "flying high").save();
        MovementType subterainianMv = new MovementType(
                name: "Subteranian", code: "S", description: "underground").save();
        MovementType gateMv = new MovementType(
                name: "Gate", code: "G", description: "using a magical gate").save();
        MovementType teleportMv = new MovementType(
                name: "Teleportation", code: "T", description: "via the teleportation spell").save();

        MovementEffect adjCost = new MovementEffect(
                name: "Adjacent Border Cost", code: "adj_bd",
                description: "The cost for moving across an adjacent border",
                targetType: "cost", operator: "+", ammount:0).save()

        MovementRule movementRule = new MovementRule(
            name: "Adj Cost", code: "Adj_cst", description: "The cost of going into an adjacent land region",
            preconditions: "always", movementType: landMv, movementEffect: adjCost).save()


        BorderType borderType = new BorderType(
                name: "Unknown", code: "?", description: "a mystery",
                landCost: 0, airCost: 0, navalCost:0, manaCost:0).save();
        BorderType borderType1 = new BorderType(
                name: "Adjacent", code: "Adj", description: "a default border, easy to cross at no penalty",
                landCost: 0, airCost: 0, navalCost:0, manaCost:0).save();
        BorderType borderType2 = new BorderType(
                name: "Road", code: "Rd", description: "A Road",
                landCost: 0, airCost: 0, navalCost:0, manaCost:0).save();
        BorderType borderType3 = new BorderType(
                name: "River", code: "Ri", description: "",
                landCost: 0, airCost: 0, navalCost:0, manaCost:0).save();
        BorderType borderType4 = new BorderType(
                name: "Canal", code: "Can", description: "",
                landCost: 0, airCost: 0, navalCost:0, manaCost:0).save();
        BorderType borderType5 = new BorderType(
                name: "Bridge", code: "Br", description: "",
                landCost: 0, airCost: 0, navalCost:0, manaCost:0).save();
        BorderType borderType6 = new BorderType(
                name: "Minor Mountain", code: "MiMtn", description: "",
                landCost: 0, airCost: 0, navalCost:0, manaCost:0).save();
        BorderType borderType7 = new BorderType(
                name: "Major Mountain", code: "MaMtn", description: "",
                landCost: 0, airCost: 0, navalCost:0, manaCost:0).save();
        BorderType borderType8 = new BorderType(
                name: "Minor Mountain Pass", code: "MiMP", description: "",
                landCost: 0, airCost: 0, navalCost:0, manaCost:0).save();
        BorderType borderType9 = new BorderType(
                name: "Major Mountain Pass", code: "MaMP", description: "",
                landCost: 0, airCost: 0, navalCost:0, manaCost:0).save();
        BorderType borderType10 = new BorderType(
                name: "Great Wall", code: "GW", description: "",
                landCost: 0, airCost: 0, navalCost:0, manaCost:0).save();
        BorderType borderType11 = new BorderType(
                name: "Tunnel", code: "T", description: "",
                landCost: 0, airCost: 0, navalCost:0, manaCost:0).save();
        BorderType borderType12 = new BorderType(
                name: "Blocked Tunnel", code: "BT", description: "",
                landCost: 0, airCost: 0, navalCost:0, manaCost:0).save();
        BorderType borderType13 = new BorderType(
                name: "Gate", code: "Gt", description: "",
                landCost: 0, airCost: 0, navalCost:0, manaCost:0).save();
        BorderType borderType14 = new BorderType(
                name: "Stairs", code: "St", description: "",
                landCost: 0, airCost: 0, navalCost:0, manaCost:0).save();
        BorderType borderType15 = new BorderType(
                name: "Cliffs", code: "Cl", description: "",
                landCost: 0, airCost: 0, navalCost:0, manaCost:0).save();
        BorderType borderType16 = new BorderType(
                name: "Current", code: "Cu", description: "",
                landCost: 0, airCost: 0, navalCost:0, manaCost:0).save();
        BorderType borderType17 = new BorderType(
                name: "Monsoon Current", code: "MC", description: "",
                landCost: 0, airCost: 0, navalCost:0, manaCost:0).save();
    }

    def destroy = {
    }
}
