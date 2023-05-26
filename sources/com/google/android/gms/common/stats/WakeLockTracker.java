package com.google.android.gms.common.stats;

import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
@KeepForSdk
@Deprecated
/* loaded from: classes.dex */
public class WakeLockTracker {
    private static WakeLockTracker zza = new WakeLockTracker();

    @NonNull
    @KeepForSdk
    public static WakeLockTracker getInstance() {
        return zza;
    }

    @KeepForSdk
    public void registerAcquireEvent(@NonNull Context context, @NonNull Intent intent, @NonNull String str, @NonNull String str2, @NonNull String str3, int i8, @NonNull String str4) {
    }

    @KeepForSdk
    public void registerDeadlineEvent(@NonNull Context context, @NonNull String str, @NonNull String str2, @NonNull String str3, int i8, @NonNull List<String> list, boolean z7, long j8) {
    }

    @KeepForSdk
    public void registerEvent(@NonNull Context context, @NonNull String str, int i8, @NonNull String str2, @NonNull String str3, @NonNull String str4, int i9, @NonNull List<String> list) {
    }

    @KeepForSdk
    public void registerEvent(@NonNull Context context, @NonNull String str, int i8, @NonNull String str2, @NonNull String str3, @NonNull String str4, int i9, @NonNull List<String> list, long j8) {
    }

    @KeepForSdk
    public void registerReleaseEvent(@NonNull Context context, @NonNull Intent intent) {
    }
}
