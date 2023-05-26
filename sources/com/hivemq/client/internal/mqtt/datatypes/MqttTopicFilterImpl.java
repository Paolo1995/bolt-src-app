package com.hivemq.client.internal.mqtt.datatypes;

import com.hivemq.client.internal.util.Checks;
import com.hivemq.client.mqtt.datatypes.MqttTopicFilter;
import java.util.Arrays;

/* loaded from: classes3.dex */
public class MqttTopicFilterImpl extends MqttUtf8StringImpl implements MqttTopicFilter {

    /* renamed from: j  reason: collision with root package name */
    final int f17986j;

    /* JADX INFO: Access modifiers changed from: package-private */
    public MqttTopicFilterImpl(byte[] bArr, int i8) {
        super(bArr);
        this.f17986j = i8;
    }

    public static MqttTopicFilterImpl t(String str) {
        Checks.f(str, "Topic filter");
        MqttUtf8StringImpl.a(str, "Topic filter");
        MqttUtf8StringImpl.c(str, "Topic filter");
        if (MqttSharedTopicFilterImpl.y(str)) {
            return MqttSharedTopicFilterImpl.A(str);
        }
        return new MqttTopicFilterImpl(str, v(str, 0));
    }

    public static MqttTopicFilterImpl u(byte[] bArr) {
        if (bArr.length == 0 || !MqttBinaryData.h(bArr) || MqttUtf8StringImpl.k(bArr)) {
            return null;
        }
        if (MqttSharedTopicFilterImpl.z(bArr)) {
            return MqttSharedTopicFilterImpl.B(bArr);
        }
        int w7 = w(bArr, 0);
        if (w7 == -1) {
            return null;
        }
        return new MqttTopicFilterImpl(bArr, w7);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int v(String str, int i8) {
        int i9 = 0;
        char c8 = 1;
        for (int i10 = i8; i10 < str.length(); i10++) {
            char charAt = str.charAt(i10);
            if (c8 != 0) {
                if (c8 != 1) {
                    if (c8 != 2) {
                        if (c8 == 3) {
                            if (charAt != '/') {
                                throw new IllegalArgumentException("Topic filter [" + str.substring(i8) + "] contains misplaced wildcard characters. Single level wildcard (+) at index " + ((i10 - i8) - 1) + " must be followed by a topic level separator.");
                            }
                            c8 = 1;
                        } else {
                            continue;
                        }
                    } else {
                        throw new IllegalArgumentException("Topic filter [" + str.substring(i8) + "] contains misplaced wildcard characters. Multi level wildcard (#) must be the last character.");
                    }
                } else {
                    if (charAt != '#') {
                        if (charAt != '+') {
                            if (charAt != '/') {
                                c8 = 0;
                            }
                            c8 = 1;
                        } else {
                            i9 |= 2;
                            c8 = 3;
                        }
                    } else {
                        i9 |= 1;
                        c8 = 2;
                    }
                }
            } else if (charAt != '+' && charAt != '#') {
                if (charAt != '/') {
                }
                c8 = 1;
            } else {
                throw new IllegalArgumentException("Topic filter [" + str.substring(i8) + "] contains misplaced wildcard characters. Wildcard (" + charAt + ") at index " + (i10 - i8) + " must follow a topic level separator.");
            }
        }
        return i9;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int w(byte[] bArr, int i8) {
        int i9 = 0;
        char c8 = 1;
        while (i8 < bArr.length) {
            byte b8 = bArr[i8];
            if (c8 != 0) {
                if (c8 != 1) {
                    if (c8 != 2) {
                        if (c8 == 3) {
                            if (b8 != 47) {
                            }
                            c8 = 1;
                            i8++;
                        } else {
                            continue;
                            i8++;
                        }
                    }
                    return -1;
                }
                if (b8 != 35) {
                    if (b8 != 43) {
                        if (b8 != 47) {
                            c8 = 0;
                        }
                        c8 = 1;
                    } else {
                        i9 |= 2;
                        c8 = 3;
                    }
                } else {
                    i9 |= 1;
                    c8 = 2;
                }
                i8++;
            } else if (b8 == 43 || b8 == 35) {
                return -1;
            } else {
                if (b8 != 47) {
                    i8++;
                }
                c8 = 1;
                i8++;
            }
        }
        return i9;
    }

    public boolean q() {
        if ((this.f17986j & 1) != 0) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int r() {
        return 0;
    }

    public byte[] s() {
        int r7 = r();
        if (r7 == 0) {
            return null;
        }
        return Arrays.copyOfRange(p(), 0, r7 - 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MqttTopicFilterImpl(String str, int i8) {
        super(str);
        this.f17986j = i8;
    }
}
