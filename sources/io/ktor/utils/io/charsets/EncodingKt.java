package io.ktor.utils.io.charsets;

import com.google.android.gms.common.api.Api;
import io.ktor.utils.io.core.BytePacketBuilder;
import io.ktor.utils.io.core.ByteReadPacket;
import io.ktor.utils.io.core.Input;
import io.ktor.utils.io.core.Output;
import io.ktor.utils.io.core.internal.ChunkBuffer;
import io.ktor.utils.io.core.internal.UnsafeKt;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Encoding.kt */
/* loaded from: classes5.dex */
public final class EncodingKt {
    public static final String a(CharsetDecoder charsetDecoder, Input input, int i8) {
        Intrinsics.f(charsetDecoder, "<this>");
        Intrinsics.f(input, "input");
        StringBuilder sb = new StringBuilder((int) Math.min(i8, g(input)));
        CharsetJVMKt.a(charsetDecoder, input, sb, i8);
        String sb2 = sb.toString();
        Intrinsics.e(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    public static /* synthetic */ String b(CharsetDecoder charsetDecoder, Input input, int i8, int i9, Object obj) {
        if ((i9 & 2) != 0) {
            i8 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        }
        return a(charsetDecoder, input, i8);
    }

    public static final ByteReadPacket c(CharsetEncoder charsetEncoder, CharSequence input, int i8, int i9) {
        Intrinsics.f(charsetEncoder, "<this>");
        Intrinsics.f(input, "input");
        BytePacketBuilder bytePacketBuilder = new BytePacketBuilder(null, 1, null);
        try {
            f(charsetEncoder, bytePacketBuilder, input, i8, i9);
            return bytePacketBuilder.K0();
        } catch (Throwable th) {
            bytePacketBuilder.release();
            throw th;
        }
    }

    public static /* synthetic */ ByteReadPacket d(CharsetEncoder charsetEncoder, CharSequence charSequence, int i8, int i9, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            i8 = 0;
        }
        if ((i10 & 4) != 0) {
            i9 = charSequence.length();
        }
        return c(charsetEncoder, charSequence, i8, i9);
    }

    private static final int e(CharsetEncoder charsetEncoder, Output output) {
        boolean z7;
        ChunkBuffer d8 = UnsafeKt.d(output, 1, null);
        int i8 = 1;
        int i9 = 0;
        while (true) {
            try {
                int g8 = d8.g() - d8.k();
                if (CharsetJVMKt.e(charsetEncoder, d8)) {
                    i8 = 0;
                } else {
                    i8++;
                }
                i9 += g8 - (d8.g() - d8.k());
                if (i8 > 0) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                if (z7) {
                    d8 = UnsafeKt.d(output, 1, d8);
                } else {
                    return i9;
                }
            } finally {
                output.c();
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:54:0x005f, code lost:
        throw new java.lang.IllegalStateException("Check failed.".toString());
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final int f(java.nio.charset.CharsetEncoder r8, io.ktor.utils.io.core.Output r9, java.lang.CharSequence r10, int r11, int r12) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.f(r8, r0)
            java.lang.String r0 = "destination"
            kotlin.jvm.internal.Intrinsics.f(r9, r0)
            java.lang.String r0 = "input"
            kotlin.jvm.internal.Intrinsics.f(r10, r0)
            r0 = 0
            if (r11 < r12) goto L13
            return r0
        L13:
            r1 = 0
            r2 = 1
            io.ktor.utils.io.core.internal.ChunkBuffer r1 = io.ktor.utils.io.core.internal.UnsafeKt.d(r9, r2, r1)
            r3 = 0
        L1a:
            int r4 = r1.g()     // Catch: java.lang.Throwable -> L60
            int r5 = r1.k()     // Catch: java.lang.Throwable -> L60
            int r4 = r4 - r5
            int r5 = io.ktor.utils.io.charsets.CharsetJVMKt.f(r8, r10, r11, r12, r1)     // Catch: java.lang.Throwable -> L60
            if (r5 < 0) goto L2b
            r6 = 1
            goto L2c
        L2b:
            r6 = 0
        L2c:
            if (r6 == 0) goto L54
            int r11 = r11 + r5
            int r6 = r1.g()     // Catch: java.lang.Throwable -> L60
            int r7 = r1.k()     // Catch: java.lang.Throwable -> L60
            int r6 = r6 - r7
            int r4 = r4 - r6
            int r3 = r3 + r4
            if (r11 < r12) goto L3e
            r4 = 0
            goto L44
        L3e:
            if (r5 != 0) goto L43
            r4 = 8
            goto L44
        L43:
            r4 = 1
        L44:
            if (r4 <= 0) goto L4b
            io.ktor.utils.io.core.internal.ChunkBuffer r1 = io.ktor.utils.io.core.internal.UnsafeKt.d(r9, r4, r1)     // Catch: java.lang.Throwable -> L60
            goto L1a
        L4b:
            r9.c()
            int r8 = e(r8, r9)
            int r3 = r3 + r8
            return r3
        L54:
            java.lang.String r8 = "Check failed."
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L60
            java.lang.String r8 = r8.toString()     // Catch: java.lang.Throwable -> L60
            r10.<init>(r8)     // Catch: java.lang.Throwable -> L60
            throw r10     // Catch: java.lang.Throwable -> L60
        L60:
            r8 = move-exception
            r9.c()
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.charsets.EncodingKt.f(java.nio.charset.CharsetEncoder, io.ktor.utils.io.core.Output, java.lang.CharSequence, int, int):int");
    }

    public static final long g(Input input) {
        Intrinsics.f(input, "<this>");
        if (input instanceof ByteReadPacket) {
            return input.C0();
        }
        return Math.max(input.C0(), 16L);
    }
}
