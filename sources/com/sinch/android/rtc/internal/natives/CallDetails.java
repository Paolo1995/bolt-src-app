package com.sinch.android.rtc.internal.natives;

import com.sinch.android.rtc.SinchError;
import com.sinch.android.rtc.calling.CallEndCause;
import java.util.Date;

/* loaded from: classes3.dex */
public class CallDetails {
    private final int duration;
    private final Date endTime;
    private final SinchError error;
    private final Date establishTime;
    private final Date progressTime;
    private final Date startTime;
    private final CallEndCause terminationCause;
    private final boolean videoOffered;

    private CallDetails(long j8, long j9, long j10, long j11, int i8, int i9, int i10, SinchError sinchError) {
        this.startTime = new Date(j8 * 1000);
        this.endTime = new Date(j9 * 1000);
        this.progressTime = new Date(j10 * 1000);
        this.establishTime = new Date(j11 * 1000);
        this.duration = i8;
        if (i10 < 0 || i10 >= MediaOfferFlag.values().length) {
            throw new IllegalStateException("Illegal mediaOfferFlag with value:" + i10);
        }
        this.videoOffered = i10 == MediaOfferFlag.AudioAndVideo.ordinal();
        this.error = sinchError;
        if (i9 >= 0 && i9 < CallEndCause.values().length) {
            this.terminationCause = CallEndCause.values()[i9];
            return;
        }
        throw new IllegalStateException("Illegal terminationCause with value:" + i9);
    }

    public int getDuration() {
        return this.duration;
    }

    public Date getEndTime() {
        return this.endTime;
    }

    public SinchError getError() {
        return this.error;
    }

    public Date getEstablishTime() {
        return this.establishTime;
    }

    public Date getProgressTime() {
        return this.progressTime;
    }

    public Date getStartTime() {
        return this.startTime;
    }

    public CallEndCause getTerminationCause() {
        return this.terminationCause;
    }

    public boolean isVideoOffered() {
        return this.videoOffered;
    }

    public String toString() {
        return "SessionDetails [startTime=" + this.startTime + ", endTime=" + this.endTime + ", progressTime=" + this.progressTime + ", establishTime=" + this.establishTime + ", duration=" + this.duration + ", terminationCause=" + this.terminationCause + ", error=" + this.error + "]";
    }
}
