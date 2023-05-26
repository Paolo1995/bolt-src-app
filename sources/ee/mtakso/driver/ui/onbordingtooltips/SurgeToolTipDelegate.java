package ee.mtakso.driver.ui.onbordingtooltips;

import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.AppCompatImageButton;
import ee.mtakso.driver.R;
import ee.mtakso.driver.ui.onbordingtooltips.SurgeToolTipDelegate;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SurgeToolTipDelegate.kt */
/* loaded from: classes3.dex */
public final class SurgeToolTipDelegate {

    /* renamed from: a  reason: collision with root package name */
    private final ViewGroup f26989a;

    /* renamed from: b  reason: collision with root package name */
    private final ViewGroup f26990b;

    /* renamed from: c  reason: collision with root package name */
    private final int f26991c;

    /* renamed from: d  reason: collision with root package name */
    private final Function0<Unit> f26992d;

    /* renamed from: e  reason: collision with root package name */
    private final Lazy f26993e;

    public SurgeToolTipDelegate(ViewGroup rootLayout, ViewGroup parent, int i8, Function0<Unit> toolTipClosedCallback) {
        Lazy b8;
        Intrinsics.f(rootLayout, "rootLayout");
        Intrinsics.f(parent, "parent");
        Intrinsics.f(toolTipClosedCallback, "toolTipClosedCallback");
        this.f26989a = rootLayout;
        this.f26990b = parent;
        this.f26991c = i8;
        this.f26992d = toolTipClosedCallback;
        b8 = LazyKt__LazyJVMKt.b(new Function0<AlertDialog>() { // from class: ee.mtakso.driver.ui.onbordingtooltips.SurgeToolTipDelegate$alertDialog$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final AlertDialog invoke() {
                ViewGroup viewGroup;
                viewGroup = SurgeToolTipDelegate.this.f26990b;
                AlertDialog a8 = new AlertDialog.Builder(viewGroup.getContext()).p(R.layout.surge_category_tooltip_layout).a();
                Intrinsics.e(a8, "Builder(parent.context)\n…ut)\n            .create()");
                return a8;
            }
        });
        this.f26993e = b8;
    }

    private final AlertDialog e() {
        return (AlertDialog) this.f26993e.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(SurgeToolTipDelegate this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        this$0.f26992d.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(SurgeToolTipDelegate this$0, DialogInterface dialogInterface) {
        Intrinsics.f(this$0, "this$0");
        this$0.f26992d.invoke();
    }

    public final void d() {
        e().dismiss();
    }

    public final void f() {
        Window window = e().getWindow();
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
            window.clearFlags(2);
        }
        e().show();
        SurgeToolTipDelegateKt.c(e(), this.f26989a, this.f26990b, this.f26991c);
        Window window2 = e().getWindow();
        if (window2 != null) {
            window2.setWindowAnimations(R.style.DialogAnimation);
        }
        AppCompatImageButton appCompatImageButton = (AppCompatImageButton) e().findViewById(R.id.closeToolTip);
        if (appCompatImageButton != null) {
            appCompatImageButton.setOnClickListener(new View.OnClickListener() { // from class: u2.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SurgeToolTipDelegate.g(SurgeToolTipDelegate.this, view);
                }
            });
        }
        e().setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: u2.b
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                SurgeToolTipDelegate.h(SurgeToolTipDelegate.this, dialogInterface);
            }
        });
    }
}
