package com.google.firebase.heartbeatinfo;

import com.google.firebase.components.Component;

/* loaded from: classes3.dex */
public class HeartBeatConsumerComponent {
    private HeartBeatConsumerComponent() {
    }

    public static Component<?> a() {
        return Component.i(new HeartBeatConsumer() { // from class: com.google.firebase.heartbeatinfo.HeartBeatConsumerComponent.1
        }, HeartBeatConsumer.class);
    }
}
