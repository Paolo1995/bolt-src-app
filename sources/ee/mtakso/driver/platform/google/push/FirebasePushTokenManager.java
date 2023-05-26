package ee.mtakso.driver.platform.google.push;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;
import com.google.firebase.messaging.FirebaseMessaging;
import ee.mtakso.driver.platform.google.push.FirebasePushTokenManager;
import ee.mtakso.driver.platform.push.TokenProvider;
import eu.bolt.kalev.Kalev;
import eu.bolt.kalev.fast.FastLog;
import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import io.reactivex.functions.Function;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: FirebasePushTokenManager.kt */
/* loaded from: classes3.dex */
public final class FirebasePushTokenManager implements TokenProvider {

    /* renamed from: a  reason: collision with root package name */
    private final String f23335a = FirebaseApp.k().m().d();

    private final void i(final SingleEmitter<String> singleEmitter) {
        FirebaseMessaging.g().i().addOnCompleteListener(new OnCompleteListener() { // from class: b2.e
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                FirebasePushTokenManager.j(SingleEmitter.this, task);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(SingleEmitter emitter, Task task) {
        Intrinsics.f(emitter, "$emitter");
        Intrinsics.f(task, "task");
        if (!task.isSuccessful()) {
            Exception exception = task.getException();
            if (exception == null) {
                exception = new IllegalStateException("PushToken task is not successful, error is null");
            }
            emitter.onError(exception);
            return;
        }
        String str = (String) task.getResult();
        FastLog g8 = Kalev.f41674e.g();
        if (g8 != null) {
            FastLog.DefaultImpls.a(g8, "Push token result: " + str, null, 2, null);
        }
        emitter.onSuccess(str);
    }

    private final void k(final SingleEmitter<String> singleEmitter) {
        FirebaseInstanceId.i().j().addOnCompleteListener(new OnCompleteListener() { // from class: b2.d
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                FirebasePushTokenManager.l(SingleEmitter.this, task);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(SingleEmitter emitter, Task task) {
        boolean y7;
        Intrinsics.f(emitter, "$emitter");
        Intrinsics.f(task, "task");
        if (task.isSuccessful()) {
            String a8 = ((InstanceIdResult) task.getResult()).a();
            Intrinsics.e(a8, "task.result.token");
            FastLog g8 = Kalev.f41674e.g();
            if (g8 != null) {
                FastLog.DefaultImpls.a(g8, "Push token result: " + a8, null, 2, null);
            }
            y7 = StringsKt__StringsJVMKt.y(a8);
            if (y7) {
                emitter.onError(new IllegalStateException("Push token is empty"));
                return;
            } else {
                emitter.onSuccess(a8);
                return;
            }
        }
        Exception exception = task.getException();
        if (exception == null) {
            exception = new IllegalStateException("PushToken task is not successful, error is null");
        }
        emitter.onError(exception);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(FirebasePushTokenManager this$0, SingleEmitter emitter) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(emitter, "emitter");
        this$0.k(emitter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(FirebasePushTokenManager this$0, SingleEmitter emitter) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(emitter, "emitter");
        this$0.i(emitter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TokenProvider.PushTokenData o(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (TokenProvider.PushTokenData) tmp0.invoke(obj);
    }

    @Override // ee.mtakso.driver.platform.push.TokenProvider
    public Single<TokenProvider.PushTokenData> a() {
        Single f8 = Single.f(new SingleOnSubscribe() { // from class: b2.b
            @Override // io.reactivex.SingleOnSubscribe
            public final void a(SingleEmitter singleEmitter) {
                FirebasePushTokenManager.n(FirebasePushTokenManager.this, singleEmitter);
            }
        });
        final Function1<String, TokenProvider.PushTokenData> function1 = new Function1<String, TokenProvider.PushTokenData>() { // from class: ee.mtakso.driver.platform.google.push.FirebasePushTokenManager$requestPushTokenData$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final TokenProvider.PushTokenData invoke(String it) {
                String str;
                Intrinsics.f(it, "it");
                str = FirebasePushTokenManager.this.f23335a;
                return new TokenProvider.PushTokenData(str, it);
            }
        };
        Single<TokenProvider.PushTokenData> x7 = f8.x(new Function() { // from class: b2.c
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                TokenProvider.PushTokenData o8;
                o8 = FirebasePushTokenManager.o(Function1.this, obj);
                return o8;
            }
        });
        Intrinsics.e(x7, "override fun requestPush…)\n                }\n    }");
        return x7;
    }

    @Override // ee.mtakso.driver.platform.push.TokenProvider
    public Single<String> b() {
        Single<String> f8 = Single.f(new SingleOnSubscribe() { // from class: b2.a
            @Override // io.reactivex.SingleOnSubscribe
            public final void a(SingleEmitter singleEmitter) {
                FirebasePushTokenManager.m(FirebasePushTokenManager.this, singleEmitter);
            }
        });
        Intrinsics.e(f8, "create { emitter ->\n    …Legacy(emitter)\n        }");
        return f8;
    }
}
