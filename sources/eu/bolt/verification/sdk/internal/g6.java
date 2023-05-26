package eu.bolt.verification.sdk.internal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Base64;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.collection.ArraySet;
import eu.bolt.logger.Logger;
import eu.bolt.verification.sdk.internal.ac;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes5.dex */
public final class g6 implements SharedPreferences {

    /* renamed from: e  reason: collision with root package name */
    private static final Logger f43105e = ac.a.f42020b.g();

    /* renamed from: a  reason: collision with root package name */
    final SharedPreferences f43106a;

    /* renamed from: b  reason: collision with root package name */
    final CopyOnWriteArrayList<SharedPreferences.OnSharedPreferenceChangeListener> f43107b = new CopyOnWriteArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    private final o f43108c;

    /* renamed from: d  reason: collision with root package name */
    private final or f43109d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f43110a;

        static {
            int[] iArr = new int[c.values().length];
            f43110a = iArr;
            try {
                iArr[c.STRING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f43110a[c.INT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f43110a[c.LONG.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f43110a[c.FLOAT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f43110a[c.BOOLEAN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f43110a[c.STRING_SET.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* loaded from: classes5.dex */
    private static final class b implements SharedPreferences.Editor {

        /* renamed from: a  reason: collision with root package name */
        private final g6 f43111a;

        /* renamed from: b  reason: collision with root package name */
        private final SharedPreferences.Editor f43112b;

        /* renamed from: d  reason: collision with root package name */
        private AtomicBoolean f43114d = new AtomicBoolean(false);

        /* renamed from: c  reason: collision with root package name */
        private final List<String> f43113c = new CopyOnWriteArrayList();

        b(g6 g6Var, SharedPreferences.Editor editor) {
            this.f43111a = g6Var;
            this.f43112b = editor;
        }

        private void a(String str, byte[] bArr) {
            if (this.f43111a.i(str)) {
                throw new SecurityException(str + " is a reserved key for the encryption keyset.");
            }
            this.f43113c.add(str);
            if (str == null) {
                str = "__NULL__";
            }
            try {
                Pair<String, String> c8 = this.f43111a.c(str, bArr);
                this.f43112b.putString((String) c8.first, (String) c8.second);
            } catch (Exception e8) {
                Logger logger = g6.f43105e;
                logger.c(new SecurityException("Could not encrypt data: " + e8.getMessage(), e8));
            }
        }

        private void b(boolean z7) {
            if (z7) {
                Iterator<SharedPreferences.OnSharedPreferenceChangeListener> it = this.f43111a.f43107b.iterator();
                while (it.hasNext()) {
                    it.next().onSharedPreferenceChanged(this.f43111a, null);
                }
            }
            Iterator<SharedPreferences.OnSharedPreferenceChangeListener> it2 = this.f43111a.f43107b.iterator();
            while (it2.hasNext()) {
                SharedPreferences.OnSharedPreferenceChangeListener next = it2.next();
                for (String str : this.f43113c) {
                    next.onSharedPreferenceChanged(this.f43111a, str);
                }
            }
        }

        private boolean c() {
            if (this.f43114d.getAndSet(false)) {
                for (String str : this.f43111a.getAll().keySet()) {
                    if (!this.f43113c.contains(str) && !this.f43111a.i(str)) {
                        this.f43112b.remove(this.f43111a.g(str));
                    }
                }
                return true;
            }
            return false;
        }

        @Override // android.content.SharedPreferences.Editor
        public void apply() {
            boolean c8 = c();
            this.f43112b.apply();
            b(c8);
            this.f43113c.clear();
        }

        @Override // android.content.SharedPreferences.Editor
        @NonNull
        public SharedPreferences.Editor clear() {
            this.f43114d.set(true);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public boolean commit() {
            boolean c8 = c();
            try {
                return this.f43112b.commit();
            } finally {
                b(c8);
                this.f43113c.clear();
            }
        }

        @Override // android.content.SharedPreferences.Editor
        @NonNull
        public SharedPreferences.Editor putBoolean(String str, boolean z7) {
            ByteBuffer allocate = ByteBuffer.allocate(5);
            allocate.putInt(c.BOOLEAN.a());
            allocate.put(z7 ? (byte) 1 : (byte) 0);
            a(str, allocate.array());
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        @NonNull
        public SharedPreferences.Editor putFloat(String str, float f8) {
            ByteBuffer allocate = ByteBuffer.allocate(8);
            allocate.putInt(c.FLOAT.a());
            allocate.putFloat(f8);
            a(str, allocate.array());
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        @NonNull
        public SharedPreferences.Editor putInt(String str, int i8) {
            ByteBuffer allocate = ByteBuffer.allocate(8);
            allocate.putInt(c.INT.a());
            allocate.putInt(i8);
            a(str, allocate.array());
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        @NonNull
        public SharedPreferences.Editor putLong(String str, long j8) {
            ByteBuffer allocate = ByteBuffer.allocate(12);
            allocate.putInt(c.LONG.a());
            allocate.putLong(j8);
            a(str, allocate.array());
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        @NonNull
        public SharedPreferences.Editor putString(String str, String str2) {
            if (str2 == null) {
                str2 = "__NULL__";
            }
            byte[] bytes = str2.getBytes(StandardCharsets.UTF_8);
            int length = bytes.length;
            ByteBuffer allocate = ByteBuffer.allocate(length + 8);
            allocate.putInt(c.STRING.a());
            allocate.putInt(length);
            allocate.put(bytes);
            a(str, allocate.array());
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        @NonNull
        public SharedPreferences.Editor putStringSet(String str, Set<String> set) {
            if (set == null) {
                set = new ArraySet<>();
                set.add("__NULL__");
            }
            ArrayList<byte[]> arrayList = new ArrayList(set.size());
            int size = set.size() * 4;
            for (String str2 : set) {
                byte[] bytes = str2.getBytes(StandardCharsets.UTF_8);
                arrayList.add(bytes);
                size += bytes.length;
            }
            ByteBuffer allocate = ByteBuffer.allocate(size + 4);
            allocate.putInt(c.STRING_SET.a());
            for (byte[] bArr : arrayList) {
                allocate.putInt(bArr.length);
                allocate.put(bArr);
            }
            a(str, allocate.array());
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        @NonNull
        public SharedPreferences.Editor remove(String str) {
            if (!this.f43111a.i(str)) {
                this.f43112b.remove(this.f43111a.g(str));
                this.f43113c.add(str);
                return this;
            }
            throw new SecurityException(str + " is a reserved key for the encryption keyset.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public enum c {
        STRING(0),
        STRING_SET(1),
        INT(2),
        LONG(3),
        FLOAT(4),
        BOOLEAN(5);
        

        /* renamed from: f  reason: collision with root package name */
        private final int f43122f;

        c(int i8) {
            this.f43122f = i8;
        }

        public static c c(int i8) {
            if (i8 != 0) {
                if (i8 != 1) {
                    if (i8 != 2) {
                        if (i8 != 3) {
                            if (i8 != 4) {
                                if (i8 != 5) {
                                    return null;
                                }
                                return BOOLEAN;
                            }
                            return FLOAT;
                        }
                        return LONG;
                    }
                    return INT;
                }
                return STRING_SET;
            }
            return STRING;
        }

        public int a() {
            return this.f43122f;
        }
    }

    g6(@NonNull byte[] bArr, @NonNull SharedPreferences sharedPreferences) {
        this.f43106a = sharedPreferences;
        this.f43108c = new o(f(bArr));
        this.f43109d = new or(f(bArr));
    }

    @NonNull
    @SuppressLint({"UnencryptedSharedPreferencesIssue"})
    public static SharedPreferences b(@NonNull Context context, @NonNull String str, @NonNull byte[] bArr) {
        return new g6(bArr, context.getApplicationContext().getSharedPreferences(str, 0));
    }

    private Object d(String str, Object obj) {
        try {
            return h(str);
        } catch (Exception e8) {
            f43105e.c(e8);
            return obj;
        }
    }

    private byte[] f(byte[] bArr) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(bArr);
            return messageDigest.digest();
        } catch (Exception e8) {
            throw new RuntimeException(e8);
        }
    }

    private Object h(String str) {
        if (i(str)) {
            throw new SecurityException(str + " is a reserved key for the encryption keyset.");
        }
        if (str == null) {
            str = "__NULL__";
        }
        String g8 = g(str);
        String string = this.f43106a.getString(g8, null);
        if (string != null) {
            ByteBuffer wrap = ByteBuffer.wrap(this.f43108c.c(Base64.decode(string, 10), f(g8.getBytes(StandardCharsets.UTF_8))));
            wrap.position(0);
            c c8 = c.c(wrap.getInt());
            if (c8 != null) {
                switch (a.f43110a[c8.ordinal()]) {
                    case 1:
                        int i8 = wrap.getInt();
                        ByteBuffer slice = wrap.slice();
                        wrap.limit(i8);
                        String charBuffer = StandardCharsets.UTF_8.decode(slice).toString();
                        if (charBuffer.equals("__NULL__")) {
                            return null;
                        }
                        return charBuffer;
                    case 2:
                        return Integer.valueOf(wrap.getInt());
                    case 3:
                        return Long.valueOf(wrap.getLong());
                    case 4:
                        return Float.valueOf(wrap.getFloat());
                    case 5:
                        return Boolean.valueOf(wrap.get() != 0);
                    case 6:
                        ArraySet arraySet = new ArraySet();
                        while (wrap.hasRemaining()) {
                            int i9 = wrap.getInt();
                            ByteBuffer slice2 = wrap.slice();
                            slice2.limit(i9);
                            wrap.position(wrap.position() + i9);
                            arraySet.add(StandardCharsets.UTF_8.decode(slice2).toString());
                        }
                        if (arraySet.size() == 1 && "__NULL__".equals(arraySet.n(0))) {
                            return null;
                        }
                        return arraySet;
                    default:
                        return null;
                }
            }
            return null;
        }
        return null;
    }

    Pair<String, String> c(String str, byte[] bArr) {
        String g8 = g(str);
        return new Pair<>(g8, Base64.encodeToString(this.f43108c.e(bArr, f(g8.getBytes(StandardCharsets.UTF_8))), 10));
    }

    @Override // android.content.SharedPreferences
    public boolean contains(String str) {
        if (!i(str)) {
            return this.f43106a.contains(g(str));
        }
        throw new SecurityException(str + " is a reserved key for the encryption keyset.");
    }

    String e(String str) {
        String b8 = this.f43109d.b(str);
        if (b8.equals("__NULL__")) {
            return null;
        }
        return b8;
    }

    @Override // android.content.SharedPreferences
    @NonNull
    public SharedPreferences.Editor edit() {
        return new b(this, this.f43106a.edit());
    }

    String g(String str) {
        if (str == null) {
            str = "__NULL__";
        }
        return this.f43109d.e(str);
    }

    @Override // android.content.SharedPreferences
    @NonNull
    public Map<String, ?> getAll() {
        HashMap hashMap = new HashMap();
        try {
            for (Map.Entry<String, ?> entry : this.f43106a.getAll().entrySet()) {
                if (!i(entry.getKey())) {
                    String e8 = e(entry.getKey());
                    hashMap.put(e8, h(e8));
                }
            }
        } catch (Exception e9) {
            f43105e.c(e9);
        }
        return hashMap;
    }

    @Override // android.content.SharedPreferences
    public boolean getBoolean(String str, boolean z7) {
        Object d8 = d(str, Boolean.valueOf(z7));
        return (d8 == null || !(d8 instanceof Boolean)) ? z7 : ((Boolean) d8).booleanValue();
    }

    @Override // android.content.SharedPreferences
    public float getFloat(String str, float f8) {
        Object d8 = d(str, Float.valueOf(f8));
        return (d8 == null || !(d8 instanceof Float)) ? f8 : ((Float) d8).floatValue();
    }

    @Override // android.content.SharedPreferences
    public int getInt(String str, int i8) {
        Object d8 = d(str, Integer.valueOf(i8));
        return (d8 == null || !(d8 instanceof Integer)) ? i8 : ((Integer) d8).intValue();
    }

    @Override // android.content.SharedPreferences
    public long getLong(String str, long j8) {
        Object d8 = d(str, Long.valueOf(j8));
        return (d8 == null || !(d8 instanceof Long)) ? j8 : ((Long) d8).longValue();
    }

    @Override // android.content.SharedPreferences
    public String getString(String str, String str2) {
        Object d8 = d(str, str2);
        return (d8 == null || !(d8 instanceof String)) ? str2 : (String) d8;
    }

    @Override // android.content.SharedPreferences
    public Set<String> getStringSet(String str, Set<String> set) {
        Object d8 = d(str, set);
        Set<String> arraySet = d8 instanceof Set ? (Set) d8 : new ArraySet<>();
        return arraySet.size() > 0 ? arraySet : set;
    }

    boolean i(String str) {
        return "__androidx_security_crypto_encrypted_prefs_key_keyset__".equals(str) || "__androidx_security_crypto_encrypted_prefs_value_keyset__".equals(str);
    }

    @Override // android.content.SharedPreferences
    public void registerOnSharedPreferenceChangeListener(@NonNull SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.f43107b.add(onSharedPreferenceChangeListener);
    }

    @Override // android.content.SharedPreferences
    public void unregisterOnSharedPreferenceChangeListener(@NonNull SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.f43107b.remove(onSharedPreferenceChangeListener);
    }
}
