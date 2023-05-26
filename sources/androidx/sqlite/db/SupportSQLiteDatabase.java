package androidx.sqlite.db;

import android.database.Cursor;
import android.database.SQLException;
import android.os.CancellationSignal;
import android.util.Pair;
import java.io.Closeable;
import java.util.List;

/* loaded from: classes.dex */
public interface SupportSQLiteDatabase extends Closeable {
    Cursor C(SupportSQLiteQuery supportSQLiteQuery, CancellationSignal cancellationSignal);

    Cursor J0(String str);

    void K();

    void L(String str, Object[] objArr) throws SQLException;

    void M();

    void S();

    boolean T0();

    Cursor a0(SupportSQLiteQuery supportSQLiteQuery);

    boolean d1();

    String getPath();

    boolean isOpen();

    void n();

    void p0(int i8);

    List<Pair<String, String>> r();

    SupportSQLiteStatement r0(String str);

    void u(String str) throws SQLException;
}
