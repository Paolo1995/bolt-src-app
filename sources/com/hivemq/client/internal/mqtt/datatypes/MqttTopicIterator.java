package com.hivemq.client.internal.mqtt.datatypes;

import com.hivemq.client.internal.util.ByteArrayUtil;
import java.util.Arrays;
import java.util.NoSuchElementException;

/* loaded from: classes3.dex */
public class MqttTopicIterator extends MqttTopicLevel {

    /* renamed from: c  reason: collision with root package name */
    private int f17987c;

    /* renamed from: d  reason: collision with root package name */
    private int f17988d;

    /* renamed from: e  reason: collision with root package name */
    private final int f17989e;

    private MqttTopicIterator(byte[] bArr, int i8, int i9, int i10) {
        super(bArr);
        this.f17987c = i8;
        this.f17988d = i9;
        this.f17989e = i10;
    }

    public static MqttTopicIterator q(MqttTopicFilterImpl mqttTopicFilterImpl) {
        int length;
        byte[] p8 = mqttTopicFilterImpl.p();
        int r7 = mqttTopicFilterImpl.r() - 1;
        if (mqttTopicFilterImpl.q()) {
            length = p8.length - 2;
        } else {
            length = p8.length;
        }
        return new MqttTopicIterator(p8, r7, r7, length);
    }

    public static MqttTopicIterator r(MqttTopicImpl mqttTopicImpl) {
        byte[] p8 = mqttTopicImpl.p();
        return new MqttTopicIterator(p8, -1, -1, p8.length);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.hivemq.client.internal.util.ByteArray
    public int a() {
        return this.f17988d;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.hivemq.client.internal.util.ByteArray
    public int b() {
        return this.f17987c;
    }

    @Override // com.hivemq.client.internal.mqtt.datatypes.MqttTopicLevel
    public MqttTopicLevel i() {
        if (!o()) {
            return MqttTopicLevel.g(this.f18667a, this.f17987c, this.f17988d);
        }
        int i8 = this.f17987c;
        int i9 = this.f17988d;
        int i10 = this.f17989e;
        this.f17988d = i10;
        this.f17987c = i10;
        return new MqttTopicLevels(Arrays.copyOfRange(this.f18667a, i8, this.f17989e), i9 - i8);
    }

    public MqttTopicIterator j() {
        return new MqttTopicIterator(this.f18667a, this.f17987c, this.f17988d, this.f17989e);
    }

    public boolean k(MqttTopicLevels mqttTopicLevels) {
        byte[] d8 = mqttTopicLevels.d();
        int a8 = mqttTopicLevels.a();
        int i8 = this.f17988d;
        int length = (d8.length + i8) - a8;
        int i9 = this.f17989e;
        if (length <= i9) {
            if ((length == i9 || this.f18667a[length] == 47) && ByteArrayUtil.a(this.f18667a, i8 + 1, length, d8, a8 + 1, d8.length)) {
                this.f17988d = length;
                this.f17987c = length;
                return true;
            }
            return false;
        }
        return false;
    }

    public boolean l(MqttTopicLevels mqttTopicLevels) {
        boolean z7;
        boolean z8;
        if (!o()) {
            return false;
        }
        int i8 = this.f17988d + 1;
        int a8 = mqttTopicLevels.a() + 1;
        byte[] d8 = mqttTopicLevels.d();
        while (true) {
            if (i8 == this.f17989e) {
                z7 = true;
            } else {
                z7 = false;
            }
            if (a8 == d8.length) {
                z8 = true;
            } else {
                z8 = false;
            }
            if (z8) {
                if (!z7 && this.f18667a[i8] != 47) {
                    return false;
                }
                this.f17988d = i8;
                this.f17987c = i8;
                return true;
            } else if (z7) {
                return false;
            } else {
                byte b8 = d8[a8];
                if (this.f18667a[i8] == b8) {
                    i8++;
                } else if (b8 != 43) {
                    return false;
                } else {
                    while (i8 < this.f17989e && this.f18667a[i8] != 47) {
                        i8++;
                    }
                }
                a8++;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x003e, code lost:
        if (r5 != false) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0042, code lost:
        if (r9[r3] != 47) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0044, code lost:
        if (r4 != false) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x004a, code lost:
        if (r8.f18667a[r2] != 47) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x004c, code lost:
        r0 = r2;
        r1 = r3;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int m(com.hivemq.client.internal.mqtt.datatypes.MqttTopicLevels r9) {
        /*
            r8 = this;
            boolean r0 = r8.o()
            if (r0 != 0) goto Lb
            int r9 = r9.a()
            return r9
        Lb:
            int r0 = r8.f17988d
            int r1 = r9.a()
            int r2 = r0 + 1
            int r3 = r1 + 1
            byte[] r9 = r9.d()
        L19:
            int r4 = r8.f17989e
            r5 = 0
            r6 = 1
            if (r2 != r4) goto L21
            r4 = 1
            goto L22
        L21:
            r4 = 0
        L22:
            int r7 = r9.length
            if (r3 != r7) goto L26
            r5 = 1
        L26:
            r6 = 47
            if (r5 != 0) goto L3e
            if (r4 == 0) goto L2d
            goto L3e
        L2d:
            r4 = r9[r3]
            byte[] r5 = r8.f18667a
            r5 = r5[r2]
            if (r5 != r4) goto L4e
            if (r4 != r6) goto L39
            r0 = r2
            r1 = r3
        L39:
            int r2 = r2 + 1
            int r3 = r3 + 1
            goto L19
        L3e:
            if (r5 != 0) goto L44
            r9 = r9[r3]
            if (r9 != r6) goto L4e
        L44:
            if (r4 != 0) goto L4c
            byte[] r9 = r8.f18667a
            r9 = r9[r2]
            if (r9 != r6) goto L4e
        L4c:
            r0 = r2
            r1 = r3
        L4e:
            r8.f17988d = r0
            r8.f17987c = r0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hivemq.client.internal.mqtt.datatypes.MqttTopicIterator.m(com.hivemq.client.internal.mqtt.datatypes.MqttTopicLevels):int");
    }

    public boolean n() {
        if (this.f17989e != this.f18667a.length) {
            return true;
        }
        return false;
    }

    public boolean o() {
        if (this.f17988d != this.f17989e) {
            return true;
        }
        return false;
    }

    public MqttTopicLevel p() {
        if (o()) {
            int i8 = this.f17988d + 1;
            this.f17987c = i8;
            this.f17988d = ByteArrayUtil.c(this.f18667a, i8, (byte) 47);
            return this;
        }
        throw new NoSuchElementException();
    }
}
