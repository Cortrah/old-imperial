package old.imperial

import org.turnstyles.AllegianceType
import org.turnstyles.BorderType
import org.turnstyles.Kindred
import org.turnstyles.TrainingType
import org.turnstyles.AgentType
import org.turnstyles.LeaderActionType
import org.turnstyles.Religion

import org.turnstyles.Game
import org.turnstyles.Herald
import org.turnstyles.MovementEffect
import org.turnstyles.MovementRule
import org.turnstyles.MovementType
import org.turnstyles.TerrainType
import org.turnstyles.Turn
import org.turnstyles.Realm
import org.turnstyles.MajorMap
import org.turnstyles.Region
import org.turnstyles.Location
import org.turnstyles.RegionBorders


class BootStrap {

    def init = { servletContext ->

        Religion defaultReligion = new Religion().save();
        defaultReligion.seedContext(servletContext);

        LeaderActionType defaultLeaderActionType = new LeaderActionType().save();
        defaultLeaderActionType.seedContext(servletContext);

        TrainingType defaultTrainingType = new TrainingType().save();
        defaultTrainingType.seedContext(servletContext);

        AgentType defaultAgentType = new AgentType().save();
        defaultAgentType.seedContext(servletContext);

        AllegianceType defaultAllegianceType = new AllegianceType().save()
        defaultAllegianceType.seedContext(servletContext);

        BorderType defaultBorderType = new BorderType().save()
        defaultBorderType.seedContext(servletContext);

        Kindred defaultKindred = new Kindred().save()
        defaultKindred.seedContext(servletContext);

        MovementType defaultMovementType = new MovementType().save()
        defaultMovementType.seedContext(servletContext);

        MovementEffect defaultMovementEffect = new MovementEffect().save()
        defaultMovementEffect.seedContext(servletContext);

        MovementRule defaultMovementRule = new MovementRule().save()
        defaultMovementRule.seedContext(servletContext);

        TerrainType defaultTerrainType = new TerrainType().save()
        defaultTerrainType.seedContext(servletContext);

        Game defaultGame = new Game().save()
        defaultGame.seedContext(servletContext);

//        Turn defaultTurn = new Turn(defaultGame).save()
//        defaultTurn.seedContext(servletContext);

//        Realm defaultRealm = new Realm().save()
//        defaultRealm.seedContext(servletContext);
//
//        Herald defaultHerald = new Herald().save()
//        defaultHerald.seedContext(servletContext);
//
//        MajorMap defaultMajorMap = new MajorMap().save()
//        defaultMajorMap.seedContext(servletContext);
//
//        Region defaultRegion = new Region().save()
//        defaultRegion.seedContext(servletContext);
//
//        Location defaultLocation = new Location().save()
//        defaultLocation.seedContext(servletContext);
//
//        RegionBorders defaultBorder = new RegionBorders().save()
//        defaultBorder.seedContext(servletContext);

        //Turn25.addToMajorMaps(sahulMap).save()
        //FireAndIce.currentTurn = Turn25
        //servletContext.defaultGame.seedSecondPass(servletContext, Turn25);
    }

    def destroy = {
    }
}
