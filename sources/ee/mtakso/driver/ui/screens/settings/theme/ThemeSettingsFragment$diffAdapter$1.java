package ee.mtakso.driver.ui.screens.settings.theme;

import ee.mtakso.driver.uicore.components.recyclerview.delegates.common.TwoLinesItemDelegate;
import eu.bolt.driver.core.theme.AppThemeMode;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ThemeSettingsFragment.kt */
/* loaded from: classes5.dex */
public /* synthetic */ class ThemeSettingsFragment$diffAdapter$1 extends FunctionReferenceImpl implements Function1<TwoLinesItemDelegate.Model<AppThemeMode>, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public ThemeSettingsFragment$diffAdapter$1(Object obj) {
        super(1, obj, ThemeSettingsFragment.class, "handleMenuItemClick", "handleMenuItemClick(Lee/mtakso/driver/uicore/components/recyclerview/delegates/common/TwoLinesItemDelegate$Model;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(TwoLinesItemDelegate.Model<AppThemeMode> model) {
        j(model);
        return Unit.f50853a;
    }

    public final void j(TwoLinesItemDelegate.Model<AppThemeMode> p02) {
        Intrinsics.f(p02, "p0");
        ((ThemeSettingsFragment) this.f50989g).W(p02);
    }
}
