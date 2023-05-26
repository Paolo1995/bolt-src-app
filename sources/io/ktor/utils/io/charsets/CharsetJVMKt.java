package io.ktor.utils.io.charsets;

import io.ktor.utils.io.bits.Memory;
import io.ktor.utils.io.core.Buffer;
import io.ktor.utils.io.core.Input;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CharsetJVM.kt */
/* loaded from: classes5.dex */
public final class CharsetJVMKt {

    /* renamed from: a  reason: collision with root package name */
    private static final CharBuffer f47366a = CharBuffer.allocate(0);

    /* renamed from: b  reason: collision with root package name */
    private static final ByteBuffer f47367b;

    static {
        ByteBuffer allocate = ByteBuffer.allocate(0);
        Intrinsics.c(allocate);
        f47367b = allocate;
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x00a7, code lost:
        throw new java.lang.IllegalStateException("Buffer's limit change is not allowed".toString());
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final int a(java.nio.charset.CharsetDecoder r11, io.ktor.utils.io.core.Input r12, java.lang.Appendable r13, int r14) {
        /*
            Method dump skipped, instructions count: 287
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.charsets.CharsetJVMKt.a(java.nio.charset.CharsetDecoder, io.ktor.utils.io.core.Input, java.lang.Appendable, int):int");
    }

    public static final String b(CharsetDecoder charsetDecoder, Input input, int i8) {
        Intrinsics.f(charsetDecoder, "<this>");
        Intrinsics.f(input, "input");
        if (i8 == 0) {
            return "";
        }
        if (input.f0() - input.s0() >= i8) {
            if (input.k0().hasArray()) {
                ByteBuffer k02 = input.k0();
                byte[] array = k02.array();
                Intrinsics.e(array, "bb.array()");
                Charset charset = charsetDecoder.charset();
                Intrinsics.e(charset, "charset()");
                String str = new String(array, k02.arrayOffset() + k02.position() + input.d0().i(), i8, charset);
                input.t(i8);
                return str;
            }
            return c(charsetDecoder, input, i8);
        }
        return d(charsetDecoder, input, i8);
    }

    private static final String c(CharsetDecoder charsetDecoder, Input input, int i8) {
        CharBuffer allocate = CharBuffer.allocate(i8);
        ByteBuffer d8 = Memory.d(input.k0(), input.d0().i(), i8);
        CoderResult rc = charsetDecoder.decode(d8, allocate, true);
        if (rc.isMalformed() || rc.isUnmappable()) {
            Intrinsics.e(rc, "rc");
            j(rc);
        }
        allocate.flip();
        input.t(d8.position());
        String charBuffer = allocate.toString();
        Intrinsics.e(charBuffer, "cb.toString()");
        return charBuffer;
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x00a6, code lost:
        throw new java.lang.IllegalStateException("Buffer's limit change is not allowed".toString());
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final java.lang.String d(java.nio.charset.CharsetDecoder r17, io.ktor.utils.io.core.Input r18, int r19) {
        /*
            Method dump skipped, instructions count: 332
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.charsets.CharsetJVMKt.d(java.nio.charset.CharsetDecoder, io.ktor.utils.io.core.Input, int):java.lang.String");
    }

    public static final boolean e(CharsetEncoder charsetEncoder, Buffer dst) {
        Intrinsics.f(charsetEncoder, "<this>");
        Intrinsics.f(dst, "dst");
        ByteBuffer h8 = dst.h();
        int k8 = dst.k();
        int g8 = dst.g() - k8;
        ByteBuffer d8 = Memory.d(h8, k8, g8);
        boolean z7 = true;
        CoderResult result = charsetEncoder.encode(f47366a, d8, true);
        if (result.isMalformed() || result.isUnmappable()) {
            Intrinsics.e(result, "result");
            j(result);
        }
        boolean isUnderflow = result.isUnderflow();
        if (d8.limit() != g8) {
            z7 = false;
        }
        if (z7) {
            dst.a(d8.position());
            return isUnderflow;
        }
        throw new IllegalStateException("Buffer's limit change is not allowed".toString());
    }

    public static final int f(CharsetEncoder charsetEncoder, CharSequence input, int i8, int i9, Buffer dst) {
        Intrinsics.f(charsetEncoder, "<this>");
        Intrinsics.f(input, "input");
        Intrinsics.f(dst, "dst");
        CharBuffer wrap = CharBuffer.wrap(input, i8, i9);
        int remaining = wrap.remaining();
        ByteBuffer h8 = dst.h();
        int k8 = dst.k();
        int g8 = dst.g() - k8;
        ByteBuffer d8 = Memory.d(h8, k8, g8);
        boolean z7 = false;
        CoderResult result = charsetEncoder.encode(wrap, d8, false);
        if (result.isMalformed() || result.isUnmappable()) {
            Intrinsics.e(result, "result");
            j(result);
        }
        if (d8.limit() == g8) {
            z7 = true;
        }
        if (z7) {
            dst.a(d8.position());
            return remaining - wrap.remaining();
        }
        throw new IllegalStateException("Buffer's limit change is not allowed".toString());
    }

    public static final byte[] g(CharsetEncoder charsetEncoder, CharSequence input, int i8, int i9) {
        Intrinsics.f(charsetEncoder, "<this>");
        Intrinsics.f(input, "input");
        if (input instanceof String) {
            if (i8 == 0 && i9 == input.length()) {
                byte[] bytes = ((String) input).getBytes(charsetEncoder.charset());
                Intrinsics.e(bytes, "input as java.lang.String).getBytes(charset())");
                return bytes;
            }
            String substring = ((String) input).substring(i8, i9);
            Intrinsics.e(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            byte[] bytes2 = substring.getBytes(charsetEncoder.charset());
            Intrinsics.e(bytes2, "input.substring(fromInde…ring).getBytes(charset())");
            return bytes2;
        }
        return h(charsetEncoder, input, i8, i9);
    }

    private static final byte[] h(CharsetEncoder charsetEncoder, CharSequence charSequence, int i8, int i9) {
        boolean z7;
        ByteBuffer encode = charsetEncoder.encode(CharBuffer.wrap(charSequence, i8, i9));
        byte[] bArr = null;
        if (encode.hasArray() && encode.arrayOffset() == 0) {
            byte[] array = encode.array();
            if (array.length == encode.remaining()) {
                z7 = true;
            } else {
                z7 = false;
            }
            if (z7) {
                bArr = array;
            }
        }
        if (bArr == null) {
            byte[] bArr2 = new byte[encode.remaining()];
            encode.get(bArr2);
            return bArr2;
        }
        return bArr;
    }

    public static final String i(Charset charset) {
        Intrinsics.f(charset, "<this>");
        String name = charset.name();
        Intrinsics.e(name, "name()");
        return name;
    }

    private static final void j(CoderResult coderResult) {
        try {
            coderResult.throwException();
        } catch (java.nio.charset.MalformedInputException e8) {
            String message = e8.getMessage();
            if (message == null) {
                message = "Failed to decode bytes";
            }
            throw new MalformedInputException(message);
        }
    }
}
