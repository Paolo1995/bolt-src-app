package com.google.firebase.perf.internal;

import com.google.android.gms.tasks.OnSuccessListener;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final /* synthetic */ class RemoteConfigManager$$Lambda$1 implements OnSuccessListener {

    /* renamed from: a  reason: collision with root package name */
    private final RemoteConfigManager f16753a;

    private RemoteConfigManager$$Lambda$1(RemoteConfigManager remoteConfigManager) {
        this.f16753a = remoteConfigManager;
    }

    public static OnSuccessListener a(RemoteConfigManager remoteConfigManager) {
        return new RemoteConfigManager$$Lambda$1(remoteConfigManager);
    }

    @Override // com.google.android.gms.tasks.OnSuccessListener
    public void onSuccess(Object obj) {
        Boolean bool = (Boolean) obj;
        r0.syncConfigValues(this.f16753a.firebaseRemoteConfig.e());
    }
}
