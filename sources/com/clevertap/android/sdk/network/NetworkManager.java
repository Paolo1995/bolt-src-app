package com.clevertap.android.sdk.network;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.clevertap.android.sdk.BaseCallbackManager;
import com.clevertap.android.sdk.CTLockManager;
import com.clevertap.android.sdk.CleverTapInstanceConfig;
import com.clevertap.android.sdk.ControllerManager;
import com.clevertap.android.sdk.CoreMetaData;
import com.clevertap.android.sdk.DeviceInfo;
import com.clevertap.android.sdk.LocalDataStore;
import com.clevertap.android.sdk.Logger;
import com.clevertap.android.sdk.StorageHelper;
import com.clevertap.android.sdk.db.BaseDatabaseManager;
import com.clevertap.android.sdk.db.QueueCursor;
import com.clevertap.android.sdk.events.EventGroup;
import com.clevertap.android.sdk.response.ARPResponse;
import com.clevertap.android.sdk.response.BaseResponse;
import com.clevertap.android.sdk.response.CleverTapResponse;
import com.clevertap.android.sdk.response.CleverTapResponseHelper;
import com.clevertap.android.sdk.response.ConsoleResponse;
import com.clevertap.android.sdk.response.DisplayUnitResponse;
import com.clevertap.android.sdk.response.FeatureFlagResponse;
import com.clevertap.android.sdk.response.GeofenceResponse;
import com.clevertap.android.sdk.response.InAppResponse;
import com.clevertap.android.sdk.response.InboxResponse;
import com.clevertap.android.sdk.response.MetadataResponse;
import com.clevertap.android.sdk.response.ProductConfigResponse;
import com.clevertap.android.sdk.response.PushAmpResponse;
import com.clevertap.android.sdk.task.CTExecutorFactory;
import com.clevertap.android.sdk.validation.ValidationResultStack;
import com.clevertap.android.sdk.validation.Validator;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.security.SecureRandom;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Callable;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class NetworkManager extends BaseNetworkManager {

    /* renamed from: n  reason: collision with root package name */
    private static SSLSocketFactory f11627n;

    /* renamed from: o  reason: collision with root package name */
    private static SSLContext f11628o;

    /* renamed from: a  reason: collision with root package name */
    private final BaseCallbackManager f11629a;

    /* renamed from: b  reason: collision with root package name */
    private CleverTapResponse f11630b;

    /* renamed from: c  reason: collision with root package name */
    private final CleverTapInstanceConfig f11631c;

    /* renamed from: d  reason: collision with root package name */
    private final Context f11632d;

    /* renamed from: e  reason: collision with root package name */
    private final ControllerManager f11633e;

    /* renamed from: f  reason: collision with root package name */
    private final CoreMetaData f11634f;

    /* renamed from: h  reason: collision with root package name */
    private final BaseDatabaseManager f11636h;

    /* renamed from: i  reason: collision with root package name */
    private final DeviceInfo f11637i;

    /* renamed from: j  reason: collision with root package name */
    private final Logger f11638j;

    /* renamed from: l  reason: collision with root package name */
    private final ValidationResultStack f11640l;

    /* renamed from: g  reason: collision with root package name */
    private int f11635g = 0;

    /* renamed from: k  reason: collision with root package name */
    private int f11639k = 0;

    /* renamed from: m  reason: collision with root package name */
    private int f11641m = 0;

    public NetworkManager(Context context, CleverTapInstanceConfig cleverTapInstanceConfig, DeviceInfo deviceInfo, CoreMetaData coreMetaData, ValidationResultStack validationResultStack, ControllerManager controllerManager, BaseDatabaseManager baseDatabaseManager, BaseCallbackManager baseCallbackManager, CTLockManager cTLockManager, Validator validator, LocalDataStore localDataStore) {
        this.f11632d = context;
        this.f11631c = cleverTapInstanceConfig;
        this.f11637i = deviceInfo;
        this.f11629a = baseCallbackManager;
        this.f11638j = cleverTapInstanceConfig.n();
        this.f11634f = coreMetaData;
        this.f11640l = validationResultStack;
        this.f11633e = controllerManager;
        this.f11636h = baseDatabaseManager;
        C(new BaseResponse(context, cleverTapInstanceConfig, deviceInfo, this, localDataStore, new InAppResponse(new MetadataResponse(new ARPResponse(new ConsoleResponse(new InboxResponse(new PushAmpResponse(new DisplayUnitResponse(new FeatureFlagResponse(new ProductConfigResponse(new GeofenceResponse(new CleverTapResponseHelper(), cleverTapInstanceConfig, baseCallbackManager), cleverTapInstanceConfig, coreMetaData, controllerManager), cleverTapInstanceConfig, controllerManager), cleverTapInstanceConfig, baseCallbackManager, controllerManager), context, cleverTapInstanceConfig, baseDatabaseManager, baseCallbackManager, controllerManager), cleverTapInstanceConfig, cTLockManager, baseCallbackManager, controllerManager), cleverTapInstanceConfig), cleverTapInstanceConfig, this, validator, controllerManager), cleverTapInstanceConfig, deviceInfo, this), cleverTapInstanceConfig, controllerManager, false)));
    }

    private void I(final Context context, boolean z7) {
        if (z7) {
            StorageHelper.n(context, StorageHelper.s(this.f11631c, "comms_mtd"), (int) (System.currentTimeMillis() / 1000));
            D(context, null);
            CTExecutorFactory.a(this.f11631c).c().d("CommsManager#setMuted", new Callable<Void>() { // from class: com.clevertap.android.sdk.network.NetworkManager.1
                @Override // java.util.concurrent.Callable
                /* renamed from: a */
                public Void call() {
                    NetworkManager.this.f11636h.a(context);
                    return null;
                }
            });
            return;
        }
        StorageHelper.n(context, StorageHelper.s(this.f11631c, "comms_mtd"), 0);
    }

    private JSONObject g() {
        SharedPreferences y7;
        try {
            String r7 = r();
            if (r7 == null) {
                return null;
            }
            if (!StorageHelper.h(this.f11632d, r7).getAll().isEmpty()) {
                y7 = StorageHelper.h(this.f11632d, r7);
            } else {
                y7 = y(r7, q());
            }
            Map<String, ?> all = y7.getAll();
            Iterator<Map.Entry<String, ?>> it = all.entrySet().iterator();
            while (it.hasNext()) {
                Object value = it.next().getValue();
                if ((value instanceof Number) && ((Number) value).intValue() == -1) {
                    it.remove();
                }
            }
            JSONObject jSONObject = new JSONObject(all);
            Logger logger = this.f11638j;
            String c8 = this.f11631c.c();
            logger.s(c8, "Fetched ARP for namespace key: " + r7 + " values: " + all.toString());
            return jSONObject;
        } catch (Throwable th) {
            this.f11638j.t(this.f11631c.c(), "Failed to construct ARP object", th);
            return null;
        }
    }

    private long n() {
        return StorageHelper.f(this.f11632d, this.f11631c, "comms_i", 0, "IJ");
    }

    private long o() {
        return StorageHelper.f(this.f11632d, this.f11631c, "comms_j", 0, "IJ");
    }

    private String q() {
        String c8 = this.f11631c.c();
        if (c8 == null) {
            return null;
        }
        Logger logger = this.f11638j;
        String c9 = this.f11631c.c();
        logger.s(c9, "Old ARP Key = ARP:" + c8);
        return "ARP:" + c8;
    }

    private static SSLSocketFactory s(SSLContext sSLContext) {
        if (sSLContext == null) {
            return null;
        }
        if (f11627n == null) {
            try {
                f11627n = sSLContext.getSocketFactory();
                Logger.a("Pinning SSL session to DigiCertGlobalRoot CA certificate");
            } catch (Throwable th) {
                Logger.d("Issue in pinning SSL,", th);
            }
        }
        return f11627n;
    }

    private static synchronized SSLContext t() {
        SSLContext sSLContext;
        synchronized (NetworkManager.class) {
            if (f11628o == null) {
                f11628o = new SSLContextBuilder().a();
            }
            sSLContext = f11628o;
        }
        return sSLContext;
    }

    public static boolean x(Context context) {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                return true;
            }
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                if (activeNetworkInfo.isConnected()) {
                    return true;
                }
            }
            return false;
        } catch (Throwable unused) {
            return true;
        }
    }

    private SharedPreferences y(String str, String str2) {
        SharedPreferences h8 = StorageHelper.h(this.f11632d, str2);
        SharedPreferences h9 = StorageHelper.h(this.f11632d, str);
        SharedPreferences.Editor edit = h9.edit();
        for (Map.Entry<String, ?> entry : h8.getAll().entrySet()) {
            Object value = entry.getValue();
            if (value instanceof Number) {
                edit.putInt(entry.getKey(), ((Number) value).intValue());
            } else if (value instanceof String) {
                String str3 = (String) value;
                if (str3.length() < 100) {
                    edit.putString(entry.getKey(), str3);
                } else {
                    Logger logger = this.f11638j;
                    String c8 = this.f11631c.c();
                    logger.s(c8, "ARP update for key " + entry.getKey() + " rejected (string value too long)");
                }
            } else if (value instanceof Boolean) {
                edit.putBoolean(entry.getKey(), ((Boolean) value).booleanValue());
            } else {
                Logger logger2 = this.f11638j;
                String c9 = this.f11631c.c();
                logger2.s(c9, "ARP update for key " + entry.getKey() + " rejected (invalid data type)");
            }
        }
        Logger logger3 = this.f11638j;
        String c10 = this.f11631c.c();
        logger3.s(c10, "Completed ARP update for namespace key: " + str + "");
        StorageHelper.l(edit);
        h8.edit().clear().apply();
        return h9;
    }

    boolean A(Context context, HttpsURLConnection httpsURLConnection) {
        String headerField = httpsURLConnection.getHeaderField("X-WZRK-MUTE");
        if (headerField != null && headerField.trim().length() > 0) {
            if (headerField.equals("true")) {
                I(context, true);
                return false;
            }
            I(context, false);
        }
        String headerField2 = httpsURLConnection.getHeaderField("X-WZRK-RD");
        Logger.n("Getting domain from header - " + headerField2);
        if (headerField2 != null && headerField2.trim().length() != 0) {
            String headerField3 = httpsURLConnection.getHeaderField("X-WZRK-SPIKY-RD");
            Logger.n("Getting spiky domain from header - " + headerField3);
            I(context, false);
            D(context, headerField2);
            Logger.n("Setting spiky domain from header as -" + headerField3);
            if (headerField3 == null) {
                K(context, headerField2);
            } else {
                K(context, headerField3);
            }
        }
        return true;
    }

    boolean B(Context context, EventGroup eventGroup, JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() <= 0) {
            return false;
        }
        if (this.f11637i.x() == null) {
            this.f11638j.f(this.f11631c.c(), "CleverTap Id not finalized, unable to send queue");
            return false;
        }
        HttpsURLConnection httpsURLConnection = null;
        try {
            String l8 = l(false, eventGroup);
            if (l8 == null) {
                this.f11638j.f(this.f11631c.c(), "Problem configuring queue endpoint, unable to send queue");
                return false;
            }
            HttpsURLConnection f8 = f(l8);
            try {
                String w7 = w(context, jSONArray);
                if (w7 == null) {
                    this.f11638j.f(this.f11631c.c(), "Problem configuring queue request, unable to send queue");
                    if (f8 != null) {
                        try {
                            f8.getInputStream().close();
                            f8.disconnect();
                        } catch (Throwable unused) {
                        }
                    }
                    return false;
                }
                this.f11638j.f(this.f11631c.c(), "Send queue contains " + jSONArray.length() + " items: " + w7);
                this.f11638j.f(this.f11631c.c(), "Sending queue to: " + l8);
                f8.setDoOutput(true);
                f8.getOutputStream().write(w7.getBytes("UTF-8"));
                int responseCode = f8.getResponseCode();
                if (responseCode == 200) {
                    String headerField = f8.getHeaderField("X-WZRK-RD");
                    if (headerField != null && headerField.trim().length() > 0 && u(headerField)) {
                        D(context, headerField);
                        this.f11638j.f(this.f11631c.c(), "The domain has changed to " + headerField + ". The request will be retried shortly.");
                        try {
                            f8.getInputStream().close();
                            f8.disconnect();
                        } catch (Throwable unused2) {
                        }
                        return false;
                    }
                    if (A(context, f8)) {
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(f8.getInputStream(), "utf-8"));
                        StringBuilder sb = new StringBuilder();
                        while (true) {
                            String readLine = bufferedReader.readLine();
                            if (readLine == null) {
                                break;
                            }
                            sb.append(readLine);
                        }
                        h().a(null, sb.toString(), this.f11632d);
                    }
                    H(i());
                    E(i());
                    this.f11638j.f(this.f11631c.c(), "Queue sent successfully");
                    this.f11641m = 0;
                    this.f11639k = 0;
                    try {
                        f8.getInputStream().close();
                        f8.disconnect();
                    } catch (Throwable unused3) {
                    }
                    return true;
                }
                throw new IOException("Response code is not 200. It is " + responseCode);
            } catch (Throwable th) {
                th = th;
                httpsURLConnection = f8;
                try {
                    this.f11638j.g(this.f11631c.c(), "An exception occurred while sending the queue, will retry: ", th);
                    this.f11641m++;
                    this.f11639k++;
                    this.f11629a.c().a(context);
                    if (httpsURLConnection != null) {
                        try {
                            httpsURLConnection.getInputStream().close();
                            httpsURLConnection.disconnect();
                        } catch (Throwable unused4) {
                        }
                    }
                    return false;
                } catch (Throwable th2) {
                    if (httpsURLConnection != null) {
                        try {
                            httpsURLConnection.getInputStream().close();
                            httpsURLConnection.disconnect();
                        } catch (Throwable unused5) {
                        }
                    }
                    throw th2;
                }
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    void C(CleverTapResponse cleverTapResponse) {
        this.f11630b = cleverTapResponse;
    }

    void D(Context context, String str) {
        Logger logger = this.f11638j;
        String c8 = this.f11631c.c();
        logger.s(c8, "Setting domain to " + str);
        StorageHelper.p(context, StorageHelper.s(this.f11631c, "comms_dmn"), str);
    }

    void E(int i8) {
        if (m() > 0) {
            return;
        }
        StorageHelper.n(this.f11632d, StorageHelper.s(this.f11631c, "comms_first_ts"), i8);
    }

    @SuppressLint({"CommitPrefEdits"})
    public void F(Context context, long j8) {
        SharedPreferences.Editor edit = StorageHelper.h(context, "IJ").edit();
        edit.putLong(StorageHelper.s(this.f11631c, "comms_i"), j8);
        StorageHelper.l(edit);
    }

    @SuppressLint({"CommitPrefEdits"})
    public void G(Context context, long j8) {
        SharedPreferences.Editor edit = StorageHelper.h(context, "IJ").edit();
        edit.putLong(StorageHelper.s(this.f11631c, "comms_j"), j8);
        StorageHelper.l(edit);
    }

    void H(int i8) {
        StorageHelper.n(this.f11632d, StorageHelper.s(this.f11631c, "comms_last_ts"), i8);
    }

    void J(int i8) {
        this.f11641m = i8;
    }

    void K(Context context, String str) {
        Logger logger = this.f11638j;
        String c8 = this.f11631c.c();
        logger.s(c8, "Setting spiky domain to " + str);
        StorageHelper.p(context, StorageHelper.s(this.f11631c, "comms_dmn_spiky"), str);
    }

    @Override // com.clevertap.android.sdk.network.BaseNetworkManager
    public void a(Context context, EventGroup eventGroup) {
        this.f11631c.n().s(this.f11631c.c(), "Somebody has invoked me to send the queue to CleverTap servers");
        QueueCursor queueCursor = null;
        boolean z7 = true;
        while (z7) {
            queueCursor = this.f11636h.b(context, 50, queueCursor, eventGroup);
            if (queueCursor != null && !queueCursor.d().booleanValue()) {
                JSONArray a8 = queueCursor.a();
                if (a8 != null && a8.length() > 0) {
                    z7 = B(context, eventGroup, a8);
                } else {
                    this.f11631c.n().s(this.f11631c.c(), "No events in the queue, failing");
                    return;
                }
            } else {
                this.f11631c.n().s(this.f11631c.c(), "No events in the queue, failing");
                return;
            }
        }
    }

    @Override // com.clevertap.android.sdk.network.BaseNetworkManager
    public int b() {
        Logger logger = this.f11638j;
        String c8 = this.f11631c.c();
        logger.f(c8, "Network retry #" + this.f11639k);
        if (this.f11639k < 10) {
            Logger logger2 = this.f11638j;
            String c9 = this.f11631c.c();
            logger2.f(c9, "Failure count is " + this.f11639k + ". Setting delay frequency to 1s");
            return 1000;
        } else if (this.f11631c.d() == null) {
            this.f11638j.f(this.f11631c.c(), "Setting delay frequency to 1s");
            return 1000;
        } else {
            int nextInt = ((new SecureRandom().nextInt(10) + 1) * 1000) + 0;
            if (nextInt < 600000) {
                Logger logger3 = this.f11638j;
                String c10 = this.f11631c.c();
                logger3.f(c10, "Setting delay frequency to " + nextInt);
                return nextInt;
            }
            Logger logger4 = this.f11638j;
            String c11 = this.f11631c.c();
            logger4.f(c11, "Setting delay frequency to 1000");
            return 1000;
        }
    }

    @Override // com.clevertap.android.sdk.network.BaseNetworkManager
    public void c(EventGroup eventGroup, Runnable runnable) {
        this.f11641m = 0;
        D(this.f11632d, null);
        z(this.f11632d, eventGroup, runnable);
    }

    @Override // com.clevertap.android.sdk.network.BaseNetworkManager
    public boolean d(EventGroup eventGroup) {
        if (k(eventGroup) != null && this.f11641m <= 5) {
            return false;
        }
        return true;
    }

    HttpsURLConnection f(String str) throws IOException {
        SSLContext t7;
        HttpsURLConnection httpsURLConnection = (HttpsURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(new URL(str).openConnection()));
        httpsURLConnection.setConnectTimeout(10000);
        httpsURLConnection.setReadTimeout(10000);
        httpsURLConnection.setRequestProperty("Content-Type", "application/json; charset=utf-8");
        httpsURLConnection.setRequestProperty("X-CleverTap-Account-ID", this.f11631c.c());
        httpsURLConnection.setRequestProperty("X-CleverTap-Token", this.f11631c.e());
        httpsURLConnection.setInstanceFollowRedirects(false);
        if (this.f11631c.x() && (t7 = t()) != null) {
            httpsURLConnection.setSSLSocketFactory(s(t7));
        }
        return httpsURLConnection;
    }

    CleverTapResponse h() {
        return this.f11630b;
    }

    int i() {
        return this.f11635g;
    }

    String j(boolean z7, EventGroup eventGroup) {
        boolean z8;
        String k8 = k(eventGroup);
        if (k8 != null && k8.trim().length() != 0) {
            z8 = false;
        } else {
            z8 = true;
        }
        if (z8 && !z7) {
            return null;
        }
        if (z8) {
            return "wzrkt.com/hello";
        }
        return k8 + "/a1";
    }

    String k(EventGroup eventGroup) {
        try {
            String d8 = this.f11631c.d();
            if (d8 != null && d8.trim().length() > 0) {
                J(0);
                if (eventGroup.equals(EventGroup.PUSH_NOTIFICATION_VIEWED)) {
                    return d8.trim().toLowerCase() + eventGroup.f11167f + ".wzrkt.com";
                }
                return d8.trim().toLowerCase() + ".wzrkt.com";
            }
        } catch (Throwable unused) {
        }
        if (eventGroup.equals(EventGroup.PUSH_NOTIFICATION_VIEWED)) {
            return StorageHelper.k(this.f11632d, this.f11631c, "comms_dmn_spiky", null);
        }
        return StorageHelper.k(this.f11632d, this.f11631c, "comms_dmn", null);
    }

    String l(boolean z7, EventGroup eventGroup) {
        String j8 = j(z7, eventGroup);
        if (j8 == null) {
            this.f11638j.s(this.f11631c.c(), "Unable to configure endpoint, domain is null");
            return null;
        }
        String c8 = this.f11631c.c();
        if (c8 == null) {
            this.f11638j.s(this.f11631c.c(), "Unable to configure endpoint, accountID is null");
            return null;
        }
        String str = ("https://" + j8 + "?os=Android&t=" + this.f11637i.L()) + "&z=" + c8;
        if (d(eventGroup)) {
            return str;
        }
        this.f11635g = (int) (System.currentTimeMillis() / 1000);
        return str + "&ts=" + i();
    }

    int m() {
        return StorageHelper.d(this.f11632d, this.f11631c, "comms_first_ts", 0);
    }

    int p() {
        return StorageHelper.d(this.f11632d, this.f11631c, "comms_last_ts", 0);
    }

    public String r() {
        String c8 = this.f11631c.c();
        if (c8 == null) {
            return null;
        }
        Logger logger = this.f11638j;
        String c9 = this.f11631c.c();
        logger.s(c9, "New ARP Key = ARP:" + c8 + ":" + this.f11637i.x());
        return "ARP:" + c8 + ":" + this.f11637i.x();
    }

    boolean u(String str) {
        return !str.equals(StorageHelper.k(this.f11632d, this.f11631c, "comms_dmn", null));
    }

    public void v() {
        this.f11641m++;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x00c4 A[Catch: all -> 0x01df, TryCatch #2 {all -> 0x01df, blocks: (B:2:0x0000, B:4:0x000d, B:6:0x0015, B:8:0x0028, B:10:0x0044, B:11:0x0049, B:13:0x0051, B:14:0x0056, B:18:0x0068, B:20:0x00a9, B:25:0x00b9, B:27:0x00c4, B:28:0x00ce, B:30:0x00e7, B:31:0x00fd, B:40:0x012d, B:56:0x0173, B:58:0x017b, B:60:0x0181, B:61:0x0186, B:63:0x018e, B:65:0x01aa, B:64:0x019d, B:67:0x01d0, B:7:0x001b, B:41:0x0132, B:43:0x013a, B:44:0x013f, B:46:0x0147, B:47:0x014c, B:49:0x0154, B:50:0x0159, B:52:0x015f, B:32:0x010d, B:34:0x0113, B:36:0x0119), top: B:73:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00e7 A[Catch: all -> 0x01df, TryCatch #2 {all -> 0x01df, blocks: (B:2:0x0000, B:4:0x000d, B:6:0x0015, B:8:0x0028, B:10:0x0044, B:11:0x0049, B:13:0x0051, B:14:0x0056, B:18:0x0068, B:20:0x00a9, B:25:0x00b9, B:27:0x00c4, B:28:0x00ce, B:30:0x00e7, B:31:0x00fd, B:40:0x012d, B:56:0x0173, B:58:0x017b, B:60:0x0181, B:61:0x0186, B:63:0x018e, B:65:0x01aa, B:64:0x019d, B:67:0x01d0, B:7:0x001b, B:41:0x0132, B:43:0x013a, B:44:0x013f, B:46:0x0147, B:47:0x014c, B:49:0x0154, B:50:0x0159, B:52:0x015f, B:32:0x010d, B:34:0x0113, B:36:0x0119), top: B:73:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x013a A[Catch: all -> 0x0165, TryCatch #2 {all -> 0x01df, blocks: (B:2:0x0000, B:4:0x000d, B:6:0x0015, B:8:0x0028, B:10:0x0044, B:11:0x0049, B:13:0x0051, B:14:0x0056, B:18:0x0068, B:20:0x00a9, B:25:0x00b9, B:27:0x00c4, B:28:0x00ce, B:30:0x00e7, B:31:0x00fd, B:40:0x012d, B:56:0x0173, B:58:0x017b, B:60:0x0181, B:61:0x0186, B:63:0x018e, B:65:0x01aa, B:64:0x019d, B:67:0x01d0, B:7:0x001b, B:41:0x0132, B:43:0x013a, B:44:0x013f, B:46:0x0147, B:47:0x014c, B:49:0x0154, B:50:0x0159, B:52:0x015f, B:32:0x010d, B:34:0x0113, B:36:0x0119), top: B:73:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0147 A[Catch: all -> 0x0165, TryCatch #2 {all -> 0x01df, blocks: (B:2:0x0000, B:4:0x000d, B:6:0x0015, B:8:0x0028, B:10:0x0044, B:11:0x0049, B:13:0x0051, B:14:0x0056, B:18:0x0068, B:20:0x00a9, B:25:0x00b9, B:27:0x00c4, B:28:0x00ce, B:30:0x00e7, B:31:0x00fd, B:40:0x012d, B:56:0x0173, B:58:0x017b, B:60:0x0181, B:61:0x0186, B:63:0x018e, B:65:0x01aa, B:64:0x019d, B:67:0x01d0, B:7:0x001b, B:41:0x0132, B:43:0x013a, B:44:0x013f, B:46:0x0147, B:47:0x014c, B:49:0x0154, B:50:0x0159, B:52:0x015f, B:32:0x010d, B:34:0x0113, B:36:0x0119), top: B:73:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0154 A[Catch: all -> 0x0165, TryCatch #2 {all -> 0x01df, blocks: (B:2:0x0000, B:4:0x000d, B:6:0x0015, B:8:0x0028, B:10:0x0044, B:11:0x0049, B:13:0x0051, B:14:0x0056, B:18:0x0068, B:20:0x00a9, B:25:0x00b9, B:27:0x00c4, B:28:0x00ce, B:30:0x00e7, B:31:0x00fd, B:40:0x012d, B:56:0x0173, B:58:0x017b, B:60:0x0181, B:61:0x0186, B:63:0x018e, B:65:0x01aa, B:64:0x019d, B:67:0x01d0, B:7:0x001b, B:41:0x0132, B:43:0x013a, B:44:0x013f, B:46:0x0147, B:47:0x014c, B:49:0x0154, B:50:0x0159, B:52:0x015f, B:32:0x010d, B:34:0x0113, B:36:0x0119), top: B:73:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x015f A[Catch: all -> 0x0165, TRY_LEAVE, TryCatch #2 {all -> 0x01df, blocks: (B:2:0x0000, B:4:0x000d, B:6:0x0015, B:8:0x0028, B:10:0x0044, B:11:0x0049, B:13:0x0051, B:14:0x0056, B:18:0x0068, B:20:0x00a9, B:25:0x00b9, B:27:0x00c4, B:28:0x00ce, B:30:0x00e7, B:31:0x00fd, B:40:0x012d, B:56:0x0173, B:58:0x017b, B:60:0x0181, B:61:0x0186, B:63:0x018e, B:65:0x01aa, B:64:0x019d, B:67:0x01d0, B:7:0x001b, B:41:0x0132, B:43:0x013a, B:44:0x013f, B:46:0x0147, B:47:0x014c, B:49:0x0154, B:50:0x0159, B:52:0x015f, B:32:0x010d, B:34:0x0113, B:36:0x0119), top: B:73:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x018e A[Catch: all -> 0x01df, TryCatch #2 {all -> 0x01df, blocks: (B:2:0x0000, B:4:0x000d, B:6:0x0015, B:8:0x0028, B:10:0x0044, B:11:0x0049, B:13:0x0051, B:14:0x0056, B:18:0x0068, B:20:0x00a9, B:25:0x00b9, B:27:0x00c4, B:28:0x00ce, B:30:0x00e7, B:31:0x00fd, B:40:0x012d, B:56:0x0173, B:58:0x017b, B:60:0x0181, B:61:0x0186, B:63:0x018e, B:65:0x01aa, B:64:0x019d, B:67:0x01d0, B:7:0x001b, B:41:0x0132, B:43:0x013a, B:44:0x013f, B:46:0x0147, B:47:0x014c, B:49:0x0154, B:50:0x0159, B:52:0x015f, B:32:0x010d, B:34:0x0113, B:36:0x0119), top: B:73:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x019d A[Catch: all -> 0x01df, TryCatch #2 {all -> 0x01df, blocks: (B:2:0x0000, B:4:0x000d, B:6:0x0015, B:8:0x0028, B:10:0x0044, B:11:0x0049, B:13:0x0051, B:14:0x0056, B:18:0x0068, B:20:0x00a9, B:25:0x00b9, B:27:0x00c4, B:28:0x00ce, B:30:0x00e7, B:31:0x00fd, B:40:0x012d, B:56:0x0173, B:58:0x017b, B:60:0x0181, B:61:0x0186, B:63:0x018e, B:65:0x01aa, B:64:0x019d, B:67:0x01d0, B:7:0x001b, B:41:0x0132, B:43:0x013a, B:44:0x013f, B:46:0x0147, B:47:0x014c, B:49:0x0154, B:50:0x0159, B:52:0x015f, B:32:0x010d, B:34:0x0113, B:36:0x0119), top: B:73:0x0000 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    java.lang.String w(android.content.Context r8, org.json.JSONArray r9) {
        /*
            Method dump skipped, instructions count: 498
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.clevertap.android.sdk.network.NetworkManager.w(android.content.Context, org.json.JSONArray):java.lang.String");
    }

    void z(Context context, EventGroup eventGroup, Runnable runnable) {
        String l8 = l(true, eventGroup);
        if (l8 == null) {
            this.f11638j.s(this.f11631c.c(), "Unable to perform handshake, endpoint is null");
        }
        Logger logger = this.f11638j;
        String c8 = this.f11631c.c();
        logger.s(c8, "Performing handshake with " + l8);
        try {
            HttpsURLConnection f8 = f(l8);
            int responseCode = f8.getResponseCode();
            if (responseCode != 200) {
                Logger logger2 = this.f11638j;
                String c9 = this.f11631c.c();
                logger2.s(c9, "Invalid HTTP status code received for handshake - " + responseCode);
                try {
                    f8.getInputStream().close();
                    f8.disconnect();
                    return;
                } catch (Throwable unused) {
                    return;
                }
            }
            this.f11638j.s(this.f11631c.c(), "Received success from handshake :)");
            if (A(context, f8)) {
                this.f11638j.s(this.f11631c.c(), "We are not muted");
                runnable.run();
            }
            f8.getInputStream().close();
            f8.disconnect();
        } catch (Throwable unused2) {
        }
    }
}
