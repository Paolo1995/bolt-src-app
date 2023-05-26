package ee.mtakso.driver.ui.screens.campaigns.v2.details;

import ee.mtakso.driver.R;
import ee.mtakso.driver.helper.DateTimeConverter;
import ee.mtakso.driver.network.client.campaign.Bonus;
import ee.mtakso.driver.network.client.campaign.DriverReferralCampaignInvitation;
import ee.mtakso.driver.network.client.campaign.DriverReferralCampaignInvitesDetails;
import ee.mtakso.driver.network.client.campaign.InviteCampaign;
import ee.mtakso.driver.network.client.campaign.InviteCampaignV2Summary;
import ee.mtakso.driver.network.client.campaign.TCMessage;
import ee.mtakso.driver.param.DriverConfig;
import ee.mtakso.driver.service.time.TrueTimeProvider;
import ee.mtakso.driver.uikit.utils.Text;
import eu.bolt.android.engine.html.HtmlEngine;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: ReferralCampaignMapper.kt */
/* loaded from: classes3.dex */
public final class ReferralCampaignMapper {

    /* renamed from: a  reason: collision with root package name */
    private final TrueTimeProvider f27540a;

    /* renamed from: b  reason: collision with root package name */
    private final DriverConfig f27541b;

    /* renamed from: c  reason: collision with root package name */
    private final ReferralCampaignInvitationFactory f27542c;

    /* renamed from: d  reason: collision with root package name */
    private final DateTimeConverter f27543d;

    /* renamed from: e  reason: collision with root package name */
    private final HtmlEngine f27544e;

    @Inject
    public ReferralCampaignMapper(TrueTimeProvider trueTimeProvider, DriverConfig driver, ReferralCampaignInvitationFactory referralCampaignInvitationFactory, DateTimeConverter dateTimeConverter, HtmlEngine htmlEngine) {
        Intrinsics.f(trueTimeProvider, "trueTimeProvider");
        Intrinsics.f(driver, "driver");
        Intrinsics.f(referralCampaignInvitationFactory, "referralCampaignInvitationFactory");
        Intrinsics.f(dateTimeConverter, "dateTimeConverter");
        Intrinsics.f(htmlEngine, "htmlEngine");
        this.f27540a = trueTimeProvider;
        this.f27541b = driver;
        this.f27542c = referralCampaignInvitationFactory;
        this.f27543d = dateTimeConverter;
        this.f27544e = htmlEngine;
    }

    private final Text a(InviteCampaignV2Summary inviteCampaignV2Summary) {
        boolean y7;
        boolean O;
        String str;
        List e8;
        List n8;
        if (inviteCampaignV2Summary.b() != null && inviteCampaignV2Summary.b().h() > TimeUnit.SECONDS.convert(this.f27540a.b(), TimeUnit.MILLISECONDS)) {
            n8 = CollectionsKt__CollectionsKt.n(inviteCampaignV2Summary.b().f(), inviteCampaignV2Summary.a(), inviteCampaignV2Summary.d());
            return new Text.Resource(R.string.share_campaign_driver_referrals, n8);
        }
        y7 = StringsKt__StringsJVMKt.y(inviteCampaignV2Summary.d());
        if (!y7) {
            str = inviteCampaignV2Summary.d();
        } else {
            O = StringsKt__StringsKt.O("liveGoogle", "prelive", true);
            if (O) {
                str = "https://partners.prelive.bolt.eu/#?refid=%s";
            } else {
                str = "https://partners.bolt.eu/#?refid=%s";
            }
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.f51021a;
        String format = String.format(str, Arrays.copyOf(new Object[]{new String[]{this.f27541b.E()}}, 1));
        Intrinsics.e(format, "format(format, *args)");
        e8 = CollectionsKt__CollectionsJVMKt.e(format);
        return new Text.Resource(R.string.drive_with_taxify, e8);
    }

    private final boolean b(InviteCampaignV2Summary inviteCampaignV2Summary) {
        if (inviteCampaignV2Summary.b() == null && inviteCampaignV2Summary.c() == null) {
            return true;
        }
        return false;
    }

    private final boolean c(InviteCampaignV2Summary inviteCampaignV2Summary) {
        if (inviteCampaignV2Summary.b() != null && inviteCampaignV2Summary.b().h() > TimeUnit.SECONDS.convert(this.f27540a.b(), TimeUnit.MILLISECONDS)) {
            return true;
        }
        return false;
    }

    public final ReferralCampaignState d(InviteCampaignV2Summary campaign) {
        List k8;
        Long l8;
        Text.Resource resource;
        Text.Value value;
        Text.Value value2;
        Text.Value value3;
        Bonus bonus;
        Text.Value value4;
        List k9;
        ArrayList arrayList;
        Text.Value value5;
        TCMessage g8;
        String a8;
        List<DriverReferralCampaignInvitation> a9;
        int v7;
        int m8;
        boolean z7;
        String c8;
        String e8;
        String b8;
        String b9;
        boolean y7;
        Text.Value value6;
        List e9;
        List k10;
        Intrinsics.f(campaign, "campaign");
        if (b(campaign)) {
            Text.Resource resource2 = new Text.Resource(R.string.referral_title_no_campaign, null, 2, null);
            Text a10 = a(campaign);
            String E = this.f27541b.E();
            k10 = CollectionsKt__CollectionsKt.k();
            return new ReferralCampaignState(null, resource2, null, null, null, null, a10, E, null, null, k10, null, true);
        } else if (c(campaign)) {
            InviteCampaign b10 = campaign.b();
            if (b10 != null) {
                l8 = Long.valueOf(b10.d());
            } else {
                l8 = null;
            }
            Text.Resource resource3 = new Text.Resource(R.string.referral_title, null, 2, null);
            InviteCampaign b11 = campaign.b();
            if (b11 != null) {
                e9 = CollectionsKt__CollectionsJVMKt.e(this.f27543d.a(Long.valueOf(b11.h())));
                resource = new Text.Resource(R.string.referral_until, e9);
            } else {
                resource = null;
            }
            DriverReferralCampaignInvitesDetails c9 = campaign.c();
            if (c9 != null && (b9 = c9.b()) != null) {
                y7 = StringsKt__StringsJVMKt.y(b9);
                if (!y7) {
                    value6 = new Text.Value(b9);
                } else {
                    value6 = null;
                }
                value = value6;
            } else {
                value = null;
            }
            InviteCampaign b12 = campaign.b();
            if (b12 != null && (b8 = b12.b()) != null) {
                value2 = new Text.Value(b8);
            } else {
                value2 = null;
            }
            InviteCampaign b13 = campaign.b();
            if (b13 != null && (e8 = b13.e()) != null) {
                value3 = new Text.Value(e8);
            } else {
                value3 = null;
            }
            Text a11 = a(campaign);
            String a12 = campaign.a();
            InviteCampaign b14 = campaign.b();
            if (b14 != null) {
                bonus = b14.a();
            } else {
                bonus = null;
            }
            InviteCampaign b15 = campaign.b();
            if (b15 != null && (c8 = b15.c()) != null) {
                value4 = new Text.Value(c8);
            } else {
                value4 = null;
            }
            DriverReferralCampaignInvitesDetails c10 = campaign.c();
            if (c10 != null && (a9 = c10.a()) != null) {
                v7 = CollectionsKt__IterablesKt.v(a9, 10);
                ArrayList arrayList2 = new ArrayList(v7);
                Iterator it = a9.iterator();
                int i8 = 0;
                while (it.hasNext()) {
                    Object next = it.next();
                    int i9 = i8 + 1;
                    if (i8 < 0) {
                        CollectionsKt__CollectionsKt.u();
                    }
                    DriverReferralCampaignInvitation driverReferralCampaignInvitation = (DriverReferralCampaignInvitation) next;
                    ReferralCampaignInvitationFactory referralCampaignInvitationFactory = this.f27542c;
                    Iterator it2 = it;
                    String str = "invitation_" + i8;
                    m8 = CollectionsKt__CollectionsKt.m(campaign.c().a());
                    if (i8 == m8) {
                        z7 = true;
                    } else {
                        z7 = false;
                    }
                    arrayList2.add(referralCampaignInvitationFactory.a(str, z7, driverReferralCampaignInvitation));
                    i8 = i9;
                    it = it2;
                }
                arrayList = arrayList2;
            } else {
                k9 = CollectionsKt__CollectionsKt.k();
                arrayList = k9;
            }
            InviteCampaign b16 = campaign.b();
            if (b16 != null && (g8 = b16.g()) != null && (a8 = g8.a()) != null) {
                value5 = new Text.Value(this.f27544e.a(a8));
            } else {
                value5 = null;
            }
            return new ReferralCampaignState(l8, resource3, resource, value, value2, value3, a11, a12, bonus, value4, arrayList, value5, false, 4096, null);
        } else {
            Text.Resource resource4 = new Text.Resource(R.string.referral_title, null, 2, null);
            Text a13 = a(campaign);
            String E2 = this.f27541b.E();
            Text.Resource resource5 = new Text.Resource(R.string.title_campaign_driver_referral_no_reward, null, 2, null);
            k8 = CollectionsKt__CollectionsKt.k();
            return new ReferralCampaignState(null, resource4, null, null, null, null, a13, E2, null, resource5, k8, null, false, 4096, null);
        }
    }
}
