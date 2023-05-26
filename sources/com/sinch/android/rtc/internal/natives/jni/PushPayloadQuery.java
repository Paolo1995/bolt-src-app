package com.sinch.android.rtc.internal.natives.jni;

import com.sinch.android.rtc.SinchError;
import java.util.Map;

/* loaded from: classes3.dex */
public class PushPayloadQuery {
    public static final int CALL = 1;

    /* loaded from: classes3.dex */
    public static class PushPayloadQueryResult {
        private final String domain;
        private SinchError error;
        private final Map<String, String> headers;
        private final boolean isTimedOut;
        private boolean isValid;
        private final String sessionId;
        private final int type;
        private final String userId;
        private boolean videoOffered;

        public PushPayloadQueryResult(String str, String str2, String str3, boolean z7, boolean z8, int i8, boolean z9, Map<String, String> map, SinchError sinchError) {
            this.sessionId = str;
            this.userId = str2;
            this.domain = str3;
            this.isTimedOut = z7;
            this.isValid = z8;
            this.type = i8;
            this.videoOffered = z9;
            this.headers = map;
            this.error = sinchError;
        }

        public String getDomain() {
            return this.domain;
        }

        public SinchError getError() {
            return this.error;
        }

        public Map<String, String> getHeaders() {
            return this.headers;
        }

        public String getSessionId() {
            return this.sessionId;
        }

        public int getType() {
            return this.type;
        }

        public String getUserId() {
            return this.userId;
        }

        public boolean getVideoOffered() {
            return this.videoOffered;
        }

        public boolean isCallQuery() {
            return getType() == 1;
        }

        public boolean isTimedOut() {
            return this.isTimedOut;
        }

        public boolean isValid() {
            return this.isValid;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("PushPayloadQueryResult [sessionId=");
            String str = this.sessionId;
            if (str == null) {
                str = "<null>";
            }
            sb.append(str);
            sb.append(", userId=");
            String str2 = this.userId;
            if (str2 == null) {
                str2 = "<null>";
            }
            sb.append(str2);
            sb.append(", isTimedOut=");
            sb.append(this.isTimedOut);
            sb.append(", isValid=");
            sb.append(this.isValid);
            sb.append(", headers=");
            sb.append(this.headers);
            sb.append(", error=");
            SinchError sinchError = this.error;
            sb.append(sinchError != null ? sinchError : "<null>");
            sb.append("]");
            return sb.toString();
        }
    }

    public static native PushPayloadQueryResult queryPayload(String str, long j8);
}
