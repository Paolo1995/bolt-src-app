package eu.bolt.verification.sdk.internal;

import android.view.View;

/* loaded from: classes5.dex */
public interface lr {

    /* loaded from: classes5.dex */
    public static final class a {
        public static /* synthetic */ void a(lr lrVar, View view, boolean z7, boolean z8, int i8, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: configureWindowsInsets");
            }
            if ((i8 & 2) != 0) {
                z7 = true;
            }
            if ((i8 & 4) != 0) {
                z8 = true;
            }
            lrVar.a(view, z7, z8);
        }
    }

    void a(View view, boolean z7, boolean z8);
}
