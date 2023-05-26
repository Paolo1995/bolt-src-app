package eu.bolt.verification.sdk.internal;

import eu.bolt.verification.sdk.internal.nd;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import java.util.Map;
import javax.inject.Inject;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes5.dex */
public final class nd {

    /* renamed from: a  reason: collision with root package name */
    private final xn f44322a;

    /* loaded from: classes5.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final Map<String, em> f44323a;

        /* JADX WARN: Multi-variable type inference failed */
        public a(Map<String, ? extends em> inputMap) {
            Intrinsics.f(inputMap, "inputMap");
            this.f44323a = inputMap;
        }

        public final Map<String, em> a() {
            return this.f44323a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof a) && Intrinsics.a(this.f44323a, ((a) obj).f44323a);
        }

        public int hashCode() {
            return this.f44323a.hashCode();
        }

        public String toString() {
            Map<String, em> map = this.f44323a;
            return "Result(inputMap=" + map + ")";
        }
    }

    /* loaded from: classes5.dex */
    static final class b extends Lambda implements Function1<Map<String, ? extends em>, a> {

        /* renamed from: f  reason: collision with root package name */
        public static final b f44324f = new b();

        b() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: b */
        public final a invoke(Map<String, ? extends em> it) {
            Intrinsics.f(it, "it");
            return new a(it);
        }
    }

    @Inject
    public nd(xn verificationFlowRepository) {
        Intrinsics.f(verificationFlowRepository, "verificationFlowRepository");
        this.f44322a = verificationFlowRepository;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final a b(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (a) tmp0.invoke(obj);
    }

    public Observable<a> c() {
        Observable c8 = xn.c(this.f44322a, null, 1, null);
        final b bVar = b.f44324f;
        Observable<a> map = c8.map(new Function() { // from class: eu.bolt.verification.sdk.internal.xu
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                nd.a b8;
                b8 = nd.b(Function1.this, obj);
                return b8;
            }
        });
        Intrinsics.e(map, "verificationFlowReposito…      .map { Result(it) }");
        return map;
    }
}
