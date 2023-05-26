package com.google.protobuf;

import com.google.android.gms.common.api.Api;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MapEntryLite;
import com.google.protobuf.WireFormat;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
abstract class BinaryReader implements Reader {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.google.protobuf.BinaryReader$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f17165a;

        static {
            int[] iArr = new int[WireFormat.FieldType.values().length];
            f17165a = iArr;
            try {
                iArr[WireFormat.FieldType.f17679o.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f17165a[WireFormat.FieldType.f17683s.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f17165a[WireFormat.FieldType.f17672h.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f17165a[WireFormat.FieldType.f17685u.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f17165a[WireFormat.FieldType.f17678n.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f17165a[WireFormat.FieldType.f17677m.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f17165a[WireFormat.FieldType.f17673i.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f17165a[WireFormat.FieldType.f17676l.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f17165a[WireFormat.FieldType.f17674j.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f17165a[WireFormat.FieldType.f17682r.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f17165a[WireFormat.FieldType.f17686v.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f17165a[WireFormat.FieldType.f17687w.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f17165a[WireFormat.FieldType.f17688x.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f17165a[WireFormat.FieldType.f17689y.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f17165a[WireFormat.FieldType.f17680p.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f17165a[WireFormat.FieldType.f17684t.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f17165a[WireFormat.FieldType.f17675k.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
        }
    }

    /* loaded from: classes3.dex */
    private static final class SafeHeapReader extends BinaryReader {

        /* renamed from: a  reason: collision with root package name */
        private final boolean f17166a;

        /* renamed from: b  reason: collision with root package name */
        private final byte[] f17167b;

        /* renamed from: c  reason: collision with root package name */
        private int f17168c;

        /* renamed from: d  reason: collision with root package name */
        private final int f17169d;

        /* renamed from: e  reason: collision with root package name */
        private int f17170e;

        /* renamed from: f  reason: collision with root package name */
        private int f17171f;

        /* renamed from: g  reason: collision with root package name */
        private int f17172g;

        public SafeHeapReader(ByteBuffer byteBuffer, boolean z7) {
            super(null);
            this.f17166a = z7;
            this.f17167b = byteBuffer.array();
            int arrayOffset = byteBuffer.arrayOffset() + byteBuffer.position();
            this.f17168c = arrayOffset;
            this.f17169d = arrayOffset;
            this.f17170e = byteBuffer.arrayOffset() + byteBuffer.limit();
        }

        private boolean R() {
            if (this.f17168c == this.f17170e) {
                return true;
            }
            return false;
        }

        private byte S() throws IOException {
            int i8 = this.f17168c;
            if (i8 != this.f17170e) {
                byte[] bArr = this.f17167b;
                this.f17168c = i8 + 1;
                return bArr[i8];
            }
            throw InvalidProtocolBufferException.m();
        }

        private Object T(WireFormat.FieldType fieldType, Class<?> cls, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            switch (AnonymousClass1.f17165a[fieldType.ordinal()]) {
                case 1:
                    return Boolean.valueOf(e());
                case 2:
                    return o();
                case 3:
                    return Double.valueOf(readDouble());
                case 4:
                    return Integer.valueOf(k());
                case 5:
                    return Integer.valueOf(u());
                case 6:
                    return Long.valueOf(b());
                case 7:
                    return Float.valueOf(readFloat());
                case 8:
                    return Integer.valueOf(p());
                case 9:
                    return Long.valueOf(H());
                case 10:
                    return N(cls, extensionRegistryLite);
                case 11:
                    return Integer.valueOf(E());
                case 12:
                    return Long.valueOf(f());
                case 13:
                    return Integer.valueOf(l());
                case 14:
                    return Long.valueOf(y());
                case 15:
                    return I();
                case 16:
                    return Integer.valueOf(h());
                case 17:
                    return Long.valueOf(s());
                default:
                    throw new RuntimeException("unsupported field type.");
            }
        }

        private <T> T U(Schema<T> schema, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            int i8 = this.f17172g;
            this.f17172g = WireFormat.c(WireFormat.a(this.f17171f), 4);
            try {
                T e8 = schema.e();
                schema.g(e8, this, extensionRegistryLite);
                schema.b(e8);
                if (this.f17171f == this.f17172g) {
                    return e8;
                }
                throw InvalidProtocolBufferException.h();
            } finally {
                this.f17172g = i8;
            }
        }

        private int V() throws IOException {
            f0(4);
            return W();
        }

        private int W() {
            int i8 = this.f17168c;
            byte[] bArr = this.f17167b;
            this.f17168c = i8 + 4;
            return ((bArr[i8 + 3] & 255) << 24) | (bArr[i8] & 255) | ((bArr[i8 + 1] & 255) << 8) | ((bArr[i8 + 2] & 255) << 16);
        }

        private long X() throws IOException {
            f0(8);
            return Y();
        }

        private long Y() {
            int i8 = this.f17168c;
            byte[] bArr = this.f17167b;
            this.f17168c = i8 + 8;
            return ((bArr[i8 + 7] & 255) << 56) | (bArr[i8] & 255) | ((bArr[i8 + 1] & 255) << 8) | ((bArr[i8 + 2] & 255) << 16) | ((bArr[i8 + 3] & 255) << 24) | ((bArr[i8 + 4] & 255) << 32) | ((bArr[i8 + 5] & 255) << 40) | ((bArr[i8 + 6] & 255) << 48);
        }

        private <T> T Z(Schema<T> schema, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            int c02 = c0();
            f0(c02);
            int i8 = this.f17170e;
            int i9 = this.f17168c + c02;
            this.f17170e = i9;
            try {
                T e8 = schema.e();
                schema.g(e8, this, extensionRegistryLite);
                schema.b(e8);
                if (this.f17168c == i9) {
                    return e8;
                }
                throw InvalidProtocolBufferException.h();
            } finally {
                this.f17170e = i8;
            }
        }

        private int c0() throws IOException {
            int i8;
            int i9 = this.f17168c;
            int i10 = this.f17170e;
            if (i10 != i9) {
                byte[] bArr = this.f17167b;
                int i11 = i9 + 1;
                byte b8 = bArr[i9];
                if (b8 >= 0) {
                    this.f17168c = i11;
                    return b8;
                } else if (i10 - i11 < 9) {
                    return (int) e0();
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
                                                        throw InvalidProtocolBufferException.f();
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
                    this.f17168c = i12;
                    return i8;
                }
            }
            throw InvalidProtocolBufferException.m();
        }

        private long e0() throws IOException {
            long j8 = 0;
            for (int i8 = 0; i8 < 64; i8 += 7) {
                byte S = S();
                j8 |= (S & Byte.MAX_VALUE) << i8;
                if ((S & 128) == 0) {
                    return j8;
                }
            }
            throw InvalidProtocolBufferException.f();
        }

        private void f0(int i8) throws IOException {
            if (i8 >= 0 && i8 <= this.f17170e - this.f17168c) {
                return;
            }
            throw InvalidProtocolBufferException.m();
        }

        private void g0(int i8) throws IOException {
            if (this.f17168c == i8) {
                return;
            }
            throw InvalidProtocolBufferException.m();
        }

        private void h0(int i8) throws IOException {
            if (WireFormat.b(this.f17171f) == i8) {
                return;
            }
            throw InvalidProtocolBufferException.e();
        }

        private void i0(int i8) throws IOException {
            f0(i8);
            this.f17168c += i8;
        }

        private void j0() throws IOException {
            int i8 = this.f17172g;
            this.f17172g = WireFormat.c(WireFormat.a(this.f17171f), 4);
            while (A() != Integer.MAX_VALUE && D()) {
            }
            if (this.f17171f == this.f17172g) {
                this.f17172g = i8;
                return;
            }
            throw InvalidProtocolBufferException.h();
        }

        private void k0() throws IOException {
            int i8 = this.f17170e;
            int i9 = this.f17168c;
            if (i8 - i9 >= 10) {
                byte[] bArr = this.f17167b;
                int i10 = 0;
                while (i10 < 10) {
                    int i11 = i9 + 1;
                    if (bArr[i9] >= 0) {
                        this.f17168c = i11;
                        return;
                    } else {
                        i10++;
                        i9 = i11;
                    }
                }
            }
            l0();
        }

        private void l0() throws IOException {
            for (int i8 = 0; i8 < 10; i8++) {
                if (S() >= 0) {
                    return;
                }
            }
            throw InvalidProtocolBufferException.f();
        }

        private void m0(int i8) throws IOException {
            f0(i8);
            if ((i8 & 3) == 0) {
                return;
            }
            throw InvalidProtocolBufferException.h();
        }

        private void n0(int i8) throws IOException {
            f0(i8);
            if ((i8 & 7) == 0) {
                return;
            }
            throw InvalidProtocolBufferException.h();
        }

        @Override // com.google.protobuf.Reader
        public int A() throws IOException {
            if (R()) {
                return Api.BaseClientBuilder.API_PRIORITY_OTHER;
            }
            int c02 = c0();
            this.f17171f = c02;
            if (c02 == this.f17172g) {
                return Api.BaseClientBuilder.API_PRIORITY_OTHER;
            }
            return WireFormat.a(c02);
        }

        @Override // com.google.protobuf.Reader
        public void B(List<String> list) throws IOException {
            b0(list, false);
        }

        @Override // com.google.protobuf.Reader
        public void C(List<Float> list) throws IOException {
            int i8;
            int i9;
            if (list instanceof FloatArrayList) {
                FloatArrayList floatArrayList = (FloatArrayList) list;
                int b8 = WireFormat.b(this.f17171f);
                if (b8 != 2) {
                    if (b8 == 5) {
                        do {
                            floatArrayList.g(readFloat());
                            if (R()) {
                                return;
                            }
                            i9 = this.f17168c;
                        } while (c0() == this.f17171f);
                        this.f17168c = i9;
                        return;
                    }
                    throw InvalidProtocolBufferException.e();
                }
                int c02 = c0();
                m0(c02);
                int i10 = this.f17168c + c02;
                while (this.f17168c < i10) {
                    floatArrayList.g(Float.intBitsToFloat(W()));
                }
                return;
            }
            int b9 = WireFormat.b(this.f17171f);
            if (b9 != 2) {
                if (b9 == 5) {
                    do {
                        list.add(Float.valueOf(readFloat()));
                        if (R()) {
                            return;
                        }
                        i8 = this.f17168c;
                    } while (c0() == this.f17171f);
                    this.f17168c = i8;
                    return;
                }
                throw InvalidProtocolBufferException.e();
            }
            int c03 = c0();
            m0(c03);
            int i11 = this.f17168c + c03;
            while (this.f17168c < i11) {
                list.add(Float.valueOf(Float.intBitsToFloat(W())));
            }
        }

        @Override // com.google.protobuf.Reader
        public boolean D() throws IOException {
            int i8;
            if (!R() && (i8 = this.f17171f) != this.f17172g) {
                int b8 = WireFormat.b(i8);
                if (b8 != 0) {
                    if (b8 != 1) {
                        if (b8 != 2) {
                            if (b8 != 3) {
                                if (b8 == 5) {
                                    i0(4);
                                    return true;
                                }
                                throw InvalidProtocolBufferException.e();
                            }
                            j0();
                            return true;
                        }
                        i0(c0());
                        return true;
                    }
                    i0(8);
                    return true;
                }
                k0();
                return true;
            }
            return false;
        }

        @Override // com.google.protobuf.Reader
        public int E() throws IOException {
            h0(5);
            return V();
        }

        @Override // com.google.protobuf.Reader
        public void F(List<ByteString> list) throws IOException {
            int i8;
            if (WireFormat.b(this.f17171f) == 2) {
                do {
                    list.add(o());
                    if (R()) {
                        return;
                    }
                    i8 = this.f17168c;
                } while (c0() == this.f17171f);
                this.f17168c = i8;
                return;
            }
            throw InvalidProtocolBufferException.e();
        }

        @Override // com.google.protobuf.Reader
        public void G(List<Double> list) throws IOException {
            int i8;
            int i9;
            if (list instanceof DoubleArrayList) {
                DoubleArrayList doubleArrayList = (DoubleArrayList) list;
                int b8 = WireFormat.b(this.f17171f);
                if (b8 != 1) {
                    if (b8 == 2) {
                        int c02 = c0();
                        n0(c02);
                        int i10 = this.f17168c + c02;
                        while (this.f17168c < i10) {
                            doubleArrayList.K0(Double.longBitsToDouble(Y()));
                        }
                        return;
                    }
                    throw InvalidProtocolBufferException.e();
                }
                do {
                    doubleArrayList.K0(readDouble());
                    if (R()) {
                        return;
                    }
                    i9 = this.f17168c;
                } while (c0() == this.f17171f);
                this.f17168c = i9;
                return;
            }
            int b9 = WireFormat.b(this.f17171f);
            if (b9 != 1) {
                if (b9 == 2) {
                    int c03 = c0();
                    n0(c03);
                    int i11 = this.f17168c + c03;
                    while (this.f17168c < i11) {
                        list.add(Double.valueOf(Double.longBitsToDouble(Y())));
                    }
                    return;
                }
                throw InvalidProtocolBufferException.e();
            }
            do {
                list.add(Double.valueOf(readDouble()));
                if (R()) {
                    return;
                }
                i8 = this.f17168c;
            } while (c0() == this.f17171f);
            this.f17168c = i8;
        }

        @Override // com.google.protobuf.Reader
        public long H() throws IOException {
            h0(0);
            return d0();
        }

        @Override // com.google.protobuf.Reader
        public String I() throws IOException {
            return a0(true);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.protobuf.Reader
        @Deprecated
        public <T> void J(List<T> list, Schema<T> schema, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            int i8;
            if (WireFormat.b(this.f17171f) == 3) {
                int i9 = this.f17171f;
                do {
                    list.add(U(schema, extensionRegistryLite));
                    if (R()) {
                        return;
                    }
                    i8 = this.f17168c;
                } while (c0() == i9);
                this.f17168c = i8;
                return;
            }
            throw InvalidProtocolBufferException.e();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.protobuf.Reader
        public <T> void K(List<T> list, Schema<T> schema, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            int i8;
            if (WireFormat.b(this.f17171f) == 2) {
                int i9 = this.f17171f;
                do {
                    list.add(Z(schema, extensionRegistryLite));
                    if (R()) {
                        return;
                    }
                    i8 = this.f17168c;
                } while (c0() == i9);
                this.f17168c = i8;
                return;
            }
            throw InvalidProtocolBufferException.e();
        }

        @Override // com.google.protobuf.Reader
        @Deprecated
        public <T> T L(Class<T> cls, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            h0(3);
            return (T) U(Protobuf.a().d(cls), extensionRegistryLite);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.protobuf.Reader
        public <K, V> void M(Map<K, V> map, MapEntryLite.Metadata<K, V> metadata, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            h0(2);
            int c02 = c0();
            f0(c02);
            int i8 = this.f17170e;
            this.f17170e = this.f17168c + c02;
            try {
                Object obj = metadata.f17507b;
                Object obj2 = metadata.f17509d;
                while (true) {
                    int A = A();
                    if (A == Integer.MAX_VALUE) {
                        map.put(obj, obj2);
                        return;
                    } else if (A != 1) {
                        if (A != 2) {
                            try {
                                if (!D()) {
                                    throw new InvalidProtocolBufferException("Unable to parse map entry.");
                                    break;
                                }
                            } catch (InvalidProtocolBufferException.InvalidWireTypeException unused) {
                                if (!D()) {
                                    throw new InvalidProtocolBufferException("Unable to parse map entry.");
                                }
                            }
                        } else {
                            obj2 = T(metadata.f17508c, metadata.f17509d.getClass(), extensionRegistryLite);
                        }
                    } else {
                        obj = T(metadata.f17506a, null, null);
                    }
                }
            } finally {
                this.f17170e = i8;
            }
        }

        @Override // com.google.protobuf.Reader
        public <T> T N(Class<T> cls, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            h0(2);
            return (T) Z(Protobuf.a().d(cls), extensionRegistryLite);
        }

        @Override // com.google.protobuf.Reader
        @Deprecated
        public <T> T O(Schema<T> schema, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            h0(3);
            return (T) U(schema, extensionRegistryLite);
        }

        @Override // com.google.protobuf.Reader
        public <T> T P(Schema<T> schema, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            h0(2);
            return (T) Z(schema, extensionRegistryLite);
        }

        @Override // com.google.protobuf.Reader
        public int a() {
            return this.f17171f;
        }

        public String a0(boolean z7) throws IOException {
            h0(2);
            int c02 = c0();
            if (c02 == 0) {
                return "";
            }
            f0(c02);
            if (z7) {
                byte[] bArr = this.f17167b;
                int i8 = this.f17168c;
                if (!Utf8.t(bArr, i8, i8 + c02)) {
                    throw InvalidProtocolBufferException.d();
                }
            }
            String str = new String(this.f17167b, this.f17168c, c02, Internal.f17450b);
            this.f17168c += c02;
            return str;
        }

        @Override // com.google.protobuf.Reader
        public long b() throws IOException {
            h0(1);
            return X();
        }

        public void b0(List<String> list, boolean z7) throws IOException {
            int i8;
            int i9;
            if (WireFormat.b(this.f17171f) == 2) {
                if ((list instanceof LazyStringList) && !z7) {
                    LazyStringList lazyStringList = (LazyStringList) list;
                    do {
                        lazyStringList.t(o());
                        if (R()) {
                            return;
                        }
                        i9 = this.f17168c;
                    } while (c0() == this.f17171f);
                    this.f17168c = i9;
                    return;
                }
                do {
                    list.add(a0(z7));
                    if (R()) {
                        return;
                    }
                    i8 = this.f17168c;
                } while (c0() == this.f17171f);
                this.f17168c = i8;
                return;
            }
            throw InvalidProtocolBufferException.e();
        }

        @Override // com.google.protobuf.Reader
        public void c(List<Integer> list) throws IOException {
            int i8;
            int i9;
            if (list instanceof IntArrayList) {
                IntArrayList intArrayList = (IntArrayList) list;
                int b8 = WireFormat.b(this.f17171f);
                if (b8 != 2) {
                    if (b8 == 5) {
                        do {
                            intArrayList.s0(E());
                            if (R()) {
                                return;
                            }
                            i9 = this.f17168c;
                        } while (c0() == this.f17171f);
                        this.f17168c = i9;
                        return;
                    }
                    throw InvalidProtocolBufferException.e();
                }
                int c02 = c0();
                m0(c02);
                int i10 = this.f17168c + c02;
                while (this.f17168c < i10) {
                    intArrayList.s0(W());
                }
                return;
            }
            int b9 = WireFormat.b(this.f17171f);
            if (b9 != 2) {
                if (b9 == 5) {
                    do {
                        list.add(Integer.valueOf(E()));
                        if (R()) {
                            return;
                        }
                        i8 = this.f17168c;
                    } while (c0() == this.f17171f);
                    this.f17168c = i8;
                    return;
                }
                throw InvalidProtocolBufferException.e();
            }
            int c03 = c0();
            m0(c03);
            int i11 = this.f17168c + c03;
            while (this.f17168c < i11) {
                list.add(Integer.valueOf(W()));
            }
        }

        @Override // com.google.protobuf.Reader
        public void d(List<Long> list) throws IOException {
            int i8;
            int i9;
            if (list instanceof LongArrayList) {
                LongArrayList longArrayList = (LongArrayList) list;
                int b8 = WireFormat.b(this.f17171f);
                if (b8 != 0) {
                    if (b8 == 2) {
                        int c02 = this.f17168c + c0();
                        while (this.f17168c < c02) {
                            longArrayList.v0(CodedInputStream.d(d0()));
                        }
                        return;
                    }
                    throw InvalidProtocolBufferException.e();
                }
                do {
                    longArrayList.v0(y());
                    if (R()) {
                        return;
                    }
                    i9 = this.f17168c;
                } while (c0() == this.f17171f);
                this.f17168c = i9;
                return;
            }
            int b9 = WireFormat.b(this.f17171f);
            if (b9 != 0) {
                if (b9 == 2) {
                    int c03 = this.f17168c + c0();
                    while (this.f17168c < c03) {
                        list.add(Long.valueOf(CodedInputStream.d(d0())));
                    }
                    return;
                }
                throw InvalidProtocolBufferException.e();
            }
            do {
                list.add(Long.valueOf(y()));
                if (R()) {
                    return;
                }
                i8 = this.f17168c;
            } while (c0() == this.f17171f);
            this.f17168c = i8;
        }

        public long d0() throws IOException {
            long j8;
            long j9;
            long j10;
            int i8;
            int i9 = this.f17168c;
            int i10 = this.f17170e;
            if (i10 != i9) {
                byte[] bArr = this.f17167b;
                int i11 = i9 + 1;
                byte b8 = bArr[i9];
                if (b8 >= 0) {
                    this.f17168c = i11;
                    return b8;
                } else if (i10 - i11 < 9) {
                    return e0();
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
                                                        throw InvalidProtocolBufferException.f();
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
                        this.f17168c = i12;
                        return j8;
                    }
                    j8 = i8;
                    this.f17168c = i12;
                    return j8;
                }
            }
            throw InvalidProtocolBufferException.m();
        }

        @Override // com.google.protobuf.Reader
        public boolean e() throws IOException {
            h0(0);
            if (c0() == 0) {
                return false;
            }
            return true;
        }

        @Override // com.google.protobuf.Reader
        public long f() throws IOException {
            h0(1);
            return X();
        }

        @Override // com.google.protobuf.Reader
        public void g(List<Long> list) throws IOException {
            int i8;
            int i9;
            if (list instanceof LongArrayList) {
                LongArrayList longArrayList = (LongArrayList) list;
                int b8 = WireFormat.b(this.f17171f);
                if (b8 != 0) {
                    if (b8 == 2) {
                        int c02 = this.f17168c + c0();
                        while (this.f17168c < c02) {
                            longArrayList.v0(d0());
                        }
                        g0(c02);
                        return;
                    }
                    throw InvalidProtocolBufferException.e();
                }
                do {
                    longArrayList.v0(s());
                    if (R()) {
                        return;
                    }
                    i9 = this.f17168c;
                } while (c0() == this.f17171f);
                this.f17168c = i9;
                return;
            }
            int b9 = WireFormat.b(this.f17171f);
            if (b9 != 0) {
                if (b9 == 2) {
                    int c03 = this.f17168c + c0();
                    while (this.f17168c < c03) {
                        list.add(Long.valueOf(d0()));
                    }
                    g0(c03);
                    return;
                }
                throw InvalidProtocolBufferException.e();
            }
            do {
                list.add(Long.valueOf(s()));
                if (R()) {
                    return;
                }
                i8 = this.f17168c;
            } while (c0() == this.f17171f);
            this.f17168c = i8;
        }

        @Override // com.google.protobuf.Reader
        public int h() throws IOException {
            h0(0);
            return c0();
        }

        @Override // com.google.protobuf.Reader
        public void i(List<Long> list) throws IOException {
            int i8;
            int i9;
            if (list instanceof LongArrayList) {
                LongArrayList longArrayList = (LongArrayList) list;
                int b8 = WireFormat.b(this.f17171f);
                if (b8 != 0) {
                    if (b8 == 2) {
                        int c02 = this.f17168c + c0();
                        while (this.f17168c < c02) {
                            longArrayList.v0(d0());
                        }
                        g0(c02);
                        return;
                    }
                    throw InvalidProtocolBufferException.e();
                }
                do {
                    longArrayList.v0(H());
                    if (R()) {
                        return;
                    }
                    i9 = this.f17168c;
                } while (c0() == this.f17171f);
                this.f17168c = i9;
                return;
            }
            int b9 = WireFormat.b(this.f17171f);
            if (b9 != 0) {
                if (b9 == 2) {
                    int c03 = this.f17168c + c0();
                    while (this.f17168c < c03) {
                        list.add(Long.valueOf(d0()));
                    }
                    g0(c03);
                    return;
                }
                throw InvalidProtocolBufferException.e();
            }
            do {
                list.add(Long.valueOf(H()));
                if (R()) {
                    return;
                }
                i8 = this.f17168c;
            } while (c0() == this.f17171f);
            this.f17168c = i8;
        }

        @Override // com.google.protobuf.Reader
        public void j(List<Integer> list) throws IOException {
            int i8;
            int i9;
            if (list instanceof IntArrayList) {
                IntArrayList intArrayList = (IntArrayList) list;
                int b8 = WireFormat.b(this.f17171f);
                if (b8 != 0) {
                    if (b8 == 2) {
                        int c02 = this.f17168c + c0();
                        while (this.f17168c < c02) {
                            intArrayList.s0(c0());
                        }
                        return;
                    }
                    throw InvalidProtocolBufferException.e();
                }
                do {
                    intArrayList.s0(k());
                    if (R()) {
                        return;
                    }
                    i9 = this.f17168c;
                } while (c0() == this.f17171f);
                this.f17168c = i9;
                return;
            }
            int b9 = WireFormat.b(this.f17171f);
            if (b9 != 0) {
                if (b9 == 2) {
                    int c03 = this.f17168c + c0();
                    while (this.f17168c < c03) {
                        list.add(Integer.valueOf(c0()));
                    }
                    return;
                }
                throw InvalidProtocolBufferException.e();
            }
            do {
                list.add(Integer.valueOf(k()));
                if (R()) {
                    return;
                }
                i8 = this.f17168c;
            } while (c0() == this.f17171f);
            this.f17168c = i8;
        }

        @Override // com.google.protobuf.Reader
        public int k() throws IOException {
            h0(0);
            return c0();
        }

        @Override // com.google.protobuf.Reader
        public int l() throws IOException {
            h0(0);
            return CodedInputStream.c(c0());
        }

        @Override // com.google.protobuf.Reader
        public void m(List<Boolean> list) throws IOException {
            int i8;
            boolean z7;
            int i9;
            boolean z8;
            if (list instanceof BooleanArrayList) {
                BooleanArrayList booleanArrayList = (BooleanArrayList) list;
                int b8 = WireFormat.b(this.f17171f);
                if (b8 != 0) {
                    if (b8 == 2) {
                        int c02 = this.f17168c + c0();
                        while (this.f17168c < c02) {
                            if (c0() != 0) {
                                z8 = true;
                            } else {
                                z8 = false;
                            }
                            booleanArrayList.i(z8);
                        }
                        g0(c02);
                        return;
                    }
                    throw InvalidProtocolBufferException.e();
                }
                do {
                    booleanArrayList.i(e());
                    if (R()) {
                        return;
                    }
                    i9 = this.f17168c;
                } while (c0() == this.f17171f);
                this.f17168c = i9;
                return;
            }
            int b9 = WireFormat.b(this.f17171f);
            if (b9 != 0) {
                if (b9 == 2) {
                    int c03 = this.f17168c + c0();
                    while (this.f17168c < c03) {
                        if (c0() != 0) {
                            z7 = true;
                        } else {
                            z7 = false;
                        }
                        list.add(Boolean.valueOf(z7));
                    }
                    g0(c03);
                    return;
                }
                throw InvalidProtocolBufferException.e();
            }
            do {
                list.add(Boolean.valueOf(e()));
                if (R()) {
                    return;
                }
                i8 = this.f17168c;
            } while (c0() == this.f17171f);
            this.f17168c = i8;
        }

        @Override // com.google.protobuf.Reader
        public void n(List<String> list) throws IOException {
            b0(list, true);
        }

        @Override // com.google.protobuf.Reader
        public ByteString o() throws IOException {
            ByteString p8;
            h0(2);
            int c02 = c0();
            if (c02 == 0) {
                return ByteString.f17177g;
            }
            f0(c02);
            if (this.f17166a) {
                p8 = ByteString.P(this.f17167b, this.f17168c, c02);
            } else {
                p8 = ByteString.p(this.f17167b, this.f17168c, c02);
            }
            this.f17168c += c02;
            return p8;
        }

        @Override // com.google.protobuf.Reader
        public int p() throws IOException {
            h0(0);
            return c0();
        }

        @Override // com.google.protobuf.Reader
        public void q(List<Long> list) throws IOException {
            int i8;
            int i9;
            if (list instanceof LongArrayList) {
                LongArrayList longArrayList = (LongArrayList) list;
                int b8 = WireFormat.b(this.f17171f);
                if (b8 != 1) {
                    if (b8 == 2) {
                        int c02 = c0();
                        n0(c02);
                        int i10 = this.f17168c + c02;
                        while (this.f17168c < i10) {
                            longArrayList.v0(Y());
                        }
                        return;
                    }
                    throw InvalidProtocolBufferException.e();
                }
                do {
                    longArrayList.v0(b());
                    if (R()) {
                        return;
                    }
                    i9 = this.f17168c;
                } while (c0() == this.f17171f);
                this.f17168c = i9;
                return;
            }
            int b9 = WireFormat.b(this.f17171f);
            if (b9 != 1) {
                if (b9 == 2) {
                    int c03 = c0();
                    n0(c03);
                    int i11 = this.f17168c + c03;
                    while (this.f17168c < i11) {
                        list.add(Long.valueOf(Y()));
                    }
                    return;
                }
                throw InvalidProtocolBufferException.e();
            }
            do {
                list.add(Long.valueOf(b()));
                if (R()) {
                    return;
                }
                i8 = this.f17168c;
            } while (c0() == this.f17171f);
            this.f17168c = i8;
        }

        @Override // com.google.protobuf.Reader
        public void r(List<Integer> list) throws IOException {
            int i8;
            int i9;
            if (list instanceof IntArrayList) {
                IntArrayList intArrayList = (IntArrayList) list;
                int b8 = WireFormat.b(this.f17171f);
                if (b8 != 0) {
                    if (b8 == 2) {
                        int c02 = this.f17168c + c0();
                        while (this.f17168c < c02) {
                            intArrayList.s0(CodedInputStream.c(c0()));
                        }
                        return;
                    }
                    throw InvalidProtocolBufferException.e();
                }
                do {
                    intArrayList.s0(l());
                    if (R()) {
                        return;
                    }
                    i9 = this.f17168c;
                } while (c0() == this.f17171f);
                this.f17168c = i9;
                return;
            }
            int b9 = WireFormat.b(this.f17171f);
            if (b9 != 0) {
                if (b9 == 2) {
                    int c03 = this.f17168c + c0();
                    while (this.f17168c < c03) {
                        list.add(Integer.valueOf(CodedInputStream.c(c0())));
                    }
                    return;
                }
                throw InvalidProtocolBufferException.e();
            }
            do {
                list.add(Integer.valueOf(l()));
                if (R()) {
                    return;
                }
                i8 = this.f17168c;
            } while (c0() == this.f17171f);
            this.f17168c = i8;
        }

        @Override // com.google.protobuf.Reader
        public double readDouble() throws IOException {
            h0(1);
            return Double.longBitsToDouble(X());
        }

        @Override // com.google.protobuf.Reader
        public float readFloat() throws IOException {
            h0(5);
            return Float.intBitsToFloat(V());
        }

        @Override // com.google.protobuf.Reader
        public long s() throws IOException {
            h0(0);
            return d0();
        }

        @Override // com.google.protobuf.Reader
        public void t(List<Integer> list) throws IOException {
            int i8;
            int i9;
            if (list instanceof IntArrayList) {
                IntArrayList intArrayList = (IntArrayList) list;
                int b8 = WireFormat.b(this.f17171f);
                if (b8 != 0) {
                    if (b8 == 2) {
                        int c02 = this.f17168c + c0();
                        while (this.f17168c < c02) {
                            intArrayList.s0(c0());
                        }
                        return;
                    }
                    throw InvalidProtocolBufferException.e();
                }
                do {
                    intArrayList.s0(h());
                    if (R()) {
                        return;
                    }
                    i9 = this.f17168c;
                } while (c0() == this.f17171f);
                this.f17168c = i9;
                return;
            }
            int b9 = WireFormat.b(this.f17171f);
            if (b9 != 0) {
                if (b9 == 2) {
                    int c03 = this.f17168c + c0();
                    while (this.f17168c < c03) {
                        list.add(Integer.valueOf(c0()));
                    }
                    return;
                }
                throw InvalidProtocolBufferException.e();
            }
            do {
                list.add(Integer.valueOf(h()));
                if (R()) {
                    return;
                }
                i8 = this.f17168c;
            } while (c0() == this.f17171f);
            this.f17168c = i8;
        }

        @Override // com.google.protobuf.Reader
        public int u() throws IOException {
            h0(5);
            return V();
        }

        @Override // com.google.protobuf.Reader
        public void v(List<Long> list) throws IOException {
            int i8;
            int i9;
            if (list instanceof LongArrayList) {
                LongArrayList longArrayList = (LongArrayList) list;
                int b8 = WireFormat.b(this.f17171f);
                if (b8 != 1) {
                    if (b8 == 2) {
                        int c02 = c0();
                        n0(c02);
                        int i10 = this.f17168c + c02;
                        while (this.f17168c < i10) {
                            longArrayList.v0(Y());
                        }
                        return;
                    }
                    throw InvalidProtocolBufferException.e();
                }
                do {
                    longArrayList.v0(f());
                    if (R()) {
                        return;
                    }
                    i9 = this.f17168c;
                } while (c0() == this.f17171f);
                this.f17168c = i9;
                return;
            }
            int b9 = WireFormat.b(this.f17171f);
            if (b9 != 1) {
                if (b9 == 2) {
                    int c03 = c0();
                    n0(c03);
                    int i11 = this.f17168c + c03;
                    while (this.f17168c < i11) {
                        list.add(Long.valueOf(Y()));
                    }
                    return;
                }
                throw InvalidProtocolBufferException.e();
            }
            do {
                list.add(Long.valueOf(f()));
                if (R()) {
                    return;
                }
                i8 = this.f17168c;
            } while (c0() == this.f17171f);
            this.f17168c = i8;
        }

        @Override // com.google.protobuf.Reader
        public void w(List<Integer> list) throws IOException {
            int i8;
            int i9;
            if (list instanceof IntArrayList) {
                IntArrayList intArrayList = (IntArrayList) list;
                int b8 = WireFormat.b(this.f17171f);
                if (b8 != 0) {
                    if (b8 == 2) {
                        int c02 = this.f17168c + c0();
                        while (this.f17168c < c02) {
                            intArrayList.s0(c0());
                        }
                        g0(c02);
                        return;
                    }
                    throw InvalidProtocolBufferException.e();
                }
                do {
                    intArrayList.s0(p());
                    if (R()) {
                        return;
                    }
                    i9 = this.f17168c;
                } while (c0() == this.f17171f);
                this.f17168c = i9;
                return;
            }
            int b9 = WireFormat.b(this.f17171f);
            if (b9 != 0) {
                if (b9 == 2) {
                    int c03 = this.f17168c + c0();
                    while (this.f17168c < c03) {
                        list.add(Integer.valueOf(c0()));
                    }
                    g0(c03);
                    return;
                }
                throw InvalidProtocolBufferException.e();
            }
            do {
                list.add(Integer.valueOf(p()));
                if (R()) {
                    return;
                }
                i8 = this.f17168c;
            } while (c0() == this.f17171f);
            this.f17168c = i8;
        }

        @Override // com.google.protobuf.Reader
        public void x(List<Integer> list) throws IOException {
            int i8;
            int i9;
            if (list instanceof IntArrayList) {
                IntArrayList intArrayList = (IntArrayList) list;
                int b8 = WireFormat.b(this.f17171f);
                if (b8 != 2) {
                    if (b8 == 5) {
                        do {
                            intArrayList.s0(u());
                            if (R()) {
                                return;
                            }
                            i9 = this.f17168c;
                        } while (c0() == this.f17171f);
                        this.f17168c = i9;
                        return;
                    }
                    throw InvalidProtocolBufferException.e();
                }
                int c02 = c0();
                m0(c02);
                int i10 = this.f17168c + c02;
                while (this.f17168c < i10) {
                    intArrayList.s0(W());
                }
                return;
            }
            int b9 = WireFormat.b(this.f17171f);
            if (b9 != 2) {
                if (b9 == 5) {
                    do {
                        list.add(Integer.valueOf(u()));
                        if (R()) {
                            return;
                        }
                        i8 = this.f17168c;
                    } while (c0() == this.f17171f);
                    this.f17168c = i8;
                    return;
                }
                throw InvalidProtocolBufferException.e();
            }
            int c03 = c0();
            m0(c03);
            int i11 = this.f17168c + c03;
            while (this.f17168c < i11) {
                list.add(Integer.valueOf(W()));
            }
        }

        @Override // com.google.protobuf.Reader
        public long y() throws IOException {
            h0(0);
            return CodedInputStream.d(d0());
        }

        @Override // com.google.protobuf.Reader
        public String z() throws IOException {
            return a0(false);
        }
    }

    private BinaryReader() {
    }

    /* synthetic */ BinaryReader(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static BinaryReader Q(ByteBuffer byteBuffer, boolean z7) {
        if (byteBuffer.hasArray()) {
            return new SafeHeapReader(byteBuffer, z7);
        }
        throw new IllegalArgumentException("Direct buffers not yet supported");
    }
}
