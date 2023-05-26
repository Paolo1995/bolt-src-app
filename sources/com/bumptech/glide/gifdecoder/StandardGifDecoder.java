package com.bumptech.glide.gifdecoder;

import android.graphics.Bitmap;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentTransaction;
import com.bumptech.glide.gifdecoder.GifDecoder;
import j$.util.Spliterator;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.Iterator;

/* loaded from: classes.dex */
public class StandardGifDecoder implements GifDecoder {

    /* renamed from: u  reason: collision with root package name */
    private static final String f9878u = "StandardGifDecoder";

    /* renamed from: a  reason: collision with root package name */
    private int[] f9879a;

    /* renamed from: b  reason: collision with root package name */
    private final int[] f9880b;

    /* renamed from: c  reason: collision with root package name */
    private final GifDecoder.BitmapProvider f9881c;

    /* renamed from: d  reason: collision with root package name */
    private ByteBuffer f9882d;

    /* renamed from: e  reason: collision with root package name */
    private byte[] f9883e;

    /* renamed from: f  reason: collision with root package name */
    private short[] f9884f;

    /* renamed from: g  reason: collision with root package name */
    private byte[] f9885g;

    /* renamed from: h  reason: collision with root package name */
    private byte[] f9886h;

    /* renamed from: i  reason: collision with root package name */
    private byte[] f9887i;

    /* renamed from: j  reason: collision with root package name */
    private int[] f9888j;

    /* renamed from: k  reason: collision with root package name */
    private int f9889k;

    /* renamed from: l  reason: collision with root package name */
    private GifHeader f9890l;

    /* renamed from: m  reason: collision with root package name */
    private Bitmap f9891m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f9892n;

    /* renamed from: o  reason: collision with root package name */
    private int f9893o;

    /* renamed from: p  reason: collision with root package name */
    private int f9894p;

    /* renamed from: q  reason: collision with root package name */
    private int f9895q;

    /* renamed from: r  reason: collision with root package name */
    private int f9896r;

    /* renamed from: s  reason: collision with root package name */
    private Boolean f9897s;
    @NonNull

    /* renamed from: t  reason: collision with root package name */
    private Bitmap.Config f9898t;

    public StandardGifDecoder(@NonNull GifDecoder.BitmapProvider bitmapProvider, GifHeader gifHeader, ByteBuffer byteBuffer, int i8) {
        this(bitmapProvider);
        p(gifHeader, byteBuffer, i8);
    }

    private int h(int i8, int i9, int i10) {
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        int i15 = 0;
        for (int i16 = i8; i16 < this.f9894p + i8; i16++) {
            byte[] bArr = this.f9887i;
            if (i16 >= bArr.length || i16 >= i9) {
                break;
            }
            int i17 = this.f9879a[bArr[i16] & 255];
            if (i17 != 0) {
                i11 += (i17 >> 24) & 255;
                i12 += (i17 >> 16) & 255;
                i13 += (i17 >> 8) & 255;
                i14 += i17 & 255;
                i15++;
            }
        }
        int i18 = i8 + i10;
        for (int i19 = i18; i19 < this.f9894p + i18; i19++) {
            byte[] bArr2 = this.f9887i;
            if (i19 >= bArr2.length || i19 >= i9) {
                break;
            }
            int i20 = this.f9879a[bArr2[i19] & 255];
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

    private void i(GifFrame gifFrame) {
        boolean z7;
        boolean booleanValue;
        int i8;
        int i9;
        boolean z8;
        int i10;
        int i11;
        int i12;
        int[] iArr = this.f9888j;
        int i13 = gifFrame.f9853d;
        int i14 = this.f9894p;
        int i15 = i13 / i14;
        int i16 = gifFrame.f9851b / i14;
        int i17 = gifFrame.f9852c / i14;
        int i18 = gifFrame.f9850a / i14;
        if (this.f9889k == 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        int i19 = this.f9896r;
        int i20 = this.f9895q;
        byte[] bArr = this.f9887i;
        int[] iArr2 = this.f9879a;
        Boolean bool = this.f9897s;
        int i21 = 8;
        int i22 = 0;
        int i23 = 0;
        int i24 = 1;
        while (i22 < i15) {
            Boolean bool2 = bool;
            if (gifFrame.f9854e) {
                if (i23 >= i15) {
                    i8 = i15;
                    int i25 = i24 + 1;
                    if (i25 != 2) {
                        if (i25 != 3) {
                            if (i25 != 4) {
                                i24 = i25;
                            } else {
                                i24 = i25;
                                i23 = 1;
                                i21 = 2;
                            }
                        } else {
                            i24 = i25;
                            i23 = 2;
                            i21 = 4;
                        }
                    } else {
                        i24 = i25;
                        i23 = 4;
                    }
                } else {
                    i8 = i15;
                }
                i9 = i23 + i21;
            } else {
                i8 = i15;
                i9 = i23;
                i23 = i22;
            }
            int i26 = i23 + i16;
            if (i14 == 1) {
                z8 = true;
            } else {
                z8 = false;
            }
            if (i26 < i20) {
                int i27 = i26 * i19;
                int i28 = i27 + i18;
                int i29 = i28 + i17;
                int i30 = i27 + i19;
                if (i30 < i29) {
                    i29 = i30;
                }
                i10 = i9;
                int i31 = i22 * i14 * gifFrame.f9852c;
                if (z8) {
                    int i32 = i28;
                    while (i32 < i29) {
                        int i33 = i16;
                        int i34 = iArr2[bArr[i31] & 255];
                        if (i34 != 0) {
                            iArr[i32] = i34;
                        } else if (z7 && bool2 == null) {
                            bool2 = Boolean.TRUE;
                        }
                        i31 += i14;
                        i32++;
                        i16 = i33;
                    }
                } else {
                    i12 = i16;
                    int i35 = ((i29 - i28) * i14) + i31;
                    int i36 = i28;
                    while (true) {
                        i11 = i17;
                        if (i36 < i29) {
                            int h8 = h(i31, i35, gifFrame.f9852c);
                            if (h8 != 0) {
                                iArr[i36] = h8;
                            } else if (z7 && bool2 == null) {
                                bool2 = Boolean.TRUE;
                            }
                            i31 += i14;
                            i36++;
                            i17 = i11;
                        }
                    }
                    bool = bool2;
                    i22++;
                    i16 = i12;
                    i17 = i11;
                    i15 = i8;
                    i23 = i10;
                }
            } else {
                i10 = i9;
            }
            i12 = i16;
            i11 = i17;
            bool = bool2;
            i22++;
            i16 = i12;
            i17 = i11;
            i15 = i8;
            i23 = i10;
        }
        Boolean bool3 = bool;
        if (this.f9897s == null) {
            if (bool3 == null) {
                booleanValue = false;
            } else {
                booleanValue = bool3.booleanValue();
            }
            this.f9897s = Boolean.valueOf(booleanValue);
        }
    }

    private void j(GifFrame gifFrame) {
        boolean z7;
        boolean z8;
        GifFrame gifFrame2 = gifFrame;
        int[] iArr = this.f9888j;
        int i8 = gifFrame2.f9853d;
        int i9 = gifFrame2.f9851b;
        int i10 = gifFrame2.f9852c;
        int i11 = gifFrame2.f9850a;
        if (this.f9889k == 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        int i12 = this.f9896r;
        byte[] bArr = this.f9887i;
        int[] iArr2 = this.f9879a;
        int i13 = 0;
        byte b8 = -1;
        while (i13 < i8) {
            int i14 = (i13 + i9) * i12;
            int i15 = i14 + i11;
            int i16 = i15 + i10;
            int i17 = i14 + i12;
            if (i17 < i16) {
                i16 = i17;
            }
            int i18 = gifFrame2.f9852c * i13;
            int i19 = i15;
            while (i19 < i16) {
                byte b9 = bArr[i18];
                int i20 = i8;
                int i21 = b9 & 255;
                if (i21 != b8) {
                    int i22 = iArr2[i21];
                    if (i22 != 0) {
                        iArr[i19] = i22;
                    } else {
                        b8 = b9;
                    }
                }
                i18++;
                i19++;
                i8 = i20;
            }
            i13++;
            gifFrame2 = gifFrame;
        }
        Boolean bool = this.f9897s;
        if ((bool != null && bool.booleanValue()) || (this.f9897s == null && z7 && b8 != -1)) {
            z8 = true;
        } else {
            z8 = false;
        }
        this.f9897s = Boolean.valueOf(z8);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void k(GifFrame gifFrame) {
        int i8;
        int i9;
        short s7;
        StandardGifDecoder standardGifDecoder = this;
        if (gifFrame != null) {
            standardGifDecoder.f9882d.position(gifFrame.f9859j);
        }
        if (gifFrame == null) {
            GifHeader gifHeader = standardGifDecoder.f9890l;
            i8 = gifHeader.f9866f;
            i9 = gifHeader.f9867g;
        } else {
            i8 = gifFrame.f9852c;
            i9 = gifFrame.f9853d;
        }
        int i10 = i8 * i9;
        byte[] bArr = standardGifDecoder.f9887i;
        if (bArr == null || bArr.length < i10) {
            standardGifDecoder.f9887i = standardGifDecoder.f9881c.a(i10);
        }
        byte[] bArr2 = standardGifDecoder.f9887i;
        if (standardGifDecoder.f9884f == null) {
            standardGifDecoder.f9884f = new short[4096];
        }
        short[] sArr = standardGifDecoder.f9884f;
        if (standardGifDecoder.f9885g == null) {
            standardGifDecoder.f9885g = new byte[4096];
        }
        byte[] bArr3 = standardGifDecoder.f9885g;
        if (standardGifDecoder.f9886h == null) {
            standardGifDecoder.f9886h = new byte[FragmentTransaction.TRANSIT_FRAGMENT_OPEN];
        }
        byte[] bArr4 = standardGifDecoder.f9886h;
        int o8 = o();
        int i11 = 1 << o8;
        int i12 = i11 + 1;
        int i13 = i11 + 2;
        int i14 = o8 + 1;
        int i15 = (1 << i14) - 1;
        int i16 = 0;
        for (int i17 = 0; i17 < i11; i17++) {
            sArr[i17] = 0;
            bArr3[i17] = (byte) i17;
        }
        byte[] bArr5 = standardGifDecoder.f9883e;
        int i18 = i14;
        int i19 = i13;
        int i20 = i15;
        int i21 = 0;
        int i22 = 0;
        int i23 = 0;
        int i24 = 0;
        int i25 = 0;
        int i26 = -1;
        int i27 = 0;
        int i28 = 0;
        while (true) {
            if (i16 >= i10) {
                break;
            }
            if (i21 == 0) {
                i21 = n();
                if (i21 <= 0) {
                    standardGifDecoder.f9893o = 3;
                    break;
                }
                i22 = 0;
            }
            i24 += (bArr5[i22] & 255) << i23;
            i22++;
            i21--;
            int i29 = i23 + 8;
            int i30 = i19;
            int i31 = i26;
            int i32 = i18;
            int i33 = i14;
            int i34 = i28;
            while (true) {
                if (i29 >= i32) {
                    int i35 = i13;
                    int i36 = i24 & i20;
                    i24 >>= i32;
                    i29 -= i32;
                    if (i36 == i11) {
                        i20 = i15;
                        i32 = i33;
                        i30 = i35;
                        i13 = i30;
                        i31 = -1;
                    } else if (i36 == i12) {
                        i23 = i29;
                        i28 = i34;
                        i19 = i30;
                        i14 = i33;
                        i13 = i35;
                        i26 = i31;
                        i18 = i32;
                        break;
                    } else if (i31 == -1) {
                        bArr2[i25] = bArr3[i36];
                        i25++;
                        i16++;
                        i31 = i36;
                        i34 = i31;
                        i13 = i35;
                        i29 = i29;
                    } else {
                        if (i36 >= i30) {
                            bArr4[i27] = (byte) i34;
                            i27++;
                            s7 = i31;
                        } else {
                            s7 = i36;
                        }
                        while (s7 >= i11) {
                            bArr4[i27] = bArr3[s7];
                            i27++;
                            s7 = sArr[s7];
                        }
                        i34 = bArr3[s7] & 255;
                        byte b8 = (byte) i34;
                        bArr2[i25] = b8;
                        while (true) {
                            i25++;
                            i16++;
                            if (i27 <= 0) {
                                break;
                            }
                            i27--;
                            bArr2[i25] = bArr4[i27];
                        }
                        byte[] bArr6 = bArr4;
                        if (i30 < 4096) {
                            sArr[i30] = (short) i31;
                            bArr3[i30] = b8;
                            i30++;
                            if ((i30 & i20) == 0 && i30 < 4096) {
                                i32++;
                                i20 += i30;
                            }
                        }
                        i31 = i36;
                        i13 = i35;
                        i29 = i29;
                        bArr4 = bArr6;
                    }
                } else {
                    i19 = i30;
                    i18 = i32;
                    i23 = i29;
                    i28 = i34;
                    i14 = i33;
                    i26 = i31;
                    break;
                }
            }
            standardGifDecoder = this;
        }
        Arrays.fill(bArr2, i25, i10, (byte) 0);
    }

    private Bitmap m() {
        Bitmap.Config config;
        Boolean bool = this.f9897s;
        if (bool != null && !bool.booleanValue()) {
            config = this.f9898t;
        } else {
            config = Bitmap.Config.ARGB_8888;
        }
        Bitmap b8 = this.f9881c.b(this.f9896r, this.f9895q, config);
        b8.setHasAlpha(true);
        return b8;
    }

    private int n() {
        int o8 = o();
        if (o8 <= 0) {
            return o8;
        }
        ByteBuffer byteBuffer = this.f9882d;
        byteBuffer.get(this.f9883e, 0, Math.min(o8, byteBuffer.remaining()));
        return o8;
    }

    private int o() {
        return this.f9882d.get() & 255;
    }

    private Bitmap q(GifFrame gifFrame, GifFrame gifFrame2) {
        int i8;
        int i9;
        Bitmap bitmap;
        int[] iArr = this.f9888j;
        int i10 = 0;
        if (gifFrame2 == null) {
            Bitmap bitmap2 = this.f9891m;
            if (bitmap2 != null) {
                this.f9881c.d(bitmap2);
            }
            this.f9891m = null;
            Arrays.fill(iArr, 0);
        }
        if (gifFrame2 != null && gifFrame2.f9856g == 3 && this.f9891m == null) {
            Arrays.fill(iArr, 0);
        }
        if (gifFrame2 != null && (i9 = gifFrame2.f9856g) > 0) {
            if (i9 == 2) {
                if (!gifFrame.f9855f) {
                    GifHeader gifHeader = this.f9890l;
                    int i11 = gifHeader.f9872l;
                    if (gifFrame.f9860k == null || gifHeader.f9870j != gifFrame.f9857h) {
                        i10 = i11;
                    }
                }
                int i12 = gifFrame2.f9853d;
                int i13 = this.f9894p;
                int i14 = i12 / i13;
                int i15 = gifFrame2.f9851b / i13;
                int i16 = gifFrame2.f9852c / i13;
                int i17 = gifFrame2.f9850a / i13;
                int i18 = this.f9896r;
                int i19 = (i15 * i18) + i17;
                int i20 = (i14 * i18) + i19;
                while (i19 < i20) {
                    int i21 = i19 + i16;
                    for (int i22 = i19; i22 < i21; i22++) {
                        iArr[i22] = i10;
                    }
                    i19 += this.f9896r;
                }
            } else if (i9 == 3 && (bitmap = this.f9891m) != null) {
                int i23 = this.f9896r;
                bitmap.getPixels(iArr, 0, i23, 0, 0, i23, this.f9895q);
            }
        }
        k(gifFrame);
        if (!gifFrame.f9854e && this.f9894p == 1) {
            j(gifFrame);
        } else {
            i(gifFrame);
        }
        if (this.f9892n && ((i8 = gifFrame.f9856g) == 0 || i8 == 1)) {
            if (this.f9891m == null) {
                this.f9891m = m();
            }
            Bitmap bitmap3 = this.f9891m;
            int i24 = this.f9896r;
            bitmap3.setPixels(iArr, 0, i24, 0, 0, i24, this.f9895q);
        }
        Bitmap m8 = m();
        int i25 = this.f9896r;
        m8.setPixels(iArr, 0, i25, 0, 0, i25, this.f9895q);
        return m8;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public void a() {
        this.f9889k = (this.f9889k + 1) % this.f9890l.f9863c;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public int b() {
        return this.f9890l.f9863c;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public void c(@NonNull Bitmap.Config config) {
        if (config != Bitmap.Config.ARGB_8888 && config != Bitmap.Config.RGB_565) {
            throw new IllegalArgumentException("Unsupported format: " + config + ", must be one of " + Bitmap.Config.ARGB_8888 + " or " + Bitmap.Config.RGB_565);
        }
        this.f9898t = config;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public void clear() {
        this.f9890l = null;
        byte[] bArr = this.f9887i;
        if (bArr != null) {
            this.f9881c.e(bArr);
        }
        int[] iArr = this.f9888j;
        if (iArr != null) {
            this.f9881c.f(iArr);
        }
        Bitmap bitmap = this.f9891m;
        if (bitmap != null) {
            this.f9881c.d(bitmap);
        }
        this.f9891m = null;
        this.f9882d = null;
        this.f9897s = null;
        byte[] bArr2 = this.f9883e;
        if (bArr2 != null) {
            this.f9881c.e(bArr2);
        }
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public int d() {
        int i8;
        if (this.f9890l.f9863c > 0 && (i8 = this.f9889k) >= 0) {
            return l(i8);
        }
        return 0;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public void e() {
        this.f9889k = -1;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public int f() {
        return this.f9889k;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public int g() {
        return this.f9882d.limit() + this.f9887i.length + (this.f9888j.length * 4);
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    @NonNull
    public ByteBuffer getData() {
        return this.f9882d;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public synchronized Bitmap getNextFrame() {
        GifFrame gifFrame;
        if (this.f9890l.f9863c <= 0 || this.f9889k < 0) {
            String str = f9878u;
            if (Log.isLoggable(str, 3)) {
                Log.d(str, "Unable to decode frame, frameCount=" + this.f9890l.f9863c + ", framePointer=" + this.f9889k);
            }
            this.f9893o = 1;
        }
        int i8 = this.f9893o;
        if (i8 != 1 && i8 != 2) {
            this.f9893o = 0;
            if (this.f9883e == null) {
                this.f9883e = this.f9881c.a(255);
            }
            GifFrame gifFrame2 = this.f9890l.f9865e.get(this.f9889k);
            int i9 = this.f9889k - 1;
            if (i9 >= 0) {
                gifFrame = this.f9890l.f9865e.get(i9);
            } else {
                gifFrame = null;
            }
            int[] iArr = gifFrame2.f9860k;
            if (iArr == null) {
                iArr = this.f9890l.f9861a;
            }
            this.f9879a = iArr;
            if (iArr == null) {
                String str2 = f9878u;
                if (Log.isLoggable(str2, 3)) {
                    Log.d(str2, "No valid color table found for frame #" + this.f9889k);
                }
                this.f9893o = 1;
                return null;
            }
            if (gifFrame2.f9855f) {
                System.arraycopy(iArr, 0, this.f9880b, 0, iArr.length);
                int[] iArr2 = this.f9880b;
                this.f9879a = iArr2;
                iArr2[gifFrame2.f9857h] = 0;
                if (gifFrame2.f9856g == 2 && this.f9889k == 0) {
                    this.f9897s = Boolean.TRUE;
                }
            }
            return q(gifFrame2, gifFrame);
        }
        String str3 = f9878u;
        if (Log.isLoggable(str3, 3)) {
            Log.d(str3, "Unable to decode frame, status=" + this.f9893o);
        }
        return null;
    }

    public int l(int i8) {
        if (i8 >= 0) {
            GifHeader gifHeader = this.f9890l;
            if (i8 < gifHeader.f9863c) {
                return gifHeader.f9865e.get(i8).f9858i;
            }
        }
        return -1;
    }

    public synchronized void p(@NonNull GifHeader gifHeader, @NonNull ByteBuffer byteBuffer, int i8) {
        if (i8 > 0) {
            int highestOneBit = Integer.highestOneBit(i8);
            this.f9893o = 0;
            this.f9890l = gifHeader;
            this.f9889k = -1;
            ByteBuffer asReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
            this.f9882d = asReadOnlyBuffer;
            asReadOnlyBuffer.position(0);
            this.f9882d.order(ByteOrder.LITTLE_ENDIAN);
            this.f9892n = false;
            Iterator<GifFrame> it = gifHeader.f9865e.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (it.next().f9856g == 3) {
                    this.f9892n = true;
                    break;
                }
            }
            this.f9894p = highestOneBit;
            int i9 = gifHeader.f9866f;
            this.f9896r = i9 / highestOneBit;
            int i10 = gifHeader.f9867g;
            this.f9895q = i10 / highestOneBit;
            this.f9887i = this.f9881c.a(i9 * i10);
            this.f9888j = this.f9881c.c(this.f9896r * this.f9895q);
        } else {
            throw new IllegalArgumentException("Sample size must be >=0, not: " + i8);
        }
    }

    public StandardGifDecoder(@NonNull GifDecoder.BitmapProvider bitmapProvider) {
        this.f9880b = new int[Spliterator.NONNULL];
        this.f9898t = Bitmap.Config.ARGB_8888;
        this.f9881c = bitmapProvider;
        this.f9890l = new GifHeader();
    }
}
