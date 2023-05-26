package okio;

import java.io.Serializable;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.util.Arrays;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import okio.internal._ByteStringKt;

/* compiled from: ByteString.kt */
/* loaded from: classes5.dex */
public class ByteString implements Serializable, Comparable<ByteString> {

    /* renamed from: i  reason: collision with root package name */
    public static final Companion f52591i = new Companion(null);

    /* renamed from: j  reason: collision with root package name */
    public static final ByteString f52592j = new ByteString(new byte[0]);

    /* renamed from: f  reason: collision with root package name */
    private final byte[] f52593f;

    /* renamed from: g  reason: collision with root package name */
    private transient int f52594g;

    /* renamed from: h  reason: collision with root package name */
    private transient String f52595h;

    /* compiled from: ByteString.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ ByteString f(Companion companion, byte[] bArr, int i8, int i9, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                i8 = 0;
            }
            if ((i10 & 2) != 0) {
                i9 = bArr.length;
            }
            return companion.e(bArr, i8, i9);
        }

        public final ByteString a(String str) {
            Intrinsics.f(str, "<this>");
            byte[] a8 = _Base64Kt.a(str);
            if (a8 != null) {
                return new ByteString(a8);
            }
            return null;
        }

        public final ByteString b(String str) {
            boolean z7;
            Intrinsics.f(str, "<this>");
            int i8 = 0;
            if (str.length() % 2 == 0) {
                z7 = true;
            } else {
                z7 = false;
            }
            if (z7) {
                int length = str.length() / 2;
                byte[] bArr = new byte[length];
                int i9 = length - 1;
                if (i9 >= 0) {
                    while (true) {
                        int i10 = i8 + 1;
                        int i11 = i8 * 2;
                        bArr[i8] = (byte) ((_ByteStringKt.b(str.charAt(i11)) << 4) + _ByteStringKt.b(str.charAt(i11 + 1)));
                        if (i10 > i9) {
                            break;
                        }
                        i8 = i10;
                    }
                }
                return new ByteString(bArr);
            }
            throw new IllegalArgumentException(Intrinsics.n("Unexpected hex string: ", str).toString());
        }

        public final ByteString c(String str, Charset charset) {
            Intrinsics.f(str, "<this>");
            Intrinsics.f(charset, "charset");
            byte[] bytes = str.getBytes(charset);
            Intrinsics.e(bytes, "(this as java.lang.String).getBytes(charset)");
            return new ByteString(bytes);
        }

        public final ByteString d(String str) {
            Intrinsics.f(str, "<this>");
            ByteString byteString = new ByteString(_JvmPlatformKt.a(str));
            byteString.w(str);
            return byteString;
        }

        public final ByteString e(byte[] bArr, int i8, int i9) {
            byte[] j8;
            Intrinsics.f(bArr, "<this>");
            _UtilKt.b(bArr.length, i8, i9);
            j8 = ArraysKt___ArraysJvmKt.j(bArr, i8, i9 + i8);
            return new ByteString(j8);
        }
    }

    public ByteString(byte[] data) {
        Intrinsics.f(data, "data");
        this.f52593f = data;
    }

    public static final ByteString f(String str) {
        return f52591i.d(str);
    }

    public final boolean A(ByteString prefix) {
        Intrinsics.f(prefix, "prefix");
        return t(0, prefix, 0, prefix.z());
    }

    public ByteString B() {
        byte b8;
        for (int i8 = 0; i8 < j().length; i8++) {
            byte b9 = j()[i8];
            byte b10 = (byte) 65;
            if (b9 >= b10 && b9 <= (b8 = (byte) 90)) {
                byte[] j8 = j();
                byte[] copyOf = Arrays.copyOf(j8, j8.length);
                Intrinsics.e(copyOf, "java.util.Arrays.copyOf(this, size)");
                copyOf[i8] = (byte) (b9 + 32);
                for (int i9 = i8 + 1; i9 < copyOf.length; i9++) {
                    byte b11 = copyOf[i9];
                    if (b11 >= b10 && b11 <= b8) {
                        copyOf[i9] = (byte) (b11 + 32);
                    }
                }
                return new ByteString(copyOf);
            }
        }
        return this;
    }

    public byte[] C() {
        byte[] j8 = j();
        byte[] copyOf = Arrays.copyOf(j8, j8.length);
        Intrinsics.e(copyOf, "java.util.Arrays.copyOf(this, size)");
        return copyOf;
    }

    public String D() {
        String m8 = m();
        if (m8 == null) {
            String b8 = _JvmPlatformKt.b(q());
            w(b8);
            return b8;
        }
        return m8;
    }

    public void E(Buffer buffer, int i8, int i9) {
        Intrinsics.f(buffer, "buffer");
        _ByteStringKt.d(this, buffer, i8, i9);
    }

    public String a() {
        return _Base64Kt.c(j(), null, 1, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0030 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0032 A[ORIG_RETURN, RETURN] */
    @Override // java.lang.Comparable
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int compareTo(okio.ByteString r10) {
        /*
            r9 = this;
            java.lang.String r0 = "other"
            kotlin.jvm.internal.Intrinsics.f(r10, r0)
            int r0 = r9.z()
            int r1 = r10.z()
            int r2 = java.lang.Math.min(r0, r1)
            r3 = 0
            r4 = 0
        L13:
            r5 = -1
            r6 = 1
            if (r4 >= r2) goto L2b
            byte r7 = r9.h(r4)
            r7 = r7 & 255(0xff, float:3.57E-43)
            byte r8 = r10.h(r4)
            r8 = r8 & 255(0xff, float:3.57E-43)
            if (r7 != r8) goto L28
            int r4 = r4 + 1
            goto L13
        L28:
            if (r7 >= r8) goto L32
            goto L30
        L2b:
            if (r0 != r1) goto L2e
            goto L33
        L2e:
            if (r0 >= r1) goto L32
        L30:
            r3 = -1
            goto L33
        L32:
            r3 = 1
        L33:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.ByteString.compareTo(okio.ByteString):int");
    }

    public ByteString e(String algorithm) {
        Intrinsics.f(algorithm, "algorithm");
        MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
        messageDigest.update(j(), 0, z());
        byte[] digestBytes = messageDigest.digest();
        Intrinsics.e(digestBytes, "digestBytes");
        return new ByteString(digestBytes);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ByteString) {
            ByteString byteString = (ByteString) obj;
            if (byteString.z() == j().length && byteString.u(0, j(), 0, j().length)) {
                return true;
            }
        }
        return false;
    }

    public final byte h(int i8) {
        return r(i8);
    }

    public int hashCode() {
        int k8 = k();
        if (k8 == 0) {
            int hashCode = Arrays.hashCode(j());
            v(hashCode);
            return hashCode;
        }
        return k8;
    }

    public final byte[] j() {
        return this.f52593f;
    }

    public final int k() {
        return this.f52594g;
    }

    public int l() {
        return j().length;
    }

    public final String m() {
        return this.f52595h;
    }

    public String p() {
        String q8;
        char[] cArr = new char[j().length * 2];
        byte[] j8 = j();
        int length = j8.length;
        int i8 = 0;
        int i9 = 0;
        while (i8 < length) {
            byte b8 = j8[i8];
            i8++;
            int i10 = i9 + 1;
            cArr[i9] = _ByteStringKt.f()[(b8 >> 4) & 15];
            i9 = i10 + 1;
            cArr[i10] = _ByteStringKt.f()[b8 & 15];
        }
        q8 = StringsKt__StringsJVMKt.q(cArr);
        return q8;
    }

    public byte[] q() {
        return j();
    }

    public byte r(int i8) {
        return j()[i8];
    }

    public final ByteString s() {
        return e("MD5");
    }

    public boolean t(int i8, ByteString other, int i9, int i10) {
        Intrinsics.f(other, "other");
        return other.u(i9, j(), i8, i10);
    }

    public String toString() {
        boolean z7;
        String F;
        String F2;
        String F3;
        boolean z8;
        ByteString byteString;
        byte[] j8;
        String str;
        boolean z9 = true;
        if (j().length == 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7) {
            str = "[size=0]";
        } else {
            int a8 = _ByteStringKt.a(j(), 64);
            if (a8 == -1) {
                if (j().length <= 64) {
                    str = "[hex=" + p() + ']';
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append("[size=");
                    sb.append(j().length);
                    sb.append(" hex=");
                    int d8 = _UtilKt.d(this, 64);
                    if (d8 <= j().length) {
                        z8 = true;
                    } else {
                        z8 = false;
                    }
                    if (z8) {
                        if (d8 + 0 < 0) {
                            z9 = false;
                        }
                        if (z9) {
                            if (d8 == j().length) {
                                byteString = this;
                            } else {
                                j8 = ArraysKt___ArraysJvmKt.j(j(), 0, d8);
                                byteString = new ByteString(j8);
                            }
                            sb.append(byteString.p());
                            sb.append("…]");
                            return sb.toString();
                        }
                        throw new IllegalArgumentException("endIndex < beginIndex".toString());
                    }
                    throw new IllegalArgumentException(("endIndex > length(" + j().length + ')').toString());
                }
            } else {
                String D = D();
                if (D != null) {
                    String substring = D.substring(0, a8);
                    Intrinsics.e(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    F = StringsKt__StringsJVMKt.F(substring, "\\", "\\\\", false, 4, null);
                    F2 = StringsKt__StringsJVMKt.F(F, "\n", "\\n", false, 4, null);
                    F3 = StringsKt__StringsJVMKt.F(F2, "\r", "\\r", false, 4, null);
                    if (a8 < D.length()) {
                        return "[size=" + j().length + " text=" + F3 + "…]";
                    }
                    return "[text=" + F3 + ']';
                }
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
        }
        return str;
    }

    public boolean u(int i8, byte[] other, int i9, int i10) {
        Intrinsics.f(other, "other");
        if (i8 >= 0 && i8 <= j().length - i10 && i9 >= 0 && i9 <= other.length - i10 && _UtilKt.a(j(), i8, other, i9, i10)) {
            return true;
        }
        return false;
    }

    public final void v(int i8) {
        this.f52594g = i8;
    }

    public final void w(String str) {
        this.f52595h = str;
    }

    public final ByteString x() {
        return e("SHA-1");
    }

    public final ByteString y() {
        return e("SHA-256");
    }

    public final int z() {
        return l();
    }
}
