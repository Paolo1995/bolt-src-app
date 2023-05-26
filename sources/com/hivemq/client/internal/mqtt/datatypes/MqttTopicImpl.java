package com.hivemq.client.internal.mqtt.datatypes;

import com.hivemq.client.internal.util.Checks;
import com.hivemq.client.mqtt.datatypes.MqttTopic;
import io.netty.buffer.ByteBuf;

/* loaded from: classes3.dex */
public class MqttTopicImpl extends MqttUtf8StringImpl implements MqttTopic {
    private MqttTopicImpl(byte[] bArr) {
        super(bArr);
    }

    static void c(String str, String str2) {
        MqttUtf8StringImpl.c(str, str2);
        q(str, str2);
    }

    static boolean k(byte[] bArr) {
        if (!MqttUtf8StringImpl.k(bArr) && !r(bArr)) {
            return false;
        }
        return true;
    }

    private static void q(String str, String str2) {
        int indexOf = str.indexOf(35);
        if (indexOf == -1) {
            int indexOf2 = str.indexOf(43);
            if (indexOf2 == -1) {
                return;
            }
            throw new IllegalArgumentException(str2 + " [" + str + "] must not contain single level wildcard (+), found at index " + indexOf2 + ".");
        }
        throw new IllegalArgumentException(str2 + " [" + str + "] must not contain multi level wildcard (#), found at index " + indexOf + ".");
    }

    private static boolean r(byte[] bArr) {
        for (byte b8 : bArr) {
            if (b8 == 35 || b8 == 43) {
                return true;
            }
        }
        return false;
    }

    public static MqttTopicImpl s(ByteBuf byteBuf) {
        byte[] b8 = MqttBinaryData.b(byteBuf);
        if (b8 == null) {
            return null;
        }
        return v(b8);
    }

    public static MqttTopicImpl t(String str) {
        return u(str, "Topic");
    }

    public static MqttTopicImpl u(String str, String str2) {
        Checks.f(str, str2);
        MqttUtf8StringImpl.a(str, str2);
        c(str, str2);
        return new MqttTopicImpl(str);
    }

    public static MqttTopicImpl v(byte[] bArr) {
        if (bArr.length != 0 && MqttBinaryData.h(bArr) && !k(bArr)) {
            return new MqttTopicImpl(bArr);
        }
        return null;
    }

    private MqttTopicImpl(String str) {
        super(str);
    }
}
