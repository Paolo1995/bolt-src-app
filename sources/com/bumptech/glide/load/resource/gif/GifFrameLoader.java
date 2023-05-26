package com.bumptech.glide.load.resource.gif;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.gifdecoder.GifDecoder;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import com.bumptech.glide.signature.ObjectKey;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.Util;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class GifFrameLoader {

    /* renamed from: a  reason: collision with root package name */
    private final GifDecoder f10541a;

    /* renamed from: b  reason: collision with root package name */
    private final Handler f10542b;

    /* renamed from: c  reason: collision with root package name */
    private final List<FrameCallback> f10543c;

    /* renamed from: d  reason: collision with root package name */
    final RequestManager f10544d;

    /* renamed from: e  reason: collision with root package name */
    private final BitmapPool f10545e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f10546f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f10547g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f10548h;

    /* renamed from: i  reason: collision with root package name */
    private RequestBuilder<Bitmap> f10549i;

    /* renamed from: j  reason: collision with root package name */
    private DelayTarget f10550j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f10551k;

    /* renamed from: l  reason: collision with root package name */
    private DelayTarget f10552l;

    /* renamed from: m  reason: collision with root package name */
    private Bitmap f10553m;

    /* renamed from: n  reason: collision with root package name */
    private Transformation<Bitmap> f10554n;

    /* renamed from: o  reason: collision with root package name */
    private DelayTarget f10555o;

    /* renamed from: p  reason: collision with root package name */
    private OnEveryFrameListener f10556p;

    /* renamed from: q  reason: collision with root package name */
    private int f10557q;

    /* renamed from: r  reason: collision with root package name */
    private int f10558r;

    /* renamed from: s  reason: collision with root package name */
    private int f10559s;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class DelayTarget extends CustomTarget<Bitmap> {

        /* renamed from: i  reason: collision with root package name */
        private final Handler f10560i;

        /* renamed from: j  reason: collision with root package name */
        final int f10561j;

        /* renamed from: k  reason: collision with root package name */
        private final long f10562k;

        /* renamed from: l  reason: collision with root package name */
        private Bitmap f10563l;

        DelayTarget(Handler handler, int i8, long j8) {
            this.f10560i = handler;
            this.f10561j = i8;
            this.f10562k = j8;
        }

        @Override // com.bumptech.glide.request.target.Target
        public void d(Drawable drawable) {
            this.f10563l = null;
        }

        Bitmap f() {
            return this.f10563l;
        }

        @Override // com.bumptech.glide.request.target.Target
        /* renamed from: h */
        public void e(@NonNull Bitmap bitmap, Transition<? super Bitmap> transition) {
            this.f10563l = bitmap;
            this.f10560i.sendMessageAtTime(this.f10560i.obtainMessage(1, this), this.f10562k);
        }
    }

    /* loaded from: classes.dex */
    public interface FrameCallback {
        void a();
    }

    /* loaded from: classes.dex */
    private class FrameLoaderCallback implements Handler.Callback {
        FrameLoaderCallback() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i8 = message.what;
            if (i8 == 1) {
                GifFrameLoader.this.m((DelayTarget) message.obj);
                return true;
            } else if (i8 == 2) {
                GifFrameLoader.this.f10544d.n((DelayTarget) message.obj);
                return false;
            } else {
                return false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface OnEveryFrameListener {
        void a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public GifFrameLoader(Glide glide, GifDecoder gifDecoder, int i8, int i9, Transformation<Bitmap> transformation, Bitmap bitmap) {
        this(glide.f(), Glide.t(glide.h()), gifDecoder, null, i(Glide.t(glide.h()), i8, i9), transformation, bitmap);
    }

    private static Key g() {
        return new ObjectKey(Double.valueOf(Math.random()));
    }

    private static RequestBuilder<Bitmap> i(RequestManager requestManager, int i8, int i9) {
        return requestManager.h().a(RequestOptions.r0(DiskCacheStrategy.f10070b).p0(true).k0(true).Z(i8, i9));
    }

    private void l() {
        boolean z7;
        if (this.f10546f && !this.f10547g) {
            if (this.f10548h) {
                if (this.f10555o == null) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                Preconditions.a(z7, "Pending target must be null when starting from the first frame");
                this.f10541a.e();
                this.f10548h = false;
            }
            DelayTarget delayTarget = this.f10555o;
            if (delayTarget != null) {
                this.f10555o = null;
                m(delayTarget);
                return;
            }
            this.f10547g = true;
            long uptimeMillis = SystemClock.uptimeMillis() + this.f10541a.d();
            this.f10541a.a();
            this.f10552l = new DelayTarget(this.f10542b, this.f10541a.f(), uptimeMillis);
            this.f10549i.a(RequestOptions.s0(g())).F0(this.f10541a).y0(this.f10552l);
        }
    }

    private void n() {
        Bitmap bitmap = this.f10553m;
        if (bitmap != null) {
            this.f10545e.c(bitmap);
            this.f10553m = null;
        }
    }

    private void p() {
        if (this.f10546f) {
            return;
        }
        this.f10546f = true;
        this.f10551k = false;
        l();
    }

    private void q() {
        this.f10546f = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        this.f10543c.clear();
        n();
        q();
        DelayTarget delayTarget = this.f10550j;
        if (delayTarget != null) {
            this.f10544d.n(delayTarget);
            this.f10550j = null;
        }
        DelayTarget delayTarget2 = this.f10552l;
        if (delayTarget2 != null) {
            this.f10544d.n(delayTarget2);
            this.f10552l = null;
        }
        DelayTarget delayTarget3 = this.f10555o;
        if (delayTarget3 != null) {
            this.f10544d.n(delayTarget3);
            this.f10555o = null;
        }
        this.f10541a.clear();
        this.f10551k = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ByteBuffer b() {
        return this.f10541a.getData().asReadOnlyBuffer();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Bitmap c() {
        DelayTarget delayTarget = this.f10550j;
        if (delayTarget != null) {
            return delayTarget.f();
        }
        return this.f10553m;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int d() {
        DelayTarget delayTarget = this.f10550j;
        if (delayTarget != null) {
            return delayTarget.f10561j;
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Bitmap e() {
        return this.f10553m;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int f() {
        return this.f10541a.b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int h() {
        return this.f10559s;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int j() {
        return this.f10541a.g() + this.f10557q;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int k() {
        return this.f10558r;
    }

    void m(DelayTarget delayTarget) {
        OnEveryFrameListener onEveryFrameListener = this.f10556p;
        if (onEveryFrameListener != null) {
            onEveryFrameListener.a();
        }
        this.f10547g = false;
        if (this.f10551k) {
            this.f10542b.obtainMessage(2, delayTarget).sendToTarget();
        } else if (!this.f10546f) {
            if (this.f10548h) {
                this.f10542b.obtainMessage(2, delayTarget).sendToTarget();
            } else {
                this.f10555o = delayTarget;
            }
        } else {
            if (delayTarget.f() != null) {
                n();
                DelayTarget delayTarget2 = this.f10550j;
                this.f10550j = delayTarget;
                for (int size = this.f10543c.size() - 1; size >= 0; size--) {
                    this.f10543c.get(size).a();
                }
                if (delayTarget2 != null) {
                    this.f10542b.obtainMessage(2, delayTarget2).sendToTarget();
                }
            }
            l();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o(Transformation<Bitmap> transformation, Bitmap bitmap) {
        this.f10554n = (Transformation) Preconditions.d(transformation);
        this.f10553m = (Bitmap) Preconditions.d(bitmap);
        this.f10549i = this.f10549i.a(new RequestOptions().l0(transformation));
        this.f10557q = Util.h(bitmap);
        this.f10558r = bitmap.getWidth();
        this.f10559s = bitmap.getHeight();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void r(FrameCallback frameCallback) {
        if (!this.f10551k) {
            if (!this.f10543c.contains(frameCallback)) {
                boolean isEmpty = this.f10543c.isEmpty();
                this.f10543c.add(frameCallback);
                if (isEmpty) {
                    p();
                    return;
                }
                return;
            }
            throw new IllegalStateException("Cannot subscribe twice in a row");
        }
        throw new IllegalStateException("Cannot subscribe to a cleared frame loader");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void s(FrameCallback frameCallback) {
        this.f10543c.remove(frameCallback);
        if (this.f10543c.isEmpty()) {
            q();
        }
    }

    GifFrameLoader(BitmapPool bitmapPool, RequestManager requestManager, GifDecoder gifDecoder, Handler handler, RequestBuilder<Bitmap> requestBuilder, Transformation<Bitmap> transformation, Bitmap bitmap) {
        this.f10543c = new ArrayList();
        this.f10544d = requestManager;
        handler = handler == null ? new Handler(Looper.getMainLooper(), new FrameLoaderCallback()) : handler;
        this.f10545e = bitmapPool;
        this.f10542b = handler;
        this.f10549i = requestBuilder;
        this.f10541a = gifDecoder;
        o(transformation, bitmap);
    }
}
