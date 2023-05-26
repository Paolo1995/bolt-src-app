package com.google.firebase.messaging;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.content.ContextCompat;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-messaging@@21.1.0 */
/* loaded from: classes3.dex */
public class Store {

    /* renamed from: a  reason: collision with root package name */
    final SharedPreferences f16582a;

    /* renamed from: b  reason: collision with root package name */
    final Context f16583b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: com.google.firebase:firebase-messaging@@21.1.0 */
    /* loaded from: classes3.dex */
    public static class Token {

        /* renamed from: d  reason: collision with root package name */
        private static final long f16584d = TimeUnit.DAYS.toMillis(7);

        /* renamed from: a  reason: collision with root package name */
        final String f16585a;

        /* renamed from: b  reason: collision with root package name */
        final String f16586b;

        /* renamed from: c  reason: collision with root package name */
        final long f16587c;

        private Token(String str, String str2, long j8) {
            this.f16585a = str;
            this.f16586b = str2;
            this.f16587c = j8;
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
                Log.w("FirebaseMessaging", sb.toString());
                return null;
            }
        }

        static Token c(String str) {
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
                    Log.w("FirebaseMessaging", sb.toString());
                    return null;
                }
            }
            return new Token(str, null, 0L);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean b(String str) {
            if (System.currentTimeMillis() <= this.f16587c + f16584d && str.equals(this.f16586b)) {
                return false;
            }
            return true;
        }
    }

    public Store(Context context) {
        this.f16583b = context;
        this.f16582a = context.getSharedPreferences("com.google.android.gms.appid", 0);
        a("com.google.android.gms.appid-no-backup");
    }

    private void a(String str) {
        String str2;
        File file = new File(ContextCompat.getNoBackupFilesDir(this.f16583b), "com.google.android.gms.appid-no-backup");
        if (file.exists()) {
            return;
        }
        try {
            if (file.createNewFile() && !e()) {
                Log.i("FirebaseMessaging", "App restored, clearing state");
                c();
            }
        } catch (IOException e8) {
            if (Log.isLoggable("FirebaseMessaging", 3)) {
                String valueOf = String.valueOf(e8.getMessage());
                if (valueOf.length() != 0) {
                    str2 = "Error creating file in no backup dir: ".concat(valueOf);
                } else {
                    str2 = new String("Error creating file in no backup dir: ");
                }
                Log.d("FirebaseMessaging", str2);
            }
        }
    }

    private String b(String str, String str2) {
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 5 + String.valueOf(str2).length());
        sb.append(str);
        sb.append("|T|");
        sb.append(str2);
        sb.append("|*");
        return sb.toString();
    }

    public synchronized void c() {
        this.f16582a.edit().clear().commit();
    }

    public synchronized Token d(String str, String str2) {
        return Token.c(this.f16582a.getString(b(str, str2), null));
    }

    public synchronized boolean e() {
        return this.f16582a.getAll().isEmpty();
    }

    public synchronized void f(String str, String str2, String str3, String str4) {
        String a8 = Token.a(str3, str4, System.currentTimeMillis());
        if (a8 == null) {
            return;
        }
        SharedPreferences.Editor edit = this.f16582a.edit();
        edit.putString(b(str, str2), a8);
        edit.commit();
    }
}
