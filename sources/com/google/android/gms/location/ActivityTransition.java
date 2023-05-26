package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: com.google.android.gms:play-services-location@@18.0.0 */
@SafeParcelable.Class(creator = "ActivityTransitionCreator")
@SafeParcelable.Reserved({1000})
/* loaded from: classes.dex */
public class ActivityTransition extends AbstractSafeParcelable {
    public static final int ACTIVITY_TRANSITION_ENTER = 0;
    public static final int ACTIVITY_TRANSITION_EXIT = 1;
    @RecentlyNonNull
    public static final Parcelable.Creator<ActivityTransition> CREATOR = new zzl();
    @SafeParcelable.Field(getter = "getActivityType", id = 1)
    private final int zza;
    @SafeParcelable.Field(getter = "getTransitionType", id = 2)
    private final int zzb;

    /* compiled from: com.google.android.gms:play-services-location@@18.0.0 */
    /* loaded from: classes.dex */
    public static class Builder {
        private int zza = -1;
        private int zzb = -1;

        @RecentlyNonNull
        public ActivityTransition build() {
            boolean z7;
            boolean z8 = true;
            if (this.zza != -1) {
                z7 = true;
            } else {
                z7 = false;
            }
            Preconditions.checkState(z7, "Activity type not set.");
            if (this.zzb == -1) {
                z8 = false;
            }
            Preconditions.checkState(z8, "Activity transition type not set.");
            return new ActivityTransition(this.zza, this.zzb);
        }

        @RecentlyNonNull
        public Builder setActivityTransition(int i8) {
            ActivityTransition.zza(i8);
            this.zzb = i8;
            return this;
        }

        @RecentlyNonNull
        public Builder setActivityType(int i8) {
            this.zza = i8;
            return this;
        }
    }

    /* compiled from: com.google.android.gms:play-services-location@@18.0.0 */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface SupportedActivityTransition {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public ActivityTransition(@SafeParcelable.Param(id = 1) int i8, @SafeParcelable.Param(id = 2) int i9) {
        this.zza = i8;
        this.zzb = i9;
    }

    public static void zza(int i8) {
        boolean z7 = true;
        z7 = (i8 < 0 || i8 > 1) ? false : false;
        StringBuilder sb = new StringBuilder(41);
        sb.append("Transition type ");
        sb.append(i8);
        sb.append(" is not valid.");
        Preconditions.checkArgument(z7, sb.toString());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ActivityTransition)) {
            return false;
        }
        ActivityTransition activityTransition = (ActivityTransition) obj;
        if (this.zza == activityTransition.zza && this.zzb == activityTransition.zzb) {
            return true;
        }
        return false;
    }

    public int getActivityType() {
        return this.zza;
    }

    public int getTransitionType() {
        return this.zzb;
    }

    public int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.zza), Integer.valueOf(this.zzb));
    }

    @RecentlyNonNull
    public String toString() {
        int i8 = this.zza;
        int i9 = this.zzb;
        StringBuilder sb = new StringBuilder(75);
        sb.append("ActivityTransition [mActivityType=");
        sb.append(i8);
        sb.append(", mTransitionType=");
        sb.append(i9);
        sb.append(']');
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@RecentlyNonNull Parcel parcel, int i8) {
        Preconditions.checkNotNull(parcel);
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, getActivityType());
        SafeParcelWriter.writeInt(parcel, 2, getTransitionType());
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
