package eu.bolt.android.rib.lifecycle;

import android.os.Bundle;
import java.util.Locale;

/* loaded from: classes5.dex */
public class ActivityLifecycleEvent {

    /* renamed from: b  reason: collision with root package name */
    private static final ActivityLifecycleEvent f37146b = new ActivityLifecycleEvent(Type.START);

    /* renamed from: c  reason: collision with root package name */
    private static final ActivityLifecycleEvent f37147c = new ActivityLifecycleEvent(Type.RESUME);

    /* renamed from: d  reason: collision with root package name */
    private static final ActivityLifecycleEvent f37148d = new ActivityLifecycleEvent(Type.PAUSE);

    /* renamed from: e  reason: collision with root package name */
    private static final ActivityLifecycleEvent f37149e = new ActivityLifecycleEvent(Type.STOP);

    /* renamed from: f  reason: collision with root package name */
    private static final ActivityLifecycleEvent f37150f = new ActivityLifecycleEvent(Type.DESTROY);

    /* renamed from: a  reason: collision with root package name */
    private final Type f37151a;

    /* renamed from: eu.bolt.android.rib.lifecycle.ActivityLifecycleEvent$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f37152a;

        static {
            int[] iArr = new int[Type.values().length];
            f37152a = iArr;
            try {
                iArr[Type.START.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f37152a[Type.RESUME.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f37152a[Type.PAUSE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f37152a[Type.STOP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f37152a[Type.DESTROY.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class Create extends ActivityLifecycleEvent {

        /* renamed from: g  reason: collision with root package name */
        private final Bundle f37153g;

        private Create(Bundle bundle) {
            super(Type.CREATE);
            this.f37153g = bundle;
        }
    }

    /* loaded from: classes5.dex */
    public enum Type {
        CREATE,
        START,
        RESUME,
        PAUSE,
        STOP,
        DESTROY
    }

    private ActivityLifecycleEvent(Type type) {
        this.f37151a = type;
    }

    private static String a(String str) {
        return Character.toUpperCase(str.charAt(0)) + str.substring(1);
    }

    public static ActivityLifecycleEvent b(Type type) {
        int i8 = AnonymousClass1.f37152a[type.ordinal()];
        if (i8 != 1) {
            if (i8 != 2) {
                if (i8 != 3) {
                    if (i8 != 4) {
                        if (i8 == 5) {
                            return f37150f;
                        }
                        throw new IllegalArgumentException("Use the createOn" + a(type.name().toLowerCase(Locale.US)) + "Event() method for this type!");
                    }
                    return f37149e;
                }
                return f37148d;
            }
            return f37147c;
        }
        return f37146b;
    }

    public static Create c(Bundle bundle) {
        return new Create(bundle);
    }

    public Type d() {
        return this.f37151a;
    }

    public boolean e() {
        Type type = this.f37151a;
        if (type != Type.RESUME && type != Type.START && type != Type.PAUSE) {
            return false;
        }
        return true;
    }
}
