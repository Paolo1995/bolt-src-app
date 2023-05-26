package org.koin.core;

import java.util.List;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.koin.core.logger.Level;
import org.koin.core.logger.Logger;
import org.koin.core.module.Module;
import org.koin.mp.KoinPlatformTimeTools;

/* compiled from: KoinApplication.kt */
/* loaded from: classes5.dex */
public final class KoinApplication {

    /* renamed from: c  reason: collision with root package name */
    public static final Companion f52735c = new Companion(null);

    /* renamed from: a  reason: collision with root package name */
    private final Koin f52736a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f52737b;

    /* compiled from: KoinApplication.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KoinApplication a() {
            return new KoinApplication(null);
        }
    }

    private KoinApplication() {
        this.f52736a = new Koin();
        this.f52737b = true;
    }

    public /* synthetic */ KoinApplication(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private final void c(List<Module> list) {
        this.f52736a.f(list, this.f52737b);
    }

    public final void a() {
        this.f52736a.a();
    }

    public final Koin b() {
        return this.f52736a;
    }

    public final KoinApplication d(Logger logger) {
        Intrinsics.f(logger, "logger");
        this.f52736a.g(logger);
        return this;
    }

    public final KoinApplication e(List<Module> modules) {
        Intrinsics.f(modules, "modules");
        Logger d8 = this.f52736a.d();
        Level level = Level.INFO;
        if (d8.b(level)) {
            KoinPlatformTimeTools koinPlatformTimeTools = KoinPlatformTimeTools.f52810a;
            long a8 = koinPlatformTimeTools.a();
            c(modules);
            double doubleValue = ((Number) new Pair(Unit.f50853a, Double.valueOf((koinPlatformTimeTools.a() - a8) / 1000000.0d)).e()).doubleValue();
            int j8 = this.f52736a.c().j();
            Logger d9 = this.f52736a.d();
            d9.a(level, "loaded " + j8 + " definitions in " + doubleValue + " ms");
        } else {
            c(modules);
        }
        return this;
    }

    public final KoinApplication f(Module... modules) {
        List<Module> f02;
        Intrinsics.f(modules, "modules");
        f02 = ArraysKt___ArraysKt.f0(modules);
        return e(f02);
    }
}
