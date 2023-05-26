package com.clevertap.android.sdk.inbox;

import android.text.TextUtils;
import com.clevertap.android.sdk.Logger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.simpleframework.xml.strategy.Name;

/* loaded from: classes.dex */
public class CTMessageDAO {

    /* renamed from: a  reason: collision with root package name */
    private String f11583a;

    /* renamed from: b  reason: collision with root package name */
    private long f11584b;

    /* renamed from: c  reason: collision with root package name */
    private long f11585c;

    /* renamed from: d  reason: collision with root package name */
    private String f11586d;

    /* renamed from: e  reason: collision with root package name */
    private JSONObject f11587e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f11588f;

    /* renamed from: g  reason: collision with root package name */
    private List<String> f11589g;

    /* renamed from: h  reason: collision with root package name */
    private String f11590h;

    /* renamed from: i  reason: collision with root package name */
    private JSONObject f11591i;

    public CTMessageDAO() {
        this.f11589g = new ArrayList();
    }

    private static JSONObject i(JSONObject jSONObject) throws JSONException {
        JSONObject jSONObject2 = new JSONObject();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            if (next.startsWith("wzrk_")) {
                jSONObject2.put(next, jSONObject.get(next));
            }
        }
        return jSONObject2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static CTMessageDAO k(JSONObject jSONObject, String str) {
        String str2;
        long currentTimeMillis;
        long currentTimeMillis2;
        JSONObject jSONObject2;
        String str3;
        JSONArray jSONArray;
        try {
            if (jSONObject.has("_id")) {
                str2 = jSONObject.getString("_id");
            } else {
                str2 = null;
            }
            if (jSONObject.has("date")) {
                currentTimeMillis = jSONObject.getInt("date");
            } else {
                currentTimeMillis = System.currentTimeMillis() / 1000;
            }
            long j8 = currentTimeMillis;
            if (jSONObject.has("wzrk_ttl")) {
                currentTimeMillis2 = jSONObject.getInt("wzrk_ttl");
            } else {
                currentTimeMillis2 = (System.currentTimeMillis() + 86400000) / 1000;
            }
            long j9 = currentTimeMillis2;
            if (jSONObject.has("msg")) {
                jSONObject2 = jSONObject.getJSONObject("msg");
            } else {
                jSONObject2 = null;
            }
            ArrayList arrayList = new ArrayList();
            if (jSONObject2 != null) {
                if (jSONObject2.has("tags")) {
                    jSONArray = jSONObject2.getJSONArray("tags");
                } else {
                    jSONArray = null;
                }
                if (jSONArray != null) {
                    for (int i8 = 0; i8 < jSONArray.length(); i8++) {
                        arrayList.add(jSONArray.getString(i8));
                    }
                }
            }
            if (!jSONObject.has("wzrk_id")) {
                str3 = "0_0";
            } else {
                str3 = jSONObject.getString("wzrk_id");
            }
            if (str3.equalsIgnoreCase("0_0")) {
                jSONObject.put("wzrk_id", str3);
            }
            JSONObject i9 = i(jSONObject);
            if (str2 == null) {
                return null;
            }
            return new CTMessageDAO(str2, jSONObject2, false, j8, j9, str, arrayList, str3, i9);
        } catch (JSONException e8) {
            Logger.a("Unable to parse Notification inbox message to CTMessageDao - " + e8.getLocalizedMessage());
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a() {
        CTInboxMessageContent cTInboxMessageContent = new CTInboxMessage(v()).f().get(0);
        if (!cTInboxMessageContent.z() && !cTInboxMessageContent.u()) {
            return false;
        }
        return true;
    }

    public String b() {
        return this.f11583a;
    }

    public long c() {
        return this.f11584b;
    }

    public long d() {
        return this.f11585c;
    }

    public String e() {
        return this.f11586d;
    }

    public JSONObject f() {
        return this.f11587e;
    }

    public String g() {
        return TextUtils.join(",", this.f11589g);
    }

    public String h() {
        return this.f11590h;
    }

    public JSONObject j() {
        return this.f11591i;
    }

    public int l() {
        if (this.f11588f) {
            return 1;
        }
        return 0;
    }

    public void m(String str) {
        this.f11583a = str;
    }

    public void n(long j8) {
        this.f11584b = j8;
    }

    public void o(long j8) {
        this.f11585c = j8;
    }

    public void p(String str) {
        this.f11586d = str;
    }

    public void q(JSONObject jSONObject) {
        this.f11587e = jSONObject;
    }

    public void r(int i8) {
        boolean z7 = true;
        if (i8 != 1) {
            z7 = false;
        }
        this.f11588f = z7;
    }

    public void s(String str) {
        this.f11589g.addAll(Arrays.asList(str.split(",")));
    }

    public void t(String str) {
        this.f11590h = str;
    }

    public void u(JSONObject jSONObject) {
        this.f11591i = jSONObject;
    }

    public JSONObject v() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(Name.MARK, this.f11586d);
            jSONObject.put("msg", this.f11587e);
            jSONObject.put("isRead", this.f11588f);
            jSONObject.put("date", this.f11584b);
            jSONObject.put("wzrk_ttl", this.f11585c);
            JSONArray jSONArray = new JSONArray();
            for (int i8 = 0; i8 < this.f11589g.size(); i8++) {
                jSONArray.put(this.f11589g.get(i8));
            }
            jSONObject.put("tags", jSONArray);
            jSONObject.put("wzrk_id", this.f11583a);
            jSONObject.put("wzrkParams", this.f11591i);
            return jSONObject;
        } catch (JSONException e8) {
            Logger.n("Unable to convert CTMessageDao to JSON - " + e8.getLocalizedMessage());
            return jSONObject;
        }
    }

    private CTMessageDAO(String str, JSONObject jSONObject, boolean z7, long j8, long j9, String str2, List<String> list, String str3, JSONObject jSONObject2) {
        new ArrayList();
        this.f11586d = str;
        this.f11587e = jSONObject;
        this.f11588f = z7;
        this.f11584b = j8;
        this.f11585c = j9;
        this.f11590h = str2;
        this.f11589g = list;
        this.f11583a = str3;
        this.f11591i = jSONObject2;
    }
}
