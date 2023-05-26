package com.google.firebase.remoteconfig;

import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.remoteconfig.internal.ConfigFetchHandler;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final /* synthetic */ class FirebaseRemoteConfig$$Lambda$5 implements SuccessContinuation {

    /* renamed from: a  reason: collision with root package name */
    private static final FirebaseRemoteConfig$$Lambda$5 f17028a = new FirebaseRemoteConfig$$Lambda$5();

    private FirebaseRemoteConfig$$Lambda$5() {
    }

    public static SuccessContinuation a() {
        return f17028a;
    }

    @Override // com.google.android.gms.tasks.SuccessContinuation
    public Task then(Object obj) {
        Task forResult;
        ConfigFetchHandler.FetchResponse fetchResponse = (ConfigFetchHandler.FetchResponse) obj;
        forResult = Tasks.forResult(null);
        return forResult;
    }
}
