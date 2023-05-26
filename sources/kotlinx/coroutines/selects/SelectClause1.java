package kotlinx.coroutines.selects;

import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;

/* compiled from: Select.kt */
/* loaded from: classes5.dex */
public interface SelectClause1<Q> {
    <R> void n(SelectInstance<? super R> selectInstance, Function2<? super Q, ? super Continuation<? super R>, ? extends Object> function2);
}
