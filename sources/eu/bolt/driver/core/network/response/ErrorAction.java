package eu.bolt.driver.core.network.response;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ImagesContract;
import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ErrorAction.kt */
/* loaded from: classes5.dex */
public final class ErrorAction implements Parcelable {
    public static final Parcelable.Creator<ErrorAction> CREATOR = new Creator();
    @SerializedName("text")

    /* renamed from: f  reason: collision with root package name */
    private final String f40881f;
    @SerializedName("type")

    /* renamed from: g  reason: collision with root package name */
    private final Type f40882g;
    @SerializedName("ui_type")

    /* renamed from: h  reason: collision with root package name */
    private final UiType f40883h;
    @SerializedName("typed_content")

    /* renamed from: i  reason: collision with root package name */
    private final TypedContent f40884i;

    /* compiled from: ErrorAction.kt */
    /* loaded from: classes5.dex */
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

    /* compiled from: ErrorAction.kt */
    /* loaded from: classes5.dex */
    public enum Type {
        CLOSE,
        URL
    }

    /* compiled from: ErrorAction.kt */
    /* loaded from: classes5.dex */
    public static final class TypedContent implements Parcelable {
        public static final Parcelable.Creator<TypedContent> CREATOR = new Creator();
        @SerializedName(ImagesContract.URL)

        /* renamed from: f  reason: collision with root package name */
        private final String f40885f;

        /* compiled from: ErrorAction.kt */
        /* loaded from: classes5.dex */
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
            this.f40885f = url;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof TypedContent) && Intrinsics.a(this.f40885f, ((TypedContent) obj).f40885f);
        }

        public int hashCode() {
            return this.f40885f.hashCode();
        }

        public String toString() {
            String str = this.f40885f;
            return "TypedContent(url=" + str + ")";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel out, int i8) {
            Intrinsics.f(out, "out");
            out.writeString(this.f40885f);
        }
    }

    /* compiled from: ErrorAction.kt */
    /* loaded from: classes5.dex */
    public enum UiType {
        PRIMARY,
        SECONDARY,
        DANGER
    }

    public ErrorAction(String text, Type type, UiType uiType, TypedContent typedContent) {
        Intrinsics.f(text, "text");
        Intrinsics.f(type, "type");
        Intrinsics.f(uiType, "uiType");
        this.f40881f = text;
        this.f40882g = type;
        this.f40883h = uiType;
        this.f40884i = typedContent;
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
            return Intrinsics.a(this.f40881f, errorAction.f40881f) && this.f40882g == errorAction.f40882g && this.f40883h == errorAction.f40883h && Intrinsics.a(this.f40884i, errorAction.f40884i);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((((this.f40881f.hashCode() * 31) + this.f40882g.hashCode()) * 31) + this.f40883h.hashCode()) * 31;
        TypedContent typedContent = this.f40884i;
        return hashCode + (typedContent == null ? 0 : typedContent.hashCode());
    }

    public String toString() {
        String str = this.f40881f;
        Type type = this.f40882g;
        UiType uiType = this.f40883h;
        TypedContent typedContent = this.f40884i;
        return "ErrorAction(text=" + str + ", type=" + type + ", uiType=" + uiType + ", typedContent=" + typedContent + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i8) {
        Intrinsics.f(out, "out");
        out.writeString(this.f40881f);
        out.writeString(this.f40882g.name());
        out.writeString(this.f40883h.name());
        TypedContent typedContent = this.f40884i;
        if (typedContent == null) {
            out.writeInt(0);
            return;
        }
        out.writeInt(1);
        typedContent.writeToParcel(out, i8);
    }
}
