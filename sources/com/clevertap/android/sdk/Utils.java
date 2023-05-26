package com.clevertap.android.sdk;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.telephony.TelephonyManager;
import androidx.core.content.ContextCompat;
import com.google.firebase.iid.FirebaseInstanceId;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class Utils {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f11091a = a();

    /* renamed from: b  reason: collision with root package name */
    public static boolean f11092b = b();

    private static boolean a() {
        Class<?> cls = null;
        try {
            Class.forName("com.google.android.exoplayer2.SimpleExoPlayer");
            Class.forName("com.google.android.exoplayer2.source.hls.HlsMediaSource");
            cls = Class.forName("com.google.android.exoplayer2.ui.PlayerView");
            Logger.a("ExoPlayer is present");
            return true;
        } catch (Throwable unused) {
            Logger.a("ExoPlayer library files are missing!!!");
            Logger.a("Please add ExoPlayer dependencies to render InApp or Inbox messages playing video. For more information checkout CleverTap documentation.");
            if (cls != null) {
                Logger.a("ExoPlayer classes not found " + cls.getName());
            } else {
                Logger.a("ExoPlayer classes not found");
            }
            return false;
        }
    }

    private static boolean b() {
        boolean z7;
        try {
            int i8 = FirebaseInstanceId.f16281m;
            z7 = true;
            try {
                Logger.a("Firebase Instance Id is available." + FirebaseInstanceId.class);
            } catch (Throwable unused) {
                Logger.a("It looks like you're using FirebaseMessaging dependency v22.0.0.Ensure your app's version of FCM is v20.2.4");
                return z7;
            }
        } catch (Throwable unused2) {
            z7 = false;
        }
        return z7;
    }

    public static boolean c(Collection<String> collection, String str) {
        if (collection != null && str != null) {
            for (String str2 : collection) {
                if (str.equalsIgnoreCase(str2)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static HashMap<String, Object> d(Bundle bundle) {
        HashMap<String, Object> hashMap = new HashMap<>();
        for (String str : bundle.keySet()) {
            Object obj = bundle.get(str);
            if (obj instanceof Bundle) {
                hashMap.putAll(d((Bundle) obj));
            } else {
                hashMap.put(str, bundle.get(str));
            }
        }
        return hashMap;
    }

    public static ArrayList<HashMap<String, Object>> e(JSONArray jSONArray) {
        ArrayList<HashMap<String, Object>> arrayList = new ArrayList<>();
        if (jSONArray != null) {
            for (int i8 = 0; i8 < jSONArray.length(); i8++) {
                try {
                    arrayList.add(g(jSONArray.getJSONObject(i8)));
                } catch (JSONException e8) {
                    Logger.n("Could not convert JSONArray of JSONObjects to ArrayList of HashMaps - " + e8.getMessage());
                }
            }
        }
        return arrayList;
    }

    public static ArrayList<String> f(JSONArray jSONArray) {
        ArrayList<String> arrayList = new ArrayList<>();
        if (jSONArray != null) {
            for (int i8 = 0; i8 < jSONArray.length(); i8++) {
                try {
                    arrayList.add(jSONArray.getString(i8));
                } catch (JSONException e8) {
                    Logger.n("Could not convert JSONArray to ArrayList - " + e8.getMessage());
                }
            }
        }
        return arrayList;
    }

    public static HashMap<String, Object> g(JSONObject jSONObject) {
        HashMap<String, Object> hashMap = new HashMap<>();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            try {
                String next = keys.next();
                Object obj = jSONObject.get(next);
                if (obj instanceof JSONObject) {
                    hashMap.putAll(g((JSONObject) obj));
                } else {
                    hashMap.put(next, jSONObject.get(next));
                }
            } catch (Throwable unused) {
            }
        }
        return hashMap;
    }

    public static String h(String str) {
        char[] charArray;
        if (str != null && !str.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            boolean z7 = true;
            for (char c8 : str.toCharArray()) {
                if (Character.isSpaceChar(c8)) {
                    z7 = true;
                } else if (z7) {
                    c8 = Character.toTitleCase(c8);
                    z7 = false;
                } else {
                    c8 = Character.toLowerCase(c8);
                }
                sb.append(c8);
            }
            return sb.toString();
        }
        return str;
    }

    static Bitmap i(Drawable drawable) throws NullPointerException {
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        Bitmap createBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return createBitmap;
    }

    private static Bitmap j(Context context) throws NullPointerException {
        try {
            Drawable applicationLogo = context.getPackageManager().getApplicationLogo(context.getApplicationInfo());
            if (applicationLogo != null) {
                return i(applicationLogo);
            }
            throw new Exception("Logo is null");
        } catch (Exception unused) {
            return i(context.getPackageManager().getApplicationIcon(context.getApplicationInfo()));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0070 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.graphics.Bitmap k(java.lang.String r5) {
        /*
            java.lang.String r0 = "Couldn't close connection!"
            java.lang.String r1 = "///"
            java.lang.String r2 = "/"
            java.lang.String r5 = r5.replace(r1, r2)
            java.lang.String r1 = "//"
            java.lang.String r5 = r5.replace(r1, r2)
            java.lang.String r1 = "http:/"
            java.lang.String r2 = "http://"
            java.lang.String r5 = r5.replace(r1, r2)
            java.lang.String r1 = "https:/"
            java.lang.String r2 = "https://"
            java.lang.String r5 = r5.replace(r1, r2)
            r1 = 0
            java.net.URL r2 = new java.net.URL     // Catch: java.lang.Throwable -> L4a java.io.IOException -> L4c
            r2.<init>(r5)     // Catch: java.lang.Throwable -> L4a java.io.IOException -> L4c
            java.net.URLConnection r2 = r2.openConnection()     // Catch: java.lang.Throwable -> L4a java.io.IOException -> L4c
            java.lang.Object r2 = com.google.firebase.perf.network.FirebasePerfUrlConnection.instrument(r2)     // Catch: java.lang.Throwable -> L4a java.io.IOException -> L4c
            java.net.URLConnection r2 = (java.net.URLConnection) r2     // Catch: java.lang.Throwable -> L4a java.io.IOException -> L4c
            java.net.HttpURLConnection r2 = (java.net.HttpURLConnection) r2     // Catch: java.lang.Throwable -> L4a java.io.IOException -> L4c
            r3 = 1
            r2.setDoInput(r3)     // Catch: java.io.IOException -> L4d java.lang.Throwable -> L6c
            r2.connect()     // Catch: java.io.IOException -> L4d java.lang.Throwable -> L6c
            java.io.InputStream r3 = r2.getInputStream()     // Catch: java.io.IOException -> L4d java.lang.Throwable -> L6c
            android.graphics.Bitmap r5 = android.graphics.BitmapFactory.decodeStream(r3)     // Catch: java.io.IOException -> L4d java.lang.Throwable -> L6c
            r2.disconnect()     // Catch: java.lang.Throwable -> L45
            goto L49
        L45:
            r1 = move-exception
            com.clevertap.android.sdk.Logger.q(r0, r1)
        L49:
            return r5
        L4a:
            r5 = move-exception
            goto L6e
        L4c:
            r2 = r1
        L4d:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L6c
            r3.<init>()     // Catch: java.lang.Throwable -> L6c
            java.lang.String r4 = "Couldn't download the notification icon. URL was: "
            r3.append(r4)     // Catch: java.lang.Throwable -> L6c
            r3.append(r5)     // Catch: java.lang.Throwable -> L6c
            java.lang.String r5 = r3.toString()     // Catch: java.lang.Throwable -> L6c
            com.clevertap.android.sdk.Logger.n(r5)     // Catch: java.lang.Throwable -> L6c
            if (r2 == 0) goto L6b
            r2.disconnect()     // Catch: java.lang.Throwable -> L67
            goto L6b
        L67:
            r5 = move-exception
            com.clevertap.android.sdk.Logger.q(r0, r5)
        L6b:
            return r1
        L6c:
            r5 = move-exception
            r1 = r2
        L6e:
            if (r1 == 0) goto L78
            r1.disconnect()     // Catch: java.lang.Throwable -> L74
            goto L78
        L74:
            r1 = move-exception
            com.clevertap.android.sdk.Logger.q(r0, r1)
        L78:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.clevertap.android.sdk.Utils.k(java.lang.String):android.graphics.Bitmap");
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x007e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static byte[] l(java.lang.String r8) {
        /*
            java.lang.String r0 = "Couldn't close connection!"
            java.lang.String r1 = "///"
            java.lang.String r2 = "/"
            java.lang.String r8 = r8.replace(r1, r2)
            java.lang.String r1 = "//"
            java.lang.String r8 = r8.replace(r1, r2)
            java.lang.String r1 = "http:/"
            java.lang.String r2 = "http://"
            java.lang.String r8 = r8.replace(r1, r2)
            java.lang.String r1 = "https:/"
            java.lang.String r2 = "https://"
            java.lang.String r8 = r8.replace(r1, r2)
            r1 = 0
            java.net.URL r2 = new java.net.URL     // Catch: java.lang.Throwable -> L58 java.io.IOException -> L5a
            r2.<init>(r8)     // Catch: java.lang.Throwable -> L58 java.io.IOException -> L5a
            java.net.URLConnection r2 = r2.openConnection()     // Catch: java.lang.Throwable -> L58 java.io.IOException -> L5a
            java.lang.Object r2 = com.google.firebase.perf.network.FirebasePerfUrlConnection.instrument(r2)     // Catch: java.lang.Throwable -> L58 java.io.IOException -> L5a
            java.net.URLConnection r2 = (java.net.URLConnection) r2     // Catch: java.lang.Throwable -> L58 java.io.IOException -> L5a
            javax.net.ssl.HttpsURLConnection r2 = (javax.net.ssl.HttpsURLConnection) r2     // Catch: java.lang.Throwable -> L58 java.io.IOException -> L5a
            java.io.InputStream r3 = r2.getInputStream()     // Catch: java.io.IOException -> L5b java.lang.Throwable -> L7a
            r4 = 8192(0x2000, float:1.148E-41)
            byte[] r4 = new byte[r4]     // Catch: java.io.IOException -> L5b java.lang.Throwable -> L7a
            java.io.ByteArrayOutputStream r5 = new java.io.ByteArrayOutputStream     // Catch: java.io.IOException -> L5b java.lang.Throwable -> L7a
            r5.<init>()     // Catch: java.io.IOException -> L5b java.lang.Throwable -> L7a
        L3f:
            int r6 = r3.read(r4)     // Catch: java.io.IOException -> L5b java.lang.Throwable -> L7a
            r7 = -1
            if (r6 == r7) goto L4b
            r7 = 0
            r5.write(r4, r7, r6)     // Catch: java.io.IOException -> L5b java.lang.Throwable -> L7a
            goto L3f
        L4b:
            byte[] r8 = r5.toByteArray()     // Catch: java.io.IOException -> L5b java.lang.Throwable -> L7a
            r2.disconnect()     // Catch: java.lang.Throwable -> L53
            goto L57
        L53:
            r1 = move-exception
            com.clevertap.android.sdk.Logger.q(r0, r1)
        L57:
            return r8
        L58:
            r8 = move-exception
            goto L7c
        L5a:
            r2 = r1
        L5b:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L7a
            r3.<init>()     // Catch: java.lang.Throwable -> L7a
            java.lang.String r4 = "Error processing image bytes from url: "
            r3.append(r4)     // Catch: java.lang.Throwable -> L7a
            r3.append(r8)     // Catch: java.lang.Throwable -> L7a
            java.lang.String r8 = r3.toString()     // Catch: java.lang.Throwable -> L7a
            com.clevertap.android.sdk.Logger.n(r8)     // Catch: java.lang.Throwable -> L7a
            if (r2 == 0) goto L79
            r2.disconnect()     // Catch: java.lang.Throwable -> L75
            goto L79
        L75:
            r8 = move-exception
            com.clevertap.android.sdk.Logger.q(r0, r8)
        L79:
            return r1
        L7a:
            r8 = move-exception
            r1 = r2
        L7c:
            if (r1 == 0) goto L86
            r1.disconnect()     // Catch: java.lang.Throwable -> L82
            goto L86
        L82:
            r1 = move-exception
            com.clevertap.android.sdk.Logger.q(r0, r1)
        L86:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.clevertap.android.sdk.Utils.l(java.lang.String):byte[]");
    }

    @SuppressLint({"MissingPermission"})
    public static String m(Context context) {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                return "Unavailable";
            }
            NetworkInfo networkInfo = connectivityManager.getNetworkInfo(1);
            if (networkInfo != null && networkInfo.isConnected()) {
                return "WiFi";
            }
            return n(context);
        } catch (Throwable unused) {
            return "Unavailable";
        }
    }

    @SuppressLint({"MissingPermission"})
    public static String n(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager == null) {
            return "Unavailable";
        }
        int i8 = 0;
        if (Build.VERSION.SDK_INT >= 30) {
            if (t(context, "android.permission.READ_PHONE_STATE")) {
                try {
                    i8 = telephonyManager.getDataNetworkType();
                } catch (SecurityException e8) {
                    Logger.a("Security Exception caught while fetch network type" + e8.getMessage());
                }
            } else {
                Logger.a("READ_PHONE_STATE permission not asked by the app or not granted by the user");
            }
        } else {
            i8 = telephonyManager.getNetworkType();
        }
        if (i8 != 20) {
            switch (i8) {
                case 1:
                case 2:
                case 4:
                case 7:
                case 11:
                    return "2G";
                case 3:
                case 5:
                case 6:
                case 8:
                case 9:
                case 10:
                case 12:
                case 14:
                case 15:
                    return "3G";
                case 13:
                    return "4G";
                default:
                    return "Unknown";
            }
        }
        return "5G";
    }

    public static String o(Context context, CleverTapInstanceConfig cleverTapInstanceConfig) {
        String str = null;
        try {
            String h8 = ManifestInfo.i(context).h();
            if (h8 != null) {
                Logger n8 = cleverTapInstanceConfig.n();
                String c8 = cleverTapInstanceConfig.c();
                n8.s(c8, "Requesting an FCM token with Manifest SenderId - " + h8);
                str = FirebaseInstanceId.i().o(h8, "FCM");
            }
            Logger n9 = cleverTapInstanceConfig.n();
            String c9 = cleverTapInstanceConfig.c();
            n9.m(c9, "FCM token using Manifest SenderId: " + str);
        } catch (Throwable th) {
            cleverTapInstanceConfig.n().t(cleverTapInstanceConfig.c(), "Error requesting FCM token with Manifest SenderId", th);
        }
        return str;
    }

    public static long p() {
        return Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
    }

    public static Bitmap q(String str, boolean z7, Context context) throws NullPointerException {
        if (str != null && !str.equals("")) {
            if (!str.startsWith("http")) {
                str = "http://static.wizrocket.com/android/ico//" + str;
            }
            Bitmap k8 = k(str);
            if (k8 != null) {
                return k8;
            }
            if (!z7) {
                return null;
            }
            return j(context);
        } else if (!z7) {
            return null;
        } else {
            return j(context);
        }
    }

    public static int r() {
        return (int) (System.currentTimeMillis() / 1000);
    }

    public static int s(Context context, String str) {
        if (context != null) {
            return context.getResources().getIdentifier(str, "drawable", context.getPackageName());
        }
        return -1;
    }

    public static boolean t(Context context, String str) {
        try {
            if (ContextCompat.checkSelfPermission(context, str) != 0) {
                return false;
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean u(Activity activity) {
        if (activity == null || activity.isFinishing() || activity.isDestroyed()) {
            return true;
        }
        return false;
    }

    public static void v(Runnable runnable) {
        if (runnable != null) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                runnable.run();
            } else {
                new Handler(Looper.getMainLooper()).post(runnable);
            }
        }
    }

    public static void w(Context context, Intent intent) {
        List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 0);
        if (queryIntentActivities != null) {
            String packageName = context.getPackageName();
            for (ResolveInfo resolveInfo : queryIntentActivities) {
                if (packageName.equals(resolveInfo.activityInfo.packageName)) {
                    intent.setPackage(packageName);
                    return;
                }
            }
        }
    }

    public static boolean x(String str) {
        if (str == null) {
            Logger.j("CLEVERTAP_USE_CUSTOM_ID has been set as 1 in AndroidManifest.xml but custom CleverTap ID passed is NULL.");
            return false;
        } else if (str.isEmpty()) {
            Logger.j("CLEVERTAP_USE_CUSTOM_ID has been set as 1 in AndroidManifest.xml but custom CleverTap ID passed is empty.");
            return false;
        } else if (str.length() > 64) {
            Logger.j("Custom CleverTap ID passed is greater than 64 characters. ");
            return false;
        } else if (!str.matches("[A-Za-z0-9()!:$@_-]*")) {
            Logger.j("Custom CleverTap ID cannot contain special characters apart from :,(,),_,!,@,$ and - ");
            return false;
        } else {
            return true;
        }
    }
}
