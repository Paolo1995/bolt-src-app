package com.sinch.android.rtc.calling;

import androidx.annotation.NonNull;
import java.util.Map;

/* loaded from: classes3.dex */
public interface CallController {
    void addCallControllerListener(CallControllerListener callControllerListener);

    Call callConference(String str);

    Call callConference(String str, String str2);

    Call callConference(String str, String str2, Map<String, String> map);

    Call callConference(String str, Map<String, String> map);

    Call callPhoneNumber(String str, String str2);

    Call callPhoneNumber(String str, String str2, Map<String, String> map);

    Call callSip(String str);

    Call callSip(String str, String str2);

    Call callSip(String str, String str2, Map<String, String> map);

    Call callSip(String str, Map<String, String> map);

    Call callUser(String str, @NonNull MediaConstraints mediaConstraints);

    Call callUser(String str, @NonNull MediaConstraints mediaConstraints, Map<String, String> map);

    Call getCall(String str);

    void removeCallControllerListener(CallControllerListener callControllerListener);

    void setRespectNativeCalls(boolean z7);
}
