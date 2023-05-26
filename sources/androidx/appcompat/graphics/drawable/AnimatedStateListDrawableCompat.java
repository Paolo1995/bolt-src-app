package androidx.appcompat.graphics.drawable;

import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.StateSet;
import androidx.annotation.NonNull;
import androidx.appcompat.graphics.drawable.DrawableContainerCompat;
import androidx.appcompat.graphics.drawable.StateListDrawableCompat;
import androidx.appcompat.resources.Compatibility$Api18Impl;
import androidx.appcompat.resources.Compatibility$Api21Impl;
import androidx.appcompat.resources.R$styleable;
import androidx.appcompat.widget.ResourceManagerInternal;
import androidx.collection.LongSparseArray;
import androidx.collection.SparseArrayCompat;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.graphics.drawable.TintAwareDrawable;
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
public class AnimatedStateListDrawableCompat extends StateListDrawableCompat implements TintAwareDrawable {

    /* renamed from: y  reason: collision with root package name */
    private static final String f1342y = AnimatedStateListDrawableCompat.class.getSimpleName();

    /* renamed from: t  reason: collision with root package name */
    private AnimatedStateListState f1343t;

    /* renamed from: u  reason: collision with root package name */
    private Transition f1344u;

    /* renamed from: v  reason: collision with root package name */
    private int f1345v;

    /* renamed from: w  reason: collision with root package name */
    private int f1346w;

    /* renamed from: x  reason: collision with root package name */
    private boolean f1347x;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class AnimatableTransition extends Transition {

        /* renamed from: a  reason: collision with root package name */
        private final Animatable f1348a;

        AnimatableTransition(Animatable animatable) {
            super();
            this.f1348a = animatable;
        }

        @Override // androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat.Transition
        public void c() {
            this.f1348a.start();
        }

        @Override // androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat.Transition
        public void d() {
            this.f1348a.stop();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class AnimatedStateListState extends StateListDrawableCompat.StateListState {
        LongSparseArray<Long> K;
        SparseArrayCompat<Integer> L;

        AnimatedStateListState(AnimatedStateListState animatedStateListState, @NonNull AnimatedStateListDrawableCompat animatedStateListDrawableCompat, Resources resources) {
            super(animatedStateListState, animatedStateListDrawableCompat, resources);
            if (animatedStateListState != null) {
                this.K = animatedStateListState.K;
                this.L = animatedStateListState.L;
                return;
            }
            this.K = new LongSparseArray<>();
            this.L = new SparseArrayCompat<>();
        }

        private static long E(int i8, int i9) {
            return i9 | (i8 << 32);
        }

        int C(@NonNull int[] iArr, @NonNull Drawable drawable, int i8) {
            int A = super.A(iArr, drawable);
            this.L.j(A, Integer.valueOf(i8));
            return A;
        }

        int D(int i8, int i9, @NonNull Drawable drawable, boolean z7) {
            long j8;
            int a8 = super.a(drawable);
            long E = E(i8, i9);
            if (z7) {
                j8 = 8589934592L;
            } else {
                j8 = 0;
            }
            long j9 = a8;
            this.K.a(E, Long.valueOf(j9 | j8));
            if (z7) {
                this.K.a(E(i9, i8), Long.valueOf(4294967296L | j9 | j8));
            }
            return a8;
        }

        int F(int i8) {
            if (i8 < 0) {
                return 0;
            }
            return this.L.f(i8, 0).intValue();
        }

        int G(@NonNull int[] iArr) {
            int B = super.B(iArr);
            if (B >= 0) {
                return B;
            }
            return super.B(StateSet.WILD_CARD);
        }

        int H(int i8, int i9) {
            return (int) this.K.h(E(i8, i9), -1L).longValue();
        }

        boolean I(int i8, int i9) {
            if ((this.K.h(E(i8, i9), -1L).longValue() & 4294967296L) != 0) {
                return true;
            }
            return false;
        }

        boolean J(int i8, int i9) {
            if ((this.K.h(E(i8, i9), -1L).longValue() & 8589934592L) != 0) {
                return true;
            }
            return false;
        }

        @Override // androidx.appcompat.graphics.drawable.StateListDrawableCompat.StateListState, android.graphics.drawable.Drawable.ConstantState
        @NonNull
        public Drawable newDrawable() {
            return new AnimatedStateListDrawableCompat(this, null);
        }

        @Override // androidx.appcompat.graphics.drawable.StateListDrawableCompat.StateListState, androidx.appcompat.graphics.drawable.DrawableContainerCompat.DrawableContainerState
        void s() {
            this.K = this.K.clone();
            this.L = this.L.clone();
        }

        @Override // androidx.appcompat.graphics.drawable.StateListDrawableCompat.StateListState, android.graphics.drawable.Drawable.ConstantState
        @NonNull
        public Drawable newDrawable(Resources resources) {
            return new AnimatedStateListDrawableCompat(this, resources);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class AnimatedVectorDrawableTransition extends Transition {

        /* renamed from: a  reason: collision with root package name */
        private final AnimatedVectorDrawableCompat f1349a;

        AnimatedVectorDrawableTransition(AnimatedVectorDrawableCompat animatedVectorDrawableCompat) {
            super();
            this.f1349a = animatedVectorDrawableCompat;
        }

        @Override // androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat.Transition
        public void c() {
            this.f1349a.start();
        }

        @Override // androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat.Transition
        public void d() {
            this.f1349a.stop();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class AnimationDrawableTransition extends Transition {

        /* renamed from: a  reason: collision with root package name */
        private final ObjectAnimator f1350a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean f1351b;

        AnimationDrawableTransition(AnimationDrawable animationDrawable, boolean z7, boolean z8) {
            super();
            int i8;
            int i9;
            int numberOfFrames = animationDrawable.getNumberOfFrames();
            if (z7) {
                i8 = numberOfFrames - 1;
            } else {
                i8 = 0;
            }
            if (z7) {
                i9 = 0;
            } else {
                i9 = numberOfFrames - 1;
            }
            FrameInterpolator frameInterpolator = new FrameInterpolator(animationDrawable, z7);
            ObjectAnimator ofInt = ObjectAnimator.ofInt(animationDrawable, "currentIndex", i8, i9);
            Compatibility$Api18Impl.a(ofInt, true);
            ofInt.setDuration(frameInterpolator.a());
            ofInt.setInterpolator(frameInterpolator);
            this.f1351b = z8;
            this.f1350a = ofInt;
        }

        @Override // androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat.Transition
        public boolean a() {
            return this.f1351b;
        }

        @Override // androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat.Transition
        public void b() {
            this.f1350a.reverse();
        }

        @Override // androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat.Transition
        public void c() {
            this.f1350a.start();
        }

        @Override // androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat.Transition
        public void d() {
            this.f1350a.cancel();
        }
    }

    /* loaded from: classes.dex */
    private static class FrameInterpolator implements TimeInterpolator {

        /* renamed from: a  reason: collision with root package name */
        private int[] f1352a;

        /* renamed from: b  reason: collision with root package name */
        private int f1353b;

        /* renamed from: c  reason: collision with root package name */
        private int f1354c;

        FrameInterpolator(AnimationDrawable animationDrawable, boolean z7) {
            b(animationDrawable, z7);
        }

        int a() {
            return this.f1354c;
        }

        int b(AnimationDrawable animationDrawable, boolean z7) {
            int numberOfFrames = animationDrawable.getNumberOfFrames();
            this.f1353b = numberOfFrames;
            int[] iArr = this.f1352a;
            if (iArr == null || iArr.length < numberOfFrames) {
                this.f1352a = new int[numberOfFrames];
            }
            int[] iArr2 = this.f1352a;
            int i8 = 0;
            for (int i9 = 0; i9 < numberOfFrames; i9++) {
                int duration = animationDrawable.getDuration(z7 ? (numberOfFrames - i9) - 1 : i9);
                iArr2[i9] = duration;
                i8 += duration;
            }
            this.f1354c = i8;
            return i8;
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f8) {
            float f9;
            int i8 = (int) ((f8 * this.f1354c) + 0.5f);
            int i9 = this.f1353b;
            int[] iArr = this.f1352a;
            int i10 = 0;
            while (i10 < i9) {
                int i11 = iArr[i10];
                if (i8 < i11) {
                    break;
                }
                i8 -= i11;
                i10++;
            }
            if (i10 < i9) {
                f9 = i8 / this.f1354c;
            } else {
                f9 = 0.0f;
            }
            return (i10 / i9) + f9;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static abstract class Transition {
        private Transition() {
        }

        public boolean a() {
            return false;
        }

        public void b() {
        }

        public abstract void c();

        public abstract void d();
    }

    public AnimatedStateListDrawableCompat() {
        this(null, null);
    }

    @NonNull
    public static AnimatedStateListDrawableCompat m(@NonNull Context context, @NonNull Resources resources, @NonNull XmlPullParser xmlPullParser, @NonNull AttributeSet attributeSet, Resources.Theme theme) throws IOException, XmlPullParserException {
        String name = xmlPullParser.getName();
        if (name.equals("animated-selector")) {
            AnimatedStateListDrawableCompat animatedStateListDrawableCompat = new AnimatedStateListDrawableCompat();
            animatedStateListDrawableCompat.n(context, resources, xmlPullParser, attributeSet, theme);
            return animatedStateListDrawableCompat;
        }
        throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": invalid animated-selector tag " + name);
    }

    private void o(@NonNull Context context, @NonNull Resources resources, @NonNull XmlPullParser xmlPullParser, @NonNull AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        int depth = xmlPullParser.getDepth() + 1;
        while (true) {
            int next = xmlPullParser.next();
            if (next != 1) {
                int depth2 = xmlPullParser.getDepth();
                if (depth2 >= depth || next != 3) {
                    if (next == 2 && depth2 <= depth) {
                        if (xmlPullParser.getName().equals("item")) {
                            q(context, resources, xmlPullParser, attributeSet, theme);
                        } else if (xmlPullParser.getName().equals("transition")) {
                            r(context, resources, xmlPullParser, attributeSet, theme);
                        }
                    }
                } else {
                    return;
                }
            } else {
                return;
            }
        }
    }

    private void p() {
        onStateChange(getState());
    }

    private int q(@NonNull Context context, @NonNull Resources resources, @NonNull XmlPullParser xmlPullParser, @NonNull AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        Drawable drawable;
        int next;
        TypedArray k8 = TypedArrayUtils.k(resources, theme, attributeSet, R$styleable.f1419h);
        int resourceId = k8.getResourceId(R$styleable.f1420i, 0);
        int resourceId2 = k8.getResourceId(R$styleable.f1421j, -1);
        if (resourceId2 > 0) {
            drawable = ResourceManagerInternal.h().j(context, resourceId2);
        } else {
            drawable = null;
        }
        k8.recycle();
        int[] k9 = k(attributeSet);
        if (drawable == null) {
            do {
                next = xmlPullParser.next();
            } while (next == 4);
            if (next == 2) {
                if (xmlPullParser.getName().equals("vector")) {
                    drawable = VectorDrawableCompat.c(resources, xmlPullParser, attributeSet, theme);
                } else {
                    drawable = Compatibility$Api21Impl.a(resources, xmlPullParser, attributeSet, theme);
                }
            } else {
                throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <item> tag requires a 'drawable' attribute or child tag defining a drawable");
            }
        }
        if (drawable != null) {
            return this.f1343t.C(k9, drawable, resourceId);
        }
        throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <item> tag requires a 'drawable' attribute or child tag defining a drawable");
    }

    private int r(@NonNull Context context, @NonNull Resources resources, @NonNull XmlPullParser xmlPullParser, @NonNull AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        Drawable drawable;
        int next;
        TypedArray k8 = TypedArrayUtils.k(resources, theme, attributeSet, R$styleable.f1422k);
        int resourceId = k8.getResourceId(R$styleable.f1425n, -1);
        int resourceId2 = k8.getResourceId(R$styleable.f1424m, -1);
        int resourceId3 = k8.getResourceId(R$styleable.f1423l, -1);
        if (resourceId3 > 0) {
            drawable = ResourceManagerInternal.h().j(context, resourceId3);
        } else {
            drawable = null;
        }
        boolean z7 = k8.getBoolean(R$styleable.f1426o, false);
        k8.recycle();
        if (drawable == null) {
            do {
                next = xmlPullParser.next();
            } while (next == 4);
            if (next == 2) {
                if (xmlPullParser.getName().equals("animated-vector")) {
                    drawable = AnimatedVectorDrawableCompat.b(context, resources, xmlPullParser, attributeSet, theme);
                } else {
                    drawable = Compatibility$Api21Impl.a(resources, xmlPullParser, attributeSet, theme);
                }
            } else {
                throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <transition> tag requires a 'drawable' attribute or child tag defining a drawable");
            }
        }
        if (drawable != null) {
            if (resourceId != -1 && resourceId2 != -1) {
                return this.f1343t.D(resourceId, resourceId2, drawable, z7);
            }
            throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <transition> tag requires 'fromId' & 'toId' attributes");
        }
        throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <transition> tag requires a 'drawable' attribute or child tag defining a drawable");
    }

    private boolean s(int i8) {
        int c8;
        int H;
        Transition animatableTransition;
        Transition transition = this.f1344u;
        if (transition != null) {
            if (i8 == this.f1345v) {
                return true;
            }
            if (i8 == this.f1346w && transition.a()) {
                transition.b();
                this.f1345v = this.f1346w;
                this.f1346w = i8;
                return true;
            }
            c8 = this.f1345v;
            transition.d();
        } else {
            c8 = c();
        }
        this.f1344u = null;
        this.f1346w = -1;
        this.f1345v = -1;
        AnimatedStateListState animatedStateListState = this.f1343t;
        int F = animatedStateListState.F(c8);
        int F2 = animatedStateListState.F(i8);
        if (F2 == 0 || F == 0 || (H = animatedStateListState.H(F, F2)) < 0) {
            return false;
        }
        boolean J = animatedStateListState.J(F, F2);
        g(H);
        Drawable current = getCurrent();
        if (current instanceof AnimationDrawable) {
            animatableTransition = new AnimationDrawableTransition((AnimationDrawable) current, animatedStateListState.I(F, F2), J);
        } else if (current instanceof AnimatedVectorDrawableCompat) {
            animatableTransition = new AnimatedVectorDrawableTransition((AnimatedVectorDrawableCompat) current);
        } else {
            if (current instanceof Animatable) {
                animatableTransition = new AnimatableTransition((Animatable) current);
            }
            return false;
        }
        animatableTransition.c();
        this.f1344u = animatableTransition;
        this.f1346w = c8;
        this.f1345v = i8;
        return true;
    }

    private void t(TypedArray typedArray) {
        AnimatedStateListState animatedStateListState = this.f1343t;
        animatedStateListState.f1372d |= Compatibility$Api21Impl.b(typedArray);
        animatedStateListState.y(typedArray.getBoolean(R$styleable.f1415d, animatedStateListState.f1377i));
        animatedStateListState.u(typedArray.getBoolean(R$styleable.f1416e, animatedStateListState.f1380l));
        animatedStateListState.v(typedArray.getInt(R$styleable.f1417f, animatedStateListState.A));
        animatedStateListState.w(typedArray.getInt(R$styleable.f1418g, animatedStateListState.B));
        setDither(typedArray.getBoolean(R$styleable.f1413b, animatedStateListState.f1392x));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.appcompat.graphics.drawable.StateListDrawableCompat, androidx.appcompat.graphics.drawable.DrawableContainerCompat
    public void h(@NonNull DrawableContainerCompat.DrawableContainerState drawableContainerState) {
        super.h(drawableContainerState);
        if (drawableContainerState instanceof AnimatedStateListState) {
            this.f1343t = (AnimatedStateListState) drawableContainerState;
        }
    }

    @Override // androidx.appcompat.graphics.drawable.StateListDrawableCompat, androidx.appcompat.graphics.drawable.DrawableContainerCompat, android.graphics.drawable.Drawable
    public boolean isStateful() {
        return true;
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainerCompat, android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        super.jumpToCurrentState();
        Transition transition = this.f1344u;
        if (transition != null) {
            transition.d();
            this.f1344u = null;
            g(this.f1345v);
            this.f1345v = -1;
            this.f1346w = -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.appcompat.graphics.drawable.StateListDrawableCompat
    /* renamed from: l */
    public AnimatedStateListState j() {
        return new AnimatedStateListState(this.f1343t, this, null);
    }

    @Override // androidx.appcompat.graphics.drawable.StateListDrawableCompat, androidx.appcompat.graphics.drawable.DrawableContainerCompat, android.graphics.drawable.Drawable
    @NonNull
    public Drawable mutate() {
        if (!this.f1347x && super.mutate() == this) {
            this.f1343t.s();
            this.f1347x = true;
        }
        return this;
    }

    public void n(@NonNull Context context, @NonNull Resources resources, @NonNull XmlPullParser xmlPullParser, @NonNull AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        TypedArray k8 = TypedArrayUtils.k(resources, theme, attributeSet, R$styleable.f1412a);
        setVisible(k8.getBoolean(R$styleable.f1414c, true), true);
        t(k8);
        i(resources);
        k8.recycle();
        o(context, resources, xmlPullParser, attributeSet, theme);
        p();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.graphics.drawable.StateListDrawableCompat, androidx.appcompat.graphics.drawable.DrawableContainerCompat, android.graphics.drawable.Drawable
    public boolean onStateChange(@NonNull int[] iArr) {
        boolean z7;
        int G = this.f1343t.G(iArr);
        if (G != c() && (s(G) || g(G))) {
            z7 = true;
        } else {
            z7 = false;
        }
        Drawable current = getCurrent();
        if (current != null) {
            return z7 | current.setState(iArr);
        }
        return z7;
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainerCompat, android.graphics.drawable.Drawable
    public boolean setVisible(boolean z7, boolean z8) {
        boolean visible = super.setVisible(z7, z8);
        Transition transition = this.f1344u;
        if (transition != null && (visible || z8)) {
            if (z7) {
                transition.c();
            } else {
                jumpToCurrentState();
            }
        }
        return visible;
    }

    AnimatedStateListDrawableCompat(AnimatedStateListState animatedStateListState, Resources resources) {
        super(null);
        this.f1345v = -1;
        this.f1346w = -1;
        h(new AnimatedStateListState(animatedStateListState, this, resources));
        onStateChange(getState());
        jumpToCurrentState();
    }
}
