package com.clevertap.android.sdk.db;

import android.content.Context;
import android.content.SharedPreferences;
import com.clevertap.android.sdk.CTLockManager;
import com.clevertap.android.sdk.CleverTapInstanceConfig;
import com.clevertap.android.sdk.Logger;
import com.clevertap.android.sdk.StorageHelper;
import com.clevertap.android.sdk.db.DBAdapter;
import com.clevertap.android.sdk.events.EventGroup;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class DBManager extends BaseDatabaseManager {

    /* renamed from: a  reason: collision with root package name */
    private DBAdapter f11128a;

    /* renamed from: b  reason: collision with root package name */
    private final CTLockManager f11129b;

    /* renamed from: c  reason: collision with root package name */
    private final CleverTapInstanceConfig f11130c;

    public DBManager(CleverTapInstanceConfig cleverTapInstanceConfig, CTLockManager cTLockManager) {
        this.f11130c = cleverTapInstanceConfig;
        this.f11129b = cTLockManager;
    }

    private void f(Context context) {
        StorageHelper.n(context, StorageHelper.s(this.f11130c, "comms_first_ts"), 0);
    }

    private void g(Context context) {
        SharedPreferences.Editor edit = StorageHelper.h(context, "IJ").edit();
        edit.clear();
        StorageHelper.l(edit);
    }

    private void h(Context context) {
        StorageHelper.n(context, StorageHelper.s(this.f11130c, "comms_last_ts"), 0);
    }

    private void i(Context context) {
        g(context);
        f(context);
        h(context);
    }

    private void m(Context context, JSONObject jSONObject, DBAdapter.Table table) {
        synchronized (this.f11129b.a()) {
            if (c(context).J(jSONObject, table) > 0) {
                Logger n8 = this.f11130c.n();
                String c8 = this.f11130c.c();
                n8.f(c8, "Queued event: " + jSONObject.toString());
                Logger n9 = this.f11130c.n();
                String c9 = this.f11130c.c();
                n9.s(c9, "Queued event to DB table " + table + ": " + jSONObject.toString());
            }
        }
    }

    @Override // com.clevertap.android.sdk.db.BaseDatabaseManager
    public void a(Context context) {
        synchronized (this.f11129b.a()) {
            DBAdapter c8 = c(context);
            c8.H(DBAdapter.Table.EVENTS);
            c8.H(DBAdapter.Table.PROFILE_EVENTS);
            i(context);
        }
    }

    @Override // com.clevertap.android.sdk.db.BaseDatabaseManager
    public QueueCursor b(Context context, int i8, QueueCursor queueCursor, EventGroup eventGroup) {
        if (eventGroup == EventGroup.PUSH_NOTIFICATION_VIEWED) {
            this.f11130c.n().s(this.f11130c.c(), "Returning Queued Notification Viewed events");
            return j(context, i8, queueCursor);
        }
        this.f11130c.n().s(this.f11130c.c(), "Returning Queued events");
        return l(context, i8, queueCursor);
    }

    @Override // com.clevertap.android.sdk.db.BaseDatabaseManager
    public DBAdapter c(Context context) {
        if (this.f11128a == null) {
            DBAdapter dBAdapter = new DBAdapter(context, this.f11130c);
            this.f11128a = dBAdapter;
            dBAdapter.u(DBAdapter.Table.EVENTS);
            this.f11128a.u(DBAdapter.Table.PROFILE_EVENTS);
            this.f11128a.u(DBAdapter.Table.PUSH_NOTIFICATION_VIEWED);
            this.f11128a.s();
        }
        return this.f11128a;
    }

    @Override // com.clevertap.android.sdk.db.BaseDatabaseManager
    public void d(Context context, JSONObject jSONObject, int i8) {
        DBAdapter.Table table;
        if (i8 == 3) {
            table = DBAdapter.Table.PROFILE_EVENTS;
        } else {
            table = DBAdapter.Table.EVENTS;
        }
        m(context, jSONObject, table);
    }

    @Override // com.clevertap.android.sdk.db.BaseDatabaseManager
    public void e(Context context, JSONObject jSONObject) {
        m(context, jSONObject, DBAdapter.Table.PUSH_NOTIFICATION_VIEWED);
    }

    QueueCursor j(Context context, int i8, QueueCursor queueCursor) {
        return k(context, DBAdapter.Table.PUSH_NOTIFICATION_VIEWED, i8, queueCursor);
    }

    QueueCursor k(Context context, DBAdapter.Table table, int i8, QueueCursor queueCursor) {
        QueueCursor n8;
        synchronized (this.f11129b.a()) {
            DBAdapter c8 = c(context);
            if (queueCursor != null) {
                table = queueCursor.c();
            }
            if (queueCursor != null) {
                c8.t(queueCursor.b(), queueCursor.c());
            }
            QueueCursor queueCursor2 = new QueueCursor();
            queueCursor2.g(table);
            n8 = n(c8.y(table, i8), queueCursor2);
        }
        return n8;
    }

    QueueCursor l(Context context, int i8, QueueCursor queueCursor) {
        QueueCursor queueCursor2;
        synchronized (this.f11129b.a()) {
            DBAdapter.Table table = DBAdapter.Table.EVENTS;
            QueueCursor k8 = k(context, table, i8, queueCursor);
            queueCursor2 = null;
            if (k8.d().booleanValue() && k8.c().equals(table)) {
                k8 = k(context, DBAdapter.Table.PROFILE_EVENTS, i8, null);
            }
            if (!k8.d().booleanValue()) {
                queueCursor2 = k8;
            }
        }
        return queueCursor2;
    }

    QueueCursor n(JSONObject jSONObject, QueueCursor queueCursor) {
        if (jSONObject == null) {
            return queueCursor;
        }
        Iterator<String> keys = jSONObject.keys();
        if (keys.hasNext()) {
            String next = keys.next();
            queueCursor.f(next);
            try {
                queueCursor.e(jSONObject.getJSONArray(next));
            } catch (JSONException unused) {
                queueCursor.f(null);
                queueCursor.e(null);
            }
        }
        return queueCursor;
    }
}
