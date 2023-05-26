package ee.mtakso.driver.ui.screens.earnings.v2.payout.request;

import ee.mtakso.driver.uicore.components.recyclerview.delegates.generic.GenericItemDelegate;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PayoutRequestFragment.kt */
/* loaded from: classes3.dex */
public /* synthetic */ class PayoutRequestFragment$diffAdapter$2 extends FunctionReferenceImpl implements Function1<GenericItemDelegate.PopupInfo, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public PayoutRequestFragment$diffAdapter$2(Object obj) {
        super(1, obj, PayoutRequestFragment.class, "showPopup", "showPopup(Lee/mtakso/driver/uicore/components/recyclerview/delegates/generic/GenericItemDelegate$PopupInfo;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(GenericItemDelegate.PopupInfo popupInfo) {
        j(popupInfo);
        return Unit.f50853a;
    }

    public final void j(GenericItemDelegate.PopupInfo popupInfo) {
        ((PayoutRequestFragment) this.f50989g).k0(popupInfo);
    }
}
