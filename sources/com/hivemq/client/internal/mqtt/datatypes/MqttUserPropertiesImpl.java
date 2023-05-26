package com.hivemq.client.internal.mqtt.datatypes;

import com.hivemq.client.internal.util.collections.ImmutableList;
import com.hivemq.client.internal.util.collections.b;
import io.netty.buffer.ByteBuf;

/* loaded from: classes3.dex */
public class MqttUserPropertiesImpl {

    /* renamed from: c  reason: collision with root package name */
    public static final MqttUserPropertiesImpl f17992c = new MqttUserPropertiesImpl(b.z());

    /* renamed from: a  reason: collision with root package name */
    private final ImmutableList<MqttUserPropertyImpl> f17993a;

    /* renamed from: b  reason: collision with root package name */
    private int f17994b = -1;

    private MqttUserPropertiesImpl(ImmutableList<MqttUserPropertyImpl> immutableList) {
        this.f17993a = immutableList;
    }

    public static MqttUserPropertiesImpl b(ImmutableList.Builder<MqttUserPropertyImpl> builder) {
        if (builder == null) {
            return f17992c;
        }
        return f(builder.b());
    }

    private int c() {
        int i8 = 0;
        for (int i9 = 0; i9 < this.f17993a.size(); i9++) {
            i8 += this.f17993a.get(i9).f();
        }
        return i8;
    }

    public static MqttUserPropertiesImpl f(ImmutableList<MqttUserPropertyImpl> immutableList) {
        if (immutableList.isEmpty()) {
            return f17992c;
        }
        return new MqttUserPropertiesImpl(immutableList);
    }

    public ImmutableList<MqttUserPropertyImpl> a() {
        return this.f17993a;
    }

    public void d(ByteBuf byteBuf) {
        for (int i8 = 0; i8 < this.f17993a.size(); i8++) {
            this.f17993a.get(i8).e(byteBuf);
        }
    }

    public int e() {
        if (this.f17994b == -1) {
            this.f17994b = c();
        }
        return this.f17994b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MqttUserPropertiesImpl)) {
            return false;
        }
        return this.f17993a.equals(((MqttUserPropertiesImpl) obj).f17993a);
    }

    public int hashCode() {
        return this.f17993a.hashCode();
    }

    public String toString() {
        return this.f17993a.toString();
    }
}
