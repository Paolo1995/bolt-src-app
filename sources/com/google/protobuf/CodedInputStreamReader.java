package com.google.protobuf;

import com.google.android.gms.common.api.Api;
import com.google.protobuf.WireFormat;
import java.io.IOException;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class CodedInputStreamReader implements Reader {

    /* renamed from: a  reason: collision with root package name */
    private final CodedInputStream f17239a;

    /* renamed from: b  reason: collision with root package name */
    private int f17240b;

    /* renamed from: c  reason: collision with root package name */
    private int f17241c;

    /* renamed from: d  reason: collision with root package name */
    private int f17242d = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.google.protobuf.CodedInputStreamReader$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f17243a;

        static {
            int[] iArr = new int[WireFormat.FieldType.values().length];
            f17243a = iArr;
            try {
                iArr[WireFormat.FieldType.f17679o.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f17243a[WireFormat.FieldType.f17683s.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f17243a[WireFormat.FieldType.f17672h.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f17243a[WireFormat.FieldType.f17685u.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f17243a[WireFormat.FieldType.f17678n.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f17243a[WireFormat.FieldType.f17677m.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f17243a[WireFormat.FieldType.f17673i.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f17243a[WireFormat.FieldType.f17676l.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f17243a[WireFormat.FieldType.f17674j.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f17243a[WireFormat.FieldType.f17682r.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f17243a[WireFormat.FieldType.f17686v.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f17243a[WireFormat.FieldType.f17687w.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f17243a[WireFormat.FieldType.f17688x.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f17243a[WireFormat.FieldType.f17689y.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f17243a[WireFormat.FieldType.f17680p.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f17243a[WireFormat.FieldType.f17684t.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f17243a[WireFormat.FieldType.f17675k.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
        }
    }

    private CodedInputStreamReader(CodedInputStream codedInputStream) {
        CodedInputStream codedInputStream2 = (CodedInputStream) Internal.b(codedInputStream, "input");
        this.f17239a = codedInputStream2;
        codedInputStream2.f17194d = this;
    }

    public static CodedInputStreamReader Q(CodedInputStream codedInputStream) {
        CodedInputStreamReader codedInputStreamReader = codedInputStream.f17194d;
        if (codedInputStreamReader != null) {
            return codedInputStreamReader;
        }
        return new CodedInputStreamReader(codedInputStream);
    }

    private Object R(WireFormat.FieldType fieldType, Class<?> cls, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        switch (AnonymousClass1.f17243a[fieldType.ordinal()]) {
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
                throw new IllegalArgumentException("unsupported field type.");
        }
    }

    private <T> T S(Schema<T> schema, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        int i8 = this.f17241c;
        this.f17241c = WireFormat.c(WireFormat.a(this.f17240b), 4);
        try {
            T e8 = schema.e();
            schema.g(e8, this, extensionRegistryLite);
            schema.b(e8);
            if (this.f17240b == this.f17241c) {
                return e8;
            }
            throw InvalidProtocolBufferException.h();
        } finally {
            this.f17241c = i8;
        }
    }

    private <T> T T(Schema<T> schema, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        CodedInputStream codedInputStream;
        int L = this.f17239a.L();
        CodedInputStream codedInputStream2 = this.f17239a;
        if (codedInputStream2.f17191a < codedInputStream2.f17192b) {
            int q8 = codedInputStream2.q(L);
            T e8 = schema.e();
            this.f17239a.f17191a++;
            schema.g(e8, this, extensionRegistryLite);
            schema.b(e8);
            this.f17239a.a(0);
            codedInputStream.f17191a--;
            this.f17239a.p(q8);
            return e8;
        }
        throw InvalidProtocolBufferException.i();
    }

    private void V(int i8) throws IOException {
        if (this.f17239a.f() == i8) {
            return;
        }
        throw InvalidProtocolBufferException.m();
    }

    private void W(int i8) throws IOException {
        if (WireFormat.b(this.f17240b) == i8) {
            return;
        }
        throw InvalidProtocolBufferException.e();
    }

    private void X(int i8) throws IOException {
        if ((i8 & 3) == 0) {
            return;
        }
        throw InvalidProtocolBufferException.h();
    }

    private void Y(int i8) throws IOException {
        if ((i8 & 7) == 0) {
            return;
        }
        throw InvalidProtocolBufferException.h();
    }

    @Override // com.google.protobuf.Reader
    public int A() throws IOException {
        int i8 = this.f17242d;
        if (i8 != 0) {
            this.f17240b = i8;
            this.f17242d = 0;
        } else {
            this.f17240b = this.f17239a.K();
        }
        int i9 = this.f17240b;
        if (i9 != 0 && i9 != this.f17241c) {
            return WireFormat.a(i9);
        }
        return Api.BaseClientBuilder.API_PRIORITY_OTHER;
    }

    @Override // com.google.protobuf.Reader
    public void B(List<String> list) throws IOException {
        U(list, false);
    }

    @Override // com.google.protobuf.Reader
    public void C(List<Float> list) throws IOException {
        int K;
        int K2;
        if (list instanceof FloatArrayList) {
            FloatArrayList floatArrayList = (FloatArrayList) list;
            int b8 = WireFormat.b(this.f17240b);
            if (b8 != 2) {
                if (b8 == 5) {
                    do {
                        floatArrayList.g(this.f17239a.x());
                        if (this.f17239a.g()) {
                            return;
                        }
                        K2 = this.f17239a.K();
                    } while (K2 == this.f17240b);
                    this.f17242d = K2;
                    return;
                }
                throw InvalidProtocolBufferException.e();
            }
            int L = this.f17239a.L();
            X(L);
            int f8 = this.f17239a.f() + L;
            do {
                floatArrayList.g(this.f17239a.x());
            } while (this.f17239a.f() < f8);
            return;
        }
        int b9 = WireFormat.b(this.f17240b);
        if (b9 != 2) {
            if (b9 == 5) {
                do {
                    list.add(Float.valueOf(this.f17239a.x()));
                    if (this.f17239a.g()) {
                        return;
                    }
                    K = this.f17239a.K();
                } while (K == this.f17240b);
                this.f17242d = K;
                return;
            }
            throw InvalidProtocolBufferException.e();
        }
        int L2 = this.f17239a.L();
        X(L2);
        int f9 = this.f17239a.f() + L2;
        do {
            list.add(Float.valueOf(this.f17239a.x()));
        } while (this.f17239a.f() < f9);
    }

    @Override // com.google.protobuf.Reader
    public boolean D() throws IOException {
        int i8;
        if (!this.f17239a.g() && (i8 = this.f17240b) != this.f17241c) {
            return this.f17239a.N(i8);
        }
        return false;
    }

    @Override // com.google.protobuf.Reader
    public int E() throws IOException {
        W(5);
        return this.f17239a.E();
    }

    @Override // com.google.protobuf.Reader
    public void F(List<ByteString> list) throws IOException {
        int K;
        if (WireFormat.b(this.f17240b) == 2) {
            do {
                list.add(o());
                if (this.f17239a.g()) {
                    return;
                }
                K = this.f17239a.K();
            } while (K == this.f17240b);
            this.f17242d = K;
            return;
        }
        throw InvalidProtocolBufferException.e();
    }

    @Override // com.google.protobuf.Reader
    public void G(List<Double> list) throws IOException {
        int K;
        int K2;
        if (list instanceof DoubleArrayList) {
            DoubleArrayList doubleArrayList = (DoubleArrayList) list;
            int b8 = WireFormat.b(this.f17240b);
            if (b8 != 1) {
                if (b8 == 2) {
                    int L = this.f17239a.L();
                    Y(L);
                    int f8 = this.f17239a.f() + L;
                    do {
                        doubleArrayList.K0(this.f17239a.t());
                    } while (this.f17239a.f() < f8);
                    return;
                }
                throw InvalidProtocolBufferException.e();
            }
            do {
                doubleArrayList.K0(this.f17239a.t());
                if (this.f17239a.g()) {
                    return;
                }
                K2 = this.f17239a.K();
            } while (K2 == this.f17240b);
            this.f17242d = K2;
            return;
        }
        int b9 = WireFormat.b(this.f17240b);
        if (b9 != 1) {
            if (b9 == 2) {
                int L2 = this.f17239a.L();
                Y(L2);
                int f9 = this.f17239a.f() + L2;
                do {
                    list.add(Double.valueOf(this.f17239a.t()));
                } while (this.f17239a.f() < f9);
                return;
            }
            throw InvalidProtocolBufferException.e();
        }
        do {
            list.add(Double.valueOf(this.f17239a.t()));
            if (this.f17239a.g()) {
                return;
            }
            K = this.f17239a.K();
        } while (K == this.f17240b);
        this.f17242d = K;
    }

    @Override // com.google.protobuf.Reader
    public long H() throws IOException {
        W(0);
        return this.f17239a.A();
    }

    @Override // com.google.protobuf.Reader
    public String I() throws IOException {
        W(2);
        return this.f17239a.J();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.protobuf.Reader
    @Deprecated
    public <T> void J(List<T> list, Schema<T> schema, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        int K;
        if (WireFormat.b(this.f17240b) == 3) {
            int i8 = this.f17240b;
            do {
                list.add(S(schema, extensionRegistryLite));
                if (!this.f17239a.g() && this.f17242d == 0) {
                    K = this.f17239a.K();
                } else {
                    return;
                }
            } while (K == i8);
            this.f17242d = K;
            return;
        }
        throw InvalidProtocolBufferException.e();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.protobuf.Reader
    public <T> void K(List<T> list, Schema<T> schema, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        int K;
        if (WireFormat.b(this.f17240b) == 2) {
            int i8 = this.f17240b;
            do {
                list.add(T(schema, extensionRegistryLite));
                if (!this.f17239a.g() && this.f17242d == 0) {
                    K = this.f17239a.K();
                } else {
                    return;
                }
            } while (K == i8);
            this.f17242d = K;
            return;
        }
        throw InvalidProtocolBufferException.e();
    }

    @Override // com.google.protobuf.Reader
    @Deprecated
    public <T> T L(Class<T> cls, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        W(3);
        return (T) S(Protobuf.a().d(cls), extensionRegistryLite);
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x005c, code lost:
        r8.put(r2, r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0064, code lost:
        return;
     */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.protobuf.Reader
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public <K, V> void M(java.util.Map<K, V> r8, com.google.protobuf.MapEntryLite.Metadata<K, V> r9, com.google.protobuf.ExtensionRegistryLite r10) throws java.io.IOException {
        /*
            r7 = this;
            r0 = 2
            r7.W(r0)
            com.google.protobuf.CodedInputStream r1 = r7.f17239a
            int r1 = r1.L()
            com.google.protobuf.CodedInputStream r2 = r7.f17239a
            int r1 = r2.q(r1)
            K r2 = r9.f17507b
            V r3 = r9.f17509d
        L14:
            int r4 = r7.A()     // Catch: java.lang.Throwable -> L65
            r5 = 2147483647(0x7fffffff, float:NaN)
            if (r4 == r5) goto L5c
            com.google.protobuf.CodedInputStream r5 = r7.f17239a     // Catch: java.lang.Throwable -> L65
            boolean r5 = r5.g()     // Catch: java.lang.Throwable -> L65
            if (r5 == 0) goto L26
            goto L5c
        L26:
            r5 = 1
            java.lang.String r6 = "Unable to parse map entry."
            if (r4 == r5) goto L47
            if (r4 == r0) goto L3a
            boolean r4 = r7.D()     // Catch: com.google.protobuf.InvalidProtocolBufferException.InvalidWireTypeException -> L4f java.lang.Throwable -> L65
            if (r4 == 0) goto L34
            goto L14
        L34:
            com.google.protobuf.InvalidProtocolBufferException r4 = new com.google.protobuf.InvalidProtocolBufferException     // Catch: com.google.protobuf.InvalidProtocolBufferException.InvalidWireTypeException -> L4f java.lang.Throwable -> L65
            r4.<init>(r6)     // Catch: com.google.protobuf.InvalidProtocolBufferException.InvalidWireTypeException -> L4f java.lang.Throwable -> L65
            throw r4     // Catch: com.google.protobuf.InvalidProtocolBufferException.InvalidWireTypeException -> L4f java.lang.Throwable -> L65
        L3a:
            com.google.protobuf.WireFormat$FieldType r4 = r9.f17508c     // Catch: com.google.protobuf.InvalidProtocolBufferException.InvalidWireTypeException -> L4f java.lang.Throwable -> L65
            V r5 = r9.f17509d     // Catch: com.google.protobuf.InvalidProtocolBufferException.InvalidWireTypeException -> L4f java.lang.Throwable -> L65
            java.lang.Class r5 = r5.getClass()     // Catch: com.google.protobuf.InvalidProtocolBufferException.InvalidWireTypeException -> L4f java.lang.Throwable -> L65
            java.lang.Object r3 = r7.R(r4, r5, r10)     // Catch: com.google.protobuf.InvalidProtocolBufferException.InvalidWireTypeException -> L4f java.lang.Throwable -> L65
            goto L14
        L47:
            com.google.protobuf.WireFormat$FieldType r4 = r9.f17506a     // Catch: com.google.protobuf.InvalidProtocolBufferException.InvalidWireTypeException -> L4f java.lang.Throwable -> L65
            r5 = 0
            java.lang.Object r2 = r7.R(r4, r5, r5)     // Catch: com.google.protobuf.InvalidProtocolBufferException.InvalidWireTypeException -> L4f java.lang.Throwable -> L65
            goto L14
        L4f:
            boolean r4 = r7.D()     // Catch: java.lang.Throwable -> L65
            if (r4 == 0) goto L56
            goto L14
        L56:
            com.google.protobuf.InvalidProtocolBufferException r8 = new com.google.protobuf.InvalidProtocolBufferException     // Catch: java.lang.Throwable -> L65
            r8.<init>(r6)     // Catch: java.lang.Throwable -> L65
            throw r8     // Catch: java.lang.Throwable -> L65
        L5c:
            r8.put(r2, r3)     // Catch: java.lang.Throwable -> L65
            com.google.protobuf.CodedInputStream r8 = r7.f17239a
            r8.p(r1)
            return
        L65:
            r8 = move-exception
            com.google.protobuf.CodedInputStream r9 = r7.f17239a
            r9.p(r1)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.CodedInputStreamReader.M(java.util.Map, com.google.protobuf.MapEntryLite$Metadata, com.google.protobuf.ExtensionRegistryLite):void");
    }

    @Override // com.google.protobuf.Reader
    public <T> T N(Class<T> cls, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        W(2);
        return (T) T(Protobuf.a().d(cls), extensionRegistryLite);
    }

    @Override // com.google.protobuf.Reader
    @Deprecated
    public <T> T O(Schema<T> schema, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        W(3);
        return (T) S(schema, extensionRegistryLite);
    }

    @Override // com.google.protobuf.Reader
    public <T> T P(Schema<T> schema, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        W(2);
        return (T) T(schema, extensionRegistryLite);
    }

    public void U(List<String> list, boolean z7) throws IOException {
        String z8;
        int K;
        int K2;
        if (WireFormat.b(this.f17240b) == 2) {
            if ((list instanceof LazyStringList) && !z7) {
                LazyStringList lazyStringList = (LazyStringList) list;
                do {
                    lazyStringList.t(o());
                    if (this.f17239a.g()) {
                        return;
                    }
                    K2 = this.f17239a.K();
                } while (K2 == this.f17240b);
                this.f17242d = K2;
                return;
            }
            do {
                if (z7) {
                    z8 = I();
                } else {
                    z8 = z();
                }
                list.add(z8);
                if (this.f17239a.g()) {
                    return;
                }
                K = this.f17239a.K();
            } while (K == this.f17240b);
            this.f17242d = K;
            return;
        }
        throw InvalidProtocolBufferException.e();
    }

    @Override // com.google.protobuf.Reader
    public int a() {
        return this.f17240b;
    }

    @Override // com.google.protobuf.Reader
    public long b() throws IOException {
        W(1);
        return this.f17239a.w();
    }

    @Override // com.google.protobuf.Reader
    public void c(List<Integer> list) throws IOException {
        int K;
        int K2;
        if (list instanceof IntArrayList) {
            IntArrayList intArrayList = (IntArrayList) list;
            int b8 = WireFormat.b(this.f17240b);
            if (b8 != 2) {
                if (b8 == 5) {
                    do {
                        intArrayList.s0(this.f17239a.E());
                        if (this.f17239a.g()) {
                            return;
                        }
                        K2 = this.f17239a.K();
                    } while (K2 == this.f17240b);
                    this.f17242d = K2;
                    return;
                }
                throw InvalidProtocolBufferException.e();
            }
            int L = this.f17239a.L();
            X(L);
            int f8 = this.f17239a.f() + L;
            do {
                intArrayList.s0(this.f17239a.E());
            } while (this.f17239a.f() < f8);
            return;
        }
        int b9 = WireFormat.b(this.f17240b);
        if (b9 != 2) {
            if (b9 == 5) {
                do {
                    list.add(Integer.valueOf(this.f17239a.E()));
                    if (this.f17239a.g()) {
                        return;
                    }
                    K = this.f17239a.K();
                } while (K == this.f17240b);
                this.f17242d = K;
                return;
            }
            throw InvalidProtocolBufferException.e();
        }
        int L2 = this.f17239a.L();
        X(L2);
        int f9 = this.f17239a.f() + L2;
        do {
            list.add(Integer.valueOf(this.f17239a.E()));
        } while (this.f17239a.f() < f9);
    }

    @Override // com.google.protobuf.Reader
    public void d(List<Long> list) throws IOException {
        int K;
        int K2;
        if (list instanceof LongArrayList) {
            LongArrayList longArrayList = (LongArrayList) list;
            int b8 = WireFormat.b(this.f17240b);
            if (b8 != 0) {
                if (b8 == 2) {
                    int f8 = this.f17239a.f() + this.f17239a.L();
                    do {
                        longArrayList.v0(this.f17239a.H());
                    } while (this.f17239a.f() < f8);
                    V(f8);
                    return;
                }
                throw InvalidProtocolBufferException.e();
            }
            do {
                longArrayList.v0(this.f17239a.H());
                if (this.f17239a.g()) {
                    return;
                }
                K2 = this.f17239a.K();
            } while (K2 == this.f17240b);
            this.f17242d = K2;
            return;
        }
        int b9 = WireFormat.b(this.f17240b);
        if (b9 != 0) {
            if (b9 == 2) {
                int f9 = this.f17239a.f() + this.f17239a.L();
                do {
                    list.add(Long.valueOf(this.f17239a.H()));
                } while (this.f17239a.f() < f9);
                V(f9);
                return;
            }
            throw InvalidProtocolBufferException.e();
        }
        do {
            list.add(Long.valueOf(this.f17239a.H()));
            if (this.f17239a.g()) {
                return;
            }
            K = this.f17239a.K();
        } while (K == this.f17240b);
        this.f17242d = K;
    }

    @Override // com.google.protobuf.Reader
    public boolean e() throws IOException {
        W(0);
        return this.f17239a.r();
    }

    @Override // com.google.protobuf.Reader
    public long f() throws IOException {
        W(1);
        return this.f17239a.F();
    }

    @Override // com.google.protobuf.Reader
    public void g(List<Long> list) throws IOException {
        int K;
        int K2;
        if (list instanceof LongArrayList) {
            LongArrayList longArrayList = (LongArrayList) list;
            int b8 = WireFormat.b(this.f17240b);
            if (b8 != 0) {
                if (b8 == 2) {
                    int f8 = this.f17239a.f() + this.f17239a.L();
                    do {
                        longArrayList.v0(this.f17239a.M());
                    } while (this.f17239a.f() < f8);
                    V(f8);
                    return;
                }
                throw InvalidProtocolBufferException.e();
            }
            do {
                longArrayList.v0(this.f17239a.M());
                if (this.f17239a.g()) {
                    return;
                }
                K2 = this.f17239a.K();
            } while (K2 == this.f17240b);
            this.f17242d = K2;
            return;
        }
        int b9 = WireFormat.b(this.f17240b);
        if (b9 != 0) {
            if (b9 == 2) {
                int f9 = this.f17239a.f() + this.f17239a.L();
                do {
                    list.add(Long.valueOf(this.f17239a.M()));
                } while (this.f17239a.f() < f9);
                V(f9);
                return;
            }
            throw InvalidProtocolBufferException.e();
        }
        do {
            list.add(Long.valueOf(this.f17239a.M()));
            if (this.f17239a.g()) {
                return;
            }
            K = this.f17239a.K();
        } while (K == this.f17240b);
        this.f17242d = K;
    }

    @Override // com.google.protobuf.Reader
    public int h() throws IOException {
        W(0);
        return this.f17239a.L();
    }

    @Override // com.google.protobuf.Reader
    public void i(List<Long> list) throws IOException {
        int K;
        int K2;
        if (list instanceof LongArrayList) {
            LongArrayList longArrayList = (LongArrayList) list;
            int b8 = WireFormat.b(this.f17240b);
            if (b8 != 0) {
                if (b8 == 2) {
                    int f8 = this.f17239a.f() + this.f17239a.L();
                    do {
                        longArrayList.v0(this.f17239a.A());
                    } while (this.f17239a.f() < f8);
                    V(f8);
                    return;
                }
                throw InvalidProtocolBufferException.e();
            }
            do {
                longArrayList.v0(this.f17239a.A());
                if (this.f17239a.g()) {
                    return;
                }
                K2 = this.f17239a.K();
            } while (K2 == this.f17240b);
            this.f17242d = K2;
            return;
        }
        int b9 = WireFormat.b(this.f17240b);
        if (b9 != 0) {
            if (b9 == 2) {
                int f9 = this.f17239a.f() + this.f17239a.L();
                do {
                    list.add(Long.valueOf(this.f17239a.A()));
                } while (this.f17239a.f() < f9);
                V(f9);
                return;
            }
            throw InvalidProtocolBufferException.e();
        }
        do {
            list.add(Long.valueOf(this.f17239a.A()));
            if (this.f17239a.g()) {
                return;
            }
            K = this.f17239a.K();
        } while (K == this.f17240b);
        this.f17242d = K;
    }

    @Override // com.google.protobuf.Reader
    public void j(List<Integer> list) throws IOException {
        int K;
        int K2;
        if (list instanceof IntArrayList) {
            IntArrayList intArrayList = (IntArrayList) list;
            int b8 = WireFormat.b(this.f17240b);
            if (b8 != 0) {
                if (b8 == 2) {
                    int f8 = this.f17239a.f() + this.f17239a.L();
                    do {
                        intArrayList.s0(this.f17239a.u());
                    } while (this.f17239a.f() < f8);
                    V(f8);
                    return;
                }
                throw InvalidProtocolBufferException.e();
            }
            do {
                intArrayList.s0(this.f17239a.u());
                if (this.f17239a.g()) {
                    return;
                }
                K2 = this.f17239a.K();
            } while (K2 == this.f17240b);
            this.f17242d = K2;
            return;
        }
        int b9 = WireFormat.b(this.f17240b);
        if (b9 != 0) {
            if (b9 == 2) {
                int f9 = this.f17239a.f() + this.f17239a.L();
                do {
                    list.add(Integer.valueOf(this.f17239a.u()));
                } while (this.f17239a.f() < f9);
                V(f9);
                return;
            }
            throw InvalidProtocolBufferException.e();
        }
        do {
            list.add(Integer.valueOf(this.f17239a.u()));
            if (this.f17239a.g()) {
                return;
            }
            K = this.f17239a.K();
        } while (K == this.f17240b);
        this.f17242d = K;
    }

    @Override // com.google.protobuf.Reader
    public int k() throws IOException {
        W(0);
        return this.f17239a.u();
    }

    @Override // com.google.protobuf.Reader
    public int l() throws IOException {
        W(0);
        return this.f17239a.G();
    }

    @Override // com.google.protobuf.Reader
    public void m(List<Boolean> list) throws IOException {
        int K;
        int K2;
        if (list instanceof BooleanArrayList) {
            BooleanArrayList booleanArrayList = (BooleanArrayList) list;
            int b8 = WireFormat.b(this.f17240b);
            if (b8 != 0) {
                if (b8 == 2) {
                    int f8 = this.f17239a.f() + this.f17239a.L();
                    do {
                        booleanArrayList.i(this.f17239a.r());
                    } while (this.f17239a.f() < f8);
                    V(f8);
                    return;
                }
                throw InvalidProtocolBufferException.e();
            }
            do {
                booleanArrayList.i(this.f17239a.r());
                if (this.f17239a.g()) {
                    return;
                }
                K2 = this.f17239a.K();
            } while (K2 == this.f17240b);
            this.f17242d = K2;
            return;
        }
        int b9 = WireFormat.b(this.f17240b);
        if (b9 != 0) {
            if (b9 == 2) {
                int f9 = this.f17239a.f() + this.f17239a.L();
                do {
                    list.add(Boolean.valueOf(this.f17239a.r()));
                } while (this.f17239a.f() < f9);
                V(f9);
                return;
            }
            throw InvalidProtocolBufferException.e();
        }
        do {
            list.add(Boolean.valueOf(this.f17239a.r()));
            if (this.f17239a.g()) {
                return;
            }
            K = this.f17239a.K();
        } while (K == this.f17240b);
        this.f17242d = K;
    }

    @Override // com.google.protobuf.Reader
    public void n(List<String> list) throws IOException {
        U(list, true);
    }

    @Override // com.google.protobuf.Reader
    public ByteString o() throws IOException {
        W(2);
        return this.f17239a.s();
    }

    @Override // com.google.protobuf.Reader
    public int p() throws IOException {
        W(0);
        return this.f17239a.z();
    }

    @Override // com.google.protobuf.Reader
    public void q(List<Long> list) throws IOException {
        int K;
        int K2;
        if (list instanceof LongArrayList) {
            LongArrayList longArrayList = (LongArrayList) list;
            int b8 = WireFormat.b(this.f17240b);
            if (b8 != 1) {
                if (b8 == 2) {
                    int L = this.f17239a.L();
                    Y(L);
                    int f8 = this.f17239a.f() + L;
                    do {
                        longArrayList.v0(this.f17239a.w());
                    } while (this.f17239a.f() < f8);
                    return;
                }
                throw InvalidProtocolBufferException.e();
            }
            do {
                longArrayList.v0(this.f17239a.w());
                if (this.f17239a.g()) {
                    return;
                }
                K2 = this.f17239a.K();
            } while (K2 == this.f17240b);
            this.f17242d = K2;
            return;
        }
        int b9 = WireFormat.b(this.f17240b);
        if (b9 != 1) {
            if (b9 == 2) {
                int L2 = this.f17239a.L();
                Y(L2);
                int f9 = this.f17239a.f() + L2;
                do {
                    list.add(Long.valueOf(this.f17239a.w()));
                } while (this.f17239a.f() < f9);
                return;
            }
            throw InvalidProtocolBufferException.e();
        }
        do {
            list.add(Long.valueOf(this.f17239a.w()));
            if (this.f17239a.g()) {
                return;
            }
            K = this.f17239a.K();
        } while (K == this.f17240b);
        this.f17242d = K;
    }

    @Override // com.google.protobuf.Reader
    public void r(List<Integer> list) throws IOException {
        int K;
        int K2;
        if (list instanceof IntArrayList) {
            IntArrayList intArrayList = (IntArrayList) list;
            int b8 = WireFormat.b(this.f17240b);
            if (b8 != 0) {
                if (b8 == 2) {
                    int f8 = this.f17239a.f() + this.f17239a.L();
                    do {
                        intArrayList.s0(this.f17239a.G());
                    } while (this.f17239a.f() < f8);
                    V(f8);
                    return;
                }
                throw InvalidProtocolBufferException.e();
            }
            do {
                intArrayList.s0(this.f17239a.G());
                if (this.f17239a.g()) {
                    return;
                }
                K2 = this.f17239a.K();
            } while (K2 == this.f17240b);
            this.f17242d = K2;
            return;
        }
        int b9 = WireFormat.b(this.f17240b);
        if (b9 != 0) {
            if (b9 == 2) {
                int f9 = this.f17239a.f() + this.f17239a.L();
                do {
                    list.add(Integer.valueOf(this.f17239a.G()));
                } while (this.f17239a.f() < f9);
                V(f9);
                return;
            }
            throw InvalidProtocolBufferException.e();
        }
        do {
            list.add(Integer.valueOf(this.f17239a.G()));
            if (this.f17239a.g()) {
                return;
            }
            K = this.f17239a.K();
        } while (K == this.f17240b);
        this.f17242d = K;
    }

    @Override // com.google.protobuf.Reader
    public double readDouble() throws IOException {
        W(1);
        return this.f17239a.t();
    }

    @Override // com.google.protobuf.Reader
    public float readFloat() throws IOException {
        W(5);
        return this.f17239a.x();
    }

    @Override // com.google.protobuf.Reader
    public long s() throws IOException {
        W(0);
        return this.f17239a.M();
    }

    @Override // com.google.protobuf.Reader
    public void t(List<Integer> list) throws IOException {
        int K;
        int K2;
        if (list instanceof IntArrayList) {
            IntArrayList intArrayList = (IntArrayList) list;
            int b8 = WireFormat.b(this.f17240b);
            if (b8 != 0) {
                if (b8 == 2) {
                    int f8 = this.f17239a.f() + this.f17239a.L();
                    do {
                        intArrayList.s0(this.f17239a.L());
                    } while (this.f17239a.f() < f8);
                    V(f8);
                    return;
                }
                throw InvalidProtocolBufferException.e();
            }
            do {
                intArrayList.s0(this.f17239a.L());
                if (this.f17239a.g()) {
                    return;
                }
                K2 = this.f17239a.K();
            } while (K2 == this.f17240b);
            this.f17242d = K2;
            return;
        }
        int b9 = WireFormat.b(this.f17240b);
        if (b9 != 0) {
            if (b9 == 2) {
                int f9 = this.f17239a.f() + this.f17239a.L();
                do {
                    list.add(Integer.valueOf(this.f17239a.L()));
                } while (this.f17239a.f() < f9);
                V(f9);
                return;
            }
            throw InvalidProtocolBufferException.e();
        }
        do {
            list.add(Integer.valueOf(this.f17239a.L()));
            if (this.f17239a.g()) {
                return;
            }
            K = this.f17239a.K();
        } while (K == this.f17240b);
        this.f17242d = K;
    }

    @Override // com.google.protobuf.Reader
    public int u() throws IOException {
        W(5);
        return this.f17239a.v();
    }

    @Override // com.google.protobuf.Reader
    public void v(List<Long> list) throws IOException {
        int K;
        int K2;
        if (list instanceof LongArrayList) {
            LongArrayList longArrayList = (LongArrayList) list;
            int b8 = WireFormat.b(this.f17240b);
            if (b8 != 1) {
                if (b8 == 2) {
                    int L = this.f17239a.L();
                    Y(L);
                    int f8 = this.f17239a.f() + L;
                    do {
                        longArrayList.v0(this.f17239a.F());
                    } while (this.f17239a.f() < f8);
                    return;
                }
                throw InvalidProtocolBufferException.e();
            }
            do {
                longArrayList.v0(this.f17239a.F());
                if (this.f17239a.g()) {
                    return;
                }
                K2 = this.f17239a.K();
            } while (K2 == this.f17240b);
            this.f17242d = K2;
            return;
        }
        int b9 = WireFormat.b(this.f17240b);
        if (b9 != 1) {
            if (b9 == 2) {
                int L2 = this.f17239a.L();
                Y(L2);
                int f9 = this.f17239a.f() + L2;
                do {
                    list.add(Long.valueOf(this.f17239a.F()));
                } while (this.f17239a.f() < f9);
                return;
            }
            throw InvalidProtocolBufferException.e();
        }
        do {
            list.add(Long.valueOf(this.f17239a.F()));
            if (this.f17239a.g()) {
                return;
            }
            K = this.f17239a.K();
        } while (K == this.f17240b);
        this.f17242d = K;
    }

    @Override // com.google.protobuf.Reader
    public void w(List<Integer> list) throws IOException {
        int K;
        int K2;
        if (list instanceof IntArrayList) {
            IntArrayList intArrayList = (IntArrayList) list;
            int b8 = WireFormat.b(this.f17240b);
            if (b8 != 0) {
                if (b8 == 2) {
                    int f8 = this.f17239a.f() + this.f17239a.L();
                    do {
                        intArrayList.s0(this.f17239a.z());
                    } while (this.f17239a.f() < f8);
                    V(f8);
                    return;
                }
                throw InvalidProtocolBufferException.e();
            }
            do {
                intArrayList.s0(this.f17239a.z());
                if (this.f17239a.g()) {
                    return;
                }
                K2 = this.f17239a.K();
            } while (K2 == this.f17240b);
            this.f17242d = K2;
            return;
        }
        int b9 = WireFormat.b(this.f17240b);
        if (b9 != 0) {
            if (b9 == 2) {
                int f9 = this.f17239a.f() + this.f17239a.L();
                do {
                    list.add(Integer.valueOf(this.f17239a.z()));
                } while (this.f17239a.f() < f9);
                V(f9);
                return;
            }
            throw InvalidProtocolBufferException.e();
        }
        do {
            list.add(Integer.valueOf(this.f17239a.z()));
            if (this.f17239a.g()) {
                return;
            }
            K = this.f17239a.K();
        } while (K == this.f17240b);
        this.f17242d = K;
    }

    @Override // com.google.protobuf.Reader
    public void x(List<Integer> list) throws IOException {
        int K;
        int K2;
        if (list instanceof IntArrayList) {
            IntArrayList intArrayList = (IntArrayList) list;
            int b8 = WireFormat.b(this.f17240b);
            if (b8 != 2) {
                if (b8 == 5) {
                    do {
                        intArrayList.s0(this.f17239a.v());
                        if (this.f17239a.g()) {
                            return;
                        }
                        K2 = this.f17239a.K();
                    } while (K2 == this.f17240b);
                    this.f17242d = K2;
                    return;
                }
                throw InvalidProtocolBufferException.e();
            }
            int L = this.f17239a.L();
            X(L);
            int f8 = this.f17239a.f() + L;
            do {
                intArrayList.s0(this.f17239a.v());
            } while (this.f17239a.f() < f8);
            return;
        }
        int b9 = WireFormat.b(this.f17240b);
        if (b9 != 2) {
            if (b9 == 5) {
                do {
                    list.add(Integer.valueOf(this.f17239a.v()));
                    if (this.f17239a.g()) {
                        return;
                    }
                    K = this.f17239a.K();
                } while (K == this.f17240b);
                this.f17242d = K;
                return;
            }
            throw InvalidProtocolBufferException.e();
        }
        int L2 = this.f17239a.L();
        X(L2);
        int f9 = this.f17239a.f() + L2;
        do {
            list.add(Integer.valueOf(this.f17239a.v()));
        } while (this.f17239a.f() < f9);
    }

    @Override // com.google.protobuf.Reader
    public long y() throws IOException {
        W(0);
        return this.f17239a.H();
    }

    @Override // com.google.protobuf.Reader
    public String z() throws IOException {
        W(2);
        return this.f17239a.I();
    }
}
