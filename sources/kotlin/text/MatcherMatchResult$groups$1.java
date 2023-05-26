package kotlin.text;

import java.util.Iterator;
import kotlin.collections.AbstractCollection;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt___SequencesKt;

/* compiled from: Regex.kt */
/* loaded from: classes5.dex */
public final class MatcherMatchResult$groups$1 extends AbstractCollection<MatchGroup> implements MatchGroupCollection {

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ MatcherMatchResult f51158f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public MatcherMatchResult$groups$1(MatcherMatchResult matcherMatchResult) {
        this.f51158f = matcherMatchResult;
    }

    @Override // kotlin.collections.AbstractCollection
    public int b() {
        java.util.regex.MatchResult c8;
        c8 = this.f51158f.c();
        return c8.groupCount() + 1;
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        boolean z7;
        if (obj == null) {
            z7 = true;
        } else {
            z7 = obj instanceof MatchGroup;
        }
        if (!z7) {
            return false;
        }
        return d((MatchGroup) obj);
    }

    public /* bridge */ boolean d(MatchGroup matchGroup) {
        return super.contains(matchGroup);
    }

    @Override // kotlin.text.MatchGroupCollection
    public MatchGroup get(int i8) {
        java.util.regex.MatchResult c8;
        IntRange f8;
        java.util.regex.MatchResult c9;
        c8 = this.f51158f.c();
        f8 = RegexKt.f(c8, i8);
        if (f8.r().intValue() >= 0) {
            c9 = this.f51158f.c();
            String group = c9.group(i8);
            Intrinsics.e(group, "matchResult.group(index)");
            return new MatchGroup(group, f8);
        }
        return null;
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return false;
    }

    @Override // java.util.Collection, java.lang.Iterable
    public Iterator<MatchGroup> iterator() {
        IntRange l8;
        Sequence O;
        Sequence v7;
        l8 = CollectionsKt__CollectionsKt.l(this);
        O = CollectionsKt___CollectionsKt.O(l8);
        v7 = SequencesKt___SequencesKt.v(O, new Function1<Integer, MatchGroup>() { // from class: kotlin.text.MatcherMatchResult$groups$1$iterator$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final MatchGroup b(int i8) {
                return MatcherMatchResult$groups$1.this.get(i8);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ MatchGroup invoke(Integer num) {
                return b(num.intValue());
            }
        });
        return v7.iterator();
    }
}
