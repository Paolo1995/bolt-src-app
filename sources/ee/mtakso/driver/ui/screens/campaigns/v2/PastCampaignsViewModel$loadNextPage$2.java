package ee.mtakso.driver.ui.screens.campaigns.v2;

import ee.mtakso.driver.network.client.campaign.CampaignV2Group;
import ee.mtakso.driver.network.client.campaign.DriverCampaignV2;
import ee.mtakso.driver.network.client.campaign.PastCampaignsV2;
import ee.mtakso.driver.uicore.components.recyclerview.delegates.generic.GenericTitleDelegate;
import j$.util.Collection$EL;
import j$.util.function.Predicate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PastCampaignsViewModel.kt */
/* loaded from: classes3.dex */
public final class PastCampaignsViewModel$loadNextPage$2 extends Lambda implements Function1<PastCampaignsV2, PastCampaignsState> {

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ PastCampaignsState f27360f;

    /* renamed from: g  reason: collision with root package name */
    final /* synthetic */ PastCampaignsViewModel f27361g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PastCampaignsViewModel$loadNextPage$2(PastCampaignsState pastCampaignsState, PastCampaignsViewModel pastCampaignsViewModel) {
        super(1);
        this.f27360f = pastCampaignsState;
        this.f27361g = pastCampaignsViewModel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean d(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return ((Boolean) tmp0.invoke(obj)).booleanValue();
    }

    @Override // kotlin.jvm.functions.Function1
    /* renamed from: c */
    public final PastCampaignsState invoke(PastCampaignsV2 response) {
        List<CampaignV2Group> J0;
        int v7;
        int y02;
        int v8;
        boolean z7;
        List n02;
        int i8;
        boolean z8;
        int v9;
        CampaignFactory campaignFactory;
        Object obj;
        List n03;
        boolean z9;
        Intrinsics.f(response, "response");
        List<CampaignV2Group> a8 = response.a();
        if (a8 == null) {
            a8 = CollectionsKt__CollectionsKt.k();
        }
        J0 = CollectionsKt___CollectionsKt.J0(a8);
        int i9 = 10;
        v7 = CollectionsKt__IterablesKt.v(J0, 10);
        ArrayList arrayList = new ArrayList(v7);
        for (CampaignV2Group campaignV2Group : J0) {
            arrayList.add(Integer.valueOf(campaignV2Group.c().size()));
        }
        y02 = CollectionsKt___CollectionsKt.y0(arrayList);
        List<CampaignV2Group> f8 = this.f27360f.f();
        v8 = CollectionsKt__IterablesKt.v(f8, 10);
        ArrayList arrayList2 = new ArrayList(v8);
        Iterator<T> it = f8.iterator();
        while (true) {
            z7 = true;
            if (!it.hasNext()) {
                break;
            }
            final CampaignV2Group campaignV2Group2 = (CampaignV2Group) it.next();
            Iterator it2 = J0.iterator();
            while (true) {
                if (it2.hasNext()) {
                    obj = it2.next();
                    if (((CampaignV2Group) obj).d() == campaignV2Group2.d()) {
                        z9 = true;
                        continue;
                    } else {
                        z9 = false;
                        continue;
                    }
                    if (z9) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            CampaignV2Group campaignV2Group3 = (CampaignV2Group) obj;
            final Function1<CampaignV2Group, Boolean> function1 = new Function1<CampaignV2Group, Boolean>() { // from class: ee.mtakso.driver.ui.screens.campaigns.v2.PastCampaignsViewModel$loadNextPage$2$source$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                /* renamed from: b */
                public final Boolean invoke(CampaignV2Group it3) {
                    boolean z10;
                    Intrinsics.f(it3, "it");
                    if (it3.d() == CampaignV2Group.this.d()) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    return Boolean.valueOf(z10);
                }
            };
            Collection$EL.removeIf(J0, new Predicate() { // from class: ee.mtakso.driver.ui.screens.campaigns.v2.y
                @Override // j$.util.function.Predicate
                public /* synthetic */ Predicate and(Predicate predicate) {
                    return Predicate.CC.$default$and(this, predicate);
                }

                @Override // j$.util.function.Predicate
                public /* synthetic */ Predicate negate() {
                    return Predicate.CC.$default$negate(this);
                }

                @Override // j$.util.function.Predicate
                public /* synthetic */ Predicate or(Predicate predicate) {
                    return Predicate.CC.$default$or(this, predicate);
                }

                @Override // j$.util.function.Predicate
                public final boolean test(Object obj2) {
                    boolean d8;
                    d8 = PastCampaignsViewModel$loadNextPage$2.d(Function1.this, obj2);
                    return d8;
                }
            });
            if (campaignV2Group3 != null) {
                n03 = CollectionsKt___CollectionsKt.n0(campaignV2Group2.c(), campaignV2Group3.c());
                campaignV2Group2 = CampaignV2Group.b(campaignV2Group2, 0L, null, n03, 3, null);
            }
            arrayList2.add(campaignV2Group2);
        }
        n02 = CollectionsKt___CollectionsKt.n0(arrayList2, J0);
        i8 = this.f27361g.f27356i;
        if (y02 < i8) {
            z8 = true;
        } else {
            z8 = false;
        }
        PastCampaignsState pastCampaignsState = this.f27360f;
        PastCampaignsViewModel pastCampaignsViewModel = this.f27361g;
        ArrayList arrayList3 = new ArrayList();
        Iterator it3 = n02.iterator();
        while (it3.hasNext()) {
            CampaignV2Group campaignV2Group4 = (CampaignV2Group) it3.next();
            ArrayList arrayList4 = new ArrayList();
            if (campaignV2Group4.c().isEmpty() ^ z7) {
                String e8 = pastCampaignsState.d().e();
                long d8 = campaignV2Group4.d();
                arrayList4.add(new GenericTitleDelegate.Model(e8 + d8, 0, campaignV2Group4.e(), null, false, false, false, null, null, null, 1016, null));
            }
            List<DriverCampaignV2> c8 = campaignV2Group4.c();
            v9 = CollectionsKt__IterablesKt.v(c8, i9);
            ArrayList arrayList5 = new ArrayList(v9);
            for (DriverCampaignV2 driverCampaignV2 : c8) {
                campaignFactory = pastCampaignsViewModel.f27355h;
                String c9 = pastCampaignsState.d().c();
                long i10 = driverCampaignV2.i();
                arrayList5.add(campaignFactory.a(c9 + i10, driverCampaignV2));
                it3 = it3;
            }
            arrayList4.addAll(arrayList5);
            CollectionsKt__MutableCollectionsKt.A(arrayList3, arrayList4);
            i9 = 10;
            z7 = true;
        }
        PastCampaignsState state = this.f27360f;
        Intrinsics.e(state, "state");
        return PastCampaignsState.b(state, null, n02, arrayList3, z8, 1, null);
    }
}
