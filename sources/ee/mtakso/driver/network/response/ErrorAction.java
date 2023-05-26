package ee.mtakso.driver.network.response;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ImagesContract;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ServerResponse.kt */
/* loaded from: classes3.dex */
public final class ErrorAction implements Parcelable, Serializable {
    @SerializedName("text")

    /* renamed from: f  reason: collision with root package name */
    private final String f23006f;
    @SerializedName("type")

    /* renamed from: g  reason: collision with root package name */
    private final Type f23007g;
    @SerializedName("ui_type")

    /* renamed from: h  reason: collision with root package name */
    private final UiType f23008h;
    @SerializedName("typed_content")

    /* renamed from: i  reason: collision with root package name */
    private final TypedContent f23009i;

    /* renamed from: j  reason: collision with root package name */
    public static final Companion f23005j = new Companion(null);
    public static final Parcelable.Creator<ErrorAction> CREATOR = new Creator();

    /* compiled from: ServerResponse.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: ServerResponse.kt */
    /* loaded from: classes3.dex */
    public static final class Creator implements Parcelable.Creator<ErrorAction> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public final ErrorAction createFromParcel(Parcel parcel) {
            Intrinsics.f(parcel, "parcel");
            return new ErrorAction(parcel.readString(), Type.valueOf(parcel.readString()), UiType.valueOf(parcel.readString()), parcel.readInt() == 0 ? null : TypedContent.CREATOR.createFromParcel(parcel));
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public final ErrorAction[] newArray(int i8) {
            return new ErrorAction[i8];
        }
    }

    /* compiled from: ServerResponse.kt */
    /* loaded from: classes3.dex */
    public enum Type {
        CLOSE,
        URL
    }

    /* compiled from: ServerResponse.kt */
    /* loaded from: classes3.dex */
    public static final class TypedContent implements Parcelable, Serializable {
        @SerializedName(ImagesContract.URL)

        /* renamed from: f  reason: collision with root package name */
        private final String f23011f;

        /* renamed from: g  reason: collision with root package name */
        public static final Companion f23010g = new Companion(null);
        public static final Parcelable.Creator<TypedContent> CREATOR = new Creator();

        /* compiled from: ServerResponse.kt */
        /* loaded from: classes3.dex */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        /* compiled from: ServerResponse.kt */
        /* loaded from: classes3.dex */
        public static final class Creator implements Parcelable.Creator<TypedContent> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public final TypedContent createFromParcel(Parcel parcel) {
                Intrinsics.f(parcel, "parcel");
                return new TypedContent(parcel.readString());
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b */
            public final TypedContent[] newArray(int i8) {
                return new TypedContent[i8];
            }
        }

        public TypedContent(String url) {
            Intrinsics.f(url, "url");
            this.f23011f = url;
        }

        public final String a() {
            return this.f23011f;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof TypedContent) && Intrinsics.a(this.f23011f, ((TypedContent) obj).f23011f);
        }

        public int hashCode() {
            return this.f23011f.hashCode();
        }

        public String toString() {
            String str = this.f23011f;
            return "TypedContent(url=" + str + ")";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel out, int i8) {
            Intrinsics.f(out, "out");
            out.writeString(this.f23011f);
        }
    }

    /* compiled from: ServerResponse.kt */
    /* loaded from: classes3.dex */
    public enum UiType {
        PRIMARY,
        SECONDARY,
        DANGER
    }

    public ErrorAction(String text, Type type, UiType uiType, TypedContent typedContent) {
        Intrinsics.f(text, "text");
        Intrinsics.f(type, "type");
        Intrinsics.f(uiType, "uiType");
        this.f23006f = text;
        this.f23007g = type;
        this.f23008h = uiType;
        this.f23009i = typedContent;
    }

    public final String a() {
        return this.f23006f;
    }

    public final Type b() {
        return this.f23007g;
    }

    public final TypedContent c() {
        return this.f23009i;
    }

    public final UiType d() {
        return this.f23008h;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ErrorAction) {
            ErrorAction errorAction = (ErrorAction) obj;
            return Intrinsics.a(this.f23006f, errorAction.f23006f) && this.f23007g == errorAction.f23007g && this.f23008h == errorAction.f23008h && Intrinsics.a(this.f23009i, errorAction.f23009i);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((((this.f23006f.hashCode() * 31) + this.f23007g.hashCode()) * 31) + this.f23008h.hashCode()) * 31;
        TypedContent typedContent = this.f23009i;
        return hashCode + (typedContent == null ? 0 : typedContent.hashCode());
    }

    public String toString() {
        String str = this.f23006f;
        Type type = this.f23007g;
        UiType uiType = this.f23008h;
        TypedContent typedContent = this.f23009i;
        return "ErrorAction(text=" + str + ", type=" + type + ", uiType=" + uiType + ", typedContent=" + typedContent + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i8) {
        Intrinsics.f(out, "out");
        out.writeString(this.f23006f);
        out.writeString(this.f23007g.name());
        out.writeString(this.f23008h.name());
        TypedContent typedContent = this.f23009i;
        if (typedContent == null) {
            out.writeInt(0);
            return;
        }
        out.writeInt(1);
        typedContent.writeToParcel(out, i8);
    }
}
