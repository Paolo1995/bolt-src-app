package kotlin.sequences;

import java.util.Iterator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Add missing generic type declarations: [R] */
/* compiled from: _Sequences.kt */
/* loaded from: classes5.dex */
/* synthetic */ class SequencesKt___SequencesKt$flatMap$1<R> extends FunctionReferenceImpl implements Function1<Iterable<? extends R>, Iterator<? extends R>> {

    /* renamed from: o  reason: collision with root package name */
    public static final SequencesKt___SequencesKt$flatMap$1 f51127o = new SequencesKt___SequencesKt$flatMap$1();

    SequencesKt___SequencesKt$flatMap$1() {
        super(1, Iterable.class, "iterator", "iterator()Ljava/util/Iterator;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    /* renamed from: j */
    public final Iterator<R> invoke(Iterable<? extends R> p02) {
        Intrinsics.f(p02, "p0");
        return (Iterator<? extends R>) p02.iterator();
    }
}
