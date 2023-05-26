package com.google.android.datatransport.runtime.firebase.transport;

import com.google.firebase.encoders.proto.Protobuf;

/* loaded from: classes.dex */
public final class StorageMetrics {

    /* renamed from: c  reason: collision with root package name */
    private static final StorageMetrics f12188c = new Builder().a();

    /* renamed from: a  reason: collision with root package name */
    private final long f12189a;

    /* renamed from: b  reason: collision with root package name */
    private final long f12190b;

    /* loaded from: classes.dex */
    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        private long f12191a = 0;

        /* renamed from: b  reason: collision with root package name */
        private long f12192b = 0;

        Builder() {
        }

        public StorageMetrics a() {
            return new StorageMetrics(this.f12191a, this.f12192b);
        }

        public Builder b(long j8) {
            this.f12191a = j8;
            return this;
        }

        public Builder c(long j8) {
            this.f12192b = j8;
            return this;
        }
    }

    StorageMetrics(long j8, long j9) {
        this.f12189a = j8;
        this.f12190b = j9;
    }

    public static Builder c() {
        return new Builder();
    }

    @Protobuf(tag = 1)
    public long a() {
        return this.f12189a;
    }

    @Protobuf(tag = 2)
    public long b() {
        return this.f12190b;
    }
}
