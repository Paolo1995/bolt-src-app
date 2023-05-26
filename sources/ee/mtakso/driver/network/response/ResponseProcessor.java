package ee.mtakso.driver.network.response;

import io.reactivex.Single;

/* compiled from: ResponseProcessor.kt */
/* loaded from: classes3.dex */
public interface ResponseProcessor {
    <Response extends BasicServerResponse> Single<Response> a(Response response);
}
