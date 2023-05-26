package okhttp3.internal.proxy;

import java.io.IOException;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.SocketAddress;
import java.net.URI;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;

/* compiled from: NullProxySelector.kt */
/* loaded from: classes5.dex */
public final class NullProxySelector extends ProxySelector {
    public static final NullProxySelector INSTANCE = new NullProxySelector();

    private NullProxySelector() {
    }

    @Override // java.net.ProxySelector
    public void connectFailed(URI uri, SocketAddress socketAddress, IOException iOException) {
    }

    @Override // java.net.ProxySelector
    public List<Proxy> select(URI uri) {
        List<Proxy> e8;
        if (uri != null) {
            e8 = CollectionsKt__CollectionsJVMKt.e(Proxy.NO_PROXY);
            return e8;
        }
        throw new IllegalArgumentException("uri must not be null".toString());
    }
}
