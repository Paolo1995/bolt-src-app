package com.google.firebase.remoteconfig.internal;

import java.util.Date;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class ConfigContainer {

    /* renamed from: f  reason: collision with root package name */
    private static final Date f17065f = new Date(0);

    /* renamed from: a  reason: collision with root package name */
    private JSONObject f17066a;

    /* renamed from: b  reason: collision with root package name */
    private JSONObject f17067b;

    /* renamed from: c  reason: collision with root package name */
    private Date f17068c;

    /* renamed from: d  reason: collision with root package name */
    private JSONArray f17069d;

    /* renamed from: e  reason: collision with root package name */
    private JSONObject f17070e;

    /* loaded from: classes3.dex */
    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        private JSONObject f17071a;

        /* renamed from: b  reason: collision with root package name */
        private Date f17072b;

        /* renamed from: c  reason: collision with root package name */
        private JSONArray f17073c;

        /* renamed from: d  reason: collision with root package name */
        private JSONObject f17074d;

        public ConfigContainer a() throws JSONException {
            return new ConfigContainer(this.f17071a, this.f17072b, this.f17073c, this.f17074d);
        }

        public Builder b(Map<String, String> map) {
            this.f17071a = new JSONObject(map);
            return this;
        }

        public Builder c(JSONObject jSONObject) {
            try {
                this.f17071a = new JSONObject(jSONObject.toString());
            } catch (JSONException unused) {
            }
            return this;
        }

        public Builder d(JSONArray jSONArray) {
            try {
                this.f17073c = new JSONArray(jSONArray.toString());
            } catch (JSONException unused) {
            }
            return this;
        }

        public Builder e(Date date) {
            this.f17072b = date;
            return this;
        }

        public Builder f(JSONObject jSONObject) {
            try {
                this.f17074d = new JSONObject(jSONObject.toString());
            } catch (JSONException unused) {
            }
            return this;
        }

        private Builder() {
            this.f17071a = new JSONObject();
            this.f17072b = ConfigContainer.f17065f;
            this.f17073c = new JSONArray();
            this.f17074d = new JSONObject();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ConfigContainer b(JSONObject jSONObject) throws JSONException {
        JSONObject optJSONObject = jSONObject.optJSONObject("personalization_metadata_key");
        if (optJSONObject == null) {
            optJSONObject = new JSONObject();
        }
        return new ConfigContainer(jSONObject.getJSONObject("configs_key"), new Date(jSONObject.getLong("fetch_time_key")), jSONObject.getJSONArray("abt_experiments_key"), optJSONObject);
    }

    public static Builder g() {
        return new Builder();
    }

    public JSONArray c() {
        return this.f17069d;
    }

    public JSONObject d() {
        return this.f17067b;
    }

    public Date e() {
        return this.f17068c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ConfigContainer)) {
            return false;
        }
        return this.f17066a.toString().equals(((ConfigContainer) obj).toString());
    }

    public JSONObject f() {
        return this.f17070e;
    }

    public int hashCode() {
        return this.f17066a.hashCode();
    }

    public String toString() {
        return this.f17066a.toString();
    }

    private ConfigContainer(JSONObject jSONObject, Date date, JSONArray jSONArray, JSONObject jSONObject2) throws JSONException {
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("configs_key", jSONObject);
        jSONObject3.put("fetch_time_key", date.getTime());
        jSONObject3.put("abt_experiments_key", jSONArray);
        jSONObject3.put("personalization_metadata_key", jSONObject2);
        this.f17067b = jSONObject;
        this.f17068c = date;
        this.f17069d = jSONArray;
        this.f17070e = jSONObject2;
        this.f17066a = jSONObject3;
    }
}
