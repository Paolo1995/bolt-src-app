package io.ktor.client.engine;

import io.ktor.client.HttpClient;
import io.ktor.client.request.HttpRequestData;
import io.ktor.client.request.HttpResponseData;
import io.ktor.client.request.HttpSendPipeline;
import java.io.Closeable;
import java.util.Set;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;

/* compiled from: HttpClientEngine.kt */
/* loaded from: classes5.dex */
public interface HttpClientEngine extends CoroutineScope, Closeable {

    /* compiled from: HttpClientEngine.kt */
    /* loaded from: classes5.dex */
    public static final class DefaultImpls {
        /* JADX INFO: Access modifiers changed from: private */
        public static void d(HttpClientEngine httpClientEngine, HttpRequestData httpRequestData) {
            for (HttpClientEngineCapability<?> httpClientEngineCapability : httpRequestData.g()) {
                if (!httpClientEngine.z0().contains(httpClientEngineCapability)) {
                    throw new IllegalArgumentException(("Engine doesn't support " + httpClientEngineCapability).toString());
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
        /* JADX WARN: Removed duplicated region for block: B:16:0x0041  */
        /* JADX WARN: Removed duplicated region for block: B:21:0x007a A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:22:0x007b A[PHI: r12 
          PHI: (r12v7 java.lang.Object) = (r12v6 java.lang.Object), (r12v1 java.lang.Object) binds: [B:20:0x0078, B:12:0x0028] A[DONT_GENERATE, DONT_INLINE], RETURN] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public static java.lang.Object e(io.ktor.client.engine.HttpClientEngine r10, io.ktor.client.request.HttpRequestData r11, kotlin.coroutines.Continuation<? super io.ktor.client.request.HttpResponseData> r12) {
            /*
                boolean r0 = r12 instanceof io.ktor.client.engine.HttpClientEngine$executeWithinCallContext$1
                if (r0 == 0) goto L13
                r0 = r12
                io.ktor.client.engine.HttpClientEngine$executeWithinCallContext$1 r0 = (io.ktor.client.engine.HttpClientEngine$executeWithinCallContext$1) r0
                int r1 = r0.f46112i
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.f46112i = r1
                goto L18
            L13:
                io.ktor.client.engine.HttpClientEngine$executeWithinCallContext$1 r0 = new io.ktor.client.engine.HttpClientEngine$executeWithinCallContext$1
                r0.<init>(r12)
            L18:
                java.lang.Object r12 = r0.f46111h
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.d()
                int r2 = r0.f46112i
                r3 = 2
                r4 = 1
                if (r2 == 0) goto L41
                if (r2 == r4) goto L34
                if (r2 != r3) goto L2c
                kotlin.ResultKt.b(r12)
                goto L7b
            L2c:
                java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
                java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
                r10.<init>(r11)
                throw r10
            L34:
                java.lang.Object r10 = r0.f46110g
                r11 = r10
                io.ktor.client.request.HttpRequestData r11 = (io.ktor.client.request.HttpRequestData) r11
                java.lang.Object r10 = r0.f46109f
                io.ktor.client.engine.HttpClientEngine r10 = (io.ktor.client.engine.HttpClientEngine) r10
                kotlin.ResultKt.b(r12)
                goto L55
            L41:
                kotlin.ResultKt.b(r12)
                kotlinx.coroutines.Job r12 = r11.d()
                r0.f46109f = r10
                r0.f46110g = r11
                r0.f46112i = r4
                java.lang.Object r12 = io.ktor.client.engine.HttpClientEngineKt.b(r10, r12, r0)
                if (r12 != r1) goto L55
                return r1
            L55:
                r4 = r10
                kotlin.coroutines.CoroutineContext r12 = (kotlin.coroutines.CoroutineContext) r12
                io.ktor.client.engine.KtorCallContextElement r10 = new io.ktor.client.engine.KtorCallContextElement
                r10.<init>(r12)
                kotlin.coroutines.CoroutineContext r5 = r12.s0(r10)
                r6 = 0
                io.ktor.client.engine.HttpClientEngine$executeWithinCallContext$2 r7 = new io.ktor.client.engine.HttpClientEngine$executeWithinCallContext$2
                r10 = 0
                r7.<init>(r4, r11, r10)
                r8 = 2
                r9 = 0
                kotlinx.coroutines.Deferred r11 = kotlinx.coroutines.BuildersKt.b(r4, r5, r6, r7, r8, r9)
                r0.f46109f = r10
                r0.f46110g = r10
                r0.f46112i = r3
                java.lang.Object r12 = r11.N(r0)
                if (r12 != r1) goto L7b
                return r1
            L7b:
                return r12
            */
            throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.engine.HttpClientEngine.DefaultImpls.e(io.ktor.client.engine.HttpClientEngine, io.ktor.client.request.HttpRequestData, kotlin.coroutines.Continuation):java.lang.Object");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static boolean f(HttpClientEngine httpClientEngine) {
            boolean z7;
            Job job = (Job) httpClientEngine.j().g(Job.f51296d);
            if (job != null) {
                z7 = job.isActive();
            } else {
                z7 = false;
            }
            return !z7;
        }

        public static Set<HttpClientEngineCapability<?>> g(HttpClientEngine httpClientEngine) {
            Set<HttpClientEngineCapability<?>> b8;
            b8 = SetsKt__SetsKt.b();
            return b8;
        }

        public static void h(HttpClientEngine httpClientEngine, HttpClient client) {
            Intrinsics.f(client, "client");
            client.m().l(HttpSendPipeline.f46641h.a(), new HttpClientEngine$install$1(client, httpClientEngine, null));
        }
    }

    Object Y0(HttpRequestData httpRequestData, Continuation<? super HttpResponseData> continuation);

    HttpClientEngineConfig d();

    void g1(HttpClient httpClient);

    CoroutineDispatcher getDispatcher();

    Set<HttpClientEngineCapability<?>> z0();
}
