package eu.bolt.verification.sdk.internal;

import eu.bolt.verification.sdk.internal.ac;
import eu.bolt.verification.sdk.internal.ld;
import eu.bolt.verification.sdk.internal.qn;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import javax.inject.Inject;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes5.dex */
public final class ld {

    /* renamed from: a  reason: collision with root package name */
    private final rc f44039a;

    /* loaded from: classes5.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final String f44040a;

        public a(String stepId) {
            Intrinsics.f(stepId, "stepId");
            this.f44040a = stepId;
        }

        public final String a() {
            return this.f44040a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof a) && Intrinsics.a(this.f44040a, ((a) obj).f44040a);
        }

        public int hashCode() {
            return this.f44040a.hashCode();
        }

        public String toString() {
            String str = this.f44040a;
            return "Args(stepId=" + str + ")";
        }
    }

    /* loaded from: classes5.dex */
    static final class b extends Lambda implements Function1<qn.b, k7> {

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ a f44042g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(a aVar) {
            super(1);
            this.f44042g = aVar;
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: b */
        public final k7 invoke(qn.b flow) {
            Object obj;
            Intrinsics.f(flow, "flow");
            List<k7> f8 = flow.f();
            a aVar = this.f44042g;
            Iterator<T> it = f8.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (Intrinsics.a(((k7) obj).e(), aVar.a())) {
                    break;
                }
            }
            k7 k7Var = (k7) obj;
            if (k7Var == null) {
                a aVar2 = this.f44042g;
                ac.b.f42045b.d().e("Cannot find step with id " + aVar2.a() + " in " + flow.f());
                return null;
            }
            return k7Var;
        }
    }

    /* loaded from: classes5.dex */
    static final class c extends Lambda implements Function1<k7, ObservableSource<? extends k7>> {

        /* renamed from: f  reason: collision with root package name */
        public static final c f44043f = new c();

        c() {
            super(1);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final k7 d(k7 flow) {
            Intrinsics.f(flow, "$flow");
            return flow;
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: c */
        public final ObservableSource<? extends k7> invoke(final k7 flow) {
            Intrinsics.f(flow, "flow");
            return Observable.fromCallable(new Callable() { // from class: eu.bolt.verification.sdk.internal.nu
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    k7 d8;
                    d8 = ld.c.d(k7.this);
                    return d8;
                }
            });
        }
    }

    @Inject
    public ld(rc observeCurrentFlowInteractor) {
        Intrinsics.f(observeCurrentFlowInteractor, "observeCurrentFlowInteractor");
        this.f44039a = observeCurrentFlowInteractor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ObservableSource c(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (ObservableSource) tmp0.invoke(obj);
    }

    public Observable<k7> b(a args) {
        Intrinsics.f(args, "args");
        Observable n8 = ug.n(this.f44039a.a(), new b(args));
        final c cVar = c.f44043f;
        Observable<k7> flatMap = n8.flatMap(new Function() { // from class: eu.bolt.verification.sdk.internal.mu
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource c8;
                c8 = ld.c(Function1.this, obj);
                return c8;
            }
        });
        Intrinsics.e(flatMap, "override fun execute(arg…low }\n            }\n    }");
        return flatMap;
    }
}
