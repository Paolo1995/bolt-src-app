package okhttp3;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Dns.kt */
/* loaded from: classes5.dex */
public interface Dns {
    public static final Companion Companion = Companion.$$INSTANCE;
    public static final Dns SYSTEM = new Companion.DnsSystem();

    /* compiled from: Dns.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        /* compiled from: Dns.kt */
        /* loaded from: classes5.dex */
        private static final class DnsSystem implements Dns {
            @Override // okhttp3.Dns
            public List<InetAddress> lookup(String hostname) {
                List<InetAddress> f02;
                Intrinsics.f(hostname, "hostname");
                try {
                    InetAddress[] allByName = InetAddress.getAllByName(hostname);
                    Intrinsics.e(allByName, "getAllByName(hostname)");
                    f02 = ArraysKt___ArraysKt.f0(allByName);
                    return f02;
                } catch (NullPointerException e8) {
                    UnknownHostException unknownHostException = new UnknownHostException(Intrinsics.n("Broken system behaviour for dns lookup of ", hostname));
                    unknownHostException.initCause(e8);
                    throw unknownHostException;
                }
            }
        }

        private Companion() {
        }
    }

    List<InetAddress> lookup(String str) throws UnknownHostException;
}
