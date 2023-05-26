package ee.mtakso.driver.service.device.fingerprint;

import ee.mtakso.driver.service.BaseService;
import ee.mtakso.driver.utils.DisposableExtKt;
import eu.bolt.kalev.Kalev;
import eu.bolt.kalev.fast.FastLog;
import io.reactivex.Completable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DeviceFingerprintService.kt */
/* loaded from: classes3.dex */
public final class DeviceFingerprintService implements BaseService {

    /* renamed from: a  reason: collision with root package name */
    private final DeviceFingerprintManager f24298a;

    /* renamed from: b  reason: collision with root package name */
    private Disposable f24299b;

    @Inject
    public DeviceFingerprintService(DeviceFingerprintManager manager) {
        Intrinsics.f(manager, "manager");
        this.f24298a = manager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g() {
        FastLog g8 = Kalev.f41674e.g();
        if (g8 != null) {
            FastLog.DefaultImpls.c(g8, "Fingerprint sent", null, 2, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // ee.mtakso.driver.service.BaseService
    public boolean start() {
        Completable I = this.f24298a.c().I(Schedulers.c());
        Action action = new Action() { // from class: ee.mtakso.driver.service.device.fingerprint.c
            @Override // io.reactivex.functions.Action
            public final void run() {
                DeviceFingerprintService.g();
            }
        };
        final DeviceFingerprintService$start$2 deviceFingerprintService$start$2 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.service.device.fingerprint.DeviceFingerprintService$start$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.f50853a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable it) {
                Intrinsics.e(it, "it");
                Kalev.e(it, "Failed to send fingerprint");
            }
        };
        this.f24299b = I.G(action, new Consumer() { // from class: ee.mtakso.driver.service.device.fingerprint.d
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                DeviceFingerprintService.h(Function1.this, obj);
            }
        });
        return true;
    }

    @Override // ee.mtakso.driver.service.BaseService
    public void stop() {
        Disposable disposable = this.f24299b;
        if (disposable != null) {
            DisposableExtKt.a(disposable);
        }
    }
}
