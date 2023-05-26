package eu.bolt.chat.logger;

import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.koin.core.logger.Level;
import org.koin.core.logger.Logger;

/* compiled from: KoinLogger.kt */
/* loaded from: classes5.dex */
public final class KoinLogger extends Logger {

    /* compiled from: KoinLogger.kt */
    /* loaded from: classes5.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f39129a;

        static {
            int[] iArr = new int[Level.values().length];
            try {
                iArr[Level.DEBUG.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Level.INFO.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Level.WARNING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[Level.ERROR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[Level.NONE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            f39129a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KoinLogger(Level level) {
        super(level);
        Intrinsics.f(level, "level");
    }

    @Override // org.koin.core.logger.Logger
    public void a(Level level, String msg) {
        Intrinsics.f(level, "level");
        Intrinsics.f(msg, "msg");
        int i8 = WhenMappings.f39129a[level.ordinal()];
        if (i8 != 1) {
            if (i8 != 2) {
                if (i8 != 3) {
                    if (i8 != 4) {
                        if (i8 != 5) {
                            throw new NoWhenBranchMatchedException();
                        }
                        return;
                    }
                    co.touchlab.kermit.Logger.f8826c.b(msg);
                    return;
                }
                co.touchlab.kermit.Logger.f8826c.h(msg);
                return;
            }
            co.touchlab.kermit.Logger.f8826c.e(msg);
            return;
        }
        co.touchlab.kermit.Logger.f8826c.a(msg);
    }
}
