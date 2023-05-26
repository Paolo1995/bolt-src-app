package com.hivemq.client.mqtt.mqtt3.message.auth;

import com.hivemq.client.mqtt.mqtt3.message.auth.Mqtt3SimpleAuthBuilderBase;

/* loaded from: classes3.dex */
public interface Mqtt3SimpleAuthBuilder extends Mqtt3SimpleAuthBuilderBase<Complete> {

    /* loaded from: classes3.dex */
    public interface Complete extends Mqtt3SimpleAuthBuilder, Mqtt3SimpleAuthBuilderBase.Complete<Complete> {
        Mqtt3SimpleAuth build();
    }
}
