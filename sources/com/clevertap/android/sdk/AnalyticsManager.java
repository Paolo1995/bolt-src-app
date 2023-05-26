package com.clevertap.android.sdk;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.clevertap.android.sdk.events.BaseEventQueueManager;
import com.clevertap.android.sdk.inapp.CTInAppNotification;
import com.clevertap.android.sdk.inbox.CTInboxMessage;
import com.clevertap.android.sdk.response.CleverTapResponseHelper;
import com.clevertap.android.sdk.response.DisplayUnitResponse;
import com.clevertap.android.sdk.response.InAppResponse;
import com.clevertap.android.sdk.response.InboxResponse;
import com.clevertap.android.sdk.task.CTExecutorFactory;
import com.clevertap.android.sdk.utils.CTJsonConverter;
import com.clevertap.android.sdk.utils.UriHelper;
import com.clevertap.android.sdk.validation.ValidationResult;
import com.clevertap.android.sdk.validation.ValidationResultFactory;
import com.clevertap.android.sdk.validation.ValidationResultStack;
import com.clevertap.android.sdk.validation.Validator;
import com.google.android.gms.auth.api.credentials.CredentialsApi;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Callable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class AnalyticsManager extends BaseAnalyticsManager {

    /* renamed from: a  reason: collision with root package name */
    private final CTLockManager f10809a;

    /* renamed from: c  reason: collision with root package name */
    private final BaseEventQueueManager f10811c;

    /* renamed from: d  reason: collision with root package name */
    private final BaseCallbackManager f10812d;

    /* renamed from: e  reason: collision with root package name */
    private final CleverTapInstanceConfig f10813e;

    /* renamed from: f  reason: collision with root package name */
    private final Context f10814f;

    /* renamed from: g  reason: collision with root package name */
    private final ControllerManager f10815g;

    /* renamed from: h  reason: collision with root package name */
    private final CoreMetaData f10816h;

    /* renamed from: i  reason: collision with root package name */
    private final DeviceInfo f10817i;

    /* renamed from: j  reason: collision with root package name */
    private final LocalDataStore f10818j;

    /* renamed from: k  reason: collision with root package name */
    private final ValidationResultStack f10819k;

    /* renamed from: l  reason: collision with root package name */
    private final Validator f10820l;

    /* renamed from: b  reason: collision with root package name */
    private final HashMap<String, Integer> f10810b = new HashMap<>(8);

    /* renamed from: m  reason: collision with root package name */
    private final HashMap<String, Object> f10821m = new HashMap<>();

    /* renamed from: n  reason: collision with root package name */
    private final Object f10822n = new Object();

    /* renamed from: o  reason: collision with root package name */
    private final HashMap<String, Object> f10823o = new HashMap<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    public AnalyticsManager(Context context, CleverTapInstanceConfig cleverTapInstanceConfig, BaseEventQueueManager baseEventQueueManager, Validator validator, ValidationResultStack validationResultStack, CoreMetaData coreMetaData, LocalDataStore localDataStore, DeviceInfo deviceInfo, BaseCallbackManager baseCallbackManager, ControllerManager controllerManager, CTLockManager cTLockManager) {
        this.f10814f = context;
        this.f10813e = cleverTapInstanceConfig;
        this.f10811c = baseEventQueueManager;
        this.f10820l = validator;
        this.f10819k = validationResultStack;
        this.f10816h = coreMetaData;
        this.f10818j = localDataStore;
        this.f10817i = deviceInfo;
        this.f10812d = baseCallbackManager;
        this.f10809a = cTLockManager;
        this.f10815g = controllerManager;
    }

    private JSONArray b(ArrayList<String> arrayList, String str) {
        String str2;
        if (arrayList != null && str != null) {
            try {
                JSONArray jSONArray = new JSONArray();
                Iterator<String> it = arrayList.iterator();
                while (it.hasNext()) {
                    String next = it.next();
                    if (next == null) {
                        next = "";
                    }
                    ValidationResult d8 = this.f10820l.d(next);
                    if (d8.a() != 0) {
                        this.f10819k.b(d8);
                    }
                    if (d8.c() != null) {
                        str2 = d8.c().toString();
                    } else {
                        str2 = null;
                    }
                    if (str2 != null && !str2.isEmpty()) {
                        jSONArray.put(str2);
                    }
                    d(str);
                    return null;
                }
                return jSONArray;
            } catch (Throwable th) {
                this.f10813e.n().t(this.f10813e.c(), "Error cleaning multi values for key " + str, th);
                d(str);
            }
        }
        return null;
    }

    private JSONArray c(String str, String str2) {
        boolean equals = str2.equals("$remove");
        boolean equals2 = str2.equals("$add");
        if (!equals && !equals2) {
            return new JSONArray();
        }
        Object f8 = f(str);
        JSONArray jSONArray = null;
        if (f8 == null) {
            if (equals) {
                return null;
            }
            return new JSONArray();
        } else if (f8 instanceof JSONArray) {
            return (JSONArray) f8;
        } else {
            if (equals2) {
                jSONArray = new JSONArray();
            }
            String j8 = j(f8);
            if (j8 != null) {
                return new JSONArray().put(j8);
            }
            return jSONArray;
        }
    }

    private void e(String str) {
        this.f10819k.b(ValidationResultFactory.b(523, 23, str));
        Logger n8 = this.f10813e.n();
        String c8 = this.f10813e.c();
        n8.f(c8, "Invalid multi-value property key " + str + " profile multi value operation aborted");
    }

    private Object f(String str) {
        return this.f10818j.w(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(ArrayList<String> arrayList, String str, String str2) {
        String str3;
        if (str == null) {
            return;
        }
        if (arrayList != null && !arrayList.isEmpty()) {
            ValidationResult c8 = this.f10820l.c(str);
            if (c8.a() != 0) {
                this.f10819k.b(c8);
            }
            if (c8.c() != null) {
                str3 = c8.c().toString();
            } else {
                str3 = null;
            }
            if (str3 != null && !str3.isEmpty()) {
                try {
                    k(c(str3, str2), b(arrayList, str3), arrayList, str3, str2);
                    return;
                } catch (Throwable th) {
                    Logger n8 = this.f10813e.n();
                    String c9 = this.f10813e.c();
                    n8.t(c9, "Error handling multi value operation for key " + str3, th);
                    return;
                }
            }
            e(str);
            return;
        }
        d(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v2, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v6, types: [java.lang.Object, java.lang.String] */
    public void h(Map<String, Object> map) {
        if (map != null && !map.isEmpty()) {
            try {
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                for (String str : map.keySet()) {
                    Object obj = map.get(str);
                    ValidationResult e8 = this.f10820l.e(str);
                    String obj2 = e8.c().toString();
                    if (e8.a() != 0) {
                        this.f10819k.b(e8);
                    }
                    if (obj2.isEmpty()) {
                        ValidationResult b8 = ValidationResultFactory.b(512, 2, new String[0]);
                        this.f10819k.b(b8);
                        this.f10813e.n().f(this.f10813e.c(), b8.b());
                    } else {
                        ValidationResult f8 = this.f10820l.f(obj, Validator.ValidationContext.Profile);
                        Object c8 = f8.c();
                        if (f8.a() != 0) {
                            this.f10819k.b(f8);
                        }
                        if (obj2.equalsIgnoreCase("Phone")) {
                            try {
                                c8 = c8.toString();
                                String u7 = this.f10817i.u();
                                if ((u7 == null || u7.isEmpty()) && !c8.startsWith("+")) {
                                    ValidationResult b9 = ValidationResultFactory.b(512, 4, c8);
                                    this.f10819k.b(b9);
                                    this.f10813e.n().f(this.f10813e.c(), b9.b());
                                }
                                Logger n8 = this.f10813e.n();
                                String c9 = this.f10813e.c();
                                StringBuilder sb = new StringBuilder();
                                sb.append("Profile phone is: ");
                                sb.append((Object) c8);
                                sb.append(" device country code is: ");
                                if (u7 == null) {
                                    u7 = "null";
                                }
                                sb.append(u7);
                                n8.s(c9, sb.toString());
                            } catch (Exception e9) {
                                this.f10819k.b(ValidationResultFactory.b(512, 5, new String[0]));
                                Logger n9 = this.f10813e.n();
                                String c10 = this.f10813e.c();
                                n9.f(c10, "Invalid phone number: " + e9.getLocalizedMessage());
                            }
                        }
                        jSONObject2.put(obj2, c8);
                        jSONObject.put(obj2, c8);
                    }
                }
                Logger n10 = this.f10813e.n();
                String c11 = this.f10813e.c();
                n10.s(c11, "Constructed custom profile: " + jSONObject.toString());
                if (jSONObject2.length() > 0) {
                    this.f10818j.O(jSONObject2);
                }
                this.f10811c.c(jSONObject);
            } catch (Throwable th) {
                this.f10813e.n().t(this.f10813e.c(), "Failed to push profile", th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(String str) {
        if (str == null) {
            str = "";
        }
        try {
            ValidationResult e8 = this.f10820l.e(str);
            String obj = e8.c().toString();
            if (obj.isEmpty()) {
                ValidationResult b8 = ValidationResultFactory.b(512, 6, new String[0]);
                this.f10819k.b(b8);
                this.f10813e.n().f(this.f10813e.c(), b8.b());
                return;
            }
            if (e8.a() != 0) {
                this.f10819k.b(e8);
            }
            this.f10818j.H(obj);
            this.f10811c.c(new JSONObject().put(obj, new JSONObject().put("$delete", true)));
            Logger n8 = this.f10813e.n();
            String c8 = this.f10813e.c();
            n8.s(c8, "removing value for key " + obj + " from user profile");
        } catch (Throwable th) {
            Logger n9 = this.f10813e.n();
            String c9 = this.f10813e.c();
            n9.t(c9, "Failed to remove profile value for key " + str, th);
        }
    }

    private String j(Object obj) {
        String k8 = CTJsonConverter.k(obj);
        if (k8 != null) {
            ValidationResult d8 = this.f10820l.d(k8);
            if (d8.a() != 0) {
                this.f10819k.b(d8);
            }
            if (d8.c() != null) {
                return d8.c().toString();
            }
            return null;
        }
        return k8;
    }

    private void k(JSONArray jSONArray, JSONArray jSONArray2, ArrayList<String> arrayList, String str, String str2) {
        String str3;
        if (jSONArray != null && jSONArray2 != null && arrayList != null && str != null && str2 != null) {
            try {
                if (str2.equals("$remove")) {
                    str3 = "multiValuePropertyRemoveValues";
                } else {
                    str3 = "multiValuePropertyAddValues";
                }
                ValidationResult j8 = this.f10820l.j(jSONArray, jSONArray2, str3, str);
                if (j8.a() != 0) {
                    this.f10819k.b(j8);
                }
                JSONArray jSONArray3 = (JSONArray) j8.c();
                if (jSONArray3 != null && jSONArray3.length() > 0) {
                    this.f10818j.M(str, jSONArray3);
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(str2, new JSONArray((Collection) arrayList));
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put(str, jSONObject);
                    this.f10811c.c(jSONObject2);
                    Logger n8 = this.f10813e.n();
                    String c8 = this.f10813e.c();
                    n8.s(c8, "Constructed multi-value profile push: " + jSONObject2.toString());
                }
                this.f10818j.H(str);
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put(str2, new JSONArray((Collection) arrayList));
                JSONObject jSONObject22 = new JSONObject();
                jSONObject22.put(str, jSONObject3);
                this.f10811c.c(jSONObject22);
                Logger n82 = this.f10813e.n();
                String c82 = this.f10813e.c();
                n82.s(c82, "Constructed multi-value profile push: " + jSONObject22.toString());
            } catch (Throwable th) {
                Logger n9 = this.f10813e.n();
                String c9 = this.f10813e.c();
                n9.t(c9, "Error pushing multiValue for key " + str, th);
            }
        }
    }

    private boolean v(Bundle bundle, HashMap<String, Object> hashMap, int i8) {
        boolean z7;
        synchronized (this.f10822n) {
            z7 = false;
            try {
                String string = bundle.getString("wzrk_id");
                long currentTimeMillis = System.currentTimeMillis();
                if (hashMap.containsKey(string) && currentTimeMillis - ((Long) hashMap.get(string)).longValue() < i8) {
                    z7 = true;
                }
                hashMap.put(string, Long.valueOf(currentTimeMillis));
            } catch (Throwable unused) {
            }
        }
        return z7;
    }

    private void x(Bundle bundle) {
        try {
            new DisplayUnitResponse(new CleverTapResponseHelper(), this.f10813e, this.f10812d, this.f10815g).a(CTJsonConverter.a(bundle), null, this.f10814f);
        } catch (Throwable th) {
            Logger.q("Failed to process Display Unit from push notification payload", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void A(Uri uri, boolean z7) {
        if (uri == null) {
            return;
        }
        try {
            JSONObject b8 = UriHelper.b(uri);
            if (b8.has("us")) {
                this.f10816h.Y(b8.get("us").toString());
            }
            if (b8.has("um")) {
                this.f10816h.V(b8.get("um").toString());
            }
            if (b8.has("uc")) {
                this.f10816h.K(b8.get("uc").toString());
            }
            b8.put("referrer", uri.toString());
            if (z7) {
                b8.put("install", true);
            }
            I(b8);
        } finally {
        }
    }

    public void B(String str, Map<String, Object> map) {
        String str2;
        if (str != null && !str.equals("")) {
            ValidationResult i8 = this.f10820l.i(str);
            if (i8.a() > 0) {
                this.f10819k.b(i8);
                return;
            }
            ValidationResult h8 = this.f10820l.h(str);
            if (h8.a() > 0) {
                this.f10819k.b(h8);
                return;
            }
            if (map == null) {
                map = new HashMap<>();
            }
            JSONObject jSONObject = new JSONObject();
            try {
                ValidationResult b8 = this.f10820l.b(str);
                if (b8.a() != 0) {
                    jSONObject.put("wzrk_error", CTJsonConverter.c(b8));
                }
                String obj = b8.c().toString();
                JSONObject jSONObject2 = new JSONObject();
                for (String str3 : map.keySet()) {
                    Object obj2 = map.get(str3);
                    ValidationResult e8 = this.f10820l.e(str3);
                    String obj3 = e8.c().toString();
                    if (e8.a() != 0) {
                        jSONObject.put("wzrk_error", CTJsonConverter.c(e8));
                    }
                    try {
                        ValidationResult f8 = this.f10820l.f(obj2, Validator.ValidationContext.Event);
                        Object c8 = f8.c();
                        if (f8.a() != 0) {
                            jSONObject.put("wzrk_error", CTJsonConverter.c(f8));
                        }
                        jSONObject2.put(obj3, c8);
                    } catch (IllegalArgumentException unused) {
                        String[] strArr = new String[3];
                        strArr[0] = obj;
                        strArr[1] = obj3;
                        if (obj2 == null) {
                            str2 = "";
                        } else {
                            str2 = obj2.toString();
                        }
                        strArr[2] = str2;
                        ValidationResult b9 = ValidationResultFactory.b(512, 7, strArr);
                        this.f10813e.n().f(this.f10813e.c(), b9.b());
                        this.f10819k.b(b9);
                    }
                }
                jSONObject.put("evtName", obj);
                jSONObject.put("evtData", jSONObject2);
                this.f10811c.e(this.f10814f, jSONObject, 4);
            } catch (Throwable unused2) {
            }
        }
    }

    public void C(boolean z7, CTInAppNotification cTInAppNotification, Bundle bundle) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject f8 = CTJsonConverter.f(cTInAppNotification);
            if (bundle != null) {
                for (String str : bundle.keySet()) {
                    Object obj = bundle.get(str);
                    if (obj != null) {
                        f8.put(str, obj);
                    }
                }
            }
            if (z7) {
                try {
                    this.f10816h.Z(f8);
                } catch (Throwable unused) {
                }
                jSONObject.put("evtName", "Notification Clicked");
            } else {
                jSONObject.put("evtName", "Notification Viewed");
            }
            jSONObject.put("evtData", f8);
            this.f10811c.e(this.f10814f, jSONObject, 4);
        } catch (Throwable unused2) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void D(boolean z7, CTInboxMessage cTInboxMessage, Bundle bundle) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject g8 = CTJsonConverter.g(cTInboxMessage);
            if (bundle != null) {
                for (String str : bundle.keySet()) {
                    Object obj = bundle.get(str);
                    if (obj != null) {
                        g8.put(str, obj);
                    }
                }
            }
            if (z7) {
                try {
                    this.f10816h.Z(g8);
                } catch (Throwable unused) {
                }
                jSONObject.put("evtName", "Notification Clicked");
            } else {
                jSONObject.put("evtName", "Notification Viewed");
            }
            jSONObject.put("evtData", g8);
            this.f10811c.e(this.f10814f, jSONObject, 4);
        } catch (Throwable unused2) {
        }
    }

    public void E(String str) {
        try {
            Logger n8 = this.f10813e.n();
            String c8 = this.f10813e.c();
            n8.s(c8, "Referrer received: " + str);
            if (str == null) {
                return;
            }
            int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
            if (this.f10810b.containsKey(str) && currentTimeMillis - this.f10810b.get(str).intValue() < 10) {
                this.f10813e.n().s(this.f10813e.c(), "Skipping install referrer due to duplicate within 10 seconds");
                return;
            }
            this.f10810b.put(str, Integer.valueOf(currentTimeMillis));
            A(Uri.parse("wzrk://track?install=true&" + str), true);
        } catch (Throwable unused) {
        }
    }

    public void F(final Bundle bundle) {
        String bundle2;
        boolean z7;
        if (this.f10813e.p()) {
            this.f10813e.n().f(this.f10813e.c(), "is Analytics Only - will not process Notification Clicked event.");
        } else if (bundle != null && !bundle.isEmpty() && bundle.get("wzrk_pn") != null) {
            String str = null;
            try {
                str = bundle.getString("wzrk_acct_id");
            } catch (Throwable unused) {
            }
            if ((str == null && this.f10813e.t()) || this.f10813e.c().equals(str)) {
                z7 = true;
            } else {
                z7 = false;
            }
            if (!z7) {
                this.f10813e.n().f(this.f10813e.c(), "Push notification not targeted at this instance, not processing Notification Clicked Event");
            } else if (bundle.containsKey("wzrk_inapp")) {
                CTExecutorFactory.a(this.f10813e).c().d("testInappNotification", new Callable<Void>() { // from class: com.clevertap.android.sdk.AnalyticsManager.2
                    @Override // java.util.concurrent.Callable
                    /* renamed from: a */
                    public Void call() {
                        try {
                            Logger.n("Received in-app via push payload: " + bundle.getString("wzrk_inapp"));
                            JSONObject jSONObject = new JSONObject();
                            JSONArray jSONArray = new JSONArray();
                            jSONObject.put("inapp_notifs", jSONArray);
                            jSONArray.put(new JSONObject(bundle.getString("wzrk_inapp")));
                            new InAppResponse(new CleverTapResponseHelper(), AnalyticsManager.this.f10813e, AnalyticsManager.this.f10815g, true).a(jSONObject, null, AnalyticsManager.this.f10814f);
                        } catch (Throwable th) {
                            Logger.q("Failed to display inapp notification from push notification payload", th);
                        }
                        return null;
                    }
                });
            } else if (bundle.containsKey("wzrk_inbox")) {
                CTExecutorFactory.a(this.f10813e).c().d("testInboxNotification", new Callable<Void>() { // from class: com.clevertap.android.sdk.AnalyticsManager.3
                    @Override // java.util.concurrent.Callable
                    /* renamed from: a */
                    public Void call() {
                        try {
                            Logger.n("Received inbox via push payload: " + bundle.getString("wzrk_inbox"));
                            JSONObject jSONObject = new JSONObject();
                            JSONArray jSONArray = new JSONArray();
                            jSONObject.put("inbox_notifs", jSONArray);
                            JSONObject jSONObject2 = new JSONObject(bundle.getString("wzrk_inbox"));
                            jSONObject2.put("_id", String.valueOf(System.currentTimeMillis() / 1000));
                            jSONArray.put(jSONObject2);
                            new InboxResponse(new CleverTapResponseHelper(), AnalyticsManager.this.f10813e, AnalyticsManager.this.f10809a, AnalyticsManager.this.f10812d, AnalyticsManager.this.f10815g).a(jSONObject, null, AnalyticsManager.this.f10814f);
                        } catch (Throwable th) {
                            Logger.q("Failed to process inbox message from push notification payload", th);
                        }
                        return null;
                    }
                });
            } else if (bundle.containsKey("wzrk_adunit")) {
                x(bundle);
            } else if (bundle.containsKey("wzrk_id") && bundle.getString("wzrk_id") != null) {
                if (v(bundle, this.f10821m, 5000)) {
                    Logger n8 = this.f10813e.n();
                    String c8 = this.f10813e.c();
                    n8.f(c8, "Already processed Notification Clicked event for " + bundle.toString() + ", dropping duplicate.");
                    return;
                }
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                try {
                    for (String str2 : bundle.keySet()) {
                        if (str2.startsWith("wzrk_")) {
                            jSONObject2.put(str2, bundle.get(str2));
                        }
                    }
                    jSONObject.put("evtName", "Notification Clicked");
                    jSONObject.put("evtData", jSONObject2);
                    this.f10811c.e(this.f10814f, jSONObject, 4);
                    this.f10816h.Z(CTJsonConverter.e(bundle));
                } catch (Throwable unused2) {
                }
                if (this.f10812d.k() != null) {
                    this.f10812d.k().a(Utils.d(bundle));
                } else {
                    Logger.a("CTPushNotificationListener is not set");
                }
            } else {
                Logger n9 = this.f10813e.n();
                String c9 = this.f10813e.c();
                n9.f(c9, "Push notification ID Tag is null, not processing Notification Clicked event for:  " + bundle.toString());
            }
        } else {
            Logger n10 = this.f10813e.n();
            String c10 = this.f10813e.c();
            StringBuilder sb = new StringBuilder();
            sb.append("Push notification: ");
            if (bundle == null) {
                bundle2 = "NULL";
            } else {
                bundle2 = bundle.toString();
            }
            sb.append(bundle2);
            sb.append(" not from CleverTap - will not process Notification Clicked event.");
            n10.f(c10, sb.toString());
        }
    }

    public void G(Bundle bundle) {
        String bundle2;
        if (bundle != null && !bundle.isEmpty() && bundle.get("wzrk_pn") != null) {
            if (bundle.containsKey("wzrk_id") && bundle.getString("wzrk_id") != null) {
                if (v(bundle, this.f10823o, CredentialsApi.CREDENTIAL_PICKER_REQUEST_CODE)) {
                    Logger n8 = this.f10813e.n();
                    String c8 = this.f10813e.c();
                    n8.f(c8, "Already processed Notification Viewed event for " + bundle.toString() + ", dropping duplicate.");
                    return;
                }
                Logger n9 = this.f10813e.n();
                n9.e("Recording Notification Viewed event for notification:  " + bundle.toString());
                JSONObject jSONObject = new JSONObject();
                try {
                    JSONObject e8 = CTJsonConverter.e(bundle);
                    jSONObject.put("evtName", "Notification Viewed");
                    jSONObject.put("evtData", e8);
                } catch (Throwable unused) {
                }
                this.f10811c.e(this.f10814f, jSONObject, 6);
                return;
            }
            Logger n10 = this.f10813e.n();
            String c9 = this.f10813e.c();
            n10.f(c9, "Push notification ID Tag is null, not processing Notification Viewed event for:  " + bundle.toString());
            return;
        }
        Logger n11 = this.f10813e.n();
        String c10 = this.f10813e.c();
        StringBuilder sb = new StringBuilder();
        sb.append("Push notification: ");
        if (bundle == null) {
            bundle2 = "NULL";
        } else {
            bundle2 = bundle.toString();
        }
        sb.append(bundle2);
        sb.append(" not from CleverTap - will not process Notification Viewed event.");
        n11.f(c10, sb.toString());
    }

    public void H(final Map<String, Object> map) {
        if (map != null && !map.isEmpty()) {
            CTExecutorFactory.a(this.f10813e).c().d("profilePush", new Callable<Void>() { // from class: com.clevertap.android.sdk.AnalyticsManager.4
                @Override // java.util.concurrent.Callable
                /* renamed from: a */
                public Void call() {
                    AnalyticsManager.this.h(map);
                    return null;
                }
            });
        }
    }

    void I(JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = new JSONObject();
            if (jSONObject != null && jSONObject.length() > 0) {
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    try {
                        String next = keys.next();
                        jSONObject2.put(next, jSONObject.getString(next));
                    } catch (ClassCastException unused) {
                    }
                }
            }
            this.f10811c.e(this.f10814f, jSONObject2, 1);
        } catch (Throwable unused2) {
        }
    }

    public void J(final String str, final ArrayList<String> arrayList) {
        CTExecutorFactory.a(this.f10813e).c().d("removeMultiValuesForKey", new Callable<Void>() { // from class: com.clevertap.android.sdk.AnalyticsManager.5
            @Override // java.util.concurrent.Callable
            /* renamed from: a */
            public Void call() {
                AnalyticsManager.this.g(arrayList, str, "$remove");
                return null;
            }
        });
    }

    public void K(final String str) {
        CTExecutorFactory.a(this.f10813e).c().d("removeValueForKey", new Callable<Void>() { // from class: com.clevertap.android.sdk.AnalyticsManager.6
            @Override // java.util.concurrent.Callable
            /* renamed from: a */
            public Void call() {
                AnalyticsManager.this.i(str);
                return null;
            }
        });
    }

    public void L(JSONObject jSONObject) {
        this.f10811c.e(this.f10814f, jSONObject, 5);
    }

    public void M(JSONObject jSONObject) {
        this.f10811c.e(this.f10814f, jSONObject, 7);
    }

    public void N(JSONObject jSONObject) {
        this.f10811c.e(this.f10814f, jSONObject, 2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void O(final String str, final ArrayList<String> arrayList) {
        CTExecutorFactory.a(this.f10813e).c().d("setMultiValuesForKey", new Callable<Void>() { // from class: com.clevertap.android.sdk.AnalyticsManager.7
            @Override // java.util.concurrent.Callable
            /* renamed from: a */
            public Void call() {
                AnalyticsManager.this.g(arrayList, str, "$set");
                return null;
            }
        });
    }

    @Override // com.clevertap.android.sdk.BaseAnalyticsManager
    public void a() {
        if (this.f10813e.p()) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("t", 1);
            jSONObject.put("evtName", "wzrk_fetch");
            jSONObject.put("evtData", jSONObject2);
        } catch (JSONException e8) {
            e8.printStackTrace();
        }
        M(jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(String str) {
        ValidationResult b8 = ValidationResultFactory.b(512, 1, str);
        this.f10819k.b(b8);
        this.f10813e.n().f(this.f10813e.c(), b8.b());
    }

    public void u(final String str, final ArrayList<String> arrayList) {
        CTExecutorFactory.a(this.f10813e).c().d("addMultiValuesForKey", new Callable<Void>() { // from class: com.clevertap.android.sdk.AnalyticsManager.1
            @Override // java.util.concurrent.Callable
            /* renamed from: a */
            public Void call() {
                String str2;
                if (AnalyticsManager.this.f10818j.w(str) != null) {
                    str2 = "$add";
                } else {
                    str2 = "$set";
                }
                AnalyticsManager.this.g(arrayList, str, str2);
                return null;
            }
        });
    }

    public void w() {
        this.f10816h.I(false);
        y();
    }

    public void y() {
        if (this.f10813e.u()) {
            this.f10816h.I(true);
            this.f10813e.n().f(this.f10813e.c(), "App Launched Events disabled in the Android Manifest file");
        } else if (this.f10816h.w()) {
            this.f10813e.n().s(this.f10813e.c(), "App Launched has already been triggered. Will not trigger it ");
        } else {
            this.f10813e.n().s(this.f10813e.c(), "Firing App Launched event");
            this.f10816h.I(true);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("evtName", "App Launched");
                jSONObject.put("evtData", this.f10817i.o());
            } catch (Throwable unused) {
            }
            this.f10811c.e(this.f10814f, jSONObject, 4);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void z(HashMap<String, Object> hashMap, ArrayList<HashMap<String, Object>> arrayList) {
        Iterator<String> it;
        int i8;
        String str;
        if (hashMap != null && arrayList != null) {
            if (arrayList.size() > 50) {
                ValidationResult a8 = ValidationResultFactory.a(522);
                this.f10813e.n().f(this.f10813e.c(), a8.b());
                this.f10819k.b(a8);
            }
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            try {
                it = hashMap.keySet().iterator();
            } catch (Throwable unused) {
                return;
            }
            while (true) {
                String str2 = "";
                i8 = 2;
                if (!it.hasNext()) {
                    break;
                }
                String next = it.next();
                Object obj = hashMap.get(next);
                ValidationResult e8 = this.f10820l.e(next);
                String obj2 = e8.c().toString();
                if (e8.a() != 0) {
                    jSONObject2.put("wzrk_error", CTJsonConverter.c(e8));
                }
                try {
                    ValidationResult f8 = this.f10820l.f(obj, Validator.ValidationContext.Event);
                    Object c8 = f8.c();
                    if (f8.a() != 0) {
                        jSONObject2.put("wzrk_error", CTJsonConverter.c(f8));
                    }
                    jSONObject.put(obj2, c8);
                } catch (IllegalArgumentException unused2) {
                    String[] strArr = new String[3];
                    strArr[0] = "Charged";
                    strArr[1] = obj2;
                    if (obj != null) {
                        str2 = obj.toString();
                    }
                    strArr[2] = str2;
                    ValidationResult b8 = ValidationResultFactory.b(511, 7, strArr);
                    this.f10819k.b(b8);
                    this.f10813e.n().f(this.f10813e.c(), b8.b());
                }
                return;
            }
            JSONArray jSONArray = new JSONArray();
            Iterator<HashMap<String, Object>> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                HashMap<String, Object> next2 = it2.next();
                JSONObject jSONObject3 = new JSONObject();
                for (String str3 : next2.keySet()) {
                    Object obj3 = next2.get(str3);
                    ValidationResult e9 = this.f10820l.e(str3);
                    String obj4 = e9.c().toString();
                    if (e9.a() != 0) {
                        jSONObject2.put("wzrk_error", CTJsonConverter.c(e9));
                    }
                    try {
                        ValidationResult f9 = this.f10820l.f(obj3, Validator.ValidationContext.Event);
                        Object c9 = f9.c();
                        if (f9.a() != 0) {
                            jSONObject2.put("wzrk_error", CTJsonConverter.c(f9));
                        }
                        jSONObject3.put(obj4, c9);
                    } catch (IllegalArgumentException unused3) {
                        String[] strArr2 = new String[i8];
                        strArr2[0] = obj4;
                        if (obj3 == null) {
                            str = "";
                        } else {
                            str = obj3.toString();
                        }
                        strArr2[1] = str;
                        ValidationResult b9 = ValidationResultFactory.b(511, 15, strArr2);
                        this.f10813e.n().f(this.f10813e.c(), b9.b());
                        this.f10819k.b(b9);
                        i8 = 2;
                    }
                }
                jSONArray.put(jSONObject3);
                i8 = 2;
            }
            jSONObject.put("Items", jSONArray);
            jSONObject2.put("evtName", "Charged");
            jSONObject2.put("evtData", jSONObject);
            this.f10811c.e(this.f10814f, jSONObject2, 4);
            return;
        }
        this.f10813e.n().f(this.f10813e.c(), "Invalid Charged event: details and or items is null");
    }
}
