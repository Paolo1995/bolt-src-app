package com.google.android.datatransport.runtime.scheduling.persistence;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.os.SystemClock;
import android.util.Base64;
import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.runtime.EncodedPayload;
import com.google.android.datatransport.runtime.EventInternal;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.dagger.Lazy;
import com.google.android.datatransport.runtime.firebase.transport.ClientMetrics;
import com.google.android.datatransport.runtime.firebase.transport.GlobalMetrics;
import com.google.android.datatransport.runtime.firebase.transport.LogEventDropped;
import com.google.android.datatransport.runtime.firebase.transport.LogSourceMetrics;
import com.google.android.datatransport.runtime.firebase.transport.StorageMetrics;
import com.google.android.datatransport.runtime.firebase.transport.TimeWindow;
import com.google.android.datatransport.runtime.logging.Logging;
import com.google.android.datatransport.runtime.synchronization.SynchronizationException;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import com.google.android.datatransport.runtime.time.Clock;
import com.google.android.datatransport.runtime.util.PriorityMapping;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

@Singleton
/* loaded from: classes.dex */
public class SQLiteEventStore implements EventStore, SynchronizationGuard, ClientHealthMetricsStore {

    /* renamed from: k  reason: collision with root package name */
    private static final Encoding f12304k = Encoding.b("proto");

    /* renamed from: f  reason: collision with root package name */
    private final SchemaManager f12305f;

    /* renamed from: g  reason: collision with root package name */
    private final Clock f12306g;

    /* renamed from: h  reason: collision with root package name */
    private final Clock f12307h;

    /* renamed from: i  reason: collision with root package name */
    private final EventStoreConfig f12308i;

    /* renamed from: j  reason: collision with root package name */
    private final Lazy<String> f12309j;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface Function<T, U> {
        U apply(T t7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class Metadata {

        /* renamed from: a  reason: collision with root package name */
        final String f12310a;

        /* renamed from: b  reason: collision with root package name */
        final String f12311b;

        private Metadata(String str, String str2) {
            this.f12310a = str;
            this.f12311b = str2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface Producer<T> {
        T a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Inject
    public SQLiteEventStore(Clock clock, Clock clock2, EventStoreConfig eventStoreConfig, SchemaManager schemaManager, @Named("PACKAGE_NAME") Lazy<String> lazy) {
        this.f12305f = schemaManager;
        this.f12306g = clock;
        this.f12307h = clock2;
        this.f12308i = eventStoreConfig;
        this.f12309j = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ ClientMetrics A1(String str, final Map map, final ClientMetrics.Builder builder, SQLiteDatabase sQLiteDatabase) {
        return (ClientMetrics) T1(sQLiteDatabase.rawQuery(str, new String[0]), new Function() { // from class: com.google.android.datatransport.runtime.scheduling.persistence.q
            @Override // com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore.Function
            public final Object apply(Object obj) {
                ClientMetrics z12;
                z12 = SQLiteEventStore.this.z1(map, builder, (Cursor) obj);
                return z12;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object B1(List list, TransportContext transportContext, Cursor cursor) {
        while (cursor.moveToNext()) {
            boolean z7 = false;
            long j8 = cursor.getLong(0);
            if (cursor.getInt(7) != 0) {
                z7 = true;
            }
            EventInternal.Builder k8 = EventInternal.a().j(cursor.getString(1)).i(cursor.getLong(2)).k(cursor.getLong(3));
            if (z7) {
                k8.h(new EncodedPayload(R1(cursor.getString(4)), cursor.getBlob(5)));
            } else {
                k8.h(new EncodedPayload(R1(cursor.getString(4)), P1(j8)));
            }
            if (!cursor.isNull(6)) {
                k8.g(Integer.valueOf(cursor.getInt(6)));
            }
            list.add(PersistedEvent.a(j8, transportContext, k8.d()));
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object C1(Map map, Cursor cursor) {
        while (cursor.moveToNext()) {
            long j8 = cursor.getLong(0);
            Set set = (Set) map.get(Long.valueOf(j8));
            if (set == null) {
                set = new HashSet();
                map.put(Long.valueOf(j8), set);
            }
            set.add(new Metadata(cursor.getString(1), cursor.getString(2)));
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Long D1(EventInternal eventInternal, TransportContext transportContext, SQLiteDatabase sQLiteDatabase) {
        boolean z7;
        byte[] bArr;
        if (h1()) {
            g(1L, LogEventDropped.Reason.CACHE_FULL, eventInternal.j());
            return -1L;
        }
        long P0 = P0(sQLiteDatabase, transportContext);
        int e8 = this.f12308i.e();
        byte[] a8 = eventInternal.e().a();
        if (a8.length <= e8) {
            z7 = true;
        } else {
            z7 = false;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("context_id", Long.valueOf(P0));
        contentValues.put("transport_name", eventInternal.j());
        contentValues.put("timestamp_ms", Long.valueOf(eventInternal.f()));
        contentValues.put("uptime_ms", Long.valueOf(eventInternal.k()));
        contentValues.put("payload_encoding", eventInternal.e().b().a());
        contentValues.put("code", eventInternal.d());
        contentValues.put("num_attempts", (Integer) 0);
        contentValues.put("inline", Boolean.valueOf(z7));
        if (z7) {
            bArr = a8;
        } else {
            bArr = new byte[0];
        }
        contentValues.put("payload", bArr);
        long insert = sQLiteDatabase.insert("events", null, contentValues);
        if (!z7) {
            int ceil = (int) Math.ceil(a8.length / e8);
            for (int i8 = 1; i8 <= ceil; i8++) {
                byte[] copyOfRange = Arrays.copyOfRange(a8, (i8 - 1) * e8, Math.min(i8 * e8, a8.length));
                ContentValues contentValues2 = new ContentValues();
                contentValues2.put("event_id", Long.valueOf(insert));
                contentValues2.put("sequence_num", Integer.valueOf(i8));
                contentValues2.put("bytes", copyOfRange);
                sQLiteDatabase.insert("event_payloads", null, contentValues2);
            }
        }
        for (Map.Entry<String, String> entry : eventInternal.i().entrySet()) {
            ContentValues contentValues3 = new ContentValues();
            contentValues3.put("event_id", Long.valueOf(insert));
            contentValues3.put("name", entry.getKey());
            contentValues3.put(AppMeasurementSdk.ConditionalUserProperty.VALUE, entry.getValue());
            sQLiteDatabase.insert("event_metadata", null, contentValues3);
        }
        return Long.valueOf(insert);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ byte[] E1(Cursor cursor) {
        ArrayList arrayList = new ArrayList();
        int i8 = 0;
        while (cursor.moveToNext()) {
            byte[] blob = cursor.getBlob(0);
            arrayList.add(blob);
            i8 += blob.length;
        }
        byte[] bArr = new byte[i8];
        int i9 = 0;
        for (int i10 = 0; i10 < arrayList.size(); i10++) {
            byte[] bArr2 = (byte[]) arrayList.get(i10);
            System.arraycopy(bArr2, 0, bArr, i9, bArr2.length);
            i9 += bArr2.length;
        }
        return bArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object F1(Cursor cursor) {
        while (cursor.moveToNext()) {
            int i8 = cursor.getInt(0);
            g(i8, LogEventDropped.Reason.MAX_RETRIES_REACHED, cursor.getString(1));
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object G1(String str, String str2, SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.compileStatement(str).execute();
        T1(sQLiteDatabase.rawQuery(str2, null), new Function() { // from class: com.google.android.datatransport.runtime.scheduling.persistence.n
            @Override // com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore.Function
            public final Object apply(Object obj) {
                Object F1;
                F1 = SQLiteEventStore.this.F1((Cursor) obj);
                return F1;
            }
        });
        sQLiteDatabase.compileStatement("DELETE FROM events WHERE num_attempts >= 16").execute();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Boolean H1(Cursor cursor) {
        boolean z7;
        if (cursor.getCount() > 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        return Boolean.valueOf(z7);
    }

    private LogEventDropped.Reason I0(int i8) {
        LogEventDropped.Reason reason = LogEventDropped.Reason.REASON_UNKNOWN;
        if (i8 == reason.getNumber()) {
            return reason;
        }
        LogEventDropped.Reason reason2 = LogEventDropped.Reason.MESSAGE_TOO_OLD;
        if (i8 == reason2.getNumber()) {
            return reason2;
        }
        LogEventDropped.Reason reason3 = LogEventDropped.Reason.CACHE_FULL;
        if (i8 == reason3.getNumber()) {
            return reason3;
        }
        LogEventDropped.Reason reason4 = LogEventDropped.Reason.PAYLOAD_TOO_BIG;
        if (i8 == reason4.getNumber()) {
            return reason4;
        }
        LogEventDropped.Reason reason5 = LogEventDropped.Reason.MAX_RETRIES_REACHED;
        if (i8 == reason5.getNumber()) {
            return reason5;
        }
        LogEventDropped.Reason reason6 = LogEventDropped.Reason.INVALID_PAYLOD;
        if (i8 == reason6.getNumber()) {
            return reason6;
        }
        LogEventDropped.Reason reason7 = LogEventDropped.Reason.SERVER_ERROR;
        if (i8 == reason7.getNumber()) {
            return reason7;
        }
        Logging.b("SQLiteEventStore", "%n is not valid. No matched LogEventDropped-Reason found. Treated it as REASON_UNKNOWN", Integer.valueOf(i8));
        return reason;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object I1(String str, LogEventDropped.Reason reason, long j8, SQLiteDatabase sQLiteDatabase) {
        if (!((Boolean) T1(sQLiteDatabase.rawQuery("SELECT 1 FROM log_event_dropped WHERE log_source = ? AND reason = ?", new String[]{str, Integer.toString(reason.getNumber())}), new Function() { // from class: com.google.android.datatransport.runtime.scheduling.persistence.m
            @Override // com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore.Function
            public final Object apply(Object obj) {
                Boolean H1;
                H1 = SQLiteEventStore.H1((Cursor) obj);
                return H1;
            }
        })).booleanValue()) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("log_source", str);
            contentValues.put("reason", Integer.valueOf(reason.getNumber()));
            contentValues.put("events_dropped_count", Long.valueOf(j8));
            sQLiteDatabase.insert("log_event_dropped", null, contentValues);
        } else {
            sQLiteDatabase.execSQL("UPDATE log_event_dropped SET events_dropped_count = events_dropped_count + " + j8 + " WHERE log_source = ? AND reason = ?", new String[]{str, Integer.toString(reason.getNumber())});
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object J1(long j8, TransportContext transportContext, SQLiteDatabase sQLiteDatabase) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("next_request_ms", Long.valueOf(j8));
        if (sQLiteDatabase.update("transport_contexts", contentValues, "backend_name = ? and priority = ?", new String[]{transportContext.b(), String.valueOf(PriorityMapping.a(transportContext.d()))}) < 1) {
            contentValues.put("backend_name", transportContext.b());
            contentValues.put("priority", Integer.valueOf(PriorityMapping.a(transportContext.d())));
            sQLiteDatabase.insert("transport_contexts", null, contentValues);
        }
        return null;
    }

    private void K0(final SQLiteDatabase sQLiteDatabase) {
        Q1(new Producer() { // from class: com.google.android.datatransport.runtime.scheduling.persistence.v
            @Override // com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore.Producer
            public final Object a() {
                Object o12;
                o12 = SQLiteEventStore.o1(sQLiteDatabase);
                return o12;
            }
        }, new Function() { // from class: com.google.android.datatransport.runtime.scheduling.persistence.w
            @Override // com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore.Function
            public final Object apply(Object obj) {
                Object p12;
                p12 = SQLiteEventStore.p1((Throwable) obj);
                return p12;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object K1(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.compileStatement("DELETE FROM log_event_dropped").execute();
        sQLiteDatabase.compileStatement("UPDATE global_log_event_state SET last_metrics_upload_ms=" + this.f12306g.a()).execute();
        return null;
    }

    private List<PersistedEvent> L1(SQLiteDatabase sQLiteDatabase, final TransportContext transportContext) {
        final ArrayList arrayList = new ArrayList();
        Long c12 = c1(sQLiteDatabase, transportContext);
        if (c12 == null) {
            return arrayList;
        }
        T1(sQLiteDatabase.query("events", new String[]{"_id", "transport_name", "timestamp_ms", "uptime_ms", "payload_encoding", "payload", "code", "inline"}, "context_id = ?", new String[]{c12.toString()}, null, null, null, String.valueOf(this.f12308i.d())), new Function() { // from class: com.google.android.datatransport.runtime.scheduling.persistence.k
            @Override // com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore.Function
            public final Object apply(Object obj) {
                Object B1;
                B1 = SQLiteEventStore.this.B1(arrayList, transportContext, (Cursor) obj);
                return B1;
            }
        });
        return arrayList;
    }

    private Map<Long, Set<Metadata>> M1(SQLiteDatabase sQLiteDatabase, List<PersistedEvent> list) {
        final HashMap hashMap = new HashMap();
        StringBuilder sb = new StringBuilder("event_id IN (");
        for (int i8 = 0; i8 < list.size(); i8++) {
            sb.append(list.get(i8).c());
            if (i8 < list.size() - 1) {
                sb.append(',');
            }
        }
        sb.append(')');
        T1(sQLiteDatabase.query("event_metadata", new String[]{"event_id", "name", AppMeasurementSdk.ConditionalUserProperty.VALUE}, sb.toString(), null, null, null, null), new Function() { // from class: com.google.android.datatransport.runtime.scheduling.persistence.i
            @Override // com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore.Function
            public final Object apply(Object obj) {
                Object C1;
                C1 = SQLiteEventStore.C1(hashMap, (Cursor) obj);
                return C1;
            }
        });
        return hashMap;
    }

    private static byte[] N1(String str) {
        if (str == null) {
            return null;
        }
        return Base64.decode(str, 0);
    }

    private void O1(ClientMetrics.Builder builder, Map<String, List<LogEventDropped>> map) {
        for (Map.Entry<String, List<LogEventDropped>> entry : map.entrySet()) {
            builder.a(LogSourceMetrics.c().c(entry.getKey()).b(entry.getValue()).a());
        }
    }

    private long P0(SQLiteDatabase sQLiteDatabase, TransportContext transportContext) {
        Long c12 = c1(sQLiteDatabase, transportContext);
        if (c12 != null) {
            return c12.longValue();
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("backend_name", transportContext.b());
        contentValues.put("priority", Integer.valueOf(PriorityMapping.a(transportContext.d())));
        contentValues.put("next_request_ms", (Integer) 0);
        if (transportContext.c() != null) {
            contentValues.put("extras", Base64.encodeToString(transportContext.c(), 0));
        }
        return sQLiteDatabase.insert("transport_contexts", null, contentValues);
    }

    private byte[] P1(long j8) {
        return (byte[]) T1(S0().query("event_payloads", new String[]{"bytes"}, "event_id = ?", new String[]{String.valueOf(j8)}, null, null, "sequence_num"), new Function() { // from class: com.google.android.datatransport.runtime.scheduling.persistence.p
            @Override // com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore.Function
            public final Object apply(Object obj) {
                byte[] E1;
                E1 = SQLiteEventStore.E1((Cursor) obj);
                return E1;
            }
        });
    }

    private <T> T Q1(Producer<T> producer, Function<Throwable, T> function) {
        long a8 = this.f12307h.a();
        while (true) {
            try {
                return producer.a();
            } catch (SQLiteDatabaseLockedException e8) {
                if (this.f12307h.a() >= this.f12308i.b() + a8) {
                    return function.apply(e8);
                }
                SystemClock.sleep(50L);
            }
        }
    }

    private static Encoding R1(String str) {
        if (str == null) {
            return f12304k;
        }
        return Encoding.b(str);
    }

    private static String S1(Iterable<PersistedEvent> iterable) {
        StringBuilder sb = new StringBuilder("(");
        Iterator<PersistedEvent> it = iterable.iterator();
        while (it.hasNext()) {
            sb.append(it.next().c());
            if (it.hasNext()) {
                sb.append(',');
            }
        }
        sb.append(')');
        return sb.toString();
    }

    static <T> T T1(Cursor cursor, Function<Cursor, T> function) {
        try {
            return function.apply(cursor);
        } finally {
            cursor.close();
        }
    }

    private GlobalMetrics U0() {
        return GlobalMetrics.b().b(StorageMetrics.c().b(R0()).c(EventStoreConfig.f12299a.f()).a()).a();
    }

    private long W0() {
        return S0().compileStatement("PRAGMA page_count").simpleQueryForLong();
    }

    private long Z0() {
        return S0().compileStatement("PRAGMA page_size").simpleQueryForLong();
    }

    private TimeWindow b1() {
        final long a8 = this.f12306g.a();
        return (TimeWindow) f1(new Function() { // from class: com.google.android.datatransport.runtime.scheduling.persistence.r
            @Override // com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore.Function
            public final Object apply(Object obj) {
                TimeWindow t12;
                t12 = SQLiteEventStore.t1(a8, (SQLiteDatabase) obj);
                return t12;
            }
        });
    }

    private Long c1(SQLiteDatabase sQLiteDatabase, TransportContext transportContext) {
        StringBuilder sb = new StringBuilder("backend_name = ? and priority = ?");
        ArrayList arrayList = new ArrayList(Arrays.asList(transportContext.b(), String.valueOf(PriorityMapping.a(transportContext.d()))));
        if (transportContext.c() != null) {
            sb.append(" and extras = ?");
            arrayList.add(Base64.encodeToString(transportContext.c(), 0));
        } else {
            sb.append(" and extras is null");
        }
        return (Long) T1(sQLiteDatabase.query("transport_contexts", new String[]{"_id"}, sb.toString(), (String[]) arrayList.toArray(new String[0]), null, null, null), new Function() { // from class: com.google.android.datatransport.runtime.scheduling.persistence.h
            @Override // com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore.Function
            public final Object apply(Object obj) {
                Long u12;
                u12 = SQLiteEventStore.u1((Cursor) obj);
                return u12;
            }
        });
    }

    private boolean h1() {
        if (W0() * Z0() >= this.f12308i.f()) {
            return true;
        }
        return false;
    }

    private List<PersistedEvent> l1(List<PersistedEvent> list, Map<Long, Set<Metadata>> map) {
        ListIterator<PersistedEvent> listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            PersistedEvent next = listIterator.next();
            if (map.containsKey(Long.valueOf(next.c()))) {
                EventInternal.Builder l8 = next.b().l();
                for (Metadata metadata : map.get(Long.valueOf(next.c()))) {
                    l8.c(metadata.f12310a, metadata.f12311b);
                }
                listIterator.set(PersistedEvent.a(next.c(), next.d(), l8.d()));
            }
        }
        return list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object m1(Cursor cursor) {
        while (cursor.moveToNext()) {
            int i8 = cursor.getInt(0);
            g(i8, LogEventDropped.Reason.MESSAGE_TOO_OLD, cursor.getString(1));
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Integer n1(long j8, SQLiteDatabase sQLiteDatabase) {
        String[] strArr = {String.valueOf(j8)};
        T1(sQLiteDatabase.rawQuery("SELECT COUNT(*), transport_name FROM events WHERE timestamp_ms < ? GROUP BY transport_name", strArr), new Function() { // from class: com.google.android.datatransport.runtime.scheduling.persistence.g
            @Override // com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore.Function
            public final Object apply(Object obj) {
                Object m12;
                m12 = SQLiteEventStore.this.m1((Cursor) obj);
                return m12;
            }
        });
        return Integer.valueOf(sQLiteDatabase.delete("events", "timestamp_ms < ?", strArr));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object o1(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.beginTransaction();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object p1(Throwable th) {
        throw new SynchronizationException("Timed out while trying to acquire the lock.", th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ SQLiteDatabase q1(Throwable th) {
        throw new SynchronizationException("Timed out while trying to open db.", th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Long r1(Cursor cursor) {
        if (cursor.moveToNext()) {
            return Long.valueOf(cursor.getLong(0));
        }
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ TimeWindow s1(long j8, Cursor cursor) {
        cursor.moveToNext();
        return TimeWindow.c().c(cursor.getLong(0)).b(j8).a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ TimeWindow t1(final long j8, SQLiteDatabase sQLiteDatabase) {
        return (TimeWindow) T1(sQLiteDatabase.rawQuery("SELECT last_metrics_upload_ms FROM global_log_event_state LIMIT 1", new String[0]), new Function() { // from class: com.google.android.datatransport.runtime.scheduling.persistence.s
            @Override // com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore.Function
            public final Object apply(Object obj) {
                TimeWindow s12;
                s12 = SQLiteEventStore.s1(j8, (Cursor) obj);
                return s12;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Long u1(Cursor cursor) {
        if (!cursor.moveToNext()) {
            return null;
        }
        return Long.valueOf(cursor.getLong(0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Boolean v1(TransportContext transportContext, SQLiteDatabase sQLiteDatabase) {
        Long c12 = c1(sQLiteDatabase, transportContext);
        if (c12 == null) {
            return Boolean.FALSE;
        }
        return (Boolean) T1(S0().rawQuery("SELECT 1 FROM events WHERE context_id = ? LIMIT 1", new String[]{c12.toString()}), new Function() { // from class: com.google.android.datatransport.runtime.scheduling.persistence.o
            @Override // com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore.Function
            public final Object apply(Object obj) {
                return Boolean.valueOf(((Cursor) obj).moveToNext());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ List w1(SQLiteDatabase sQLiteDatabase) {
        return (List) T1(sQLiteDatabase.rawQuery("SELECT distinct t._id, t.backend_name, t.priority, t.extras FROM transport_contexts AS t, events AS e WHERE e.context_id = t._id", new String[0]), new Function() { // from class: com.google.android.datatransport.runtime.scheduling.persistence.z
            @Override // com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore.Function
            public final Object apply(Object obj) {
                List x12;
                x12 = SQLiteEventStore.x1((Cursor) obj);
                return x12;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ List x1(Cursor cursor) {
        ArrayList arrayList = new ArrayList();
        while (cursor.moveToNext()) {
            arrayList.add(TransportContext.a().b(cursor.getString(1)).d(PriorityMapping.b(cursor.getInt(2))).c(N1(cursor.getString(3))).a());
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ List y1(TransportContext transportContext, SQLiteDatabase sQLiteDatabase) {
        List<PersistedEvent> L1 = L1(sQLiteDatabase, transportContext);
        return l1(L1, M1(sQLiteDatabase, L1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ ClientMetrics z1(Map map, ClientMetrics.Builder builder, Cursor cursor) {
        while (cursor.moveToNext()) {
            String string = cursor.getString(0);
            LogEventDropped.Reason I0 = I0(cursor.getInt(1));
            long j8 = cursor.getLong(2);
            if (!map.containsKey(string)) {
                map.put(string, new ArrayList());
            }
            ((List) map.get(string)).add(LogEventDropped.c().c(I0).b(j8).a());
        }
        O1(builder, map);
        builder.e(b1());
        builder.d(U0());
        builder.c(this.f12309j.get());
        return builder.b();
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.EventStore
    public void A(final TransportContext transportContext, final long j8) {
        f1(new Function() { // from class: com.google.android.datatransport.runtime.scheduling.persistence.c
            @Override // com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore.Function
            public final Object apply(Object obj) {
                Object J1;
                J1 = SQLiteEventStore.J1(j8, transportContext, (SQLiteDatabase) obj);
                return J1;
            }
        });
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.EventStore
    public Iterable<TransportContext> D() {
        return (Iterable) f1(new Function() { // from class: com.google.android.datatransport.runtime.scheduling.persistence.a
            @Override // com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore.Function
            public final Object apply(Object obj) {
                List w12;
                w12 = SQLiteEventStore.w1((SQLiteDatabase) obj);
                return w12;
            }
        });
    }

    long R0() {
        return W0() * Z0();
    }

    SQLiteDatabase S0() {
        final SchemaManager schemaManager = this.f12305f;
        Objects.requireNonNull(schemaManager);
        return (SQLiteDatabase) Q1(new Producer() { // from class: com.google.android.datatransport.runtime.scheduling.persistence.l
            @Override // com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore.Producer
            public final Object a() {
                return SchemaManager.this.getWritableDatabase();
            }
        }, new Function() { // from class: com.google.android.datatransport.runtime.scheduling.persistence.t
            @Override // com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore.Function
            public final Object apply(Object obj) {
                SQLiteDatabase q12;
                q12 = SQLiteEventStore.q1((Throwable) obj);
                return q12;
            }
        });
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.EventStore
    public PersistedEvent X0(final TransportContext transportContext, final EventInternal eventInternal) {
        Logging.c("SQLiteEventStore", "Storing event with priority=%s, name=%s for destination %s", transportContext.d(), eventInternal.j(), transportContext.b());
        long longValue = ((Long) f1(new Function() { // from class: com.google.android.datatransport.runtime.scheduling.persistence.x
            @Override // com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore.Function
            public final Object apply(Object obj) {
                Long D1;
                D1 = SQLiteEventStore.this.D1(eventInternal, transportContext, (SQLiteDatabase) obj);
                return D1;
            }
        })).longValue();
        if (longValue < 1) {
            return null;
        }
        return PersistedEvent.a(longValue, transportContext, eventInternal);
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.ClientHealthMetricsStore
    public void a() {
        f1(new Function() { // from class: com.google.android.datatransport.runtime.scheduling.persistence.d
            @Override // com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore.Function
            public final Object apply(Object obj) {
                Object K1;
                K1 = SQLiteEventStore.this.K1((SQLiteDatabase) obj);
                return K1;
            }
        });
    }

    @Override // com.google.android.datatransport.runtime.synchronization.SynchronizationGuard
    public <T> T c(SynchronizationGuard.CriticalSection<T> criticalSection) {
        SQLiteDatabase S0 = S0();
        K0(S0);
        try {
            T execute = criticalSection.execute();
            S0.setTransactionSuccessful();
            return execute;
        } finally {
            S0.endTransaction();
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f12305f.close();
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.ClientHealthMetricsStore
    public ClientMetrics e() {
        final ClientMetrics.Builder e8 = ClientMetrics.e();
        final HashMap hashMap = new HashMap();
        return (ClientMetrics) f1(new Function() { // from class: com.google.android.datatransport.runtime.scheduling.persistence.j
            @Override // com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore.Function
            public final Object apply(Object obj) {
                ClientMetrics A1;
                A1 = SQLiteEventStore.this.A1(r2, hashMap, e8, (SQLiteDatabase) obj);
                return A1;
            }
        });
    }

    <T> T f1(Function<SQLiteDatabase, T> function) {
        SQLiteDatabase S0 = S0();
        S0.beginTransaction();
        try {
            T apply = function.apply(S0);
            S0.setTransactionSuccessful();
            return apply;
        } finally {
            S0.endTransaction();
        }
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.ClientHealthMetricsStore
    public void g(final long j8, final LogEventDropped.Reason reason, final String str) {
        f1(new Function() { // from class: com.google.android.datatransport.runtime.scheduling.persistence.b
            @Override // com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore.Function
            public final Object apply(Object obj) {
                Object I1;
                I1 = SQLiteEventStore.I1(str, reason, j8, (SQLiteDatabase) obj);
                return I1;
            }
        });
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.EventStore
    public long g0(TransportContext transportContext) {
        return ((Long) T1(S0().rawQuery("SELECT next_request_ms FROM transport_contexts WHERE backend_name = ? and priority = ?", new String[]{transportContext.b(), String.valueOf(PriorityMapping.a(transportContext.d()))}), new Function() { // from class: com.google.android.datatransport.runtime.scheduling.persistence.u
            @Override // com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore.Function
            public final Object apply(Object obj) {
                Long r12;
                r12 = SQLiteEventStore.r1((Cursor) obj);
                return r12;
            }
        })).longValue();
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.EventStore
    public boolean h0(final TransportContext transportContext) {
        return ((Boolean) f1(new Function() { // from class: com.google.android.datatransport.runtime.scheduling.persistence.a0
            @Override // com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore.Function
            public final Object apply(Object obj) {
                Boolean v12;
                v12 = SQLiteEventStore.this.v1(transportContext, (SQLiteDatabase) obj);
                return v12;
            }
        })).booleanValue();
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.EventStore
    public void i0(Iterable<PersistedEvent> iterable) {
        if (!iterable.iterator().hasNext()) {
            return;
        }
        final String str = "UPDATE events SET num_attempts = num_attempts + 1 WHERE _id in " + S1(iterable);
        f1(new Function() { // from class: com.google.android.datatransport.runtime.scheduling.persistence.f
            @Override // com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore.Function
            public final Object apply(Object obj) {
                Object G1;
                G1 = SQLiteEventStore.this.G1(str, r3, (SQLiteDatabase) obj);
                return G1;
            }
        });
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.EventStore
    public int o() {
        final long a8 = this.f12306g.a() - this.f12308i.c();
        return ((Integer) f1(new Function() { // from class: com.google.android.datatransport.runtime.scheduling.persistence.y
            @Override // com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore.Function
            public final Object apply(Object obj) {
                Integer n12;
                n12 = SQLiteEventStore.this.n1(a8, (SQLiteDatabase) obj);
                return n12;
            }
        })).intValue();
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.EventStore
    public void p(Iterable<PersistedEvent> iterable) {
        if (!iterable.iterator().hasNext()) {
            return;
        }
        S0().compileStatement("DELETE FROM events WHERE _id in " + S1(iterable)).execute();
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.EventStore
    public Iterable<PersistedEvent> t0(final TransportContext transportContext) {
        return (Iterable) f1(new Function() { // from class: com.google.android.datatransport.runtime.scheduling.persistence.e
            @Override // com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore.Function
            public final Object apply(Object obj) {
                List y12;
                y12 = SQLiteEventStore.this.y1(transportContext, (SQLiteDatabase) obj);
                return y12;
            }
        });
    }
}
