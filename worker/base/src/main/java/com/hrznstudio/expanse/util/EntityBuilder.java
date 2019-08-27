package com.hrznstudio.expanse.util;

import improbable.*;
import improbable.worker.ComponentMetaclass;
import improbable.worker.Entity;

import java.util.HashMap;
import java.util.Map;

public class EntityBuilder {
    private Entity entity;
    private Map<Integer, WorkerRequirementSet> write_access = new HashMap<>();

    public EntityBuilder(String entityType) {
        entity = new Entity();
        entity.add(Metadata.COMPONENT, new MetadataData(entityType));
    }

    public <DATA, META extends ComponentMetaclass<DATA, ?>> EntityBuilder addComponent(META component, DATA data, WorkerRequirementSet writeAccess) {
        entity.add(component, data);
        write_access.put(component.getComponentId(), writeAccess);
        return this;
    }

    public Entity build() {
        entity.add(Persistence.COMPONENT, new PersistenceData());
        entity.add(EntityAcl.COMPONENT, new EntityAclData(
                CommonWorkerRequirements.GetCommonWorkers(),
                write_access
        ));

        return entity;
    }
}