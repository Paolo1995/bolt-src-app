package ee.mtakso.driver.service.modules.fifo;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FifoQueueState.kt */
/* loaded from: classes3.dex */
public abstract class FifoQueueState {

    /* compiled from: FifoQueueState.kt */
    /* loaded from: classes3.dex */
    public static final class Closed extends FifoQueueState {

        /* renamed from: a  reason: collision with root package name */
        public static final Closed f24757a = new Closed();

        private Closed() {
            super(null);
        }
    }

    /* compiled from: FifoQueueState.kt */
    /* loaded from: classes3.dex */
    public static final class InQueue extends FifoQueueState {

        /* renamed from: a  reason: collision with root package name */
        private final String f24758a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public InQueue(String hash) {
            super(null);
            Intrinsics.f(hash, "hash");
            this.f24758a = hash;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof InQueue) && Intrinsics.a(this.f24758a, ((InQueue) obj).f24758a);
        }

        public int hashCode() {
            return this.f24758a.hashCode();
        }

        public String toString() {
            String str = this.f24758a;
            return "InQueue(hash=" + str + ")";
        }
    }

    /* compiled from: FifoQueueState.kt */
    /* loaded from: classes3.dex */
    public static final class None extends FifoQueueState {

        /* renamed from: a  reason: collision with root package name */
        public static final None f24759a = new None();

        private None() {
            super(null);
        }
    }

    /* compiled from: FifoQueueState.kt */
    /* loaded from: classes3.dex */
    public static final class Proximity extends FifoQueueState {

        /* renamed from: a  reason: collision with root package name */
        private final String f24760a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Proximity(String hash) {
            super(null);
            Intrinsics.f(hash, "hash");
            this.f24760a = hash;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Proximity) && Intrinsics.a(this.f24760a, ((Proximity) obj).f24760a);
        }

        public int hashCode() {
            return this.f24760a.hashCode();
        }

        public String toString() {
            String str = this.f24760a;
            return "Proximity(hash=" + str + ")";
        }
    }

    private FifoQueueState() {
    }

    public /* synthetic */ FifoQueueState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
