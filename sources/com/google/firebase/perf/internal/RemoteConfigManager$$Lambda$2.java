package com.google.firebase.perf.internal;

import com.google.android.gms.tasks.OnFailureListener;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final /* synthetic */ class RemoteConfigManager$$Lambda$2 implements OnFailureListener {

    /* renamed from: a  reason: collision with root package name */
    private final RemoteConfigManager f16754a;

    private RemoteConfigManager$$Lambda$2(RemoteConfigManager remoteConfigManager) {
        this.f16754a = remoteConfigManager;
    }

    public static OnFailureListener a(RemoteConfigManager remoteConfigManager) {
        return new RemoteConfigManager$$Lambda$2(remoteConfigManager);
    }

    @Override // com.google.android.gms.tasks.OnFailureListener
    public void onFailure(Exception exc) {
        this.f16754a.firebaseRemoteConfigLastFetchTimestampMs = RemoteConfigManager.FETCH_NEVER_HAPPENED_TIMESTAMP_MS;
    }
}
