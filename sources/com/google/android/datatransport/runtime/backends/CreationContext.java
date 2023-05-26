package com.google.android.datatransport.runtime.backends;

import android.content.Context;
import androidx.annotation.NonNull;
import com.google.android.datatransport.runtime.time.Clock;

/* loaded from: classes.dex */
public abstract class CreationContext {
    public static CreationContext a(Context context, Clock clock, Clock clock2, String str) {
        return new AutoValue_CreationContext(context, clock, clock2, str);
    }

    public abstract Context b();

    @NonNull
    public abstract String c();

    public abstract Clock d();

    public abstract Clock e();
}
