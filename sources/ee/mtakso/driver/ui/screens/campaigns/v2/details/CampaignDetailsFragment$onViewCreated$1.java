package ee.mtakso.driver.ui.screens.campaigns.v2.details;

import ee.mtakso.driver.ui.screens.campaigns.v2.details.CampaignConditionDelegate;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CampaignDetailsFragment.kt */
/* loaded from: classes3.dex */
/* synthetic */ class CampaignDetailsFragment$onViewCreated$1 extends FunctionReferenceImpl implements Function1<CampaignConditionDelegate.Model, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public CampaignDetailsFragment$onViewCreated$1(Object obj) {
        super(1, obj, CampaignDetailsFragment.class, "onInfoClicked", "onInfoClicked(Lee/mtakso/driver/ui/screens/campaigns/v2/details/CampaignConditionDelegate$Model;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(CampaignConditionDelegate.Model model) {
        j(model);
        return Unit.f50853a;
    }

    public final void j(CampaignConditionDelegate.Model p02) {
        Intrinsics.f(p02, "p0");
        ((CampaignDetailsFragment) this.f50989g).b0(p02);
    }
}
