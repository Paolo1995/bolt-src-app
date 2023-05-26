package ee.mtakso.driver.service.driver.other;

import ee.mtakso.driver.network.client.search.Drivers;
import ee.mtakso.driver.network.client.search.OtherDriver;
import ee.mtakso.driver.network.client.search.SearchClient;
import ee.mtakso.driver.utils.DisposableExtKt;
import eu.bolt.kalev.Kalev;
import eu.bolt.kalev.fast.FastLog;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.BehaviorSubject;
import java.util.List;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OtherDriversManager.kt */
/* loaded from: classes3.dex */
public final class OtherDriversManager {

    /* renamed from: a  reason: collision with root package name */
    private final SearchClient f24338a;

    /* renamed from: b  reason: collision with root package name */
    private Disposable f24339b;

    /* renamed from: c  reason: collision with root package name */
    private final BehaviorSubject<List<OtherDriver>> f24340c;

    @Inject
    public OtherDriversManager(SearchClient searchClient) {
        Intrinsics.f(searchClient, "searchClient");
        this.f24338a = searchClient;
        BehaviorSubject<List<OtherDriver>> e8 = BehaviorSubject.e();
        Intrinsics.e(e8, "create<List<OtherDriver>>()");
        this.f24340c = e8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final Observable<List<OtherDriver>> d() {
        return this.f24340c;
    }

    public final void e() {
        if (!DisposableExtKt.b(this.f24339b)) {
            FastLog g8 = Kalev.f41674e.g();
            if (g8 != null) {
                FastLog.DefaultImpls.c(g8, "Other drivers update in progress...", null, 2, null);
                return;
            }
            return;
        }
        Single<Drivers> a8 = this.f24338a.a();
        final Function1<Drivers, Unit> function1 = new Function1<Drivers, Unit>() { // from class: ee.mtakso.driver.service.driver.other.OtherDriversManager$updateOtherDrivers$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(Drivers drivers) {
                BehaviorSubject behaviorSubject;
                behaviorSubject = OtherDriversManager.this.f24340c;
                behaviorSubject.onNext(drivers.a());
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Drivers drivers) {
                b(drivers);
                return Unit.f50853a;
            }
        };
        Consumer<? super Drivers> consumer = new Consumer() { // from class: ee.mtakso.driver.service.driver.other.a
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                OtherDriversManager.f(Function1.this, obj);
            }
        };
        final OtherDriversManager$updateOtherDrivers$2 otherDriversManager$updateOtherDrivers$2 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.service.driver.other.OtherDriversManager$updateOtherDrivers$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.f50853a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable it) {
                Intrinsics.e(it, "it");
                Kalev.e(it, "Failed to update other drivers");
            }
        };
        this.f24339b = a8.I(consumer, new Consumer() { // from class: ee.mtakso.driver.service.driver.other.b
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                OtherDriversManager.g(Function1.this, obj);
            }
        });
    }
}
