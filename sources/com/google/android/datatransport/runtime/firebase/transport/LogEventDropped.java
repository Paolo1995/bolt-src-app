package com.google.android.datatransport.runtime.firebase.transport;

import com.google.firebase.encoders.proto.ProtoEnum;
import com.google.firebase.encoders.proto.Protobuf;

/* loaded from: classes.dex */
public final class LogEventDropped {

    /* renamed from: c  reason: collision with root package name */
    private static final LogEventDropped f12169c = new Builder().a();

    /* renamed from: a  reason: collision with root package name */
    private final long f12170a;

    /* renamed from: b  reason: collision with root package name */
    private final Reason f12171b;

    /* loaded from: classes.dex */
    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        private long f12172a = 0;

        /* renamed from: b  reason: collision with root package name */
        private Reason f12173b = Reason.REASON_UNKNOWN;

        Builder() {
        }

        public LogEventDropped a() {
            return new LogEventDropped(this.f12172a, this.f12173b);
        }

        public Builder b(long j8) {
            this.f12172a = j8;
            return this;
        }

        public Builder c(Reason reason) {
            this.f12173b = reason;
            return this;
        }
    }

    /* loaded from: classes.dex */
    public enum Reason implements ProtoEnum {
        REASON_UNKNOWN(0),
        MESSAGE_TOO_OLD(1),
        CACHE_FULL(2),
        PAYLOAD_TOO_BIG(3),
        MAX_RETRIES_REACHED(4),
        INVALID_PAYLOD(5),
        SERVER_ERROR(6);
        

        /* renamed from: f  reason: collision with root package name */
        private final int f12182f;

        Reason(int i8) {
            this.f12182f = i8;
        }

        @Override // com.google.firebase.encoders.proto.ProtoEnum
        public int getNumber() {
            return this.f12182f;
        }
    }

    LogEventDropped(long j8, Reason reason) {
        this.f12170a = j8;
        this.f12171b = reason;
    }

    public static Builder c() {
        return new Builder();
    }

    @Protobuf(tag = 1)
    public long a() {
        return this.f12170a;
    }

    @Protobuf(tag = 3)
    public Reason b() {
        return this.f12171b;
    }
}
