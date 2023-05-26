package eu.bolt.android.stories.widget.slide;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.widget.NestedScrollView;
import eu.bolt.android.stories.widget.slide.ScrollBasedElevationHelper;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ARiderX.kt */
/* loaded from: classes5.dex */
public final class ScrollBasedElevationHelper {

    /* renamed from: b  reason: collision with root package name */
    public static final Companion f37664b = new Companion(null);

    /* renamed from: a  reason: collision with root package name */
    private final float f37665a;

    /* compiled from: ARiderX.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public ScrollBasedElevationHelper() {
        this(0.0f, 1, null);
    }

    public ScrollBasedElevationHelper(float f8) {
        this.f37665a = f8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(ScrollBasedElevationHelper this$0, NestedScrollView scrollView, ViewGroup elevationRecipient, View view, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(scrollView, "$scrollView");
        Intrinsics.f(elevationRecipient, "$elevationRecipient");
        this$0.f(scrollView, elevationRecipient);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(ScrollBasedElevationHelper this$0, NestedScrollView scrollView, ViewGroup elevationRecipient, NestedScrollView nestedScrollView, int i8, int i9, int i10, int i11) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(scrollView, "$scrollView");
        Intrinsics.f(elevationRecipient, "$elevationRecipient");
        Intrinsics.f(nestedScrollView, "<anonymous parameter 0>");
        this$0.f(scrollView, elevationRecipient);
    }

    private final void f(NestedScrollView nestedScrollView, ViewGroup viewGroup) {
        View childAt;
        float d8;
        if (!viewGroup.isAttachedToWindow() || !nestedScrollView.isAttachedToWindow() || (childAt = nestedScrollView.getChildAt(0)) == null) {
            return;
        }
        if (nestedScrollView.getScrollY() >= childAt.getMeasuredHeight() - nestedScrollView.getMeasuredHeight()) {
            d8 = 0.0f;
        } else {
            Context context = viewGroup.getContext();
            Intrinsics.e(context, "elevationRecipient.context");
            d8 = ARiderXKt.d(context, this.f37665a);
        }
        viewGroup.setZ(d8);
    }

    public final void c(final NestedScrollView scrollView, final ViewGroup elevationRecipient) {
        Intrinsics.f(scrollView, "scrollView");
        Intrinsics.f(elevationRecipient, "elevationRecipient");
        View childAt = scrollView.getChildAt(0);
        if (childAt != null) {
            childAt.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: j6.a
                @Override // android.view.View.OnLayoutChangeListener
                public final void onLayoutChange(View view, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15) {
                    ScrollBasedElevationHelper.d(ScrollBasedElevationHelper.this, scrollView, elevationRecipient, view, i8, i9, i10, i11, i12, i13, i14, i15);
                }
            });
        }
        scrollView.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() { // from class: j6.b
            @Override // androidx.core.widget.NestedScrollView.OnScrollChangeListener
            public final void a(NestedScrollView nestedScrollView, int i8, int i9, int i10, int i11) {
                ScrollBasedElevationHelper.e(ScrollBasedElevationHelper.this, scrollView, elevationRecipient, nestedScrollView, i8, i9, i10, i11);
            }
        });
    }

    public /* synthetic */ ScrollBasedElevationHelper(float f8, int i8, DefaultConstructorMarker defaultConstructorMarker) {
        this((i8 & 1) != 0 ? 24.0f : f8);
    }
}
