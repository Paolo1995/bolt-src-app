package eu.bolt.verification.sdk.internal;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import eu.bolt.verification.core.network.adapter.VerificationFlowDetailsResponseAdapter;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@JsonAdapter(VerificationFlowDetailsResponseAdapter.class)
/* loaded from: classes5.dex */
public abstract class jo extends dh {
    @SerializedName("type")

    /* renamed from: d  reason: collision with root package name */
    private final String f43760d;
    @SerializedName("status")

    /* renamed from: e  reason: collision with root package name */
    private final String f43761e;

    /* loaded from: classes5.dex */
    public static final class a extends jo {

        /* renamed from: f  reason: collision with root package name */
        public static final a f43762f = new a();

        private a() {
            super(null, null, 3, null);
        }
    }

    /* loaded from: classes5.dex */
    public static final class b extends jo {
        @SerializedName("payload")

        /* renamed from: f  reason: collision with root package name */
        private final a f43763f;

        /* loaded from: classes5.dex */
        public static final class a {
            @SerializedName("steps")

            /* renamed from: a  reason: collision with root package name */
            private final List<yp> f43764a;
            @SerializedName("first_step_id")

            /* renamed from: b  reason: collision with root package name */
            private final String f43765b;
            @SerializedName("poll_interval_sec")

            /* renamed from: c  reason: collision with root package name */
            private final Integer f43766c;
            @SerializedName("media_upload_failed_step")

            /* renamed from: d  reason: collision with root package name */
            private final yp f43767d;

            public final yp a() {
                return this.f43767d;
            }

            public final String b() {
                return this.f43765b;
            }

            public final Integer c() {
                return this.f43766c;
            }

            public final List<yp> d() {
                return this.f43764a;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof a) {
                    a aVar = (a) obj;
                    return Intrinsics.a(this.f43764a, aVar.f43764a) && Intrinsics.a(this.f43765b, aVar.f43765b) && Intrinsics.a(this.f43766c, aVar.f43766c) && Intrinsics.a(this.f43767d, aVar.f43767d);
                }
                return false;
            }

            public int hashCode() {
                int hashCode = ((this.f43764a.hashCode() * 31) + this.f43765b.hashCode()) * 31;
                Integer num = this.f43766c;
                int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
                yp ypVar = this.f43767d;
                return hashCode2 + (ypVar != null ? ypVar.hashCode() : 0);
            }

            public String toString() {
                List<yp> list = this.f43764a;
                String str = this.f43765b;
                Integer num = this.f43766c;
                yp ypVar = this.f43767d;
                return "Payload(steps=" + list + ", firstStepId=" + str + ", pollIntervalSec=" + num + ", errorStep=" + ypVar + ")";
            }
        }

        public final a b() {
            return this.f43763f;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof b) && Intrinsics.a(this.f43763f, ((b) obj).f43763f);
        }

        public int hashCode() {
            return this.f43763f.hashCode();
        }

        public String toString() {
            a aVar = this.f43763f;
            return "ShowStepSdkPayload(payload=" + aVar + ")";
        }
    }

    private jo(String str, String str2) {
        this.f43760d = str;
        this.f43761e = str2;
    }

    public /* synthetic */ jo(String str, String str2, int i8, DefaultConstructorMarker defaultConstructorMarker) {
        this((i8 & 1) != 0 ? "" : str, (i8 & 2) != 0 ? "" : str2, null);
    }

    public /* synthetic */ jo(String str, String str2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2);
    }

    public final String a() {
        return this.f43761e;
    }
}
