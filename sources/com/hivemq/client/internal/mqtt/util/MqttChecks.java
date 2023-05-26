package com.hivemq.client.internal.mqtt.util;

import com.hivemq.client.internal.mqtt.datatypes.MqttBinaryData;
import com.hivemq.client.internal.mqtt.datatypes.MqttUtf8StringImpl;
import com.hivemq.client.internal.mqtt.message.connect.MqttConnect;
import com.hivemq.client.internal.mqtt.message.connect.mqtt3.Mqtt3ConnectView;
import com.hivemq.client.internal.mqtt.message.disconnect.MqttDisconnect;
import com.hivemq.client.internal.mqtt.message.publish.MqttPublish;
import com.hivemq.client.internal.mqtt.message.publish.mqtt3.Mqtt3PublishView;
import com.hivemq.client.internal.mqtt.message.subscribe.MqttSubscribe;
import com.hivemq.client.internal.mqtt.message.subscribe.mqtt3.Mqtt3SubscribeView;
import com.hivemq.client.internal.util.Checks;
import com.hivemq.client.mqtt.mqtt3.message.connect.Mqtt3Connect;
import com.hivemq.client.mqtt.mqtt3.message.publish.Mqtt3Publish;
import com.hivemq.client.mqtt.mqtt3.message.subscribe.Mqtt3Subscribe;
import com.hivemq.client.mqtt.mqtt5.message.connect.Mqtt5Connect;
import com.hivemq.client.mqtt.mqtt5.message.disconnect.Mqtt5Disconnect;
import com.hivemq.client.mqtt.mqtt5.message.publish.Mqtt5Publish;
import com.hivemq.client.mqtt.mqtt5.message.subscribe.Mqtt5Subscribe;
import java.nio.ByteBuffer;
import okhttp3.internal.http2.Settings;

/* loaded from: classes3.dex */
public final class MqttChecks {
    private MqttChecks() {
    }

    public static ByteBuffer a(byte[] bArr, String str) {
        return b((byte[]) Checks.j(bArr, str), str);
    }

    private static ByteBuffer b(byte[] bArr, String str) {
        if (MqttBinaryData.h(bArr)) {
            return ByteBuffer.wrap(bArr);
        }
        throw new IllegalArgumentException(str + " can not be encoded as binary data. Maximum length is " + Settings.DEFAULT_INITIAL_WINDOW_SIZE + " bytes, but was " + bArr.length + " bytes.");
    }

    public static MqttConnect c(Mqtt3Connect mqtt3Connect) {
        return ((Mqtt3ConnectView) Checks.g(mqtt3Connect, Mqtt3ConnectView.class, "Connect")).b();
    }

    public static MqttConnect d(Mqtt5Connect mqtt5Connect) {
        return (MqttConnect) Checks.g(mqtt5Connect, MqttConnect.class, "Connect");
    }

    public static MqttDisconnect e(Mqtt5Disconnect mqtt5Disconnect) {
        return (MqttDisconnect) Checks.g(mqtt5Disconnect, MqttDisconnect.class, "Disconnect");
    }

    public static MqttPublish f(Mqtt3Publish mqtt3Publish) {
        return ((Mqtt3PublishView) Checks.g(mqtt3Publish, Mqtt3PublishView.class, "Publish")).d();
    }

    public static MqttPublish g(Mqtt5Publish mqtt5Publish) {
        return (MqttPublish) Checks.g(mqtt5Publish, MqttPublish.class, "Publish");
    }

    public static MqttUtf8StringImpl h(String str) {
        return i(str, "Reason string");
    }

    public static MqttUtf8StringImpl i(String str, String str2) {
        if (str == null) {
            return null;
        }
        return MqttUtf8StringImpl.l(str, str2);
    }

    public static MqttSubscribe j(Mqtt3Subscribe mqtt3Subscribe) {
        return ((Mqtt3SubscribeView) Checks.g(mqtt3Subscribe, Mqtt3SubscribeView.class, "Subscribe")).b();
    }

    public static MqttSubscribe k(Mqtt5Subscribe mqtt5Subscribe) {
        return (MqttSubscribe) Checks.g(mqtt5Subscribe, MqttSubscribe.class, "Subscribe");
    }
}
