package com.bumptech.glide.manager;

import androidx.annotation.NonNull;
import com.bumptech.glide.RequestManager;
import java.util.Collections;
import java.util.Set;

/* loaded from: classes.dex */
final class EmptyRequestManagerTreeNode implements RequestManagerTreeNode {
    @Override // com.bumptech.glide.manager.RequestManagerTreeNode
    @NonNull
    public Set<RequestManager> a() {
        return Collections.emptySet();
    }
}
