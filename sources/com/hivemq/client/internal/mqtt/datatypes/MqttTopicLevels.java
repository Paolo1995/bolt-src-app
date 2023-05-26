package com.hivemq.client.internal.mqtt.datatypes;

import com.hivemq.client.internal.util.ByteArrayUtil;
import java.util.Arrays;

/* loaded from: classes3.dex */
public class MqttTopicLevels extends MqttTopicLevel {

    /* renamed from: c  reason: collision with root package name */
    private final int f17991c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public MqttTopicLevels(byte[] bArr, int i8) {
        super(bArr);
        this.f17991c = i8;
    }

    public static MqttTopicLevels l(MqttTopicLevel mqttTopicLevel, MqttTopicLevel mqttTopicLevel2) {
        byte[] d8 = mqttTopicLevel.i().d();
        byte[] d9 = mqttTopicLevel2.i().d();
        byte[] bArr = new byte[d8.length + 1 + d9.length];
        System.arraycopy(d8, 0, bArr, 0, d8.length);
        bArr[d8.length] = 47;
        System.arraycopy(d9, 0, bArr, d8.length + 1, d9.length);
        return new MqttTopicLevels(bArr, mqttTopicLevel.c());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.hivemq.client.internal.util.ByteArray
    public int a() {
        return this.f17991c;
    }

    public MqttTopicLevel j(int i8) {
        int i9 = i8 + 1;
        int c8 = ByteArrayUtil.c(this.f18667a, i9, (byte) 47);
        byte[] bArr = this.f18667a;
        if (c8 == bArr.length) {
            return MqttTopicLevel.g(bArr, i9, bArr.length);
        }
        return new MqttTopicLevels(Arrays.copyOfRange(bArr, i9, bArr.length), c8 - i9);
    }

    public MqttTopicLevel k(int i8) {
        byte[] bArr = this.f18667a;
        if (i8 == bArr.length) {
            return this;
        }
        int i9 = this.f17991c;
        if (i8 == i9) {
            return MqttTopicLevel.g(bArr, 0, i9);
        }
        return new MqttTopicLevels(Arrays.copyOfRange(bArr, 0, i8), this.f17991c);
    }
}
