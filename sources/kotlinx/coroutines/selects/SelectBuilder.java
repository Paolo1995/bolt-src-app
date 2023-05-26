package kotlinx.coroutines.selects;

import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* compiled from: Select.kt */
/* loaded from: classes5.dex */
public interface SelectBuilder<R> {
    void h(long j8, Function1<? super Continuation<? super R>, ? extends Object> function1);

    <Q> void x(SelectClause1<? extends Q> selectClause1, Function2<? super Q, ? super Continuation<? super R>, ? extends Object> function2);
}
