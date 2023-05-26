package ee.mtakso.driver.ui.screens.campaigns.v2.details;

import ee.mtakso.driver.uikit.utils.Image;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CampaignImageMapper.kt */
/* loaded from: classes3.dex */
public final class CampaignImageMapper {
    public final Image a(ee.mtakso.driver.network.client.campaign.Image image) {
        Intrinsics.f(image, "image");
        return new Image.DarkLight(new Image.Url(image.b()), new Image.Url(image.a()));
    }
}
