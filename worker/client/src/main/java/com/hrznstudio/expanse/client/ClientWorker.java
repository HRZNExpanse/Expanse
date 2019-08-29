package com.hrznstudio.expanse.client;

import com.hrznstudio.expanse.worker.BaseWorker;
import net.fabricmc.loader.launch.knot.KnotClient;
import org.spongepowered.asm.launch.MixinBootstrap;

public final class ClientWorker extends BaseWorker<ClientView> {
    public ClientWorker() {
        super(ClientView::new);
    }

    @Override
    protected void onConnected() {

    }

    public static void main(String[] args) {
        KnotClient.main(args);
    }
}