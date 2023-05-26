package eu.bolt.chat.network.mapper;

import com.hivemq.client.mqtt.mqtt3.exceptions.Mqtt3ConnAckException;
import com.hivemq.client.mqtt.mqtt3.exceptions.Mqtt3DisconnectException;
import com.hivemq.client.mqtt.mqtt3.message.connect.connack.Mqtt3ConnAckReturnCode;
import eu.bolt.chat.network.data.ConnAckReturnCode;
import eu.bolt.chat.network.exception.ConnectionAckException;
import eu.bolt.chat.network.exception.ConnectionClosedException;
import eu.bolt.chat.network.exception.ConnectionFailedException;
import eu.bolt.chat.network.exception.DisconnectException;
import eu.bolt.chat.network.exception.MqttException;
import eu.bolt.chat.network.exception.PublishingException;
import eu.bolt.chat.network.exception.SubscriptionException;
import eu.bolt.chat.network.exception.UnknownMqttException;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ExceptionMapper.kt */
/* loaded from: classes5.dex */
public final class ExceptionMapper {

    /* compiled from: ExceptionMapper.kt */
    /* loaded from: classes5.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f39536a;

        static {
            int[] iArr = new int[Mqtt3ConnAckReturnCode.values().length];
            try {
                iArr[Mqtt3ConnAckReturnCode.SUCCESS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Mqtt3ConnAckReturnCode.UNSUPPORTED_PROTOCOL_VERSION.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Mqtt3ConnAckReturnCode.SERVER_UNAVAILABLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[Mqtt3ConnAckReturnCode.IDENTIFIER_REJECTED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[Mqtt3ConnAckReturnCode.BAD_USER_NAME_OR_PASSWORD.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[Mqtt3ConnAckReturnCode.NOT_AUTHORIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            f39536a = iArr;
        }
    }

    private final ConnectionAckException a(Mqtt3ConnAckException mqtt3ConnAckException) {
        Mqtt3ConnAckReturnCode a8 = mqtt3ConnAckException.a().a();
        Intrinsics.e(a8, "error.mqttMessage.returnCode");
        return new ConnectionAckException(i(a8), mqtt3ConnAckException.getMessage(), mqtt3ConnAckException);
    }

    private final ConnectionClosedException b(com.hivemq.client.mqtt.exceptions.ConnectionClosedException connectionClosedException) {
        return new ConnectionClosedException(connectionClosedException.getMessage(), connectionClosedException);
    }

    private final ConnectionFailedException d(com.hivemq.client.mqtt.exceptions.ConnectionFailedException connectionFailedException) {
        return new ConnectionFailedException(connectionFailedException.getMessage(), connectionFailedException);
    }

    private final DisconnectException e(Mqtt3DisconnectException mqtt3DisconnectException) {
        return new DisconnectException(mqtt3DisconnectException.getMessage(), mqtt3DisconnectException);
    }

    private final UnknownMqttException h(Throwable th) {
        return new UnknownMqttException(th.getMessage(), th);
    }

    private final ConnAckReturnCode i(Mqtt3ConnAckReturnCode mqtt3ConnAckReturnCode) {
        switch (WhenMappings.f39536a[mqtt3ConnAckReturnCode.ordinal()]) {
            case 1:
                return ConnAckReturnCode.SUCCESS;
            case 2:
                return ConnAckReturnCode.UNACCEPTABLE_PROTOCOL_VERSION;
            case 3:
                return ConnAckReturnCode.SERVER_UNAVAILABLE;
            case 4:
                return ConnAckReturnCode.IDENTIFIER_REJECTED;
            case 5:
                return ConnAckReturnCode.BAD_USERNAME_OR_PASSWORD;
            case 6:
                return ConnAckReturnCode.NOT_AUTHORIZED;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public final MqttException c(Throwable error) {
        Intrinsics.f(error, "error");
        if (error instanceof Mqtt3ConnAckException) {
            return a((Mqtt3ConnAckException) error);
        }
        if (error instanceof com.hivemq.client.mqtt.exceptions.ConnectionFailedException) {
            return d((com.hivemq.client.mqtt.exceptions.ConnectionFailedException) error);
        }
        if (error instanceof com.hivemq.client.mqtt.exceptions.ConnectionClosedException) {
            return b((com.hivemq.client.mqtt.exceptions.ConnectionClosedException) error);
        }
        if (error instanceof Mqtt3DisconnectException) {
            return e((Mqtt3DisconnectException) error);
        }
        return h(error);
    }

    public final PublishingException f(Throwable error) {
        Intrinsics.f(error, "error");
        return new PublishingException(error.getMessage(), error);
    }

    public final SubscriptionException g(Throwable error) {
        Intrinsics.f(error, "error");
        return new SubscriptionException(error.getMessage(), error);
    }
}
