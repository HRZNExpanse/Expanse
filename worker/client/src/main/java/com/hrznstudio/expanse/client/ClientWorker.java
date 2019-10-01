package com.hrznstudio.expanse.client;

import com.hrznstudio.expanse.worker.BaseWorker;
import net.fabricmc.loader.launch.knot.KnotClient;

public final class ClientWorker extends BaseWorker<ClientView> {
    public ClientWorker() {
        super(ClientView::new);
    }

    @Override
    protected void onConnected() {

    }

    public static void main(String[] args) {
        System.setProperty("fabric.development", "true");
        KnotClient.main(args);
    }
}