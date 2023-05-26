package ee.mtakso.driver.ui.screens.boltclub;

import ee.mtakso.driver.network.client.boltclub.BoltClubApi;
import ee.mtakso.driver.network.client.boltclub.BoltClubDetailsRequest;
import ee.mtakso.driver.network.client.boltclub.FavouriteStatusRequest;
import ee.mtakso.driver.network.client.boltclub.model.BoltClubOfferDetailsResponse;
import ee.mtakso.driver.network.client.boltclub.model.BoltClubOffersResponse;
import eu.bolt.driver.core.network.response.BasicServerResponseKt;
import eu.bolt.driver.core.network.response.ServerResponse;
import io.reactivex.Completable;
import io.reactivex.Single;
import io.reactivex.functions.Function;
import javax.inject.Inject;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BoltClubClient.kt */
/* loaded from: classes3.dex */
public final class BoltClubClient {

    /* renamed from: a  reason: collision with root package name */
    private final BoltClubApi f27110a;

    @Inject
    public BoltClubClient(BoltClubApi apiClient) {
        Intrinsics.f(apiClient, "apiClient");
        this.f27110a = apiClient;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final BoltClubOffersResponse d(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (BoltClubOffersResponse) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final BoltClubOfferDetailsResponse f(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (BoltClubOfferDetailsResponse) tmp0.invoke(obj);
    }

    public final Single<BoltClubOffersResponse> c(String language) {
        Intrinsics.f(language, "language");
        Single<ServerResponse<BoltClubOffersResponse>> c8 = this.f27110a.c(language);
        final BoltClubClient$fetchLoyaltyOffersList$1 boltClubClient$fetchLoyaltyOffersList$1 = new Function1<ServerResponse<BoltClubOffersResponse>, BoltClubOffersResponse>() { // from class: ee.mtakso.driver.ui.screens.boltclub.BoltClubClient$fetchLoyaltyOffersList$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final BoltClubOffersResponse invoke(ServerResponse<BoltClubOffersResponse> it) {
                Intrinsics.f(it, "it");
                return (BoltClubOffersResponse) BasicServerResponseKt.a(it);
            }
        };
        Single x7 = c8.x(new Function() { // from class: ee.mtakso.driver.ui.screens.boltclub.b
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                BoltClubOffersResponse d8;
                d8 = BoltClubClient.d(Function1.this, obj);
                return d8;
            }
        });
        Intrinsics.e(x7, "apiClient\n        .getOf… .map { it.exposeData() }");
        return x7;
    }

    public final Single<BoltClubOfferDetailsResponse> e(long j8, String language, String theme) {
        Intrinsics.f(language, "language");
        Intrinsics.f(theme, "theme");
        Single<ServerResponse<BoltClubOfferDetailsResponse>> a8 = this.f27110a.a(new BoltClubDetailsRequest(j8, language, theme));
        final BoltClubClient$getLoyaltyOfferDescription$1 boltClubClient$getLoyaltyOfferDescription$1 = new Function1<ServerResponse<BoltClubOfferDetailsResponse>, BoltClubOfferDetailsResponse>() { // from class: ee.mtakso.driver.ui.screens.boltclub.BoltClubClient$getLoyaltyOfferDescription$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final BoltClubOfferDetailsResponse invoke(ServerResponse<BoltClubOfferDetailsResponse> it) {
                Intrinsics.f(it, "it");
                return (BoltClubOfferDetailsResponse) BasicServerResponseKt.a(it);
            }
        };
        Single x7 = a8.x(new Function() { // from class: ee.mtakso.driver.ui.screens.boltclub.a
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                BoltClubOfferDetailsResponse f8;
                f8 = BoltClubClient.f(Function1.this, obj);
                return f8;
            }
        });
        Intrinsics.e(x7, "apiClient\n        .getOf… .map { it.exposeData() }");
        return x7;
    }

    public final Completable g(long j8, boolean z7) {
        Completable v7 = this.f27110a.b(new FavouriteStatusRequest(j8, z7)).v();
        Intrinsics.e(v7, "apiClient\n        .setOf…vourite)).ignoreElement()");
        return v7;
    }
}
