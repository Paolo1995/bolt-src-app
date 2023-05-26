package com.google.firebase.heartbeatinfo;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import j$.time.ZoneOffset;
import j$.time.format.DateTimeFormatter;
import j$.util.DateRetargetClass;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class HeartBeatInfoStorage {

    /* renamed from: a  reason: collision with root package name */
    private final SharedPreferences f16270a;

    public HeartBeatInfoStorage(Context context, String str) {
        this.f16270a = context.getSharedPreferences("FirebaseHeartBeat" + str, 0);
    }

    private synchronized void a() {
        long j8 = this.f16270a.getLong("fire-count", 0L);
        String str = null;
        String str2 = "";
        for (Map.Entry<String, ?> entry : this.f16270a.getAll().entrySet()) {
            if (entry.getValue() instanceof Set) {
                for (String str3 : (Set) entry.getValue()) {
                    if (str == null || str.compareTo(str3) > 0) {
                        str2 = entry.getKey();
                        str = str3;
                    }
                }
            }
        }
        HashSet hashSet = new HashSet(this.f16270a.getStringSet(str2, new HashSet()));
        hashSet.remove(str);
        this.f16270a.edit().putStringSet(str2, hashSet).putLong("fire-count", j8 - 1).commit();
    }

    private synchronized String d(long j8) {
        if (Build.VERSION.SDK_INT >= 26) {
            return DateRetargetClass.toInstant(new Date(j8)).atOffset(ZoneOffset.UTC).toLocalDateTime().format(DateTimeFormatter.ISO_LOCAL_DATE);
        }
        return new SimpleDateFormat("yyyy-MM-dd", Locale.UK).format(new Date(j8));
    }

    private synchronized String e(String str) {
        for (Map.Entry<String, ?> entry : this.f16270a.getAll().entrySet()) {
            if (entry.getValue() instanceof Set) {
                for (String str2 : (Set) entry.getValue()) {
                    if (str.equals(str2)) {
                        return entry.getKey();
                    }
                }
                continue;
            }
        }
        return null;
    }

    private synchronized void h(String str) {
        String e8 = e(str);
        if (e8 == null) {
            return;
        }
        HashSet hashSet = new HashSet(this.f16270a.getStringSet(e8, new HashSet()));
        hashSet.remove(str);
        if (hashSet.isEmpty()) {
            this.f16270a.edit().remove(e8).commit();
        } else {
            this.f16270a.edit().putStringSet(e8, hashSet).commit();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void b() {
        SharedPreferences.Editor edit = this.f16270a.edit();
        for (Map.Entry<String, ?> entry : this.f16270a.getAll().entrySet()) {
            if (entry.getValue() instanceof Set) {
                edit.remove(entry.getKey());
            }
        }
        edit.remove("fire-count");
        edit.commit();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized List<HeartBeatResult> c() {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (Map.Entry<String, ?> entry : this.f16270a.getAll().entrySet()) {
            if (entry.getValue() instanceof Set) {
                arrayList.add(HeartBeatResult.a(entry.getKey(), new ArrayList((Set) entry.getValue())));
            }
        }
        l(System.currentTimeMillis());
        return arrayList;
    }

    synchronized boolean f(long j8, long j9) {
        return d(j8).equals(d(j9));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void g() {
        String d8 = d(System.currentTimeMillis());
        this.f16270a.edit().putString("last-used-date", d8).commit();
        h(d8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized boolean i(long j8) {
        return j("fire-global", j8);
    }

    synchronized boolean j(String str, long j8) {
        if (this.f16270a.contains(str)) {
            if (!f(this.f16270a.getLong(str, -1L), j8)) {
                this.f16270a.edit().putLong(str, j8).commit();
                return true;
            }
            return false;
        }
        this.f16270a.edit().putLong(str, j8).commit();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void k(long j8, String str) {
        String d8 = d(j8);
        if (this.f16270a.getString("last-used-date", "").equals(d8)) {
            return;
        }
        long j9 = this.f16270a.getLong("fire-count", 0L);
        if (j9 + 1 == 30) {
            a();
            j9 = this.f16270a.getLong("fire-count", 0L);
        }
        HashSet hashSet = new HashSet(this.f16270a.getStringSet(str, new HashSet()));
        hashSet.add(d8);
        this.f16270a.edit().putStringSet(str, hashSet).putLong("fire-count", j9 + 1).putString("last-used-date", d8).commit();
    }

    synchronized void l(long j8) {
        this.f16270a.edit().putLong("fire-global", j8).commit();
    }
}
