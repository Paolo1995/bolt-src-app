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
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TopLeftContentSlideDecorator.kt */
/* loaded from: classes5.dex */
public final class TopLeftContentSlideDecorator extends StorySlideLayoutDecorator<StorySlide.LeftContent> {

    /* renamed from: h  reason: collision with root package name */
    private final /* synthetic */ StorySlideButtonController f37773h;

    /* renamed from: i  reason: collision with root package name */
    private final int f37774i;

    /* renamed from: j  reason: collision with root package name */
    private final int f37775j;

    /* renamed from: k  reason: collision with root package name */
    private final int f37776k;

    /* renamed from: l  reason: collision with root package name */
    private Integer f37777l;

    /* renamed from: m  reason: collision with root package name */
    private TextView f37778m;

    /* renamed from: n  reason: collision with root package name */
    private TextView f37779n;

    /* renamed from: o  reason: collision with root package name */
    private LottieAnimationView f37780o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TopLeftContentSlideDecorator(StorySlideListener listener) {
        super(listener);
        Intrinsics.f(listener, "listener");
        this.f37773h = new StorySlideButtonController(listener);
        this.f37774i = R$color.f37424f;
        this.f37775j = R$dimen.f37431i;
        this.f37776k = R$dimen.f37432j;
        this.f37777l = 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void A(eu.bolt.android.stories.widget.slide.StorySlide.LeftContent r3, android.widget.TextView r4) {
        /*
            r2 = this;
            java.lang.String r0 = r3.j()
            if (r0 == 0) goto L17
            eu.bolt.android.stories.utils.StoriesHtmlEngine r0 = eu.bolt.android.stories.utils.StoriesHtmlEngine.f37614a
            kotlin.jvm.functions.Function1 r0 = r0.a()
            java.lang.String r3 = r3.j()
            java.lang.Object r3 = r0.invoke(r3)
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            goto L1b
        L17:
            java.lang.String r3 = r3.i()
        L1b:
            r0 = 1
            if (r3 == 0) goto L27
            boolean r1 = kotlin.text.StringsKt.y(r3)
            if (r1 == 0) goto L25
            goto L27
        L25:
            r1 = 0
            goto L28
        L27:
            r1 = 1
        L28:
            r0 = r0 ^ r1
            eu.bolt.android.stories.widget.slide.ARiderXKt.g(r4, r0)
            if (r3 == 0) goto L35
            eu.bolt.android.stories.widget.slide.StoryTextStyle r3 = r2.w(r3)
            eu.bolt.android.stories.widget.slide.ARiderXKt.f(r4, r3)
        L35:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: eu.bolt.android.stories.widget.slide.decorators.TopLeftContentSlideDecorator.A(eu.bolt.android.stories.widget.slide.StorySlide$LeftContent, android.widget.TextView):void");
    }

    private final StoryTextStyle w(CharSequence charSequence) {
        StoryTextStyleBuilder storyTextStyleBuilder = new StoryTextStyleBuilder();
        storyTextStyleBuilder.f(charSequence);
        storyTextStyleBuilder.a(this.f37774i);
        storyTextStyleBuilder.e(this.f37775j);
        storyTextStyleBuilder.b(this.f37776k);
        storyTextStyleBuilder.d(this.f37777l);
        return storyTextStyleBuilder.c();
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void z(eu.bolt.android.stories.widget.slide.StorySlide.LeftContent r3, android.widget.TextView r4) {
        /*
            r2 = this;
            java.lang.String r0 = r3.f()
            if (r0 == 0) goto L17
            eu.bolt.android.stories.utils.StoriesHtmlEngine r0 = eu.bolt.android.stories.utils.StoriesHtmlEngine.f37614a
            kotlin.jvm.functions.Function1 r0 = r0.a()
            java.lang.String r3 = r3.f()
            java.lang.Object r3 = r0.invoke(r3)
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            goto L1b
        L17:
            java.lang.String r3 = r3.e()
        L1b:
            r0 = 1
            if (r3 == 0) goto L27
            boolean r1 = kotlin.text.StringsKt.y(r3)
            if (r1 == 0) goto L25
            goto L27
        L25:
            r1 = 0
            goto L28
        L27:
            r1 = 1
        L28:
            r0 = r0 ^ r1
            eu.bolt.android.stories.widget.slide.ARiderXKt.g(r4, r0)
            if (r3 == 0) goto L35
            eu.bolt.android.stories.widget.slide.StoryTextStyle r3 = r2.w(r3)
            eu.bolt.android.stories.widget.slide.ARiderXKt.f(r4, r3)
        L35:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: eu.bolt.android.stories.widget.slide.decorators.TopLeftContentSlideDecorator.z(eu.bolt.android.stories.widget.slide.StorySlide$LeftContent, android.widget.TextView):void");
    }

    @Override // eu.bolt.android.stories.widget.slide.ButtonController
    public void a() {
        this.f37773h.a();
    }

    @Override // eu.bolt.android.stories.widget.slide.ButtonController
    public void b(StorySlide slide, ConstraintLayout view) {
        Intrinsics.f(slide, "slide");
        Intrinsics.f(view, "view");
        this.f37773h.b(slide, view);
    }

    @Override // eu.bolt.android.stories.widget.slide.ButtonController
    public void c(StorySlide slide) {
        Intrinsics.f(slide, "slide");
        this.f37773h.c(slide);
    }

    @Override // eu.bolt.android.stories.widget.slide.decorators.StorySlideLayoutDecorator
    public void g() {
        super.g();
        TextView textView = this.f37778m;
        TextView textView2 = null;
        if (textView == null) {
            Intrinsics.w("slideTitle");
            textView = null;
        }
        textView.setText((CharSequence) null);
        TextView textView3 = this.f37778m;
        if (textView3 == null) {
            Intrinsics.w("slideTitle");
            textView3 = null;
        }
        ARiderXKt.g(textView3, false);
        TextView textView4 = this.f37779n;
        if (textView4 == null) {
            Intrinsics.w("slideDescription");
            textView4 = null;
        }
        textView4.setText((CharSequence) null);
        TextView textView5 = this.f37779n;
        if (textView5 == null) {
            Intrinsics.w("slideDescription");
        } else {
            textView2 = textView5;
        }
        ARiderXKt.g(textView2, false);
    }

    @Override // eu.bolt.android.stories.widget.slide.decorators.StorySlideLayoutDecorator
    public int i() {
        return R$layout.view_story_slide_top_left;
    }

    @Override // eu.bolt.android.stories.widget.slide.decorators.StorySlideLayoutDecorator
    /* renamed from: v */
    public void f(StorySlide.LeftContent slide, ConstraintLayout view) {
        List<? extends LottieAnimationView> e8;
        Intrinsics.f(slide, "slide");
        Intrinsics.f(view, "view");
        View findViewById = view.findViewById(R$id.storySlideTitle);
        Intrinsics.e(findViewById, "view.findViewById(R.id.storySlideTitle)");
        this.f37778m = (TextView) findViewById;
        View findViewById2 = view.findViewById(R$id.storySlideDescription);
        Intrinsics.e(findViewById2, "view.findViewById(R.id.storySlideDescription)");
        this.f37779n = (TextView) findViewById2;
        View findViewById3 = view.findViewById(R$id.storySlideAssetLottie);
        Intrinsics.e(findViewById3, "view.findViewById(R.id.storySlideAssetLottie)");
        LottieAnimationView lottieAnimationView = (LottieAnimationView) findViewById3;
        this.f37780o = lottieAnimationView;
        if (lottieAnimationView == null) {
            Intrinsics.w("slideAssetLottie");
            lottieAnimationView = null;
        }
        e8 = CollectionsKt__CollectionsJVMKt.e(lottieAnimationView);
        t(e8);
        super.f(slide, view);
    }

    public void x(StorySlide.LeftContent slide) {
        Intrinsics.f(slide, "slide");
        this.f37777l = slide.h();
        TextView textView = this.f37778m;
        TextView textView2 = null;
        if (textView == null) {
            Intrinsics.w("slideTitle");
            textView = null;
        }
        A(slide, textView);
        TextView textView3 = this.f37779n;
        if (textView3 == null) {
            Intrinsics.w("slideDescription");
        } else {
            textView2 = textView3;
        }
        z(slide, textView2);
    }

    @Override // eu.bolt.android.stories.widget.slide.decorators.StorySlideLayoutDecorator
    /* renamed from: y */
    public void s(StorySlide.LeftContent slide) {
        Intrinsics.f(slide, "slide");
        super.s(slide);
        StorySlideAsset g8 = slide.g();
        LottieAnimationView lottieAnimationView = this.f37780o;
        if (lottieAnimationView == null) {
            Intrinsics.w("slideAssetLottie");
            lottieAnimationView = null;
        }
        e(g8, lottieAnimationView);
    }
}
