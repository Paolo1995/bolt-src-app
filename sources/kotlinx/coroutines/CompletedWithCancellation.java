package kotlinx.coroutines;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CompletionState.kt */
/* loaded from: classes5.dex */
public final class CompletedWithCancellation {

    /* renamed from: a  reason: collision with root package name */
    public final Object f51235a;

    /* renamed from: b  reason: collision with root package name */
    public final Function1<Throwable, Unit> f51236b;

    /* JADX WARN: Multi-variable type inference failed */
    public CompletedWithCancellation(Object obj, Function1<? super Throwable, Unit> function1) {
        this.f51235a = obj;
        this.f51236b = function1;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CompletedWithCancellation) {
            CompletedWithCancellation completedWithCancellation = (CompletedWithCancellation) obj;
            return Intrinsics.a(this.f51235a, completedWithCancellation.f51235a) && Intrinsics.a(this.f51236b, completedWithCancellation.f51236b);
        }
        return false;
    }

    public int hashCode() {
        Object obj = this.f51235a;
        return ((obj == null ? 0 : obj.hashCode()) * 31) + this.f51236b.hashCode();
    }

    public String toString() {
        return "CompletedWithCancellation(result=" + this.f51235a + ", onCancellation=" + this.f51236b + ')';
    }
}
