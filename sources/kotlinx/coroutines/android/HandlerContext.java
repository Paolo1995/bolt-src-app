package kotlinx.coroutines.android;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.CancellationException;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.NonDisposableHandle;
import kotlinx.coroutines.android.HandlerContext;

/* compiled from: HandlerDispatcher.kt */
/* loaded from: classes5.dex */
public final class HandlerContext extends HandlerDispatcher {
    private volatile HandlerContext _immediate;

    /* renamed from: h  reason: collision with root package name */
    private final Handler f51353h;

    /* renamed from: i  reason: collision with root package name */
    private final String f51354i;

    /* renamed from: j  reason: collision with root package name */
    private final boolean f51355j;

    /* renamed from: k  reason: collision with root package name */
    private final HandlerContext f51356k;

    private HandlerContext(Handler handler, String str, boolean z7) {
        super(null);
        this.f51353h = handler;
        this.f51354i = str;
        this.f51355j = z7;
        this._immediate = z7 ? this : null;
        HandlerContext handlerContext = this._immediate;
        if (handlerContext == null) {
            handlerContext = new HandlerContext(handler, str, true);
            this._immediate = handlerContext;
        }
        this.f51356k = handlerContext;
    }

    private final void Z0(CoroutineContext coroutineContext, Runnable runnable) {
        JobKt.c(coroutineContext, new CancellationException("The task was rejected, the handler underlying the dispatcher '" + this + "' was closed"));
        Dispatchers.b().G0(coroutineContext, runnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c1(HandlerContext handlerContext, Runnable runnable) {
        handlerContext.f51353h.removeCallbacks(runnable);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void G0(CoroutineContext coroutineContext, Runnable runnable) {
        if (!this.f51353h.post(runnable)) {
            Z0(coroutineContext, runnable);
        }
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public boolean K0(CoroutineContext coroutineContext) {
        if (this.f51355j && Intrinsics.a(Looper.myLooper(), this.f51353h.getLooper())) {
            return false;
        }
        return true;
    }

    @Override // kotlinx.coroutines.android.HandlerDispatcher, kotlinx.coroutines.Delay
    public DisposableHandle Y(long j8, final Runnable runnable, CoroutineContext coroutineContext) {
        long h8;
        Handler handler = this.f51353h;
        h8 = RangesKt___RangesKt.h(j8, 4611686018427387903L);
        if (handler.postDelayed(runnable, h8)) {
            return new DisposableHandle() { // from class: n7.a
                @Override // kotlinx.coroutines.DisposableHandle
                public final void dispose() {
                    HandlerContext.c1(HandlerContext.this, runnable);
                }
            };
        }
        Z0(coroutineContext, runnable);
        return NonDisposableHandle.f51324f;
    }

    @Override // kotlinx.coroutines.MainCoroutineDispatcher
    /* renamed from: b1 */
    public HandlerContext R0() {
        return this.f51356k;
    }

    public boolean equals(Object obj) {
        if ((obj instanceof HandlerContext) && ((HandlerContext) obj).f51353h == this.f51353h) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return System.identityHashCode(this.f51353h);
    }

    @Override // kotlinx.coroutines.Delay
    public void j(long j8, final CancellableContinuation<? super Unit> cancellableContinuation) {
        long h8;
        final Runnable runnable = new Runnable() { // from class: kotlinx.coroutines.android.HandlerContext$scheduleResumeAfterDelay$$inlined$Runnable$1
            @Override // java.lang.Runnable
            public final void run() {
                CancellableContinuation.this.C(this, Unit.f50853a);
            }
        };
        Handler handler = this.f51353h;
        h8 = RangesKt___RangesKt.h(j8, 4611686018427387903L);
        if (handler.postDelayed(runnable, h8)) {
            cancellableContinuation.o(new Function1<Throwable, Unit>() { // from class: kotlinx.coroutines.android.HandlerContext$scheduleResumeAfterDelay$1
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
                    Handler handler2;
                    handler2 = HandlerContext.this.f51353h;
                    handler2.removeCallbacks(runnable);
                }
            });
        } else {
            Z0(cancellableContinuation.getContext(), runnable);
        }
    }

    @Override // kotlinx.coroutines.MainCoroutineDispatcher, kotlinx.coroutines.CoroutineDispatcher
    public String toString() {
        String S0 = S0();
        if (S0 == null) {
            String str = this.f51354i;
            if (str == null) {
                str = this.f51353h.toString();
            }
            if (this.f51355j) {
                return str + ".immediate";
            }
            return str;
        }
        return S0;
    }

    public /* synthetic */ HandlerContext(Handler handler, String str, int i8, DefaultConstructorMarker defaultConstructorMarker) {
        this(handler, (i8 & 2) != 0 ? null : str);
    }

    public HandlerContext(Handler handler, String str) {
        this(handler, str, false);
    }
}
