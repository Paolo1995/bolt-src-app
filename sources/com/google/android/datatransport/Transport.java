package com.google.android.datatransport;

/* loaded from: classes.dex */
public interface Transport<T> {
    void a(Event<T> event, TransportScheduleCallback transportScheduleCallback);

    void b(Event<T> event);
}
