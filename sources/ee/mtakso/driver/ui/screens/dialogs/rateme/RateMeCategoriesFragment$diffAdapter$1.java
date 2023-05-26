package ee.mtakso.driver.ui.screens.dialogs.rateme;

import ee.mtakso.driver.ui.interactor.rateme.RateMeCategory;
import ee.mtakso.driver.uicore.components.recyclerview.delegates.common.TwoLinesItemDelegate;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RateMeCategoriesFragment.kt */
/* loaded from: classes3.dex */
public /* synthetic */ class RateMeCategoriesFragment$diffAdapter$1 extends FunctionReferenceImpl implements Function1<TwoLinesItemDelegate.Model<RateMeCategory>, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public RateMeCategoriesFragment$diffAdapter$1(Object obj) {
        super(1, obj, RateMeCategoriesFragment.class, "handleMenuItemClick", "handleMenuItemClick(Lee/mtakso/driver/uicore/components/recyclerview/delegates/common/TwoLinesItemDelegate$Model;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(TwoLinesItemDelegate.Model<RateMeCategory> model) {
        j(model);
        return Unit.f50853a;
    }

    public final void j(TwoLinesItemDelegate.Model<RateMeCategory> p02) {
        Intrinsics.f(p02, "p0");
        ((RateMeCategoriesFragment) this.f50989g).Y(p02);
    }
}
