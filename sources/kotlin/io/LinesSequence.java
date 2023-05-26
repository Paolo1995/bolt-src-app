package kotlin.io;

import java.io.BufferedReader;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;

/* compiled from: ReadWrite.kt */
/* loaded from: classes5.dex */
final class LinesSequence implements Sequence<String> {

    /* renamed from: a  reason: collision with root package name */
    private final BufferedReader f50971a;

    public LinesSequence(BufferedReader reader) {
        Intrinsics.f(reader, "reader");
        this.f50971a = reader;
    }

    @Override // kotlin.sequences.Sequence
    public Iterator<String> iterator() {
        return new LinesSequence$iterator$1(this);
    }
}
