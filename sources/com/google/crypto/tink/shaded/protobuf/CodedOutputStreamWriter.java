package com.google.crypto.tink.shaded.protobuf;

import com.google.crypto.tink.shaded.protobuf.MapEntryLite;
import com.google.crypto.tink.shaded.protobuf.WireFormat;
import com.google.crypto.tink.shaded.protobuf.Writer;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class CodedOutputStreamWriter implements Writer {

    /* renamed from: a  reason: collision with root package name */
    private final CodedOutputStream f15027a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.google.crypto.tink.shaded.protobuf.CodedOutputStreamWriter$1  reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f15028a;

        static {
            int[] iArr = new int[WireFormat.FieldType.values().length];
            f15028a = iArr;
            try {
                iArr[WireFormat.FieldType.f15278o.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f15028a[WireFormat.FieldType.f15277n.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f15028a[WireFormat.FieldType.f15275l.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f15028a[WireFormat.FieldType.f15285v.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f15028a[WireFormat.FieldType.f15287x.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f15028a[WireFormat.FieldType.f15283t.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f15028a[WireFormat.FieldType.f15276m.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f15028a[WireFormat.FieldType.f15273j.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f15028a[WireFormat.FieldType.f15286w.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f15028a[WireFormat.FieldType.f15288y.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f15028a[WireFormat.FieldType.f15274k.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f15028a[WireFormat.FieldType.f15279p.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    private CodedOutputStreamWriter(CodedOutputStream codedOutputStream) {
        CodedOutputStream codedOutputStream2 = (CodedOutputStream) Internal.b(codedOutputStream, "output");
        this.f15027a = codedOutputStream2;
        codedOutputStream2.f15021a = this;
    }

    public static CodedOutputStreamWriter P(CodedOutputStream codedOutputStream) {
        CodedOutputStreamWriter codedOutputStreamWriter = codedOutputStream.f15021a;
        if (codedOutputStreamWriter != null) {
            return codedOutputStreamWriter;
        }
        return new CodedOutputStreamWriter(codedOutputStream);
    }

    private <K, V> void Q(int i8, MapEntryLite.Metadata<K, V> metadata, Map<K, V> map) throws IOException {
        int[] iArr = AnonymousClass1.f15028a;
        throw null;
    }

    private void R(int i8, Object obj) throws IOException {
        if (obj instanceof String) {
            this.f15027a.L0(i8, (String) obj);
        } else {
            this.f15027a.j0(i8, (ByteString) obj);
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void A(int i8, List<Boolean> list, boolean z7) throws IOException {
        int i9 = 0;
        if (z7) {
            this.f15027a.M0(i8, 2);
            int i10 = 0;
            for (int i11 = 0; i11 < list.size(); i11++) {
                i10 += CodedOutputStream.e(list.get(i11).booleanValue());
            }
            this.f15027a.O0(i10);
            while (i9 < list.size()) {
                this.f15027a.i0(list.get(i9).booleanValue());
                i9++;
            }
            return;
        }
        while (i9 < list.size()) {
            this.f15027a.h0(i8, list.get(i9).booleanValue());
            i9++;
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void B(int i8, float f8) throws IOException {
        this.f15027a.s0(i8, f8);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void C(int i8) throws IOException {
        this.f15027a.M0(i8, 4);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void D(int i8, List<Integer> list, boolean z7) throws IOException {
        int i9 = 0;
        if (z7) {
            this.f15027a.M0(i8, 2);
            int i10 = 0;
            for (int i11 = 0; i11 < list.size(); i11++) {
                i10 += CodedOutputStream.P(list.get(i11).intValue());
            }
            this.f15027a.O0(i10);
            while (i9 < list.size()) {
                this.f15027a.I0(list.get(i9).intValue());
                i9++;
            }
            return;
        }
        while (i9 < list.size()) {
            this.f15027a.H0(i8, list.get(i9).intValue());
            i9++;
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void E(int i8, int i9) throws IOException {
        this.f15027a.m0(i8, i9);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void F(int i8, List<Long> list, boolean z7) throws IOException {
        int i9 = 0;
        if (z7) {
            this.f15027a.M0(i8, 2);
            int i10 = 0;
            for (int i11 = 0; i11 < list.size(); i11++) {
                i10 += CodedOutputStream.y(list.get(i11).longValue());
            }
            this.f15027a.O0(i10);
            while (i9 < list.size()) {
                this.f15027a.z0(list.get(i9).longValue());
                i9++;
            }
            return;
        }
        while (i9 < list.size()) {
            this.f15027a.y0(i8, list.get(i9).longValue());
            i9++;
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void G(int i8, List<Double> list, boolean z7) throws IOException {
        int i9 = 0;
        if (z7) {
            this.f15027a.M0(i8, 2);
            int i10 = 0;
            for (int i11 = 0; i11 < list.size(); i11++) {
                i10 += CodedOutputStream.j(list.get(i11).doubleValue());
            }
            this.f15027a.O0(i10);
            while (i9 < list.size()) {
                this.f15027a.l0(list.get(i9).doubleValue());
                i9++;
            }
            return;
        }
        while (i9 < list.size()) {
            this.f15027a.k0(i8, list.get(i9).doubleValue());
            i9++;
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void H(int i8, int i9) throws IOException {
        this.f15027a.H0(i8, i9);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void I(int i8, List<ByteString> list) throws IOException {
        for (int i9 = 0; i9 < list.size(); i9++) {
            this.f15027a.j0(i8, list.get(i9));
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public <K, V> void J(int i8, MapEntryLite.Metadata<K, V> metadata, Map<K, V> map) throws IOException {
        if (this.f15027a.c0()) {
            Q(i8, metadata, map);
            return;
        }
        for (Map.Entry<K, V> entry : map.entrySet()) {
            this.f15027a.M0(i8, 2);
            this.f15027a.O0(MapEntryLite.b(metadata, entry.getKey(), entry.getValue()));
            MapEntryLite.d(this.f15027a, metadata, entry.getKey(), entry.getValue());
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void K(int i8, Object obj, Schema schema) throws IOException {
        this.f15027a.u0(i8, (MessageLite) obj, schema);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void L(int i8, List<?> list, Schema schema) throws IOException {
        for (int i9 = 0; i9 < list.size(); i9++) {
            N(i8, list.get(i9), schema);
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void M(int i8, ByteString byteString) throws IOException {
        this.f15027a.j0(i8, byteString);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void N(int i8, Object obj, Schema schema) throws IOException {
        this.f15027a.A0(i8, (MessageLite) obj, schema);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void O(int i8, List<?> list, Schema schema) throws IOException {
        for (int i9 = 0; i9 < list.size(); i9++) {
            K(i8, list.get(i9), schema);
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void a(int i8, List<Float> list, boolean z7) throws IOException {
        int i9 = 0;
        if (z7) {
            this.f15027a.M0(i8, 2);
            int i10 = 0;
            for (int i11 = 0; i11 < list.size(); i11++) {
                i10 += CodedOutputStream.r(list.get(i11).floatValue());
            }
            this.f15027a.O0(i10);
            while (i9 < list.size()) {
                this.f15027a.t0(list.get(i9).floatValue());
                i9++;
            }
            return;
        }
        while (i9 < list.size()) {
            this.f15027a.s0(i8, list.get(i9).floatValue());
            i9++;
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public final void b(int i8, Object obj) throws IOException {
        if (obj instanceof ByteString) {
            this.f15027a.C0(i8, (ByteString) obj);
        } else {
            this.f15027a.B0(i8, (MessageLite) obj);
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void c(int i8, int i9) throws IOException {
        this.f15027a.o0(i8, i9);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void d(int i8, List<String> list) throws IOException {
        int i9 = 0;
        if (list instanceof LazyStringList) {
            LazyStringList lazyStringList = (LazyStringList) list;
            while (i9 < list.size()) {
                R(i8, lazyStringList.l(i9));
                i9++;
            }
            return;
        }
        while (i9 < list.size()) {
            this.f15027a.L0(i8, list.get(i9));
            i9++;
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void e(int i8, String str) throws IOException {
        this.f15027a.L0(i8, str);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void f(int i8, long j8) throws IOException {
        this.f15027a.P0(i8, j8);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void g(int i8, List<Integer> list, boolean z7) throws IOException {
        int i9 = 0;
        if (z7) {
            this.f15027a.M0(i8, 2);
            int i10 = 0;
            for (int i11 = 0; i11 < list.size(); i11++) {
                i10 += CodedOutputStream.w(list.get(i11).intValue());
            }
            this.f15027a.O0(i10);
            while (i9 < list.size()) {
                this.f15027a.x0(list.get(i9).intValue());
                i9++;
            }
            return;
        }
        while (i9 < list.size()) {
            this.f15027a.w0(i8, list.get(i9).intValue());
            i9++;
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void h(int i8, int i9) throws IOException {
        this.f15027a.w0(i8, i9);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void i(int i8, long j8) throws IOException {
        this.f15027a.F0(i8, j8);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void j(int i8, List<Integer> list, boolean z7) throws IOException {
        int i9 = 0;
        if (z7) {
            this.f15027a.M0(i8, 2);
            int i10 = 0;
            for (int i11 = 0; i11 < list.size(); i11++) {
                i10 += CodedOutputStream.n(list.get(i11).intValue());
            }
            this.f15027a.O0(i10);
            while (i9 < list.size()) {
                this.f15027a.p0(list.get(i9).intValue());
                i9++;
            }
            return;
        }
        while (i9 < list.size()) {
            this.f15027a.o0(i8, list.get(i9).intValue());
            i9++;
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void k(int i8, List<Integer> list, boolean z7) throws IOException {
        int i9 = 0;
        if (z7) {
            this.f15027a.M0(i8, 2);
            int i10 = 0;
            for (int i11 = 0; i11 < list.size(); i11++) {
                i10 += CodedOutputStream.W(list.get(i11).intValue());
            }
            this.f15027a.O0(i10);
            while (i9 < list.size()) {
                this.f15027a.O0(list.get(i9).intValue());
                i9++;
            }
            return;
        }
        while (i9 < list.size()) {
            this.f15027a.N0(i8, list.get(i9).intValue());
            i9++;
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void l(int i8, List<Long> list, boolean z7) throws IOException {
        int i9 = 0;
        if (z7) {
            this.f15027a.M0(i8, 2);
            int i10 = 0;
            for (int i11 = 0; i11 < list.size(); i11++) {
                i10 += CodedOutputStream.R(list.get(i11).longValue());
            }
            this.f15027a.O0(i10);
            while (i9 < list.size()) {
                this.f15027a.K0(list.get(i9).longValue());
                i9++;
            }
            return;
        }
        while (i9 < list.size()) {
            this.f15027a.J0(i8, list.get(i9).longValue());
            i9++;
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void m(int i8, long j8) throws IOException {
        this.f15027a.J0(i8, j8);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void n(int i8, List<Integer> list, boolean z7) throws IOException {
        int i9 = 0;
        if (z7) {
            this.f15027a.M0(i8, 2);
            int i10 = 0;
            for (int i11 = 0; i11 < list.size(); i11++) {
                i10 += CodedOutputStream.l(list.get(i11).intValue());
            }
            this.f15027a.O0(i10);
            while (i9 < list.size()) {
                this.f15027a.n0(list.get(i9).intValue());
                i9++;
            }
            return;
        }
        while (i9 < list.size()) {
            this.f15027a.m0(i8, list.get(i9).intValue());
            i9++;
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void o(int i8, int i9) throws IOException {
        this.f15027a.N0(i8, i9);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void p(int i8, double d8) throws IOException {
        this.f15027a.k0(i8, d8);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void q(int i8, List<Long> list, boolean z7) throws IOException {
        int i9 = 0;
        if (z7) {
            this.f15027a.M0(i8, 2);
            int i10 = 0;
            for (int i11 = 0; i11 < list.size(); i11++) {
                i10 += CodedOutputStream.N(list.get(i11).longValue());
            }
            this.f15027a.O0(i10);
            while (i9 < list.size()) {
                this.f15027a.G0(list.get(i9).longValue());
                i9++;
            }
            return;
        }
        while (i9 < list.size()) {
            this.f15027a.F0(i8, list.get(i9).longValue());
            i9++;
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void r(int i8, List<Long> list, boolean z7) throws IOException {
        int i9 = 0;
        if (z7) {
            this.f15027a.M0(i8, 2);
            int i10 = 0;
            for (int i11 = 0; i11 < list.size(); i11++) {
                i10 += CodedOutputStream.Y(list.get(i11).longValue());
            }
            this.f15027a.O0(i10);
            while (i9 < list.size()) {
                this.f15027a.Q0(list.get(i9).longValue());
                i9++;
            }
            return;
        }
        while (i9 < list.size()) {
            this.f15027a.P0(i8, list.get(i9).longValue());
            i9++;
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void s(int i8, long j8) throws IOException {
        this.f15027a.q0(i8, j8);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public Writer.FieldOrder t() {
        return Writer.FieldOrder.ASCENDING;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void u(int i8, long j8) throws IOException {
        this.f15027a.y0(i8, j8);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void v(int i8, boolean z7) throws IOException {
        this.f15027a.h0(i8, z7);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void w(int i8, int i9) throws IOException {
        this.f15027a.D0(i8, i9);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void x(int i8) throws IOException {
        this.f15027a.M0(i8, 3);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void y(int i8, List<Long> list, boolean z7) throws IOException {
        int i9 = 0;
        if (z7) {
            this.f15027a.M0(i8, 2);
            int i10 = 0;
            for (int i11 = 0; i11 < list.size(); i11++) {
                i10 += CodedOutputStream.p(list.get(i11).longValue());
            }
            this.f15027a.O0(i10);
            while (i9 < list.size()) {
                this.f15027a.r0(list.get(i9).longValue());
                i9++;
            }
            return;
        }
        while (i9 < list.size()) {
            this.f15027a.q0(i8, list.get(i9).longValue());
            i9++;
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void z(int i8, List<Integer> list, boolean z7) throws IOException {
        int i9 = 0;
        if (z7) {
            this.f15027a.M0(i8, 2);
            int i10 = 0;
            for (int i11 = 0; i11 < list.size(); i11++) {
                i10 += CodedOutputStream.L(list.get(i11).intValue());
            }
            this.f15027a.O0(i10);
            while (i9 < list.size()) {
                this.f15027a.E0(list.get(i9).intValue());
                i9++;
            }
            return;
        }
        while (i9 < list.size()) {
            this.f15027a.D0(i8, list.get(i9).intValue());
            i9++;
        }
    }
}
