package org.turnstyles

// ToDo: add effects

class TrainingType {
    String name = "Unknown"
    String code = "?"
    String description = "A Mystery"
    String toString() {"$name"}

    static graphql = true
    static constraints = {
        name blank: false
        code blank: false
        description nullable: true
    }
    def seedContext (servletContext) {
        servletContext.gn = new TrainingType(name: "General", code: "Gn", description: "").save();
        servletContext.wz = new TrainingType(name: "Wizard", code: "Wz", description: "").save();
        servletContext.sc = new TrainingType(name: "Scholar", code: "Sc", description: "").save();
        servletContext.li = new TrainingType(name: "Lich", code: "li", description: "").save();
        servletContext.ad = new TrainingType(name: "Admiral", code: "Ad", description: "").save();
        servletContext.am = new TrainingType(name: "Air Marshal", code: "AM", description: "").save();
        servletContext.sp = new TrainingType(name: "Spy", code: "Spy", description: "").save();
        servletContext.al = new TrainingType(name: "Alchemist", code: "Al", description: "").save();
        servletContext.hi = new TrainingType(name: "Historian", code: "Hi", description: "").save();
        servletContext.mm = new TrainingType(name: "Cartographer", code: "MM", description: "Map Maker").save();
        servletContext.eg = new TrainingType(name: "Diplomat", code: "Di", description: "Diplomatic Envoy").save();
        servletContext.ju = new TrainingType(name: "Jurist", code: "Ju", description: "").save();
        servletContext.en = new TrainingType(name: "Engineer", code: "En", description: "").save();
        servletContext.md = new TrainingType(name: "Doctor", code: "MD", description: "").save();
        servletContext.na = new TrainingType(name: "Navigator", code: "Na", description: "").save();
        servletContext.th = new TrainingType(name: "Theologian", code: "Th", description: "").save();
        servletContext.vp = new TrainingType(name: "Vampire", code: "Vp", description: "").save();
    }
}

