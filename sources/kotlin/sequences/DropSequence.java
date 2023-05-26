package kotlin.sequences;

import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Sequences.kt */
/* loaded from: classes5.dex */
public final class DropSequence<T> implements Sequence<T>, DropTakeSequence<T> {

    /* renamed from: a  reason: collision with root package name */
    private final Sequence<T> f51093a;

    /* renamed from: b  reason: collision with root package name */
    private final int f51094b;

    /* JADX WARN: Multi-variable type inference failed */
    public DropSequence(Sequence<? extends T> sequence, int i8) {
        boolean z7;
        Intrinsics.f(sequence, "sequence");
        this.f51093a = sequence;
        this.f51094b = i8;
        if (i8 >= 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7) {
            return;
        }
        throw new IllegalArgumentException(("count must be non-negative, but was " + i8 + '.').toString());
    }

    @Override // kotlin.sequences.DropTakeSequence
    public Sequence<T> a(int i8) {
        int i9 = this.f51094b + i8;
        if (i9 < 0) {
            return new DropSequence(this, i8);
        }
        return new DropSequence(this.f51093a, i9);
    }

    @Override // kotlin.sequences.Sequence
    public Iterator<T> iterator() {
        return new DropSequence$iterator$1(this);
    }
}
