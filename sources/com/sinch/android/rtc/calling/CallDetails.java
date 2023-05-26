package com.sinch.android.rtc.calling;

import com.sinch.android.rtc.SinchError;
import java.util.Date;

/* loaded from: classes3.dex */
public interface CallDetails {
    int getDuration();

    CallEndCause getEndCause();

    Date getEndedTime();

    SinchError getError();

    Date getEstablishedTime();

    Date getStartedTime();

    boolean isVideoOffered();
}
