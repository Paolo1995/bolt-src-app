package co.touchlab.kermit;

import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LoggerConfig.kt */
/* loaded from: classes.dex */
public final class StaticConfig implements LoggerConfig {

    /* renamed from: a  reason: collision with root package name */
    private final Severity f8839a;

    /* renamed from: b  reason: collision with root package name */
    private final List<LogWriter> f8840b;

    public StaticConfig() {
        this(null, null, 3, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public StaticConfig(Severity minSeverity, List<? extends LogWriter> logWriterList) {
        Intrinsics.f(minSeverity, "minSeverity");
        Intrinsics.f(logWriterList, "logWriterList");
        this.f8839a = minSeverity;
        this.f8840b = logWriterList;
    }

    @Override // co.touchlab.kermit.LoggerConfig
    public Severity a() {
        return this.f8839a;
    }

    @Override // co.touchlab.kermit.LoggerConfig
    public List<LogWriter> b() {
        return this.f8840b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof StaticConfig) {
            StaticConfig staticConfig = (StaticConfig) obj;
            return a() == staticConfig.a() && Intrinsics.a(b(), staticConfig.b());
        }
        return false;
    }

    public int hashCode() {
        return (a().hashCode() * 31) + b().hashCode();
    }

    public String toString() {
        return "StaticConfig(minSeverity=" + a() + ", logWriterList=" + b() + ')';
    }

    public /* synthetic */ StaticConfig(Severity severity, List list, int i8, DefaultConstructorMarker defaultConstructorMarker) {
        this((i8 & 1) != 0 ? LoggerKt.a() : severity, (i8 & 2) != 0 ? CollectionsKt__CollectionsJVMKt.e(new CommonWriter()) : list);
    }
}
