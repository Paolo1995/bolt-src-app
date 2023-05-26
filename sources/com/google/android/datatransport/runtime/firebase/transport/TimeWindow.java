package com.google.android.datatransport.runtime.firebase.transport;

import com.google.firebase.encoders.proto.Protobuf;

/* loaded from: classes.dex */
public final class TimeWindow {

    /* renamed from: c  reason: collision with root package name */
    private static final TimeWindow f12193c = new Builder().a();

    /* renamed from: a  reason: collision with root package name */
    private final long f12194a;

    /* renamed from: b  reason: collision with root package name */
    private final long f12195b;

    /* loaded from: classes.dex */
    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        private long f12196a = 0;

        /* renamed from: b  reason: collision with root package name */
        private long f12197b = 0;

        Builder() {
        }

        public TimeWindow a() {
            return new TimeWindow(this.f12196a, this.f12197b);
        }

        public Builder b(long j8) {
            this.f12197b = j8;
            return this;
        }

        public Builder c(long j8) {
            this.f12196a = j8;
            return this;
        }
    }

    TimeWindow(long j8, long j9) {
        this.f12194a = j8;
        this.f12195b = j9;
    }

    public static Builder c() {
        return new Builder();
    }

    @Protobuf(tag = 2)
    public long a() {
        return this.f12195b;
    }

    @Protobuf(tag = 1)
    public long b() {
        return this.f12194a;
    }
}
