package com.google.crypto.tink.shaded.protobuf;

import com.google.crypto.tink.shaded.protobuf.Writer;
import java.io.IOException;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class UnknownFieldSetLite {

    /* renamed from: f  reason: collision with root package name */
    private static final UnknownFieldSetLite f15229f = new UnknownFieldSetLite(0, new int[0], new Object[0], false);

    /* renamed from: a  reason: collision with root package name */
    private int f15230a;

    /* renamed from: b  reason: collision with root package name */
    private int[] f15231b;

    /* renamed from: c  reason: collision with root package name */
    private Object[] f15232c;

    /* renamed from: d  reason: collision with root package name */
    private int f15233d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f15234e;

    private UnknownFieldSetLite() {
        this(0, new int[8], new Object[8], true);
    }

    private void b() {
        int i8;
        int i9 = this.f15230a;
        int[] iArr = this.f15231b;
        if (i9 == iArr.length) {
            if (i9 < 4) {
                i8 = 8;
            } else {
                i8 = i9 >> 1;
            }
            int i10 = i9 + i8;
            this.f15231b = Arrays.copyOf(iArr, i10);
            this.f15232c = Arrays.copyOf(this.f15232c, i10);
        }
    }

    private static boolean c(int[] iArr, int[] iArr2, int i8) {
        for (int i9 = 0; i9 < i8; i9++) {
            if (iArr[i9] != iArr2[i9]) {
                return false;
            }
        }
        return true;
    }

    private static boolean d(Object[] objArr, Object[] objArr2, int i8) {
        for (int i9 = 0; i9 < i8; i9++) {
            if (!objArr[i9].equals(objArr2[i9])) {
                return false;
            }
        }
        return true;
    }

    public static UnknownFieldSetLite e() {
        return f15229f;
    }

    private static int h(int[] iArr, int i8) {
        int i9 = 17;
        for (int i10 = 0; i10 < i8; i10++) {
            i9 = (i9 * 31) + iArr[i10];
        }
        return i9;
    }

    private static int i(Object[] objArr, int i8) {
        int i9 = 17;
        for (int i10 = 0; i10 < i8; i10++) {
            i9 = (i9 * 31) + objArr[i10].hashCode();
        }
        return i9;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static UnknownFieldSetLite k(UnknownFieldSetLite unknownFieldSetLite, UnknownFieldSetLite unknownFieldSetLite2) {
        int i8 = unknownFieldSetLite.f15230a + unknownFieldSetLite2.f15230a;
        int[] copyOf = Arrays.copyOf(unknownFieldSetLite.f15231b, i8);
        System.arraycopy(unknownFieldSetLite2.f15231b, 0, copyOf, unknownFieldSetLite.f15230a, unknownFieldSetLite2.f15230a);
        Object[] copyOf2 = Arrays.copyOf(unknownFieldSetLite.f15232c, i8);
        System.arraycopy(unknownFieldSetLite2.f15232c, 0, copyOf2, unknownFieldSetLite.f15230a, unknownFieldSetLite2.f15230a);
        return new UnknownFieldSetLite(i8, copyOf, copyOf2, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static UnknownFieldSetLite l() {
        return new UnknownFieldSetLite();
    }

    private static void p(int i8, Object obj, Writer writer) throws IOException {
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
                        throw new RuntimeException(InvalidProtocolBufferException.d());
                    } else if (writer.t() == Writer.FieldOrder.ASCENDING) {
                        writer.x(a8);
                        ((UnknownFieldSetLite) obj).q(writer);
                        writer.C(a8);
                        return;
                    } else {
                        writer.C(a8);
                        ((UnknownFieldSetLite) obj).q(writer);
                        writer.x(a8);
                        return;
                    }
                }
                writer.M(a8, (ByteString) obj);
                return;
            }
            writer.s(a8, ((Long) obj).longValue());
            return;
        }
        writer.u(a8, ((Long) obj).longValue());
    }

    void a() {
        if (this.f15234e) {
            return;
        }
        throw new UnsupportedOperationException();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof UnknownFieldSetLite)) {
            return false;
        }
        UnknownFieldSetLite unknownFieldSetLite = (UnknownFieldSetLite) obj;
        int i8 = this.f15230a;
        if (i8 == unknownFieldSetLite.f15230a && c(this.f15231b, unknownFieldSetLite.f15231b, i8) && d(this.f15232c, unknownFieldSetLite.f15232c, this.f15230a)) {
            return true;
        }
        return false;
    }

    public int f() {
        int X;
        int i8 = this.f15233d;
        if (i8 != -1) {
            return i8;
        }
        int i9 = 0;
        for (int i10 = 0; i10 < this.f15230a; i10++) {
            int i11 = this.f15231b[i10];
            int a8 = WireFormat.a(i11);
            int b8 = WireFormat.b(i11);
            if (b8 != 0) {
                if (b8 != 1) {
                    if (b8 != 2) {
                        if (b8 != 3) {
                            if (b8 == 5) {
                                X = CodedOutputStream.m(a8, ((Integer) this.f15232c[i10]).intValue());
                            } else {
                                throw new IllegalStateException(InvalidProtocolBufferException.d());
                            }
                        } else {
                            X = (CodedOutputStream.U(a8) * 2) + ((UnknownFieldSetLite) this.f15232c[i10]).f();
                        }
                    } else {
                        X = CodedOutputStream.g(a8, (ByteString) this.f15232c[i10]);
                    }
                } else {
                    X = CodedOutputStream.o(a8, ((Long) this.f15232c[i10]).longValue());
                }
            } else {
                X = CodedOutputStream.X(a8, ((Long) this.f15232c[i10]).longValue());
            }
            i9 += X;
        }
        this.f15233d = i9;
        return i9;
    }

    public int g() {
        int i8 = this.f15233d;
        if (i8 != -1) {
            return i8;
        }
        int i9 = 0;
        for (int i10 = 0; i10 < this.f15230a; i10++) {
            i9 += CodedOutputStream.I(WireFormat.a(this.f15231b[i10]), (ByteString) this.f15232c[i10]);
        }
        this.f15233d = i9;
        return i9;
    }

    public int hashCode() {
        int i8 = this.f15230a;
        return ((((527 + i8) * 31) + h(this.f15231b, i8)) * 31) + i(this.f15232c, this.f15230a);
    }

    public void j() {
        this.f15234e = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void m(StringBuilder sb, int i8) {
        for (int i9 = 0; i9 < this.f15230a; i9++) {
            MessageLiteToString.c(sb, i8, String.valueOf(WireFormat.a(this.f15231b[i9])), this.f15232c[i9]);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void n(int i8, Object obj) {
        a();
        b();
        int[] iArr = this.f15231b;
        int i9 = this.f15230a;
        iArr[i9] = i8;
        this.f15232c[i9] = obj;
        this.f15230a = i9 + 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o(Writer writer) throws IOException {
        if (writer.t() == Writer.FieldOrder.DESCENDING) {
            for (int i8 = this.f15230a - 1; i8 >= 0; i8--) {
                writer.b(WireFormat.a(this.f15231b[i8]), this.f15232c[i8]);
            }
            return;
        }
        for (int i9 = 0; i9 < this.f15230a; i9++) {
            writer.b(WireFormat.a(this.f15231b[i9]), this.f15232c[i9]);
        }
    }

    public void q(Writer writer) throws IOException {
        if (this.f15230a == 0) {
            return;
        }
        if (writer.t() == Writer.FieldOrder.ASCENDING) {
            for (int i8 = 0; i8 < this.f15230a; i8++) {
                p(this.f15231b[i8], this.f15232c[i8], writer);
            }
            return;
        }
        for (int i9 = this.f15230a - 1; i9 >= 0; i9--) {
            p(this.f15231b[i9], this.f15232c[i9], writer);
        }
    }

    private UnknownFieldSetLite(int i8, int[] iArr, Object[] objArr, boolean z7) {
        this.f15233d = -1;
        this.f15230a = i8;
        this.f15231b = iArr;
        this.f15232c = objArr;
        this.f15234e = z7;
    }
}
