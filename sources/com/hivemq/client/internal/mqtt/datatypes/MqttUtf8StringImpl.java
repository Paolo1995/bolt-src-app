package com.hivemq.client.internal.mqtt.datatypes;

import com.hivemq.client.internal.util.Checks;
import com.hivemq.client.internal.util.Utf8Util;
import com.hivemq.client.mqtt.datatypes.MqttUtf8String;
import io.netty.buffer.ByteBuf;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import okhttp3.internal.http2.Settings;

/* loaded from: classes3.dex */
public class MqttUtf8StringImpl implements MqttUtf8String {

    /* renamed from: i  reason: collision with root package name */
    public static final MqttUtf8StringImpl f17997i = new MqttUtf8StringImpl("MQTT".getBytes(StandardCharsets.UTF_8));

    /* renamed from: f  reason: collision with root package name */
    private byte[] f17998f;

    /* renamed from: g  reason: collision with root package name */
    private String f17999g;

    /* renamed from: h  reason: collision with root package name */
    private int f18000h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public MqttUtf8StringImpl(byte[] bArr) {
        this.f17998f = bArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(String str, String str2) {
        int a8;
        if (str.length() * 3 > 65535 && (a8 = Utf8Util.a(str)) > 65535) {
            throw new IllegalArgumentException(str2 + " [" + str.substring(0, 10) + "...] must not be longer than " + Settings.DEFAULT_INITIAL_WINDOW_SIZE + " bytes, but was " + a8 + " bytes.");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void c(String str, String str2) {
        boolean z7 = false;
        for (int i8 = 0; i8 < str.length(); i8++) {
            char charAt = str.charAt(i8);
            if (charAt != 0) {
                if (z7 == Character.isLowSurrogate(charAt)) {
                    z7 = Character.isHighSurrogate(charAt);
                } else {
                    throw new IllegalArgumentException(str2 + " [" + str + "] must not contain unmatched UTF-16 surrogate, found at index " + i8 + ".");
                }
            } else {
                throw new IllegalArgumentException(str2 + " [" + str + "] must not contain null character (U+0000), found at index " + i8 + ".");
            }
        }
        if (!z7) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str2);
        sb.append(" [");
        sb.append(str);
        sb.append("] must not contain unmatched UTF-16 surrogate, found at index ");
        sb.append(str.length() - 1);
        sb.append(".");
        throw new IllegalArgumentException(sb.toString());
    }

    public static MqttUtf8StringImpl f(ByteBuf byteBuf) {
        byte[] b8 = MqttBinaryData.b(byteBuf);
        if (b8 == null) {
            return null;
        }
        return m(b8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean k(byte[] bArr) {
        if (Utf8Util.b(bArr) != 0) {
            return true;
        }
        for (byte b8 : bArr) {
            if (b8 == 0) {
                return true;
            }
        }
        return false;
    }

    public static MqttUtf8StringImpl l(String str, String str2) {
        Checks.j(str, str2);
        a(str, str2);
        c(str, str2);
        return new MqttUtf8StringImpl(str);
    }

    public static MqttUtf8StringImpl m(byte[] bArr) {
        if (MqttBinaryData.h(bArr) && !k(bArr)) {
            return new MqttUtf8StringImpl(bArr);
        }
        return null;
    }

    @Override // java.lang.Comparable
    /* renamed from: e */
    public int compareTo(MqttUtf8String mqttUtf8String) {
        return toString().compareTo(mqttUtf8String.toString());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MqttUtf8StringImpl)) {
            return false;
        }
        MqttUtf8StringImpl mqttUtf8StringImpl = (MqttUtf8StringImpl) obj;
        String str = this.f17999g;
        String str2 = mqttUtf8StringImpl.f17999g;
        if (str != null && str2 != null) {
            return str.equals(str2);
        }
        byte[] bArr = this.f17998f;
        byte[] bArr2 = mqttUtf8StringImpl.f17998f;
        if (bArr != null && bArr2 != null) {
            return Arrays.equals(bArr, bArr2);
        }
        return toString().equals(mqttUtf8StringImpl.toString());
    }

    public void h(ByteBuf byteBuf) {
        MqttBinaryData.d(p(), byteBuf);
    }

    public int hashCode() {
        return toString().hashCode();
    }

    public int j() {
        return MqttBinaryData.g(p());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public byte[] p() {
        byte[] bArr = this.f17998f;
        if (bArr == null) {
            String str = this.f17999g;
            if (str == null) {
                return p();
            }
            bArr = str.getBytes(StandardCharsets.UTF_8);
            this.f17998f = bArr;
            int i8 = this.f18000h + 1;
            this.f18000h = i8;
            if (i8 < 3) {
                this.f17999g = null;
            }
        }
        return bArr;
    }

    public String toString() {
        String str = this.f17999g;
        if (str == null) {
            byte[] bArr = this.f17998f;
            if (bArr == null) {
                return toString();
            }
            String str2 = new String(bArr, StandardCharsets.UTF_8);
            this.f17999g = str2;
            int i8 = this.f18000h + 1;
            this.f18000h = i8;
            if (i8 < 3) {
                this.f17998f = null;
            }
            return str2;
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MqttUtf8StringImpl(String str) {
        this.f17999g = str;
    }
}
