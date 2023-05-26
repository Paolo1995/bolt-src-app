package kotlin.sequences;

import java.util.Iterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Sequences.kt */
/* loaded from: classes5.dex */
final class GeneratorSequence<T> implements Sequence<T> {

    /* renamed from: a  reason: collision with root package name */
    private final Function0<T> f51111a;

    /* renamed from: b  reason: collision with root package name */
    private final Function1<T, T> f51112b;

    /* JADX WARN: Multi-variable type inference failed */
    public GeneratorSequence(Function0<? extends T> getInitialValue, Function1<? super T, ? extends T> getNextValue) {
        Intrinsics.f(getInitialValue, "getInitialValue");
        Intrinsics.f(getNextValue, "getNextValue");
        this.f51111a = getInitialValue;
        this.f51112b = getNextValue;
    }

    @Override // kotlin.sequences.Sequence
    public Iterator<T> iterator() {
        return new GeneratorSequence$iterator$1(this);
    }
}
