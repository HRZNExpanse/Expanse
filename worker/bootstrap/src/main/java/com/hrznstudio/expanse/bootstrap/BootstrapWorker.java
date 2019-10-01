package com.hrznstudio.expanse.bootstrap;

import com.hrznstudio.expanse.schema.boostrap.Bootstrap;
import com.hrznstudio.expanse.schema.boostrap.BootstrapData;
import com.hrznstudio.expanse.util.CommonWorkerRequirements;
import com.hrznstudio.expanse.util.EntityBuilder;
import com.hrznstudio.expanse.worker.BaseWorker;
import improbable.collections.Option;
import improbable.worker.*;

public final class BootstrapWorker extends BaseWorker.BaseViewWorker {
    @Override
    protected void onConnected() {
        RequestId<ReserveEntityIdsRequest> request = getConnection().sendReserveEntityIdsRequest(1, Option.empty());
        getDispatcher().onReserveEntityIdsResponse(argument -> {
            if (argument.requestId.equals(request)) {
                if (argument.statusCode == StatusCode.SUCCESS) {
                    getConnection().sendCreateEntityRequest(createBootstrapEntity(), argument.firstEntityId, Option.empty());
                }
            }
        });
    }

    public static Entity createBootstrapEntity() {
        EntityBuilder builder = new EntityBuilder("Bootstrap");
        builder.addComponent(Bootstrap.COMPONENT, BootstrapData.create(), CommonWorkerRequirements.createWorkerRequirementSet("bootstrap"));
        return builder.build();
    }
}