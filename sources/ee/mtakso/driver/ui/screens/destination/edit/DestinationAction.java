package ee.mtakso.driver.ui.screens.destination.edit;

import ee.mtakso.driver.R;
import ee.mtakso.driver.uikit.utils.Color;
import ee.mtakso.driver.uikit.utils.Image;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DestinationActionData.kt */
/* loaded from: classes3.dex */
public abstract class DestinationAction {

    /* renamed from: a  reason: collision with root package name */
    private final Image f28188a;

    /* renamed from: b  reason: collision with root package name */
    private final Color f28189b;

    /* renamed from: c  reason: collision with root package name */
    private final int f28190c;

    /* renamed from: d  reason: collision with root package name */
    private final Color f28191d;

    private DestinationAction(Image image, Color color, int i8, Color color2) {
        this.f28188a = image;
        this.f28189b = color;
        this.f28190c = i8;
        this.f28191d = color2;
    }

    public /* synthetic */ DestinationAction(Image image, Color color, int i8, Color color2, DefaultConstructorMarker defaultConstructorMarker) {
        this(image, color, i8, color2);
    }

    public final Image a() {
        return this.f28188a;
    }

    public final Color b() {
        return this.f28189b;
    }

    public final int c() {
        return this.f28190c;
    }

    public final Color d() {
        return this.f28191d;
    }

    /* compiled from: DestinationActionData.kt */
    /* loaded from: classes3.dex */
    public static final class Edit extends DestinationAction {

        /* renamed from: e  reason: collision with root package name */
        private final Image f28196e;

        /* renamed from: f  reason: collision with root package name */
        private final int f28197f;

        public Edit() {
            this(null, 0, 3, null);
        }

        public /* synthetic */ Edit(Image image, int i8, int i9, DefaultConstructorMarker defaultConstructorMarker) {
            this((i9 & 1) != 0 ? new Image.Res(R.drawable.ic_edit_filled) : image, (i9 & 2) != 0 ? R.string.destination_edit_address : i8);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Edit) {
                Edit edit = (Edit) obj;
                return Intrinsics.a(this.f28196e, edit.f28196e) && this.f28197f == edit.f28197f;
            }
            return false;
        }

        public int hashCode() {
            return (this.f28196e.hashCode() * 31) + this.f28197f;
        }

        public String toString() {
            Image image = this.f28196e;
            int i8 = this.f28197f;
            return "Edit(editIcon=" + image + ", editTitleRes=" + i8 + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Edit(Image editIcon, int i8) {
            super(editIcon, null, i8, null, 10, null);
            Intrinsics.f(editIcon, "editIcon");
            this.f28196e = editIcon;
            this.f28197f = i8;
        }
    }

    /* compiled from: DestinationActionData.kt */
    /* loaded from: classes3.dex */
    public static final class Delete extends DestinationAction {

        /* renamed from: e  reason: collision with root package name */
        private final Image f28192e;

        /* renamed from: f  reason: collision with root package name */
        private final Color f28193f;

        /* renamed from: g  reason: collision with root package name */
        private final int f28194g;

        /* renamed from: h  reason: collision with root package name */
        private final Color f28195h;

        public Delete() {
            this(null, null, 0, null, 15, null);
        }

        public /* synthetic */ Delete(Image image, Color color, int i8, Color color2, int i9, DefaultConstructorMarker defaultConstructorMarker) {
            this((i9 & 1) != 0 ? new Image.Res(R.drawable.ic_delete) : image, (i9 & 2) != 0 ? new Color.Attr(R.attr.contentCritical) : color, (i9 & 4) != 0 ? R.string.destination_remove_address : i8, (i9 & 8) != 0 ? new Color.Attr(R.attr.contentCritical) : color2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Delete) {
                Delete delete = (Delete) obj;
                return Intrinsics.a(this.f28192e, delete.f28192e) && Intrinsics.a(this.f28193f, delete.f28193f) && this.f28194g == delete.f28194g && Intrinsics.a(this.f28195h, delete.f28195h);
            }
            return false;
        }

        public int hashCode() {
            return (((((this.f28192e.hashCode() * 31) + this.f28193f.hashCode()) * 31) + this.f28194g) * 31) + this.f28195h.hashCode();
        }

        public String toString() {
            Image image = this.f28192e;
            Color color = this.f28193f;
            int i8 = this.f28194g;
            Color color2 = this.f28195h;
            return "Delete(deleteIcon=" + image + ", deleteTint=" + color + ", deleteTitleRes=" + i8 + ", deleteTitleTint=" + color2 + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Delete(Image deleteIcon, Color deleteTint, int i8, Color deleteTitleTint) {
            super(deleteIcon, deleteTint, i8, deleteTitleTint, null);
            Intrinsics.f(deleteIcon, "deleteIcon");
            Intrinsics.f(deleteTint, "deleteTint");
            Intrinsics.f(deleteTitleTint, "deleteTitleTint");
            this.f28192e = deleteIcon;
            this.f28193f = deleteTint;
            this.f28194g = i8;
            this.f28195h = deleteTitleTint;
        }
    }

    public /* synthetic */ DestinationAction(Image image, Color color, int i8, Color color2, int i9, DefaultConstructorMarker defaultConstructorMarker) {
        this(image, (i9 & 2) != 0 ? new Color.Attr(R.attr.accentNeutral) : color, i8, (i9 & 8) != 0 ? new Color.Attr(R.attr.accentNeutral) : color2, null);
    }
}
