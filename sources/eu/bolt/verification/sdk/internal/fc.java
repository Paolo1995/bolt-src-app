package eu.bolt.verification.sdk.internal;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import eu.bolt.logger.Logger;
import eu.bolt.verification.sdk.internal.ac;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class fc {

    /* renamed from: a  reason: collision with root package name */
    public static final a f42978a = new a(null);

    /* renamed from: b  reason: collision with root package name */
    private static final Logger f42979b = ac.a.f42020b.g();

    /* loaded from: classes5.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final void b(String str, Map<String, ?> map, SharedPreferences.Editor editor) {
            Object obj = map.get(str);
            if (obj instanceof Boolean) {
                editor.putBoolean(str, ((Boolean) obj).booleanValue());
            } else if (obj instanceof Integer) {
                editor.putInt(str, ((Number) obj).intValue());
            } else if (obj instanceof Long) {
                editor.putLong(str, ((Number) obj).longValue());
            } else if (obj instanceof Float) {
                editor.putFloat(str, ((Number) obj).floatValue());
            } else if (obj instanceof String) {
                editor.putString(str, (String) obj);
            } else if (obj instanceof Set) {
                editor.putStringSet(str, (Set) obj);
            } else {
                throw new IllegalArgumentException("Unsupported type for key: " + str);
            }
        }

        @SuppressLint({"ApplySharedPref"})
        public final void a(SharedPreferences from, SharedPreferences to) {
            Intrinsics.f(from, "from");
            Intrinsics.f(to, "to");
            Map<String, ?> keyValues = from.getAll();
            if (keyValues.isEmpty()) {
                fc.f42979b.b("No keys to migrate");
                return;
            }
            SharedPreferences.Editor edit = to.edit();
            Intrinsics.e(edit, "to.edit()");
            for (String key : keyValues.keySet()) {
                Logger logger = fc.f42979b;
                logger.b("Trying to migrate key: " + key);
                if (!to.contains(key)) {
                    Logger logger2 = fc.f42979b;
                    logger2.b("Migrating non-existent key: " + key);
                    Intrinsics.e(key, "key");
                    Intrinsics.e(keyValues, "keyValues");
                    b(key, keyValues, edit);
                }
            }
            if (!edit.commit()) {
                fc.f42979b.d("Migration failed");
                return;
            }
            fc.f42979b.b("Migration successful");
            from.edit().clear().commit();
        }
    }
}
