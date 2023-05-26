package kotlin.reflect;

import kotlin.jvm.functions.Function1;

/* compiled from: KProperty.kt */
/* loaded from: classes5.dex */
public interface KProperty1<T, V> extends KProperty<V>, Function1<T, V> {

    /* compiled from: KProperty.kt */
    /* loaded from: classes5.dex */
    public interface Getter<T, V> extends KFunction, Function1<T, V> {
    }

    Getter<T, V> a();

    V get(T t7);
}
