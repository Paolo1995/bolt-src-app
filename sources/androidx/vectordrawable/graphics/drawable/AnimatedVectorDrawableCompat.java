package androidx.vectordrawable.graphics.drawable;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import androidx.annotation.NonNull;
import androidx.collection.ArrayMap;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.graphics.drawable.DrawableCompat;
import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
public class AnimatedVectorDrawableCompat extends VectorDrawableCommon implements Animatable {

    /* renamed from: g  reason: collision with root package name */
    private AnimatedVectorDrawableCompatState f7928g;

    /* renamed from: h  reason: collision with root package name */
    private Context f7929h;

    /* renamed from: i  reason: collision with root package name */
    private android.animation.ArgbEvaluator f7930i;

    /* renamed from: j  reason: collision with root package name */
    AnimatedVectorDrawableDelegateState f7931j;

    /* renamed from: k  reason: collision with root package name */
    private Animator.AnimatorListener f7932k;

    /* renamed from: l  reason: collision with root package name */
    ArrayList<Animatable2Compat$AnimationCallback> f7933l;

    /* renamed from: m  reason: collision with root package name */
    final Drawable.Callback f7934m;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class AnimatedVectorDrawableCompatState extends Drawable.ConstantState {

        /* renamed from: a  reason: collision with root package name */
        int f7937a;

        /* renamed from: b  reason: collision with root package name */
        VectorDrawableCompat f7938b;

        /* renamed from: c  reason: collision with root package name */
        AnimatorSet f7939c;

        /* renamed from: d  reason: collision with root package name */
        ArrayList<Animator> f7940d;

        /* renamed from: e  reason: collision with root package name */
        ArrayMap<Animator, String> f7941e;

        public AnimatedVectorDrawableCompatState(Context context, AnimatedVectorDrawableCompatState animatedVectorDrawableCompatState, Drawable.Callback callback, Resources resources) {
            if (animatedVectorDrawableCompatState != null) {
                this.f7937a = animatedVectorDrawableCompatState.f7937a;
                VectorDrawableCompat vectorDrawableCompat = animatedVectorDrawableCompatState.f7938b;
                if (vectorDrawableCompat != null) {
                    Drawable.ConstantState constantState = vectorDrawableCompat.getConstantState();
                    if (resources != null) {
                        this.f7938b = (VectorDrawableCompat) constantState.newDrawable(resources);
                    } else {
                        this.f7938b = (VectorDrawableCompat) constantState.newDrawable();
                    }
                    VectorDrawableCompat vectorDrawableCompat2 = (VectorDrawableCompat) this.f7938b.mutate();
                    this.f7938b = vectorDrawableCompat2;
                    vectorDrawableCompat2.setCallback(callback);
                    this.f7938b.setBounds(animatedVectorDrawableCompatState.f7938b.getBounds());
                    this.f7938b.h(false);
                }
                ArrayList<Animator> arrayList = animatedVectorDrawableCompatState.f7940d;
                if (arrayList != null) {
                    int size = arrayList.size();
                    this.f7940d = new ArrayList<>(size);
                    this.f7941e = new ArrayMap<>(size);
                    for (int i8 = 0; i8 < size; i8++) {
                        Animator animator = animatedVectorDrawableCompatState.f7940d.get(i8);
                        Animator clone = animator.clone();
                        String str = animatedVectorDrawableCompatState.f7941e.get(animator);
                        clone.setTarget(this.f7938b.d(str));
                        this.f7940d.add(clone);
                        this.f7941e.put(clone, str);
                    }
                    a();
                }
            }
        }

        public void a() {
            if (this.f7939c == null) {
                this.f7939c = new AnimatorSet();
            }
            this.f7939c.playTogether(this.f7940d);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f7937a;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            throw new IllegalStateException("No constant state support for SDK < 24.");
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            throw new IllegalStateException("No constant state support for SDK < 24.");
        }
    }

    AnimatedVectorDrawableCompat() {
        this(null, null, null);
    }

    public static AnimatedVectorDrawableCompat a(@NonNull Context context, int i8) {
        int next;
        if (Build.VERSION.SDK_INT >= 24) {
            AnimatedVectorDrawableCompat animatedVectorDrawableCompat = new AnimatedVectorDrawableCompat(context);
            Drawable f8 = ResourcesCompat.f(context.getResources(), i8, context.getTheme());
            animatedVectorDrawableCompat.f7945f = f8;
            f8.setCallback(animatedVectorDrawableCompat.f7934m);
            animatedVectorDrawableCompat.f7931j = new AnimatedVectorDrawableDelegateState(animatedVectorDrawableCompat.f7945f.getConstantState());
            return animatedVectorDrawableCompat;
        }
        try {
            XmlResourceParser xml = context.getResources().getXml(i8);
            AttributeSet asAttributeSet = Xml.asAttributeSet(xml);
            while (true) {
                next = xml.next();
                if (next == 2 || next == 1) {
                    break;
                }
            }
            if (next == 2) {
                return b(context, context.getResources(), xml, asAttributeSet, context.getTheme());
            }
            throw new XmlPullParserException("No start tag found");
        } catch (IOException e8) {
            Log.e("AnimatedVDCompat", "parser error", e8);
            return null;
        } catch (XmlPullParserException e9) {
            Log.e("AnimatedVDCompat", "parser error", e9);
            return null;
        }
    }

    public static AnimatedVectorDrawableCompat b(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        AnimatedVectorDrawableCompat animatedVectorDrawableCompat = new AnimatedVectorDrawableCompat(context);
        animatedVectorDrawableCompat.inflate(resources, xmlPullParser, attributeSet, theme);
        return animatedVectorDrawableCompat;
    }

    private static void d(@NonNull AnimatedVectorDrawable animatedVectorDrawable, @NonNull Animatable2Compat$AnimationCallback animatable2Compat$AnimationCallback) {
        animatedVectorDrawable.registerAnimationCallback(animatable2Compat$AnimationCallback.a());
    }

    private void e() {
        Animator.AnimatorListener animatorListener = this.f7932k;
        if (animatorListener != null) {
            this.f7928g.f7939c.removeListener(animatorListener);
            this.f7932k = null;
        }
    }

    private void f(String str, Animator animator) {
        animator.setTarget(this.f7928g.f7938b.d(str));
        AnimatedVectorDrawableCompatState animatedVectorDrawableCompatState = this.f7928g;
        if (animatedVectorDrawableCompatState.f7940d == null) {
            animatedVectorDrawableCompatState.f7940d = new ArrayList<>();
            this.f7928g.f7941e = new ArrayMap<>();
        }
        this.f7928g.f7940d.add(animator);
        this.f7928g.f7941e.put(animator, str);
    }

    private static boolean h(AnimatedVectorDrawable animatedVectorDrawable, Animatable2Compat$AnimationCallback animatable2Compat$AnimationCallback) {
        boolean unregisterAnimationCallback;
        unregisterAnimationCallback = animatedVectorDrawable.unregisterAnimationCallback(animatable2Compat$AnimationCallback.a());
        return unregisterAnimationCallback;
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public void applyTheme(Resources.Theme theme) {
        Drawable drawable = this.f7945f;
        if (drawable != null) {
            DrawableCompat.a(drawable, theme);
        }
    }

    public void c(@NonNull Animatable2Compat$AnimationCallback animatable2Compat$AnimationCallback) {
        Drawable drawable = this.f7945f;
        if (drawable != null) {
            d((AnimatedVectorDrawable) drawable, animatable2Compat$AnimationCallback);
        } else if (animatable2Compat$AnimationCallback == null) {
        } else {
            if (this.f7933l == null) {
                this.f7933l = new ArrayList<>();
            }
            if (this.f7933l.contains(animatable2Compat$AnimationCallback)) {
                return;
            }
            this.f7933l.add(animatable2Compat$AnimationCallback);
            if (this.f7932k == null) {
                this.f7932k = new AnimatorListenerAdapter() { // from class: androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat.2
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        ArrayList arrayList = new ArrayList(AnimatedVectorDrawableCompat.this.f7933l);
                        int size = arrayList.size();
                        for (int i8 = 0; i8 < size; i8++) {
                            ((Animatable2Compat$AnimationCallback) arrayList.get(i8)).b(AnimatedVectorDrawableCompat.this);
                        }
                    }

                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                        ArrayList arrayList = new ArrayList(AnimatedVectorDrawableCompat.this.f7933l);
                        int size = arrayList.size();
                        for (int i8 = 0; i8 < size; i8++) {
                            ((Animatable2Compat$AnimationCallback) arrayList.get(i8)).c(AnimatedVectorDrawableCompat.this);
                        }
                    }
                };
            }
            this.f7928g.f7939c.addListener(this.f7932k);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean canApplyTheme() {
        Drawable drawable = this.f7945f;
        if (drawable != null) {
            return DrawableCompat.b(drawable);
        }
        return false;
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void clearColorFilter() {
        super.clearColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Drawable drawable = this.f7945f;
        if (drawable != null) {
            drawable.draw(canvas);
            return;
        }
        this.f7928g.f7938b.draw(canvas);
        if (this.f7928g.f7939c.isStarted()) {
            invalidateSelf();
        }
    }

    public boolean g(@NonNull Animatable2Compat$AnimationCallback animatable2Compat$AnimationCallback) {
        Drawable drawable = this.f7945f;
        if (drawable != null) {
            h((AnimatedVectorDrawable) drawable, animatable2Compat$AnimationCallback);
        }
        ArrayList<Animatable2Compat$AnimationCallback> arrayList = this.f7933l;
        if (arrayList != null && animatable2Compat$AnimationCallback != null) {
            boolean remove = arrayList.remove(animatable2Compat$AnimationCallback);
            if (this.f7933l.size() == 0) {
                e();
            }
            return remove;
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        Drawable drawable = this.f7945f;
        if (drawable != null) {
            return DrawableCompat.d(drawable);
        }
        return this.f7928g.f7938b.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        Drawable drawable = this.f7945f;
        if (drawable != null) {
            return drawable.getChangingConfigurations();
        }
        return super.getChangingConfigurations() | this.f7928g.f7937a;
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        Drawable drawable = this.f7945f;
        if (drawable != null) {
            return DrawableCompat.e(drawable);
        }
        return this.f7928g.f7938b.getColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        if (this.f7945f != null && Build.VERSION.SDK_INT >= 24) {
            return new AnimatedVectorDrawableDelegateState(this.f7945f.getConstantState());
        }
        return null;
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ Drawable getCurrent() {
        return super.getCurrent();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        Drawable drawable = this.f7945f;
        if (drawable != null) {
            return drawable.getIntrinsicHeight();
        }
        return this.f7928g.f7938b.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        Drawable drawable = this.f7945f;
        if (drawable != null) {
            return drawable.getIntrinsicWidth();
        }
        return this.f7928g.f7938b.getIntrinsicWidth();
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getMinimumHeight() {
        return super.getMinimumHeight();
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getMinimumWidth() {
        return super.getMinimumWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        Drawable drawable = this.f7945f;
        if (drawable != null) {
            return drawable.getOpacity();
        }
        return this.f7928g.f7938b.getOpacity();
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean getPadding(Rect rect) {
        return super.getPadding(rect);
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int[] getState() {
        return super.getState();
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ Region getTransparentRegion() {
        return super.getTransparentRegion();
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        Drawable drawable = this.f7945f;
        if (drawable != null) {
            DrawableCompat.g(drawable, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        int eventType = xmlPullParser.getEventType();
        int depth = xmlPullParser.getDepth() + 1;
        while (eventType != 1 && (xmlPullParser.getDepth() >= depth || eventType != 3)) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                if ("animated-vector".equals(name)) {
                    TypedArray k8 = TypedArrayUtils.k(resources, theme, attributeSet, AndroidResources.f7918e);
                    int resourceId = k8.getResourceId(0, 0);
                    if (resourceId != 0) {
                        VectorDrawableCompat b8 = VectorDrawableCompat.b(resources, resourceId, theme);
                        b8.h(false);
                        b8.setCallback(this.f7934m);
                        VectorDrawableCompat vectorDrawableCompat = this.f7928g.f7938b;
                        if (vectorDrawableCompat != null) {
                            vectorDrawableCompat.setCallback(null);
                        }
                        this.f7928g.f7938b = b8;
                    }
                    k8.recycle();
                } else if ("target".equals(name)) {
                    TypedArray obtainAttributes = resources.obtainAttributes(attributeSet, AndroidResources.f7919f);
                    String string = obtainAttributes.getString(0);
                    int resourceId2 = obtainAttributes.getResourceId(1, 0);
                    if (resourceId2 != 0) {
                        Context context = this.f7929h;
                        if (context != null) {
                            f(string, AnimatorInflaterCompat.i(context, resourceId2));
                        } else {
                            obtainAttributes.recycle();
                            throw new IllegalStateException("Context can't be null when inflating animators");
                        }
                    }
                    obtainAttributes.recycle();
                } else {
                    continue;
                }
            }
            eventType = xmlPullParser.next();
        }
        this.f7928g.a();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        Drawable drawable = this.f7945f;
        if (drawable != null) {
            return DrawableCompat.h(drawable);
        }
        return this.f7928g.f7938b.isAutoMirrored();
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        Drawable drawable = this.f7945f;
        if (drawable != null) {
            return ((AnimatedVectorDrawable) drawable).isRunning();
        }
        return this.f7928g.f7939c.isRunning();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        Drawable drawable = this.f7945f;
        if (drawable != null) {
            return drawable.isStateful();
        }
        return this.f7928g.f7938b.isStateful();
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void jumpToCurrentState() {
        super.jumpToCurrentState();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        Drawable drawable = this.f7945f;
        if (drawable != null) {
            drawable.mutate();
        }
        return this;
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        Drawable drawable = this.f7945f;
        if (drawable != null) {
            drawable.setBounds(rect);
        } else {
            this.f7928g.f7938b.setBounds(rect);
        }
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    protected boolean onLevelChange(int i8) {
        Drawable drawable = this.f7945f;
        if (drawable != null) {
            return drawable.setLevel(i8);
        }
        return this.f7928g.f7938b.setLevel(i8);
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        Drawable drawable = this.f7945f;
        if (drawable != null) {
            return drawable.setState(iArr);
        }
        return this.f7928g.f7938b.setState(iArr);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i8) {
        Drawable drawable = this.f7945f;
        if (drawable != null) {
            drawable.setAlpha(i8);
        } else {
            this.f7928g.f7938b.setAlpha(i8);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z7) {
        Drawable drawable = this.f7945f;
        if (drawable != null) {
            DrawableCompat.j(drawable, z7);
        } else {
            this.f7928g.f7938b.setAutoMirrored(z7);
        }
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setChangingConfigurations(int i8) {
        super.setChangingConfigurations(i8);
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setColorFilter(int i8, PorterDuff.Mode mode) {
        super.setColorFilter(i8, mode);
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setFilterBitmap(boolean z7) {
        super.setFilterBitmap(z7);
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspot(float f8, float f9) {
        super.setHotspot(f8, f9);
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspotBounds(int i8, int i9, int i10, int i11) {
        super.setHotspotBounds(i8, i9, i10, i11);
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean setState(int[] iArr) {
        return super.setState(iArr);
    }

    @Override // android.graphics.drawable.Drawable
    public void setTint(int i8) {
        Drawable drawable = this.f7945f;
        if (drawable != null) {
            DrawableCompat.n(drawable, i8);
        } else {
            this.f7928g.f7938b.setTint(i8);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        Drawable drawable = this.f7945f;
        if (drawable != null) {
            DrawableCompat.o(drawable, colorStateList);
        } else {
            this.f7928g.f7938b.setTintList(colorStateList);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.f7945f;
        if (drawable != null) {
            DrawableCompat.p(drawable, mode);
        } else {
            this.f7928g.f7938b.setTintMode(mode);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z7, boolean z8) {
        Drawable drawable = this.f7945f;
        if (drawable != null) {
            return drawable.setVisible(z7, z8);
        }
        this.f7928g.f7938b.setVisible(z7, z8);
        return super.setVisible(z7, z8);
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        Drawable drawable = this.f7945f;
        if (drawable != null) {
            ((AnimatedVectorDrawable) drawable).start();
        } else if (this.f7928g.f7939c.isStarted()) {
        } else {
            this.f7928g.f7939c.start();
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        Drawable drawable = this.f7945f;
        if (drawable != null) {
            ((AnimatedVectorDrawable) drawable).stop();
        } else {
            this.f7928g.f7939c.end();
        }
    }

    private AnimatedVectorDrawableCompat(Context context) {
        this(context, null, null);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.f7945f;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
        } else {
            this.f7928g.f7938b.setColorFilter(colorFilter);
        }
    }

    /* loaded from: classes.dex */
    private static class AnimatedVectorDrawableDelegateState extends Drawable.ConstantState {

        /* renamed from: a  reason: collision with root package name */
        private final Drawable.ConstantState f7942a;

        public AnimatedVectorDrawableDelegateState(Drawable.ConstantState constantState) {
            this.f7942a = constantState;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public boolean canApplyTheme() {
            return this.f7942a.canApplyTheme();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f7942a.getChangingConfigurations();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            AnimatedVectorDrawableCompat animatedVectorDrawableCompat = new AnimatedVectorDrawableCompat();
            Drawable newDrawable = this.f7942a.newDrawable();
            animatedVectorDrawableCompat.f7945f = newDrawable;
            newDrawable.setCallback(animatedVectorDrawableCompat.f7934m);
            return animatedVectorDrawableCompat;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            AnimatedVectorDrawableCompat animatedVectorDrawableCompat = new AnimatedVectorDrawableCompat();
            Drawable newDrawable = this.f7942a.newDrawable(resources);
            animatedVectorDrawableCompat.f7945f = newDrawable;
            newDrawable.setCallback(animatedVectorDrawableCompat.f7934m);
            return animatedVectorDrawableCompat;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources, Resources.Theme theme) {
            AnimatedVectorDrawableCompat animatedVectorDrawableCompat = new AnimatedVectorDrawableCompat();
            Drawable newDrawable = this.f7942a.newDrawable(resources, theme);
            animatedVectorDrawableCompat.f7945f = newDrawable;
            newDrawable.setCallback(animatedVectorDrawableCompat.f7934m);
            return animatedVectorDrawableCompat;
        }
    }

    private AnimatedVectorDrawableCompat(Context context, AnimatedVectorDrawableCompatState animatedVectorDrawableCompatState, Resources resources) {
        this.f7930i = null;
        this.f7932k = null;
        this.f7933l = null;
        Drawable.Callback callback = new Drawable.Callback() { // from class: androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat.1
            @Override // android.graphics.drawable.Drawable.Callback
            public void invalidateDrawable(Drawable drawable) {
                AnimatedVectorDrawableCompat.this.invalidateSelf();
            }

            @Override // android.graphics.drawable.Drawable.Callback
            public void scheduleDrawable(Drawable drawable, Runnable runnable, long j8) {
                AnimatedVectorDrawableCompat.this.scheduleSelf(runnable, j8);
            }

            @Override // android.graphics.drawable.Drawable.Callback
            public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
                AnimatedVectorDrawableCompat.this.unscheduleSelf(runnable);
            }
        };
        this.f7934m = callback;
        this.f7929h = context;
        if (animatedVectorDrawableCompatState != null) {
            this.f7928g = animatedVectorDrawableCompatState;
        } else {
            this.f7928g = new AnimatedVectorDrawableCompatState(context, animatedVectorDrawableCompatState, callback, resources);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        inflate(resources, xmlPullParser, attributeSet, null);
    }
}
