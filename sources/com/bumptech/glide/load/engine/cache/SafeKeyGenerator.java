package com.bumptech.glide.load.engine.cache;

import androidx.annotation.NonNull;
import androidx.core.util.Pools$Pool;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.util.LruCache;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.Util;
import com.bumptech.glide.util.pool.FactoryPools;
import com.bumptech.glide.util.pool.StateVerifier;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* loaded from: classes.dex */
public class SafeKeyGenerator {

    /* renamed from: a  reason: collision with root package name */
    private final LruCache<Key, String> f10262a = new LruCache<>(1000);

    /* renamed from: b  reason: collision with root package name */
    private final Pools$Pool<PoolableDigestContainer> f10263b = FactoryPools.d(10, new FactoryPools.Factory<PoolableDigestContainer>() { // from class: com.bumptech.glide.load.engine.cache.SafeKeyGenerator.1
        @Override // com.bumptech.glide.util.pool.FactoryPools.Factory
        /* renamed from: b */
        public PoolableDigestContainer a() {
            try {
                return new PoolableDigestContainer(MessageDigest.getInstance("SHA-256"));
            } catch (NoSuchAlgorithmException e8) {
                throw new RuntimeException(e8);
            }
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class PoolableDigestContainer implements FactoryPools.Poolable {

        /* renamed from: f  reason: collision with root package name */
        final MessageDigest f10265f;

        /* renamed from: g  reason: collision with root package name */
        private final StateVerifier f10266g = StateVerifier.a();

        PoolableDigestContainer(MessageDigest messageDigest) {
            this.f10265f = messageDigest;
        }

        @Override // com.bumptech.glide.util.pool.FactoryPools.Poolable
        @NonNull
        public StateVerifier e() {
            return this.f10266g;
        }
    }

    private String a(Key key) {
        PoolableDigestContainer poolableDigestContainer = (PoolableDigestContainer) Preconditions.d(this.f10263b.b());
        try {
            key.b(poolableDigestContainer.f10265f);
            return Util.w(poolableDigestContainer.f10265f.digest());
        } finally {
            this.f10263b.a(poolableDigestContainer);
        }
    }

    public String b(Key key) {
        String g8;
        synchronized (this.f10262a) {
            g8 = this.f10262a.g(key);
        }
        if (g8 == null) {
            g8 = a(key);
        }
        synchronized (this.f10262a) {
            this.f10262a.k(key, g8);
        }
        return g8;
    }
}
