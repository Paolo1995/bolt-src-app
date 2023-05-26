package ee.mtakso.driver.ui.screens.boltclub;

import ee.mtakso.driver.uicore.components.recyclerview.delegates.common.ButtonItemDelegate;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BoltClubOfferDetailsFragment.kt */
/* loaded from: classes3.dex */
public /* synthetic */ class BoltClubOfferDetailsFragment$adapter$2$1$1 extends FunctionReferenceImpl implements Function1<ButtonItemDelegate.Model<String>, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public BoltClubOfferDetailsFragment$adapter$2$1$1(Object obj) {
        super(1, obj, BoltClubOfferDetailsFragment.class, "handleButtonClick", "handleButtonClick(Lee/mtakso/driver/uicore/components/recyclerview/delegates/common/ButtonItemDelegate$Model;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ButtonItemDelegate.Model<String> model) {
        j(model);
        return Unit.f50853a;
    }

    public final void j(ButtonItemDelegate.Model<String> p02) {
        Intrinsics.f(p02, "p0");
        ((BoltClubOfferDetailsFragment) this.f50989g).a0(p02);
    }
}
