package com.google.android.datatransport.runtime.firebase.transport;

import com.google.android.datatransport.runtime.ProtoEncoderDoNotUse;
import com.google.firebase.encoders.proto.Protobuf;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public final class ClientMetrics {

    /* renamed from: e  reason: collision with root package name */
    private static final ClientMetrics f12157e = new Builder().b();

    /* renamed from: a  reason: collision with root package name */
    private final TimeWindow f12158a;

    /* renamed from: b  reason: collision with root package name */
    private final List<LogSourceMetrics> f12159b;

    /* renamed from: c  reason: collision with root package name */
    private final GlobalMetrics f12160c;

    /* renamed from: d  reason: collision with root package name */
    private final String f12161d;

    /* loaded from: classes.dex */
    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        private TimeWindow f12162a = null;

        /* renamed from: b  reason: collision with root package name */
        private List<LogSourceMetrics> f12163b = new ArrayList();

        /* renamed from: c  reason: collision with root package name */
        private GlobalMetrics f12164c = null;

        /* renamed from: d  reason: collision with root package name */
        private String f12165d = "";

        Builder() {
        }

        public Builder a(LogSourceMetrics logSourceMetrics) {
            this.f12163b.add(logSourceMetrics);
            return this;
        }

        public ClientMetrics b() {
            return new ClientMetrics(this.f12162a, Collections.unmodifiableList(this.f12163b), this.f12164c, this.f12165d);
        }

        public Builder c(String str) {
            this.f12165d = str;
            return this;
        }

        public Builder d(GlobalMetrics globalMetrics) {
            this.f12164c = globalMetrics;
            return this;
        }

        public Builder e(TimeWindow timeWindow) {
            this.f12162a = timeWindow;
            return this;
        }
    }

    ClientMetrics(TimeWindow timeWindow, List<LogSourceMetrics> list, GlobalMetrics globalMetrics, String str) {
        this.f12158a = timeWindow;
        this.f12159b = list;
        this.f12160c = globalMetrics;
        this.f12161d = str;
    }

    public static Builder e() {
        return new Builder();
    }

    @Protobuf(tag = 4)
    public String a() {
        return this.f12161d;
    }

    @Protobuf(tag = 3)
    public GlobalMetrics b() {
        return this.f12160c;
    }

    @Protobuf(tag = 2)
    public List<LogSourceMetrics> c() {
        return this.f12159b;
    }

    @Protobuf(tag = 1)
    public TimeWindow d() {
        return this.f12158a;
    }

    public byte[] f() {
        return ProtoEncoderDoNotUse.a(this);
    }
}
