package ee.mtakso.driver.service.google;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings;
import ee.mtakso.driver.R;
import ee.mtakso.driver.service.google.FirebaseRemoteConfigManager;
import io.reactivex.Completable;
import io.reactivex.CompletableEmitter;
import io.reactivex.CompletableOnSubscribe;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FirebaseRemoteConfigManager.kt */
/* loaded from: classes3.dex */
public final class FirebaseRemoteConfigManager {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(FirebaseRemoteConfig remoteConfig, final CompletableEmitter emitter) {
        Intrinsics.f(remoteConfig, "$remoteConfig");
        Intrinsics.f(emitter, "emitter");
        remoteConfig.d().addOnCompleteListener(new OnCompleteListener() { // from class: h2.b
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                FirebaseRemoteConfigManager.e(CompletableEmitter.this, task);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(CompletableEmitter emitter, Task task) {
        Intrinsics.f(emitter, "$emitter");
        Intrinsics.f(task, "task");
        if (!task.isSuccessful()) {
            Exception exception = task.getException();
            if (exception == null) {
                exception = new Exception("Unable to fetch Firebase Remote Config");
            }
            emitter.onError(exception);
        }
        emitter.onComplete();
    }

    public final Completable c() {
        final FirebaseRemoteConfig g8 = FirebaseRemoteConfig.g();
        Intrinsics.e(g8, "getInstance()");
        g8.p(new FirebaseRemoteConfigSettings.Builder().c());
        g8.q(R.xml.firebase_remote_config_defaults);
        Completable i8 = Completable.i(new CompletableOnSubscribe() { // from class: h2.a
            @Override // io.reactivex.CompletableOnSubscribe
            public final void a(CompletableEmitter completableEmitter) {
                FirebaseRemoteConfigManager.d(FirebaseRemoteConfig.this, completableEmitter);
            }
        });
        Intrinsics.e(i8, "create { emitter ->\n    …              }\n        }");
        return i8;
    }
}
