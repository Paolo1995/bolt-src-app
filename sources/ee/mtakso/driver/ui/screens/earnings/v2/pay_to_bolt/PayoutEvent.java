package ee.mtakso.driver.ui.screens.earnings.v2.pay_to_bolt;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PayoutEvent.kt */
/* loaded from: classes3.dex */
public abstract class PayoutEvent {

    /* compiled from: PayoutEvent.kt */
    /* loaded from: classes3.dex */
    public static final class LoadError extends PayoutEvent {

        /* renamed from: a  reason: collision with root package name */
        private final Throwable f28654a;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof LoadError) && Intrinsics.a(this.f28654a, ((LoadError) obj).f28654a);
        }

        public int hashCode() {
            return this.f28654a.hashCode();
        }

        public String toString() {
            Throwable th = this.f28654a;
            return "LoadError(err=" + th + ")";
        }
    }

    /* compiled from: PayoutEvent.kt */
    /* loaded from: classes3.dex */
    public static final class PayToBoltLinkReady extends PayoutEvent {

        /* renamed from: a  reason: collision with root package name */
        private final String f28655a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PayToBoltLinkReady(String link) {
            super(null);
            Intrinsics.f(link, "link");
            this.f28655a = link;
        }

        public final String a() {
            return this.f28655a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof PayToBoltLinkReady) && Intrinsics.a(this.f28655a, ((PayToBoltLinkReady) obj).f28655a);
        }

        public int hashCode() {
            return this.f28655a.hashCode();
        }

        public String toString() {
            String str = this.f28655a;
            return "PayToBoltLinkReady(link=" + str + ")";
        }
    }

    private PayoutEvent() {
    }

    public /* synthetic */ PayoutEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
