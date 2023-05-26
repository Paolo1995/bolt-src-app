package ee.mtakso.driver.startup;

import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import ee.mtakso.driver.work.WorkerFactorImpl;

@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class WorkManagerInitializer_MembersInjector implements MembersInjector<WorkManagerInitializer> {
    @InjectedFieldSignature("ee.mtakso.driver.startup.WorkManagerInitializer.workerFactory")
    public static void a(WorkManagerInitializer workManagerInitializer, WorkerFactorImpl workerFactorImpl) {
        workManagerInitializer.f26220a = workerFactorImpl;
    }
}
