package eu.bolt.verification.sdk.internal;

import android.view.View;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.WindowInsetsCompat;
import eu.bolt.verification.R$id;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public class i7 implements OnApplyWindowInsetsListener {
    @Override // androidx.core.view.OnApplyWindowInsetsListener
    public WindowInsetsCompat a(View v7, WindowInsetsCompat insets) {
        Intrinsics.f(v7, "v");
        Intrinsics.f(insets, "insets");
        Object tag = v7.getTag(R$id.key_insets);
        WindowInsetsCompat windowInsetsCompat = tag instanceof WindowInsetsCompat ? (WindowInsetsCompat) tag : null;
        if (windowInsetsCompat != null) {
            insets = windowInsetsCompat;
        }
        v7.setPadding(insets.j(), insets.l(), insets.k(), insets.i());
        return insets;
    }
}
