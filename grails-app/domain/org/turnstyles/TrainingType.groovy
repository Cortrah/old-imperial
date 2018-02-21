package org.turnstyles

// ToDo: add effects
//TrainingType gn = new TrainingType(name: "General", code: "Gn", description: "").save();
//TrainingType wz = new TrainingType(name: "Wizard", code: "Wz", description: "").save();
//TrainingType sc = new TrainingType(name: "Scholar", code: "Sc", description: "").save();
//TrainingType li = new TrainingType(name: "Lich", code: "li", description: "").save();
//TrainingType ad = new TrainingType(name: "Admiral", code: "Ad", description: "").save();
//TrainingType am = new TrainingType(name: "Air Marshal", code: "AM", description: "").save();
//TrainingType sp = new TrainingType(name: "Spy", code: "Spy", description: "").save();
//TrainingType al = new TrainingType(name: "Alchemist", code: "Al", description: "").save();
//TrainingType hi = new TrainingType(name: "Historian", code: "Hi", description: "").save();
//TrainingType mm = new TrainingType(name: "Cartographer", code: "MM", description: "Map Maker").save();
//TrainingType eg = new TrainingType(name: "Diplomat", code: "Di", description: "Diplomatic Envoy").save();
//TrainingType ju = new TrainingType(name: "Jurist", code: "Ju", description: "").save();
//TrainingType en = new TrainingType(name: "Engineer", code: "En", description: "").save();
//TrainingType md = new TrainingType(name: "Doctor", code: "MD", description: "").save();
//TrainingType na = new TrainingType(name: "Navigator", code: "Na", description: "").save();
//TrainingType th = new TrainingType(name: "Theologian", code: "Th", description: "").save();
//TrainingType vp = new TrainingType(name: "Vampire", code: "Vp", description: "").save();


class TrainingType {
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
}
