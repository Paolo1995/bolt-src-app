package kotlin.sequences;

import java.util.Iterator;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: Iterables.kt */
/* loaded from: classes5.dex */
public final class SequencesKt___SequencesKt$asIterable$$inlined$Iterable$1<T> implements Iterable<T>, KMappedMarker {

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ Sequence f51125f;

    public SequencesKt___SequencesKt$asIterable$$inlined$Iterable$1(Sequence sequence) {
        this.f51125f = sequence;
    }

    @Override // java.lang.Iterable
    public Iterator<T> iterator() {
        return this.f51125f.iterator();
    }
}
