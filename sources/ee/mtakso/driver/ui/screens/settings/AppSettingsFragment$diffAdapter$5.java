package ee.mtakso.driver.ui.screens.settings;

import ee.mtakso.driver.uicore.components.recyclerview.delegates.common.TwoLinesItemDelegate;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AppSettingsFragment.kt */
/* loaded from: classes5.dex */
public /* synthetic */ class AppSettingsFragment$diffAdapter$5 extends FunctionReferenceImpl implements Function1<TwoLinesItemDelegate.Model<String>, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public AppSettingsFragment$diffAdapter$5(Object obj) {
        super(1, obj, AppSettingsFragment.class, "handleMenuItemClick", "handleMenuItemClick(Lee/mtakso/driver/uicore/components/recyclerview/delegates/common/TwoLinesItemDelegate$Model;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(TwoLinesItemDelegate.Model<String> model) {
        j(model);
        return Unit.f50853a;
    }

    public final void j(TwoLinesItemDelegate.Model<String> p02) {
        Intrinsics.f(p02, "p0");
        ((AppSettingsFragment) this.f50989g).Y(p02);
    }
}
