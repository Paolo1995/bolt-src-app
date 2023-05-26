package ee.mtakso.driver.ui.screens.destination;

import ee.mtakso.driver.network.client.settings.DriverDestination;
import ee.mtakso.driver.uicore.components.recyclerview.delegates.common.TwoLinesItemDelegate;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DestinationFragment.kt */
/* loaded from: classes3.dex */
public /* synthetic */ class DestinationFragment$diffAdapter$1 extends FunctionReferenceImpl implements Function1<TwoLinesItemDelegate.Model<DriverDestination>, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public DestinationFragment$diffAdapter$1(Object obj) {
        super(1, obj, DestinationFragment.class, "handleItemClick", "handleItemClick(Lee/mtakso/driver/uicore/components/recyclerview/delegates/common/TwoLinesItemDelegate$Model;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(TwoLinesItemDelegate.Model<DriverDestination> model) {
        j(model);
        return Unit.f50853a;
    }

    public final void j(TwoLinesItemDelegate.Model<DriverDestination> p02) {
        Intrinsics.f(p02, "p0");
        ((DestinationFragment) this.f50989g).o0(p02);
    }
}
