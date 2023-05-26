package ee.mtakso.driver.service.integration.clevertap;

import ee.mtakso.driver.service.push.PushTokenHandler;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FcmCleverTapPushTokenHandler.kt */
/* loaded from: classes3.dex */
public final class FcmCleverTapPushTokenHandler implements PushTokenHandler {

    /* renamed from: a  reason: collision with root package name */
    private final CleverTapManager f24563a;

    @Inject
    public FcmCleverTapPushTokenHandler(CleverTapManager cleverTapManager) {
        Intrinsics.f(cleverTapManager, "cleverTapManager");
        this.f24563a = cleverTapManager;
    }

    @Override // ee.mtakso.driver.service.push.PushTokenHandler
    public void a(String token) {
        Intrinsics.f(token, "token");
        this.f24563a.w(token);
    }
}
