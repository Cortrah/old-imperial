package old.imperial

import org.turnstyles.AllegianceType
import org.turnstyles.BorderType
import org.turnstyles.Kindred
import org.turnstyles.TrainingType
import org.turnstyles.AgentType
import org.turnstyles.LeaderActionType
import org.turnstyles.Religion

import org.turnstyles.Game
import org.turnstyles.MovementEffect
import org.turnstyles.MovementRule
import org.turnstyles.MovementType
import org.turnstyles.TerrainType

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
    }

    def destroy = {
    }
}
