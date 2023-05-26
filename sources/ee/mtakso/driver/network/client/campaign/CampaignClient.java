package ee.mtakso.driver.network.client.campaign;

import dagger.Lazy;
import ee.mtakso.driver.network.client.ShardApiProvider;
import ee.mtakso.driver.network.client.order.DriverStatisticsSummary;
import ee.mtakso.driver.network.response.CompositeResponseTransformer;
import ee.mtakso.driver.utils.SingleExtKt;
import eu.bolt.driver.core.network.response.BasicServerResponseKt;
import eu.bolt.driver.core.network.response.EmptyServerResponse;
import eu.bolt.driver.core.network.response.ServerResponse;
import io.reactivex.Single;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import javax.inject.Inject;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CampaignClient.kt */
/* loaded from: classes3.dex */
public final class CampaignClient {

    /* renamed from: a  reason: collision with root package name */
    private final Lazy<CampaignApi> f21601a;

    /* renamed from: b  reason: collision with root package name */
    private final ShardApiProvider f21602b;

    /* renamed from: c  reason: collision with root package name */
    private final CompositeResponseTransformer f21603c;

    @Inject
    public CampaignClient(Lazy<CampaignApi> api, ShardApiProvider shardApiProvider, CompositeResponseTransformer responseTransformer) {
        Intrinsics.f(api, "api");
        Intrinsics.f(shardApiProvider, "shardApiProvider");
        Intrinsics.f(responseTransformer, "responseTransformer");
        this.f21601a = api;
        this.f21602b = shardApiProvider;
        this.f21603c = responseTransformer;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ActiveAndPendingCampaignsV2 j(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (ActiveAndPendingCampaignsV2) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ActiveAndFutureCampaigns l(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (ActiveAndFutureCampaigns) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ActiveAndPendingCampaignInfo n(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (ActiveAndPendingCampaignInfo) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CampaignV2Details p(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (CampaignV2Details) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InviteCampaignV2Summary s(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (InviteCampaignV2Summary) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final OptInChoicesV2 u(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (OptInChoicesV2) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PastCampaignsV2 w(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (PastCampaignsV2) tmp0.invoke(obj);
    }

    public final Single<EmptyServerResponse> h(long j8, long j9) {
        Single<EmptyServerResponse> K = this.f21601a.get().c(j8, j9).K(Schedulers.c());
        Intrinsics.e(K, "api.get().activateOptInC…scribeOn(Schedulers.io())");
        return K;
    }

    public final Single<ActiveAndPendingCampaignsV2> i() {
        Single<ServerResponse<ActiveAndPendingCampaignsV2>> e8 = this.f21601a.get().e();
        final CampaignClient$getActiveAndPendingCampaignsV2$1 campaignClient$getActiveAndPendingCampaignsV2$1 = new Function1<ServerResponse<ActiveAndPendingCampaignsV2>, ActiveAndPendingCampaignsV2>() { // from class: ee.mtakso.driver.network.client.campaign.CampaignClient$getActiveAndPendingCampaignsV2$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final ActiveAndPendingCampaignsV2 invoke(ServerResponse<ActiveAndPendingCampaignsV2> it) {
                Intrinsics.f(it, "it");
                return (ActiveAndPendingCampaignsV2) BasicServerResponseKt.a(it);
            }
        };
        Single<ActiveAndPendingCampaignsV2> K = e8.x(new Function() { // from class: ee.mtakso.driver.network.client.campaign.e
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ActiveAndPendingCampaignsV2 j8;
                j8 = CampaignClient.j(Function1.this, obj);
                return j8;
            }
        }).K(Schedulers.c());
        Intrinsics.e(K, "api.get().getActiveAndPe…scribeOn(Schedulers.io())");
        return K;
    }

    public final Single<ActiveAndFutureCampaigns> k() {
        Single<ServerResponse<ActiveAndFutureCampaigns>> f8 = this.f21601a.get().f();
        final CampaignClient$getActiveCampaigns$1 campaignClient$getActiveCampaigns$1 = new Function1<ServerResponse<ActiveAndFutureCampaigns>, ActiveAndFutureCampaigns>() { // from class: ee.mtakso.driver.network.client.campaign.CampaignClient$getActiveCampaigns$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final ActiveAndFutureCampaigns invoke(ServerResponse<ActiveAndFutureCampaigns> it) {
                Intrinsics.f(it, "it");
                return (ActiveAndFutureCampaigns) BasicServerResponseKt.a(it);
            }
        };
        Single<ActiveAndFutureCampaigns> K = f8.x(new Function() { // from class: ee.mtakso.driver.network.client.campaign.f
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ActiveAndFutureCampaigns l8;
                l8 = CampaignClient.l(Function1.this, obj);
                return l8;
            }
        }).K(Schedulers.c());
        Intrinsics.e(K, "api.get().getActiveCampa…scribeOn(Schedulers.io())");
        return K;
    }

    public final Single<ActiveAndPendingCampaignInfo> m() {
        Single<ServerResponse<ActiveAndPendingCampaignInfo>> h8 = this.f21601a.get().h();
        final CampaignClient$getActiveCampaignsInfo$1 campaignClient$getActiveCampaignsInfo$1 = new Function1<ServerResponse<ActiveAndPendingCampaignInfo>, ActiveAndPendingCampaignInfo>() { // from class: ee.mtakso.driver.network.client.campaign.CampaignClient$getActiveCampaignsInfo$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final ActiveAndPendingCampaignInfo invoke(ServerResponse<ActiveAndPendingCampaignInfo> it) {
                Intrinsics.f(it, "it");
                return (ActiveAndPendingCampaignInfo) BasicServerResponseKt.a(it);
            }
        };
        Single<ActiveAndPendingCampaignInfo> K = h8.x(new Function() { // from class: ee.mtakso.driver.network.client.campaign.c
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ActiveAndPendingCampaignInfo n8;
                n8 = CampaignClient.n(Function1.this, obj);
                return n8;
            }
        }).K(Schedulers.c());
        Intrinsics.e(K, "api.get().getActiveCampa…scribeOn(Schedulers.io())");
        return K;
    }

    public final Single<CampaignV2Details> o(long j8) {
        Single<ServerResponse<CampaignV2Details>> b8 = this.f21601a.get().b(j8);
        final CampaignClient$getCampaignV2$1 campaignClient$getCampaignV2$1 = new Function1<ServerResponse<CampaignV2Details>, CampaignV2Details>() { // from class: ee.mtakso.driver.network.client.campaign.CampaignClient$getCampaignV2$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final CampaignV2Details invoke(ServerResponse<CampaignV2Details> it) {
                Intrinsics.f(it, "it");
                return (CampaignV2Details) BasicServerResponseKt.a(it);
            }
        };
        Single<CampaignV2Details> K = b8.x(new Function() { // from class: ee.mtakso.driver.network.client.campaign.d
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                CampaignV2Details p8;
                p8 = CampaignClient.p(Function1.this, obj);
                return p8;
            }
        }).K(Schedulers.c());
        Intrinsics.e(K, "api.get().getCampaignV2(…scribeOn(Schedulers.io())");
        return K;
    }

    public final Single<DriverStatisticsSummary> q() {
        return SingleExtKt.g(this.f21602b.k().u(), this.f21603c);
    }

    public final Single<InviteCampaignV2Summary> r() {
        Single<ServerResponse<InviteCampaignV2Summary>> d8 = this.f21601a.get().d();
        final CampaignClient$getInviteCampaignV2Summary$1 campaignClient$getInviteCampaignV2Summary$1 = new Function1<ServerResponse<InviteCampaignV2Summary>, InviteCampaignV2Summary>() { // from class: ee.mtakso.driver.network.client.campaign.CampaignClient$getInviteCampaignV2Summary$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final InviteCampaignV2Summary invoke(ServerResponse<InviteCampaignV2Summary> it) {
                Intrinsics.f(it, "it");
                return (InviteCampaignV2Summary) BasicServerResponseKt.a(it);
            }
        };
        Single<InviteCampaignV2Summary> K = d8.x(new Function() { // from class: ee.mtakso.driver.network.client.campaign.a
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                InviteCampaignV2Summary s7;
                s7 = CampaignClient.s(Function1.this, obj);
                return s7;
            }
        }).K(Schedulers.c());
        Intrinsics.e(K, "api.get().getInviteCampa…scribeOn(Schedulers.io())");
        return K;
    }

    public final Single<OptInChoicesV2> t() {
        Single<ServerResponse<OptInChoicesV2>> a8 = this.f21601a.get().a();
        final CampaignClient$getOptInGroupsV2$1 campaignClient$getOptInGroupsV2$1 = new Function1<ServerResponse<OptInChoicesV2>, OptInChoicesV2>() { // from class: ee.mtakso.driver.network.client.campaign.CampaignClient$getOptInGroupsV2$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final OptInChoicesV2 invoke(ServerResponse<OptInChoicesV2> it) {
                Intrinsics.f(it, "it");
                return (OptInChoicesV2) BasicServerResponseKt.a(it);
            }
        };
        Single<OptInChoicesV2> K = a8.x(new Function() { // from class: ee.mtakso.driver.network.client.campaign.g
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                OptInChoicesV2 u7;
                u7 = CampaignClient.u(Function1.this, obj);
                return u7;
            }
        }).K(Schedulers.c());
        Intrinsics.e(K, "api.get().getOptInGroups…scribeOn(Schedulers.io())");
        return K;
    }

    public final Single<PastCampaignsV2> v(boolean z7, int i8, int i9) {
        Single<ServerResponse<PastCampaignsV2>> g8 = this.f21601a.get().g(z7, i8, i9);
        final CampaignClient$getPastCampaignsV2$1 campaignClient$getPastCampaignsV2$1 = new Function1<ServerResponse<PastCampaignsV2>, PastCampaignsV2>() { // from class: ee.mtakso.driver.network.client.campaign.CampaignClient$getPastCampaignsV2$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final PastCampaignsV2 invoke(ServerResponse<PastCampaignsV2> it) {
                Intrinsics.f(it, "it");
                return (PastCampaignsV2) BasicServerResponseKt.a(it);
            }
        };
        Single<PastCampaignsV2> K = g8.x(new Function() { // from class: ee.mtakso.driver.network.client.campaign.b
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                PastCampaignsV2 w7;
                w7 = CampaignClient.w(Function1.this, obj);
                return w7;
            }
        }).K(Schedulers.c());
        Intrinsics.e(K, "api.get().getPastCampaig…scribeOn(Schedulers.io())");
        return K;
    }
}
