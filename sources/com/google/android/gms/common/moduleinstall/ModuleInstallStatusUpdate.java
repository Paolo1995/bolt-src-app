package com.google.android.gms.common.moduleinstall;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
@SafeParcelable.Class(creator = "ModuleInstallStatusUpdateCreator")
/* loaded from: classes.dex */
public class ModuleInstallStatusUpdate extends AbstractSafeParcelable {
    @NonNull
    public static final Parcelable.Creator<ModuleInstallStatusUpdate> CREATOR = new zae();
    @SafeParcelable.Field(getter = "getSessionId", id = 1)
    private final int zaa;
    @InstallState
    @SafeParcelable.Field(getter = "getInstallState", id = 2)
    private final int zab;
    @SafeParcelable.Field(getter = "getBytesDownloaded", id = 3)
    private final Long zac;
    @SafeParcelable.Field(getter = "getTotalBytesToDownload", id = 4)
    private final Long zad;
    @SafeParcelable.Field(getter = "getErrorCode", id = 5)
    private final int zae;
    private final ProgressInfo zaf;

    /* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes.dex */
    public @interface InstallState {
        public static final int STATE_CANCELED = 3;
        public static final int STATE_COMPLETED = 4;
        public static final int STATE_DOWNLOADING = 2;
        public static final int STATE_DOWNLOAD_PAUSED = 7;
        public static final int STATE_FAILED = 5;
        public static final int STATE_INSTALLING = 6;
        public static final int STATE_PENDING = 1;
        public static final int STATE_UNKNOWN = 0;
    }

    /* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
    /* loaded from: classes.dex */
    public static class ProgressInfo {
        private final long zaa;
        private final long zab;

        ProgressInfo(long j8, long j9) {
            Preconditions.checkNotZero(j9);
            this.zaa = j8;
            this.zab = j9;
        }

        public long getBytesDownloaded() {
            return this.zaa;
        }

        public long getTotalBytesToDownload() {
            return this.zab;
        }
    }

    @SafeParcelable.Constructor
    @KeepForSdk
    public ModuleInstallStatusUpdate(@SafeParcelable.Param(id = 1) int i8, @SafeParcelable.Param(id = 2) @InstallState int i9, @SafeParcelable.Param(id = 3) Long l8, @SafeParcelable.Param(id = 4) Long l9, @SafeParcelable.Param(id = 5) int i10) {
        ProgressInfo progressInfo;
        this.zaa = i8;
        this.zab = i9;
        this.zac = l8;
        this.zad = l9;
        this.zae = i10;
        if (l8 != null && l9 != null && l9.longValue() != 0) {
            progressInfo = new ProgressInfo(l8.longValue(), l9.longValue());
        } else {
            progressInfo = null;
        }
        this.zaf = progressInfo;
    }

    public int getErrorCode() {
        return this.zae;
    }

    @InstallState
    public int getInstallState() {
        return this.zab;
    }

    public ProgressInfo getProgressInfo() {
        return this.zaf;
    }

    public int getSessionId() {
        return this.zaa;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i8) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, getSessionId());
        SafeParcelWriter.writeInt(parcel, 2, getInstallState());
        SafeParcelWriter.writeLongObject(parcel, 3, this.zac, false);
        SafeParcelWriter.writeLongObject(parcel, 4, this.zad, false);
        SafeParcelWriter.writeInt(parcel, 5, getErrorCode());
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
