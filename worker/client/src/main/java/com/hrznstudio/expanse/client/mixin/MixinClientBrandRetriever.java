package com.hrznstudio.expanse.client.mixin;

import com.hrznstudio.expanse.util.ConnectionManager;
import net.minecraft.client.ClientBrandRetriever;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(ClientBrandRetriever.class)
public class MixinClientBrandRetriever {

    /**
     * @reason Identify what system is in control
     * @author Coded
     */
    @Overwrite
    public static String getClientModName() {
        if (ConnectionManager.getConnectionStatus().isDisconnected()) {
            return "Expanse";
        }
        return "Expanse,SpatialOS";
    }
}
