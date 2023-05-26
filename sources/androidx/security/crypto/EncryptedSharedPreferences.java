package androidx.security.crypto;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.ArraySet;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.google.crypto.tink.Aead;
import com.google.crypto.tink.DeterministicAead;
import com.google.crypto.tink.KeyTemplate;
import com.google.crypto.tink.KeysetHandle;
import com.google.crypto.tink.aead.AeadConfig;
import com.google.crypto.tink.aead.AesGcmKeyManager;
import com.google.crypto.tink.daead.AesSivKeyManager;
import com.google.crypto.tink.daead.DeterministicAeadConfig;
import com.google.crypto.tink.integration.android.AndroidKeysetManager;
import com.google.crypto.tink.subtle.Base64;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public final class EncryptedSharedPreferences implements SharedPreferences {

    /* renamed from: a  reason: collision with root package name */
    final SharedPreferences f7711a;

    /* renamed from: b  reason: collision with root package name */
    final List<SharedPreferences.OnSharedPreferenceChangeListener> f7712b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    final String f7713c;

    /* renamed from: d  reason: collision with root package name */
    final String f7714d;

    /* renamed from: e  reason: collision with root package name */
    final Aead f7715e;

    /* renamed from: f  reason: collision with root package name */
    final DeterministicAead f7716f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: androidx.security.crypto.EncryptedSharedPreferences$1  reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f7717a;

        static {
            int[] iArr = new int[EncryptedType.values().length];
            f7717a = iArr;
            try {
                iArr[EncryptedType.STRING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f7717a[EncryptedType.INT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f7717a[EncryptedType.LONG.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f7717a[EncryptedType.FLOAT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f7717a[EncryptedType.BOOLEAN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f7717a[EncryptedType.STRING_SET.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* loaded from: classes.dex */
    private static final class Editor implements SharedPreferences.Editor {

        /* renamed from: a  reason: collision with root package name */
        private final EncryptedSharedPreferences f7718a;

        /* renamed from: b  reason: collision with root package name */
        private final SharedPreferences.Editor f7719b;

        /* renamed from: d  reason: collision with root package name */
        private AtomicBoolean f7721d = new AtomicBoolean(false);

        /* renamed from: c  reason: collision with root package name */
        private final List<String> f7720c = new CopyOnWriteArrayList();

        Editor(EncryptedSharedPreferences encryptedSharedPreferences, SharedPreferences.Editor editor) {
            this.f7718a = encryptedSharedPreferences;
            this.f7719b = editor;
        }

        private void a() {
            if (this.f7721d.getAndSet(false)) {
                for (String str : this.f7718a.getAll().keySet()) {
                    if (!this.f7720c.contains(str) && !this.f7718a.f(str)) {
                        this.f7719b.remove(this.f7718a.c(str));
                    }
                }
            }
        }

        private void b() {
            for (SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener : this.f7718a.f7712b) {
                for (String str : this.f7720c) {
                    onSharedPreferenceChangeListener.onSharedPreferenceChanged(this.f7718a, str);
                }
            }
        }

        private void c(String str, byte[] bArr) {
            if (!this.f7718a.f(str)) {
                this.f7720c.add(str);
                if (str == null) {
                    str = "__NULL__";
                }
                try {
                    Pair<String, String> d8 = this.f7718a.d(str, bArr);
                    this.f7719b.putString((String) d8.first, (String) d8.second);
                    return;
                } catch (GeneralSecurityException e8) {
                    throw new SecurityException("Could not encrypt data: " + e8.getMessage(), e8);
                }
            }
            throw new SecurityException(str + " is a reserved key for the encryption keyset.");
        }

        @Override // android.content.SharedPreferences.Editor
        public void apply() {
            a();
            this.f7719b.apply();
            b();
            this.f7720c.clear();
        }

        @Override // android.content.SharedPreferences.Editor
        @NonNull
        public SharedPreferences.Editor clear() {
            this.f7721d.set(true);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public boolean commit() {
            a();
            try {
                return this.f7719b.commit();
            } finally {
                b();
                this.f7720c.clear();
            }
        }

        @Override // android.content.SharedPreferences.Editor
        @NonNull
        public SharedPreferences.Editor putBoolean(String str, boolean z7) {
            ByteBuffer allocate = ByteBuffer.allocate(5);
            allocate.putInt(EncryptedType.BOOLEAN.c());
            allocate.put(z7 ? (byte) 1 : (byte) 0);
            c(str, allocate.array());
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        @NonNull
        public SharedPreferences.Editor putFloat(String str, float f8) {
            ByteBuffer allocate = ByteBuffer.allocate(8);
            allocate.putInt(EncryptedType.FLOAT.c());
            allocate.putFloat(f8);
            c(str, allocate.array());
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        @NonNull
        public SharedPreferences.Editor putInt(String str, int i8) {
            ByteBuffer allocate = ByteBuffer.allocate(8);
            allocate.putInt(EncryptedType.INT.c());
            allocate.putInt(i8);
            c(str, allocate.array());
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        @NonNull
        public SharedPreferences.Editor putLong(String str, long j8) {
            ByteBuffer allocate = ByteBuffer.allocate(12);
            allocate.putInt(EncryptedType.LONG.c());
            allocate.putLong(j8);
            c(str, allocate.array());
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
            allocate.putInt(EncryptedType.STRING.c());
            allocate.putInt(length);
            allocate.put(bytes);
            c(str, allocate.array());
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        @NonNull
        public SharedPreferences.Editor putStringSet(String str, Set<String> set) {
            if (set == null) {
                set = new ArraySet();
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
            allocate.putInt(EncryptedType.STRING_SET.c());
            for (byte[] bArr : arrayList) {
                allocate.putInt(bArr.length);
                allocate.put(bArr);
            }
            c(str, allocate.array());
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        @NonNull
        public SharedPreferences.Editor remove(String str) {
            if (!this.f7718a.f(str)) {
                this.f7719b.remove(this.f7718a.c(str));
                this.f7720c.remove(str);
                return this;
            }
            throw new SecurityException(str + " is a reserved key for the encryption keyset.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public enum EncryptedType {
        STRING(0),
        STRING_SET(1),
        INT(2),
        LONG(3),
        FLOAT(4),
        BOOLEAN(5);
        

        /* renamed from: f  reason: collision with root package name */
        private final int f7729f;

        EncryptedType(int i8) {
            this.f7729f = i8;
        }

        public static EncryptedType a(int i8) {
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

        public int c() {
            return this.f7729f;
        }
    }

    /* loaded from: classes.dex */
    public enum PrefKeyEncryptionScheme {
        AES256_SIV(AesSivKeyManager.j());
        

        /* renamed from: f  reason: collision with root package name */
        private final KeyTemplate f7732f;

        PrefKeyEncryptionScheme(KeyTemplate keyTemplate) {
            this.f7732f = keyTemplate;
        }

        KeyTemplate a() {
            return this.f7732f;
        }
    }

    /* loaded from: classes.dex */
    public enum PrefValueEncryptionScheme {
        AES256_GCM(AesGcmKeyManager.j());
        

        /* renamed from: f  reason: collision with root package name */
        private final KeyTemplate f7735f;

        PrefValueEncryptionScheme(KeyTemplate keyTemplate) {
            this.f7735f = keyTemplate;
        }

        KeyTemplate a() {
            return this.f7735f;
        }
    }

    EncryptedSharedPreferences(@NonNull String str, @NonNull String str2, @NonNull SharedPreferences sharedPreferences, @NonNull Aead aead, @NonNull DeterministicAead deterministicAead) {
        this.f7713c = str;
        this.f7711a = sharedPreferences;
        this.f7714d = str2;
        this.f7715e = aead;
        this.f7716f = deterministicAead;
    }

    @NonNull
    public static SharedPreferences a(@NonNull String str, @NonNull String str2, @NonNull Context context, @NonNull PrefKeyEncryptionScheme prefKeyEncryptionScheme, @NonNull PrefValueEncryptionScheme prefValueEncryptionScheme) throws GeneralSecurityException, IOException {
        DeterministicAeadConfig.b();
        AeadConfig.b();
        AndroidKeysetManager.Builder j8 = new AndroidKeysetManager.Builder().h(prefKeyEncryptionScheme.a()).j(context, "__androidx_security_crypto_encrypted_prefs_key_keyset__", str);
        KeysetHandle c8 = j8.i("android-keystore://" + str2).d().c();
        AndroidKeysetManager.Builder j9 = new AndroidKeysetManager.Builder().h(prefValueEncryptionScheme.a()).j(context, "__androidx_security_crypto_encrypted_prefs_value_keyset__", str);
        KeysetHandle c9 = j9.i("android-keystore://" + str2).d().c();
        DeterministicAead deterministicAead = (DeterministicAead) c8.h(DeterministicAead.class);
        return new EncryptedSharedPreferences(str, str2, context.getSharedPreferences(str, 0), (Aead) c9.h(Aead.class), deterministicAead);
    }

    private Object e(String str) {
        if (!f(str)) {
            if (str == null) {
                str = "__NULL__";
            }
            try {
                String c8 = c(str);
                String string = this.f7711a.getString(c8, null);
                if (string == null) {
                    return null;
                }
                boolean z7 = false;
                ByteBuffer wrap = ByteBuffer.wrap(this.f7715e.b(Base64.a(string, 0), c8.getBytes(StandardCharsets.UTF_8)));
                wrap.position(0);
                switch (AnonymousClass1.f7717a[EncryptedType.a(wrap.getInt()).ordinal()]) {
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
                        if (wrap.get() != 0) {
                            z7 = true;
                        }
                        return Boolean.valueOf(z7);
                    case 6:
                        ArraySet arraySet = new ArraySet();
                        while (wrap.hasRemaining()) {
                            int i9 = wrap.getInt();
                            ByteBuffer slice2 = wrap.slice();
                            slice2.limit(i9);
                            wrap.position(wrap.position() + i9);
                            arraySet.add(StandardCharsets.UTF_8.decode(slice2).toString());
                        }
                        if (arraySet.size() == 1 && "__NULL__".equals(arraySet.valueAt(0))) {
                            return null;
                        }
                        return arraySet;
                    default:
                        return null;
                }
            } catch (GeneralSecurityException e8) {
                throw new SecurityException("Could not decrypt value. " + e8.getMessage(), e8);
            }
        }
        throw new SecurityException(str + " is a reserved key for the encryption keyset.");
    }

    String b(String str) {
        try {
            String str2 = new String(this.f7716f.b(Base64.a(str, 0), this.f7713c.getBytes()), StandardCharsets.UTF_8);
            if (str2.equals("__NULL__")) {
                return null;
            }
            return str2;
        } catch (GeneralSecurityException e8) {
            throw new SecurityException("Could not decrypt key. " + e8.getMessage(), e8);
        }
    }

    String c(String str) {
        if (str == null) {
            str = "__NULL__";
        }
        try {
            return Base64.d(this.f7716f.a(str.getBytes(StandardCharsets.UTF_8), this.f7713c.getBytes()));
        } catch (GeneralSecurityException e8) {
            throw new SecurityException("Could not encrypt key. " + e8.getMessage(), e8);
        }
    }

    @Override // android.content.SharedPreferences
    public boolean contains(String str) {
        if (!f(str)) {
            return this.f7711a.contains(c(str));
        }
        throw new SecurityException(str + " is a reserved key for the encryption keyset.");
    }

    Pair<String, String> d(String str, byte[] bArr) throws GeneralSecurityException {
        String c8 = c(str);
        return new Pair<>(c8, Base64.d(this.f7715e.a(bArr, c8.getBytes(StandardCharsets.UTF_8))));
    }

    @Override // android.content.SharedPreferences
    @NonNull
    public SharedPreferences.Editor edit() {
        return new Editor(this, this.f7711a.edit());
    }

    boolean f(String str) {
        if (!"__androidx_security_crypto_encrypted_prefs_key_keyset__".equals(str) && !"__androidx_security_crypto_encrypted_prefs_value_keyset__".equals(str)) {
            return false;
        }
        return true;
    }

    @Override // android.content.SharedPreferences
    @NonNull
    public Map<String, ?> getAll() {
        HashMap hashMap = new HashMap();
        for (Map.Entry<String, ?> entry : this.f7711a.getAll().entrySet()) {
            if (!f(entry.getKey())) {
                String b8 = b(entry.getKey());
                hashMap.put(b8, e(b8));
            }
        }
        return hashMap;
    }

    @Override // android.content.SharedPreferences
    public boolean getBoolean(String str, boolean z7) {
        Object e8 = e(str);
        if (e8 != null && (e8 instanceof Boolean)) {
            return ((Boolean) e8).booleanValue();
        }
        return z7;
    }

    @Override // android.content.SharedPreferences
    public float getFloat(String str, float f8) {
        Object e8 = e(str);
        if (e8 != null && (e8 instanceof Float)) {
            return ((Float) e8).floatValue();
        }
        return f8;
    }

    @Override // android.content.SharedPreferences
    public int getInt(String str, int i8) {
        Object e8 = e(str);
        if (e8 != null && (e8 instanceof Integer)) {
            return ((Integer) e8).intValue();
        }
        return i8;
    }

    @Override // android.content.SharedPreferences
    public long getLong(String str, long j8) {
        Object e8 = e(str);
        if (e8 != null && (e8 instanceof Long)) {
            return ((Long) e8).longValue();
        }
        return j8;
    }

    @Override // android.content.SharedPreferences
    public String getString(String str, String str2) {
        Object e8 = e(str);
        if (e8 != null && (e8 instanceof String)) {
            return (String) e8;
        }
        return str2;
    }

    @Override // android.content.SharedPreferences
    public Set<String> getStringSet(String str, Set<String> set) {
        Set<String> arraySet;
        Object e8 = e(str);
        if (e8 instanceof Set) {
            arraySet = (Set) e8;
        } else {
            arraySet = new ArraySet();
        }
        if (arraySet.size() > 0) {
            return arraySet;
        }
        return set;
    }

    @Override // android.content.SharedPreferences
    public void registerOnSharedPreferenceChangeListener(@NonNull SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.f7712b.add(onSharedPreferenceChangeListener);
    }

    @Override // android.content.SharedPreferences
    public void unregisterOnSharedPreferenceChangeListener(@NonNull SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.f7712b.remove(onSharedPreferenceChangeListener);
    }
}
