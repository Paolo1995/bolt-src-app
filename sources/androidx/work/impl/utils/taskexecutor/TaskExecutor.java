package androidx.work.impl.utils.taskexecutor;

import androidx.work.impl.utils.SerialExecutor;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public interface TaskExecutor {
    Executor a();

    void b(Runnable runnable);

    SerialExecutor c();
}
