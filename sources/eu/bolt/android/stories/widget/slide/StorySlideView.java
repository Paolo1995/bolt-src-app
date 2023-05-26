package eu.bolt.android.stories.widget.slide;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import eu.bolt.android.stories.widget.slide.StorySlide;
import eu.bolt.android.stories.widget.slide.decorators.BottomSheetLikeDecorator;
import eu.bolt.android.stories.widget.slide.decorators.StorySlideLayoutDecorator;
import eu.bolt.android.stories.widget.slide.decorators.TopArrayContentWithFooterSlideDecorator;
import eu.bolt.android.stories.widget.slide.decorators.TopLeftContentSlideDecorator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* compiled from: StorySlideView.kt */
/* loaded from: classes5.dex */
public final class StorySlideView extends ConstraintLayout {
    private StorySlide E;
    private StorySlideListener F;
    private StorySlideLayoutDecorator<? extends StorySlide> G;
    private final Map<KClass<? extends StorySlide>, StorySlideLayoutDecorator<? extends StorySlide>> H;
    public Map<Integer, View> I;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StorySlideView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.f(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StorySlideView(Context context, AttributeSet attributeSet, int i8) {
        super(context, attributeSet, i8);
        Intrinsics.f(context, "context");
        this.I = new LinkedHashMap();
        this.H = new LinkedHashMap();
    }

    private final StorySlideLayoutDecorator<? extends StorySlide> C(StorySlide storySlide) {
        StorySlideLayoutDecorator<? extends StorySlide> bottomSheetLikeDecorator;
        StorySlideListener storySlideListener = null;
        if (storySlide instanceof StorySlide.LeftContent) {
            StorySlideListener storySlideListener2 = this.F;
            if (storySlideListener2 == null) {
                Intrinsics.w(ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
            } else {
                storySlideListener = storySlideListener2;
            }
            bottomSheetLikeDecorator = new TopLeftContentSlideDecorator(storySlideListener);
            bottomSheetLikeDecorator.k(storySlide, this);
        } else if (storySlide instanceof StorySlide.ArrayContentWithFooter) {
            StorySlideListener storySlideListener3 = this.F;
            if (storySlideListener3 == null) {
                Intrinsics.w(ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
            } else {
                storySlideListener = storySlideListener3;
            }
            bottomSheetLikeDecorator = new TopArrayContentWithFooterSlideDecorator(storySlideListener);
            bottomSheetLikeDecorator.k(storySlide, this);
        } else if (storySlide instanceof StorySlide.BottomSheetLikeContent) {
            StorySlideListener storySlideListener4 = this.F;
            if (storySlideListener4 == null) {
                Intrinsics.w(ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
            } else {
                storySlideListener = storySlideListener4;
            }
            bottomSheetLikeDecorator = new BottomSheetLikeDecorator(storySlideListener);
            bottomSheetLikeDecorator.k(storySlide, this);
        } else {
            throw new NoWhenBranchMatchedException();
        }
        return bottomSheetLikeDecorator;
    }

    private final StorySlideLayoutDecorator<? extends StorySlide> D(StorySlide storySlide) {
        Map<KClass<? extends StorySlide>, StorySlideLayoutDecorator<? extends StorySlide>> map = this.H;
        KClass<? extends StorySlide> b8 = Reflection.b(storySlide.getClass());
        StorySlideLayoutDecorator<? extends StorySlide> storySlideLayoutDecorator = map.get(b8);
        if (storySlideLayoutDecorator == null) {
            storySlideLayoutDecorator = C(storySlide);
            map.put(b8, storySlideLayoutDecorator);
        }
        return storySlideLayoutDecorator;
    }

    public final void B() {
        StorySlideLayoutDecorator<? extends StorySlide> storySlideLayoutDecorator = this.G;
        if (storySlideLayoutDecorator != null) {
            storySlideLayoutDecorator.g();
        }
    }

    public final void E() {
        StorySlideLayoutDecorator<? extends StorySlide> storySlideLayoutDecorator = this.G;
        if (storySlideLayoutDecorator != null) {
            storySlideLayoutDecorator.m();
        }
    }

    public final void F() {
        StorySlideLayoutDecorator<? extends StorySlide> storySlideLayoutDecorator = this.G;
        if (storySlideLayoutDecorator != null) {
            storySlideLayoutDecorator.o();
        }
    }

    public final void G() {
        StorySlideLayoutDecorator<? extends StorySlide> storySlideLayoutDecorator = this.G;
        if (storySlideLayoutDecorator != null) {
            storySlideLayoutDecorator.q();
        }
    }

    public final void H(StorySlide slide) {
        Intrinsics.f(slide, "slide");
        if (slide instanceof StorySlide.LeftContent) {
            StorySlideLayoutDecorator<? extends StorySlide> D = D(slide);
            Intrinsics.d(D, "null cannot be cast to non-null type eu.bolt.android.stories.widget.slide.decorators.TopLeftContentSlideDecorator");
            ((TopLeftContentSlideDecorator) D).x((StorySlide.LeftContent) slide);
        } else if (slide instanceof StorySlide.ArrayContentWithFooter) {
            StorySlideLayoutDecorator<? extends StorySlide> D2 = D(slide);
            Intrinsics.d(D2, "null cannot be cast to non-null type eu.bolt.android.stories.widget.slide.decorators.TopArrayContentWithFooterSlideDecorator");
            ((TopArrayContentWithFooterSlideDecorator) D2).E((StorySlide.ArrayContentWithFooter) slide);
        } else if (slide instanceof StorySlide.BottomSheetLikeContent) {
            StorySlideLayoutDecorator<? extends StorySlide> D3 = D(slide);
            Intrinsics.d(D3, "null cannot be cast to non-null type eu.bolt.android.stories.widget.slide.decorators.BottomSheetLikeDecorator");
            ((BottomSheetLikeDecorator) D3).x((StorySlide.BottomSheetLikeContent) slide);
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    public final void setListener(StorySlideListener listener) {
        Intrinsics.f(listener, "listener");
        this.F = listener;
    }

    public final void setSlide(StorySlide slide) {
        ConstraintLayout h8;
        Intrinsics.f(slide, "slide");
        this.E = slide;
        StorySlideLayoutDecorator<? extends StorySlide> D = D(slide);
        D.d(slide);
        if (!Intrinsics.a(D, this.G)) {
            StorySlideLayoutDecorator<? extends StorySlide> storySlideLayoutDecorator = this.G;
            if (storySlideLayoutDecorator != null && (h8 = storySlideLayoutDecorator.h()) != null) {
                removeView(h8);
            }
            addView(D.h());
        }
        this.G = D;
    }

    public /* synthetic */ StorySlideView(Context context, AttributeSet attributeSet, int i8, int i9, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i9 & 2) != 0 ? null : attributeSet, (i9 & 4) != 0 ? 0 : i8);
    }
}
