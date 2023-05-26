package ee.mtakso.driver.service.push;

import ee.mtakso.driver.service.BaseService;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AuthPushService.kt */
/* loaded from: classes3.dex */
public final class AuthPushService implements BaseService {

    /* renamed from: a  reason: collision with root package name */
    private final PushManagerImpl f25590a;

    /* renamed from: b  reason: collision with root package name */
    private final Set<PushHandler> f25591b;

    /* renamed from: c  reason: collision with root package name */
    private final Set<PushTokenHandler> f25592c;

    /* renamed from: d  reason: collision with root package name */
    private final AtomicBoolean f25593d;

    @Inject
    public AuthPushService(PushManagerImpl pushManager, Set<PushHandler> messageHandlers, Set<PushTokenHandler> tokenHandlers) {
        Intrinsics.f(pushManager, "pushManager");
        Intrinsics.f(messageHandlers, "messageHandlers");
        Intrinsics.f(tokenHandlers, "tokenHandlers");
        this.f25590a = pushManager;
        this.f25591b = messageHandlers;
        this.f25592c = tokenHandlers;
        this.f25593d = new AtomicBoolean(false);
    }

    @Override // ee.mtakso.driver.service.BaseService
    public boolean start() {
        if (!this.f25593d.compareAndSet(false, true)) {
            return false;
        }
        this.f25590a.e(this.f25591b);
        this.f25590a.f(this.f25592c);
        this.f25590a.i();
        return true;
    }

    @Override // ee.mtakso.driver.service.BaseService
    public void stop() {
        this.f25590a.g(this.f25591b);
        this.f25590a.h(this.f25592c);
        this.f25593d.set(false);
    }
}
