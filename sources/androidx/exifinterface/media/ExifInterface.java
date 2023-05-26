package androidx.exifinterface.media;

import android.content.res.AssetManager;
import android.location.Location;
import android.media.MediaDataSource;
import android.media.MediaMetadataRetriever;
import android.os.Build;
import android.system.OsConstants;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.exifinterface.media.ExifInterfaceUtils;
import androidx.fragment.app.FragmentTransaction;
import com.google.android.gms.common.api.Api;
import j$.util.DesugarTimeZone;
import j$.util.Spliterator;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.CRC32;
import okhttp3.internal.ws.WebSocketProtocol;

/* loaded from: classes.dex */
public class ExifInterface {
    private static SimpleDateFormat U;
    private static SimpleDateFormat V;
    private static final ExifTag[] Z;

    /* renamed from: a0  reason: collision with root package name */
    private static final ExifTag[] f6552a0;

    /* renamed from: b0  reason: collision with root package name */
    private static final ExifTag[] f6553b0;

    /* renamed from: c0  reason: collision with root package name */
    private static final ExifTag[] f6554c0;

    /* renamed from: d0  reason: collision with root package name */
    private static final ExifTag[] f6555d0;

    /* renamed from: e0  reason: collision with root package name */
    private static final ExifTag f6556e0;

    /* renamed from: f0  reason: collision with root package name */
    private static final ExifTag[] f6557f0;

    /* renamed from: g0  reason: collision with root package name */
    private static final ExifTag[] f6558g0;

    /* renamed from: h0  reason: collision with root package name */
    private static final ExifTag[] f6559h0;

    /* renamed from: i0  reason: collision with root package name */
    private static final ExifTag[] f6560i0;

    /* renamed from: j0  reason: collision with root package name */
    static final ExifTag[][] f6561j0;

    /* renamed from: k0  reason: collision with root package name */
    private static final ExifTag[] f6562k0;

    /* renamed from: l0  reason: collision with root package name */
    private static final HashMap<Integer, ExifTag>[] f6563l0;

    /* renamed from: m0  reason: collision with root package name */
    private static final HashMap<String, ExifTag>[] f6564m0;

    /* renamed from: n0  reason: collision with root package name */
    private static final HashSet<String> f6565n0;

    /* renamed from: o0  reason: collision with root package name */
    private static final HashMap<Integer, Integer> f6566o0;

    /* renamed from: p0  reason: collision with root package name */
    static final Charset f6567p0;

    /* renamed from: q0  reason: collision with root package name */
    static final byte[] f6568q0;

    /* renamed from: r0  reason: collision with root package name */
    private static final byte[] f6569r0;

    /* renamed from: s0  reason: collision with root package name */
    private static final Pattern f6570s0;

    /* renamed from: t0  reason: collision with root package name */
    private static final Pattern f6571t0;

    /* renamed from: u0  reason: collision with root package name */
    private static final Pattern f6572u0;

    /* renamed from: v0  reason: collision with root package name */
    private static final Pattern f6574v0;

    /* renamed from: a  reason: collision with root package name */
    private String f6579a;

    /* renamed from: b  reason: collision with root package name */
    private FileDescriptor f6580b;

    /* renamed from: c  reason: collision with root package name */
    private AssetManager.AssetInputStream f6581c;

    /* renamed from: d  reason: collision with root package name */
    private int f6582d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f6583e;

    /* renamed from: f  reason: collision with root package name */
    private final HashMap<String, ExifAttribute>[] f6584f;

    /* renamed from: g  reason: collision with root package name */
    private Set<Integer> f6585g;

    /* renamed from: h  reason: collision with root package name */
    private ByteOrder f6586h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f6587i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f6588j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f6589k;

    /* renamed from: l  reason: collision with root package name */
    private int f6590l;

    /* renamed from: m  reason: collision with root package name */
    private int f6591m;

    /* renamed from: n  reason: collision with root package name */
    private byte[] f6592n;

    /* renamed from: o  reason: collision with root package name */
    private int f6593o;

    /* renamed from: p  reason: collision with root package name */
    private int f6594p;

    /* renamed from: q  reason: collision with root package name */
    private int f6595q;

    /* renamed from: r  reason: collision with root package name */
    private int f6596r;

    /* renamed from: s  reason: collision with root package name */
    private int f6597s;

    /* renamed from: t  reason: collision with root package name */
    private boolean f6598t;

    /* renamed from: u  reason: collision with root package name */
    private boolean f6599u;

    /* renamed from: v  reason: collision with root package name */
    private static final boolean f6573v = Log.isLoggable("ExifInterface", 3);

    /* renamed from: w  reason: collision with root package name */
    private static final List<Integer> f6575w = Arrays.asList(1, 6, 3, 8);

    /* renamed from: x  reason: collision with root package name */
    private static final List<Integer> f6576x = Arrays.asList(2, 7, 4, 5);

    /* renamed from: y  reason: collision with root package name */
    public static final int[] f6577y = {8, 8, 8};

    /* renamed from: z  reason: collision with root package name */
    public static final int[] f6578z = {4};
    public static final int[] A = {8};
    static final byte[] B = {-1, -40, -1};
    private static final byte[] C = {102, 116, 121, 112};
    private static final byte[] D = {109, 105, 102, 49};
    private static final byte[] E = {104, 101, 105, 99};
    private static final byte[] F = {79, 76, 89, 77, 80, 0};
    private static final byte[] G = {79, 76, 89, 77, 80, 85, 83, 0, 73, 73};
    private static final byte[] H = {-119, 80, 78, 71, 13, 10, 26, 10};
    private static final byte[] I = {101, 88, 73, 102};
    private static final byte[] J = {73, 72, 68, 82};
    private static final byte[] K = {73, 69, 78, 68};
    private static final byte[] L = {82, 73, 70, 70};
    private static final byte[] M = {87, 69, 66, 80};
    private static final byte[] N = {69, 88, 73, 70};
    private static final byte[] O = {-99, 1, 42};
    private static final byte[] P = "VP8X".getBytes(Charset.defaultCharset());
    private static final byte[] Q = "VP8L".getBytes(Charset.defaultCharset());
    private static final byte[] R = "VP8 ".getBytes(Charset.defaultCharset());
    private static final byte[] S = "ANIM".getBytes(Charset.defaultCharset());
    private static final byte[] T = "ANMF".getBytes(Charset.defaultCharset());
    static final String[] W = {"", "BYTE", "STRING", "USHORT", "ULONG", "URATIONAL", "SBYTE", "UNDEFINED", "SSHORT", "SLONG", "SRATIONAL", "SINGLE", "DOUBLE", "IFD"};
    static final int[] X = {0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8, 1};
    static final byte[] Y = {65, 83, 67, 73, 73, 0, 0, 0};

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class ByteOrderedDataInputStream extends InputStream implements DataInput {

        /* renamed from: j  reason: collision with root package name */
        private static final ByteOrder f6603j = ByteOrder.LITTLE_ENDIAN;

        /* renamed from: k  reason: collision with root package name */
        private static final ByteOrder f6604k = ByteOrder.BIG_ENDIAN;

        /* renamed from: f  reason: collision with root package name */
        final DataInputStream f6605f;

        /* renamed from: g  reason: collision with root package name */
        private ByteOrder f6606g;

        /* renamed from: h  reason: collision with root package name */
        int f6607h;

        /* renamed from: i  reason: collision with root package name */
        private byte[] f6608i;

        ByteOrderedDataInputStream(byte[] bArr) throws IOException {
            this(new ByteArrayInputStream(bArr), ByteOrder.BIG_ENDIAN);
        }

        public int a() {
            return this.f6607h;
        }

        @Override // java.io.InputStream
        public int available() throws IOException {
            return this.f6605f.available();
        }

        public long c() throws IOException {
            return readInt() & 4294967295L;
        }

        public void e(ByteOrder byteOrder) {
            this.f6606g = byteOrder;
        }

        public void g(int i8) throws IOException {
            int i9 = 0;
            while (i9 < i8) {
                int i10 = i8 - i9;
                int skip = (int) this.f6605f.skip(i10);
                if (skip <= 0) {
                    if (this.f6608i == null) {
                        this.f6608i = new byte[FragmentTransaction.TRANSIT_EXIT_MASK];
                    }
                    skip = this.f6605f.read(this.f6608i, 0, Math.min((int) FragmentTransaction.TRANSIT_EXIT_MASK, i10));
                    if (skip == -1) {
                        throw new EOFException("Reached EOF while skipping " + i8 + " bytes.");
                    }
                }
                i9 += skip;
            }
            this.f6607h += i9;
        }

        @Override // java.io.InputStream
        public void mark(int i8) {
            throw new UnsupportedOperationException("Mark is currently unsupported");
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            this.f6607h++;
            return this.f6605f.read();
        }

        @Override // java.io.DataInput
        public boolean readBoolean() throws IOException {
            this.f6607h++;
            return this.f6605f.readBoolean();
        }

        @Override // java.io.DataInput
        public byte readByte() throws IOException {
            this.f6607h++;
            int read = this.f6605f.read();
            if (read >= 0) {
                return (byte) read;
            }
            throw new EOFException();
        }

        @Override // java.io.DataInput
        public char readChar() throws IOException {
            this.f6607h += 2;
            return this.f6605f.readChar();
        }

        @Override // java.io.DataInput
        public double readDouble() throws IOException {
            return Double.longBitsToDouble(readLong());
        }

        @Override // java.io.DataInput
        public float readFloat() throws IOException {
            return Float.intBitsToFloat(readInt());
        }

        @Override // java.io.DataInput
        public void readFully(byte[] bArr, int i8, int i9) throws IOException {
            this.f6607h += i9;
            this.f6605f.readFully(bArr, i8, i9);
        }

        @Override // java.io.DataInput
        public int readInt() throws IOException {
            this.f6607h += 4;
            int read = this.f6605f.read();
            int read2 = this.f6605f.read();
            int read3 = this.f6605f.read();
            int read4 = this.f6605f.read();
            if ((read | read2 | read3 | read4) >= 0) {
                ByteOrder byteOrder = this.f6606g;
                if (byteOrder == f6603j) {
                    return (read4 << 24) + (read3 << 16) + (read2 << 8) + read;
                }
                if (byteOrder == f6604k) {
                    return (read << 24) + (read2 << 16) + (read3 << 8) + read4;
                }
                throw new IOException("Invalid byte order: " + this.f6606g);
            }
            throw new EOFException();
        }

        @Override // java.io.DataInput
        public String readLine() throws IOException {
            Log.d("ExifInterface", "Currently unsupported");
            return null;
        }

        @Override // java.io.DataInput
        public long readLong() throws IOException {
            this.f6607h += 8;
            int read = this.f6605f.read();
            int read2 = this.f6605f.read();
            int read3 = this.f6605f.read();
            int read4 = this.f6605f.read();
            int read5 = this.f6605f.read();
            int read6 = this.f6605f.read();
            int read7 = this.f6605f.read();
            int read8 = this.f6605f.read();
            if ((read | read2 | read3 | read4 | read5 | read6 | read7 | read8) >= 0) {
                ByteOrder byteOrder = this.f6606g;
                if (byteOrder == f6603j) {
                    return (read8 << 56) + (read7 << 48) + (read6 << 40) + (read5 << 32) + (read4 << 24) + (read3 << 16) + (read2 << 8) + read;
                }
                if (byteOrder == f6604k) {
                    return (read << 56) + (read2 << 48) + (read3 << 40) + (read4 << 32) + (read5 << 24) + (read6 << 16) + (read7 << 8) + read8;
                }
                throw new IOException("Invalid byte order: " + this.f6606g);
            }
            throw new EOFException();
        }

        @Override // java.io.DataInput
        public short readShort() throws IOException {
            this.f6607h += 2;
            int read = this.f6605f.read();
            int read2 = this.f6605f.read();
            if ((read | read2) >= 0) {
                ByteOrder byteOrder = this.f6606g;
                if (byteOrder == f6603j) {
                    return (short) ((read2 << 8) + read);
                }
                if (byteOrder == f6604k) {
                    return (short) ((read << 8) + read2);
                }
                throw new IOException("Invalid byte order: " + this.f6606g);
            }
            throw new EOFException();
        }

        @Override // java.io.DataInput
        public String readUTF() throws IOException {
            this.f6607h += 2;
            return this.f6605f.readUTF();
        }

        @Override // java.io.DataInput
        public int readUnsignedByte() throws IOException {
            this.f6607h++;
            return this.f6605f.readUnsignedByte();
        }

        @Override // java.io.DataInput
        public int readUnsignedShort() throws IOException {
            this.f6607h += 2;
            int read = this.f6605f.read();
            int read2 = this.f6605f.read();
            if ((read | read2) >= 0) {
                ByteOrder byteOrder = this.f6606g;
                if (byteOrder == f6603j) {
                    return (read2 << 8) + read;
                }
                if (byteOrder == f6604k) {
                    return (read << 8) + read2;
                }
                throw new IOException("Invalid byte order: " + this.f6606g);
            }
            throw new EOFException();
        }

        @Override // java.io.InputStream
        public void reset() {
            throw new UnsupportedOperationException("Reset is currently unsupported");
        }

        @Override // java.io.DataInput
        public int skipBytes(int i8) throws IOException {
            throw new UnsupportedOperationException("skipBytes is currently unsupported");
        }

        ByteOrderedDataInputStream(InputStream inputStream) throws IOException {
            this(inputStream, ByteOrder.BIG_ENDIAN);
        }

        ByteOrderedDataInputStream(InputStream inputStream, ByteOrder byteOrder) throws IOException {
            this.f6606g = ByteOrder.BIG_ENDIAN;
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            this.f6605f = dataInputStream;
            dataInputStream.mark(0);
            this.f6607h = 0;
            this.f6606g = byteOrder;
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i8, int i9) throws IOException {
            int read = this.f6605f.read(bArr, i8, i9);
            this.f6607h += read;
            return read;
        }

        @Override // java.io.DataInput
        public void readFully(byte[] bArr) throws IOException {
            this.f6607h += bArr.length;
            this.f6605f.readFully(bArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class ByteOrderedDataOutputStream extends FilterOutputStream {

        /* renamed from: f  reason: collision with root package name */
        final OutputStream f6609f;

        /* renamed from: g  reason: collision with root package name */
        private ByteOrder f6610g;

        public ByteOrderedDataOutputStream(OutputStream outputStream, ByteOrder byteOrder) {
            super(outputStream);
            this.f6609f = outputStream;
            this.f6610g = byteOrder;
        }

        public void a(ByteOrder byteOrder) {
            this.f6610g = byteOrder;
        }

        public void c(int i8) throws IOException {
            this.f6609f.write(i8);
        }

        public void e(int i8) throws IOException {
            ByteOrder byteOrder = this.f6610g;
            if (byteOrder == ByteOrder.LITTLE_ENDIAN) {
                this.f6609f.write((i8 >>> 0) & 255);
                this.f6609f.write((i8 >>> 8) & 255);
                this.f6609f.write((i8 >>> 16) & 255);
                this.f6609f.write((i8 >>> 24) & 255);
            } else if (byteOrder == ByteOrder.BIG_ENDIAN) {
                this.f6609f.write((i8 >>> 24) & 255);
                this.f6609f.write((i8 >>> 16) & 255);
                this.f6609f.write((i8 >>> 8) & 255);
                this.f6609f.write((i8 >>> 0) & 255);
            }
        }

        public void g(short s7) throws IOException {
            ByteOrder byteOrder = this.f6610g;
            if (byteOrder == ByteOrder.LITTLE_ENDIAN) {
                this.f6609f.write((s7 >>> 0) & 255);
                this.f6609f.write((s7 >>> 8) & 255);
            } else if (byteOrder == ByteOrder.BIG_ENDIAN) {
                this.f6609f.write((s7 >>> 8) & 255);
                this.f6609f.write((s7 >>> 0) & 255);
            }
        }

        public void h(long j8) throws IOException {
            e((int) j8);
        }

        public void j(int i8) throws IOException {
            g((short) i8);
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream
        public void write(byte[] bArr) throws IOException {
            this.f6609f.write(bArr);
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream
        public void write(byte[] bArr, int i8, int i9) throws IOException {
            this.f6609f.write(bArr, i8, i9);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class ExifAttribute {

        /* renamed from: a  reason: collision with root package name */
        public final int f6611a;

        /* renamed from: b  reason: collision with root package name */
        public final int f6612b;

        /* renamed from: c  reason: collision with root package name */
        public final long f6613c;

        /* renamed from: d  reason: collision with root package name */
        public final byte[] f6614d;

        ExifAttribute(int i8, int i9, byte[] bArr) {
            this(i8, i9, -1L, bArr);
        }

        public static ExifAttribute a(String str) {
            if (str.length() == 1 && str.charAt(0) >= '0' && str.charAt(0) <= '1') {
                return new ExifAttribute(1, 1, new byte[]{(byte) (str.charAt(0) - '0')});
            }
            byte[] bytes = str.getBytes(ExifInterface.f6567p0);
            return new ExifAttribute(1, bytes.length, bytes);
        }

        public static ExifAttribute b(double[] dArr, ByteOrder byteOrder) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[ExifInterface.X[12] * dArr.length]);
            wrap.order(byteOrder);
            for (double d8 : dArr) {
                wrap.putDouble(d8);
            }
            return new ExifAttribute(12, dArr.length, wrap.array());
        }

        public static ExifAttribute c(int[] iArr, ByteOrder byteOrder) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[ExifInterface.X[9] * iArr.length]);
            wrap.order(byteOrder);
            for (int i8 : iArr) {
                wrap.putInt(i8);
            }
            return new ExifAttribute(9, iArr.length, wrap.array());
        }

        public static ExifAttribute d(Rational[] rationalArr, ByteOrder byteOrder) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[ExifInterface.X[10] * rationalArr.length]);
            wrap.order(byteOrder);
            for (Rational rational : rationalArr) {
                wrap.putInt((int) rational.f6619a);
                wrap.putInt((int) rational.f6620b);
            }
            return new ExifAttribute(10, rationalArr.length, wrap.array());
        }

        public static ExifAttribute e(String str) {
            byte[] bytes = (str + (char) 0).getBytes(ExifInterface.f6567p0);
            return new ExifAttribute(2, bytes.length, bytes);
        }

        public static ExifAttribute f(long j8, ByteOrder byteOrder) {
            return g(new long[]{j8}, byteOrder);
        }

        public static ExifAttribute g(long[] jArr, ByteOrder byteOrder) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[ExifInterface.X[4] * jArr.length]);
            wrap.order(byteOrder);
            for (long j8 : jArr) {
                wrap.putInt((int) j8);
            }
            return new ExifAttribute(4, jArr.length, wrap.array());
        }

        public static ExifAttribute h(Rational rational, ByteOrder byteOrder) {
            return i(new Rational[]{rational}, byteOrder);
        }

        public static ExifAttribute i(Rational[] rationalArr, ByteOrder byteOrder) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[ExifInterface.X[5] * rationalArr.length]);
            wrap.order(byteOrder);
            for (Rational rational : rationalArr) {
                wrap.putInt((int) rational.f6619a);
                wrap.putInt((int) rational.f6620b);
            }
            return new ExifAttribute(5, rationalArr.length, wrap.array());
        }

        public static ExifAttribute j(int i8, ByteOrder byteOrder) {
            return k(new int[]{i8}, byteOrder);
        }

        public static ExifAttribute k(int[] iArr, ByteOrder byteOrder) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[ExifInterface.X[3] * iArr.length]);
            wrap.order(byteOrder);
            for (int i8 : iArr) {
                wrap.putShort((short) i8);
            }
            return new ExifAttribute(3, iArr.length, wrap.array());
        }

        public double l(ByteOrder byteOrder) {
            Object o8 = o(byteOrder);
            if (o8 != null) {
                if (o8 instanceof String) {
                    return Double.parseDouble((String) o8);
                }
                if (o8 instanceof long[]) {
                    long[] jArr = (long[]) o8;
                    if (jArr.length == 1) {
                        return jArr[0];
                    }
                    throw new NumberFormatException("There are more than one component");
                } else if (o8 instanceof int[]) {
                    int[] iArr = (int[]) o8;
                    if (iArr.length == 1) {
                        return iArr[0];
                    }
                    throw new NumberFormatException("There are more than one component");
                } else if (o8 instanceof double[]) {
                    double[] dArr = (double[]) o8;
                    if (dArr.length == 1) {
                        return dArr[0];
                    }
                    throw new NumberFormatException("There are more than one component");
                } else if (o8 instanceof Rational[]) {
                    Rational[] rationalArr = (Rational[]) o8;
                    if (rationalArr.length == 1) {
                        return rationalArr[0].a();
                    }
                    throw new NumberFormatException("There are more than one component");
                } else {
                    throw new NumberFormatException("Couldn't find a double value");
                }
            }
            throw new NumberFormatException("NULL can't be converted to a double value");
        }

        public int m(ByteOrder byteOrder) {
            Object o8 = o(byteOrder);
            if (o8 != null) {
                if (o8 instanceof String) {
                    return Integer.parseInt((String) o8);
                }
                if (o8 instanceof long[]) {
                    long[] jArr = (long[]) o8;
                    if (jArr.length == 1) {
                        return (int) jArr[0];
                    }
                    throw new NumberFormatException("There are more than one component");
                } else if (o8 instanceof int[]) {
                    int[] iArr = (int[]) o8;
                    if (iArr.length == 1) {
                        return iArr[0];
                    }
                    throw new NumberFormatException("There are more than one component");
                } else {
                    throw new NumberFormatException("Couldn't find a integer value");
                }
            }
            throw new NumberFormatException("NULL can't be converted to a integer value");
        }

        public String n(ByteOrder byteOrder) {
            Object o8 = o(byteOrder);
            if (o8 == null) {
                return null;
            }
            if (o8 instanceof String) {
                return (String) o8;
            }
            StringBuilder sb = new StringBuilder();
            int i8 = 0;
            if (o8 instanceof long[]) {
                long[] jArr = (long[]) o8;
                while (i8 < jArr.length) {
                    sb.append(jArr[i8]);
                    i8++;
                    if (i8 != jArr.length) {
                        sb.append(",");
                    }
                }
                return sb.toString();
            } else if (o8 instanceof int[]) {
                int[] iArr = (int[]) o8;
                while (i8 < iArr.length) {
                    sb.append(iArr[i8]);
                    i8++;
                    if (i8 != iArr.length) {
                        sb.append(",");
                    }
                }
                return sb.toString();
            } else if (o8 instanceof double[]) {
                double[] dArr = (double[]) o8;
                while (i8 < dArr.length) {
                    sb.append(dArr[i8]);
                    i8++;
                    if (i8 != dArr.length) {
                        sb.append(",");
                    }
                }
                return sb.toString();
            } else if (!(o8 instanceof Rational[])) {
                return null;
            } else {
                Rational[] rationalArr = (Rational[]) o8;
                while (i8 < rationalArr.length) {
                    sb.append(rationalArr[i8].f6619a);
                    sb.append('/');
                    sb.append(rationalArr[i8].f6620b);
                    i8++;
                    if (i8 != rationalArr.length) {
                        sb.append(",");
                    }
                }
                return sb.toString();
            }
        }

        /* JADX WARN: Not initialized variable reg: 3, insn: 0x0198: MOVE  (r2 I:??[OBJECT, ARRAY]) = (r3 I:??[OBJECT, ARRAY]), block:B:151:0x0198 */
        /* JADX WARN: Removed duplicated region for block: B:182:0x019b A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        java.lang.Object o(java.nio.ByteOrder r11) {
            /*
                Method dump skipped, instructions count: 448
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.exifinterface.media.ExifInterface.ExifAttribute.o(java.nio.ByteOrder):java.lang.Object");
        }

        public int p() {
            return ExifInterface.X[this.f6611a] * this.f6612b;
        }

        public String toString() {
            return "(" + ExifInterface.W[this.f6611a] + ", data length:" + this.f6614d.length + ")";
        }

        ExifAttribute(int i8, int i9, long j8, byte[] bArr) {
            this.f6611a = i8;
            this.f6612b = i9;
            this.f6613c = j8;
            this.f6614d = bArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class Rational {

        /* renamed from: a  reason: collision with root package name */
        public final long f6619a;

        /* renamed from: b  reason: collision with root package name */
        public final long f6620b;

        Rational(double d8) {
            this((long) (d8 * 10000.0d), 10000L);
        }

        public double a() {
            return this.f6619a / this.f6620b;
        }

        public String toString() {
            return this.f6619a + "/" + this.f6620b;
        }

        Rational(long j8, long j9) {
            if (j9 == 0) {
                this.f6619a = 0L;
                this.f6620b = 1L;
                return;
            }
            this.f6619a = j8;
            this.f6620b = j9;
        }
    }

    static {
        ExifTag[] exifTagArr;
        ExifTag[] exifTagArr2 = {new ExifTag("NewSubfileType", 254, 4), new ExifTag("SubfileType", 255, 4), new ExifTag("ImageWidth", Spliterator.NONNULL, 3, 4), new ExifTag("ImageLength", 257, 3, 4), new ExifTag("BitsPerSample", 258, 3), new ExifTag("Compression", 259, 3), new ExifTag("PhotometricInterpretation", 262, 3), new ExifTag("ImageDescription", 270, 2), new ExifTag("Make", 271, 2), new ExifTag("Model", 272, 2), new ExifTag("StripOffsets", 273, 3, 4), new ExifTag("Orientation", 274, 3), new ExifTag("SamplesPerPixel", 277, 3), new ExifTag("RowsPerStrip", 278, 3, 4), new ExifTag("StripByteCounts", 279, 3, 4), new ExifTag("XResolution", 282, 5), new ExifTag("YResolution", 283, 5), new ExifTag("PlanarConfiguration", 284, 3), new ExifTag("ResolutionUnit", 296, 3), new ExifTag("TransferFunction", 301, 3), new ExifTag("Software", 305, 2), new ExifTag("DateTime", 306, 2), new ExifTag("Artist", 315, 2), new ExifTag("WhitePoint", 318, 5), new ExifTag("PrimaryChromaticities", 319, 5), new ExifTag("SubIFDPointer", 330, 4), new ExifTag("JPEGInterchangeFormat", 513, 4), new ExifTag("JPEGInterchangeFormatLength", 514, 4), new ExifTag("YCbCrCoefficients", 529, 5), new ExifTag("YCbCrSubSampling", 530, 3), new ExifTag("YCbCrPositioning", 531, 3), new ExifTag("ReferenceBlackWhite", 532, 5), new ExifTag("Copyright", 33432, 2), new ExifTag("ExifIFDPointer", 34665, 4), new ExifTag("GPSInfoIFDPointer", 34853, 4), new ExifTag("SensorTopBorder", 4, 4), new ExifTag("SensorLeftBorder", 5, 4), new ExifTag("SensorBottomBorder", 6, 4), new ExifTag("SensorRightBorder", 7, 4), new ExifTag("ISO", 23, 3), new ExifTag("JpgFromRaw", 46, 7), new ExifTag("Xmp", 700, 1)};
        Z = exifTagArr2;
        ExifTag[] exifTagArr3 = {new ExifTag("ExposureTime", 33434, 5), new ExifTag("FNumber", 33437, 5), new ExifTag("ExposureProgram", 34850, 3), new ExifTag("SpectralSensitivity", 34852, 2), new ExifTag("PhotographicSensitivity", 34855, 3), new ExifTag("OECF", 34856, 7), new ExifTag("SensitivityType", 34864, 3), new ExifTag("StandardOutputSensitivity", 34865, 4), new ExifTag("RecommendedExposureIndex", 34866, 4), new ExifTag("ISOSpeed", 34867, 4), new ExifTag("ISOSpeedLatitudeyyy", 34868, 4), new ExifTag("ISOSpeedLatitudezzz", 34869, 4), new ExifTag("ExifVersion", 36864, 2), new ExifTag("DateTimeOriginal", 36867, 2), new ExifTag("DateTimeDigitized", 36868, 2), new ExifTag("OffsetTime", 36880, 2), new ExifTag("OffsetTimeOriginal", 36881, 2), new ExifTag("OffsetTimeDigitized", 36882, 2), new ExifTag("ComponentsConfiguration", 37121, 7), new ExifTag("CompressedBitsPerPixel", 37122, 5), new ExifTag("ShutterSpeedValue", 37377, 10), new ExifTag("ApertureValue", 37378, 5), new ExifTag("BrightnessValue", 37379, 10), new ExifTag("ExposureBiasValue", 37380, 10), new ExifTag("MaxApertureValue", 37381, 5), new ExifTag("SubjectDistance", 37382, 5), new ExifTag("MeteringMode", 37383, 3), new ExifTag("LightSource", 37384, 3), new ExifTag("Flash", 37385, 3), new ExifTag("FocalLength", 37386, 5), new ExifTag("SubjectArea", 37396, 3), new ExifTag("MakerNote", 37500, 7), new ExifTag("UserComment", 37510, 7), new ExifTag("SubSecTime", 37520, 2), new ExifTag("SubSecTimeOriginal", 37521, 2), new ExifTag("SubSecTimeDigitized", 37522, 2), new ExifTag("FlashpixVersion", 40960, 7), new ExifTag("ColorSpace", 40961, 3), new ExifTag("PixelXDimension", 40962, 3, 4), new ExifTag("PixelYDimension", 40963, 3, 4), new ExifTag("RelatedSoundFile", 40964, 2), new ExifTag("InteroperabilityIFDPointer", 40965, 4), new ExifTag("FlashEnergy", 41483, 5), new ExifTag("SpatialFrequencyResponse", 41484, 7), new ExifTag("FocalPlaneXResolution", 41486, 5), new ExifTag("FocalPlaneYResolution", 41487, 5), new ExifTag("FocalPlaneResolutionUnit", 41488, 3), new ExifTag("SubjectLocation", 41492, 3), new ExifTag("ExposureIndex", 41493, 5), new ExifTag("SensingMethod", 41495, 3), new ExifTag("FileSource", 41728, 7), new ExifTag("SceneType", 41729, 7), new ExifTag("CFAPattern", 41730, 7), new ExifTag("CustomRendered", 41985, 3), new ExifTag("ExposureMode", 41986, 3), new ExifTag("WhiteBalance", 41987, 3), new ExifTag("DigitalZoomRatio", 41988, 5), new ExifTag("FocalLengthIn35mmFilm", 41989, 3), new ExifTag("SceneCaptureType", 41990, 3), new ExifTag("GainControl", 41991, 3), new ExifTag("Contrast", 41992, 3), new ExifTag("Saturation", 41993, 3), new ExifTag("Sharpness", 41994, 3), new ExifTag("DeviceSettingDescription", 41995, 7), new ExifTag("SubjectDistanceRange", 41996, 3), new ExifTag("ImageUniqueID", 42016, 2), new ExifTag("CameraOwnerName", 42032, 2), new ExifTag("BodySerialNumber", 42033, 2), new ExifTag("LensSpecification", 42034, 5), new ExifTag("LensMake", 42035, 2), new ExifTag("LensModel", 42036, 2), new ExifTag("Gamma", 42240, 5), new ExifTag("DNGVersion", 50706, 1), new ExifTag("DefaultCropSize", 50720, 3, 4)};
        f6552a0 = exifTagArr3;
        ExifTag[] exifTagArr4 = {new ExifTag("GPSVersionID", 0, 1), new ExifTag("GPSLatitudeRef", 1, 2), new ExifTag("GPSLatitude", 2, 5, 10), new ExifTag("GPSLongitudeRef", 3, 2), new ExifTag("GPSLongitude", 4, 5, 10), new ExifTag("GPSAltitudeRef", 5, 1), new ExifTag("GPSAltitude", 6, 5), new ExifTag("GPSTimeStamp", 7, 5), new ExifTag("GPSSatellites", 8, 2), new ExifTag("GPSStatus", 9, 2), new ExifTag("GPSMeasureMode", 10, 2), new ExifTag("GPSDOP", 11, 5), new ExifTag("GPSSpeedRef", 12, 2), new ExifTag("GPSSpeed", 13, 5), new ExifTag("GPSTrackRef", 14, 2), new ExifTag("GPSTrack", 15, 5), new ExifTag("GPSImgDirectionRef", 16, 2), new ExifTag("GPSImgDirection", 17, 5), new ExifTag("GPSMapDatum", 18, 2), new ExifTag("GPSDestLatitudeRef", 19, 2), new ExifTag("GPSDestLatitude", 20, 5), new ExifTag("GPSDestLongitudeRef", 21, 2), new ExifTag("GPSDestLongitude", 22, 5), new ExifTag("GPSDestBearingRef", 23, 2), new ExifTag("GPSDestBearing", 24, 5), new ExifTag("GPSDestDistanceRef", 25, 2), new ExifTag("GPSDestDistance", 26, 5), new ExifTag("GPSProcessingMethod", 27, 7), new ExifTag("GPSAreaInformation", 28, 7), new ExifTag("GPSDateStamp", 29, 2), new ExifTag("GPSDifferential", 30, 3), new ExifTag("GPSHPositioningError", 31, 5)};
        f6553b0 = exifTagArr4;
        ExifTag[] exifTagArr5 = {new ExifTag("InteroperabilityIndex", 1, 2)};
        f6554c0 = exifTagArr5;
        ExifTag[] exifTagArr6 = {new ExifTag("NewSubfileType", 254, 4), new ExifTag("SubfileType", 255, 4), new ExifTag("ThumbnailImageWidth", Spliterator.NONNULL, 3, 4), new ExifTag("ThumbnailImageLength", 257, 3, 4), new ExifTag("BitsPerSample", 258, 3), new ExifTag("Compression", 259, 3), new ExifTag("PhotometricInterpretation", 262, 3), new ExifTag("ImageDescription", 270, 2), new ExifTag("Make", 271, 2), new ExifTag("Model", 272, 2), new ExifTag("StripOffsets", 273, 3, 4), new ExifTag("ThumbnailOrientation", 274, 3), new ExifTag("SamplesPerPixel", 277, 3), new ExifTag("RowsPerStrip", 278, 3, 4), new ExifTag("StripByteCounts", 279, 3, 4), new ExifTag("XResolution", 282, 5), new ExifTag("YResolution", 283, 5), new ExifTag("PlanarConfiguration", 284, 3), new ExifTag("ResolutionUnit", 296, 3), new ExifTag("TransferFunction", 301, 3), new ExifTag("Software", 305, 2), new ExifTag("DateTime", 306, 2), new ExifTag("Artist", 315, 2), new ExifTag("WhitePoint", 318, 5), new ExifTag("PrimaryChromaticities", 319, 5), new ExifTag("SubIFDPointer", 330, 4), new ExifTag("JPEGInterchangeFormat", 513, 4), new ExifTag("JPEGInterchangeFormatLength", 514, 4), new ExifTag("YCbCrCoefficients", 529, 5), new ExifTag("YCbCrSubSampling", 530, 3), new ExifTag("YCbCrPositioning", 531, 3), new ExifTag("ReferenceBlackWhite", 532, 5), new ExifTag("Copyright", 33432, 2), new ExifTag("ExifIFDPointer", 34665, 4), new ExifTag("GPSInfoIFDPointer", 34853, 4), new ExifTag("DNGVersion", 50706, 1), new ExifTag("DefaultCropSize", 50720, 3, 4)};
        f6555d0 = exifTagArr6;
        f6556e0 = new ExifTag("StripOffsets", 273, 3);
        ExifTag[] exifTagArr7 = {new ExifTag("ThumbnailImage", Spliterator.NONNULL, 7), new ExifTag("CameraSettingsIFDPointer", 8224, 4), new ExifTag("ImageProcessingIFDPointer", 8256, 4)};
        f6557f0 = exifTagArr7;
        ExifTag[] exifTagArr8 = {new ExifTag("PreviewImageStart", 257, 4), new ExifTag("PreviewImageLength", 258, 4)};
        f6558g0 = exifTagArr8;
        ExifTag[] exifTagArr9 = {new ExifTag("AspectFrame", 4371, 3)};
        f6559h0 = exifTagArr9;
        ExifTag[] exifTagArr10 = {new ExifTag("ColorSpace", 55, 3)};
        f6560i0 = exifTagArr10;
        ExifTag[][] exifTagArr11 = {exifTagArr2, exifTagArr3, exifTagArr4, exifTagArr5, exifTagArr6, exifTagArr2, exifTagArr7, exifTagArr8, exifTagArr9, exifTagArr10};
        f6561j0 = exifTagArr11;
        f6562k0 = new ExifTag[]{new ExifTag("SubIFDPointer", 330, 4), new ExifTag("ExifIFDPointer", 34665, 4), new ExifTag("GPSInfoIFDPointer", 34853, 4), new ExifTag("InteroperabilityIFDPointer", 40965, 4), new ExifTag("CameraSettingsIFDPointer", 8224, 1), new ExifTag("ImageProcessingIFDPointer", 8256, 1)};
        f6563l0 = new HashMap[exifTagArr11.length];
        f6564m0 = new HashMap[exifTagArr11.length];
        f6565n0 = new HashSet<>(Arrays.asList("FNumber", "DigitalZoomRatio", "ExposureTime", "SubjectDistance", "GPSTimeStamp"));
        f6566o0 = new HashMap<>();
        Charset forName = Charset.forName("US-ASCII");
        f6567p0 = forName;
        f6568q0 = "Exif\u0000\u0000".getBytes(forName);
        f6569r0 = "http://ns.adobe.com/xap/1.0/\u0000".getBytes(forName);
        Locale locale = Locale.US;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss", locale);
        U = simpleDateFormat;
        simpleDateFormat.setTimeZone(DesugarTimeZone.getTimeZone("UTC"));
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", locale);
        V = simpleDateFormat2;
        simpleDateFormat2.setTimeZone(DesugarTimeZone.getTimeZone("UTC"));
        int i8 = 0;
        while (true) {
            ExifTag[][] exifTagArr12 = f6561j0;
            if (i8 < exifTagArr12.length) {
                f6563l0[i8] = new HashMap<>();
                f6564m0[i8] = new HashMap<>();
                for (ExifTag exifTag : exifTagArr12[i8]) {
                    f6563l0[i8].put(Integer.valueOf(exifTag.f6615a), exifTag);
                    f6564m0[i8].put(exifTag.f6616b, exifTag);
                }
                i8++;
            } else {
                HashMap<Integer, Integer> hashMap = f6566o0;
                ExifTag[] exifTagArr13 = f6562k0;
                hashMap.put(Integer.valueOf(exifTagArr13[0].f6615a), 5);
                hashMap.put(Integer.valueOf(exifTagArr13[1].f6615a), 1);
                hashMap.put(Integer.valueOf(exifTagArr13[2].f6615a), 2);
                hashMap.put(Integer.valueOf(exifTagArr13[3].f6615a), 3);
                hashMap.put(Integer.valueOf(exifTagArr13[4].f6615a), 7);
                hashMap.put(Integer.valueOf(exifTagArr13[5].f6615a), 8);
                f6570s0 = Pattern.compile(".*[1-9].*");
                f6571t0 = Pattern.compile("^(\\d{2}):(\\d{2}):(\\d{2})$");
                f6572u0 = Pattern.compile("^(\\d{4}):(\\d{2}):(\\d{2})\\s(\\d{2}):(\\d{2}):(\\d{2})$");
                f6574v0 = Pattern.compile("^(\\d{4})-(\\d{2})-(\\d{2})\\s(\\d{2}):(\\d{2}):(\\d{2})$");
                return;
            }
        }
    }

    public ExifInterface(@NonNull String str) throws IOException {
        ExifTag[][] exifTagArr = f6561j0;
        this.f6584f = new HashMap[exifTagArr.length];
        this.f6585g = new HashSet(exifTagArr.length);
        this.f6586h = ByteOrder.BIG_ENDIAN;
        if (str != null) {
            A(str);
            return;
        }
        throw new NullPointerException("filename cannot be null");
    }

    private void A(String str) throws IOException {
        FileInputStream fileInputStream;
        if (str != null) {
            FileInputStream fileInputStream2 = null;
            this.f6581c = null;
            this.f6579a = str;
            try {
                fileInputStream = new FileInputStream(str);
            } catch (Throwable th) {
                th = th;
            }
            try {
                if (I(fileInputStream.getFD())) {
                    this.f6580b = fileInputStream.getFD();
                } else {
                    this.f6580b = null;
                }
                N(fileInputStream);
                ExifInterfaceUtils.c(fileInputStream);
                return;
            } catch (Throwable th2) {
                th = th2;
                fileInputStream2 = fileInputStream;
                ExifInterfaceUtils.c(fileInputStream2);
                throw th;
            }
        }
        throw new NullPointerException("filename cannot be null");
    }

    private static boolean B(BufferedInputStream bufferedInputStream) throws IOException {
        byte[] bArr = f6568q0;
        bufferedInputStream.mark(bArr.length);
        byte[] bArr2 = new byte[bArr.length];
        bufferedInputStream.read(bArr2);
        bufferedInputStream.reset();
        int i8 = 0;
        while (true) {
            byte[] bArr3 = f6568q0;
            if (i8 < bArr3.length) {
                if (bArr2[i8] != bArr3[i8]) {
                    return false;
                }
                i8++;
            } else {
                return true;
            }
        }
    }

    private boolean C(byte[] bArr) throws IOException {
        ByteOrderedDataInputStream byteOrderedDataInputStream;
        long readInt;
        byte[] bArr2;
        ByteOrderedDataInputStream byteOrderedDataInputStream2 = null;
        try {
            try {
                byteOrderedDataInputStream = new ByteOrderedDataInputStream(bArr);
                try {
                    readInt = byteOrderedDataInputStream.readInt();
                    bArr2 = new byte[4];
                    byteOrderedDataInputStream.read(bArr2);
                } catch (Exception e8) {
                    e = e8;
                    byteOrderedDataInputStream2 = byteOrderedDataInputStream;
                    if (f6573v) {
                        Log.d("ExifInterface", "Exception parsing HEIF file type box.", e);
                    }
                    if (byteOrderedDataInputStream2 != null) {
                        byteOrderedDataInputStream2.close();
                    }
                    return false;
                } catch (Throwable th) {
                    th = th;
                    byteOrderedDataInputStream2 = byteOrderedDataInputStream;
                    if (byteOrderedDataInputStream2 != null) {
                        byteOrderedDataInputStream2.close();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e9) {
            e = e9;
        }
        if (!Arrays.equals(bArr2, C)) {
            byteOrderedDataInputStream.close();
            return false;
        }
        long j8 = 16;
        if (readInt == 1) {
            readInt = byteOrderedDataInputStream.readLong();
            if (readInt < 16) {
                byteOrderedDataInputStream.close();
                return false;
            }
        } else {
            j8 = 8;
        }
        if (readInt > bArr.length) {
            readInt = bArr.length;
        }
        long j9 = readInt - j8;
        if (j9 < 8) {
            byteOrderedDataInputStream.close();
            return false;
        }
        byte[] bArr3 = new byte[4];
        boolean z7 = false;
        boolean z8 = false;
        for (long j10 = 0; j10 < j9 / 4; j10++) {
            if (byteOrderedDataInputStream.read(bArr3) != 4) {
                byteOrderedDataInputStream.close();
                return false;
            }
            if (j10 != 1) {
                if (Arrays.equals(bArr3, D)) {
                    z7 = true;
                } else if (Arrays.equals(bArr3, E)) {
                    z8 = true;
                }
                if (z7 && z8) {
                    byteOrderedDataInputStream.close();
                    return true;
                }
            }
        }
        byteOrderedDataInputStream.close();
        return false;
    }

    private static boolean D(byte[] bArr) throws IOException {
        int i8 = 0;
        while (true) {
            byte[] bArr2 = B;
            if (i8 < bArr2.length) {
                if (bArr[i8] != bArr2[i8]) {
                    return false;
                }
                i8++;
            } else {
                return true;
            }
        }
    }

    private boolean E(byte[] bArr) throws IOException {
        ByteOrderedDataInputStream byteOrderedDataInputStream;
        boolean z7 = false;
        ByteOrderedDataInputStream byteOrderedDataInputStream2 = null;
        try {
            byteOrderedDataInputStream = new ByteOrderedDataInputStream(bArr);
        } catch (Exception unused) {
        } catch (Throwable th) {
            th = th;
        }
        try {
            ByteOrder Q2 = Q(byteOrderedDataInputStream);
            this.f6586h = Q2;
            byteOrderedDataInputStream.e(Q2);
            short readShort = byteOrderedDataInputStream.readShort();
            z7 = (readShort == 20306 || readShort == 21330) ? true : true;
            byteOrderedDataInputStream.close();
            return z7;
        } catch (Exception unused2) {
            byteOrderedDataInputStream2 = byteOrderedDataInputStream;
            if (byteOrderedDataInputStream2 != null) {
                byteOrderedDataInputStream2.close();
            }
            return false;
        } catch (Throwable th2) {
            th = th2;
            byteOrderedDataInputStream2 = byteOrderedDataInputStream;
            if (byteOrderedDataInputStream2 != null) {
                byteOrderedDataInputStream2.close();
            }
            throw th;
        }
    }

    private boolean F(byte[] bArr) throws IOException {
        int i8 = 0;
        while (true) {
            byte[] bArr2 = H;
            if (i8 < bArr2.length) {
                if (bArr[i8] != bArr2[i8]) {
                    return false;
                }
                i8++;
            } else {
                return true;
            }
        }
    }

    private boolean G(byte[] bArr) throws IOException {
        byte[] bytes = "FUJIFILMCCD-RAW".getBytes(Charset.defaultCharset());
        for (int i8 = 0; i8 < bytes.length; i8++) {
            if (bArr[i8] != bytes[i8]) {
                return false;
            }
        }
        return true;
    }

    private boolean H(byte[] bArr) throws IOException {
        ByteOrderedDataInputStream byteOrderedDataInputStream;
        boolean z7 = false;
        ByteOrderedDataInputStream byteOrderedDataInputStream2 = null;
        try {
            byteOrderedDataInputStream = new ByteOrderedDataInputStream(bArr);
        } catch (Exception unused) {
        } catch (Throwable th) {
            th = th;
        }
        try {
            ByteOrder Q2 = Q(byteOrderedDataInputStream);
            this.f6586h = Q2;
            byteOrderedDataInputStream.e(Q2);
            if (byteOrderedDataInputStream.readShort() == 85) {
                z7 = true;
            }
            byteOrderedDataInputStream.close();
            return z7;
        } catch (Exception unused2) {
            byteOrderedDataInputStream2 = byteOrderedDataInputStream;
            if (byteOrderedDataInputStream2 != null) {
                byteOrderedDataInputStream2.close();
            }
            return false;
        } catch (Throwable th2) {
            th = th2;
            byteOrderedDataInputStream2 = byteOrderedDataInputStream;
            if (byteOrderedDataInputStream2 != null) {
                byteOrderedDataInputStream2.close();
            }
            throw th;
        }
    }

    private static boolean I(FileDescriptor fileDescriptor) {
        try {
            ExifInterfaceUtils.Api21Impl.c(fileDescriptor, 0L, OsConstants.SEEK_CUR);
            return true;
        } catch (Exception unused) {
            if (f6573v) {
                Log.d("ExifInterface", "The file descriptor for the given input is not seekable");
                return false;
            }
            return false;
        }
    }

    private boolean J(HashMap hashMap) throws IOException {
        ExifAttribute exifAttribute;
        int m8;
        ExifAttribute exifAttribute2 = (ExifAttribute) hashMap.get("BitsPerSample");
        if (exifAttribute2 != null) {
            int[] iArr = (int[]) exifAttribute2.o(this.f6586h);
            int[] iArr2 = f6577y;
            if (Arrays.equals(iArr2, iArr)) {
                return true;
            }
            if (this.f6582d == 3 && (exifAttribute = (ExifAttribute) hashMap.get("PhotometricInterpretation")) != null && (((m8 = exifAttribute.m(this.f6586h)) == 1 && Arrays.equals(iArr, A)) || (m8 == 6 && Arrays.equals(iArr, iArr2)))) {
                return true;
            }
        }
        if (f6573v) {
            Log.d("ExifInterface", "Unsupported data type value");
            return false;
        }
        return false;
    }

    private static boolean K(int i8) {
        return i8 == 4 || i8 == 13 || i8 == 14;
    }

    private boolean L(HashMap hashMap) throws IOException {
        ExifAttribute exifAttribute = (ExifAttribute) hashMap.get("ImageLength");
        ExifAttribute exifAttribute2 = (ExifAttribute) hashMap.get("ImageWidth");
        if (exifAttribute != null && exifAttribute2 != null) {
            int m8 = exifAttribute.m(this.f6586h);
            int m9 = exifAttribute2.m(this.f6586h);
            if (m8 <= 512 && m9 <= 512) {
                return true;
            }
            return false;
        }
        return false;
    }

    private boolean M(byte[] bArr) throws IOException {
        int i8 = 0;
        while (true) {
            byte[] bArr2 = L;
            if (i8 < bArr2.length) {
                if (bArr[i8] != bArr2[i8]) {
                    return false;
                }
                i8++;
            } else {
                int i9 = 0;
                while (true) {
                    byte[] bArr3 = M;
                    if (i9 < bArr3.length) {
                        if (bArr[L.length + i9 + 4] != bArr3[i9]) {
                            return false;
                        }
                        i9++;
                    } else {
                        return true;
                    }
                }
            }
        }
    }

    private void N(@NonNull InputStream inputStream) {
        boolean z7;
        if (inputStream != null) {
            for (int i8 = 0; i8 < f6561j0.length; i8++) {
                try {
                    try {
                        this.f6584f[i8] = new HashMap<>();
                    } catch (IOException | UnsupportedOperationException e8) {
                        boolean z8 = f6573v;
                        if (z8) {
                            Log.w("ExifInterface", "Invalid image: ExifInterface got an unsupported image format file(ExifInterface supports JPEG and some RAW image formats only) or a corrupted JPEG file to ExifInterface.", e8);
                        }
                        a();
                        if (!z8) {
                            return;
                        }
                    }
                } finally {
                    a();
                    if (f6573v) {
                        P();
                    }
                }
            }
            if (!this.f6583e) {
                BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream, 5000);
                this.f6582d = n(bufferedInputStream);
                inputStream = bufferedInputStream;
            }
            if (f0(this.f6582d)) {
                SeekableByteOrderedDataInputStream seekableByteOrderedDataInputStream = new SeekableByteOrderedDataInputStream(inputStream);
                if (this.f6583e) {
                    t(seekableByteOrderedDataInputStream);
                } else {
                    int i9 = this.f6582d;
                    if (i9 == 12) {
                        k(seekableByteOrderedDataInputStream);
                    } else if (i9 == 7) {
                        o(seekableByteOrderedDataInputStream);
                    } else if (i9 == 10) {
                        s(seekableByteOrderedDataInputStream);
                    } else {
                        r(seekableByteOrderedDataInputStream);
                    }
                }
                seekableByteOrderedDataInputStream.h(this.f6594p);
                e0(seekableByteOrderedDataInputStream);
            } else {
                ByteOrderedDataInputStream byteOrderedDataInputStream = new ByteOrderedDataInputStream(inputStream);
                int i10 = this.f6582d;
                if (i10 == 4) {
                    l(byteOrderedDataInputStream, 0, 0);
                } else if (i10 == 13) {
                    p(byteOrderedDataInputStream);
                } else if (i10 == 9) {
                    q(byteOrderedDataInputStream);
                } else if (i10 == 14) {
                    w(byteOrderedDataInputStream);
                }
            }
            if (!z7) {
                return;
            }
            return;
        }
        throw new NullPointerException("inputstream shouldn't be null");
    }

    private void O(ByteOrderedDataInputStream byteOrderedDataInputStream) throws IOException {
        ByteOrder Q2 = Q(byteOrderedDataInputStream);
        this.f6586h = Q2;
        byteOrderedDataInputStream.e(Q2);
        int readUnsignedShort = byteOrderedDataInputStream.readUnsignedShort();
        int i8 = this.f6582d;
        if (i8 != 7 && i8 != 10 && readUnsignedShort != 42) {
            throw new IOException("Invalid start code: " + Integer.toHexString(readUnsignedShort));
        }
        int readInt = byteOrderedDataInputStream.readInt();
        if (readInt >= 8) {
            int i9 = readInt - 8;
            if (i9 > 0) {
                byteOrderedDataInputStream.g(i9);
                return;
            }
            return;
        }
        throw new IOException("Invalid first Ifd offset: " + readInt);
    }

    private void P() {
        for (int i8 = 0; i8 < this.f6584f.length; i8++) {
            Log.d("ExifInterface", "The size of tag group[" + i8 + "]: " + this.f6584f[i8].size());
            for (Map.Entry<String, ExifAttribute> entry : this.f6584f[i8].entrySet()) {
                ExifAttribute value = entry.getValue();
                Log.d("ExifInterface", "tagName: " + entry.getKey() + ", tagType: " + value.toString() + ", tagValue: '" + value.n(this.f6586h) + "'");
            }
        }
    }

    private ByteOrder Q(ByteOrderedDataInputStream byteOrderedDataInputStream) throws IOException {
        short readShort = byteOrderedDataInputStream.readShort();
        if (readShort != 18761) {
            if (readShort == 19789) {
                if (f6573v) {
                    Log.d("ExifInterface", "readExifSegment: Byte Align MM");
                }
                return ByteOrder.BIG_ENDIAN;
            }
            throw new IOException("Invalid byte order: " + Integer.toHexString(readShort));
        }
        if (f6573v) {
            Log.d("ExifInterface", "readExifSegment: Byte Align II");
        }
        return ByteOrder.LITTLE_ENDIAN;
    }

    private void R(byte[] bArr, int i8) throws IOException {
        SeekableByteOrderedDataInputStream seekableByteOrderedDataInputStream = new SeekableByteOrderedDataInputStream(bArr);
        O(seekableByteOrderedDataInputStream);
        S(seekableByteOrderedDataInputStream, i8);
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0229  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0247  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0283  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void S(androidx.exifinterface.media.ExifInterface.SeekableByteOrderedDataInputStream r30, int r31) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 928
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.exifinterface.media.ExifInterface.S(androidx.exifinterface.media.ExifInterface$SeekableByteOrderedDataInputStream, int):void");
    }

    private void T(String str) {
        for (int i8 = 0; i8 < f6561j0.length; i8++) {
            this.f6584f[i8].remove(str);
        }
    }

    private void U(int i8, String str, String str2) {
        if (!this.f6584f[i8].isEmpty() && this.f6584f[i8].get(str) != null) {
            HashMap<String, ExifAttribute> hashMap = this.f6584f[i8];
            hashMap.put(str2, hashMap.get(str));
            this.f6584f[i8].remove(str);
        }
    }

    private void V(SeekableByteOrderedDataInputStream seekableByteOrderedDataInputStream, int i8) throws IOException {
        ExifAttribute exifAttribute = this.f6584f[i8].get("ImageLength");
        ExifAttribute exifAttribute2 = this.f6584f[i8].get("ImageWidth");
        if (exifAttribute == null || exifAttribute2 == null) {
            ExifAttribute exifAttribute3 = this.f6584f[i8].get("JPEGInterchangeFormat");
            ExifAttribute exifAttribute4 = this.f6584f[i8].get("JPEGInterchangeFormatLength");
            if (exifAttribute3 != null && exifAttribute4 != null) {
                int m8 = exifAttribute3.m(this.f6586h);
                int m9 = exifAttribute3.m(this.f6586h);
                seekableByteOrderedDataInputStream.h(m8);
                byte[] bArr = new byte[m9];
                seekableByteOrderedDataInputStream.read(bArr);
                l(new ByteOrderedDataInputStream(bArr), m8, i8);
            }
        }
    }

    private void X(InputStream inputStream, OutputStream outputStream) throws IOException {
        if (f6573v) {
            Log.d("ExifInterface", "saveJpegAttributes starting with (inputStream: " + inputStream + ", outputStream: " + outputStream + ")");
        }
        ByteOrderedDataInputStream byteOrderedDataInputStream = new ByteOrderedDataInputStream(inputStream);
        ByteOrderedDataOutputStream byteOrderedDataOutputStream = new ByteOrderedDataOutputStream(outputStream, ByteOrder.BIG_ENDIAN);
        if (byteOrderedDataInputStream.readByte() == -1) {
            byteOrderedDataOutputStream.c(-1);
            if (byteOrderedDataInputStream.readByte() == -40) {
                byteOrderedDataOutputStream.c(-40);
                ExifAttribute exifAttribute = null;
                if (g("Xmp") != null && this.f6599u) {
                    exifAttribute = this.f6584f[0].remove("Xmp");
                }
                byteOrderedDataOutputStream.c(-1);
                byteOrderedDataOutputStream.c(-31);
                j0(byteOrderedDataOutputStream);
                if (exifAttribute != null) {
                    this.f6584f[0].put("Xmp", exifAttribute);
                }
                byte[] bArr = new byte[4096];
                while (byteOrderedDataInputStream.readByte() == -1) {
                    byte readByte = byteOrderedDataInputStream.readByte();
                    if (readByte != -39 && readByte != -38) {
                        if (readByte != -31) {
                            byteOrderedDataOutputStream.c(-1);
                            byteOrderedDataOutputStream.c(readByte);
                            int readUnsignedShort = byteOrderedDataInputStream.readUnsignedShort();
                            byteOrderedDataOutputStream.j(readUnsignedShort);
                            int i8 = readUnsignedShort - 2;
                            if (i8 >= 0) {
                                while (i8 > 0) {
                                    int read = byteOrderedDataInputStream.read(bArr, 0, Math.min(i8, 4096));
                                    if (read >= 0) {
                                        byteOrderedDataOutputStream.write(bArr, 0, read);
                                        i8 -= read;
                                    }
                                }
                            } else {
                                throw new IOException("Invalid length");
                            }
                        } else {
                            int readUnsignedShort2 = byteOrderedDataInputStream.readUnsignedShort() - 2;
                            if (readUnsignedShort2 >= 0) {
                                byte[] bArr2 = new byte[6];
                                if (readUnsignedShort2 >= 6) {
                                    if (byteOrderedDataInputStream.read(bArr2) == 6) {
                                        if (Arrays.equals(bArr2, f6568q0)) {
                                            byteOrderedDataInputStream.g(readUnsignedShort2 - 6);
                                        }
                                    } else {
                                        throw new IOException("Invalid exif");
                                    }
                                }
                                byteOrderedDataOutputStream.c(-1);
                                byteOrderedDataOutputStream.c(readByte);
                                byteOrderedDataOutputStream.j(readUnsignedShort2 + 2);
                                if (readUnsignedShort2 >= 6) {
                                    readUnsignedShort2 -= 6;
                                    byteOrderedDataOutputStream.write(bArr2);
                                }
                                while (readUnsignedShort2 > 0) {
                                    int read2 = byteOrderedDataInputStream.read(bArr, 0, Math.min(readUnsignedShort2, 4096));
                                    if (read2 >= 0) {
                                        byteOrderedDataOutputStream.write(bArr, 0, read2);
                                        readUnsignedShort2 -= read2;
                                    }
                                }
                            } else {
                                throw new IOException("Invalid length");
                            }
                        }
                    } else {
                        byteOrderedDataOutputStream.c(-1);
                        byteOrderedDataOutputStream.c(readByte);
                        ExifInterfaceUtils.e(byteOrderedDataInputStream, byteOrderedDataOutputStream);
                        return;
                    }
                }
                throw new IOException("Invalid marker");
            }
            throw new IOException("Invalid marker");
        }
        throw new IOException("Invalid marker");
    }

    private void Y(InputStream inputStream, OutputStream outputStream) throws IOException {
        if (f6573v) {
            Log.d("ExifInterface", "savePngAttributes starting with (inputStream: " + inputStream + ", outputStream: " + outputStream + ")");
        }
        ByteOrderedDataInputStream byteOrderedDataInputStream = new ByteOrderedDataInputStream(inputStream);
        ByteOrder byteOrder = ByteOrder.BIG_ENDIAN;
        ByteOrderedDataOutputStream byteOrderedDataOutputStream = new ByteOrderedDataOutputStream(outputStream, byteOrder);
        byte[] bArr = H;
        ExifInterfaceUtils.f(byteOrderedDataInputStream, byteOrderedDataOutputStream, bArr.length);
        int i8 = this.f6594p;
        if (i8 == 0) {
            int readInt = byteOrderedDataInputStream.readInt();
            byteOrderedDataOutputStream.e(readInt);
            ExifInterfaceUtils.f(byteOrderedDataInputStream, byteOrderedDataOutputStream, readInt + 4 + 4);
        } else {
            ExifInterfaceUtils.f(byteOrderedDataInputStream, byteOrderedDataOutputStream, ((i8 - bArr.length) - 4) - 4);
            byteOrderedDataInputStream.g(byteOrderedDataInputStream.readInt() + 4 + 4);
        }
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            try {
                ByteOrderedDataOutputStream byteOrderedDataOutputStream2 = new ByteOrderedDataOutputStream(byteArrayOutputStream2, byteOrder);
                j0(byteOrderedDataOutputStream2);
                byte[] byteArray = ((ByteArrayOutputStream) byteOrderedDataOutputStream2.f6609f).toByteArray();
                byteOrderedDataOutputStream.write(byteArray);
                CRC32 crc32 = new CRC32();
                crc32.update(byteArray, 4, byteArray.length - 4);
                byteOrderedDataOutputStream.e((int) crc32.getValue());
                ExifInterfaceUtils.c(byteArrayOutputStream2);
                ExifInterfaceUtils.e(byteOrderedDataInputStream, byteOrderedDataOutputStream);
            } catch (Throwable th) {
                th = th;
                byteArrayOutputStream = byteArrayOutputStream2;
                ExifInterfaceUtils.c(byteArrayOutputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private void Z(InputStream inputStream, OutputStream outputStream) throws IOException {
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        if (f6573v) {
            Log.d("ExifInterface", "saveWebpAttributes starting with (inputStream: " + inputStream + ", outputStream: " + outputStream + ")");
        }
        ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
        ByteOrderedDataInputStream byteOrderedDataInputStream = new ByteOrderedDataInputStream(inputStream, byteOrder);
        ByteOrderedDataOutputStream byteOrderedDataOutputStream = new ByteOrderedDataOutputStream(outputStream, byteOrder);
        byte[] bArr = L;
        ExifInterfaceUtils.f(byteOrderedDataInputStream, byteOrderedDataOutputStream, bArr.length);
        byte[] bArr2 = M;
        byteOrderedDataInputStream.g(bArr2.length + 4);
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            try {
                ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                try {
                    ByteOrderedDataOutputStream byteOrderedDataOutputStream2 = new ByteOrderedDataOutputStream(byteArrayOutputStream2, byteOrder);
                    int i13 = this.f6594p;
                    if (i13 != 0) {
                        ExifInterfaceUtils.f(byteOrderedDataInputStream, byteOrderedDataOutputStream2, ((i13 - ((bArr.length + 4) + bArr2.length)) - 4) - 4);
                        byteOrderedDataInputStream.g(4);
                        int readInt = byteOrderedDataInputStream.readInt();
                        if (readInt % 2 != 0) {
                            readInt++;
                        }
                        byteOrderedDataInputStream.g(readInt);
                        j0(byteOrderedDataOutputStream2);
                    } else {
                        byte[] bArr3 = new byte[4];
                        if (byteOrderedDataInputStream.read(bArr3) == 4) {
                            byte[] bArr4 = P;
                            boolean z7 = false;
                            boolean z8 = true;
                            if (Arrays.equals(bArr3, bArr4)) {
                                int readInt2 = byteOrderedDataInputStream.readInt();
                                if (readInt2 % 2 == 1) {
                                    i12 = readInt2 + 1;
                                } else {
                                    i12 = readInt2;
                                }
                                byte[] bArr5 = new byte[i12];
                                byteOrderedDataInputStream.read(bArr5);
                                byte b8 = (byte) (8 | bArr5[0]);
                                bArr5[0] = b8;
                                if (((b8 >> 1) & 1) == 1) {
                                    z7 = true;
                                }
                                byteOrderedDataOutputStream2.write(bArr4);
                                byteOrderedDataOutputStream2.e(readInt2);
                                byteOrderedDataOutputStream2.write(bArr5);
                                if (z7) {
                                    d(byteOrderedDataInputStream, byteOrderedDataOutputStream2, S, null);
                                    while (true) {
                                        byte[] bArr6 = new byte[4];
                                        inputStream.read(bArr6);
                                        if (!Arrays.equals(bArr6, T)) {
                                            break;
                                        }
                                        e(byteOrderedDataInputStream, byteOrderedDataOutputStream2, bArr6);
                                    }
                                    j0(byteOrderedDataOutputStream2);
                                } else {
                                    d(byteOrderedDataInputStream, byteOrderedDataOutputStream2, R, Q);
                                    j0(byteOrderedDataOutputStream2);
                                }
                            } else {
                                byte[] bArr7 = R;
                                if (Arrays.equals(bArr3, bArr7) || Arrays.equals(bArr3, Q)) {
                                    int readInt3 = byteOrderedDataInputStream.readInt();
                                    if (readInt3 % 2 == 1) {
                                        i8 = readInt3 + 1;
                                    } else {
                                        i8 = readInt3;
                                    }
                                    byte[] bArr8 = new byte[3];
                                    if (Arrays.equals(bArr3, bArr7)) {
                                        byteOrderedDataInputStream.read(bArr8);
                                        byte[] bArr9 = new byte[3];
                                        if (byteOrderedDataInputStream.read(bArr9) == 3 && Arrays.equals(O, bArr9)) {
                                            i9 = byteOrderedDataInputStream.readInt();
                                            i8 -= 10;
                                            i11 = (i9 << 2) >> 18;
                                            i10 = (i9 << 18) >> 18;
                                            z8 = false;
                                        } else {
                                            throw new IOException("Encountered error while checking VP8 signature");
                                        }
                                    } else if (Arrays.equals(bArr3, Q)) {
                                        if (byteOrderedDataInputStream.readByte() == 47) {
                                            i9 = byteOrderedDataInputStream.readInt();
                                            i10 = ((i9 << 18) >> 18) + 1;
                                            i11 = ((i9 << 4) >> 18) + 1;
                                            if ((i9 & 8) == 0) {
                                                z8 = false;
                                            }
                                            i8 -= 5;
                                        } else {
                                            throw new IOException("Encountered error while checking VP8L signature");
                                        }
                                    } else {
                                        i9 = 0;
                                        z8 = false;
                                        i10 = 0;
                                        i11 = 0;
                                    }
                                    byteOrderedDataOutputStream2.write(bArr4);
                                    byteOrderedDataOutputStream2.e(10);
                                    byte[] bArr10 = new byte[10];
                                    if (z8) {
                                        bArr10[0] = (byte) (bArr10[0] | 16);
                                    }
                                    bArr10[0] = (byte) (bArr10[0] | 8);
                                    int i14 = i10 - 1;
                                    int i15 = i11 - 1;
                                    bArr10[4] = (byte) i14;
                                    bArr10[5] = (byte) (i14 >> 8);
                                    bArr10[6] = (byte) (i14 >> 16);
                                    bArr10[7] = (byte) i15;
                                    bArr10[8] = (byte) (i15 >> 8);
                                    bArr10[9] = (byte) (i15 >> 16);
                                    byteOrderedDataOutputStream2.write(bArr10);
                                    byteOrderedDataOutputStream2.write(bArr3);
                                    byteOrderedDataOutputStream2.e(readInt3);
                                    if (Arrays.equals(bArr3, bArr7)) {
                                        byteOrderedDataOutputStream2.write(bArr8);
                                        byteOrderedDataOutputStream2.write(O);
                                        byteOrderedDataOutputStream2.e(i9);
                                    } else if (Arrays.equals(bArr3, Q)) {
                                        byteOrderedDataOutputStream2.write(47);
                                        byteOrderedDataOutputStream2.e(i9);
                                    }
                                    ExifInterfaceUtils.f(byteOrderedDataInputStream, byteOrderedDataOutputStream2, i8);
                                    j0(byteOrderedDataOutputStream2);
                                }
                            }
                        } else {
                            throw new IOException("Encountered invalid length while parsing WebP chunk type");
                        }
                    }
                    ExifInterfaceUtils.e(byteOrderedDataInputStream, byteOrderedDataOutputStream2);
                    int size = byteArrayOutputStream2.size();
                    byte[] bArr11 = M;
                    byteOrderedDataOutputStream.e(size + bArr11.length);
                    byteOrderedDataOutputStream.write(bArr11);
                    byteArrayOutputStream2.writeTo(byteOrderedDataOutputStream);
                    ExifInterfaceUtils.c(byteArrayOutputStream2);
                } catch (Exception e8) {
                    e = e8;
                    byteArrayOutputStream = byteArrayOutputStream2;
                    throw new IOException("Failed to save WebP file", e);
                } catch (Throwable th) {
                    th = th;
                    byteArrayOutputStream = byteArrayOutputStream2;
                    ExifInterfaceUtils.c(byteArrayOutputStream);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e9) {
            e = e9;
        }
    }

    private void a() {
        String g8 = g("DateTimeOriginal");
        if (g8 != null && g("DateTime") == null) {
            this.f6584f[0].put("DateTime", ExifAttribute.e(g8));
        }
        if (g("ImageWidth") == null) {
            this.f6584f[0].put("ImageWidth", ExifAttribute.f(0L, this.f6586h));
        }
        if (g("ImageLength") == null) {
            this.f6584f[0].put("ImageLength", ExifAttribute.f(0L, this.f6586h));
        }
        if (g("Orientation") == null) {
            this.f6584f[0].put("Orientation", ExifAttribute.f(0L, this.f6586h));
        }
        if (g("LightSource") == null) {
            this.f6584f[1].put("LightSource", ExifAttribute.f(0L, this.f6586h));
        }
    }

    private String b(double d8) {
        long j8 = (long) d8;
        double d9 = d8 - j8;
        long j9 = (long) (d9 * 60.0d);
        long round = Math.round((d9 - (j9 / 60.0d)) * 3600.0d * 1.0E7d);
        return j8 + "/1," + j9 + "/1," + round + "/10000000";
    }

    private static double c(String str, String str2) {
        try {
            String[] split = str.split(",", -1);
            String[] split2 = split[0].split("/", -1);
            String[] split3 = split[1].split("/", -1);
            String[] split4 = split[2].split("/", -1);
            double parseDouble = (Double.parseDouble(split2[0].trim()) / Double.parseDouble(split2[1].trim())) + ((Double.parseDouble(split3[0].trim()) / Double.parseDouble(split3[1].trim())) / 60.0d) + ((Double.parseDouble(split4[0].trim()) / Double.parseDouble(split4[1].trim())) / 3600.0d);
            if (!str2.equals("S") && !str2.equals("W")) {
                if (!str2.equals("N") && !str2.equals("E")) {
                    throw new IllegalArgumentException();
                }
                return parseDouble;
            }
            return -parseDouble;
        } catch (ArrayIndexOutOfBoundsException | NumberFormatException unused) {
            throw new IllegalArgumentException();
        }
    }

    private void d(ByteOrderedDataInputStream byteOrderedDataInputStream, ByteOrderedDataOutputStream byteOrderedDataOutputStream, byte[] bArr, byte[] bArr2) throws IOException {
        Charset charset;
        String str;
        while (true) {
            byte[] bArr3 = new byte[4];
            if (byteOrderedDataInputStream.read(bArr3) != 4) {
                StringBuilder sb = new StringBuilder();
                sb.append("Encountered invalid length while copying WebP chunks up tochunk type ");
                sb.append(new String(bArr, f6567p0));
                if (bArr2 == null) {
                    str = "";
                } else {
                    str = " or " + new String(bArr2, charset);
                }
                sb.append(str);
                throw new IOException(sb.toString());
            }
            e(byteOrderedDataInputStream, byteOrderedDataOutputStream, bArr3);
            if (!Arrays.equals(bArr3, bArr)) {
                if (bArr2 != null && Arrays.equals(bArr3, bArr2)) {
                    return;
                }
            } else {
                return;
            }
        }
    }

    private void e(ByteOrderedDataInputStream byteOrderedDataInputStream, ByteOrderedDataOutputStream byteOrderedDataOutputStream, byte[] bArr) throws IOException {
        int readInt = byteOrderedDataInputStream.readInt();
        byteOrderedDataOutputStream.write(bArr);
        byteOrderedDataOutputStream.e(readInt);
        if (readInt % 2 == 1) {
            readInt++;
        }
        ExifInterfaceUtils.f(byteOrderedDataInputStream, byteOrderedDataOutputStream, readInt);
    }

    private void e0(ByteOrderedDataInputStream byteOrderedDataInputStream) throws IOException {
        HashMap<String, ExifAttribute> hashMap = this.f6584f[4];
        ExifAttribute exifAttribute = hashMap.get("Compression");
        if (exifAttribute != null) {
            int m8 = exifAttribute.m(this.f6586h);
            this.f6593o = m8;
            if (m8 != 1) {
                if (m8 != 6) {
                    if (m8 != 7) {
                        return;
                    }
                } else {
                    y(byteOrderedDataInputStream, hashMap);
                    return;
                }
            }
            if (J(hashMap)) {
                z(byteOrderedDataInputStream, hashMap);
                return;
            }
            return;
        }
        this.f6593o = 6;
        y(byteOrderedDataInputStream, hashMap);
    }

    private static boolean f0(int i8) {
        return (i8 == 4 || i8 == 9 || i8 == 13 || i8 == 14) ? false : true;
    }

    private void g0(int i8, int i9) throws IOException {
        if (!this.f6584f[i8].isEmpty() && !this.f6584f[i9].isEmpty()) {
            ExifAttribute exifAttribute = this.f6584f[i8].get("ImageLength");
            ExifAttribute exifAttribute2 = this.f6584f[i8].get("ImageWidth");
            ExifAttribute exifAttribute3 = this.f6584f[i9].get("ImageLength");
            ExifAttribute exifAttribute4 = this.f6584f[i9].get("ImageWidth");
            if (exifAttribute != null && exifAttribute2 != null) {
                if (exifAttribute3 != null && exifAttribute4 != null) {
                    int m8 = exifAttribute.m(this.f6586h);
                    int m9 = exifAttribute2.m(this.f6586h);
                    int m10 = exifAttribute3.m(this.f6586h);
                    int m11 = exifAttribute4.m(this.f6586h);
                    if (m8 < m10 && m9 < m11) {
                        HashMap<String, ExifAttribute>[] hashMapArr = this.f6584f;
                        HashMap<String, ExifAttribute> hashMap = hashMapArr[i8];
                        hashMapArr[i8] = hashMapArr[i9];
                        hashMapArr[i9] = hashMap;
                    }
                } else if (f6573v) {
                    Log.d("ExifInterface", "Second image does not contain valid size information");
                }
            } else if (f6573v) {
                Log.d("ExifInterface", "First image does not contain valid size information");
            }
        } else if (f6573v) {
            Log.d("ExifInterface", "Cannot perform swap since only one image data exists");
        }
    }

    private void h0(SeekableByteOrderedDataInputStream seekableByteOrderedDataInputStream, int i8) throws IOException {
        ExifAttribute j8;
        ExifAttribute j9;
        ExifAttribute exifAttribute = this.f6584f[i8].get("DefaultCropSize");
        ExifAttribute exifAttribute2 = this.f6584f[i8].get("SensorTopBorder");
        ExifAttribute exifAttribute3 = this.f6584f[i8].get("SensorLeftBorder");
        ExifAttribute exifAttribute4 = this.f6584f[i8].get("SensorBottomBorder");
        ExifAttribute exifAttribute5 = this.f6584f[i8].get("SensorRightBorder");
        if (exifAttribute != null) {
            if (exifAttribute.f6611a == 5) {
                Rational[] rationalArr = (Rational[]) exifAttribute.o(this.f6586h);
                if (rationalArr != null && rationalArr.length == 2) {
                    j8 = ExifAttribute.h(rationalArr[0], this.f6586h);
                    j9 = ExifAttribute.h(rationalArr[1], this.f6586h);
                } else {
                    Log.w("ExifInterface", "Invalid crop size values. cropSize=" + Arrays.toString(rationalArr));
                    return;
                }
            } else {
                int[] iArr = (int[]) exifAttribute.o(this.f6586h);
                if (iArr != null && iArr.length == 2) {
                    j8 = ExifAttribute.j(iArr[0], this.f6586h);
                    j9 = ExifAttribute.j(iArr[1], this.f6586h);
                } else {
                    Log.w("ExifInterface", "Invalid crop size values. cropSize=" + Arrays.toString(iArr));
                    return;
                }
            }
            this.f6584f[i8].put("ImageWidth", j8);
            this.f6584f[i8].put("ImageLength", j9);
        } else if (exifAttribute2 != null && exifAttribute3 != null && exifAttribute4 != null && exifAttribute5 != null) {
            int m8 = exifAttribute2.m(this.f6586h);
            int m9 = exifAttribute4.m(this.f6586h);
            int m10 = exifAttribute5.m(this.f6586h);
            int m11 = exifAttribute3.m(this.f6586h);
            if (m9 > m8 && m10 > m11) {
                ExifAttribute j10 = ExifAttribute.j(m9 - m8, this.f6586h);
                ExifAttribute j11 = ExifAttribute.j(m10 - m11, this.f6586h);
                this.f6584f[i8].put("ImageLength", j10);
                this.f6584f[i8].put("ImageWidth", j11);
            }
        } else {
            V(seekableByteOrderedDataInputStream, i8);
        }
    }

    private void i0() throws IOException {
        g0(0, 5);
        g0(0, 4);
        g0(5, 4);
        ExifAttribute exifAttribute = this.f6584f[1].get("PixelXDimension");
        ExifAttribute exifAttribute2 = this.f6584f[1].get("PixelYDimension");
        if (exifAttribute != null && exifAttribute2 != null) {
            this.f6584f[0].put("ImageWidth", exifAttribute);
            this.f6584f[0].put("ImageLength", exifAttribute2);
        }
        if (this.f6584f[4].isEmpty() && L(this.f6584f[5])) {
            HashMap<String, ExifAttribute>[] hashMapArr = this.f6584f;
            hashMapArr[4] = hashMapArr[5];
            hashMapArr[5] = new HashMap<>();
        }
        if (!L(this.f6584f[4])) {
            Log.d("ExifInterface", "No image meets the size requirements of a thumbnail image.");
        }
        U(0, "ThumbnailOrientation", "Orientation");
        U(0, "ThumbnailImageLength", "ImageLength");
        U(0, "ThumbnailImageWidth", "ImageWidth");
        U(5, "ThumbnailOrientation", "Orientation");
        U(5, "ThumbnailImageLength", "ImageLength");
        U(5, "ThumbnailImageWidth", "ImageWidth");
        U(4, "Orientation", "ThumbnailOrientation");
        U(4, "ImageLength", "ThumbnailImageLength");
        U(4, "ImageWidth", "ThumbnailImageWidth");
    }

    private ExifAttribute j(@NonNull String str) {
        if (str != null) {
            if ("ISOSpeedRatings".equals(str)) {
                if (f6573v) {
                    Log.d("ExifInterface", "getExifAttribute: Replacing TAG_ISO_SPEED_RATINGS with TAG_PHOTOGRAPHIC_SENSITIVITY.");
                }
                str = "PhotographicSensitivity";
            }
            for (int i8 = 0; i8 < f6561j0.length; i8++) {
                ExifAttribute exifAttribute = this.f6584f[i8].get(str);
                if (exifAttribute != null) {
                    return exifAttribute;
                }
            }
            return null;
        }
        throw new NullPointerException("tag shouldn't be null");
    }

    private int j0(ByteOrderedDataOutputStream byteOrderedDataOutputStream) throws IOException {
        short s7;
        ExifTag[][] exifTagArr = f6561j0;
        int[] iArr = new int[exifTagArr.length];
        int[] iArr2 = new int[exifTagArr.length];
        for (ExifTag exifTag : f6562k0) {
            T(exifTag.f6616b);
        }
        if (this.f6587i) {
            if (this.f6588j) {
                T("StripOffsets");
                T("StripByteCounts");
            } else {
                T("JPEGInterchangeFormat");
                T("JPEGInterchangeFormatLength");
            }
        }
        for (int i8 = 0; i8 < f6561j0.length; i8++) {
            for (Object obj : this.f6584f[i8].entrySet().toArray()) {
                Map.Entry entry = (Map.Entry) obj;
                if (entry.getValue() == null) {
                    this.f6584f[i8].remove(entry.getKey());
                }
            }
        }
        if (!this.f6584f[1].isEmpty()) {
            this.f6584f[0].put(f6562k0[1].f6616b, ExifAttribute.f(0L, this.f6586h));
        }
        if (!this.f6584f[2].isEmpty()) {
            this.f6584f[0].put(f6562k0[2].f6616b, ExifAttribute.f(0L, this.f6586h));
        }
        if (!this.f6584f[3].isEmpty()) {
            this.f6584f[1].put(f6562k0[3].f6616b, ExifAttribute.f(0L, this.f6586h));
        }
        if (this.f6587i) {
            if (this.f6588j) {
                this.f6584f[4].put("StripOffsets", ExifAttribute.j(0, this.f6586h));
                this.f6584f[4].put("StripByteCounts", ExifAttribute.j(this.f6591m, this.f6586h));
            } else {
                this.f6584f[4].put("JPEGInterchangeFormat", ExifAttribute.f(0L, this.f6586h));
                this.f6584f[4].put("JPEGInterchangeFormatLength", ExifAttribute.f(this.f6591m, this.f6586h));
            }
        }
        for (int i9 = 0; i9 < f6561j0.length; i9++) {
            int i10 = 0;
            for (Map.Entry<String, ExifAttribute> entry2 : this.f6584f[i9].entrySet()) {
                int p8 = entry2.getValue().p();
                if (p8 > 4) {
                    i10 += p8;
                }
            }
            iArr2[i9] = iArr2[i9] + i10;
        }
        int i11 = 8;
        for (int i12 = 0; i12 < f6561j0.length; i12++) {
            if (!this.f6584f[i12].isEmpty()) {
                iArr[i12] = i11;
                i11 += (this.f6584f[i12].size() * 12) + 2 + 4 + iArr2[i12];
            }
        }
        if (this.f6587i) {
            if (this.f6588j) {
                this.f6584f[4].put("StripOffsets", ExifAttribute.j(i11, this.f6586h));
            } else {
                this.f6584f[4].put("JPEGInterchangeFormat", ExifAttribute.f(i11, this.f6586h));
            }
            this.f6590l = i11;
            i11 += this.f6591m;
        }
        if (this.f6582d == 4) {
            i11 += 8;
        }
        if (f6573v) {
            for (int i13 = 0; i13 < f6561j0.length; i13++) {
                Log.d("ExifInterface", String.format("index: %d, offsets: %d, tag count: %d, data sizes: %d, total size: %d", Integer.valueOf(i13), Integer.valueOf(iArr[i13]), Integer.valueOf(this.f6584f[i13].size()), Integer.valueOf(iArr2[i13]), Integer.valueOf(i11)));
            }
        }
        if (!this.f6584f[1].isEmpty()) {
            this.f6584f[0].put(f6562k0[1].f6616b, ExifAttribute.f(iArr[1], this.f6586h));
        }
        if (!this.f6584f[2].isEmpty()) {
            this.f6584f[0].put(f6562k0[2].f6616b, ExifAttribute.f(iArr[2], this.f6586h));
        }
        if (!this.f6584f[3].isEmpty()) {
            this.f6584f[1].put(f6562k0[3].f6616b, ExifAttribute.f(iArr[3], this.f6586h));
        }
        int i14 = this.f6582d;
        if (i14 != 4) {
            if (i14 != 13) {
                if (i14 == 14) {
                    byteOrderedDataOutputStream.write(N);
                    byteOrderedDataOutputStream.e(i11);
                }
            } else {
                byteOrderedDataOutputStream.e(i11);
                byteOrderedDataOutputStream.write(I);
            }
        } else {
            byteOrderedDataOutputStream.j(i11);
            byteOrderedDataOutputStream.write(f6568q0);
        }
        if (this.f6586h == ByteOrder.BIG_ENDIAN) {
            s7 = 19789;
        } else {
            s7 = 18761;
        }
        byteOrderedDataOutputStream.g(s7);
        byteOrderedDataOutputStream.a(this.f6586h);
        byteOrderedDataOutputStream.j(42);
        byteOrderedDataOutputStream.h(8L);
        for (int i15 = 0; i15 < f6561j0.length; i15++) {
            if (!this.f6584f[i15].isEmpty()) {
                byteOrderedDataOutputStream.j(this.f6584f[i15].size());
                int size = iArr[i15] + 2 + (this.f6584f[i15].size() * 12) + 4;
                for (Map.Entry<String, ExifAttribute> entry3 : this.f6584f[i15].entrySet()) {
                    int i16 = f6564m0[i15].get(entry3.getKey()).f6615a;
                    ExifAttribute value = entry3.getValue();
                    int p9 = value.p();
                    byteOrderedDataOutputStream.j(i16);
                    byteOrderedDataOutputStream.j(value.f6611a);
                    byteOrderedDataOutputStream.e(value.f6612b);
                    if (p9 > 4) {
                        byteOrderedDataOutputStream.h(size);
                        size += p9;
                    } else {
                        byteOrderedDataOutputStream.write(value.f6614d);
                        if (p9 < 4) {
                            while (p9 < 4) {
                                byteOrderedDataOutputStream.c(0);
                                p9++;
                            }
                        }
                    }
                }
                if (i15 == 0 && !this.f6584f[4].isEmpty()) {
                    byteOrderedDataOutputStream.h(iArr[4]);
                } else {
                    byteOrderedDataOutputStream.h(0L);
                }
                for (Map.Entry<String, ExifAttribute> entry4 : this.f6584f[i15].entrySet()) {
                    byte[] bArr = entry4.getValue().f6614d;
                    if (bArr.length > 4) {
                        byteOrderedDataOutputStream.write(bArr, 0, bArr.length);
                    }
                }
            }
        }
        if (this.f6587i) {
            byteOrderedDataOutputStream.write(v());
        }
        if (this.f6582d == 14 && i11 % 2 == 1) {
            byteOrderedDataOutputStream.c(0);
        }
        byteOrderedDataOutputStream.a(ByteOrder.BIG_ENDIAN);
        return i11;
    }

    private void k(final SeekableByteOrderedDataInputStream seekableByteOrderedDataInputStream) throws IOException {
        String str;
        String str2;
        if (Build.VERSION.SDK_INT >= 28) {
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            try {
                try {
                    ExifInterfaceUtils.Api23Impl.a(mediaMetadataRetriever, new MediaDataSource() { // from class: androidx.exifinterface.media.ExifInterface.1

                        /* renamed from: f  reason: collision with root package name */
                        long f6600f;

                        @Override // java.io.Closeable, java.lang.AutoCloseable
                        public void close() throws IOException {
                        }

                        public long getSize() throws IOException {
                            return -1L;
                        }

                        public int readAt(long j8, byte[] bArr, int i8, int i9) throws IOException {
                            if (i9 == 0) {
                                return 0;
                            }
                            if (j8 < 0) {
                                return -1;
                            }
                            try {
                                long j9 = this.f6600f;
                                if (j9 != j8) {
                                    if (j9 >= 0 && j8 >= j9 + seekableByteOrderedDataInputStream.available()) {
                                        return -1;
                                    }
                                    seekableByteOrderedDataInputStream.h(j8);
                                    this.f6600f = j8;
                                }
                                if (i9 > seekableByteOrderedDataInputStream.available()) {
                                    i9 = seekableByteOrderedDataInputStream.available();
                                }
                                int read = seekableByteOrderedDataInputStream.read(bArr, i8, i9);
                                if (read >= 0) {
                                    this.f6600f += read;
                                    return read;
                                }
                            } catch (IOException unused) {
                            }
                            this.f6600f = -1L;
                            return -1;
                        }
                    });
                    String extractMetadata = mediaMetadataRetriever.extractMetadata(33);
                    String extractMetadata2 = mediaMetadataRetriever.extractMetadata(34);
                    String extractMetadata3 = mediaMetadataRetriever.extractMetadata(26);
                    String extractMetadata4 = mediaMetadataRetriever.extractMetadata(17);
                    String str3 = null;
                    if ("yes".equals(extractMetadata3)) {
                        str3 = mediaMetadataRetriever.extractMetadata(29);
                        str = mediaMetadataRetriever.extractMetadata(30);
                        str2 = mediaMetadataRetriever.extractMetadata(31);
                    } else if ("yes".equals(extractMetadata4)) {
                        str3 = mediaMetadataRetriever.extractMetadata(18);
                        str = mediaMetadataRetriever.extractMetadata(19);
                        str2 = mediaMetadataRetriever.extractMetadata(24);
                    } else {
                        str = null;
                        str2 = null;
                    }
                    if (str3 != null) {
                        this.f6584f[0].put("ImageWidth", ExifAttribute.j(Integer.parseInt(str3), this.f6586h));
                    }
                    if (str != null) {
                        this.f6584f[0].put("ImageLength", ExifAttribute.j(Integer.parseInt(str), this.f6586h));
                    }
                    if (str2 != null) {
                        int i8 = 1;
                        int parseInt = Integer.parseInt(str2);
                        if (parseInt != 90) {
                            if (parseInt != 180) {
                                if (parseInt == 270) {
                                    i8 = 8;
                                }
                            } else {
                                i8 = 3;
                            }
                        } else {
                            i8 = 6;
                        }
                        this.f6584f[0].put("Orientation", ExifAttribute.j(i8, this.f6586h));
                    }
                    if (extractMetadata != null && extractMetadata2 != null) {
                        int parseInt2 = Integer.parseInt(extractMetadata);
                        int parseInt3 = Integer.parseInt(extractMetadata2);
                        if (parseInt3 > 6) {
                            seekableByteOrderedDataInputStream.h(parseInt2);
                            byte[] bArr = new byte[6];
                            if (seekableByteOrderedDataInputStream.read(bArr) == 6) {
                                int i9 = parseInt2 + 6;
                                int i10 = parseInt3 - 6;
                                if (Arrays.equals(bArr, f6568q0)) {
                                    byte[] bArr2 = new byte[i10];
                                    if (seekableByteOrderedDataInputStream.read(bArr2) == i10) {
                                        this.f6594p = i9;
                                        R(bArr2, 0);
                                    } else {
                                        throw new IOException("Can't read exif");
                                    }
                                } else {
                                    throw new IOException("Invalid identifier");
                                }
                            } else {
                                throw new IOException("Can't read identifier");
                            }
                        } else {
                            throw new IOException("Invalid exif length");
                        }
                    }
                    if (f6573v) {
                        Log.d("ExifInterface", "Heif meta: " + str3 + "x" + str + ", rotation " + str2);
                    }
                    return;
                } catch (RuntimeException unused) {
                    throw new UnsupportedOperationException("Failed to read EXIF from HEIF file. Given stream is either malformed or unsupported.");
                }
            } finally {
                mediaMetadataRetriever.release();
            }
        }
        throw new UnsupportedOperationException("Reading EXIF from HEIF files is supported from SDK 28 and above");
    }

    /* JADX WARN: Code restructure failed: missing block: B:68:0x019a, code lost:
        r22.e(r21.f6586h);
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x019f, code lost:
        return;
     */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00ba A[FALL_THROUGH] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0184 A[LOOP:0: B:10:0x0038->B:63:0x0184, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x018e A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void l(androidx.exifinterface.media.ExifInterface.ByteOrderedDataInputStream r22, int r23, int r24) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 542
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.exifinterface.media.ExifInterface.l(androidx.exifinterface.media.ExifInterface$ByteOrderedDataInputStream, int, int):void");
    }

    private int n(BufferedInputStream bufferedInputStream) throws IOException {
        bufferedInputStream.mark(5000);
        byte[] bArr = new byte[5000];
        bufferedInputStream.read(bArr);
        bufferedInputStream.reset();
        if (D(bArr)) {
            return 4;
        }
        if (G(bArr)) {
            return 9;
        }
        if (C(bArr)) {
            return 12;
        }
        if (E(bArr)) {
            return 7;
        }
        if (H(bArr)) {
            return 10;
        }
        if (F(bArr)) {
            return 13;
        }
        if (M(bArr)) {
            return 14;
        }
        return 0;
    }

    private void o(SeekableByteOrderedDataInputStream seekableByteOrderedDataInputStream) throws IOException {
        int i8;
        int i9;
        r(seekableByteOrderedDataInputStream);
        ExifAttribute exifAttribute = this.f6584f[1].get("MakerNote");
        if (exifAttribute != null) {
            SeekableByteOrderedDataInputStream seekableByteOrderedDataInputStream2 = new SeekableByteOrderedDataInputStream(exifAttribute.f6614d);
            seekableByteOrderedDataInputStream2.e(this.f6586h);
            byte[] bArr = F;
            byte[] bArr2 = new byte[bArr.length];
            seekableByteOrderedDataInputStream2.readFully(bArr2);
            seekableByteOrderedDataInputStream2.h(0L);
            byte[] bArr3 = G;
            byte[] bArr4 = new byte[bArr3.length];
            seekableByteOrderedDataInputStream2.readFully(bArr4);
            if (Arrays.equals(bArr2, bArr)) {
                seekableByteOrderedDataInputStream2.h(8L);
            } else if (Arrays.equals(bArr4, bArr3)) {
                seekableByteOrderedDataInputStream2.h(12L);
            }
            S(seekableByteOrderedDataInputStream2, 6);
            ExifAttribute exifAttribute2 = this.f6584f[7].get("PreviewImageStart");
            ExifAttribute exifAttribute3 = this.f6584f[7].get("PreviewImageLength");
            if (exifAttribute2 != null && exifAttribute3 != null) {
                this.f6584f[5].put("JPEGInterchangeFormat", exifAttribute2);
                this.f6584f[5].put("JPEGInterchangeFormatLength", exifAttribute3);
            }
            ExifAttribute exifAttribute4 = this.f6584f[8].get("AspectFrame");
            if (exifAttribute4 != null) {
                int[] iArr = (int[]) exifAttribute4.o(this.f6586h);
                if (iArr != null && iArr.length == 4) {
                    int i10 = iArr[2];
                    int i11 = iArr[0];
                    if (i10 > i11 && (i8 = iArr[3]) > (i9 = iArr[1])) {
                        int i12 = (i10 - i11) + 1;
                        int i13 = (i8 - i9) + 1;
                        if (i12 < i13) {
                            int i14 = i12 + i13;
                            i13 = i14 - i13;
                            i12 = i14 - i13;
                        }
                        ExifAttribute j8 = ExifAttribute.j(i12, this.f6586h);
                        ExifAttribute j9 = ExifAttribute.j(i13, this.f6586h);
                        this.f6584f[0].put("ImageWidth", j8);
                        this.f6584f[0].put("ImageLength", j9);
                        return;
                    }
                    return;
                }
                Log.w("ExifInterface", "Invalid aspect frame values. frame=" + Arrays.toString(iArr));
            }
        }
    }

    private void p(ByteOrderedDataInputStream byteOrderedDataInputStream) throws IOException {
        if (f6573v) {
            Log.d("ExifInterface", "getPngAttributes starting with: " + byteOrderedDataInputStream);
        }
        byteOrderedDataInputStream.e(ByteOrder.BIG_ENDIAN);
        byte[] bArr = H;
        byteOrderedDataInputStream.g(bArr.length);
        int length = bArr.length + 0;
        while (true) {
            try {
                int readInt = byteOrderedDataInputStream.readInt();
                int i8 = length + 4;
                byte[] bArr2 = new byte[4];
                if (byteOrderedDataInputStream.read(bArr2) == 4) {
                    int i9 = i8 + 4;
                    if (i9 == 16 && !Arrays.equals(bArr2, J)) {
                        throw new IOException("Encountered invalid PNG file--IHDR chunk should appearas the first chunk");
                    }
                    if (!Arrays.equals(bArr2, K)) {
                        if (Arrays.equals(bArr2, I)) {
                            byte[] bArr3 = new byte[readInt];
                            if (byteOrderedDataInputStream.read(bArr3) == readInt) {
                                int readInt2 = byteOrderedDataInputStream.readInt();
                                CRC32 crc32 = new CRC32();
                                crc32.update(bArr2);
                                crc32.update(bArr3);
                                if (((int) crc32.getValue()) == readInt2) {
                                    this.f6594p = i9;
                                    R(bArr3, 0);
                                    i0();
                                    e0(new ByteOrderedDataInputStream(bArr3));
                                    return;
                                }
                                throw new IOException("Encountered invalid CRC value for PNG-EXIF chunk.\n recorded CRC value: " + readInt2 + ", calculated CRC value: " + crc32.getValue());
                            }
                            throw new IOException("Failed to read given length for given PNG chunk type: " + ExifInterfaceUtils.a(bArr2));
                        }
                        int i10 = readInt + 4;
                        byteOrderedDataInputStream.g(i10);
                        length = i9 + i10;
                    } else {
                        return;
                    }
                } else {
                    throw new IOException("Encountered invalid length while parsing PNG chunktype");
                }
            } catch (EOFException unused) {
                throw new IOException("Encountered corrupt PNG file.");
            }
        }
    }

    private void q(ByteOrderedDataInputStream byteOrderedDataInputStream) throws IOException {
        boolean z7 = f6573v;
        if (z7) {
            Log.d("ExifInterface", "getRafAttributes starting with: " + byteOrderedDataInputStream);
        }
        byteOrderedDataInputStream.g(84);
        byte[] bArr = new byte[4];
        byte[] bArr2 = new byte[4];
        byte[] bArr3 = new byte[4];
        byteOrderedDataInputStream.read(bArr);
        byteOrderedDataInputStream.read(bArr2);
        byteOrderedDataInputStream.read(bArr3);
        int i8 = ByteBuffer.wrap(bArr).getInt();
        int i9 = ByteBuffer.wrap(bArr2).getInt();
        int i10 = ByteBuffer.wrap(bArr3).getInt();
        byte[] bArr4 = new byte[i9];
        byteOrderedDataInputStream.g(i8 - byteOrderedDataInputStream.a());
        byteOrderedDataInputStream.read(bArr4);
        l(new ByteOrderedDataInputStream(bArr4), i8, 5);
        byteOrderedDataInputStream.g(i10 - byteOrderedDataInputStream.a());
        byteOrderedDataInputStream.e(ByteOrder.BIG_ENDIAN);
        int readInt = byteOrderedDataInputStream.readInt();
        if (z7) {
            Log.d("ExifInterface", "numberOfDirectoryEntry: " + readInt);
        }
        for (int i11 = 0; i11 < readInt; i11++) {
            int readUnsignedShort = byteOrderedDataInputStream.readUnsignedShort();
            int readUnsignedShort2 = byteOrderedDataInputStream.readUnsignedShort();
            if (readUnsignedShort == f6556e0.f6615a) {
                short readShort = byteOrderedDataInputStream.readShort();
                short readShort2 = byteOrderedDataInputStream.readShort();
                ExifAttribute j8 = ExifAttribute.j(readShort, this.f6586h);
                ExifAttribute j9 = ExifAttribute.j(readShort2, this.f6586h);
                this.f6584f[0].put("ImageLength", j8);
                this.f6584f[0].put("ImageWidth", j9);
                if (f6573v) {
                    Log.d("ExifInterface", "Updated to length: " + ((int) readShort) + ", width: " + ((int) readShort2));
                    return;
                }
                return;
            }
            byteOrderedDataInputStream.g(readUnsignedShort2);
        }
    }

    private void r(SeekableByteOrderedDataInputStream seekableByteOrderedDataInputStream) throws IOException {
        ExifAttribute exifAttribute;
        O(seekableByteOrderedDataInputStream);
        S(seekableByteOrderedDataInputStream, 0);
        h0(seekableByteOrderedDataInputStream, 0);
        h0(seekableByteOrderedDataInputStream, 5);
        h0(seekableByteOrderedDataInputStream, 4);
        i0();
        if (this.f6582d == 8 && (exifAttribute = this.f6584f[1].get("MakerNote")) != null) {
            SeekableByteOrderedDataInputStream seekableByteOrderedDataInputStream2 = new SeekableByteOrderedDataInputStream(exifAttribute.f6614d);
            seekableByteOrderedDataInputStream2.e(this.f6586h);
            seekableByteOrderedDataInputStream2.g(6);
            S(seekableByteOrderedDataInputStream2, 9);
            ExifAttribute exifAttribute2 = this.f6584f[9].get("ColorSpace");
            if (exifAttribute2 != null) {
                this.f6584f[1].put("ColorSpace", exifAttribute2);
            }
        }
    }

    private void s(SeekableByteOrderedDataInputStream seekableByteOrderedDataInputStream) throws IOException {
        if (f6573v) {
            Log.d("ExifInterface", "getRw2Attributes starting with: " + seekableByteOrderedDataInputStream);
        }
        r(seekableByteOrderedDataInputStream);
        ExifAttribute exifAttribute = this.f6584f[0].get("JpgFromRaw");
        if (exifAttribute != null) {
            l(new ByteOrderedDataInputStream(exifAttribute.f6614d), (int) exifAttribute.f6613c, 5);
        }
        ExifAttribute exifAttribute2 = this.f6584f[0].get("ISO");
        ExifAttribute exifAttribute3 = this.f6584f[1].get("PhotographicSensitivity");
        if (exifAttribute2 != null && exifAttribute3 == null) {
            this.f6584f[1].put("PhotographicSensitivity", exifAttribute2);
        }
    }

    private void t(SeekableByteOrderedDataInputStream seekableByteOrderedDataInputStream) throws IOException {
        byte[] bArr = f6568q0;
        seekableByteOrderedDataInputStream.g(bArr.length);
        byte[] bArr2 = new byte[seekableByteOrderedDataInputStream.available()];
        seekableByteOrderedDataInputStream.readFully(bArr2);
        this.f6594p = bArr.length;
        R(bArr2, 0);
    }

    private void w(ByteOrderedDataInputStream byteOrderedDataInputStream) throws IOException {
        if (f6573v) {
            Log.d("ExifInterface", "getWebpAttributes starting with: " + byteOrderedDataInputStream);
        }
        byteOrderedDataInputStream.e(ByteOrder.LITTLE_ENDIAN);
        byteOrderedDataInputStream.g(L.length);
        int readInt = byteOrderedDataInputStream.readInt() + 8;
        byte[] bArr = M;
        byteOrderedDataInputStream.g(bArr.length);
        int length = bArr.length + 8;
        while (true) {
            try {
                byte[] bArr2 = new byte[4];
                if (byteOrderedDataInputStream.read(bArr2) == 4) {
                    int readInt2 = byteOrderedDataInputStream.readInt();
                    int i8 = length + 4 + 4;
                    if (Arrays.equals(N, bArr2)) {
                        byte[] bArr3 = new byte[readInt2];
                        if (byteOrderedDataInputStream.read(bArr3) == readInt2) {
                            this.f6594p = i8;
                            R(bArr3, 0);
                            e0(new ByteOrderedDataInputStream(bArr3));
                            return;
                        }
                        throw new IOException("Failed to read given length for given PNG chunk type: " + ExifInterfaceUtils.a(bArr2));
                    }
                    if (readInt2 % 2 == 1) {
                        readInt2++;
                    }
                    length = i8 + readInt2;
                    if (length == readInt) {
                        return;
                    }
                    if (length <= readInt) {
                        byteOrderedDataInputStream.g(readInt2);
                    } else {
                        throw new IOException("Encountered WebP file with invalid chunk size");
                    }
                } else {
                    throw new IOException("Encountered invalid length while parsing WebP chunktype");
                }
            } catch (EOFException unused) {
                throw new IOException("Encountered corrupt WebP file.");
            }
        }
    }

    private static Pair<Integer, Integer> x(String str) {
        int intValue;
        int i8;
        if (str.contains(",")) {
            String[] split = str.split(",", -1);
            Pair<Integer, Integer> x7 = x(split[0]);
            if (((Integer) x7.first).intValue() == 2) {
                return x7;
            }
            for (int i9 = 1; i9 < split.length; i9++) {
                Pair<Integer, Integer> x8 = x(split[i9]);
                if (!((Integer) x8.first).equals(x7.first) && !((Integer) x8.second).equals(x7.first)) {
                    intValue = -1;
                } else {
                    intValue = ((Integer) x7.first).intValue();
                }
                if (((Integer) x7.second).intValue() != -1 && (((Integer) x8.first).equals(x7.second) || ((Integer) x8.second).equals(x7.second))) {
                    i8 = ((Integer) x7.second).intValue();
                } else {
                    i8 = -1;
                }
                if (intValue == -1 && i8 == -1) {
                    return new Pair<>(2, -1);
                }
                if (intValue == -1) {
                    x7 = new Pair<>(Integer.valueOf(i8), -1);
                } else if (i8 == -1) {
                    x7 = new Pair<>(Integer.valueOf(intValue), -1);
                }
            }
            return x7;
        } else if (str.contains("/")) {
            String[] split2 = str.split("/", -1);
            if (split2.length == 2) {
                try {
                    long parseDouble = (long) Double.parseDouble(split2[0]);
                    long parseDouble2 = (long) Double.parseDouble(split2[1]);
                    if (parseDouble >= 0 && parseDouble2 >= 0) {
                        if (parseDouble <= 2147483647L && parseDouble2 <= 2147483647L) {
                            return new Pair<>(10, 5);
                        }
                        return new Pair<>(5, -1);
                    }
                    return new Pair<>(10, -1);
                } catch (NumberFormatException unused) {
                }
            }
            return new Pair<>(2, -1);
        } else {
            try {
                try {
                    Long valueOf = Long.valueOf(Long.parseLong(str));
                    if (valueOf.longValue() >= 0 && valueOf.longValue() <= WebSocketProtocol.PAYLOAD_SHORT_MAX) {
                        return new Pair<>(3, 4);
                    }
                    if (valueOf.longValue() < 0) {
                        return new Pair<>(9, -1);
                    }
                    return new Pair<>(4, -1);
                } catch (NumberFormatException unused2) {
                    Double.parseDouble(str);
                    return new Pair<>(12, -1);
                }
            } catch (NumberFormatException unused3) {
                return new Pair<>(2, -1);
            }
        }
    }

    private void y(ByteOrderedDataInputStream byteOrderedDataInputStream, HashMap hashMap) throws IOException {
        ExifAttribute exifAttribute = (ExifAttribute) hashMap.get("JPEGInterchangeFormat");
        ExifAttribute exifAttribute2 = (ExifAttribute) hashMap.get("JPEGInterchangeFormatLength");
        if (exifAttribute != null && exifAttribute2 != null) {
            int m8 = exifAttribute.m(this.f6586h);
            int m9 = exifAttribute2.m(this.f6586h);
            if (this.f6582d == 7) {
                m8 += this.f6595q;
            }
            if (m8 > 0 && m9 > 0) {
                this.f6587i = true;
                if (this.f6579a == null && this.f6581c == null && this.f6580b == null) {
                    byte[] bArr = new byte[m9];
                    byteOrderedDataInputStream.skip(m8);
                    byteOrderedDataInputStream.read(bArr);
                    this.f6592n = bArr;
                }
                this.f6590l = m8;
                this.f6591m = m9;
            }
            if (f6573v) {
                Log.d("ExifInterface", "Setting thumbnail attributes with offset: " + m8 + ", length: " + m9);
            }
        }
    }

    private void z(ByteOrderedDataInputStream byteOrderedDataInputStream, HashMap hashMap) throws IOException {
        ExifAttribute exifAttribute = (ExifAttribute) hashMap.get("StripOffsets");
        ExifAttribute exifAttribute2 = (ExifAttribute) hashMap.get("StripByteCounts");
        if (exifAttribute != null && exifAttribute2 != null) {
            long[] d8 = ExifInterfaceUtils.d(exifAttribute.o(this.f6586h));
            long[] d9 = ExifInterfaceUtils.d(exifAttribute2.o(this.f6586h));
            if (d8 != null && d8.length != 0) {
                if (d9 != null && d9.length != 0) {
                    if (d8.length != d9.length) {
                        Log.w("ExifInterface", "stripOffsets and stripByteCounts should have same length.");
                        return;
                    }
                    long j8 = 0;
                    for (long j9 : d9) {
                        j8 += j9;
                    }
                    int i8 = (int) j8;
                    byte[] bArr = new byte[i8];
                    int i9 = 1;
                    this.f6589k = true;
                    this.f6588j = true;
                    this.f6587i = true;
                    int i10 = 0;
                    int i11 = 0;
                    int i12 = 0;
                    while (i10 < d8.length) {
                        int i13 = (int) d8[i10];
                        int i14 = (int) d9[i10];
                        if (i10 < d8.length - i9 && i13 + i14 != d8[i10 + 1]) {
                            this.f6589k = false;
                        }
                        int i15 = i13 - i11;
                        if (i15 < 0) {
                            Log.d("ExifInterface", "Invalid strip offset value");
                            return;
                        }
                        long j10 = i15;
                        if (byteOrderedDataInputStream.skip(j10) != j10) {
                            Log.d("ExifInterface", "Failed to skip " + i15 + " bytes.");
                            return;
                        }
                        int i16 = i11 + i15;
                        byte[] bArr2 = new byte[i14];
                        if (byteOrderedDataInputStream.read(bArr2) != i14) {
                            Log.d("ExifInterface", "Failed to read " + i14 + " bytes.");
                            return;
                        }
                        i11 = i16 + i14;
                        System.arraycopy(bArr2, 0, bArr, i12, i14);
                        i12 += i14;
                        i10++;
                        i9 = 1;
                    }
                    this.f6592n = bArr;
                    if (this.f6589k) {
                        this.f6590l = (int) d8[0];
                        this.f6591m = i8;
                        return;
                    }
                    return;
                }
                Log.w("ExifInterface", "stripByteCounts should not be null or have zero length.");
                return;
            }
            Log.w("ExifInterface", "stripOffsets should not be null or have zero length.");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:64:0x00e4 A[Catch: all -> 0x010c, Exception -> 0x010f, TryCatch #20 {Exception -> 0x010f, all -> 0x010c, blocks: (B:62:0x00e0, B:64:0x00e4, B:66:0x00fa, B:65:0x00f3), top: B:121:0x00e0 }] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00f3 A[Catch: all -> 0x010c, Exception -> 0x010f, TryCatch #20 {Exception -> 0x010f, all -> 0x010c, blocks: (B:62:0x00e0, B:64:0x00e4, B:66:0x00fa, B:65:0x00f3), top: B:121:0x00e0 }] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0146  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void W() throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 371
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.exifinterface.media.ExifInterface.W():void");
    }

    public void a0(double d8) {
        String str;
        if (d8 >= 0.0d) {
            str = "0";
        } else {
            str = "1";
        }
        b0("GPSAltitude", new Rational(Math.abs(d8)).toString());
        b0("GPSAltitudeRef", str);
    }

    public void b0(@NonNull String str, String str2) {
        ExifTag exifTag;
        int i8;
        String str3;
        Matcher matcher;
        String str4 = str;
        String str5 = str2;
        if (str4 != null) {
            if (("DateTime".equals(str4) || "DateTimeOriginal".equals(str4) || "DateTimeDigitized".equals(str4)) && str5 != null) {
                boolean find = f6572u0.matcher(str5).find();
                boolean find2 = f6574v0.matcher(str5).find();
                if (str2.length() == 19 && (find || find2)) {
                    if (find2) {
                        str5 = str5.replaceAll("-", ":");
                    }
                } else {
                    Log.w("ExifInterface", "Invalid value for " + str4 + " : " + str5);
                    return;
                }
            }
            if ("ISOSpeedRatings".equals(str4)) {
                if (f6573v) {
                    Log.d("ExifInterface", "setAttribute: Replacing TAG_ISO_SPEED_RATINGS with TAG_PHOTOGRAPHIC_SENSITIVITY.");
                }
                str4 = "PhotographicSensitivity";
            }
            int i9 = 2;
            int i10 = 1;
            if (str5 != null && f6565n0.contains(str4)) {
                if (str4.equals("GPSTimeStamp")) {
                    if (!f6571t0.matcher(str5).find()) {
                        Log.w("ExifInterface", "Invalid value for " + str4 + " : " + str5);
                        return;
                    }
                    str5 = Integer.parseInt(matcher.group(1)) + "/1," + Integer.parseInt(matcher.group(2)) + "/1," + Integer.parseInt(matcher.group(3)) + "/1";
                } else {
                    try {
                        str5 = new Rational(Double.parseDouble(str5)).toString();
                    } catch (NumberFormatException unused) {
                        Log.w("ExifInterface", "Invalid value for " + str4 + " : " + str5);
                        return;
                    }
                }
            }
            char c8 = 0;
            int i11 = 0;
            while (i11 < f6561j0.length) {
                if ((i11 != 4 || this.f6587i) && (exifTag = f6564m0[i11].get(str4)) != null) {
                    if (str5 == null) {
                        this.f6584f[i11].remove(str4);
                    } else {
                        Pair<Integer, Integer> x7 = x(str5);
                        int i12 = -1;
                        if (exifTag.f6617c != ((Integer) x7.first).intValue() && exifTag.f6617c != ((Integer) x7.second).intValue()) {
                            int i13 = exifTag.f6618d;
                            if (i13 != -1 && (i13 == ((Integer) x7.first).intValue() || exifTag.f6618d == ((Integer) x7.second).intValue())) {
                                i8 = exifTag.f6618d;
                            } else {
                                int i14 = exifTag.f6617c;
                                if (i14 != i10 && i14 != 7 && i14 != i9) {
                                    if (f6573v) {
                                        StringBuilder sb = new StringBuilder();
                                        sb.append("Given tag (");
                                        sb.append(str4);
                                        sb.append(") value didn't match with one of expected formats: ");
                                        String[] strArr = W;
                                        sb.append(strArr[exifTag.f6617c]);
                                        String str6 = "";
                                        if (exifTag.f6618d == -1) {
                                            str3 = "";
                                        } else {
                                            str3 = ", " + strArr[exifTag.f6618d];
                                        }
                                        sb.append(str3);
                                        sb.append(" (guess: ");
                                        sb.append(strArr[((Integer) x7.first).intValue()]);
                                        if (((Integer) x7.second).intValue() != -1) {
                                            str6 = ", " + strArr[((Integer) x7.second).intValue()];
                                        }
                                        sb.append(str6);
                                        sb.append(")");
                                        Log.d("ExifInterface", sb.toString());
                                    }
                                } else {
                                    i8 = i14;
                                }
                            }
                        } else {
                            i8 = exifTag.f6617c;
                        }
                        switch (i8) {
                            case 1:
                                this.f6584f[i11].put(str4, ExifAttribute.a(str5));
                                continue;
                                i11++;
                                i9 = 2;
                                c8 = 0;
                                i10 = 1;
                            case 2:
                            case 7:
                                this.f6584f[i11].put(str4, ExifAttribute.e(str5));
                                continue;
                                i11++;
                                i9 = 2;
                                c8 = 0;
                                i10 = 1;
                            case 3:
                                String[] split = str5.split(",", -1);
                                int[] iArr = new int[split.length];
                                for (int i15 = 0; i15 < split.length; i15++) {
                                    iArr[i15] = Integer.parseInt(split[i15]);
                                }
                                this.f6584f[i11].put(str4, ExifAttribute.k(iArr, this.f6586h));
                                continue;
                                i11++;
                                i9 = 2;
                                c8 = 0;
                                i10 = 1;
                            case 4:
                                String[] split2 = str5.split(",", -1);
                                long[] jArr = new long[split2.length];
                                for (int i16 = 0; i16 < split2.length; i16++) {
                                    jArr[i16] = Long.parseLong(split2[i16]);
                                }
                                this.f6584f[i11].put(str4, ExifAttribute.g(jArr, this.f6586h));
                                continue;
                                i11++;
                                i9 = 2;
                                c8 = 0;
                                i10 = 1;
                            case 5:
                                String[] split3 = str5.split(",", -1);
                                Rational[] rationalArr = new Rational[split3.length];
                                int i17 = 0;
                                while (i17 < split3.length) {
                                    String[] split4 = split3[i17].split("/", i12);
                                    rationalArr[i17] = new Rational((long) Double.parseDouble(split4[0]), (long) Double.parseDouble(split4[1]));
                                    i17++;
                                    i12 = -1;
                                }
                                this.f6584f[i11].put(str4, ExifAttribute.i(rationalArr, this.f6586h));
                                continue;
                                i11++;
                                i9 = 2;
                                c8 = 0;
                                i10 = 1;
                            case 6:
                            case 8:
                            case 11:
                            default:
                                if (f6573v) {
                                    Log.d("ExifInterface", "Data format isn't one of expected formats: " + i8);
                                } else {
                                    continue;
                                }
                                i11++;
                                i9 = 2;
                                c8 = 0;
                                i10 = 1;
                            case 9:
                                String[] split5 = str5.split(",", -1);
                                int[] iArr2 = new int[split5.length];
                                for (int i18 = 0; i18 < split5.length; i18++) {
                                    iArr2[i18] = Integer.parseInt(split5[i18]);
                                }
                                this.f6584f[i11].put(str4, ExifAttribute.c(iArr2, this.f6586h));
                                break;
                            case 10:
                                String[] split6 = str5.split(",", -1);
                                Rational[] rationalArr2 = new Rational[split6.length];
                                int i19 = 0;
                                while (i19 < split6.length) {
                                    String[] split7 = split6[i19].split("/", -1);
                                    rationalArr2[i19] = new Rational((long) Double.parseDouble(split7[c8]), (long) Double.parseDouble(split7[i10]));
                                    i19++;
                                    split6 = split6;
                                    c8 = 0;
                                    i10 = 1;
                                }
                                this.f6584f[i11].put(str4, ExifAttribute.d(rationalArr2, this.f6586h));
                                break;
                            case 12:
                                String[] split8 = str5.split(",", -1);
                                double[] dArr = new double[split8.length];
                                for (int i20 = 0; i20 < split8.length; i20++) {
                                    dArr[i20] = Double.parseDouble(split8[i20]);
                                }
                                this.f6584f[i11].put(str4, ExifAttribute.b(dArr, this.f6586h));
                                break;
                        }
                    }
                }
                i11++;
                i9 = 2;
                c8 = 0;
                i10 = 1;
            }
            return;
        }
        throw new NullPointerException("tag shouldn't be null");
    }

    public void c0(Location location) {
        if (location == null) {
            return;
        }
        b0("GPSProcessingMethod", location.getProvider());
        d0(location.getLatitude(), location.getLongitude());
        a0(location.getAltitude());
        b0("GPSSpeedRef", "K");
        b0("GPSSpeed", new Rational((location.getSpeed() * ((float) TimeUnit.HOURS.toSeconds(1L))) / 1000.0f).toString());
        String[] split = U.format(new Date(location.getTime())).split("\\s+", -1);
        b0("GPSDateStamp", split[0]);
        b0("GPSTimeStamp", split[1]);
    }

    public void d0(double d8, double d9) {
        String str;
        String str2;
        if (d8 >= -90.0d && d8 <= 90.0d && !Double.isNaN(d8)) {
            if (d9 >= -180.0d && d9 <= 180.0d && !Double.isNaN(d9)) {
                if (d8 >= 0.0d) {
                    str = "N";
                } else {
                    str = "S";
                }
                b0("GPSLatitudeRef", str);
                b0("GPSLatitude", b(Math.abs(d8)));
                if (d9 >= 0.0d) {
                    str2 = "E";
                } else {
                    str2 = "W";
                }
                b0("GPSLongitudeRef", str2);
                b0("GPSLongitude", b(Math.abs(d9)));
                return;
            }
            throw new IllegalArgumentException("Longitude value " + d9 + " is not valid.");
        }
        throw new IllegalArgumentException("Latitude value " + d8 + " is not valid.");
    }

    public double f(double d8) {
        double h8 = h("GPSAltitude", -1.0d);
        int i8 = -1;
        int i9 = i("GPSAltitudeRef", -1);
        if (h8 >= 0.0d && i9 >= 0) {
            if (i9 != 1) {
                i8 = 1;
            }
            return h8 * i8;
        }
        return d8;
    }

    public String g(@NonNull String str) {
        if (str != null) {
            ExifAttribute j8 = j(str);
            if (j8 != null) {
                if (!f6565n0.contains(str)) {
                    return j8.n(this.f6586h);
                }
                if (str.equals("GPSTimeStamp")) {
                    int i8 = j8.f6611a;
                    if (i8 != 5 && i8 != 10) {
                        Log.w("ExifInterface", "GPS Timestamp format is not rational. format=" + j8.f6611a);
                        return null;
                    }
                    Rational[] rationalArr = (Rational[]) j8.o(this.f6586h);
                    if (rationalArr != null && rationalArr.length == 3) {
                        Rational rational = rationalArr[0];
                        Rational rational2 = rationalArr[1];
                        Rational rational3 = rationalArr[2];
                        return String.format("%02d:%02d:%02d", Integer.valueOf((int) (((float) rational.f6619a) / ((float) rational.f6620b))), Integer.valueOf((int) (((float) rational2.f6619a) / ((float) rational2.f6620b))), Integer.valueOf((int) (((float) rational3.f6619a) / ((float) rational3.f6620b))));
                    }
                    Log.w("ExifInterface", "Invalid GPS Timestamp array. array=" + Arrays.toString(rationalArr));
                    return null;
                }
                try {
                    return Double.toString(j8.l(this.f6586h));
                } catch (NumberFormatException unused) {
                }
            }
            return null;
        }
        throw new NullPointerException("tag shouldn't be null");
    }

    public double h(@NonNull String str, double d8) {
        if (str != null) {
            ExifAttribute j8 = j(str);
            if (j8 == null) {
                return d8;
            }
            try {
                return j8.l(this.f6586h);
            } catch (NumberFormatException unused) {
                return d8;
            }
        }
        throw new NullPointerException("tag shouldn't be null");
    }

    public int i(@NonNull String str, int i8) {
        if (str != null) {
            ExifAttribute j8 = j(str);
            if (j8 == null) {
                return i8;
            }
            try {
                return j8.m(this.f6586h);
            } catch (NumberFormatException unused) {
                return i8;
            }
        }
        throw new NullPointerException("tag shouldn't be null");
    }

    public double[] m() {
        String g8 = g("GPSLatitude");
        String g9 = g("GPSLatitudeRef");
        String g10 = g("GPSLongitude");
        String g11 = g("GPSLongitudeRef");
        if (g8 != null && g9 != null && g10 != null && g11 != null) {
            try {
                return new double[]{c(g8, g9), c(g10, g11)};
            } catch (IllegalArgumentException unused) {
                Log.w("ExifInterface", "Latitude/longitude values are not parsable. " + String.format("latValue=%s, latRef=%s, lngValue=%s, lngRef=%s", g8, g9, g10, g11));
                return null;
            }
        }
        return null;
    }

    public byte[] u() {
        int i8 = this.f6593o;
        if (i8 != 6 && i8 != 7) {
            return null;
        }
        return v();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0065 A[Catch: Exception -> 0x0088, all -> 0x00a7, TRY_ENTER, TryCatch #3 {all -> 0x00a7, blocks: (B:28:0x004f, B:31:0x0065, B:33:0x0071, B:38:0x007c, B:39:0x0081, B:40:0x0082, B:41:0x0087, B:52:0x0099), top: B:63:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0082 A[Catch: Exception -> 0x0088, all -> 0x00a7, TryCatch #3 {all -> 0x00a7, blocks: (B:28:0x004f, B:31:0x0065, B:33:0x0071, B:38:0x007c, B:39:0x0081, B:40:0x0082, B:41:0x0087, B:52:0x0099), top: B:63:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00ae  */
    /* JADX WARN: Type inference failed for: r1v1, types: [byte[]] */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r1v5, types: [android.content.res.AssetManager$AssetInputStream, java.io.Closeable, java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r1v6, types: [java.io.Closeable, java.io.InputStream] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public byte[] v() {
        /*
            r11 = this;
            java.lang.String r0 = "ExifInterface"
            boolean r1 = r11.f6587i
            r2 = 0
            if (r1 != 0) goto L8
            return r2
        L8:
            byte[] r1 = r11.f6592n
            if (r1 == 0) goto Ld
            return r1
        Ld:
            android.content.res.AssetManager$AssetInputStream r1 = r11.f6581c     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L95
            if (r1 == 0) goto L2e
            boolean r3 = r1.markSupported()     // Catch: java.lang.Throwable -> L25 java.lang.Exception -> L29
            if (r3 == 0) goto L1c
            r1.reset()     // Catch: java.lang.Throwable -> L25 java.lang.Exception -> L29
        L1a:
            r3 = r2
            goto L4f
        L1c:
            java.lang.String r3 = "Cannot read thumbnail from inputstream without mark/reset support"
            android.util.Log.d(r0, r3)     // Catch: java.lang.Throwable -> L25 java.lang.Exception -> L29
            androidx.exifinterface.media.ExifInterfaceUtils.c(r1)
            return r2
        L25:
            r0 = move-exception
            r3 = r2
            goto La8
        L29:
            r3 = move-exception
            r4 = r3
            r3 = r2
            goto L99
        L2e:
            java.lang.String r1 = r11.f6579a     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L95
            if (r1 == 0) goto L3a
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L95
            java.lang.String r3 = r11.f6579a     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L95
            r1.<init>(r3)     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L95
            goto L1a
        L3a:
            java.io.FileDescriptor r1 = r11.f6580b     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L95
            java.io.FileDescriptor r1 = androidx.exifinterface.media.ExifInterfaceUtils.Api21Impl.b(r1)     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L95
            r3 = 0
            int r5 = android.system.OsConstants.SEEK_SET     // Catch: java.lang.Throwable -> L8a java.lang.Exception -> L8d
            androidx.exifinterface.media.ExifInterfaceUtils.Api21Impl.c(r1, r3, r5)     // Catch: java.lang.Throwable -> L8a java.lang.Exception -> L8d
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L8a java.lang.Exception -> L8d
            r3.<init>(r1)     // Catch: java.lang.Throwable -> L8a java.lang.Exception -> L8d
            r10 = r3
            r3 = r1
            r1 = r10
        L4f:
            int r4 = r11.f6590l     // Catch: java.lang.Exception -> L88 java.lang.Throwable -> La7
            int r5 = r11.f6594p     // Catch: java.lang.Exception -> L88 java.lang.Throwable -> La7
            int r4 = r4 + r5
            long r4 = (long) r4     // Catch: java.lang.Exception -> L88 java.lang.Throwable -> La7
            long r4 = r1.skip(r4)     // Catch: java.lang.Exception -> L88 java.lang.Throwable -> La7
            int r6 = r11.f6590l     // Catch: java.lang.Exception -> L88 java.lang.Throwable -> La7
            int r7 = r11.f6594p     // Catch: java.lang.Exception -> L88 java.lang.Throwable -> La7
            int r6 = r6 + r7
            long r6 = (long) r6
            java.lang.String r8 = "Corrupted image"
            int r9 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r9 != 0) goto L82
            int r4 = r11.f6591m     // Catch: java.lang.Exception -> L88 java.lang.Throwable -> La7
            byte[] r4 = new byte[r4]     // Catch: java.lang.Exception -> L88 java.lang.Throwable -> La7
            int r5 = r1.read(r4)     // Catch: java.lang.Exception -> L88 java.lang.Throwable -> La7
            int r6 = r11.f6591m     // Catch: java.lang.Exception -> L88 java.lang.Throwable -> La7
            if (r5 != r6) goto L7c
            r11.f6592n = r4     // Catch: java.lang.Exception -> L88 java.lang.Throwable -> La7
            androidx.exifinterface.media.ExifInterfaceUtils.c(r1)
            if (r3 == 0) goto L7b
            androidx.exifinterface.media.ExifInterfaceUtils.b(r3)
        L7b:
            return r4
        L7c:
            java.io.IOException r4 = new java.io.IOException     // Catch: java.lang.Exception -> L88 java.lang.Throwable -> La7
            r4.<init>(r8)     // Catch: java.lang.Exception -> L88 java.lang.Throwable -> La7
            throw r4     // Catch: java.lang.Exception -> L88 java.lang.Throwable -> La7
        L82:
            java.io.IOException r4 = new java.io.IOException     // Catch: java.lang.Exception -> L88 java.lang.Throwable -> La7
            r4.<init>(r8)     // Catch: java.lang.Exception -> L88 java.lang.Throwable -> La7
            throw r4     // Catch: java.lang.Exception -> L88 java.lang.Throwable -> La7
        L88:
            r4 = move-exception
            goto L99
        L8a:
            r0 = move-exception
            r3 = r1
            goto La9
        L8d:
            r3 = move-exception
            r4 = r3
            r3 = r1
            r1 = r2
            goto L99
        L92:
            r0 = move-exception
            r3 = r2
            goto La9
        L95:
            r3 = move-exception
            r1 = r2
            r4 = r3
            r3 = r1
        L99:
            java.lang.String r5 = "Encountered exception while getting thumbnail"
            android.util.Log.d(r0, r5, r4)     // Catch: java.lang.Throwable -> La7
            androidx.exifinterface.media.ExifInterfaceUtils.c(r1)
            if (r3 == 0) goto La6
            androidx.exifinterface.media.ExifInterfaceUtils.b(r3)
        La6:
            return r2
        La7:
            r0 = move-exception
        La8:
            r2 = r1
        La9:
            androidx.exifinterface.media.ExifInterfaceUtils.c(r2)
            if (r3 == 0) goto Lb1
            androidx.exifinterface.media.ExifInterfaceUtils.b(r3)
        Lb1:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.exifinterface.media.ExifInterface.v():byte[]");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class SeekableByteOrderedDataInputStream extends ByteOrderedDataInputStream {
        SeekableByteOrderedDataInputStream(byte[] bArr) throws IOException {
            super(bArr);
            this.f6605f.mark(Api.BaseClientBuilder.API_PRIORITY_OTHER);
        }

        public void h(long j8) throws IOException {
            int i8 = this.f6607h;
            if (i8 > j8) {
                this.f6607h = 0;
                this.f6605f.reset();
            } else {
                j8 -= i8;
            }
            g((int) j8);
        }

        SeekableByteOrderedDataInputStream(InputStream inputStream) throws IOException {
            super(inputStream);
            if (inputStream.markSupported()) {
                this.f6605f.mark(Api.BaseClientBuilder.API_PRIORITY_OTHER);
                return;
            }
            throw new IllegalArgumentException("Cannot create SeekableByteOrderedDataInputStream with stream that does not support mark/reset");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class ExifTag {

        /* renamed from: a  reason: collision with root package name */
        public final int f6615a;

        /* renamed from: b  reason: collision with root package name */
        public final String f6616b;

        /* renamed from: c  reason: collision with root package name */
        public final int f6617c;

        /* renamed from: d  reason: collision with root package name */
        public final int f6618d;

        ExifTag(String str, int i8, int i9) {
            this.f6616b = str;
            this.f6615a = i8;
            this.f6617c = i9;
            this.f6618d = -1;
        }

        boolean a(int i8) {
            int i9;
            int i10 = this.f6617c;
            if (i10 == 7 || i8 == 7 || i10 == i8 || (i9 = this.f6618d) == i8) {
                return true;
            }
            if ((i10 == 4 || i9 == 4) && i8 == 3) {
                return true;
            }
            if ((i10 == 9 || i9 == 9) && i8 == 8) {
                return true;
            }
            if ((i10 == 12 || i9 == 12) && i8 == 11) {
                return true;
            }
            return false;
        }

        ExifTag(String str, int i8, int i9, int i10) {
            this.f6616b = str;
            this.f6615a = i8;
            this.f6617c = i9;
            this.f6618d = i10;
        }
    }

    public ExifInterface(@NonNull InputStream inputStream) throws IOException {
        this(inputStream, 0);
    }

    public ExifInterface(@NonNull InputStream inputStream, int i8) throws IOException {
        ExifTag[][] exifTagArr = f6561j0;
        this.f6584f = new HashMap[exifTagArr.length];
        this.f6585g = new HashSet(exifTagArr.length);
        this.f6586h = ByteOrder.BIG_ENDIAN;
        if (inputStream != null) {
            this.f6579a = null;
            if (i8 == 1) {
                BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream, f6568q0.length);
                if (!B(bufferedInputStream)) {
                    Log.w("ExifInterface", "Given data does not follow the structure of an Exif-only data.");
                    return;
                }
                this.f6583e = true;
                this.f6581c = null;
                this.f6580b = null;
                inputStream = bufferedInputStream;
            } else if (inputStream instanceof AssetManager.AssetInputStream) {
                this.f6581c = (AssetManager.AssetInputStream) inputStream;
                this.f6580b = null;
            } else {
                if (inputStream instanceof FileInputStream) {
                    FileInputStream fileInputStream = (FileInputStream) inputStream;
                    if (I(fileInputStream.getFD())) {
                        this.f6581c = null;
                        this.f6580b = fileInputStream.getFD();
                    }
                }
                this.f6581c = null;
                this.f6580b = null;
            }
            N(inputStream);
            return;
        }
        throw new NullPointerException("inputStream cannot be null");
    }
}
