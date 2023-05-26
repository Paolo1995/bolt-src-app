package ee.mtakso.driver.work;

import android.content.Context;
import androidx.work.ListenableWorker;
import androidx.work.WorkerFactory;
import androidx.work.WorkerParameters;
import ee.mtakso.driver.utils.AssertUtils;
import java.util.Iterator;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WorkerFactorImpl.kt */
/* loaded from: classes5.dex */
public final class WorkerFactorImpl extends WorkerFactory {

    /* renamed from: b  reason: collision with root package name */
    private final Map<Class<? extends ListenableWorker>, Provider<ChildWorkerFactory>> f36486b;

    @Inject
    public WorkerFactorImpl(Map<Class<? extends ListenableWorker>, Provider<ChildWorkerFactory>> workerFactories) {
        Intrinsics.f(workerFactories, "workerFactories");
        this.f36486b = workerFactories;
    }

    @Override // androidx.work.WorkerFactory
    public ListenableWorker a(Context appContext, String workerClassName, WorkerParameters workerParameters) {
        Object obj;
        Provider provider;
        ChildWorkerFactory childWorkerFactory;
        Intrinsics.f(appContext, "appContext");
        Intrinsics.f(workerClassName, "workerClassName");
        Intrinsics.f(workerParameters, "workerParameters");
        Iterator<T> it = this.f36486b.entrySet().iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (Class.forName(workerClassName).isAssignableFrom((Class) ((Map.Entry) obj).getKey())) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        Map.Entry entry = (Map.Entry) obj;
        if (entry != null) {
            provider = (Provider) entry.getValue();
        } else {
            provider = null;
        }
        AssertUtils.c(provider, "Unknown worker class name: " + workerClassName);
        if (provider == null || (childWorkerFactory = (ChildWorkerFactory) provider.get()) == null) {
            return null;
        }
        return childWorkerFactory.a(appContext, workerParameters);
    }
}
