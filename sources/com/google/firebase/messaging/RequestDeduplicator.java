package com.google.firebase.messaging;

import android.util.Log;
import androidx.collection.ArrayMap;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import java.util.Map;
import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.firebase:firebase-messaging@@21.1.0 */
/* loaded from: classes3.dex */
class RequestDeduplicator {

    /* renamed from: a  reason: collision with root package name */
    private final Executor f16565a;
    @GuardedBy("this")

    /* renamed from: b  reason: collision with root package name */
    private final Map<String, Task<String>> f16566b = new ArrayMap();

    /* compiled from: com.google.firebase:firebase-messaging@@21.1.0 */
    /* loaded from: classes3.dex */
    interface GetTokenRequest {
        Task<String> start();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public RequestDeduplicator(Executor executor) {
        this.f16565a = executor;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public synchronized Task<String> a(final String str, GetTokenRequest getTokenRequest) {
        String str2;
        String str3;
        Task<String> task = this.f16566b.get(str);
        if (task != null) {
            if (Log.isLoggable("FirebaseMessaging", 3)) {
                String valueOf = String.valueOf(str);
                if (valueOf.length() != 0) {
                    str3 = "Joining ongoing request for: ".concat(valueOf);
                } else {
                    str3 = new String("Joining ongoing request for: ");
                }
                Log.d("FirebaseMessaging", str3);
            }
            return task;
        }
        if (Log.isLoggable("FirebaseMessaging", 3)) {
            String valueOf2 = String.valueOf(str);
            if (valueOf2.length() != 0) {
                str2 = "Making new request for: ".concat(valueOf2);
            } else {
                str2 = new String("Making new request for: ");
            }
            Log.d("FirebaseMessaging", str2);
        }
        Task continueWithTask = getTokenRequest.start().continueWithTask(this.f16565a, new Continuation(this, str) { // from class: com.google.firebase.messaging.RequestDeduplicator$$Lambda$0

            /* renamed from: a  reason: collision with root package name */
            private final RequestDeduplicator f16567a;

            /* renamed from: b  reason: collision with root package name */
            private final String f16568b;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f16567a = this;
                this.f16568b = str;
            }

            @Override // com.google.android.gms.tasks.Continuation
            public Object then(Task task2) {
                this.f16567a.b(this.f16568b, task2);
                return task2;
            }
        });
        this.f16566b.put(str, continueWithTask);
        return continueWithTask;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ Task b(String str, Task task) throws Exception {
        synchronized (this) {
            this.f16566b.remove(str);
        }
        return task;
    }
}
