package androidx.work.impl;

import androidx.annotation.NonNull;
import androidx.work.impl.model.WorkSpec;

/* loaded from: classes.dex */
public interface Scheduler {
    void a(@NonNull WorkSpec... workSpecArr);

    boolean c();

    void cancel(@NonNull String str);
}
