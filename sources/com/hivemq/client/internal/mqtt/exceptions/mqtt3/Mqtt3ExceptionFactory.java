package com.hivemq.client.internal.mqtt.exceptions.mqtt3;

import com.hivemq.client.internal.mqtt.exceptions.mqtt3.Mqtt3ExceptionFactory;
import com.hivemq.client.internal.mqtt.message.connect.connack.MqttConnAck;
import com.hivemq.client.internal.mqtt.message.connect.connack.mqtt3.Mqtt3ConnAckView;
import com.hivemq.client.internal.mqtt.message.subscribe.suback.MqttSubAck;
import com.hivemq.client.internal.mqtt.message.subscribe.suback.mqtt3.Mqtt3SubAckView;
import com.hivemq.client.mqtt.exceptions.MqttSessionExpiredException;
import com.hivemq.client.mqtt.mqtt3.exceptions.Mqtt3ConnAckException;
import com.hivemq.client.mqtt.mqtt3.exceptions.Mqtt3DisconnectException;
import com.hivemq.client.mqtt.mqtt3.exceptions.Mqtt3MessageException;
import com.hivemq.client.mqtt.mqtt3.exceptions.Mqtt3PubAckException;
import com.hivemq.client.mqtt.mqtt3.exceptions.Mqtt3PubRecException;
import com.hivemq.client.mqtt.mqtt3.exceptions.Mqtt3SubAckException;
import com.hivemq.client.mqtt.mqtt3.exceptions.Mqtt3UnsubAckException;
import com.hivemq.client.mqtt.mqtt5.exceptions.Mqtt5MessageException;
import com.hivemq.client.mqtt.mqtt5.message.Mqtt5Message;
import com.hivemq.client.mqtt.mqtt5.message.Mqtt5MessageType;
import io.reactivex.functions.Function;
import j$.util.function.Function;

/* loaded from: classes3.dex */
public final class Mqtt3ExceptionFactory {

    /* renamed from: a  reason: collision with root package name */
    public static final Function<Throwable, Throwable> f18001a = new Function() { // from class: f0.a
        @Override // io.reactivex.functions.Function
        public final Object apply(Object obj) {
            return Mqtt3ExceptionFactory.c((Throwable) obj);
        }
    };

    /* renamed from: b  reason: collision with root package name */
    public static final j$.util.function.Function<Throwable, Throwable> f18002b = new j$.util.function.Function() { // from class: f0.b
        @Override // j$.util.function.Function
        public /* synthetic */ j$.util.function.Function andThen(j$.util.function.Function function) {
            return Function.CC.$default$andThen(this, function);
        }

        @Override // j$.util.function.Function
        public final Object apply(Object obj) {
            return Mqtt3ExceptionFactory.c((Throwable) obj);
        }

        @Override // j$.util.function.Function
        public /* synthetic */ j$.util.function.Function compose(j$.util.function.Function function) {
            return Function.CC.$default$compose(this, function);
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.hivemq.client.internal.mqtt.exceptions.mqtt3.Mqtt3ExceptionFactory$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f18003a;

        static {
            int[] iArr = new int[Mqtt5MessageType.values().length];
            f18003a = iArr;
            try {
                iArr[Mqtt5MessageType.CONNACK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f18003a[Mqtt5MessageType.DISCONNECT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f18003a[Mqtt5MessageType.PUBACK.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f18003a[Mqtt5MessageType.PUBREC.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f18003a[Mqtt5MessageType.SUBACK.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f18003a[Mqtt5MessageType.UNSUBACK.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    private Mqtt3ExceptionFactory() {
    }

    public static Mqtt3MessageException a(Mqtt5MessageException mqtt5MessageException) {
        Mqtt5Message a8 = mqtt5MessageException.a();
        String message = mqtt5MessageException.getMessage();
        Throwable cause = mqtt5MessageException.getCause();
        switch (AnonymousClass1.f18003a[a8.getType().ordinal()]) {
            case 1:
                return new Mqtt3ConnAckException(Mqtt3ConnAckView.e((MqttConnAck) a8), message, cause);
            case 2:
                return new Mqtt3DisconnectException(message, cause);
            case 3:
                return new Mqtt3PubAckException(message, cause);
            case 4:
                return new Mqtt3PubRecException(message, cause);
            case 5:
                return new Mqtt3SubAckException(Mqtt3SubAckView.f((MqttSubAck) a8), message, cause);
            case 6:
                return new Mqtt3UnsubAckException(message, cause);
            default:
                throw new IllegalStateException();
        }
    }

    public static RuntimeException b(RuntimeException runtimeException) {
        if (runtimeException instanceof Mqtt5MessageException) {
            return a((Mqtt5MessageException) runtimeException);
        }
        if (runtimeException instanceof MqttSessionExpiredException) {
            Throwable cause = runtimeException.getCause();
            if (cause instanceof Mqtt5MessageException) {
                return new MqttSessionExpiredException(runtimeException.getMessage(), a((Mqtt5MessageException) cause));
            }
        }
        return runtimeException;
    }

    public static Throwable c(Throwable th) {
        if (th instanceof RuntimeException) {
            return b((RuntimeException) th);
        }
        return th;
    }
}
