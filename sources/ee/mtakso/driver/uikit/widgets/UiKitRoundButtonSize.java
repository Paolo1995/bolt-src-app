package ee.mtakso.driver.uikit.widgets;

import android.os.Parcel;
import android.os.Parcelable;
import ee.mtakso.driver.uikit.R$dimen;
import ee.mtakso.driver.uikit.R$style;
import ee.mtakso.driver.uikit.utils.Padding;
import kotlin.jvm.internal.Intrinsics;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum i uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:444)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByField(EnumVisitor.java:368)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByWrappedInsn(EnumVisitor.java:333)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:318)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:258)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInvoke(EnumVisitor.java:289)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: UiKitRoundButtonType.kt */
/* loaded from: classes5.dex */
public final class UiKitRoundButtonSize implements Parcelable {
    public static final Parcelable.Creator<UiKitRoundButtonSize> CREATOR;

    /* renamed from: i  reason: collision with root package name */
    public static final UiKitRoundButtonSize f36155i;

    /* renamed from: j  reason: collision with root package name */
    public static final UiKitRoundButtonSize f36156j;

    /* renamed from: k  reason: collision with root package name */
    private static final /* synthetic */ UiKitRoundButtonSize[] f36157k;

    /* renamed from: f  reason: collision with root package name */
    private final int f36158f;

    /* renamed from: g  reason: collision with root package name */
    private final int f36159g;

    /* renamed from: h  reason: collision with root package name */
    private final Padding f36160h;

    static {
        int i8 = R$style.TextAppearance_UIKit_Button_Small;
        int i9 = R$dimen.uikit_roundbutton_small_minheight;
        int i10 = R$dimen.uikit_roundbutton_small_padding_horizontal;
        int i11 = R$dimen.uikit_roundbutton_small_padding_vertical;
        f36155i = new UiKitRoundButtonSize("SMALL", 0, i8, i9, new Padding(i10, i11, i10, i11));
        int i12 = R$style.TextAppearance_UIKit_Button_Large;
        int i13 = R$dimen.uikit_roundbutton_large_minheight;
        int i14 = R$dimen.uikit_roundbutton_large_padding_horizontal;
        int i15 = R$dimen.uikit_roundbutton_large_padding_vertical;
        f36156j = new UiKitRoundButtonSize("LARGE", 1, i12, i13, new Padding(i14, i15, i14, i15));
        f36157k = a();
        CREATOR = new Parcelable.Creator<UiKitRoundButtonSize>() { // from class: ee.mtakso.driver.uikit.widgets.UiKitRoundButtonSize.Creator
            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public final UiKitRoundButtonSize createFromParcel(Parcel parcel) {
                Intrinsics.f(parcel, "parcel");
                return UiKitRoundButtonSize.valueOf(parcel.readString());
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b */
            public final UiKitRoundButtonSize[] newArray(int i16) {
                return new UiKitRoundButtonSize[i16];
            }
        };
    }

    private UiKitRoundButtonSize(String str, int i8, int i9, int i10, Padding padding) {
        this.f36158f = i9;
        this.f36159g = i10;
        this.f36160h = padding;
    }

    private static final /* synthetic */ UiKitRoundButtonSize[] a() {
        return new UiKitRoundButtonSize[]{f36155i, f36156j};
    }

    public static UiKitRoundButtonSize valueOf(String str) {
        return (UiKitRoundButtonSize) Enum.valueOf(UiKitRoundButtonSize.class, str);
    }

    public static UiKitRoundButtonSize[] values() {
        return (UiKitRoundButtonSize[]) f36157k.clone();
    }

    public final int c() {
        return this.f36159g;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final Padding e() {
        return this.f36160h;
    }

    public final int f() {
        return this.f36158f;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i8) {
        Intrinsics.f(out, "out");
        out.writeString(name());
    }
}
