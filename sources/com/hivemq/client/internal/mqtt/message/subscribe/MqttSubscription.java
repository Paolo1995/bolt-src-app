package com.hivemq.client.internal.mqtt.message.subscribe;

import com.hivemq.client.internal.mqtt.datatypes.MqttTopicFilterImpl;
import com.hivemq.client.mqtt.datatypes.MqttQos;
import com.hivemq.client.mqtt.mqtt5.message.subscribe.Mqtt5RetainHandling;
import e0.a;

/* loaded from: classes3.dex */
public class MqttSubscription {

    /* renamed from: a  reason: collision with root package name */
    private final MqttTopicFilterImpl f18603a;

    /* renamed from: b  reason: collision with root package name */
    private final MqttQos f18604b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f18605c;

    /* renamed from: d  reason: collision with root package name */
    private final Mqtt5RetainHandling f18606d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f18607e;

    public MqttSubscription(MqttTopicFilterImpl mqttTopicFilterImpl, MqttQos mqttQos, boolean z7, Mqtt5RetainHandling mqtt5RetainHandling, boolean z8) {
        this.f18603a = mqttTopicFilterImpl;
        this.f18604b = mqttQos;
        this.f18605c = z7;
        this.f18606d = mqtt5RetainHandling;
        this.f18607e = z8;
    }

    public static boolean a(byte b8) {
        return (b8 & 4) != 0;
    }

    public static MqttQos b(byte b8) {
        return MqttQos.a(b8 & 3);
    }

    public static boolean c(byte b8) {
        return (b8 & 8) != 0;
    }

    public static Mqtt5RetainHandling d(byte b8) {
        return Mqtt5RetainHandling.a((b8 & 48) >> 4);
    }

    private String h() {
        return "topicFilter=" + this.f18603a + ", qos=" + this.f18604b + ", noLocal=" + this.f18605c + ", retainHandling=" + this.f18606d + ", retainAsPublished=" + this.f18607e;
    }

    public byte e() {
        byte c8 = (byte) ((this.f18606d.c() << 4) | 0);
        if (this.f18607e) {
            c8 = (byte) (c8 | 8);
        }
        if (this.f18605c) {
            c8 = (byte) (c8 | 4);
        }
        return (byte) (c8 | this.f18604b.c());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MqttSubscription)) {
            return false;
        }
        MqttSubscription mqttSubscription = (MqttSubscription) obj;
        if (this.f18603a.equals(mqttSubscription.f18603a) && this.f18604b == mqttSubscription.f18604b && this.f18605c == mqttSubscription.f18605c && this.f18606d == mqttSubscription.f18606d && this.f18607e == mqttSubscription.f18607e) {
            return true;
        }
        return false;
    }

    public MqttQos f() {
        return this.f18604b;
    }

    public MqttTopicFilterImpl g() {
        return this.f18603a;
    }

    public int hashCode() {
        return (((((((this.f18603a.hashCode() * 31) + this.f18604b.hashCode()) * 31) + a.a(this.f18605c)) * 31) + this.f18606d.hashCode()) * 31) + a.a(this.f18607e);
    }

    public String toString() {
        return "MqttSubscription{" + h() + '}';
    }
}
