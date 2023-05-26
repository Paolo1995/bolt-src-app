package ee.mtakso.driver.service.modules.surge;

import ee.mtakso.driver.network.client.driver.surge.SurgeMap;
import ee.mtakso.driver.param.DriverProvider;
import ee.mtakso.driver.utils.Optional;
import io.reactivex.Observable;
import io.reactivex.functions.BiFunction;
import io.reactivex.subjects.BehaviorSubject;
import io.reactivex.subjects.PublishSubject;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SurgeManager.kt */
@Singleton
/* loaded from: classes3.dex */
public final class SurgeManager {

    /* renamed from: a  reason: collision with root package name */
    private final DriverProvider f25297a;

    /* renamed from: b  reason: collision with root package name */
    private final BehaviorSubject<Optional<SurgeMap>> f25298b;

    /* renamed from: c  reason: collision with root package name */
    private final PublishSubject<String> f25299c;

    @Inject
    public SurgeManager(DriverProvider driverProvider) {
        Intrinsics.f(driverProvider, "driverProvider");
        this.f25297a = driverProvider;
        BehaviorSubject<Optional<SurgeMap>> e8 = BehaviorSubject.e();
        Intrinsics.e(e8, "create<Optional<SurgeMap>>()");
        this.f25298b = e8;
        PublishSubject<String> e9 = PublishSubject.e();
        Intrinsics.e(e9, "create<String>()");
        this.f25299c = e9;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SurgeSettings e(Function2 tmp0, Object obj, Object obj2) {
        Intrinsics.f(tmp0, "$tmp0");
        return (SurgeSettings) tmp0.s(obj, obj2);
    }

    public static /* synthetic */ void h(SurgeManager surgeManager, String str, boolean z7, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            z7 = false;
        }
        surgeManager.g(str, z7);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean c() {
        /*
            r5 = this;
            io.reactivex.subjects.BehaviorSubject<ee.mtakso.driver.utils.Optional<ee.mtakso.driver.network.client.driver.surge.SurgeMap>> r0 = r5.f25298b
            java.lang.Object r0 = r0.g()
            ee.mtakso.driver.utils.Optional r0 = (ee.mtakso.driver.utils.Optional) r0
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L14
            boolean r0 = r0.d()
            if (r0 != r1) goto L14
            r0 = 1
            goto L15
        L14:
            r0 = 0
        L15:
            if (r0 != 0) goto L55
            io.reactivex.subjects.BehaviorSubject<ee.mtakso.driver.utils.Optional<ee.mtakso.driver.network.client.driver.surge.SurgeMap>> r0 = r5.f25298b
            java.lang.Object r0 = r0.g()
            ee.mtakso.driver.utils.Optional r0 = (ee.mtakso.driver.utils.Optional) r0
            r3 = 0
            if (r0 == 0) goto L29
            java.lang.Object r0 = r0.c()
            ee.mtakso.driver.network.client.driver.surge.SurgeMap r0 = (ee.mtakso.driver.network.client.driver.surge.SurgeMap) r0
            goto L2a
        L29:
            r0 = r3
        L2a:
            if (r0 == 0) goto L31
            java.lang.String r4 = r0.d()
            goto L32
        L31:
            r4 = r3
        L32:
            if (r4 == 0) goto L3d
            boolean r4 = kotlin.text.StringsKt.y(r4)
            if (r4 == 0) goto L3b
            goto L3d
        L3b:
            r4 = 0
            goto L3e
        L3d:
            r4 = 1
        L3e:
            if (r4 == 0) goto L56
            if (r0 == 0) goto L46
            java.util.LinkedHashMap r3 = r0.a()
        L46:
            if (r3 == 0) goto L51
            boolean r0 = r3.isEmpty()
            if (r0 == 0) goto L4f
            goto L51
        L4f:
            r0 = 0
            goto L52
        L51:
            r0 = 1
        L52:
            if (r0 != 0) goto L55
            goto L56
        L55:
            r1 = 0
        L56:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: ee.mtakso.driver.service.modules.surge.SurgeManager.c():boolean");
    }

    public final Observable<SurgeSettings> d() {
        BehaviorSubject<Optional<SurgeMap>> behaviorSubject = this.f25298b;
        Observable<String> startWith = this.f25299c.startWith((PublishSubject<String>) this.f25297a.v().P());
        final Function2<Optional<SurgeMap>, String, SurgeSettings> function2 = new Function2<Optional<SurgeMap>, String, SurgeSettings>() { // from class: ee.mtakso.driver.service.modules.surge.SurgeManager$observeSurgeSettings$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            /* renamed from: b */
            public final SurgeSettings s(Optional<SurgeMap> optionalSurgeMap, String categoryId) {
                DriverProvider driverProvider;
                Intrinsics.f(optionalSurgeMap, "optionalSurgeMap");
                Intrinsics.f(categoryId, "categoryId");
                driverProvider = SurgeManager.this.f25297a;
                return new SurgeSettings(optionalSurgeMap.c(), categoryId, driverProvider.v().Q());
            }
        };
        Observable<SurgeSettings> combineLatest = Observable.combineLatest(behaviorSubject, startWith, new BiFunction() { // from class: ee.mtakso.driver.service.modules.surge.a
            @Override // io.reactivex.functions.BiFunction
            public final Object apply(Object obj, Object obj2) {
                SurgeSettings e8;
                e8 = SurgeManager.e(Function2.this, obj, obj2);
                return e8;
            }
        });
        Intrinsics.e(combineLatest, "fun observeSurgeSettings…        )\n        }\n    }");
        return combineLatest;
    }

    public final void f(Optional<SurgeMap> currentSurge) {
        Intrinsics.f(currentSurge, "currentSurge");
        if (Intrinsics.a(this.f25298b.g(), currentSurge)) {
            return;
        }
        this.f25298b.onNext(currentSurge);
    }

    public final void g(String str, boolean z7) {
        if (str == null) {
            str = "";
        }
        this.f25297a.v().o0(true);
        this.f25297a.v().n0(str);
        if (!z7) {
            this.f25299c.onNext(str);
        }
    }
}
