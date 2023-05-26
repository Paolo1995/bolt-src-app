package ee.mtakso.driver.network.client.registration;

import dagger.Lazy;
import ee.mtakso.driver.network.response.CompositeResponseTransformer;
import ee.mtakso.driver.utils.SingleExtKt;
import io.reactivex.Single;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DriverRegistrationClient.kt */
/* loaded from: classes3.dex */
public final class DriverRegistrationClient {

    /* renamed from: a  reason: collision with root package name */
    private final Lazy<DriverRegistrationApi> f22697a;

    /* renamed from: b  reason: collision with root package name */
    private final CompositeResponseTransformer f22698b;

    @Inject
    public DriverRegistrationClient(Lazy<DriverRegistrationApi> api, CompositeResponseTransformer responseTransformer) {
        Intrinsics.f(api, "api");
        Intrinsics.f(responseTransformer, "responseTransformer");
        this.f22697a = api;
        this.f22698b = responseTransformer;
    }

    public final Single<DriverRegistrationCompletionStatus> a(String registrationToken) {
        Intrinsics.f(registrationToken, "registrationToken");
        return SingleExtKt.g(this.f22697a.get().a(registrationToken), this.f22698b);
    }
}
