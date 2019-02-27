package org.turnstyles

// Nsr, Bl, Ir, Rs, Cav, Inf, Sge, Nav, Air, Cel, (Rugby, Shinty ...)
// ToDo: add effects for certain qualityRatingType ranges

class QualityRatingType {

    String name = "Name"
    String code = "Code"
    String description = ""

    String toString() {"$name"}

    static graphql = true
    static constraints = {
        name blank: false
        code blank: false
        description nullable: true
    }

    def seedContext (servletContext) {
        servletContext.nsr = QualityRatingType(name="Sorcery", code="Nsr")
        servletContext.bl = QualityRatingType(name="Beaurocracy", code="Bl")
        servletContext.ir = QualityRatingType(name="Inteligence", code="Ir")
        servletContext.rs = QualityRatingType(name="Religious Strength", code="Rs")
        servletContext.cav = QualityRatingType(name="Cavalry", code="Cav")
        servletContext.inf = QualityRatingType(name="Infantry", code="Inf")
        servletContext.sge = QualityRatingType(name="Seige", code="Sge")
        servletContext.nav = QualityRatingType(name="Naval", code="Nav")
        servletContext.air = QualityRatingType(name="Air", code="Air")
        servletContext.cel = QualityRatingType(name="Celestial", code="Cel")
    }
}

