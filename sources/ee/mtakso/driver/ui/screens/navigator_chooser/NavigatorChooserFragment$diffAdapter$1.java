package ee.mtakso.driver.ui.screens.navigator_chooser;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NavigatorChooserFragment.kt */
/* loaded from: classes3.dex */
public /* synthetic */ class NavigatorChooserFragment$diffAdapter$1 extends FunctionReferenceImpl implements Function1<NavigationOption, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public NavigatorChooserFragment$diffAdapter$1(Object obj) {
        super(1, obj, NavigatorChooserFragment.class, "handleItemClick", "handleItemClick(Lee/mtakso/driver/ui/screens/navigator_chooser/NavigationOption;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(NavigationOption navigationOption) {
        j(navigationOption);
        return Unit.f50853a;
    }

    public final void j(NavigationOption p02) {
        Intrinsics.f(p02, "p0");
        ((NavigatorChooserFragment) this.f50989g).Z(p02);
    }
}
