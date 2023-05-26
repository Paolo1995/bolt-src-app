package eu.bolt.chat.async;

import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: FlowBufferedChunks.kt */
@DebugMetadata(c = "eu.bolt.chat.async.TimedChunkFlow$resultFlow$1", f = "FlowBufferedChunks.kt", l = {17}, m = "invokeSuspend")
/* loaded from: classes5.dex */
public final class TimedChunkFlow$resultFlow$1<T> extends SuspendLambda implements Function2<FlowCollector<? super List<T>>, Continuation<? super Unit>, Object> {

    /* renamed from: g  reason: collision with root package name */
    int f37860g;

    /* renamed from: h  reason: collision with root package name */
    private /* synthetic */ Object f37861h;

    /* renamed from: i  reason: collision with root package name */
    final /* synthetic */ Flow<T> f37862i;

    /* renamed from: j  reason: collision with root package name */
    final /* synthetic */ TimedChunkFlow<T> f37863j;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FlowBufferedChunks.kt */
    /* renamed from: eu.bolt.chat.async.TimedChunkFlow$resultFlow$1$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    public static final class AnonymousClass1<T> implements FlowCollector {

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ TimedChunkFlow<T> f37864f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ FlowCollector<List<T>> f37865g;

        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(TimedChunkFlow<T> timedChunkFlow, FlowCollector<? super List<T>> flowCollector) {
            this.f37864f = timedChunkFlow;
            this.f37865g = flowCollector;
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
        /* JADX WARN: Removed duplicated region for block: B:16:0x0047  */
        /* JADX WARN: Removed duplicated region for block: B:23:0x0086 A[RETURN] */
        @Override // kotlinx.coroutines.flow.FlowCollector
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object b(T r8, kotlin.coroutines.Continuation<? super kotlin.Unit> r9) {
            /*
                r7 = this;
                boolean r0 = r9 instanceof eu.bolt.chat.async.TimedChunkFlow$resultFlow$1$1$emit$1
                if (r0 == 0) goto L13
                r0 = r9
                eu.bolt.chat.async.TimedChunkFlow$resultFlow$1$1$emit$1 r0 = (eu.bolt.chat.async.TimedChunkFlow$resultFlow$1$1$emit$1) r0
                int r1 = r0.f37872l
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.f37872l = r1
                goto L18
            L13:
                eu.bolt.chat.async.TimedChunkFlow$resultFlow$1$1$emit$1 r0 = new eu.bolt.chat.async.TimedChunkFlow$resultFlow$1$1$emit$1
                r0.<init>(r7, r9)
            L18:
                java.lang.Object r9 = r0.f37870j
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.d()
                int r2 = r0.f37872l
                r3 = 2
                r4 = 1
                r5 = 0
                if (r2 == 0) goto L47
                if (r2 == r4) goto L35
                if (r2 != r3) goto L2d
                kotlin.ResultKt.b(r9)
                goto L87
            L2d:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r9)
                throw r8
            L35:
                java.lang.Object r8 = r0.f37869i
                eu.bolt.chat.async.TimedChunkFlow r8 = (eu.bolt.chat.async.TimedChunkFlow) r8
                java.lang.Object r2 = r0.f37868h
                kotlinx.coroutines.sync.Mutex r2 = (kotlinx.coroutines.sync.Mutex) r2
                java.lang.Object r4 = r0.f37867g
                java.lang.Object r6 = r0.f37866f
                eu.bolt.chat.async.TimedChunkFlow$resultFlow$1$1 r6 = (eu.bolt.chat.async.TimedChunkFlow$resultFlow$1.AnonymousClass1) r6
                kotlin.ResultKt.b(r9)
                goto L66
            L47:
                kotlin.ResultKt.b(r9)
                eu.bolt.chat.async.TimedChunkFlow<T> r9 = r7.f37864f
                kotlinx.coroutines.sync.Mutex r2 = eu.bolt.chat.async.TimedChunkFlow.b(r9)
                eu.bolt.chat.async.TimedChunkFlow<T> r9 = r7.f37864f
                r0.f37866f = r7
                r0.f37867g = r8
                r0.f37868h = r2
                r0.f37869i = r9
                r0.f37872l = r4
                java.lang.Object r4 = r2.a(r5, r0)
                if (r4 != r1) goto L63
                return r1
            L63:
                r6 = r7
                r4 = r8
                r8 = r9
            L66:
                java.util.List r9 = eu.bolt.chat.async.TimedChunkFlow.a(r8)     // Catch: java.lang.Throwable -> L8a
                r9.add(r4)     // Catch: java.lang.Throwable -> L8a
                java.util.List r8 = eu.bolt.chat.async.TimedChunkFlow.a(r8)     // Catch: java.lang.Throwable -> L8a
                r2.b(r5)
                kotlinx.coroutines.flow.FlowCollector<java.util.List<T>> r9 = r6.f37865g
                r0.f37866f = r5
                r0.f37867g = r5
                r0.f37868h = r5
                r0.f37869i = r5
                r0.f37872l = r3
                java.lang.Object r8 = r9.b(r8, r0)
                if (r8 != r1) goto L87
                return r1
            L87:
                kotlin.Unit r8 = kotlin.Unit.f50853a
                return r8
            L8a:
                r8 = move-exception
                r2.b(r5)
                throw r8
            */
            throw new UnsupportedOperationException("Method not decompiled: eu.bolt.chat.async.TimedChunkFlow$resultFlow$1.AnonymousClass1.b(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public TimedChunkFlow$resultFlow$1(Flow<? extends T> flow, TimedChunkFlow<T> timedChunkFlow, Continuation<? super TimedChunkFlow$resultFlow$1> continuation) {
        super(2, continuation);
        this.f37862i = flow;
        this.f37863j = timedChunkFlow;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        TimedChunkFlow$resultFlow$1 timedChunkFlow$resultFlow$1 = new TimedChunkFlow$resultFlow$1(this.f37862i, this.f37863j, continuation);
        timedChunkFlow$resultFlow$1.f37861h = obj;
        return timedChunkFlow$resultFlow$1;
    }

    @Override // kotlin.jvm.functions.Function2
    /* renamed from: h */
    public final Object s(FlowCollector<? super List<T>> flowCollector, Continuation<? super Unit> continuation) {
        return ((TimedChunkFlow$resultFlow$1) create(flowCollector, continuation)).invokeSuspend(Unit.f50853a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object d8;
        d8 = IntrinsicsKt__IntrinsicsKt.d();
        int i8 = this.f37860g;
        if (i8 != 0) {
            if (i8 == 1) {
                ResultKt.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.b(obj);
            Flow<T> flow = this.f37862i;
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.f37863j, (FlowCollector) this.f37861h);
            this.f37860g = 1;
            if (flow.a(anonymousClass1, this) == d8) {
                return d8;
            }
        }
        return Unit.f50853a;
    }
}
