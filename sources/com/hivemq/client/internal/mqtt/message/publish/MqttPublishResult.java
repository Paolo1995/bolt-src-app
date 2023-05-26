package com.hivemq.client.internal.mqtt.message.publish;

import com.hivemq.client.internal.mqtt.message.publish.puback.MqttPubAck;
import com.hivemq.client.internal.mqtt.message.publish.pubrec.MqttPubRec;
import com.hivemq.client.mqtt.mqtt5.message.publish.Mqtt5PublishResult;
import j$.util.Optional;
import j$.util.function.BooleanSupplier;
import java.util.Objects;

/* loaded from: classes3.dex */
public class MqttPublishResult implements Mqtt5PublishResult {

    /* renamed from: a  reason: collision with root package name */
    private final MqttPublish f18559a;

    /* renamed from: b  reason: collision with root package name */
    private final Throwable f18560b;

    /* loaded from: classes3.dex */
    public static class MqttQos1Result extends MqttPublishResult {

        /* renamed from: c  reason: collision with root package name */
        private final MqttPubAck f18561c;

        public MqttQos1Result(MqttPublish mqttPublish, Throwable th, MqttPubAck mqttPubAck) {
            super(mqttPublish, th);
            this.f18561c = mqttPubAck;
        }

        @Override // com.hivemq.client.internal.mqtt.message.publish.MqttPublishResult
        protected boolean b(Object obj) {
            return obj instanceof MqttQos1Result;
        }

        @Override // com.hivemq.client.internal.mqtt.message.publish.MqttPublishResult
        String e() {
            return super.e() + ", pubAck=" + this.f18561c;
        }

        @Override // com.hivemq.client.internal.mqtt.message.publish.MqttPublishResult
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if ((obj instanceof MqttQos1Result) && super.equals(obj)) {
                return this.f18561c.equals(((MqttQos1Result) obj).f18561c);
            }
            return false;
        }

        @Override // com.hivemq.client.internal.mqtt.message.publish.MqttPublishResult
        public int hashCode() {
            return (super.hashCode() * 31) + this.f18561c.hashCode();
        }

        @Override // com.hivemq.client.internal.mqtt.message.publish.MqttPublishResult
        public String toString() {
            return "MqttQos1Result{" + e() + '}';
        }
    }

    /* loaded from: classes3.dex */
    public static class MqttQos2IntermediateResult extends MqttQos2Result {

        /* renamed from: d  reason: collision with root package name */
        private final BooleanSupplier f18562d;

        public MqttQos2IntermediateResult(MqttPublish mqttPublish, MqttPubRec mqttPubRec, BooleanSupplier booleanSupplier) {
            super(mqttPublish, null, mqttPubRec);
            this.f18562d = booleanSupplier;
        }

        @Override // com.hivemq.client.internal.mqtt.message.publish.MqttPublishResult
        public boolean a() {
            return this.f18562d.getAsBoolean();
        }
    }

    /* loaded from: classes3.dex */
    public static class MqttQos2Result extends MqttPublishResult {

        /* renamed from: c  reason: collision with root package name */
        private final MqttPubRec f18563c;

        public MqttQos2Result(MqttPublish mqttPublish, Throwable th, MqttPubRec mqttPubRec) {
            super(mqttPublish, th);
            this.f18563c = mqttPubRec;
        }

        @Override // com.hivemq.client.internal.mqtt.message.publish.MqttPublishResult
        protected boolean b(Object obj) {
            return obj instanceof MqttQos2Result;
        }

        @Override // com.hivemq.client.internal.mqtt.message.publish.MqttPublishResult
        String e() {
            return super.e() + ", pubRec=" + this.f18563c;
        }

        @Override // com.hivemq.client.internal.mqtt.message.publish.MqttPublishResult
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if ((obj instanceof MqttQos2Result) && super.equals(obj)) {
                return this.f18563c.equals(((MqttQos2Result) obj).f18563c);
            }
            return false;
        }

        @Override // com.hivemq.client.internal.mqtt.message.publish.MqttPublishResult
        public int hashCode() {
            return (super.hashCode() * 31) + this.f18563c.hashCode();
        }

        @Override // com.hivemq.client.internal.mqtt.message.publish.MqttPublishResult
        public String toString() {
            return "MqttQos2Result{" + e() + '}';
        }
    }

    public MqttPublishResult(MqttPublish mqttPublish, Throwable th) {
        this.f18559a = mqttPublish;
        this.f18560b = th;
    }

    public boolean a() {
        return true;
    }

    protected boolean b(Object obj) {
        return obj instanceof MqttPublishResult;
    }

    public Optional<Throwable> c() {
        return Optional.ofNullable(this.f18560b);
    }

    public MqttPublish d() {
        return this.f18559a;
    }

    String e() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append("publish=");
        sb.append(this.f18559a);
        if (this.f18560b == null) {
            str = "";
        } else {
            str = ", error=" + this.f18560b;
        }
        sb.append(str);
        return sb.toString();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MqttPublishResult)) {
            return false;
        }
        MqttPublishResult mqttPublishResult = (MqttPublishResult) obj;
        if (mqttPublishResult.b(this) && this.f18559a.equals(mqttPublishResult.f18559a) && Objects.equals(this.f18560b, mqttPublishResult.f18560b)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (this.f18559a.hashCode() * 31) + Objects.hashCode(this.f18560b);
    }

    public String toString() {
        return "MqttPublishResult{" + e() + '}';
    }
}
