package kotlinx.coroutines;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CancellableContinuationImpl.kt */
/* loaded from: classes5.dex */
final class CompletedContinuation {

    /* renamed from: a  reason: collision with root package name */
    public final Object f51228a;

    /* renamed from: b  reason: collision with root package name */
    public final CancelHandler f51229b;

    /* renamed from: c  reason: collision with root package name */
    public final Function1<Throwable, Unit> f51230c;

    /* renamed from: d  reason: collision with root package name */
    public final Object f51231d;

    /* renamed from: e  reason: collision with root package name */
    public final Throwable f51232e;

    /* JADX WARN: Multi-variable type inference failed */
    public CompletedContinuation(Object obj, CancelHandler cancelHandler, Function1<? super Throwable, Unit> function1, Object obj2, Throwable th) {
        this.f51228a = obj;
        this.f51229b = cancelHandler;
        this.f51230c = function1;
        this.f51231d = obj2;
        this.f51232e = th;
    }

    public static /* synthetic */ CompletedContinuation b(CompletedContinuation completedContinuation, Object obj, CancelHandler cancelHandler, Function1 function1, Object obj2, Throwable th, int i8, Object obj3) {
        if ((i8 & 1) != 0) {
            obj = completedContinuation.f51228a;
        }
        if ((i8 & 2) != 0) {
            cancelHandler = completedContinuation.f51229b;
        }
        CancelHandler cancelHandler2 = cancelHandler;
        Function1<Throwable, Unit> function12 = function1;
        if ((i8 & 4) != 0) {
            function12 = completedContinuation.f51230c;
        }
        Function1 function13 = function12;
        if ((i8 & 8) != 0) {
            obj2 = completedContinuation.f51231d;
        }
        Object obj4 = obj2;
        if ((i8 & 16) != 0) {
            th = completedContinuation.f51232e;
        }
        return completedContinuation.a(obj, cancelHandler2, function13, obj4, th);
    }

    public final CompletedContinuation a(Object obj, CancelHandler cancelHandler, Function1<? super Throwable, Unit> function1, Object obj2, Throwable th) {
        return new CompletedContinuation(obj, cancelHandler, function1, obj2, th);
    }

    public final boolean c() {
        if (this.f51232e != null) {
            return true;
        }
        return false;
    }

    public final void d(CancellableContinuationImpl<?> cancellableContinuationImpl, Throwable th) {
        CancelHandler cancelHandler = this.f51229b;
        if (cancelHandler != null) {
            cancellableContinuationImpl.k(cancelHandler, th);
        }
        Function1<Throwable, Unit> function1 = this.f51230c;
        if (function1 != null) {
            cancellableContinuationImpl.l(function1, th);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CompletedContinuation) {
            CompletedContinuation completedContinuation = (CompletedContinuation) obj;
            return Intrinsics.a(this.f51228a, completedContinuation.f51228a) && Intrinsics.a(this.f51229b, completedContinuation.f51229b) && Intrinsics.a(this.f51230c, completedContinuation.f51230c) && Intrinsics.a(this.f51231d, completedContinuation.f51231d) && Intrinsics.a(this.f51232e, completedContinuation.f51232e);
        }
        return false;
    }

    public int hashCode() {
        Object obj = this.f51228a;
        int hashCode = (obj == null ? 0 : obj.hashCode()) * 31;
        CancelHandler cancelHandler = this.f51229b;
        int hashCode2 = (hashCode + (cancelHandler == null ? 0 : cancelHandler.hashCode())) * 31;
        Function1<Throwable, Unit> function1 = this.f51230c;
        int hashCode3 = (hashCode2 + (function1 == null ? 0 : function1.hashCode())) * 31;
        Object obj2 = this.f51231d;
        int hashCode4 = (hashCode3 + (obj2 == null ? 0 : obj2.hashCode())) * 31;
        Throwable th = this.f51232e;
        return hashCode4 + (th != null ? th.hashCode() : 0);
    }

    public String toString() {
        return "CompletedContinuation(result=" + this.f51228a + ", cancelHandler=" + this.f51229b + ", onCancellation=" + this.f51230c + ", idempotentResume=" + this.f51231d + ", cancelCause=" + this.f51232e + ')';
    }

    public /* synthetic */ CompletedContinuation(Object obj, CancelHandler cancelHandler, Function1 function1, Object obj2, Throwable th, int i8, DefaultConstructorMarker defaultConstructorMarker) {
        this(obj, (i8 & 2) != 0 ? null : cancelHandler, (i8 & 4) != 0 ? null : function1, (i8 & 8) != 0 ? null : obj2, (i8 & 16) != 0 ? null : th);
    }
}
