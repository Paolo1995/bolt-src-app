package eu.bolt.verification.sdk.internal;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import eu.bolt.verification.core.network.adapter.VerificationButtonActionConditionAdapter;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

@JsonAdapter(VerificationButtonActionConditionAdapter.class)
/* loaded from: classes5.dex */
public abstract class pm {

    /* loaded from: classes5.dex */
    public static final class a extends pm {
        @SerializedName("check_box_group_id")

        /* renamed from: a  reason: collision with root package name */
        private final String f44554a;
        @SerializedName("required_variant_ids")

        /* renamed from: b  reason: collision with root package name */
        private final List<String> f44555b;

        public final String a() {
            return this.f44554a;
        }

        public final List<String> b() {
            return this.f44555b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof a) {
                a aVar = (a) obj;
                return Intrinsics.a(this.f44554a, aVar.f44554a) && Intrinsics.a(this.f44555b, aVar.f44555b);
            }
            return false;
        }

        public int hashCode() {
            return (this.f44554a.hashCode() * 31) + this.f44555b.hashCode();
        }

        public String toString() {
            String str = this.f44554a;
            List<String> list = this.f44555b;
            return "CheckBoxSelected(checkBoxGroupId=" + str + ", requiredVariantIds=" + list + ")";
        }
    }

    /* loaded from: classes5.dex */
    public static final class b extends pm {
        @SerializedName("field_id")

        /* renamed from: a  reason: collision with root package name */
        private final String f44556a;
        @SerializedName("regex")

        /* renamed from: b  reason: collision with root package name */
        private final String f44557b;

        public final String a() {
            return this.f44556a;
        }

        public final String b() {
            return this.f44557b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof b) {
                b bVar = (b) obj;
                return Intrinsics.a(this.f44556a, bVar.f44556a) && Intrinsics.a(this.f44557b, bVar.f44557b);
            }
            return false;
        }

        public int hashCode() {
            return (this.f44556a.hashCode() * 31) + this.f44557b.hashCode();
        }

        public String toString() {
            String str = this.f44556a;
            String str2 = this.f44557b;
            return "FieldRegex(fieldId=" + str + ", regex=" + str2 + ")";
        }
    }

    /* loaded from: classes5.dex */
    public static final class c extends pm {
        @SerializedName("required_element_id")

        /* renamed from: a  reason: collision with root package name */
        private final String f44558a;

        public final String a() {
            return this.f44558a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof c) && Intrinsics.a(this.f44558a, ((c) obj).f44558a);
        }

        public int hashCode() {
            return this.f44558a.hashCode();
        }

        public String toString() {
            String str = this.f44558a;
            return "HasRequiredAnswer(requiredElementId=" + str + ")";
        }
    }

    private pm() {
    }
}
