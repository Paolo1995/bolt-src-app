package eu.bolt.android.stories.widget.slide;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import eu.bolt.android.stories.R$dimen;
import eu.bolt.android.stories.R$id;
import eu.bolt.android.stories.widget.helper.StoryButton;
import eu.bolt.android.stories.widget.slide.StorySlideButtonController;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: StorySlideButtonController.kt */
/* loaded from: classes5.dex */
public final class StorySlideButtonController implements ButtonController {

    /* renamed from: a  reason: collision with root package name */
    private final StorySlideButtonClickListener f37706a;

    /* renamed from: b  reason: collision with root package name */
    private Button f37707b;

    /* renamed from: c  reason: collision with root package name */
    private StoryButtonStyle f37708c;

    /* renamed from: d  reason: collision with root package name */
    private StorySlide f37709d;

    /* renamed from: e  reason: collision with root package name */
    private ConstraintLayout f37710e;

    public StorySlideButtonController(StorySlideButtonClickListener listener) {
        Intrinsics.f(listener, "listener");
        this.f37706a = listener;
    }

    private final void f(StorySlide storySlide) {
        ConstraintLayout constraintLayout = this.f37710e;
        if (storySlide.c() != null && constraintLayout != null) {
            StoryButtonStyle b8 = storySlide.c().b();
            if (!Intrinsics.a(this.f37708c, b8)) {
                this.f37708c = b8;
                Button button = this.f37707b;
                if (button != null) {
                    constraintLayout.removeView(button);
                }
                StoryButton.Companion companion = StoryButton.f37626k;
                Context context = constraintLayout.getContext();
                Intrinsics.e(context, "storySlideView.context");
                StoryButton a8 = companion.a(context, b8.a());
                ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-1, -2);
                Context context2 = constraintLayout.getContext();
                Intrinsics.e(context2, "storySlideView.context");
                int i8 = R$dimen.f37427a;
                int b9 = ARiderXKt.b(context2, i8);
                Context context3 = constraintLayout.getContext();
                Intrinsics.e(context3, "storySlideView.context");
                int i9 = R$dimen.f37428b;
                int b10 = ARiderXKt.b(context3, i9);
                Context context4 = constraintLayout.getContext();
                Intrinsics.e(context4, "storySlideView.context");
                int b11 = ARiderXKt.b(context4, i8);
                Context context5 = constraintLayout.getContext();
                Intrinsics.e(context5, "storySlideView.context");
                marginLayoutParams.setMargins(b9, b10, b11, ARiderXKt.b(context5, i9));
                a8.setLayoutParams(marginLayoutParams);
                a8.setId(R$id.f37450n);
                a8.setOnClickListener(new View.OnClickListener() { // from class: j6.c
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        StorySlideButtonController.g(StorySlideButtonController.this, view);
                    }
                });
                constraintLayout.addView(a8);
                ConstraintSet constraintSet = new ConstraintSet();
                constraintSet.g(constraintLayout);
                Context context6 = constraintLayout.getContext();
                Intrinsics.e(context6, "storySlideView.context");
                int c8 = ARiderXKt.c(context6, 24.0f);
                constraintSet.j(a8.getId(), 4, 0, 4, c8);
                constraintSet.j(a8.getId(), 6, 0, 6, c8);
                constraintSet.j(a8.getId(), 7, 0, 7, c8);
                constraintSet.c(constraintLayout);
                this.f37707b = a8;
                return;
            }
            return;
        }
        a();
        this.f37707b = null;
        this.f37708c = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(StorySlideButtonController this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        StorySlide storySlide = this$0.f37709d;
        if (storySlide != null) {
            this$0.f37706a.d(storySlide, this$0);
        }
    }

    @Override // eu.bolt.android.stories.widget.slide.ButtonController
    public void a() {
        e();
        Button button = this.f37707b;
        if (button != null) {
            ARiderXKt.g(button, false);
        }
    }

    @Override // eu.bolt.android.stories.widget.slide.ButtonController
    public void b(StorySlide slide, ConstraintLayout view) {
        Intrinsics.f(slide, "slide");
        Intrinsics.f(view, "view");
        this.f37710e = view;
        f(slide);
    }

    @Override // eu.bolt.android.stories.widget.slide.ButtonController
    public void c(StorySlide slide) {
        boolean y7;
        Intrinsics.f(slide, "slide");
        this.f37709d = slide;
        e();
        StorySlideButton c8 = slide.c();
        if (c8 == null) {
            a();
            return;
        }
        f(slide);
        Button button = this.f37707b;
        if (button != null) {
            y7 = StringsKt__StringsJVMKt.y(c8.c());
            ARiderXKt.g(button, !y7);
        }
        Button button2 = this.f37707b;
        if (button2 != null) {
            button2.setText(c8.c());
        }
    }

    public void e() {
    }
}
