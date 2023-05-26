package com.google.protobuf;

import com.google.protobuf.MapEntryLite;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public interface Writer {

    /* loaded from: classes3.dex */
    public enum FieldOrder {
        ASCENDING,
        DESCENDING
    }

    void A(int i8, List<Boolean> list, boolean z7) throws IOException;

    void B(int i8, float f8) throws IOException;

    @Deprecated
    void C(int i8) throws IOException;

    void D(int i8, List<Integer> list, boolean z7) throws IOException;

    void E(int i8, int i9) throws IOException;

    void F(int i8, List<Long> list, boolean z7) throws IOException;

    void G(int i8, List<Double> list, boolean z7) throws IOException;

    void H(int i8, int i9) throws IOException;

    void I(int i8, List<ByteString> list) throws IOException;

    void J(int i8, List<?> list, Schema schema) throws IOException;

    @Deprecated
    void K(int i8, Object obj, Schema schema) throws IOException;

    void L(int i8, ByteString byteString) throws IOException;

    @Deprecated
    void M(int i8, List<?> list, Schema schema) throws IOException;

    void N(int i8, Object obj, Schema schema) throws IOException;

    <K, V> void O(int i8, MapEntryLite.Metadata<K, V> metadata, Map<K, V> map) throws IOException;

    void a(int i8, List<Float> list, boolean z7) throws IOException;

    void b(int i8, Object obj) throws IOException;

    void c(int i8, int i9) throws IOException;

    void d(int i8, List<String> list) throws IOException;

    void e(int i8, String str) throws IOException;

    void f(int i8, long j8) throws IOException;

    void g(int i8, List<Integer> list, boolean z7) throws IOException;

    void h(int i8, int i9) throws IOException;

    void i(int i8, long j8) throws IOException;

    void j(int i8, List<Integer> list, boolean z7) throws IOException;

    void k(int i8, List<Integer> list, boolean z7) throws IOException;

    void l(int i8, List<Long> list, boolean z7) throws IOException;

    void m(int i8, long j8) throws IOException;

    void n(int i8, List<Integer> list, boolean z7) throws IOException;

    void o(int i8, int i9) throws IOException;

    void p(int i8, double d8) throws IOException;

    void q(int i8, List<Long> list, boolean z7) throws IOException;

    void r(int i8, List<Long> list, boolean z7) throws IOException;

    void s(int i8, long j8) throws IOException;

    FieldOrder t();

    void u(int i8, long j8) throws IOException;

    void v(int i8, boolean z7) throws IOException;

    void w(int i8, int i9) throws IOException;

    @Deprecated
    void x(int i8) throws IOException;

    void y(int i8, List<Long> list, boolean z7) throws IOException;

    void z(int i8, List<Integer> list, boolean z7) throws IOException;
}
