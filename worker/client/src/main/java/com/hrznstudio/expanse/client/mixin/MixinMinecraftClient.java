package com.hrznstudio.expanse.client.mixin;

import com.hrznstudio.expanse.client.resources.ExpanseResourceCreator;
import com.hrznstudio.expanse.client.screen.GuiExpanseMenu;
import com.hrznstudio.expanse.util.ConnectionManager;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.TitleScreen;
import net.minecraft.client.resource.ClientResourcePackContainer;
import net.minecraft.resource.ResourcePackContainerManager;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MinecraftClient.class)
public class MixinMinecraftClient {
    @Shadow
    @Final
    private ResourcePackContainerManager<ClientResourcePackContainer> resourcePackContainerManager;

    @Shadow
    public InGameHud inGameHud;

    @Inject(method = "<init>", at = @At("RETURN"))
    public void constructor(CallbackInfo info) {
        this.resourcePackContainerManager.addCreator(new ExpanseResourceCreator());
    }

    @ModifyVariable(method = "openScreen", at = @At(value = "HEAD", ordinal = 0))
    public Screen constructor(Screen screen) {
        if (screen instanceof TitleScreen || (screen == null && MinecraftClient.getInstance().world == null)) {
            return new GuiExpanseMenu();
        }
        return screen;
    }

    /**
     * @author Coded
     */
    @Overwrite
    public String getVersionType() {
        return "Expanse";
    }
}
