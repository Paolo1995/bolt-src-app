package com.mixpanel.android.mpmetrics;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.Build;
import android.view.Display;
import android.view.WindowManager;
import com.mixpanel.android.mpmetrics.InAppNotification;
import com.mixpanel.android.util.ImageStore;
import com.mixpanel.android.util.MPLog;
import com.mixpanel.android.util.RemoteService;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class DecideChecker {

    /* renamed from: f  reason: collision with root package name */
    private static final JSONArray f19099f = new JSONArray();

    /* renamed from: a  reason: collision with root package name */
    private final MPConfig f19100a;

    /* renamed from: b  reason: collision with root package name */
    private final Context f19101b;

    /* renamed from: c  reason: collision with root package name */
    private final Map<String, DecideMessages> f19102c = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    private final ImageStore f19103d;

    /* renamed from: e  reason: collision with root package name */
    private final SystemInformation f19104e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class Result {

        /* renamed from: a  reason: collision with root package name */
        public final List<InAppNotification> f19105a = new ArrayList();

        /* renamed from: b  reason: collision with root package name */
        public final List<InAppNotification> f19106b = new ArrayList();

        /* renamed from: c  reason: collision with root package name */
        public JSONArray f19107c = DecideChecker.f19099f;

        /* renamed from: d  reason: collision with root package name */
        public JSONArray f19108d = DecideChecker.f19099f;

        /* renamed from: e  reason: collision with root package name */
        public boolean f19109e = false;

        /* renamed from: f  reason: collision with root package name */
        public JSONArray f19110f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class UnintelligibleMessageException extends Exception {
        public UnintelligibleMessageException(String str, JSONException jSONException) {
            super(str, jSONException);
        }
    }

    public DecideChecker(Context context, MPConfig mPConfig) {
        this.f19101b = context;
        this.f19100a = mPConfig;
        this.f19103d = d(context);
        this.f19104e = SystemInformation.g(context);
    }

    private static byte[] c(RemoteService remoteService, Context context, String str) throws RemoteService.ServiceUnavailableException {
        MPConfig s7 = MPConfig.s(context);
        if (!remoteService.b(context, s7.z())) {
            return null;
        }
        try {
            return remoteService.a(str, null, s7.C());
        } catch (FileNotFoundException e8) {
            MPLog.j("MixpanelAPI.DChecker", "Cannot get " + str + ", file not found.", e8);
            return null;
        } catch (MalformedURLException e9) {
            MPLog.d("MixpanelAPI.DChecker", "Cannot interpret " + str + " as a URL.", e9);
            return null;
        } catch (IOException e10) {
            MPLog.j("MixpanelAPI.DChecker", "Cannot get " + str + ".", e10);
            return null;
        } catch (OutOfMemoryError e11) {
            MPLog.d("MixpanelAPI.DChecker", "Out of memory when getting to " + str + ".", e11);
            return null;
        }
    }

    private String f(String str, String str2, RemoteService remoteService) throws RemoteService.ServiceUnavailableException {
        String str3;
        try {
            String encode = URLEncoder.encode(str, "utf-8");
            if (str2 != null) {
                str3 = URLEncoder.encode(str2, "utf-8");
            } else {
                str3 = null;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("?version=1&lib=android&token=");
            sb.append(encode);
            if (str3 != null) {
                sb.append("&distinct_id=");
                sb.append(str3);
            }
            sb.append("&properties=");
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("$android_lib_version", "5.8.5");
                jSONObject.putOpt("$android_app_version", this.f19104e.c());
                jSONObject.putOpt("$android_version", Build.VERSION.RELEASE);
                jSONObject.putOpt("$android_app_release", this.f19104e.b());
                jSONObject.putOpt("$android_device_model", Build.MODEL);
                sb.append(URLEncoder.encode(jSONObject.toString(), "utf-8"));
            } catch (Exception e8) {
                MPLog.d("MixpanelAPI.DChecker", "Exception constructing properties JSON", e8.getCause());
            }
            String str4 = this.f19100a.d() + sb.toString();
            MPLog.i("MixpanelAPI.DChecker", "Querying decide server, url: " + str4);
            byte[] c8 = c(remoteService, this.f19101b, str4);
            if (c8 == null) {
                return null;
            }
            try {
                return new String(c8, "UTF-8");
            } catch (UnsupportedEncodingException e9) {
                throw new RuntimeException("UTF not supported on this platform?", e9);
            }
        } catch (UnsupportedEncodingException e10) {
            throw new RuntimeException("Mixpanel library requires utf-8 string encoding to be available", e10);
        }
    }

    @SuppressLint({"NewApi"})
    private static int g(Display display) {
        Point point = new Point();
        display.getSize(point);
        return point.x;
    }

    private Bitmap h(InAppNotification inAppNotification, Context context) throws RemoteService.ServiceUnavailableException {
        String[] strArr = {inAppNotification.h(), inAppNotification.j()};
        int g8 = g(((WindowManager) context.getSystemService("window")).getDefaultDisplay());
        if (inAppNotification.n() == InAppNotification.Type.TAKEOVER && g8 >= 720) {
            strArr = new String[]{inAppNotification.i(), inAppNotification.h(), inAppNotification.j()};
        }
        int length = strArr.length;
        for (int i8 = 0; i8 < length; i8++) {
            String str = strArr[i8];
            try {
                return this.f19103d.f(str);
            } catch (ImageStore.CantGetImageException e8) {
                MPLog.j("MixpanelAPI.DChecker", "Can't load image " + str + " for a notification", e8);
            }
        }
        return null;
    }

    static Result i(String str) throws UnintelligibleMessageException {
        Result result = new Result();
        try {
            JSONObject jSONObject = new JSONObject(str);
            for (InAppNotification inAppNotification : j(jSONObject)) {
                if (inAppNotification.p()) {
                    result.f19106b.add(inAppNotification);
                } else {
                    result.f19105a.add(inAppNotification);
                }
            }
            if (jSONObject.has("event_bindings")) {
                try {
                    result.f19107c = jSONObject.getJSONArray("event_bindings");
                } catch (JSONException unused) {
                    MPLog.c("MixpanelAPI.DChecker", "Mixpanel endpoint returned non-array JSON for event bindings: " + jSONObject);
                }
            }
            if (jSONObject.has("variants")) {
                try {
                    result.f19108d = jSONObject.getJSONArray("variants");
                } catch (JSONException unused2) {
                    MPLog.c("MixpanelAPI.DChecker", "Mixpanel endpoint returned non-array JSON for variants: " + jSONObject);
                }
            }
            if (jSONObject.has("automatic_events")) {
                try {
                    result.f19109e = jSONObject.getBoolean("automatic_events");
                } catch (JSONException unused3) {
                    MPLog.c("MixpanelAPI.DChecker", "Mixpanel endpoint returned a non boolean value for automatic events: " + jSONObject);
                }
            }
            if (jSONObject.has("integrations")) {
                try {
                    result.f19110f = jSONObject.getJSONArray("integrations");
                } catch (JSONException unused4) {
                    MPLog.c("MixpanelAPI.DChecker", "Mixpanel endpoint returned a non-array JSON for integrations: " + jSONObject);
                }
            }
            return result;
        } catch (JSONException e8) {
            throw new UnintelligibleMessageException("Mixpanel endpoint returned unparsable result:\n" + str, e8);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x002d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.util.List<com.mixpanel.android.mpmetrics.InAppNotification> j(org.json.JSONObject r9) {
        /*
            java.lang.String r0 = "Received a strange response from notifications service: "
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.lang.String r2 = "notifications"
            boolean r3 = r9.has(r2)
            java.lang.String r4 = "MixpanelAPI.DChecker"
            if (r3 == 0) goto L2a
            org.json.JSONArray r9 = r9.getJSONArray(r2)     // Catch: org.json.JSONException -> L16
            goto L2b
        L16:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Mixpanel endpoint returned non-array JSON for notifications: "
            r2.append(r3)
            r2.append(r9)
            java.lang.String r9 = r2.toString()
            com.mixpanel.android.util.MPLog.c(r4, r9)
        L2a:
            r9 = 0
        L2b:
            if (r9 == 0) goto Lc5
            r2 = 0
            r3 = 0
            r5 = 0
        L30:
            int r6 = r9.length()
            if (r2 >= r6) goto Lc5
            org.json.JSONObject r6 = r9.getJSONObject(r2)     // Catch: java.lang.OutOfMemoryError -> L78 com.mixpanel.android.mpmetrics.BadDecideObjectException -> L92 org.json.JSONException -> Laa
            java.lang.String r7 = "display_triggers"
            boolean r7 = r6.has(r7)     // Catch: java.lang.OutOfMemoryError -> L78 com.mixpanel.android.mpmetrics.BadDecideObjectException -> L92 org.json.JSONException -> Laa
            r8 = 2
            if (r7 == 0) goto L4a
            if (r5 < r8) goto L47
            goto Lc1
        L47:
            int r5 = r5 + 1
            goto L50
        L4a:
            if (r3 < r8) goto L4e
            goto Lc1
        L4e:
            int r3 = r3 + 1
        L50:
            java.lang.String r7 = "type"
            java.lang.String r7 = r6.getString(r7)     // Catch: java.lang.OutOfMemoryError -> L78 com.mixpanel.android.mpmetrics.BadDecideObjectException -> L92 org.json.JSONException -> Laa
            java.lang.String r8 = "takeover"
            boolean r8 = r7.equalsIgnoreCase(r8)     // Catch: java.lang.OutOfMemoryError -> L78 com.mixpanel.android.mpmetrics.BadDecideObjectException -> L92 org.json.JSONException -> Laa
            if (r8 == 0) goto L67
            com.mixpanel.android.mpmetrics.TakeoverInAppNotification r7 = new com.mixpanel.android.mpmetrics.TakeoverInAppNotification     // Catch: java.lang.OutOfMemoryError -> L78 com.mixpanel.android.mpmetrics.BadDecideObjectException -> L92 org.json.JSONException -> Laa
            r7.<init>(r6)     // Catch: java.lang.OutOfMemoryError -> L78 com.mixpanel.android.mpmetrics.BadDecideObjectException -> L92 org.json.JSONException -> Laa
            r1.add(r7)     // Catch: java.lang.OutOfMemoryError -> L78 com.mixpanel.android.mpmetrics.BadDecideObjectException -> L92 org.json.JSONException -> Laa
            goto Lc1
        L67:
            java.lang.String r8 = "mini"
            boolean r7 = r7.equalsIgnoreCase(r8)     // Catch: java.lang.OutOfMemoryError -> L78 com.mixpanel.android.mpmetrics.BadDecideObjectException -> L92 org.json.JSONException -> Laa
            if (r7 == 0) goto Lc1
            com.mixpanel.android.mpmetrics.MiniInAppNotification r7 = new com.mixpanel.android.mpmetrics.MiniInAppNotification     // Catch: java.lang.OutOfMemoryError -> L78 com.mixpanel.android.mpmetrics.BadDecideObjectException -> L92 org.json.JSONException -> Laa
            r7.<init>(r6)     // Catch: java.lang.OutOfMemoryError -> L78 com.mixpanel.android.mpmetrics.BadDecideObjectException -> L92 org.json.JSONException -> Laa
            r1.add(r7)     // Catch: java.lang.OutOfMemoryError -> L78 com.mixpanel.android.mpmetrics.BadDecideObjectException -> L92 org.json.JSONException -> Laa
            goto Lc1
        L78:
            r6 = move-exception
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "Not enough memory to show load notification from package: "
            r7.append(r8)
            java.lang.String r8 = r9.toString()
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            com.mixpanel.android.util.MPLog.d(r4, r7, r6)
            goto Lc1
        L92:
            r6 = move-exception
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            r7.append(r0)
            java.lang.String r8 = r9.toString()
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            com.mixpanel.android.util.MPLog.d(r4, r7, r6)
            goto Lc1
        Laa:
            r6 = move-exception
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            r7.append(r0)
            java.lang.String r8 = r9.toString()
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            com.mixpanel.android.util.MPLog.d(r4, r7, r6)
        Lc1:
            int r2 = r2 + 1
            goto L30
        Lc5:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mixpanel.android.mpmetrics.DecideChecker.j(org.json.JSONObject):java.util.List");
    }

    private Result k(String str, String str2, RemoteService remoteService) throws RemoteService.ServiceUnavailableException, UnintelligibleMessageException {
        String f8 = f(str, str2, remoteService);
        MPLog.i("MixpanelAPI.DChecker", "Mixpanel decide server response was:\n" + f8);
        if (f8 != null) {
            Result i8 = i(f8);
            m(i8.f19105a.iterator());
            m(i8.f19106b.iterator());
            return i8;
        }
        return null;
    }

    private void m(Iterator<InAppNotification> it) throws RemoteService.ServiceUnavailableException {
        while (it.hasNext()) {
            InAppNotification next = it.next();
            Bitmap h8 = h(next, this.f19101b);
            if (h8 == null) {
                MPLog.e("MixpanelAPI.DChecker", "Could not retrieve image for notification " + next.f() + ", will not show the notification.");
                it.remove();
            } else {
                next.r(h8);
            }
        }
    }

    public void b(DecideMessages decideMessages) {
        this.f19102c.put(decideMessages.e(), decideMessages);
    }

    protected ImageStore d(Context context) {
        return new ImageStore(context, "DecideChecker");
    }

    public DecideMessages e(String str) {
        return this.f19102c.get(str);
    }

    public void l(String str, RemoteService remoteService) throws RemoteService.ServiceUnavailableException {
        DecideMessages decideMessages = this.f19102c.get(str);
        if (decideMessages != null) {
            try {
                Result k8 = k(decideMessages.e(), decideMessages.a(), remoteService);
                if (k8 != null) {
                    decideMessages.i(k8.f19105a, k8.f19106b, k8.f19107c, k8.f19108d, k8.f19109e, k8.f19110f);
                }
            } catch (UnintelligibleMessageException e8) {
                MPLog.d("MixpanelAPI.DChecker", e8.getMessage(), e8);
            }
        }
    }
}
