package com.google.firebase.messaging;

import android.content.Context;
import android.content.SharedPreferences;
import java.lang.ref.WeakReference;
import java.util.concurrent.Executor;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-messaging@@21.1.0 */
/* loaded from: classes3.dex */
public final class TopicsStore {

    /* renamed from: d  reason: collision with root package name */
    private static WeakReference<TopicsStore> f16597d;

    /* renamed from: a  reason: collision with root package name */
    private final SharedPreferences f16598a;

    /* renamed from: b  reason: collision with root package name */
    private SharedPreferencesQueue f16599b;

    /* renamed from: c  reason: collision with root package name */
    private final Executor f16600c;

    private TopicsStore(SharedPreferences sharedPreferences, Executor executor) {
        this.f16600c = executor;
        this.f16598a = sharedPreferences;
    }

    public static synchronized TopicsStore a(Context context, Executor executor) {
        TopicsStore topicsStore;
        synchronized (TopicsStore.class) {
            WeakReference<TopicsStore> weakReference = f16597d;
            if (weakReference != null) {
                topicsStore = weakReference.get();
            } else {
                topicsStore = null;
            }
            if (topicsStore == null) {
                TopicsStore topicsStore2 = new TopicsStore(context.getSharedPreferences("com.google.android.gms.appid", 0), executor);
                topicsStore2.c();
                f16597d = new WeakReference<>(topicsStore2);
                return topicsStore2;
            }
            return topicsStore;
        }
    }

    private synchronized void c() {
        this.f16599b = SharedPreferencesQueue.c(this.f16598a, "topic_operation_queue", ",", this.f16600c);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized TopicOperation b() {
        return TopicOperation.a(this.f16599b.e());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized boolean d(TopicOperation topicOperation) {
        return this.f16599b.f(topicOperation.e());
    }
}
