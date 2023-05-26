package com.google.android.datatransport.runtime.firebase.transport;

import com.google.firebase.encoders.proto.Protobuf;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public final class LogSourceMetrics {

    /* renamed from: c  reason: collision with root package name */
    private static final LogSourceMetrics f12183c = new Builder().a();

    /* renamed from: a  reason: collision with root package name */
    private final String f12184a;

    /* renamed from: b  reason: collision with root package name */
    private final List<LogEventDropped> f12185b;

    /* loaded from: classes.dex */
    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        private String f12186a = "";

        /* renamed from: b  reason: collision with root package name */
        private List<LogEventDropped> f12187b = new ArrayList();

        Builder() {
        }

        public LogSourceMetrics a() {
            return new LogSourceMetrics(this.f12186a, Collections.unmodifiableList(this.f12187b));
        }

        public Builder b(List<LogEventDropped> list) {
            this.f12187b = list;
            return this;
        }

        public Builder c(String str) {
            this.f12186a = str;
            return this;
        }
    }

    LogSourceMetrics(String str, List<LogEventDropped> list) {
        this.f12184a = str;
        this.f12185b = list;
    }

    public static Builder c() {
        return new Builder();
    }

    @Protobuf(tag = 2)
    public List<LogEventDropped> a() {
        return this.f12185b;
    }

    @Protobuf(tag = 1)
    public String b() {
        return this.f12184a;
    }
}
