package com.clevertap.android.sdk.gif;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentTransaction;
import com.clevertap.android.sdk.Logger;
import j$.util.Spliterator;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Iterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class GifDecoder {

    /* renamed from: y  reason: collision with root package name */
    private static final String f11215y = "GifDecoder";

    /* renamed from: a  reason: collision with root package name */
    private int[] f11216a;

    /* renamed from: b  reason: collision with root package name */
    private final BitmapProvider f11217b;

    /* renamed from: c  reason: collision with root package name */
    private byte[] f11218c;

    /* renamed from: d  reason: collision with root package name */
    private int f11219d;

    /* renamed from: e  reason: collision with root package name */
    private int f11220e;

    /* renamed from: f  reason: collision with root package name */
    private int f11221f;

    /* renamed from: g  reason: collision with root package name */
    private GifHeader f11222g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f11223h;

    /* renamed from: i  reason: collision with root package name */
    private int f11224i;

    /* renamed from: j  reason: collision with root package name */
    private byte[] f11225j;

    /* renamed from: k  reason: collision with root package name */
    private int[] f11226k;

    /* renamed from: l  reason: collision with root package name */
    private GifHeaderParser f11227l;

    /* renamed from: m  reason: collision with root package name */
    private final int[] f11228m;

    /* renamed from: n  reason: collision with root package name */
    private byte[] f11229n;

    /* renamed from: o  reason: collision with root package name */
    private short[] f11230o;

    /* renamed from: p  reason: collision with root package name */
    private Bitmap f11231p;

    /* renamed from: q  reason: collision with root package name */
    private ByteBuffer f11232q;

    /* renamed from: r  reason: collision with root package name */
    private int f11233r;

    /* renamed from: s  reason: collision with root package name */
    private boolean f11234s;

    /* renamed from: t  reason: collision with root package name */
    private int f11235t;

    /* renamed from: u  reason: collision with root package name */
    private byte[] f11236u;

    /* renamed from: v  reason: collision with root package name */
    private byte[] f11237v;

    /* renamed from: w  reason: collision with root package name */
    private int f11238w;

    /* renamed from: x  reason: collision with root package name */
    private int f11239x;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface BitmapProvider {
        byte[] a(int i8);

        @NonNull
        Bitmap b(int i8, int i9, Bitmap.Config config);

        int[] c(int i8);
    }

    GifDecoder(BitmapProvider bitmapProvider) {
        this.f11228m = new int[Spliterator.NONNULL];
        this.f11238w = 0;
        this.f11239x = 0;
        this.f11217b = bitmapProvider;
        this.f11222g = new GifHeader();
    }

    private int b(int i8, int i9, int i10) {
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        int i15 = 0;
        for (int i16 = i8; i16 < this.f11233r + i8; i16++) {
            byte[] bArr = this.f11225j;
            if (i16 >= bArr.length || i16 >= i9) {
                break;
            }
            int i17 = this.f11216a[bArr[i16] & 255];
            if (i17 != 0) {
                i11 += (i17 >> 24) & 255;
                i12 += (i17 >> 16) & 255;
                i13 += (i17 >> 8) & 255;
                i14 += i17 & 255;
                i15++;
            }
        }
        int i18 = i8 + i10;
        for (int i19 = i18; i19 < this.f11233r + i18; i19++) {
            byte[] bArr2 = this.f11225j;
            if (i19 >= bArr2.length || i19 >= i9) {
                break;
            }
            int i20 = this.f11216a[bArr2[i19] & 255];
            if (i20 != 0) {
                i11 += (i20 >> 24) & 255;
                i12 += (i20 >> 16) & 255;
                i13 += (i20 >> 8) & 255;
                i14 += i20 & 255;
                i15++;
            }
        }
        if (i15 == 0) {
            return 0;
        }
        return ((i11 / i15) << 24) | ((i12 / i15) << 16) | ((i13 / i15) << 8) | (i14 / i15);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void c(GifFrame gifFrame) {
        int i8;
        int i9;
        int i10;
        int i11;
        short s7;
        this.f11239x = 0;
        this.f11238w = 0;
        if (gifFrame != null) {
            this.f11232q.position(gifFrame.f11240a);
        }
        if (gifFrame == null) {
            GifHeader gifHeader = this.f11222g;
            i8 = gifHeader.f11263m;
            i9 = gifHeader.f11259i;
        } else {
            i8 = gifFrame.f11246g;
            i9 = gifFrame.f11247h;
        }
        int i12 = i8 * i9;
        byte[] bArr = this.f11225j;
        if (bArr == null || bArr.length < i12) {
            this.f11225j = this.f11217b.a(i12);
        }
        if (this.f11230o == null) {
            this.f11230o = new short[4096];
        }
        if (this.f11236u == null) {
            this.f11236u = new byte[4096];
        }
        if (this.f11229n == null) {
            this.f11229n = new byte[FragmentTransaction.TRANSIT_FRAGMENT_OPEN];
        }
        int p8 = p();
        int i13 = 1;
        int i14 = 1 << p8;
        int i15 = i14 + 1;
        int i16 = i14 + 2;
        int i17 = p8 + 1;
        int i18 = (1 << i17) - 1;
        for (int i19 = 0; i19 < i14; i19++) {
            this.f11230o[i19] = 0;
            this.f11236u[i19] = (byte) i19;
        }
        int i20 = -1;
        int i21 = i17;
        int i22 = i16;
        int i23 = i18;
        int i24 = 0;
        int i25 = 0;
        int i26 = 0;
        int i27 = 0;
        int i28 = 0;
        int i29 = 0;
        int i30 = -1;
        int i31 = 0;
        int i32 = 0;
        while (true) {
            if (i24 >= i12) {
                break;
            }
            if (i25 == 0) {
                i25 = o();
                if (i25 <= 0) {
                    this.f11235t = 3;
                    break;
                }
                i28 = 0;
            }
            i27 += (this.f11218c[i28] & 255) << i26;
            i26 += 8;
            i28 += i13;
            i25 += i20;
            int i33 = i22;
            int i34 = i30;
            int i35 = i21;
            int i36 = i32;
            while (i26 >= i35) {
                int i37 = i27 & i23;
                i27 >>= i35;
                i26 -= i35;
                if (i37 == i14) {
                    i35 = i17;
                    i33 = i16;
                    i23 = i18;
                    i34 = -1;
                } else {
                    if (i37 > i33) {
                        i10 = i17;
                        this.f11235t = 3;
                    } else {
                        i10 = i17;
                        if (i37 != i15) {
                            if (i34 == -1) {
                                this.f11229n[i31] = this.f11236u[i37];
                                i34 = i37;
                                i36 = i34;
                                i31++;
                                i17 = i10;
                            } else {
                                if (i37 >= i33) {
                                    i11 = i37;
                                    this.f11229n[i31] = (byte) i36;
                                    s7 = i34;
                                    i31++;
                                } else {
                                    i11 = i37;
                                    s7 = i11;
                                }
                                while (s7 >= i14) {
                                    this.f11229n[i31] = this.f11236u[s7];
                                    s7 = this.f11230o[s7];
                                    i31++;
                                    i14 = i14;
                                }
                                int i38 = i14;
                                byte[] bArr2 = this.f11236u;
                                int i39 = bArr2[s7] & 255;
                                int i40 = i31 + 1;
                                int i41 = i15;
                                byte b8 = (byte) i39;
                                this.f11229n[i31] = b8;
                                if (i33 < 4096) {
                                    this.f11230o[i33] = (short) i34;
                                    bArr2[i33] = b8;
                                    i33++;
                                    if ((i33 & i23) == 0 && i33 < 4096) {
                                        i35++;
                                        i23 += i33;
                                    }
                                }
                                i31 = i40;
                                while (i31 > 0) {
                                    i31--;
                                    this.f11225j[i29] = this.f11229n[i31];
                                    i24++;
                                    i29++;
                                }
                                i14 = i38;
                                i34 = i11;
                                i15 = i41;
                                i36 = i39;
                                i17 = i10;
                            }
                        }
                    }
                    i22 = i33;
                    i30 = i34;
                    i21 = i35;
                    i17 = i10;
                    i32 = i36;
                    break;
                }
            }
            i32 = i36;
            i22 = i33;
            i30 = i34;
            i21 = i35;
            i13 = 1;
            i20 = -1;
        }
        for (int i42 = i29; i42 < i12; i42++) {
            this.f11225j[i42] = 0;
        }
    }

    private void d(int[] iArr, GifFrame gifFrame, int i8) {
        int i9 = gifFrame.f11247h;
        int i10 = this.f11233r;
        int i11 = i9 / i10;
        int i12 = gifFrame.f11245f / i10;
        int i13 = gifFrame.f11246g / i10;
        int i14 = gifFrame.f11244e / i10;
        int i15 = this.f11220e;
        int i16 = (i12 * i15) + i14;
        int i17 = (i11 * i15) + i16;
        while (i16 < i17) {
            int i18 = i16 + i13;
            for (int i19 = i16; i19 < i18; i19++) {
                iArr[i19] = i8;
            }
            i16 += this.f11220e;
        }
    }

    private GifHeaderParser h() {
        if (this.f11227l == null) {
            this.f11227l = new GifHeaderParser();
        }
        return this.f11227l;
    }

    private Bitmap j() {
        Bitmap.Config config;
        if (this.f11223h) {
            config = Bitmap.Config.ARGB_8888;
        } else {
            config = Bitmap.Config.RGB_565;
        }
        Bitmap b8 = this.f11217b.b(this.f11220e, this.f11219d, config);
        s(b8);
        return b8;
    }

    private int o() {
        int p8 = p();
        if (p8 > 0) {
            try {
                if (this.f11218c == null) {
                    this.f11218c = this.f11217b.a(255);
                }
                int i8 = this.f11239x;
                int i9 = this.f11238w;
                int i10 = i8 - i9;
                if (i10 >= p8) {
                    System.arraycopy(this.f11237v, i9, this.f11218c, 0, p8);
                    this.f11238w += p8;
                } else if (this.f11232q.remaining() + i10 >= p8) {
                    System.arraycopy(this.f11237v, this.f11238w, this.f11218c, 0, i10);
                    this.f11238w = this.f11239x;
                    q();
                    int i11 = p8 - i10;
                    System.arraycopy(this.f11237v, 0, this.f11218c, i10, i11);
                    this.f11238w += i11;
                } else {
                    this.f11235t = 1;
                }
            } catch (Exception e8) {
                Logger.c(f11215y, "Error Reading Block", e8);
                this.f11235t = 1;
            }
        }
        return p8;
    }

    private int p() {
        try {
            q();
            byte[] bArr = this.f11237v;
            int i8 = this.f11238w;
            this.f11238w = i8 + 1;
            return bArr[i8] & 255;
        } catch (Exception unused) {
            this.f11235t = 1;
            return 0;
        }
    }

    private void q() {
        if (this.f11239x > this.f11238w) {
            return;
        }
        if (this.f11237v == null) {
            this.f11237v = this.f11217b.a(16384);
        }
        this.f11238w = 0;
        int min = Math.min(this.f11232q.remaining(), 16384);
        this.f11239x = min;
        this.f11232q.get(this.f11237v, 0, min);
    }

    @TargetApi(12)
    private static void s(Bitmap bitmap) {
        bitmap.setHasAlpha(true);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0029, code lost:
        if (r3.f11252b == r18.f11249j) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private android.graphics.Bitmap x(com.clevertap.android.sdk.gif.GifFrame r18, com.clevertap.android.sdk.gif.GifFrame r19) {
        /*
            Method dump skipped, instructions count: 307
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.clevertap.android.sdk.gif.GifDecoder.x(com.clevertap.android.sdk.gif.GifFrame, com.clevertap.android.sdk.gif.GifFrame):android.graphics.Bitmap");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a() {
        if (this.f11222g.f11254d <= 0) {
            return false;
        }
        if (this.f11221f == g() - 1) {
            this.f11224i++;
        }
        GifHeader gifHeader = this.f11222g;
        int i8 = gifHeader.f11260j;
        if (i8 != -1 && this.f11224i > i8) {
            return false;
        }
        this.f11221f = (this.f11221f + 1) % gifHeader.f11254d;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int e() {
        return this.f11221f;
    }

    int f(int i8) {
        if (i8 >= 0) {
            GifHeader gifHeader = this.f11222g;
            if (i8 < gifHeader.f11254d) {
                return gifHeader.f11255e.get(i8).f11241b;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int g() {
        return this.f11222g.f11254d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int i() {
        return this.f11222g.f11259i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int k() {
        int i8;
        if (this.f11222g.f11254d > 0 && (i8 = this.f11221f) >= 0) {
            return f(i8);
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized Bitmap l() {
        GifFrame gifFrame;
        if (this.f11222g.f11254d <= 0 || this.f11221f < 0) {
            Logger.b(f11215y, "unable to decode frame, frameCount=" + this.f11222g.f11254d + " framePointer=" + this.f11221f);
            this.f11235t = 1;
        }
        int i8 = this.f11235t;
        if (i8 != 1 && i8 != 2) {
            this.f11235t = 0;
            GifFrame gifFrame2 = this.f11222g.f11255e.get(this.f11221f);
            int i9 = this.f11221f - 1;
            if (i9 >= 0) {
                gifFrame = this.f11222g.f11255e.get(i9);
            } else {
                gifFrame = null;
            }
            int[] iArr = gifFrame2.f11248i;
            if (iArr == null) {
                iArr = this.f11222g.f11256f;
            }
            this.f11216a = iArr;
            if (iArr == null) {
                Logger.b(f11215y, "No Valid Color Table for frame #" + this.f11221f);
                this.f11235t = 1;
                return null;
            }
            if (gifFrame2.f11250k) {
                System.arraycopy(iArr, 0, this.f11228m, 0, iArr.length);
                int[] iArr2 = this.f11228m;
                this.f11216a = iArr2;
                iArr2[gifFrame2.f11249j] = 0;
            }
            return x(gifFrame2, gifFrame);
        }
        Logger.b(f11215y, "Unable to decode frame, status=" + this.f11235t);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int m() {
        return this.f11222g.f11263m;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized int n(byte[] bArr) {
        GifHeader b8 = h().p(bArr).b();
        this.f11222g = b8;
        if (bArr != null) {
            v(b8, bArr);
        }
        return this.f11235t;
    }

    void r() {
        this.f11224i = 0;
    }

    synchronized void t(GifHeader gifHeader, ByteBuffer byteBuffer) {
        u(gifHeader, byteBuffer, 1);
    }

    synchronized void u(GifHeader gifHeader, ByteBuffer byteBuffer, int i8) {
        if (i8 > 0) {
            int highestOneBit = Integer.highestOneBit(i8);
            this.f11235t = 0;
            this.f11222g = gifHeader;
            this.f11223h = false;
            this.f11221f = -1;
            r();
            ByteBuffer asReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
            this.f11232q = asReadOnlyBuffer;
            asReadOnlyBuffer.position(0);
            this.f11232q.order(ByteOrder.LITTLE_ENDIAN);
            this.f11234s = false;
            Iterator<GifFrame> it = gifHeader.f11255e.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (it.next().f11242c == 3) {
                    this.f11234s = true;
                    break;
                }
            }
            this.f11233r = highestOneBit;
            int i9 = gifHeader.f11263m;
            this.f11220e = i9 / highestOneBit;
            int i10 = gifHeader.f11259i;
            this.f11219d = i10 / highestOneBit;
            this.f11225j = this.f11217b.a(i9 * i10);
            this.f11226k = this.f11217b.c(this.f11220e * this.f11219d);
        } else {
            throw new IllegalArgumentException("Sample size must be >=0, not: " + i8);
        }
    }

    synchronized void v(GifHeader gifHeader, byte[] bArr) {
        t(gifHeader, ByteBuffer.wrap(bArr));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean w(int i8) {
        if (i8 >= -1 && i8 < g()) {
            this.f11221f = i8;
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public GifDecoder() {
        this(new SimpleBitmapProvider());
    }
}
