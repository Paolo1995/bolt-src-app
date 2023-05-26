package eu.bolt.verification.sdk.internal;

import android.view.View;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class mr implements lr {

    /* renamed from: a  reason: collision with root package name */
    private final jc f44224a;

    @Inject
    public mr(jc navigationBarController) {
        Intrinsics.f(navigationBarController, "navigationBarController");
        this.f44224a = navigationBarController;
    }

    private final OnApplyWindowInsetsListener c(final boolean z7, final boolean z8) {
        return new OnApplyWindowInsetsListener() { // from class: eu.bolt.verification.sdk.internal.uu
            @Override // androidx.core.view.OnApplyWindowInsetsListener
            public final WindowInsetsCompat a(View view, WindowInsetsCompat windowInsetsCompat) {
                WindowInsetsCompat d8;
                d8 = mr.d(z8, z7, this, view, windowInsetsCompat);
                return d8;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WindowInsetsCompat d(boolean z7, boolean z8, mr this$0, View v7, WindowInsetsCompat insets) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(v7, "v");
        Intrinsics.f(insets, "insets");
        v7.setPadding(insets.j(), z7 ? insets.l() : 0, insets.k(), z8 ? this$0.f44224a.c() : 0);
        return insets;
    }

    @Override // eu.bolt.verification.sdk.internal.lr
    public void a(View view, boolean z7, boolean z8) {
        Intrinsics.f(view, "view");
        ViewCompat.G0(view, this.f44224a.g() ? c(z7, z8) : new i7());
    }
}
