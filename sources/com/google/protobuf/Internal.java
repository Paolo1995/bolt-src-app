package com.google.protobuf;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.AbstractList;
import java.util.List;
import java.util.RandomAccess;

/* loaded from: classes3.dex */
public final class Internal {

    /* renamed from: a  reason: collision with root package name */
    static final Charset f17449a = Charset.forName("US-ASCII");

    /* renamed from: b  reason: collision with root package name */
    static final Charset f17450b = Charset.forName("UTF-8");

    /* renamed from: c  reason: collision with root package name */
    static final Charset f17451c = Charset.forName("ISO-8859-1");

    /* renamed from: d  reason: collision with root package name */
    public static final byte[] f17452d;

    /* renamed from: e  reason: collision with root package name */
    public static final ByteBuffer f17453e;

    /* renamed from: f  reason: collision with root package name */
    public static final CodedInputStream f17454f;

    /* loaded from: classes3.dex */
    public interface BooleanList extends ProtobufList<Boolean> {
        @Override // 
        ProtobufList<Boolean> a(int i8);
    }

    /* loaded from: classes3.dex */
    public interface DoubleList extends ProtobufList<Double> {
        void K0(double d8);

        @Override // com.google.protobuf.Internal.ProtobufList, com.google.protobuf.Internal.BooleanList
        ProtobufList<Double> a(int i8);

        double d0(int i8, double d8);

        double getDouble(int i8);
    }

    /* loaded from: classes3.dex */
    public interface EnumLite {
        int getNumber();
    }

    /* loaded from: classes3.dex */
    public interface EnumLiteMap<T extends EnumLite> {
        T a(int i8);
    }

    /* loaded from: classes3.dex */
    public interface EnumVerifier {
        boolean a(int i8);
    }

    /* loaded from: classes3.dex */
    public interface FloatList extends ProtobufList<Float> {
        @Override // com.google.protobuf.Internal.ProtobufList, com.google.protobuf.Internal.BooleanList
        ProtobufList<Float> a(int i8);
    }

    /* loaded from: classes3.dex */
    public interface IntList extends ProtobufList<Integer> {
        @Override // com.google.protobuf.Internal.ProtobufList, com.google.protobuf.Internal.BooleanList
        ProtobufList<Integer> a(int i8);

        int getInt(int i8);

        int q(int i8, int i9);

        void s0(int i8);
    }

    /* loaded from: classes3.dex */
    public static class ListAdapter<F, T> extends AbstractList<T> {

        /* renamed from: f  reason: collision with root package name */
        private final List<F> f17455f;

        /* renamed from: g  reason: collision with root package name */
        private final Converter<F, T> f17456g;

        /* loaded from: classes3.dex */
        public interface Converter<F, T> {
            T convert(F f8);
        }

        public ListAdapter(List<F> list, Converter<F, T> converter) {
            this.f17455f = list;
            this.f17456g = converter;
        }

        @Override // java.util.AbstractList, java.util.List
        public T get(int i8) {
            return this.f17456g.convert(this.f17455f.get(i8));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.f17455f.size();
        }
    }

    /* loaded from: classes3.dex */
    public interface LongList extends ProtobufList<Long> {
        long S0(int i8, long j8);

        @Override // com.google.protobuf.Internal.ProtobufList, com.google.protobuf.Internal.BooleanList
        ProtobufList<Long> a(int i8);

        long getLong(int i8);

        void v0(long j8);
    }

    /* loaded from: classes3.dex */
    public interface ProtobufList<E> extends List<E>, RandomAccess {
        ProtobufList<E> a(int i8);

        void c();

        boolean h();
    }

    static {
        byte[] bArr = new byte[0];
        f17452d = bArr;
        f17453e = ByteBuffer.wrap(bArr);
        f17454f = CodedInputStream.m(bArr);
    }

    private Internal() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> T a(T t7) {
        t7.getClass();
        return t7;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> T b(T t7, String str) {
        if (t7 != null) {
            return t7;
        }
        throw new NullPointerException(str);
    }

    public static int c(boolean z7) {
        return z7 ? 1231 : 1237;
    }

    public static int d(byte[] bArr) {
        return e(bArr, 0, bArr.length);
    }

    static int e(byte[] bArr, int i8, int i9) {
        int i10 = i(i9, bArr, i8, i9);
        if (i10 == 0) {
            return 1;
        }
        return i10;
    }

    public static int f(long j8) {
        return (int) (j8 ^ (j8 >>> 32));
    }

    public static boolean g(byte[] bArr) {
        return Utf8.s(bArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object h(Object obj, Object obj2) {
        return ((MessageLite) obj).toBuilder().w((MessageLite) obj2).g();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int i(int i8, byte[] bArr, int i9, int i10) {
        for (int i11 = i9; i11 < i9 + i10; i11++) {
            i8 = (i8 * 31) + bArr[i11];
        }
        return i8;
    }

    public static String j(byte[] bArr) {
        return new String(bArr, f17450b);
    }
}
