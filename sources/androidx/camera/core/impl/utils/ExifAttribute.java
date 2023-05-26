package androidx.camera.core.impl.utils;

import androidx.annotation.NonNull;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/* loaded from: classes.dex */
final class ExifAttribute {

    /* renamed from: e  reason: collision with root package name */
    static final Charset f3771e = StandardCharsets.US_ASCII;

    /* renamed from: f  reason: collision with root package name */
    static final String[] f3772f = {"", "BYTE", "STRING", "USHORT", "ULONG", "URATIONAL", "SBYTE", "UNDEFINED", "SSHORT", "SLONG", "SRATIONAL", "SINGLE", "DOUBLE", "IFD"};

    /* renamed from: g  reason: collision with root package name */
    static final int[] f3773g = {0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8, 1};

    /* renamed from: h  reason: collision with root package name */
    static final byte[] f3774h = {65, 83, 67, 73, 73, 0, 0, 0};

    /* renamed from: a  reason: collision with root package name */
    public final int f3775a;

    /* renamed from: b  reason: collision with root package name */
    public final int f3776b;

    /* renamed from: c  reason: collision with root package name */
    public final long f3777c;

    /* renamed from: d  reason: collision with root package name */
    public final byte[] f3778d;

    ExifAttribute(int i8, int i9, byte[] bArr) {
        this(i8, i9, -1L, bArr);
    }

    @NonNull
    public static ExifAttribute a(@NonNull String str) {
        if (str.length() == 1 && str.charAt(0) >= '0' && str.charAt(0) <= '1') {
            return new ExifAttribute(1, 1, new byte[]{(byte) (str.charAt(0) - '0')});
        }
        byte[] bytes = str.getBytes(f3771e);
        return new ExifAttribute(1, bytes.length, bytes);
    }

    @NonNull
    public static ExifAttribute b(@NonNull double[] dArr, @NonNull ByteOrder byteOrder) {
        ByteBuffer wrap = ByteBuffer.wrap(new byte[f3773g[12] * dArr.length]);
        wrap.order(byteOrder);
        for (double d8 : dArr) {
            wrap.putDouble(d8);
        }
        return new ExifAttribute(12, dArr.length, wrap.array());
    }

    @NonNull
    public static ExifAttribute c(@NonNull int[] iArr, @NonNull ByteOrder byteOrder) {
        ByteBuffer wrap = ByteBuffer.wrap(new byte[f3773g[9] * iArr.length]);
        wrap.order(byteOrder);
        for (int i8 : iArr) {
            wrap.putInt(i8);
        }
        return new ExifAttribute(9, iArr.length, wrap.array());
    }

    @NonNull
    public static ExifAttribute d(@NonNull LongRational[] longRationalArr, @NonNull ByteOrder byteOrder) {
        ByteBuffer wrap = ByteBuffer.wrap(new byte[f3773g[10] * longRationalArr.length]);
        wrap.order(byteOrder);
        for (LongRational longRational : longRationalArr) {
            wrap.putInt((int) longRational.b());
            wrap.putInt((int) longRational.a());
        }
        return new ExifAttribute(10, longRationalArr.length, wrap.array());
    }

    @NonNull
    public static ExifAttribute e(@NonNull String str) {
        byte[] bytes = (str + (char) 0).getBytes(f3771e);
        return new ExifAttribute(2, bytes.length, bytes);
    }

    @NonNull
    public static ExifAttribute f(long j8, @NonNull ByteOrder byteOrder) {
        return g(new long[]{j8}, byteOrder);
    }

    @NonNull
    public static ExifAttribute g(@NonNull long[] jArr, @NonNull ByteOrder byteOrder) {
        ByteBuffer wrap = ByteBuffer.wrap(new byte[f3773g[4] * jArr.length]);
        wrap.order(byteOrder);
        for (long j8 : jArr) {
            wrap.putInt((int) j8);
        }
        return new ExifAttribute(4, jArr.length, wrap.array());
    }

    @NonNull
    public static ExifAttribute h(@NonNull LongRational[] longRationalArr, @NonNull ByteOrder byteOrder) {
        ByteBuffer wrap = ByteBuffer.wrap(new byte[f3773g[5] * longRationalArr.length]);
        wrap.order(byteOrder);
        for (LongRational longRational : longRationalArr) {
            wrap.putInt((int) longRational.b());
            wrap.putInt((int) longRational.a());
        }
        return new ExifAttribute(5, longRationalArr.length, wrap.array());
    }

    @NonNull
    public static ExifAttribute i(@NonNull int[] iArr, @NonNull ByteOrder byteOrder) {
        ByteBuffer wrap = ByteBuffer.wrap(new byte[f3773g[3] * iArr.length]);
        wrap.order(byteOrder);
        for (int i8 : iArr) {
            wrap.putShort((short) i8);
        }
        return new ExifAttribute(3, iArr.length, wrap.array());
    }

    public int j() {
        return f3773g[this.f3775a] * this.f3776b;
    }

    public String toString() {
        return "(" + f3772f[this.f3775a] + ", data length:" + this.f3778d.length + ")";
    }

    ExifAttribute(int i8, int i9, long j8, byte[] bArr) {
        this.f3775a = i8;
        this.f3776b = i9;
        this.f3777c = j8;
        this.f3778d = bArr;
    }
}
