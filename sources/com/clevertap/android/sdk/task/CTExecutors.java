package com.clevertap.android.sdk.task;

import com.clevertap.android.sdk.CleverTapInstanceConfig;
import java.util.HashMap;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public class CTExecutors {

    /* renamed from: a  reason: collision with root package name */
    public final IOExecutor f11782a = new IOExecutor();

    /* renamed from: b  reason: collision with root package name */
    public final MainThreadExecutor f11783b;

    /* renamed from: c  reason: collision with root package name */
    public final MainThreadExecutor f11784c;

    /* renamed from: d  reason: collision with root package name */
    protected final CleverTapInstanceConfig f11785d;

    /* renamed from: e  reason: collision with root package name */
    private final HashMap<String, PostAsyncSafelyExecutor> f11786e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CTExecutors(CleverTapInstanceConfig cleverTapInstanceConfig) {
        MainThreadExecutor mainThreadExecutor = new MainThreadExecutor();
        this.f11783b = mainThreadExecutor;
        this.f11784c = mainThreadExecutor;
        this.f11786e = new HashMap<>();
        this.f11785d = cleverTapInstanceConfig;
    }

    public <TResult> Task<TResult> a() {
        return e(this.f11782a, this.f11784c, "ioTask");
    }

    public <TResult> Task<TResult> b() {
        return e(this.f11783b, this.f11784c, "Main");
    }

    public <TResult> Task<TResult> c() {
        return d(this.f11785d.c());
    }

    public <TResult> Task<TResult> d(String str) {
        if (str != null) {
            PostAsyncSafelyExecutor postAsyncSafelyExecutor = this.f11786e.get(str);
            if (postAsyncSafelyExecutor == null) {
                postAsyncSafelyExecutor = new PostAsyncSafelyExecutor();
                this.f11786e.put(str, postAsyncSafelyExecutor);
            }
            return e(postAsyncSafelyExecutor, this.f11784c, "PostAsyncSafely");
        }
        throw new IllegalArgumentException("Tag can't be null");
    }

    public <TResult> Task<TResult> e(Executor executor, Executor executor2, String str) {
        if (executor != null && executor2 != null) {
            return new Task<>(this.f11785d, executor, executor2, str);
        }
        throw new IllegalArgumentException("Can't create task " + str + " with null executors");
    }
}
