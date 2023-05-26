package com.google.crypto.tink.shaded.protobuf;

import com.google.android.gms.common.api.Api;
import com.google.crypto.tink.shaded.protobuf.MapEntryLite;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
abstract class BinaryReader implements Reader {

    /* loaded from: classes.dex */
    private static final class SafeHeapReader extends BinaryReader {

        /* renamed from: a  reason: collision with root package name */
        private final boolean f14979a;

        /* renamed from: b  reason: collision with root package name */
        private final byte[] f14980b;

        /* renamed from: c  reason: collision with root package name */
        private int f14981c;

        /* renamed from: d  reason: collision with root package name */
        private final int f14982d;

        /* renamed from: e  reason: collision with root package name */
        private int f14983e;

        /* renamed from: f  reason: collision with root package name */
        private int f14984f;

        /* renamed from: g  reason: collision with root package name */
        private int f14985g;

        public SafeHeapReader(ByteBuffer byteBuffer, boolean z7) {
            super();
            this.f14979a = z7;
            this.f14980b = byteBuffer.array();
            int arrayOffset = byteBuffer.arrayOffset() + byteBuffer.position();
            this.f14981c = arrayOffset;
            this.f14982d = arrayOffset;
            this.f14983e = byteBuffer.arrayOffset() + byteBuffer.limit();
        }

        private boolean R() {
            if (this.f14981c == this.f14983e) {
                return true;
            }
            return false;
        }

        private byte S() throws IOException {
            int i8 = this.f14981c;
            if (i8 != this.f14983e) {
                byte[] bArr = this.f14980b;
                this.f14981c = i8 + 1;
                return bArr[i8];
            }
            throw InvalidProtocolBufferException.j();
        }

        private <T> T T(Schema<T> schema, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            int i8 = this.f14985g;
            this.f14985g = WireFormat.c(WireFormat.a(this.f14984f), 4);
            try {
                T e8 = schema.e();
                schema.g(e8, this, extensionRegistryLite);
                schema.b(e8);
                if (this.f14984f == this.f14985g) {
                    return e8;
                }
                throw InvalidProtocolBufferException.g();
            } finally {
                this.f14985g = i8;
            }
        }

        private int U() throws IOException {
            e0(4);
            return V();
        }

        private int V() {
            int i8 = this.f14981c;
            byte[] bArr = this.f14980b;
            this.f14981c = i8 + 4;
            return ((bArr[i8 + 3] & 255) << 24) | (bArr[i8] & 255) | ((bArr[i8 + 1] & 255) << 8) | ((bArr[i8 + 2] & 255) << 16);
        }

        private long W() throws IOException {
            e0(8);
            return X();
        }

        private long X() {
            int i8 = this.f14981c;
            byte[] bArr = this.f14980b;
            this.f14981c = i8 + 8;
            return ((bArr[i8 + 7] & 255) << 56) | (bArr[i8] & 255) | ((bArr[i8 + 1] & 255) << 8) | ((bArr[i8 + 2] & 255) << 16) | ((bArr[i8 + 3] & 255) << 24) | ((bArr[i8 + 4] & 255) << 32) | ((bArr[i8 + 5] & 255) << 40) | ((bArr[i8 + 6] & 255) << 48);
        }

        private <T> T Y(Schema<T> schema, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            int b02 = b0();
            e0(b02);
            int i8 = this.f14983e;
            int i9 = this.f14981c + b02;
            this.f14983e = i9;
            try {
                T e8 = schema.e();
                schema.g(e8, this, extensionRegistryLite);
                schema.b(e8);
                if (this.f14981c == i9) {
                    return e8;
                }
                throw InvalidProtocolBufferException.g();
            } finally {
                this.f14983e = i8;
            }
        }

        private int b0() throws IOException {
            int i8;
            int i9 = this.f14981c;
            int i10 = this.f14983e;
            if (i10 != i9) {
                byte[] bArr = this.f14980b;
                int i11 = i9 + 1;
                byte b8 = bArr[i9];
                if (b8 >= 0) {
                    this.f14981c = i11;
                    return b8;
                } else if (i10 - i11 < 9) {
                    return (int) d0();
                } else {
                    int i12 = i11 + 1;
                    int i13 = b8 ^ (bArr[i11] << 7);
                    if (i13 < 0) {
                        i8 = i13 ^ (-128);
                    } else {
                        int i14 = i12 + 1;
                        int i15 = i13 ^ (bArr[i12] << 14);
                        if (i15 >= 0) {
                            i8 = i15 ^ 16256;
                        } else {
                            i12 = i14 + 1;
                            int i16 = i15 ^ (bArr[i14] << 21);
                            if (i16 < 0) {
                                i8 = i16 ^ (-2080896);
                            } else {
                                i14 = i12 + 1;
                                byte b9 = bArr[i12];
                                i8 = (i16 ^ (b9 << 28)) ^ 266354560;
                                if (b9 < 0) {
                                    i12 = i14 + 1;
                                    if (bArr[i14] < 0) {
                                        i14 = i12 + 1;
                                        if (bArr[i12] < 0) {
                                            i12 = i14 + 1;
                                            if (bArr[i14] < 0) {
                                                i14 = i12 + 1;
                                                if (bArr[i12] < 0) {
                                                    i12 = i14 + 1;
                                                    if (bArr[i14] < 0) {
                                                        throw InvalidProtocolBufferException.e();
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        i12 = i14;
                    }
                    this.f14981c = i12;
                    return i8;
                }
            }
            throw InvalidProtocolBufferException.j();
        }

        private long d0() throws IOException {
            long j8 = 0;
            for (int i8 = 0; i8 < 64; i8 += 7) {
                byte S = S();
                j8 |= (S & Byte.MAX_VALUE) << i8;
                if ((S & 128) == 0) {
                    return j8;
                }
            }
            throw InvalidProtocolBufferException.e();
        }

        private void e0(int i8) throws IOException {
            if (i8 >= 0 && i8 <= this.f14983e - this.f14981c) {
                return;
            }
            throw InvalidProtocolBufferException.j();
        }

        private void f0(int i8) throws IOException {
            if (this.f14981c == i8) {
                return;
            }
            throw InvalidProtocolBufferException.j();
        }

        private void g0(int i8) throws IOException {
            if (WireFormat.b(this.f14984f) == i8) {
                return;
            }
            throw InvalidProtocolBufferException.d();
        }

        private void h0(int i8) throws IOException {
            e0(i8);
            this.f14981c += i8;
        }

        private void i0() throws IOException {
            int i8 = this.f14985g;
            this.f14985g = WireFormat.c(WireFormat.a(this.f14984f), 4);
            while (A() != Integer.MAX_VALUE && D()) {
            }
            if (this.f14984f == this.f14985g) {
                this.f14985g = i8;
                return;
            }
            throw InvalidProtocolBufferException.g();
        }

        private void j0() throws IOException {
            int i8 = this.f14983e;
            int i9 = this.f14981c;
            if (i8 - i9 >= 10) {
                byte[] bArr = this.f14980b;
                int i10 = 0;
                while (i10 < 10) {
                    int i11 = i9 + 1;
                    if (bArr[i9] >= 0) {
                        this.f14981c = i11;
                        return;
                    } else {
                        i10++;
                        i9 = i11;
                    }
                }
            }
            k0();
        }

        private void k0() throws IOException {
            for (int i8 = 0; i8 < 10; i8++) {
                if (S() >= 0) {
                    return;
                }
            }
            throw InvalidProtocolBufferException.e();
        }

        private void l0(int i8) throws IOException {
            e0(i8);
            if ((i8 & 3) == 0) {
                return;
            }
            throw InvalidProtocolBufferException.g();
        }

        private void m0(int i8) throws IOException {
            e0(i8);
            if ((i8 & 7) == 0) {
                return;
            }
            throw InvalidProtocolBufferException.g();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Reader
        public int A() throws IOException {
            if (R()) {
                return Api.BaseClientBuilder.API_PRIORITY_OTHER;
            }
            int b02 = b0();
            this.f14984f = b02;
            if (b02 == this.f14985g) {
                return Api.BaseClientBuilder.API_PRIORITY_OTHER;
            }
            return WireFormat.a(b02);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Reader
        public void B(List<String> list) throws IOException {
            a0(list, false);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Reader
        public void C(List<Float> list) throws IOException {
            int i8;
            int i9;
            if (list instanceof FloatArrayList) {
                FloatArrayList floatArrayList = (FloatArrayList) list;
                int b8 = WireFormat.b(this.f14984f);
                if (b8 != 2) {
                    if (b8 == 5) {
                        do {
                            floatArrayList.g(readFloat());
                            if (R()) {
                                return;
                            }
                            i9 = this.f14981c;
                        } while (b0() == this.f14984f);
                        this.f14981c = i9;
                        return;
                    }
                    throw InvalidProtocolBufferException.d();
                }
                int b02 = b0();
                l0(b02);
                int i10 = this.f14981c + b02;
                while (this.f14981c < i10) {
                    floatArrayList.g(Float.intBitsToFloat(V()));
                }
                return;
            }
            int b9 = WireFormat.b(this.f14984f);
            if (b9 != 2) {
                if (b9 == 5) {
                    do {
                        list.add(Float.valueOf(readFloat()));
                        if (R()) {
                            return;
                        }
                        i8 = this.f14981c;
                    } while (b0() == this.f14984f);
                    this.f14981c = i8;
                    return;
                }
                throw InvalidProtocolBufferException.d();
            }
            int b03 = b0();
            l0(b03);
            int i11 = this.f14981c + b03;
            while (this.f14981c < i11) {
                list.add(Float.valueOf(Float.intBitsToFloat(V())));
            }
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Reader
        public boolean D() throws IOException {
            int i8;
            if (!R() && (i8 = this.f14984f) != this.f14985g) {
                int b8 = WireFormat.b(i8);
                if (b8 != 0) {
                    if (b8 != 1) {
                        if (b8 != 2) {
                            if (b8 != 3) {
                                if (b8 == 5) {
                                    h0(4);
                                    return true;
                                }
                                throw InvalidProtocolBufferException.d();
                            }
                            i0();
                            return true;
                        }
                        h0(b0());
                        return true;
                    }
                    h0(8);
                    return true;
                }
                j0();
                return true;
            }
            return false;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Reader
        public int E() throws IOException {
            g0(5);
            return U();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Reader
        public void F(List<ByteString> list) throws IOException {
            int i8;
            if (WireFormat.b(this.f14984f) == 2) {
                do {
                    list.add(o());
                    if (R()) {
                        return;
                    }
                    i8 = this.f14981c;
                } while (b0() == this.f14984f);
                this.f14981c = i8;
                return;
            }
            throw InvalidProtocolBufferException.d();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Reader
        public void G(List<Double> list) throws IOException {
            int i8;
            int i9;
            if (list instanceof DoubleArrayList) {
                DoubleArrayList doubleArrayList = (DoubleArrayList) list;
                int b8 = WireFormat.b(this.f14984f);
                if (b8 != 1) {
                    if (b8 == 2) {
                        int b02 = b0();
                        m0(b02);
                        int i10 = this.f14981c + b02;
                        while (this.f14981c < i10) {
                            doubleArrayList.K0(Double.longBitsToDouble(X()));
                        }
                        return;
                    }
                    throw InvalidProtocolBufferException.d();
                }
                do {
                    doubleArrayList.K0(readDouble());
                    if (R()) {
                        return;
                    }
                    i9 = this.f14981c;
                } while (b0() == this.f14984f);
                this.f14981c = i9;
                return;
            }
            int b9 = WireFormat.b(this.f14984f);
            if (b9 != 1) {
                if (b9 == 2) {
                    int b03 = b0();
                    m0(b03);
                    int i11 = this.f14981c + b03;
                    while (this.f14981c < i11) {
                        list.add(Double.valueOf(Double.longBitsToDouble(X())));
                    }
                    return;
                }
                throw InvalidProtocolBufferException.d();
            }
            do {
                list.add(Double.valueOf(readDouble()));
                if (R()) {
                    return;
                }
                i8 = this.f14981c;
            } while (b0() == this.f14984f);
            this.f14981c = i8;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Reader
        public long H() throws IOException {
            g0(0);
            return c0();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Reader
        public String I() throws IOException {
            return Z(true);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Reader
        public <T> T J(Schema<T> schema, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            g0(3);
            return (T) T(schema, extensionRegistryLite);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Reader
        public <T> T K(Class<T> cls, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            g0(3);
            return (T) T(Protobuf.a().d(cls), extensionRegistryLite);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Reader
        public <K, V> void L(Map<K, V> map, MapEntryLite.Metadata<K, V> metadata, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            g0(2);
            int b02 = b0();
            e0(b02);
            int i8 = this.f14983e;
            this.f14983e = this.f14981c + b02;
            try {
                throw null;
            } catch (Throwable th) {
                this.f14983e = i8;
                throw th;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.crypto.tink.shaded.protobuf.Reader
        public <T> void M(List<T> list, Schema<T> schema, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            int i8;
            if (WireFormat.b(this.f14984f) == 2) {
                int i9 = this.f14984f;
                do {
                    list.add(Y(schema, extensionRegistryLite));
                    if (R()) {
                        return;
                    }
                    i8 = this.f14981c;
                } while (b0() == i9);
                this.f14981c = i8;
                return;
            }
            throw InvalidProtocolBufferException.d();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Reader
        public <T> T N(Schema<T> schema, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            g0(2);
            return (T) Y(schema, extensionRegistryLite);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Reader
        public <T> T O(Class<T> cls, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            g0(2);
            return (T) Y(Protobuf.a().d(cls), extensionRegistryLite);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.crypto.tink.shaded.protobuf.Reader
        public <T> void P(List<T> list, Schema<T> schema, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            int i8;
            if (WireFormat.b(this.f14984f) == 3) {
                int i9 = this.f14984f;
                do {
                    list.add(T(schema, extensionRegistryLite));
                    if (R()) {
                        return;
                    }
                    i8 = this.f14981c;
                } while (b0() == i9);
                this.f14981c = i8;
                return;
            }
            throw InvalidProtocolBufferException.d();
        }

        public String Z(boolean z7) throws IOException {
            g0(2);
            int b02 = b0();
            if (b02 == 0) {
                return "";
            }
            e0(b02);
            if (z7) {
                byte[] bArr = this.f14980b;
                int i8 = this.f14981c;
                if (!Utf8.n(bArr, i8, i8 + b02)) {
                    throw InvalidProtocolBufferException.c();
                }
            }
            String str = new String(this.f14980b, this.f14981c, b02, Internal.f15115a);
            this.f14981c += b02;
            return str;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Reader
        public int a() {
            return this.f14984f;
        }

        public void a0(List<String> list, boolean z7) throws IOException {
            int i8;
            int i9;
            if (WireFormat.b(this.f14984f) == 2) {
                if ((list instanceof LazyStringList) && !z7) {
                    LazyStringList lazyStringList = (LazyStringList) list;
                    do {
                        lazyStringList.U0(o());
                        if (R()) {
                            return;
                        }
                        i9 = this.f14981c;
                    } while (b0() == this.f14984f);
                    this.f14981c = i9;
                    return;
                }
                do {
                    list.add(Z(z7));
                    if (R()) {
                        return;
                    }
                    i8 = this.f14981c;
                } while (b0() == this.f14984f);
                this.f14981c = i8;
                return;
            }
            throw InvalidProtocolBufferException.d();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Reader
        public long b() throws IOException {
            g0(1);
            return W();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Reader
        public void c(List<Integer> list) throws IOException {
            int i8;
            int i9;
            if (list instanceof IntArrayList) {
                IntArrayList intArrayList = (IntArrayList) list;
                int b8 = WireFormat.b(this.f14984f);
                if (b8 != 2) {
                    if (b8 == 5) {
                        do {
                            intArrayList.s0(E());
                            if (R()) {
                                return;
                            }
                            i9 = this.f14981c;
                        } while (b0() == this.f14984f);
                        this.f14981c = i9;
                        return;
                    }
                    throw InvalidProtocolBufferException.d();
                }
                int b02 = b0();
                l0(b02);
                int i10 = this.f14981c + b02;
                while (this.f14981c < i10) {
                    intArrayList.s0(V());
                }
                return;
            }
            int b9 = WireFormat.b(this.f14984f);
            if (b9 != 2) {
                if (b9 == 5) {
                    do {
                        list.add(Integer.valueOf(E()));
                        if (R()) {
                            return;
                        }
                        i8 = this.f14981c;
                    } while (b0() == this.f14984f);
                    this.f14981c = i8;
                    return;
                }
                throw InvalidProtocolBufferException.d();
            }
            int b03 = b0();
            l0(b03);
            int i11 = this.f14981c + b03;
            while (this.f14981c < i11) {
                list.add(Integer.valueOf(V()));
            }
        }

        public long c0() throws IOException {
            long j8;
            long j9;
            long j10;
            int i8;
            int i9 = this.f14981c;
            int i10 = this.f14983e;
            if (i10 != i9) {
                byte[] bArr = this.f14980b;
                int i11 = i9 + 1;
                byte b8 = bArr[i9];
                if (b8 >= 0) {
                    this.f14981c = i11;
                    return b8;
                } else if (i10 - i11 < 9) {
                    return d0();
                } else {
                    int i12 = i11 + 1;
                    int i13 = b8 ^ (bArr[i11] << 7);
                    if (i13 < 0) {
                        i8 = i13 ^ (-128);
                    } else {
                        int i14 = i12 + 1;
                        int i15 = i13 ^ (bArr[i12] << 14);
                        if (i15 >= 0) {
                            i12 = i14;
                            j8 = i15 ^ 16256;
                        } else {
                            i12 = i14 + 1;
                            int i16 = i15 ^ (bArr[i14] << 21);
                            if (i16 < 0) {
                                i8 = i16 ^ (-2080896);
                            } else {
                                long j11 = i16;
                                int i17 = i12 + 1;
                                long j12 = j11 ^ (bArr[i12] << 28);
                                if (j12 >= 0) {
                                    j10 = 266354560;
                                } else {
                                    i12 = i17 + 1;
                                    long j13 = j12 ^ (bArr[i17] << 35);
                                    if (j13 < 0) {
                                        j9 = -34093383808L;
                                    } else {
                                        i17 = i12 + 1;
                                        j12 = j13 ^ (bArr[i12] << 42);
                                        if (j12 >= 0) {
                                            j10 = 4363953127296L;
                                        } else {
                                            i12 = i17 + 1;
                                            j13 = j12 ^ (bArr[i17] << 49);
                                            if (j13 < 0) {
                                                j9 = -558586000294016L;
                                            } else {
                                                int i18 = i12 + 1;
                                                long j14 = (j13 ^ (bArr[i12] << 56)) ^ 71499008037633920L;
                                                if (j14 < 0) {
                                                    i12 = i18 + 1;
                                                    if (bArr[i18] < 0) {
                                                        throw InvalidProtocolBufferException.e();
                                                    }
                                                } else {
                                                    i12 = i18;
                                                }
                                                j8 = j14;
                                            }
                                        }
                                    }
                                    j8 = j13 ^ j9;
                                }
                                j8 = j12 ^ j10;
                                i12 = i17;
                            }
                        }
                        this.f14981c = i12;
                        return j8;
                    }
                    j8 = i8;
                    this.f14981c = i12;
                    return j8;
                }
            }
            throw InvalidProtocolBufferException.j();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Reader
        public void d(List<Long> list) throws IOException {
            int i8;
            int i9;
            if (list instanceof LongArrayList) {
                LongArrayList longArrayList = (LongArrayList) list;
                int b8 = WireFormat.b(this.f14984f);
                if (b8 != 0) {
                    if (b8 == 2) {
                        int b02 = this.f14981c + b0();
                        while (this.f14981c < b02) {
                            longArrayList.v0(CodedInputStream.c(c0()));
                        }
                        return;
                    }
                    throw InvalidProtocolBufferException.d();
                }
                do {
                    longArrayList.v0(y());
                    if (R()) {
                        return;
                    }
                    i9 = this.f14981c;
                } while (b0() == this.f14984f);
                this.f14981c = i9;
                return;
            }
            int b9 = WireFormat.b(this.f14984f);
            if (b9 != 0) {
                if (b9 == 2) {
                    int b03 = this.f14981c + b0();
                    while (this.f14981c < b03) {
                        list.add(Long.valueOf(CodedInputStream.c(c0())));
                    }
                    return;
                }
                throw InvalidProtocolBufferException.d();
            }
            do {
                list.add(Long.valueOf(y()));
                if (R()) {
                    return;
                }
                i8 = this.f14981c;
            } while (b0() == this.f14984f);
            this.f14981c = i8;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Reader
        public boolean e() throws IOException {
            g0(0);
            if (b0() == 0) {
                return false;
            }
            return true;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Reader
        public long f() throws IOException {
            g0(1);
            return W();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Reader
        public void g(List<Long> list) throws IOException {
            int i8;
            int i9;
            if (list instanceof LongArrayList) {
                LongArrayList longArrayList = (LongArrayList) list;
                int b8 = WireFormat.b(this.f14984f);
                if (b8 != 0) {
                    if (b8 == 2) {
                        int b02 = this.f14981c + b0();
                        while (this.f14981c < b02) {
                            longArrayList.v0(c0());
                        }
                        f0(b02);
                        return;
                    }
                    throw InvalidProtocolBufferException.d();
                }
                do {
                    longArrayList.v0(s());
                    if (R()) {
                        return;
                    }
                    i9 = this.f14981c;
                } while (b0() == this.f14984f);
                this.f14981c = i9;
                return;
            }
            int b9 = WireFormat.b(this.f14984f);
            if (b9 != 0) {
                if (b9 == 2) {
                    int b03 = this.f14981c + b0();
                    while (this.f14981c < b03) {
                        list.add(Long.valueOf(c0()));
                    }
                    f0(b03);
                    return;
                }
                throw InvalidProtocolBufferException.d();
            }
            do {
                list.add(Long.valueOf(s()));
                if (R()) {
                    return;
                }
                i8 = this.f14981c;
            } while (b0() == this.f14984f);
            this.f14981c = i8;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Reader
        public int h() throws IOException {
            g0(0);
            return b0();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Reader
        public void i(List<Long> list) throws IOException {
            int i8;
            int i9;
            if (list instanceof LongArrayList) {
                LongArrayList longArrayList = (LongArrayList) list;
                int b8 = WireFormat.b(this.f14984f);
                if (b8 != 0) {
                    if (b8 == 2) {
                        int b02 = this.f14981c + b0();
                        while (this.f14981c < b02) {
                            longArrayList.v0(c0());
                        }
                        f0(b02);
                        return;
                    }
                    throw InvalidProtocolBufferException.d();
                }
                do {
                    longArrayList.v0(H());
                    if (R()) {
                        return;
                    }
                    i9 = this.f14981c;
                } while (b0() == this.f14984f);
                this.f14981c = i9;
                return;
            }
            int b9 = WireFormat.b(this.f14984f);
            if (b9 != 0) {
                if (b9 == 2) {
                    int b03 = this.f14981c + b0();
                    while (this.f14981c < b03) {
                        list.add(Long.valueOf(c0()));
                    }
                    f0(b03);
                    return;
                }
                throw InvalidProtocolBufferException.d();
            }
            do {
                list.add(Long.valueOf(H()));
                if (R()) {
                    return;
                }
                i8 = this.f14981c;
            } while (b0() == this.f14984f);
            this.f14981c = i8;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Reader
        public void j(List<Integer> list) throws IOException {
            int i8;
            int i9;
            if (list instanceof IntArrayList) {
                IntArrayList intArrayList = (IntArrayList) list;
                int b8 = WireFormat.b(this.f14984f);
                if (b8 != 0) {
                    if (b8 == 2) {
                        int b02 = this.f14981c + b0();
                        while (this.f14981c < b02) {
                            intArrayList.s0(b0());
                        }
                        return;
                    }
                    throw InvalidProtocolBufferException.d();
                }
                do {
                    intArrayList.s0(k());
                    if (R()) {
                        return;
                    }
                    i9 = this.f14981c;
                } while (b0() == this.f14984f);
                this.f14981c = i9;
                return;
            }
            int b9 = WireFormat.b(this.f14984f);
            if (b9 != 0) {
                if (b9 == 2) {
                    int b03 = this.f14981c + b0();
                    while (this.f14981c < b03) {
                        list.add(Integer.valueOf(b0()));
                    }
                    return;
                }
                throw InvalidProtocolBufferException.d();
            }
            do {
                list.add(Integer.valueOf(k()));
                if (R()) {
                    return;
                }
                i8 = this.f14981c;
            } while (b0() == this.f14984f);
            this.f14981c = i8;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Reader
        public int k() throws IOException {
            g0(0);
            return b0();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Reader
        public int l() throws IOException {
            g0(0);
            return CodedInputStream.b(b0());
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Reader
        public void m(List<Boolean> list) throws IOException {
            int i8;
            boolean z7;
            int i9;
            boolean z8;
            if (list instanceof BooleanArrayList) {
                BooleanArrayList booleanArrayList = (BooleanArrayList) list;
                int b8 = WireFormat.b(this.f14984f);
                if (b8 != 0) {
                    if (b8 == 2) {
                        int b02 = this.f14981c + b0();
                        while (this.f14981c < b02) {
                            if (b0() != 0) {
                                z8 = true;
                            } else {
                                z8 = false;
                            }
                            booleanArrayList.i(z8);
                        }
                        f0(b02);
                        return;
                    }
                    throw InvalidProtocolBufferException.d();
                }
                do {
                    booleanArrayList.i(e());
                    if (R()) {
                        return;
                    }
                    i9 = this.f14981c;
                } while (b0() == this.f14984f);
                this.f14981c = i9;
                return;
            }
            int b9 = WireFormat.b(this.f14984f);
            if (b9 != 0) {
                if (b9 == 2) {
                    int b03 = this.f14981c + b0();
                    while (this.f14981c < b03) {
                        if (b0() != 0) {
                            z7 = true;
                        } else {
                            z7 = false;
                        }
                        list.add(Boolean.valueOf(z7));
                    }
                    f0(b03);
                    return;
                }
                throw InvalidProtocolBufferException.d();
            }
            do {
                list.add(Boolean.valueOf(e()));
                if (R()) {
                    return;
                }
                i8 = this.f14981c;
            } while (b0() == this.f14984f);
            this.f14981c = i8;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Reader
        public void n(List<String> list) throws IOException {
            a0(list, true);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Reader
        public ByteString o() throws IOException {
            ByteString k8;
            g0(2);
            int b02 = b0();
            if (b02 == 0) {
                return ByteString.f14989g;
            }
            e0(b02);
            if (this.f14979a) {
                k8 = ByteString.F(this.f14980b, this.f14981c, b02);
            } else {
                k8 = ByteString.k(this.f14980b, this.f14981c, b02);
            }
            this.f14981c += b02;
            return k8;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Reader
        public int p() throws IOException {
            g0(0);
            return b0();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Reader
        public void q(List<Long> list) throws IOException {
            int i8;
            int i9;
            if (list instanceof LongArrayList) {
                LongArrayList longArrayList = (LongArrayList) list;
                int b8 = WireFormat.b(this.f14984f);
                if (b8 != 1) {
                    if (b8 == 2) {
                        int b02 = b0();
                        m0(b02);
                        int i10 = this.f14981c + b02;
                        while (this.f14981c < i10) {
                            longArrayList.v0(X());
                        }
                        return;
                    }
                    throw InvalidProtocolBufferException.d();
                }
                do {
                    longArrayList.v0(b());
                    if (R()) {
                        return;
                    }
                    i9 = this.f14981c;
                } while (b0() == this.f14984f);
                this.f14981c = i9;
                return;
            }
            int b9 = WireFormat.b(this.f14984f);
            if (b9 != 1) {
                if (b9 == 2) {
                    int b03 = b0();
                    m0(b03);
                    int i11 = this.f14981c + b03;
                    while (this.f14981c < i11) {
                        list.add(Long.valueOf(X()));
                    }
                    return;
                }
                throw InvalidProtocolBufferException.d();
            }
            do {
                list.add(Long.valueOf(b()));
                if (R()) {
                    return;
                }
                i8 = this.f14981c;
            } while (b0() == this.f14984f);
            this.f14981c = i8;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Reader
        public void r(List<Integer> list) throws IOException {
            int i8;
            int i9;
            if (list instanceof IntArrayList) {
                IntArrayList intArrayList = (IntArrayList) list;
                int b8 = WireFormat.b(this.f14984f);
                if (b8 != 0) {
                    if (b8 == 2) {
                        int b02 = this.f14981c + b0();
                        while (this.f14981c < b02) {
                            intArrayList.s0(CodedInputStream.b(b0()));
                        }
                        return;
                    }
                    throw InvalidProtocolBufferException.d();
                }
                do {
                    intArrayList.s0(l());
                    if (R()) {
                        return;
                    }
                    i9 = this.f14981c;
                } while (b0() == this.f14984f);
                this.f14981c = i9;
                return;
            }
            int b9 = WireFormat.b(this.f14984f);
            if (b9 != 0) {
                if (b9 == 2) {
                    int b03 = this.f14981c + b0();
                    while (this.f14981c < b03) {
                        list.add(Integer.valueOf(CodedInputStream.b(b0())));
                    }
                    return;
                }
                throw InvalidProtocolBufferException.d();
            }
            do {
                list.add(Integer.valueOf(l()));
                if (R()) {
                    return;
                }
                i8 = this.f14981c;
            } while (b0() == this.f14984f);
            this.f14981c = i8;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Reader
        public double readDouble() throws IOException {
            g0(1);
            return Double.longBitsToDouble(W());
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Reader
        public float readFloat() throws IOException {
            g0(5);
            return Float.intBitsToFloat(U());
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Reader
        public long s() throws IOException {
            g0(0);
            return c0();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Reader
        public void t(List<Integer> list) throws IOException {
            int i8;
            int i9;
            if (list instanceof IntArrayList) {
                IntArrayList intArrayList = (IntArrayList) list;
                int b8 = WireFormat.b(this.f14984f);
                if (b8 != 0) {
                    if (b8 == 2) {
                        int b02 = this.f14981c + b0();
                        while (this.f14981c < b02) {
                            intArrayList.s0(b0());
                        }
                        return;
                    }
                    throw InvalidProtocolBufferException.d();
                }
                do {
                    intArrayList.s0(h());
                    if (R()) {
                        return;
                    }
                    i9 = this.f14981c;
                } while (b0() == this.f14984f);
                this.f14981c = i9;
                return;
            }
            int b9 = WireFormat.b(this.f14984f);
            if (b9 != 0) {
                if (b9 == 2) {
                    int b03 = this.f14981c + b0();
                    while (this.f14981c < b03) {
                        list.add(Integer.valueOf(b0()));
                    }
                    return;
                }
                throw InvalidProtocolBufferException.d();
            }
            do {
                list.add(Integer.valueOf(h()));
                if (R()) {
                    return;
                }
                i8 = this.f14981c;
            } while (b0() == this.f14984f);
            this.f14981c = i8;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Reader
        public int u() throws IOException {
            g0(5);
            return U();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Reader
        public void v(List<Long> list) throws IOException {
            int i8;
            int i9;
            if (list instanceof LongArrayList) {
                LongArrayList longArrayList = (LongArrayList) list;
                int b8 = WireFormat.b(this.f14984f);
                if (b8 != 1) {
                    if (b8 == 2) {
                        int b02 = b0();
                        m0(b02);
                        int i10 = this.f14981c + b02;
                        while (this.f14981c < i10) {
                            longArrayList.v0(X());
                        }
                        return;
                    }
                    throw InvalidProtocolBufferException.d();
                }
                do {
                    longArrayList.v0(f());
                    if (R()) {
                        return;
                    }
                    i9 = this.f14981c;
                } while (b0() == this.f14984f);
                this.f14981c = i9;
                return;
            }
            int b9 = WireFormat.b(this.f14984f);
            if (b9 != 1) {
                if (b9 == 2) {
                    int b03 = b0();
                    m0(b03);
                    int i11 = this.f14981c + b03;
                    while (this.f14981c < i11) {
                        list.add(Long.valueOf(X()));
                    }
                    return;
                }
                throw InvalidProtocolBufferException.d();
            }
            do {
                list.add(Long.valueOf(f()));
                if (R()) {
                    return;
                }
                i8 = this.f14981c;
            } while (b0() == this.f14984f);
            this.f14981c = i8;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Reader
        public void w(List<Integer> list) throws IOException {
            int i8;
            int i9;
            if (list instanceof IntArrayList) {
                IntArrayList intArrayList = (IntArrayList) list;
                int b8 = WireFormat.b(this.f14984f);
                if (b8 != 0) {
                    if (b8 == 2) {
                        int b02 = this.f14981c + b0();
                        while (this.f14981c < b02) {
                            intArrayList.s0(b0());
                        }
                        f0(b02);
                        return;
                    }
                    throw InvalidProtocolBufferException.d();
                }
                do {
                    intArrayList.s0(p());
                    if (R()) {
                        return;
                    }
                    i9 = this.f14981c;
                } while (b0() == this.f14984f);
                this.f14981c = i9;
                return;
            }
            int b9 = WireFormat.b(this.f14984f);
            if (b9 != 0) {
                if (b9 == 2) {
                    int b03 = this.f14981c + b0();
                    while (this.f14981c < b03) {
                        list.add(Integer.valueOf(b0()));
                    }
                    f0(b03);
                    return;
                }
                throw InvalidProtocolBufferException.d();
            }
            do {
                list.add(Integer.valueOf(p()));
                if (R()) {
                    return;
                }
                i8 = this.f14981c;
            } while (b0() == this.f14984f);
            this.f14981c = i8;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Reader
        public void x(List<Integer> list) throws IOException {
            int i8;
            int i9;
            if (list instanceof IntArrayList) {
                IntArrayList intArrayList = (IntArrayList) list;
                int b8 = WireFormat.b(this.f14984f);
                if (b8 != 2) {
                    if (b8 == 5) {
                        do {
                            intArrayList.s0(u());
                            if (R()) {
                                return;
                            }
                            i9 = this.f14981c;
                        } while (b0() == this.f14984f);
                        this.f14981c = i9;
                        return;
                    }
                    throw InvalidProtocolBufferException.d();
                }
                int b02 = b0();
                l0(b02);
                int i10 = this.f14981c + b02;
                while (this.f14981c < i10) {
                    intArrayList.s0(V());
                }
                return;
            }
            int b9 = WireFormat.b(this.f14984f);
            if (b9 != 2) {
                if (b9 == 5) {
                    do {
                        list.add(Integer.valueOf(u()));
                        if (R()) {
                            return;
                        }
                        i8 = this.f14981c;
                    } while (b0() == this.f14984f);
                    this.f14981c = i8;
                    return;
                }
                throw InvalidProtocolBufferException.d();
            }
            int b03 = b0();
            l0(b03);
            int i11 = this.f14981c + b03;
            while (this.f14981c < i11) {
                list.add(Integer.valueOf(V()));
            }
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Reader
        public long y() throws IOException {
            g0(0);
            return CodedInputStream.c(c0());
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Reader
        public String z() throws IOException {
            return Z(false);
        }
    }

    private BinaryReader() {
    }

    public static BinaryReader Q(ByteBuffer byteBuffer, boolean z7) {
        if (byteBuffer.hasArray()) {
            return new SafeHeapReader(byteBuffer, z7);
        }
        throw new IllegalArgumentException("Direct buffers not yet supported");
    }
}
