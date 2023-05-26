package eu.bolt.driver.core.ui.common.snackbar;

import android.content.Context;
import android.view.View;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;
import ee.mtakso.driver.uikit.utils.Text;
import ee.mtakso.driver.uikit.utils.TextKt;
import eu.bolt.driver.core.ui.common.snackbar.SnackBarDelegate;
import eu.bolt.driver.core.ui.common.snackbar.SnackBarModel;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SnackBarDelegate.kt */
/* loaded from: classes5.dex */
public final class SnackBarDelegate {

    /* renamed from: a  reason: collision with root package name */
    private final View f41126a;

    /* renamed from: b  reason: collision with root package name */
    private final View f41127b;

    public SnackBarDelegate(View view, View view2) {
        Intrinsics.f(view, "view");
        this.f41126a = view;
        this.f41127b = view2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(SnackBarModel model, View v7) {
        Intrinsics.f(model, "$model");
        Function1<View, Unit> a8 = model.a();
        if (a8 != null) {
            Intrinsics.e(v7, "v");
            a8.invoke(v7);
        }
    }

    public final void b(final SnackBarModel model) {
        CharSequence a8;
        Intrinsics.f(model, "model");
        Context context = this.f41126a.getContext();
        View view = this.f41126a;
        Text f8 = model.f();
        Intrinsics.e(context, "context");
        Snackbar t02 = Snackbar.t0(context, view, TextKt.a(f8, context), model.c());
        Intrinsics.e(t02, "make(context, view, mode…context), model.duration)");
        View view2 = this.f41127b;
        if (view2 != null) {
            t02.X(view2);
        }
        Text b8 = model.b();
        if (b8 != null && (a8 = TextKt.a(b8, context)) != null) {
            t02.x0(a8, new View.OnClickListener() { // from class: h7.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    SnackBarDelegate.c(SnackBarModel.this, view3);
                }
            });
        }
        t02.u(new BaseTransientBottomBar.BaseCallback<Snackbar>() { // from class: eu.bolt.driver.core.ui.common.snackbar.SnackBarDelegate$showShackBar$3
            @Override // com.google.android.material.snackbar.BaseTransientBottomBar.BaseCallback
            /* renamed from: c */
            public void a(Snackbar snackbar, int i8) {
                Function1<Snackbar, Unit> d8 = SnackBarModel.this.d();
                if (d8 != null) {
                    d8.invoke(snackbar);
                }
            }

            @Override // com.google.android.material.snackbar.BaseTransientBottomBar.BaseCallback
            /* renamed from: d */
            public void b(Snackbar snackbar) {
                Function1<Snackbar, Unit> e8 = SnackBarModel.this.e();
                if (e8 != null) {
                    e8.invoke(snackbar);
                }
            }
        });
        t02.e0();
    }

    public /* synthetic */ SnackBarDelegate(View view, View view2, int i8, DefaultConstructorMarker defaultConstructorMarker) {
        this(view, (i8 & 2) != 0 ? null : view2);
    }
}
