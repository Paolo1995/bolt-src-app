package ee.mtakso.driver.ui.screens.campaigns.v2;

import ee.mtakso.driver.ui.screens.campaigns.v2.CampaignDelegate;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ActiveCampaignsFragment.kt */
/* loaded from: classes3.dex */
public /* synthetic */ class ActiveCampaignsFragment$adapter$3 extends FunctionReferenceImpl implements Function1<CampaignDelegate.Model, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public ActiveCampaignsFragment$adapter$3(Object obj) {
        super(1, obj, ActiveCampaignsFragment.class, "onItemClicked", "onItemClicked(Lee/mtakso/driver/ui/screens/campaigns/v2/CampaignDelegate$Model;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(CampaignDelegate.Model model) {
        j(model);
        return Unit.f50853a;
    }

    public final void j(CampaignDelegate.Model p02) {
        Intrinsics.f(p02, "p0");
        ((ActiveCampaignsFragment) this.f50989g).f0(p02);
    }
}
