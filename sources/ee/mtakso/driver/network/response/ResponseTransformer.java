package ee.mtakso.driver.network.response;

import io.reactivex.Single;

/* compiled from: ResponseTransformer.kt */
/* loaded from: classes3.dex */
public interface ResponseTransformer {
    <Data, Response extends ServerResponse<Data>> Single<Data> a(Response response);
}
