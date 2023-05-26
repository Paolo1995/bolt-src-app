package ee.mtakso.driver.deeplink;

import android.content.Intent;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* compiled from: DeepLinkManager.kt */
@Singleton
/* loaded from: classes3.dex */
public final class DeepLinkManager {

    /* renamed from: a  reason: collision with root package name */
    private final DeepLinkParser f19991a;

    /* renamed from: b  reason: collision with root package name */
    private final Map<Class<DeeplinkCall>, DeeplinkCall> f19992b;

    @Inject
    public DeepLinkManager(DeepLinkParser deepLinkParser) {
        Intrinsics.f(deepLinkParser, "deepLinkParser");
        this.f19991a = deepLinkParser;
        this.f19992b = new LinkedHashMap();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void a(DeeplinkCall deeplinkCall) {
        this.f19992b.put(deeplinkCall.getClass(), deeplinkCall);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final DeeplinkCall b(DeeplinkCall action) {
        Intrinsics.f(action, "action");
        return c(action.getClass());
    }

    public final DeeplinkCall c(Class<? extends DeeplinkCall> actionClass) {
        Intrinsics.f(actionClass, "actionClass");
        DeeplinkCall deeplinkCall = this.f19992b.get(actionClass);
        TypeIntrinsics.d(this.f19992b).remove(actionClass);
        return deeplinkCall;
    }

    public final List<DeeplinkCall> d() {
        List<DeeplinkCall> H0;
        H0 = CollectionsKt___CollectionsKt.H0(this.f19992b.values());
        return H0;
    }

    public final void e(Intent intent) {
        Intrinsics.f(intent, "intent");
        DeeplinkCall d8 = this.f19991a.d(intent);
        if (d8 != null) {
            a(d8);
        }
    }

    public final boolean f(Class<? extends DeeplinkCall> actionClass) {
        Intrinsics.f(actionClass, "actionClass");
        return this.f19992b.containsKey(actionClass);
    }
}
