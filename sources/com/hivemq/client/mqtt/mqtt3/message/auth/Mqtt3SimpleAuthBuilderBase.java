package com.hivemq.client.mqtt.mqtt3.message.auth;

import com.hivemq.client.mqtt.mqtt3.message.auth.Mqtt3SimpleAuthBuilderBase.Complete;

/* loaded from: classes3.dex */
public interface Mqtt3SimpleAuthBuilderBase<C extends Complete<C>> {

    /* loaded from: classes3.dex */
    public interface Complete<C extends Complete<C>> extends Mqtt3SimpleAuthBuilderBase<C> {
        C b(byte[] bArr);
    }

    C a(String str);
}
