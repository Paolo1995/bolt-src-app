package com.clevertap.android.sdk.gif;

import com.clevertap.android.sdk.Logger;
import com.google.android.gms.common.api.Api;
import j$.util.Spliterator;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

/* loaded from: classes.dex */
class GifHeaderParser {

    /* renamed from: a  reason: collision with root package name */
    private final byte[] f11264a = new byte[Spliterator.NONNULL];

    /* renamed from: b  reason: collision with root package name */
    private int f11265b = 0;

    /* renamed from: c  reason: collision with root package name */
    private GifHeader f11266c;

    /* renamed from: d  reason: collision with root package name */
    private ByteBuffer f11267d;

    private boolean a() {
        if (this.f11266c.f11262l != 0) {
            return true;
        }
        return false;
    }

    private int c() {
        try {
            return this.f11267d.get() & 255;
        } catch (Exception unused) {
            this.f11266c.f11262l = 1;
            return 0;
        }
    }

    private void d() {
        boolean z7;
        this.f11266c.f11253c.f11244e = m();
        this.f11266c.f11253c.f11245f = m();
        this.f11266c.f11253c.f11246g = m();
        this.f11266c.f11253c.f11247h = m();
        int c8 = c();
        boolean z8 = false;
        if ((c8 & 128) != 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        int pow = (int) Math.pow(2.0d, (c8 & 7) + 1);
        GifFrame gifFrame = this.f11266c.f11253c;
        if ((c8 & 64) != 0) {
            z8 = true;
        }
        gifFrame.f11243d = z8;
        if (z7) {
            gifFrame.f11248i = f(pow);
        } else {
            gifFrame.f11248i = null;
        }
        this.f11266c.f11253c.f11240a = this.f11267d.position();
        r();
        if (a()) {
            return;
        }
        GifHeader gifHeader = this.f11266c;
        gifHeader.f11254d++;
        gifHeader.f11255e.add(gifHeader.f11253c);
    }

    private int e() {
        int c8 = c();
        this.f11265b = c8;
        int i8 = 0;
        if (c8 > 0) {
            while (true) {
                try {
                    int i9 = this.f11265b;
                    if (i8 >= i9) {
                        break;
                    }
                    int i10 = i9 - i8;
                    this.f11267d.get(this.f11264a, i8, i10);
                    i8 += i10;
                } catch (Exception unused) {
                    this.f11266c.f11262l = 1;
                }
            }
        }
        return i8;
    }

    private int[] f(int i8) {
        byte[] bArr = new byte[i8 * 3];
        int[] iArr = null;
        try {
            this.f11267d.get(bArr);
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
            Logger.c("GifHeaderParser", "Format Error Reading Color Table", e8);
            this.f11266c.f11262l = 1;
        }
        return iArr;
    }

    private void g() {
        h(Api.BaseClientBuilder.API_PRIORITY_OTHER);
    }

    private void h(int i8) {
        boolean z7 = false;
        while (!z7 && !a() && this.f11266c.f11254d <= i8) {
            int c8 = c();
            if (c8 != 33) {
                if (c8 != 44) {
                    if (c8 != 59) {
                        this.f11266c.f11262l = 1;
                    } else {
                        z7 = true;
                    }
                } else {
                    GifHeader gifHeader = this.f11266c;
                    if (gifHeader.f11253c == null) {
                        gifHeader.f11253c = new GifFrame();
                    }
                    d();
                }
            } else {
                int c9 = c();
                if (c9 != 1) {
                    if (c9 != 249) {
                        if (c9 != 254) {
                            if (c9 != 255) {
                                q();
                            } else {
                                e();
                                String str = "";
                                for (int i9 = 0; i9 < 11; i9++) {
                                    str = str + ((char) this.f11264a[i9]);
                                }
                                if (str.equals("NETSCAPE2.0")) {
                                    l();
                                } else {
                                    q();
                                }
                            }
                        } else {
                            q();
                        }
                    } else {
                        this.f11266c.f11253c = new GifFrame();
                        i();
                    }
                } else {
                    q();
                }
            }
        }
    }

    private void i() {
        c();
        int c8 = c();
        GifFrame gifFrame = this.f11266c.f11253c;
        int i8 = (c8 & 28) >> 2;
        gifFrame.f11242c = i8;
        boolean z7 = true;
        if (i8 == 0) {
            gifFrame.f11242c = 1;
        }
        if ((c8 & 1) == 0) {
            z7 = false;
        }
        gifFrame.f11250k = z7;
        int m8 = m();
        if (m8 < 2) {
            m8 = 10;
        }
        GifFrame gifFrame2 = this.f11266c.f11253c;
        gifFrame2.f11241b = m8 * 10;
        gifFrame2.f11249j = c();
        c();
    }

    private void j() {
        String str = "";
        for (int i8 = 0; i8 < 6; i8++) {
            str = str + ((char) c());
        }
        if (!str.startsWith("GIF")) {
            this.f11266c.f11262l = 1;
            return;
        }
        k();
        if (this.f11266c.f11257g && !a()) {
            GifHeader gifHeader = this.f11266c;
            gifHeader.f11256f = f(gifHeader.f11258h);
            GifHeader gifHeader2 = this.f11266c;
            gifHeader2.f11251a = gifHeader2.f11256f[gifHeader2.f11252b];
        }
    }

    private void k() {
        boolean z7;
        this.f11266c.f11263m = m();
        this.f11266c.f11259i = m();
        int c8 = c();
        GifHeader gifHeader = this.f11266c;
        if ((c8 & 128) != 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        gifHeader.f11257g = z7;
        gifHeader.f11258h = 2 << (c8 & 7);
        gifHeader.f11252b = c();
        this.f11266c.f11261k = c();
    }

    private void l() {
        do {
            e();
            byte[] bArr = this.f11264a;
            if (bArr[0] == 1) {
                GifHeader gifHeader = this.f11266c;
                int i8 = ((bArr[2] & 255) << 8) | (bArr[1] & 255);
                gifHeader.f11260j = i8;
                if (i8 == 0) {
                    gifHeader.f11260j = -1;
                }
            }
            if (this.f11265b <= 0) {
                return;
            }
        } while (!a());
    }

    private int m() {
        return this.f11267d.getShort();
    }

    private void n() {
        this.f11267d = null;
        Arrays.fill(this.f11264a, (byte) 0);
        this.f11266c = new GifHeader();
        this.f11265b = 0;
    }

    private void q() {
        int c8;
        do {
            try {
                c8 = c();
                ByteBuffer byteBuffer = this.f11267d;
                byteBuffer.position(byteBuffer.position() + c8);
            } catch (IllegalArgumentException unused) {
                return;
            }
        } while (c8 > 0);
    }

    private void r() {
        c();
        q();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public GifHeader b() {
        if (this.f11267d != null) {
            if (a()) {
                return this.f11266c;
            }
            j();
            if (!a()) {
                g();
                GifHeader gifHeader = this.f11266c;
                if (gifHeader.f11254d < 0) {
                    gifHeader.f11262l = 1;
                }
            }
            return this.f11266c;
        }
        throw new IllegalStateException("You must call setData() before parseHeader()");
    }

    public GifHeaderParser o(ByteBuffer byteBuffer) {
        n();
        ByteBuffer asReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
        this.f11267d = asReadOnlyBuffer;
        asReadOnlyBuffer.position(0);
        this.f11267d.order(ByteOrder.LITTLE_ENDIAN);
        return this;
    }

    public GifHeaderParser p(byte[] bArr) {
        if (bArr != null) {
            o(ByteBuffer.wrap(bArr));
        } else {
            this.f11267d = null;
            this.f11266c.f11262l = 2;
        }
        return this;
    }
}
