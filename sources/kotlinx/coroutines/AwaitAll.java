package kotlinx.coroutines;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Await.kt */
/* loaded from: classes5.dex */
public final class AwaitAll<T> {

    /* renamed from: b  reason: collision with root package name */
    static final /* synthetic */ AtomicIntegerFieldUpdater f51208b = AtomicIntegerFieldUpdater.newUpdater(AwaitAll.class, "notCompletedCount");

    /* renamed from: a  reason: collision with root package name */
    private final Deferred<T>[] f51209a;
    volatile /* synthetic */ int notCompletedCount;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Await.kt */
    /* loaded from: classes5.dex */
    public final class AwaitAllNode extends JobNode {
        private volatile /* synthetic */ Object _disposer = null;

        /* renamed from: j  reason: collision with root package name */
        private final CancellableContinuation<List<? extends T>> f51210j;

        /* renamed from: k  reason: collision with root package name */
        public DisposableHandle f51211k;

        /* JADX WARN: Multi-variable type inference failed */
        public AwaitAllNode(CancellableContinuation<? super List<? extends T>> cancellableContinuation) {
            this.f51210j = cancellableContinuation;
        }

        @Override // kotlinx.coroutines.CompletionHandlerBase
        public void V(Throwable th) {
            if (th != null) {
                Object p8 = this.f51210j.p(th);
                if (p8 != null) {
                    this.f51210j.G(p8);
                    AwaitAll<T>.DisposeHandlersOnCancel Y = Y();
                    if (Y != null) {
                        Y.c();
                        return;
                    }
                    return;
                }
                return;
            }
            if (AwaitAll.f51208b.decrementAndGet(AwaitAll.this) == 0) {
                CancellableContinuation<List<? extends T>> cancellableContinuation = this.f51210j;
                Deferred[] deferredArr = ((AwaitAll) AwaitAll.this).f51209a;
                ArrayList arrayList = new ArrayList(deferredArr.length);
                for (Deferred deferred : deferredArr) {
                    arrayList.add(deferred.q());
                }
                cancellableContinuation.resumeWith(Result.b(arrayList));
            }
        }

        public final AwaitAll<T>.DisposeHandlersOnCancel Y() {
            return (DisposeHandlersOnCancel) this._disposer;
        }

        public final DisposableHandle Z() {
            DisposableHandle disposableHandle = this.f51211k;
            if (disposableHandle != null) {
                return disposableHandle;
            }
            Intrinsics.w("handle");
            return null;
        }

        public final void a0(AwaitAll<T>.DisposeHandlersOnCancel disposeHandlersOnCancel) {
            this._disposer = disposeHandlersOnCancel;
        }

        public final void b0(DisposableHandle disposableHandle) {
            this.f51211k = disposableHandle;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
            V(th);
            return Unit.f50853a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Await.kt */
    /* loaded from: classes5.dex */
    public final class DisposeHandlersOnCancel extends CancelHandler {

        /* renamed from: f  reason: collision with root package name */
        private final AwaitAll<T>.AwaitAllNode[] f51213f;

        public DisposeHandlersOnCancel(AwaitAll<T>.AwaitAllNode[] awaitAllNodeArr) {
            this.f51213f = awaitAllNodeArr;
        }

        @Override // kotlinx.coroutines.CancelHandlerBase
        public void b(Throwable th) {
            c();
        }

        public final void c() {
            for (AwaitAll<T>.AwaitAllNode awaitAllNode : this.f51213f) {
                awaitAllNode.Z().dispose();
            }
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
            b(th);
            return Unit.f50853a;
        }

        public String toString() {
            return "DisposeHandlersOnCancel[" + this.f51213f + ']';
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AwaitAll(Deferred<? extends T>[] deferredArr) {
        this.f51209a = deferredArr;
        this.notCompletedCount = deferredArr.length;
    }

    public final Object b(Continuation<? super List<? extends T>> continuation) {
        Continuation c8;
        Object d8;
        c8 = IntrinsicsKt__IntrinsicsJvmKt.c(continuation);
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(c8, 1);
        cancellableContinuationImpl.y();
        int length = this.f51209a.length;
        AwaitAllNode[] awaitAllNodeArr = new AwaitAllNode[length];
        for (int i8 = 0; i8 < length; i8++) {
            Deferred deferred = this.f51209a[i8];
            deferred.start();
            AwaitAllNode awaitAllNode = new AwaitAllNode(cancellableContinuationImpl);
            awaitAllNode.b0(deferred.X(awaitAllNode));
            Unit unit = Unit.f50853a;
            awaitAllNodeArr[i8] = awaitAllNode;
        }
        AwaitAll<T>.DisposeHandlersOnCancel disposeHandlersOnCancel = new DisposeHandlersOnCancel(awaitAllNodeArr);
        for (int i9 = 0; i9 < length; i9++) {
            awaitAllNodeArr[i9].a0(disposeHandlersOnCancel);
        }
        if (cancellableContinuationImpl.c()) {
            disposeHandlersOnCancel.c();
        } else {
            cancellableContinuationImpl.o(disposeHandlersOnCancel);
        }
        Object v7 = cancellableContinuationImpl.v();
        d8 = IntrinsicsKt__IntrinsicsKt.d();
        if (v7 == d8) {
            DebugProbesKt.c(continuation);
        }
        return v7;
    }
}
