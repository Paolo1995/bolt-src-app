package eu.bolt.driver.chat.ui.screen.conversation.pager.item;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Conversation.kt */
/* loaded from: classes5.dex */
public final class Conversation implements Parcelable {
    public static final Parcelable.Creator<Conversation> CREATOR = new Creator();

    /* renamed from: f  reason: collision with root package name */
    private final String f40627f;

    /* renamed from: g  reason: collision with root package name */
    private final String f40628g;

    /* renamed from: h  reason: collision with root package name */
    private final String f40629h;

    /* renamed from: i  reason: collision with root package name */
    private final OrderHandleUi f40630i;

    /* compiled from: Conversation.kt */
    /* loaded from: classes5.dex */
    public static final class Creator implements Parcelable.Creator<Conversation> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public final Conversation createFromParcel(Parcel parcel) {
            Intrinsics.f(parcel, "parcel");
            return new Conversation(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() == 0 ? null : OrderHandleUi.CREATOR.createFromParcel(parcel));
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public final Conversation[] newArray(int i8) {
            return new Conversation[i8];
        }
    }

    public Conversation(String chatId, String title, String str, OrderHandleUi orderHandleUi) {
        Intrinsics.f(chatId, "chatId");
        Intrinsics.f(title, "title");
        this.f40627f = chatId;
        this.f40628g = title;
        this.f40629h = str;
        this.f40630i = orderHandleUi;
    }

    public final String a() {
        return this.f40627f;
    }

    public final String b() {
        return this.f40629h;
    }

    public final OrderHandleUi c() {
        return this.f40630i;
    }

    public final String d() {
        return this.f40628g;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Conversation) {
            Conversation conversation = (Conversation) obj;
            return Intrinsics.a(this.f40627f, conversation.f40627f) && Intrinsics.a(this.f40628g, conversation.f40628g) && Intrinsics.a(this.f40629h, conversation.f40629h) && Intrinsics.a(this.f40630i, conversation.f40630i);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((this.f40627f.hashCode() * 31) + this.f40628g.hashCode()) * 31;
        String str = this.f40629h;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        OrderHandleUi orderHandleUi = this.f40630i;
        return hashCode2 + (orderHandleUi != null ? orderHandleUi.hashCode() : 0);
    }

    public String toString() {
        String str = this.f40627f;
        String str2 = this.f40628g;
        String str3 = this.f40629h;
        OrderHandleUi orderHandleUi = this.f40630i;
        return "Conversation(chatId=" + str + ", title=" + str2 + ", description=" + str3 + ", orderHandle=" + orderHandleUi + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i8) {
        Intrinsics.f(out, "out");
        out.writeString(this.f40627f);
        out.writeString(this.f40628g);
        out.writeString(this.f40629h);
        OrderHandleUi orderHandleUi = this.f40630i;
        if (orderHandleUi == null) {
            out.writeInt(0);
            return;
        }
        out.writeInt(1);
        orderHandleUi.writeToParcel(out, i8);
    }
}
