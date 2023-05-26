package ee.mtakso.driver.service.chat;

import ee.mtakso.driver.service.connectivity.NetworkConnectionStatus;
import ee.mtakso.driver.service.connectivity.NetworkService;
import eu.bolt.chat.chatcore.network.connection.NetworkConnectionInfoProvider;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import javax.inject.Inject;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ChatNetworkInfoProvider.kt */
/* loaded from: classes3.dex */
public final class ChatNetworkInfoProvider implements NetworkConnectionInfoProvider {

    /* renamed from: a  reason: collision with root package name */
    private final NetworkService f23997a;

    @Inject
    public ChatNetworkInfoProvider(NetworkService networkService) {
        Intrinsics.f(networkService, "networkService");
        this.f23997a = networkService;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Boolean c(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (Boolean) tmp0.invoke(obj);
    }

    @Override // eu.bolt.chat.chatcore.network.connection.NetworkConnectionInfoProvider
    public Observable<Boolean> a() {
        Observable<NetworkConnectionStatus> d8 = this.f23997a.d();
        final ChatNetworkInfoProvider$observeNetworkConnection$1 chatNetworkInfoProvider$observeNetworkConnection$1 = new Function1<NetworkConnectionStatus, Boolean>() { // from class: ee.mtakso.driver.service.chat.ChatNetworkInfoProvider$observeNetworkConnection$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final Boolean invoke(NetworkConnectionStatus it) {
                boolean z7;
                Intrinsics.f(it, "it");
                if (it == NetworkConnectionStatus.CONNECTED) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                return Boolean.valueOf(z7);
            }
        };
        Observable map = d8.map(new Function() { // from class: ee.mtakso.driver.service.chat.b
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                Boolean c8;
                c8 = ChatNetworkInfoProvider.c(Function1.this, obj);
                return c8;
            }
        });
        Intrinsics.e(map, "networkService.observeFo…nectionStatus.CONNECTED }");
        return map;
    }
}
