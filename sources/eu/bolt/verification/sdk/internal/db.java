package eu.bolt.verification.sdk.internal;

import android.view.View;

/* loaded from: classes5.dex */
public interface db {

    /* loaded from: classes5.dex */
    public static final class a {
        public static /* synthetic */ void a(db dbVar, View view, boolean z7, int i8, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: hideKeyboard");
            }
            if ((i8 & 1) != 0) {
                view = null;
            }
            if ((i8 & 2) != 0) {
                z7 = true;
            }
            dbVar.a(view, z7);
        }
    }

    void a(View view, boolean z7);
}
