package ee.mtakso.driver.ui.screens.settings.language;

import ee.mtakso.driver.uicore.components.recyclerview.delegates.common.TwoLinesItemDelegate;
import eu.bolt.driver.core.language.Language;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LanguageSettingsFragment.kt */
/* loaded from: classes5.dex */
public /* synthetic */ class LanguageSettingsFragment$diffAdapter$1 extends FunctionReferenceImpl implements Function1<TwoLinesItemDelegate.Model<Language>, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public LanguageSettingsFragment$diffAdapter$1(Object obj) {
        super(1, obj, LanguageSettingsFragment.class, "handleMenuItemClick", "handleMenuItemClick(Lee/mtakso/driver/uicore/components/recyclerview/delegates/common/TwoLinesItemDelegate$Model;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(TwoLinesItemDelegate.Model<Language> model) {
        j(model);
        return Unit.f50853a;
    }

    public final void j(TwoLinesItemDelegate.Model<Language> p02) {
        Intrinsics.f(p02, "p0");
        ((LanguageSettingsFragment) this.f50989g).V(p02);
    }
}
