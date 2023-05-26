package org.koin.core.logger;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Logger.kt */
/* loaded from: classes5.dex */
public abstract class Logger {

    /* renamed from: a  reason: collision with root package name */
    private Level f52770a;

    public Logger() {
        this(null, 1, null);
    }

    public Logger(Level level) {
        Intrinsics.f(level, "level");
        this.f52770a = level;
    }

    public abstract void a(Level level, String str);

    public final boolean b(Level lvl) {
        Intrinsics.f(lvl, "lvl");
        if (this.f52770a.compareTo(lvl) <= 0) {
            return true;
        }
        return false;
    }

    public /* synthetic */ Logger(Level level, int i8, DefaultConstructorMarker defaultConstructorMarker) {
        this((i8 & 1) != 0 ? Level.INFO : level);
    }
}
