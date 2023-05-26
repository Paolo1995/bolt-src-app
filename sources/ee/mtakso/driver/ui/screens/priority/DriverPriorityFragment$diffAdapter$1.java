package ee.mtakso.driver.ui.screens.priority;

import ee.mtakso.driver.uicore.components.recyclerview.delegates.common.SimpleTextDelegate;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DriverPriorityFragment.kt */
/* loaded from: classes3.dex */
public /* synthetic */ class DriverPriorityFragment$diffAdapter$1 extends FunctionReferenceImpl implements Function1<SimpleTextDelegate.Model, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public DriverPriorityFragment$diffAdapter$1(Object obj) {
        super(1, obj, DriverPriorityFragment.class, "handleTextClick", "handleTextClick(Lee/mtakso/driver/uicore/components/recyclerview/delegates/common/SimpleTextDelegate$Model;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(SimpleTextDelegate.Model model) {
        j(model);
        return Unit.f50853a;
    }

    public final void j(SimpleTextDelegate.Model p02) {
        Intrinsics.f(p02, "p0");
        ((DriverPriorityFragment) this.f50989g).e0(p02);
    }
}
