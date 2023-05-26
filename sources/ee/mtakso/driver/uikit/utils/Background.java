package ee.mtakso.driver.uikit.utils;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Background.kt */
/* loaded from: classes5.dex */
public abstract class Background implements Parcelable {

    /* compiled from: Background.kt */
    /* loaded from: classes5.dex */
    public static final class Attr extends Background {
        public static final Parcelable.Creator<Attr> CREATOR = new Creator();

        /* renamed from: f  reason: collision with root package name */
        private final int f36027f;

        /* compiled from: Background.kt */
        /* loaded from: classes5.dex */
        public static final class Creator implements Parcelable.Creator<Attr> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public final Attr createFromParcel(Parcel parcel) {
                Intrinsics.f(parcel, "parcel");
                return new Attr(parcel.readInt());
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b */
            public final Attr[] newArray(int i8) {
                return new Attr[i8];
            }
        }

        public Attr(int i8) {
            super(null);
            this.f36027f = i8;
        }

        public final int a() {
            return this.f36027f;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Attr) && this.f36027f == ((Attr) obj).f36027f;
        }

        public int hashCode() {
            return this.f36027f;
        }

        public String toString() {
            int i8 = this.f36027f;
            return "Attr(id=" + i8 + ")";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel out, int i8) {
            Intrinsics.f(out, "out");
            out.writeInt(this.f36027f);
        }
    }

    /* compiled from: Background.kt */
    /* loaded from: classes5.dex */
    public static final class Res extends Background {
        public static final Parcelable.Creator<Res> CREATOR = new Creator();

        /* renamed from: f  reason: collision with root package name */
        private final int f36028f;

        /* compiled from: Background.kt */
        /* loaded from: classes5.dex */
        public static final class Creator implements Parcelable.Creator<Res> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public final Res createFromParcel(Parcel parcel) {
                Intrinsics.f(parcel, "parcel");
                return new Res(parcel.readInt());
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b */
            public final Res[] newArray(int i8) {
                return new Res[i8];
            }
        }

        public Res(int i8) {
            super(null);
            this.f36028f = i8;
        }

        public final int a() {
            return this.f36028f;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Res) && this.f36028f == ((Res) obj).f36028f;
        }

        public int hashCode() {
            return this.f36028f;
        }

        public String toString() {
            int i8 = this.f36028f;
            return "Res(id=" + i8 + ")";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel out, int i8) {
            Intrinsics.f(out, "out");
            out.writeInt(this.f36028f);
        }
    }

    private Background() {
    }

    public /* synthetic */ Background(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
