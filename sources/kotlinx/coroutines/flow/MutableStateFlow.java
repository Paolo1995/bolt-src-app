package kotlinx.coroutines.flow;

/* compiled from: StateFlow.kt */
/* loaded from: classes5.dex */
public interface MutableStateFlow<T> extends StateFlow<T>, MutableSharedFlow<T> {
    boolean g(T t7, T t8);

    @Override // kotlinx.coroutines.flow.StateFlow
    T getValue();

    void setValue(T t7);
}
