package ee.mtakso.driver.ui.screens.work;

import ee.mtakso.driver.uicore.components.recyclerview.delegates.common.ButtonItemDelegate;
import eu.bolt.driver.earnings.network.DriverButtonAction;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: WorkFifoQueueDelegate.kt */
/* loaded from: classes5.dex */
public /* synthetic */ class WorkFifoQueueDelegate$adapter$1 extends FunctionReferenceImpl implements Function1<ButtonItemDelegate.Model<DriverButtonAction>, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public WorkFifoQueueDelegate$adapter$1(Object obj) {
        super(1, obj, WorkFifoQueueDelegate.class, "onButtonClicked", "onButtonClicked(Lee/mtakso/driver/uicore/components/recyclerview/delegates/common/ButtonItemDelegate$Model;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ButtonItemDelegate.Model<DriverButtonAction> model) {
        j(model);
        return Unit.f50853a;
    }

    public final void j(ButtonItemDelegate.Model<DriverButtonAction> p02) {
        Intrinsics.f(p02, "p0");
        ((WorkFifoQueueDelegate) this.f50989g).j(p02);
    }
}
