package ee.mtakso.driver.ui.screens.campaigns.v2;

import android.text.SpannableStringBuilder;
import android.text.style.BulletSpan;
import ee.mtakso.driver.R;
import ee.mtakso.driver.network.client.campaign.Badge;
import ee.mtakso.driver.network.client.campaign.Condition;
import ee.mtakso.driver.network.client.campaign.DriverCampaignV2;
import ee.mtakso.driver.network.client.campaign.ProgressCondition;
import ee.mtakso.driver.network.client.campaign.ThresholdCondition;
import ee.mtakso.driver.ui.screens.campaigns.v2.CampaignDelegate;
import ee.mtakso.driver.ui.utils.ThemedImageKt;
import ee.mtakso.driver.uicore.components.recyclerview.decorations.Divider;
import ee.mtakso.driver.uikit.utils.Color;
import ee.mtakso.driver.uikit.utils.Dimens;
import ee.mtakso.driver.uikit.utils.Image;
import ee.mtakso.driver.uikit.utils.Text;
import eu.bolt.android.engine.html.HtmlEngine;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.StringsKt___StringsKt;

/* compiled from: FutureCampaignFactory.kt */
/* loaded from: classes3.dex */
public final class FutureCampaignFactory {

    /* renamed from: a  reason: collision with root package name */
    private final HtmlEngine f27329a;

    @Inject
    public FutureCampaignFactory(HtmlEngine htmlEngine) {
        Intrinsics.f(htmlEngine, "htmlEngine");
        this.f27329a = htmlEngine;
    }

    private final Text b(DriverCampaignV2 driverCampaignV2) {
        char c12;
        int V;
        int V2;
        String str;
        List<Condition> e8 = driverCampaignV2.e();
        if (e8 == null) {
            return null;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        Iterator<T> it = e8.iterator();
        int i8 = 0;
        while (true) {
            boolean z7 = true;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            int i9 = i8 + 1;
            if (i8 < 0) {
                CollectionsKt__CollectionsKt.u();
            }
            Condition condition = (Condition) next;
            ProgressCondition a8 = condition.a();
            if (a8 == null || (str = a8.a()) == null) {
                ThresholdCondition b8 = condition.b();
                if (b8 != null) {
                    str = b8.a();
                } else {
                    str = null;
                }
            }
            if (str != null && str.length() != 0) {
                z7 = false;
            }
            if (!z7) {
                int length = spannableStringBuilder.length();
                spannableStringBuilder.append((CharSequence) str);
                spannableStringBuilder.setSpan(new BulletSpan(Dimens.c(8)), length, spannableStringBuilder.length(), 17);
                Intrinsics.e(spannableStringBuilder.append('\n'), "append('\\n')");
            }
            i8 = i9;
        }
        c12 = StringsKt___StringsKt.c1(spannableStringBuilder);
        if (c12 == '\n') {
            V = StringsKt__StringsKt.V(spannableStringBuilder);
            V2 = StringsKt__StringsKt.V(spannableStringBuilder);
            spannableStringBuilder.delete(V, V2 + 1);
        }
        return new Text.Value(spannableStringBuilder);
    }

    public final CampaignDelegate.Model a(String listId, DriverCampaignV2 campaign) {
        ArrayList arrayList;
        Text.Value value;
        int v7;
        Text.Value value2;
        Image image;
        Intrinsics.f(listId, "listId");
        Intrinsics.f(campaign, "campaign");
        long i8 = campaign.i();
        Text b8 = CampaignV2ExtKt.b(campaign);
        List<Badge> a8 = campaign.a();
        if (a8 != null) {
            v7 = CollectionsKt__IterablesKt.v(a8, 10);
            arrayList = new ArrayList(v7);
            for (Badge badge : a8) {
                String b9 = badge.b();
                if (b9 != null) {
                    value2 = new Text.Value(b9);
                } else {
                    value2 = null;
                }
                ee.mtakso.driver.network.client.campaign.Image a9 = badge.a();
                if (a9 != null) {
                    image = ThemedImageKt.a(a9);
                } else {
                    image = null;
                }
                arrayList.add(new CampaignDelegate.ChipModel(value2, image, CampaignV2ExtKt.a(badge.c())));
            }
        } else {
            arrayList = null;
        }
        Text.Value value3 = new Text.Value(campaign.q());
        Text.Value value4 = new Text.Value(campaign.d());
        Text.Value value5 = new Text.Value(campaign.j());
        Text b10 = b(campaign);
        String n8 = campaign.n();
        if (n8 != null) {
            value = new Text.Value(this.f27329a.a(n8));
        } else {
            value = null;
        }
        return new CampaignDelegate.Model(listId, i8, b8, arrayList, value3, value4, value5, b10, null, value, new Divider(false, false, true, new Color.Attr(R.attr.backTertiary), null, Float.valueOf(Dimens.b(8.0f)), 19, null));
    }
}
