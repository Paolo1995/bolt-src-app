package ee.mtakso.driver.ui.screens.campaigns.v2.details;

import ee.mtakso.driver.helper.DateTimeConverter;
import ee.mtakso.driver.network.client.campaign.DriverReferralCampaignInvitationStatus;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ReferralCampaignInvitationFactory.kt */
/* loaded from: classes3.dex */
public final class ReferralCampaignInvitationFactory {

    /* renamed from: a  reason: collision with root package name */
    private final DateTimeConverter f27537a;

    /* compiled from: ReferralCampaignInvitationFactory.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f27538a;

        static {
            int[] iArr = new int[DriverReferralCampaignInvitationStatus.values().length];
            try {
                iArr[DriverReferralCampaignInvitationStatus.EXPIRED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[DriverReferralCampaignInvitationStatus.IN_PROGRESS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[DriverReferralCampaignInvitationStatus.COMPLETED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f27538a = iArr;
        }
    }

    @Inject
    public ReferralCampaignInvitationFactory(DateTimeConverter dateTimeConverter) {
        Intrinsics.f(dateTimeConverter, "dateTimeConverter");
        this.f27537a = dateTimeConverter;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:14:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x012c  */
    /* JADX WARN: Type inference failed for: r2v19, types: [ee.mtakso.driver.uicore.components.recyclerview.decorations.NoDivider] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final ee.mtakso.driver.uikit.recyclerview.ListModel a(java.lang.String r37, boolean r38, ee.mtakso.driver.network.client.campaign.DriverReferralCampaignInvitation r39) {
        /*
            Method dump skipped, instructions count: 372
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: ee.mtakso.driver.ui.screens.campaigns.v2.details.ReferralCampaignInvitationFactory.a(java.lang.String, boolean, ee.mtakso.driver.network.client.campaign.DriverReferralCampaignInvitation):ee.mtakso.driver.uikit.recyclerview.ListModel");
    }
}
