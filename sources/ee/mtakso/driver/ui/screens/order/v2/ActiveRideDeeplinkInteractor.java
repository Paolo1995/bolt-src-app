package ee.mtakso.driver.ui.screens.order.v2;

import ee.mtakso.driver.deeplink.DeepLinkManager;
import ee.mtakso.driver.deeplink.DeeplinkCall;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ActiveRideDeeplinkInteractor.kt */
/* loaded from: classes3.dex */
public final class ActiveRideDeeplinkInteractor {

    /* renamed from: a  reason: collision with root package name */
    private final DeepLinkManager f31896a;

    @Inject
    public ActiveRideDeeplinkInteractor(DeepLinkManager deepLinkManager) {
        Intrinsics.f(deepLinkManager, "deepLinkManager");
        this.f31896a = deepLinkManager;
    }

    public final DeeplinkCall a() {
        List e8;
        Object obj;
        e8 = CollectionsKt__CollectionsJVMKt.e(DeeplinkCall.Chat.class);
        Iterator it = e8.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (this.f31896a.f((Class) obj)) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        Class<? extends DeeplinkCall> cls = (Class) obj;
        if (cls == null) {
            return null;
        }
        return this.f31896a.c(cls);
    }
}
