package androidx.dynamicanimation.animation;

import android.os.Looper;
import android.util.AndroidRuntimeException;
import android.view.View;
import androidx.core.view.ViewCompat;
import androidx.dynamicanimation.animation.AnimationHandler;
import androidx.dynamicanimation.animation.DynamicAnimation;
import java.util.ArrayList;

/* loaded from: classes.dex */
public abstract class DynamicAnimation<T extends DynamicAnimation<T>> implements AnimationHandler.AnimationFrameCallback {

    /* renamed from: m  reason: collision with root package name */
    public static final ViewProperty f6256m = new ViewProperty("translationX") { // from class: androidx.dynamicanimation.animation.DynamicAnimation.1
        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        /* renamed from: c */
        public float a(View view) {
            return view.getTranslationX();
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        /* renamed from: d */
        public void b(View view, float f8) {
            view.setTranslationX(f8);
        }
    };

    /* renamed from: n  reason: collision with root package name */
    public static final ViewProperty f6257n = new ViewProperty("translationY") { // from class: androidx.dynamicanimation.animation.DynamicAnimation.2
        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        /* renamed from: c */
        public float a(View view) {
            return view.getTranslationY();
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        /* renamed from: d */
        public void b(View view, float f8) {
            view.setTranslationY(f8);
        }
    };

    /* renamed from: o  reason: collision with root package name */
    public static final ViewProperty f6258o = new ViewProperty("translationZ") { // from class: androidx.dynamicanimation.animation.DynamicAnimation.3
        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        /* renamed from: c */
        public float a(View view) {
            return ViewCompat.N(view);
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        /* renamed from: d */
        public void b(View view, float f8) {
            ViewCompat.N0(view, f8);
        }
    };

    /* renamed from: p  reason: collision with root package name */
    public static final ViewProperty f6259p = new ViewProperty("scaleX") { // from class: androidx.dynamicanimation.animation.DynamicAnimation.4
        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        /* renamed from: c */
        public float a(View view) {
            return view.getScaleX();
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        /* renamed from: d */
        public void b(View view, float f8) {
            view.setScaleX(f8);
        }
    };

    /* renamed from: q  reason: collision with root package name */
    public static final ViewProperty f6260q = new ViewProperty("scaleY") { // from class: androidx.dynamicanimation.animation.DynamicAnimation.5
        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        /* renamed from: c */
        public float a(View view) {
            return view.getScaleY();
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        /* renamed from: d */
        public void b(View view, float f8) {
            view.setScaleY(f8);
        }
    };

    /* renamed from: r  reason: collision with root package name */
    public static final ViewProperty f6261r = new ViewProperty("rotation") { // from class: androidx.dynamicanimation.animation.DynamicAnimation.6
        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        /* renamed from: c */
        public float a(View view) {
            return view.getRotation();
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        /* renamed from: d */
        public void b(View view, float f8) {
            view.setRotation(f8);
        }
    };

    /* renamed from: s  reason: collision with root package name */
    public static final ViewProperty f6262s = new ViewProperty("rotationX") { // from class: androidx.dynamicanimation.animation.DynamicAnimation.7
        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        /* renamed from: c */
        public float a(View view) {
            return view.getRotationX();
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        /* renamed from: d */
        public void b(View view, float f8) {
            view.setRotationX(f8);
        }
    };

    /* renamed from: t  reason: collision with root package name */
    public static final ViewProperty f6263t = new ViewProperty("rotationY") { // from class: androidx.dynamicanimation.animation.DynamicAnimation.8
        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        /* renamed from: c */
        public float a(View view) {
            return view.getRotationY();
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        /* renamed from: d */
        public void b(View view, float f8) {
            view.setRotationY(f8);
        }
    };

    /* renamed from: u  reason: collision with root package name */
    public static final ViewProperty f6264u = new ViewProperty("x") { // from class: androidx.dynamicanimation.animation.DynamicAnimation.9
        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        /* renamed from: c */
        public float a(View view) {
            return view.getX();
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        /* renamed from: d */
        public void b(View view, float f8) {
            view.setX(f8);
        }
    };

    /* renamed from: v  reason: collision with root package name */
    public static final ViewProperty f6265v = new ViewProperty("y") { // from class: androidx.dynamicanimation.animation.DynamicAnimation.10
        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        /* renamed from: c */
        public float a(View view) {
            return view.getY();
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        /* renamed from: d */
        public void b(View view, float f8) {
            view.setY(f8);
        }
    };

    /* renamed from: w  reason: collision with root package name */
    public static final ViewProperty f6266w = new ViewProperty("z") { // from class: androidx.dynamicanimation.animation.DynamicAnimation.11
        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        /* renamed from: c */
        public float a(View view) {
            return ViewCompat.P(view);
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        /* renamed from: d */
        public void b(View view, float f8) {
            ViewCompat.P0(view, f8);
        }
    };

    /* renamed from: x  reason: collision with root package name */
    public static final ViewProperty f6267x = new ViewProperty("alpha") { // from class: androidx.dynamicanimation.animation.DynamicAnimation.12
        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        /* renamed from: c */
        public float a(View view) {
            return view.getAlpha();
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        /* renamed from: d */
        public void b(View view, float f8) {
            view.setAlpha(f8);
        }
    };

    /* renamed from: y  reason: collision with root package name */
    public static final ViewProperty f6268y = new ViewProperty("scrollX") { // from class: androidx.dynamicanimation.animation.DynamicAnimation.13
        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        /* renamed from: c */
        public float a(View view) {
            return view.getScrollX();
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        /* renamed from: d */
        public void b(View view, float f8) {
            view.setScrollX((int) f8);
        }
    };

    /* renamed from: z  reason: collision with root package name */
    public static final ViewProperty f6269z = new ViewProperty("scrollY") { // from class: androidx.dynamicanimation.animation.DynamicAnimation.14
        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        /* renamed from: c */
        public float a(View view) {
            return view.getScrollY();
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        /* renamed from: d */
        public void b(View view, float f8) {
            view.setScrollY((int) f8);
        }
    };

    /* renamed from: d  reason: collision with root package name */
    final Object f6273d;

    /* renamed from: e  reason: collision with root package name */
    final FloatPropertyCompat f6274e;

    /* renamed from: j  reason: collision with root package name */
    private float f6279j;

    /* renamed from: a  reason: collision with root package name */
    float f6270a = 0.0f;

    /* renamed from: b  reason: collision with root package name */
    float f6271b = Float.MAX_VALUE;

    /* renamed from: c  reason: collision with root package name */
    boolean f6272c = false;

    /* renamed from: f  reason: collision with root package name */
    boolean f6275f = false;

    /* renamed from: g  reason: collision with root package name */
    float f6276g = Float.MAX_VALUE;

    /* renamed from: h  reason: collision with root package name */
    float f6277h = -Float.MAX_VALUE;

    /* renamed from: i  reason: collision with root package name */
    private long f6278i = 0;

    /* renamed from: k  reason: collision with root package name */
    private final ArrayList<OnAnimationEndListener> f6280k = new ArrayList<>();

    /* renamed from: l  reason: collision with root package name */
    private final ArrayList<OnAnimationUpdateListener> f6281l = new ArrayList<>();

    /* loaded from: classes.dex */
    static class MassState {

        /* renamed from: a  reason: collision with root package name */
        float f6282a;

        /* renamed from: b  reason: collision with root package name */
        float f6283b;
    }

    /* loaded from: classes.dex */
    public interface OnAnimationEndListener {
        void a(DynamicAnimation dynamicAnimation, boolean z7, float f8, float f9);
    }

    /* loaded from: classes.dex */
    public interface OnAnimationUpdateListener {
        void a(DynamicAnimation dynamicAnimation, float f8, float f9);
    }

    /* loaded from: classes.dex */
    public static abstract class ViewProperty extends FloatPropertyCompat<View> {
        private ViewProperty(String str) {
            super(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public <K> DynamicAnimation(K k8, FloatPropertyCompat<K> floatPropertyCompat) {
        this.f6273d = k8;
        this.f6274e = floatPropertyCompat;
        if (floatPropertyCompat != f6261r && floatPropertyCompat != f6262s && floatPropertyCompat != f6263t) {
            if (floatPropertyCompat == f6267x) {
                this.f6279j = 0.00390625f;
                return;
            } else if (floatPropertyCompat != f6259p && floatPropertyCompat != f6260q) {
                this.f6279j = 1.0f;
                return;
            } else {
                this.f6279j = 0.00390625f;
                return;
            }
        }
        this.f6279j = 0.1f;
    }

    private void b(boolean z7) {
        this.f6275f = false;
        AnimationHandler.d().g(this);
        this.f6278i = 0L;
        this.f6272c = false;
        for (int i8 = 0; i8 < this.f6280k.size(); i8++) {
            if (this.f6280k.get(i8) != null) {
                this.f6280k.get(i8).a(this, z7, this.f6271b, this.f6270a);
            }
        }
        f(this.f6280k);
    }

    private float c() {
        return this.f6274e.a(this.f6273d);
    }

    private static <T> void f(ArrayList<T> arrayList) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (arrayList.get(size) == null) {
                arrayList.remove(size);
            }
        }
    }

    private void j() {
        if (!this.f6275f) {
            this.f6275f = true;
            if (!this.f6272c) {
                this.f6271b = c();
            }
            float f8 = this.f6271b;
            if (f8 <= this.f6276g && f8 >= this.f6277h) {
                AnimationHandler.d().a(this, 0L);
                return;
            }
            throw new IllegalArgumentException("Starting value need to be in between min value and max value");
        }
    }

    @Override // androidx.dynamicanimation.animation.AnimationHandler.AnimationFrameCallback
    public boolean a(long j8) {
        long j9 = this.f6278i;
        if (j9 == 0) {
            this.f6278i = j8;
            g(this.f6271b);
            return false;
        }
        this.f6278i = j8;
        boolean k8 = k(j8 - j9);
        float min = Math.min(this.f6271b, this.f6276g);
        this.f6271b = min;
        float max = Math.max(min, this.f6277h);
        this.f6271b = max;
        g(max);
        if (k8) {
            b(false);
        }
        return k8;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float d() {
        return this.f6279j * 0.75f;
    }

    public boolean e() {
        return this.f6275f;
    }

    void g(float f8) {
        this.f6274e.b(this.f6273d, f8);
        for (int i8 = 0; i8 < this.f6281l.size(); i8++) {
            if (this.f6281l.get(i8) != null) {
                this.f6281l.get(i8).a(this, this.f6271b, this.f6270a);
            }
        }
        f(this.f6281l);
    }

    public T h(float f8) {
        this.f6271b = f8;
        this.f6272c = true;
        return this;
    }

    public void i() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            if (!this.f6275f) {
                j();
                return;
            }
            return;
        }
        throw new AndroidRuntimeException("Animations may only be started on the main thread");
    }

    abstract boolean k(long j8);
}
