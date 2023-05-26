package com.google.android.datatransport.runtime.scheduling.persistence;

import android.content.Context;
import javax.inject.Named;

/* loaded from: classes.dex */
public abstract class EventStoreModule {
    /* JADX INFO: Access modifiers changed from: package-private */
    @Named("SQLITE_DB_NAME")
    public static String a() {
        return "com.google.android.datatransport.events";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Named("PACKAGE_NAME")
    public static String b(Context context) {
        return context.getPackageName();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Named("SCHEMA_VERSION")
    public static int c() {
        return SchemaManager.f12318i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static EventStoreConfig d() {
        return EventStoreConfig.f12299a;
    }
}
