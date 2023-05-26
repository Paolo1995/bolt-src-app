package com.sinch.android.rtc.internal.service.state;

import android.app.ActivityManager;
import android.content.Context;
import androidx.core.content.ContextCompat;
import java.util.List;

/* loaded from: classes3.dex */
public class AndroidAppStateService implements AppStateService {
    private Context context;

    public AndroidAppStateService(Context context) {
        this.context = context;
    }

    @Override // com.sinch.android.rtc.internal.service.state.AppStateService
    public boolean isAppInForeground() {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        ActivityManager activityManager = (ActivityManager) this.context.getSystemService("activity");
        if (activityManager == null || (runningAppProcesses = activityManager.getRunningAppProcesses()) == null) {
            return false;
        }
        String packageName = this.context.getPackageName();
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (runningAppProcessInfo.importance == 100 && runningAppProcessInfo.processName.equals(packageName)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.sinch.android.rtc.internal.service.state.AppStateService
    public boolean isMicrophonePermissionGranted() {
        return ContextCompat.checkSelfPermission(this.context, "android.permission.RECORD_AUDIO") == 0;
    }
}
