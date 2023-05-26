package j$.util;

import java.util.Collection;
import java.util.SortedSet;

/* loaded from: classes2.dex */
final class A extends a0 {

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ SortedSet f50134f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public A(SortedSet sortedSet, Collection collection) {
        super(21, collection);
        this.f50134f = sortedSet;
    }

    @Override // j$.util.a0, j$.util.Spliterator
    public final java.util.Comparator getComparator() {
        return this.f50134f.comparator();
    }
}
