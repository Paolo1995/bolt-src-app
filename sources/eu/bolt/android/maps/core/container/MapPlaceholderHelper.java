package eu.bolt.android.maps.core.container;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.view.ViewGroup;
import android.view.ViewGroupOverlay;
import androidx.core.content.ContextCompat;
import eu.bolt.android.maps.core.R$drawable;
import eu.bolt.android.maps.core.container.MapPlaceholderHelper;
import eu.bolt.android.maps.core.plugin.driver.MapStyle;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MapPlaceholderHelper.kt */
/* loaded from: classes5.dex */
public final class MapPlaceholderHelper {

    /* renamed from: a  reason: collision with root package name */
    private final ViewGroup f36953a;

    /* renamed from: b  reason: collision with root package name */
    private Drawable f36954b;

    /* compiled from: MapPlaceholderHelper.kt */
    /* loaded from: classes5.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f36955a;

        static {
            int[] iArr = new int[MapStyle.values().length];
            try {
                iArr[MapStyle.LIGHT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[MapStyle.DARK.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f36955a = iArr;
        }
    }

    public MapPlaceholderHelper(ViewGroup view) {
        Intrinsics.f(view, "view");
        this.f36953a = view;
    }

    private final TileDrawable c(Context context, MapStyle mapStyle) {
        int i8 = WhenMappings.f36955a[mapStyle.ordinal()];
        if (i8 != 1) {
            if (i8 == 2) {
                return e(this, context, R$drawable.map_placeholder_dark, null, 4, null);
            }
            throw new NoWhenBranchMatchedException();
        }
        return e(this, context, R$drawable.map_placeholder, null, 4, null);
    }

    private final TileDrawable d(Context context, int i8, Shader.TileMode tileMode) {
        Drawable drawable = ContextCompat.getDrawable(context, i8);
        if (drawable != null) {
            return new TileDrawable(drawable, tileMode);
        }
        return null;
    }

    static /* synthetic */ TileDrawable e(MapPlaceholderHelper mapPlaceholderHelper, Context context, int i8, Shader.TileMode tileMode, int i9, Object obj) {
        if ((i9 & 4) != 0) {
            tileMode = Shader.TileMode.REPEAT;
        }
        return mapPlaceholderHelper.d(context, i8, tileMode);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(MapPlaceholderHelper this$0, ValueAnimator it) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(it, "it");
        Drawable drawable = this$0.f36954b;
        if (drawable != null) {
            Object animatedValue = it.getAnimatedValue();
            Intrinsics.d(animatedValue, "null cannot be cast to non-null type kotlin.Int");
            drawable.setAlpha(((Integer) animatedValue).intValue());
        }
        Drawable drawable2 = this$0.f36954b;
        if (drawable2 != null) {
            drawable2.invalidateSelf();
        }
    }

    public final void f() {
        ValueAnimator ofInt = ValueAnimator.ofInt(255, 0);
        ofInt.setDuration(400L);
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: f6.a
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                MapPlaceholderHelper.g(MapPlaceholderHelper.this, valueAnimator);
            }
        });
        ofInt.addListener(new Animator.AnimatorListener() { // from class: eu.bolt.android.maps.core.container.MapPlaceholderHelper$hidePlaceholder$2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animation) {
                Intrinsics.f(animation, "animation");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                ViewGroup viewGroup;
                Intrinsics.f(animation, "animation");
                viewGroup = MapPlaceholderHelper.this.f36953a;
                viewGroup.getOverlay().clear();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animation) {
                Intrinsics.f(animation, "animation");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animation) {
                Intrinsics.f(animation, "animation");
            }
        });
        ofInt.start();
    }

    public final void h(MapStyle mapStyle) {
        Intrinsics.f(mapStyle, "mapStyle");
        Context context = this.f36953a.getContext();
        Intrinsics.e(context, "view.context");
        this.f36954b = c(context, mapStyle);
        ViewGroupOverlay overlay = this.f36953a.getOverlay();
        Drawable drawable = this.f36954b;
        if (drawable != null) {
            overlay.add(drawable);
            return;
        }
        throw new IllegalStateException("Required value was null.".toString());
    }
}
