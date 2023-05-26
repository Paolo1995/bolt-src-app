package io.ktor.http;

import io.ktor.utils.io.charsets.EncodingKt;
import io.ktor.utils.io.core.ByteReadPacket;
import io.ktor.utils.io.core.internal.ChunkBuffer;
import io.ktor.utils.io.core.internal.UnsafeKt;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.collections.SetsKt___SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.CharRange;
import kotlin.text.CharsKt__CharKt;
import kotlin.text.Charsets;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: Codecs.kt */
/* loaded from: classes5.dex */
public final class CodecsKt {

    /* renamed from: a  reason: collision with root package name */
    private static final Set<Byte> f46714a;

    /* renamed from: b  reason: collision with root package name */
    private static final Set<Character> f46715b;

    /* renamed from: c  reason: collision with root package name */
    private static final Set<Character> f46716c;

    /* renamed from: d  reason: collision with root package name */
    private static final List<Byte> f46717d;

    /* renamed from: e  reason: collision with root package name */
    private static final Set<Character> f46718e;

    /* renamed from: f  reason: collision with root package name */
    private static final Set<Character> f46719f;

    /* renamed from: g  reason: collision with root package name */
    private static final List<Byte> f46720g;

    static {
        List m02;
        List<Character> n02;
        int v7;
        Set<Byte> L0;
        List m03;
        List n03;
        Set<Character> L02;
        List m04;
        List n04;
        Set<Character> L03;
        Set<Character> f8;
        int v8;
        Set<Character> f9;
        Set f10;
        Set<Character> h8;
        List<Character> n8;
        int v9;
        m02 = CollectionsKt___CollectionsKt.m0(new CharRange('a', 'z'), new CharRange('A', 'Z'));
        n02 = CollectionsKt___CollectionsKt.n0(m02, new CharRange('0', '9'));
        v7 = CollectionsKt__IterablesKt.v(n02, 10);
        ArrayList arrayList = new ArrayList(v7);
        for (Character ch : n02) {
            arrayList.add(Byte.valueOf((byte) ch.charValue()));
        }
        L0 = CollectionsKt___CollectionsKt.L0(arrayList);
        f46714a = L0;
        m03 = CollectionsKt___CollectionsKt.m0(new CharRange('a', 'z'), new CharRange('A', 'Z'));
        n03 = CollectionsKt___CollectionsKt.n0(m03, new CharRange('0', '9'));
        L02 = CollectionsKt___CollectionsKt.L0(n03);
        f46715b = L02;
        m04 = CollectionsKt___CollectionsKt.m0(new CharRange('a', 'f'), new CharRange('A', 'F'));
        n04 = CollectionsKt___CollectionsKt.n0(m04, new CharRange('0', '9'));
        L03 = CollectionsKt___CollectionsKt.L0(n04);
        f46716c = L03;
        f8 = SetsKt__SetsKt.f(':', '/', '?', '#', '[', ']', '@', '!', '$', '&', '\'', '(', ')', '*', ',', ';', '=', '-', '.', '_', '~', '+');
        v8 = CollectionsKt__IterablesKt.v(f8, 10);
        ArrayList arrayList2 = new ArrayList(v8);
        for (Character ch2 : f8) {
            arrayList2.add(Byte.valueOf((byte) ch2.charValue()));
        }
        f46717d = arrayList2;
        f9 = SetsKt__SetsKt.f(':', '@', '!', '$', '&', '\'', '(', ')', '*', '+', ',', ';', '=', '-', '.', '_', '~');
        f46718e = f9;
        Set<Character> set = f46715b;
        f10 = SetsKt__SetsKt.f('!', '#', '$', '&', '+', '-', '.', '^', '_', '`', '|', '~');
        h8 = SetsKt___SetsKt.h(set, f10);
        f46719f = h8;
        n8 = CollectionsKt__CollectionsKt.n('-', '.', '_', '~');
        v9 = CollectionsKt__IterablesKt.v(n8, 10);
        ArrayList arrayList3 = new ArrayList(v9);
        for (Character ch3 : n8) {
            arrayList3.add(Byte.valueOf((byte) ch3.charValue()));
        }
        f46720g = arrayList3;
    }

    private static final int e(char c8) {
        boolean z7 = true;
        if ('0' <= c8 && c8 < ':') {
            return c8 - '0';
        }
        char c9 = 'A';
        if (!('A' <= c8 && c8 < 'G')) {
            c9 = 'a';
            if (!(('a' > c8 || c8 >= 'g') ? false : false)) {
                return -1;
            }
        }
        return (c8 - c9) + 10;
    }

    private static final String f(CharSequence charSequence, int i8, int i9, int i10, boolean z7, Charset charset) {
        int i11 = i9 - i8;
        if (i11 > 255) {
            i11 /= 3;
        }
        StringBuilder sb = new StringBuilder(i11);
        if (i10 > i8) {
            sb.append(charSequence, i8, i10);
        }
        byte[] bArr = null;
        while (i10 < i9) {
            char charAt = charSequence.charAt(i10);
            if (z7 && charAt == '+') {
                sb.append(' ');
            } else if (charAt == '%') {
                if (bArr == null) {
                    bArr = new byte[(i9 - i10) / 3];
                }
                int i12 = 0;
                while (i10 < i9 && charSequence.charAt(i10) == '%') {
                    int i13 = i10 + 2;
                    if (i13 < i9) {
                        int i14 = i10 + 1;
                        int e8 = e(charSequence.charAt(i14));
                        int e9 = e(charSequence.charAt(i13));
                        if (e8 != -1 && e9 != -1) {
                            bArr[i12] = (byte) ((e8 * 16) + e9);
                            i10 += 3;
                            i12++;
                        } else {
                            throw new URLDecodeException("Wrong HEX escape: %" + charSequence.charAt(i14) + charSequence.charAt(i13) + ", in " + ((Object) charSequence) + ", at " + i10);
                        }
                    } else {
                        throw new URLDecodeException("Incomplete trailing HEX escape: " + charSequence.subSequence(i10, charSequence.length()).toString() + ", in " + ((Object) charSequence) + " at " + i10);
                    }
                }
                sb.append(new String(bArr, 0, i12, charset));
            } else {
                sb.append(charAt);
            }
            i10++;
        }
        String sb2 = sb.toString();
        Intrinsics.e(sb2, "sb.toString()");
        return sb2;
    }

    private static final String g(String str, int i8, int i9, boolean z7, Charset charset) {
        for (int i10 = i8; i10 < i9; i10++) {
            char charAt = str.charAt(i10);
            if (charAt == '%' || (z7 && charAt == '+')) {
                return f(str, i8, i9, i10, z7, charset);
            }
        }
        if (i8 != 0 || i9 != str.length()) {
            String substring = str.substring(i8, i9);
            Intrinsics.e(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            return substring;
        }
        return str;
    }

    public static final String h(String str, int i8, int i9, Charset charset) {
        Intrinsics.f(str, "<this>");
        Intrinsics.f(charset, "charset");
        return g(str, i8, i9, false, charset);
    }

    public static /* synthetic */ String i(String str, int i8, int i9, Charset charset, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            i8 = 0;
        }
        if ((i10 & 2) != 0) {
            i9 = str.length();
        }
        if ((i10 & 4) != 0) {
            charset = Charsets.f51135b;
        }
        return h(str, i8, i9, charset);
    }

    public static final String j(String str, int i8, int i9, boolean z7, Charset charset) {
        Intrinsics.f(str, "<this>");
        Intrinsics.f(charset, "charset");
        return g(str, i8, i9, z7, charset);
    }

    public static /* synthetic */ String k(String str, int i8, int i9, boolean z7, Charset charset, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            i8 = 0;
        }
        if ((i10 & 2) != 0) {
            i9 = str.length();
        }
        if ((i10 & 4) != 0) {
            z7 = false;
        }
        if ((i10 & 8) != 0) {
            charset = Charsets.f51135b;
        }
        return j(str, i8, i9, z7, charset);
    }

    public static final String l(String str, final boolean z7) {
        Intrinsics.f(str, "<this>");
        final StringBuilder sb = new StringBuilder();
        CharsetEncoder newEncoder = Charsets.f51135b.newEncoder();
        Intrinsics.e(newEncoder, "UTF_8.newEncoder()");
        s(EncodingKt.d(newEncoder, str, 0, 0, 6, null), new Function1<Byte, Unit>() { // from class: io.ktor.http.CodecsKt$encodeURLParameter$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final void b(byte b8) {
                Set set;
                List list;
                String u7;
                set = CodecsKt.f46714a;
                if (!set.contains(Byte.valueOf(b8))) {
                    list = CodecsKt.f46720g;
                    if (!list.contains(Byte.valueOf(b8))) {
                        if (z7 && b8 == ((byte) 32)) {
                            sb.append('+');
                            return;
                        }
                        StringBuilder sb2 = sb;
                        u7 = CodecsKt.u(b8);
                        sb2.append(u7);
                        return;
                    }
                }
                sb.append((char) b8);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Byte b8) {
                b(b8.byteValue());
                return Unit.f50853a;
            }
        });
        String sb2 = sb.toString();
        Intrinsics.e(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    public static /* synthetic */ String m(String str, boolean z7, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            z7 = false;
        }
        return l(str, z7);
    }

    public static final String n(String str) {
        Intrinsics.f(str, "<this>");
        return l(str, true);
    }

    public static final String o(String str, boolean z7) {
        boolean e8;
        int i8;
        int i9;
        Intrinsics.f(str, "<this>");
        final StringBuilder sb = new StringBuilder();
        Charset charset = Charsets.f51135b;
        int i10 = 0;
        while (i10 < str.length()) {
            char charAt = str.charAt(i10);
            if ((z7 || charAt != '/') && !f46715b.contains(Character.valueOf(charAt)) && !f46718e.contains(Character.valueOf(charAt))) {
                if (charAt == '%' && (i9 = i10 + 2) < str.length()) {
                    Set<Character> set = f46716c;
                    int i11 = i10 + 1;
                    if (set.contains(Character.valueOf(str.charAt(i11))) && set.contains(Character.valueOf(str.charAt(i9)))) {
                        sb.append(charAt);
                        sb.append(str.charAt(i11));
                        sb.append(str.charAt(i9));
                        i10 += 3;
                    }
                }
                e8 = CharsKt__CharKt.e(charAt);
                if (e8) {
                    i8 = 2;
                } else {
                    i8 = 1;
                }
                CharsetEncoder newEncoder = charset.newEncoder();
                Intrinsics.e(newEncoder, "charset.newEncoder()");
                int i12 = i8 + i10;
                s(EncodingKt.c(newEncoder, str, i10, i12), new Function1<Byte, Unit>() { // from class: io.ktor.http.CodecsKt$encodeURLPath$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    public final void b(byte b8) {
                        String u7;
                        StringBuilder sb2 = sb;
                        u7 = CodecsKt.u(b8);
                        sb2.append(u7);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Byte b8) {
                        b(b8.byteValue());
                        return Unit.f50853a;
                    }
                });
                i10 = i12;
            } else {
                sb.append(charAt);
                i10++;
            }
        }
        String sb2 = sb.toString();
        Intrinsics.e(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    public static final String p(String str) {
        Intrinsics.f(str, "<this>");
        return o(str, true);
    }

    public static final String q(String str, final boolean z7, final boolean z8, Charset charset) {
        Intrinsics.f(str, "<this>");
        Intrinsics.f(charset, "charset");
        final StringBuilder sb = new StringBuilder();
        CharsetEncoder newEncoder = charset.newEncoder();
        Intrinsics.e(newEncoder, "charset.newEncoder()");
        s(EncodingKt.d(newEncoder, str, 0, 0, 6, null), new Function1<Byte, Unit>() { // from class: io.ktor.http.CodecsKt$encodeURLQueryComponent$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            /* JADX WARN: Code restructure failed: missing block: B:13:0x0037, code lost:
                if (r0.contains(java.lang.Byte.valueOf(r3)) != false) goto L18;
             */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final void b(byte r3) {
                /*
                    r2 = this;
                    r0 = 32
                    byte r0 = (byte) r0
                    if (r3 != r0) goto L19
                    boolean r3 = r1
                    if (r3 == 0) goto L11
                    java.lang.StringBuilder r3 = r2
                    r0 = 43
                    r3.append(r0)
                    goto L4a
                L11:
                    java.lang.StringBuilder r3 = r2
                    java.lang.String r0 = "%20"
                    r3.append(r0)
                    goto L4a
                L19:
                    java.util.Set r0 = io.ktor.http.CodecsKt.b()
                    java.lang.Byte r1 = java.lang.Byte.valueOf(r3)
                    boolean r0 = r0.contains(r1)
                    if (r0 != 0) goto L44
                    boolean r0 = r3
                    if (r0 != 0) goto L3a
                    java.util.List r0 = io.ktor.http.CodecsKt.c()
                    java.lang.Byte r1 = java.lang.Byte.valueOf(r3)
                    boolean r0 = r0.contains(r1)
                    if (r0 == 0) goto L3a
                    goto L44
                L3a:
                    java.lang.StringBuilder r0 = r2
                    java.lang.String r3 = io.ktor.http.CodecsKt.d(r3)
                    r0.append(r3)
                    goto L4a
                L44:
                    java.lang.StringBuilder r0 = r2
                    char r3 = (char) r3
                    r0.append(r3)
                L4a:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: io.ktor.http.CodecsKt$encodeURLQueryComponent$1$1.b(byte):void");
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Byte b8) {
                b(b8.byteValue());
                return Unit.f50853a;
            }
        });
        String sb2 = sb.toString();
        Intrinsics.e(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    public static /* synthetic */ String r(String str, boolean z7, boolean z8, Charset charset, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            z7 = false;
        }
        if ((i8 & 2) != 0) {
            z8 = false;
        }
        if ((i8 & 4) != 0) {
            charset = Charsets.f51135b;
        }
        return q(str, z7, z8, charset);
    }

    private static final void s(ByteReadPacket byteReadPacket, Function1<? super Byte, Unit> function1) {
        boolean z7;
        boolean z8 = true;
        ChunkBuffer b8 = UnsafeKt.b(byteReadPacket, 1);
        if (b8 == null) {
            return;
        }
        while (true) {
            try {
                if (b8.k() > b8.i()) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                if (z7) {
                    function1.invoke(Byte.valueOf(b8.l()));
                } else {
                    try {
                        b8 = UnsafeKt.c(byteReadPacket, b8);
                        if (b8 == null) {
                            return;
                        }
                    } catch (Throwable th) {
                        th = th;
                        z8 = false;
                        if (z8) {
                            UnsafeKt.a(byteReadPacket, b8);
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    private static final char t(int i8) {
        boolean z7 = false;
        if (i8 >= 0 && i8 < 10) {
            z7 = true;
        }
        return (char) (z7 ? i8 + 48 : ((char) (i8 + 65)) - '\n');
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String u(byte b8) {
        String q8;
        int i8 = b8 & 255;
        q8 = StringsKt__StringsJVMKt.q(new char[]{'%', t(i8 >> 4), t(i8 & 15)});
        return q8;
    }
}
