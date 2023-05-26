package com.clevertap.android.sdk.db;

import android.content.Context;
import com.clevertap.android.sdk.events.EventGroup;
import org.json.JSONObject;

/* loaded from: classes.dex */
public abstract class BaseDatabaseManager {
    public abstract void a(Context context);

    public abstract QueueCursor b(Context context, int i8, QueueCursor queueCursor, EventGroup eventGroup);

    public abstract DBAdapter c(Context context);

    public abstract void d(Context context, JSONObject jSONObject, int i8);

    public abstract void e(Context context, JSONObject jSONObject);
}
