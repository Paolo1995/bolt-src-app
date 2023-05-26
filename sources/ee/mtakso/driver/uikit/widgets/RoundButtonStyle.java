package ee.mtakso.driver.uikit.widgets;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: UiKitRoundButtonType.kt */
/* loaded from: classes5.dex */
public final class RoundButtonStyle implements Parcelable {
    public static final Parcelable.Creator<RoundButtonStyle> CREATOR = new Creator();

    /* renamed from: f  reason: collision with root package name */
    private final UiKitRoundButtonType f36153f;

    /* renamed from: g  reason: collision with root package name */
    private final UiKitRoundButtonSize f36154g;

    /* compiled from: UiKitRoundButtonType.kt */
    /* loaded from: classes5.dex */
    public static final class Creator implements Parcelable.Creator<RoundButtonStyle> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public final RoundButtonStyle createFromParcel(Parcel parcel) {
            Intrinsics.f(parcel, "parcel");
            return new RoundButtonStyle(UiKitRoundButtonType.CREATOR.createFromParcel(parcel), UiKitRoundButtonSize.CREATOR.createFromParcel(parcel));
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public final RoundButtonStyle[] newArray(int i8) {
            return new RoundButtonStyle[i8];
        }
    }

    public RoundButtonStyle(UiKitRoundButtonType type, UiKitRoundButtonSize size) {
        Intrinsics.f(type, "type");
        Intrinsics.f(size, "size");
        this.f36153f = type;
        this.f36154g = size;
    }

    public final UiKitRoundButtonSize a() {
        return this.f36154g;
    }

    public final UiKitRoundButtonType b() {
        return this.f36153f;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof RoundButtonStyle) {
            RoundButtonStyle roundButtonStyle = (RoundButtonStyle) obj;
            return this.f36153f == roundButtonStyle.f36153f && this.f36154g == roundButtonStyle.f36154g;
        }
        return false;
    }

    public int hashCode() {
        return (this.f36153f.hashCode() * 31) + this.f36154g.hashCode();
    }

    public String toString() {
        UiKitRoundButtonType uiKitRoundButtonType = this.f36153f;
        UiKitRoundButtonSize uiKitRoundButtonSize = this.f36154g;
        return "RoundButtonStyle(type=" + uiKitRoundButtonType + ", size=" + uiKitRoundButtonSize + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i8) {
        Intrinsics.f(out, "out");
        this.f36153f.writeToParcel(out, i8);
        this.f36154g.writeToParcel(out, i8);
    }
}
