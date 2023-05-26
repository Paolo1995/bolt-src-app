package eu.bolt.verification.sdk.internal;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.widget.NestedScrollView;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class ah {

    /* renamed from: b  reason: collision with root package name */
    public static final a f42083b = new a(null);

    /* renamed from: a  reason: collision with root package name */
    private final float f42084a;

    /* loaded from: classes5.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public ah(float f8) {
        this.f42084a = f8;
    }

    public /* synthetic */ ah(float f8, int i8, DefaultConstructorMarker defaultConstructorMarker) {
        this((i8 & 1) != 0 ? 24.0f : f8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(ah this$0, NestedScrollView scrollView, ViewGroup elevationRecipient, View view, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(scrollView, "$scrollView");
        Intrinsics.f(elevationRecipient, "$elevationRecipient");
        this$0.f(scrollView, elevationRecipient);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(ah this$0, NestedScrollView scrollView, ViewGroup elevationRecipient, NestedScrollView nestedScrollView, int i8, int i9, int i10, int i11) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(scrollView, "$scrollView");
        Intrinsics.f(elevationRecipient, "$elevationRecipient");
        Intrinsics.f(nestedScrollView, "<anonymous parameter 0>");
        this$0.f(scrollView, elevationRecipient);
    }

    private final void f(NestedScrollView nestedScrollView, ViewGroup viewGroup) {
        View childAt;
        float i8;
        if (viewGroup.isAttachedToWindow() && nestedScrollView.isAttachedToWindow() && (childAt = nestedScrollView.getChildAt(0)) != null) {
            if (nestedScrollView.getScrollY() >= childAt.getMeasuredHeight() - nestedScrollView.getMeasuredHeight()) {
                i8 = 0.0f;
            } else {
                Context context = viewGroup.getContext();
                Intrinsics.e(context, "elevationRecipient.context");
                i8 = f2.i(context, this.f42084a);
            }
            viewGroup.setZ(i8);
        }
    }

    public final void c(final NestedScrollView scrollView, final ViewGroup elevationRecipient) {
        Intrinsics.f(scrollView, "scrollView");
        Intrinsics.f(elevationRecipient, "elevationRecipient");
        View childAt = scrollView.getChildAt(0);
        if (childAt != null) {
            childAt.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: eu.bolt.verification.sdk.internal.c6
                @Override // android.view.View.OnLayoutChangeListener
                public final void onLayoutChange(View view, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15) {
                    ah.d(ah.this, scrollView, elevationRecipient, view, i8, i9, i10, i11, i12, i13, i14, i15);
                }
            });
        }
        scrollView.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() { // from class: eu.bolt.verification.sdk.internal.d6
            @Override // androidx.core.widget.NestedScrollView.OnScrollChangeListener
            public final void a(NestedScrollView nestedScrollView, int i8, int i9, int i10, int i11) {
                ah.e(ah.this, scrollView, elevationRecipient, nestedScrollView, i8, i9, i10, i11);
            }
        });
    }
}
