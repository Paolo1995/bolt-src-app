package eu.bolt.driver.core.util;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PendingIntentFactory.kt */
/* loaded from: classes5.dex */
public final class PendingIntentFactory {

    /* renamed from: a  reason: collision with root package name */
    private final Context f41308a;

    /* compiled from: PendingIntentFactory.kt */
    /* loaded from: classes5.dex */
    public enum Type {
        ACTIVITY,
        SERVICE,
        BROADCAST
    }

    /* compiled from: PendingIntentFactory.kt */
    /* loaded from: classes5.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f41313a;

        static {
            int[] iArr = new int[Type.values().length];
            try {
                iArr[Type.ACTIVITY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Type.SERVICE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Type.BROADCAST.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f41313a = iArr;
        }
    }

    public PendingIntentFactory(Context context) {
        Intrinsics.f(context, "context");
        this.f41308a = context;
    }

    public static /* synthetic */ PendingIntent b(PendingIntentFactory pendingIntentFactory, Intent intent, int i8, int i9, Type type, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            i8 = 0;
        }
        if ((i10 & 4) != 0) {
            i9 = 0;
        }
        if ((i10 & 8) != 0) {
            type = Type.ACTIVITY;
        }
        return pendingIntentFactory.a(intent, i8, i9, type);
    }

    private final int c(int i8) {
        if (Build.VERSION.SDK_INT >= 23) {
            return i8 | 67108864;
        }
        return i8;
    }

    public final PendingIntent a(Intent intent, int i8, int i9, Type type) {
        Intrinsics.f(intent, "intent");
        Intrinsics.f(type, "type");
        int i10 = WhenMappings.f41313a[type.ordinal()];
        if (i10 != 1) {
            if (i10 != 2) {
                if (i10 == 3) {
                    PendingIntent broadcast = PendingIntent.getBroadcast(this.f41308a, i8, intent, c(i9));
                    Intrinsics.e(broadcast, "{\n                Pendin…          )\n            }");
                    return broadcast;
                }
                throw new NoWhenBranchMatchedException();
            }
            PendingIntent service = PendingIntent.getService(this.f41308a, i8, intent, c(i9));
            Intrinsics.e(service, "{\n                Pendin…          )\n            }");
            return service;
        }
        PendingIntent activity = PendingIntent.getActivity(this.f41308a, i8, intent, c(i9));
        Intrinsics.e(activity, "{\n                Pendin…          )\n            }");
        return activity;
    }
}
