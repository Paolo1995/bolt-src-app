package ee.mtakso.driver.ui.screens.campaigns.v2;

import ee.mtakso.driver.R;
import ee.mtakso.driver.network.client.campaign.BadgeType;
import ee.mtakso.driver.network.client.campaign.DriverCampaignV2;
import ee.mtakso.driver.uikit.utils.Color;
import ee.mtakso.driver.uikit.utils.Text;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CampaignV2Ext.kt */
/* loaded from: classes3.dex */
public final class CampaignV2ExtKt {

    /* compiled from: CampaignV2Ext.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f27328a;

        static {
            int[] iArr = new int[BadgeType.values().length];
            try {
                iArr[BadgeType.DEFAULT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[BadgeType.INFO.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[BadgeType.SUCCESS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f27328a = iArr;
        }
    }

    public static final Color a(BadgeType badgeType) {
        Intrinsics.f(badgeType, "<this>");
        int i8 = WhenMappings.f27328a[badgeType.ordinal()];
        if (i8 != 1) {
            if (i8 != 2) {
                if (i8 == 3) {
                    return new Color.Attr(R.attr.accentGreen);
                }
                throw new NoWhenBranchMatchedException();
            }
            return new Color.Attr(R.attr.accentOrange);
        }
        return new Color.Res(R.color.purple500);
    }

    public static final Text b(DriverCampaignV2 driverCampaignV2) {
        boolean z7;
        List n8;
        Intrinsics.f(driverCampaignV2, "<this>");
        if (driverCampaignV2.k() != null) {
            return new Text.Value(driverCampaignV2.k());
        }
        if (driverCampaignV2.l() != null) {
            List<String> b8 = driverCampaignV2.l().b();
            if (b8 != null && !b8.isEmpty()) {
                z7 = false;
            } else {
                z7 = true;
            }
            if (!z7) {
                if (driverCampaignV2.l().b().size() == 1) {
                    return new Text.Value(driverCampaignV2.l().b().get(0));
                }
                n8 = CollectionsKt__CollectionsKt.n(driverCampaignV2.l().b().get(0), driverCampaignV2.l().a());
                return new Text.Resource(R.string.campaign_period_label_format, n8);
            }
        }
        return null;
    }
}
