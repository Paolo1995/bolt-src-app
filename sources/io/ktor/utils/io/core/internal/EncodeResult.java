package io.ktor.utils.io.core.internal;

import kotlin.UShort;
import okhttp3.internal.http2.Settings;

/* compiled from: EncodeResult.kt */
/* loaded from: classes5.dex */
public final class EncodeResult {
    public static final short a(int i8) {
        return f(i8);
    }

    public static final short b(int i8) {
        return e(i8);
    }

    public static int c(int i8) {
        return i8;
    }

    public static int d(short s7, short s8) {
        return c(((s7 & 65535) << 16) | (s8 & 65535));
    }

    public static final short e(int i8) {
        return UShort.c((short) (i8 & Settings.DEFAULT_INITIAL_WINDOW_SIZE));
    }

    public static final short f(int i8) {
        return UShort.c((short) (i8 >>> 16));
    }
}
