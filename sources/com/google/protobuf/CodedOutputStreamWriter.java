package com.google.protobuf;

import com.google.protobuf.MapEntryLite;
import com.google.protobuf.WireFormat;
import com.google.protobuf.Writer;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class CodedOutputStreamWriter implements Writer {

    /* renamed from: a  reason: collision with root package name */
    private final CodedOutputStream f17257a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.google.protobuf.CodedOutputStreamWriter$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f17258a;

        static {
            int[] iArr = new int[WireFormat.FieldType.values().length];
            f17258a = iArr;
            try {
                iArr[WireFormat.FieldType.f17679o.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f17258a[WireFormat.FieldType.f17678n.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f17258a[WireFormat.FieldType.f17676l.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f17258a[WireFormat.FieldType.f17686v.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f17258a[WireFormat.FieldType.f17688x.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f17258a[WireFormat.FieldType.f17684t.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f17258a[WireFormat.FieldType.f17677m.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f17258a[WireFormat.FieldType.f17674j.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f17258a[WireFormat.FieldType.f17687w.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f17258a[WireFormat.FieldType.f17689y.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f17258a[WireFormat.FieldType.f17675k.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f17258a[WireFormat.FieldType.f17680p.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    private CodedOutputStreamWriter(CodedOutputStream codedOutputStream) {
        CodedOutputStream codedOutputStream2 = (CodedOutputStream) Internal.b(codedOutputStream, "output");
        this.f17257a = codedOutputStream2;
        codedOutputStream2.f17246a = this;
    }

    public static CodedOutputStreamWriter P(CodedOutputStream codedOutputStream) {
        CodedOutputStreamWriter codedOutputStreamWriter = codedOutputStream.f17246a;
        if (codedOutputStreamWriter != null) {
            return codedOutputStreamWriter;
        }
        return new CodedOutputStreamWriter(codedOutputStream);
    }

    private <V> void Q(int i8, boolean z7, V v7, MapEntryLite.Metadata<Boolean, V> metadata) throws IOException {
        this.f17257a.W0(i8, 2);
        this.f17257a.Y0(MapEntryLite.b(metadata, Boolean.valueOf(z7), v7));
        MapEntryLite.e(this.f17257a, metadata, Boolean.valueOf(z7), v7);
    }

    private <V> void R(int i8, MapEntryLite.Metadata<Integer, V> metadata, Map<Integer, V> map) throws IOException {
        int size = map.size();
        int[] iArr = new int[size];
        int i9 = 0;
        for (Integer num : map.keySet()) {
            iArr[i9] = num.intValue();
            i9++;
        }
        Arrays.sort(iArr);
        for (int i10 = 0; i10 < size; i10++) {
            int i11 = iArr[i10];
            V v7 = map.get(Integer.valueOf(i11));
            this.f17257a.W0(i8, 2);
            this.f17257a.Y0(MapEntryLite.b(metadata, Integer.valueOf(i11), v7));
            MapEntryLite.e(this.f17257a, metadata, Integer.valueOf(i11), v7);
        }
    }

    private <V> void S(int i8, MapEntryLite.Metadata<Long, V> metadata, Map<Long, V> map) throws IOException {
        int size = map.size();
        long[] jArr = new long[size];
        int i9 = 0;
        for (Long l8 : map.keySet()) {
            jArr[i9] = l8.longValue();
            i9++;
        }
        Arrays.sort(jArr);
        for (int i10 = 0; i10 < size; i10++) {
            long j8 = jArr[i10];
            V v7 = map.get(Long.valueOf(j8));
            this.f17257a.W0(i8, 2);
            this.f17257a.Y0(MapEntryLite.b(metadata, Long.valueOf(j8), v7));
            MapEntryLite.e(this.f17257a, metadata, Long.valueOf(j8), v7);
        }
    }

    private <K, V> void T(int i8, MapEntryLite.Metadata<K, V> metadata, Map<K, V> map) throws IOException {
        switch (AnonymousClass1.f17258a[metadata.f17506a.ordinal()]) {
            case 1:
                V v7 = map.get(Boolean.FALSE);
                if (v7 != null) {
                    Q(i8, false, v7, metadata);
                }
                V v8 = map.get(Boolean.TRUE);
                if (v8 != null) {
                    Q(i8, true, v8, metadata);
                    return;
                }
                return;
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                R(i8, metadata, map);
                return;
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
                S(i8, metadata, map);
                return;
            case 12:
                U(i8, metadata, map);
                return;
            default:
                throw new IllegalArgumentException("does not support key type: " + metadata.f17506a);
        }
    }

    private <V> void U(int i8, MapEntryLite.Metadata<String, V> metadata, Map<String, V> map) throws IOException {
        int size = map.size();
        String[] strArr = new String[size];
        int i9 = 0;
        for (String str : map.keySet()) {
            strArr[i9] = str;
            i9++;
        }
        Arrays.sort(strArr);
        for (int i10 = 0; i10 < size; i10++) {
            String str2 = strArr[i10];
            V v7 = map.get(str2);
            this.f17257a.W0(i8, 2);
            this.f17257a.Y0(MapEntryLite.b(metadata, str2, v7));
            MapEntryLite.e(this.f17257a, metadata, str2, v7);
        }
    }

    private void V(int i8, Object obj) throws IOException {
        if (obj instanceof String) {
            this.f17257a.U0(i8, (String) obj);
        } else {
            this.f17257a.o0(i8, (ByteString) obj);
        }
    }

    @Override // com.google.protobuf.Writer
    public void A(int i8, List<Boolean> list, boolean z7) throws IOException {
        int i9 = 0;
        if (z7) {
            this.f17257a.W0(i8, 2);
            int i10 = 0;
            for (int i11 = 0; i11 < list.size(); i11++) {
                i10 += CodedOutputStream.f(list.get(i11).booleanValue());
            }
            this.f17257a.Y0(i10);
            while (i9 < list.size()) {
                this.f17257a.l0(list.get(i9).booleanValue());
                i9++;
            }
            return;
        }
        while (i9 < list.size()) {
            this.f17257a.k0(i8, list.get(i9).booleanValue());
            i9++;
        }
    }

    @Override // com.google.protobuf.Writer
    public void B(int i8, float f8) throws IOException {
        this.f17257a.y0(i8, f8);
    }

    @Override // com.google.protobuf.Writer
    @Deprecated
    public void C(int i8) throws IOException {
        this.f17257a.W0(i8, 4);
    }

    @Override // com.google.protobuf.Writer
    public void D(int i8, List<Integer> list, boolean z7) throws IOException {
        int i9 = 0;
        if (z7) {
            this.f17257a.W0(i8, 2);
            int i10 = 0;
            for (int i11 = 0; i11 < list.size(); i11++) {
                i10 += CodedOutputStream.Q(list.get(i11).intValue());
            }
            this.f17257a.Y0(i10);
            while (i9 < list.size()) {
                this.f17257a.R0(list.get(i9).intValue());
                i9++;
            }
            return;
        }
        while (i9 < list.size()) {
            this.f17257a.Q0(i8, list.get(i9).intValue());
            i9++;
        }
    }

    @Override // com.google.protobuf.Writer
    public void E(int i8, int i9) throws IOException {
        this.f17257a.s0(i8, i9);
    }

    @Override // com.google.protobuf.Writer
    public void F(int i8, List<Long> list, boolean z7) throws IOException {
        int i9 = 0;
        if (z7) {
            this.f17257a.W0(i8, 2);
            int i10 = 0;
            for (int i11 = 0; i11 < list.size(); i11++) {
                i10 += CodedOutputStream.z(list.get(i11).longValue());
            }
            this.f17257a.Y0(i10);
            while (i9 < list.size()) {
                this.f17257a.H0(list.get(i9).longValue());
                i9++;
            }
            return;
        }
        while (i9 < list.size()) {
            this.f17257a.G0(i8, list.get(i9).longValue());
            i9++;
        }
    }

    @Override // com.google.protobuf.Writer
    public void G(int i8, List<Double> list, boolean z7) throws IOException {
        int i9 = 0;
        if (z7) {
            this.f17257a.W0(i8, 2);
            int i10 = 0;
            for (int i11 = 0; i11 < list.size(); i11++) {
                i10 += CodedOutputStream.k(list.get(i11).doubleValue());
            }
            this.f17257a.Y0(i10);
            while (i9 < list.size()) {
                this.f17257a.r0(list.get(i9).doubleValue());
                i9++;
            }
            return;
        }
        while (i9 < list.size()) {
            this.f17257a.q0(i8, list.get(i9).doubleValue());
            i9++;
        }
    }

    @Override // com.google.protobuf.Writer
    public void H(int i8, int i9) throws IOException {
        this.f17257a.Q0(i8, i9);
    }

    @Override // com.google.protobuf.Writer
    public void I(int i8, List<ByteString> list) throws IOException {
        for (int i9 = 0; i9 < list.size(); i9++) {
            this.f17257a.o0(i8, list.get(i9));
        }
    }

    @Override // com.google.protobuf.Writer
    public void J(int i8, List<?> list, Schema schema) throws IOException {
        for (int i9 = 0; i9 < list.size(); i9++) {
            N(i8, list.get(i9), schema);
        }
    }

    @Override // com.google.protobuf.Writer
    public void K(int i8, Object obj, Schema schema) throws IOException {
        this.f17257a.B0(i8, (MessageLite) obj, schema);
    }

    @Override // com.google.protobuf.Writer
    public void L(int i8, ByteString byteString) throws IOException {
        this.f17257a.o0(i8, byteString);
    }

    @Override // com.google.protobuf.Writer
    public void M(int i8, List<?> list, Schema schema) throws IOException {
        for (int i9 = 0; i9 < list.size(); i9++) {
            K(i8, list.get(i9), schema);
        }
    }

    @Override // com.google.protobuf.Writer
    public void N(int i8, Object obj, Schema schema) throws IOException {
        this.f17257a.I0(i8, (MessageLite) obj, schema);
    }

    @Override // com.google.protobuf.Writer
    public <K, V> void O(int i8, MapEntryLite.Metadata<K, V> metadata, Map<K, V> map) throws IOException {
        if (this.f17257a.e0()) {
            T(i8, metadata, map);
            return;
        }
        for (Map.Entry<K, V> entry : map.entrySet()) {
            this.f17257a.W0(i8, 2);
            this.f17257a.Y0(MapEntryLite.b(metadata, entry.getKey(), entry.getValue()));
            MapEntryLite.e(this.f17257a, metadata, entry.getKey(), entry.getValue());
        }
    }

    @Override // com.google.protobuf.Writer
    public void a(int i8, List<Float> list, boolean z7) throws IOException {
        int i9 = 0;
        if (z7) {
            this.f17257a.W0(i8, 2);
            int i10 = 0;
            for (int i11 = 0; i11 < list.size(); i11++) {
                i10 += CodedOutputStream.s(list.get(i11).floatValue());
            }
            this.f17257a.Y0(i10);
            while (i9 < list.size()) {
                this.f17257a.z0(list.get(i9).floatValue());
                i9++;
            }
            return;
        }
        while (i9 < list.size()) {
            this.f17257a.y0(i8, list.get(i9).floatValue());
            i9++;
        }
    }

    @Override // com.google.protobuf.Writer
    public final void b(int i8, Object obj) throws IOException {
        if (obj instanceof ByteString) {
            this.f17257a.L0(i8, (ByteString) obj);
        } else {
            this.f17257a.K0(i8, (MessageLite) obj);
        }
    }

    @Override // com.google.protobuf.Writer
    public void c(int i8, int i9) throws IOException {
        this.f17257a.u0(i8, i9);
    }

    @Override // com.google.protobuf.Writer
    public void d(int i8, List<String> list) throws IOException {
        int i9 = 0;
        if (list instanceof LazyStringList) {
            LazyStringList lazyStringList = (LazyStringList) list;
            while (i9 < list.size()) {
                V(i8, lazyStringList.l(i9));
                i9++;
            }
            return;
        }
        while (i9 < list.size()) {
            this.f17257a.U0(i8, list.get(i9));
            i9++;
        }
    }

    @Override // com.google.protobuf.Writer
    public void e(int i8, String str) throws IOException {
        this.f17257a.U0(i8, str);
    }

    @Override // com.google.protobuf.Writer
    public void f(int i8, long j8) throws IOException {
        this.f17257a.Z0(i8, j8);
    }

    @Override // com.google.protobuf.Writer
    public void g(int i8, List<Integer> list, boolean z7) throws IOException {
        int i9 = 0;
        if (z7) {
            this.f17257a.W0(i8, 2);
            int i10 = 0;
            for (int i11 = 0; i11 < list.size(); i11++) {
                i10 += CodedOutputStream.x(list.get(i11).intValue());
            }
            this.f17257a.Y0(i10);
            while (i9 < list.size()) {
                this.f17257a.F0(list.get(i9).intValue());
                i9++;
            }
            return;
        }
        while (i9 < list.size()) {
            this.f17257a.E0(i8, list.get(i9).intValue());
            i9++;
        }
    }

    @Override // com.google.protobuf.Writer
    public void h(int i8, int i9) throws IOException {
        this.f17257a.E0(i8, i9);
    }

    @Override // com.google.protobuf.Writer
    public void i(int i8, long j8) throws IOException {
        this.f17257a.O0(i8, j8);
    }

    @Override // com.google.protobuf.Writer
    public void j(int i8, List<Integer> list, boolean z7) throws IOException {
        int i9 = 0;
        if (z7) {
            this.f17257a.W0(i8, 2);
            int i10 = 0;
            for (int i11 = 0; i11 < list.size(); i11++) {
                i10 += CodedOutputStream.o(list.get(i11).intValue());
            }
            this.f17257a.Y0(i10);
            while (i9 < list.size()) {
                this.f17257a.v0(list.get(i9).intValue());
                i9++;
            }
            return;
        }
        while (i9 < list.size()) {
            this.f17257a.u0(i8, list.get(i9).intValue());
            i9++;
        }
    }

    @Override // com.google.protobuf.Writer
    public void k(int i8, List<Integer> list, boolean z7) throws IOException {
        int i9 = 0;
        if (z7) {
            this.f17257a.W0(i8, 2);
            int i10 = 0;
            for (int i11 = 0; i11 < list.size(); i11++) {
                i10 += CodedOutputStream.X(list.get(i11).intValue());
            }
            this.f17257a.Y0(i10);
            while (i9 < list.size()) {
                this.f17257a.Y0(list.get(i9).intValue());
                i9++;
            }
            return;
        }
        while (i9 < list.size()) {
            this.f17257a.X0(i8, list.get(i9).intValue());
            i9++;
        }
    }

    @Override // com.google.protobuf.Writer
    public void l(int i8, List<Long> list, boolean z7) throws IOException {
        int i9 = 0;
        if (z7) {
            this.f17257a.W0(i8, 2);
            int i10 = 0;
            for (int i11 = 0; i11 < list.size(); i11++) {
                i10 += CodedOutputStream.S(list.get(i11).longValue());
            }
            this.f17257a.Y0(i10);
            while (i9 < list.size()) {
                this.f17257a.T0(list.get(i9).longValue());
                i9++;
            }
            return;
        }
        while (i9 < list.size()) {
            this.f17257a.S0(i8, list.get(i9).longValue());
            i9++;
        }
    }

    @Override // com.google.protobuf.Writer
    public void m(int i8, long j8) throws IOException {
        this.f17257a.S0(i8, j8);
    }

    @Override // com.google.protobuf.Writer
    public void n(int i8, List<Integer> list, boolean z7) throws IOException {
        int i9 = 0;
        if (z7) {
            this.f17257a.W0(i8, 2);
            int i10 = 0;
            for (int i11 = 0; i11 < list.size(); i11++) {
                i10 += CodedOutputStream.m(list.get(i11).intValue());
            }
            this.f17257a.Y0(i10);
            while (i9 < list.size()) {
                this.f17257a.t0(list.get(i9).intValue());
                i9++;
            }
            return;
        }
        while (i9 < list.size()) {
            this.f17257a.s0(i8, list.get(i9).intValue());
            i9++;
        }
    }

    @Override // com.google.protobuf.Writer
    public void o(int i8, int i9) throws IOException {
        this.f17257a.X0(i8, i9);
    }

    @Override // com.google.protobuf.Writer
    public void p(int i8, double d8) throws IOException {
        this.f17257a.q0(i8, d8);
    }

    @Override // com.google.protobuf.Writer
    public void q(int i8, List<Long> list, boolean z7) throws IOException {
        int i9 = 0;
        if (z7) {
            this.f17257a.W0(i8, 2);
            int i10 = 0;
            for (int i11 = 0; i11 < list.size(); i11++) {
                i10 += CodedOutputStream.O(list.get(i11).longValue());
            }
            this.f17257a.Y0(i10);
            while (i9 < list.size()) {
                this.f17257a.P0(list.get(i9).longValue());
                i9++;
            }
            return;
        }
        while (i9 < list.size()) {
            this.f17257a.O0(i8, list.get(i9).longValue());
            i9++;
        }
    }

    @Override // com.google.protobuf.Writer
    public void r(int i8, List<Long> list, boolean z7) throws IOException {
        int i9 = 0;
        if (z7) {
            this.f17257a.W0(i8, 2);
            int i10 = 0;
            for (int i11 = 0; i11 < list.size(); i11++) {
                i10 += CodedOutputStream.Z(list.get(i11).longValue());
            }
            this.f17257a.Y0(i10);
            while (i9 < list.size()) {
                this.f17257a.a1(list.get(i9).longValue());
                i9++;
            }
            return;
        }
        while (i9 < list.size()) {
            this.f17257a.Z0(i8, list.get(i9).longValue());
            i9++;
        }
    }

    @Override // com.google.protobuf.Writer
    public void s(int i8, long j8) throws IOException {
        this.f17257a.w0(i8, j8);
    }

    @Override // com.google.protobuf.Writer
    public Writer.FieldOrder t() {
        return Writer.FieldOrder.ASCENDING;
    }

    @Override // com.google.protobuf.Writer
    public void u(int i8, long j8) throws IOException {
        this.f17257a.G0(i8, j8);
    }

    @Override // com.google.protobuf.Writer
    public void v(int i8, boolean z7) throws IOException {
        this.f17257a.k0(i8, z7);
    }

    @Override // com.google.protobuf.Writer
    public void w(int i8, int i9) throws IOException {
        this.f17257a.M0(i8, i9);
    }

    @Override // com.google.protobuf.Writer
    @Deprecated
    public void x(int i8) throws IOException {
        this.f17257a.W0(i8, 3);
    }

    @Override // com.google.protobuf.Writer
    public void y(int i8, List<Long> list, boolean z7) throws IOException {
        int i9 = 0;
        if (z7) {
            this.f17257a.W0(i8, 2);
            int i10 = 0;
            for (int i11 = 0; i11 < list.size(); i11++) {
                i10 += CodedOutputStream.q(list.get(i11).longValue());
            }
            this.f17257a.Y0(i10);
            while (i9 < list.size()) {
                this.f17257a.x0(list.get(i9).longValue());
                i9++;
            }
            return;
        }
        while (i9 < list.size()) {
            this.f17257a.w0(i8, list.get(i9).longValue());
            i9++;
        }
    }

    @Override // com.google.protobuf.Writer
    public void z(int i8, List<Integer> list, boolean z7) throws IOException {
        int i9 = 0;
        if (z7) {
            this.f17257a.W0(i8, 2);
            int i10 = 0;
            for (int i11 = 0; i11 < list.size(); i11++) {
                i10 += CodedOutputStream.M(list.get(i11).intValue());
            }
            this.f17257a.Y0(i10);
            while (i9 < list.size()) {
                this.f17257a.N0(list.get(i9).intValue());
                i9++;
            }
            return;
        }
        while (i9 < list.size()) {
            this.f17257a.M0(i8, list.get(i9).intValue());
            i9++;
        }
    }
}
