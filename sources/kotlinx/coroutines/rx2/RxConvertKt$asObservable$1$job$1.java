package kotlinx.coroutines.rx2;

import io.reactivex.ObservableEmitter;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RxConvert.kt */
@DebugMetadata(c = "kotlinx.coroutines.rx2.RxConvertKt$asObservable$1$job$1", f = "RxConvert.kt", l = {114}, m = "invokeSuspend")
/* loaded from: classes5.dex */
public final class RxConvertKt$asObservable$1$job$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: g  reason: collision with root package name */
    int f51909g;

    /* renamed from: h  reason: collision with root package name */
    private /* synthetic */ Object f51910h;

    /* renamed from: i  reason: collision with root package name */
    final /* synthetic */ Flow f51911i;

    /* renamed from: j  reason: collision with root package name */
    final /* synthetic */ ObservableEmitter f51912j;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RxConvertKt$asObservable$1$job$1(Flow flow, ObservableEmitter observableEmitter, Continuation continuation) {
        super(2, continuation);
        this.f51911i = flow;
        this.f51912j = observableEmitter;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        RxConvertKt$asObservable$1$job$1 rxConvertKt$asObservable$1$job$1 = new RxConvertKt$asObservable$1$job$1(this.f51911i, this.f51912j, continuation);
        rxConvertKt$asObservable$1$job$1.f51910h = obj;
        return rxConvertKt$asObservable$1$job$1;
    }

    @Override // kotlin.jvm.functions.Function2
    /* renamed from: h */
    public final Object s(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((RxConvertKt$asObservable$1$job$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f50853a);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0057  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r7) {
        /*
            r6 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.d()
            int r1 = r6.f51909g
            r2 = 1
            if (r1 == 0) goto L1d
            if (r1 != r2) goto L15
            java.lang.Object r0 = r6.f51910h
            kotlinx.coroutines.CoroutineScope r0 = (kotlinx.coroutines.CoroutineScope) r0
            kotlin.ResultKt.b(r7)     // Catch: java.lang.Throwable -> L13
            goto L39
        L13:
            r7 = move-exception
            goto L43
        L15:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L1d:
            kotlin.ResultKt.b(r7)
            java.lang.Object r7 = r6.f51910h
            kotlinx.coroutines.CoroutineScope r7 = (kotlinx.coroutines.CoroutineScope) r7
            kotlinx.coroutines.flow.Flow r1 = r6.f51911i     // Catch: java.lang.Throwable -> L3f
            kotlinx.coroutines.rx2.RxConvertKt$asObservable$1$job$1$1 r3 = new kotlinx.coroutines.rx2.RxConvertKt$asObservable$1$job$1$1     // Catch: java.lang.Throwable -> L3f
            io.reactivex.ObservableEmitter r4 = r6.f51912j     // Catch: java.lang.Throwable -> L3f
            r3.<init>()     // Catch: java.lang.Throwable -> L3f
            r6.f51910h = r7     // Catch: java.lang.Throwable -> L3f
            r6.f51909g = r2     // Catch: java.lang.Throwable -> L3f
            java.lang.Object r1 = r1.a(r3, r6)     // Catch: java.lang.Throwable -> L3f
            if (r1 != r0) goto L38
            return r0
        L38:
            r0 = r7
        L39:
            io.reactivex.ObservableEmitter r7 = r6.f51912j     // Catch: java.lang.Throwable -> L13
            r7.onComplete()     // Catch: java.lang.Throwable -> L13
            goto L5c
        L3f:
            r0 = move-exception
            r5 = r0
            r0 = r7
            r7 = r5
        L43:
            boolean r1 = r7 instanceof java.util.concurrent.CancellationException
            if (r1 != 0) goto L57
            io.reactivex.ObservableEmitter r1 = r6.f51912j
            boolean r1 = r1.a(r7)
            if (r1 != 0) goto L5c
            kotlin.coroutines.CoroutineContext r0 = r0.j()
            kotlinx.coroutines.rx2.RxCancellableKt.a(r7, r0)
            goto L5c
        L57:
            io.reactivex.ObservableEmitter r7 = r6.f51912j
            r7.onComplete()
        L5c:
            kotlin.Unit r7 = kotlin.Unit.f50853a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.rx2.RxConvertKt$asObservable$1$job$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
