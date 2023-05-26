package eu.bolt.verification.sdk.internal;

import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.WindowInsetsCompat;
import java.lang.ref.WeakReference;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt___SequencesKt;

/* loaded from: classes5.dex */
public final class v5 implements OnApplyWindowInsetsListener {

    /* renamed from: a  reason: collision with root package name */
    private WindowInsetsCompat f45430a;

    /* renamed from: b  reason: collision with root package name */
    private List<? extends WeakReference<View>> f45431b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class a extends Lambda implements Function1<View, WeakReference<View>> {

        /* renamed from: f  reason: collision with root package name */
        public static final a f45432f = new a();

        a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: b */
        public final WeakReference<View> invoke(View it) {
            Intrinsics.f(it, "it");
            return new WeakReference<>(it);
        }
    }

    public v5() {
        List<? extends WeakReference<View>> k8;
        k8 = CollectionsKt__CollectionsKt.k();
        this.f45431b = k8;
    }

    private final List<WeakReference<View>> b(ViewGroup viewGroup) {
        Sequence v7;
        List<WeakReference<View>> D;
        v7 = SequencesKt___SequencesKt.v(uq.t(viewGroup), a.f45432f);
        D = SequencesKt___SequencesKt.D(v7);
        return D;
    }

    @Override // androidx.core.view.OnApplyWindowInsetsListener
    public WindowInsetsCompat a(View v7, WindowInsetsCompat insets) {
        Intrinsics.f(v7, "v");
        Intrinsics.f(insets, "insets");
        ViewGroup viewGroup = v7 instanceof ViewGroup ? (ViewGroup) v7 : null;
        if (viewGroup == null) {
            t3.c("DispatchingWindowInsetsListener can only be applied to a ViewGroup but has been applied to " + v7, null, 2, null);
            return insets;
        }
        List<WeakReference<View>> b8 = b(viewGroup);
        if (Intrinsics.a(this.f45430a, insets) && Intrinsics.a(this.f45431b, b8)) {
            return insets;
        }
        this.f45431b = b8;
        this.f45430a = insets;
        uq.F(viewGroup, insets);
        return insets;
    }
}
