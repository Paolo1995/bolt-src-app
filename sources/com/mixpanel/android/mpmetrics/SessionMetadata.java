package com.mixpanel.android.mpmetrics;

import com.mixpanel.android.util.MPLog;
import java.util.Random;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class SessionMetadata {

    /* renamed from: a  reason: collision with root package name */
    private long f19355a;

    /* renamed from: b  reason: collision with root package name */
    private long f19356b;

    /* renamed from: c  reason: collision with root package name */
    private long f19357c;

    /* renamed from: d  reason: collision with root package name */
    private String f19358d;

    /* renamed from: e  reason: collision with root package name */
    private Random f19359e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SessionMetadata() {
        d();
        this.f19359e = new Random();
    }

    private JSONObject c(boolean z7) {
        long j8;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("$mp_event_id", Long.toHexString(this.f19359e.nextLong()));
            jSONObject.put("$mp_session_id", this.f19358d);
            if (z7) {
                j8 = this.f19355a;
            } else {
                j8 = this.f19356b;
            }
            jSONObject.put("$mp_session_seq_id", j8);
            jSONObject.put("$mp_session_start_sec", this.f19357c);
            if (z7) {
                this.f19355a++;
            } else {
                this.f19356b++;
            }
        } catch (JSONException e8) {
            MPLog.d(ConfigurationChecker.f19092a, "Cannot create session metadata JSON object", e8);
        }
        return jSONObject;
    }

    public JSONObject a() {
        return c(true);
    }

    public JSONObject b() {
        return c(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d() {
        this.f19355a = 0L;
        this.f19356b = 0L;
        this.f19358d = Long.toHexString(new Random().nextLong());
        this.f19357c = System.currentTimeMillis() / 1000;
    }
}
