package io.ktor.utils.io.core;

import com.google.android.gms.common.api.Api;
import io.ktor.utils.io.charsets.CharsetJVMKt;
import io.ktor.utils.io.charsets.EncodingKt;
import io.ktor.utils.io.core.internal.ChunkBuffer;
import io.ktor.utils.io.core.internal.EncodeResult;
import io.ktor.utils.io.core.internal.UTF8Kt;
import io.ktor.utils.io.core.internal.UnsafeKt;
import java.io.EOFException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* compiled from: Strings.kt */
/* loaded from: classes5.dex */
public final class StringsKt {
    public static final Void a(int i8) {
        throw new EOFException("Premature end of stream: expected " + i8 + " bytes");
    }

    public static final byte[] b(ByteReadPacket byteReadPacket, int i8) {
        Intrinsics.f(byteReadPacket, "<this>");
        if (i8 != 0) {
            byte[] bArr = new byte[i8];
            InputArraysKt.b(byteReadPacket, bArr, 0, i8);
            return bArr;
        }
        return UnsafeKt.f47410a;
    }

    public static /* synthetic */ byte[] c(ByteReadPacket byteReadPacket, int i8, int i9, Object obj) {
        if ((i9 & 1) != 0) {
            long C0 = byteReadPacket.C0();
            if (C0 <= 2147483647L) {
                i8 = (int) C0;
            } else {
                throw new IllegalArgumentException("Unable to convert to a ByteArray: packet is too big");
            }
        }
        return b(byteReadPacket, i8);
    }

    public static final String d(Input input, Charset charset, int i8) {
        Intrinsics.f(input, "<this>");
        Intrinsics.f(charset, "charset");
        CharsetDecoder newDecoder = charset.newDecoder();
        Intrinsics.e(newDecoder, "charset.newDecoder()");
        return EncodingKt.a(newDecoder, input, i8);
    }

    public static /* synthetic */ String e(Input input, Charset charset, int i8, int i9, Object obj) {
        if ((i9 & 1) != 0) {
            charset = Charsets.f51135b;
        }
        if ((i9 & 2) != 0) {
            i8 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        }
        return d(input, charset, i8);
    }

    public static final String f(Input input, int i8, Charset charset) {
        Intrinsics.f(input, "<this>");
        Intrinsics.f(charset, "charset");
        CharsetDecoder newDecoder = charset.newDecoder();
        Intrinsics.e(newDecoder, "charset.newDecoder()");
        return CharsetJVMKt.b(newDecoder, input, i8);
    }

    public static /* synthetic */ String g(Input input, int i8, Charset charset, int i9, Object obj) {
        if ((i9 & 2) != 0) {
            charset = Charsets.f51135b;
        }
        return f(input, i8, charset);
    }

    public static final void h(Output output, CharSequence text, int i8, int i9, Charset charset) {
        Intrinsics.f(output, "<this>");
        Intrinsics.f(text, "text");
        Intrinsics.f(charset, "charset");
        if (charset == Charsets.f51135b) {
            j(output, text, i8, i9);
            return;
        }
        CharsetEncoder newEncoder = charset.newEncoder();
        Intrinsics.e(newEncoder, "charset.newEncoder()");
        EncodingKt.f(newEncoder, output, text, i8, i9);
    }

    public static /* synthetic */ void i(Output output, CharSequence charSequence, int i8, int i9, Charset charset, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            i8 = 0;
        }
        if ((i10 & 4) != 0) {
            i9 = charSequence.length();
        }
        if ((i10 & 8) != 0) {
            charset = Charsets.f51135b;
        }
        h(output, charSequence, i8, i9, charset);
    }

    private static final void j(Output output, CharSequence charSequence, int i8, int i9) {
        int i10;
        ChunkBuffer d8 = UnsafeKt.d(output, 1, null);
        while (true) {
            try {
                int b8 = UTF8Kt.b(d8.h(), charSequence, i8, i9, d8.k(), d8.g());
                int a8 = EncodeResult.a(b8) & 65535;
                i8 += a8;
                d8.a(EncodeResult.b(b8) & 65535);
                if (a8 == 0 && i8 < i9) {
                    i10 = 8;
                } else if (i8 < i9) {
                    i10 = 1;
                } else {
                    i10 = 0;
                }
                if (i10 > 0) {
                    d8 = UnsafeKt.d(output, i10, d8);
                } else {
                    return;
                }
            } finally {
                output.c();
            }
        }
    }
}
