package ee.mtakso.driver.platform.google.installation;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.installations.FirebaseInstallations;
import ee.mtakso.driver.platform.google.installation.FirebaseInstallationIdProvider;
import ee.mtakso.driver.platform.installation.InstallationIdProvider;
import eu.bolt.kalev.Kalev;
import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FirebaseInstallationIdProvider.kt */
/* loaded from: classes3.dex */
public final class FirebaseInstallationIdProvider implements InstallationIdProvider {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(FirebaseInstallationIdProvider this$0, SingleEmitter emitter) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(emitter, "emitter");
        this$0.e(emitter);
    }

    private final void e(final SingleEmitter<String> singleEmitter) {
        FirebaseInstallations.n().getId().addOnCompleteListener(new OnCompleteListener() { // from class: a2.b
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                FirebaseInstallationIdProvider.f(SingleEmitter.this, task);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(SingleEmitter emitter, Task task) {
        Intrinsics.f(emitter, "$emitter");
        Intrinsics.f(task, "task");
        Object result = task.getResult();
        Kalev.b("Installation ID result: " + result);
        if (!task.isSuccessful()) {
            Exception exception = task.getException();
            if (exception == null) {
                exception = new IllegalStateException("Installation ID task is not successful, error is null");
            }
            emitter.onError(exception);
            return;
        }
        emitter.onSuccess(task.getResult());
    }

    @Override // ee.mtakso.driver.platform.installation.InstallationIdProvider
    public Single<String> a() {
        Single<String> f8 = Single.f(new SingleOnSubscribe() { // from class: a2.a
            @Override // io.reactivex.SingleOnSubscribe
            public final void a(SingleEmitter singleEmitter) {
                FirebaseInstallationIdProvider.d(FirebaseInstallationIdProvider.this, singleEmitter);
            }
        });
        Intrinsics.e(f8, "create { emitter -> requ…InstallationId(emitter) }");
        return f8;
    }
}
