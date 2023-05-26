package org.koin.core.definition;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Callbacks.kt */
/* loaded from: classes5.dex */
public final class Callbacks<T> {

    /* renamed from: a  reason: collision with root package name */
    private final Function1<T, Unit> f52746a;

    public Callbacks() {
        this(null, 1, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Callbacks(Function1<? super T, Unit> function1) {
        this.f52746a = function1;
    }

    public final Function1<T, Unit> a() {
        return this.f52746a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof Callbacks) && Intrinsics.a(this.f52746a, ((Callbacks) obj).f52746a);
    }

    public int hashCode() {
        Function1<T, Unit> function1 = this.f52746a;
        if (function1 == null) {
            return 0;
        }
        return function1.hashCode();
    }

    public String toString() {
        return "Callbacks(onClose=" + this.f52746a + ')';
    }

    public /* synthetic */ Callbacks(Function1 function1, int i8, DefaultConstructorMarker defaultConstructorMarker) {
        this((i8 & 1) != 0 ? null : function1);
    }
}
