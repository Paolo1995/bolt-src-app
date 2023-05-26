package com.google.crypto.tink.shaded.protobuf;

import com.google.android.gms.common.api.Api;
import java.io.IOException;
import java.util.Arrays;

/* loaded from: classes.dex */
public abstract class CodedInputStream {

    /* renamed from: a  reason: collision with root package name */
    int f15001a;

    /* renamed from: b  reason: collision with root package name */
    int f15002b;

    /* renamed from: c  reason: collision with root package name */
    int f15003c;

    /* renamed from: d  reason: collision with root package name */
    CodedInputStreamReader f15004d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f15005e;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class ArrayDecoder extends CodedInputStream {

        /* renamed from: f  reason: collision with root package name */
        private final byte[] f15006f;

        /* renamed from: g  reason: collision with root package name */
        private final boolean f15007g;

        /* renamed from: h  reason: collision with root package name */
        private int f15008h;

        /* renamed from: i  reason: collision with root package name */
        private int f15009i;

        /* renamed from: j  reason: collision with root package name */
        private int f15010j;

        /* renamed from: k  reason: collision with root package name */
        private int f15011k;

        /* renamed from: l  reason: collision with root package name */
        private int f15012l;

        /* renamed from: m  reason: collision with root package name */
        private boolean f15013m;

        /* renamed from: n  reason: collision with root package name */
        private int f15014n;

        private void K() {
            int i8 = this.f15008h + this.f15009i;
            this.f15008h = i8;
            int i9 = i8 - this.f15011k;
            int i10 = this.f15014n;
            if (i9 > i10) {
                int i11 = i9 - i10;
                this.f15009i = i11;
                this.f15008h = i8 - i11;
                return;
            }
            this.f15009i = 0;
        }

        private void N() throws IOException {
            if (this.f15008h - this.f15010j >= 10) {
                O();
            } else {
                P();
            }
        }

        private void O() throws IOException {
            for (int i8 = 0; i8 < 10; i8++) {
                byte[] bArr = this.f15006f;
                int i9 = this.f15010j;
                this.f15010j = i9 + 1;
                if (bArr[i9] >= 0) {
                    return;
                }
            }
            throw InvalidProtocolBufferException.e();
        }

        private void P() throws IOException {
            for (int i8 = 0; i8 < 10; i8++) {
                if (D() >= 0) {
                    return;
                }
            }
            throw InvalidProtocolBufferException.e();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public int A() throws IOException {
            return H();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public long B() throws IOException {
            return I();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public boolean C(int i8) throws IOException {
            int b8 = WireFormat.b(i8);
            if (b8 != 0) {
                if (b8 != 1) {
                    if (b8 != 2) {
                        if (b8 != 3) {
                            if (b8 != 4) {
                                if (b8 == 5) {
                                    M(4);
                                    return true;
                                }
                                throw InvalidProtocolBufferException.d();
                            }
                            return false;
                        }
                        L();
                        a(WireFormat.c(WireFormat.a(i8), 4));
                        return true;
                    }
                    M(H());
                    return true;
                }
                M(8);
                return true;
            }
            N();
            return true;
        }

        public byte D() throws IOException {
            int i8 = this.f15010j;
            if (i8 != this.f15008h) {
                byte[] bArr = this.f15006f;
                this.f15010j = i8 + 1;
                return bArr[i8];
            }
            throw InvalidProtocolBufferException.j();
        }

        public byte[] E(int i8) throws IOException {
            if (i8 > 0) {
                int i9 = this.f15008h;
                int i10 = this.f15010j;
                if (i8 <= i9 - i10) {
                    int i11 = i8 + i10;
                    this.f15010j = i11;
                    return Arrays.copyOfRange(this.f15006f, i10, i11);
                }
            }
            if (i8 <= 0) {
                if (i8 == 0) {
                    return Internal.f15117c;
                }
                throw InvalidProtocolBufferException.f();
            }
            throw InvalidProtocolBufferException.j();
        }

        public int F() throws IOException {
            int i8 = this.f15010j;
            if (this.f15008h - i8 >= 4) {
                byte[] bArr = this.f15006f;
                this.f15010j = i8 + 4;
                return ((bArr[i8 + 3] & 255) << 24) | (bArr[i8] & 255) | ((bArr[i8 + 1] & 255) << 8) | ((bArr[i8 + 2] & 255) << 16);
            }
            throw InvalidProtocolBufferException.j();
        }

        public long G() throws IOException {
            int i8 = this.f15010j;
            if (this.f15008h - i8 >= 8) {
                byte[] bArr = this.f15006f;
                this.f15010j = i8 + 8;
                return ((bArr[i8 + 7] & 255) << 56) | (bArr[i8] & 255) | ((bArr[i8 + 1] & 255) << 8) | ((bArr[i8 + 2] & 255) << 16) | ((bArr[i8 + 3] & 255) << 24) | ((bArr[i8 + 4] & 255) << 32) | ((bArr[i8 + 5] & 255) << 40) | ((bArr[i8 + 6] & 255) << 48);
            }
            throw InvalidProtocolBufferException.j();
        }

        /* JADX WARN: Code restructure failed: missing block: B:33:0x0068, code lost:
            if (r2[r3] < 0) goto L34;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public int H() throws java.io.IOException {
            /*
                r5 = this;
                int r0 = r5.f15010j
                int r1 = r5.f15008h
                if (r1 != r0) goto L7
                goto L6a
            L7:
                byte[] r2 = r5.f15006f
                int r3 = r0 + 1
                r0 = r2[r0]
                if (r0 < 0) goto L12
                r5.f15010j = r3
                return r0
            L12:
                int r1 = r1 - r3
                r4 = 9
                if (r1 >= r4) goto L18
                goto L6a
            L18:
                int r1 = r3 + 1
                r3 = r2[r3]
                int r3 = r3 << 7
                r0 = r0 ^ r3
                if (r0 >= 0) goto L24
                r0 = r0 ^ (-128(0xffffffffffffff80, float:NaN))
                goto L70
            L24:
                int r3 = r1 + 1
                r1 = r2[r1]
                int r1 = r1 << 14
                r0 = r0 ^ r1
                if (r0 < 0) goto L31
                r0 = r0 ^ 16256(0x3f80, float:2.278E-41)
            L2f:
                r1 = r3
                goto L70
            L31:
                int r1 = r3 + 1
                r3 = r2[r3]
                int r3 = r3 << 21
                r0 = r0 ^ r3
                if (r0 >= 0) goto L3f
                r2 = -2080896(0xffffffffffe03f80, float:NaN)
                r0 = r0 ^ r2
                goto L70
            L3f:
                int r3 = r1 + 1
                r1 = r2[r1]
                int r4 = r1 << 28
                r0 = r0 ^ r4
                r4 = 266354560(0xfe03f80, float:2.2112565E-29)
                r0 = r0 ^ r4
                if (r1 >= 0) goto L2f
                int r1 = r3 + 1
                r3 = r2[r3]
                if (r3 >= 0) goto L70
                int r3 = r1 + 1
                r1 = r2[r1]
                if (r1 >= 0) goto L2f
                int r1 = r3 + 1
                r3 = r2[r3]
                if (r3 >= 0) goto L70
                int r3 = r1 + 1
                r1 = r2[r1]
                if (r1 >= 0) goto L2f
                int r1 = r3 + 1
                r2 = r2[r3]
                if (r2 >= 0) goto L70
            L6a:
                long r0 = r5.J()
                int r1 = (int) r0
                return r1
            L70:
                r5.f15010j = r1
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.shaded.protobuf.CodedInputStream.ArrayDecoder.H():int");
        }

        /* JADX WARN: Code restructure failed: missing block: B:39:0x00b4, code lost:
            if (r2[r0] < 0) goto L42;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public long I() throws java.io.IOException {
            /*
                Method dump skipped, instructions count: 192
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.shaded.protobuf.CodedInputStream.ArrayDecoder.I():long");
        }

        long J() throws IOException {
            long j8 = 0;
            for (int i8 = 0; i8 < 64; i8 += 7) {
                byte D = D();
                j8 |= (D & Byte.MAX_VALUE) << i8;
                if ((D & 128) == 0) {
                    return j8;
                }
            }
            throw InvalidProtocolBufferException.e();
        }

        public void L() throws IOException {
            int z7;
            do {
                z7 = z();
                if (z7 == 0) {
                    return;
                }
            } while (C(z7));
        }

        public void M(int i8) throws IOException {
            if (i8 >= 0) {
                int i9 = this.f15008h;
                int i10 = this.f15010j;
                if (i8 <= i9 - i10) {
                    this.f15010j = i10 + i8;
                    return;
                }
            }
            if (i8 < 0) {
                throw InvalidProtocolBufferException.f();
            }
            throw InvalidProtocolBufferException.j();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public void a(int i8) throws InvalidProtocolBufferException {
            if (this.f15012l == i8) {
                return;
            }
            throw InvalidProtocolBufferException.a();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public int d() {
            return this.f15010j - this.f15011k;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public boolean e() throws IOException {
            if (this.f15010j == this.f15008h) {
                return true;
            }
            return false;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public void i(int i8) {
            this.f15014n = i8;
            K();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public int j(int i8) throws InvalidProtocolBufferException {
            if (i8 >= 0) {
                int d8 = i8 + d();
                int i9 = this.f15014n;
                if (d8 <= i9) {
                    this.f15014n = d8;
                    K();
                    return i9;
                }
                throw InvalidProtocolBufferException.j();
            }
            throw InvalidProtocolBufferException.f();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public boolean k() throws IOException {
            if (I() != 0) {
                return true;
            }
            return false;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public ByteString l() throws IOException {
            ByteString k8;
            int H = H();
            if (H > 0) {
                int i8 = this.f15008h;
                int i9 = this.f15010j;
                if (H <= i8 - i9) {
                    if (this.f15007g && this.f15013m) {
                        k8 = ByteString.F(this.f15006f, i9, H);
                    } else {
                        k8 = ByteString.k(this.f15006f, i9, H);
                    }
                    this.f15010j += H;
                    return k8;
                }
            }
            if (H == 0) {
                return ByteString.f14989g;
            }
            return ByteString.E(E(H));
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public double m() throws IOException {
            return Double.longBitsToDouble(G());
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public int n() throws IOException {
            return H();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public int o() throws IOException {
            return F();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public long p() throws IOException {
            return G();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public float q() throws IOException {
            return Float.intBitsToFloat(F());
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public int r() throws IOException {
            return H();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public long s() throws IOException {
            return I();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public int t() throws IOException {
            return F();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public long u() throws IOException {
            return G();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public int v() throws IOException {
            return CodedInputStream.b(H());
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public long w() throws IOException {
            return CodedInputStream.c(I());
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public String x() throws IOException {
            int H = H();
            if (H > 0) {
                int i8 = this.f15008h;
                int i9 = this.f15010j;
                if (H <= i8 - i9) {
                    String str = new String(this.f15006f, i9, H, Internal.f15115a);
                    this.f15010j += H;
                    return str;
                }
            }
            if (H == 0) {
                return "";
            }
            if (H < 0) {
                throw InvalidProtocolBufferException.f();
            }
            throw InvalidProtocolBufferException.j();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public String y() throws IOException {
            int H = H();
            if (H > 0) {
                int i8 = this.f15008h;
                int i9 = this.f15010j;
                if (H <= i8 - i9) {
                    String e8 = Utf8.e(this.f15006f, i9, H);
                    this.f15010j += H;
                    return e8;
                }
            }
            if (H == 0) {
                return "";
            }
            if (H <= 0) {
                throw InvalidProtocolBufferException.f();
            }
            throw InvalidProtocolBufferException.j();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public int z() throws IOException {
            if (e()) {
                this.f15012l = 0;
                return 0;
            }
            int H = H();
            this.f15012l = H;
            if (WireFormat.a(H) != 0) {
                return this.f15012l;
            }
            throw InvalidProtocolBufferException.b();
        }

        private ArrayDecoder(byte[] bArr, int i8, int i9, boolean z7) {
            super();
            this.f15014n = Api.BaseClientBuilder.API_PRIORITY_OTHER;
            this.f15006f = bArr;
            this.f15008h = i9 + i8;
            this.f15010j = i8;
            this.f15011k = i8;
            this.f15007g = z7;
        }
    }

    public static int b(int i8) {
        return (-(i8 & 1)) ^ (i8 >>> 1);
    }

    public static long c(long j8) {
        return (-(j8 & 1)) ^ (j8 >>> 1);
    }

    public static CodedInputStream f(byte[] bArr) {
        return g(bArr, 0, bArr.length);
    }

    public static CodedInputStream g(byte[] bArr, int i8, int i9) {
        return h(bArr, i8, i9, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static CodedInputStream h(byte[] bArr, int i8, int i9, boolean z7) {
        ArrayDecoder arrayDecoder = new ArrayDecoder(bArr, i8, i9, z7);
        try {
            arrayDecoder.j(i9);
            return arrayDecoder;
        } catch (InvalidProtocolBufferException e8) {
            throw new IllegalArgumentException(e8);
        }
    }

    public abstract int A() throws IOException;

    public abstract long B() throws IOException;

    public abstract boolean C(int i8) throws IOException;

    public abstract void a(int i8) throws InvalidProtocolBufferException;

    public abstract int d();

    public abstract boolean e() throws IOException;

    public abstract void i(int i8);

    public abstract int j(int i8) throws InvalidProtocolBufferException;

    public abstract boolean k() throws IOException;

    public abstract ByteString l() throws IOException;

    public abstract double m() throws IOException;

    public abstract int n() throws IOException;

    public abstract int o() throws IOException;

    public abstract long p() throws IOException;

    public abstract float q() throws IOException;

    public abstract int r() throws IOException;

    public abstract long s() throws IOException;

    public abstract int t() throws IOException;

    public abstract long u() throws IOException;

    public abstract int v() throws IOException;

    public abstract long w() throws IOException;

    public abstract String x() throws IOException;

    public abstract String y() throws IOException;

    public abstract int z() throws IOException;

    private CodedInputStream() {
        this.f15002b = 100;
        this.f15003c = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        this.f15005e = false;
    }
}
