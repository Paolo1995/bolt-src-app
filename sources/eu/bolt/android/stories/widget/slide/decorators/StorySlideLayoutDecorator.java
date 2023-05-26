package eu.bolt.android.stories.widget.slide.decorators;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.airbnb.lottie.LottieAnimationView;
import eu.bolt.android.stories.widget.slide.ARiderXKt;
import eu.bolt.android.stories.widget.slide.ButtonController;
import eu.bolt.android.stories.widget.slide.StorySlide;
import eu.bolt.android.stories.widget.slide.StorySlideAsset;
import eu.bolt.android.stories.widget.slide.StorySlideImageAssetDelegate;
import eu.bolt.android.stories.widget.slide.StorySlideListener;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: StorySlideLayoutDecorator.kt */
/* loaded from: classes5.dex */
public abstract class StorySlideLayoutDecorator<T extends StorySlide> implements ButtonController {

    /* renamed from: g  reason: collision with root package name */
    private static final Companion f37756g = new Companion(null);

    /* renamed from: a  reason: collision with root package name */
    private final StorySlideListener f37757a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ StorySlideImageAssetDelegate f37758b;

    /* renamed from: c  reason: collision with root package name */
    private T f37759c;

    /* renamed from: d  reason: collision with root package name */
    private ConstraintLayout f37760d;

    /* renamed from: e  reason: collision with root package name */
    private Drawable f37761e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f37762f;

    /* compiled from: StorySlideLayoutDecorator.kt */
    /* loaded from: classes5.dex */
    private static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public StorySlideLayoutDecorator(StorySlideListener listener) {
        Intrinsics.f(listener, "listener");
        this.f37757a = listener;
        this.f37758b = new StorySlideImageAssetDelegate(listener);
    }

    private final void u(T t7) {
        ColorDrawable colorDrawable = new ColorDrawable(t7.b());
        ConstraintLayout constraintLayout = null;
        if (this.f37761e == null) {
            ConstraintLayout constraintLayout2 = this.f37760d;
            if (constraintLayout2 == null) {
                Intrinsics.w("contentView");
            } else {
                constraintLayout = constraintLayout2;
            }
            constraintLayout.setBackground(colorDrawable);
        } else {
            TransitionDrawable transitionDrawable = new TransitionDrawable(new Drawable[]{this.f37761e, colorDrawable});
            ConstraintLayout constraintLayout3 = this.f37760d;
            if (constraintLayout3 == null) {
                Intrinsics.w("contentView");
            } else {
                constraintLayout = constraintLayout3;
            }
            constraintLayout.setBackground(transitionDrawable);
            transitionDrawable.startTransition(400);
        }
        this.f37761e = colorDrawable;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void d(StorySlide slide) {
        Intrinsics.f(slide, "slide");
        this.f37759c = slide;
        s(slide);
    }

    public void e(StorySlideAsset storySlideAsset, LottieAnimationView view) {
        Intrinsics.f(view, "view");
        this.f37758b.f(storySlideAsset, view);
    }

    public void f(T slide, ConstraintLayout view) {
        Intrinsics.f(slide, "slide");
        Intrinsics.f(view, "view");
        this.f37760d = view;
        b(slide, view);
    }

    public void g() {
        l();
        a();
        ConstraintLayout constraintLayout = this.f37760d;
        if (constraintLayout == null) {
            Intrinsics.w("contentView");
            constraintLayout = null;
        }
        constraintLayout.setBackgroundColor(-1);
        this.f37759c = null;
    }

    public final ConstraintLayout h() {
        ConstraintLayout constraintLayout = this.f37760d;
        if (constraintLayout == null) {
            Intrinsics.w("contentView");
            return null;
        }
        return constraintLayout;
    }

    public abstract int i();

    public final StorySlideListener j() {
        return this.f37757a;
    }

    public final void k(T slide, ConstraintLayout view) {
        Intrinsics.f(slide, "slide");
        Intrinsics.f(view, "view");
        ConstraintLayout constraintLayout = (ConstraintLayout) ARiderXKt.e(view, i());
        this.f37760d = constraintLayout;
        if (constraintLayout == null) {
            Intrinsics.w("contentView");
            constraintLayout = null;
        }
        f(slide, constraintLayout);
    }

    public void l() {
        this.f37758b.h();
    }

    public void m() {
        o();
        n();
    }

    public void n() {
        this.f37758b.i();
    }

    public void o() {
        if (!this.f37762f) {
            return;
        }
        this.f37762f = false;
        p();
    }

    public void p() {
        this.f37758b.j();
    }

    public void q() {
        if (this.f37762f) {
            return;
        }
        this.f37762f = true;
        r();
    }

    public void r() {
        this.f37758b.k();
    }

    public void s(T slide) {
        Intrinsics.f(slide, "slide");
        u(slide);
        c(slide);
    }

    public void t(List<? extends LottieAnimationView> views) {
        Intrinsics.f(views, "views");
        this.f37758b.l(views);
    }
}
