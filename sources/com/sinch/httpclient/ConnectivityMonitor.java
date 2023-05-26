package com.sinch.httpclient;

/* loaded from: classes3.dex */
public interface ConnectivityMonitor {

    /* loaded from: classes3.dex */
    public interface Listener {
        void onReconnected();
    }

    void registerListener(Listener listener);

    void unregisterListener(Listener listener);
}
