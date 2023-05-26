package kotlin.internal;

import kotlin.internal.jdk7.JDK7PlatformImplementations;
import kotlin.internal.jdk8.JDK8PlatformImplementations;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PlatformImplementations.kt */
/* loaded from: classes5.dex */
public final class PlatformImplementationsKt {

    /* renamed from: a  reason: collision with root package name */
    public static final PlatformImplementations f50939a;

    static {
        PlatformImplementations platformImplementations;
        Object newInstance;
        try {
            newInstance = JDK8PlatformImplementations.class.newInstance();
            Intrinsics.e(newInstance, "forName(\"kotlin.internal…entations\").newInstance()");
            try {
                try {
                } catch (ClassCastException e8) {
                    ClassLoader classLoader = newInstance.getClass().getClassLoader();
                    ClassLoader classLoader2 = PlatformImplementations.class.getClassLoader();
                    if (!Intrinsics.a(classLoader, classLoader2)) {
                        throw new ClassNotFoundException("Instance class was loaded from a different classloader: " + classLoader + ", base type classloader: " + classLoader2, e8);
                    }
                    throw e8;
                }
            } catch (ClassNotFoundException unused) {
                Object newInstance2 = JDK7PlatformImplementations.class.newInstance();
                Intrinsics.e(newInstance2, "forName(\"kotlin.internal…entations\").newInstance()");
                try {
                    try {
                        if (newInstance2 != null) {
                            platformImplementations = (PlatformImplementations) newInstance2;
                        } else {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
                        }
                    } catch (ClassNotFoundException unused2) {
                        platformImplementations = new PlatformImplementations();
                    }
                } catch (ClassCastException e9) {
                    ClassLoader classLoader3 = newInstance2.getClass().getClassLoader();
                    ClassLoader classLoader4 = PlatformImplementations.class.getClassLoader();
                    if (!Intrinsics.a(classLoader3, classLoader4)) {
                        throw new ClassNotFoundException("Instance class was loaded from a different classloader: " + classLoader3 + ", base type classloader: " + classLoader4, e9);
                    }
                    throw e9;
                }
            }
        } catch (ClassNotFoundException unused3) {
            Object newInstance3 = Class.forName("kotlin.internal.JRE8PlatformImplementations").newInstance();
            Intrinsics.e(newInstance3, "forName(\"kotlin.internal…entations\").newInstance()");
            try {
                try {
                    if (newInstance3 != null) {
                        platformImplementations = (PlatformImplementations) newInstance3;
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
                    }
                } catch (ClassNotFoundException unused4) {
                    Object newInstance4 = Class.forName("kotlin.internal.JRE7PlatformImplementations").newInstance();
                    Intrinsics.e(newInstance4, "forName(\"kotlin.internal…entations\").newInstance()");
                    try {
                        if (newInstance4 != null) {
                            platformImplementations = (PlatformImplementations) newInstance4;
                        } else {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
                        }
                    } catch (ClassCastException e10) {
                        ClassLoader classLoader5 = newInstance4.getClass().getClassLoader();
                        ClassLoader classLoader6 = PlatformImplementations.class.getClassLoader();
                        if (!Intrinsics.a(classLoader5, classLoader6)) {
                            throw new ClassNotFoundException("Instance class was loaded from a different classloader: " + classLoader5 + ", base type classloader: " + classLoader6, e10);
                        }
                        throw e10;
                    }
                }
            } catch (ClassCastException e11) {
                ClassLoader classLoader7 = newInstance3.getClass().getClassLoader();
                ClassLoader classLoader8 = PlatformImplementations.class.getClassLoader();
                if (!Intrinsics.a(classLoader7, classLoader8)) {
                    throw new ClassNotFoundException("Instance class was loaded from a different classloader: " + classLoader7 + ", base type classloader: " + classLoader8, e11);
                }
                throw e11;
            }
        }
        if (newInstance != null) {
            platformImplementations = (PlatformImplementations) newInstance;
            f50939a = platformImplementations;
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
    }
}
