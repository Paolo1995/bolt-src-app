package androidx.core.widget;

import android.widget.ListView;
import androidx.annotation.NonNull;

/* loaded from: classes.dex */
public class ListViewAutoScrollHelper extends AutoScrollHelper {

    /* renamed from: x  reason: collision with root package name */
    private final ListView f6118x;

    public ListViewAutoScrollHelper(@NonNull ListView listView) {
        super(listView);
        this.f6118x = listView;
    }

    @Override // androidx.core.widget.AutoScrollHelper
    public boolean a(int i8) {
        return false;
    }

    @Override // androidx.core.widget.AutoScrollHelper
    public boolean b(int i8) {
        ListView listView = this.f6118x;
        int count = listView.getCount();
        if (count == 0) {
            return false;
        }
        int childCount = listView.getChildCount();
        int firstVisiblePosition = listView.getFirstVisiblePosition();
        int i9 = firstVisiblePosition + childCount;
        if (i8 > 0) {
            if (i9 >= count && listView.getChildAt(childCount - 1).getBottom() <= listView.getHeight()) {
                return false;
            }
        } else if (i8 >= 0) {
            return false;
        } else {
            if (firstVisiblePosition <= 0 && listView.getChildAt(0).getTop() >= 0) {
                return false;
            }
        }
        return true;
    }

    @Override // androidx.core.widget.AutoScrollHelper
    public void j(int i8, int i9) {
        ListViewCompat.a(this.f6118x, i9);
    }
}
