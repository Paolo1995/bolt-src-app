package com.google.firebase.messaging;

import android.content.res.Resources;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import java.util.Arrays;
import java.util.MissingFormatArgumentException;
import org.json.JSONArray;
import org.json.JSONException;

/* compiled from: com.google.firebase:firebase-messaging@@21.1.0 */
/* loaded from: classes3.dex */
public class NotificationParams {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final Bundle f16535a;

    public NotificationParams(@NonNull Bundle bundle) {
        if (bundle != null) {
            this.f16535a = new Bundle(bundle);
            return;
        }
        throw new NullPointerException("data");
    }

    private static int d(String str) {
        int parseColor = Color.parseColor(str);
        if (parseColor != -16777216) {
            return parseColor;
        }
        throw new IllegalArgumentException("Transparent color is invalid");
    }

    private static boolean s(String str) {
        if (!str.startsWith("google.c.a.") && !str.equals("from")) {
            return false;
        }
        return true;
    }

    public static boolean t(Bundle bundle) {
        if (!"1".equals(bundle.getString("gcm.n.e")) && !"1".equals(bundle.getString(v("gcm.n.e")))) {
            return false;
        }
        return true;
    }

    private static boolean u(String str) {
        if (!str.startsWith("google.c.") && !str.startsWith("gcm.n.") && !str.startsWith("gcm.notification.")) {
            return false;
        }
        return true;
    }

    private static String v(String str) {
        if (!str.startsWith("gcm.n.")) {
            return str;
        }
        return str.replace("gcm.n.", "gcm.notification.");
    }

    private String w(String str) {
        if (!this.f16535a.containsKey(str) && str.startsWith("gcm.n.")) {
            String v7 = v(str);
            if (this.f16535a.containsKey(v7)) {
                return v7;
            }
        }
        return str;
    }

    private static String z(String str) {
        if (str.startsWith("gcm.n.")) {
            return str.substring(6);
        }
        return str;
    }

    public boolean a(String str) {
        String p8 = p(str);
        if (!"1".equals(p8) && !Boolean.parseBoolean(p8)) {
            return false;
        }
        return true;
    }

    public Integer b(String str) {
        String p8 = p(str);
        if (!TextUtils.isEmpty(p8)) {
            try {
                return Integer.valueOf(Integer.parseInt(p8));
            } catch (NumberFormatException unused) {
                String z7 = z(str);
                StringBuilder sb = new StringBuilder(String.valueOf(z7).length() + 38 + String.valueOf(p8).length());
                sb.append("Couldn't parse value of ");
                sb.append(z7);
                sb.append("(");
                sb.append(p8);
                sb.append(") into an int");
                Log.w("NotificationParams", sb.toString());
                return null;
            }
        }
        return null;
    }

    public JSONArray c(String str) {
        String p8 = p(str);
        if (!TextUtils.isEmpty(p8)) {
            try {
                return new JSONArray(p8);
            } catch (JSONException unused) {
                String z7 = z(str);
                StringBuilder sb = new StringBuilder(String.valueOf(z7).length() + 50 + String.valueOf(p8).length());
                sb.append("Malformed JSON for key ");
                sb.append(z7);
                sb.append(": ");
                sb.append(p8);
                sb.append(", falling back to default");
                Log.w("NotificationParams", sb.toString());
                return null;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int[] e() {
        JSONArray c8 = c("gcm.n.light_settings");
        if (c8 == null) {
            return null;
        }
        int[] iArr = new int[3];
        try {
            if (c8.length() == 3) {
                iArr[0] = d(c8.optString(0));
                iArr[1] = c8.optInt(1);
                iArr[2] = c8.optInt(2);
                return iArr;
            }
            throw new JSONException("lightSettings don't have all three fields");
        } catch (IllegalArgumentException e8) {
            String valueOf = String.valueOf(c8);
            String message = e8.getMessage();
            StringBuilder sb = new StringBuilder(valueOf.length() + 60 + String.valueOf(message).length());
            sb.append("LightSettings is invalid: ");
            sb.append(valueOf);
            sb.append(". ");
            sb.append(message);
            sb.append(". Skipping setting LightSettings");
            Log.w("NotificationParams", sb.toString());
            return null;
        } catch (JSONException unused) {
            String valueOf2 = String.valueOf(c8);
            StringBuilder sb2 = new StringBuilder(valueOf2.length() + 58);
            sb2.append("LightSettings is invalid: ");
            sb2.append(valueOf2);
            sb2.append(". Skipping setting LightSettings");
            Log.w("NotificationParams", sb2.toString());
            return null;
        }
    }

    public Uri f() {
        String p8 = p("gcm.n.link_android");
        if (TextUtils.isEmpty(p8)) {
            p8 = p("gcm.n.link");
        }
        if (!TextUtils.isEmpty(p8)) {
            return Uri.parse(p8);
        }
        return null;
    }

    public Object[] g(String str) {
        JSONArray c8 = c(String.valueOf(str).concat("_loc_args"));
        if (c8 == null) {
            return null;
        }
        int length = c8.length();
        String[] strArr = new String[length];
        for (int i8 = 0; i8 < length; i8++) {
            strArr[i8] = c8.optString(i8);
        }
        return strArr;
    }

    public String h(String str) {
        return p(String.valueOf(str).concat("_loc_key"));
    }

    public String i(Resources resources, String str, String str2) {
        String h8 = h(str2);
        if (TextUtils.isEmpty(h8)) {
            return null;
        }
        int identifier = resources.getIdentifier(h8, "string", str);
        if (identifier == 0) {
            String z7 = z(String.valueOf(str2).concat("_loc_key"));
            StringBuilder sb = new StringBuilder(String.valueOf(z7).length() + 49 + String.valueOf(str2).length());
            sb.append(z7);
            sb.append(" resource not found: ");
            sb.append(str2);
            sb.append(" Default value will be used.");
            Log.w("NotificationParams", sb.toString());
            return null;
        }
        Object[] g8 = g(str2);
        if (g8 == null) {
            return resources.getString(identifier);
        }
        try {
            return resources.getString(identifier, g8);
        } catch (MissingFormatArgumentException e8) {
            String z8 = z(str2);
            String arrays = Arrays.toString(g8);
            StringBuilder sb2 = new StringBuilder(String.valueOf(z8).length() + 58 + String.valueOf(arrays).length());
            sb2.append("Missing format argument for ");
            sb2.append(z8);
            sb2.append(": ");
            sb2.append(arrays);
            sb2.append(" Default value will be used.");
            Log.w("NotificationParams", sb2.toString(), e8);
            return null;
        }
    }

    public Long j(String str) {
        String p8 = p(str);
        if (!TextUtils.isEmpty(p8)) {
            try {
                return Long.valueOf(Long.parseLong(p8));
            } catch (NumberFormatException unused) {
                String z7 = z(str);
                StringBuilder sb = new StringBuilder(String.valueOf(z7).length() + 38 + String.valueOf(p8).length());
                sb.append("Couldn't parse value of ");
                sb.append(z7);
                sb.append("(");
                sb.append(p8);
                sb.append(") into a long");
                Log.w("NotificationParams", sb.toString());
                return null;
            }
        }
        return null;
    }

    public String k() {
        return p("gcm.n.android_channel_id");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Integer l() {
        Integer b8 = b("gcm.n.notification_count");
        if (b8 == null) {
            return null;
        }
        if (b8.intValue() < 0) {
            String valueOf = String.valueOf(b8);
            StringBuilder sb = new StringBuilder(valueOf.length() + 67);
            sb.append("notificationCount is invalid: ");
            sb.append(valueOf);
            sb.append(". Skipping setting notificationCount.");
            Log.w("FirebaseMessaging", sb.toString());
            return null;
        }
        return b8;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Integer m() {
        Integer b8 = b("gcm.n.notification_priority");
        if (b8 == null) {
            return null;
        }
        if (b8.intValue() >= -2 && b8.intValue() <= 2) {
            return b8;
        }
        String valueOf = String.valueOf(b8);
        StringBuilder sb = new StringBuilder(valueOf.length() + 72);
        sb.append("notificationPriority is invalid ");
        sb.append(valueOf);
        sb.append(". Skipping setting notificationPriority.");
        Log.w("FirebaseMessaging", sb.toString());
        return null;
    }

    public String n(Resources resources, String str, String str2) {
        String p8 = p(str2);
        if (!TextUtils.isEmpty(p8)) {
            return p8;
        }
        return i(resources, str, str2);
    }

    public String o() {
        String p8 = p("gcm.n.sound2");
        if (TextUtils.isEmpty(p8)) {
            return p("gcm.n.sound");
        }
        return p8;
    }

    public String p(String str) {
        return this.f16535a.getString(w(str));
    }

    public long[] q() {
        JSONArray c8 = c("gcm.n.vibrate_timings");
        if (c8 == null) {
            return null;
        }
        try {
            if (c8.length() > 1) {
                int length = c8.length();
                long[] jArr = new long[length];
                for (int i8 = 0; i8 < length; i8++) {
                    jArr[i8] = c8.optLong(i8);
                }
                return jArr;
            }
            throw new JSONException("vibrateTimings have invalid length");
        } catch (NumberFormatException | JSONException unused) {
            String valueOf = String.valueOf(c8);
            StringBuilder sb = new StringBuilder(valueOf.length() + 74);
            sb.append("User defined vibrateTimings is invalid: ");
            sb.append(valueOf);
            sb.append(". Skipping setting vibrateTimings.");
            Log.w("NotificationParams", sb.toString());
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Integer r() {
        Integer b8 = b("gcm.n.visibility");
        if (b8 == null) {
            return null;
        }
        if (b8.intValue() >= -1 && b8.intValue() <= 1) {
            return b8;
        }
        String valueOf = String.valueOf(b8);
        StringBuilder sb = new StringBuilder(valueOf.length() + 53);
        sb.append("visibility is invalid: ");
        sb.append(valueOf);
        sb.append(". Skipping setting visibility.");
        Log.w("NotificationParams", sb.toString());
        return null;
    }

    public Bundle x() {
        Bundle bundle = new Bundle(this.f16535a);
        for (String str : this.f16535a.keySet()) {
            if (!s(str)) {
                bundle.remove(str);
            }
        }
        return bundle;
    }

    public Bundle y() {
        Bundle bundle = new Bundle(this.f16535a);
        for (String str : this.f16535a.keySet()) {
            if (u(str)) {
                bundle.remove(str);
            }
        }
        return bundle;
    }
}
