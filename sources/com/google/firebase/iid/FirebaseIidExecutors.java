package com.google.firebase.iid;

import com.google.android.gms.common.util.concurrent.NamedThreadFactory;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.firebase:firebase-iid@@21.1.0 */
/* loaded from: classes3.dex */
class FirebaseIidExecutors {

    /* renamed from: a  reason: collision with root package name */
    private static final Executor f16275a = FirebaseIidExecutors$$Lambda$0.f16276f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Executor a() {
        return f16275a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ExecutorService b() {
        return new ThreadPoolExecutor(0, 1, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new NamedThreadFactory("firebase-iid-executor"));
    }
}
