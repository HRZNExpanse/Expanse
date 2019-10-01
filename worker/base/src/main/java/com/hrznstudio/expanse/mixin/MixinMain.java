package com.hrznstudio.expanse.mixin;

import com.hrznstudio.expanse.ExpanseInjection;
import net.minecraft.client.main.Main;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(Main.class)
public class MixinMain {
    @ModifyVariable(method = "main", at = @At(value = "HEAD"))
    private static String[] args(String[] args) {
        ExpanseInjection.doInject();
        return args;
    }
}