package ee.mtakso.driver.ui.screens.dialogs.rateme;

import ee.mtakso.driver.ui.interactor.rateme.RateMeItem;
import ee.mtakso.driver.uicore.components.recyclerview.delegates.common.TwoLinesItemDelegate;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RateMeReasonsFragment.kt */
/* loaded from: classes3.dex */
public /* synthetic */ class RateMeReasonsFragment$diffAdapter$1 extends FunctionReferenceImpl implements Function1<TwoLinesItemDelegate.Model<RateMeItem>, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public RateMeReasonsFragment$diffAdapter$1(Object obj) {
        super(1, obj, RateMeReasonsFragment.class, "handleMenuItemClick", "handleMenuItemClick(Lee/mtakso/driver/uicore/components/recyclerview/delegates/common/TwoLinesItemDelegate$Model;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(TwoLinesItemDelegate.Model<RateMeItem> model) {
        j(model);
        return Unit.f50853a;
    }

    public final void j(TwoLinesItemDelegate.Model<RateMeItem> p02) {
        Intrinsics.f(p02, "p0");
        ((RateMeReasonsFragment) this.f50989g).Z(p02);
    }
}
