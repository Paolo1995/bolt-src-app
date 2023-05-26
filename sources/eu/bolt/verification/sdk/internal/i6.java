package eu.bolt.verification.sdk.internal;

import com.google.android.gms.common.internal.ImagesContract;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class i6 implements Serializable {

    /* renamed from: j  reason: collision with root package name */
    public static final a f43499j = new a(null);
    @SerializedName("text")

    /* renamed from: f  reason: collision with root package name */
    private final String f43500f;
    @SerializedName("type")

    /* renamed from: g  reason: collision with root package name */
    private final String f43501g;
    @SerializedName("ui_type")

    /* renamed from: h  reason: collision with root package name */
    private final String f43502h;
    @SerializedName("typed_content")

    /* renamed from: i  reason: collision with root package name */
    private final b f43503i;

    /* loaded from: classes5.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* loaded from: classes5.dex */
    public static final class b implements Serializable {
        @SerializedName(ImagesContract.URL)

        /* renamed from: f  reason: collision with root package name */
        private final String f43504f;
        @SerializedName("story")

        /* renamed from: g  reason: collision with root package name */
        private final String f43505g;

        public b() {
            this(null, null, 3, null);
        }

        public b(String str, String str2) {
            this.f43504f = str;
            this.f43505g = str2;
        }

        public /* synthetic */ b(String str, String str2, int i8, DefaultConstructorMarker defaultConstructorMarker) {
            this((i8 & 1) != 0 ? null : str, (i8 & 2) != 0 ? null : str2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof b) {
                b bVar = (b) obj;
                return Intrinsics.a(this.f43504f, bVar.f43504f) && Intrinsics.a(this.f43505g, bVar.f43505g);
            }
            return false;
        }

        public int hashCode() {
            String str = this.f43504f;
            int hashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.f43505g;
            return hashCode + (str2 != null ? str2.hashCode() : 0);
        }

        public String toString() {
            String str = this.f43504f;
            String str2 = this.f43505g;
            return "TypedContent(url=" + str + ", story=" + str2 + ")";
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof i6) {
            i6 i6Var = (i6) obj;
            return Intrinsics.a(this.f43500f, i6Var.f43500f) && Intrinsics.a(this.f43501g, i6Var.f43501g) && Intrinsics.a(this.f43502h, i6Var.f43502h) && Intrinsics.a(this.f43503i, i6Var.f43503i);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((this.f43500f.hashCode() * 31) + this.f43501g.hashCode()) * 31;
        String str = this.f43502h;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        b bVar = this.f43503i;
        return hashCode2 + (bVar != null ? bVar.hashCode() : 0);
    }

    public String toString() {
        String str = this.f43500f;
        String str2 = this.f43501g;
        String str3 = this.f43502h;
        b bVar = this.f43503i;
        return "ErrorAction(text=" + str + ", type=" + str2 + ", uiType=" + str3 + ", typedContent=" + bVar + ")";
    }
}
