package com.clevertap.android.sdk.gif;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;

/* loaded from: classes.dex */
public class GifImageView extends AppCompatImageView implements Runnable {

    /* renamed from: f  reason: collision with root package name */
    private boolean f11268f;

    /* renamed from: g  reason: collision with root package name */
    private OnAnimationStart f11269g;

    /* renamed from: h  reason: collision with root package name */
    private OnAnimationStop f11270h;

    /* renamed from: i  reason: collision with root package name */
    private Thread f11271i;

    /* renamed from: j  reason: collision with root package name */
    private OnFrameAvailable f11272j;

    /* renamed from: k  reason: collision with root package name */
    private long f11273k;

    /* renamed from: l  reason: collision with root package name */
    private GifDecoder f11274l;

    /* renamed from: m  reason: collision with root package name */
    private final Handler f11275m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f11276n;

    /* renamed from: o  reason: collision with root package name */
    private boolean f11277o;

    /* renamed from: p  reason: collision with root package name */
    private Bitmap f11278p;

    /* renamed from: q  reason: collision with root package name */
    private final Runnable f11279q;

    /* renamed from: r  reason: collision with root package name */
    private final Runnable f11280r;

    /* loaded from: classes.dex */
    public interface OnAnimationStart {
        void a();
    }

    /* loaded from: classes.dex */
    public interface OnAnimationStop {
        void a();
    }

    /* loaded from: classes.dex */
    public interface OnFrameAvailable {
        Bitmap a(Bitmap bitmap);
    }

    public GifImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f11269g = null;
        this.f11270h = null;
        this.f11272j = null;
        this.f11273k = -1L;
        this.f11275m = new Handler(Looper.getMainLooper());
        this.f11279q = new Runnable() { // from class: com.clevertap.android.sdk.gif.GifImageView.1
            @Override // java.lang.Runnable
            public void run() {
                GifImageView.this.f11278p = null;
                GifImageView.this.f11274l = null;
                GifImageView.this.f11271i = null;
                GifImageView.this.f11277o = false;
            }
        };
        this.f11280r = new Runnable() { // from class: com.clevertap.android.sdk.gif.GifImageView.2
            @Override // java.lang.Runnable
            public void run() {
                if (GifImageView.this.f11278p != null && !GifImageView.this.f11278p.isRecycled()) {
                    GifImageView gifImageView = GifImageView.this;
                    gifImageView.setImageBitmap(gifImageView.f11278p);
                    GifImageView.this.setScaleType(ImageView.ScaleType.FIT_CENTER);
                }
            }
        };
    }

    private boolean h() {
        if ((this.f11268f || this.f11276n) && this.f11274l != null && this.f11271i == null) {
            return true;
        }
        return false;
    }

    private void l() {
        if (h()) {
            Thread thread = new Thread(this);
            this.f11271i = thread;
            thread.start();
        }
    }

    public int getFrameCount() {
        return this.f11274l.g();
    }

    public long getFramesDisplayDuration() {
        return this.f11273k;
    }

    public int getGifHeight() {
        return this.f11274l.i();
    }

    public int getGifWidth() {
        return this.f11274l.m();
    }

    public OnAnimationStop getOnAnimationStop() {
        return this.f11270h;
    }

    public OnFrameAvailable getOnFrameAvailable() {
        return this.f11272j;
    }

    public void i() {
        this.f11268f = false;
        this.f11276n = false;
        this.f11277o = true;
        m();
        this.f11275m.post(this.f11279q);
    }

    public void j(int i8) {
        if (this.f11274l.e() != i8 && this.f11274l.w(i8 - 1) && !this.f11268f) {
            this.f11276n = true;
            l();
        }
    }

    public void k() {
        this.f11268f = true;
        l();
    }

    public void m() {
        this.f11268f = false;
        Thread thread = this.f11271i;
        if (thread != null) {
            thread.interrupt();
            this.f11271i = null;
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        i();
    }

    @Override // java.lang.Runnable
    public void run() {
        long j8;
        OnAnimationStart onAnimationStart = this.f11269g;
        if (onAnimationStart != null) {
            onAnimationStart.a();
        }
        do {
            if (!this.f11268f && !this.f11276n) {
                break;
            }
            boolean a8 = this.f11274l.a();
            try {
                long nanoTime = System.nanoTime();
                Bitmap l8 = this.f11274l.l();
                this.f11278p = l8;
                OnFrameAvailable onFrameAvailable = this.f11272j;
                if (onFrameAvailable != null) {
                    this.f11278p = onFrameAvailable.a(l8);
                }
                j8 = (System.nanoTime() - nanoTime) / 1000000;
                try {
                    this.f11275m.post(this.f11280r);
                } catch (ArrayIndexOutOfBoundsException | IllegalArgumentException unused) {
                }
            } catch (ArrayIndexOutOfBoundsException | IllegalArgumentException unused2) {
                j8 = 0;
            }
            this.f11276n = false;
            if (this.f11268f && a8) {
                try {
                    int k8 = (int) (this.f11274l.k() - j8);
                    if (k8 > 0) {
                        long j9 = this.f11273k;
                        if (j9 <= 0) {
                            j9 = k8;
                        }
                        Thread.sleep(j9);
                    }
                } catch (InterruptedException unused3) {
                }
            } else {
                this.f11268f = false;
                break;
            }
        } while (this.f11268f);
        if (this.f11277o) {
            this.f11275m.post(this.f11279q);
        }
        this.f11271i = null;
        OnAnimationStop onAnimationStop = this.f11270h;
        if (onAnimationStop != null) {
            onAnimationStop.a();
        }
    }

    public void setBytes(byte[] bArr) {
        GifDecoder gifDecoder = new GifDecoder();
        this.f11274l = gifDecoder;
        try {
            gifDecoder.n(bArr);
            if (this.f11268f) {
                l();
            } else {
                j(0);
            }
        } catch (Exception unused) {
            this.f11274l = null;
        }
    }

    public void setFramesDisplayDuration(long j8) {
        this.f11273k = j8;
    }

    public void setOnAnimationStart(OnAnimationStart onAnimationStart) {
        this.f11269g = onAnimationStart;
    }

    public void setOnAnimationStop(OnAnimationStop onAnimationStop) {
        this.f11270h = onAnimationStop;
    }

    public void setOnFrameAvailable(OnFrameAvailable onFrameAvailable) {
        this.f11272j = onFrameAvailable;
    }
}
