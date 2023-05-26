package eu.bolt.driver.core.ui.routing.internal;

import java.util.Comparator;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ReverseIntegerComparator.kt */
/* loaded from: classes5.dex */
public final class ReverseIntegerComparator implements Comparator<Integer> {
    public int a(int i8, int i9) {
        return Intrinsics.h(i8, i9) * (-1);
    }

    @Override // java.util.Comparator
    public /* bridge */ /* synthetic */ int compare(Integer num, Integer num2) {
        return a(num.intValue(), num2.intValue());
    }
}
