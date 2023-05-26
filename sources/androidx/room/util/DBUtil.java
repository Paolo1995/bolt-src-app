package androidx.room.util;

import android.database.AbstractWindowedCursor;
import android.database.Cursor;
import android.os.Build;
import android.os.CancellationSignal;
import androidx.annotation.NonNull;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteCompat$Api16Impl;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteQuery;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.spi.AbstractInterruptibleChannel;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class DBUtil {
    private DBUtil() {
    }

    public static CancellationSignal a() {
        return SupportSQLiteCompat$Api16Impl.b();
    }

    public static void b(SupportSQLiteDatabase supportSQLiteDatabase) {
        ArrayList<String> arrayList = new ArrayList();
        Cursor J0 = supportSQLiteDatabase.J0("SELECT name FROM sqlite_master WHERE type = 'trigger'");
        while (J0.moveToNext()) {
            try {
                arrayList.add(J0.getString(0));
            } catch (Throwable th) {
                J0.close();
                throw th;
            }
        }
        J0.close();
        for (String str : arrayList) {
            if (str.startsWith("room_fts_content_sync_")) {
                supportSQLiteDatabase.u("DROP TRIGGER IF EXISTS " + str);
            }
        }
    }

    @NonNull
    public static Cursor c(@NonNull RoomDatabase roomDatabase, @NonNull SupportSQLiteQuery supportSQLiteQuery, boolean z7, CancellationSignal cancellationSignal) {
        int i8;
        Cursor C = roomDatabase.C(supportSQLiteQuery, cancellationSignal);
        if (z7 && (C instanceof AbstractWindowedCursor)) {
            AbstractWindowedCursor abstractWindowedCursor = (AbstractWindowedCursor) C;
            int count = abstractWindowedCursor.getCount();
            if (abstractWindowedCursor.hasWindow()) {
                i8 = abstractWindowedCursor.getWindow().getNumRows();
            } else {
                i8 = count;
            }
            if (Build.VERSION.SDK_INT < 23 || i8 < count) {
                return CursorUtil.a(abstractWindowedCursor);
            }
            return C;
        }
        return C;
    }

    public static int d(@NonNull File file) throws IOException {
        AbstractInterruptibleChannel abstractInterruptibleChannel = null;
        try {
            ByteBuffer allocate = ByteBuffer.allocate(4);
            FileChannel channel = new FileInputStream(file).getChannel();
            channel.tryLock(60L, 4L, true);
            channel.position(60L);
            if (channel.read(allocate) == 4) {
                allocate.rewind();
                int i8 = allocate.getInt();
                channel.close();
                return i8;
            }
            throw new IOException("Bad database header, unable to read 4 bytes at offset 60");
        } catch (Throwable th) {
            if (0 != 0) {
                abstractInterruptibleChannel.close();
            }
            throw th;
        }
    }
}
