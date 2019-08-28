package com.hrznstudio.expanse.bootstrap.util;

import com.hrznstudio.expanse.schema.entity.*;
import com.hrznstudio.expanse.schema.inventory.Inventory;
import com.hrznstudio.expanse.schema.inventory.InventoryData;
import com.hrznstudio.expanse.schema.player.*;
import com.hrznstudio.expanse.util.CommonWorkerRequirements;
import com.hrznstudio.expanse.util.EntityBuilder;
import improbable.Coordinates;
import improbable.Position;
import improbable.PositionData;
import improbable.Vector3f;
import improbable.worker.Entity;

import java.util.Collections;

public class PlayerUtil {
    public Entity createPlayerEntity() {
        EntityBuilder builder = new EntityBuilder("Player");
        builder.addComponent(Health.COMPONENT, new HealthData(20, 20), CommonWorkerRequirements.createWorkerRequirementSet("entity_worker"));
        builder.addComponent(Position.COMPONENT, new PositionData(new Coordinates(0, 0, 0)), CommonWorkerRequirements.createWorkerRequirementSet("entity_worker"));
        builder.addComponent(Rotation.COMPONENT, new RotationData(0, 0), CommonWorkerRequirements.createWorkerRequirementSet("entity_worker"));
        builder.addComponent(Motion.COMPONENT, new MotionData(new Vector3f(0, 0, 0)), CommonWorkerRequirements.createWorkerRequirementSet("entity_worker"));
        builder.addComponent(Food.COMPONENT, new FoodData(20, 20), CommonWorkerRequirements.createWorkerRequirementSet("entity_worker"));
        builder.addComponent(Experience.COMPONENT, new ExperienceData(0), CommonWorkerRequirements.createWorkerRequirementSet("entity_worker"));
        builder.addComponent(Flammable.COMPONENT, new FlammableData(false), CommonWorkerRequirements.createWorkerRequirementSet("entity_worker"));
        builder.addComponent(Inventory.COMPONENT, new InventoryData(Collections.emptyMap()), CommonWorkerRequirements.createWorkerRequirementSet("entity_worker"));
        builder.addComponent(PlayerInfo.COMPONENT, new PlayerInfoData(new GameProfile("UUID", "NAME")), CommonWorkerRequirements.createWorkerRequirementSet("bootstrap"));
        builder.addComponent(PlayerConnection.COMPONENT, new PlayerConnectionData(), CommonWorkerRequirements.createWorkerRequirementSet("bootstrap"));
        builder.addComponent(WorldEntity.COMPONENT, new WorldEntityData(), CommonWorkerRequirements.createWorkerRequirementSet("bootstrap"));
        builder.addComponent(ChatAbility.COMPONENT, new ChatAbilityData(), CommonWorkerRequirements.createWorkerRequirementSet("bootstrap"));
        return builder.build();
    }
}