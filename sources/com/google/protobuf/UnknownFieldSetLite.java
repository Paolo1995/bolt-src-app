package com.google.protobuf;

import com.google.protobuf.Writer;
import java.io.IOException;
import java.util.Arrays;

/* loaded from: classes3.dex */
public final class UnknownFieldSetLite {

    /* renamed from: f  reason: collision with root package name */
    private static final UnknownFieldSetLite f17620f = new UnknownFieldSetLite(0, new int[0], new Object[0], false);

    /* renamed from: a  reason: collision with root package name */
    private int f17621a;

    /* renamed from: b  reason: collision with root package name */
    private int[] f17622b;

    /* renamed from: c  reason: collision with root package name */
    private Object[] f17623c;

    /* renamed from: d  reason: collision with root package name */
    private int f17624d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f17625e;

    private UnknownFieldSetLite() {
        this(0, new int[8], new Object[8], true);
    }

    private void b() {
        int i8;
        int i9 = this.f17621a;
        int[] iArr = this.f17622b;
        if (i9 == iArr.length) {
            if (i9 < 4) {
                i8 = 8;
            } else {
                i8 = i9 >> 1;
            }
            int i10 = i9 + i8;
            this.f17622b = Arrays.copyOf(iArr, i10);
            this.f17623c = Arrays.copyOf(this.f17623c, i10);
        }
    }

    public static UnknownFieldSetLite c() {
        return f17620f;
    }

    private static int f(int[] iArr, int i8) {
        int i9 = 17;
        for (int i10 = 0; i10 < i8; i10++) {
            i9 = (i9 * 31) + iArr[i10];
        }
        return i9;
    }

    private static int g(Object[] objArr, int i8) {
        int i9 = 17;
        for (int i10 = 0; i10 < i8; i10++) {
            i9 = (i9 * 31) + objArr[i10].hashCode();
        }
        return i9;
    }

    private UnknownFieldSetLite j(CodedInputStream codedInputStream) throws IOException {
        int K;
        do {
            K = codedInputStream.K();
            if (K == 0) {
                break;
            }
        } while (i(K, codedInputStream));
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static UnknownFieldSetLite m(UnknownFieldSetLite unknownFieldSetLite, UnknownFieldSetLite unknownFieldSetLite2) {
        int i8 = unknownFieldSetLite.f17621a + unknownFieldSetLite2.f17621a;
        int[] copyOf = Arrays.copyOf(unknownFieldSetLite.f17622b, i8);
        System.arraycopy(unknownFieldSetLite2.f17622b, 0, copyOf, unknownFieldSetLite.f17621a, unknownFieldSetLite2.f17621a);
        Object[] copyOf2 = Arrays.copyOf(unknownFieldSetLite.f17623c, i8);
        System.arraycopy(unknownFieldSetLite2.f17623c, 0, copyOf2, unknownFieldSetLite.f17621a, unknownFieldSetLite2.f17621a);
        return new UnknownFieldSetLite(i8, copyOf, copyOf2, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static UnknownFieldSetLite n() {
        return new UnknownFieldSetLite();
    }

    private static boolean o(Object[] objArr, Object[] objArr2, int i8) {
        for (int i9 = 0; i9 < i8; i9++) {
            if (!objArr[i9].equals(objArr2[i9])) {
                return false;
            }
        }
        return true;
    }

    private static boolean r(int[] iArr, int[] iArr2, int i8) {
        for (int i9 = 0; i9 < i8; i9++) {
            if (iArr[i9] != iArr2[i9]) {
                return false;
            }
        }
        return true;
    }

    private static void t(int i8, Object obj, Writer writer) throws IOException {
        int a8 = WireFormat.a(i8);
        int b8 = WireFormat.b(i8);
        if (b8 != 0) {
            if (b8 != 1) {
                if (b8 != 2) {
                    if (b8 != 3) {
                        if (b8 == 5) {
                            writer.c(a8, ((Integer) obj).intValue());
                            return;
                        }
                        throw new RuntimeException(InvalidProtocolBufferException.e());
                    } else if (writer.t() == Writer.FieldOrder.ASCENDING) {
                        writer.x(a8);
                        ((UnknownFieldSetLite) obj).u(writer);
                        writer.C(a8);
                        return;
                    } else {
                        writer.C(a8);
                        ((UnknownFieldSetLite) obj).u(writer);
                        writer.x(a8);
                        return;
                    }
                }
                writer.L(a8, (ByteString) obj);
                return;
            }
            writer.s(a8, ((Long) obj).longValue());
            return;
        }
        writer.u(a8, ((Long) obj).longValue());
    }

    void a() {
        if (this.f17625e) {
            return;
        }
        throw new UnsupportedOperationException();
    }

    public int d() {
        int Y;
        int i8 = this.f17624d;
        if (i8 != -1) {
            return i8;
        }
        int i9 = 0;
        for (int i10 = 0; i10 < this.f17621a; i10++) {
            int i11 = this.f17622b[i10];
            int a8 = WireFormat.a(i11);
            int b8 = WireFormat.b(i11);
            if (b8 != 0) {
                if (b8 != 1) {
                    if (b8 != 2) {
                        if (b8 != 3) {
                            if (b8 == 5) {
                                Y = CodedOutputStream.n(a8, ((Integer) this.f17623c[i10]).intValue());
                            } else {
                                throw new IllegalStateException(InvalidProtocolBufferException.e());
                            }
                        } else {
                            Y = (CodedOutputStream.V(a8) * 2) + ((UnknownFieldSetLite) this.f17623c[i10]).d();
                        }
                    } else {
                        Y = CodedOutputStream.h(a8, (ByteString) this.f17623c[i10]);
                    }
                } else {
                    Y = CodedOutputStream.p(a8, ((Long) this.f17623c[i10]).longValue());
                }
            } else {
                Y = CodedOutputStream.Y(a8, ((Long) this.f17623c[i10]).longValue());
            }
            i9 += Y;
        }
        this.f17624d = i9;
        return i9;
    }

    public int e() {
        int i8 = this.f17624d;
        if (i8 != -1) {
            return i8;
        }
        int i9 = 0;
        for (int i10 = 0; i10 < this.f17621a; i10++) {
            i9 += CodedOutputStream.K(WireFormat.a(this.f17622b[i10]), (ByteString) this.f17623c[i10]);
        }
        this.f17624d = i9;
        return i9;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof UnknownFieldSetLite)) {
            return false;
        }
        UnknownFieldSetLite unknownFieldSetLite = (UnknownFieldSetLite) obj;
        int i8 = this.f17621a;
        if (i8 == unknownFieldSetLite.f17621a && r(this.f17622b, unknownFieldSetLite.f17622b, i8) && o(this.f17623c, unknownFieldSetLite.f17623c, this.f17621a)) {
            return true;
        }
        return false;
    }

    public void h() {
        this.f17625e = false;
    }

    public int hashCode() {
        int i8 = this.f17621a;
        return ((((527 + i8) * 31) + f(this.f17622b, i8)) * 31) + g(this.f17623c, this.f17621a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean i(int i8, CodedInputStream codedInputStream) throws IOException {
        a();
        int a8 = WireFormat.a(i8);
        int b8 = WireFormat.b(i8);
        if (b8 != 0) {
            if (b8 != 1) {
                if (b8 != 2) {
                    if (b8 != 3) {
                        if (b8 != 4) {
                            if (b8 == 5) {
                                q(i8, Integer.valueOf(codedInputStream.v()));
                                return true;
                            }
                            throw InvalidProtocolBufferException.e();
                        }
                        return false;
                    }
                    UnknownFieldSetLite unknownFieldSetLite = new UnknownFieldSetLite();
                    unknownFieldSetLite.j(codedInputStream);
                    codedInputStream.a(WireFormat.c(a8, 4));
                    q(i8, unknownFieldSetLite);
                    return true;
                }
                q(i8, codedInputStream.s());
                return true;
            }
            q(i8, Long.valueOf(codedInputStream.w()));
            return true;
        }
        q(i8, Long.valueOf(codedInputStream.A()));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public UnknownFieldSetLite k(int i8, ByteString byteString) {
        a();
        if (i8 != 0) {
            q(WireFormat.c(i8, 2), byteString);
            return this;
        }
        throw new IllegalArgumentException("Zero is not a valid field number.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public UnknownFieldSetLite l(int i8, int i9) {
        a();
        if (i8 != 0) {
            q(WireFormat.c(i8, 0), Long.valueOf(i9));
            return this;
        }
        throw new IllegalArgumentException("Zero is not a valid field number.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void p(StringBuilder sb, int i8) {
        for (int i9 = 0; i9 < this.f17621a; i9++) {
            MessageLiteToString.c(sb, i8, String.valueOf(WireFormat.a(this.f17622b[i9])), this.f17623c[i9]);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void q(int i8, Object obj) {
        a();
        b();
        int[] iArr = this.f17622b;
        int i9 = this.f17621a;
        iArr[i9] = i8;
        this.f17623c[i9] = obj;
        this.f17621a = i9 + 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void s(Writer writer) throws IOException {
        if (writer.t() == Writer.FieldOrder.DESCENDING) {
            for (int i8 = this.f17621a - 1; i8 >= 0; i8--) {
                writer.b(WireFormat.a(this.f17622b[i8]), this.f17623c[i8]);
            }
            return;
        }
        for (int i9 = 0; i9 < this.f17621a; i9++) {
            writer.b(WireFormat.a(this.f17622b[i9]), this.f17623c[i9]);
        }
    }

    public void u(Writer writer) throws IOException {
        if (this.f17621a == 0) {
            return;
        }
        if (writer.t() == Writer.FieldOrder.ASCENDING) {
            for (int i8 = 0; i8 < this.f17621a; i8++) {
                t(this.f17622b[i8], this.f17623c[i8], writer);
            }
            return;
        }
        for (int i9 = this.f17621a - 1; i9 >= 0; i9--) {
            t(this.f17622b[i9], this.f17623c[i9], writer);
        }
    }

    private UnknownFieldSetLite(int i8, int[] iArr, Object[] objArr, boolean z7) {
        this.f17624d = -1;
        this.f17621a = i8;
        this.f17622b = iArr;
        this.f17623c = objArr;
        this.f17625e = z7;
    }
}
