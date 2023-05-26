package eu.bolt.verification.sdk.internal;

import eu.bolt.verification.sdk.internal.ld;
import eu.bolt.verification.sdk.internal.nd;
import eu.bolt.verification.sdk.internal.qn;
import eu.bolt.verification.sdk.internal.zc;
import io.reactivex.Observable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Function;
import java.util.Map;
import javax.inject.Inject;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes5.dex */
public final class zc {

    /* renamed from: a  reason: collision with root package name */
    private final rc f45846a;

    /* renamed from: b  reason: collision with root package name */
    private final ld f45847b;

    /* renamed from: c  reason: collision with root package name */
    private final nd f45848c;

    /* loaded from: classes5.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final String f45849a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean f45850b;

        public a(String stepId, boolean z7) {
            Intrinsics.f(stepId, "stepId");
            this.f45849a = stepId;
            this.f45850b = z7;
        }

        public final String a() {
            return this.f45849a;
        }

        public final boolean b() {
            return this.f45850b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof a) {
                a aVar = (a) obj;
                return Intrinsics.a(this.f45849a, aVar.f45849a) && this.f45850b == aVar.f45850b;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int hashCode = this.f45849a.hashCode() * 31;
            boolean z7 = this.f45850b;
            int i8 = z7;
            if (z7 != 0) {
                i8 = 1;
            }
            return hashCode + i8;
        }

        public String toString() {
            String str = this.f45849a;
            boolean z7 = this.f45850b;
            return "Args(stepId=" + str + ", isError=" + z7 + ")";
        }
    }

    /* loaded from: classes5.dex */
    public static abstract class b {

        /* loaded from: classes5.dex */
        public static final class a extends b {

            /* renamed from: a  reason: collision with root package name */
            private final k7 f45851a;

            /* renamed from: b  reason: collision with root package name */
            private final Map<String, em> f45852b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public a(k7 flowStep, Map<String, ? extends em> userInput) {
                super(null);
                Intrinsics.f(flowStep, "flowStep");
                Intrinsics.f(userInput, "userInput");
                this.f45851a = flowStep;
                this.f45852b = userInput;
            }

            public final k7 a() {
                return this.f45851a;
            }

            public final Map<String, em> b() {
                return this.f45852b;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof a) {
                    a aVar = (a) obj;
                    return Intrinsics.a(this.f45851a, aVar.f45851a) && Intrinsics.a(this.f45852b, aVar.f45852b);
                }
                return false;
            }

            public int hashCode() {
                return (this.f45851a.hashCode() * 31) + this.f45852b.hashCode();
            }

            public String toString() {
                k7 k7Var = this.f45851a;
                Map<String, em> map = this.f45852b;
                return "Data(flowStep=" + k7Var + ", userInput=" + map + ")";
            }
        }

        /* renamed from: eu.bolt.verification.sdk.internal.zc$b$b  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public static final class C0101b extends b {

            /* renamed from: a  reason: collision with root package name */
            private final Throwable f45853a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0101b(Throwable error) {
                super(null);
                Intrinsics.f(error, "error");
                this.f45853a = error;
            }

            public final Throwable a() {
                return this.f45853a;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof C0101b) && Intrinsics.a(this.f45853a, ((C0101b) obj).f45853a);
            }

            public int hashCode() {
                return this.f45853a.hashCode();
            }

            public String toString() {
                Throwable th = this.f45853a;
                return "Error(error=" + th + ")";
            }
        }

        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* loaded from: classes5.dex */
    static final class c extends Lambda implements Function2<k7, nd.a, b> {
        c() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: b */
        public final b s(k7 flowStep, nd.a userInput) {
            Intrinsics.f(flowStep, "flowStep");
            Intrinsics.f(userInput, "userInput");
            return zc.this.d(flowStep, userInput.a());
        }
    }

    /* loaded from: classes5.dex */
    static final class d extends Lambda implements Function1<Throwable, b> {

        /* renamed from: f  reason: collision with root package name */
        public static final d f45855f = new d();

        d() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: b */
        public final b invoke(Throwable it) {
            Intrinsics.f(it, "it");
            return new b.C0101b(it);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class e extends Lambda implements Function1<qn.b, k7> {

        /* renamed from: f  reason: collision with root package name */
        public static final e f45856f = new e();

        e() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: b */
        public final k7 invoke(qn.b it) {
            Intrinsics.f(it, "it");
            return it.a();
        }
    }

    @Inject
    public zc(rc observeCurrentFlowInteractor, ld observeStepByIdInteractor, nd observeUserInputInteractor) {
        Intrinsics.f(observeCurrentFlowInteractor, "observeCurrentFlowInteractor");
        Intrinsics.f(observeStepByIdInteractor, "observeStepByIdInteractor");
        Intrinsics.f(observeUserInputInteractor, "observeUserInputInteractor");
        this.f45846a = observeCurrentFlowInteractor;
        this.f45847b = observeStepByIdInteractor;
        this.f45848c = observeUserInputInteractor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final b d(k7 k7Var, Map<String, ? extends em> map) {
        return new b.a(k7Var, map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final b f(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (b) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final b g(Function2 tmp0, Object obj, Object obj2) {
        Intrinsics.f(tmp0, "$tmp0");
        return (b) tmp0.s(obj, obj2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k7 i(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (k7) tmp0.invoke(obj);
    }

    private final Observable<k7> j(a aVar) {
        if (aVar.b()) {
            Observable<qn.b> a8 = this.f45846a.a();
            final e eVar = e.f45856f;
            Observable map = a8.map(new Function() { // from class: eu.bolt.verification.sdk.internal.py
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    k7 i8;
                    i8 = zc.i(Function1.this, obj);
                    return i8;
                }
            });
            Intrinsics.e(map, "{\n            observeCur… it.errorStep }\n        }");
            return map;
        }
        return this.f45847b.b(new ld.a(aVar.a()));
    }

    public Observable<b> h(a args) {
        Intrinsics.f(args, "args");
        Observable<k7> j8 = j(args);
        Observable<nd.a> distinctUntilChanged = this.f45848c.c().distinctUntilChanged();
        final c cVar = new c();
        Observable combineLatest = Observable.combineLatest(j8, distinctUntilChanged, new BiFunction() { // from class: eu.bolt.verification.sdk.internal.ny
            @Override // io.reactivex.functions.BiFunction
            public final Object apply(Object obj, Object obj2) {
                zc.b g8;
                g8 = zc.g(Function2.this, obj, obj2);
                return g8;
            }
        });
        final d dVar = d.f45855f;
        Observable<b> onErrorReturn = combineLatest.onErrorReturn(new Function() { // from class: eu.bolt.verification.sdk.internal.oy
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                zc.b f8;
                f8 = zc.f(Function1.this, obj);
                return f8;
            }
        });
        Intrinsics.e(onErrorReturn, "override fun execute(arg… Result.Error(it) }\n    }");
        return onErrorReturn;
    }
}
