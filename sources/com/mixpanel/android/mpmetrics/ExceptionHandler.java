package com.mixpanel.android.mpmetrics;

import android.os.Process;
import com.mixpanel.android.mpmetrics.MixpanelAPI;
import java.lang.Thread;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class ExceptionHandler implements Thread.UncaughtExceptionHandler {

    /* renamed from: b  reason: collision with root package name */
    private static ExceptionHandler f19126b;

    /* renamed from: a  reason: collision with root package name */
    private final Thread.UncaughtExceptionHandler f19127a = Thread.getDefaultUncaughtExceptionHandler();

    public ExceptionHandler() {
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    public static void a() {
        if (f19126b == null) {
            synchronized (ExceptionHandler.class) {
                if (f19126b == null) {
                    f19126b = new ExceptionHandler();
                }
            }
        }
    }

    private void b() {
        try {
            Thread.sleep(400L);
        } catch (InterruptedException e8) {
            e8.printStackTrace();
        }
        Process.killProcess(Process.myPid());
        System.exit(10);
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, final Throwable th) {
        MixpanelAPI.m(new MixpanelAPI.InstanceProcessor() { // from class: com.mixpanel.android.mpmetrics.ExceptionHandler.1
            @Override // com.mixpanel.android.mpmetrics.MixpanelAPI.InstanceProcessor
            public void a(MixpanelAPI mixpanelAPI) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("$ae_crashed_reason", th.toString());
                    mixpanelAPI.W("$ae_crashed", jSONObject, true);
                } catch (JSONException unused) {
                }
            }
        });
        MixpanelAPI.m(new MixpanelAPI.InstanceProcessor() { // from class: com.mixpanel.android.mpmetrics.ExceptionHandler.2
            @Override // com.mixpanel.android.mpmetrics.MixpanelAPI.InstanceProcessor
            public void a(MixpanelAPI mixpanelAPI) {
                mixpanelAPI.t();
            }
        });
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.f19127a;
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(thread, th);
        } else {
            b();
        }
    }
}
