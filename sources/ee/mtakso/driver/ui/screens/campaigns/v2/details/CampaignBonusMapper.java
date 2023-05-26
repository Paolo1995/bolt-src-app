package ee.mtakso.driver.ui.screens.campaigns.v2.details;

import ee.mtakso.driver.network.client.campaign.Bonus;
import ee.mtakso.driver.network.client.campaign.InfoBlock;
import ee.mtakso.driver.network.client.campaign.ThresholdData;
import ee.mtakso.driver.ui.screens.campaigns.v2.details.CampaignBonusController;
import ee.mtakso.driver.ui.views.infoblock.InfoBlockData;
import ee.mtakso.driver.uikit.utils.Image;
import ee.mtakso.driver.uikit.utils.Text;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CampaignBonusMapper.kt */
/* loaded from: classes3.dex */
public final class CampaignBonusMapper {

    /* renamed from: a  reason: collision with root package name */
    private final CampaignImageMapper f27413a;

    /* renamed from: b  reason: collision with root package name */
    private final CampaignInfoBlockMapper f27414b;

    @Inject
    public CampaignBonusMapper(CampaignImageMapper campaignImageMapper, CampaignInfoBlockMapper campaignInfoBlockMapper) {
        Intrinsics.f(campaignImageMapper, "campaignImageMapper");
        Intrinsics.f(campaignInfoBlockMapper, "campaignInfoBlockMapper");
        this.f27413a = campaignImageMapper;
        this.f27414b = campaignInfoBlockMapper;
    }

    public final CampaignBonusController.Model a(Bonus bonus) {
        Text.Value value;
        Integer num;
        Text.Value value2;
        Text.Value value3;
        Text.Value value4;
        InfoBlockData infoBlockData;
        String c8;
        String a8;
        String b8;
        Intrinsics.f(bonus, "bonus");
        Image a9 = this.f27413a.a(bonus.b());
        Text.Value value5 = new Text.Value(bonus.e());
        String c9 = bonus.c();
        if (c9 != null) {
            value = new Text.Value(c9);
        } else {
            value = null;
        }
        ThresholdData d8 = bonus.d();
        if (d8 != null) {
            num = Integer.valueOf(d8.d());
        } else {
            num = null;
        }
        ThresholdData d9 = bonus.d();
        if (d9 != null && (b8 = d9.b()) != null) {
            value2 = new Text.Value(b8);
        } else {
            value2 = null;
        }
        ThresholdData d10 = bonus.d();
        if (d10 != null && (a8 = d10.a()) != null) {
            value3 = new Text.Value(a8);
        } else {
            value3 = null;
        }
        ThresholdData d11 = bonus.d();
        if (d11 != null && (c8 = d11.c()) != null) {
            value4 = new Text.Value(c8);
        } else {
            value4 = null;
        }
        InfoBlock a10 = bonus.a();
        if (a10 != null) {
            infoBlockData = this.f27414b.a(a10);
        } else {
            infoBlockData = null;
        }
        return new CampaignBonusController.Model(a9, value5, value, num, value2, value3, value4, infoBlockData);
    }
}
