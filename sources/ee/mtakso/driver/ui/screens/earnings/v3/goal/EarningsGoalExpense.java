package ee.mtakso.driver.ui.screens.earnings.v3.goal;

import android.os.Parcel;
import android.os.Parcelable;
import ee.mtakso.driver.uikit.utils.Image;
import java.math.BigDecimal;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EarningsGoalExpense.kt */
/* loaded from: classes3.dex */
public final class EarningsGoalExpense implements Parcelable {
    public static final Parcelable.Creator<EarningsGoalExpense> CREATOR = new Creator();

    /* renamed from: f  reason: collision with root package name */
    private final String f29094f;

    /* renamed from: g  reason: collision with root package name */
    private final String f29095g;

    /* renamed from: h  reason: collision with root package name */
    private final Image f29096h;

    /* renamed from: i  reason: collision with root package name */
    private final State f29097i;

    /* compiled from: EarningsGoalExpense.kt */
    /* loaded from: classes3.dex */
    public static final class Creator implements Parcelable.Creator<EarningsGoalExpense> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public final EarningsGoalExpense createFromParcel(Parcel parcel) {
            Intrinsics.f(parcel, "parcel");
            return new EarningsGoalExpense(parcel.readString(), parcel.readString(), (Image) parcel.readParcelable(EarningsGoalExpense.class.getClassLoader()), (State) parcel.readParcelable(EarningsGoalExpense.class.getClassLoader()));
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public final EarningsGoalExpense[] newArray(int i8) {
            return new EarningsGoalExpense[i8];
        }
    }

    /* compiled from: EarningsGoalExpense.kt */
    /* loaded from: classes3.dex */
    public static abstract class State implements Parcelable {

        /* compiled from: EarningsGoalExpense.kt */
        /* loaded from: classes3.dex */
        public static final class Default extends State {

            /* renamed from: f  reason: collision with root package name */
            public static final Default f29098f = new Default();
            public static final Parcelable.Creator<Default> CREATOR = new Creator();

            /* compiled from: EarningsGoalExpense.kt */
            /* loaded from: classes3.dex */
            public static final class Creator implements Parcelable.Creator<Default> {
                @Override // android.os.Parcelable.Creator
                /* renamed from: a */
                public final Default createFromParcel(Parcel parcel) {
                    Intrinsics.f(parcel, "parcel");
                    parcel.readInt();
                    return Default.f29098f;
                }

                @Override // android.os.Parcelable.Creator
                /* renamed from: b */
                public final Default[] newArray(int i8) {
                    return new Default[i8];
                }
            }

            private Default() {
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

        /* compiled from: EarningsGoalExpense.kt */
        /* loaded from: classes3.dex */
        public static final class None extends State {

            /* renamed from: f  reason: collision with root package name */
            public static final None f29099f = new None();
            public static final Parcelable.Creator<None> CREATOR = new Creator();

            /* compiled from: EarningsGoalExpense.kt */
            /* loaded from: classes3.dex */
            public static final class Creator implements Parcelable.Creator<None> {
                @Override // android.os.Parcelable.Creator
                /* renamed from: a */
                public final None createFromParcel(Parcel parcel) {
                    Intrinsics.f(parcel, "parcel");
                    parcel.readInt();
                    return None.f29099f;
                }

                @Override // android.os.Parcelable.Creator
                /* renamed from: b */
                public final None[] newArray(int i8) {
                    return new None[i8];
                }
            }

            private None() {
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

        /* compiled from: EarningsGoalExpense.kt */
        /* loaded from: classes3.dex */
        public static final class Set extends State {
            public static final Parcelable.Creator<Set> CREATOR = new Creator();

            /* renamed from: f  reason: collision with root package name */
            private final BigDecimal f29100f;

            /* compiled from: EarningsGoalExpense.kt */
            /* loaded from: classes3.dex */
            public static final class Creator implements Parcelable.Creator<Set> {
                @Override // android.os.Parcelable.Creator
                /* renamed from: a */
                public final Set createFromParcel(Parcel parcel) {
                    Intrinsics.f(parcel, "parcel");
                    return new Set((BigDecimal) parcel.readSerializable());
                }

                @Override // android.os.Parcelable.Creator
                /* renamed from: b */
                public final Set[] newArray(int i8) {
                    return new Set[i8];
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Set(BigDecimal value) {
                super(null);
                Intrinsics.f(value, "value");
                this.f29100f = value;
            }

            public final BigDecimal a() {
                return this.f29100f;
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof Set) && Intrinsics.a(this.f29100f, ((Set) obj).f29100f);
            }

            public int hashCode() {
                return this.f29100f.hashCode();
            }

            public String toString() {
                BigDecimal bigDecimal = this.f29100f;
                return "Set(value=" + bigDecimal + ")";
            }

            @Override // android.os.Parcelable
            public void writeToParcel(Parcel out, int i8) {
                Intrinsics.f(out, "out");
                out.writeSerializable(this.f29100f);
            }
        }

        private State() {
        }

        public /* synthetic */ State(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public EarningsGoalExpense(String type, String title, Image image, State state) {
        Intrinsics.f(type, "type");
        Intrinsics.f(title, "title");
        Intrinsics.f(state, "state");
        this.f29094f = type;
        this.f29095g = title;
        this.f29096h = image;
        this.f29097i = state;
    }

    public static /* synthetic */ EarningsGoalExpense b(EarningsGoalExpense earningsGoalExpense, String str, String str2, Image image, State state, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            str = earningsGoalExpense.f29094f;
        }
        if ((i8 & 2) != 0) {
            str2 = earningsGoalExpense.f29095g;
        }
        if ((i8 & 4) != 0) {
            image = earningsGoalExpense.f29096h;
        }
        if ((i8 & 8) != 0) {
            state = earningsGoalExpense.f29097i;
        }
        return earningsGoalExpense.a(str, str2, image, state);
    }

    public final EarningsGoalExpense a(String type, String title, Image image, State state) {
        Intrinsics.f(type, "type");
        Intrinsics.f(title, "title");
        Intrinsics.f(state, "state");
        return new EarningsGoalExpense(type, title, image, state);
    }

    public final Image c() {
        return this.f29096h;
    }

    public final State d() {
        return this.f29097i;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final String e() {
        return this.f29095g;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof EarningsGoalExpense) {
            EarningsGoalExpense earningsGoalExpense = (EarningsGoalExpense) obj;
            return Intrinsics.a(this.f29094f, earningsGoalExpense.f29094f) && Intrinsics.a(this.f29095g, earningsGoalExpense.f29095g) && Intrinsics.a(this.f29096h, earningsGoalExpense.f29096h) && Intrinsics.a(this.f29097i, earningsGoalExpense.f29097i);
        }
        return false;
    }

    public final String f() {
        return this.f29094f;
    }

    public int hashCode() {
        int hashCode = ((this.f29094f.hashCode() * 31) + this.f29095g.hashCode()) * 31;
        Image image = this.f29096h;
        return ((hashCode + (image == null ? 0 : image.hashCode())) * 31) + this.f29097i.hashCode();
    }

    public String toString() {
        String str = this.f29094f;
        String str2 = this.f29095g;
        Image image = this.f29096h;
        State state = this.f29097i;
        return "EarningsGoalExpense(type=" + str + ", title=" + str2 + ", icon=" + image + ", state=" + state + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i8) {
        Intrinsics.f(out, "out");
        out.writeString(this.f29094f);
        out.writeString(this.f29095g);
        out.writeParcelable(this.f29096h, i8);
        out.writeParcelable(this.f29097i, i8);
    }
}
