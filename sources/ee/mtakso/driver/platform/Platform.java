package ee.mtakso.driver.platform;

import ee.mtakso.driver.platform.di.PlatformDependencies;

/* compiled from: Platform.kt */
/* loaded from: classes3.dex */
public final class Platform {

    /* renamed from: a  reason: collision with root package name */
    public static final Platform f23272a = new Platform();

    /* renamed from: b  reason: collision with root package name */
    private static PlatformDependencies f23273b;

    private Platform() {
    }

    public final PlatformDependencies a() {
        return f23273b;
    }

    public final void b(PlatformDependencies platformDependencies) {
        f23273b = platformDependencies;
    }
}
