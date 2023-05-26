package eu.bolt.verification.sdk.internal;

import androidx.recyclerview.widget.RecyclerView;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class nf {
    public static final void a(RecyclerView recyclerView, boolean z7) {
        Intrinsics.f(recyclerView, "<this>");
        if (z7) {
            recyclerView.x1(0);
        } else {
            recyclerView.p1(0);
        }
    }

    public static final boolean b(RecyclerView recyclerView) {
        Intrinsics.f(recyclerView, "<this>");
        return recyclerView.computeHorizontalScrollRange() > recyclerView.getWidth() || recyclerView.computeVerticalScrollRange() > recyclerView.getHeight();
    }
}
