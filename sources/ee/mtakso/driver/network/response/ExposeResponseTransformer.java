package ee.mtakso.driver.network.response;

import io.reactivex.Single;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ResponseTransformer.kt */
/* loaded from: classes3.dex */
public final class ExposeResponseTransformer implements ResponseTransformer {
    @Override // ee.mtakso.driver.network.response.ResponseTransformer
    public <Data, Response extends ServerResponse<Data>> Single<Data> a(Response response) {
        Intrinsics.f(response, "response");
        if (response.d() == null) {
            Single<Data> error = Single.error(new NullPointerException("Response is null. " + response));
            Intrinsics.e(error, "error(NullPointerExcepti…nse is null. $response\"))");
            return error;
        }
        Single<Data> w7 = Single.w(response.d());
        Intrinsics.e(w7, "just(response.data)");
        return w7;
    }
}
