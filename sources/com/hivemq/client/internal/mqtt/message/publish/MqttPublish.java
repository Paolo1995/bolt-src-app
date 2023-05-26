package com.hivemq.client.internal.mqtt.message.publish;

import b1.a;
import com.hivemq.client.internal.checkpoint.Confirmable;
import com.hivemq.client.internal.mqtt.datatypes.MqttTopicImpl;
import com.hivemq.client.internal.mqtt.datatypes.MqttUserPropertiesImpl;
import com.hivemq.client.internal.mqtt.datatypes.MqttUtf8StringImpl;
import com.hivemq.client.internal.mqtt.handler.publish.outgoing.MqttTopicAliasMapping;
import com.hivemq.client.internal.mqtt.message.MqttMessageWithUserProperties;
import com.hivemq.client.internal.util.ByteBufferUtil;
import com.hivemq.client.internal.util.StringUtil;
import com.hivemq.client.internal.util.collections.ImmutableIntList;
import com.hivemq.client.mqtt.datatypes.MqttQos;
import com.hivemq.client.mqtt.mqtt5.message.Mqtt5MessageType;
import com.hivemq.client.mqtt.mqtt5.message.publish.Mqtt5PayloadFormatIndicator;
import com.hivemq.client.mqtt.mqtt5.message.publish.Mqtt5Publish;
import java.nio.ByteBuffer;
import java.util.Objects;

/* loaded from: classes3.dex */
public class MqttPublish extends MqttMessageWithUserProperties implements Mqtt5Publish {

    /* renamed from: c  reason: collision with root package name */
    private final MqttTopicImpl f18549c;

    /* renamed from: d  reason: collision with root package name */
    private final ByteBuffer f18550d;

    /* renamed from: e  reason: collision with root package name */
    private final MqttQos f18551e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f18552f;

    /* renamed from: g  reason: collision with root package name */
    private final long f18553g;

    /* renamed from: h  reason: collision with root package name */
    private final Mqtt5PayloadFormatIndicator f18554h;

    /* renamed from: i  reason: collision with root package name */
    private final MqttUtf8StringImpl f18555i;

    /* renamed from: j  reason: collision with root package name */
    private final MqttTopicImpl f18556j;

    /* renamed from: k  reason: collision with root package name */
    private final ByteBuffer f18557k;

    /* renamed from: l  reason: collision with root package name */
    private final Confirmable f18558l;

    public MqttPublish(MqttTopicImpl mqttTopicImpl, ByteBuffer byteBuffer, MqttQos mqttQos, boolean z7, long j8, Mqtt5PayloadFormatIndicator mqtt5PayloadFormatIndicator, MqttUtf8StringImpl mqttUtf8StringImpl, MqttTopicImpl mqttTopicImpl2, ByteBuffer byteBuffer2, MqttUserPropertiesImpl mqttUserPropertiesImpl, Confirmable confirmable) {
        super(mqttUserPropertiesImpl);
        this.f18549c = mqttTopicImpl;
        this.f18550d = byteBuffer;
        this.f18551e = mqttQos;
        this.f18552f = z7;
        this.f18553g = j8;
        this.f18554h = mqtt5PayloadFormatIndicator;
        this.f18555i = mqttUtf8StringImpl;
        this.f18556j = mqttTopicImpl2;
        this.f18557k = byteBuffer2;
        this.f18558l = confirmable;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.hivemq.client.internal.mqtt.message.MqttMessageWithUserProperties
    public String e() {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        StringBuilder sb = new StringBuilder();
        sb.append("topic=");
        sb.append(this.f18549c);
        String str6 = "";
        if (this.f18550d == null) {
            str = "";
        } else {
            str = ", payload=" + this.f18550d.remaining() + "byte";
        }
        sb.append(str);
        sb.append(", qos=");
        sb.append(this.f18551e);
        sb.append(", retain=");
        sb.append(this.f18552f);
        if (this.f18553g == Long.MAX_VALUE) {
            str2 = "";
        } else {
            str2 = ", messageExpiryInterval=" + this.f18553g;
        }
        sb.append(str2);
        if (this.f18554h == null) {
            str3 = "";
        } else {
            str3 = ", payloadFormatIndicator=" + this.f18554h;
        }
        sb.append(str3);
        if (this.f18555i == null) {
            str4 = "";
        } else {
            str4 = ", contentType=" + this.f18555i;
        }
        sb.append(str4);
        if (this.f18556j == null) {
            str5 = "";
        } else {
            str5 = ", responseTopic=" + this.f18556j;
        }
        sb.append(str5);
        if (this.f18557k != null) {
            str6 = ", correlationData=" + this.f18557k.remaining() + "byte";
        }
        sb.append(str6);
        sb.append(StringUtil.a(", ", super.e()));
        return sb.toString();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MqttPublish)) {
            return false;
        }
        MqttPublish mqttPublish = (MqttPublish) obj;
        if (mqttPublish.f(this) && c(mqttPublish) && this.f18549c.equals(mqttPublish.f18549c) && Objects.equals(this.f18550d, mqttPublish.f18550d) && this.f18551e == mqttPublish.f18551e && this.f18552f == mqttPublish.f18552f && this.f18553g == mqttPublish.f18553g && this.f18554h == mqttPublish.f18554h && Objects.equals(this.f18555i, mqttPublish.f18555i) && Objects.equals(this.f18556j, mqttPublish.f18556j) && Objects.equals(this.f18557k, mqttPublish.f18557k)) {
            return true;
        }
        return false;
    }

    protected boolean f(Object obj) {
        return obj instanceof MqttPublish;
    }

    public MqttStatefulPublish g(int i8, boolean z7, int i9, ImmutableIntList immutableIntList) {
        return new MqttStatefulPublish(this, i8, z7, i9, immutableIntList);
    }

    @Override // com.hivemq.client.mqtt.mqtt5.message.Mqtt5Message
    public /* synthetic */ Mqtt5MessageType getType() {
        return a.a(this);
    }

    public MqttStatefulPublish h(int i8, boolean z7, MqttTopicAliasMapping mqttTopicAliasMapping) {
        int b8;
        if (mqttTopicAliasMapping == null) {
            b8 = 0;
        } else {
            b8 = mqttTopicAliasMapping.b(this.f18549c);
        }
        return g(i8, z7, b8, MqttStatefulPublish.f18564g);
    }

    public int hashCode() {
        return (((((((((((((((((d() * 31) + this.f18549c.hashCode()) * 31) + Objects.hashCode(this.f18550d)) * 31) + this.f18551e.hashCode()) * 31) + e0.a.a(this.f18552f)) * 31) + i0.a.a(this.f18553g)) * 31) + Objects.hashCode(this.f18554h)) * 31) + Objects.hashCode(this.f18555i)) * 31) + Objects.hashCode(this.f18556j)) * 31) + Objects.hashCode(this.f18557k);
    }

    public byte[] i() {
        return ByteBufferUtil.b(this.f18550d);
    }

    public MqttQos j() {
        return this.f18551e;
    }

    public MqttUtf8StringImpl k() {
        return this.f18555i;
    }

    public ByteBuffer l() {
        return this.f18557k;
    }

    public long m() {
        return this.f18553g;
    }

    public ByteBuffer n() {
        return this.f18550d;
    }

    public Mqtt5PayloadFormatIndicator o() {
        return this.f18554h;
    }

    public MqttTopicImpl p() {
        return this.f18556j;
    }

    public MqttTopicImpl q() {
        return this.f18549c;
    }

    public boolean r() {
        return this.f18552f;
    }

    public MqttPublish s(Confirmable confirmable) {
        return new MqttPublish(this.f18549c, this.f18550d, this.f18551e, this.f18552f, this.f18553g, this.f18554h, this.f18555i, this.f18556j, this.f18557k, b(), confirmable);
    }

    public String toString() {
        return "MqttPublish{" + e() + '}';
    }
}
