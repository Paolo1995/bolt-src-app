package androidx.appcompat.widget;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.InputFilter;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.Property;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CompoundButton;
import androidx.annotation.NonNull;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$string;
import androidx.appcompat.R$styleable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.text.AllCapsTransformationMethod;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.TextViewCompat;
import androidx.emoji2.text.EmojiCompat;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public class SwitchCompat extends CompoundButton {

    /* renamed from: a0  reason: collision with root package name */
    private static final Property<SwitchCompat, Float> f2164a0 = new Property<SwitchCompat, Float>(Float.class, "thumbPos") { // from class: androidx.appcompat.widget.SwitchCompat.1
        @Override // android.util.Property
        /* renamed from: a */
        public Float get(SwitchCompat switchCompat) {
            return Float.valueOf(switchCompat.E);
        }

        @Override // android.util.Property
        /* renamed from: b */
        public void set(SwitchCompat switchCompat, Float f8) {
            switchCompat.setThumbPosition(f8.floatValue());
        }
    };

    /* renamed from: b0  reason: collision with root package name */
    private static final int[] f2165b0 = {16842912};
    private float A;
    private float B;
    private VelocityTracker C;
    private int D;
    float E;
    private int F;
    private int G;
    private int H;
    private int I;
    private int J;
    private int K;
    private int L;
    private boolean M;
    private final TextPaint N;
    private ColorStateList O;
    private Layout P;
    private Layout Q;
    private TransformationMethod R;
    ObjectAnimator S;
    private final AppCompatTextHelper T;
    @NonNull
    private AppCompatEmojiTextHelper U;
    private EmojiCompatInitCallback V;
    private final Rect W;

    /* renamed from: f  reason: collision with root package name */
    private Drawable f2166f;

    /* renamed from: g  reason: collision with root package name */
    private ColorStateList f2167g;

    /* renamed from: h  reason: collision with root package name */
    private PorterDuff.Mode f2168h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f2169i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f2170j;

    /* renamed from: k  reason: collision with root package name */
    private Drawable f2171k;

    /* renamed from: l  reason: collision with root package name */
    private ColorStateList f2172l;

    /* renamed from: m  reason: collision with root package name */
    private PorterDuff.Mode f2173m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f2174n;

    /* renamed from: o  reason: collision with root package name */
    private boolean f2175o;

    /* renamed from: p  reason: collision with root package name */
    private int f2176p;

    /* renamed from: q  reason: collision with root package name */
    private int f2177q;

    /* renamed from: r  reason: collision with root package name */
    private int f2178r;

    /* renamed from: s  reason: collision with root package name */
    private boolean f2179s;

    /* renamed from: t  reason: collision with root package name */
    private CharSequence f2180t;

    /* renamed from: u  reason: collision with root package name */
    private CharSequence f2181u;

    /* renamed from: v  reason: collision with root package name */
    private CharSequence f2182v;

    /* renamed from: w  reason: collision with root package name */
    private CharSequence f2183w;

    /* renamed from: x  reason: collision with root package name */
    private boolean f2184x;

    /* renamed from: y  reason: collision with root package name */
    private int f2185y;

    /* renamed from: z  reason: collision with root package name */
    private int f2186z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class Api18Impl {
        private Api18Impl() {
        }

        static void a(ObjectAnimator objectAnimator, boolean z7) {
            objectAnimator.setAutoCancel(z7);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class EmojiCompatInitCallback extends EmojiCompat.InitCallback {

        /* renamed from: a  reason: collision with root package name */
        private final Reference<SwitchCompat> f2187a;

        EmojiCompatInitCallback(SwitchCompat switchCompat) {
            this.f2187a = new WeakReference(switchCompat);
        }

        @Override // androidx.emoji2.text.EmojiCompat.InitCallback
        public void a(Throwable th) {
            SwitchCompat switchCompat = this.f2187a.get();
            if (switchCompat != null) {
                switchCompat.j();
            }
        }

        @Override // androidx.emoji2.text.EmojiCompat.InitCallback
        public void b() {
            SwitchCompat switchCompat = this.f2187a.get();
            if (switchCompat != null) {
                switchCompat.j();
            }
        }
    }

    public SwitchCompat(@NonNull Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.L);
    }

    private void a(boolean z7) {
        float f8;
        if (z7) {
            f8 = 1.0f;
        } else {
            f8 = 0.0f;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, f2164a0, f8);
        this.S = ofFloat;
        ofFloat.setDuration(250L);
        Api18Impl.a(this.S, true);
        this.S.start();
    }

    private void b() {
        Drawable drawable = this.f2166f;
        if (drawable != null) {
            if (this.f2169i || this.f2170j) {
                Drawable mutate = DrawableCompat.r(drawable).mutate();
                this.f2166f = mutate;
                if (this.f2169i) {
                    DrawableCompat.o(mutate, this.f2167g);
                }
                if (this.f2170j) {
                    DrawableCompat.p(this.f2166f, this.f2168h);
                }
                if (this.f2166f.isStateful()) {
                    this.f2166f.setState(getDrawableState());
                }
            }
        }
    }

    private void c() {
        Drawable drawable = this.f2171k;
        if (drawable != null) {
            if (this.f2174n || this.f2175o) {
                Drawable mutate = DrawableCompat.r(drawable).mutate();
                this.f2171k = mutate;
                if (this.f2174n) {
                    DrawableCompat.o(mutate, this.f2172l);
                }
                if (this.f2175o) {
                    DrawableCompat.p(this.f2171k, this.f2173m);
                }
                if (this.f2171k.isStateful()) {
                    this.f2171k.setState(getDrawableState());
                }
            }
        }
    }

    private void d() {
        ObjectAnimator objectAnimator = this.S;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
    }

    private void e(MotionEvent motionEvent) {
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        obtain.setAction(3);
        super.onTouchEvent(obtain);
        obtain.recycle();
    }

    private static float f(float f8, float f9, float f10) {
        return f8 < f9 ? f9 : f8 > f10 ? f10 : f8;
    }

    private CharSequence g(CharSequence charSequence) {
        TransformationMethod f8 = getEmojiTextViewHelper().f(this.R);
        if (f8 != null) {
            return f8.getTransformation(charSequence, this);
        }
        return charSequence;
    }

    @NonNull
    private AppCompatEmojiTextHelper getEmojiTextViewHelper() {
        if (this.U == null) {
            this.U = new AppCompatEmojiTextHelper(this);
        }
        return this.U;
    }

    private boolean getTargetCheckedState() {
        if (this.E > 0.5f) {
            return true;
        }
        return false;
    }

    private int getThumbOffset() {
        float f8;
        if (ViewUtils.b(this)) {
            f8 = 1.0f - this.E;
        } else {
            f8 = this.E;
        }
        return (int) ((f8 * getThumbScrollRange()) + 0.5f);
    }

    private int getThumbScrollRange() {
        Rect rect;
        Drawable drawable = this.f2171k;
        if (drawable != null) {
            Rect rect2 = this.W;
            drawable.getPadding(rect2);
            Drawable drawable2 = this.f2166f;
            if (drawable2 != null) {
                rect = DrawableUtils.d(drawable2);
            } else {
                rect = DrawableUtils.f1970c;
            }
            return ((((this.F - this.H) - rect2.left) - rect2.right) - rect.left) - rect.right;
        }
        return 0;
    }

    private boolean h(float f8, float f9) {
        if (this.f2166f == null) {
            return false;
        }
        int thumbOffset = getThumbOffset();
        this.f2166f.getPadding(this.W);
        int i8 = this.J;
        int i9 = this.f2186z;
        int i10 = i8 - i9;
        int i11 = (this.I + thumbOffset) - i9;
        Rect rect = this.W;
        int i12 = this.H + i11 + rect.left + rect.right + i9;
        int i13 = this.L + i9;
        if (f8 <= i11 || f8 >= i12 || f9 <= i10 || f9 >= i13) {
            return false;
        }
        return true;
    }

    private Layout i(CharSequence charSequence) {
        int i8;
        TextPaint textPaint = this.N;
        if (charSequence != null) {
            i8 = (int) Math.ceil(Layout.getDesiredWidth(charSequence, textPaint));
        } else {
            i8 = 0;
        }
        return new StaticLayout(charSequence, textPaint, i8, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
    }

    private void k() {
        if (Build.VERSION.SDK_INT >= 30) {
            CharSequence charSequence = this.f2182v;
            if (charSequence == null) {
                charSequence = getResources().getString(R$string.f938b);
            }
            ViewCompat.L0(this, charSequence);
        }
    }

    private void l() {
        if (Build.VERSION.SDK_INT >= 30) {
            CharSequence charSequence = this.f2180t;
            if (charSequence == null) {
                charSequence = getResources().getString(R$string.f939c);
            }
            ViewCompat.L0(this, charSequence);
        }
    }

    private void o(int i8, int i9) {
        Typeface typeface;
        if (i8 != 1) {
            if (i8 != 2) {
                if (i8 != 3) {
                    typeface = null;
                } else {
                    typeface = Typeface.MONOSPACE;
                }
            } else {
                typeface = Typeface.SERIF;
            }
        } else {
            typeface = Typeface.SANS_SERIF;
        }
        n(typeface, i9);
    }

    private void p() {
        if (this.V == null && this.U.b() && EmojiCompat.h()) {
            EmojiCompat b8 = EmojiCompat.b();
            int d8 = b8.d();
            if (d8 == 3 || d8 == 0) {
                EmojiCompatInitCallback emojiCompatInitCallback = new EmojiCompatInitCallback(this);
                this.V = emojiCompatInitCallback;
                b8.s(emojiCompatInitCallback);
            }
        }
    }

    private void q(MotionEvent motionEvent) {
        boolean z7;
        this.f2185y = 0;
        boolean z8 = true;
        if (motionEvent.getAction() == 1 && isEnabled()) {
            z7 = true;
        } else {
            z7 = false;
        }
        boolean isChecked = isChecked();
        if (z7) {
            this.C.computeCurrentVelocity(1000);
            float xVelocity = this.C.getXVelocity();
            if (Math.abs(xVelocity) > this.D) {
                if (!ViewUtils.b(this) ? xVelocity <= 0.0f : xVelocity >= 0.0f) {
                    z8 = false;
                }
            } else {
                z8 = getTargetCheckedState();
            }
        } else {
            z8 = isChecked;
        }
        if (z8 != isChecked) {
            playSoundEffect(0);
        }
        setChecked(z8);
        e(motionEvent);
    }

    private void setTextOffInternal(CharSequence charSequence) {
        this.f2182v = charSequence;
        this.f2183w = g(charSequence);
        this.Q = null;
        if (this.f2184x) {
            p();
        }
    }

    private void setTextOnInternal(CharSequence charSequence) {
        this.f2180t = charSequence;
        this.f2181u = g(charSequence);
        this.P = null;
        if (this.f2184x) {
            p();
        }
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        Rect rect;
        int i8;
        int i9;
        Rect rect2 = this.W;
        int i10 = this.I;
        int i11 = this.J;
        int i12 = this.K;
        int i13 = this.L;
        int thumbOffset = getThumbOffset() + i10;
        Drawable drawable = this.f2166f;
        if (drawable != null) {
            rect = DrawableUtils.d(drawable);
        } else {
            rect = DrawableUtils.f1970c;
        }
        Drawable drawable2 = this.f2171k;
        if (drawable2 != null) {
            drawable2.getPadding(rect2);
            int i14 = rect2.left;
            thumbOffset += i14;
            if (rect != null) {
                int i15 = rect.left;
                if (i15 > i14) {
                    i10 += i15 - i14;
                }
                int i16 = rect.top;
                int i17 = rect2.top;
                if (i16 > i17) {
                    i8 = (i16 - i17) + i11;
                } else {
                    i8 = i11;
                }
                int i18 = rect.right;
                int i19 = rect2.right;
                if (i18 > i19) {
                    i12 -= i18 - i19;
                }
                int i20 = rect.bottom;
                int i21 = rect2.bottom;
                if (i20 > i21) {
                    i9 = i13 - (i20 - i21);
                    this.f2171k.setBounds(i10, i8, i12, i9);
                }
            } else {
                i8 = i11;
            }
            i9 = i13;
            this.f2171k.setBounds(i10, i8, i12, i9);
        }
        Drawable drawable3 = this.f2166f;
        if (drawable3 != null) {
            drawable3.getPadding(rect2);
            int i22 = thumbOffset - rect2.left;
            int i23 = thumbOffset + this.H + rect2.right;
            this.f2166f.setBounds(i22, i11, i23, i13);
            Drawable background = getBackground();
            if (background != null) {
                DrawableCompat.l(background, i22, i11, i23, i13);
            }
        }
        super.draw(canvas);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void drawableHotspotChanged(float f8, float f9) {
        super.drawableHotspotChanged(f8, f9);
        Drawable drawable = this.f2166f;
        if (drawable != null) {
            DrawableCompat.k(drawable, f8, f9);
        }
        Drawable drawable2 = this.f2171k;
        if (drawable2 != null) {
            DrawableCompat.k(drawable2, f8, f9);
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.f2166f;
        boolean z7 = false;
        if (drawable != null && drawable.isStateful()) {
            z7 = false | drawable.setState(drawableState);
        }
        Drawable drawable2 = this.f2171k;
        if (drawable2 != null && drawable2.isStateful()) {
            z7 |= drawable2.setState(drawableState);
        }
        if (z7) {
            invalidate();
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingLeft() {
        if (!ViewUtils.b(this)) {
            return super.getCompoundPaddingLeft();
        }
        int compoundPaddingLeft = super.getCompoundPaddingLeft() + this.F;
        if (!TextUtils.isEmpty(getText())) {
            return compoundPaddingLeft + this.f2178r;
        }
        return compoundPaddingLeft;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingRight() {
        if (ViewUtils.b(this)) {
            return super.getCompoundPaddingRight();
        }
        int compoundPaddingRight = super.getCompoundPaddingRight() + this.F;
        if (!TextUtils.isEmpty(getText())) {
            return compoundPaddingRight + this.f2178r;
        }
        return compoundPaddingRight;
    }

    @Override // android.widget.TextView
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return TextViewCompat.q(super.getCustomSelectionActionModeCallback());
    }

    public boolean getShowText() {
        return this.f2184x;
    }

    public boolean getSplitTrack() {
        return this.f2179s;
    }

    public int getSwitchMinWidth() {
        return this.f2177q;
    }

    public int getSwitchPadding() {
        return this.f2178r;
    }

    public CharSequence getTextOff() {
        return this.f2182v;
    }

    public CharSequence getTextOn() {
        return this.f2180t;
    }

    public Drawable getThumbDrawable() {
        return this.f2166f;
    }

    protected final float getThumbPosition() {
        return this.E;
    }

    public int getThumbTextPadding() {
        return this.f2176p;
    }

    public ColorStateList getThumbTintList() {
        return this.f2167g;
    }

    public PorterDuff.Mode getThumbTintMode() {
        return this.f2168h;
    }

    public Drawable getTrackDrawable() {
        return this.f2171k;
    }

    public ColorStateList getTrackTintList() {
        return this.f2172l;
    }

    public PorterDuff.Mode getTrackTintMode() {
        return this.f2173m;
    }

    void j() {
        setTextOnInternal(this.f2180t);
        setTextOffInternal(this.f2182v);
        requestLayout();
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f2166f;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
        Drawable drawable2 = this.f2171k;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
        }
        ObjectAnimator objectAnimator = this.S;
        if (objectAnimator != null && objectAnimator.isStarted()) {
            this.S.end();
            this.S = null;
        }
    }

    public void m(Context context, int i8) {
        TintTypedArray t7 = TintTypedArray.t(context, i8, R$styleable.S2);
        ColorStateList c8 = t7.c(R$styleable.W2);
        if (c8 != null) {
            this.O = c8;
        } else {
            this.O = getTextColors();
        }
        int f8 = t7.f(R$styleable.T2, 0);
        if (f8 != 0) {
            float f9 = f8;
            if (f9 != this.N.getTextSize()) {
                this.N.setTextSize(f9);
                requestLayout();
            }
        }
        o(t7.k(R$styleable.U2, -1), t7.k(R$styleable.V2, -1));
        if (t7.a(R$styleable.f975d3, false)) {
            this.R = new AllCapsTransformationMethod(getContext());
        } else {
            this.R = null;
        }
        setTextOnInternal(this.f2180t);
        setTextOffInternal(this.f2182v);
        t7.w();
    }

    public void n(Typeface typeface, int i8) {
        Typeface create;
        int i9;
        float f8 = 0.0f;
        boolean z7 = false;
        if (i8 > 0) {
            if (typeface == null) {
                create = Typeface.defaultFromStyle(i8);
            } else {
                create = Typeface.create(typeface, i8);
            }
            setSwitchTypeface(create);
            if (create != null) {
                i9 = create.getStyle();
            } else {
                i9 = 0;
            }
            int i10 = (~i9) & i8;
            TextPaint textPaint = this.N;
            if ((i10 & 1) != 0) {
                z7 = true;
            }
            textPaint.setFakeBoldText(z7);
            TextPaint textPaint2 = this.N;
            if ((i10 & 2) != 0) {
                f8 = -0.25f;
            }
            textPaint2.setTextSkewX(f8);
            return;
        }
        this.N.setFakeBoldText(false);
        this.N.setTextSkewX(0.0f);
        setSwitchTypeface(typeface);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected int[] onCreateDrawableState(int i8) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i8 + 1);
        if (isChecked()) {
            View.mergeDrawableStates(onCreateDrawableState, f2165b0);
        }
        return onCreateDrawableState;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        Layout layout;
        int width;
        super.onDraw(canvas);
        Rect rect = this.W;
        Drawable drawable = this.f2171k;
        if (drawable != null) {
            drawable.getPadding(rect);
        } else {
            rect.setEmpty();
        }
        int i8 = this.J;
        int i9 = this.L;
        int i10 = i8 + rect.top;
        int i11 = i9 - rect.bottom;
        Drawable drawable2 = this.f2166f;
        if (drawable != null) {
            if (this.f2179s && drawable2 != null) {
                Rect d8 = DrawableUtils.d(drawable2);
                drawable2.copyBounds(rect);
                rect.left += d8.left;
                rect.right -= d8.right;
                int save = canvas.save();
                canvas.clipRect(rect, Region.Op.DIFFERENCE);
                drawable.draw(canvas);
                canvas.restoreToCount(save);
            } else {
                drawable.draw(canvas);
            }
        }
        int save2 = canvas.save();
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
        if (getTargetCheckedState()) {
            layout = this.P;
        } else {
            layout = this.Q;
        }
        if (layout != null) {
            int[] drawableState = getDrawableState();
            ColorStateList colorStateList = this.O;
            if (colorStateList != null) {
                this.N.setColor(colorStateList.getColorForState(drawableState, 0));
            }
            this.N.drawableState = drawableState;
            if (drawable2 != null) {
                Rect bounds = drawable2.getBounds();
                width = bounds.left + bounds.right;
            } else {
                width = getWidth();
            }
            canvas.translate((width / 2) - (layout.getWidth() / 2), ((i10 + i11) / 2) - (layout.getHeight() / 2));
            layout.draw(canvas);
        }
        canvas.restoreToCount(save2);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName("android.widget.Switch");
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        CharSequence charSequence;
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("android.widget.Switch");
        if (Build.VERSION.SDK_INT < 30) {
            if (isChecked()) {
                charSequence = this.f2180t;
            } else {
                charSequence = this.f2182v;
            }
            if (!TextUtils.isEmpty(charSequence)) {
                CharSequence text = accessibilityNodeInfo.getText();
                if (TextUtils.isEmpty(text)) {
                    accessibilityNodeInfo.setText(charSequence);
                    return;
                }
                StringBuilder sb = new StringBuilder();
                sb.append(text);
                sb.append(' ');
                sb.append(charSequence);
                accessibilityNodeInfo.setText(sb);
            }
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean z7, int i8, int i9, int i10, int i11) {
        int i12;
        int width;
        int i13;
        int i14;
        int paddingTop;
        int i15;
        super.onLayout(z7, i8, i9, i10, i11);
        int i16 = 0;
        if (this.f2166f != null) {
            Rect rect = this.W;
            Drawable drawable = this.f2171k;
            if (drawable != null) {
                drawable.getPadding(rect);
            } else {
                rect.setEmpty();
            }
            Rect d8 = DrawableUtils.d(this.f2166f);
            i12 = Math.max(0, d8.left - rect.left);
            i16 = Math.max(0, d8.right - rect.right);
        } else {
            i12 = 0;
        }
        if (ViewUtils.b(this)) {
            i13 = getPaddingLeft() + i12;
            width = ((this.F + i13) - i12) - i16;
        } else {
            width = (getWidth() - getPaddingRight()) - i16;
            i13 = (width - this.F) + i12 + i16;
        }
        int gravity = getGravity() & 112;
        if (gravity != 16) {
            if (gravity != 80) {
                paddingTop = getPaddingTop();
                i14 = this.G;
            } else {
                i15 = getHeight() - getPaddingBottom();
                paddingTop = i15 - this.G;
                this.I = i13;
                this.J = paddingTop;
                this.L = i15;
                this.K = width;
            }
        } else {
            i14 = this.G;
            paddingTop = (((getPaddingTop() + getHeight()) - getPaddingBottom()) / 2) - (i14 / 2);
        }
        i15 = i14 + paddingTop;
        this.I = i13;
        this.J = paddingTop;
        this.L = i15;
        this.K = width;
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int i8, int i9) {
        int i10;
        int i11;
        int i12;
        int i13;
        if (this.f2184x) {
            if (this.P == null) {
                this.P = i(this.f2181u);
            }
            if (this.Q == null) {
                this.Q = i(this.f2183w);
            }
        }
        Rect rect = this.W;
        Drawable drawable = this.f2166f;
        int i14 = 0;
        if (drawable != null) {
            drawable.getPadding(rect);
            i10 = (this.f2166f.getIntrinsicWidth() - rect.left) - rect.right;
            i11 = this.f2166f.getIntrinsicHeight();
        } else {
            i10 = 0;
            i11 = 0;
        }
        if (this.f2184x) {
            i12 = Math.max(this.P.getWidth(), this.Q.getWidth()) + (this.f2176p * 2);
        } else {
            i12 = 0;
        }
        this.H = Math.max(i12, i10);
        Drawable drawable2 = this.f2171k;
        if (drawable2 != null) {
            drawable2.getPadding(rect);
            i14 = this.f2171k.getIntrinsicHeight();
        } else {
            rect.setEmpty();
        }
        int i15 = rect.left;
        int i16 = rect.right;
        Drawable drawable3 = this.f2166f;
        if (drawable3 != null) {
            Rect d8 = DrawableUtils.d(drawable3);
            i15 = Math.max(i15, d8.left);
            i16 = Math.max(i16, d8.right);
        }
        if (this.M) {
            i13 = Math.max(this.f2177q, (this.H * 2) + i15 + i16);
        } else {
            i13 = this.f2177q;
        }
        int max = Math.max(i14, i11);
        this.F = i13;
        this.G = max;
        super.onMeasure(i8, i9);
        if (getMeasuredHeight() < max) {
            setMeasuredDimension(getMeasuredWidthAndState(), max);
        }
    }

    @Override // android.view.View
    public void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        CharSequence charSequence;
        super.onPopulateAccessibilityEvent(accessibilityEvent);
        if (isChecked()) {
            charSequence = this.f2180t;
        } else {
            charSequence = this.f2182v;
        }
        if (charSequence != null) {
            accessibilityEvent.getText().add(charSequence);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0012, code lost:
        if (r0 != 3) goto L8;
     */
    @Override // android.widget.TextView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouchEvent(android.view.MotionEvent r7) {
        /*
            r6 = this;
            android.view.VelocityTracker r0 = r6.C
            r0.addMovement(r7)
            int r0 = r7.getActionMasked()
            r1 = 1
            if (r0 == 0) goto L9f
            r2 = 2
            if (r0 == r1) goto L8b
            if (r0 == r2) goto L16
            r3 = 3
            if (r0 == r3) goto L8b
            goto Lb9
        L16:
            int r0 = r6.f2185y
            if (r0 == r1) goto L57
            if (r0 == r2) goto L1e
            goto Lb9
        L1e:
            float r7 = r7.getX()
            int r0 = r6.getThumbScrollRange()
            float r2 = r6.A
            float r2 = r7 - r2
            r3 = 1065353216(0x3f800000, float:1.0)
            r4 = 0
            if (r0 == 0) goto L32
            float r0 = (float) r0
            float r2 = r2 / r0
            goto L3d
        L32:
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 <= 0) goto L39
            r2 = 1065353216(0x3f800000, float:1.0)
            goto L3d
        L39:
            r0 = -1082130432(0xffffffffbf800000, float:-1.0)
            r2 = -1082130432(0xffffffffbf800000, float:-1.0)
        L3d:
            boolean r0 = androidx.appcompat.widget.ViewUtils.b(r6)
            if (r0 == 0) goto L44
            float r2 = -r2
        L44:
            float r0 = r6.E
            float r0 = r0 + r2
            float r0 = f(r0, r4, r3)
            float r2 = r6.E
            int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r2 == 0) goto L56
            r6.A = r7
            r6.setThumbPosition(r0)
        L56:
            return r1
        L57:
            float r0 = r7.getX()
            float r3 = r7.getY()
            float r4 = r6.A
            float r4 = r0 - r4
            float r4 = java.lang.Math.abs(r4)
            int r5 = r6.f2186z
            float r5 = (float) r5
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 > 0) goto L7d
            float r4 = r6.B
            float r4 = r3 - r4
            float r4 = java.lang.Math.abs(r4)
            int r5 = r6.f2186z
            float r5 = (float) r5
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 <= 0) goto Lb9
        L7d:
            r6.f2185y = r2
            android.view.ViewParent r7 = r6.getParent()
            r7.requestDisallowInterceptTouchEvent(r1)
            r6.A = r0
            r6.B = r3
            return r1
        L8b:
            int r0 = r6.f2185y
            if (r0 != r2) goto L96
            r6.q(r7)
            super.onTouchEvent(r7)
            return r1
        L96:
            r0 = 0
            r6.f2185y = r0
            android.view.VelocityTracker r0 = r6.C
            r0.clear()
            goto Lb9
        L9f:
            float r0 = r7.getX()
            float r2 = r7.getY()
            boolean r3 = r6.isEnabled()
            if (r3 == 0) goto Lb9
            boolean r3 = r6.h(r0, r2)
            if (r3 == 0) goto Lb9
            r6.f2185y = r1
            r6.A = r0
            r6.B = r2
        Lb9:
            boolean r7 = super.onTouchEvent(r7)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.SwitchCompat.onTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean z7) {
        super.setAllCaps(z7);
        getEmojiTextViewHelper().d(z7);
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z7) {
        float f8;
        super.setChecked(z7);
        boolean isChecked = isChecked();
        if (isChecked) {
            l();
        } else {
            k();
        }
        if (getWindowToken() != null && ViewCompat.W(this)) {
            a(isChecked);
            return;
        }
        d();
        if (isChecked) {
            f8 = 1.0f;
        } else {
            f8 = 0.0f;
        }
        setThumbPosition(f8);
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(TextViewCompat.r(this, callback));
    }

    public void setEmojiCompatEnabled(boolean z7) {
        getEmojiTextViewHelper().e(z7);
        setTextOnInternal(this.f2180t);
        setTextOffInternal(this.f2182v);
        requestLayout();
    }

    protected final void setEnforceSwitchWidth(boolean z7) {
        this.M = z7;
        invalidate();
    }

    @Override // android.widget.TextView
    public void setFilters(@NonNull InputFilter[] inputFilterArr) {
        super.setFilters(getEmojiTextViewHelper().a(inputFilterArr));
    }

    public void setShowText(boolean z7) {
        if (this.f2184x != z7) {
            this.f2184x = z7;
            requestLayout();
            if (z7) {
                p();
            }
        }
    }

    public void setSplitTrack(boolean z7) {
        this.f2179s = z7;
        invalidate();
    }

    public void setSwitchMinWidth(int i8) {
        this.f2177q = i8;
        requestLayout();
    }

    public void setSwitchPadding(int i8) {
        this.f2178r = i8;
        requestLayout();
    }

    public void setSwitchTypeface(Typeface typeface) {
        if ((this.N.getTypeface() != null && !this.N.getTypeface().equals(typeface)) || (this.N.getTypeface() == null && typeface != null)) {
            this.N.setTypeface(typeface);
            requestLayout();
            invalidate();
        }
    }

    public void setTextOff(CharSequence charSequence) {
        setTextOffInternal(charSequence);
        requestLayout();
        if (!isChecked()) {
            k();
        }
    }

    public void setTextOn(CharSequence charSequence) {
        setTextOnInternal(charSequence);
        requestLayout();
        if (isChecked()) {
            l();
        }
    }

    public void setThumbDrawable(Drawable drawable) {
        Drawable drawable2 = this.f2166f;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.f2166f = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        requestLayout();
    }

    void setThumbPosition(float f8) {
        this.E = f8;
        invalidate();
    }

    public void setThumbResource(int i8) {
        setThumbDrawable(AppCompatResources.b(getContext(), i8));
    }

    public void setThumbTextPadding(int i8) {
        this.f2176p = i8;
        requestLayout();
    }

    public void setThumbTintList(ColorStateList colorStateList) {
        this.f2167g = colorStateList;
        this.f2169i = true;
        b();
    }

    public void setThumbTintMode(PorterDuff.Mode mode) {
        this.f2168h = mode;
        this.f2170j = true;
        b();
    }

    public void setTrackDrawable(Drawable drawable) {
        Drawable drawable2 = this.f2171k;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.f2171k = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        requestLayout();
    }

    public void setTrackResource(int i8) {
        setTrackDrawable(AppCompatResources.b(getContext(), i8));
    }

    public void setTrackTintList(ColorStateList colorStateList) {
        this.f2172l = colorStateList;
        this.f2174n = true;
        c();
    }

    public void setTrackTintMode(PorterDuff.Mode mode) {
        this.f2173m = mode;
        this.f2175o = true;
        c();
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void toggle() {
        setChecked(!isChecked());
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        if (!super.verifyDrawable(drawable) && drawable != this.f2166f && drawable != this.f2171k) {
            return false;
        }
        return true;
    }

    public SwitchCompat(@NonNull Context context, AttributeSet attributeSet, int i8) {
        super(context, attributeSet, i8);
        this.f2167g = null;
        this.f2168h = null;
        this.f2169i = false;
        this.f2170j = false;
        this.f2172l = null;
        this.f2173m = null;
        this.f2174n = false;
        this.f2175o = false;
        this.C = VelocityTracker.obtain();
        this.M = true;
        this.W = new Rect();
        ThemeUtils.a(this, getContext());
        TextPaint textPaint = new TextPaint(1);
        this.N = textPaint;
        textPaint.density = getResources().getDisplayMetrics().density;
        int[] iArr = R$styleable.D2;
        TintTypedArray v7 = TintTypedArray.v(context, attributeSet, iArr, i8, 0);
        ViewCompat.q0(this, context, iArr, attributeSet, v7.r(), i8, 0);
        Drawable g8 = v7.g(R$styleable.G2);
        this.f2166f = g8;
        if (g8 != null) {
            g8.setCallback(this);
        }
        Drawable g9 = v7.g(R$styleable.P2);
        this.f2171k = g9;
        if (g9 != null) {
            g9.setCallback(this);
        }
        setTextOnInternal(v7.p(R$styleable.E2));
        setTextOffInternal(v7.p(R$styleable.F2));
        this.f2184x = v7.a(R$styleable.H2, true);
        this.f2176p = v7.f(R$styleable.M2, 0);
        this.f2177q = v7.f(R$styleable.J2, 0);
        this.f2178r = v7.f(R$styleable.K2, 0);
        this.f2179s = v7.a(R$styleable.I2, false);
        ColorStateList c8 = v7.c(R$styleable.N2);
        if (c8 != null) {
            this.f2167g = c8;
            this.f2169i = true;
        }
        PorterDuff.Mode e8 = DrawableUtils.e(v7.k(R$styleable.O2, -1), null);
        if (this.f2168h != e8) {
            this.f2168h = e8;
            this.f2170j = true;
        }
        if (this.f2169i || this.f2170j) {
            b();
        }
        ColorStateList c9 = v7.c(R$styleable.Q2);
        if (c9 != null) {
            this.f2172l = c9;
            this.f2174n = true;
        }
        PorterDuff.Mode e9 = DrawableUtils.e(v7.k(R$styleable.R2, -1), null);
        if (this.f2173m != e9) {
            this.f2173m = e9;
            this.f2175o = true;
        }
        if (this.f2174n || this.f2175o) {
            c();
        }
        int n8 = v7.n(R$styleable.L2, 0);
        if (n8 != 0) {
            m(context, n8);
        }
        AppCompatTextHelper appCompatTextHelper = new AppCompatTextHelper(this);
        this.T = appCompatTextHelper;
        appCompatTextHelper.m(attributeSet, i8);
        v7.w();
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f2186z = viewConfiguration.getScaledTouchSlop();
        this.D = viewConfiguration.getScaledMinimumFlingVelocity();
        getEmojiTextViewHelper().c(attributeSet, i8);
        refreshDrawableState();
        setChecked(isChecked());
    }
}
