package io.ktor.client.engine;

import io.ktor.client.engine.HttpClientEngineConfig;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HttpClientEngine.kt */
/* loaded from: classes5.dex */
public interface HttpClientEngineFactory<T extends HttpClientEngineConfig> {

    /* compiled from: HttpClientEngine.kt */
    /* loaded from: classes5.dex */
    public static final class DefaultImpls {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ HttpClientEngine a(HttpClientEngineFactory httpClientEngineFactory, Function1 function1, int i8, Object obj) {
            if (obj == null) {
                if ((i8 & 1) != 0) {
                    function1 = new Function1<T, Unit>() { // from class: io.ktor.client.engine.HttpClientEngineFactory$create$1
                        /* JADX WARN: Incorrect types in method signature: (TT;)V */
                        public final void b(HttpClientEngineConfig httpClientEngineConfig) {
                            Intrinsics.f(httpClientEngineConfig, "$this$null");
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Object obj2) {
                            b((HttpClientEngineConfig) obj2);
                            return Unit.f50853a;
                        }
                    };
                }
                return httpClientEngineFactory.a(function1);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: create");
        }
    }

    HttpClientEngine a(Function1<? super T, Unit> function1);
}
