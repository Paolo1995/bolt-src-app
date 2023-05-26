package kotlin.text;

import java.util.Iterator;
import kotlin.Pair;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.sequences.Sequence;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Strings.kt */
/* loaded from: classes5.dex */
public final class DelimitedRangesSequence implements Sequence<IntRange> {

    /* renamed from: a  reason: collision with root package name */
    private final CharSequence f51143a;

    /* renamed from: b  reason: collision with root package name */
    private final int f51144b;

    /* renamed from: c  reason: collision with root package name */
    private final int f51145c;

    /* renamed from: d  reason: collision with root package name */
    private final Function2<CharSequence, Integer, Pair<Integer, Integer>> f51146d;

    /* JADX WARN: Multi-variable type inference failed */
    public DelimitedRangesSequence(CharSequence input, int i8, int i9, Function2<? super CharSequence, ? super Integer, Pair<Integer, Integer>> getNextMatch) {
        Intrinsics.f(input, "input");
        Intrinsics.f(getNextMatch, "getNextMatch");
        this.f51143a = input;
        this.f51144b = i8;
        this.f51145c = i9;
        this.f51146d = getNextMatch;
    }

    @Override // kotlin.sequences.Sequence
    public Iterator<IntRange> iterator() {
        return new DelimitedRangesSequence$iterator$1(this);
    }
}
