package ee.mtakso.driver.ui.screens.destination.edit;

import ee.mtakso.driver.uicore.components.recyclerview.delegates.common.TwoLinesItemDelegate;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DestinationEditBottomDialogFragment.kt */
/* loaded from: classes3.dex */
/* synthetic */ class DestinationEditBottomDialogFragment$diffAdapter$1 extends FunctionReferenceImpl implements Function1<TwoLinesItemDelegate.Model<DestinationAction>, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public DestinationEditBottomDialogFragment$diffAdapter$1(Object obj) {
        super(1, obj, DestinationEditBottomDialogFragment.class, "handleItemClick", "handleItemClick(Lee/mtakso/driver/uicore/components/recyclerview/delegates/common/TwoLinesItemDelegate$Model;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(TwoLinesItemDelegate.Model<DestinationAction> model) {
        j(model);
        return Unit.f50853a;
    }

    public final void j(TwoLinesItemDelegate.Model<DestinationAction> p02) {
        Intrinsics.f(p02, "p0");
        ((DestinationEditBottomDialogFragment) this.f50989g).d0(p02);
    }
}