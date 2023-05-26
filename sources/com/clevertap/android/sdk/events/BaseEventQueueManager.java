package com.clevertap.android.sdk.events;

import android.content.Context;
import java.util.concurrent.Future;
import org.json.JSONObject;

/* loaded from: classes.dex */
public abstract class BaseEventQueueManager {
    public abstract void b(Context context, EventGroup eventGroup);

    public abstract void c(JSONObject jSONObject);

    public abstract void d();

    public abstract Future<?> e(Context context, JSONObject jSONObject, int i8);
}
