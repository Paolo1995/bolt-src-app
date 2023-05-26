package com.bumptech.glide.request.target;

import android.content.Context;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import com.bumptech.glide.R$id;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.util.Preconditions;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public abstract class CustomViewTarget<T extends View, Z> implements Target<Z> {

    /* renamed from: k  reason: collision with root package name */
    private static final int f10726k = R$id.glide_custom_view_target_tag;

    /* renamed from: f  reason: collision with root package name */
    private final SizeDeterminer f10727f;

    /* renamed from: g  reason: collision with root package name */
    protected final T f10728g;

    /* renamed from: h  reason: collision with root package name */
    private View.OnAttachStateChangeListener f10729h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f10730i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f10731j;

    /* loaded from: classes.dex */
    static final class SizeDeterminer {

        /* renamed from: e  reason: collision with root package name */
        static Integer f10732e;

        /* renamed from: a  reason: collision with root package name */
        private final View f10733a;

        /* renamed from: b  reason: collision with root package name */
        private final List<SizeReadyCallback> f10734b = new ArrayList();

        /* renamed from: c  reason: collision with root package name */
        boolean f10735c;

        /* renamed from: d  reason: collision with root package name */
        private SizeDeterminerLayoutListener f10736d;

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class SizeDeterminerLayoutListener implements ViewTreeObserver.OnPreDrawListener {

            /* renamed from: f  reason: collision with root package name */
            private final WeakReference<SizeDeterminer> f10737f;

            SizeDeterminerLayoutListener(@NonNull SizeDeterminer sizeDeterminer) {
                this.f10737f = new WeakReference<>(sizeDeterminer);
            }

            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                if (Log.isLoggable("CustomViewTarget", 2)) {
                    Log.v("CustomViewTarget", "OnGlobalLayoutListener called attachStateListener=" + this);
                }
                SizeDeterminer sizeDeterminer = this.f10737f.get();
                if (sizeDeterminer != null) {
                    sizeDeterminer.a();
                    return true;
                }
                return true;
            }
        }

        SizeDeterminer(@NonNull View view) {
            this.f10733a = view;
        }

        private static int c(@NonNull Context context) {
            if (f10732e == null) {
                Display defaultDisplay = ((WindowManager) Preconditions.d((WindowManager) context.getSystemService("window"))).getDefaultDisplay();
                Point point = new Point();
                defaultDisplay.getSize(point);
                f10732e = Integer.valueOf(Math.max(point.x, point.y));
            }
            return f10732e.intValue();
        }

        private int e(int i8, int i9, int i10) {
            int i11 = i9 - i10;
            if (i11 > 0) {
                return i11;
            }
            if (this.f10735c && this.f10733a.isLayoutRequested()) {
                return 0;
            }
            int i12 = i8 - i10;
            if (i12 > 0) {
                return i12;
            }
            if (this.f10733a.isLayoutRequested() || i9 != -2) {
                return 0;
            }
            if (Log.isLoggable("CustomViewTarget", 4)) {
                Log.i("CustomViewTarget", "Glide treats LayoutParams.WRAP_CONTENT as a request for an image the size of this device's screen dimensions. If you want to load the original image and are ok with the corresponding memory cost and OOMs (depending on the input size), use .override(Target.SIZE_ORIGINAL). Otherwise, use LayoutParams.MATCH_PARENT, set layout_width and layout_height to fixed dimension, or use .override() with fixed dimensions.");
            }
            return c(this.f10733a.getContext());
        }

        private int f() {
            int i8;
            int paddingTop = this.f10733a.getPaddingTop() + this.f10733a.getPaddingBottom();
            ViewGroup.LayoutParams layoutParams = this.f10733a.getLayoutParams();
            if (layoutParams != null) {
                i8 = layoutParams.height;
            } else {
                i8 = 0;
            }
            return e(this.f10733a.getHeight(), i8, paddingTop);
        }

        private int g() {
            int i8;
            int paddingLeft = this.f10733a.getPaddingLeft() + this.f10733a.getPaddingRight();
            ViewGroup.LayoutParams layoutParams = this.f10733a.getLayoutParams();
            if (layoutParams != null) {
                i8 = layoutParams.width;
            } else {
                i8 = 0;
            }
            return e(this.f10733a.getWidth(), i8, paddingLeft);
        }

        private boolean h(int i8) {
            return i8 > 0 || i8 == Integer.MIN_VALUE;
        }

        private boolean i(int i8, int i9) {
            if (h(i8) && h(i9)) {
                return true;
            }
            return false;
        }

        private void j(int i8, int i9) {
            Iterator it = new ArrayList(this.f10734b).iterator();
            while (it.hasNext()) {
                ((SizeReadyCallback) it.next()).e(i8, i9);
            }
        }

        void a() {
            if (this.f10734b.isEmpty()) {
                return;
            }
            int g8 = g();
            int f8 = f();
            if (!i(g8, f8)) {
                return;
            }
            j(g8, f8);
            b();
        }

        void b() {
            ViewTreeObserver viewTreeObserver = this.f10733a.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeOnPreDrawListener(this.f10736d);
            }
            this.f10736d = null;
            this.f10734b.clear();
        }

        void d(@NonNull SizeReadyCallback sizeReadyCallback) {
            int g8 = g();
            int f8 = f();
            if (i(g8, f8)) {
                sizeReadyCallback.e(g8, f8);
                return;
            }
            if (!this.f10734b.contains(sizeReadyCallback)) {
                this.f10734b.add(sizeReadyCallback);
            }
            if (this.f10736d == null) {
                ViewTreeObserver viewTreeObserver = this.f10733a.getViewTreeObserver();
                SizeDeterminerLayoutListener sizeDeterminerLayoutListener = new SizeDeterminerLayoutListener(this);
                this.f10736d = sizeDeterminerLayoutListener;
                viewTreeObserver.addOnPreDrawListener(sizeDeterminerLayoutListener);
            }
        }

        void k(@NonNull SizeReadyCallback sizeReadyCallback) {
            this.f10734b.remove(sizeReadyCallback);
        }
    }

    public CustomViewTarget(@NonNull T t7) {
        this.f10728g = (T) Preconditions.d(t7);
        this.f10727f = new SizeDeterminer(t7);
    }

    private Object f() {
        return this.f10728g.getTag(f10726k);
    }

    private void j() {
        View.OnAttachStateChangeListener onAttachStateChangeListener = this.f10729h;
        if (onAttachStateChangeListener != null && !this.f10731j) {
            this.f10728g.addOnAttachStateChangeListener(onAttachStateChangeListener);
            this.f10731j = true;
        }
    }

    private void l() {
        View.OnAttachStateChangeListener onAttachStateChangeListener = this.f10729h;
        if (onAttachStateChangeListener != null && this.f10731j) {
            this.f10728g.removeOnAttachStateChangeListener(onAttachStateChangeListener);
            this.f10731j = false;
        }
    }

    private void o(Object obj) {
        this.f10728g.setTag(f10726k, obj);
    }

    @Override // com.bumptech.glide.request.target.Target
    public final void a(@NonNull SizeReadyCallback sizeReadyCallback) {
        this.f10727f.k(sizeReadyCallback);
    }

    @Override // com.bumptech.glide.request.target.Target
    public final void b(Drawable drawable) {
        j();
        n(drawable);
    }

    @Override // com.bumptech.glide.request.target.Target
    public final Request c() {
        Object f8 = f();
        if (f8 != null) {
            if (f8 instanceof Request) {
                return (Request) f8;
            }
            throw new IllegalArgumentException("You must not pass non-R.id ids to setTag(id)");
        }
        return null;
    }

    @Override // com.bumptech.glide.request.target.Target
    public final void d(Drawable drawable) {
        this.f10727f.b();
        m(drawable);
        if (!this.f10730i) {
            l();
        }
    }

    @Override // com.bumptech.glide.request.target.Target
    public final void g(Request request) {
        o(request);
    }

    @NonNull
    public final T h() {
        return this.f10728g;
    }

    @Override // com.bumptech.glide.request.target.Target
    public final void k(@NonNull SizeReadyCallback sizeReadyCallback) {
        this.f10727f.d(sizeReadyCallback);
    }

    protected abstract void m(Drawable drawable);

    /* JADX INFO: Access modifiers changed from: protected */
    public void n(Drawable drawable) {
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public void onDestroy() {
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public void onStart() {
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public void onStop() {
    }

    public String toString() {
        return "Target for: " + this.f10728g;
    }
}
