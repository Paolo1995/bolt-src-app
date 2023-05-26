package ee.mtakso.driver.service.modules.fifo;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: FifoQueuePollingState.kt */
/* loaded from: classes3.dex */
public final class FifoQueuePollingState {

    /* renamed from: a  reason: collision with root package name */
    private final String f24746a;

    /* renamed from: b  reason: collision with root package name */
    private final String f24747b;

    public FifoQueuePollingState(String str, String str2) {
        this.f24746a = str;
        this.f24747b = str2;
    }

    public final String a() {
        return this.f24746a;
    }

    public final String b() {
        return this.f24747b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof FifoQueuePollingState) {
            FifoQueuePollingState fifoQueuePollingState = (FifoQueuePollingState) obj;
            return Intrinsics.a(this.f24746a, fifoQueuePollingState.f24746a) && Intrinsics.a(this.f24747b, fifoQueuePollingState.f24747b);
        }
        return false;
    }

    public int hashCode() {
        String str = this.f24746a;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.f24747b;
        return hashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        String str = this.f24746a;
        String str2 = this.f24747b;
        return "FifoQueuePollingState(fifoQueueState=" + str + ", fifoQueueStateForDriver=" + str2 + ")";
    }
}
