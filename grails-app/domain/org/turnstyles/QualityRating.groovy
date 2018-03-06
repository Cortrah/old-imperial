package org.turnstyles

class QualityRating {

    QualityRatingType qualityRatingType
    Integer level = 0
    Integer investment = 0

    static belongsTo = [realm :Realm]

    static graphql = true
    static constraints = {

        qualityRatingType()
        level()
        investment()
        realm()
    }
}
