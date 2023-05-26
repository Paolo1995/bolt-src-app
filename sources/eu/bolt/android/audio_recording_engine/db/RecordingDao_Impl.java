package eu.bolt.android.audio_recording_engine.db;

import android.database.Cursor;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* loaded from: classes5.dex */
public final class RecordingDao_Impl implements RecordingDao {

    /* renamed from: a  reason: collision with root package name */
    private final RoomDatabase f36606a;

    /* renamed from: b  reason: collision with root package name */
    private final EntityInsertionAdapter<OrderRecordingsData> f36607b;

    /* renamed from: c  reason: collision with root package name */
    private final EntityInsertionAdapter<RecordingFileInfo> f36608c;

    /* renamed from: d  reason: collision with root package name */
    private final SharedSQLiteStatement f36609d;

    public RecordingDao_Impl(RoomDatabase roomDatabase) {
        this.f36606a = roomDatabase;
        this.f36607b = new EntityInsertionAdapter<OrderRecordingsData>(roomDatabase) { // from class: eu.bolt.android.audio_recording_engine.db.RecordingDao_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            public String d() {
                return "INSERT OR IGNORE INTO `OrderRecordingsData` (`orderKey`,`createdTimeStamp`,`fileSize`) VALUES (?,?,?)";
            }

            @Override // androidx.room.EntityInsertionAdapter
            /* renamed from: k */
            public void g(SupportSQLiteStatement supportSQLiteStatement, OrderRecordingsData orderRecordingsData) {
                if (orderRecordingsData.c() == null) {
                    supportSQLiteStatement.Q0(1);
                } else {
                    supportSQLiteStatement.q0(1, orderRecordingsData.c());
                }
                supportSQLiteStatement.B0(2, orderRecordingsData.a());
                supportSQLiteStatement.B0(3, orderRecordingsData.b());
            }
        };
        this.f36608c = new EntityInsertionAdapter<RecordingFileInfo>(roomDatabase) { // from class: eu.bolt.android.audio_recording_engine.db.RecordingDao_Impl.2
            @Override // androidx.room.SharedSQLiteStatement
            public String d() {
                return "INSERT OR IGNORE INTO `RecordingFileInfo` (`fileIndex`,`parentOrderKey`,`isUploaded`,`durationMilliSecs`) VALUES (?,?,?,?)";
            }

            @Override // androidx.room.EntityInsertionAdapter
            /* renamed from: k */
            public void g(SupportSQLiteStatement supportSQLiteStatement, RecordingFileInfo recordingFileInfo) {
                supportSQLiteStatement.B0(1, recordingFileInfo.b());
                if (recordingFileInfo.c() == null) {
                    supportSQLiteStatement.Q0(2);
                } else {
                    supportSQLiteStatement.q0(2, recordingFileInfo.c());
                }
                supportSQLiteStatement.B0(3, recordingFileInfo.d() ? 1L : 0L);
                if (recordingFileInfo.a() == null) {
                    supportSQLiteStatement.Q0(4);
                } else {
                    supportSQLiteStatement.B0(4, recordingFileInfo.a().longValue());
                }
            }
        };
        this.f36609d = new SharedSQLiteStatement(roomDatabase) { // from class: eu.bolt.android.audio_recording_engine.db.RecordingDao_Impl.3
            @Override // androidx.room.SharedSQLiteStatement
            public String d() {
                return "UPDATE RecordingFileInfo SET isUploaded = 'true' WHERE fileIndex = ? AND parentOrderKey =?";
            }
        };
    }

    public static List<Class<?>> l() {
        return Collections.emptyList();
    }

    @Override // eu.bolt.android.audio_recording_engine.db.RecordingDao
    public Object a(String str, Continuation<? super List<Long>> continuation) {
        final RoomSQLiteQuery e8 = RoomSQLiteQuery.e("SELECT durationMilliSecs FROM RecordingFileInfo WHERE parentOrderKey =?", 1);
        if (str == null) {
            e8.Q0(1);
        } else {
            e8.q0(1, str);
        }
        return CoroutinesRoom.a(this.f36606a, false, DBUtil.a(), new Callable<List<Long>>() { // from class: eu.bolt.android.audio_recording_engine.db.RecordingDao_Impl.9
            @Override // java.util.concurrent.Callable
            /* renamed from: a */
            public List<Long> call() throws Exception {
                Long valueOf;
                Cursor c8 = DBUtil.c(RecordingDao_Impl.this.f36606a, e8, false, null);
                try {
                    ArrayList arrayList = new ArrayList(c8.getCount());
                    while (c8.moveToNext()) {
                        if (c8.isNull(0)) {
                            valueOf = null;
                        } else {
                            valueOf = Long.valueOf(c8.getLong(0));
                        }
                        arrayList.add(valueOf);
                    }
                    return arrayList;
                } finally {
                    c8.close();
                    e8.release();
                }
            }
        }, continuation);
    }

    @Override // eu.bolt.android.audio_recording_engine.db.RecordingDao
    public Object b(long j8, int i8, Continuation<? super List<String>> continuation) {
        final RoomSQLiteQuery e8 = RoomSQLiteQuery.e("SELECT orderKey FROM OrderRecordingsData WHERE ? - createdTimeStamp >= ?", 2);
        e8.B0(1, j8);
        e8.B0(2, i8);
        return CoroutinesRoom.a(this.f36606a, false, DBUtil.a(), new Callable<List<String>>() { // from class: eu.bolt.android.audio_recording_engine.db.RecordingDao_Impl.10
            @Override // java.util.concurrent.Callable
            /* renamed from: a */
            public List<String> call() throws Exception {
                String string;
                Cursor c8 = DBUtil.c(RecordingDao_Impl.this.f36606a, e8, false, null);
                try {
                    ArrayList arrayList = new ArrayList(c8.getCount());
                    while (c8.moveToNext()) {
                        if (c8.isNull(0)) {
                            string = null;
                        } else {
                            string = c8.getString(0);
                        }
                        arrayList.add(string);
                    }
                    return arrayList;
                } finally {
                    c8.close();
                    e8.release();
                }
            }
        }, continuation);
    }

    @Override // eu.bolt.android.audio_recording_engine.db.RecordingDao
    public Object c(final String str, final int i8, Continuation<? super Unit> continuation) {
        return CoroutinesRoom.b(this.f36606a, true, new Callable<Unit>() { // from class: eu.bolt.android.audio_recording_engine.db.RecordingDao_Impl.6
            @Override // java.util.concurrent.Callable
            /* renamed from: a */
            public Unit call() throws Exception {
                SupportSQLiteStatement a8 = RecordingDao_Impl.this.f36609d.a();
                a8.B0(1, i8);
                String str2 = str;
                if (str2 == null) {
                    a8.Q0(2);
                } else {
                    a8.q0(2, str2);
                }
                RecordingDao_Impl.this.f36606a.e();
                try {
                    a8.x();
                    RecordingDao_Impl.this.f36606a.E();
                    return Unit.f50853a;
                } finally {
                    RecordingDao_Impl.this.f36606a.i();
                    RecordingDao_Impl.this.f36609d.f(a8);
                }
            }
        }, continuation);
    }

    @Override // eu.bolt.android.audio_recording_engine.db.RecordingDao
    public Object d(String str, Continuation<? super List<Integer>> continuation) {
        final RoomSQLiteQuery e8 = RoomSQLiteQuery.e("SELECT fileIndex FROM RecordingFileInfo WHERE isUploaded = '0' AND parentOrderKey =?", 1);
        if (str == null) {
            e8.Q0(1);
        } else {
            e8.q0(1, str);
        }
        return CoroutinesRoom.a(this.f36606a, true, DBUtil.a(), new Callable<List<Integer>>() { // from class: eu.bolt.android.audio_recording_engine.db.RecordingDao_Impl.8
            @Override // java.util.concurrent.Callable
            /* renamed from: a */
            public List<Integer> call() throws Exception {
                Integer valueOf;
                RecordingDao_Impl.this.f36606a.e();
                try {
                    Cursor c8 = DBUtil.c(RecordingDao_Impl.this.f36606a, e8, false, null);
                    ArrayList arrayList = new ArrayList(c8.getCount());
                    while (c8.moveToNext()) {
                        if (c8.isNull(0)) {
                            valueOf = null;
                        } else {
                            valueOf = Integer.valueOf(c8.getInt(0));
                        }
                        arrayList.add(valueOf);
                    }
                    RecordingDao_Impl.this.f36606a.E();
                    c8.close();
                    e8.release();
                    return arrayList;
                } finally {
                    RecordingDao_Impl.this.f36606a.i();
                }
            }
        }, continuation);
    }

    @Override // eu.bolt.android.audio_recording_engine.db.RecordingDao
    public Object e(final RecordingFileInfo recordingFileInfo, Continuation<? super Unit> continuation) {
        return CoroutinesRoom.b(this.f36606a, true, new Callable<Unit>() { // from class: eu.bolt.android.audio_recording_engine.db.RecordingDao_Impl.5
            @Override // java.util.concurrent.Callable
            /* renamed from: a */
            public Unit call() throws Exception {
                RecordingDao_Impl.this.f36606a.e();
                try {
                    RecordingDao_Impl.this.f36608c.i(recordingFileInfo);
                    RecordingDao_Impl.this.f36606a.E();
                    return Unit.f50853a;
                } finally {
                    RecordingDao_Impl.this.f36606a.i();
                }
            }
        }, continuation);
    }

    @Override // eu.bolt.android.audio_recording_engine.db.RecordingDao
    public Object f(String str, Continuation<? super OrderRecordingsData> continuation) {
        final RoomSQLiteQuery e8 = RoomSQLiteQuery.e("SELECT * FROM OrderRecordingsData WHERE orderKey = ?", 1);
        if (str == null) {
            e8.Q0(1);
        } else {
            e8.q0(1, str);
        }
        return CoroutinesRoom.a(this.f36606a, false, DBUtil.a(), new Callable<OrderRecordingsData>() { // from class: eu.bolt.android.audio_recording_engine.db.RecordingDao_Impl.7
            @Override // java.util.concurrent.Callable
            /* renamed from: a */
            public OrderRecordingsData call() throws Exception {
                OrderRecordingsData orderRecordingsData = null;
                String string = null;
                Cursor c8 = DBUtil.c(RecordingDao_Impl.this.f36606a, e8, false, null);
                try {
                    int e9 = CursorUtil.e(c8, "orderKey");
                    int e10 = CursorUtil.e(c8, "createdTimeStamp");
                    int e11 = CursorUtil.e(c8, "fileSize");
                    if (c8.moveToFirst()) {
                        if (!c8.isNull(e9)) {
                            string = c8.getString(e9);
                        }
                        orderRecordingsData = new OrderRecordingsData(string, c8.getLong(e10), c8.getLong(e11));
                    }
                    return orderRecordingsData;
                } finally {
                    c8.close();
                    e8.release();
                }
            }
        }, continuation);
    }

    @Override // eu.bolt.android.audio_recording_engine.db.RecordingDao
    public Object g(final OrderRecordingsData orderRecordingsData, Continuation<? super Unit> continuation) {
        return CoroutinesRoom.b(this.f36606a, true, new Callable<Unit>() { // from class: eu.bolt.android.audio_recording_engine.db.RecordingDao_Impl.4
            @Override // java.util.concurrent.Callable
            /* renamed from: a */
            public Unit call() throws Exception {
                RecordingDao_Impl.this.f36606a.e();
                try {
                    RecordingDao_Impl.this.f36607b.i(orderRecordingsData);
                    RecordingDao_Impl.this.f36606a.E();
                    return Unit.f50853a;
                } finally {
                    RecordingDao_Impl.this.f36606a.i();
                }
            }
        }, continuation);
    }
}
