package ee.mtakso.driver.uikit.widgets;

import android.os.Parcel;
import android.os.Parcelable;
import ee.mtakso.driver.uikit.R$attr;
import ee.mtakso.driver.uikit.utils.Color;
import kotlin.jvm.internal.Intrinsics;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum k uses external variables
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
public final class UiKitRoundButtonType implements Parcelable {
    public static final Parcelable.Creator<UiKitRoundButtonType> CREATOR;

    /* renamed from: k  reason: collision with root package name */
    public static final UiKitRoundButtonType f36161k;

    /* renamed from: l  reason: collision with root package name */
    public static final UiKitRoundButtonType f36162l;

    /* renamed from: m  reason: collision with root package name */
    public static final UiKitRoundButtonType f36163m;

    /* renamed from: n  reason: collision with root package name */
    public static final UiKitRoundButtonType f36164n;

    /* renamed from: o  reason: collision with root package name */
    public static final UiKitRoundButtonType f36165o;

    /* renamed from: p  reason: collision with root package name */
    public static final UiKitRoundButtonType f36166p;

    /* renamed from: q  reason: collision with root package name */
    public static final UiKitRoundButtonType f36167q;

    /* renamed from: r  reason: collision with root package name */
    private static final /* synthetic */ UiKitRoundButtonType[] f36168r;

    /* renamed from: f  reason: collision with root package name */
    private final Color f36169f;

    /* renamed from: g  reason: collision with root package name */
    private final Color f36170g;

    /* renamed from: h  reason: collision with root package name */
    private final Color f36171h;

    /* renamed from: i  reason: collision with root package name */
    private final Color f36172i;

    /* renamed from: j  reason: collision with root package name */
    private final Color f36173j;

    static {
        Color.Attr attr = new Color.Attr(R$attr.f35741a);
        int i8 = R$attr.f35746q;
        Color.Attr attr2 = new Color.Attr(i8);
        int i9 = R$attr.colorBgActiveActionPrimary;
        f36161k = new UiKitRoundButtonType("ACTION", 0, attr, attr2, new Color.Attr(i9), new Color.Attr(R$attr.colorContentActionSecondary), new Color.Attr(R$attr.colorBgActiveActionSecondary));
        f36162l = new UiKitRoundButtonType("PRIMARY", 1, new Color.Attr(R$attr.f35744l), new Color.Attr(i8), new Color.Attr(i9), new Color.Attr(R$attr.colorContentPositiveSecondary), new Color.Attr(R$attr.colorBgActivePositiveSecondary));
        f36163m = new UiKitRoundButtonType("CRITICAL", 2, new Color.Attr(R$attr.f35743j), new Color.Attr(i8), new Color.Attr(R$attr.colorBgActiveDangerPrimary), new Color.Attr(R$attr.colorContentDangerSecondary), new Color.Attr(R$attr.colorBgActiveDangerSecondary));
        int i10 = R$attr.colorBgNeutralSecondary;
        f36164n = new UiKitRoundButtonType("SECONDARY", 3, new Color.Attr(i10), new Color.Attr(R$attr.colorContentPrimary), new Color.Attr(R$attr.f35742f), new Color.Attr(R$attr.colorContentTertiary), new Color.Attr(i10));
        int i11 = R$attr.colorSpecialNulled;
        Color.Attr attr3 = new Color.Attr(i11);
        int i12 = R$attr.colorContentPromoPrimary;
        Color.Attr attr4 = new Color.Attr(i12);
        int i13 = R$attr.colorLayerFloor0;
        f36165o = new UiKitRoundButtonType("LINK", 4, attr3, attr4, new Color.Attr(i13), new Color.Attr(i12), new Color.Attr(i11));
        Color.Attr attr5 = new Color.Attr(i11);
        int i14 = R$attr.colorContentActionPrimary;
        f36166p = new UiKitRoundButtonType("LINK_ALTERNATIVE", 5, attr5, new Color.Attr(i14), new Color.Attr(i13), new Color.Attr(i14), new Color.Attr(i11));
        f36167q = new UiKitRoundButtonType("OFFLINE", 6, new Color.Attr(R$attr.f35745m), new Color.Attr(i8), new Color.Attr(R$attr.colorBgActiveWarningPrimary), new Color.Attr(R$attr.colorContentWarningSecondary), new Color.Attr(R$attr.colorBgActiveWarningSecondary));
        f36168r = a();
        CREATOR = new Parcelable.Creator<UiKitRoundButtonType>() { // from class: ee.mtakso.driver.uikit.widgets.UiKitRoundButtonType.Creator
            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public final UiKitRoundButtonType createFromParcel(Parcel parcel) {
                Intrinsics.f(parcel, "parcel");
                return UiKitRoundButtonType.valueOf(parcel.readString());
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b */
            public final UiKitRoundButtonType[] newArray(int i15) {
                return new UiKitRoundButtonType[i15];
            }
        };
    }

    private UiKitRoundButtonType(String str, int i8, Color color, Color color2, Color color3, Color color4, Color color5) {
        this.f36169f = color;
        this.f36170g = color2;
        this.f36171h = color3;
        this.f36172i = color4;
        this.f36173j = color5;
    }

    private static final /* synthetic */ UiKitRoundButtonType[] a() {
        return new UiKitRoundButtonType[]{f36161k, f36162l, f36163m, f36164n, f36165o, f36166p, f36167q};
    }

    public static UiKitRoundButtonType valueOf(String str) {
        return (UiKitRoundButtonType) Enum.valueOf(UiKitRoundButtonType.class, str);
    }

    public static UiKitRoundButtonType[] values() {
        return (UiKitRoundButtonType[]) f36168r.clone();
    }

    public final Color c() {
        return this.f36169f;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final Color e() {
        return this.f36173j;
    }

    public final Color f() {
        return this.f36172i;
    }

    public final Color h() {
        return this.f36171h;
    }

    public final Color j() {
        return this.f36170g;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i8) {
        Intrinsics.f(out, "out");
        out.writeString(name());
    }
}
