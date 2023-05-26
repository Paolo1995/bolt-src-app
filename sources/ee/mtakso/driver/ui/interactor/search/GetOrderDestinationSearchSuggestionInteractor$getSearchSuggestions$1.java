package ee.mtakso.driver.ui.interactor.search;

import ee.mtakso.driver.network.client.driver.AddressSuggestions;
import ee.mtakso.driver.network.client.driver.DriverClient;
import ee.mtakso.driver.network.client.geo.ExternalSourceAddresses;
import ee.mtakso.driver.service.geo.GeoLocation;
import ee.mtakso.driver.service.order.details.OrderDetails;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.BiFunction;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: GetOrderDestinationSearchSuggestionInteractor.kt */
/* loaded from: classes3.dex */
public final class GetOrderDestinationSearchSuggestionInteractor$getSearchSuggestions$1 extends Lambda implements Function1<OrderDetails, ObservableSource<? extends ExternalSourceAddresses>> {

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ GetOrderDestinationSearchSuggestionInteractor f26880f;

    /* renamed from: g  reason: collision with root package name */
    final /* synthetic */ String f26881g;

    /* renamed from: h  reason: collision with root package name */
    final /* synthetic */ GeoLocation f26882h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GetOrderDestinationSearchSuggestionInteractor$getSearchSuggestions$1(GetOrderDestinationSearchSuggestionInteractor getOrderDestinationSearchSuggestionInteractor, String str, GeoLocation geoLocation) {
        super(1);
        this.f26880f = getOrderDestinationSearchSuggestionInteractor;
        this.f26881g = str;
        this.f26882h = geoLocation;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ExternalSourceAddresses d(Function2 tmp0, Object obj, Object obj2) {
        Intrinsics.f(tmp0, "$tmp0");
        return (ExternalSourceAddresses) tmp0.s(obj, obj2);
    }

    @Override // kotlin.jvm.functions.Function1
    /* renamed from: c */
    public final ObservableSource<? extends ExternalSourceAddresses> invoke(OrderDetails model) {
        DriverClient driverClient;
        GetExternalSourceAddressInteractor getExternalSourceAddressInteractor;
        Intrinsics.f(model, "model");
        driverClient = this.f26880f.f26873b;
        Observable<AddressSuggestions> R = driverClient.g(this.f26881g, model.a(), this.f26882h.e()).R();
        getExternalSourceAddressInteractor = this.f26880f.f26872a;
        Observable<ExternalSourceAddresses> R2 = getExternalSourceAddressInteractor.a(this.f26881g, this.f26882h, model.c()).R();
        final GetOrderDestinationSearchSuggestionInteractor getOrderDestinationSearchSuggestionInteractor = this.f26880f;
        final Function2<AddressSuggestions, ExternalSourceAddresses, ExternalSourceAddresses> function2 = new Function2<AddressSuggestions, ExternalSourceAddresses, ExternalSourceAddresses>() { // from class: ee.mtakso.driver.ui.interactor.search.GetOrderDestinationSearchSuggestionInteractor$getSearchSuggestions$1.1
            {
                super(2);
            }

            /* JADX WARN: Code restructure failed: missing block: B:10:0x004a, code lost:
                if ((!r2) != false) goto L10;
             */
            @Override // kotlin.jvm.functions.Function2
            /* renamed from: b */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final ee.mtakso.driver.network.client.geo.ExternalSourceAddresses s(ee.mtakso.driver.network.client.driver.AddressSuggestions r6, ee.mtakso.driver.network.client.geo.ExternalSourceAddresses r7) {
                /*
                    r5 = this;
                    java.lang.String r0 = "historicAddressSuggestions"
                    kotlin.jvm.internal.Intrinsics.f(r6, r0)
                    java.lang.String r0 = "externalAddressSuggestions"
                    kotlin.jvm.internal.Intrinsics.f(r7, r0)
                    ee.mtakso.driver.ui.interactor.search.GetOrderDestinationSearchSuggestionInteractor r0 = ee.mtakso.driver.ui.interactor.search.GetOrderDestinationSearchSuggestionInteractor.this
                    java.util.List r6 = ee.mtakso.driver.ui.interactor.search.GetOrderDestinationSearchSuggestionInteractor.i(r0, r6)
                    java.util.List r7 = r7.a()
                    java.util.ArrayList r0 = new java.util.ArrayList
                    r0.<init>()
                    java.util.Iterator r7 = r7.iterator()
                L1d:
                    boolean r1 = r7.hasNext()
                    if (r1 == 0) goto L54
                    java.lang.Object r1 = r7.next()
                    r2 = r1
                    ee.mtakso.driver.network.client.geo.ExternalSourceAddress r2 = (ee.mtakso.driver.network.client.geo.ExternalSourceAddress) r2
                    java.lang.String r3 = r2.f()
                    boolean r3 = kotlin.text.StringsKt.y(r3)
                    r4 = 1
                    r3 = r3 ^ r4
                    if (r3 == 0) goto L4d
                    java.lang.String r3 = r2.a()
                    boolean r3 = kotlin.text.StringsKt.y(r3)
                    r3 = r3 ^ r4
                    if (r3 == 0) goto L4d
                    java.lang.String r2 = r2.e()
                    boolean r2 = kotlin.text.StringsKt.y(r2)
                    r2 = r2 ^ r4
                    if (r2 == 0) goto L4d
                    goto L4e
                L4d:
                    r4 = 0
                L4e:
                    if (r4 == 0) goto L1d
                    r0.add(r1)
                    goto L1d
                L54:
                    java.util.List r6 = kotlin.collections.CollectionsKt.n0(r6, r0)
                    ee.mtakso.driver.network.client.geo.ExternalSourceAddresses r7 = new ee.mtakso.driver.network.client.geo.ExternalSourceAddresses
                    r7.<init>(r6)
                    return r7
                */
                throw new UnsupportedOperationException("Method not decompiled: ee.mtakso.driver.ui.interactor.search.GetOrderDestinationSearchSuggestionInteractor$getSearchSuggestions$1.AnonymousClass1.s(ee.mtakso.driver.network.client.driver.AddressSuggestions, ee.mtakso.driver.network.client.geo.ExternalSourceAddresses):ee.mtakso.driver.network.client.geo.ExternalSourceAddresses");
            }
        };
        return Observable.combineLatest(R, R2, new BiFunction() { // from class: ee.mtakso.driver.ui.interactor.search.f
            @Override // io.reactivex.functions.BiFunction
            public final Object apply(Object obj, Object obj2) {
                ExternalSourceAddresses d8;
                d8 = GetOrderDestinationSearchSuggestionInteractor$getSearchSuggestions$1.d(Function2.this, obj, obj2);
                return d8;
            }
        });
    }
}
