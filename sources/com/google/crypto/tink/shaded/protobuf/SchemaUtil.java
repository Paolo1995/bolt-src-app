package com.google.crypto.tink.shaded.protobuf;

import com.google.crypto.tink.shaded.protobuf.FieldSet;
import com.google.crypto.tink.shaded.protobuf.Internal;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class SchemaUtil {

    /* renamed from: a  reason: collision with root package name */
    private static final Class<?> f15197a = B();

    /* renamed from: b  reason: collision with root package name */
    private static final UnknownFieldSchema<?, ?> f15198b = C(false);

    /* renamed from: c  reason: collision with root package name */
    private static final UnknownFieldSchema<?, ?> f15199c = C(true);

    /* renamed from: d  reason: collision with root package name */
    private static final UnknownFieldSchema<?, ?> f15200d = new UnknownFieldSetLiteSchema();

    private SchemaUtil() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <UT, UB> UB A(int i8, List<Integer> list, Internal.EnumVerifier enumVerifier, UB ub, UnknownFieldSchema<UT, UB> unknownFieldSchema) {
        if (enumVerifier == null) {
            return ub;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i9 = 0;
            for (int i10 = 0; i10 < size; i10++) {
                int intValue = list.get(i10).intValue();
                if (enumVerifier.a(intValue)) {
                    if (i10 != i9) {
                        list.set(i9, Integer.valueOf(intValue));
                    }
                    i9++;
                } else {
                    ub = (UB) L(i8, intValue, ub, unknownFieldSchema);
                }
            }
            if (i9 != size) {
                list.subList(i9, size).clear();
            }
        } else {
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()) {
                int intValue2 = it.next().intValue();
                if (!enumVerifier.a(intValue2)) {
                    ub = (UB) L(i8, intValue2, ub, unknownFieldSchema);
                    it.remove();
                }
            }
        }
        return ub;
    }

    private static Class<?> B() {
        try {
            return Class.forName("com.google.crypto.tink.shaded.protobuf.GeneratedMessageV3");
        } catch (Throwable unused) {
            return null;
        }
    }

    private static UnknownFieldSchema<?, ?> C(boolean z7) {
        try {
            Class<?> D = D();
            if (D == null) {
                return null;
            }
            return (UnknownFieldSchema) D.getConstructor(Boolean.TYPE).newInstance(Boolean.valueOf(z7));
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Class<?> D() {
        try {
            return Class.forName("com.google.crypto.tink.shaded.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T, FT extends FieldSet.FieldDescriptorLite<FT>> void E(ExtensionSchema<FT> extensionSchema, T t7, T t8) {
        FieldSet<FT> c8 = extensionSchema.c(t8);
        if (!c8.m()) {
            extensionSchema.d(t7).t(c8);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> void F(MapFieldSchema mapFieldSchema, T t7, T t8, long j8) {
        UnsafeUtil.O(t7, j8, mapFieldSchema.a(UnsafeUtil.A(t7, j8), UnsafeUtil.A(t8, j8)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T, UT, UB> void G(UnknownFieldSchema<UT, UB> unknownFieldSchema, T t7, T t8) {
        unknownFieldSchema.p(t7, unknownFieldSchema.k(unknownFieldSchema.g(t7), unknownFieldSchema.g(t8)));
    }

    public static UnknownFieldSchema<?, ?> H() {
        return f15198b;
    }

    public static UnknownFieldSchema<?, ?> I() {
        return f15199c;
    }

    public static void J(Class<?> cls) {
        Class<?> cls2;
        if (!GeneratedMessageLite.class.isAssignableFrom(cls) && (cls2 = f15197a) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean K(Object obj, Object obj2) {
        if (obj != obj2 && (obj == null || !obj.equals(obj2))) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <UT, UB> UB L(int i8, int i9, UB ub, UnknownFieldSchema<UT, UB> unknownFieldSchema) {
        if (ub == null) {
            ub = unknownFieldSchema.n();
        }
        unknownFieldSchema.e(ub, i8, i9);
        return ub;
    }

    public static UnknownFieldSchema<?, ?> M() {
        return f15200d;
    }

    public static void N(int i8, List<Boolean> list, Writer writer, boolean z7) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.A(i8, list, z7);
        }
    }

    public static void O(int i8, List<ByteString> list, Writer writer) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.I(i8, list);
        }
    }

    public static void P(int i8, List<Double> list, Writer writer, boolean z7) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.G(i8, list, z7);
        }
    }

    public static void Q(int i8, List<Integer> list, Writer writer, boolean z7) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.n(i8, list, z7);
        }
    }

    public static void R(int i8, List<Integer> list, Writer writer, boolean z7) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.j(i8, list, z7);
        }
    }

    public static void S(int i8, List<Long> list, Writer writer, boolean z7) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.y(i8, list, z7);
        }
    }

    public static void T(int i8, List<Float> list, Writer writer, boolean z7) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.a(i8, list, z7);
        }
    }

    public static void U(int i8, List<?> list, Writer writer, Schema schema) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.O(i8, list, schema);
        }
    }

    public static void V(int i8, List<Integer> list, Writer writer, boolean z7) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.g(i8, list, z7);
        }
    }

    public static void W(int i8, List<Long> list, Writer writer, boolean z7) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.F(i8, list, z7);
        }
    }

    public static void X(int i8, List<?> list, Writer writer, Schema schema) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.L(i8, list, schema);
        }
    }

    public static void Y(int i8, List<Integer> list, Writer writer, boolean z7) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.z(i8, list, z7);
        }
    }

    public static void Z(int i8, List<Long> list, Writer writer, boolean z7) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.q(i8, list, z7);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(int i8, List<?> list, boolean z7) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        if (z7) {
            return CodedOutputStream.U(i8) + CodedOutputStream.C(size);
        }
        return size * CodedOutputStream.d(i8, true);
    }

    public static void a0(int i8, List<Integer> list, Writer writer, boolean z7) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.D(i8, list, z7);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int b(List<?> list) {
        return list.size();
    }

    public static void b0(int i8, List<Long> list, Writer writer, boolean z7) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.l(i8, list, z7);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int c(int i8, List<ByteString> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int U = size * CodedOutputStream.U(i8);
        for (int i9 = 0; i9 < list.size(); i9++) {
            U += CodedOutputStream.h(list.get(i9));
        }
        return U;
    }

    public static void c0(int i8, List<String> list, Writer writer) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.d(i8, list);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int d(int i8, List<Integer> list, boolean z7) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int e8 = e(list);
        if (z7) {
            return CodedOutputStream.U(i8) + CodedOutputStream.C(e8);
        }
        return e8 + (size * CodedOutputStream.U(i8));
    }

    public static void d0(int i8, List<Integer> list, Writer writer, boolean z7) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.k(i8, list, z7);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int e(List<Integer> list) {
        int i8;
        int size = list.size();
        int i9 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof IntArrayList) {
            IntArrayList intArrayList = (IntArrayList) list;
            i8 = 0;
            while (i9 < size) {
                i8 += CodedOutputStream.l(intArrayList.getInt(i9));
                i9++;
            }
        } else {
            i8 = 0;
            while (i9 < size) {
                i8 += CodedOutputStream.l(list.get(i9).intValue());
                i9++;
            }
        }
        return i8;
    }

    public static void e0(int i8, List<Long> list, Writer writer, boolean z7) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.r(i8, list, z7);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int f(int i8, List<?> list, boolean z7) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        if (z7) {
            return CodedOutputStream.U(i8) + CodedOutputStream.C(size * 4);
        }
        return size * CodedOutputStream.m(i8, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int g(List<?> list) {
        return list.size() * 4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int h(int i8, List<?> list, boolean z7) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        if (z7) {
            return CodedOutputStream.U(i8) + CodedOutputStream.C(size * 8);
        }
        return size * CodedOutputStream.o(i8, 0L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int i(List<?> list) {
        return list.size() * 8;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int j(int i8, List<MessageLite> list, Schema schema) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i9 = 0;
        for (int i10 = 0; i10 < size; i10++) {
            i9 += CodedOutputStream.s(i8, list.get(i10), schema);
        }
        return i9;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int k(int i8, List<Integer> list, boolean z7) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int l8 = l(list);
        if (z7) {
            return CodedOutputStream.U(i8) + CodedOutputStream.C(l8);
        }
        return l8 + (size * CodedOutputStream.U(i8));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int l(List<Integer> list) {
        int i8;
        int size = list.size();
        int i9 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof IntArrayList) {
            IntArrayList intArrayList = (IntArrayList) list;
            i8 = 0;
            while (i9 < size) {
                i8 += CodedOutputStream.w(intArrayList.getInt(i9));
                i9++;
            }
        } else {
            i8 = 0;
            while (i9 < size) {
                i8 += CodedOutputStream.w(list.get(i9).intValue());
                i9++;
            }
        }
        return i8;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int m(int i8, List<Long> list, boolean z7) {
        if (list.size() == 0) {
            return 0;
        }
        int n8 = n(list);
        if (z7) {
            return CodedOutputStream.U(i8) + CodedOutputStream.C(n8);
        }
        return n8 + (list.size() * CodedOutputStream.U(i8));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int n(List<Long> list) {
        int i8;
        int size = list.size();
        int i9 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof LongArrayList) {
            LongArrayList longArrayList = (LongArrayList) list;
            i8 = 0;
            while (i9 < size) {
                i8 += CodedOutputStream.y(longArrayList.getLong(i9));
                i9++;
            }
        } else {
            i8 = 0;
            while (i9 < size) {
                i8 += CodedOutputStream.y(list.get(i9).longValue());
                i9++;
            }
        }
        return i8;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int o(int i8, Object obj, Schema schema) {
        if (obj instanceof LazyFieldLite) {
            return CodedOutputStream.A(i8, (LazyFieldLite) obj);
        }
        return CodedOutputStream.F(i8, (MessageLite) obj, schema);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int p(int i8, List<?> list, Schema schema) {
        int H;
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int U = CodedOutputStream.U(i8) * size;
        for (int i9 = 0; i9 < size; i9++) {
            Object obj = list.get(i9);
            if (obj instanceof LazyFieldLite) {
                H = CodedOutputStream.B((LazyFieldLite) obj);
            } else {
                H = CodedOutputStream.H((MessageLite) obj, schema);
            }
            U += H;
        }
        return U;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int q(int i8, List<Integer> list, boolean z7) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int r7 = r(list);
        if (z7) {
            return CodedOutputStream.U(i8) + CodedOutputStream.C(r7);
        }
        return r7 + (size * CodedOutputStream.U(i8));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int r(List<Integer> list) {
        int i8;
        int size = list.size();
        int i9 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof IntArrayList) {
            IntArrayList intArrayList = (IntArrayList) list;
            i8 = 0;
            while (i9 < size) {
                i8 += CodedOutputStream.P(intArrayList.getInt(i9));
                i9++;
            }
        } else {
            i8 = 0;
            while (i9 < size) {
                i8 += CodedOutputStream.P(list.get(i9).intValue());
                i9++;
            }
        }
        return i8;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int s(int i8, List<Long> list, boolean z7) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int t7 = t(list);
        if (z7) {
            return CodedOutputStream.U(i8) + CodedOutputStream.C(t7);
        }
        return t7 + (size * CodedOutputStream.U(i8));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int t(List<Long> list) {
        int i8;
        int size = list.size();
        int i9 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof LongArrayList) {
            LongArrayList longArrayList = (LongArrayList) list;
            i8 = 0;
            while (i9 < size) {
                i8 += CodedOutputStream.R(longArrayList.getLong(i9));
                i9++;
            }
        } else {
            i8 = 0;
            while (i9 < size) {
                i8 += CodedOutputStream.R(list.get(i9).longValue());
                i9++;
            }
        }
        return i8;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int u(int i8, List<?> list) {
        int T;
        int T2;
        int size = list.size();
        int i9 = 0;
        if (size == 0) {
            return 0;
        }
        int U = CodedOutputStream.U(i8) * size;
        if (list instanceof LazyStringList) {
            LazyStringList lazyStringList = (LazyStringList) list;
            while (i9 < size) {
                Object l8 = lazyStringList.l(i9);
                if (l8 instanceof ByteString) {
                    T2 = CodedOutputStream.h((ByteString) l8);
                } else {
                    T2 = CodedOutputStream.T((String) l8);
                }
                U += T2;
                i9++;
            }
        } else {
            while (i9 < size) {
                Object obj = list.get(i9);
                if (obj instanceof ByteString) {
                    T = CodedOutputStream.h((ByteString) obj);
                } else {
                    T = CodedOutputStream.T((String) obj);
                }
                U += T;
                i9++;
            }
        }
        return U;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int v(int i8, List<Integer> list, boolean z7) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int w7 = w(list);
        if (z7) {
            return CodedOutputStream.U(i8) + CodedOutputStream.C(w7);
        }
        return w7 + (size * CodedOutputStream.U(i8));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int w(List<Integer> list) {
        int i8;
        int size = list.size();
        int i9 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof IntArrayList) {
            IntArrayList intArrayList = (IntArrayList) list;
            i8 = 0;
            while (i9 < size) {
                i8 += CodedOutputStream.W(intArrayList.getInt(i9));
                i9++;
            }
        } else {
            i8 = 0;
            while (i9 < size) {
                i8 += CodedOutputStream.W(list.get(i9).intValue());
                i9++;
            }
        }
        return i8;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int x(int i8, List<Long> list, boolean z7) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int y7 = y(list);
        if (z7) {
            return CodedOutputStream.U(i8) + CodedOutputStream.C(y7);
        }
        return y7 + (size * CodedOutputStream.U(i8));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int y(List<Long> list) {
        int i8;
        int size = list.size();
        int i9 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof LongArrayList) {
            LongArrayList longArrayList = (LongArrayList) list;
            i8 = 0;
            while (i9 < size) {
                i8 += CodedOutputStream.Y(longArrayList.getLong(i9));
                i9++;
            }
        } else {
            i8 = 0;
            while (i9 < size) {
                i8 += CodedOutputStream.Y(list.get(i9).longValue());
                i9++;
            }
        }
        return i8;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <UT, UB> UB z(int i8, List<Integer> list, Internal.EnumLiteMap<?> enumLiteMap, UB ub, UnknownFieldSchema<UT, UB> unknownFieldSchema) {
        if (enumLiteMap == null) {
            return ub;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i9 = 0;
            for (int i10 = 0; i10 < size; i10++) {
                int intValue = list.get(i10).intValue();
                if (enumLiteMap.a(intValue) != null) {
                    if (i10 != i9) {
                        list.set(i9, Integer.valueOf(intValue));
                    }
                    i9++;
                } else {
                    ub = (UB) L(i8, intValue, ub, unknownFieldSchema);
                }
            }
            if (i9 != size) {
                list.subList(i9, size).clear();
            }
        } else {
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()) {
                int intValue2 = it.next().intValue();
                if (enumLiteMap.a(intValue2) == null) {
                    ub = (UB) L(i8, intValue2, ub, unknownFieldSchema);
                    it.remove();
                }
            }
        }
        return ub;
    }
}
