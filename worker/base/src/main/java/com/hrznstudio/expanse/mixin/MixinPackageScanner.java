package com.hrznstudio.expanse.mixin;

import org.reflections.Reflections;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

import java.util.HashSet;
import java.util.Set;

@Mixin(targets = "improbable.worker.PackageScanner", remap = false)
public class MixinPackageScanner {

    private static final Reflections[] reflections = new Reflections[]{
            new Reflections("improbable"),
            new Reflections("com.hrznstudio.expanse.schema")
    };

    /**
     * @reason Optimize subClass check to only check packages which might contain what its looking for
     * @author Coded
     */
    @Overwrite(remap = false)
    static Set<Class> getAllSubClassesOf(final Class desiredClass) {
        Set<Class> set = new HashSet<>();
        for (Reflections reflection : reflections) {
            //noinspection unchecked
            set.addAll(reflection.getSubTypesOf(desiredClass));
        }
        return set;
    }

}