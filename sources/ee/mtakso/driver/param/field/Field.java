package ee.mtakso.driver.param.field;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Field.kt */
/* loaded from: classes3.dex */
public final class Field<T> {

    /* renamed from: a  reason: collision with root package name */
    private final Function0<T> f23257a;

    /* JADX WARN: Multi-variable type inference failed */
    public Field(Function0<? extends T> compute) {
        Intrinsics.f(compute, "compute");
        this.f23257a = compute;
    }

    public final T a() {
        return this.f23257a.invoke();
    }
}
