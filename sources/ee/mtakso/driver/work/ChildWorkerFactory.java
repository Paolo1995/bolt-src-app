package ee.mtakso.driver.work;

import android.content.Context;
import androidx.work.ListenableWorker;
import androidx.work.WorkerParameters;

/* compiled from: ChildWorkerFactory.kt */
/* loaded from: classes5.dex */
public interface ChildWorkerFactory {
    ListenableWorker a(Context context, WorkerParameters workerParameters);
}
