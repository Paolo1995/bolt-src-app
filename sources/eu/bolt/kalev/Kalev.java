package eu.bolt.kalev;

import eu.bolt.kalev.fast.FastLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Kalev.kt */
/* loaded from: classes5.dex */
public final class Kalev {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f41670a;

    /* renamed from: c  reason: collision with root package name */
    private static FastLog f41672c;

    /* renamed from: e  reason: collision with root package name */
    public static final Kalev f41674e = new Kalev();

    /* renamed from: b  reason: collision with root package name */
    private static final NopLogEntry f41671b = NopLogEntry.f41681g;

    /* renamed from: d  reason: collision with root package name */
    private static final List<Kalevipoeg> f41673d = new ArrayList();

    private Kalev() {
    }

    public static final void a(Kalevipoeg consumer) {
        Intrinsics.g(consumer, "consumer");
        f41673d.add(consumer);
    }

    public static final void b(String message) {
        Intrinsics.g(message, "message");
        f41674e.f().j(message, "d");
    }

    public static final void c(Throwable throwable, String message) {
        Intrinsics.g(throwable, "throwable");
        Intrinsics.g(message, "message");
        o(throwable).j(message, "d");
    }

    public static final void d(String message) {
        Intrinsics.g(message, "message");
        f41674e.f().j(message, "e");
    }

    public static final void e(Throwable throwable, String message) {
        Intrinsics.g(throwable, "throwable");
        Intrinsics.g(message, "message");
        o(throwable).j(message, "e");
    }

    public static final void h(String message) {
        Intrinsics.g(message, "message");
        f41674e.f().j(message, "i");
    }

    public static final LogEntry j(String tag) {
        Intrinsics.g(tag, "tag");
        return f41674e.f().k(tag);
    }

    public static final void k(String message) {
        Intrinsics.g(message, "message");
        f41674e.f().j(message, "v");
    }

    public static final void l(String message) {
        Intrinsics.g(message, "message");
        f41674e.f().j(message, "w");
    }

    public static final void m(Throwable throwable, String message) {
        Intrinsics.g(throwable, "throwable");
        Intrinsics.g(message, "message");
        o(throwable).j(message, "w");
    }

    public static final LogEntry n(String key, Object obj) {
        Intrinsics.g(key, "key");
        return f41674e.f().n(key, obj);
    }

    public static final LogEntry o(Throwable error) {
        Intrinsics.g(error, "error");
        return f41674e.f().o(error);
    }

    public final LogEntry f() {
        if (f41670a) {
            return f41671b;
        }
        return new LogEntry();
    }

    public final FastLog g() {
        return f41672c;
    }

    public final void i(LogEntry entry) {
        Intrinsics.g(entry, "entry");
        for (Kalevipoeg kalevipoeg : f41673d) {
            kalevipoeg.a(entry);
        }
    }
}
