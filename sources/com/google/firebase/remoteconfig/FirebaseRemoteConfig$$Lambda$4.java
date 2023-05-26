package com.google.firebase.remoteconfig;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final /* synthetic */ class FirebaseRemoteConfig$$Lambda$4 implements Continuation {

    /* renamed from: a  reason: collision with root package name */
    private final FirebaseRemoteConfig f17025a;

    /* renamed from: b  reason: collision with root package name */
    private final Task f17026b;

    /* renamed from: c  reason: collision with root package name */
    private final Task f17027c;

    private FirebaseRemoteConfig$$Lambda$4(FirebaseRemoteConfig firebaseRemoteConfig, Task task, Task task2) {
        this.f17025a = firebaseRemoteConfig;
        this.f17026b = task;
        this.f17027c = task2;
    }

    public static Continuation a(FirebaseRemoteConfig firebaseRemoteConfig, Task task, Task task2) {
        return new FirebaseRemoteConfig$$Lambda$4(firebaseRemoteConfig, task, task2);
    }

    @Override // com.google.android.gms.tasks.Continuation
    public Object then(Task task) {
        return FirebaseRemoteConfig.j(this.f17025a, this.f17026b, this.f17027c, task);
    }
}
