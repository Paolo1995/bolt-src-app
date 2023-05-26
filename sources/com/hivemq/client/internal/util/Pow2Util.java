package com.hivemq.client.internal.util;

/* loaded from: classes3.dex */
public final class Pow2Util {
    private Pow2Util() {
    }

    public static int a(int i8) {
        return 32 - Integer.numberOfLeadingZeros(i8 - 1);
    }
}
