package com.hivemq.client.internal.mqtt.datatypes;

import com.hivemq.client.internal.util.ByteArrayUtil;

/* loaded from: classes3.dex */
public class MqttSharedTopicFilterImpl extends MqttTopicFilterImpl {

    /* renamed from: m  reason: collision with root package name */
    private static final int f17983m = 7;

    /* renamed from: k  reason: collision with root package name */
    private int f17984k;

    /* renamed from: l  reason: collision with root package name */
    private int f17985l;

    private MqttSharedTopicFilterImpl(byte[] bArr, int i8, int i9) {
        super(bArr, i9);
        this.f17984k = i8 + 1;
        this.f17985l = -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static MqttSharedTopicFilterImpl A(String str) {
        char charAt;
        int i8 = f17983m;
        while (i8 < str.length() && (charAt = str.charAt(i8)) != '/') {
            if (charAt != '#') {
                if (charAt != '+') {
                    i8++;
                } else {
                    throw new IllegalArgumentException(D(x(str), i8));
                }
            } else {
                throw new IllegalArgumentException(C(x(str), i8));
            }
        }
        if (i8 != f17983m) {
            if (i8 < str.length() - 1) {
                return new MqttSharedTopicFilterImpl(str, i8, MqttTopicFilterImpl.v(str, i8 + 1));
            }
            throw new IllegalArgumentException("Topic filter must be at least one character long.");
        }
        throw new IllegalArgumentException("Share name must be at least one character long.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static MqttSharedTopicFilterImpl B(byte[] bArr) {
        int w7;
        byte b8;
        int i8 = f17983m;
        while (i8 < bArr.length && (b8 = bArr[i8]) != 47) {
            if (b8 == 35 || b8 == 43) {
                return null;
            }
            i8++;
        }
        if (i8 == f17983m || i8 >= bArr.length - 1 || (w7 = MqttTopicFilterImpl.w(bArr, i8 + 1)) == -1) {
            return null;
        }
        return new MqttSharedTopicFilterImpl(bArr, i8, w7);
    }

    private static String C(String str, int i8) {
        return "Share name [" + str + "] must not contain multi level wildcard (#), found at index " + i8 + ".";
    }

    private static String D(String str, int i8) {
        return "Share name [" + str + "] must not contain single level wildcard (+), found at index " + i8 + ".";
    }

    private static String x(String str) {
        int i8 = f17983m;
        int indexOf = str.indexOf(47, i8);
        if (indexOf == -1) {
            indexOf = str.length();
        }
        return str.substring(i8, indexOf);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean y(String str) {
        return str.startsWith("$share/");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean z(byte[] bArr) {
        if (bArr.length < f17983m) {
            return false;
        }
        for (int i8 = 0; i8 < f17983m; i8++) {
            if (bArr[i8] != "$share/".charAt(i8)) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.hivemq.client.internal.mqtt.datatypes.MqttTopicFilterImpl
    public int r() {
        if (this.f17984k == -1) {
            this.f17984k = ByteArrayUtil.c(p(), f17983m + 1, (byte) 47) + 1;
        }
        return this.f17984k;
    }

    private MqttSharedTopicFilterImpl(String str, int i8, int i9) {
        super(str, i9);
        this.f17984k = -1;
        this.f17985l = i8 + 1;
    }
}
