package ee.mtakso.driver.ui.interactor.driver;

import ee.mtakso.driver.network.client.driver.Cars;
import ee.mtakso.driver.network.client.driver.DriverClient;
import ee.mtakso.driver.service.driver.DriverManager;
import ee.mtakso.driver.ui.interactor.driver.DriverStateChangeFailInteractor;
import ee.mtakso.driver.utils.ext.ApiExceptionUtils;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.functions.Function;
import javax.inject.Inject;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DriverStateChangeFailInteractor.kt */
/* loaded from: classes3.dex */
public final class DriverStateChangeFailInteractor {

    /* renamed from: a  reason: collision with root package name */
    private final DriverManager f26465a;

    /* renamed from: b  reason: collision with root package name */
    private final DriverClient f26466b;

    /* compiled from: DriverStateChangeFailInteractor.kt */
    /* loaded from: classes3.dex */
    public static final class UpdateCarRequired {

        /* renamed from: a  reason: collision with root package name */
        private final boolean f26467a;

        public UpdateCarRequired(boolean z7) {
            this.f26467a = z7;
        }

        public final boolean a() {
            return this.f26467a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof UpdateCarRequired) && this.f26467a == ((UpdateCarRequired) obj).f26467a;
        }

        public int hashCode() {
            boolean z7 = this.f26467a;
            if (z7) {
                return 1;
            }
            return z7 ? 1 : 0;
        }

        public String toString() {
            boolean z7 = this.f26467a;
            return "UpdateCarRequired(hasCars=" + z7 + ")";
        }
    }

    @Inject
    public DriverStateChangeFailInteractor(DriverManager driverManager, DriverClient driverClient) {
        Intrinsics.f(driverManager, "driverManager");
        Intrinsics.f(driverClient, "driverClient");
        this.f26465a = driverManager;
        this.f26466b = driverClient;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SingleSource e(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (SingleSource) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Single<UpdateCarRequired> f() {
        Single<Cars> i8 = this.f26466b.i();
        final DriverStateChangeFailInteractor$requestCarsAndFireCarUnavailableDialog$1 driverStateChangeFailInteractor$requestCarsAndFireCarUnavailableDialog$1 = new Function1<Cars, UpdateCarRequired>() { // from class: ee.mtakso.driver.ui.interactor.driver.DriverStateChangeFailInteractor$requestCarsAndFireCarUnavailableDialog$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final DriverStateChangeFailInteractor.UpdateCarRequired invoke(Cars it) {
                Intrinsics.f(it, "it");
                return new DriverStateChangeFailInteractor.UpdateCarRequired(!it.a().isEmpty());
            }
        };
        Single x7 = i8.x(new Function() { // from class: ee.mtakso.driver.ui.interactor.driver.d
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                DriverStateChangeFailInteractor.UpdateCarRequired g8;
                g8 = DriverStateChangeFailInteractor.g(Function1.this, obj);
                return g8;
            }
        });
        Intrinsics.e(x7, "driverClient.getCars()\n …          )\n            }");
        return x7;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final UpdateCarRequired g(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (UpdateCarRequired) tmp0.invoke(obj);
    }

    public final Observable<UpdateCarRequired> d() {
        Observable<Throwable> t7 = this.f26465a.t();
        final Function1<Throwable, SingleSource<? extends UpdateCarRequired>> function1 = new Function1<Throwable, SingleSource<? extends UpdateCarRequired>>() { // from class: ee.mtakso.driver.ui.interactor.driver.DriverStateChangeFailInteractor$observeDriverUpdateCarRequired$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final SingleSource<? extends DriverStateChangeFailInteractor.UpdateCarRequired> invoke(Throwable error) {
                Single f8;
                Intrinsics.f(error, "error");
                if (ApiExceptionUtils.m(error, 419)) {
                    f8 = DriverStateChangeFailInteractor.this.f();
                    return f8;
                }
                Single error2 = Single.error(error);
                Intrinsics.e(error2, "{\n                Single…rror(error)\n            }");
                return error2;
            }
        };
        Observable flatMapSingle = t7.flatMapSingle(new Function() { // from class: ee.mtakso.driver.ui.interactor.driver.c
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                SingleSource e8;
                e8 = DriverStateChangeFailInteractor.e(Function1.this, obj);
                return e8;
            }
        });
        Intrinsics.e(flatMapSingle, "fun observeDriverUpdateC…)\n            }\n        }");
        return flatMapSingle;
    }
}
