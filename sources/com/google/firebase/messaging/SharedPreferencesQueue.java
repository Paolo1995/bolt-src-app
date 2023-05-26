package com.google.firebase.messaging;

import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.concurrent.Executor;

/* compiled from: com.google.firebase:firebase-messaging@@21.1.0 */
/* loaded from: classes3.dex */
final class SharedPreferencesQueue {

    /* renamed from: a  reason: collision with root package name */
    private final SharedPreferences f16575a;

    /* renamed from: e  reason: collision with root package name */
    private final Executor f16579e;

    /* renamed from: d  reason: collision with root package name */
    private final ArrayDeque<String> f16578d = new ArrayDeque<>();

    /* renamed from: f  reason: collision with root package name */
    private boolean f16580f = false;

    /* renamed from: b  reason: collision with root package name */
    private final String f16576b = "topic_operation_queue";

    /* renamed from: c  reason: collision with root package name */
    private final String f16577c = ",";

    private SharedPreferencesQueue(SharedPreferences sharedPreferences, String str, String str2, Executor executor) {
        this.f16575a = sharedPreferences;
        this.f16579e = executor;
    }

    private boolean b(boolean z7) {
        if (z7 && !this.f16580f) {
            i();
            return true;
        }
        return z7;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static SharedPreferencesQueue c(SharedPreferences sharedPreferences, String str, String str2, Executor executor) {
        SharedPreferencesQueue sharedPreferencesQueue = new SharedPreferencesQueue(sharedPreferences, "topic_operation_queue", ",", executor);
        sharedPreferencesQueue.d();
        return sharedPreferencesQueue;
    }

    private void d() {
        synchronized (this.f16578d) {
            this.f16578d.clear();
            String string = this.f16575a.getString(this.f16576b, "");
            if (!TextUtils.isEmpty(string) && string.contains(this.f16577c)) {
                String[] split = string.split(this.f16577c, -1);
                if (split.length == 0) {
                    Log.e("FirebaseMessaging", "Corrupted queue. Please check the queue contents and item separator provided");
                }
                for (String str : split) {
                    if (!TextUtils.isEmpty(str)) {
                        this.f16578d.add(str);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public void a() {
        synchronized (this.f16578d) {
            this.f16575a.edit().putString(this.f16576b, g()).commit();
        }
    }

    private void i() {
        this.f16579e.execute(new Runnable(this) { // from class: com.google.firebase.messaging.SharedPreferencesQueue$$Lambda$0

            /* renamed from: f  reason: collision with root package name */
            private final SharedPreferencesQueue f16581f;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f16581f = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f16581f.a();
            }
        });
    }

    public String e() {
        String peek;
        synchronized (this.f16578d) {
            peek = this.f16578d.peek();
        }
        return peek;
    }

    public boolean f(Object obj) {
        boolean remove;
        synchronized (this.f16578d) {
            remove = this.f16578d.remove(obj);
            b(remove);
        }
        return remove;
    }

    @NonNull
    public String g() {
        StringBuilder sb = new StringBuilder();
        Iterator<String> it = this.f16578d.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            sb.append(this.f16577c);
        }
        return sb.toString();
    }
}
