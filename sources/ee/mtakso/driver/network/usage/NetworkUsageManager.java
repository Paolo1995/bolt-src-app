package ee.mtakso.driver.network.usage;

import android.net.TrafficStats;
import android.os.Process;
import eu.bolt.kalev.Kalev;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NetworkUsageManager.kt */
/* loaded from: classes3.dex */
public final class NetworkUsageManager {

    /* renamed from: a  reason: collision with root package name */
    private final int f23025a = Process.myUid();

    /* renamed from: b  reason: collision with root package name */
    private final NetworkUsage f23026b = b();

    public final NetworkUsage a(NetworkUsage lastNetworkUsage) {
        Intrinsics.f(lastNetworkUsage, "lastNetworkUsage");
        NetworkUsage b8 = b();
        long sentBytes = b8.getSentBytes() - lastNetworkUsage.getSentBytes();
        long receivedBytes = b8.getReceivedBytes() - lastNetworkUsage.getReceivedBytes();
        Throwable th = new Throwable("Network Usage Measure");
        Kalev.e(th, "sentBytes: " + sentBytes + ", receivedBytes: " + receivedBytes);
        return new NetworkUsage(sentBytes, receivedBytes, sentBytes + receivedBytes);
    }

    public final NetworkUsage b() {
        long uidTxBytes = TrafficStats.getUidTxBytes(this.f23025a);
        long uidRxBytes = TrafficStats.getUidRxBytes(this.f23025a);
        return new NetworkUsage(uidTxBytes, uidRxBytes, uidTxBytes + uidRxBytes);
    }
}
