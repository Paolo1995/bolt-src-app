package com.google.android.gms.location;

import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.common.util.VisibleForTesting;

/* compiled from: com.google.android.gms:play-services-location@@18.0.0 */
@VisibleForTesting
/* loaded from: classes.dex */
public interface Geofence {
    public static final int GEOFENCE_TRANSITION_DWELL = 4;
    public static final int GEOFENCE_TRANSITION_ENTER = 1;
    public static final int GEOFENCE_TRANSITION_EXIT = 2;
    public static final long NEVER_EXPIRE = -1;

    /* compiled from: com.google.android.gms:play-services-location@@18.0.0 */
    @VisibleForTesting
    /* loaded from: classes.dex */
    public static final class Builder {
        private double zze;
        private double zzf;
        private float zzg;
        private String zza = null;
        @TransitionTypes
        private int zzb = 0;
        private long zzc = Long.MIN_VALUE;
        private short zzd = -1;
        private int zzh = 0;
        private int zzi = -1;

        @RecentlyNonNull
        public Geofence build() {
            String str = this.zza;
            if (str != null) {
                int i8 = this.zzb;
                if (i8 != 0) {
                    if ((i8 & 4) != 0 && this.zzi < 0) {
                        throw new IllegalArgumentException("Non-negative loitering delay needs to be set when transition types include GEOFENCE_TRANSITION_DWELLING.");
                    }
                    long j8 = this.zzc;
                    if (j8 != Long.MIN_VALUE) {
                        if (this.zzd != -1) {
                            int i9 = this.zzh;
                            if (i9 >= 0) {
                                return new com.google.android.gms.internal.location.zzbe(str, i8, (short) 1, this.zze, this.zzf, this.zzg, j8, i9, this.zzi);
                            }
                            throw new IllegalArgumentException("Notification responsiveness should be nonnegative.");
                        }
                        throw new IllegalArgumentException("Geofence region not set.");
                    }
                    throw new IllegalArgumentException("Expiration not set.");
                }
                throw new IllegalArgumentException("Transitions types not set.");
            }
            throw new IllegalArgumentException("Request ID not set.");
        }

        @RecentlyNonNull
        public Builder setCircularRegion(double d8, double d9, float f8) {
            boolean z7;
            boolean z8;
            boolean z9 = false;
            if (d8 >= -90.0d && d8 <= 90.0d) {
                z7 = true;
            } else {
                z7 = false;
            }
            StringBuilder sb = new StringBuilder(42);
            sb.append("Invalid latitude: ");
            sb.append(d8);
            Preconditions.checkArgument(z7, sb.toString());
            if (d9 >= -180.0d && d9 <= 180.0d) {
                z8 = true;
            } else {
                z8 = false;
            }
            StringBuilder sb2 = new StringBuilder(43);
            sb2.append("Invalid longitude: ");
            sb2.append(d9);
            Preconditions.checkArgument(z8, sb2.toString());
            if (f8 > 0.0f) {
                z9 = true;
            }
            StringBuilder sb3 = new StringBuilder(31);
            sb3.append("Invalid radius: ");
            sb3.append(f8);
            Preconditions.checkArgument(z9, sb3.toString());
            this.zzd = (short) 1;
            this.zze = d8;
            this.zzf = d9;
            this.zzg = f8;
            return this;
        }

        @RecentlyNonNull
        public Builder setExpirationDuration(long j8) {
            if (j8 < 0) {
                this.zzc = -1L;
            } else {
                this.zzc = DefaultClock.getInstance().elapsedRealtime() + j8;
            }
            return this;
        }

        @RecentlyNonNull
        public Builder setLoiteringDelay(int i8) {
            this.zzi = i8;
            return this;
        }

        @RecentlyNonNull
        public Builder setNotificationResponsiveness(int i8) {
            this.zzh = i8;
            return this;
        }

        @RecentlyNonNull
        public Builder setRequestId(@RecentlyNonNull String str) {
            this.zza = (String) Preconditions.checkNotNull(str, "Request ID can't be set to null");
            return this;
        }

        @RecentlyNonNull
        public Builder setTransitionTypes(@TransitionTypes int i8) {
            this.zzb = i8;
            return this;
        }
    }

    /* compiled from: com.google.android.gms:play-services-location@@18.0.0 */
    /* loaded from: classes.dex */
    public @interface GeofenceTransition {
    }

    /* compiled from: com.google.android.gms:play-services-location@@18.0.0 */
    /* loaded from: classes.dex */
    public @interface TransitionTypes {
    }

    @RecentlyNonNull
    String getRequestId();
}
