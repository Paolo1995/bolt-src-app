package com.sinch.android.rtc.internal.client;

import com.sinch.android.rtc.SinchError;
import com.sinch.android.rtc.calling.CallDetails;
import com.sinch.android.rtc.calling.CallEndCause;
import java.util.Date;

/* loaded from: classes3.dex */
public class DefaultCallDetails implements CallDetails {
    private final com.sinch.android.rtc.internal.natives.CallDetails details;

    public DefaultCallDetails(com.sinch.android.rtc.internal.natives.CallDetails callDetails) {
        this.details = callDetails;
    }

    @Override // com.sinch.android.rtc.calling.CallDetails
    public int getDuration() {
        return this.details.getDuration();
    }

    @Override // com.sinch.android.rtc.calling.CallDetails
    public CallEndCause getEndCause() {
        return this.details.getTerminationCause();
    }

    @Override // com.sinch.android.rtc.calling.CallDetails
    public Date getEndedTime() {
        return this.details.getEndTime();
    }

    @Override // com.sinch.android.rtc.calling.CallDetails
    public SinchError getError() {
        return this.details.getError();
    }

    @Override // com.sinch.android.rtc.calling.CallDetails
    public Date getEstablishedTime() {
        return this.details.getEstablishTime();
    }

    @Override // com.sinch.android.rtc.calling.CallDetails
    public Date getStartedTime() {
        return this.details.getStartTime();
    }

    @Override // com.sinch.android.rtc.calling.CallDetails
    public boolean isVideoOffered() {
        return this.details.isVideoOffered();
    }

    public String toString() {
        return this.details.toString();
    }
}
