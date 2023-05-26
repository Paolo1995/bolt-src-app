package com.airbnb.lottie.animation.keyframe;

import android.view.animation.Interpolator;
import androidx.annotation.NonNull;
import com.airbnb.lottie.L;
import com.airbnb.lottie.value.Keyframe;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public abstract class BaseKeyframeAnimation<K, A> {

    /* renamed from: c  reason: collision with root package name */
    private final KeyframesWrapper<K> f9169c;

    /* renamed from: e  reason: collision with root package name */
    protected LottieValueCallback<A> f9171e;

    /* renamed from: a  reason: collision with root package name */
    final List<AnimationListener> f9167a = new ArrayList(1);

    /* renamed from: b  reason: collision with root package name */
    private boolean f9168b = false;

    /* renamed from: d  reason: collision with root package name */
    protected float f9170d = 0.0f;

    /* renamed from: f  reason: collision with root package name */
    private A f9172f = null;

    /* renamed from: g  reason: collision with root package name */
    private float f9173g = -1.0f;

    /* renamed from: h  reason: collision with root package name */
    private float f9174h = -1.0f;

    /* loaded from: classes.dex */
    public interface AnimationListener {
        void a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class EmptyKeyframeWrapper<T> implements KeyframesWrapper<T> {
        private EmptyKeyframeWrapper() {
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public boolean a(float f8) {
            throw new IllegalStateException("not implemented");
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public Keyframe<T> b() {
            throw new IllegalStateException("not implemented");
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public boolean c(float f8) {
            return false;
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public float d() {
            return 0.0f;
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public float e() {
            return 1.0f;
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public boolean isEmpty() {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public interface KeyframesWrapper<T> {
        boolean a(float f8);

        Keyframe<T> b();

        boolean c(float f8);

        float d();

        float e();

        boolean isEmpty();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class KeyframesWrapperImpl<T> implements KeyframesWrapper<T> {

        /* renamed from: a  reason: collision with root package name */
        private final List<? extends Keyframe<T>> f9175a;

        /* renamed from: c  reason: collision with root package name */
        private Keyframe<T> f9177c = null;

        /* renamed from: d  reason: collision with root package name */
        private float f9178d = -1.0f;
        @NonNull

        /* renamed from: b  reason: collision with root package name */
        private Keyframe<T> f9176b = f(0.0f);

        KeyframesWrapperImpl(List<? extends Keyframe<T>> list) {
            this.f9175a = list;
        }

        private Keyframe<T> f(float f8) {
            List<? extends Keyframe<T>> list = this.f9175a;
            Keyframe<T> keyframe = list.get(list.size() - 1);
            if (f8 >= keyframe.e()) {
                return keyframe;
            }
            for (int size = this.f9175a.size() - 2; size >= 1; size--) {
                Keyframe<T> keyframe2 = this.f9175a.get(size);
                if (this.f9176b != keyframe2 && keyframe2.a(f8)) {
                    return keyframe2;
                }
            }
            return this.f9175a.get(0);
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public boolean a(float f8) {
            Keyframe<T> keyframe = this.f9177c;
            Keyframe<T> keyframe2 = this.f9176b;
            if (keyframe == keyframe2 && this.f9178d == f8) {
                return true;
            }
            this.f9177c = keyframe2;
            this.f9178d = f8;
            return false;
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        @NonNull
        public Keyframe<T> b() {
            return this.f9176b;
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public boolean c(float f8) {
            if (this.f9176b.a(f8)) {
                return !this.f9176b.h();
            }
            this.f9176b = f(f8);
            return true;
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public float d() {
            return this.f9175a.get(0).e();
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public float e() {
            List<? extends Keyframe<T>> list = this.f9175a;
            return list.get(list.size() - 1).b();
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public boolean isEmpty() {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class SingleKeyframeWrapper<T> implements KeyframesWrapper<T> {
        @NonNull

        /* renamed from: a  reason: collision with root package name */
        private final Keyframe<T> f9179a;

        /* renamed from: b  reason: collision with root package name */
        private float f9180b = -1.0f;

        SingleKeyframeWrapper(List<? extends Keyframe<T>> list) {
            this.f9179a = list.get(0);
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public boolean a(float f8) {
            if (this.f9180b == f8) {
                return true;
            }
            this.f9180b = f8;
            return false;
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public Keyframe<T> b() {
            return this.f9179a;
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public boolean c(float f8) {
            return !this.f9179a.h();
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public float d() {
            return this.f9179a.e();
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public float e() {
            return this.f9179a.b();
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public boolean isEmpty() {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BaseKeyframeAnimation(List<? extends Keyframe<K>> list) {
        this.f9169c = o(list);
    }

    private float g() {
        if (this.f9173g == -1.0f) {
            this.f9173g = this.f9169c.d();
        }
        return this.f9173g;
    }

    private static <T> KeyframesWrapper<T> o(List<? extends Keyframe<T>> list) {
        if (list.isEmpty()) {
            return new EmptyKeyframeWrapper();
        }
        if (list.size() == 1) {
            return new SingleKeyframeWrapper(list);
        }
        return new KeyframesWrapperImpl(list);
    }

    public void a(AnimationListener animationListener) {
        this.f9167a.add(animationListener);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Keyframe<K> b() {
        L.a("BaseKeyframeAnimation#getCurrentKeyframe");
        Keyframe<K> b8 = this.f9169c.b();
        L.b("BaseKeyframeAnimation#getCurrentKeyframe");
        return b8;
    }

    float c() {
        if (this.f9174h == -1.0f) {
            this.f9174h = this.f9169c.e();
        }
        return this.f9174h;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public float d() {
        Keyframe<K> b8 = b();
        if (b8 != null && !b8.h()) {
            return b8.f9663d.getInterpolation(e());
        }
        return 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float e() {
        if (this.f9168b) {
            return 0.0f;
        }
        Keyframe<K> b8 = b();
        if (b8.h()) {
            return 0.0f;
        }
        return (this.f9170d - b8.e()) / (b8.b() - b8.e());
    }

    public float f() {
        return this.f9170d;
    }

    public A h() {
        A i8;
        float e8 = e();
        if (this.f9171e == null && this.f9169c.a(e8)) {
            return this.f9172f;
        }
        Keyframe<K> b8 = b();
        Interpolator interpolator = b8.f9664e;
        if (interpolator != null && b8.f9665f != null) {
            i8 = j(b8, e8, interpolator.getInterpolation(e8), b8.f9665f.getInterpolation(e8));
        } else {
            i8 = i(b8, d());
        }
        this.f9172f = i8;
        return i8;
    }

    abstract A i(Keyframe<K> keyframe, float f8);

    protected A j(Keyframe<K> keyframe, float f8, float f9, float f10) {
        throw new UnsupportedOperationException("This animation does not support split dimensions!");
    }

    public void k() {
        for (int i8 = 0; i8 < this.f9167a.size(); i8++) {
            this.f9167a.get(i8).a();
        }
    }

    public void l() {
        this.f9168b = true;
    }

    public void m(float f8) {
        if (this.f9169c.isEmpty()) {
            return;
        }
        if (f8 < g()) {
            f8 = g();
        } else if (f8 > c()) {
            f8 = c();
        }
        if (f8 == this.f9170d) {
            return;
        }
        this.f9170d = f8;
        if (this.f9169c.c(f8)) {
            k();
        }
    }

    public void n(LottieValueCallback<A> lottieValueCallback) {
        LottieValueCallback<A> lottieValueCallback2 = this.f9171e;
        if (lottieValueCallback2 != null) {
            lottieValueCallback2.c(null);
        }
        this.f9171e = lottieValueCallback;
        if (lottieValueCallback != null) {
            lottieValueCallback.c(this);
        }
    }
}
