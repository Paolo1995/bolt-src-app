package eu.bolt.driver.core.storage;

import android.content.Context;
import android.os.Build;
import eu.bolt.driver.core.storage.crypto.EncryptedSharedPreferencesApi1;
import eu.bolt.driver.core.storage.crypto.EncryptedSharedPreferencesApi23;
import eu.bolt.driver.core.util.DefaultCipher;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import javax.inject.Inject;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: StorageFactory.kt */
/* loaded from: classes5.dex */
public final class StorageFactory {

    /* renamed from: a  reason: collision with root package name */
    private final Context f40941a;

    /* renamed from: b  reason: collision with root package name */
    private final DefaultCipher f40942b;

    /* renamed from: c  reason: collision with root package name */
    private final HashMap<String, Object> f40943c;

    @Inject
    public StorageFactory(Context context) {
        Intrinsics.f(context, "context");
        this.f40941a = context;
        this.f40942b = new DefaultCipher("BoltPrefEncryptionKey");
        this.f40943c = new HashMap<>();
    }

    public final KVStorage a(String name, List<? extends StorageMigration> migrations) {
        KVStorage encryptedSharedPreferencesApi1;
        List<StorageMigration> v02;
        Intrinsics.f(name, "name");
        Intrinsics.f(migrations, "migrations");
        if (Build.VERSION.SDK_INT >= 23) {
            Context context = this.f40941a;
            encryptedSharedPreferencesApi1 = new EncryptedSharedPreferencesApi23(context, name + "_23");
        } else {
            Context context2 = this.f40941a;
            encryptedSharedPreferencesApi1 = new EncryptedSharedPreferencesApi1(context2, name + "_1", this.f40942b);
        }
        v02 = CollectionsKt___CollectionsKt.v0(migrations, new Comparator() { // from class: eu.bolt.driver.core.storage.StorageFactory$createEncryptedStorage$$inlined$sortedBy$1
            @Override // java.util.Comparator
            public final int compare(T t7, T t8) {
                int a8;
                a8 = ComparisonsKt__ComparisonsKt.a(Integer.valueOf(((StorageMigration) t7).a()), Integer.valueOf(((StorageMigration) t8).a()));
                return a8;
            }
        });
        for (StorageMigration storageMigration : v02) {
            storageMigration.b(encryptedSharedPreferencesApi1);
        }
        return encryptedSharedPreferencesApi1;
    }
}
