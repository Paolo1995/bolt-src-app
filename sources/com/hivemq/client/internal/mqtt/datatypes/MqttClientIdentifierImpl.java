package com.hivemq.client.internal.mqtt.datatypes;

import com.hivemq.client.internal.util.Checks;
import io.netty.buffer.ByteBuf;

/* loaded from: classes3.dex */
public class MqttClientIdentifierImpl extends MqttUtf8StringImpl {

    /* renamed from: j  reason: collision with root package name */
    public static final MqttClientIdentifierImpl f17982j = new MqttClientIdentifierImpl(new byte[0]);

    private MqttClientIdentifierImpl(byte[] bArr) {
        super(bArr);
    }

    public static MqttClientIdentifierImpl q(ByteBuf byteBuf) {
        byte[] b8 = MqttBinaryData.b(byteBuf);
        if (b8 == null) {
            return null;
        }
        return s(b8);
    }

    public static MqttClientIdentifierImpl r(String str) {
        Checks.j(str, "Client identifier");
        MqttUtf8StringImpl.a(str, "Client identifier");
        MqttUtf8StringImpl.c(str, "Client identifier");
        return new MqttClientIdentifierImpl(str);
    }

    public static MqttClientIdentifierImpl s(byte[] bArr) {
        if (MqttBinaryData.h(bArr) && !MqttUtf8StringImpl.k(bArr)) {
            return new MqttClientIdentifierImpl(bArr);
        }
        return null;
    }

    private MqttClientIdentifierImpl(String str) {
        super(str);
    }
}
