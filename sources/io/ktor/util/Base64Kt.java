package io.ktor.util;

import io.ktor.utils.io.core.BytePacketBuilder;
import io.ktor.utils.io.core.ByteReadPacket;
import io.ktor.utils.io.core.StringsKt;
import j$.util.Spliterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: Base64.kt */
/* loaded from: classes5.dex */
public final class Base64Kt {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f46998a;

    static {
        int a02;
        int[] iArr = new int[Spliterator.NONNULL];
        for (int i8 = 0; i8 < 256; i8++) {
            a02 = StringsKt__StringsKt.a0("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", (char) i8, 0, false, 6, null);
            iArr[i8] = a02;
        }
        f46998a = iArr;
    }

    public static final String a(ByteReadPacket byteReadPacket) {
        Intrinsics.f(byteReadPacket, "<this>");
        return c(StringsKt.c(byteReadPacket, 0, 1, null));
    }

    public static final String b(String str) {
        Intrinsics.f(str, "<this>");
        BytePacketBuilder bytePacketBuilder = new BytePacketBuilder(null, 1, null);
        try {
            StringsKt.i(bytePacketBuilder, str, 0, 0, null, 14, null);
            return a(bytePacketBuilder.K0());
        } catch (Throwable th) {
            bytePacketBuilder.release();
            throw th;
        }
    }

    public static final String c(byte[] bArr) {
        int i8;
        String r7;
        int i9;
        String r8;
        Intrinsics.f(bArr, "<this>");
        int i10 = 3;
        char[] cArr = new char[((bArr.length * 8) / 6) + 3];
        int i11 = 0;
        int i12 = 0;
        while (true) {
            int i13 = i11 + 3;
            if (i13 > bArr.length) {
                break;
            }
            int i14 = (bArr[i11 + 2] & 255) | ((bArr[i11] & 255) << 16) | ((bArr[i11 + 1] & 255) << 8);
            int i15 = 3;
            while (-1 < i15) {
                cArr[i12] = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".charAt((i14 >> (i15 * 6)) & 63);
                i15--;
                i12++;
            }
            i11 = i13;
        }
        int length = bArr.length - i11;
        if (length == 0) {
            r8 = StringsKt__StringsJVMKt.r(cArr, 0, i12);
            return r8;
        }
        if (length == 1) {
            i8 = ((bArr[i11] & 255) << 16) | 0;
        } else {
            i8 = ((bArr[i11 + 1] & 255) << 8) | ((bArr[i11] & 255) << 16);
        }
        int i16 = i8 | 0;
        int i17 = ((3 - length) * 8) / 6;
        if (i17 <= 3) {
            while (true) {
                i9 = i12 + 1;
                cArr[i12] = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".charAt((i16 >> (i10 * 6)) & 63);
                if (i10 == i17) {
                    break;
                }
                i10--;
                i12 = i9;
            }
            i12 = i9;
        }
        int i18 = 0;
        while (i18 < i17) {
            cArr[i12] = '=';
            i18++;
            i12++;
        }
        r7 = StringsKt__StringsJVMKt.r(cArr, 0, i12);
        return r7;
    }
}
