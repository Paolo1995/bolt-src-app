package eu.bolt.driver.chat.ui.screen.conversation.pager.item.menu;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import ee.mtakso.driver.uikit.utils.Image;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TranslatedMessageUiModel.kt */
/* loaded from: classes5.dex */
public final class TranslatedMessageUiModel implements Parcelable {
    public static final Parcelable.Creator<TranslatedMessageUiModel> CREATOR = new Creator();

    /* renamed from: f  reason: collision with root package name */
    private final String f40741f;

    /* renamed from: g  reason: collision with root package name */
    private final CharSequence f40742g;

    /* renamed from: h  reason: collision with root package name */
    private final CharSequence f40743h;

    /* renamed from: i  reason: collision with root package name */
    private final CharSequence f40744i;

    /* renamed from: j  reason: collision with root package name */
    private final Image f40745j;

    /* compiled from: TranslatedMessageUiModel.kt */
    /* loaded from: classes5.dex */
    public static final class Creator implements Parcelable.Creator<TranslatedMessageUiModel> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public final TranslatedMessageUiModel createFromParcel(Parcel parcel) {
            Intrinsics.f(parcel, "parcel");
            return new TranslatedMessageUiModel(parcel.readString(), (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel), (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel), (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel), (Image) parcel.readParcelable(TranslatedMessageUiModel.class.getClassLoader()));
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public final TranslatedMessageUiModel[] newArray(int i8) {
            return new TranslatedMessageUiModel[i8];
        }
    }

    public TranslatedMessageUiModel(String id, CharSequence originalMessage, CharSequence translatedMessage, CharSequence attributionText, Image image) {
        Intrinsics.f(id, "id");
        Intrinsics.f(originalMessage, "originalMessage");
        Intrinsics.f(translatedMessage, "translatedMessage");
        Intrinsics.f(attributionText, "attributionText");
        this.f40741f = id;
        this.f40742g = originalMessage;
        this.f40743h = translatedMessage;
        this.f40744i = attributionText;
        this.f40745j = image;
    }

    public final CharSequence a() {
        return this.f40742g;
    }

    public final CharSequence b() {
        return this.f40743h;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof TranslatedMessageUiModel) {
            TranslatedMessageUiModel translatedMessageUiModel = (TranslatedMessageUiModel) obj;
            return Intrinsics.a(this.f40741f, translatedMessageUiModel.f40741f) && Intrinsics.a(this.f40742g, translatedMessageUiModel.f40742g) && Intrinsics.a(this.f40743h, translatedMessageUiModel.f40743h) && Intrinsics.a(this.f40744i, translatedMessageUiModel.f40744i) && Intrinsics.a(this.f40745j, translatedMessageUiModel.f40745j);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((((((this.f40741f.hashCode() * 31) + this.f40742g.hashCode()) * 31) + this.f40743h.hashCode()) * 31) + this.f40744i.hashCode()) * 31;
        Image image = this.f40745j;
        return hashCode + (image == null ? 0 : image.hashCode());
    }

    public String toString() {
        String str = this.f40741f;
        CharSequence charSequence = this.f40742g;
        CharSequence charSequence2 = this.f40743h;
        CharSequence charSequence3 = this.f40744i;
        Image image = this.f40745j;
        return "TranslatedMessageUiModel(id=" + str + ", originalMessage=" + ((Object) charSequence) + ", translatedMessage=" + ((Object) charSequence2) + ", attributionText=" + ((Object) charSequence3) + ", attributionLogo=" + image + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i8) {
        Intrinsics.f(out, "out");
        out.writeString(this.f40741f);
        TextUtils.writeToParcel(this.f40742g, out, i8);
        TextUtils.writeToParcel(this.f40743h, out, i8);
        TextUtils.writeToParcel(this.f40744i, out, i8);
        out.writeParcelable(this.f40745j, i8);
    }
}
