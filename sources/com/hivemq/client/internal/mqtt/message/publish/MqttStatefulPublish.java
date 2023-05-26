package com.hivemq.client.internal.mqtt.message.publish;

import com.hivemq.client.internal.mqtt.message.MqttStatefulMessage;
import com.hivemq.client.internal.util.collections.ImmutableIntList;
import com.hivemq.client.internal.util.collections.a;
import okhttp3.internal.http2.Settings;

/* loaded from: classes3.dex */
public class MqttStatefulPublish extends MqttStatefulMessage.WithId<MqttPublish> {

    /* renamed from: g  reason: collision with root package name */
    public static final ImmutableIntList f18564g = a.b();

    /* renamed from: d  reason: collision with root package name */
    private final boolean f18565d;

    /* renamed from: e  reason: collision with root package name */
    private final int f18566e;

    /* renamed from: f  reason: collision with root package name */
    private final ImmutableIntList f18567f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public MqttStatefulPublish(MqttPublish mqttPublish, int i8, boolean z7, int i9, ImmutableIntList immutableIntList) {
        super(mqttPublish, i8);
        this.f18565d = z7;
        this.f18566e = i9;
        this.f18567f = immutableIntList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.hivemq.client.internal.mqtt.message.MqttStatefulMessage.WithId, com.hivemq.client.internal.mqtt.message.MqttStatefulMessage
    public String d() {
        return super.d() + ", dup=" + this.f18565d + ", topicAlias=" + this.f18566e + ", subscriptionIdentifiers=" + this.f18567f;
    }

    public ImmutableIntList e() {
        return this.f18567f;
    }

    public int f() {
        return this.f18566e & Settings.DEFAULT_INITIAL_WINDOW_SIZE;
    }

    public boolean g() {
        return this.f18565d;
    }

    public boolean h() {
        if ((this.f18566e & 65536) != 0) {
            return true;
        }
        return false;
    }

    public String toString() {
        return "MqttStatefulPublish{" + d() + '}';
    }
}
