package com.google.firebase.installations;

import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.installations.local.PersistedInstallationEntry;

/* loaded from: classes3.dex */
class GetIdListener implements StateListener {

    /* renamed from: a  reason: collision with root package name */
    final TaskCompletionSource<String> f16376a;

    public GetIdListener(TaskCompletionSource<String> taskCompletionSource) {
        this.f16376a = taskCompletionSource;
    }

    @Override // com.google.firebase.installations.StateListener
    public boolean a(Exception exc) {
        return false;
    }

    @Override // com.google.firebase.installations.StateListener
    public boolean b(PersistedInstallationEntry persistedInstallationEntry) {
        if (!persistedInstallationEntry.l() && !persistedInstallationEntry.k() && !persistedInstallationEntry.i()) {
            return false;
        }
        this.f16376a.trySetResult(persistedInstallationEntry.d());
        return true;
    }
}
