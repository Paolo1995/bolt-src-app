package androidx.work;

import android.content.Context;
import androidx.annotation.NonNull;

/* loaded from: classes.dex */
public abstract class WorkerFactory {

    /* renamed from: a  reason: collision with root package name */
    private static final String f8330a = Logger.f("WorkerFactory");

    @NonNull
    public static WorkerFactory c() {
        return new WorkerFactory() { // from class: androidx.work.WorkerFactory.1
            @Override // androidx.work.WorkerFactory
            public ListenableWorker a(@NonNull Context context, @NonNull String str, @NonNull WorkerParameters workerParameters) {
                return null;
            }
        };
    }

    public abstract ListenableWorker a(@NonNull Context context, @NonNull String str, @NonNull WorkerParameters workerParameters);

    public final ListenableWorker b(@NonNull Context context, @NonNull String str, @NonNull WorkerParameters workerParameters) {
        ListenableWorker a8 = a(context, str, workerParameters);
        if (a8 == null) {
            Class cls = null;
            try {
                cls = Class.forName(str).asSubclass(ListenableWorker.class);
            } catch (Throwable th) {
                Logger c8 = Logger.c();
                String str2 = f8330a;
                c8.b(str2, "Invalid class: " + str, th);
            }
            if (cls != null) {
                try {
                    a8 = (ListenableWorker) cls.getDeclaredConstructor(Context.class, WorkerParameters.class).newInstance(context, workerParameters);
                } catch (Throwable th2) {
                    Logger c9 = Logger.c();
                    String str3 = f8330a;
                    c9.b(str3, "Could not instantiate " + str, th2);
                }
            }
        }
        if (a8 != null && a8.l()) {
            throw new IllegalStateException(String.format("WorkerFactory (%s) returned an instance of a ListenableWorker (%s) which has already been invoked. createWorker() must always return a new instance of a ListenableWorker.", getClass().getName(), str));
        }
        return a8;
    }
}
