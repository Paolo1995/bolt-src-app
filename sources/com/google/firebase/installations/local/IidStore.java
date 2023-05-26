package com.google.firebase.installations.local;

import android.content.SharedPreferences;
import android.util.Base64;
import android.util.Log;
import androidx.annotation.NonNull;
import com.google.android.gms.stats.CodePackage;
import com.google.firebase.FirebaseApp;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class IidStore {

    /* renamed from: c  reason: collision with root package name */
    private static final String[] f16402c = {"*", "FCM", CodePackage.GCM, ""};

    /* renamed from: a  reason: collision with root package name */
    private final SharedPreferences f16403a;

    /* renamed from: b  reason: collision with root package name */
    private final String f16404b;

    public IidStore(@NonNull FirebaseApp firebaseApp) {
        this.f16403a = firebaseApp.j().getSharedPreferences("com.google.android.gms.appid", 0);
        this.f16404b = b(firebaseApp);
    }

    private String a(@NonNull String str, @NonNull String str2) {
        return "|T|" + str + "|" + str2;
    }

    private static String b(FirebaseApp firebaseApp) {
        String d8 = firebaseApp.m().d();
        if (d8 != null) {
            return d8;
        }
        String c8 = firebaseApp.m().c();
        if (!c8.startsWith("1:") && !c8.startsWith("2:")) {
            return c8;
        }
        String[] split = c8.split(":");
        if (split.length != 4) {
            return null;
        }
        String str = split[1];
        if (str.isEmpty()) {
            return null;
        }
        return str;
    }

    private static String c(@NonNull PublicKey publicKey) {
        try {
            byte[] digest = MessageDigest.getInstance("SHA1").digest(publicKey.getEncoded());
            digest[0] = (byte) (((digest[0] & 15) + 112) & 255);
            return Base64.encodeToString(digest, 0, 8, 11);
        } catch (NoSuchAlgorithmException unused) {
            Log.w("ContentValues", "Unexpected error, device missing required algorithms");
            return null;
        }
    }

    private String d(String str) {
        try {
            return new JSONObject(str).getString("token");
        } catch (JSONException unused) {
            return null;
        }
    }

    private PublicKey e(String str) {
        try {
            return KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(str, 8)));
        } catch (IllegalArgumentException | NoSuchAlgorithmException | InvalidKeySpecException e8) {
            Log.w("ContentValues", "Invalid key stored " + e8);
            return null;
        }
    }

    private String g() {
        String string;
        synchronized (this.f16403a) {
            string = this.f16403a.getString("|S|id", null);
        }
        return string;
    }

    private String h() {
        synchronized (this.f16403a) {
            String string = this.f16403a.getString("|S||P|", null);
            if (string == null) {
                return null;
            }
            PublicKey e8 = e(string);
            if (e8 == null) {
                return null;
            }
            return c(e8);
        }
    }

    public String f() {
        synchronized (this.f16403a) {
            String g8 = g();
            if (g8 != null) {
                return g8;
            }
            return h();
        }
    }

    public String i() {
        synchronized (this.f16403a) {
            for (String str : f16402c) {
                String string = this.f16403a.getString(a(this.f16404b, str), null);
                if (string != null && !string.isEmpty()) {
                    if (string.startsWith("{")) {
                        string = d(string);
                    }
                    return string;
                }
            }
            return null;
        }
    }
}
