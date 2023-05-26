package com.clevertap.android.sdk.db;

import com.clevertap.android.sdk.db.DBAdapter;
import org.json.JSONArray;

/* loaded from: classes.dex */
public final class QueueCursor {

    /* renamed from: a  reason: collision with root package name */
    private JSONArray f11131a;

    /* renamed from: b  reason: collision with root package name */
    private String f11132b;

    /* renamed from: c  reason: collision with root package name */
    private DBAdapter.Table f11133c;

    public JSONArray a() {
        return this.f11131a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String b() {
        return this.f11132b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DBAdapter.Table c() {
        return this.f11133c;
    }

    public Boolean d() {
        boolean z7;
        JSONArray jSONArray;
        if (this.f11132b != null && (jSONArray = this.f11131a) != null && jSONArray.length() > 0) {
            z7 = false;
        } else {
            z7 = true;
        }
        return Boolean.valueOf(z7);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(JSONArray jSONArray) {
        this.f11131a = jSONArray;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(String str) {
        this.f11132b = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(DBAdapter.Table table) {
        this.f11133c = table;
    }

    public String toString() {
        if (d().booleanValue()) {
            return "tableName: " + this.f11133c + " | numItems: 0";
        }
        return "tableName: " + this.f11133c + " | lastId: " + this.f11132b + " | numItems: " + this.f11131a.length() + " | items: " + this.f11131a.toString();
    }
}
