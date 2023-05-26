package androidx.room.util;

import android.database.Cursor;
import android.database.MatrixCursor;
import android.os.Build;
import android.util.Log;
import androidx.annotation.NonNull;
import java.util.Arrays;

/* loaded from: classes.dex */
public class CursorUtil {
    private CursorUtil() {
    }

    @NonNull
    public static Cursor a(@NonNull Cursor cursor) {
        try {
            MatrixCursor matrixCursor = new MatrixCursor(cursor.getColumnNames(), cursor.getCount());
            while (cursor.moveToNext()) {
                Object[] objArr = new Object[cursor.getColumnCount()];
                for (int i8 = 0; i8 < cursor.getColumnCount(); i8++) {
                    int type = cursor.getType(i8);
                    if (type != 0) {
                        if (type != 1) {
                            if (type != 2) {
                                if (type != 3) {
                                    if (type == 4) {
                                        objArr[i8] = cursor.getBlob(i8);
                                    } else {
                                        throw new IllegalStateException();
                                    }
                                } else {
                                    objArr[i8] = cursor.getString(i8);
                                }
                            } else {
                                objArr[i8] = Double.valueOf(cursor.getDouble(i8));
                            }
                        } else {
                            objArr[i8] = Long.valueOf(cursor.getLong(i8));
                        }
                    } else {
                        objArr[i8] = null;
                    }
                }
                matrixCursor.addRow(objArr);
            }
            return matrixCursor;
        } finally {
            cursor.close();
        }
    }

    private static int b(@NonNull Cursor cursor, @NonNull String str) {
        if (Build.VERSION.SDK_INT > 25 || str.length() == 0) {
            return -1;
        }
        return c(cursor.getColumnNames(), str);
    }

    static int c(String[] strArr, String str) {
        String str2 = "." + str;
        String str3 = "." + str + "`";
        for (int i8 = 0; i8 < strArr.length; i8++) {
            String str4 = strArr[i8];
            if (str4.length() >= str.length() + 2) {
                if (str4.endsWith(str2)) {
                    return i8;
                }
                if (str4.charAt(0) == '`' && str4.endsWith(str3)) {
                    return i8;
                }
            }
        }
        return -1;
    }

    public static int d(@NonNull Cursor cursor, @NonNull String str) {
        int columnIndex = cursor.getColumnIndex(str);
        if (columnIndex >= 0) {
            return columnIndex;
        }
        int columnIndex2 = cursor.getColumnIndex("`" + str + "`");
        if (columnIndex2 >= 0) {
            return columnIndex2;
        }
        return b(cursor, str);
    }

    public static int e(@NonNull Cursor cursor, @NonNull String str) {
        String str2;
        int d8 = d(cursor, str);
        if (d8 >= 0) {
            return d8;
        }
        try {
            str2 = Arrays.toString(cursor.getColumnNames());
        } catch (Exception e8) {
            Log.d("RoomCursorUtil", "Cannot collect column names for debug purposes", e8);
            str2 = "";
        }
        throw new IllegalArgumentException("column '" + str + "' does not exist. Available columns: " + str2);
    }
}
