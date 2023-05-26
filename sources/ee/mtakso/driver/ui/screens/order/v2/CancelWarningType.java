package ee.mtakso.driver.ui.screens.order.v2;

import ee.mtakso.driver.network.client.order.RejectReason;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OrderViewModel.kt */
/* loaded from: classes3.dex */
public abstract class CancelWarningType {

    /* renamed from: a  reason: collision with root package name */
    private final List<RejectReason> f31912a;

    /* compiled from: OrderViewModel.kt */
    /* loaded from: classes3.dex */
    public static final class CampaignWarning extends CancelWarningType {

        /* renamed from: b  reason: collision with root package name */
        private final List<RejectReason> f31913b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CampaignWarning(List<RejectReason> reasons) {
            super(reasons, null);
            Intrinsics.f(reasons, "reasons");
            this.f31913b = reasons;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof CampaignWarning) && Intrinsics.a(this.f31913b, ((CampaignWarning) obj).f31913b);
        }

        public int hashCode() {
            return this.f31913b.hashCode();
        }

        public String toString() {
            List<RejectReason> list = this.f31913b;
            return "CampaignWarning(reasons=" + list + ")";
        }
    }

    /* compiled from: OrderViewModel.kt */
    /* loaded from: classes3.dex */
    public static final class Confirmation extends CancelWarningType {

        /* renamed from: b  reason: collision with root package name */
        private final CharSequence f31914b;

        /* renamed from: c  reason: collision with root package name */
        private final List<RejectReason> f31915c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Confirmation(CharSequence confirmation, List<RejectReason> reasons) {
            super(reasons, null);
            Intrinsics.f(confirmation, "confirmation");
            Intrinsics.f(reasons, "reasons");
            this.f31914b = confirmation;
            this.f31915c = reasons;
        }

        public final CharSequence b() {
            return this.f31914b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Confirmation) {
                Confirmation confirmation = (Confirmation) obj;
                return Intrinsics.a(this.f31914b, confirmation.f31914b) && Intrinsics.a(this.f31915c, confirmation.f31915c);
            }
            return false;
        }

        public int hashCode() {
            return (this.f31914b.hashCode() * 31) + this.f31915c.hashCode();
        }

        public String toString() {
            CharSequence charSequence = this.f31914b;
            List<RejectReason> list = this.f31915c;
            return "Confirmation(confirmation=" + ((Object) charSequence) + ", reasons=" + list + ")";
        }
    }

    /* compiled from: OrderViewModel.kt */
    /* loaded from: classes3.dex */
    public static final class DriverScoreAndCampaignWarning extends CancelWarningType {

        /* renamed from: b  reason: collision with root package name */
        private final List<RejectReason> f31916b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DriverScoreAndCampaignWarning(List<RejectReason> reasons) {
            super(reasons, null);
            Intrinsics.f(reasons, "reasons");
            this.f31916b = reasons;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof DriverScoreAndCampaignWarning) && Intrinsics.a(this.f31916b, ((DriverScoreAndCampaignWarning) obj).f31916b);
        }

        public int hashCode() {
            return this.f31916b.hashCode();
        }

        public String toString() {
            List<RejectReason> list = this.f31916b;
            return "DriverScoreAndCampaignWarning(reasons=" + list + ")";
        }
    }

    /* compiled from: OrderViewModel.kt */
    /* loaded from: classes3.dex */
    public static final class DriverScoreWarning extends CancelWarningType {

        /* renamed from: b  reason: collision with root package name */
        private final List<RejectReason> f31917b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DriverScoreWarning(List<RejectReason> reasons) {
            super(reasons, null);
            Intrinsics.f(reasons, "reasons");
            this.f31917b = reasons;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof DriverScoreWarning) && Intrinsics.a(this.f31917b, ((DriverScoreWarning) obj).f31917b);
        }

        public int hashCode() {
            return this.f31917b.hashCode();
        }

        public String toString() {
            List<RejectReason> list = this.f31917b;
            return "DriverScoreWarning(reasons=" + list + ")";
        }
    }

    private CancelWarningType(List<RejectReason> list) {
        this.f31912a = list;
    }

    public /* synthetic */ CancelWarningType(List list, DefaultConstructorMarker defaultConstructorMarker) {
        this(list);
    }

    public final List<RejectReason> a() {
        return this.f31912a;
    }
}
