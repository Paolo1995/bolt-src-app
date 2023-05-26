package com.hivemq.client.internal.mqtt.codec.encoder.mqtt5;

import com.hivemq.client.internal.mqtt.codec.encoder.MqttEncoderContext;
import com.hivemq.client.internal.mqtt.codec.encoder.MqttMessageEncoder;
import com.hivemq.client.internal.mqtt.codec.encoder.MqttMessageEncoderUtil;
import com.hivemq.client.internal.mqtt.datatypes.MqttUtf8StringImpl;
import com.hivemq.client.internal.mqtt.datatypes.MqttVariableByteInteger;
import com.hivemq.client.internal.mqtt.message.auth.MqttEnhancedAuth;
import com.hivemq.client.internal.mqtt.message.auth.MqttSimpleAuth;
import com.hivemq.client.internal.mqtt.message.connect.MqttConnect;
import com.hivemq.client.internal.mqtt.message.connect.MqttConnectRestrictions;
import com.hivemq.client.internal.mqtt.message.connect.MqttStatefulConnect;
import com.hivemq.client.mqtt.mqtt5.message.Mqtt5MessageType;
import io.netty.buffer.ByteBuf;
import javax.inject.Inject;
import javax.inject.Singleton;
import okhttp3.internal.http2.Settings;

@Singleton
/* loaded from: classes3.dex */
public class Mqtt5ConnectEncoder extends MqttMessageEncoder<MqttStatefulConnect> {

    /* renamed from: b  reason: collision with root package name */
    private static final int f17963b = Mqtt5MessageType.CONNECT.c() << 4;

    /* renamed from: a  reason: collision with root package name */
    private final Mqtt5PublishEncoder f17964a;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Inject
    public Mqtt5ConnectEncoder(Mqtt5PublishEncoder mqtt5PublishEncoder) {
        this.f17964a = mqtt5PublishEncoder;
    }

    private ByteBuf d(MqttStatefulConnect mqttStatefulConnect, MqttEncoderContext mqttEncoderContext, int i8, int i9, int i10, int i11, int i12) {
        ByteBuf ioBuffer = mqttEncoderContext.a().ioBuffer(i8, i8);
        e(mqttStatefulConnect, ioBuffer, i9, i10, i11, i12);
        return ioBuffer;
    }

    private void e(MqttStatefulConnect mqttStatefulConnect, ByteBuf byteBuf, int i8, int i9, int i10, int i11) {
        f(byteBuf, i8);
        i(mqttStatefulConnect, byteBuf, i9, i11);
        g(mqttStatefulConnect, byteBuf, i10);
    }

    private void f(ByteBuf byteBuf, int i8) {
        byteBuf.writeByte(f17963b);
        MqttVariableByteInteger.b(i8, byteBuf);
    }

    private void g(MqttStatefulConnect mqttStatefulConnect, ByteBuf byteBuf, int i8) {
        MqttConnect c8 = mqttStatefulConnect.c();
        mqttStatefulConnect.e().h(byteBuf);
        j(c8, byteBuf, i8);
        MqttSimpleAuth i9 = c8.i();
        if (i9 != null) {
            MqttMessageEncoderUtil.a(i9.b(), byteBuf);
            MqttMessageEncoderUtil.b(i9.a(), byteBuf);
        }
    }

    private void h(MqttStatefulConnect mqttStatefulConnect, ByteBuf byteBuf, int i8, int i9) {
        MqttConnect c8 = mqttStatefulConnect.c();
        MqttVariableByteInteger.b(i8, byteBuf);
        Mqtt5MessageEncoderUtil.c(17, c8.l(), 0L, byteBuf);
        MqttEnhancedAuth f8 = mqttStatefulConnect.f();
        if (f8 != null) {
            Mqtt5MessageEncoderUtil.g(21, f8.getMethod(), byteBuf);
            Mqtt5MessageEncoderUtil.f(22, f8.b(), byteBuf);
        }
        MqttConnectRestrictions k8 = c8.k();
        if (k8 != MqttConnectRestrictions.f18498i) {
            Mqtt5MessageEncoderUtil.h(33, k8.b(), Settings.DEFAULT_INITIAL_WINDOW_SIZE, byteBuf);
            Mqtt5MessageEncoderUtil.c(39, k8.a(), 268435460L, byteBuf);
            Mqtt5MessageEncoderUtil.h(34, k8.f(), 0, byteBuf);
            Mqtt5MessageEncoderUtil.b(25, k8.h(), false, byteBuf);
            Mqtt5MessageEncoderUtil.b(23, k8.g(), true, byteBuf);
        }
        if (i9 == 0) {
            mqttStatefulConnect.b().d(byteBuf);
        }
    }

    private void i(MqttStatefulConnect mqttStatefulConnect, ByteBuf byteBuf, int i8, int i9) {
        MqttConnect c8 = mqttStatefulConnect.c();
        MqttUtf8StringImpl.f17997i.h(byteBuf);
        byteBuf.writeByte(5);
        MqttSimpleAuth i10 = c8.i();
        int i11 = 0;
        if (i10 != null) {
            if (i10.b() != null) {
                i11 = 128;
            }
            if (i10.a() != null) {
                i11 |= 64;
            }
        }
        c8.j();
        if (c8.m()) {
            i11 |= 2;
        }
        byteBuf.writeByte(i11);
        byteBuf.writeShort(c8.g());
        h(mqttStatefulConnect, byteBuf, i8, i9);
    }

    private void j(MqttConnect mqttConnect, ByteBuf byteBuf, int i8) {
        mqttConnect.j();
    }

    private int k(MqttStatefulConnect mqttStatefulConnect) {
        MqttConnect c8 = mqttStatefulConnect.c();
        int k8 = Mqtt5MessageEncoderUtil.k(c8.l(), 0L) + 0;
        MqttConnectRestrictions k9 = c8.k();
        if (k9 != MqttConnectRestrictions.f18498i) {
            k8 = k8 + Mqtt5MessageEncoderUtil.p(k9.b(), Settings.DEFAULT_INITIAL_WINDOW_SIZE) + Mqtt5MessageEncoderUtil.k(k9.a(), 268435460L) + Mqtt5MessageEncoderUtil.p(k9.f(), 0) + Mqtt5MessageEncoderUtil.a(k9.h(), false) + Mqtt5MessageEncoderUtil.a(k9.g(), true);
        }
        int e8 = k8 + mqttStatefulConnect.b().e();
        MqttEnhancedAuth f8 = mqttStatefulConnect.f();
        if (f8 != null) {
            return e8 + Mqtt5MessageEncoderUtil.o(f8.getMethod()) + Mqtt5MessageEncoderUtil.n(f8.b());
        }
        return e8;
    }

    private int l(MqttStatefulConnect mqttStatefulConnect, int i8, int i9) {
        if (i9 != 0) {
            if (i9 != 1) {
                return -1;
            }
            return i8 - mqttStatefulConnect.b().e();
        }
        return i8;
    }

    private int m(int i8, int i9, int i10) {
        int c8;
        int c9 = i8 + MqttMessageEncoderUtil.c(i9);
        if (i10 == -1) {
            c8 = 0;
        } else {
            c8 = MqttMessageEncoderUtil.c(i10);
        }
        return c9 + c8;
    }

    private int n(MqttStatefulConnect mqttStatefulConnect) {
        MqttConnect c8 = mqttStatefulConnect.c();
        int j8 = mqttStatefulConnect.e().j() + 10;
        MqttSimpleAuth i8 = c8.i();
        if (i8 != null) {
            j8 = j8 + MqttMessageEncoderUtil.f(i8.b()) + MqttMessageEncoderUtil.g(i8.a());
        }
        c8.j();
        return j8;
    }

    private int o(MqttStatefulConnect mqttStatefulConnect) {
        mqttStatefulConnect.c().j();
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.hivemq.client.internal.mqtt.codec.encoder.MqttMessageEncoder
    /* renamed from: c */
    public ByteBuf b(MqttStatefulConnect mqttStatefulConnect, MqttEncoderContext mqttEncoderContext) {
        int k8 = k(mqttStatefulConnect);
        int o8 = o(mqttStatefulConnect);
        int n8 = n(mqttStatefulConnect);
        int m8 = m(n8, k8, o8);
        int i8 = k8;
        int i9 = m8;
        int d8 = MqttMessageEncoderUtil.d(m8);
        int i10 = 0;
        while (d8 > mqttEncoderContext.b()) {
            i10++;
            i8 = l(mqttStatefulConnect, i8, i10);
            if (i8 >= 0) {
                i9 = m(n8, i8, o8);
                d8 = MqttMessageEncoderUtil.d(i9);
            } else {
                throw MqttMessageEncoderUtil.e(mqttStatefulConnect, d8, mqttEncoderContext.b());
            }
        }
        return d(mqttStatefulConnect, mqttEncoderContext, d8, i9, i8, o8, i10);
    }
}
