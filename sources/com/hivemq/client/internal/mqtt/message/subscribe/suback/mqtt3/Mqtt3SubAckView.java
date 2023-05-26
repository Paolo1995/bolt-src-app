package com.hivemq.client.internal.mqtt.message.subscribe.suback.mqtt3;

import com.hivemq.client.internal.mqtt.datatypes.MqttUserPropertiesImpl;
import com.hivemq.client.internal.mqtt.message.subscribe.suback.MqttSubAck;
import com.hivemq.client.internal.mqtt.message.subscribe.suback.mqtt3.Mqtt3SubAckView;
import com.hivemq.client.internal.util.collections.ImmutableList;
import com.hivemq.client.internal.util.collections.b;
import com.hivemq.client.mqtt.mqtt3.message.subscribe.suback.Mqtt3SubAck;
import com.hivemq.client.mqtt.mqtt3.message.subscribe.suback.Mqtt3SubAckReturnCode;
import com.hivemq.client.mqtt.mqtt5.message.subscribe.suback.Mqtt5SubAck;
import com.hivemq.client.mqtt.mqtt5.message.subscribe.suback.Mqtt5SubAckReasonCode;
import io.reactivex.functions.Function;

/* loaded from: classes3.dex */
public class Mqtt3SubAckView implements Mqtt3SubAck {

    /* renamed from: b  reason: collision with root package name */
    public static final Function<Mqtt5SubAck, Mqtt3SubAck> f18615b = new Function() { // from class: k0.a
        @Override // io.reactivex.functions.Function
        public final Object apply(Object obj) {
            return Mqtt3SubAckView.g((Mqtt5SubAck) obj);
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private final MqttSubAck f18616a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.hivemq.client.internal.mqtt.message.subscribe.suback.mqtt3.Mqtt3SubAckView$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f18617a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f18618b;

        static {
            int[] iArr = new int[Mqtt5SubAckReasonCode.values().length];
            f18618b = iArr;
            try {
                iArr[Mqtt5SubAckReasonCode.GRANTED_QOS_0.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f18618b[Mqtt5SubAckReasonCode.GRANTED_QOS_1.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f18618b[Mqtt5SubAckReasonCode.GRANTED_QOS_2.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f18618b[Mqtt5SubAckReasonCode.UNSPECIFIED_ERROR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[Mqtt3SubAckReturnCode.values().length];
            f18617a = iArr2;
            try {
                iArr2[Mqtt3SubAckReturnCode.SUCCESS_MAXIMUM_QOS_0.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f18617a[Mqtt3SubAckReturnCode.SUCCESS_MAXIMUM_QOS_1.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f18617a[Mqtt3SubAckReturnCode.SUCCESS_MAXIMUM_QOS_2.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f18617a[Mqtt3SubAckReturnCode.FAILURE.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    private Mqtt3SubAckView(MqttSubAck mqttSubAck) {
        this.f18616a = mqttSubAck;
    }

    public static MqttSubAck b(int i8, ImmutableList<Mqtt3SubAckReturnCode> immutableList) {
        return new MqttSubAck(i8, d(immutableList), null, MqttUserPropertiesImpl.f17992c);
    }

    private static Mqtt5SubAckReasonCode c(Mqtt3SubAckReturnCode mqtt3SubAckReturnCode) {
        int i8 = AnonymousClass1.f18617a[mqtt3SubAckReturnCode.ordinal()];
        if (i8 != 1) {
            if (i8 != 2) {
                if (i8 != 3) {
                    if (i8 == 4) {
                        return Mqtt5SubAckReasonCode.UNSPECIFIED_ERROR;
                    }
                    throw new IllegalStateException();
                }
                return Mqtt5SubAckReasonCode.GRANTED_QOS_2;
            }
            return Mqtt5SubAckReasonCode.GRANTED_QOS_1;
        }
        return Mqtt5SubAckReasonCode.GRANTED_QOS_0;
    }

    private static ImmutableList<Mqtt5SubAckReasonCode> d(ImmutableList<Mqtt3SubAckReturnCode> immutableList) {
        ImmutableList.Builder w7 = b.w(immutableList.size());
        for (int i8 = 0; i8 < immutableList.size(); i8++) {
            w7.a(c(immutableList.get(i8)));
        }
        return w7.b();
    }

    public static Mqtt3SubAckView f(MqttSubAck mqttSubAck) {
        return new Mqtt3SubAckView(mqttSubAck);
    }

    public static Mqtt3SubAckView g(Mqtt5SubAck mqtt5SubAck) {
        return new Mqtt3SubAckView((MqttSubAck) mqtt5SubAck);
    }

    private String h() {
        return "returnCodes=" + a();
    }

    private static Mqtt3SubAckReturnCode i(Mqtt5SubAckReasonCode mqtt5SubAckReasonCode) {
        int i8 = AnonymousClass1.f18618b[mqtt5SubAckReasonCode.ordinal()];
        if (i8 != 1) {
            if (i8 != 2) {
                if (i8 != 3) {
                    if (i8 == 4) {
                        return Mqtt3SubAckReturnCode.FAILURE;
                    }
                    throw new IllegalStateException();
                }
                return Mqtt3SubAckReturnCode.SUCCESS_MAXIMUM_QOS_2;
            }
            return Mqtt3SubAckReturnCode.SUCCESS_MAXIMUM_QOS_1;
        }
        return Mqtt3SubAckReturnCode.SUCCESS_MAXIMUM_QOS_0;
    }

    private static ImmutableList<Mqtt3SubAckReturnCode> j(ImmutableList<Mqtt5SubAckReasonCode> immutableList) {
        ImmutableList.Builder w7 = b.w(immutableList.size());
        for (int i8 = 0; i8 < immutableList.size(); i8++) {
            w7.a(i(immutableList.get(i8)));
        }
        return w7.b();
    }

    @Override // com.hivemq.client.mqtt.mqtt3.message.subscribe.suback.Mqtt3SubAck
    /* renamed from: e */
    public ImmutableList<Mqtt3SubAckReturnCode> a() {
        return j(this.f18616a.h());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Mqtt3SubAckView)) {
            return false;
        }
        return this.f18616a.equals(((Mqtt3SubAckView) obj).f18616a);
    }

    public int hashCode() {
        return this.f18616a.hashCode();
    }

    public String toString() {
        return "MqttSubAck{" + h() + "}";
    }
}
