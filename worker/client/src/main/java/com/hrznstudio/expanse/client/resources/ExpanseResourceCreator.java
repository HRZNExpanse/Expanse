package com.hrznstudio.expanse.client.resources;

import net.minecraft.resource.ResourcePackContainer;
import net.minecraft.resource.ResourcePackCreator;

import java.util.Map;

public class ExpanseResourceCreator implements ResourcePackCreator {
    @Override
    public <T extends ResourcePackContainer> void registerContainer(Map<String, T> var1, ResourcePackContainer.Factory<T> var2) {
//        FabricLoader.getInstance().getModContainer("expanse-client").map(container -> {
//            return ResourcePackContainer.of("Expanse Resources", true, () -> new ExpanseResources(container.getRootPath()), var2, ResourcePackContainer.InsertionPosition.BOTTOM);
//        }).ifPresent(t -> var1.put("expanse", t));
    }
}