package kotlinx.coroutines.rx2;

import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.plugins.RxJavaPlugins;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.rx2.RxSchedulerKt;

/* compiled from: RxScheduler.kt */
/* loaded from: classes5.dex */
public final class RxSchedulerKt {
    public static final CoroutineDispatcher d(Scheduler scheduler) {
        if (scheduler instanceof DispatcherScheduler) {
            return ((DispatcherScheduler) scheduler).f51864c;
        }
        return new SchedulerCoroutineDispatcher(scheduler);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r5v4, types: [kotlinx.coroutines.DisposableHandle, T] */
    public static final Disposable e(CoroutineScope coroutineScope, Runnable runnable, long j8, Function1<? super Function1<? super Continuation<? super Unit>, ? extends Object>, ? extends Runnable> function1) {
        CoroutineContext j9 = coroutineScope.j();
        final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        Disposable d8 = Disposables.d(new Runnable() { // from class: o7.c
            @Override // java.lang.Runnable
            public final void run() {
                RxSchedulerKt.f(Ref$ObjectRef.this);
            }
        });
        Runnable invoke = function1.invoke(new RxSchedulerKt$scheduleTask$toSchedule$1(d8, j9, RxJavaPlugins.u(runnable)));
        if (!CoroutineScopeKt.f(coroutineScope)) {
            return Disposables.a();
        }
        if (j8 <= 0) {
            invoke.run();
        } else {
            ref$ObjectRef.f51016f = DelayKt.b(j9).Y(j8, invoke, j9);
        }
        return d8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(Ref$ObjectRef ref$ObjectRef) {
        DisposableHandle disposableHandle = (DisposableHandle) ref$ObjectRef.f51016f;
        if (disposableHandle != null) {
            disposableHandle.dispose();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(9:1|(2:3|(7:5|6|7|(1:(2:10|11)(2:17|18))(2:19|(2:21|22)(2:23|(1:25)))|12|13|14))|28|6|7|(0)(0)|12|13|14) */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0053, code lost:
        r4 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0054, code lost:
        kotlinx.coroutines.rx2.RxCancellableKt.a(r4, r5);
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0036  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object g(io.reactivex.disposables.Disposable r4, kotlin.coroutines.CoroutineContext r5, final java.lang.Runnable r6, kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
        /*
            boolean r0 = r7 instanceof kotlinx.coroutines.rx2.RxSchedulerKt$scheduleTask$task$1
            if (r0 == 0) goto L13
            r0 = r7
            kotlinx.coroutines.rx2.RxSchedulerKt$scheduleTask$task$1 r0 = (kotlinx.coroutines.rx2.RxSchedulerKt$scheduleTask$task$1) r0
            int r1 = r0.f51916h
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f51916h = r1
            goto L18
        L13:
            kotlinx.coroutines.rx2.RxSchedulerKt$scheduleTask$task$1 r0 = new kotlinx.coroutines.rx2.RxSchedulerKt$scheduleTask$task$1
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.f51915g
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.d()
            int r2 = r0.f51916h
            r3 = 1
            if (r2 == 0) goto L36
            if (r2 != r3) goto L2e
            java.lang.Object r4 = r0.f51914f
            r5 = r4
            kotlin.coroutines.CoroutineContext r5 = (kotlin.coroutines.CoroutineContext) r5
            kotlin.ResultKt.b(r7)     // Catch: java.lang.Throwable -> L53
            goto L57
        L2e:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L36:
            kotlin.ResultKt.b(r7)
            boolean r4 = r4.isDisposed()
            if (r4 == 0) goto L42
            kotlin.Unit r4 = kotlin.Unit.f50853a
            return r4
        L42:
            kotlinx.coroutines.rx2.RxSchedulerKt$scheduleTask$task$2 r4 = new kotlinx.coroutines.rx2.RxSchedulerKt$scheduleTask$task$2     // Catch: java.lang.Throwable -> L53
            r4.<init>()     // Catch: java.lang.Throwable -> L53
            r0.f51914f = r5     // Catch: java.lang.Throwable -> L53
            r0.f51916h = r3     // Catch: java.lang.Throwable -> L53
            r6 = 0
            java.lang.Object r4 = kotlinx.coroutines.InterruptibleKt.c(r6, r4, r0, r3, r6)     // Catch: java.lang.Throwable -> L53
            if (r4 != r1) goto L57
            return r1
        L53:
            r4 = move-exception
            kotlinx.coroutines.rx2.RxCancellableKt.a(r4, r5)
        L57:
            kotlin.Unit r4 = kotlin.Unit.f50853a
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.rx2.RxSchedulerKt.g(io.reactivex.disposables.Disposable, kotlin.coroutines.CoroutineContext, java.lang.Runnable, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
