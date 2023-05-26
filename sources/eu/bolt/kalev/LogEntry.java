package eu.bolt.kalev;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LogEntry.kt */
/* loaded from: classes5.dex */
public class LogEntry {

    /* renamed from: a  reason: collision with root package name */
    private String f41675a;

    /* renamed from: b  reason: collision with root package name */
    private Throwable f41676b;

    /* renamed from: c  reason: collision with root package name */
    private Long f41677c;

    /* renamed from: d  reason: collision with root package name */
    public String f41678d;

    /* renamed from: e  reason: collision with root package name */
    public String f41679e;

    /* renamed from: f  reason: collision with root package name */
    private final Map<String, Object> f41680f = new LinkedHashMap();

    public void a(String message) {
        Intrinsics.g(message, "message");
        j(message, "d");
    }

    public void b(String message) {
        Intrinsics.g(message, "message");
        j(message, "e");
    }

    public final Map<String, Object> c() {
        return this.f41680f;
    }

    public final String d() {
        String str = this.f41679e;
        if (str == null) {
            Intrinsics.w("message");
        }
        return str;
    }

    public final String e() {
        String str = this.f41678d;
        if (str == null) {
            Intrinsics.w("severity");
        }
        return str;
    }

    public final String f() {
        return this.f41675a;
    }

    public final Throwable g() {
        return this.f41676b;
    }

    public final Long h() {
        return this.f41677c;
    }

    public void i(String message) {
        Intrinsics.g(message, "message");
        j(message, "i");
    }

    public void j(String message, String severity) {
        Intrinsics.g(message, "message");
        Intrinsics.g(severity, "severity");
        this.f41678d = severity;
        this.f41677c = Long.valueOf(new Date().getTime());
        this.f41679e = message;
        Kalev.f41674e.i(this);
    }

    public LogEntry k(String tag) {
        Intrinsics.g(tag, "tag");
        this.f41675a = tag;
        return this;
    }

    public void l(String message) {
        Intrinsics.g(message, "message");
        j(message, "v");
    }

    public void m(String message) {
        Intrinsics.g(message, "message");
        j(message, "w");
    }

    public LogEntry n(String key, Object obj) {
        Intrinsics.g(key, "key");
        this.f41680f.put(key, obj);
        return this;
    }

    public LogEntry o(Throwable throwable) {
        Intrinsics.g(throwable, "throwable");
        this.f41676b = throwable;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("LogEntry(tag=");
        sb.append(this.f41675a);
        sb.append(", throwable=");
        sb.append(this.f41676b);
        sb.append(", timestamp=");
        sb.append(this.f41677c);
        sb.append(", severity='");
        String str = this.f41678d;
        if (str == null) {
            Intrinsics.w("severity");
        }
        sb.append(str);
        sb.append("', message='");
        String str2 = this.f41679e;
        if (str2 == null) {
            Intrinsics.w("message");
        }
        sb.append(str2);
        sb.append("', data=");
        sb.append(this.f41680f);
        sb.append(')');
        return sb.toString();
    }
}
