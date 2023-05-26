package com.bumptech.glide.load.engine.executor;

/* loaded from: classes.dex */
final class RuntimeCompat {
    private RuntimeCompat() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a() {
        return Runtime.getRuntime().availableProcessors();
    }
}
