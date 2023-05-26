package com.google.android.datatransport.runtime.firebase.transport;

import com.google.firebase.encoders.proto.Protobuf;

/* loaded from: classes.dex */
public final class GlobalMetrics {

    /* renamed from: b  reason: collision with root package name */
    private static final GlobalMetrics f12166b = new Builder().a();

    /* renamed from: a  reason: collision with root package name */
    private final StorageMetrics f12167a;

    /* loaded from: classes.dex */
    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        private StorageMetrics f12168a = null;

        Builder() {
        }

        public GlobalMetrics a() {
            return new GlobalMetrics(this.f12168a);
        }

        public Builder b(StorageMetrics storageMetrics) {
            this.f12168a = storageMetrics;
            return this;
        }
    }

    GlobalMetrics(StorageMetrics storageMetrics) {
        this.f12167a = storageMetrics;
    }

    public static Builder b() {
        return new Builder();
    }

    @Protobuf(tag = 1)
    public StorageMetrics a() {
        return this.f12167a;
    }
}
