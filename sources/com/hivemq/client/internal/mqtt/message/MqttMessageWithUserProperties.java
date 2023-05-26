package com.hivemq.client.internal.mqtt.message;

import com.hivemq.client.internal.mqtt.datatypes.MqttUserPropertiesImpl;
import com.hivemq.client.internal.mqtt.datatypes.MqttUtf8StringImpl;
import com.hivemq.client.internal.mqtt.message.MqttMessage;
import com.hivemq.client.internal.util.StringUtil;
import com.hivemq.client.internal.util.collections.ImmutableList;
import com.hivemq.client.mqtt.mqtt5.message.Mqtt5ReasonCode;
import java.util.Objects;

/* loaded from: classes3.dex */
public abstract class MqttMessageWithUserProperties implements MqttMessage.WithUserProperties {

    /* renamed from: b  reason: collision with root package name */
    private final MqttUserPropertiesImpl f18467b;

    /* loaded from: classes3.dex */
    public static abstract class WithReason extends MqttMessageWithUserProperties {

        /* renamed from: c  reason: collision with root package name */
        private final MqttUtf8StringImpl f18468c;

        /* loaded from: classes3.dex */
        public static abstract class WithCode<R extends Mqtt5ReasonCode> extends WithReason {

            /* renamed from: d  reason: collision with root package name */
            private final R f18469d;

            /* loaded from: classes3.dex */
            public static abstract class WithId<R extends Mqtt5ReasonCode> extends WithCode<R> implements MqttMessage.WithId {

                /* renamed from: e  reason: collision with root package name */
                private final int f18470e;

                /* JADX INFO: Access modifiers changed from: protected */
                public WithId(int i8, R r7, MqttUtf8StringImpl mqttUtf8StringImpl, MqttUserPropertiesImpl mqttUserPropertiesImpl) {
                    super(r7, mqttUtf8StringImpl, mqttUserPropertiesImpl);
                    this.f18470e = i8;
                }

                @Override // com.hivemq.client.internal.mqtt.message.MqttMessage.WithId
                public int a() {
                    return this.f18470e;
                }

                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.hivemq.client.internal.mqtt.message.MqttMessageWithUserProperties.WithReason, com.hivemq.client.internal.mqtt.message.MqttMessageWithUserProperties
                public String e() {
                    return "packetIdentifier=" + this.f18470e + StringUtil.a(", ", super.e());
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            public WithCode(R r7, MqttUtf8StringImpl mqttUtf8StringImpl, MqttUserPropertiesImpl mqttUserPropertiesImpl) {
                super(mqttUtf8StringImpl, mqttUserPropertiesImpl);
                this.f18469d = r7;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.hivemq.client.internal.mqtt.message.MqttMessageWithUserProperties.WithReason, com.hivemq.client.internal.mqtt.message.MqttMessageWithUserProperties
            public int d() {
                return (super.d() * 31) + this.f18469d.hashCode();
            }

            public R h() {
                return this.f18469d;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            public boolean i(WithCode<R> withCode) {
                if (super.g(withCode) && this.f18469d.equals(withCode.f18469d)) {
                    return true;
                }
                return false;
            }
        }

        /* loaded from: classes3.dex */
        public static abstract class WithCodesAndId<R extends Mqtt5ReasonCode> extends WithReason implements MqttMessage.WithId {

            /* renamed from: d  reason: collision with root package name */
            private final int f18471d;

            /* renamed from: e  reason: collision with root package name */
            private final ImmutableList<R> f18472e;

            /* JADX INFO: Access modifiers changed from: protected */
            public WithCodesAndId(int i8, ImmutableList<R> immutableList, MqttUtf8StringImpl mqttUtf8StringImpl, MqttUserPropertiesImpl mqttUserPropertiesImpl) {
                super(mqttUtf8StringImpl, mqttUserPropertiesImpl);
                this.f18471d = i8;
                this.f18472e = immutableList;
            }

            @Override // com.hivemq.client.internal.mqtt.message.MqttMessage.WithId
            public int a() {
                return this.f18471d;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.hivemq.client.internal.mqtt.message.MqttMessageWithUserProperties.WithReason, com.hivemq.client.internal.mqtt.message.MqttMessageWithUserProperties
            public int d() {
                return (super.d() * 31) + this.f18472e.hashCode();
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.hivemq.client.internal.mqtt.message.MqttMessageWithUserProperties.WithReason, com.hivemq.client.internal.mqtt.message.MqttMessageWithUserProperties
            public String e() {
                return "packetIdentifier=" + this.f18471d + StringUtil.a(", ", super.e());
            }

            public ImmutableList<R> h() {
                return this.f18472e;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            public boolean i(WithCodesAndId<R> withCodesAndId) {
                if (super.g(withCodesAndId) && this.f18472e.equals(withCodesAndId.f18472e)) {
                    return true;
                }
                return false;
            }
        }

        WithReason(MqttUtf8StringImpl mqttUtf8StringImpl, MqttUserPropertiesImpl mqttUserPropertiesImpl) {
            super(mqttUserPropertiesImpl);
            this.f18468c = mqttUtf8StringImpl;
        }

        @Override // com.hivemq.client.internal.mqtt.message.MqttMessageWithUserProperties
        protected int d() {
            return (super.d() * 31) + Objects.hashCode(this.f18468c);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.hivemq.client.internal.mqtt.message.MqttMessageWithUserProperties
        public String e() {
            if (this.f18468c == null) {
                return super.e();
            }
            return "reasonString=" + this.f18468c + StringUtil.a(", ", super.e());
        }

        public MqttUtf8StringImpl f() {
            return this.f18468c;
        }

        protected boolean g(WithReason withReason) {
            if (super.c(withReason) && Objects.equals(this.f18468c, withReason.f18468c)) {
                return true;
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public MqttMessageWithUserProperties(MqttUserPropertiesImpl mqttUserPropertiesImpl) {
        this.f18467b = mqttUserPropertiesImpl;
    }

    @Override // com.hivemq.client.internal.mqtt.message.MqttMessage.WithUserProperties
    public MqttUserPropertiesImpl b() {
        return this.f18467b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean c(MqttMessageWithUserProperties mqttMessageWithUserProperties) {
        return this.f18467b.equals(mqttMessageWithUserProperties.f18467b);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int d() {
        return this.f18467b.hashCode();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String e() {
        if (this.f18467b.a().isEmpty()) {
            return "";
        }
        return "userProperties=" + this.f18467b;
    }
}
