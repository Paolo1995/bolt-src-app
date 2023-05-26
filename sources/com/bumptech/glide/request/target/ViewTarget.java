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

@Deprecated
/* loaded from: classes.dex */
public abstract class ViewTarget<T extends View, Z> extends BaseTarget<Z> {

    /* renamed from: l  reason: collision with root package name */
    private static boolean f10741l;

    /* renamed from: m  reason: collision with root package name */
    private static int f10742m = R$id.glide_custom_view_target_tag;

    /* renamed from: g  reason: collision with root package name */
    protected final T f10743g;

    /* renamed from: h  reason: collision with root package name */
    private final SizeDeterminer f10744h;

    /* renamed from: i  reason: collision with root package name */
    private View.OnAttachStateChangeListener f10745i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f10746j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f10747k;

    /* loaded from: classes.dex */
    static final class SizeDeterminer {

        /* renamed from: e  reason: collision with root package name */
        static Integer f10748e;

        /* renamed from: a  reason: collision with root package name */
        private final View f10749a;

        /* renamed from: b  reason: collision with root package name */
        private final List<SizeReadyCallback> f10750b = new ArrayList();

        /* renamed from: c  reason: collision with root package name */
        boolean f10751c;

        /* renamed from: d  reason: collision with root package name */
        private SizeDeterminerLayoutListener f10752d;

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class SizeDeterminerLayoutListener implements ViewTreeObserver.OnPreDrawListener {

            /* renamed from: f  reason: collision with root package name */
            private final WeakReference<SizeDeterminer> f10753f;

            SizeDeterminerLayoutListener(@NonNull SizeDeterminer sizeDeterminer) {
                this.f10753f = new WeakReference<>(sizeDeterminer);
            }

            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                if (Log.isLoggable("ViewTarget", 2)) {
                    Log.v("ViewTarget", "OnGlobalLayoutListener called attachStateListener=" + this);
                }
                SizeDeterminer sizeDeterminer = this.f10753f.get();
                if (sizeDeterminer != null) {
                    sizeDeterminer.a();
                    return true;
                }
                return true;
            }
        }

        SizeDeterminer(@NonNull View view) {
            this.f10749a = view;
        }

        private static int c(@NonNull Context context) {
            if (f10748e == null) {
                Display defaultDisplay = ((WindowManager) Preconditions.d((WindowManager) context.getSystemService("window"))).getDefaultDisplay();
                Point point = new Point();
                defaultDisplay.getSize(point);
                f10748e = Integer.valueOf(Math.max(point.x, point.y));
            }
            return f10748e.intValue();
        }

        private int e(int i8, int i9, int i10) {
            int i11 = i9 - i10;
            if (i11 > 0) {
                return i11;
            }
            if (this.f10751c && this.f10749a.isLayoutRequested()) {
                return 0;
            }
            int i12 = i8 - i10;
            if (i12 > 0) {
                return i12;
            }
            if (this.f10749a.isLayoutRequested() || i9 != -2) {
                return 0;
            }
            if (Log.isLoggable("ViewTarget", 4)) {
                Log.i("ViewTarget", "Glide treats LayoutParams.WRAP_CONTENT as a request for an image the size of this device's screen dimensions. If you want to load the original image and are ok with the corresponding memory cost and OOMs (depending on the input size), use override(Target.SIZE_ORIGINAL). Otherwise, use LayoutParams.MATCH_PARENT, set layout_width and layout_height to fixed dimension, or use .override() with fixed dimensions.");
            }
            return c(this.f10749a.getContext());
        }

        private int f() {
            int i8;
            int paddingTop = this.f10749a.getPaddingTop() + this.f10749a.getPaddingBottom();
            ViewGroup.LayoutParams layoutParams = this.f10749a.getLayoutParams();
            if (layoutParams != null) {
                i8 = layoutParams.height;
            } else {
                i8 = 0;
            }
            return e(this.f10749a.getHeight(), i8, paddingTop);
        }

        private int g() {
            int i8;
            int paddingLeft = this.f10749a.getPaddingLeft() + this.f10749a.getPaddingRight();
            ViewGroup.LayoutParams layoutParams = this.f10749a.getLayoutParams();
            if (layoutParams != null) {
                i8 = layoutParams.width;
            } else {
                i8 = 0;
            }
            return e(this.f10749a.getWidth(), i8, paddingLeft);
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
            Iterator it = new ArrayList(this.f10750b).iterator();
            while (it.hasNext()) {
                ((SizeReadyCallback) it.next()).e(i8, i9);
            }
        }

        void a() {
            if (this.f10750b.isEmpty()) {
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
            ViewTreeObserver viewTreeObserver = this.f10749a.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeOnPreDrawListener(this.f10752d);
            }
            this.f10752d = null;
            this.f10750b.clear();
        }

        void d(@NonNull SizeReadyCallback sizeReadyCallback) {
            int g8 = g();
            int f8 = f();
            if (i(g8, f8)) {
                sizeReadyCallback.e(g8, f8);
                return;
            }
            if (!this.f10750b.contains(sizeReadyCallback)) {
                this.f10750b.add(sizeReadyCallback);
            }
            if (this.f10752d == null) {
                ViewTreeObserver viewTreeObserver = this.f10749a.getViewTreeObserver();
                SizeDeterminerLayoutListener sizeDeterminerLayoutListener = new SizeDeterminerLayoutListener(this);
                this.f10752d = sizeDeterminerLayoutListener;
                viewTreeObserver.addOnPreDrawListener(sizeDeterminerLayoutListener);
            }
        }

        void k(@NonNull SizeReadyCallback sizeReadyCallback) {
            this.f10750b.remove(sizeReadyCallback);
        }
    }

    public ViewTarget(@NonNull T t7) {
        this.f10743g = (T) Preconditions.d(t7);
        this.f10744h = new SizeDeterminer(t7);
    }

    private Object f() {
        return this.f10743g.getTag(f10742m);
    }

    private void h() {
        View.OnAttachStateChangeListener onAttachStateChangeListener = this.f10745i;
        if (onAttachStateChangeListener != null && !this.f10747k) {
            this.f10743g.addOnAttachStateChangeListener(onAttachStateChangeListener);
            this.f10747k = true;
        }
    }

    private void j() {
        View.OnAttachStateChangeListener onAttachStateChangeListener = this.f10745i;
        if (onAttachStateChangeListener != null && this.f10747k) {
            this.f10743g.removeOnAttachStateChangeListener(onAttachStateChangeListener);
            this.f10747k = false;
        }
    }

    private void l(Object obj) {
        f10741l = true;
        this.f10743g.setTag(f10742m, obj);
    }

    @Override // com.bumptech.glide.request.target.Target
    public void a(@NonNull SizeReadyCallback sizeReadyCallback) {
        this.f10744h.k(sizeReadyCallback);
    }

    @Override // com.bumptech.glide.request.target.BaseTarget, com.bumptech.glide.request.target.Target
    public void b(Drawable drawable) {
        super.b(drawable);
        h();
    }

    @Override // com.bumptech.glide.request.target.BaseTarget, com.bumptech.glide.request.target.Target
    public Request c() {
        Object f8 = f();
        if (f8 != null) {
            if (f8 instanceof Request) {
                return (Request) f8;
            }
            throw new IllegalArgumentException("You must not call setTag() on a view Glide is targeting");
        }
        return null;
    }

    @Override // com.bumptech.glide.request.target.BaseTarget, com.bumptech.glide.request.target.Target
    public void d(Drawable drawable) {
        super.d(drawable);
        this.f10744h.b();
        if (!this.f10746j) {
            j();
        }
    }

    @Override // com.bumptech.glide.request.target.BaseTarget, com.bumptech.glide.request.target.Target
    public void g(Request request) {
        l(request);
    }

    @Override // com.bumptech.glide.request.target.Target
    public void k(@NonNull SizeReadyCallback sizeReadyCallback) {
        this.f10744h.d(sizeReadyCallback);
    }

    public String toString() {
        return "Target for: " + this.f10743g;
    }
}
