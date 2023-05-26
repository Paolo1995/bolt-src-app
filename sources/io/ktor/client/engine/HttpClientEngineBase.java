package io.ktor.client.engine;

import io.ktor.client.HttpClient;
import io.ktor.client.engine.HttpClientEngine;
import io.ktor.util.CoroutinesUtilsKt;
import java.util.Set;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineName;
import kotlinx.coroutines.Job;

/* compiled from: HttpClientEngineBase.kt */
/* loaded from: classes5.dex */
public abstract class HttpClientEngineBase implements HttpClientEngine {

    /* renamed from: h  reason: collision with root package name */
    private static final /* synthetic */ AtomicIntegerFieldUpdater f46123h = AtomicIntegerFieldUpdater.newUpdater(HttpClientEngineBase.class, "closed");
    private volatile /* synthetic */ int closed;

    /* renamed from: f  reason: collision with root package name */
    private final String f46124f;

    /* renamed from: g  reason: collision with root package name */
    private final Lazy f46125g;

    public HttpClientEngineBase(String engineName) {
        Lazy b8;
        Intrinsics.f(engineName, "engineName");
        this.f46124f = engineName;
        this.closed = 0;
        b8 = LazyKt__LazyJVMKt.b(new Function0<CoroutineContext>() { // from class: io.ktor.client.engine.HttpClientEngineBase$coroutineContext$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final CoroutineContext invoke() {
                String str;
                CoroutineContext s02 = CoroutinesUtilsKt.b(null, 1, null).s0(HttpClientEngineBase.this.getDispatcher());
                StringBuilder sb = new StringBuilder();
                str = HttpClientEngineBase.this.f46124f;
                sb.append(str);
                sb.append("-context");
                return s02.s0(new CoroutineName(sb.toString()));
            }
        });
        this.f46125g = b8;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        CompletableJob completableJob;
        if (!f46123h.compareAndSet(this, 0, 1)) {
            return;
        }
        CoroutineContext.Element g8 = j().g(Job.f51296d);
        if (g8 instanceof CompletableJob) {
            completableJob = (CompletableJob) g8;
        } else {
            completableJob = null;
        }
        if (completableJob == null) {
            return;
        }
        completableJob.k();
        completableJob.X(new Function1<Throwable, Unit>() { // from class: io.ktor.client.engine.HttpClientEngineBase$close$1
            /* JADX INFO: Access modifiers changed from: package-private */
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
                HttpClientEngineBaseKt.b(HttpClientEngineBase.this.getDispatcher());
            }
        });
    }

    @Override // io.ktor.client.engine.HttpClientEngine
    public void g1(HttpClient httpClient) {
        HttpClientEngine.DefaultImpls.h(this, httpClient);
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public CoroutineContext j() {
        return (CoroutineContext) this.f46125g.getValue();
    }

    @Override // io.ktor.client.engine.HttpClientEngine
    public Set<HttpClientEngineCapability<?>> z0() {
        return HttpClientEngine.DefaultImpls.g(this);
    }
}
