package ee.mtakso.driver.ui.screens.inbox;

import ee.mtakso.driver.ui.interactor.inbox.InboxItem;
import ee.mtakso.driver.uicore.components.recyclerview.delegates.common.TwoLinesItemDelegate;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: InboxFragment.kt */
/* loaded from: classes3.dex */
public /* synthetic */ class InboxFragment$diffAdapter$2 extends FunctionReferenceImpl implements Function1<TwoLinesItemDelegate.Model<InboxItem>, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public InboxFragment$diffAdapter$2(Object obj) {
        super(1, obj, InboxFragment.class, "onItemTap", "onItemTap(Lee/mtakso/driver/uicore/components/recyclerview/delegates/common/TwoLinesItemDelegate$Model;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(TwoLinesItemDelegate.Model<InboxItem> model) {
        j(model);
        return Unit.f50853a;
    }

    public final void j(TwoLinesItemDelegate.Model<InboxItem> p02) {
        Intrinsics.f(p02, "p0");
        ((InboxFragment) this.f50989g).c0(p02);
    }
}
