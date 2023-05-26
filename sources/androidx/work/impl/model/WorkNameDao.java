package androidx.work.impl.model;

import androidx.annotation.NonNull;
import java.util.List;

/* loaded from: classes.dex */
public interface WorkNameDao {
    void a(WorkName workName);

    @NonNull
    List<String> b(@NonNull String str);
}
