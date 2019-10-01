package com.hrznstudio.expanse.bootstrap;

import improbable.worker.EntityId;
import improbable.worker.SnapshotOutputStream;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.launch.knot.KnotClient;

public class BootstrapMod implements ModInitializer {
    @Override
    public void onInitialize() {
        try {
            SnapshotOutputStream outputStream = new SnapshotOutputStream("default.snapshot");
            outputStream.writeEntity(new EntityId(0), BootstrapWorker.createBootstrapEntity());
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.setProperty("fabric.development", "true");
        KnotClient.main(args);
    }
}
