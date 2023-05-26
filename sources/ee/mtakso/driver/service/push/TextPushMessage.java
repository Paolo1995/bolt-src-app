package ee.mtakso.driver.service.push;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PushMessage.kt */
/* loaded from: classes3.dex */
public final class TextPushMessage extends PushMessage {
    public static final Parcelable.Creator<TextPushMessage> CREATOR = new Creator();

    /* renamed from: f  reason: collision with root package name */
    private final String f25660f;

    /* renamed from: g  reason: collision with root package name */
    private final String f25661g;

    /* renamed from: h  reason: collision with root package name */
    private final String f25662h;

    /* compiled from: PushMessage.kt */
    /* loaded from: classes3.dex */
    public static final class Creator implements Parcelable.Creator<TextPushMessage> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public final TextPushMessage createFromParcel(Parcel parcel) {
            Intrinsics.f(parcel, "parcel");
            return new TextPushMessage(parcel.readString(), parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public final TextPushMessage[] newArray(int i8) {
            return new TextPushMessage[i8];
        }
    }

    public TextPushMessage(String str, String str2, String str3) {
        super(null);
        this.f25660f = str;
        this.f25661g = str2;
        this.f25662h = str3;
    }

    public final String a() {
        return this.f25661g;
    }

    public final String b() {
        return this.f25660f;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof TextPushMessage) {
            TextPushMessage textPushMessage = (TextPushMessage) obj;
            return Intrinsics.a(this.f25660f, textPushMessage.f25660f) && Intrinsics.a(this.f25661g, textPushMessage.f25661g) && Intrinsics.a(this.f25662h, textPushMessage.f25662h);
        }
        return false;
    }

    public int hashCode() {
        String str = this.f25660f;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.f25661g;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.f25662h;
        return hashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    public String toString() {
        String str = this.f25660f;
        String str2 = this.f25661g;
        String str3 = this.f25662h;
        return "TextPushMessage(title=" + str + ", body=" + str2 + ", type=" + str3 + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i8) {
        Intrinsics.f(out, "out");
        out.writeString(this.f25660f);
        out.writeString(this.f25661g);
        out.writeString(this.f25662h);
    }
}
