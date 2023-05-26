package com.google.firebase.crashlytics.internal.common;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import androidx.annotation.NonNull;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.installations.FirebaseInstallationsApi;
import java.util.Locale;
import java.util.UUID;
import java.util.regex.Pattern;

/* loaded from: classes3.dex */
public class IdManager implements InstallIdProvider {

    /* renamed from: g  reason: collision with root package name */
    private static final Pattern f15707g = Pattern.compile("[^\\p{Alnum}]");

    /* renamed from: h  reason: collision with root package name */
    private static final String f15708h = Pattern.quote("/");

    /* renamed from: a  reason: collision with root package name */
    private final InstallerPackageNameProvider f15709a;

    /* renamed from: b  reason: collision with root package name */
    private final Context f15710b;

    /* renamed from: c  reason: collision with root package name */
    private final String f15711c;

    /* renamed from: d  reason: collision with root package name */
    private final FirebaseInstallationsApi f15712d;

    /* renamed from: e  reason: collision with root package name */
    private final DataCollectionArbiter f15713e;

    /* renamed from: f  reason: collision with root package name */
    private String f15714f;

    public IdManager(Context context, String str, FirebaseInstallationsApi firebaseInstallationsApi, DataCollectionArbiter dataCollectionArbiter) {
        if (context != null) {
            if (str != null) {
                this.f15710b = context;
                this.f15711c = str;
                this.f15712d = firebaseInstallationsApi;
                this.f15713e = dataCollectionArbiter;
                this.f15709a = new InstallerPackageNameProvider();
                return;
            }
            throw new IllegalArgumentException("appIdentifier must not be null");
        }
        throw new IllegalArgumentException("appContext must not be null");
    }

    @NonNull
    private synchronized String b(String str, SharedPreferences sharedPreferences) {
        String e8;
        e8 = e(UUID.randomUUID().toString());
        Logger f8 = Logger.f();
        f8.i("Created new Crashlytics installation ID: " + e8 + " for FID: " + str);
        sharedPreferences.edit().putString("crashlytics.installation.id", e8).putString("firebase.installation.id", str).apply();
        return e8;
    }

    static String c() {
        return "SYN_" + UUID.randomUUID().toString();
    }

    private String d() {
        try {
            return (String) Utils.d(this.f15712d.getId());
        } catch (Exception e8) {
            Logger.f().l("Failed to retrieve Firebase Installations ID.", e8);
            return null;
        }
    }

    private static String e(String str) {
        if (str == null) {
            return null;
        }
        return f15707g.matcher(str).replaceAll("").toLowerCase(Locale.US);
    }

    static boolean k(String str) {
        if (str != null && str.startsWith("SYN_")) {
            return true;
        }
        return false;
    }

    private String l(SharedPreferences sharedPreferences) {
        return sharedPreferences.getString("crashlytics.installation.id", null);
    }

    private String m(String str) {
        return str.replaceAll(f15708h, "");
    }

    @Override // com.google.firebase.crashlytics.internal.common.InstallIdProvider
    @NonNull
    public synchronized String a() {
        String str = this.f15714f;
        if (str != null) {
            return str;
        }
        Logger.f().i("Determining Crashlytics installation ID...");
        SharedPreferences r7 = CommonUtils.r(this.f15710b);
        String string = r7.getString("firebase.installation.id", null);
        Logger f8 = Logger.f();
        f8.i("Cached Firebase Installation ID: " + string);
        if (this.f15713e.d()) {
            String d8 = d();
            Logger f9 = Logger.f();
            f9.i("Fetched Firebase Installation ID: " + d8);
            if (d8 == null) {
                if (string == null) {
                    d8 = c();
                } else {
                    d8 = string;
                }
            }
            if (d8.equals(string)) {
                this.f15714f = l(r7);
            } else {
                this.f15714f = b(d8, r7);
            }
        } else if (k(string)) {
            this.f15714f = l(r7);
        } else {
            this.f15714f = b(c(), r7);
        }
        if (this.f15714f == null) {
            Logger.f().k("Unable to determine Crashlytics Install Id, creating a new one.");
            this.f15714f = b(c(), r7);
        }
        Logger f10 = Logger.f();
        f10.i("Crashlytics installation ID: " + this.f15714f);
        return this.f15714f;
    }

    public String f() {
        return this.f15711c;
    }

    public String g() {
        return this.f15709a.a(this.f15710b);
    }

    public String h() {
        return String.format(Locale.US, "%s/%s", m(Build.MANUFACTURER), m(Build.MODEL));
    }

    public String i() {
        return m(Build.VERSION.INCREMENTAL);
    }

    public String j() {
        return m(Build.VERSION.RELEASE);
    }
}
