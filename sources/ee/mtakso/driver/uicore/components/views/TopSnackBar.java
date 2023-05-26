package ee.mtakso.driver.uicore.components.views;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.content.ContextCompat;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import ee.mtakso.driver.uicore.components.views.TopSnackBar;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TopSnackBar.kt */
/* loaded from: classes5.dex */
public final class TopSnackBar extends BaseTransientBottomBar<TopSnackBar> {
    public static final Companion G = new Companion(null);

    /* compiled from: TopSnackBar.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(TopSnackBar this_apply, View view) {
            Intrinsics.f(this_apply, "$this_apply");
            this_apply.A();
        }

        public final TopSnackBar b(ViewGroup root, View view, boolean z7, boolean z8, int i8, final Function0<Unit> function0) {
            Intrinsics.f(root, "root");
            Intrinsics.f(view, "view");
            Context context = root.getContext();
            Intrinsics.e(context, "root.context");
            TopSnackBarView topSnackBarView = new TopSnackBarView(context, null, 0, 6, null);
            topSnackBarView.addView(view);
            final TopSnackBar topSnackBar = new TopSnackBar(root, topSnackBarView);
            if (z7) {
                view.setOnClickListener(new View.OnClickListener() { // from class: ee.mtakso.driver.uicore.components.views.g
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        TopSnackBar.Companion.c(TopSnackBar.this, view2);
                    }
                });
            }
            topSnackBar.a0(i8);
            if (!z8) {
                topSnackBar.Z(new BaseTransientBottomBar.Behavior() { // from class: ee.mtakso.driver.uicore.components.views.TopSnackBar$Companion$make$1$2
                    @Override // com.google.android.material.snackbar.BaseTransientBottomBar.Behavior, com.google.android.material.behavior.SwipeDismissBehavior
                    public boolean F(View child) {
                        Intrinsics.f(child, "child");
                        return false;
                    }
                });
            }
            topSnackBar.u(new BaseTransientBottomBar.BaseCallback<TopSnackBar>() { // from class: ee.mtakso.driver.uicore.components.views.TopSnackBar$Companion$make$1$3
                @Override // com.google.android.material.snackbar.BaseTransientBottomBar.BaseCallback
                /* renamed from: c */
                public void a(TopSnackBar topSnackBar2, int i9) {
                    super.a(topSnackBar2, i9);
                    Function0<Unit> function02 = function0;
                    if (function02 != null) {
                        function02.invoke();
                    }
                }
            });
            return topSnackBar;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TopSnackBar(ViewGroup parent, TopSnackBarView content) {
        super(parent, content, content);
        Intrinsics.f(parent, "parent");
        Intrinsics.f(content, "content");
        Y(1);
        View K = K();
        K.setBackgroundColor(ContextCompat.getColor(this.f14143i.getContext(), 17170445));
        K.setPadding(0, 0, 0, 0);
        ViewGroup.LayoutParams layoutParams = K.getLayoutParams();
        Intrinsics.d(layoutParams, "null cannot be cast to non-null type androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams");
        CoordinatorLayout.LayoutParams layoutParams2 = (CoordinatorLayout.LayoutParams) layoutParams;
        layoutParams2.f5456c = 48;
        K.setLayoutParams(layoutParams2);
    }
}
