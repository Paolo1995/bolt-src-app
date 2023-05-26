package eu.bolt.verification.sdk.internal;

import eu.bolt.verification.sdk.internal.qn;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import javax.inject.Inject;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes5.dex */
public final class tc {

    /* renamed from: a  reason: collision with root package name */
    private final rc f45160a;

    /* loaded from: classes5.dex */
    static final class a extends Lambda implements Function1<qn.b, String> {

        /* renamed from: f  reason: collision with root package name */
        public static final a f45161f = new a();

        a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: b */
        public final String invoke(qn.b it) {
            Intrinsics.f(it, "it");
            return it.c();
        }
    }

    @Inject
    public tc(rc observeCurrentFlowInteractor) {
        Intrinsics.f(observeCurrentFlowInteractor, "observeCurrentFlowInteractor");
        this.f45160a = observeCurrentFlowInteractor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String c(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (String) tmp0.invoke(obj);
    }

    public Observable<String> b() {
        Observable<qn.b> a8 = this.f45160a.a();
        final a aVar = a.f45161f;
        Observable<String> distinctUntilChanged = a8.map(new Function() { // from class: eu.bolt.verification.sdk.internal.ew
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                String c8;
                c8 = tc.c(Function1.this, obj);
                return c8;
            }
        }).distinctUntilChanged();
        Intrinsics.e(distinctUntilChanged, "observeCurrentFlowIntera…  .distinctUntilChanged()");
        return distinctUntilChanged;
    }
}
