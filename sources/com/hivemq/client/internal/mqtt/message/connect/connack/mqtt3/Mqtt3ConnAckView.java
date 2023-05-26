package com.hivemq.client.internal.mqtt.message.connect.connack.mqtt3;

import com.hivemq.client.internal.mqtt.datatypes.MqttUserPropertiesImpl;
import com.hivemq.client.internal.mqtt.message.connect.connack.MqttConnAck;
import com.hivemq.client.internal.mqtt.message.connect.connack.MqttConnAckRestrictions;
import com.hivemq.client.internal.mqtt.message.connect.connack.mqtt3.Mqtt3ConnAckView;
import com.hivemq.client.mqtt.mqtt3.message.connect.connack.Mqtt3ConnAck;
import com.hivemq.client.mqtt.mqtt3.message.connect.connack.Mqtt3ConnAckReturnCode;
import com.hivemq.client.mqtt.mqtt5.message.connect.connack.Mqtt5ConnAck;
import com.hivemq.client.mqtt.mqtt5.message.connect.connack.Mqtt5ConnAckReasonCode;
import io.reactivex.functions.Function;

/* loaded from: classes3.dex */
public class Mqtt3ConnAckView implements Mqtt3ConnAck {

    /* renamed from: b  reason: collision with root package name */
    public static final Function<Mqtt5ConnAck, Mqtt3ConnAck> f18526b = new Function() { // from class: j0.a
        @Override // io.reactivex.functions.Function
        public final Object apply(Object obj) {
            return Mqtt3ConnAckView.f((Mqtt5ConnAck) obj);
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private final MqttConnAck f18527a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.hivemq.client.internal.mqtt.message.connect.connack.mqtt3.Mqtt3ConnAckView$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f18528a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f18529b;

        static {
            int[] iArr = new int[Mqtt5ConnAckReasonCode.values().length];
            f18529b = iArr;
            try {
                iArr[Mqtt5ConnAckReasonCode.SUCCESS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f18529b[Mqtt5ConnAckReasonCode.UNSUPPORTED_PROTOCOL_VERSION.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f18529b[Mqtt5ConnAckReasonCode.CLIENT_IDENTIFIER_NOT_VALID.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f18529b[Mqtt5ConnAckReasonCode.SERVER_UNAVAILABLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f18529b[Mqtt5ConnAckReasonCode.BAD_USER_NAME_OR_PASSWORD.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f18529b[Mqtt5ConnAckReasonCode.NOT_AUTHORIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            int[] iArr2 = new int[Mqtt3ConnAckReturnCode.values().length];
            f18528a = iArr2;
            try {
                iArr2[Mqtt3ConnAckReturnCode.SUCCESS.ordinal()] = 1;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f18528a[Mqtt3ConnAckReturnCode.UNSUPPORTED_PROTOCOL_VERSION.ordinal()] = 2;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f18528a[Mqtt3ConnAckReturnCode.IDENTIFIER_REJECTED.ordinal()] = 3;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f18528a[Mqtt3ConnAckReturnCode.SERVER_UNAVAILABLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f18528a[Mqtt3ConnAckReturnCode.BAD_USER_NAME_OR_PASSWORD.ordinal()] = 5;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f18528a[Mqtt3ConnAckReturnCode.NOT_AUTHORIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    private Mqtt3ConnAckView(MqttConnAck mqttConnAck) {
        this.f18527a = mqttConnAck;
    }

    public static MqttConnAck b(Mqtt3ConnAckReturnCode mqtt3ConnAckReturnCode, boolean z7) {
        return new MqttConnAck(c(mqtt3ConnAckReturnCode), z7, -1L, -1, null, null, MqttConnAckRestrictions.f18517j, null, null, null, MqttUserPropertiesImpl.f17992c);
    }

    private static Mqtt5ConnAckReasonCode c(Mqtt3ConnAckReturnCode mqtt3ConnAckReturnCode) {
        switch (AnonymousClass1.f18528a[mqtt3ConnAckReturnCode.ordinal()]) {
            case 1:
                return Mqtt5ConnAckReasonCode.SUCCESS;
            case 2:
                return Mqtt5ConnAckReasonCode.UNSUPPORTED_PROTOCOL_VERSION;
            case 3:
                return Mqtt5ConnAckReasonCode.CLIENT_IDENTIFIER_NOT_VALID;
            case 4:
                return Mqtt5ConnAckReasonCode.SERVER_UNAVAILABLE;
            case 5:
                return Mqtt5ConnAckReasonCode.BAD_USER_NAME_OR_PASSWORD;
            case 6:
                return Mqtt5ConnAckReasonCode.NOT_AUTHORIZED;
            default:
                throw new IllegalStateException();
        }
    }

    public static Mqtt3ConnAckView e(MqttConnAck mqttConnAck) {
        return new Mqtt3ConnAckView(mqttConnAck);
    }

    public static Mqtt3ConnAckView f(Mqtt5ConnAck mqtt5ConnAck) {
        return new Mqtt3ConnAckView((MqttConnAck) mqtt5ConnAck);
    }

    private String g() {
        return "returnCode=" + a() + ", sessionPresent=" + d();
    }

    private static Mqtt3ConnAckReturnCode h(Mqtt5ConnAckReasonCode mqtt5ConnAckReasonCode) {
        switch (AnonymousClass1.f18529b[mqtt5ConnAckReasonCode.ordinal()]) {
            case 1:
                return Mqtt3ConnAckReturnCode.SUCCESS;
            case 2:
                return Mqtt3ConnAckReturnCode.UNSUPPORTED_PROTOCOL_VERSION;
            case 3:
                return Mqtt3ConnAckReturnCode.IDENTIFIER_REJECTED;
            case 4:
                return Mqtt3ConnAckReturnCode.SERVER_UNAVAILABLE;
            case 5:
                return Mqtt3ConnAckReturnCode.BAD_USER_NAME_OR_PASSWORD;
            case 6:
                return Mqtt3ConnAckReturnCode.NOT_AUTHORIZED;
            default:
                throw new IllegalStateException();
        }
    }

    @Override // com.hivemq.client.mqtt.mqtt3.message.connect.connack.Mqtt3ConnAck
    public Mqtt3ConnAckReturnCode a() {
        return h(this.f18527a.h());
    }

    public boolean d() {
        return this.f18527a.o();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Mqtt3ConnAckView)) {
            return false;
        }
        return this.f18527a.equals(((Mqtt3ConnAckView) obj).f18527a);
    }

    public int hashCode() {
        return this.f18527a.hashCode();
    }

    public String toString() {
        return "MqttConnAck{" + g() + '}';
    }
}
