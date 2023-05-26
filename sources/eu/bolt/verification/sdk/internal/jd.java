package eu.bolt.verification.sdk.internal;

import eu.bolt.verification.sdk.internal.qn;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import javax.inject.Inject;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes5.dex */
public final class jd {

    /* renamed from: a  reason: collision with root package name */
    private final rc f43689a;

    /* loaded from: classes5.dex */
    static final class a extends Lambda implements Function1<qn.b, vd<Integer>> {

        /* renamed from: f  reason: collision with root package name */
        public static final a f43690f = new a();

        a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: b */
        public final vd<Integer> invoke(qn.b it) {
            Intrinsics.f(it, "it");
            return vd.b(it.d());
        }
    }

    @Inject
    public jd(rc observeCurrentFlowInteractor) {
        Intrinsics.f(observeCurrentFlowInteractor, "observeCurrentFlowInteractor");
        this.f43689a = observeCurrentFlowInteractor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final vd b(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (vd) tmp0.invoke(obj);
    }

    public Observable<vd<Integer>> c() {
        Observable<qn.b> a8 = this.f43689a.a();
        final a aVar = a.f43690f;
        Observable<vd<Integer>> distinctUntilChanged = a8.map(new Function() { // from class: eu.bolt.verification.sdk.internal.wt
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                vd b8;
                b8 = jd.b(Function1.this, obj);
                return b8;
            }
        }).distinctUntilChanged();
        Intrinsics.e(distinctUntilChanged, "observeCurrentFlowIntera…  .distinctUntilChanged()");
        return distinctUntilChanged;
    }
}
