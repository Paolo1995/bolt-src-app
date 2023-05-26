package eu.bolt.verification.sdk.internal;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes5.dex */
public final class sg extends Lambda implements Function1<Object, Object> {

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ Function1<Object, Object> f44978f;

    /* renamed from: g  reason: collision with root package name */
    final /* synthetic */ Function0<Unit> f44979g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public sg(Function1<Object, Object> function1, Function0<Unit> function0) {
        super(1);
        this.f44978f = function1;
        this.f44979g = function0;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        Object invoke = this.f44978f.invoke(obj);
        this.f44979g.invoke();
        return invoke;
    }
}
