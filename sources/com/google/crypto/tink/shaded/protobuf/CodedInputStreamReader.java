package com.google.crypto.tink.shaded.protobuf;

import com.google.android.gms.common.api.Api;
import com.google.crypto.tink.shaded.protobuf.MapEntryLite;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class CodedInputStreamReader implements Reader {

    /* renamed from: a  reason: collision with root package name */
    private final CodedInputStream f15015a;

    /* renamed from: b  reason: collision with root package name */
    private int f15016b;

    /* renamed from: c  reason: collision with root package name */
    private int f15017c;

    /* renamed from: d  reason: collision with root package name */
    private int f15018d = 0;

    private CodedInputStreamReader(CodedInputStream codedInputStream) {
        CodedInputStream codedInputStream2 = (CodedInputStream) Internal.b(codedInputStream, "input");
        this.f15015a = codedInputStream2;
        codedInputStream2.f15004d = this;
    }

    public static CodedInputStreamReader Q(CodedInputStream codedInputStream) {
        CodedInputStreamReader codedInputStreamReader = codedInputStream.f15004d;
        if (codedInputStreamReader != null) {
            return codedInputStreamReader;
        }
        return new CodedInputStreamReader(codedInputStream);
    }

    private <T> T R(Schema<T> schema, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        int i8 = this.f15017c;
        this.f15017c = WireFormat.c(WireFormat.a(this.f15016b), 4);
        try {
            T e8 = schema.e();
            schema.g(e8, this, extensionRegistryLite);
            schema.b(e8);
            if (this.f15016b == this.f15017c) {
                return e8;
            }
            throw InvalidProtocolBufferException.g();
        } finally {
            this.f15017c = i8;
        }
    }

    private <T> T S(Schema<T> schema, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        CodedInputStream codedInputStream;
        int A = this.f15015a.A();
        CodedInputStream codedInputStream2 = this.f15015a;
        if (codedInputStream2.f15001a < codedInputStream2.f15002b) {
            int j8 = codedInputStream2.j(A);
            T e8 = schema.e();
            this.f15015a.f15001a++;
            schema.g(e8, this, extensionRegistryLite);
            schema.b(e8);
            this.f15015a.a(0);
            codedInputStream.f15001a--;
            this.f15015a.i(j8);
            return e8;
        }
        throw InvalidProtocolBufferException.h();
    }

    private void U(int i8) throws IOException {
        if (this.f15015a.d() == i8) {
            return;
        }
        throw InvalidProtocolBufferException.j();
    }

    private void V(int i8) throws IOException {
        if (WireFormat.b(this.f15016b) == i8) {
            return;
        }
        throw InvalidProtocolBufferException.d();
    }

    private void W(int i8) throws IOException {
        if ((i8 & 3) == 0) {
            return;
        }
        throw InvalidProtocolBufferException.g();
    }

    private void X(int i8) throws IOException {
        if ((i8 & 7) == 0) {
            return;
        }
        throw InvalidProtocolBufferException.g();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public int A() throws IOException {
        int i8 = this.f15018d;
        if (i8 != 0) {
            this.f15016b = i8;
            this.f15018d = 0;
        } else {
            this.f15016b = this.f15015a.z();
        }
        int i9 = this.f15016b;
        if (i9 != 0 && i9 != this.f15017c) {
            return WireFormat.a(i9);
        }
        return Api.BaseClientBuilder.API_PRIORITY_OTHER;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public void B(List<String> list) throws IOException {
        T(list, false);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public void C(List<Float> list) throws IOException {
        int z7;
        int z8;
        if (list instanceof FloatArrayList) {
            FloatArrayList floatArrayList = (FloatArrayList) list;
            int b8 = WireFormat.b(this.f15016b);
            if (b8 != 2) {
                if (b8 == 5) {
                    do {
                        floatArrayList.g(this.f15015a.q());
                        if (this.f15015a.e()) {
                            return;
                        }
                        z8 = this.f15015a.z();
                    } while (z8 == this.f15016b);
                    this.f15018d = z8;
                    return;
                }
                throw InvalidProtocolBufferException.d();
            }
            int A = this.f15015a.A();
            W(A);
            int d8 = this.f15015a.d() + A;
            do {
                floatArrayList.g(this.f15015a.q());
            } while (this.f15015a.d() < d8);
            return;
        }
        int b9 = WireFormat.b(this.f15016b);
        if (b9 != 2) {
            if (b9 == 5) {
                do {
                    list.add(Float.valueOf(this.f15015a.q()));
                    if (this.f15015a.e()) {
                        return;
                    }
                    z7 = this.f15015a.z();
                } while (z7 == this.f15016b);
                this.f15018d = z7;
                return;
            }
            throw InvalidProtocolBufferException.d();
        }
        int A2 = this.f15015a.A();
        W(A2);
        int d9 = this.f15015a.d() + A2;
        do {
            list.add(Float.valueOf(this.f15015a.q()));
        } while (this.f15015a.d() < d9);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public boolean D() throws IOException {
        int i8;
        if (!this.f15015a.e() && (i8 = this.f15016b) != this.f15017c) {
            return this.f15015a.C(i8);
        }
        return false;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public int E() throws IOException {
        V(5);
        return this.f15015a.t();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public void F(List<ByteString> list) throws IOException {
        int z7;
        if (WireFormat.b(this.f15016b) == 2) {
            do {
                list.add(o());
                if (this.f15015a.e()) {
                    return;
                }
                z7 = this.f15015a.z();
            } while (z7 == this.f15016b);
            this.f15018d = z7;
            return;
        }
        throw InvalidProtocolBufferException.d();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public void G(List<Double> list) throws IOException {
        int z7;
        int z8;
        if (list instanceof DoubleArrayList) {
            DoubleArrayList doubleArrayList = (DoubleArrayList) list;
            int b8 = WireFormat.b(this.f15016b);
            if (b8 != 1) {
                if (b8 == 2) {
                    int A = this.f15015a.A();
                    X(A);
                    int d8 = this.f15015a.d() + A;
                    do {
                        doubleArrayList.K0(this.f15015a.m());
                    } while (this.f15015a.d() < d8);
                    return;
                }
                throw InvalidProtocolBufferException.d();
            }
            do {
                doubleArrayList.K0(this.f15015a.m());
                if (this.f15015a.e()) {
                    return;
                }
                z8 = this.f15015a.z();
            } while (z8 == this.f15016b);
            this.f15018d = z8;
            return;
        }
        int b9 = WireFormat.b(this.f15016b);
        if (b9 != 1) {
            if (b9 == 2) {
                int A2 = this.f15015a.A();
                X(A2);
                int d9 = this.f15015a.d() + A2;
                do {
                    list.add(Double.valueOf(this.f15015a.m()));
                } while (this.f15015a.d() < d9);
                return;
            }
            throw InvalidProtocolBufferException.d();
        }
        do {
            list.add(Double.valueOf(this.f15015a.m()));
            if (this.f15015a.e()) {
                return;
            }
            z7 = this.f15015a.z();
        } while (z7 == this.f15016b);
        this.f15018d = z7;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public long H() throws IOException {
        V(0);
        return this.f15015a.s();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public String I() throws IOException {
        V(2);
        return this.f15015a.y();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public <T> T J(Schema<T> schema, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        V(3);
        return (T) R(schema, extensionRegistryLite);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public <T> T K(Class<T> cls, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        V(3);
        return (T) R(Protobuf.a().d(cls), extensionRegistryLite);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public <K, V> void L(Map<K, V> map, MapEntryLite.Metadata<K, V> metadata, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        V(2);
        this.f15015a.j(this.f15015a.A());
        throw null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public <T> void M(List<T> list, Schema<T> schema, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        int z7;
        if (WireFormat.b(this.f15016b) == 2) {
            int i8 = this.f15016b;
            do {
                list.add(S(schema, extensionRegistryLite));
                if (!this.f15015a.e() && this.f15018d == 0) {
                    z7 = this.f15015a.z();
                } else {
                    return;
                }
            } while (z7 == i8);
            this.f15018d = z7;
            return;
        }
        throw InvalidProtocolBufferException.d();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public <T> T N(Schema<T> schema, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        V(2);
        return (T) S(schema, extensionRegistryLite);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public <T> T O(Class<T> cls, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        V(2);
        return (T) S(Protobuf.a().d(cls), extensionRegistryLite);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public <T> void P(List<T> list, Schema<T> schema, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        int z7;
        if (WireFormat.b(this.f15016b) == 3) {
            int i8 = this.f15016b;
            do {
                list.add(R(schema, extensionRegistryLite));
                if (!this.f15015a.e() && this.f15018d == 0) {
                    z7 = this.f15015a.z();
                } else {
                    return;
                }
            } while (z7 == i8);
            this.f15018d = z7;
            return;
        }
        throw InvalidProtocolBufferException.d();
    }

    public void T(List<String> list, boolean z7) throws IOException {
        String z8;
        int z9;
        int z10;
        if (WireFormat.b(this.f15016b) == 2) {
            if ((list instanceof LazyStringList) && !z7) {
                LazyStringList lazyStringList = (LazyStringList) list;
                do {
                    lazyStringList.U0(o());
                    if (this.f15015a.e()) {
                        return;
                    }
                    z10 = this.f15015a.z();
                } while (z10 == this.f15016b);
                this.f15018d = z10;
                return;
            }
            do {
                if (z7) {
                    z8 = I();
                } else {
                    z8 = z();
                }
                list.add(z8);
                if (this.f15015a.e()) {
                    return;
                }
                z9 = this.f15015a.z();
            } while (z9 == this.f15016b);
            this.f15018d = z9;
            return;
        }
        throw InvalidProtocolBufferException.d();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public int a() {
        return this.f15016b;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public long b() throws IOException {
        V(1);
        return this.f15015a.p();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public void c(List<Integer> list) throws IOException {
        int z7;
        int z8;
        if (list instanceof IntArrayList) {
            IntArrayList intArrayList = (IntArrayList) list;
            int b8 = WireFormat.b(this.f15016b);
            if (b8 != 2) {
                if (b8 == 5) {
                    do {
                        intArrayList.s0(this.f15015a.t());
                        if (this.f15015a.e()) {
                            return;
                        }
                        z8 = this.f15015a.z();
                    } while (z8 == this.f15016b);
                    this.f15018d = z8;
                    return;
                }
                throw InvalidProtocolBufferException.d();
            }
            int A = this.f15015a.A();
            W(A);
            int d8 = this.f15015a.d() + A;
            do {
                intArrayList.s0(this.f15015a.t());
            } while (this.f15015a.d() < d8);
            return;
        }
        int b9 = WireFormat.b(this.f15016b);
        if (b9 != 2) {
            if (b9 == 5) {
                do {
                    list.add(Integer.valueOf(this.f15015a.t()));
                    if (this.f15015a.e()) {
                        return;
                    }
                    z7 = this.f15015a.z();
                } while (z7 == this.f15016b);
                this.f15018d = z7;
                return;
            }
            throw InvalidProtocolBufferException.d();
        }
        int A2 = this.f15015a.A();
        W(A2);
        int d9 = this.f15015a.d() + A2;
        do {
            list.add(Integer.valueOf(this.f15015a.t()));
        } while (this.f15015a.d() < d9);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public void d(List<Long> list) throws IOException {
        int z7;
        int z8;
        if (list instanceof LongArrayList) {
            LongArrayList longArrayList = (LongArrayList) list;
            int b8 = WireFormat.b(this.f15016b);
            if (b8 != 0) {
                if (b8 == 2) {
                    int d8 = this.f15015a.d() + this.f15015a.A();
                    do {
                        longArrayList.v0(this.f15015a.w());
                    } while (this.f15015a.d() < d8);
                    U(d8);
                    return;
                }
                throw InvalidProtocolBufferException.d();
            }
            do {
                longArrayList.v0(this.f15015a.w());
                if (this.f15015a.e()) {
                    return;
                }
                z8 = this.f15015a.z();
            } while (z8 == this.f15016b);
            this.f15018d = z8;
            return;
        }
        int b9 = WireFormat.b(this.f15016b);
        if (b9 != 0) {
            if (b9 == 2) {
                int d9 = this.f15015a.d() + this.f15015a.A();
                do {
                    list.add(Long.valueOf(this.f15015a.w()));
                } while (this.f15015a.d() < d9);
                U(d9);
                return;
            }
            throw InvalidProtocolBufferException.d();
        }
        do {
            list.add(Long.valueOf(this.f15015a.w()));
            if (this.f15015a.e()) {
                return;
            }
            z7 = this.f15015a.z();
        } while (z7 == this.f15016b);
        this.f15018d = z7;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public boolean e() throws IOException {
        V(0);
        return this.f15015a.k();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public long f() throws IOException {
        V(1);
        return this.f15015a.u();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public void g(List<Long> list) throws IOException {
        int z7;
        int z8;
        if (list instanceof LongArrayList) {
            LongArrayList longArrayList = (LongArrayList) list;
            int b8 = WireFormat.b(this.f15016b);
            if (b8 != 0) {
                if (b8 == 2) {
                    int d8 = this.f15015a.d() + this.f15015a.A();
                    do {
                        longArrayList.v0(this.f15015a.B());
                    } while (this.f15015a.d() < d8);
                    U(d8);
                    return;
                }
                throw InvalidProtocolBufferException.d();
            }
            do {
                longArrayList.v0(this.f15015a.B());
                if (this.f15015a.e()) {
                    return;
                }
                z8 = this.f15015a.z();
            } while (z8 == this.f15016b);
            this.f15018d = z8;
            return;
        }
        int b9 = WireFormat.b(this.f15016b);
        if (b9 != 0) {
            if (b9 == 2) {
                int d9 = this.f15015a.d() + this.f15015a.A();
                do {
                    list.add(Long.valueOf(this.f15015a.B()));
                } while (this.f15015a.d() < d9);
                U(d9);
                return;
            }
            throw InvalidProtocolBufferException.d();
        }
        do {
            list.add(Long.valueOf(this.f15015a.B()));
            if (this.f15015a.e()) {
                return;
            }
            z7 = this.f15015a.z();
        } while (z7 == this.f15016b);
        this.f15018d = z7;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public int h() throws IOException {
        V(0);
        return this.f15015a.A();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public void i(List<Long> list) throws IOException {
        int z7;
        int z8;
        if (list instanceof LongArrayList) {
            LongArrayList longArrayList = (LongArrayList) list;
            int b8 = WireFormat.b(this.f15016b);
            if (b8 != 0) {
                if (b8 == 2) {
                    int d8 = this.f15015a.d() + this.f15015a.A();
                    do {
                        longArrayList.v0(this.f15015a.s());
                    } while (this.f15015a.d() < d8);
                    U(d8);
                    return;
                }
                throw InvalidProtocolBufferException.d();
            }
            do {
                longArrayList.v0(this.f15015a.s());
                if (this.f15015a.e()) {
                    return;
                }
                z8 = this.f15015a.z();
            } while (z8 == this.f15016b);
            this.f15018d = z8;
            return;
        }
        int b9 = WireFormat.b(this.f15016b);
        if (b9 != 0) {
            if (b9 == 2) {
                int d9 = this.f15015a.d() + this.f15015a.A();
                do {
                    list.add(Long.valueOf(this.f15015a.s()));
                } while (this.f15015a.d() < d9);
                U(d9);
                return;
            }
            throw InvalidProtocolBufferException.d();
        }
        do {
            list.add(Long.valueOf(this.f15015a.s()));
            if (this.f15015a.e()) {
                return;
            }
            z7 = this.f15015a.z();
        } while (z7 == this.f15016b);
        this.f15018d = z7;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public void j(List<Integer> list) throws IOException {
        int z7;
        int z8;
        if (list instanceof IntArrayList) {
            IntArrayList intArrayList = (IntArrayList) list;
            int b8 = WireFormat.b(this.f15016b);
            if (b8 != 0) {
                if (b8 == 2) {
                    int d8 = this.f15015a.d() + this.f15015a.A();
                    do {
                        intArrayList.s0(this.f15015a.n());
                    } while (this.f15015a.d() < d8);
                    U(d8);
                    return;
                }
                throw InvalidProtocolBufferException.d();
            }
            do {
                intArrayList.s0(this.f15015a.n());
                if (this.f15015a.e()) {
                    return;
                }
                z8 = this.f15015a.z();
            } while (z8 == this.f15016b);
            this.f15018d = z8;
            return;
        }
        int b9 = WireFormat.b(this.f15016b);
        if (b9 != 0) {
            if (b9 == 2) {
                int d9 = this.f15015a.d() + this.f15015a.A();
                do {
                    list.add(Integer.valueOf(this.f15015a.n()));
                } while (this.f15015a.d() < d9);
                U(d9);
                return;
            }
            throw InvalidProtocolBufferException.d();
        }
        do {
            list.add(Integer.valueOf(this.f15015a.n()));
            if (this.f15015a.e()) {
                return;
            }
            z7 = this.f15015a.z();
        } while (z7 == this.f15016b);
        this.f15018d = z7;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public int k() throws IOException {
        V(0);
        return this.f15015a.n();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public int l() throws IOException {
        V(0);
        return this.f15015a.v();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public void m(List<Boolean> list) throws IOException {
        int z7;
        int z8;
        if (list instanceof BooleanArrayList) {
            BooleanArrayList booleanArrayList = (BooleanArrayList) list;
            int b8 = WireFormat.b(this.f15016b);
            if (b8 != 0) {
                if (b8 == 2) {
                    int d8 = this.f15015a.d() + this.f15015a.A();
                    do {
                        booleanArrayList.i(this.f15015a.k());
                    } while (this.f15015a.d() < d8);
                    U(d8);
                    return;
                }
                throw InvalidProtocolBufferException.d();
            }
            do {
                booleanArrayList.i(this.f15015a.k());
                if (this.f15015a.e()) {
                    return;
                }
                z8 = this.f15015a.z();
            } while (z8 == this.f15016b);
            this.f15018d = z8;
            return;
        }
        int b9 = WireFormat.b(this.f15016b);
        if (b9 != 0) {
            if (b9 == 2) {
                int d9 = this.f15015a.d() + this.f15015a.A();
                do {
                    list.add(Boolean.valueOf(this.f15015a.k()));
                } while (this.f15015a.d() < d9);
                U(d9);
                return;
            }
            throw InvalidProtocolBufferException.d();
        }
        do {
            list.add(Boolean.valueOf(this.f15015a.k()));
            if (this.f15015a.e()) {
                return;
            }
            z7 = this.f15015a.z();
        } while (z7 == this.f15016b);
        this.f15018d = z7;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public void n(List<String> list) throws IOException {
        T(list, true);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public ByteString o() throws IOException {
        V(2);
        return this.f15015a.l();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public int p() throws IOException {
        V(0);
        return this.f15015a.r();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public void q(List<Long> list) throws IOException {
        int z7;
        int z8;
        if (list instanceof LongArrayList) {
            LongArrayList longArrayList = (LongArrayList) list;
            int b8 = WireFormat.b(this.f15016b);
            if (b8 != 1) {
                if (b8 == 2) {
                    int A = this.f15015a.A();
                    X(A);
                    int d8 = this.f15015a.d() + A;
                    do {
                        longArrayList.v0(this.f15015a.p());
                    } while (this.f15015a.d() < d8);
                    return;
                }
                throw InvalidProtocolBufferException.d();
            }
            do {
                longArrayList.v0(this.f15015a.p());
                if (this.f15015a.e()) {
                    return;
                }
                z8 = this.f15015a.z();
            } while (z8 == this.f15016b);
            this.f15018d = z8;
            return;
        }
        int b9 = WireFormat.b(this.f15016b);
        if (b9 != 1) {
            if (b9 == 2) {
                int A2 = this.f15015a.A();
                X(A2);
                int d9 = this.f15015a.d() + A2;
                do {
                    list.add(Long.valueOf(this.f15015a.p()));
                } while (this.f15015a.d() < d9);
                return;
            }
            throw InvalidProtocolBufferException.d();
        }
        do {
            list.add(Long.valueOf(this.f15015a.p()));
            if (this.f15015a.e()) {
                return;
            }
            z7 = this.f15015a.z();
        } while (z7 == this.f15016b);
        this.f15018d = z7;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public void r(List<Integer> list) throws IOException {
        int z7;
        int z8;
        if (list instanceof IntArrayList) {
            IntArrayList intArrayList = (IntArrayList) list;
            int b8 = WireFormat.b(this.f15016b);
            if (b8 != 0) {
                if (b8 == 2) {
                    int d8 = this.f15015a.d() + this.f15015a.A();
                    do {
                        intArrayList.s0(this.f15015a.v());
                    } while (this.f15015a.d() < d8);
                    U(d8);
                    return;
                }
                throw InvalidProtocolBufferException.d();
            }
            do {
                intArrayList.s0(this.f15015a.v());
                if (this.f15015a.e()) {
                    return;
                }
                z8 = this.f15015a.z();
            } while (z8 == this.f15016b);
            this.f15018d = z8;
            return;
        }
        int b9 = WireFormat.b(this.f15016b);
        if (b9 != 0) {
            if (b9 == 2) {
                int d9 = this.f15015a.d() + this.f15015a.A();
                do {
                    list.add(Integer.valueOf(this.f15015a.v()));
                } while (this.f15015a.d() < d9);
                U(d9);
                return;
            }
            throw InvalidProtocolBufferException.d();
        }
        do {
            list.add(Integer.valueOf(this.f15015a.v()));
            if (this.f15015a.e()) {
                return;
            }
            z7 = this.f15015a.z();
        } while (z7 == this.f15016b);
        this.f15018d = z7;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public double readDouble() throws IOException {
        V(1);
        return this.f15015a.m();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public float readFloat() throws IOException {
        V(5);
        return this.f15015a.q();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public long s() throws IOException {
        V(0);
        return this.f15015a.B();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public void t(List<Integer> list) throws IOException {
        int z7;
        int z8;
        if (list instanceof IntArrayList) {
            IntArrayList intArrayList = (IntArrayList) list;
            int b8 = WireFormat.b(this.f15016b);
            if (b8 != 0) {
                if (b8 == 2) {
                    int d8 = this.f15015a.d() + this.f15015a.A();
                    do {
                        intArrayList.s0(this.f15015a.A());
                    } while (this.f15015a.d() < d8);
                    U(d8);
                    return;
                }
                throw InvalidProtocolBufferException.d();
            }
            do {
                intArrayList.s0(this.f15015a.A());
                if (this.f15015a.e()) {
                    return;
                }
                z8 = this.f15015a.z();
            } while (z8 == this.f15016b);
            this.f15018d = z8;
            return;
        }
        int b9 = WireFormat.b(this.f15016b);
        if (b9 != 0) {
            if (b9 == 2) {
                int d9 = this.f15015a.d() + this.f15015a.A();
                do {
                    list.add(Integer.valueOf(this.f15015a.A()));
                } while (this.f15015a.d() < d9);
                U(d9);
                return;
            }
            throw InvalidProtocolBufferException.d();
        }
        do {
            list.add(Integer.valueOf(this.f15015a.A()));
            if (this.f15015a.e()) {
                return;
            }
            z7 = this.f15015a.z();
        } while (z7 == this.f15016b);
        this.f15018d = z7;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public int u() throws IOException {
        V(5);
        return this.f15015a.o();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public void v(List<Long> list) throws IOException {
        int z7;
        int z8;
        if (list instanceof LongArrayList) {
            LongArrayList longArrayList = (LongArrayList) list;
            int b8 = WireFormat.b(this.f15016b);
            if (b8 != 1) {
                if (b8 == 2) {
                    int A = this.f15015a.A();
                    X(A);
                    int d8 = this.f15015a.d() + A;
                    do {
                        longArrayList.v0(this.f15015a.u());
                    } while (this.f15015a.d() < d8);
                    return;
                }
                throw InvalidProtocolBufferException.d();
            }
            do {
                longArrayList.v0(this.f15015a.u());
                if (this.f15015a.e()) {
                    return;
                }
                z8 = this.f15015a.z();
            } while (z8 == this.f15016b);
            this.f15018d = z8;
            return;
        }
        int b9 = WireFormat.b(this.f15016b);
        if (b9 != 1) {
            if (b9 == 2) {
                int A2 = this.f15015a.A();
                X(A2);
                int d9 = this.f15015a.d() + A2;
                do {
                    list.add(Long.valueOf(this.f15015a.u()));
                } while (this.f15015a.d() < d9);
                return;
            }
            throw InvalidProtocolBufferException.d();
        }
        do {
            list.add(Long.valueOf(this.f15015a.u()));
            if (this.f15015a.e()) {
                return;
            }
            z7 = this.f15015a.z();
        } while (z7 == this.f15016b);
        this.f15018d = z7;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public void w(List<Integer> list) throws IOException {
        int z7;
        int z8;
        if (list instanceof IntArrayList) {
            IntArrayList intArrayList = (IntArrayList) list;
            int b8 = WireFormat.b(this.f15016b);
            if (b8 != 0) {
                if (b8 == 2) {
                    int d8 = this.f15015a.d() + this.f15015a.A();
                    do {
                        intArrayList.s0(this.f15015a.r());
                    } while (this.f15015a.d() < d8);
                    U(d8);
                    return;
                }
                throw InvalidProtocolBufferException.d();
            }
            do {
                intArrayList.s0(this.f15015a.r());
                if (this.f15015a.e()) {
                    return;
                }
                z8 = this.f15015a.z();
            } while (z8 == this.f15016b);
            this.f15018d = z8;
            return;
        }
        int b9 = WireFormat.b(this.f15016b);
        if (b9 != 0) {
            if (b9 == 2) {
                int d9 = this.f15015a.d() + this.f15015a.A();
                do {
                    list.add(Integer.valueOf(this.f15015a.r()));
                } while (this.f15015a.d() < d9);
                U(d9);
                return;
            }
            throw InvalidProtocolBufferException.d();
        }
        do {
            list.add(Integer.valueOf(this.f15015a.r()));
            if (this.f15015a.e()) {
                return;
            }
            z7 = this.f15015a.z();
        } while (z7 == this.f15016b);
        this.f15018d = z7;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public void x(List<Integer> list) throws IOException {
        int z7;
        int z8;
        if (list instanceof IntArrayList) {
            IntArrayList intArrayList = (IntArrayList) list;
            int b8 = WireFormat.b(this.f15016b);
            if (b8 != 2) {
                if (b8 == 5) {
                    do {
                        intArrayList.s0(this.f15015a.o());
                        if (this.f15015a.e()) {
                            return;
                        }
                        z8 = this.f15015a.z();
                    } while (z8 == this.f15016b);
                    this.f15018d = z8;
                    return;
                }
                throw InvalidProtocolBufferException.d();
            }
            int A = this.f15015a.A();
            W(A);
            int d8 = this.f15015a.d() + A;
            do {
                intArrayList.s0(this.f15015a.o());
            } while (this.f15015a.d() < d8);
            return;
        }
        int b9 = WireFormat.b(this.f15016b);
        if (b9 != 2) {
            if (b9 == 5) {
                do {
                    list.add(Integer.valueOf(this.f15015a.o()));
                    if (this.f15015a.e()) {
                        return;
                    }
                    z7 = this.f15015a.z();
                } while (z7 == this.f15016b);
                this.f15018d = z7;
                return;
            }
            throw InvalidProtocolBufferException.d();
        }
        int A2 = this.f15015a.A();
        W(A2);
        int d9 = this.f15015a.d() + A2;
        do {
            list.add(Integer.valueOf(this.f15015a.o()));
        } while (this.f15015a.d() < d9);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public long y() throws IOException {
        V(0);
        return this.f15015a.w();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public String z() throws IOException {
        V(2);
        return this.f15015a.x();
    }
}
