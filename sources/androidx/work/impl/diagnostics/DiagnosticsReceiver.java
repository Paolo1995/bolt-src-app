package androidx.work.impl.diagnostics;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.work.Logger;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import androidx.work.impl.workers.DiagnosticsWorker;

/* loaded from: classes.dex */
public class DiagnosticsReceiver extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    private static final String f8555a = Logger.f("DiagnosticsRcvr");

    @Override // android.content.BroadcastReceiver
    public void onReceive(@NonNull Context context, Intent intent) {
        if (intent == null) {
            return;
        }
        Logger.c().a(f8555a, "Requesting diagnostics", new Throwable[0]);
        try {
            WorkManager.d(context).b(OneTimeWorkRequest.d(DiagnosticsWorker.class));
        } catch (IllegalStateException e8) {
            Logger.c().b(f8555a, "WorkManager is not initialized", e8);
        }
    }
}
