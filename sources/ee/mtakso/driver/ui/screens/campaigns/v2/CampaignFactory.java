package ee.mtakso.driver.ui.screens.campaigns.v2;

import ee.mtakso.driver.R;
import ee.mtakso.driver.network.client.campaign.Badge;
import ee.mtakso.driver.network.client.campaign.Condition;
import ee.mtakso.driver.network.client.campaign.ConditionType;
import ee.mtakso.driver.network.client.campaign.DriverCampaignV2;
import ee.mtakso.driver.ui.screens.campaigns.v2.CampaignDelegate;
import ee.mtakso.driver.ui.utils.ThemedImageKt;
import ee.mtakso.driver.uicore.components.recyclerview.decorations.Divider;
import ee.mtakso.driver.uikit.utils.Color;
import ee.mtakso.driver.uikit.utils.Dimens;
import ee.mtakso.driver.uikit.utils.Image;
import ee.mtakso.driver.uikit.utils.Text;
import eu.bolt.android.engine.html.HtmlEngine;
import eu.bolt.kalev.Kalev;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CampaignFactory.kt */
/* loaded from: classes3.dex */
public final class CampaignFactory {

    /* renamed from: a  reason: collision with root package name */
    private final HtmlEngine f27301a;

    @Inject
    public CampaignFactory(HtmlEngine htmlEngine) {
        Intrinsics.f(htmlEngine, "htmlEngine");
        this.f27301a = htmlEngine;
    }

    public final CampaignDelegate.Model a(String listId, DriverCampaignV2 campaign) {
        ArrayList arrayList;
        ArrayList arrayList2;
        Text.Value value;
        int v7;
        Text.Value value2;
        boolean z7;
        int v8;
        Text.Value value3;
        Image image;
        Intrinsics.f(listId, "listId");
        Intrinsics.f(campaign, "campaign");
        long i8 = campaign.i();
        Text b8 = CampaignV2ExtKt.b(campaign);
        List<Badge> a8 = campaign.a();
        if (a8 != null) {
            v8 = CollectionsKt__IterablesKt.v(a8, 10);
            arrayList = new ArrayList(v8);
            for (Badge badge : a8) {
                String b9 = badge.b();
                if (b9 != null) {
                    value3 = new Text.Value(b9);
                } else {
                    value3 = null;
                }
                ee.mtakso.driver.network.client.campaign.Image a9 = badge.a();
                if (a9 != null) {
                    image = ThemedImageKt.a(a9);
                } else {
                    image = null;
                }
                arrayList.add(new CampaignDelegate.ChipModel(value3, image, CampaignV2ExtKt.a(badge.c())));
            }
        } else {
            arrayList = null;
        }
        Text.Value value4 = new Text.Value(campaign.q());
        Text.Value value5 = new Text.Value(campaign.d());
        Text.Value value6 = new Text.Value(campaign.j());
        Text.Value value7 = new Text.Value(campaign.f());
        List<Condition> e8 = campaign.e();
        if (e8 != null) {
            v7 = CollectionsKt__IterablesKt.v(e8, 10);
            arrayList2 = new ArrayList(v7);
            for (Condition condition : e8) {
                if (condition.c() == ConditionType.PROGRESS && condition.a() != null) {
                    value2 = new Text.Value(condition.a().b());
                    z7 = condition.a().d();
                } else if (condition.c() == ConditionType.THRESHOLD && condition.b() != null) {
                    value2 = new Text.Value(condition.b().a());
                    z7 = condition.b().c();
                } else {
                    Kalev.l("Unsupported condition " + condition);
                    value2 = new Text.Value("");
                    z7 = false;
                }
                arrayList2.add(new CampaignDelegate.ConditionModel(value2, z7));
            }
        } else {
            arrayList2 = null;
        }
        String n8 = campaign.n();
        if (n8 != null) {
            value = new Text.Value(this.f27301a.a(n8));
        } else {
            value = null;
        }
        return new CampaignDelegate.Model(listId, i8, b8, arrayList, value4, value5, value6, value7, arrayList2, value, new Divider(false, false, true, new Color.Attr(R.attr.backTertiary), null, Float.valueOf(Dimens.b(8.0f)), 19, null));
    }
}
