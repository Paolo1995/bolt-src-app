package io.ktor.client.engine;

import io.ktor.client.HttpClientConfig;
import io.ktor.client.request.HttpRequestData;
import io.ktor.http.HttpHeaders;
import io.ktor.http.UnsafeHeaderException;
import io.ktor.util.AttributeKey;
import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.CancellationException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineName;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;

/* compiled from: HttpClientEngine.kt */
/* loaded from: classes5.dex */
public final class HttpClientEngineKt {

    /* renamed from: a  reason: collision with root package name */
    private static final CoroutineName f46133a = new CoroutineName("call-context");

    /* renamed from: b  reason: collision with root package name */
    private static final AttributeKey<HttpClientConfig<?>> f46134b = new AttributeKey<>("client-config");

    public static final Object b(HttpClientEngine httpClientEngine, Job job, Continuation<? super CoroutineContext> continuation) {
        final CompletableJob a8 = JobKt.a(job);
        CoroutineContext s02 = httpClientEngine.j().s0(a8).s0(f46133a);
        Job job2 = (Job) continuation.getContext().g(Job.f51296d);
        if (job2 != null) {
            final DisposableHandle d8 = Job.DefaultImpls.d(job2, true, false, new Function1<Throwable, Unit>() { // from class: io.ktor.client.engine.UtilsKt$attachToUserJob$cleanupHandler$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                    invoke2(th);
                    return Unit.f50853a;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(Throwable th) {
                    if (th == null) {
                        return;
                    }
                    Job.this.e(new CancellationException(th.getMessage()));
                }
            }, 2, null);
            a8.X(new Function1<Throwable, Unit>() { // from class: io.ktor.client.engine.UtilsKt$attachToUserJob$2
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                    invoke2(th);
                    return Unit.f50853a;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(Throwable th) {
                    DisposableHandle.this.dispose();
                }
            });
        }
        return s02;
    }

    public static final AttributeKey<HttpClientConfig<?>> c() {
        return f46134b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(HttpRequestData httpRequestData) {
        Set<String> names = httpRequestData.e().names();
        ArrayList arrayList = new ArrayList();
        for (Object obj : names) {
            if (HttpHeaders.f46782a.r().contains((String) obj)) {
                arrayList.add(obj);
            }
        }
        if (!(!arrayList.isEmpty())) {
            return;
        }
        throw new UnsafeHeaderException(arrayList.toString());
    }
}
