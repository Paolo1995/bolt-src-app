package eu.bolt.verification.sdk.internal;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class io {
    @SerializedName("flow_run_uuid")

    /* renamed from: a  reason: collision with root package name */
    private final String f43577a;
    @SerializedName("user_inputs")

    /* renamed from: b  reason: collision with root package name */
    private final List<a> f43578b;
    @SerializedName("is_first_request")

    /* renamed from: c  reason: collision with root package name */
    private final boolean f43579c;

    /* loaded from: classes5.dex */
    public static final class a {
        @SerializedName("field_id")

        /* renamed from: a  reason: collision with root package name */
        private final String f43580a;
        @SerializedName("values")

        /* renamed from: b  reason: collision with root package name */
        private final Set<String> f43581b;

        public a(String fieldId, Set<String> values) {
            Intrinsics.f(fieldId, "fieldId");
            Intrinsics.f(values, "values");
            this.f43580a = fieldId;
            this.f43581b = values;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof a) {
                a aVar = (a) obj;
                return Intrinsics.a(this.f43580a, aVar.f43580a) && Intrinsics.a(this.f43581b, aVar.f43581b);
            }
            return false;
        }

        public int hashCode() {
            return (this.f43580a.hashCode() * 31) + this.f43581b.hashCode();
        }

        public String toString() {
            String str = this.f43580a;
            Set<String> set = this.f43581b;
            return "UserInput(fieldId=" + str + ", values=" + set + ")";
        }
    }

    public io(String flowRunUuid, List<a> list, boolean z7) {
        Intrinsics.f(flowRunUuid, "flowRunUuid");
        this.f43577a = flowRunUuid;
        this.f43578b = list;
        this.f43579c = z7;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof io) {
            io ioVar = (io) obj;
            return Intrinsics.a(this.f43577a, ioVar.f43577a) && Intrinsics.a(this.f43578b, ioVar.f43578b) && this.f43579c == ioVar.f43579c;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = this.f43577a.hashCode() * 31;
        List<a> list = this.f43578b;
        int hashCode2 = (hashCode + (list == null ? 0 : list.hashCode())) * 31;
        boolean z7 = this.f43579c;
        int i8 = z7;
        if (z7 != 0) {
            i8 = 1;
        }
        return hashCode2 + i8;
    }

    public String toString() {
        String str = this.f43577a;
        List<a> list = this.f43578b;
        boolean z7 = this.f43579c;
        return "VerificationGetFlowDetailsRequest(flowRunUuid=" + str + ", userInputs=" + list + ", isFirstRequest=" + z7 + ")";
    }
}
