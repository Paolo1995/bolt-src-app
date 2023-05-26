package ee.mtakso.driver.service.push.handler;

import ee.mtakso.driver.service.push.PushTokenHandler;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: InternalTokenHandler.kt */
/* loaded from: classes3.dex */
public final class InternalTokenHandler implements PushTokenHandler {
    @Override // ee.mtakso.driver.service.push.PushTokenHandler
    public void a(String token) {
        Intrinsics.f(token, "token");
    }
}
