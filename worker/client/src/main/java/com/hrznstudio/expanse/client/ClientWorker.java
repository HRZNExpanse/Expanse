package com.hrznstudio.expanse.client;

import com.hrznstudio.expanse.worker.BaseWorker;

public final class ClientWorker extends BaseWorker<ClientView> {
    public ClientWorker() {
        super(ClientView::new);
    }

    @Override
    protected void onConnected() {

    }
}