package ee.mtakso.driver.utils;

import ee.mtakso.driver.network.response.BasicServerResponse;
import ee.mtakso.driver.network.response.ResponseProcessor;
import ee.mtakso.driver.network.response.ResponseTransformer;
import ee.mtakso.driver.network.response.ServerResponse;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SingleExt.kt */
/* loaded from: classes5.dex */
public final class SingleExtKt {
    public static final <T> Single<T> c(Single<T> single) {
        Intrinsics.f(single, "<this>");
        Single<T> z7 = single.K(Schedulers.a()).z(AndroidSchedulers.a());
        Intrinsics.e(z7, "subscribeOn(Schedulers.c…dSchedulers.mainThread())");
        return z7;
    }

    public static final <T> Single<T> d(Single<T> single) {
        Intrinsics.f(single, "<this>");
        Single<T> z7 = single.K(Schedulers.c()).z(AndroidSchedulers.a());
        Intrinsics.e(z7, "subscribeOn(Schedulers.i…dSchedulers.mainThread())");
        return z7;
    }

    public static final <Response extends BasicServerResponse> Single<Response> e(Single<Response> single, final ResponseProcessor processor) {
        Intrinsics.f(single, "<this>");
        Intrinsics.f(processor, "processor");
        final Function1<Response, SingleSource<? extends Response>> function1 = new Function1<Response, SingleSource<? extends Response>>() { // from class: ee.mtakso.driver.utils.SingleExtKt$process$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            /* JADX WARN: Incorrect types in method signature: (TResponse;)Lio/reactivex/SingleSource<+TResponse;>; */
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final SingleSource invoke(BasicServerResponse it) {
                Intrinsics.f(it, "it");
                return ResponseProcessor.this.a(it);
            }
        };
        Single<Response> K = single.r(new Function() { // from class: ee.mtakso.driver.utils.i
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                SingleSource f8;
                f8 = SingleExtKt.f(Function1.this, obj);
                return f8;
            }
        }).K(Schedulers.c());
        Intrinsics.e(K, "processor: ResponseProce…scribeOn(Schedulers.io())");
        return K;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SingleSource f(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (SingleSource) tmp0.invoke(obj);
    }

    public static final <Data, Response extends ServerResponse<Data>> Single<Data> g(Single<Response> single, final ResponseTransformer processor) {
        Intrinsics.f(single, "<this>");
        Intrinsics.f(processor, "processor");
        final Function1<Response, SingleSource<? extends Data>> function1 = new Function1<Response, SingleSource<? extends Data>>() { // from class: ee.mtakso.driver.utils.SingleExtKt$transform$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            /* JADX WARN: Incorrect types in method signature: (TResponse;)Lio/reactivex/SingleSource<+TData;>; */
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final SingleSource invoke(ServerResponse it) {
                Intrinsics.f(it, "it");
                return ResponseTransformer.this.a(it);
            }
        };
        Single<Data> K = single.r(new Function() { // from class: ee.mtakso.driver.utils.j
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                SingleSource h8;
                h8 = SingleExtKt.h(Function1.this, obj);
                return h8;
            }
        }).K(Schedulers.c());
        Intrinsics.e(K, "processor: ResponseTrans…scribeOn(Schedulers.io())");
        return K;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SingleSource h(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (SingleSource) tmp0.invoke(obj);
    }
}
