package ee.mtakso.driver.ui.screens.campaigns.v2.details;

import ee.mtakso.driver.R;
import ee.mtakso.driver.network.client.campaign.Condition;
import ee.mtakso.driver.network.client.campaign.InfoBlock;
import ee.mtakso.driver.network.client.campaign.TCMessage;
import ee.mtakso.driver.ui.screens.campaigns.v2.details.CampaignConditionDelegate;
import ee.mtakso.driver.ui.screens.campaigns.v2.details.CampaignNoteDelegate;
import ee.mtakso.driver.ui.views.infoblock.InfoBlockType;
import ee.mtakso.driver.uicore.components.recyclerview.delegates.common.InfoBlockDelegate;
import ee.mtakso.driver.uikit.recyclerview.ListModel;
import ee.mtakso.driver.uikit.utils.Background;
import ee.mtakso.driver.uikit.utils.Color;
import ee.mtakso.driver.uikit.utils.Dimens;
import ee.mtakso.driver.uikit.utils.Image;
import ee.mtakso.driver.uikit.utils.Margins;
import ee.mtakso.driver.uikit.utils.Text;
import eu.bolt.android.engine.html.HtmlEngine;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CampaignDynamicItemsMapper.kt */
/* loaded from: classes3.dex */
public final class CampaignDynamicItemsMapper {

    /* renamed from: a  reason: collision with root package name */
    private final CampaignInfoBlockMapper f27467a;

    /* renamed from: b  reason: collision with root package name */
    private final HtmlEngine f27468b;

    @Inject
    public CampaignDynamicItemsMapper(CampaignInfoBlockMapper campaignInfoBlockMapper, HtmlEngine htmlEngine) {
        Intrinsics.f(campaignInfoBlockMapper, "campaignInfoBlockMapper");
        Intrinsics.f(htmlEngine, "htmlEngine");
        this.f27467a = campaignInfoBlockMapper;
        this.f27468b = htmlEngine;
    }

    private final ListModel a(String str, InfoBlock infoBlock) {
        Text.Value value;
        Image image;
        int c8;
        InfoBlockType d8 = this.f27467a.a(infoBlock).d();
        Text.Value value2 = new Text.Value(this.f27468b.a(infoBlock.d()));
        Color j8 = d8.j();
        String c9 = infoBlock.c();
        if (c9 != null) {
            value = new Text.Value(c9);
        } else {
            value = null;
        }
        Color.Attr attr = new Color.Attr(R.attr.contentPrimary);
        Color c10 = d8.c();
        Background.Attr attr2 = new Background.Attr(R.attr.infoBlockBackground);
        if (infoBlock.b()) {
            image = d8.e();
        } else {
            image = null;
        }
        Color f8 = d8.f();
        int c11 = Dimens.c(24);
        int c12 = Dimens.c(24);
        if (infoBlock.b()) {
            c8 = Dimens.c(12);
        } else {
            c8 = Dimens.c(16);
        }
        return new InfoBlockDelegate.Model(str, value2, 2132017742, j8, null, value, attr, null, attr2, c10, image, f8, c11, c12, new Margins(c8, Dimens.c(12), Dimens.c(16), Dimens.c(12)), 144, null);
    }

    private final ListModel b(String str, TCMessage tCMessage) {
        return new CampaignNoteDelegate.Model(str, new Text.Value(this.f27468b.a(tCMessage.a())));
    }

    private final int d(List<Condition> list, int i8) {
        int m8;
        int i9;
        m8 = CollectionsKt__CollectionsKt.m(list);
        if (m8 == i8) {
            i9 = 26;
        } else {
            i9 = 10;
        }
        return Dimens.c(i9);
    }

    public final CampaignDynamicItemsState c(List<Condition> list, TCMessage tcMessage, List<InfoBlock> list2) {
        int v7;
        int v8;
        Intrinsics.f(tcMessage, "tcMessage");
        ArrayList arrayList = new ArrayList();
        int i8 = 0;
        if (list != null) {
            v8 = CollectionsKt__IterablesKt.v(list, 10);
            ArrayList arrayList2 = new ArrayList(v8);
            int i9 = 0;
            for (Object obj : list) {
                int i10 = i9 + 1;
                if (i9 < 0) {
                    CollectionsKt__CollectionsKt.u();
                }
                arrayList2.add(new CampaignConditionDelegate.Model("requirement_" + i9, (Condition) obj, Integer.valueOf(d(list, i9)), null, 8, null));
                i9 = i10;
            }
            arrayList.addAll(arrayList2);
        }
        arrayList.add(b("note_t_and_c", tcMessage));
        if (list2 != null) {
            v7 = CollectionsKt__IterablesKt.v(list2, 10);
            ArrayList arrayList3 = new ArrayList(v7);
            for (Object obj2 : list2) {
                int i11 = i8 + 1;
                if (i8 < 0) {
                    CollectionsKt__CollectionsKt.u();
                }
                arrayList3.add(a("info_block_" + i8, (InfoBlock) obj2));
                i8 = i11;
            }
            arrayList.addAll(arrayList3);
        }
        return new CampaignDynamicItemsState(arrayList);
    }
}
