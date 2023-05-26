package eu.bolt.driver.core.theme;

import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AppThemeMode.kt */
/* loaded from: classes5.dex */
public enum AppThemeMode implements Parcelable {
    LEGACY(-100),
    DARK(2),
    LIGHT(1),
    DAY_NIGHT_SYSTEM(-1);
    

    /* renamed from: f  reason: collision with root package name */
    private final int f40972f;

    /* renamed from: g  reason: collision with root package name */
    public static final Companion f40966g = new Companion(null);
    public static final Parcelable.Creator<AppThemeMode> CREATOR = new Parcelable.Creator<AppThemeMode>() { // from class: eu.bolt.driver.core.theme.AppThemeMode.Creator
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public final AppThemeMode createFromParcel(Parcel parcel) {
            Intrinsics.f(parcel, "parcel");
            return AppThemeMode.valueOf(parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public final AppThemeMode[] newArray(int i8) {
            return new AppThemeMode[i8];
        }
    };

    /* compiled from: AppThemeMode.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final AppThemeMode a() {
            if (Build.VERSION.SDK_INT < 29) {
                return AppThemeMode.LIGHT;
            }
            return AppThemeMode.DAY_NIGHT_SYSTEM;
        }
    }

    AppThemeMode(int i8) {
        this.f40972f = i8;
    }

    public final int c() {
        return this.f40972f;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i8) {
        Intrinsics.f(out, "out");
        out.writeString(name());
    }
}
