package com.google.firebase.installations;

import androidx.annotation.NonNull;
import com.google.android.gms.tasks.Task;

/* loaded from: classes3.dex */
public interface FirebaseInstallationsApi {
    @NonNull
    Task<InstallationTokenResult> a(boolean z7);

    @NonNull
    Task<String> getId();
}
