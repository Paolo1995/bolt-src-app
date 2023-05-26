package kotlin.sequences;

import java.util.Iterator;
import kotlin.collections.EmptyIterator;

/* compiled from: Sequences.kt */
/* loaded from: classes5.dex */
final class EmptySequence implements Sequence, DropTakeSequence {

    /* renamed from: a  reason: collision with root package name */
    public static final EmptySequence f51097a = new EmptySequence();

    private EmptySequence() {
    }

    @Override // kotlin.sequences.DropTakeSequence
    /* renamed from: b */
    public EmptySequence a(int i8) {
        return f51097a;
    }

    @Override // kotlin.sequences.Sequence
    public Iterator iterator() {
        return EmptyIterator.f50878f;
    }
}
