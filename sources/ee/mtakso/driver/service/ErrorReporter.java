package ee.mtakso.driver.service;

import eu.bolt.kalev.Kalev;
import io.reactivex.exceptions.UndeliverableException;
import io.reactivex.functions.Consumer;
import io.reactivex.plugins.RxJavaPlugins;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ErrorReporter.kt */
/* loaded from: classes3.dex */
public final class ErrorReporter {

    /* renamed from: a  reason: collision with root package name */
    public static final ErrorReporter f23403a = new ErrorReporter();

    private ErrorReporter() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final void b() {
        final ErrorReporter$initRxPlugin$1 errorReporter$initRxPlugin$1 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.service.ErrorReporter$initRxPlugin$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.f50853a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable cause) {
                if (cause instanceof UndeliverableException) {
                    cause = cause.getCause();
                }
                Intrinsics.e(cause, "cause");
                Kalev.e(cause, "Global error via RxJava!");
            }
        };
        RxJavaPlugins.B(new Consumer() { // from class: ee.mtakso.driver.service.f
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ErrorReporter.c(Function1.this, obj);
            }
        });
    }
}
