package ee.mtakso.driver.param;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RateMeModel.kt */
/* loaded from: classes3.dex */
public abstract class RateMeModel implements Parcelable {

    /* compiled from: RateMeModel.kt */
    /* loaded from: classes3.dex */
    public static final class Campaign extends RateMeModel {

        /* renamed from: f  reason: collision with root package name */
        public static final Campaign f23225f = new Campaign();
        public static final Parcelable.Creator<Campaign> CREATOR = new Creator();

        /* compiled from: RateMeModel.kt */
        /* loaded from: classes3.dex */
        public static final class Creator implements Parcelable.Creator<Campaign> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public final Campaign createFromParcel(Parcel parcel) {
                Intrinsics.f(parcel, "parcel");
                parcel.readInt();
                return Campaign.f23225f;
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b */
            public final Campaign[] newArray(int i8) {
                return new Campaign[i8];
            }
        }

        private Campaign() {
            super(null);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel out, int i8) {
            Intrinsics.f(out, "out");
            out.writeInt(1);
        }
    }

    /* compiled from: RateMeModel.kt */
    /* loaded from: classes3.dex */
    public static final class DriveHome extends RateMeModel {

        /* renamed from: f  reason: collision with root package name */
        public static final DriveHome f23226f = new DriveHome();
        public static final Parcelable.Creator<DriveHome> CREATOR = new Creator();

        /* compiled from: RateMeModel.kt */
        /* loaded from: classes3.dex */
        public static final class Creator implements Parcelable.Creator<DriveHome> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public final DriveHome createFromParcel(Parcel parcel) {
                Intrinsics.f(parcel, "parcel");
                parcel.readInt();
                return DriveHome.f23226f;
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b */
            public final DriveHome[] newArray(int i8) {
                return new DriveHome[i8];
            }
        }

        private DriveHome() {
            super(null);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel out, int i8) {
            Intrinsics.f(out, "out");
            out.writeInt(1);
        }
    }

    /* compiled from: RateMeModel.kt */
    /* loaded from: classes3.dex */
    public static final class HundredRides extends RateMeModel {

        /* renamed from: f  reason: collision with root package name */
        public static final HundredRides f23227f = new HundredRides();
        public static final Parcelable.Creator<HundredRides> CREATOR = new Creator();

        /* compiled from: RateMeModel.kt */
        /* loaded from: classes3.dex */
        public static final class Creator implements Parcelable.Creator<HundredRides> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public final HundredRides createFromParcel(Parcel parcel) {
                Intrinsics.f(parcel, "parcel");
                parcel.readInt();
                return HundredRides.f23227f;
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b */
            public final HundredRides[] newArray(int i8) {
                return new HundredRides[i8];
            }
        }

        private HundredRides() {
            super(null);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel out, int i8) {
            Intrinsics.f(out, "out");
            out.writeInt(1);
        }
    }

    /* compiled from: RateMeModel.kt */
    /* loaded from: classes3.dex */
    public static final class TenRides extends RateMeModel {

        /* renamed from: f  reason: collision with root package name */
        public static final TenRides f23228f = new TenRides();
        public static final Parcelable.Creator<TenRides> CREATOR = new Creator();

        /* compiled from: RateMeModel.kt */
        /* loaded from: classes3.dex */
        public static final class Creator implements Parcelable.Creator<TenRides> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public final TenRides createFromParcel(Parcel parcel) {
                Intrinsics.f(parcel, "parcel");
                parcel.readInt();
                return TenRides.f23228f;
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b */
            public final TenRides[] newArray(int i8) {
                return new TenRides[i8];
            }
        }

        private TenRides() {
            super(null);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel out, int i8) {
            Intrinsics.f(out, "out");
            out.writeInt(1);
        }
    }

    /* compiled from: RateMeModel.kt */
    /* loaded from: classes3.dex */
    public static final class Tips extends RateMeModel {

        /* renamed from: f  reason: collision with root package name */
        public static final Tips f23229f = new Tips();
        public static final Parcelable.Creator<Tips> CREATOR = new Creator();

        /* compiled from: RateMeModel.kt */
        /* loaded from: classes3.dex */
        public static final class Creator implements Parcelable.Creator<Tips> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public final Tips createFromParcel(Parcel parcel) {
                Intrinsics.f(parcel, "parcel");
                parcel.readInt();
                return Tips.f23229f;
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b */
            public final Tips[] newArray(int i8) {
                return new Tips[i8];
            }
        }

        private Tips() {
            super(null);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel out, int i8) {
            Intrinsics.f(out, "out");
            out.writeInt(1);
        }
    }

    private RateMeModel() {
    }

    public /* synthetic */ RateMeModel(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
