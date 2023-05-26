package com.hivemq.client.internal.mqtt.codec;

import com.hivemq.client.internal.mqtt.MqttClientConfig;
import com.hivemq.client.internal.mqtt.codec.decoder.MqttMessageDecoders;
import com.hivemq.client.internal.mqtt.codec.decoder.mqtt3.Mqtt3ClientMessageDecoders;
import com.hivemq.client.internal.mqtt.codec.decoder.mqtt5.Mqtt5ClientMessageDecoders;
import com.hivemq.client.internal.mqtt.codec.encoder.MqttMessageEncoders;
import com.hivemq.client.internal.mqtt.codec.encoder.mqtt3.Mqtt3ClientMessageEncoders;
import com.hivemq.client.internal.mqtt.codec.encoder.mqtt5.Mqtt5ClientMessageEncoders;
import com.hivemq.client.mqtt.MqttVersion;
import dagger.Lazy;
import dagger.Module;
import dagger.Provides;

@Module
/* loaded from: classes3.dex */
public abstract class MqttCodecModule {

    /* renamed from: com.hivemq.client.internal.mqtt.codec.MqttCodecModule$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f17851a;

        static {
            int[] iArr = new int[MqttVersion.values().length];
            f17851a = iArr;
            try {
                iArr[MqttVersion.MQTT_5_0.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f17851a[MqttVersion.MQTT_3_1_1.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    public static MqttMessageDecoders a(MqttClientConfig mqttClientConfig, Lazy<Mqtt5ClientMessageDecoders> lazy, Lazy<Mqtt3ClientMessageDecoders> lazy2) {
        int i8 = AnonymousClass1.f17851a[mqttClientConfig.l().ordinal()];
        if (i8 != 1) {
            if (i8 == 2) {
                return lazy2.get();
            }
            throw new IllegalStateException();
        }
        return lazy.get();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    public static MqttMessageEncoders b(MqttClientConfig mqttClientConfig, Lazy<Mqtt5ClientMessageEncoders> lazy, Lazy<Mqtt3ClientMessageEncoders> lazy2) {
        int i8 = AnonymousClass1.f17851a[mqttClientConfig.l().ordinal()];
        if (i8 != 1) {
            if (i8 == 2) {
                return lazy2.get();
            }
            throw new IllegalStateException();
        }
        return lazy.get();
    }
}
