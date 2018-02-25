package org.turnstyles

// Rule Change: each action takes a turn before it becomes active or inactive
// initiate trade, military agreement, research agreement
// accept trade, military agreement, research agreement
// cease trade, military agreement, research agreement

// training, diplomacy and research are all actions done by leaders, the ruler being one
// the ruler can do more than a regular leader or allied leader

// AddResourcesFromOthers fromRealm optionallyAtRegion gp,ap,nfp,sfp,mana
// AddItemFromOthers fromRealm=>Region toRegion=>atLocation item
// AddUnitsFromOthers fromRealm=>Region=>atLocation unitType count gpCargo, apCargo

// SendResourcesToOthers  fromRealm optionallyAtRegion gp,ap,nfp,sfp,mana
// SendItemsToOthers  fromRealm=>Region toRegion=>atLocation item
// SendUnitsToOthers fromRealm=>Region=>atLocation unitType count gpCargo, apCargo

// buildUnits: unitTYpe, count, region=>location, costs:gp,ap,nfp,sfp,mana upgradeFrom:type,count

// buildConstruct
// what region=>location costs:gp,ap,nfp,sfp, upgradeFrom
// demobilizeUnits:Type,count
// demobilize discounts summary
// #,what,region,gp,ap,nfp,sfp,mana
// final cost

// miscelaneousIncome note,gp,ap,nfp,sfp,mana
// miscelaneousExpenses note,gp,ap,nfp,sfp,mana

// ToDo: make income/expenses a cool sheet instead of a boring form
// maybe little demons and devils or angels watch and comment on the focus and ballance of decisions
// allow the gm to send notes through these little characters in the margins

// income,
// Gp: regional, publicWorks, city, internaltrade, international trade, saved
// ap, nfp, sfp, mana
// gp or mana from sacrifice
// from exchanges
// from miscelaneousIncome
// Total Income gp, ap, nfp, sfp, mana

// expenses
// sacrifices gp, ap, nfp, sfp, mana
// army suport gp, ap
// religious tithe
// qr investments (gp + each qr has specific additional types allowed),
// publid works investment (gp, nfp, sfp)
// from exchanges
// from builds
// from units
// from magic
// from miscelaneous expenses
// total spent

// total remaining


class RealmAction {

    static constraints = {
    }
    def seedContext (servletContext) {
        //servletContext.r =
    }
}

