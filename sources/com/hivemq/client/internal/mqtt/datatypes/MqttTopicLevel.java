package com.hivemq.client.internal.mqtt.datatypes;

import com.hivemq.client.internal.util.ByteArray;
import java.util.Arrays;

/* loaded from: classes3.dex */
public class MqttTopicLevel extends ByteArray {

    /* renamed from: b  reason: collision with root package name */
    private static final MqttTopicLevel f17990b = new MqttTopicLevel(new byte[]{43});

    /* JADX INFO: Access modifiers changed from: package-private */
    public MqttTopicLevel(byte[] bArr) {
        super(bArr);
    }

    private static boolean f(byte[] bArr, int i8, int i9) {
        if (i9 - i8 == 1 && bArr[i8] == 43) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static MqttTopicLevel g(byte[] bArr, int i8, int i9) {
        if (f(bArr, i8, i9)) {
            return f17990b;
        }
        return new MqttTopicLevel(Arrays.copyOfRange(bArr, i8, i9));
    }

    public static MqttTopicFilterImpl h(byte[] bArr, MqttTopicLevel mqttTopicLevel, boolean z7) {
        int i8;
        int i9;
        if (bArr != null) {
            i8 = bArr.length + 1 + 0;
        } else {
            i8 = 0;
        }
        if (mqttTopicLevel != null) {
            i8 += mqttTopicLevel.f18667a.length;
        }
        if (z7) {
            if (mqttTopicLevel != null) {
                i8++;
            }
            i8++;
        }
        byte[] bArr2 = new byte[i8];
        if (bArr != null) {
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            int length = bArr.length + 0;
            bArr2[length] = 47;
            i9 = length + 1;
        } else {
            i9 = 0;
        }
        if (mqttTopicLevel != null) {
            byte[] bArr3 = mqttTopicLevel.f18667a;
            System.arraycopy(bArr3, 0, bArr2, i9, bArr3.length);
            i9 += mqttTopicLevel.f18667a.length;
        }
        if (z7) {
            if (mqttTopicLevel != null) {
                bArr2[i9] = 47;
                i9++;
            }
            bArr2[i9] = 35;
        }
        return MqttTopicFilterImpl.u(bArr2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public byte[] d() {
        return this.f18667a;
    }

    public boolean e() {
        return f(this.f18667a, b(), a());
    }

    public MqttTopicLevel i() {
        return this;
    }
}
