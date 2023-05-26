package com.google.firebase;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.StringResourceValueReader;
import com.google.android.gms.common.util.Strings;

/* loaded from: classes.dex */
public final class FirebaseOptions {

    /* renamed from: a  reason: collision with root package name */
    private final String f15391a;

    /* renamed from: b  reason: collision with root package name */
    private final String f15392b;

    /* renamed from: c  reason: collision with root package name */
    private final String f15393c;

    /* renamed from: d  reason: collision with root package name */
    private final String f15394d;

    /* renamed from: e  reason: collision with root package name */
    private final String f15395e;

    /* renamed from: f  reason: collision with root package name */
    private final String f15396f;

    /* renamed from: g  reason: collision with root package name */
    private final String f15397g;

    private FirebaseOptions(@NonNull String str, @NonNull String str2, String str3, String str4, String str5, String str6, String str7) {
        Preconditions.checkState(!Strings.isEmptyOrWhitespace(str), "ApplicationId must be set.");
        this.f15392b = str;
        this.f15391a = str2;
        this.f15393c = str3;
        this.f15394d = str4;
        this.f15395e = str5;
        this.f15396f = str6;
        this.f15397g = str7;
    }

    public static FirebaseOptions a(@NonNull Context context) {
        StringResourceValueReader stringResourceValueReader = new StringResourceValueReader(context);
        String string = stringResourceValueReader.getString("google_app_id");
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        return new FirebaseOptions(string, stringResourceValueReader.getString("google_api_key"), stringResourceValueReader.getString("firebase_database_url"), stringResourceValueReader.getString("ga_trackingId"), stringResourceValueReader.getString("gcm_defaultSenderId"), stringResourceValueReader.getString("google_storage_bucket"), stringResourceValueReader.getString("project_id"));
    }

    @NonNull
    public String b() {
        return this.f15391a;
    }

    @NonNull
    public String c() {
        return this.f15392b;
    }

    public String d() {
        return this.f15395e;
    }

    public String e() {
        return this.f15397g;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof FirebaseOptions)) {
            return false;
        }
        FirebaseOptions firebaseOptions = (FirebaseOptions) obj;
        if (!Objects.equal(this.f15392b, firebaseOptions.f15392b) || !Objects.equal(this.f15391a, firebaseOptions.f15391a) || !Objects.equal(this.f15393c, firebaseOptions.f15393c) || !Objects.equal(this.f15394d, firebaseOptions.f15394d) || !Objects.equal(this.f15395e, firebaseOptions.f15395e) || !Objects.equal(this.f15396f, firebaseOptions.f15396f) || !Objects.equal(this.f15397g, firebaseOptions.f15397g)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return Objects.hashCode(this.f15392b, this.f15391a, this.f15393c, this.f15394d, this.f15395e, this.f15396f, this.f15397g);
    }

    public String toString() {
        return Objects.toStringHelper(this).add("applicationId", this.f15392b).add("apiKey", this.f15391a).add("databaseUrl", this.f15393c).add("gcmSenderId", this.f15395e).add("storageBucket", this.f15396f).add("projectId", this.f15397g).toString();
    }
}
