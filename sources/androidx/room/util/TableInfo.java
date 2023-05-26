package androidx.room.util;

import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.room.Index$Order;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import org.simpleframework.xml.strategy.Name;

/* loaded from: classes.dex */
public final class TableInfo {

    /* renamed from: a  reason: collision with root package name */
    public final String f7668a;

    /* renamed from: b  reason: collision with root package name */
    public final Map<String, Column> f7669b;

    /* renamed from: c  reason: collision with root package name */
    public final Set<ForeignKey> f7670c;

    /* renamed from: d  reason: collision with root package name */
    public final Set<Index> f7671d;

    /* loaded from: classes.dex */
    public static final class Column {

        /* renamed from: a  reason: collision with root package name */
        public final String f7672a;

        /* renamed from: b  reason: collision with root package name */
        public final String f7673b;

        /* renamed from: c  reason: collision with root package name */
        public final int f7674c;

        /* renamed from: d  reason: collision with root package name */
        public final boolean f7675d;

        /* renamed from: e  reason: collision with root package name */
        public final int f7676e;

        /* renamed from: f  reason: collision with root package name */
        public final String f7677f;

        /* renamed from: g  reason: collision with root package name */
        private final int f7678g;

        public Column(String str, String str2, boolean z7, int i8, String str3, int i9) {
            this.f7672a = str;
            this.f7673b = str2;
            this.f7675d = z7;
            this.f7676e = i8;
            this.f7674c = c(str2);
            this.f7677f = str3;
            this.f7678g = i9;
        }

        private static boolean a(@NonNull String str) {
            if (str.length() == 0) {
                return false;
            }
            int i8 = 0;
            for (int i9 = 0; i9 < str.length(); i9++) {
                char charAt = str.charAt(i9);
                if (i9 == 0 && charAt != '(') {
                    return false;
                }
                if (charAt == '(') {
                    i8++;
                } else if (charAt == ')' && i8 - 1 == 0 && i9 != str.length() - 1) {
                    return false;
                }
            }
            if (i8 != 0) {
                return false;
            }
            return true;
        }

        public static boolean b(@NonNull String str, String str2) {
            if (str2 == null) {
                return false;
            }
            if (str.equals(str2)) {
                return true;
            }
            if (!a(str)) {
                return false;
            }
            return str.substring(1, str.length() - 1).trim().equals(str2);
        }

        private static int c(String str) {
            if (str == null) {
                return 5;
            }
            String upperCase = str.toUpperCase(Locale.US);
            if (upperCase.contains("INT")) {
                return 3;
            }
            if (!upperCase.contains("CHAR") && !upperCase.contains("CLOB") && !upperCase.contains("TEXT")) {
                if (upperCase.contains("BLOB")) {
                    return 5;
                }
                if (!upperCase.contains("REAL") && !upperCase.contains("FLOA") && !upperCase.contains("DOUB")) {
                    return 1;
                }
                return 4;
            }
            return 2;
        }

        public boolean equals(Object obj) {
            String str;
            String str2;
            String str3;
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Column)) {
                return false;
            }
            Column column = (Column) obj;
            if (this.f7676e != column.f7676e || !this.f7672a.equals(column.f7672a) || this.f7675d != column.f7675d) {
                return false;
            }
            if (this.f7678g == 1 && column.f7678g == 2 && (str3 = this.f7677f) != null && !b(str3, column.f7677f)) {
                return false;
            }
            if (this.f7678g == 2 && column.f7678g == 1 && (str2 = column.f7677f) != null && !b(str2, this.f7677f)) {
                return false;
            }
            int i8 = this.f7678g;
            if ((i8 == 0 || i8 != column.f7678g || ((str = this.f7677f) == null ? column.f7677f == null : b(str, column.f7677f))) && this.f7674c == column.f7674c) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int i8;
            int hashCode = ((this.f7672a.hashCode() * 31) + this.f7674c) * 31;
            if (this.f7675d) {
                i8 = 1231;
            } else {
                i8 = 1237;
            }
            return ((hashCode + i8) * 31) + this.f7676e;
        }

        public String toString() {
            return "Column{name='" + this.f7672a + "', type='" + this.f7673b + "', affinity='" + this.f7674c + "', notNull=" + this.f7675d + ", primaryKeyPosition=" + this.f7676e + ", defaultValue='" + this.f7677f + "'}";
        }
    }

    /* loaded from: classes.dex */
    public static final class ForeignKey {
        @NonNull

        /* renamed from: a  reason: collision with root package name */
        public final String f7679a;
        @NonNull

        /* renamed from: b  reason: collision with root package name */
        public final String f7680b;
        @NonNull

        /* renamed from: c  reason: collision with root package name */
        public final String f7681c;
        @NonNull

        /* renamed from: d  reason: collision with root package name */
        public final List<String> f7682d;
        @NonNull

        /* renamed from: e  reason: collision with root package name */
        public final List<String> f7683e;

        public ForeignKey(@NonNull String str, @NonNull String str2, @NonNull String str3, @NonNull List<String> list, @NonNull List<String> list2) {
            this.f7679a = str;
            this.f7680b = str2;
            this.f7681c = str3;
            this.f7682d = Collections.unmodifiableList(list);
            this.f7683e = Collections.unmodifiableList(list2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ForeignKey)) {
                return false;
            }
            ForeignKey foreignKey = (ForeignKey) obj;
            if (!this.f7679a.equals(foreignKey.f7679a) || !this.f7680b.equals(foreignKey.f7680b) || !this.f7681c.equals(foreignKey.f7681c) || !this.f7682d.equals(foreignKey.f7682d)) {
                return false;
            }
            return this.f7683e.equals(foreignKey.f7683e);
        }

        public int hashCode() {
            return (((((((this.f7679a.hashCode() * 31) + this.f7680b.hashCode()) * 31) + this.f7681c.hashCode()) * 31) + this.f7682d.hashCode()) * 31) + this.f7683e.hashCode();
        }

        public String toString() {
            return "ForeignKey{referenceTable='" + this.f7679a + "', onDelete='" + this.f7680b + "', onUpdate='" + this.f7681c + "', columnNames=" + this.f7682d + ", referenceColumnNames=" + this.f7683e + '}';
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class ForeignKeyWithSequence implements Comparable<ForeignKeyWithSequence> {

        /* renamed from: f  reason: collision with root package name */
        final int f7684f;

        /* renamed from: g  reason: collision with root package name */
        final int f7685g;

        /* renamed from: h  reason: collision with root package name */
        final String f7686h;

        /* renamed from: i  reason: collision with root package name */
        final String f7687i;

        ForeignKeyWithSequence(int i8, int i9, String str, String str2) {
            this.f7684f = i8;
            this.f7685g = i9;
            this.f7686h = str;
            this.f7687i = str2;
        }

        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(@NonNull ForeignKeyWithSequence foreignKeyWithSequence) {
            int i8 = this.f7684f - foreignKeyWithSequence.f7684f;
            if (i8 == 0) {
                return this.f7685g - foreignKeyWithSequence.f7685g;
            }
            return i8;
        }
    }

    /* loaded from: classes.dex */
    public static final class Index {

        /* renamed from: a  reason: collision with root package name */
        public final String f7688a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f7689b;

        /* renamed from: c  reason: collision with root package name */
        public final List<String> f7690c;

        /* renamed from: d  reason: collision with root package name */
        public final List<String> f7691d;

        public Index(String str, boolean z7, List<String> list) {
            this(str, z7, list, null);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Index)) {
                return false;
            }
            Index index = (Index) obj;
            if (this.f7689b != index.f7689b || !this.f7690c.equals(index.f7690c) || !this.f7691d.equals(index.f7691d)) {
                return false;
            }
            if (this.f7688a.startsWith("index_")) {
                return index.f7688a.startsWith("index_");
            }
            return this.f7688a.equals(index.f7688a);
        }

        public int hashCode() {
            int hashCode;
            if (this.f7688a.startsWith("index_")) {
                hashCode = -1184239155;
            } else {
                hashCode = this.f7688a.hashCode();
            }
            return (((((hashCode * 31) + (this.f7689b ? 1 : 0)) * 31) + this.f7690c.hashCode()) * 31) + this.f7691d.hashCode();
        }

        public String toString() {
            return "Index{name='" + this.f7688a + "', unique=" + this.f7689b + ", columns=" + this.f7690c + ", orders=" + this.f7691d + '}';
        }

        public Index(String str, boolean z7, List<String> list, List<String> list2) {
            this.f7688a = str;
            this.f7689b = z7;
            this.f7690c = list;
            this.f7691d = (list2 == null || list2.size() == 0) ? Collections.nCopies(list.size(), Index$Order.ASC.name()) : list2;
        }
    }

    public TableInfo(String str, Map<String, Column> map, Set<ForeignKey> set, Set<Index> set2) {
        Set<Index> unmodifiableSet;
        this.f7668a = str;
        this.f7669b = Collections.unmodifiableMap(map);
        this.f7670c = Collections.unmodifiableSet(set);
        if (set2 == null) {
            unmodifiableSet = null;
        } else {
            unmodifiableSet = Collections.unmodifiableSet(set2);
        }
        this.f7671d = unmodifiableSet;
    }

    public static TableInfo a(SupportSQLiteDatabase supportSQLiteDatabase, String str) {
        return new TableInfo(str, b(supportSQLiteDatabase, str), d(supportSQLiteDatabase, str), f(supportSQLiteDatabase, str));
    }

    private static Map<String, Column> b(SupportSQLiteDatabase supportSQLiteDatabase, String str) {
        boolean z7;
        Cursor J0 = supportSQLiteDatabase.J0("PRAGMA table_info(`" + str + "`)");
        HashMap hashMap = new HashMap();
        try {
            if (J0.getColumnCount() > 0) {
                int columnIndex = J0.getColumnIndex("name");
                int columnIndex2 = J0.getColumnIndex("type");
                int columnIndex3 = J0.getColumnIndex("notnull");
                int columnIndex4 = J0.getColumnIndex("pk");
                int columnIndex5 = J0.getColumnIndex("dflt_value");
                while (J0.moveToNext()) {
                    String string = J0.getString(columnIndex);
                    String string2 = J0.getString(columnIndex2);
                    if (J0.getInt(columnIndex3) != 0) {
                        z7 = true;
                    } else {
                        z7 = false;
                    }
                    hashMap.put(string, new Column(string, string2, z7, J0.getInt(columnIndex4), J0.getString(columnIndex5), 2));
                }
            }
            return hashMap;
        } finally {
            J0.close();
        }
    }

    private static List<ForeignKeyWithSequence> c(Cursor cursor) {
        int columnIndex = cursor.getColumnIndex(Name.MARK);
        int columnIndex2 = cursor.getColumnIndex("seq");
        int columnIndex3 = cursor.getColumnIndex("from");
        int columnIndex4 = cursor.getColumnIndex("to");
        int count = cursor.getCount();
        ArrayList arrayList = new ArrayList();
        for (int i8 = 0; i8 < count; i8++) {
            cursor.moveToPosition(i8);
            arrayList.add(new ForeignKeyWithSequence(cursor.getInt(columnIndex), cursor.getInt(columnIndex2), cursor.getString(columnIndex3), cursor.getString(columnIndex4)));
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    private static Set<ForeignKey> d(SupportSQLiteDatabase supportSQLiteDatabase, String str) {
        HashSet hashSet = new HashSet();
        Cursor J0 = supportSQLiteDatabase.J0("PRAGMA foreign_key_list(`" + str + "`)");
        try {
            int columnIndex = J0.getColumnIndex(Name.MARK);
            int columnIndex2 = J0.getColumnIndex("seq");
            int columnIndex3 = J0.getColumnIndex("table");
            int columnIndex4 = J0.getColumnIndex("on_delete");
            int columnIndex5 = J0.getColumnIndex("on_update");
            List<ForeignKeyWithSequence> c8 = c(J0);
            int count = J0.getCount();
            for (int i8 = 0; i8 < count; i8++) {
                J0.moveToPosition(i8);
                if (J0.getInt(columnIndex2) == 0) {
                    int i9 = J0.getInt(columnIndex);
                    ArrayList arrayList = new ArrayList();
                    ArrayList arrayList2 = new ArrayList();
                    for (ForeignKeyWithSequence foreignKeyWithSequence : c8) {
                        if (foreignKeyWithSequence.f7684f == i9) {
                            arrayList.add(foreignKeyWithSequence.f7686h);
                            arrayList2.add(foreignKeyWithSequence.f7687i);
                        }
                    }
                    hashSet.add(new ForeignKey(J0.getString(columnIndex3), J0.getString(columnIndex4), J0.getString(columnIndex5), arrayList, arrayList2));
                }
            }
            return hashSet;
        } finally {
            J0.close();
        }
    }

    private static Index e(SupportSQLiteDatabase supportSQLiteDatabase, String str, boolean z7) {
        String str2;
        Cursor J0 = supportSQLiteDatabase.J0("PRAGMA index_xinfo(`" + str + "`)");
        try {
            int columnIndex = J0.getColumnIndex("seqno");
            int columnIndex2 = J0.getColumnIndex("cid");
            int columnIndex3 = J0.getColumnIndex("name");
            int columnIndex4 = J0.getColumnIndex("desc");
            if (columnIndex != -1 && columnIndex2 != -1 && columnIndex3 != -1 && columnIndex4 != -1) {
                TreeMap treeMap = new TreeMap();
                TreeMap treeMap2 = new TreeMap();
                while (J0.moveToNext()) {
                    if (J0.getInt(columnIndex2) >= 0) {
                        int i8 = J0.getInt(columnIndex);
                        String string = J0.getString(columnIndex3);
                        if (J0.getInt(columnIndex4) > 0) {
                            str2 = "DESC";
                        } else {
                            str2 = "ASC";
                        }
                        treeMap.put(Integer.valueOf(i8), string);
                        treeMap2.put(Integer.valueOf(i8), str2);
                    }
                }
                ArrayList arrayList = new ArrayList(treeMap.size());
                arrayList.addAll(treeMap.values());
                ArrayList arrayList2 = new ArrayList(treeMap2.size());
                arrayList2.addAll(treeMap2.values());
                return new Index(str, z7, arrayList, arrayList2);
            }
            return null;
        } finally {
            J0.close();
        }
    }

    private static Set<Index> f(SupportSQLiteDatabase supportSQLiteDatabase, String str) {
        Cursor J0 = supportSQLiteDatabase.J0("PRAGMA index_list(`" + str + "`)");
        try {
            int columnIndex = J0.getColumnIndex("name");
            int columnIndex2 = J0.getColumnIndex(AppMeasurementSdk.ConditionalUserProperty.ORIGIN);
            int columnIndex3 = J0.getColumnIndex("unique");
            if (columnIndex != -1 && columnIndex2 != -1 && columnIndex3 != -1) {
                HashSet hashSet = new HashSet();
                while (J0.moveToNext()) {
                    if ("c".equals(J0.getString(columnIndex2))) {
                        String string = J0.getString(columnIndex);
                        boolean z7 = true;
                        if (J0.getInt(columnIndex3) != 1) {
                            z7 = false;
                        }
                        Index e8 = e(supportSQLiteDatabase, string, z7);
                        if (e8 == null) {
                            return null;
                        }
                        hashSet.add(e8);
                    }
                }
                return hashSet;
            }
            return null;
        } finally {
            J0.close();
        }
    }

    public boolean equals(Object obj) {
        Set<Index> set;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TableInfo)) {
            return false;
        }
        TableInfo tableInfo = (TableInfo) obj;
        String str = this.f7668a;
        if (str == null ? tableInfo.f7668a != null : !str.equals(tableInfo.f7668a)) {
            return false;
        }
        Map<String, Column> map = this.f7669b;
        if (map == null ? tableInfo.f7669b != null : !map.equals(tableInfo.f7669b)) {
            return false;
        }
        Set<ForeignKey> set2 = this.f7670c;
        if (set2 == null ? tableInfo.f7670c != null : !set2.equals(tableInfo.f7670c)) {
            return false;
        }
        Set<Index> set3 = this.f7671d;
        if (set3 == null || (set = tableInfo.f7671d) == null) {
            return true;
        }
        return set3.equals(set);
    }

    public int hashCode() {
        int i8;
        int i9;
        String str = this.f7668a;
        int i10 = 0;
        if (str != null) {
            i8 = str.hashCode();
        } else {
            i8 = 0;
        }
        int i11 = i8 * 31;
        Map<String, Column> map = this.f7669b;
        if (map != null) {
            i9 = map.hashCode();
        } else {
            i9 = 0;
        }
        int i12 = (i11 + i9) * 31;
        Set<ForeignKey> set = this.f7670c;
        if (set != null) {
            i10 = set.hashCode();
        }
        return i12 + i10;
    }

    public String toString() {
        return "TableInfo{name='" + this.f7668a + "', columns=" + this.f7669b + ", foreignKeys=" + this.f7670c + ", indices=" + this.f7671d + '}';
    }
}
