package androidx.room;

import android.os.CancellationSignal;
import androidx.sqlite.db.SupportSQLiteCompat$Api16Impl;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;

/* compiled from: CoroutinesRoom.kt */
/* loaded from: classes.dex */
public final class CoroutinesRoom {

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f7435a = new Companion(null);

    /* compiled from: CoroutinesRoom.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final <R> Object a(RoomDatabase roomDatabase, boolean z7, final CancellationSignal cancellationSignal, Callable<R> callable, Continuation<? super R> continuation) {
            CoroutineDispatcher a8;
            ContinuationInterceptor continuationInterceptor;
            Continuation c8;
            final Job d8;
            Object d9;
            if (roomDatabase.y() && roomDatabase.s()) {
                return callable.call();
            }
            TransactionElement transactionElement = (TransactionElement) continuation.getContext().g(TransactionElement.f7629g);
            if (transactionElement == null || (continuationInterceptor = transactionElement.b()) == null) {
                if (z7) {
                    a8 = CoroutinesRoomKt.b(roomDatabase);
                } else {
                    a8 = CoroutinesRoomKt.a(roomDatabase);
                }
                continuationInterceptor = a8;
            }
            ContinuationInterceptor continuationInterceptor2 = continuationInterceptor;
            c8 = IntrinsicsKt__IntrinsicsJvmKt.c(continuation);
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(c8, 1);
            cancellableContinuationImpl.y();
            d8 = BuildersKt__Builders_commonKt.d(GlobalScope.f51286f, continuationInterceptor2, null, new CoroutinesRoom$Companion$execute$4$job$1(callable, cancellableContinuationImpl, null), 2, null);
            cancellableContinuationImpl.o(new Function1<Throwable, Unit>() { // from class: androidx.room.CoroutinesRoom$Companion$execute$4$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                    invoke2(th);
                    return Unit.f50853a;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(Throwable th) {
                    SupportSQLiteCompat$Api16Impl.a(cancellationSignal);
                    Job.DefaultImpls.a(d8, null, 1, null);
                }
            });
            Object v7 = cancellableContinuationImpl.v();
            d9 = IntrinsicsKt__IntrinsicsKt.d();
            if (v7 == d9) {
                DebugProbesKt.c(continuation);
            }
            return v7;
        }

        public final <R> Object b(RoomDatabase roomDatabase, boolean z7, Callable<R> callable, Continuation<? super R> continuation) {
            CoroutineDispatcher a8;
            ContinuationInterceptor continuationInterceptor;
            if (roomDatabase.y() && roomDatabase.s()) {
                return callable.call();
            }
            TransactionElement transactionElement = (TransactionElement) continuation.getContext().g(TransactionElement.f7629g);
            if (transactionElement == null || (continuationInterceptor = transactionElement.b()) == null) {
                if (z7) {
                    a8 = CoroutinesRoomKt.b(roomDatabase);
                } else {
                    a8 = CoroutinesRoomKt.a(roomDatabase);
                }
                continuationInterceptor = a8;
            }
            return BuildersKt.g(continuationInterceptor, new CoroutinesRoom$Companion$execute$2(callable, null), continuation);
        }
    }

    private CoroutinesRoom() {
    }

    public static final <R> Object a(RoomDatabase roomDatabase, boolean z7, CancellationSignal cancellationSignal, Callable<R> callable, Continuation<? super R> continuation) {
        return f7435a.a(roomDatabase, z7, cancellationSignal, callable, continuation);
    }

    public static final <R> Object b(RoomDatabase roomDatabase, boolean z7, Callable<R> callable, Continuation<? super R> continuation) {
        return f7435a.b(roomDatabase, z7, callable, continuation);
    }
}
