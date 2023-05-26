package com.google.firebase.remoteconfig.internal;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import java.util.Date;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final /* synthetic */ class ConfigFetchHandler$$Lambda$2 implements Continuation {

    /* renamed from: a  reason: collision with root package name */
    private final ConfigFetchHandler f17088a;

    /* renamed from: b  reason: collision with root package name */
    private final Task f17089b;

    /* renamed from: c  reason: collision with root package name */
    private final Task f17090c;

    /* renamed from: d  reason: collision with root package name */
    private final Date f17091d;

    private ConfigFetchHandler$$Lambda$2(ConfigFetchHandler configFetchHandler, Task task, Task task2, Date date) {
        this.f17088a = configFetchHandler;
        this.f17089b = task;
        this.f17090c = task2;
        this.f17091d = date;
    }

    public static Continuation a(ConfigFetchHandler configFetchHandler, Task task, Task task2, Date date) {
        return new ConfigFetchHandler$$Lambda$2(configFetchHandler, task, task2, date);
    }

    @Override // com.google.android.gms.tasks.Continuation
    public Object then(Task task) {
        return ConfigFetchHandler.o(this.f17088a, this.f17089b, this.f17090c, this.f17091d, task);
    }
}
