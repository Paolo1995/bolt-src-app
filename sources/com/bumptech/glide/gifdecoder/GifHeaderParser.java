package com.bumptech.glide.gifdecoder;

import android.util.Log;
import androidx.annotation.NonNull;
import com.google.android.gms.common.api.Api;
import j$.util.Spliterator;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

/* loaded from: classes.dex */
public class GifHeaderParser {

    /* renamed from: b  reason: collision with root package name */
    private ByteBuffer f9875b;

    /* renamed from: c  reason: collision with root package name */
    private GifHeader f9876c;

    /* renamed from: a  reason: collision with root package name */
    private final byte[] f9874a = new byte[Spliterator.NONNULL];

    /* renamed from: d  reason: collision with root package name */
    private int f9877d = 0;

    private boolean b() {
        if (this.f9876c.f9862b != 0) {
            return true;
        }
        return false;
    }

    private int d() {
        try {
            return this.f9875b.get() & 255;
        } catch (Exception unused) {
            this.f9876c.f9862b = 1;
            return 0;
        }
    }

    private void e() {
        boolean z7;
        this.f9876c.f9864d.f9850a = n();
        this.f9876c.f9864d.f9851b = n();
        this.f9876c.f9864d.f9852c = n();
        this.f9876c.f9864d.f9853d = n();
        int d8 = d();
        boolean z8 = false;
        if ((d8 & 128) != 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        int pow = (int) Math.pow(2.0d, (d8 & 7) + 1);
        GifFrame gifFrame = this.f9876c.f9864d;
        if ((d8 & 64) != 0) {
            z8 = true;
        }
        gifFrame.f9854e = z8;
        if (z7) {
            gifFrame.f9860k = g(pow);
        } else {
            gifFrame.f9860k = null;
        }
        this.f9876c.f9864d.f9859j = this.f9875b.position();
        r();
        if (b()) {
            return;
        }
        GifHeader gifHeader = this.f9876c;
        gifHeader.f9863c++;
        gifHeader.f9865e.add(gifHeader.f9864d);
    }

    private void f() {
        int d8 = d();
        this.f9877d = d8;
        if (d8 > 0) {
            int i8 = 0;
            int i9 = 0;
            while (true) {
                try {
                    i9 = this.f9877d;
                    if (i8 < i9) {
                        i9 -= i8;
                        this.f9875b.get(this.f9874a, i8, i9);
                        i8 += i9;
                    } else {
                        return;
                    }
                } catch (Exception e8) {
                    if (Log.isLoggable("GifHeaderParser", 3)) {
                        Log.d("GifHeaderParser", "Error Reading Block n: " + i8 + " count: " + i9 + " blockSize: " + this.f9877d, e8);
                    }
                    this.f9876c.f9862b = 1;
                    return;
                }
            }
        }
    }

    private int[] g(int i8) {
        byte[] bArr = new byte[i8 * 3];
        int[] iArr = null;
        try {
            this.f9875b.get(bArr);
            iArr = new int[Spliterator.NONNULL];
            int i9 = 0;
            int i10 = 0;
            while (i9 < i8) {
                int i11 = i10 + 1;
                int i12 = i11 + 1;
                int i13 = i12 + 1;
                int i14 = i9 + 1;
                iArr[i9] = ((bArr[i10] & 255) << 16) | (-16777216) | ((bArr[i11] & 255) << 8) | (bArr[i12] & 255);
                i10 = i13;
                i9 = i14;
            }
        } catch (BufferUnderflowException e8) {
            if (Log.isLoggable("GifHeaderParser", 3)) {
                Log.d("GifHeaderParser", "Format Error Reading Color Table", e8);
            }
            this.f9876c.f9862b = 1;
        }
        return iArr;
    }

    private void h() {
        i(Api.BaseClientBuilder.API_PRIORITY_OTHER);
    }

    private void i(int i8) {
        boolean z7 = false;
        while (!z7 && !b() && this.f9876c.f9863c <= i8) {
            int d8 = d();
            if (d8 != 33) {
                if (d8 != 44) {
                    if (d8 != 59) {
                        this.f9876c.f9862b = 1;
                    } else {
                        z7 = true;
                    }
                } else {
                    GifHeader gifHeader = this.f9876c;
                    if (gifHeader.f9864d == null) {
                        gifHeader.f9864d = new GifFrame();
                    }
                    e();
                }
            } else {
                int d9 = d();
                if (d9 != 1) {
                    if (d9 != 249) {
                        if (d9 != 254) {
                            if (d9 != 255) {
                                q();
                            } else {
                                f();
                                StringBuilder sb = new StringBuilder();
                                for (int i9 = 0; i9 < 11; i9++) {
                                    sb.append((char) this.f9874a[i9]);
                                }
                                if (sb.toString().equals("NETSCAPE2.0")) {
                                    m();
                                } else {
                                    q();
                                }
                            }
                        } else {
                            q();
                        }
                    } else {
                        this.f9876c.f9864d = new GifFrame();
                        j();
                    }
                } else {
                    q();
                }
            }
        }
    }

    private void j() {
        d();
        int d8 = d();
        GifFrame gifFrame = this.f9876c.f9864d;
        int i8 = (d8 & 28) >> 2;
        gifFrame.f9856g = i8;
        boolean z7 = true;
        if (i8 == 0) {
            gifFrame.f9856g = 1;
        }
        if ((d8 & 1) == 0) {
            z7 = false;
        }
        gifFrame.f9855f = z7;
        int n8 = n();
        if (n8 < 2) {
            n8 = 10;
        }
        GifFrame gifFrame2 = this.f9876c.f9864d;
        gifFrame2.f9858i = n8 * 10;
        gifFrame2.f9857h = d();
        d();
    }

    private void k() {
        StringBuilder sb = new StringBuilder();
        for (int i8 = 0; i8 < 6; i8++) {
            sb.append((char) d());
        }
        if (!sb.toString().startsWith("GIF")) {
            this.f9876c.f9862b = 1;
            return;
        }
        l();
        if (this.f9876c.f9868h && !b()) {
            GifHeader gifHeader = this.f9876c;
            gifHeader.f9861a = g(gifHeader.f9869i);
            GifHeader gifHeader2 = this.f9876c;
            gifHeader2.f9872l = gifHeader2.f9861a[gifHeader2.f9870j];
        }
    }

    private void l() {
        boolean z7;
        this.f9876c.f9866f = n();
        this.f9876c.f9867g = n();
        int d8 = d();
        GifHeader gifHeader = this.f9876c;
        if ((d8 & 128) != 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        gifHeader.f9868h = z7;
        gifHeader.f9869i = (int) Math.pow(2.0d, (d8 & 7) + 1);
        this.f9876c.f9870j = d();
        this.f9876c.f9871k = d();
    }

    private void m() {
        do {
            f();
            byte[] bArr = this.f9874a;
            if (bArr[0] == 1) {
                this.f9876c.f9873m = ((bArr[2] & 255) << 8) | (bArr[1] & 255);
            }
            if (this.f9877d <= 0) {
                return;
            }
        } while (!b());
    }

    private int n() {
        return this.f9875b.getShort();
    }

    private void o() {
        this.f9875b = null;
        Arrays.fill(this.f9874a, (byte) 0);
        this.f9876c = new GifHeader();
        this.f9877d = 0;
    }

    private void q() {
        int d8;
        do {
            d8 = d();
            this.f9875b.position(Math.min(this.f9875b.position() + d8, this.f9875b.limit()));
        } while (d8 > 0);
    }

    private void r() {
        d();
        q();
    }

    public void a() {
        this.f9875b = null;
        this.f9876c = null;
    }

    @NonNull
    public GifHeader c() {
        if (this.f9875b != null) {
            if (b()) {
                return this.f9876c;
            }
            k();
            if (!b()) {
                h();
                GifHeader gifHeader = this.f9876c;
                if (gifHeader.f9863c < 0) {
                    gifHeader.f9862b = 1;
                }
            }
            return this.f9876c;
        }
        throw new IllegalStateException("You must call setData() before parseHeader()");
    }

    public GifHeaderParser p(@NonNull ByteBuffer byteBuffer) {
        o();
        ByteBuffer asReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
        this.f9875b = asReadOnlyBuffer;
        asReadOnlyBuffer.position(0);
        this.f9875b.order(ByteOrder.LITTLE_ENDIAN);
        return this;
    }
}
