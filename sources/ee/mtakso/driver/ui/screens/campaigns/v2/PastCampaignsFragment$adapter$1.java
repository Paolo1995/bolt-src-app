package ee.mtakso.driver.ui.screens.campaigns.v2;

import ee.mtakso.driver.ui.screens.campaigns.v2.CampaignDelegate;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PastCampaignsFragment.kt */
/* loaded from: classes3.dex */
public /* synthetic */ class PastCampaignsFragment$adapter$1 extends FunctionReferenceImpl implements Function1<CampaignDelegate.Model, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public PastCampaignsFragment$adapter$1(Object obj) {
        super(1, obj, PastCampaignsFragment.class, "onItemClicked", "onItemClicked(Lee/mtakso/driver/ui/screens/campaigns/v2/CampaignDelegate$Model;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(CampaignDelegate.Model model) {
        j(model);
        return Unit.f50853a;
    }

    public final void j(CampaignDelegate.Model p02) {
        Intrinsics.f(p02, "p0");
        ((PastCampaignsFragment) this.f50989g).Z(p02);
    }
}
