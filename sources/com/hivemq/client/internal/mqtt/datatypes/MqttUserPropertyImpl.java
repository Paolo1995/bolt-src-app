package com.hivemq.client.internal.mqtt.datatypes;

import com.hivemq.client.mqtt.mqtt5.datatypes.Mqtt5UserProperty;
import io.netty.buffer.ByteBuf;

/* loaded from: classes3.dex */
public class MqttUserPropertyImpl implements Mqtt5UserProperty {

    /* renamed from: f  reason: collision with root package name */
    private final MqttUtf8StringImpl f17995f;

    /* renamed from: g  reason: collision with root package name */
    private final MqttUtf8StringImpl f17996g;

    public MqttUserPropertyImpl(MqttUtf8StringImpl mqttUtf8StringImpl, MqttUtf8StringImpl mqttUtf8StringImpl2) {
        this.f17995f = mqttUtf8StringImpl;
        this.f17996g = mqttUtf8StringImpl2;
    }

    public static MqttUserPropertyImpl c(ByteBuf byteBuf) {
        MqttUtf8StringImpl f8;
        MqttUtf8StringImpl f9 = MqttUtf8StringImpl.f(byteBuf);
        if (f9 == null || (f8 = MqttUtf8StringImpl.f(byteBuf)) == null) {
            return null;
        }
        return new MqttUserPropertyImpl(f9, f8);
    }

    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(Mqtt5UserProperty mqtt5UserProperty) {
        int compareTo = this.f17995f.compareTo(mqtt5UserProperty.getName());
        if (compareTo == 0) {
            return this.f17996g.compareTo(mqtt5UserProperty.getValue());
        }
        return compareTo;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(ByteBuf byteBuf) {
        byteBuf.writeByte(38);
        this.f17995f.h(byteBuf);
        this.f17996g.h(byteBuf);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MqttUserPropertyImpl)) {
            return false;
        }
        MqttUserPropertyImpl mqttUserPropertyImpl = (MqttUserPropertyImpl) obj;
        if (this.f17995f.equals(mqttUserPropertyImpl.f17995f) && this.f17996g.equals(mqttUserPropertyImpl.f17996g)) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int f() {
        return this.f17995f.j() + 1 + this.f17996g.j();
    }

    @Override // com.hivemq.client.mqtt.mqtt5.datatypes.Mqtt5UserProperty
    /* renamed from: h */
    public MqttUtf8StringImpl getName() {
        return this.f17995f;
    }

    public int hashCode() {
        return (this.f17995f.hashCode() * 31) + this.f17996g.hashCode();
    }

    @Override // com.hivemq.client.mqtt.mqtt5.datatypes.Mqtt5UserProperty
    /* renamed from: j */
    public MqttUtf8StringImpl getValue() {
        return this.f17996g;
    }

    public String toString() {
        return "(" + this.f17995f + ", " + this.f17996g + ")";
    }
}
