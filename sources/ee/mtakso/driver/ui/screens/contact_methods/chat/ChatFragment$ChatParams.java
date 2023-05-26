package ee.mtakso.driver.ui.screens.contact_methods.chat;

import android.os.Parcel;
import android.os.Parcelable;
import ee.mtakso.driver.ui.screens.contact_methods.contactoptions.CancelTarget;
import ee.mtakso.driver.ui.screens.contact_methods.contactoptions.ContactOptionsConfig;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ChatFragment.kt */
/* loaded from: classes3.dex */
public final class ChatFragment$ChatParams implements Parcelable {
    public static final Parcelable.Creator<ChatFragment$ChatParams> CREATOR = new Creator();

    /* renamed from: f  reason: collision with root package name */
    private final String f27759f;

    /* renamed from: g  reason: collision with root package name */
    private final String f27760g;

    /* renamed from: h  reason: collision with root package name */
    private final String f27761h;

    /* renamed from: i  reason: collision with root package name */
    private final ContactOptionsConfig f27762i;

    /* compiled from: ChatFragment.kt */
    /* loaded from: classes3.dex */
    public static final class Creator implements Parcelable.Creator<ChatFragment$ChatParams> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public final ChatFragment$ChatParams createFromParcel(Parcel parcel) {
            Intrinsics.f(parcel, "parcel");
            return new ChatFragment$ChatParams(parcel.readString(), parcel.readString(), parcel.readString(), ContactOptionsConfig.CREATOR.createFromParcel(parcel));
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public final ChatFragment$ChatParams[] newArray(int i8) {
            return new ChatFragment$ChatParams[i8];
        }
    }

    public ChatFragment$ChatParams(String chatId, String title, String str, ContactOptionsConfig contactOptionsConfig) {
        Intrinsics.f(chatId, "chatId");
        Intrinsics.f(title, "title");
        Intrinsics.f(contactOptionsConfig, "contactOptionsConfig");
        this.f27759f = chatId;
        this.f27760g = title;
        this.f27761h = str;
        this.f27762i = contactOptionsConfig;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ChatFragment$ChatParams) {
            ChatFragment$ChatParams chatFragment$ChatParams = (ChatFragment$ChatParams) obj;
            return Intrinsics.a(this.f27759f, chatFragment$ChatParams.f27759f) && Intrinsics.a(this.f27760g, chatFragment$ChatParams.f27760g) && Intrinsics.a(this.f27761h, chatFragment$ChatParams.f27761h) && Intrinsics.a(this.f27762i, chatFragment$ChatParams.f27762i);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((this.f27759f.hashCode() * 31) + this.f27760g.hashCode()) * 31;
        String str = this.f27761h;
        return ((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.f27762i.hashCode();
    }

    public String toString() {
        String str = this.f27759f;
        String str2 = this.f27760g;
        String str3 = this.f27761h;
        ContactOptionsConfig contactOptionsConfig = this.f27762i;
        return "ChatParams(chatId=" + str + ", title=" + str2 + ", description=" + str3 + ", contactOptionsConfig=" + contactOptionsConfig + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i8) {
        Intrinsics.f(out, "out");
        out.writeString(this.f27759f);
        out.writeString(this.f27760g);
        out.writeString(this.f27761h);
        this.f27762i.writeToParcel(out, i8);
    }

    public /* synthetic */ ChatFragment$ChatParams(String str, String str2, String str3, ContactOptionsConfig contactOptionsConfig, int i8, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, (i8 & 8) != 0 ? new ContactOptionsConfig(true, CancelTarget.CHAT, null, null, 12, null) : contactOptionsConfig);
    }
}
