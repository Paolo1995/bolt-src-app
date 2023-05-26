package androidx.work;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.startup.Initializer;
import androidx.work.Configuration;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public final class WorkManagerInitializer implements Initializer<WorkManager> {

    /* renamed from: a  reason: collision with root package name */
    private static final String f8319a = Logger.f("WrkMgrInitializer");

    @Override // androidx.startup.Initializer
    @NonNull
    /* renamed from: b */
    public WorkManager a(@NonNull Context context) {
        Logger.c().a(f8319a, "Initializing WorkManager with default configuration.", new Throwable[0]);
        WorkManager.e(context, new Configuration.Builder().a());
        return WorkManager.d(context);
    }

    @Override // androidx.startup.Initializer
    @NonNull
    public List<Class<? extends Initializer<?>>> dependencies() {
        return Collections.emptyList();
    }
}
