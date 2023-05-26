package eu.bolt.driver.core.storage;

import java.util.Set;

/* compiled from: BoltPrefsStorage.kt */
/* loaded from: classes5.dex */
public interface BoltPrefsStorage {
    int a(String str, int i8);

    void b(String str, Integer num);

    void c(String str, String str2);

    boolean contains(String str);

    void d(String str, Set<String> set);

    void e(String... strArr);

    void f();

    void g(String str, Long l8);

    boolean getBoolean(String str, boolean z7);

    long getLong(String str, long j8);

    String getString(String str, String str2);

    Set<String> getStringSet(String str, Set<String> set);

    void h(String str, Boolean bool);
}
