package ee.mtakso.driver.service.modules.emergencyassist;

import ee.mtakso.driver.Config;
import ee.mtakso.driver.utils.ext.ApiExceptionUtils;
import eu.bolt.kalev.Kalev;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: EmergencyAssistManager.kt */
/* loaded from: classes3.dex */
public final class EmergencyAssistManager$startIncidentUpdater$3 extends Lambda implements Function1<Observable<Throwable>, ObservableSource<?>> {

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ long f24700f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EmergencyAssistManager$startIncidentUpdater$3(long j8) {
        super(1);
        this.f24700f = j8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ObservableSource d(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (ObservableSource) tmp0.invoke(obj);
    }

    @Override // kotlin.jvm.functions.Function1
    /* renamed from: c */
    public final ObservableSource<?> invoke(Observable<Throwable> observable) {
        Intrinsics.f(observable, "observable");
        final long j8 = this.f24700f;
        final Function1<Throwable, ObservableSource<? extends Object>> function1 = new Function1<Throwable, ObservableSource<? extends Object>>() { // from class: ee.mtakso.driver.service.modules.emergencyassist.EmergencyAssistManager$startIncidentUpdater$3.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final ObservableSource<? extends Object> invoke(Throwable throwable) {
                Intrinsics.f(throwable, "throwable");
                long j9 = j8;
                String message = throwable.getMessage();
                Kalev.h("failed to update incident with id " + j9 + ". Error: " + message);
                if (ApiExceptionUtils.m(throwable, 761)) {
                    return Observable.error(throwable);
                }
                return Observable.timer(Config.f19824b, TimeUnit.SECONDS);
            }
        };
        return observable.flatMap(new Function() { // from class: ee.mtakso.driver.service.modules.emergencyassist.o
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource d8;
                d8 = EmergencyAssistManager$startIncidentUpdater$3.d(Function1.this, obj);
                return d8;
            }
        });
    }
}
