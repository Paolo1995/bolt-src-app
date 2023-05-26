package ee.mtakso.driver.network.response;

import ee.mtakso.driver.network.ApiExceptionProvider;
import ee.mtakso.driver.network.exception.ApiException;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.subjects.PublishSubject;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ResponseProcessor.kt */
@Singleton
/* loaded from: classes3.dex */
public final class ResponseErrorProcessor implements ResponseProcessor, ApiExceptionProvider {

    /* renamed from: a  reason: collision with root package name */
    private final PublishSubject<ApiException> f23018a;

    @Inject
    public ResponseErrorProcessor() {
        PublishSubject<ApiException> e8 = PublishSubject.e();
        Intrinsics.e(e8, "create<ApiException>()");
        this.f23018a = e8;
    }

    @Override // ee.mtakso.driver.network.response.ResponseProcessor
    public <Response extends BasicServerResponse> Single<Response> a(Response response) {
        Intrinsics.f(response, "response");
        Single<Response> w7 = Single.w(response);
        Intrinsics.e(w7, "just(response)");
        return w7;
    }

    @Override // ee.mtakso.driver.network.ApiExceptionProvider
    public Observable<ApiException> b() {
        return this.f23018a;
    }

    public final <Response extends BasicServerResponse> void c(Response ignored) {
        Intrinsics.f(ignored, "ignored");
    }

    public final void d(ApiException error) {
        Intrinsics.f(error, "error");
        this.f23018a.onNext(error);
    }
}
