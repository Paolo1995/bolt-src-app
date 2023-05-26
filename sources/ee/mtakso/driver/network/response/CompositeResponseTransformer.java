package ee.mtakso.driver.network.response;

import io.reactivex.Single;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ResponseTransformer.kt */
/* loaded from: classes3.dex */
public final class CompositeResponseTransformer implements ResponseTransformer {

    /* renamed from: a  reason: collision with root package name */
    private final ExposeResponseTransformer f22982a;

    @Inject
    public CompositeResponseTransformer(ExposeResponseTransformer exposeResponseTransformer) {
        Intrinsics.f(exposeResponseTransformer, "exposeResponseTransformer");
        this.f22982a = exposeResponseTransformer;
    }

    @Override // ee.mtakso.driver.network.response.ResponseTransformer
    public <Data, Response extends ServerResponse<Data>> Single<Data> a(Response response) {
        Intrinsics.f(response, "response");
        return this.f22982a.a(response);
    }
}
