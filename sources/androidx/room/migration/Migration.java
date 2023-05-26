package androidx.room.migration;

import androidx.annotation.NonNull;
import androidx.sqlite.db.SupportSQLiteDatabase;

/* loaded from: classes.dex */
public abstract class Migration {

    /* renamed from: a  reason: collision with root package name */
    public final int f7646a;

    /* renamed from: b  reason: collision with root package name */
    public final int f7647b;

    public Migration(int i8, int i9) {
        this.f7646a = i8;
        this.f7647b = i9;
    }

    public abstract void a(@NonNull SupportSQLiteDatabase supportSQLiteDatabase);
}
