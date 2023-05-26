package com.airbnb.lottie;

import android.animation.Animator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatImageView;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.utils.Logger;
import com.airbnb.lottie.utils.Utils;
import com.airbnb.lottie.value.LottieValueCallback;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Callable;

/* loaded from: classes.dex */
public class LottieAnimationView extends AppCompatImageView {

    /* renamed from: t  reason: collision with root package name */
    private static final String f8852t = LottieAnimationView.class.getSimpleName();

    /* renamed from: u  reason: collision with root package name */
    private static final LottieListener<Throwable> f8853u = new LottieListener() { // from class: com.airbnb.lottie.c
        @Override // com.airbnb.lottie.LottieListener
        public final void onResult(Object obj) {
            LottieAnimationView.v((Throwable) obj);
        }
    };

    /* renamed from: f  reason: collision with root package name */
    private final LottieListener<LottieComposition> f8854f;

    /* renamed from: g  reason: collision with root package name */
    private final LottieListener<Throwable> f8855g;

    /* renamed from: h  reason: collision with root package name */
    private LottieListener<Throwable> f8856h;

    /* renamed from: i  reason: collision with root package name */
    private int f8857i;

    /* renamed from: j  reason: collision with root package name */
    private final LottieDrawable f8858j;

    /* renamed from: k  reason: collision with root package name */
    private String f8859k;

    /* renamed from: l  reason: collision with root package name */
    private int f8860l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f8861m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f8862n;

    /* renamed from: o  reason: collision with root package name */
    private boolean f8863o;

    /* renamed from: p  reason: collision with root package name */
    private final Set<UserActionTaken> f8864p;

    /* renamed from: q  reason: collision with root package name */
    private final Set<LottieOnCompositionLoadedListener> f8865q;

    /* renamed from: r  reason: collision with root package name */
    private LottieTask<LottieComposition> f8866r;

    /* renamed from: s  reason: collision with root package name */
    private LottieComposition f8867s;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.airbnb.lottie.LottieAnimationView.SavedState.1
            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b */
            public SavedState[] newArray(int i8) {
                return new SavedState[i8];
            }
        };

        /* renamed from: f  reason: collision with root package name */
        String f8869f;

        /* renamed from: g  reason: collision with root package name */
        int f8870g;

        /* renamed from: h  reason: collision with root package name */
        float f8871h;

        /* renamed from: i  reason: collision with root package name */
        boolean f8872i;

        /* renamed from: j  reason: collision with root package name */
        String f8873j;

        /* renamed from: k  reason: collision with root package name */
        int f8874k;

        /* renamed from: l  reason: collision with root package name */
        int f8875l;

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i8) {
            super.writeToParcel(parcel, i8);
            parcel.writeString(this.f8869f);
            parcel.writeFloat(this.f8871h);
            parcel.writeInt(this.f8872i ? 1 : 0);
            parcel.writeString(this.f8873j);
            parcel.writeInt(this.f8874k);
            parcel.writeInt(this.f8875l);
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.f8869f = parcel.readString();
            this.f8871h = parcel.readFloat();
            this.f8872i = parcel.readInt() == 1;
            this.f8873j = parcel.readString();
            this.f8874k = parcel.readInt();
            this.f8875l = parcel.readInt();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public enum UserActionTaken {
        SET_ANIMATION,
        SET_PROGRESS,
        SET_REPEAT_MODE,
        SET_REPEAT_COUNT,
        SET_IMAGE_ASSETS,
        PLAY_OPTION
    }

    public LottieAnimationView(Context context) {
        super(context);
        this.f8854f = new LottieListener() { // from class: com.airbnb.lottie.b
            @Override // com.airbnb.lottie.LottieListener
            public final void onResult(Object obj) {
                LottieAnimationView.this.setComposition((LottieComposition) obj);
            }
        };
        this.f8855g = new LottieListener<Throwable>() { // from class: com.airbnb.lottie.LottieAnimationView.1
            @Override // com.airbnb.lottie.LottieListener
            /* renamed from: a */
            public void onResult(Throwable th) {
                if (LottieAnimationView.this.f8857i != 0) {
                    LottieAnimationView lottieAnimationView = LottieAnimationView.this;
                    lottieAnimationView.setImageResource(lottieAnimationView.f8857i);
                }
                (LottieAnimationView.this.f8856h == null ? LottieAnimationView.f8853u : LottieAnimationView.this.f8856h).onResult(th);
            }
        };
        this.f8857i = 0;
        this.f8858j = new LottieDrawable();
        this.f8861m = false;
        this.f8862n = false;
        this.f8863o = true;
        this.f8864p = new HashSet();
        this.f8865q = new HashSet();
        r(null, R$attr.lottieAnimationViewStyle);
    }

    private void C() {
        boolean s7 = s();
        setImageDrawable(null);
        setImageDrawable(this.f8858j);
        if (s7) {
            this.f8858j.t0();
        }
    }

    private void m() {
        LottieTask<LottieComposition> lottieTask = this.f8866r;
        if (lottieTask != null) {
            lottieTask.j(this.f8854f);
            this.f8866r.i(this.f8855g);
        }
    }

    private void n() {
        this.f8867s = null;
        this.f8858j.u();
    }

    private LottieTask<LottieComposition> p(final String str) {
        if (isInEditMode()) {
            return new LottieTask<>(new Callable() { // from class: com.airbnb.lottie.d
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    LottieResult t7;
                    t7 = LottieAnimationView.this.t(str);
                    return t7;
                }
            }, true);
        }
        if (this.f8863o) {
            return LottieCompositionFactory.j(getContext(), str);
        }
        return LottieCompositionFactory.k(getContext(), str, null);
    }

    private LottieTask<LottieComposition> q(final int i8) {
        if (isInEditMode()) {
            return new LottieTask<>(new Callable() { // from class: com.airbnb.lottie.a
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    LottieResult u7;
                    u7 = LottieAnimationView.this.u(i8);
                    return u7;
                }
            }, true);
        }
        if (this.f8863o) {
            return LottieCompositionFactory.s(getContext(), i8);
        }
        return LottieCompositionFactory.t(getContext(), i8, null);
    }

    private void r(AttributeSet attributeSet, int i8) {
        String string;
        boolean z7 = false;
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.C, i8, 0);
        this.f8863o = obtainStyledAttributes.getBoolean(R$styleable.E, true);
        int i9 = R$styleable.O;
        boolean hasValue = obtainStyledAttributes.hasValue(i9);
        int i10 = R$styleable.J;
        boolean hasValue2 = obtainStyledAttributes.hasValue(i10);
        int i11 = R$styleable.T;
        boolean hasValue3 = obtainStyledAttributes.hasValue(i11);
        if (hasValue && hasValue2) {
            throw new IllegalArgumentException("lottie_rawRes and lottie_fileName cannot be used at the same time. Please use only one at once.");
        }
        if (hasValue) {
            int resourceId = obtainStyledAttributes.getResourceId(i9, 0);
            if (resourceId != 0) {
                setAnimation(resourceId);
            }
        } else if (hasValue2) {
            String string2 = obtainStyledAttributes.getString(i10);
            if (string2 != null) {
                setAnimation(string2);
            }
        } else if (hasValue3 && (string = obtainStyledAttributes.getString(i11)) != null) {
            setAnimationFromUrl(string);
        }
        setFallbackResource(obtainStyledAttributes.getResourceId(R$styleable.I, 0));
        if (obtainStyledAttributes.getBoolean(R$styleable.D, false)) {
            this.f8862n = true;
        }
        if (obtainStyledAttributes.getBoolean(R$styleable.M, false)) {
            this.f8858j.Q0(-1);
        }
        int i12 = R$styleable.R;
        if (obtainStyledAttributes.hasValue(i12)) {
            setRepeatMode(obtainStyledAttributes.getInt(i12, 1));
        }
        int i13 = R$styleable.Q;
        if (obtainStyledAttributes.hasValue(i13)) {
            setRepeatCount(obtainStyledAttributes.getInt(i13, -1));
        }
        int i14 = R$styleable.S;
        if (obtainStyledAttributes.hasValue(i14)) {
            setSpeed(obtainStyledAttributes.getFloat(i14, 1.0f));
        }
        int i15 = R$styleable.F;
        if (obtainStyledAttributes.hasValue(i15)) {
            setClipToCompositionBounds(obtainStyledAttributes.getBoolean(i15, true));
        }
        setImageAssetsFolder(obtainStyledAttributes.getString(R$styleable.L));
        setProgress(obtainStyledAttributes.getFloat(R$styleable.N, 0.0f));
        o(obtainStyledAttributes.getBoolean(R$styleable.H, false));
        int i16 = R$styleable.G;
        if (obtainStyledAttributes.hasValue(i16)) {
            k(new KeyPath("**"), LottieProperty.K, new LottieValueCallback(new SimpleColorFilter(AppCompatResources.a(getContext(), obtainStyledAttributes.getResourceId(i16, -1)).getDefaultColor())));
        }
        int i17 = R$styleable.P;
        if (obtainStyledAttributes.hasValue(i17)) {
            RenderMode renderMode = RenderMode.AUTOMATIC;
            int i18 = obtainStyledAttributes.getInt(i17, renderMode.ordinal());
            if (i18 >= RenderMode.values().length) {
                i18 = renderMode.ordinal();
            }
            setRenderMode(RenderMode.values()[i18]);
        }
        setIgnoreDisabledSystemAnimations(obtainStyledAttributes.getBoolean(R$styleable.K, false));
        obtainStyledAttributes.recycle();
        LottieDrawable lottieDrawable = this.f8858j;
        if (Utils.f(getContext()) != 0.0f) {
            z7 = true;
        }
        lottieDrawable.U0(Boolean.valueOf(z7));
    }

    private void setCompositionTask(LottieTask<LottieComposition> lottieTask) {
        this.f8864p.add(UserActionTaken.SET_ANIMATION);
        n();
        m();
        this.f8866r = lottieTask.d(this.f8854f).c(this.f8855g);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ LottieResult t(String str) throws Exception {
        if (this.f8863o) {
            return LottieCompositionFactory.l(getContext(), str);
        }
        return LottieCompositionFactory.m(getContext(), str, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ LottieResult u(int i8) throws Exception {
        if (this.f8863o) {
            return LottieCompositionFactory.u(getContext(), i8);
        }
        return LottieCompositionFactory.v(getContext(), i8, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void v(Throwable th) {
        if (Utils.k(th)) {
            Logger.d("Unable to load composition.", th);
            return;
        }
        throw new IllegalStateException("Unable to parse composition", th);
    }

    public void A(InputStream inputStream, String str) {
        setCompositionTask(LottieCompositionFactory.n(inputStream, str));
    }

    public void B(String str, String str2) {
        A(new ByteArrayInputStream(str.getBytes()), str2);
    }

    public boolean getClipToCompositionBounds() {
        return this.f8858j.F();
    }

    public LottieComposition getComposition() {
        return this.f8867s;
    }

    public long getDuration() {
        LottieComposition lottieComposition = this.f8867s;
        if (lottieComposition != null) {
            return lottieComposition.d();
        }
        return 0L;
    }

    public int getFrame() {
        return this.f8858j.J();
    }

    public String getImageAssetsFolder() {
        return this.f8858j.L();
    }

    public boolean getMaintainOriginalImageBounds() {
        return this.f8858j.N();
    }

    public float getMaxFrame() {
        return this.f8858j.O();
    }

    public float getMinFrame() {
        return this.f8858j.P();
    }

    public PerformanceTracker getPerformanceTracker() {
        return this.f8858j.Q();
    }

    public float getProgress() {
        return this.f8858j.R();
    }

    public RenderMode getRenderMode() {
        return this.f8858j.S();
    }

    public int getRepeatCount() {
        return this.f8858j.T();
    }

    public int getRepeatMode() {
        return this.f8858j.U();
    }

    public float getSpeed() {
        return this.f8858j.V();
    }

    public void i(Animator.AnimatorListener animatorListener) {
        this.f8858j.p(animatorListener);
    }

    @Override // android.view.View
    public void invalidate() {
        super.invalidate();
        Drawable drawable = getDrawable();
        if ((drawable instanceof LottieDrawable) && ((LottieDrawable) drawable).S() == RenderMode.SOFTWARE) {
            this.f8858j.invalidateSelf();
        }
    }

    @Override // android.widget.ImageView, android.view.View, android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(@NonNull Drawable drawable) {
        Drawable drawable2 = getDrawable();
        LottieDrawable lottieDrawable = this.f8858j;
        if (drawable2 == lottieDrawable) {
            super.invalidateDrawable(lottieDrawable);
        } else {
            super.invalidateDrawable(drawable);
        }
    }

    public boolean j(@NonNull LottieOnCompositionLoadedListener lottieOnCompositionLoadedListener) {
        LottieComposition lottieComposition = this.f8867s;
        if (lottieComposition != null) {
            lottieOnCompositionLoadedListener.a(lottieComposition);
        }
        return this.f8865q.add(lottieOnCompositionLoadedListener);
    }

    public <T> void k(KeyPath keyPath, T t7, LottieValueCallback<T> lottieValueCallback) {
        this.f8858j.q(keyPath, t7, lottieValueCallback);
    }

    public void l() {
        this.f8864p.add(UserActionTaken.PLAY_OPTION);
        this.f8858j.t();
    }

    public void o(boolean z7) {
        this.f8858j.z(z7);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (!isInEditMode() && this.f8862n) {
            this.f8858j.q0();
        }
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        int i8;
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.f8859k = savedState.f8869f;
        Set<UserActionTaken> set = this.f8864p;
        UserActionTaken userActionTaken = UserActionTaken.SET_ANIMATION;
        if (!set.contains(userActionTaken) && !TextUtils.isEmpty(this.f8859k)) {
            setAnimation(this.f8859k);
        }
        this.f8860l = savedState.f8870g;
        if (!this.f8864p.contains(userActionTaken) && (i8 = this.f8860l) != 0) {
            setAnimation(i8);
        }
        if (!this.f8864p.contains(UserActionTaken.SET_PROGRESS)) {
            setProgress(savedState.f8871h);
        }
        if (!this.f8864p.contains(UserActionTaken.PLAY_OPTION) && savedState.f8872i) {
            x();
        }
        if (!this.f8864p.contains(UserActionTaken.SET_IMAGE_ASSETS)) {
            setImageAssetsFolder(savedState.f8873j);
        }
        if (!this.f8864p.contains(UserActionTaken.SET_REPEAT_MODE)) {
            setRepeatMode(savedState.f8874k);
        }
        if (!this.f8864p.contains(UserActionTaken.SET_REPEAT_COUNT)) {
            setRepeatCount(savedState.f8875l);
        }
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f8869f = this.f8859k;
        savedState.f8870g = this.f8860l;
        savedState.f8871h = this.f8858j.R();
        savedState.f8872i = this.f8858j.a0();
        savedState.f8873j = this.f8858j.L();
        savedState.f8874k = this.f8858j.U();
        savedState.f8875l = this.f8858j.T();
        return savedState;
    }

    public boolean s() {
        return this.f8858j.Z();
    }

    public void setAnimation(int i8) {
        this.f8860l = i8;
        this.f8859k = null;
        setCompositionTask(q(i8));
    }

    @Deprecated
    public void setAnimationFromJson(String str) {
        B(str, null);
    }

    public void setAnimationFromUrl(String str) {
        LottieTask<LottieComposition> x7;
        if (this.f8863o) {
            x7 = LottieCompositionFactory.w(getContext(), str);
        } else {
            x7 = LottieCompositionFactory.x(getContext(), str, null);
        }
        setCompositionTask(x7);
    }

    public void setApplyingOpacityToLayersEnabled(boolean z7) {
        this.f8858j.v0(z7);
    }

    public void setCacheComposition(boolean z7) {
        this.f8863o = z7;
    }

    public void setClipToCompositionBounds(boolean z7) {
        this.f8858j.w0(z7);
    }

    public void setComposition(@NonNull LottieComposition lottieComposition) {
        if (L.f8841a) {
            String str = f8852t;
            Log.v(str, "Set Composition \n" + lottieComposition);
        }
        this.f8858j.setCallback(this);
        this.f8867s = lottieComposition;
        this.f8861m = true;
        boolean x02 = this.f8858j.x0(lottieComposition);
        this.f8861m = false;
        if (getDrawable() == this.f8858j && !x02) {
            return;
        }
        if (!x02) {
            C();
        }
        onVisibilityChanged(this, getVisibility());
        requestLayout();
        for (LottieOnCompositionLoadedListener lottieOnCompositionLoadedListener : this.f8865q) {
            lottieOnCompositionLoadedListener.a(lottieComposition);
        }
    }

    public void setFailureListener(LottieListener<Throwable> lottieListener) {
        this.f8856h = lottieListener;
    }

    public void setFallbackResource(int i8) {
        this.f8857i = i8;
    }

    public void setFontAssetDelegate(FontAssetDelegate fontAssetDelegate) {
        this.f8858j.y0(fontAssetDelegate);
    }

    public void setFrame(int i8) {
        this.f8858j.z0(i8);
    }

    public void setIgnoreDisabledSystemAnimations(boolean z7) {
        this.f8858j.A0(z7);
    }

    public void setImageAssetDelegate(ImageAssetDelegate imageAssetDelegate) {
        this.f8858j.B0(imageAssetDelegate);
    }

    public void setImageAssetsFolder(String str) {
        this.f8858j.C0(str);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        m();
        super.setImageBitmap(bitmap);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        m();
        super.setImageDrawable(drawable);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageResource(int i8) {
        m();
        super.setImageResource(i8);
    }

    public void setMaintainOriginalImageBounds(boolean z7) {
        this.f8858j.D0(z7);
    }

    public void setMaxFrame(int i8) {
        this.f8858j.E0(i8);
    }

    public void setMaxProgress(float f8) {
        this.f8858j.G0(f8);
    }

    public void setMinAndMaxFrame(String str) {
        this.f8858j.I0(str);
    }

    public void setMinFrame(int i8) {
        this.f8858j.J0(i8);
    }

    public void setMinProgress(float f8) {
        this.f8858j.L0(f8);
    }

    public void setOutlineMasksAndMattes(boolean z7) {
        this.f8858j.M0(z7);
    }

    public void setPerformanceTrackingEnabled(boolean z7) {
        this.f8858j.N0(z7);
    }

    public void setProgress(float f8) {
        this.f8864p.add(UserActionTaken.SET_PROGRESS);
        this.f8858j.O0(f8);
    }

    public void setRenderMode(RenderMode renderMode) {
        this.f8858j.P0(renderMode);
    }

    public void setRepeatCount(int i8) {
        this.f8864p.add(UserActionTaken.SET_REPEAT_COUNT);
        this.f8858j.Q0(i8);
    }

    public void setRepeatMode(int i8) {
        this.f8864p.add(UserActionTaken.SET_REPEAT_MODE);
        this.f8858j.R0(i8);
    }

    public void setSafeMode(boolean z7) {
        this.f8858j.S0(z7);
    }

    public void setSpeed(float f8) {
        this.f8858j.T0(f8);
    }

    public void setTextDelegate(TextDelegate textDelegate) {
        this.f8858j.V0(textDelegate);
    }

    @Override // android.view.View
    public void unscheduleDrawable(Drawable drawable) {
        LottieDrawable lottieDrawable;
        if (!this.f8861m && drawable == (lottieDrawable = this.f8858j) && lottieDrawable.Z()) {
            w();
        } else if (!this.f8861m && (drawable instanceof LottieDrawable)) {
            LottieDrawable lottieDrawable2 = (LottieDrawable) drawable;
            if (lottieDrawable2.Z()) {
                lottieDrawable2.p0();
            }
        }
        super.unscheduleDrawable(drawable);
    }

    public void w() {
        this.f8862n = false;
        this.f8858j.p0();
    }

    public void x() {
        this.f8864p.add(UserActionTaken.PLAY_OPTION);
        this.f8858j.q0();
    }

    public void y() {
        this.f8865q.clear();
    }

    public void z() {
        this.f8864p.add(UserActionTaken.PLAY_OPTION);
        this.f8858j.t0();
    }

    public void setMaxFrame(String str) {
        this.f8858j.F0(str);
    }

    public void setMinFrame(String str) {
        this.f8858j.K0(str);
    }

    public void setAnimation(String str) {
        this.f8859k = str;
        this.f8860l = 0;
        setCompositionTask(p(str));
    }

    public LottieAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f8854f = new LottieListener() { // from class: com.airbnb.lottie.b
            @Override // com.airbnb.lottie.LottieListener
            public final void onResult(Object obj) {
                LottieAnimationView.this.setComposition((LottieComposition) obj);
            }
        };
        this.f8855g = new LottieListener<Throwable>() { // from class: com.airbnb.lottie.LottieAnimationView.1
            @Override // com.airbnb.lottie.LottieListener
            /* renamed from: a */
            public void onResult(Throwable th) {
                if (LottieAnimationView.this.f8857i != 0) {
                    LottieAnimationView lottieAnimationView = LottieAnimationView.this;
                    lottieAnimationView.setImageResource(lottieAnimationView.f8857i);
                }
                (LottieAnimationView.this.f8856h == null ? LottieAnimationView.f8853u : LottieAnimationView.this.f8856h).onResult(th);
            }
        };
        this.f8857i = 0;
        this.f8858j = new LottieDrawable();
        this.f8861m = false;
        this.f8862n = false;
        this.f8863o = true;
        this.f8864p = new HashSet();
        this.f8865q = new HashSet();
        r(attributeSet, R$attr.lottieAnimationViewStyle);
    }

    public LottieAnimationView(Context context, AttributeSet attributeSet, int i8) {
        super(context, attributeSet, i8);
        this.f8854f = new LottieListener() { // from class: com.airbnb.lottie.b
            @Override // com.airbnb.lottie.LottieListener
            public final void onResult(Object obj) {
                LottieAnimationView.this.setComposition((LottieComposition) obj);
            }
        };
        this.f8855g = new LottieListener<Throwable>() { // from class: com.airbnb.lottie.LottieAnimationView.1
            @Override // com.airbnb.lottie.LottieListener
            /* renamed from: a */
            public void onResult(Throwable th) {
                if (LottieAnimationView.this.f8857i != 0) {
                    LottieAnimationView lottieAnimationView = LottieAnimationView.this;
                    lottieAnimationView.setImageResource(lottieAnimationView.f8857i);
                }
                (LottieAnimationView.this.f8856h == null ? LottieAnimationView.f8853u : LottieAnimationView.this.f8856h).onResult(th);
            }
        };
        this.f8857i = 0;
        this.f8858j = new LottieDrawable();
        this.f8861m = false;
        this.f8862n = false;
        this.f8863o = true;
        this.f8864p = new HashSet();
        this.f8865q = new HashSet();
        r(attributeSet, i8);
    }
}
