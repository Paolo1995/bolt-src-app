package com.google.firebase.remoteconfig;

import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.remoteconfig.internal.ConfigContainer;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final /* synthetic */ class FirebaseRemoteConfig$$Lambda$9 implements SuccessContinuation {

    /* renamed from: a  reason: collision with root package name */
    private static final FirebaseRemoteConfig$$Lambda$9 f17031a = new FirebaseRemoteConfig$$Lambda$9();

    private FirebaseRemoteConfig$$Lambda$9() {
    }

    public static SuccessContinuation a() {
        return f17031a;
    }

    @Override // com.google.android.gms.tasks.SuccessContinuation
    public Task then(Object obj) {
        Task forResult;
        ConfigContainer configContainer = (ConfigContainer) obj;
        forResult = Tasks.forResult(null);
        return forResult;
    }
}
