package com.bumptech.glide.util;

import androidx.annotation.NonNull;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class Executors {

    /* renamed from: a  reason: collision with root package name */
    private static final Executor f10773a = new Executor() { // from class: com.bumptech.glide.util.Executors.1
        @Override // java.util.concurrent.Executor
        public void execute(@NonNull Runnable runnable) {
            Util.u(runnable);
        }
    };

    /* renamed from: b  reason: collision with root package name */
    private static final Executor f10774b = new Executor() { // from class: com.bumptech.glide.util.Executors.2
        @Override // java.util.concurrent.Executor
        public void execute(@NonNull Runnable runnable) {
            runnable.run();
        }
    };

    private Executors() {
    }

    public static Executor a() {
        return f10774b;
    }

    public static Executor b() {
        return f10773a;
    }
}
