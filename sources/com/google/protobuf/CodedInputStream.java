package com.google.protobuf;

import com.google.android.gms.common.api.Api;
import com.google.protobuf.MessageLite;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public abstract class CodedInputStream {

    /* renamed from: f  reason: collision with root package name */
    private static volatile int f17190f = 100;

    /* renamed from: a  reason: collision with root package name */
    int f17191a;

    /* renamed from: b  reason: collision with root package name */
    int f17192b;

    /* renamed from: c  reason: collision with root package name */
    int f17193c;

    /* renamed from: d  reason: collision with root package name */
    CodedInputStreamReader f17194d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f17195e;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static final class ArrayDecoder extends CodedInputStream {

        /* renamed from: g  reason: collision with root package name */
        private final byte[] f17196g;

        /* renamed from: h  reason: collision with root package name */
        private final boolean f17197h;

        /* renamed from: i  reason: collision with root package name */
        private int f17198i;

        /* renamed from: j  reason: collision with root package name */
        private int f17199j;

        /* renamed from: k  reason: collision with root package name */
        private int f17200k;

        /* renamed from: l  reason: collision with root package name */
        private int f17201l;

        /* renamed from: m  reason: collision with root package name */
        private int f17202m;

        /* renamed from: n  reason: collision with root package name */
        private boolean f17203n;

        /* renamed from: o  reason: collision with root package name */
        private int f17204o;

        private void U() {
            int i8 = this.f17198i + this.f17199j;
            this.f17198i = i8;
            int i9 = i8 - this.f17201l;
            int i10 = this.f17204o;
            if (i9 > i10) {
                int i11 = i9 - i10;
                this.f17199j = i11;
                this.f17198i = i8 - i11;
                return;
            }
            this.f17199j = 0;
        }

        private void X() throws IOException {
            if (this.f17198i - this.f17200k >= 10) {
                Y();
            } else {
                Z();
            }
        }

        private void Y() throws IOException {
            for (int i8 = 0; i8 < 10; i8++) {
                byte[] bArr = this.f17196g;
                int i9 = this.f17200k;
                this.f17200k = i9 + 1;
                if (bArr[i9] >= 0) {
                    return;
                }
            }
            throw InvalidProtocolBufferException.f();
        }

        private void Z() throws IOException {
            for (int i8 = 0; i8 < 10; i8++) {
                if (O() >= 0) {
                    return;
                }
            }
            throw InvalidProtocolBufferException.f();
        }

        @Override // com.google.protobuf.CodedInputStream
        public long A() throws IOException {
            return S();
        }

        @Override // com.google.protobuf.CodedInputStream
        public void B(MessageLite.Builder builder, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            int C = C();
            b();
            int q8 = q(C);
            this.f17191a++;
            builder.y(this, extensionRegistryLite);
            a(0);
            this.f17191a--;
            if (e() == 0) {
                p(q8);
                return;
            }
            throw InvalidProtocolBufferException.m();
        }

        /* JADX WARN: Code restructure failed: missing block: B:33:0x0068, code lost:
            if (r2[r3] < 0) goto L34;
         */
        @Override // com.google.protobuf.CodedInputStream
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public int C() throws java.io.IOException {
            /*
                r5 = this;
                int r0 = r5.f17200k
                int r1 = r5.f17198i
                if (r1 != r0) goto L7
                goto L6a
            L7:
                byte[] r2 = r5.f17196g
                int r3 = r0 + 1
                r0 = r2[r0]
                if (r0 < 0) goto L12
                r5.f17200k = r3
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
                long r0 = r5.T()
                int r1 = (int) r0
                return r1
            L70:
                r5.f17200k = r1
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.CodedInputStream.ArrayDecoder.C():int");
        }

        @Override // com.google.protobuf.CodedInputStream
        public int E() throws IOException {
            return Q();
        }

        @Override // com.google.protobuf.CodedInputStream
        public long F() throws IOException {
            return R();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int G() throws IOException {
            return CodedInputStream.c(C());
        }

        @Override // com.google.protobuf.CodedInputStream
        public long H() throws IOException {
            return CodedInputStream.d(S());
        }

        @Override // com.google.protobuf.CodedInputStream
        public String I() throws IOException {
            int C = C();
            if (C > 0) {
                int i8 = this.f17198i;
                int i9 = this.f17200k;
                if (C <= i8 - i9) {
                    String str = new String(this.f17196g, i9, C, Internal.f17450b);
                    this.f17200k += C;
                    return str;
                }
            }
            if (C == 0) {
                return "";
            }
            if (C < 0) {
                throw InvalidProtocolBufferException.g();
            }
            throw InvalidProtocolBufferException.m();
        }

        @Override // com.google.protobuf.CodedInputStream
        public String J() throws IOException {
            int C = C();
            if (C > 0) {
                int i8 = this.f17198i;
                int i9 = this.f17200k;
                if (C <= i8 - i9) {
                    String h8 = Utf8.h(this.f17196g, i9, C);
                    this.f17200k += C;
                    return h8;
                }
            }
            if (C == 0) {
                return "";
            }
            if (C <= 0) {
                throw InvalidProtocolBufferException.g();
            }
            throw InvalidProtocolBufferException.m();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int K() throws IOException {
            if (g()) {
                this.f17202m = 0;
                return 0;
            }
            int C = C();
            this.f17202m = C;
            if (WireFormat.a(C) != 0) {
                return this.f17202m;
            }
            throw InvalidProtocolBufferException.c();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int L() throws IOException {
            return C();
        }

        @Override // com.google.protobuf.CodedInputStream
        public long M() throws IOException {
            return S();
        }

        @Override // com.google.protobuf.CodedInputStream
        public boolean N(int i8) throws IOException {
            int b8 = WireFormat.b(i8);
            if (b8 != 0) {
                if (b8 != 1) {
                    if (b8 != 2) {
                        if (b8 != 3) {
                            if (b8 != 4) {
                                if (b8 == 5) {
                                    W(4);
                                    return true;
                                }
                                throw InvalidProtocolBufferException.e();
                            }
                            return false;
                        }
                        V();
                        a(WireFormat.c(WireFormat.a(i8), 4));
                        return true;
                    }
                    W(C());
                    return true;
                }
                W(8);
                return true;
            }
            X();
            return true;
        }

        public byte O() throws IOException {
            int i8 = this.f17200k;
            if (i8 != this.f17198i) {
                byte[] bArr = this.f17196g;
                this.f17200k = i8 + 1;
                return bArr[i8];
            }
            throw InvalidProtocolBufferException.m();
        }

        public byte[] P(int i8) throws IOException {
            if (i8 > 0) {
                int i9 = this.f17198i;
                int i10 = this.f17200k;
                if (i8 <= i9 - i10) {
                    int i11 = i8 + i10;
                    this.f17200k = i11;
                    return Arrays.copyOfRange(this.f17196g, i10, i11);
                }
            }
            if (i8 <= 0) {
                if (i8 == 0) {
                    return Internal.f17452d;
                }
                throw InvalidProtocolBufferException.g();
            }
            throw InvalidProtocolBufferException.m();
        }

        public int Q() throws IOException {
            int i8 = this.f17200k;
            if (this.f17198i - i8 >= 4) {
                byte[] bArr = this.f17196g;
                this.f17200k = i8 + 4;
                return ((bArr[i8 + 3] & 255) << 24) | (bArr[i8] & 255) | ((bArr[i8 + 1] & 255) << 8) | ((bArr[i8 + 2] & 255) << 16);
            }
            throw InvalidProtocolBufferException.m();
        }

        public long R() throws IOException {
            int i8 = this.f17200k;
            if (this.f17198i - i8 >= 8) {
                byte[] bArr = this.f17196g;
                this.f17200k = i8 + 8;
                return ((bArr[i8 + 7] & 255) << 56) | (bArr[i8] & 255) | ((bArr[i8 + 1] & 255) << 8) | ((bArr[i8 + 2] & 255) << 16) | ((bArr[i8 + 3] & 255) << 24) | ((bArr[i8 + 4] & 255) << 32) | ((bArr[i8 + 5] & 255) << 40) | ((bArr[i8 + 6] & 255) << 48);
            }
            throw InvalidProtocolBufferException.m();
        }

        /* JADX WARN: Code restructure failed: missing block: B:39:0x00b4, code lost:
            if (r2[r0] < 0) goto L42;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public long S() throws java.io.IOException {
            /*
                Method dump skipped, instructions count: 192
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.CodedInputStream.ArrayDecoder.S():long");
        }

        long T() throws IOException {
            long j8 = 0;
            for (int i8 = 0; i8 < 64; i8 += 7) {
                byte O = O();
                j8 |= (O & Byte.MAX_VALUE) << i8;
                if ((O & 128) == 0) {
                    return j8;
                }
            }
            throw InvalidProtocolBufferException.f();
        }

        public void V() throws IOException {
            int K;
            do {
                K = K();
                if (K == 0) {
                    return;
                }
            } while (N(K));
        }

        public void W(int i8) throws IOException {
            if (i8 >= 0) {
                int i9 = this.f17198i;
                int i10 = this.f17200k;
                if (i8 <= i9 - i10) {
                    this.f17200k = i10 + i8;
                    return;
                }
            }
            if (i8 < 0) {
                throw InvalidProtocolBufferException.g();
            }
            throw InvalidProtocolBufferException.m();
        }

        @Override // com.google.protobuf.CodedInputStream
        public void a(int i8) throws InvalidProtocolBufferException {
            if (this.f17202m == i8) {
                return;
            }
            throw InvalidProtocolBufferException.b();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int e() {
            int i8 = this.f17204o;
            if (i8 == Integer.MAX_VALUE) {
                return -1;
            }
            return i8 - f();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int f() {
            return this.f17200k - this.f17201l;
        }

        @Override // com.google.protobuf.CodedInputStream
        public boolean g() throws IOException {
            if (this.f17200k == this.f17198i) {
                return true;
            }
            return false;
        }

        @Override // com.google.protobuf.CodedInputStream
        public void p(int i8) {
            this.f17204o = i8;
            U();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int q(int i8) throws InvalidProtocolBufferException {
            if (i8 >= 0) {
                int f8 = i8 + f();
                if (f8 >= 0) {
                    int i9 = this.f17204o;
                    if (f8 <= i9) {
                        this.f17204o = f8;
                        U();
                        return i9;
                    }
                    throw InvalidProtocolBufferException.m();
                }
                throw InvalidProtocolBufferException.h();
            }
            throw InvalidProtocolBufferException.g();
        }

        @Override // com.google.protobuf.CodedInputStream
        public boolean r() throws IOException {
            if (S() != 0) {
                return true;
            }
            return false;
        }

        @Override // com.google.protobuf.CodedInputStream
        public ByteString s() throws IOException {
            ByteString p8;
            int C = C();
            if (C > 0) {
                int i8 = this.f17198i;
                int i9 = this.f17200k;
                if (C <= i8 - i9) {
                    if (this.f17197h && this.f17203n) {
                        p8 = ByteString.P(this.f17196g, i9, C);
                    } else {
                        p8 = ByteString.p(this.f17196g, i9, C);
                    }
                    this.f17200k += C;
                    return p8;
                }
            }
            if (C == 0) {
                return ByteString.f17177g;
            }
            return ByteString.O(P(C));
        }

        @Override // com.google.protobuf.CodedInputStream
        public double t() throws IOException {
            return Double.longBitsToDouble(R());
        }

        @Override // com.google.protobuf.CodedInputStream
        public int u() throws IOException {
            return C();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int v() throws IOException {
            return Q();
        }

        @Override // com.google.protobuf.CodedInputStream
        public long w() throws IOException {
            return R();
        }

        @Override // com.google.protobuf.CodedInputStream
        public float x() throws IOException {
            return Float.intBitsToFloat(Q());
        }

        @Override // com.google.protobuf.CodedInputStream
        public void y(int i8, MessageLite.Builder builder, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            b();
            this.f17191a++;
            builder.y(this, extensionRegistryLite);
            a(WireFormat.c(i8, 4));
            this.f17191a--;
        }

        @Override // com.google.protobuf.CodedInputStream
        public int z() throws IOException {
            return C();
        }

        private ArrayDecoder(byte[] bArr, int i8, int i9, boolean z7) {
            super();
            this.f17204o = Api.BaseClientBuilder.API_PRIORITY_OTHER;
            this.f17196g = bArr;
            this.f17198i = i9 + i8;
            this.f17200k = i8;
            this.f17201l = i8;
            this.f17197h = z7;
        }
    }

    /* loaded from: classes3.dex */
    private static final class IterableDirectByteBufferDecoder extends CodedInputStream {

        /* renamed from: g  reason: collision with root package name */
        private final Iterable<ByteBuffer> f17205g;

        /* renamed from: h  reason: collision with root package name */
        private final Iterator<ByteBuffer> f17206h;

        /* renamed from: i  reason: collision with root package name */
        private ByteBuffer f17207i;

        /* renamed from: j  reason: collision with root package name */
        private final boolean f17208j;

        /* renamed from: k  reason: collision with root package name */
        private boolean f17209k;

        /* renamed from: l  reason: collision with root package name */
        private int f17210l;

        /* renamed from: m  reason: collision with root package name */
        private int f17211m;

        /* renamed from: n  reason: collision with root package name */
        private int f17212n;

        /* renamed from: o  reason: collision with root package name */
        private int f17213o;

        /* renamed from: p  reason: collision with root package name */
        private int f17214p;

        /* renamed from: q  reason: collision with root package name */
        private int f17215q;

        /* renamed from: r  reason: collision with root package name */
        private long f17216r;

        /* renamed from: s  reason: collision with root package name */
        private long f17217s;

        /* renamed from: t  reason: collision with root package name */
        private long f17218t;

        /* renamed from: u  reason: collision with root package name */
        private long f17219u;

        private long O() {
            return this.f17219u - this.f17216r;
        }

        private void P() throws InvalidProtocolBufferException {
            if (this.f17206h.hasNext()) {
                c0();
                return;
            }
            throw InvalidProtocolBufferException.m();
        }

        private void R(byte[] bArr, int i8, int i9) throws IOException {
            if (i9 >= 0 && i9 <= X()) {
                int i10 = i9;
                while (i10 > 0) {
                    if (O() == 0) {
                        P();
                    }
                    int min = Math.min(i10, (int) O());
                    long j8 = min;
                    UnsafeUtil.p(this.f17216r, bArr, (i9 - i10) + i8, j8);
                    i10 -= min;
                    this.f17216r += j8;
                }
            } else if (i9 <= 0) {
                if (i9 == 0) {
                    return;
                }
                throw InvalidProtocolBufferException.g();
            } else {
                throw InvalidProtocolBufferException.m();
            }
        }

        private void W() {
            int i8 = this.f17210l + this.f17211m;
            this.f17210l = i8;
            int i9 = i8 - this.f17215q;
            int i10 = this.f17212n;
            if (i9 > i10) {
                int i11 = i9 - i10;
                this.f17211m = i11;
                this.f17210l = i8 - i11;
                return;
            }
            this.f17211m = 0;
        }

        private int X() {
            return (int) (((this.f17210l - this.f17214p) - this.f17216r) + this.f17217s);
        }

        private void a0() throws IOException {
            for (int i8 = 0; i8 < 10; i8++) {
                if (Q() >= 0) {
                    return;
                }
            }
            throw InvalidProtocolBufferException.f();
        }

        private ByteBuffer b0(int i8, int i9) throws IOException {
            int position = this.f17207i.position();
            int limit = this.f17207i.limit();
            ByteBuffer byteBuffer = this.f17207i;
            try {
                try {
                    byteBuffer.position(i8);
                    byteBuffer.limit(i9);
                    return this.f17207i.slice();
                } catch (IllegalArgumentException unused) {
                    throw InvalidProtocolBufferException.m();
                }
            } finally {
                byteBuffer.position(position);
                byteBuffer.limit(limit);
            }
        }

        private void c0() {
            ByteBuffer next = this.f17206h.next();
            this.f17207i = next;
            this.f17214p += (int) (this.f17216r - this.f17217s);
            long position = next.position();
            this.f17216r = position;
            this.f17217s = position;
            this.f17219u = this.f17207i.limit();
            long k8 = UnsafeUtil.k(this.f17207i);
            this.f17218t = k8;
            this.f17216r += k8;
            this.f17217s += k8;
            this.f17219u += k8;
        }

        @Override // com.google.protobuf.CodedInputStream
        public long A() throws IOException {
            return U();
        }

        @Override // com.google.protobuf.CodedInputStream
        public void B(MessageLite.Builder builder, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            int C = C();
            b();
            int q8 = q(C);
            this.f17191a++;
            builder.y(this, extensionRegistryLite);
            a(0);
            this.f17191a--;
            if (e() == 0) {
                p(q8);
                return;
            }
            throw InvalidProtocolBufferException.m();
        }

        /* JADX WARN: Code restructure failed: missing block: B:33:0x0088, code lost:
            if (com.google.protobuf.UnsafeUtil.w(r4) < 0) goto L34;
         */
        @Override // com.google.protobuf.CodedInputStream
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public int C() throws java.io.IOException {
            /*
                r10 = this;
                long r0 = r10.f17216r
                long r2 = r10.f17219u
                int r4 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
                if (r4 != 0) goto La
                goto L8a
            La:
                r2 = 1
                long r4 = r0 + r2
                byte r0 = com.google.protobuf.UnsafeUtil.w(r0)
                if (r0 < 0) goto L1a
                long r4 = r10.f17216r
                long r4 = r4 + r2
                r10.f17216r = r4
                return r0
            L1a:
                long r6 = r10.f17219u
                long r8 = r10.f17216r
                long r6 = r6 - r8
                r8 = 10
                int r1 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
                if (r1 >= 0) goto L26
                goto L8a
            L26:
                long r6 = r4 + r2
                byte r1 = com.google.protobuf.UnsafeUtil.w(r4)
                int r1 = r1 << 7
                r0 = r0 ^ r1
                if (r0 >= 0) goto L34
                r0 = r0 ^ (-128(0xffffffffffffff80, float:NaN))
                goto L90
            L34:
                long r4 = r6 + r2
                byte r1 = com.google.protobuf.UnsafeUtil.w(r6)
                int r1 = r1 << 14
                r0 = r0 ^ r1
                if (r0 < 0) goto L43
                r0 = r0 ^ 16256(0x3f80, float:2.278E-41)
            L41:
                r6 = r4
                goto L90
            L43:
                long r6 = r4 + r2
                byte r1 = com.google.protobuf.UnsafeUtil.w(r4)
                int r1 = r1 << 21
                r0 = r0 ^ r1
                if (r0 >= 0) goto L53
                r1 = -2080896(0xffffffffffe03f80, float:NaN)
                r0 = r0 ^ r1
                goto L90
            L53:
                long r4 = r6 + r2
                byte r1 = com.google.protobuf.UnsafeUtil.w(r6)
                int r6 = r1 << 28
                r0 = r0 ^ r6
                r6 = 266354560(0xfe03f80, float:2.2112565E-29)
                r0 = r0 ^ r6
                if (r1 >= 0) goto L41
                long r6 = r4 + r2
                byte r1 = com.google.protobuf.UnsafeUtil.w(r4)
                if (r1 >= 0) goto L90
                long r4 = r6 + r2
                byte r1 = com.google.protobuf.UnsafeUtil.w(r6)
                if (r1 >= 0) goto L41
                long r6 = r4 + r2
                byte r1 = com.google.protobuf.UnsafeUtil.w(r4)
                if (r1 >= 0) goto L90
                long r4 = r6 + r2
                byte r1 = com.google.protobuf.UnsafeUtil.w(r6)
                if (r1 >= 0) goto L41
                long r6 = r4 + r2
                byte r1 = com.google.protobuf.UnsafeUtil.w(r4)
                if (r1 >= 0) goto L90
            L8a:
                long r0 = r10.V()
                int r1 = (int) r0
                return r1
            L90:
                r10.f17216r = r6
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.CodedInputStream.IterableDirectByteBufferDecoder.C():int");
        }

        @Override // com.google.protobuf.CodedInputStream
        public int E() throws IOException {
            return S();
        }

        @Override // com.google.protobuf.CodedInputStream
        public long F() throws IOException {
            return T();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int G() throws IOException {
            return CodedInputStream.c(C());
        }

        @Override // com.google.protobuf.CodedInputStream
        public long H() throws IOException {
            return CodedInputStream.d(U());
        }

        @Override // com.google.protobuf.CodedInputStream
        public String I() throws IOException {
            int C = C();
            if (C > 0) {
                long j8 = C;
                long j9 = this.f17219u;
                long j10 = this.f17216r;
                if (j8 <= j9 - j10) {
                    byte[] bArr = new byte[C];
                    UnsafeUtil.p(j10, bArr, 0L, j8);
                    String str = new String(bArr, Internal.f17450b);
                    this.f17216r += j8;
                    return str;
                }
            }
            if (C > 0 && C <= X()) {
                byte[] bArr2 = new byte[C];
                R(bArr2, 0, C);
                return new String(bArr2, Internal.f17450b);
            } else if (C == 0) {
                return "";
            } else {
                if (C < 0) {
                    throw InvalidProtocolBufferException.g();
                }
                throw InvalidProtocolBufferException.m();
            }
        }

        @Override // com.google.protobuf.CodedInputStream
        public String J() throws IOException {
            int C = C();
            if (C > 0) {
                long j8 = C;
                long j9 = this.f17219u;
                long j10 = this.f17216r;
                if (j8 <= j9 - j10) {
                    String g8 = Utf8.g(this.f17207i, (int) (j10 - this.f17217s), C);
                    this.f17216r += j8;
                    return g8;
                }
            }
            if (C >= 0 && C <= X()) {
                byte[] bArr = new byte[C];
                R(bArr, 0, C);
                return Utf8.h(bArr, 0, C);
            } else if (C == 0) {
                return "";
            } else {
                if (C <= 0) {
                    throw InvalidProtocolBufferException.g();
                }
                throw InvalidProtocolBufferException.m();
            }
        }

        @Override // com.google.protobuf.CodedInputStream
        public int K() throws IOException {
            if (g()) {
                this.f17213o = 0;
                return 0;
            }
            int C = C();
            this.f17213o = C;
            if (WireFormat.a(C) != 0) {
                return this.f17213o;
            }
            throw InvalidProtocolBufferException.c();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int L() throws IOException {
            return C();
        }

        @Override // com.google.protobuf.CodedInputStream
        public long M() throws IOException {
            return U();
        }

        @Override // com.google.protobuf.CodedInputStream
        public boolean N(int i8) throws IOException {
            int b8 = WireFormat.b(i8);
            if (b8 != 0) {
                if (b8 != 1) {
                    if (b8 != 2) {
                        if (b8 != 3) {
                            if (b8 != 4) {
                                if (b8 == 5) {
                                    Z(4);
                                    return true;
                                }
                                throw InvalidProtocolBufferException.e();
                            }
                            return false;
                        }
                        Y();
                        a(WireFormat.c(WireFormat.a(i8), 4));
                        return true;
                    }
                    Z(C());
                    return true;
                }
                Z(8);
                return true;
            }
            a0();
            return true;
        }

        public byte Q() throws IOException {
            if (O() == 0) {
                P();
            }
            long j8 = this.f17216r;
            this.f17216r = 1 + j8;
            return UnsafeUtil.w(j8);
        }

        public int S() throws IOException {
            if (O() >= 4) {
                long j8 = this.f17216r;
                this.f17216r = 4 + j8;
                return ((UnsafeUtil.w(j8 + 3) & 255) << 24) | (UnsafeUtil.w(j8) & 255) | ((UnsafeUtil.w(1 + j8) & 255) << 8) | ((UnsafeUtil.w(2 + j8) & 255) << 16);
            }
            return (Q() & 255) | ((Q() & 255) << 8) | ((Q() & 255) << 16) | ((Q() & 255) << 24);
        }

        public long T() throws IOException {
            if (O() >= 8) {
                long j8 = this.f17216r;
                this.f17216r = 8 + j8;
                return ((UnsafeUtil.w(j8 + 7) & 255) << 56) | (UnsafeUtil.w(j8) & 255) | ((UnsafeUtil.w(1 + j8) & 255) << 8) | ((UnsafeUtil.w(2 + j8) & 255) << 16) | ((UnsafeUtil.w(3 + j8) & 255) << 24) | ((UnsafeUtil.w(4 + j8) & 255) << 32) | ((UnsafeUtil.w(5 + j8) & 255) << 40) | ((UnsafeUtil.w(6 + j8) & 255) << 48);
            }
            return (Q() & 255) | ((Q() & 255) << 8) | ((Q() & 255) << 16) | ((Q() & 255) << 24) | ((Q() & 255) << 32) | ((Q() & 255) << 40) | ((Q() & 255) << 48) | ((Q() & 255) << 56);
        }

        public long U() throws IOException {
            long w7;
            long j8;
            long j9;
            int i8;
            long j10 = this.f17216r;
            if (this.f17219u != j10) {
                long j11 = j10 + 1;
                byte w8 = UnsafeUtil.w(j10);
                if (w8 >= 0) {
                    this.f17216r++;
                    return w8;
                } else if (this.f17219u - this.f17216r >= 10) {
                    long j12 = j11 + 1;
                    int w9 = w8 ^ (UnsafeUtil.w(j11) << 7);
                    if (w9 < 0) {
                        i8 = w9 ^ (-128);
                    } else {
                        long j13 = j12 + 1;
                        int w10 = w9 ^ (UnsafeUtil.w(j12) << 14);
                        if (w10 >= 0) {
                            w7 = w10 ^ 16256;
                        } else {
                            j12 = j13 + 1;
                            int w11 = w10 ^ (UnsafeUtil.w(j13) << 21);
                            if (w11 < 0) {
                                i8 = w11 ^ (-2080896);
                            } else {
                                j13 = j12 + 1;
                                long w12 = w11 ^ (UnsafeUtil.w(j12) << 28);
                                if (w12 >= 0) {
                                    j9 = 266354560;
                                } else {
                                    long j14 = j13 + 1;
                                    long w13 = w12 ^ (UnsafeUtil.w(j13) << 35);
                                    if (w13 < 0) {
                                        j8 = -34093383808L;
                                    } else {
                                        j13 = j14 + 1;
                                        w12 = w13 ^ (UnsafeUtil.w(j14) << 42);
                                        if (w12 >= 0) {
                                            j9 = 4363953127296L;
                                        } else {
                                            j14 = j13 + 1;
                                            w13 = w12 ^ (UnsafeUtil.w(j13) << 49);
                                            if (w13 < 0) {
                                                j8 = -558586000294016L;
                                            } else {
                                                j13 = j14 + 1;
                                                w7 = (w13 ^ (UnsafeUtil.w(j14) << 56)) ^ 71499008037633920L;
                                                if (w7 < 0) {
                                                    long j15 = 1 + j13;
                                                    if (UnsafeUtil.w(j13) >= 0) {
                                                        j12 = j15;
                                                        this.f17216r = j12;
                                                        return w7;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    w7 = w13 ^ j8;
                                    j12 = j14;
                                    this.f17216r = j12;
                                    return w7;
                                }
                                w7 = w12 ^ j9;
                            }
                        }
                        j12 = j13;
                        this.f17216r = j12;
                        return w7;
                    }
                    w7 = i8;
                    this.f17216r = j12;
                    return w7;
                }
            }
            return V();
        }

        long V() throws IOException {
            long j8 = 0;
            for (int i8 = 0; i8 < 64; i8 += 7) {
                byte Q = Q();
                j8 |= (Q & Byte.MAX_VALUE) << i8;
                if ((Q & 128) == 0) {
                    return j8;
                }
            }
            throw InvalidProtocolBufferException.f();
        }

        public void Y() throws IOException {
            int K;
            do {
                K = K();
                if (K == 0) {
                    return;
                }
            } while (N(K));
        }

        public void Z(int i8) throws IOException {
            if (i8 >= 0 && i8 <= ((this.f17210l - this.f17214p) - this.f17216r) + this.f17217s) {
                while (i8 > 0) {
                    if (O() == 0) {
                        P();
                    }
                    int min = Math.min(i8, (int) O());
                    i8 -= min;
                    this.f17216r += min;
                }
            } else if (i8 < 0) {
                throw InvalidProtocolBufferException.g();
            } else {
                throw InvalidProtocolBufferException.m();
            }
        }

        @Override // com.google.protobuf.CodedInputStream
        public void a(int i8) throws InvalidProtocolBufferException {
            if (this.f17213o == i8) {
                return;
            }
            throw InvalidProtocolBufferException.b();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int e() {
            int i8 = this.f17212n;
            if (i8 == Integer.MAX_VALUE) {
                return -1;
            }
            return i8 - f();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int f() {
            return (int) (((this.f17214p - this.f17215q) + this.f17216r) - this.f17217s);
        }

        @Override // com.google.protobuf.CodedInputStream
        public boolean g() throws IOException {
            if ((this.f17214p + this.f17216r) - this.f17217s == this.f17210l) {
                return true;
            }
            return false;
        }

        @Override // com.google.protobuf.CodedInputStream
        public void p(int i8) {
            this.f17212n = i8;
            W();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int q(int i8) throws InvalidProtocolBufferException {
            if (i8 >= 0) {
                int f8 = i8 + f();
                int i9 = this.f17212n;
                if (f8 <= i9) {
                    this.f17212n = f8;
                    W();
                    return i9;
                }
                throw InvalidProtocolBufferException.m();
            }
            throw InvalidProtocolBufferException.g();
        }

        @Override // com.google.protobuf.CodedInputStream
        public boolean r() throws IOException {
            if (U() != 0) {
                return true;
            }
            return false;
        }

        @Override // com.google.protobuf.CodedInputStream
        public ByteString s() throws IOException {
            int C = C();
            if (C > 0) {
                long j8 = C;
                long j9 = this.f17219u;
                long j10 = this.f17216r;
                if (j8 <= j9 - j10) {
                    if (this.f17208j && this.f17209k) {
                        int i8 = (int) (j10 - this.f17218t);
                        ByteString N = ByteString.N(b0(i8, C + i8));
                        this.f17216r += j8;
                        return N;
                    }
                    byte[] bArr = new byte[C];
                    UnsafeUtil.p(j10, bArr, 0L, j8);
                    this.f17216r += j8;
                    return ByteString.O(bArr);
                }
            }
            if (C > 0 && C <= X()) {
                if (this.f17208j && this.f17209k) {
                    ArrayList arrayList = new ArrayList();
                    while (C > 0) {
                        if (O() == 0) {
                            P();
                        }
                        int min = Math.min(C, (int) O());
                        int i9 = (int) (this.f17216r - this.f17218t);
                        arrayList.add(ByteString.N(b0(i9, i9 + min)));
                        C -= min;
                        this.f17216r += min;
                    }
                    return ByteString.n(arrayList);
                }
                byte[] bArr2 = new byte[C];
                R(bArr2, 0, C);
                return ByteString.O(bArr2);
            } else if (C == 0) {
                return ByteString.f17177g;
            } else {
                if (C < 0) {
                    throw InvalidProtocolBufferException.g();
                }
                throw InvalidProtocolBufferException.m();
            }
        }

        @Override // com.google.protobuf.CodedInputStream
        public double t() throws IOException {
            return Double.longBitsToDouble(T());
        }

        @Override // com.google.protobuf.CodedInputStream
        public int u() throws IOException {
            return C();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int v() throws IOException {
            return S();
        }

        @Override // com.google.protobuf.CodedInputStream
        public long w() throws IOException {
            return T();
        }

        @Override // com.google.protobuf.CodedInputStream
        public float x() throws IOException {
            return Float.intBitsToFloat(S());
        }

        @Override // com.google.protobuf.CodedInputStream
        public void y(int i8, MessageLite.Builder builder, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            b();
            this.f17191a++;
            builder.y(this, extensionRegistryLite);
            a(WireFormat.c(i8, 4));
            this.f17191a--;
        }

        @Override // com.google.protobuf.CodedInputStream
        public int z() throws IOException {
            return C();
        }

        private IterableDirectByteBufferDecoder(Iterable<ByteBuffer> iterable, int i8, boolean z7) {
            super();
            this.f17212n = Api.BaseClientBuilder.API_PRIORITY_OTHER;
            this.f17210l = i8;
            this.f17205g = iterable;
            this.f17206h = iterable.iterator();
            this.f17208j = z7;
            this.f17214p = 0;
            this.f17215q = 0;
            if (i8 == 0) {
                this.f17207i = Internal.f17453e;
                this.f17216r = 0L;
                this.f17217s = 0L;
                this.f17219u = 0L;
                this.f17218t = 0L;
                return;
            }
            c0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static final class StreamDecoder extends CodedInputStream {

        /* renamed from: g  reason: collision with root package name */
        private final InputStream f17220g;

        /* renamed from: h  reason: collision with root package name */
        private final byte[] f17221h;

        /* renamed from: i  reason: collision with root package name */
        private int f17222i;

        /* renamed from: j  reason: collision with root package name */
        private int f17223j;

        /* renamed from: k  reason: collision with root package name */
        private int f17224k;

        /* renamed from: l  reason: collision with root package name */
        private int f17225l;

        /* renamed from: m  reason: collision with root package name */
        private int f17226m;

        /* renamed from: n  reason: collision with root package name */
        private int f17227n;

        /* renamed from: o  reason: collision with root package name */
        private RefillCallback f17228o;

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes3.dex */
        public interface RefillCallback {
            void a();
        }

        private static int O(InputStream inputStream) throws IOException {
            try {
                return inputStream.available();
            } catch (InvalidProtocolBufferException e8) {
                e8.j();
                throw e8;
            }
        }

        private static int P(InputStream inputStream, byte[] bArr, int i8, int i9) throws IOException {
            try {
                return inputStream.read(bArr, i8, i9);
            } catch (InvalidProtocolBufferException e8) {
                e8.j();
                throw e8;
            }
        }

        private ByteString Q(int i8) throws IOException {
            byte[] T = T(i8);
            if (T != null) {
                return ByteString.o(T);
            }
            int i9 = this.f17224k;
            int i10 = this.f17222i;
            int i11 = i10 - i9;
            this.f17226m += i10;
            this.f17224k = 0;
            this.f17222i = 0;
            List<byte[]> U = U(i8 - i11);
            byte[] bArr = new byte[i8];
            System.arraycopy(this.f17221h, i9, bArr, 0, i11);
            for (byte[] bArr2 : U) {
                System.arraycopy(bArr2, 0, bArr, i11, bArr2.length);
                i11 += bArr2.length;
            }
            return ByteString.O(bArr);
        }

        private byte[] S(int i8, boolean z7) throws IOException {
            byte[] T = T(i8);
            if (T != null) {
                if (z7) {
                    return (byte[]) T.clone();
                }
                return T;
            }
            int i9 = this.f17224k;
            int i10 = this.f17222i;
            int i11 = i10 - i9;
            this.f17226m += i10;
            this.f17224k = 0;
            this.f17222i = 0;
            List<byte[]> U = U(i8 - i11);
            byte[] bArr = new byte[i8];
            System.arraycopy(this.f17221h, i9, bArr, 0, i11);
            for (byte[] bArr2 : U) {
                System.arraycopy(bArr2, 0, bArr, i11, bArr2.length);
                i11 += bArr2.length;
            }
            return bArr;
        }

        private byte[] T(int i8) throws IOException {
            if (i8 == 0) {
                return Internal.f17452d;
            }
            if (i8 >= 0) {
                int i9 = this.f17226m;
                int i10 = this.f17224k;
                int i11 = i9 + i10 + i8;
                if (i11 - this.f17193c <= 0) {
                    int i12 = this.f17227n;
                    if (i11 <= i12) {
                        int i13 = this.f17222i - i10;
                        int i14 = i8 - i13;
                        if (i14 >= 4096 && i14 > O(this.f17220g)) {
                            return null;
                        }
                        byte[] bArr = new byte[i8];
                        System.arraycopy(this.f17221h, this.f17224k, bArr, 0, i13);
                        this.f17226m += this.f17222i;
                        this.f17224k = 0;
                        this.f17222i = 0;
                        while (i13 < i8) {
                            int P = P(this.f17220g, bArr, i13, i8 - i13);
                            if (P != -1) {
                                this.f17226m += P;
                                i13 += P;
                            } else {
                                throw InvalidProtocolBufferException.m();
                            }
                        }
                        return bArr;
                    }
                    d0((i12 - i9) - i10);
                    throw InvalidProtocolBufferException.m();
                }
                throw InvalidProtocolBufferException.l();
            }
            throw InvalidProtocolBufferException.g();
        }

        private List<byte[]> U(int i8) throws IOException {
            ArrayList arrayList = new ArrayList();
            while (i8 > 0) {
                int min = Math.min(i8, 4096);
                byte[] bArr = new byte[min];
                int i9 = 0;
                while (i9 < min) {
                    int read = this.f17220g.read(bArr, i9, min - i9);
                    if (read != -1) {
                        this.f17226m += read;
                        i9 += read;
                    } else {
                        throw InvalidProtocolBufferException.m();
                    }
                }
                i8 -= min;
                arrayList.add(bArr);
            }
            return arrayList;
        }

        private void Z() {
            int i8 = this.f17222i + this.f17223j;
            this.f17222i = i8;
            int i9 = this.f17226m + i8;
            int i10 = this.f17227n;
            if (i9 > i10) {
                int i11 = i9 - i10;
                this.f17223j = i11;
                this.f17222i = i8 - i11;
                return;
            }
            this.f17223j = 0;
        }

        private void a0(int i8) throws IOException {
            if (!i0(i8)) {
                if (i8 > (this.f17193c - this.f17226m) - this.f17224k) {
                    throw InvalidProtocolBufferException.l();
                }
                throw InvalidProtocolBufferException.m();
            }
        }

        private static long b0(InputStream inputStream, long j8) throws IOException {
            try {
                return inputStream.skip(j8);
            } catch (InvalidProtocolBufferException e8) {
                e8.j();
                throw e8;
            }
        }

        private void e0(int i8) throws IOException {
            if (i8 >= 0) {
                int i9 = this.f17226m;
                int i10 = this.f17224k;
                int i11 = i9 + i10 + i8;
                int i12 = this.f17227n;
                if (i11 <= i12) {
                    int i13 = 0;
                    if (this.f17228o == null) {
                        this.f17226m = i9 + i10;
                        this.f17222i = 0;
                        this.f17224k = 0;
                        i13 = this.f17222i - i10;
                        while (i13 < i8) {
                            try {
                                long j8 = i8 - i13;
                                long b02 = b0(this.f17220g, j8);
                                int i14 = (b02 > 0L ? 1 : (b02 == 0L ? 0 : -1));
                                if (i14 >= 0 && b02 <= j8) {
                                    if (i14 == 0) {
                                        break;
                                    }
                                    i13 += (int) b02;
                                } else {
                                    throw new IllegalStateException(this.f17220g.getClass() + "#skip returned invalid result: " + b02 + "\nThe InputStream implementation is buggy.");
                                }
                            } finally {
                                this.f17226m += i13;
                                Z();
                            }
                        }
                    }
                    if (i13 < i8) {
                        int i15 = this.f17222i;
                        int i16 = i15 - this.f17224k;
                        this.f17224k = i15;
                        a0(1);
                        while (true) {
                            int i17 = i8 - i16;
                            int i18 = this.f17222i;
                            if (i17 > i18) {
                                i16 += i18;
                                this.f17224k = i18;
                                a0(1);
                            } else {
                                this.f17224k = i17;
                                return;
                            }
                        }
                    }
                } else {
                    d0((i12 - i9) - i10);
                    throw InvalidProtocolBufferException.m();
                }
            } else {
                throw InvalidProtocolBufferException.g();
            }
        }

        private void f0() throws IOException {
            if (this.f17222i - this.f17224k >= 10) {
                g0();
            } else {
                h0();
            }
        }

        private void g0() throws IOException {
            for (int i8 = 0; i8 < 10; i8++) {
                byte[] bArr = this.f17221h;
                int i9 = this.f17224k;
                this.f17224k = i9 + 1;
                if (bArr[i9] >= 0) {
                    return;
                }
            }
            throw InvalidProtocolBufferException.f();
        }

        private void h0() throws IOException {
            for (int i8 = 0; i8 < 10; i8++) {
                if (R() >= 0) {
                    return;
                }
            }
            throw InvalidProtocolBufferException.f();
        }

        private boolean i0(int i8) throws IOException {
            int i9 = this.f17224k;
            if (i9 + i8 > this.f17222i) {
                int i10 = this.f17193c;
                int i11 = this.f17226m;
                if (i8 > (i10 - i11) - i9 || i11 + i9 + i8 > this.f17227n) {
                    return false;
                }
                RefillCallback refillCallback = this.f17228o;
                if (refillCallback != null) {
                    refillCallback.a();
                }
                int i12 = this.f17224k;
                if (i12 > 0) {
                    int i13 = this.f17222i;
                    if (i13 > i12) {
                        byte[] bArr = this.f17221h;
                        System.arraycopy(bArr, i12, bArr, 0, i13 - i12);
                    }
                    this.f17226m += i12;
                    this.f17222i -= i12;
                    this.f17224k = 0;
                }
                InputStream inputStream = this.f17220g;
                byte[] bArr2 = this.f17221h;
                int i14 = this.f17222i;
                int P = P(inputStream, bArr2, i14, Math.min(bArr2.length - i14, (this.f17193c - this.f17226m) - i14));
                if (P != 0 && P >= -1 && P <= this.f17221h.length) {
                    if (P <= 0) {
                        return false;
                    }
                    this.f17222i += P;
                    Z();
                    if (this.f17222i >= i8) {
                        return true;
                    }
                    return i0(i8);
                }
                throw new IllegalStateException(this.f17220g.getClass() + "#read(byte[]) returned invalid result: " + P + "\nThe InputStream implementation is buggy.");
            }
            throw new IllegalStateException("refillBuffer() called when " + i8 + " bytes were already available in buffer");
        }

        @Override // com.google.protobuf.CodedInputStream
        public long A() throws IOException {
            return X();
        }

        @Override // com.google.protobuf.CodedInputStream
        public void B(MessageLite.Builder builder, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            int C = C();
            b();
            int q8 = q(C);
            this.f17191a++;
            builder.y(this, extensionRegistryLite);
            a(0);
            this.f17191a--;
            if (e() == 0) {
                p(q8);
                return;
            }
            throw InvalidProtocolBufferException.m();
        }

        /* JADX WARN: Code restructure failed: missing block: B:33:0x0068, code lost:
            if (r2[r3] < 0) goto L34;
         */
        @Override // com.google.protobuf.CodedInputStream
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public int C() throws java.io.IOException {
            /*
                r5 = this;
                int r0 = r5.f17224k
                int r1 = r5.f17222i
                if (r1 != r0) goto L7
                goto L6a
            L7:
                byte[] r2 = r5.f17221h
                int r3 = r0 + 1
                r0 = r2[r0]
                if (r0 < 0) goto L12
                r5.f17224k = r3
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
                long r0 = r5.Y()
                int r1 = (int) r0
                return r1
            L70:
                r5.f17224k = r1
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.CodedInputStream.StreamDecoder.C():int");
        }

        @Override // com.google.protobuf.CodedInputStream
        public int E() throws IOException {
            return V();
        }

        @Override // com.google.protobuf.CodedInputStream
        public long F() throws IOException {
            return W();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int G() throws IOException {
            return CodedInputStream.c(C());
        }

        @Override // com.google.protobuf.CodedInputStream
        public long H() throws IOException {
            return CodedInputStream.d(X());
        }

        @Override // com.google.protobuf.CodedInputStream
        public String I() throws IOException {
            int C = C();
            if (C > 0) {
                int i8 = this.f17222i;
                int i9 = this.f17224k;
                if (C <= i8 - i9) {
                    String str = new String(this.f17221h, i9, C, Internal.f17450b);
                    this.f17224k += C;
                    return str;
                }
            }
            if (C == 0) {
                return "";
            }
            if (C <= this.f17222i) {
                a0(C);
                String str2 = new String(this.f17221h, this.f17224k, C, Internal.f17450b);
                this.f17224k += C;
                return str2;
            }
            return new String(S(C, false), Internal.f17450b);
        }

        @Override // com.google.protobuf.CodedInputStream
        public String J() throws IOException {
            byte[] S;
            int C = C();
            int i8 = this.f17224k;
            int i9 = this.f17222i;
            if (C <= i9 - i8 && C > 0) {
                S = this.f17221h;
                this.f17224k = i8 + C;
            } else if (C == 0) {
                return "";
            } else {
                if (C <= i9) {
                    a0(C);
                    S = this.f17221h;
                    this.f17224k = C + 0;
                } else {
                    S = S(C, false);
                }
                i8 = 0;
            }
            return Utf8.h(S, i8, C);
        }

        @Override // com.google.protobuf.CodedInputStream
        public int K() throws IOException {
            if (g()) {
                this.f17225l = 0;
                return 0;
            }
            int C = C();
            this.f17225l = C;
            if (WireFormat.a(C) != 0) {
                return this.f17225l;
            }
            throw InvalidProtocolBufferException.c();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int L() throws IOException {
            return C();
        }

        @Override // com.google.protobuf.CodedInputStream
        public long M() throws IOException {
            return X();
        }

        @Override // com.google.protobuf.CodedInputStream
        public boolean N(int i8) throws IOException {
            int b8 = WireFormat.b(i8);
            if (b8 != 0) {
                if (b8 != 1) {
                    if (b8 != 2) {
                        if (b8 != 3) {
                            if (b8 != 4) {
                                if (b8 == 5) {
                                    d0(4);
                                    return true;
                                }
                                throw InvalidProtocolBufferException.e();
                            }
                            return false;
                        }
                        c0();
                        a(WireFormat.c(WireFormat.a(i8), 4));
                        return true;
                    }
                    d0(C());
                    return true;
                }
                d0(8);
                return true;
            }
            f0();
            return true;
        }

        public byte R() throws IOException {
            if (this.f17224k == this.f17222i) {
                a0(1);
            }
            byte[] bArr = this.f17221h;
            int i8 = this.f17224k;
            this.f17224k = i8 + 1;
            return bArr[i8];
        }

        public int V() throws IOException {
            int i8 = this.f17224k;
            if (this.f17222i - i8 < 4) {
                a0(4);
                i8 = this.f17224k;
            }
            byte[] bArr = this.f17221h;
            this.f17224k = i8 + 4;
            return ((bArr[i8 + 3] & 255) << 24) | (bArr[i8] & 255) | ((bArr[i8 + 1] & 255) << 8) | ((bArr[i8 + 2] & 255) << 16);
        }

        public long W() throws IOException {
            int i8 = this.f17224k;
            if (this.f17222i - i8 < 8) {
                a0(8);
                i8 = this.f17224k;
            }
            byte[] bArr = this.f17221h;
            this.f17224k = i8 + 8;
            return ((bArr[i8 + 7] & 255) << 56) | (bArr[i8] & 255) | ((bArr[i8 + 1] & 255) << 8) | ((bArr[i8 + 2] & 255) << 16) | ((bArr[i8 + 3] & 255) << 24) | ((bArr[i8 + 4] & 255) << 32) | ((bArr[i8 + 5] & 255) << 40) | ((bArr[i8 + 6] & 255) << 48);
        }

        /* JADX WARN: Code restructure failed: missing block: B:39:0x00b4, code lost:
            if (r2[r0] < 0) goto L42;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public long X() throws java.io.IOException {
            /*
                Method dump skipped, instructions count: 192
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.CodedInputStream.StreamDecoder.X():long");
        }

        long Y() throws IOException {
            long j8 = 0;
            for (int i8 = 0; i8 < 64; i8 += 7) {
                byte R = R();
                j8 |= (R & Byte.MAX_VALUE) << i8;
                if ((R & 128) == 0) {
                    return j8;
                }
            }
            throw InvalidProtocolBufferException.f();
        }

        @Override // com.google.protobuf.CodedInputStream
        public void a(int i8) throws InvalidProtocolBufferException {
            if (this.f17225l == i8) {
                return;
            }
            throw InvalidProtocolBufferException.b();
        }

        public void c0() throws IOException {
            int K;
            do {
                K = K();
                if (K == 0) {
                    return;
                }
            } while (N(K));
        }

        public void d0(int i8) throws IOException {
            int i9 = this.f17222i;
            int i10 = this.f17224k;
            if (i8 <= i9 - i10 && i8 >= 0) {
                this.f17224k = i10 + i8;
            } else {
                e0(i8);
            }
        }

        @Override // com.google.protobuf.CodedInputStream
        public int e() {
            int i8 = this.f17227n;
            if (i8 == Integer.MAX_VALUE) {
                return -1;
            }
            return i8 - (this.f17226m + this.f17224k);
        }

        @Override // com.google.protobuf.CodedInputStream
        public int f() {
            return this.f17226m + this.f17224k;
        }

        @Override // com.google.protobuf.CodedInputStream
        public boolean g() throws IOException {
            if (this.f17224k == this.f17222i && !i0(1)) {
                return true;
            }
            return false;
        }

        @Override // com.google.protobuf.CodedInputStream
        public void p(int i8) {
            this.f17227n = i8;
            Z();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int q(int i8) throws InvalidProtocolBufferException {
            if (i8 >= 0) {
                int i9 = i8 + this.f17226m + this.f17224k;
                int i10 = this.f17227n;
                if (i9 <= i10) {
                    this.f17227n = i9;
                    Z();
                    return i10;
                }
                throw InvalidProtocolBufferException.m();
            }
            throw InvalidProtocolBufferException.g();
        }

        @Override // com.google.protobuf.CodedInputStream
        public boolean r() throws IOException {
            if (X() != 0) {
                return true;
            }
            return false;
        }

        @Override // com.google.protobuf.CodedInputStream
        public ByteString s() throws IOException {
            int C = C();
            int i8 = this.f17222i;
            int i9 = this.f17224k;
            if (C <= i8 - i9 && C > 0) {
                ByteString p8 = ByteString.p(this.f17221h, i9, C);
                this.f17224k += C;
                return p8;
            } else if (C == 0) {
                return ByteString.f17177g;
            } else {
                return Q(C);
            }
        }

        @Override // com.google.protobuf.CodedInputStream
        public double t() throws IOException {
            return Double.longBitsToDouble(W());
        }

        @Override // com.google.protobuf.CodedInputStream
        public int u() throws IOException {
            return C();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int v() throws IOException {
            return V();
        }

        @Override // com.google.protobuf.CodedInputStream
        public long w() throws IOException {
            return W();
        }

        @Override // com.google.protobuf.CodedInputStream
        public float x() throws IOException {
            return Float.intBitsToFloat(V());
        }

        @Override // com.google.protobuf.CodedInputStream
        public void y(int i8, MessageLite.Builder builder, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            b();
            this.f17191a++;
            builder.y(this, extensionRegistryLite);
            a(WireFormat.c(i8, 4));
            this.f17191a--;
        }

        @Override // com.google.protobuf.CodedInputStream
        public int z() throws IOException {
            return C();
        }

        private StreamDecoder(InputStream inputStream, int i8) {
            super();
            this.f17227n = Api.BaseClientBuilder.API_PRIORITY_OTHER;
            this.f17228o = null;
            Internal.b(inputStream, "input");
            this.f17220g = inputStream;
            this.f17221h = new byte[i8];
            this.f17222i = 0;
            this.f17224k = 0;
            this.f17226m = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static final class UnsafeDirectNioDecoder extends CodedInputStream {

        /* renamed from: g  reason: collision with root package name */
        private final ByteBuffer f17229g;

        /* renamed from: h  reason: collision with root package name */
        private final boolean f17230h;

        /* renamed from: i  reason: collision with root package name */
        private final long f17231i;

        /* renamed from: j  reason: collision with root package name */
        private long f17232j;

        /* renamed from: k  reason: collision with root package name */
        private long f17233k;

        /* renamed from: l  reason: collision with root package name */
        private long f17234l;

        /* renamed from: m  reason: collision with root package name */
        private int f17235m;

        /* renamed from: n  reason: collision with root package name */
        private int f17236n;

        /* renamed from: o  reason: collision with root package name */
        private boolean f17237o;

        /* renamed from: p  reason: collision with root package name */
        private int f17238p;

        private int O(long j8) {
            return (int) (j8 - this.f17231i);
        }

        static boolean P() {
            return UnsafeUtil.J();
        }

        private void V() {
            long j8 = this.f17232j + this.f17235m;
            this.f17232j = j8;
            int i8 = (int) (j8 - this.f17234l);
            int i9 = this.f17238p;
            if (i8 > i9) {
                int i10 = i8 - i9;
                this.f17235m = i10;
                this.f17232j = j8 - i10;
                return;
            }
            this.f17235m = 0;
        }

        private int W() {
            return (int) (this.f17232j - this.f17233k);
        }

        private void Z() throws IOException {
            if (W() >= 10) {
                a0();
            } else {
                b0();
            }
        }

        private void a0() throws IOException {
            for (int i8 = 0; i8 < 10; i8++) {
                long j8 = this.f17233k;
                this.f17233k = 1 + j8;
                if (UnsafeUtil.w(j8) >= 0) {
                    return;
                }
            }
            throw InvalidProtocolBufferException.f();
        }

        private void b0() throws IOException {
            for (int i8 = 0; i8 < 10; i8++) {
                if (Q() >= 0) {
                    return;
                }
            }
            throw InvalidProtocolBufferException.f();
        }

        private ByteBuffer c0(long j8, long j9) throws IOException {
            int position = this.f17229g.position();
            int limit = this.f17229g.limit();
            ByteBuffer byteBuffer = this.f17229g;
            try {
                try {
                    byteBuffer.position(O(j8));
                    byteBuffer.limit(O(j9));
                    return this.f17229g.slice();
                } catch (IllegalArgumentException e8) {
                    InvalidProtocolBufferException m8 = InvalidProtocolBufferException.m();
                    m8.initCause(e8);
                    throw m8;
                }
            } finally {
                byteBuffer.position(position);
                byteBuffer.limit(limit);
            }
        }

        @Override // com.google.protobuf.CodedInputStream
        public long A() throws IOException {
            return T();
        }

        @Override // com.google.protobuf.CodedInputStream
        public void B(MessageLite.Builder builder, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            int C = C();
            b();
            int q8 = q(C);
            this.f17191a++;
            builder.y(this, extensionRegistryLite);
            a(0);
            this.f17191a--;
            if (e() == 0) {
                p(q8);
                return;
            }
            throw InvalidProtocolBufferException.m();
        }

        /* JADX WARN: Code restructure failed: missing block: B:33:0x0083, code lost:
            if (com.google.protobuf.UnsafeUtil.w(r4) < 0) goto L34;
         */
        @Override // com.google.protobuf.CodedInputStream
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public int C() throws java.io.IOException {
            /*
                r10 = this;
                long r0 = r10.f17233k
                long r2 = r10.f17232j
                int r4 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
                if (r4 != 0) goto La
                goto L85
            La:
                r2 = 1
                long r4 = r0 + r2
                byte r0 = com.google.protobuf.UnsafeUtil.w(r0)
                if (r0 < 0) goto L17
                r10.f17233k = r4
                return r0
            L17:
                long r6 = r10.f17232j
                long r6 = r6 - r4
                r8 = 9
                int r1 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
                if (r1 >= 0) goto L21
                goto L85
            L21:
                long r6 = r4 + r2
                byte r1 = com.google.protobuf.UnsafeUtil.w(r4)
                int r1 = r1 << 7
                r0 = r0 ^ r1
                if (r0 >= 0) goto L2f
                r0 = r0 ^ (-128(0xffffffffffffff80, float:NaN))
                goto L8b
            L2f:
                long r4 = r6 + r2
                byte r1 = com.google.protobuf.UnsafeUtil.w(r6)
                int r1 = r1 << 14
                r0 = r0 ^ r1
                if (r0 < 0) goto L3e
                r0 = r0 ^ 16256(0x3f80, float:2.278E-41)
            L3c:
                r6 = r4
                goto L8b
            L3e:
                long r6 = r4 + r2
                byte r1 = com.google.protobuf.UnsafeUtil.w(r4)
                int r1 = r1 << 21
                r0 = r0 ^ r1
                if (r0 >= 0) goto L4e
                r1 = -2080896(0xffffffffffe03f80, float:NaN)
                r0 = r0 ^ r1
                goto L8b
            L4e:
                long r4 = r6 + r2
                byte r1 = com.google.protobuf.UnsafeUtil.w(r6)
                int r6 = r1 << 28
                r0 = r0 ^ r6
                r6 = 266354560(0xfe03f80, float:2.2112565E-29)
                r0 = r0 ^ r6
                if (r1 >= 0) goto L3c
                long r6 = r4 + r2
                byte r1 = com.google.protobuf.UnsafeUtil.w(r4)
                if (r1 >= 0) goto L8b
                long r4 = r6 + r2
                byte r1 = com.google.protobuf.UnsafeUtil.w(r6)
                if (r1 >= 0) goto L3c
                long r6 = r4 + r2
                byte r1 = com.google.protobuf.UnsafeUtil.w(r4)
                if (r1 >= 0) goto L8b
                long r4 = r6 + r2
                byte r1 = com.google.protobuf.UnsafeUtil.w(r6)
                if (r1 >= 0) goto L3c
                long r6 = r4 + r2
                byte r1 = com.google.protobuf.UnsafeUtil.w(r4)
                if (r1 >= 0) goto L8b
            L85:
                long r0 = r10.U()
                int r1 = (int) r0
                return r1
            L8b:
                r10.f17233k = r6
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.CodedInputStream.UnsafeDirectNioDecoder.C():int");
        }

        @Override // com.google.protobuf.CodedInputStream
        public int E() throws IOException {
            return R();
        }

        @Override // com.google.protobuf.CodedInputStream
        public long F() throws IOException {
            return S();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int G() throws IOException {
            return CodedInputStream.c(C());
        }

        @Override // com.google.protobuf.CodedInputStream
        public long H() throws IOException {
            return CodedInputStream.d(T());
        }

        @Override // com.google.protobuf.CodedInputStream
        public String I() throws IOException {
            int C = C();
            if (C > 0 && C <= W()) {
                byte[] bArr = new byte[C];
                long j8 = C;
                UnsafeUtil.p(this.f17233k, bArr, 0L, j8);
                String str = new String(bArr, Internal.f17450b);
                this.f17233k += j8;
                return str;
            } else if (C == 0) {
                return "";
            } else {
                if (C < 0) {
                    throw InvalidProtocolBufferException.g();
                }
                throw InvalidProtocolBufferException.m();
            }
        }

        @Override // com.google.protobuf.CodedInputStream
        public String J() throws IOException {
            int C = C();
            if (C > 0 && C <= W()) {
                String g8 = Utf8.g(this.f17229g, O(this.f17233k), C);
                this.f17233k += C;
                return g8;
            } else if (C == 0) {
                return "";
            } else {
                if (C <= 0) {
                    throw InvalidProtocolBufferException.g();
                }
                throw InvalidProtocolBufferException.m();
            }
        }

        @Override // com.google.protobuf.CodedInputStream
        public int K() throws IOException {
            if (g()) {
                this.f17236n = 0;
                return 0;
            }
            int C = C();
            this.f17236n = C;
            if (WireFormat.a(C) != 0) {
                return this.f17236n;
            }
            throw InvalidProtocolBufferException.c();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int L() throws IOException {
            return C();
        }

        @Override // com.google.protobuf.CodedInputStream
        public long M() throws IOException {
            return T();
        }

        @Override // com.google.protobuf.CodedInputStream
        public boolean N(int i8) throws IOException {
            int b8 = WireFormat.b(i8);
            if (b8 != 0) {
                if (b8 != 1) {
                    if (b8 != 2) {
                        if (b8 != 3) {
                            if (b8 != 4) {
                                if (b8 == 5) {
                                    Y(4);
                                    return true;
                                }
                                throw InvalidProtocolBufferException.e();
                            }
                            return false;
                        }
                        X();
                        a(WireFormat.c(WireFormat.a(i8), 4));
                        return true;
                    }
                    Y(C());
                    return true;
                }
                Y(8);
                return true;
            }
            Z();
            return true;
        }

        public byte Q() throws IOException {
            long j8 = this.f17233k;
            if (j8 != this.f17232j) {
                this.f17233k = 1 + j8;
                return UnsafeUtil.w(j8);
            }
            throw InvalidProtocolBufferException.m();
        }

        public int R() throws IOException {
            long j8 = this.f17233k;
            if (this.f17232j - j8 >= 4) {
                this.f17233k = 4 + j8;
                return ((UnsafeUtil.w(j8 + 3) & 255) << 24) | (UnsafeUtil.w(j8) & 255) | ((UnsafeUtil.w(1 + j8) & 255) << 8) | ((UnsafeUtil.w(2 + j8) & 255) << 16);
            }
            throw InvalidProtocolBufferException.m();
        }

        public long S() throws IOException {
            long j8 = this.f17233k;
            if (this.f17232j - j8 >= 8) {
                this.f17233k = 8 + j8;
                return ((UnsafeUtil.w(j8 + 7) & 255) << 56) | (UnsafeUtil.w(j8) & 255) | ((UnsafeUtil.w(1 + j8) & 255) << 8) | ((UnsafeUtil.w(2 + j8) & 255) << 16) | ((UnsafeUtil.w(3 + j8) & 255) << 24) | ((UnsafeUtil.w(4 + j8) & 255) << 32) | ((UnsafeUtil.w(5 + j8) & 255) << 40) | ((UnsafeUtil.w(6 + j8) & 255) << 48);
            }
            throw InvalidProtocolBufferException.m();
        }

        public long T() throws IOException {
            long w7;
            long j8;
            long j9;
            int i8;
            long j10 = this.f17233k;
            if (this.f17232j != j10) {
                long j11 = j10 + 1;
                byte w8 = UnsafeUtil.w(j10);
                if (w8 >= 0) {
                    this.f17233k = j11;
                    return w8;
                } else if (this.f17232j - j11 >= 9) {
                    long j12 = j11 + 1;
                    int w9 = w8 ^ (UnsafeUtil.w(j11) << 7);
                    if (w9 < 0) {
                        i8 = w9 ^ (-128);
                    } else {
                        long j13 = j12 + 1;
                        int w10 = w9 ^ (UnsafeUtil.w(j12) << 14);
                        if (w10 >= 0) {
                            w7 = w10 ^ 16256;
                        } else {
                            j12 = j13 + 1;
                            int w11 = w10 ^ (UnsafeUtil.w(j13) << 21);
                            if (w11 < 0) {
                                i8 = w11 ^ (-2080896);
                            } else {
                                j13 = j12 + 1;
                                long w12 = w11 ^ (UnsafeUtil.w(j12) << 28);
                                if (w12 >= 0) {
                                    j9 = 266354560;
                                } else {
                                    long j14 = j13 + 1;
                                    long w13 = w12 ^ (UnsafeUtil.w(j13) << 35);
                                    if (w13 < 0) {
                                        j8 = -34093383808L;
                                    } else {
                                        j13 = j14 + 1;
                                        w12 = w13 ^ (UnsafeUtil.w(j14) << 42);
                                        if (w12 >= 0) {
                                            j9 = 4363953127296L;
                                        } else {
                                            j14 = j13 + 1;
                                            w13 = w12 ^ (UnsafeUtil.w(j13) << 49);
                                            if (w13 < 0) {
                                                j8 = -558586000294016L;
                                            } else {
                                                j13 = j14 + 1;
                                                w7 = (w13 ^ (UnsafeUtil.w(j14) << 56)) ^ 71499008037633920L;
                                                if (w7 < 0) {
                                                    long j15 = 1 + j13;
                                                    if (UnsafeUtil.w(j13) >= 0) {
                                                        j12 = j15;
                                                        this.f17233k = j12;
                                                        return w7;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    w7 = w13 ^ j8;
                                    j12 = j14;
                                    this.f17233k = j12;
                                    return w7;
                                }
                                w7 = w12 ^ j9;
                            }
                        }
                        j12 = j13;
                        this.f17233k = j12;
                        return w7;
                    }
                    w7 = i8;
                    this.f17233k = j12;
                    return w7;
                }
            }
            return U();
        }

        long U() throws IOException {
            long j8 = 0;
            for (int i8 = 0; i8 < 64; i8 += 7) {
                byte Q = Q();
                j8 |= (Q & Byte.MAX_VALUE) << i8;
                if ((Q & 128) == 0) {
                    return j8;
                }
            }
            throw InvalidProtocolBufferException.f();
        }

        public void X() throws IOException {
            int K;
            do {
                K = K();
                if (K == 0) {
                    return;
                }
            } while (N(K));
        }

        public void Y(int i8) throws IOException {
            if (i8 >= 0 && i8 <= W()) {
                this.f17233k += i8;
            } else if (i8 < 0) {
                throw InvalidProtocolBufferException.g();
            } else {
                throw InvalidProtocolBufferException.m();
            }
        }

        @Override // com.google.protobuf.CodedInputStream
        public void a(int i8) throws InvalidProtocolBufferException {
            if (this.f17236n == i8) {
                return;
            }
            throw InvalidProtocolBufferException.b();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int e() {
            int i8 = this.f17238p;
            if (i8 == Integer.MAX_VALUE) {
                return -1;
            }
            return i8 - f();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int f() {
            return (int) (this.f17233k - this.f17234l);
        }

        @Override // com.google.protobuf.CodedInputStream
        public boolean g() throws IOException {
            if (this.f17233k == this.f17232j) {
                return true;
            }
            return false;
        }

        @Override // com.google.protobuf.CodedInputStream
        public void p(int i8) {
            this.f17238p = i8;
            V();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int q(int i8) throws InvalidProtocolBufferException {
            if (i8 >= 0) {
                int f8 = i8 + f();
                int i9 = this.f17238p;
                if (f8 <= i9) {
                    this.f17238p = f8;
                    V();
                    return i9;
                }
                throw InvalidProtocolBufferException.m();
            }
            throw InvalidProtocolBufferException.g();
        }

        @Override // com.google.protobuf.CodedInputStream
        public boolean r() throws IOException {
            if (T() != 0) {
                return true;
            }
            return false;
        }

        @Override // com.google.protobuf.CodedInputStream
        public ByteString s() throws IOException {
            int C = C();
            if (C > 0 && C <= W()) {
                if (this.f17230h && this.f17237o) {
                    long j8 = this.f17233k;
                    long j9 = C;
                    ByteBuffer c02 = c0(j8, j8 + j9);
                    this.f17233k += j9;
                    return ByteString.N(c02);
                }
                byte[] bArr = new byte[C];
                long j10 = C;
                UnsafeUtil.p(this.f17233k, bArr, 0L, j10);
                this.f17233k += j10;
                return ByteString.O(bArr);
            } else if (C == 0) {
                return ByteString.f17177g;
            } else {
                if (C < 0) {
                    throw InvalidProtocolBufferException.g();
                }
                throw InvalidProtocolBufferException.m();
            }
        }

        @Override // com.google.protobuf.CodedInputStream
        public double t() throws IOException {
            return Double.longBitsToDouble(S());
        }

        @Override // com.google.protobuf.CodedInputStream
        public int u() throws IOException {
            return C();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int v() throws IOException {
            return R();
        }

        @Override // com.google.protobuf.CodedInputStream
        public long w() throws IOException {
            return S();
        }

        @Override // com.google.protobuf.CodedInputStream
        public float x() throws IOException {
            return Float.intBitsToFloat(R());
        }

        @Override // com.google.protobuf.CodedInputStream
        public void y(int i8, MessageLite.Builder builder, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            b();
            this.f17191a++;
            builder.y(this, extensionRegistryLite);
            a(WireFormat.c(i8, 4));
            this.f17191a--;
        }

        @Override // com.google.protobuf.CodedInputStream
        public int z() throws IOException {
            return C();
        }

        private UnsafeDirectNioDecoder(ByteBuffer byteBuffer, boolean z7) {
            super();
            this.f17238p = Api.BaseClientBuilder.API_PRIORITY_OTHER;
            this.f17229g = byteBuffer;
            long k8 = UnsafeUtil.k(byteBuffer);
            this.f17231i = k8;
            this.f17232j = byteBuffer.limit() + k8;
            long position = k8 + byteBuffer.position();
            this.f17233k = position;
            this.f17234l = position;
            this.f17230h = z7;
        }
    }

    public static int D(int i8, InputStream inputStream) throws IOException {
        if ((i8 & 128) == 0) {
            return i8;
        }
        int i9 = i8 & 127;
        int i10 = 7;
        while (i10 < 32) {
            int read = inputStream.read();
            if (read != -1) {
                i9 |= (read & 127) << i10;
                if ((read & 128) == 0) {
                    return i9;
                }
                i10 += 7;
            } else {
                throw InvalidProtocolBufferException.m();
            }
        }
        while (i10 < 64) {
            int read2 = inputStream.read();
            if (read2 != -1) {
                if ((read2 & 128) == 0) {
                    return i9;
                }
                i10 += 7;
            } else {
                throw InvalidProtocolBufferException.m();
            }
        }
        throw InvalidProtocolBufferException.f();
    }

    public static int c(int i8) {
        return (-(i8 & 1)) ^ (i8 >>> 1);
    }

    public static long d(long j8) {
        return (-(j8 & 1)) ^ (j8 >>> 1);
    }

    public static CodedInputStream h(InputStream inputStream) {
        return i(inputStream, 4096);
    }

    public static CodedInputStream i(InputStream inputStream, int i8) {
        if (i8 > 0) {
            if (inputStream == null) {
                return m(Internal.f17452d);
            }
            return new StreamDecoder(inputStream, i8);
        }
        throw new IllegalArgumentException("bufferSize must be > 0");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static CodedInputStream j(Iterable<ByteBuffer> iterable, boolean z7) {
        boolean z8 = false;
        int i8 = 0;
        for (ByteBuffer byteBuffer : iterable) {
            i8 += byteBuffer.remaining();
            if (byteBuffer.hasArray()) {
                z8 |= true;
            } else if (byteBuffer.isDirect()) {
                z8 |= true;
            } else {
                z8 |= true;
            }
        }
        if (z8) {
            return new IterableDirectByteBufferDecoder(iterable, i8, z7);
        }
        return h(new IterableByteBufferInputStream(iterable));
    }

    public static CodedInputStream k(ByteBuffer byteBuffer) {
        return l(byteBuffer, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static CodedInputStream l(ByteBuffer byteBuffer, boolean z7) {
        if (byteBuffer.hasArray()) {
            return o(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining(), z7);
        }
        if (byteBuffer.isDirect() && UnsafeDirectNioDecoder.P()) {
            return new UnsafeDirectNioDecoder(byteBuffer, z7);
        }
        int remaining = byteBuffer.remaining();
        byte[] bArr = new byte[remaining];
        byteBuffer.duplicate().get(bArr);
        return o(bArr, 0, remaining, true);
    }

    public static CodedInputStream m(byte[] bArr) {
        return n(bArr, 0, bArr.length);
    }

    public static CodedInputStream n(byte[] bArr, int i8, int i9) {
        return o(bArr, i8, i9, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static CodedInputStream o(byte[] bArr, int i8, int i9, boolean z7) {
        ArrayDecoder arrayDecoder = new ArrayDecoder(bArr, i8, i9, z7);
        try {
            arrayDecoder.q(i9);
            return arrayDecoder;
        } catch (InvalidProtocolBufferException e8) {
            throw new IllegalArgumentException(e8);
        }
    }

    public abstract long A() throws IOException;

    public abstract void B(MessageLite.Builder builder, ExtensionRegistryLite extensionRegistryLite) throws IOException;

    public abstract int C() throws IOException;

    public abstract int E() throws IOException;

    public abstract long F() throws IOException;

    public abstract int G() throws IOException;

    public abstract long H() throws IOException;

    public abstract String I() throws IOException;

    public abstract String J() throws IOException;

    public abstract int K() throws IOException;

    public abstract int L() throws IOException;

    public abstract long M() throws IOException;

    public abstract boolean N(int i8) throws IOException;

    public abstract void a(int i8) throws InvalidProtocolBufferException;

    public void b() throws InvalidProtocolBufferException {
        if (this.f17191a < this.f17192b) {
            return;
        }
        throw InvalidProtocolBufferException.i();
    }

    public abstract int e();

    public abstract int f();

    public abstract boolean g() throws IOException;

    public abstract void p(int i8);

    public abstract int q(int i8) throws InvalidProtocolBufferException;

    public abstract boolean r() throws IOException;

    public abstract ByteString s() throws IOException;

    public abstract double t() throws IOException;

    public abstract int u() throws IOException;

    public abstract int v() throws IOException;

    public abstract long w() throws IOException;

    public abstract float x() throws IOException;

    public abstract void y(int i8, MessageLite.Builder builder, ExtensionRegistryLite extensionRegistryLite) throws IOException;

    public abstract int z() throws IOException;

    private CodedInputStream() {
        this.f17192b = f17190f;
        this.f17193c = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        this.f17195e = false;
    }
}
