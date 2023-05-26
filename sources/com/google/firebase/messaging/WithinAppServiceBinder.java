package com.google.firebase.messaging;

import android.content.Intent;
import android.os.Binder;
import android.os.Process;
import android.util.Log;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.WithinAppServiceConnection;

/* compiled from: com.google.firebase:firebase-messaging@@21.1.0 */
/* loaded from: classes3.dex */
class WithinAppServiceBinder extends Binder {

    /* renamed from: a  reason: collision with root package name */
    private final IntentHandler f16630a;

    /* compiled from: com.google.firebase:firebase-messaging@@21.1.0 */
    /* loaded from: classes3.dex */
    interface IntentHandler {
        Task<Void> a(Intent intent);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public WithinAppServiceBinder(IntentHandler intentHandler) {
        this.f16630a = intentHandler;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(final WithinAppServiceConnection.BindRequest bindRequest) {
        if (Binder.getCallingUid() == Process.myUid()) {
            if (Log.isLoggable("FirebaseMessaging", 3)) {
                Log.d("FirebaseMessaging", "service received new intent via bind strategy");
            }
            this.f16630a.a(bindRequest.f16641a).addOnCompleteListener(WithinAppServiceBinder$$Lambda$0.f16631f, new OnCompleteListener(bindRequest) { // from class: com.google.firebase.messaging.WithinAppServiceBinder$$Lambda$1

                /* renamed from: a  reason: collision with root package name */
                private final WithinAppServiceConnection.BindRequest f16632a;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.f16632a = bindRequest;
                }

                @Override // com.google.android.gms.tasks.OnCompleteListener
                public void onComplete(Task task) {
                    this.f16632a.b();
                }
            });
            return;
        }
        throw new SecurityException("Binding only allowed within app");
    }
}
