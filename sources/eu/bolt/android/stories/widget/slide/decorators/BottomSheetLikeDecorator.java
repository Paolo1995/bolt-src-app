package eu.bolt.android.stories.widget.slide.decorators;

import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.airbnb.lottie.LottieAnimationView;
import eu.bolt.android.stories.R$color;
import eu.bolt.android.stories.R$dimen;
import eu.bolt.android.stories.R$id;
import eu.bolt.android.stories.R$layout;
import eu.bolt.android.stories.widget.slide.ARiderXKt;
import eu.bolt.android.stories.widget.slide.StorySlide;
import eu.bolt.android.stories.widget.slide.StorySlideAsset;
import eu.bolt.android.stories.widget.slide.StorySlideButtonController;
import eu.bolt.android.stories.widget.slide.StorySlideListener;
import eu.bolt.android.stories.widget.slide.StoryTextStyle;
import eu.bolt.android.stories.widget.slide.StoryTextStyleBuilder;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BottomSheetLikeDecorator.kt */
/* loaded from: classes5.dex */
public final class BottomSheetLikeDecorator extends StorySlideLayoutDecorator<StorySlide.BottomSheetLikeContent> {

    /* renamed from: o  reason: collision with root package name */
    public static final Companion f37748o = new Companion(null);

    /* renamed from: h  reason: collision with root package name */
    private final /* synthetic */ StorySlideButtonController f37749h;

    /* renamed from: i  reason: collision with root package name */
    private final int f37750i;

    /* renamed from: j  reason: collision with root package name */
    private final int f37751j;

    /* renamed from: k  reason: collision with root package name */
    private final int f37752k;

    /* renamed from: l  reason: collision with root package name */
    private TextView f37753l;

    /* renamed from: m  reason: collision with root package name */
    private TextView f37754m;

    /* renamed from: n  reason: collision with root package name */
    private LottieAnimationView f37755n;

    /* compiled from: BottomSheetLikeDecorator.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BottomSheetLikeDecorator(StorySlideListener listener) {
        super(listener);
        Intrinsics.f(listener, "listener");
        this.f37749h = new StorySlideButtonController(listener);
        this.f37750i = R$color.f37424f;
        this.f37751j = R$dimen.f37431i;
        this.f37752k = R$dimen.f37432j;
    }

    private final StoryTextStyle w(String str) {
        StoryTextStyleBuilder storyTextStyleBuilder = new StoryTextStyleBuilder();
        storyTextStyleBuilder.f(str);
        storyTextStyleBuilder.a(this.f37750i);
        storyTextStyleBuilder.e(this.f37751j);
        storyTextStyleBuilder.b(this.f37752k);
        return storyTextStyleBuilder.c();
    }

    @Override // eu.bolt.android.stories.widget.slide.ButtonController
    public void a() {
        this.f37749h.a();
    }

    @Override // eu.bolt.android.stories.widget.slide.ButtonController
    public void b(StorySlide slide, ConstraintLayout view) {
        Intrinsics.f(slide, "slide");
        Intrinsics.f(view, "view");
        this.f37749h.b(slide, view);
    }

    @Override // eu.bolt.android.stories.widget.slide.ButtonController
    public void c(StorySlide slide) {
        Intrinsics.f(slide, "slide");
        this.f37749h.c(slide);
    }

    @Override // eu.bolt.android.stories.widget.slide.decorators.StorySlideLayoutDecorator
    public void g() {
        super.g();
        TextView textView = this.f37753l;
        TextView textView2 = null;
        if (textView == null) {
            Intrinsics.w("slideTitle");
            textView = null;
        }
        textView.setText((CharSequence) null);
        TextView textView3 = this.f37753l;
        if (textView3 == null) {
            Intrinsics.w("slideTitle");
            textView3 = null;
        }
        ARiderXKt.g(textView3, false);
        TextView textView4 = this.f37754m;
        if (textView4 == null) {
            Intrinsics.w("slideDescription");
            textView4 = null;
        }
        textView4.setText((CharSequence) null);
        TextView textView5 = this.f37754m;
        if (textView5 == null) {
            Intrinsics.w("slideDescription");
        } else {
            textView2 = textView5;
        }
        ARiderXKt.g(textView2, false);
    }

    @Override // eu.bolt.android.stories.widget.slide.decorators.StorySlideLayoutDecorator
    public int i() {
        return R$layout.view_story_slide_bottom_sheet_like;
    }

    @Override // eu.bolt.android.stories.widget.slide.decorators.StorySlideLayoutDecorator
    /* renamed from: v */
    public void f(StorySlide.BottomSheetLikeContent slide, ConstraintLayout view) {
        List<? extends LottieAnimationView> e8;
        Intrinsics.f(slide, "slide");
        Intrinsics.f(view, "view");
        View findViewById = view.findViewById(R$id.f37448l);
        Intrinsics.e(findViewById, "view.findViewById(R.id.slideTitle)");
        this.f37753l = (TextView) findViewById;
        View findViewById2 = view.findViewById(R$id.f37446j);
        Intrinsics.e(findViewById2, "view.findViewById(R.id.slideDescription)");
        this.f37754m = (TextView) findViewById2;
        View findViewById3 = view.findViewById(R$id.f37443e);
        Intrinsics.e(findViewById3, "view.findViewById(R.id.slideAssetLottie)");
        LottieAnimationView lottieAnimationView = (LottieAnimationView) findViewById3;
        this.f37755n = lottieAnimationView;
        if (lottieAnimationView == null) {
            Intrinsics.w("slideAssetLottie");
            lottieAnimationView = null;
        }
        e8 = CollectionsKt__CollectionsJVMKt.e(lottieAnimationView);
        t(e8);
        super.f(slide, view);
    }

    public void x(StorySlide.BottomSheetLikeContent slide) {
        boolean z7;
        Intrinsics.f(slide, "slide");
        TextView textView = this.f37753l;
        TextView textView2 = null;
        if (textView == null) {
            Intrinsics.w("slideTitle");
            textView = null;
        }
        boolean z8 = true;
        if (slide.g() != null) {
            z7 = true;
        } else {
            z7 = false;
        }
        ARiderXKt.g(textView, z7);
        String g8 = slide.g();
        if (g8 != null) {
            TextView textView3 = this.f37753l;
            if (textView3 == null) {
                Intrinsics.w("slideTitle");
                textView3 = null;
            }
            ARiderXKt.f(textView3, w(g8));
        }
        TextView textView4 = this.f37754m;
        if (textView4 == null) {
            Intrinsics.w("slideDescription");
            textView4 = null;
        }
        if (slide.e() == null) {
            z8 = false;
        }
        ARiderXKt.g(textView4, z8);
        String e8 = slide.e();
        if (e8 != null) {
            TextView textView5 = this.f37754m;
            if (textView5 == null) {
                Intrinsics.w("slideDescription");
            } else {
                textView2 = textView5;
            }
            ARiderXKt.f(textView2, w(e8));
        }
    }

    @Override // eu.bolt.android.stories.widget.slide.decorators.StorySlideLayoutDecorator
    /* renamed from: y */
    public void s(StorySlide.BottomSheetLikeContent slide) {
        int i8;
        Intrinsics.f(slide, "slide");
        super.s(slide);
        StorySlideAsset f8 = slide.f();
        LottieAnimationView lottieAnimationView = this.f37755n;
        TextView textView = null;
        if (lottieAnimationView == null) {
            Intrinsics.w("slideAssetLottie");
            lottieAnimationView = null;
        }
        e(f8, lottieAnimationView);
        TextView textView2 = this.f37754m;
        if (textView2 == null) {
            Intrinsics.w("slideDescription");
        } else {
            textView = textView2;
        }
        if (slide.f() != null) {
            i8 = 5;
        } else {
            i8 = 12;
        }
        textView.setMaxLines(i8);
    }
}
