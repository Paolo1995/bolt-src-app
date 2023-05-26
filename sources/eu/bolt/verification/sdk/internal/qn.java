package eu.bolt.verification.sdk.internal;

import eu.bolt.verification.core.domain.model.VerificationFlowStatus;
import java.io.Serializable;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public abstract class qn implements Serializable {

    /* loaded from: classes5.dex */
    public static final class a extends qn {

        /* renamed from: f  reason: collision with root package name */
        private final VerificationFlowStatus f44678f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(VerificationFlowStatus status) {
            super(null);
            Intrinsics.f(status, "status");
            this.f44678f = status;
        }

        public final VerificationFlowStatus a() {
            return this.f44678f;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof a) && this.f44678f == ((a) obj).f44678f;
        }

        public int hashCode() {
            return this.f44678f.hashCode();
        }

        public String toString() {
            VerificationFlowStatus verificationFlowStatus = this.f44678f;
            return "CloseAction(status=" + verificationFlowStatus + ")";
        }
    }

    /* loaded from: classes5.dex */
    public static final class b extends qn {

        /* renamed from: f  reason: collision with root package name */
        private final VerificationFlowStatus f44679f;

        /* renamed from: g  reason: collision with root package name */
        private final String f44680g;

        /* renamed from: h  reason: collision with root package name */
        private final List<k7> f44681h;

        /* renamed from: i  reason: collision with root package name */
        private final String f44682i;

        /* renamed from: j  reason: collision with root package name */
        private final k7 f44683j;

        /* renamed from: k  reason: collision with root package name */
        private final Integer f44684k;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(VerificationFlowStatus status, String id, List<k7> steps, String firstStepId, k7 k7Var, Integer num) {
            super(null);
            Intrinsics.f(status, "status");
            Intrinsics.f(id, "id");
            Intrinsics.f(steps, "steps");
            Intrinsics.f(firstStepId, "firstStepId");
            this.f44679f = status;
            this.f44680g = id;
            this.f44681h = steps;
            this.f44682i = firstStepId;
            this.f44683j = k7Var;
            this.f44684k = num;
        }

        public final k7 a() {
            return this.f44683j;
        }

        public final String b() {
            return this.f44682i;
        }

        public final String c() {
            return this.f44680g;
        }

        public final Integer d() {
            return this.f44684k;
        }

        public final VerificationFlowStatus e() {
            return this.f44679f;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof b) {
                b bVar = (b) obj;
                return this.f44679f == bVar.f44679f && Intrinsics.a(this.f44680g, bVar.f44680g) && Intrinsics.a(this.f44681h, bVar.f44681h) && Intrinsics.a(this.f44682i, bVar.f44682i) && Intrinsics.a(this.f44683j, bVar.f44683j) && Intrinsics.a(this.f44684k, bVar.f44684k);
            }
            return false;
        }

        public final List<k7> f() {
            return this.f44681h;
        }

        public int hashCode() {
            int hashCode = ((((((this.f44679f.hashCode() * 31) + this.f44680g.hashCode()) * 31) + this.f44681h.hashCode()) * 31) + this.f44682i.hashCode()) * 31;
            k7 k7Var = this.f44683j;
            int hashCode2 = (hashCode + (k7Var == null ? 0 : k7Var.hashCode())) * 31;
            Integer num = this.f44684k;
            return hashCode2 + (num != null ? num.hashCode() : 0);
        }

        public String toString() {
            VerificationFlowStatus verificationFlowStatus = this.f44679f;
            String str = this.f44680g;
            List<k7> list = this.f44681h;
            String str2 = this.f44682i;
            k7 k7Var = this.f44683j;
            Integer num = this.f44684k;
            return "FlowModel(status=" + verificationFlowStatus + ", id=" + str + ", steps=" + list + ", firstStepId=" + str2 + ", errorStep=" + k7Var + ", pollIntervalSec=" + num + ")";
        }
    }

    private qn() {
    }

    public /* synthetic */ qn(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
