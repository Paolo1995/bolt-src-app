package com.google.android.datatransport.runtime.scheduling.persistence;

import com.google.android.datatransport.runtime.scheduling.persistence.EventStoreConfig;

/* loaded from: classes.dex */
final class AutoValue_EventStoreConfig extends EventStoreConfig {

    /* renamed from: b  reason: collision with root package name */
    private final long f12286b;

    /* renamed from: c  reason: collision with root package name */
    private final int f12287c;

    /* renamed from: d  reason: collision with root package name */
    private final int f12288d;

    /* renamed from: e  reason: collision with root package name */
    private final long f12289e;

    /* renamed from: f  reason: collision with root package name */
    private final int f12290f;

    /* loaded from: classes.dex */
    static final class Builder extends EventStoreConfig.Builder {

        /* renamed from: a  reason: collision with root package name */
        private Long f12291a;

        /* renamed from: b  reason: collision with root package name */
        private Integer f12292b;

        /* renamed from: c  reason: collision with root package name */
        private Integer f12293c;

        /* renamed from: d  reason: collision with root package name */
        private Long f12294d;

        /* renamed from: e  reason: collision with root package name */
        private Integer f12295e;

        @Override // com.google.android.datatransport.runtime.scheduling.persistence.EventStoreConfig.Builder
        EventStoreConfig a() {
            String str = "";
            if (this.f12291a == null) {
                str = " maxStorageSizeInBytes";
            }
            if (this.f12292b == null) {
                str = str + " loadBatchSize";
            }
            if (this.f12293c == null) {
                str = str + " criticalSectionEnterTimeoutMs";
            }
            if (this.f12294d == null) {
                str = str + " eventCleanUpAge";
            }
            if (this.f12295e == null) {
                str = str + " maxBlobByteSizePerRow";
            }
            if (str.isEmpty()) {
                return new AutoValue_EventStoreConfig(this.f12291a.longValue(), this.f12292b.intValue(), this.f12293c.intValue(), this.f12294d.longValue(), this.f12295e.intValue());
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // com.google.android.datatransport.runtime.scheduling.persistence.EventStoreConfig.Builder
        EventStoreConfig.Builder b(int i8) {
            this.f12293c = Integer.valueOf(i8);
            return this;
        }

        @Override // com.google.android.datatransport.runtime.scheduling.persistence.EventStoreConfig.Builder
        EventStoreConfig.Builder c(long j8) {
            this.f12294d = Long.valueOf(j8);
            return this;
        }

        @Override // com.google.android.datatransport.runtime.scheduling.persistence.EventStoreConfig.Builder
        EventStoreConfig.Builder d(int i8) {
            this.f12292b = Integer.valueOf(i8);
            return this;
        }

        @Override // com.google.android.datatransport.runtime.scheduling.persistence.EventStoreConfig.Builder
        EventStoreConfig.Builder e(int i8) {
            this.f12295e = Integer.valueOf(i8);
            return this;
        }

        @Override // com.google.android.datatransport.runtime.scheduling.persistence.EventStoreConfig.Builder
        EventStoreConfig.Builder f(long j8) {
            this.f12291a = Long.valueOf(j8);
            return this;
        }
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.EventStoreConfig
    int b() {
        return this.f12288d;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.EventStoreConfig
    long c() {
        return this.f12289e;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.EventStoreConfig
    int d() {
        return this.f12287c;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.EventStoreConfig
    int e() {
        return this.f12290f;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof EventStoreConfig)) {
            return false;
        }
        EventStoreConfig eventStoreConfig = (EventStoreConfig) obj;
        if (this.f12286b == eventStoreConfig.f() && this.f12287c == eventStoreConfig.d() && this.f12288d == eventStoreConfig.b() && this.f12289e == eventStoreConfig.c() && this.f12290f == eventStoreConfig.e()) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.EventStoreConfig
    long f() {
        return this.f12286b;
    }

    public int hashCode() {
        long j8 = this.f12286b;
        long j9 = this.f12289e;
        return this.f12290f ^ ((((((((((int) (j8 ^ (j8 >>> 32))) ^ 1000003) * 1000003) ^ this.f12287c) * 1000003) ^ this.f12288d) * 1000003) ^ ((int) ((j9 >>> 32) ^ j9))) * 1000003);
    }

    public String toString() {
        return "EventStoreConfig{maxStorageSizeInBytes=" + this.f12286b + ", loadBatchSize=" + this.f12287c + ", criticalSectionEnterTimeoutMs=" + this.f12288d + ", eventCleanUpAge=" + this.f12289e + ", maxBlobByteSizePerRow=" + this.f12290f + "}";
    }

    private AutoValue_EventStoreConfig(long j8, int i8, int i9, long j9, int i10) {
        this.f12286b = j8;
        this.f12287c = i8;
        this.f12288d = i9;
        this.f12289e = j9;
        this.f12290f = i10;
    }
}
