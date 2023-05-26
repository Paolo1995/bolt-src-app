package com.hivemq.client.mqtt.mqtt3.message.publish;

import com.hivemq.client.mqtt.mqtt3.message.publish.Mqtt3PublishBuilderBase;

/* loaded from: classes3.dex */
public interface Mqtt3PublishBuilder extends Mqtt3PublishBuilderBase<Complete> {

    /* loaded from: classes3.dex */
    public interface Complete extends Mqtt3PublishBuilder, Mqtt3PublishBuilderBase.Complete<Complete> {
        Mqtt3Publish build();
    }
}
