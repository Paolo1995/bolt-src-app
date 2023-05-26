package com.google.android.gms.internal.auth;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
/* loaded from: classes.dex */
final class zzfc extends zzfe {
    private static final Class<?> zza = Collections.unmodifiableList(Collections.emptyList()).getClass();

    private zzfc() {
        super(null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzfc(zzfb zzfbVar) {
        super(null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.auth.zzfe
    public final void zza(Object obj, long j8) {
        Object unmodifiableList;
        List list = (List) zzgz.zzf(obj, j8);
        if (list instanceof zzfa) {
            unmodifiableList = ((zzfa) list).zze();
        } else if (zza.isAssignableFrom(list.getClass())) {
            return;
        } else {
            if ((list instanceof zzfx) && (list instanceof zzeu)) {
                zzeu zzeuVar = (zzeu) list;
                if (zzeuVar.zzc()) {
                    zzeuVar.zzb();
                    return;
                }
                return;
            }
            unmodifiableList = Collections.unmodifiableList(list);
        }
        zzgz.zzp(obj, j8, unmodifiableList);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.auth.zzfe
    public final <E> void zzb(Object obj, Object obj2, long j8) {
        ArrayList arrayList;
        List list = (List) zzgz.zzf(obj2, j8);
        int size = list.size();
        List list2 = (List) zzgz.zzf(obj, j8);
        if (list2.isEmpty()) {
            if (list2 instanceof zzfa) {
                list2 = new zzez(size);
            } else if ((list2 instanceof zzfx) && (list2 instanceof zzeu)) {
                list2 = ((zzeu) list2).zzd(size);
            } else {
                list2 = new ArrayList(size);
            }
            zzgz.zzp(obj, j8, list2);
        } else {
            if (zza.isAssignableFrom(list2.getClass())) {
                ArrayList arrayList2 = new ArrayList(list2.size() + size);
                arrayList2.addAll(list2);
                zzgz.zzp(obj, j8, arrayList2);
                arrayList = arrayList2;
            } else if (list2 instanceof zzgu) {
                zzez zzezVar = new zzez(list2.size() + size);
                zzezVar.addAll(zzezVar.size(), (zzgu) list2);
                zzgz.zzp(obj, j8, zzezVar);
                arrayList = zzezVar;
            } else if ((list2 instanceof zzfx) && (list2 instanceof zzeu)) {
                zzeu zzeuVar = (zzeu) list2;
                if (!zzeuVar.zzc()) {
                    list2 = zzeuVar.zzd(list2.size() + size);
                    zzgz.zzp(obj, j8, list2);
                }
            }
            list2 = arrayList;
        }
        int size2 = list2.size();
        int size3 = list.size();
        if (size2 > 0 && size3 > 0) {
            list2.addAll(list);
        }
        if (size2 > 0) {
            list = list2;
        }
        zzgz.zzp(obj, j8, list);
    }
}
