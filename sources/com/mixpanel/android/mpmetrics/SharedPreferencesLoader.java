package com.mixpanel.android.mpmetrics;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/* loaded from: classes3.dex */
class SharedPreferencesLoader {

    /* renamed from: a  reason: collision with root package name */
    private final Executor f19360a = Executors.newSingleThreadExecutor();

    /* loaded from: classes3.dex */
    private static class LoadSharedPreferences implements Callable<SharedPreferences> {

        /* renamed from: f  reason: collision with root package name */
        private final Context f19361f;

        /* renamed from: g  reason: collision with root package name */
        private final String f19362g;

        /* renamed from: h  reason: collision with root package name */
        private final OnPrefsLoadedListener f19363h;

        public LoadSharedPreferences(Context context, String str, OnPrefsLoadedListener onPrefsLoadedListener) {
            this.f19361f = context;
            this.f19362g = str;
            this.f19363h = onPrefsLoadedListener;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public SharedPreferences call() {
            SharedPreferences sharedPreferences = this.f19361f.getSharedPreferences(this.f19362g, 0);
            OnPrefsLoadedListener onPrefsLoadedListener = this.f19363h;
            if (onPrefsLoadedListener != null) {
                onPrefsLoadedListener.a(sharedPreferences);
            }
            return sharedPreferences;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public interface OnPrefsLoadedListener {
        void a(SharedPreferences sharedPreferences);
    }

    public Future<SharedPreferences> a(Context context, String str, OnPrefsLoadedListener onPrefsLoadedListener) {
        FutureTask futureTask = new FutureTask(new LoadSharedPreferences(context, str, onPrefsLoadedListener));
        this.f19360a.execute(futureTask);
        return futureTask;
    }
}
