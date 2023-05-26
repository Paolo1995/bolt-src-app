package com.google.firebase.iid;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import androidx.collection.ArrayMap;
import androidx.core.content.ContextCompat;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-iid@@21.1.0 */
/* loaded from: classes3.dex */
public class Store {

    /* renamed from: a  reason: collision with root package name */
    final SharedPreferences f16332a;

    /* renamed from: b  reason: collision with root package name */
    final Context f16333b;

    /* renamed from: c  reason: collision with root package name */
    private final Map<String, Long> f16334c = new ArrayMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: com.google.firebase:firebase-iid@@21.1.0 */
    /* loaded from: classes3.dex */
    public static class Token {

        /* renamed from: d  reason: collision with root package name */
        private static final long f16335d = TimeUnit.DAYS.toMillis(7);

        /* renamed from: a  reason: collision with root package name */
        final String f16336a;

        /* renamed from: b  reason: collision with root package name */
        final String f16337b;

        /* renamed from: c  reason: collision with root package name */
        final long f16338c;

        private Token(String str, String str2, long j8) {
            this.f16336a = str;
            this.f16337b = str2;
            this.f16338c = j8;
        }

        static String a(String str, String str2, long j8) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("token", str);
                jSONObject.put("appVersion", str2);
                jSONObject.put("timestamp", j8);
                return jSONObject.toString();
            } catch (JSONException e8) {
                String valueOf = String.valueOf(e8);
                StringBuilder sb = new StringBuilder(valueOf.length() + 24);
                sb.append("Failed to encode token: ");
                sb.append(valueOf);
                Log.w("FirebaseInstanceId", sb.toString());
                return null;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static String b(Token token) {
            if (token == null) {
                return null;
            }
            return token.f16336a;
        }

        static Token d(String str) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            if (str.startsWith("{")) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    return new Token(jSONObject.getString("token"), jSONObject.getString("appVersion"), jSONObject.getLong("timestamp"));
                } catch (JSONException e8) {
                    String valueOf = String.valueOf(e8);
                    StringBuilder sb = new StringBuilder(valueOf.length() + 23);
                    sb.append("Failed to parse token: ");
                    sb.append(valueOf);
                    Log.w("FirebaseInstanceId", sb.toString());
                    return null;
                }
            }
            return new Token(str, null, 0L);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean c(String str) {
            if (System.currentTimeMillis() <= this.f16338c + f16335d && str.equals(this.f16337b)) {
                return false;
            }
            return true;
        }
    }

    public Store(Context context) {
        this.f16333b = context;
        this.f16332a = context.getSharedPreferences("com.google.android.gms.appid", 0);
        a("com.google.android.gms.appid-no-backup");
    }

    private void a(String str) {
        String str2;
        File file = new File(ContextCompat.getNoBackupFilesDir(this.f16333b), "com.google.android.gms.appid-no-backup");
        if (file.exists()) {
            return;
        }
        try {
            if (file.createNewFile() && !g()) {
                Log.i("FirebaseInstanceId", "App restored, clearing state");
                d();
            }
        } catch (IOException e8) {
            if (Log.isLoggable("FirebaseInstanceId", 3)) {
                String valueOf = String.valueOf(e8.getMessage());
                if (valueOf.length() != 0) {
                    str2 = "Error creating file in no backup dir: ".concat(valueOf);
                } else {
                    str2 = new String("Error creating file in no backup dir: ");
                }
                Log.d("FirebaseInstanceId", str2);
            }
        }
    }

    static String b(String str, String str2) {
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 6);
        sb.append(str);
        sb.append("|S|cre");
        return sb.toString();
    }

    private String c(String str, String str2, String str3) {
        int length = String.valueOf(str).length();
        StringBuilder sb = new StringBuilder(length + 4 + String.valueOf(str2).length() + String.valueOf(str3).length());
        sb.append(str);
        sb.append("|T|");
        sb.append(str2);
        sb.append("|");
        sb.append(str3);
        return sb.toString();
    }

    private long e(String str) {
        String string = this.f16332a.getString(b(str, "cre"), null);
        if (string != null) {
            try {
                return Long.parseLong(string);
            } catch (NumberFormatException unused) {
                return 0L;
            }
        }
        return 0L;
    }

    private long j(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        if (!this.f16332a.contains(b(str, "cre"))) {
            SharedPreferences.Editor edit = this.f16332a.edit();
            edit.putString(b(str, "cre"), String.valueOf(currentTimeMillis));
            edit.commit();
            return currentTimeMillis;
        }
        return e(str);
    }

    public synchronized void d() {
        this.f16334c.clear();
        this.f16332a.edit().clear().commit();
    }

    public synchronized Token f(String str, String str2, String str3) {
        return Token.d(this.f16332a.getString(c(str, str2, str3), null));
    }

    public synchronized boolean g() {
        return this.f16332a.getAll().isEmpty();
    }

    public synchronized void h(String str, String str2, String str3, String str4, String str5) {
        String a8 = Token.a(str4, str5, System.currentTimeMillis());
        if (a8 == null) {
            return;
        }
        SharedPreferences.Editor edit = this.f16332a.edit();
        edit.putString(c(str, str2, str3), a8);
        edit.commit();
    }

    public synchronized long i(String str) {
        long j8;
        j8 = j(str);
        this.f16334c.put(str, Long.valueOf(j8));
        return j8;
    }
}
