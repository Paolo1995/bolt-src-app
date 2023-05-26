package eu.bolt.driver.core.storage;

import eu.bolt.kalev.Kalev;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: StorageMigration.kt */
/* loaded from: classes5.dex */
public abstract class StorageMigration {

    /* renamed from: b  reason: collision with root package name */
    public static final Companion f40945b = new Companion(null);

    /* renamed from: a  reason: collision with root package name */
    private final int f40946a;

    /* compiled from: StorageMigration.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final int a() {
        return this.f40946a;
    }

    public final void b(KVStorage storage) {
        Intrinsics.f(storage, "storage");
        int a8 = storage.a("storage_schema_version", 0);
        int i8 = this.f40946a;
        if (a8 < i8) {
            Kalev.b("Migrating " + storage + " schema from " + a8 + " to " + i8);
            c(storage);
            storage.b("storage_schema_version", Integer.valueOf(this.f40946a));
            StringBuilder sb = new StringBuilder();
            sb.append("Migration is done for ");
            sb.append(storage);
            Kalev.b(sb.toString());
        }
    }

    protected abstract void c(KVStorage kVStorage);
}
