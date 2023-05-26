package kotlinx.coroutines.flow.internal;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.sync.Semaphore;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Merge.kt */
/* loaded from: classes5.dex */
public final class ChannelFlowMerge$collectTo$2<T> implements FlowCollector {

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ Job f51679f;

    /* renamed from: g  reason: collision with root package name */
    final /* synthetic */ Semaphore f51680g;

    /* renamed from: h  reason: collision with root package name */
    final /* synthetic */ ProducerScope<T> f51681h;

    /* renamed from: i  reason: collision with root package name */
    final /* synthetic */ SendingCollector<T> f51682i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Merge.kt */
    @DebugMetadata(c = "kotlinx.coroutines.flow.internal.ChannelFlowMerge$collectTo$2$1", f = "Merge.kt", l = {69}, m = "invokeSuspend")
    /* renamed from: kotlinx.coroutines.flow.internal.ChannelFlowMerge$collectTo$2$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: g  reason: collision with root package name */
        int f51683g;

        /* renamed from: h  reason: collision with root package name */
        final /* synthetic */ Flow<T> f51684h;

        /* renamed from: i  reason: collision with root package name */
        final /* synthetic */ SendingCollector<T> f51685i;

        /* renamed from: j  reason: collision with root package name */
        final /* synthetic */ Semaphore f51686j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(Flow<? extends T> flow, SendingCollector<T> sendingCollector, Semaphore semaphore, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.f51684h = flow;
            this.f51685i = sendingCollector;
            this.f51686j = semaphore;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.f51684h, this.f51685i, this.f51686j, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: h */
        public final Object s(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f50853a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object d8;
            d8 = IntrinsicsKt__IntrinsicsKt.d();
            int i8 = this.f51683g;
            try {
                if (i8 != 0) {
                    if (i8 == 1) {
                        ResultKt.b(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.b(obj);
                    Flow<T> flow = this.f51684h;
                    SendingCollector<T> sendingCollector = this.f51685i;
                    this.f51683g = 1;
                    if (flow.a(sendingCollector, this) == d8) {
                        return d8;
                    }
                }
                this.f51686j.release();
                return Unit.f50853a;
            } catch (Throwable th) {
                this.f51686j.release();
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public ChannelFlowMerge$collectTo$2(Job job, Semaphore semaphore, ProducerScope<? super T> producerScope, SendingCollector<T> sendingCollector) {
        this.f51679f = job;
        this.f51680g = semaphore;
        this.f51681h = producerScope;
        this.f51682i = sendingCollector;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0039  */
    @Override // kotlinx.coroutines.flow.FlowCollector
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object b(kotlinx.coroutines.flow.Flow<? extends T> r8, kotlin.coroutines.Continuation<? super kotlin.Unit> r9) {
        /*
            r7 = this;
            boolean r0 = r9 instanceof kotlinx.coroutines.flow.internal.ChannelFlowMerge$collectTo$2$emit$1
            if (r0 == 0) goto L13
            r0 = r9
            kotlinx.coroutines.flow.internal.ChannelFlowMerge$collectTo$2$emit$1 r0 = (kotlinx.coroutines.flow.internal.ChannelFlowMerge$collectTo$2$emit$1) r0
            int r1 = r0.f51691j
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f51691j = r1
            goto L18
        L13:
            kotlinx.coroutines.flow.internal.ChannelFlowMerge$collectTo$2$emit$1 r0 = new kotlinx.coroutines.flow.internal.ChannelFlowMerge$collectTo$2$emit$1
            r0.<init>(r7, r9)
        L18:
            java.lang.Object r9 = r0.f51689h
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.d()
            int r2 = r0.f51691j
            r3 = 1
            if (r2 == 0) goto L39
            if (r2 != r3) goto L31
            java.lang.Object r8 = r0.f51688g
            kotlinx.coroutines.flow.Flow r8 = (kotlinx.coroutines.flow.Flow) r8
            java.lang.Object r0 = r0.f51687f
            kotlinx.coroutines.flow.internal.ChannelFlowMerge$collectTo$2 r0 = (kotlinx.coroutines.flow.internal.ChannelFlowMerge$collectTo$2) r0
            kotlin.ResultKt.b(r9)
            goto L53
        L31:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L39:
            kotlin.ResultKt.b(r9)
            kotlinx.coroutines.Job r9 = r7.f51679f
            if (r9 == 0) goto L43
            kotlinx.coroutines.JobKt.j(r9)
        L43:
            kotlinx.coroutines.sync.Semaphore r9 = r7.f51680g
            r0.f51687f = r7
            r0.f51688g = r8
            r0.f51691j = r3
            java.lang.Object r9 = r9.a(r0)
            if (r9 != r1) goto L52
            return r1
        L52:
            r0 = r7
        L53:
            kotlinx.coroutines.channels.ProducerScope<T> r1 = r0.f51681h
            r2 = 0
            r3 = 0
            kotlinx.coroutines.flow.internal.ChannelFlowMerge$collectTo$2$1 r4 = new kotlinx.coroutines.flow.internal.ChannelFlowMerge$collectTo$2$1
            kotlinx.coroutines.flow.internal.SendingCollector<T> r9 = r0.f51682i
            kotlinx.coroutines.sync.Semaphore r0 = r0.f51680g
            r5 = 0
            r4.<init>(r8, r9, r0, r5)
            r5 = 3
            r6 = 0
            kotlinx.coroutines.BuildersKt.d(r1, r2, r3, r4, r5, r6)
            kotlin.Unit r8 = kotlin.Unit.f50853a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.internal.ChannelFlowMerge$collectTo$2.b(kotlinx.coroutines.flow.Flow, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
