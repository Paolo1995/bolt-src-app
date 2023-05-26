package com.google.android.play.core.integrity;

import android.content.Context;
import androidx.annotation.NonNull;

/* compiled from: com.google.android.play:integrity@@1.1.0 */
/* loaded from: classes.dex */
public class IntegrityManagerFactory {
    private IntegrityManagerFactory() {
    }

    @NonNull
    public static IntegrityManager a(Context context) {
        return l.a(context).a();
    }
}
