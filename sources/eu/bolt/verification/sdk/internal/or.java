package eu.bolt.verification.sdk.internal;

import java.util.Arrays;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* loaded from: classes5.dex */
public final class or {

    /* renamed from: b  reason: collision with root package name */
    public static final a f44482b = new a(null);

    /* renamed from: a  reason: collision with root package name */
    private final byte[] f44483a;

    /* loaded from: classes5.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public or(byte[] xor) {
        Intrinsics.f(xor, "xor");
        this.f44483a = xor;
        c();
        f();
    }

    private final byte a(byte b8) {
        for (byte b9 : this.f44483a) {
            b8 = (byte) (b8 ^ b9);
        }
        return b8;
    }

    private final void c() {
        if (this.f44483a.length < 16) {
            throw new h6("XOR must be at least 16 bytes");
        }
    }

    private final byte[] d(byte[] bArr) {
        int length = bArr.length;
        byte[] bArr2 = new byte[length];
        for (int i8 = 0; i8 < length; i8++) {
            bArr2[i8] = a(bArr[i8]);
        }
        return bArr2;
    }

    private final void f() {
        if (g()) {
            byte[] bArr = this.f44483a;
            int length = bArr.length / 2;
            byte[] copyOfRange = Arrays.copyOfRange(bArr, 0, length);
            Intrinsics.e(copyOfRange, "copyOfRange(xor, 0, halfSize)");
            byte[] bArr2 = this.f44483a;
            byte[] copyOfRange2 = Arrays.copyOfRange(bArr2, length, bArr2.length);
            Intrinsics.e(copyOfRange2, "copyOfRange(xor, halfSize, xor.size)");
            Arrays.sort(copyOfRange);
            Arrays.sort(copyOfRange2);
            if (Arrays.equals(copyOfRange, copyOfRange2)) {
                throw new h6("XOR must not be mirrored");
            }
        }
    }

    private final boolean g() {
        return this.f44483a.length % 2 == 0;
    }

    public final String b(String str) {
        byte[] e8 = new zg().e(str);
        Intrinsics.e(e8, "safeEncoder.decode(name)");
        return new String(d(e8), Charsets.f51135b);
    }

    public final String e(String name) {
        Intrinsics.f(name, "name");
        byte[] bytes = name.getBytes(Charsets.f51135b);
        Intrinsics.e(bytes, "this as java.lang.String).getBytes(charset)");
        String k8 = new zg().k(d(bytes));
        Intrinsics.e(k8, "safeEncoder.encodeToString(bytes)");
        return k8;
    }
}
