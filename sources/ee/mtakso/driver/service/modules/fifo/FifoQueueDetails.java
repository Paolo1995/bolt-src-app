package ee.mtakso.driver.service.modules.fifo;

import ee.mtakso.driver.network.client.order.FifoQueueStateForDriverResponse;
import ee.mtakso.driver.network.client.order.FifoQueueStateResponse;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FifoQueueDetails.kt */
/* loaded from: classes3.dex */
public abstract class FifoQueueDetails {

    /* compiled from: FifoQueueDetails.kt */
    /* loaded from: classes3.dex */
    public static final class Failed extends FifoQueueDetails {

        /* renamed from: a  reason: collision with root package name */
        private final Throwable f24725a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Failed(Throwable throwable) {
            super(null);
            Intrinsics.f(throwable, "throwable");
            this.f24725a = throwable;
        }

        public final Throwable a() {
            return this.f24725a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Failed) && Intrinsics.a(this.f24725a, ((Failed) obj).f24725a);
        }

        public int hashCode() {
            return this.f24725a.hashCode();
        }

        public String toString() {
            Throwable th = this.f24725a;
            return "Failed(throwable=" + th + ")";
        }
    }

    /* compiled from: FifoQueueDetails.kt */
    /* loaded from: classes3.dex */
    public static final class InQueue extends FifoQueueDetails {

        /* renamed from: a  reason: collision with root package name */
        private final FifoQueueStateForDriverResponse f24726a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public InQueue(FifoQueueStateForDriverResponse data) {
            super(null);
            Intrinsics.f(data, "data");
            this.f24726a = data;
        }

        public final FifoQueueStateForDriverResponse a() {
            return this.f24726a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof InQueue) && Intrinsics.a(this.f24726a, ((InQueue) obj).f24726a);
        }

        public int hashCode() {
            return this.f24726a.hashCode();
        }

        public String toString() {
            FifoQueueStateForDriverResponse fifoQueueStateForDriverResponse = this.f24726a;
            return "InQueue(data=" + fifoQueueStateForDriverResponse + ")";
        }
    }

    /* compiled from: FifoQueueDetails.kt */
    /* loaded from: classes3.dex */
    public static final class LoadingInQueue extends FifoQueueDetails {

        /* renamed from: a  reason: collision with root package name */
        public static final LoadingInQueue f24727a = new LoadingInQueue();

        private LoadingInQueue() {
            super(null);
        }
    }

    /* compiled from: FifoQueueDetails.kt */
    /* loaded from: classes3.dex */
    public static final class LoadingProximity extends FifoQueueDetails {

        /* renamed from: a  reason: collision with root package name */
        public static final LoadingProximity f24728a = new LoadingProximity();

        private LoadingProximity() {
            super(null);
        }
    }

    /* compiled from: FifoQueueDetails.kt */
    /* loaded from: classes3.dex */
    public static final class None extends FifoQueueDetails {

        /* renamed from: a  reason: collision with root package name */
        public static final None f24729a = new None();

        private None() {
            super(null);
        }
    }

    /* compiled from: FifoQueueDetails.kt */
    /* loaded from: classes3.dex */
    public static final class Proximity extends FifoQueueDetails {

        /* renamed from: a  reason: collision with root package name */
        private final FifoQueueStateResponse f24730a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Proximity(FifoQueueStateResponse data) {
            super(null);
            Intrinsics.f(data, "data");
            this.f24730a = data;
        }

        public final FifoQueueStateResponse a() {
            return this.f24730a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Proximity) && Intrinsics.a(this.f24730a, ((Proximity) obj).f24730a);
        }

        public int hashCode() {
            return this.f24730a.hashCode();
        }

        public String toString() {
            FifoQueueStateResponse fifoQueueStateResponse = this.f24730a;
            return "Proximity(data=" + fifoQueueStateResponse + ")";
        }
    }

    private FifoQueueDetails() {
    }

    public /* synthetic */ FifoQueueDetails(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
