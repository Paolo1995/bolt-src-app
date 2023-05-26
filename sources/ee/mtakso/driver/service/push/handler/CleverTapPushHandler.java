package ee.mtakso.driver.service.push.handler;

import android.content.Context;
import android.os.Bundle;
import ee.mtakso.driver.platform.push.Push;
import ee.mtakso.driver.service.integration.clevertap.CleverTapManager;
import ee.mtakso.driver.service.push.PushHandler;
import java.util.Map;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CleverTapPushHandler.kt */
/* loaded from: classes3.dex */
public final class CleverTapPushHandler implements PushHandler {

    /* renamed from: a  reason: collision with root package name */
    private final Context f25673a;

    /* renamed from: b  reason: collision with root package name */
    private final CleverTapManager f25674b;

    @Inject
    public CleverTapPushHandler(Context context, CleverTapManager cleverTapManager) {
        Intrinsics.f(context, "context");
        Intrinsics.f(cleverTapManager, "cleverTapManager");
        this.f25673a = context;
        this.f25674b = cleverTapManager;
    }

    private final Bundle c(Map<String, String> map) {
        Bundle bundle = new Bundle();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            bundle.putString(entry.getKey(), entry.getValue());
        }
        return bundle;
    }

    @Override // ee.mtakso.driver.service.push.PushHandler
    public int a() {
        return PushHandler.DefaultImpls.a(this);
    }

    @Override // ee.mtakso.driver.service.push.PushHandler
    public boolean b(Push push) {
        Intrinsics.f(push, "push");
        return this.f25674b.j(this.f25673a, c(push.b()));
    }
}
