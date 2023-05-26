package androidx.work;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.work.impl.WorkManagerImpl;
import java.util.Collections;
import java.util.List;

@SuppressLint({"AddedAbstractMethod"})
/* loaded from: classes.dex */
public abstract class WorkManager {
    @NonNull
    public static WorkManager d(@NonNull Context context) {
        return WorkManagerImpl.k(context);
    }

    public static void e(@NonNull Context context, @NonNull Configuration configuration) {
        WorkManagerImpl.e(context, configuration);
    }

    @NonNull
    public abstract Operation a(@NonNull String str);

    @NonNull
    public final Operation b(@NonNull WorkRequest workRequest) {
        return c(Collections.singletonList(workRequest));
    }

    @NonNull
    public abstract Operation c(@NonNull List<? extends WorkRequest> list);
}
