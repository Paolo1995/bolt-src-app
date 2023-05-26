package com.google.crypto.tink.shaded.protobuf;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.List;
import java.util.RandomAccess;

/* loaded from: classes.dex */
public final class Internal {

    /* renamed from: a  reason: collision with root package name */
    static final Charset f15115a = Charset.forName("UTF-8");

    /* renamed from: b  reason: collision with root package name */
    static final Charset f15116b = Charset.forName("ISO-8859-1");

    /* renamed from: c  reason: collision with root package name */
    public static final byte[] f15117c;

    /* renamed from: d  reason: collision with root package name */
    public static final ByteBuffer f15118d;

    /* renamed from: e  reason: collision with root package name */
    public static final CodedInputStream f15119e;

    /* loaded from: classes.dex */
    public interface BooleanList extends ProtobufList<Boolean> {
    }

    /* loaded from: classes.dex */
    public interface DoubleList extends ProtobufList<Double> {
    }

    /* loaded from: classes.dex */
    public interface EnumLite {
        int getNumber();
    }

    /* loaded from: classes.dex */
    public interface EnumLiteMap<T extends EnumLite> {
        T a(int i8);
    }

    /* loaded from: classes.dex */
    public interface EnumVerifier {
        boolean a(int i8);
    }

    /* loaded from: classes.dex */
    public interface FloatList extends ProtobufList<Float> {
    }

    /* loaded from: classes.dex */
    public interface IntList extends ProtobufList<Integer> {
    }

    /* loaded from: classes.dex */
    public interface LongList extends ProtobufList<Long> {
    }

    /* loaded from: classes.dex */
    public interface ProtobufList<E> extends List<E>, RandomAccess {
        ProtobufList<E> a(int i8);

        void c();

        boolean h();
    }

    static {
        byte[] bArr = new byte[0];
        f15117c = bArr;
        f15118d = ByteBuffer.wrap(bArr);
        f15119e = CodedInputStream.f(bArr);
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
        return Utf8.m(bArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object h(Object obj, Object obj2) {
        return ((MessageLite) obj).toBuilder().I((MessageLite) obj2).g();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int i(int i8, byte[] bArr, int i9, int i10) {
        for (int i11 = i9; i11 < i9 + i10; i11++) {
            i8 = (i8 * 31) + bArr[i11];
        }
        return i8;
    }

    public static String j(byte[] bArr) {
        return new String(bArr, f15115a);
    }
}
