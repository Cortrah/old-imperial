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

//
//        MovementType unknownMv = new MovementType(
//                name: "Unknown", code: "?", description: "a mystery").save();
//        MovementType landMv = new MovementType(
//                name: "Land", code: "L", description: "land movement").save();
//        MovementType navalMv = new MovementType(
//                name: "Naval", code: "N", description: "by ocean, river or canal").save();
//        MovementType airMv = new MovementType(
//                name: "Air", code: "A", description: "flying").save();
//        MovementType celestialMv = new MovementType(
//                name: "Celestial", code: "C", description: "flying high").save();
//        MovementType subterainianMv = new MovementType(
//                name: "Subteranian", code: "S", description: "underground").save();
//        MovementType gateMv = new MovementType(
//                name: "Gate", code: "G", description: "using a magical gate").save();
//        MovementType teleportMv = new MovementType(
//                name: "Teleportation", code: "T", description: "via the teleportation spell").save();
//        MovementType allMv = new MovementType(
//                name: "All", code: "*", description: "all movement types").save();
//
//        BorderType unknownBorder = new BorderType(
//                name: "Unknown", code: "?", description: "a mystery",
//                landCost: 0, airCost: 0, navalCost:0, manaCost:0).save();
//        BorderType adjBorder = new BorderType(
//                name: "Adjacent", code: "Adj", description: "a default border, easy to cross at no penalty",
//                landCost: 0, airCost: 0, navalCost:0, manaCost:0).save();
//        BorderType roadBorder = new BorderType(
//                name: "Road", code: "Rd", description: "A Road",
//                landCost: 0, airCost: 0, navalCost:0, manaCost:0).save();
//        BorderType riverBorder = new BorderType(
//                name: "River", code: "Ri", description: "",
//                landCost: 0, airCost: 0, navalCost:0, manaCost:0).save();
//        BorderType canalBorder = new BorderType(
//                name: "Canal", code: "Can", description: "",
//                landCost: 0, airCost: 0, navalCost:0, manaCost:0).save();
//        BorderType bridgeBorder = new BorderType(
//                name: "Bridge", code: "Br", description: "",
//                landCost: 0, airCost: 0, navalCost:0, manaCost:0).save();
//        BorderType minMtnBorder = new BorderType(
//                name: "Minor Mountain", code: "MiMtn", description: "",
//                landCost: 0, airCost: 0, navalCost:0, manaCost:0).save();
//        BorderType majMtnBorder = new BorderType(
//                name: "Major Mountain", code: "MaMtn", description: "",
//                landCost: 0, airCost: 0, navalCost:0, manaCost:0).save();
//        BorderType minMtnPassBorder = new BorderType(
//                name: "Minor Mountain Pass", code: "MiMP", description: "",
//                landCost: 0, airCost: 0, navalCost:0, manaCost:0).save();
//        BorderType majMtnPassBorder = new BorderType(
//                name: "Major Mountain Pass", code: "MaMP", description: "",
//                landCost: 0, airCost: 0, navalCost:0, manaCost:0).save();
//        BorderType greatWallBorder = new BorderType(
//                name: "Great Wall", code: "GW", description: "",
//                landCost: 0, airCost: 0, navalCost:0, manaCost:0).save();
//        BorderType tunnelBorder = new BorderType(
//                name: "Tunnel", code: "T", description: "",
//                landCost: 0, airCost: 0, navalCost:0, manaCost:0).save();
//        BorderType blockedTunnelBorder = new BorderType(
//                name: "Blocked Tunnel", code: "BT", description: "",
//                landCost: 0, airCost: 0, navalCost:0, manaCost:0).save();
//        BorderType gateBorder = new BorderType(
//                name: "Gate", code: "Gt", description: "",
//                landCost: 0, airCost: 0, navalCost:0, manaCost:0).save();
//        BorderType teleportationBorder = new BorderType(
//                name: "Teleportation", code: "T", description: "",
//                landCost: 0, airCost: 0, navalCost:0, manaCost:0).save();
//        BorderType stairsBorder = new BorderType(
//                name: "Stairs", code: "St", description: "",
//                landCost: 0, airCost: 0, navalCost:0, manaCost:0).save();
//        BorderType cliffsBorder = new BorderType(
//                name: "Cliffs", code: "Cl", description: "",
//                landCost: 0, airCost: 0, navalCost:0, manaCost:0).save();
//        BorderType currentBorder = new BorderType(
//                name: "Current", code: "Cu", description: "",
//                landCost: 0, airCost: 0, navalCost:0, manaCost:0).save();
//        BorderType monsoonCurrentBorder = new BorderType(
//                name: "Monsoon Current", code: "MC", description: "",
//                landCost: 0, airCost: 0, navalCost:0, manaCost:0).save();
//
//        MovementEffect adjLCost = new MovementEffect(
//                name: "Adjacent Land Border Cost", code: "albc",
//                description: "The cost for moving across an adjacent land border",
//                targetType: "cost", operator: "+", ammount:0).save()
//
//        MovementRule movementRule = new MovementRule(
//                name: "Adj L Border Cost", code: "Adj_l_cst", description: "The cost of going into an adjacent land region",
//                preconditions: "always", movementType: landMv, movementEffect: adjLCost).save()

    }

    def destroy = {
    }
}
