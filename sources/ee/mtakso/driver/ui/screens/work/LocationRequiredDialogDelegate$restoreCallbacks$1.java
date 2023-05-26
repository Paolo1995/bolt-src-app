package ee.mtakso.driver.ui.screens.work;

import android.view.View;
import androidx.fragment.app.DialogFragment;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LocationRequiredDialogDelegate.kt */
/* loaded from: classes5.dex */
public /* synthetic */ class LocationRequiredDialogDelegate$restoreCallbacks$1 extends FunctionReferenceImpl implements Function3<DialogFragment, View, Object, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public LocationRequiredDialogDelegate$restoreCallbacks$1(Object obj) {
        super(3, obj, LocationRequiredDialogDelegate.class, "onLocationRequiredDialogAction", "onLocationRequiredDialogAction(Landroidx/fragment/app/DialogFragment;Landroid/view/View;Ljava/lang/Object;)V", 0);
    }

    public final void j(DialogFragment p02, View view, Object obj) {
        Intrinsics.f(p02, "p0");
        ((LocationRequiredDialogDelegate) this.f50989g).b(p02, view, obj);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit l(DialogFragment dialogFragment, View view, Object obj) {
        j(dialogFragment, view, obj);
        return Unit.f50853a;
    }
}
