package kotlinx.coroutines.flow.internal;

import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__IndentKt;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.flow.FlowCollector;

/* compiled from: SafeCollector.kt */
/* loaded from: classes5.dex */
public final class SafeCollector<T> extends ContinuationImpl implements FlowCollector<T> {

    /* renamed from: f  reason: collision with root package name */
    public final FlowCollector<T> f51752f;

    /* renamed from: g  reason: collision with root package name */
    public final CoroutineContext f51753g;

    /* renamed from: h  reason: collision with root package name */
    public final int f51754h;

    /* renamed from: i  reason: collision with root package name */
    private CoroutineContext f51755i;

    /* renamed from: j  reason: collision with root package name */
    private Continuation<? super Unit> f51756j;

    /* JADX WARN: Multi-variable type inference failed */
    public SafeCollector(FlowCollector<? super T> flowCollector, CoroutineContext coroutineContext) {
        super(NoOpContinuation.f51746f, EmptyCoroutineContext.f50912f);
        this.f51752f = flowCollector;
        this.f51753g = coroutineContext;
        this.f51754h = ((Number) coroutineContext.l(0, new Function2<Integer, CoroutineContext.Element, Integer>() { // from class: kotlinx.coroutines.flow.internal.SafeCollector$collectContextSize$1
            public final Integer b(int i8, CoroutineContext.Element element) {
                return Integer.valueOf(i8 + 1);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Integer s(Integer num, CoroutineContext.Element element) {
                return b(num.intValue(), element);
            }
        })).intValue();
    }

    private final void h(CoroutineContext coroutineContext, CoroutineContext coroutineContext2, T t7) {
        if (coroutineContext2 instanceof DownstreamExceptionContext) {
            k((DownstreamExceptionContext) coroutineContext2, t7);
        }
        SafeCollector_commonKt.a(this, coroutineContext);
    }

    private final Object j(Continuation<? super Unit> continuation, T t7) {
        Object d8;
        CoroutineContext context = continuation.getContext();
        JobKt.i(context);
        CoroutineContext coroutineContext = this.f51755i;
        if (coroutineContext != context) {
            h(context, coroutineContext, t7);
            this.f51755i = context;
        }
        this.f51756j = continuation;
        Object l8 = SafeCollectorKt.a().l(this.f51752f, t7, this);
        d8 = IntrinsicsKt__IntrinsicsKt.d();
        if (!Intrinsics.a(l8, d8)) {
            this.f51756j = null;
        }
        return l8;
    }

    private final void k(DownstreamExceptionContext downstreamExceptionContext, Object obj) {
        String f8;
        f8 = StringsKt__IndentKt.f("\n            Flow exception transparency is violated:\n                Previous 'emit' call has thrown exception " + downstreamExceptionContext.f51739f + ", but then emission attempt of value '" + obj + "' has been detected.\n                Emissions from 'catch' blocks are prohibited in order to avoid unspecified behaviour, 'Flow.catch' operator can be used instead.\n                For a more detailed explanation, please refer to Flow documentation.\n            ");
        throw new IllegalStateException(f8.toString());
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public Object b(T t7, Continuation<? super Unit> continuation) {
        Object d8;
        Object d9;
        try {
            Object j8 = j(continuation, t7);
            d8 = IntrinsicsKt__IntrinsicsKt.d();
            if (j8 == d8) {
                DebugProbesKt.c(continuation);
            }
            d9 = IntrinsicsKt__IntrinsicsKt.d();
            if (j8 == d9) {
                return j8;
            }
            return Unit.f50853a;
        } catch (Throwable th) {
            this.f51755i = new DownstreamExceptionContext(th, continuation.getContext());
            throw th;
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl, kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public CoroutineStackFrame getCallerFrame() {
        Continuation<? super Unit> continuation = this.f51756j;
        if (continuation instanceof CoroutineStackFrame) {
            return (CoroutineStackFrame) continuation;
        }
        return null;
    }

    @Override // kotlin.coroutines.jvm.internal.ContinuationImpl, kotlin.coroutines.Continuation
    public CoroutineContext getContext() {
        CoroutineContext coroutineContext = this.f51755i;
        if (coroutineContext == null) {
            return EmptyCoroutineContext.f50912f;
        }
        return coroutineContext;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public StackTraceElement getStackTraceElement() {
        return null;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public Object invokeSuspend(Object obj) {
        Object d8;
        Throwable e8 = Result.e(obj);
        if (e8 != null) {
            this.f51755i = new DownstreamExceptionContext(e8, getContext());
        }
        Continuation<? super Unit> continuation = this.f51756j;
        if (continuation != null) {
            continuation.resumeWith(obj);
        }
        d8 = IntrinsicsKt__IntrinsicsKt.d();
        return d8;
    }

    @Override // kotlin.coroutines.jvm.internal.ContinuationImpl, kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public void releaseIntercepted() {
        super.releaseIntercepted();
    }
}
