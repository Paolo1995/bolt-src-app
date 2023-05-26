package com.google.android.datatransport.runtime.scheduling.persistence;

import com.google.android.datatransport.runtime.scheduling.persistence.AutoValue_EventStoreConfig;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class EventStoreConfig {

    /* renamed from: a  reason: collision with root package name */
    static final EventStoreConfig f12299a = a().f(10485760).d(200).b(10000).c(604800000).e(81920).a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static abstract class Builder {
        abstract EventStoreConfig a();

        abstract Builder b(int i8);

        abstract Builder c(long j8);

        abstract Builder d(int i8);

        abstract Builder e(int i8);

        abstract Builder f(long j8);
    }

    static Builder a() {
        return new AutoValue_EventStoreConfig.Builder();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract int b();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract long c();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract int d();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract int e();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract long f();
}
