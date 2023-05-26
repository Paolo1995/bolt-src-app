package com.hivemq.client.mqtt.mqtt3.message.connect;

import com.hivemq.client.mqtt.mqtt3.message.auth.Mqtt3SimpleAuth;
import com.hivemq.client.mqtt.mqtt3.message.connect.Mqtt3ConnectBuilderBase;

/* loaded from: classes3.dex */
public interface Mqtt3ConnectBuilderBase<B extends Mqtt3ConnectBuilderBase<B>> {
    B a(Mqtt3SimpleAuth mqtt3SimpleAuth);

    B c(int i8);

    B d(boolean z7);
}
