package ee.mtakso.driver.ui.screens.settings;

import ee.mtakso.driver.uicore.components.recyclerview.delegates.common.TextCenteredDelegate;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SettingsFragment.kt */
/* loaded from: classes5.dex */
public /* synthetic */ class SettingsFragment$diffAdapter$2 extends FunctionReferenceImpl implements Function1<TextCenteredDelegate.Model, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public SettingsFragment$diffAdapter$2(Object obj) {
        super(1, obj, SettingsFragment.class, "handleClick", "handleClick(Lee/mtakso/driver/uicore/components/recyclerview/delegates/common/TextCenteredDelegate$Model;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(TextCenteredDelegate.Model model) {
        j(model);
        return Unit.f50853a;
    }

    public final void j(TextCenteredDelegate.Model p02) {
        Intrinsics.f(p02, "p0");
        ((SettingsFragment) this.f50989g).i0(p02);
    }
}
