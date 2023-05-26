package com.google.crypto.tink.shaded.protobuf;

import com.google.crypto.tink.shaded.protobuf.Utf8;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes.dex */
public abstract class CodedOutputStream extends ByteOutput {

    /* renamed from: c  reason: collision with root package name */
    private static final Logger f15019c = Logger.getLogger(CodedOutputStream.class.getName());

    /* renamed from: d  reason: collision with root package name */
    private static final boolean f15020d = UnsafeUtil.C();

    /* renamed from: a  reason: collision with root package name */
    CodedOutputStreamWriter f15021a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f15022b;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class ArrayEncoder extends CodedOutputStream {

        /* renamed from: e  reason: collision with root package name */
        private final byte[] f15023e;

        /* renamed from: f  reason: collision with root package name */
        private final int f15024f;

        /* renamed from: g  reason: collision with root package name */
        private final int f15025g;

        /* renamed from: h  reason: collision with root package name */
        private int f15026h;

        ArrayEncoder(byte[] bArr, int i8, int i9) {
            super();
            if (bArr != null) {
                int i10 = i8 + i9;
                if ((i8 | i9 | (bArr.length - i10)) >= 0) {
                    this.f15023e = bArr;
                    this.f15024f = i8;
                    this.f15026h = i8;
                    this.f15025g = i10;
                    return;
                }
                throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", Integer.valueOf(bArr.length), Integer.valueOf(i8), Integer.valueOf(i9)));
            }
            throw new NullPointerException("buffer");
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        final void A0(int i8, MessageLite messageLite, Schema schema) throws IOException {
            M0(i8, 2);
            O0(((AbstractMessageLite) messageLite).d(schema));
            schema.h(messageLite, this.f15021a);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public final void B0(int i8, MessageLite messageLite) throws IOException {
            M0(1, 3);
            N0(2, i8);
            T0(3, messageLite);
            M0(1, 4);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public final void C0(int i8, ByteString byteString) throws IOException {
            M0(1, 3);
            N0(2, i8);
            j0(3, byteString);
            M0(1, 4);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public final void L0(int i8, String str) throws IOException {
            M0(i8, 2);
            V0(str);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public final void M0(int i8, int i9) throws IOException {
            O0(WireFormat.c(i8, i9));
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public final void N0(int i8, int i9) throws IOException {
            M0(i8, 0);
            O0(i9);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public final void O0(int i8) throws IOException {
            if (CodedOutputStream.f15020d && !Android.c() && f0() >= 5) {
                if ((i8 & (-128)) == 0) {
                    byte[] bArr = this.f15023e;
                    int i9 = this.f15026h;
                    this.f15026h = i9 + 1;
                    UnsafeUtil.H(bArr, i9, (byte) i8);
                    return;
                }
                byte[] bArr2 = this.f15023e;
                int i10 = this.f15026h;
                this.f15026h = i10 + 1;
                UnsafeUtil.H(bArr2, i10, (byte) (i8 | 128));
                int i11 = i8 >>> 7;
                if ((i11 & (-128)) == 0) {
                    byte[] bArr3 = this.f15023e;
                    int i12 = this.f15026h;
                    this.f15026h = i12 + 1;
                    UnsafeUtil.H(bArr3, i12, (byte) i11);
                    return;
                }
                byte[] bArr4 = this.f15023e;
                int i13 = this.f15026h;
                this.f15026h = i13 + 1;
                UnsafeUtil.H(bArr4, i13, (byte) (i11 | 128));
                int i14 = i11 >>> 7;
                if ((i14 & (-128)) == 0) {
                    byte[] bArr5 = this.f15023e;
                    int i15 = this.f15026h;
                    this.f15026h = i15 + 1;
                    UnsafeUtil.H(bArr5, i15, (byte) i14);
                    return;
                }
                byte[] bArr6 = this.f15023e;
                int i16 = this.f15026h;
                this.f15026h = i16 + 1;
                UnsafeUtil.H(bArr6, i16, (byte) (i14 | 128));
                int i17 = i14 >>> 7;
                if ((i17 & (-128)) == 0) {
                    byte[] bArr7 = this.f15023e;
                    int i18 = this.f15026h;
                    this.f15026h = i18 + 1;
                    UnsafeUtil.H(bArr7, i18, (byte) i17);
                    return;
                }
                byte[] bArr8 = this.f15023e;
                int i19 = this.f15026h;
                this.f15026h = i19 + 1;
                UnsafeUtil.H(bArr8, i19, (byte) (i17 | 128));
                byte[] bArr9 = this.f15023e;
                int i20 = this.f15026h;
                this.f15026h = i20 + 1;
                UnsafeUtil.H(bArr9, i20, (byte) (i17 >>> 7));
                return;
            }
            while ((i8 & (-128)) != 0) {
                try {
                    byte[] bArr10 = this.f15023e;
                    int i21 = this.f15026h;
                    this.f15026h = i21 + 1;
                    bArr10[i21] = (byte) ((i8 & 127) | 128);
                    i8 >>>= 7;
                } catch (IndexOutOfBoundsException e8) {
                    throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f15026h), Integer.valueOf(this.f15025g), 1), e8);
                }
            }
            byte[] bArr11 = this.f15023e;
            int i22 = this.f15026h;
            this.f15026h = i22 + 1;
            bArr11[i22] = (byte) i8;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public final void P0(int i8, long j8) throws IOException {
            M0(i8, 0);
            Q0(j8);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public final void Q0(long j8) throws IOException {
            if (CodedOutputStream.f15020d && f0() >= 10) {
                while ((j8 & (-128)) != 0) {
                    byte[] bArr = this.f15023e;
                    int i8 = this.f15026h;
                    this.f15026h = i8 + 1;
                    UnsafeUtil.H(bArr, i8, (byte) ((((int) j8) & 127) | 128));
                    j8 >>>= 7;
                }
                byte[] bArr2 = this.f15023e;
                int i9 = this.f15026h;
                this.f15026h = i9 + 1;
                UnsafeUtil.H(bArr2, i9, (byte) j8);
                return;
            }
            while ((j8 & (-128)) != 0) {
                try {
                    byte[] bArr3 = this.f15023e;
                    int i10 = this.f15026h;
                    this.f15026h = i10 + 1;
                    bArr3[i10] = (byte) ((((int) j8) & 127) | 128);
                    j8 >>>= 7;
                } catch (IndexOutOfBoundsException e8) {
                    throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f15026h), Integer.valueOf(this.f15025g), 1), e8);
                }
            }
            byte[] bArr4 = this.f15023e;
            int i11 = this.f15026h;
            this.f15026h = i11 + 1;
            bArr4[i11] = (byte) j8;
        }

        public final void R0(byte[] bArr, int i8, int i9) throws IOException {
            try {
                System.arraycopy(bArr, i8, this.f15023e, this.f15026h, i9);
                this.f15026h += i9;
            } catch (IndexOutOfBoundsException e8) {
                throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f15026h), Integer.valueOf(this.f15025g), Integer.valueOf(i9)), e8);
            }
        }

        public final void S0(ByteString byteString) throws IOException {
            O0(byteString.size());
            byteString.G(this);
        }

        public final void T0(int i8, MessageLite messageLite) throws IOException {
            M0(i8, 2);
            U0(messageLite);
        }

        public final void U0(MessageLite messageLite) throws IOException {
            O0(messageLite.getSerializedSize());
            messageLite.b(this);
        }

        public final void V0(String str) throws IOException {
            int i8 = this.f15026h;
            try {
                int W = CodedOutputStream.W(str.length() * 3);
                int W2 = CodedOutputStream.W(str.length());
                if (W2 == W) {
                    int i9 = i8 + W2;
                    this.f15026h = i9;
                    int f8 = Utf8.f(str, this.f15023e, i9, f0());
                    this.f15026h = i8;
                    O0((f8 - i8) - W2);
                    this.f15026h = f8;
                } else {
                    O0(Utf8.g(str));
                    this.f15026h = Utf8.f(str, this.f15023e, this.f15026h, f0());
                }
            } catch (Utf8.UnpairedSurrogateException e8) {
                this.f15026h = i8;
                b0(str, e8);
            } catch (IndexOutOfBoundsException e9) {
                throw new OutOfSpaceException(e9);
            }
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream, com.google.crypto.tink.shaded.protobuf.ByteOutput
        public final void a(byte[] bArr, int i8, int i9) throws IOException {
            R0(bArr, i8, i9);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public final int f0() {
            return this.f15025g - this.f15026h;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public final void g0(byte b8) throws IOException {
            try {
                byte[] bArr = this.f15023e;
                int i8 = this.f15026h;
                this.f15026h = i8 + 1;
                bArr[i8] = b8;
            } catch (IndexOutOfBoundsException e8) {
                throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f15026h), Integer.valueOf(this.f15025g), 1), e8);
            }
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public final void h0(int i8, boolean z7) throws IOException {
            M0(i8, 0);
            g0(z7 ? (byte) 1 : (byte) 0);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public final void j0(int i8, ByteString byteString) throws IOException {
            M0(i8, 2);
            S0(byteString);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public final void o0(int i8, int i9) throws IOException {
            M0(i8, 5);
            p0(i9);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public final void p0(int i8) throws IOException {
            try {
                byte[] bArr = this.f15023e;
                int i9 = this.f15026h;
                int i10 = i9 + 1;
                bArr[i9] = (byte) (i8 & 255);
                int i11 = i10 + 1;
                bArr[i10] = (byte) ((i8 >> 8) & 255);
                int i12 = i11 + 1;
                bArr[i11] = (byte) ((i8 >> 16) & 255);
                this.f15026h = i12 + 1;
                bArr[i12] = (byte) ((i8 >> 24) & 255);
            } catch (IndexOutOfBoundsException e8) {
                throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f15026h), Integer.valueOf(this.f15025g), 1), e8);
            }
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public final void q0(int i8, long j8) throws IOException {
            M0(i8, 1);
            r0(j8);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public final void r0(long j8) throws IOException {
            try {
                byte[] bArr = this.f15023e;
                int i8 = this.f15026h;
                int i9 = i8 + 1;
                bArr[i8] = (byte) (((int) j8) & 255);
                int i10 = i9 + 1;
                bArr[i9] = (byte) (((int) (j8 >> 8)) & 255);
                int i11 = i10 + 1;
                bArr[i10] = (byte) (((int) (j8 >> 16)) & 255);
                int i12 = i11 + 1;
                bArr[i11] = (byte) (((int) (j8 >> 24)) & 255);
                int i13 = i12 + 1;
                bArr[i12] = (byte) (((int) (j8 >> 32)) & 255);
                int i14 = i13 + 1;
                bArr[i13] = (byte) (((int) (j8 >> 40)) & 255);
                int i15 = i14 + 1;
                bArr[i14] = (byte) (((int) (j8 >> 48)) & 255);
                this.f15026h = i15 + 1;
                bArr[i15] = (byte) (((int) (j8 >> 56)) & 255);
            } catch (IndexOutOfBoundsException e8) {
                throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f15026h), Integer.valueOf(this.f15025g), 1), e8);
            }
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public final void w0(int i8, int i9) throws IOException {
            M0(i8, 0);
            x0(i9);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public final void x0(int i8) throws IOException {
            if (i8 >= 0) {
                O0(i8);
            } else {
                Q0(i8);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class OutOfSpaceException extends IOException {
        OutOfSpaceException() {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.");
        }

        OutOfSpaceException(Throwable th) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.", th);
        }

        OutOfSpaceException(String str, Throwable th) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.: " + str, th);
        }
    }

    public static int A(int i8, LazyFieldLite lazyFieldLite) {
        return U(i8) + B(lazyFieldLite);
    }

    public static int B(LazyFieldLite lazyFieldLite) {
        return C(lazyFieldLite.b());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int C(int i8) {
        return W(i8) + i8;
    }

    public static int D(int i8, MessageLite messageLite) {
        return (U(1) * 2) + V(2, i8) + E(3, messageLite);
    }

    public static int E(int i8, MessageLite messageLite) {
        return U(i8) + G(messageLite);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int F(int i8, MessageLite messageLite, Schema schema) {
        return U(i8) + H(messageLite, schema);
    }

    public static int G(MessageLite messageLite) {
        return C(messageLite.getSerializedSize());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int H(MessageLite messageLite, Schema schema) {
        return C(((AbstractMessageLite) messageLite).d(schema));
    }

    public static int I(int i8, ByteString byteString) {
        return (U(1) * 2) + V(2, i8) + g(3, byteString);
    }

    @Deprecated
    public static int J(int i8) {
        return W(i8);
    }

    public static int K(int i8, int i9) {
        return U(i8) + L(i9);
    }

    public static int L(int i8) {
        return 4;
    }

    public static int M(int i8, long j8) {
        return U(i8) + N(j8);
    }

    public static int N(long j8) {
        return 8;
    }

    public static int O(int i8, int i9) {
        return U(i8) + P(i9);
    }

    public static int P(int i8) {
        return W(Z(i8));
    }

    public static int Q(int i8, long j8) {
        return U(i8) + R(j8);
    }

    public static int R(long j8) {
        return Y(a0(j8));
    }

    public static int S(int i8, String str) {
        return U(i8) + T(str);
    }

    public static int T(String str) {
        int length;
        try {
            length = Utf8.g(str);
        } catch (Utf8.UnpairedSurrogateException unused) {
            length = str.getBytes(Internal.f15115a).length;
        }
        return C(length);
    }

    public static int U(int i8) {
        return W(WireFormat.c(i8, 0));
    }

    public static int V(int i8, int i9) {
        return U(i8) + W(i9);
    }

    public static int W(int i8) {
        if ((i8 & (-128)) == 0) {
            return 1;
        }
        if ((i8 & (-16384)) == 0) {
            return 2;
        }
        if (((-2097152) & i8) == 0) {
            return 3;
        }
        return (i8 & (-268435456)) == 0 ? 4 : 5;
    }

    public static int X(int i8, long j8) {
        return U(i8) + Y(j8);
    }

    public static int Y(long j8) {
        int i8;
        if (((-128) & j8) == 0) {
            return 1;
        }
        if (j8 < 0) {
            return 10;
        }
        if (((-34359738368L) & j8) != 0) {
            i8 = 6;
            j8 >>>= 28;
        } else {
            i8 = 2;
        }
        if (((-2097152) & j8) != 0) {
            i8 += 2;
            j8 >>>= 14;
        }
        return (j8 & (-16384)) != 0 ? i8 + 1 : i8;
    }

    public static int Z(int i8) {
        return (i8 >> 31) ^ (i8 << 1);
    }

    public static long a0(long j8) {
        return (j8 >> 63) ^ (j8 << 1);
    }

    public static int d(int i8, boolean z7) {
        return U(i8) + e(z7);
    }

    public static CodedOutputStream d0(byte[] bArr) {
        return e0(bArr, 0, bArr.length);
    }

    public static int e(boolean z7) {
        return 1;
    }

    public static CodedOutputStream e0(byte[] bArr, int i8, int i9) {
        return new ArrayEncoder(bArr, i8, i9);
    }

    public static int f(byte[] bArr) {
        return C(bArr.length);
    }

    public static int g(int i8, ByteString byteString) {
        return U(i8) + h(byteString);
    }

    public static int h(ByteString byteString) {
        return C(byteString.size());
    }

    public static int i(int i8, double d8) {
        return U(i8) + j(d8);
    }

    public static int j(double d8) {
        return 8;
    }

    public static int k(int i8, int i9) {
        return U(i8) + l(i9);
    }

    public static int l(int i8) {
        return w(i8);
    }

    public static int m(int i8, int i9) {
        return U(i8) + n(i9);
    }

    public static int n(int i8) {
        return 4;
    }

    public static int o(int i8, long j8) {
        return U(i8) + p(j8);
    }

    public static int p(long j8) {
        return 8;
    }

    public static int q(int i8, float f8) {
        return U(i8) + r(f8);
    }

    public static int r(float f8) {
        return 4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Deprecated
    public static int s(int i8, MessageLite messageLite, Schema schema) {
        return (U(i8) * 2) + u(messageLite, schema);
    }

    @Deprecated
    public static int t(MessageLite messageLite) {
        return messageLite.getSerializedSize();
    }

    @Deprecated
    static int u(MessageLite messageLite, Schema schema) {
        return ((AbstractMessageLite) messageLite).d(schema);
    }

    public static int v(int i8, int i9) {
        return U(i8) + w(i9);
    }

    public static int w(int i8) {
        if (i8 >= 0) {
            return W(i8);
        }
        return 10;
    }

    public static int x(int i8, long j8) {
        return U(i8) + y(j8);
    }

    public static int y(long j8) {
        return Y(j8);
    }

    public static int z(int i8, LazyFieldLite lazyFieldLite) {
        return (U(1) * 2) + V(2, i8) + A(3, lazyFieldLite);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void A0(int i8, MessageLite messageLite, Schema schema) throws IOException;

    public abstract void B0(int i8, MessageLite messageLite) throws IOException;

    public abstract void C0(int i8, ByteString byteString) throws IOException;

    public final void D0(int i8, int i9) throws IOException {
        o0(i8, i9);
    }

    public final void E0(int i8) throws IOException {
        p0(i8);
    }

    public final void F0(int i8, long j8) throws IOException {
        q0(i8, j8);
    }

    public final void G0(long j8) throws IOException {
        r0(j8);
    }

    public final void H0(int i8, int i9) throws IOException {
        N0(i8, Z(i9));
    }

    public final void I0(int i8) throws IOException {
        O0(Z(i8));
    }

    public final void J0(int i8, long j8) throws IOException {
        P0(i8, a0(j8));
    }

    public final void K0(long j8) throws IOException {
        Q0(a0(j8));
    }

    public abstract void L0(int i8, String str) throws IOException;

    public abstract void M0(int i8, int i9) throws IOException;

    public abstract void N0(int i8, int i9) throws IOException;

    public abstract void O0(int i8) throws IOException;

    public abstract void P0(int i8, long j8) throws IOException;

    public abstract void Q0(long j8) throws IOException;

    @Override // com.google.crypto.tink.shaded.protobuf.ByteOutput
    public abstract void a(byte[] bArr, int i8, int i9) throws IOException;

    final void b0(String str, Utf8.UnpairedSurrogateException unpairedSurrogateException) throws IOException {
        f15019c.log(Level.WARNING, "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) unpairedSurrogateException);
        byte[] bytes = str.getBytes(Internal.f15115a);
        try {
            O0(bytes.length);
            a(bytes, 0, bytes.length);
        } catch (OutOfSpaceException e8) {
            throw e8;
        } catch (IndexOutOfBoundsException e9) {
            throw new OutOfSpaceException(e9);
        }
    }

    public final void c() {
        if (f0() == 0) {
            return;
        }
        throw new IllegalStateException("Did not write as much data as expected.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean c0() {
        return this.f15022b;
    }

    public abstract int f0();

    public abstract void g0(byte b8) throws IOException;

    public abstract void h0(int i8, boolean z7) throws IOException;

    public final void i0(boolean z7) throws IOException {
        g0(z7 ? (byte) 1 : (byte) 0);
    }

    public abstract void j0(int i8, ByteString byteString) throws IOException;

    public final void k0(int i8, double d8) throws IOException {
        q0(i8, Double.doubleToRawLongBits(d8));
    }

    public final void l0(double d8) throws IOException {
        r0(Double.doubleToRawLongBits(d8));
    }

    public final void m0(int i8, int i9) throws IOException {
        w0(i8, i9);
    }

    public final void n0(int i8) throws IOException {
        x0(i8);
    }

    public abstract void o0(int i8, int i9) throws IOException;

    public abstract void p0(int i8) throws IOException;

    public abstract void q0(int i8, long j8) throws IOException;

    public abstract void r0(long j8) throws IOException;

    public final void s0(int i8, float f8) throws IOException {
        o0(i8, Float.floatToRawIntBits(f8));
    }

    public final void t0(float f8) throws IOException {
        p0(Float.floatToRawIntBits(f8));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Deprecated
    public final void u0(int i8, MessageLite messageLite, Schema schema) throws IOException {
        M0(i8, 3);
        v0(messageLite, schema);
        M0(i8, 4);
    }

    @Deprecated
    final void v0(MessageLite messageLite, Schema schema) throws IOException {
        schema.h(messageLite, this.f15021a);
    }

    public abstract void w0(int i8, int i9) throws IOException;

    public abstract void x0(int i8) throws IOException;

    public final void y0(int i8, long j8) throws IOException {
        P0(i8, j8);
    }

    public final void z0(long j8) throws IOException {
        Q0(j8);
    }

    private CodedOutputStream() {
    }
}
