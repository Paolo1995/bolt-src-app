package com.google.firebase.remoteconfig.internal;

import android.content.SharedPreferences;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigInfo;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings;
import java.util.Date;

/* loaded from: classes3.dex */
public class ConfigMetadataClient {

    /* renamed from: d  reason: collision with root package name */
    static final Date f17117d = new Date(-1);

    /* renamed from: e  reason: collision with root package name */
    static final Date f17118e = new Date(-1);

    /* renamed from: a  reason: collision with root package name */
    private final SharedPreferences f17119a;

    /* renamed from: b  reason: collision with root package name */
    private final Object f17120b = new Object();

    /* renamed from: c  reason: collision with root package name */
    private final Object f17121c = new Object();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class BackoffMetadata {

        /* renamed from: a  reason: collision with root package name */
        private int f17122a;

        /* renamed from: b  reason: collision with root package name */
        private Date f17123b;

        BackoffMetadata(int i8, Date date) {
            this.f17122a = i8;
            this.f17123b = date;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Date a() {
            return this.f17123b;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public int b() {
            return this.f17122a;
        }
    }

    public ConfigMetadataClient(SharedPreferences sharedPreferences) {
        this.f17119a = sharedPreferences;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BackoffMetadata a() {
        BackoffMetadata backoffMetadata;
        synchronized (this.f17121c) {
            backoffMetadata = new BackoffMetadata(this.f17119a.getInt("num_failed_fetches", 0), new Date(this.f17119a.getLong("backoff_end_time_in_millis", -1L)));
        }
        return backoffMetadata;
    }

    public long b() {
        return this.f17119a.getLong("fetch_timeout_in_seconds", 60L);
    }

    public FirebaseRemoteConfigInfo c() {
        FirebaseRemoteConfigInfoImpl a8;
        synchronized (this.f17120b) {
            long j8 = this.f17119a.getLong("last_fetch_time_in_millis", -1L);
            int i8 = this.f17119a.getInt("last_fetch_status", 0);
            a8 = FirebaseRemoteConfigInfoImpl.b().c(i8).d(j8).b(new FirebaseRemoteConfigSettings.Builder().d(this.f17119a.getLong("fetch_timeout_in_seconds", 60L)).e(this.f17119a.getLong("minimum_fetch_interval_in_seconds", ConfigFetchHandler.f17075j)).c()).a();
        }
        return a8;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String d() {
        return this.f17119a.getString("last_fetch_etag", null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Date e() {
        return new Date(this.f17119a.getLong("last_fetch_time_in_millis", -1L));
    }

    public long f() {
        return this.f17119a.getLong("minimum_fetch_interval_in_seconds", ConfigFetchHandler.f17075j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g() {
        h(0, f17118e);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(int i8, Date date) {
        synchronized (this.f17121c) {
            this.f17119a.edit().putInt("num_failed_fetches", i8).putLong("backoff_end_time_in_millis", date.getTime()).apply();
        }
    }

    public void i(FirebaseRemoteConfigSettings firebaseRemoteConfigSettings) {
        synchronized (this.f17120b) {
            this.f17119a.edit().putLong("fetch_timeout_in_seconds", firebaseRemoteConfigSettings.a()).putLong("minimum_fetch_interval_in_seconds", firebaseRemoteConfigSettings.b()).commit();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j(String str) {
        synchronized (this.f17120b) {
            this.f17119a.edit().putString("last_fetch_etag", str).apply();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k() {
        synchronized (this.f17120b) {
            this.f17119a.edit().putInt("last_fetch_status", 1).apply();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void l(Date date) {
        synchronized (this.f17120b) {
            this.f17119a.edit().putInt("last_fetch_status", -1).putLong("last_fetch_time_in_millis", date.getTime()).apply();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void m() {
        synchronized (this.f17120b) {
            this.f17119a.edit().putInt("last_fetch_status", 2).apply();
        }
    }
}
