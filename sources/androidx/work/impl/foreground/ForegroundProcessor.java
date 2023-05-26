package androidx.work.impl.foreground;

import androidx.annotation.NonNull;
import androidx.work.ForegroundInfo;

/* loaded from: classes.dex */
public interface ForegroundProcessor {
    void a(@NonNull String str);

    void b(@NonNull String str, @NonNull ForegroundInfo foregroundInfo);
}
