package eu.bolt.verification.sdk.internal;

import eu.bolt.verification.sdk.internal.bh;
import eu.bolt.verification.sdk.internal.eh;
import eu.bolt.verification.sdk.internal.qn;
import io.reactivex.Completable;
import io.reactivex.CompletableSource;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.functions.Function;
import java.util.Map;
import javax.inject.Inject;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt__StringsKt;

/* loaded from: classes5.dex */
public final class bh {

    /* renamed from: a  reason: collision with root package name */
    private final tc f42329a;

    /* renamed from: b  reason: collision with root package name */
    private final ip f42330b;

    /* renamed from: c  reason: collision with root package name */
    private final eh f42331c;

    /* loaded from: classes5.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final String f42332a;

        /* renamed from: b  reason: collision with root package name */
        private final Map<String, String> f42333b;

        public a(String path, Map<String, String> params) {
            Intrinsics.f(path, "path");
            Intrinsics.f(params, "params");
            this.f42332a = path;
            this.f42333b = params;
        }

        public final Map<String, String> a() {
            return this.f42333b;
        }

        public final String b() {
            return this.f42332a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof a) {
                a aVar = (a) obj;
                return Intrinsics.a(this.f42332a, aVar.f42332a) && Intrinsics.a(this.f42333b, aVar.f42333b);
            }
            return false;
        }

        public int hashCode() {
            return (this.f42332a.hashCode() * 31) + this.f42333b.hashCode();
        }

        public String toString() {
            String str = this.f42332a;
            Map<String, String> map = this.f42333b;
            return "Args(path=" + str + ", params=" + map + ")";
        }
    }

    /* loaded from: classes5.dex */
    static final class b extends Lambda implements Function1<String, CompletableSource> {

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ a f42335g;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes5.dex */
        public static final class a extends Lambda implements Function1<qn.b, CompletableSource> {

            /* renamed from: f  reason: collision with root package name */
            final /* synthetic */ bh f42336f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(bh bhVar) {
                super(1);
                this.f42336f = bhVar;
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final CompletableSource invoke(qn.b flow) {
                Intrinsics.f(flow, "flow");
                return this.f42336f.f42331c.b(new eh.a(flow));
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(a aVar) {
            super(1);
            this.f42335g = aVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final CompletableSource d(Function1 tmp0, Object obj) {
            Intrinsics.f(tmp0, "$tmp0");
            return (CompletableSource) tmp0.invoke(obj);
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: c */
        public final CompletableSource invoke(String flowRunUuid) {
            Intrinsics.f(flowRunUuid, "flowRunUuid");
            Single<qn.b> p8 = bh.this.f42330b.p(flowRunUuid, bh.this.f(this.f42335g.b()), this.f42335g.a());
            final a aVar = new a(bh.this);
            return p8.s(new Function() { // from class: eu.bolt.verification.sdk.internal.we
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    CompletableSource d8;
                    d8 = bh.b.d(Function1.this, obj);
                    return d8;
                }
            });
        }
    }

    @Inject
    public bh(tc observeCurrentFlowRunUuidInteractor, ip verificationNetworkRepository, eh setCurrentFlowInteractor) {
        Intrinsics.f(observeCurrentFlowRunUuidInteractor, "observeCurrentFlowRunUuidInteractor");
        Intrinsics.f(verificationNetworkRepository, "verificationNetworkRepository");
        Intrinsics.f(setCurrentFlowInteractor, "setCurrentFlowInteractor");
        this.f42329a = observeCurrentFlowRunUuidInteractor;
        this.f42330b = verificationNetworkRepository;
        this.f42331c = setCurrentFlowInteractor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CompletableSource d(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (CompletableSource) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String f(String str) {
        String s02;
        s02 = StringsKt__StringsKt.s0(str, "/");
        return s02;
    }

    public Completable c(a args) {
        Intrinsics.f(args, "args");
        Observable<String> b8 = this.f42329a.b();
        final b bVar = new b(args);
        Completable switchMapCompletable = b8.switchMapCompletable(new Function() { // from class: eu.bolt.verification.sdk.internal.ue
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                CompletableSource d8;
                d8 = bh.d(Function1.this, obj);
                return d8;
            }
        });
        Intrinsics.e(switchMapCompletable, "override fun execute(arg…    }\n            }\n    }");
        return switchMapCompletable;
    }
}
