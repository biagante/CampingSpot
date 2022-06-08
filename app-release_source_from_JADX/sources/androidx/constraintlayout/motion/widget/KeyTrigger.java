package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.motion.utils.ViewSpline;
import androidx.constraintlayout.widget.C0174R;
import androidx.constraintlayout.widget.ConstraintAttribute;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;

public class KeyTrigger extends Key {
    public static final String CROSS = "CROSS";
    public static final int KEY_TYPE = 5;
    static final String NAME = "KeyTrigger";
    public static final String NEGATIVE_CROSS = "negativeCross";
    public static final String POSITIVE_CROSS = "positiveCross";
    public static final String POST_LAYOUT = "postLayout";
    private static final String TAG = "KeyTrigger";
    public static final String TRIGGER_COLLISION_ID = "triggerCollisionId";
    public static final String TRIGGER_COLLISION_VIEW = "triggerCollisionView";
    public static final String TRIGGER_ID = "triggerID";
    public static final String TRIGGER_RECEIVER = "triggerReceiver";
    public static final String TRIGGER_SLACK = "triggerSlack";
    public static final String VIEW_TRANSITION_ON_CROSS = "viewTransitionOnCross";
    public static final String VIEW_TRANSITION_ON_NEGATIVE_CROSS = "viewTransitionOnNegativeCross";
    public static final String VIEW_TRANSITION_ON_POSITIVE_CROSS = "viewTransitionOnPositiveCross";
    RectF mCollisionRect = new RectF();
    /* access modifiers changed from: private */
    public String mCross = null;
    private int mCurveFit = -1;
    private boolean mFireCrossReset = true;
    private float mFireLastPos;
    private boolean mFireNegativeReset = true;
    private boolean mFirePositiveReset = true;
    /* access modifiers changed from: private */
    public float mFireThreshold = Float.NaN;
    HashMap<String, Method> mMethodHashMap = new HashMap<>();
    /* access modifiers changed from: private */
    public String mNegativeCross = null;
    /* access modifiers changed from: private */
    public String mPositiveCross = null;
    /* access modifiers changed from: private */
    public boolean mPostLayout = false;
    RectF mTargetRect = new RectF();
    /* access modifiers changed from: private */
    public int mTriggerCollisionId = UNSET;
    private View mTriggerCollisionView = null;
    /* access modifiers changed from: private */
    public int mTriggerID = UNSET;
    /* access modifiers changed from: private */
    public int mTriggerReceiver = UNSET;
    float mTriggerSlack = 0.1f;
    int mViewTransitionOnCross = UNSET;
    int mViewTransitionOnNegativeCross = UNSET;
    int mViewTransitionOnPositiveCross = UNSET;

    public void addValues(HashMap<String, ViewSpline> hashMap) {
    }

    public void getAttributeNames(HashSet<String> hashSet) {
    }

    public KeyTrigger() {
        this.mType = 5;
        this.mCustomConstraints = new HashMap();
    }

    public void load(Context context, AttributeSet attributeSet) {
        Loader.read(this, context.obtainStyledAttributes(attributeSet, C0174R.styleable.KeyTrigger), context);
    }

    /* access modifiers changed from: package-private */
    public int getCurveFit() {
        return this.mCurveFit;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setValue(java.lang.String r2, java.lang.Object r3) {
        /*
            r1 = this;
            int r0 = r2.hashCode()
            switch(r0) {
                case -1594793529: goto L_0x007d;
                case -966421266: goto L_0x0072;
                case -786670827: goto L_0x0068;
                case -648752941: goto L_0x005e;
                case -638126837: goto L_0x0054;
                case -76025313: goto L_0x004a;
                case -9754574: goto L_0x003f;
                case 64397344: goto L_0x0035;
                case 364489912: goto L_0x002b;
                case 1301930599: goto L_0x0020;
                case 1401391082: goto L_0x0014;
                case 1535404999: goto L_0x0009;
                default: goto L_0x0007;
            }
        L_0x0007:
            goto L_0x0087
        L_0x0009:
            java.lang.String r0 = "triggerReceiver"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0087
            r2 = 1
            goto L_0x0088
        L_0x0014:
            java.lang.String r0 = "postLayout"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0087
            r2 = 8
            goto L_0x0088
        L_0x0020:
            java.lang.String r0 = "viewTransitionOnCross"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0087
            r2 = 11
            goto L_0x0088
        L_0x002b:
            java.lang.String r0 = "triggerSlack"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0087
            r2 = 7
            goto L_0x0088
        L_0x0035:
            java.lang.String r0 = "CROSS"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0087
            r2 = 0
            goto L_0x0088
        L_0x003f:
            java.lang.String r0 = "viewTransitionOnNegativeCross"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0087
            r2 = 9
            goto L_0x0088
        L_0x004a:
            java.lang.String r0 = "triggerCollisionView"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0087
            r2 = 6
            goto L_0x0088
        L_0x0054:
            java.lang.String r0 = "negativeCross"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0087
            r2 = 2
            goto L_0x0088
        L_0x005e:
            java.lang.String r0 = "triggerID"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0087
            r2 = 4
            goto L_0x0088
        L_0x0068:
            java.lang.String r0 = "triggerCollisionId"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0087
            r2 = 5
            goto L_0x0088
        L_0x0072:
            java.lang.String r0 = "viewTransitionOnPositiveCross"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0087
            r2 = 10
            goto L_0x0088
        L_0x007d:
            java.lang.String r0 = "positiveCross"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0087
            r2 = 3
            goto L_0x0088
        L_0x0087:
            r2 = -1
        L_0x0088:
            switch(r2) {
                case 0: goto L_0x00d7;
                case 1: goto L_0x00d0;
                case 2: goto L_0x00c9;
                case 3: goto L_0x00c2;
                case 4: goto L_0x00bb;
                case 5: goto L_0x00b4;
                case 6: goto L_0x00af;
                case 7: goto L_0x00a8;
                case 8: goto L_0x00a1;
                case 9: goto L_0x009a;
                case 10: goto L_0x0093;
                case 11: goto L_0x008c;
                default: goto L_0x008b;
            }
        L_0x008b:
            goto L_0x00dd
        L_0x008c:
            int r2 = r1.toInt(r3)
            r1.mViewTransitionOnCross = r2
            goto L_0x00dd
        L_0x0093:
            int r2 = r1.toInt(r3)
            r1.mViewTransitionOnPositiveCross = r2
            goto L_0x00dd
        L_0x009a:
            int r2 = r1.toInt(r3)
            r1.mViewTransitionOnNegativeCross = r2
            goto L_0x00dd
        L_0x00a1:
            boolean r2 = r1.toBoolean(r3)
            r1.mPostLayout = r2
            goto L_0x00dd
        L_0x00a8:
            float r2 = r1.toFloat(r3)
            r1.mTriggerSlack = r2
            goto L_0x00dd
        L_0x00af:
            android.view.View r3 = (android.view.View) r3
            r1.mTriggerCollisionView = r3
            goto L_0x00dd
        L_0x00b4:
            int r2 = r1.toInt(r3)
            r1.mTriggerCollisionId = r2
            goto L_0x00dd
        L_0x00bb:
            int r2 = r1.toInt(r3)
            r1.mTriggerID = r2
            goto L_0x00dd
        L_0x00c2:
            java.lang.String r2 = r3.toString()
            r1.mPositiveCross = r2
            goto L_0x00dd
        L_0x00c9:
            java.lang.String r2 = r3.toString()
            r1.mNegativeCross = r2
            goto L_0x00dd
        L_0x00d0:
            int r2 = r1.toInt(r3)
            r1.mTriggerReceiver = r2
            goto L_0x00dd
        L_0x00d7:
            java.lang.String r2 = r3.toString()
            r1.mCross = r2
        L_0x00dd:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.KeyTrigger.setValue(java.lang.String, java.lang.Object):void");
    }

    private void setUpRect(RectF rectF, View view, boolean z) {
        rectF.top = (float) view.getTop();
        rectF.bottom = (float) view.getBottom();
        rectF.left = (float) view.getLeft();
        rectF.right = (float) view.getRight();
        if (z) {
            view.getMatrix().mapRect(rectF);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x008d  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00a2  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00b7  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00d1  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00fc  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00fe  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x010c  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x012a  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0148  */
    /* JADX WARNING: Removed duplicated region for block: B:90:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void conditionallyFire(float r10, android.view.View r11) {
        /*
            r9 = this;
            int r0 = r9.mTriggerCollisionId
            int r1 = UNSET
            r2 = 0
            r3 = 1
            if (r0 == r1) goto L_0x0062
            android.view.View r0 = r9.mTriggerCollisionView
            if (r0 != 0) goto L_0x001a
            android.view.ViewParent r0 = r11.getParent()
            android.view.ViewGroup r0 = (android.view.ViewGroup) r0
            int r1 = r9.mTriggerCollisionId
            android.view.View r0 = r0.findViewById(r1)
            r9.mTriggerCollisionView = r0
        L_0x001a:
            android.graphics.RectF r0 = r9.mCollisionRect
            android.view.View r1 = r9.mTriggerCollisionView
            boolean r4 = r9.mPostLayout
            r9.setUpRect(r0, r1, r4)
            android.graphics.RectF r0 = r9.mTargetRect
            boolean r1 = r9.mPostLayout
            r9.setUpRect(r0, r11, r1)
            android.graphics.RectF r0 = r9.mCollisionRect
            android.graphics.RectF r1 = r9.mTargetRect
            boolean r0 = r0.intersect(r1)
            if (r0 == 0) goto L_0x004c
            boolean r0 = r9.mFireCrossReset
            if (r0 == 0) goto L_0x003c
            r9.mFireCrossReset = r2
            r0 = 1
            goto L_0x003d
        L_0x003c:
            r0 = 0
        L_0x003d:
            boolean r1 = r9.mFirePositiveReset
            if (r1 == 0) goto L_0x0045
            r9.mFirePositiveReset = r2
            r1 = 1
            goto L_0x0046
        L_0x0045:
            r1 = 0
        L_0x0046:
            r9.mFireNegativeReset = r3
            r4 = r1
            r1 = 0
            goto L_0x00e3
        L_0x004c:
            boolean r0 = r9.mFireCrossReset
            if (r0 != 0) goto L_0x0054
            r9.mFireCrossReset = r3
            r0 = 1
            goto L_0x0055
        L_0x0054:
            r0 = 0
        L_0x0055:
            boolean r1 = r9.mFireNegativeReset
            if (r1 == 0) goto L_0x005d
            r9.mFireNegativeReset = r2
            r1 = 1
            goto L_0x005e
        L_0x005d:
            r1 = 0
        L_0x005e:
            r9.mFirePositiveReset = r3
            goto L_0x00e2
        L_0x0062:
            boolean r0 = r9.mFireCrossReset
            r1 = 0
            if (r0 == 0) goto L_0x0078
            float r0 = r9.mFireThreshold
            float r4 = r10 - r0
            float r5 = r9.mFireLastPos
            float r5 = r5 - r0
            float r4 = r4 * r5
            int r0 = (r4 > r1 ? 1 : (r4 == r1 ? 0 : -1))
            if (r0 >= 0) goto L_0x0088
            r9.mFireCrossReset = r2
            r0 = 1
            goto L_0x0089
        L_0x0078:
            float r0 = r9.mFireThreshold
            float r0 = r10 - r0
            float r0 = java.lang.Math.abs(r0)
            float r4 = r9.mTriggerSlack
            int r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r0 <= 0) goto L_0x0088
            r9.mFireCrossReset = r3
        L_0x0088:
            r0 = 0
        L_0x0089:
            boolean r4 = r9.mFireNegativeReset
            if (r4 == 0) goto L_0x00a2
            float r4 = r9.mFireThreshold
            float r5 = r10 - r4
            float r6 = r9.mFireLastPos
            float r6 = r6 - r4
            float r6 = r6 * r5
            int r4 = (r6 > r1 ? 1 : (r6 == r1 ? 0 : -1))
            if (r4 >= 0) goto L_0x00b2
            int r4 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
            if (r4 >= 0) goto L_0x00b2
            r9.mFireNegativeReset = r2
            r4 = 1
            goto L_0x00b3
        L_0x00a2:
            float r4 = r9.mFireThreshold
            float r4 = r10 - r4
            float r4 = java.lang.Math.abs(r4)
            float r5 = r9.mTriggerSlack
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 <= 0) goto L_0x00b2
            r9.mFireNegativeReset = r3
        L_0x00b2:
            r4 = 0
        L_0x00b3:
            boolean r5 = r9.mFirePositiveReset
            if (r5 == 0) goto L_0x00d1
            float r5 = r9.mFireThreshold
            float r6 = r10 - r5
            float r7 = r9.mFireLastPos
            float r7 = r7 - r5
            float r7 = r7 * r6
            int r5 = (r7 > r1 ? 1 : (r7 == r1 ? 0 : -1))
            if (r5 >= 0) goto L_0x00cc
            int r1 = (r6 > r1 ? 1 : (r6 == r1 ? 0 : -1))
            if (r1 <= 0) goto L_0x00cc
            r9.mFirePositiveReset = r2
            r1 = 1
            goto L_0x00cd
        L_0x00cc:
            r1 = 0
        L_0x00cd:
            r8 = r4
            r4 = r1
            r1 = r8
            goto L_0x00e3
        L_0x00d1:
            float r1 = r9.mFireThreshold
            float r1 = r10 - r1
            float r1 = java.lang.Math.abs(r1)
            float r5 = r9.mTriggerSlack
            int r1 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r1 <= 0) goto L_0x00e1
            r9.mFirePositiveReset = r3
        L_0x00e1:
            r1 = r4
        L_0x00e2:
            r4 = 0
        L_0x00e3:
            r9.mFireLastPos = r10
            if (r1 != 0) goto L_0x00eb
            if (r0 != 0) goto L_0x00eb
            if (r4 == 0) goto L_0x00f6
        L_0x00eb:
            android.view.ViewParent r5 = r11.getParent()
            androidx.constraintlayout.motion.widget.MotionLayout r5 = (androidx.constraintlayout.motion.widget.MotionLayout) r5
            int r6 = r9.mTriggerID
            r5.fireTrigger(r6, r4, r10)
        L_0x00f6:
            int r10 = r9.mTriggerReceiver
            int r5 = UNSET
            if (r10 != r5) goto L_0x00fe
            r10 = r11
            goto L_0x010a
        L_0x00fe:
            android.view.ViewParent r10 = r11.getParent()
            androidx.constraintlayout.motion.widget.MotionLayout r10 = (androidx.constraintlayout.motion.widget.MotionLayout) r10
            int r5 = r9.mTriggerReceiver
            android.view.View r10 = r10.findViewById(r5)
        L_0x010a:
            if (r1 == 0) goto L_0x0128
            java.lang.String r1 = r9.mNegativeCross
            if (r1 == 0) goto L_0x0113
            r9.fire(r1, r10)
        L_0x0113:
            int r1 = r9.mViewTransitionOnNegativeCross
            int r5 = UNSET
            if (r1 == r5) goto L_0x0128
            android.view.ViewParent r1 = r11.getParent()
            androidx.constraintlayout.motion.widget.MotionLayout r1 = (androidx.constraintlayout.motion.widget.MotionLayout) r1
            int r5 = r9.mViewTransitionOnNegativeCross
            android.view.View[] r6 = new android.view.View[r3]
            r6[r2] = r10
            r1.viewTransition(r5, r6)
        L_0x0128:
            if (r4 == 0) goto L_0x0146
            java.lang.String r1 = r9.mPositiveCross
            if (r1 == 0) goto L_0x0131
            r9.fire(r1, r10)
        L_0x0131:
            int r1 = r9.mViewTransitionOnPositiveCross
            int r4 = UNSET
            if (r1 == r4) goto L_0x0146
            android.view.ViewParent r1 = r11.getParent()
            androidx.constraintlayout.motion.widget.MotionLayout r1 = (androidx.constraintlayout.motion.widget.MotionLayout) r1
            int r4 = r9.mViewTransitionOnPositiveCross
            android.view.View[] r5 = new android.view.View[r3]
            r5[r2] = r10
            r1.viewTransition(r4, r5)
        L_0x0146:
            if (r0 == 0) goto L_0x0164
            java.lang.String r0 = r9.mCross
            if (r0 == 0) goto L_0x014f
            r9.fire(r0, r10)
        L_0x014f:
            int r0 = r9.mViewTransitionOnCross
            int r1 = UNSET
            if (r0 == r1) goto L_0x0164
            android.view.ViewParent r11 = r11.getParent()
            androidx.constraintlayout.motion.widget.MotionLayout r11 = (androidx.constraintlayout.motion.widget.MotionLayout) r11
            int r0 = r9.mViewTransitionOnCross
            android.view.View[] r1 = new android.view.View[r3]
            r1[r2] = r10
            r11.viewTransition(r0, r1)
        L_0x0164:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.KeyTrigger.conditionallyFire(float, android.view.View):void");
    }

    private void fire(String str, View view) {
        Method method;
        if (str != null) {
            if (str.startsWith(".")) {
                fireCustom(str, view);
                return;
            }
            if (this.mMethodHashMap.containsKey(str)) {
                method = this.mMethodHashMap.get(str);
                if (method == null) {
                    return;
                }
            } else {
                method = null;
            }
            if (method == null) {
                try {
                    method = view.getClass().getMethod(str, new Class[0]);
                    this.mMethodHashMap.put(str, method);
                } catch (NoSuchMethodException unused) {
                    this.mMethodHashMap.put(str, (Object) null);
                    Log.e(TypedValues.TriggerType.NAME, "Could not find method \"" + str + "\"on class " + view.getClass().getSimpleName() + " " + Debug.getName(view));
                    return;
                }
            }
            try {
                method.invoke(view, new Object[0]);
            } catch (Exception unused2) {
                Log.e(TypedValues.TriggerType.NAME, "Exception in call \"" + this.mCross + "\"on class " + view.getClass().getSimpleName() + " " + Debug.getName(view));
            }
        }
    }

    private void fireCustom(String str, View view) {
        ConstraintAttribute constraintAttribute;
        boolean z = str.length() == 1;
        if (!z) {
            str = str.substring(1).toLowerCase(Locale.ROOT);
        }
        for (String str2 : this.mCustomConstraints.keySet()) {
            String lowerCase = str2.toLowerCase(Locale.ROOT);
            if ((z || lowerCase.matches(str)) && (constraintAttribute = (ConstraintAttribute) this.mCustomConstraints.get(str2)) != null) {
                constraintAttribute.applyCustom(view);
            }
        }
    }

    private static class Loader {
        private static final int COLLISION = 9;
        private static final int CROSS = 4;
        private static final int FRAME_POS = 8;
        private static final int NEGATIVE_CROSS = 1;
        private static final int POSITIVE_CROSS = 2;
        private static final int POST_LAYOUT = 10;
        private static final int TARGET_ID = 7;
        private static final int TRIGGER_ID = 6;
        private static final int TRIGGER_RECEIVER = 11;
        private static final int TRIGGER_SLACK = 5;
        private static final int VT_CROSS = 12;
        private static final int VT_NEGATIVE_CROSS = 13;
        private static final int VT_POSITIVE_CROSS = 14;
        private static SparseIntArray mAttrMap;

        private Loader() {
        }

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            mAttrMap = sparseIntArray;
            sparseIntArray.append(C0174R.styleable.KeyTrigger_framePosition, 8);
            mAttrMap.append(C0174R.styleable.KeyTrigger_onCross, 4);
            mAttrMap.append(C0174R.styleable.KeyTrigger_onNegativeCross, 1);
            mAttrMap.append(C0174R.styleable.KeyTrigger_onPositiveCross, 2);
            mAttrMap.append(C0174R.styleable.KeyTrigger_motionTarget, 7);
            mAttrMap.append(C0174R.styleable.KeyTrigger_triggerId, 6);
            mAttrMap.append(C0174R.styleable.KeyTrigger_triggerSlack, 5);
            mAttrMap.append(C0174R.styleable.KeyTrigger_motion_triggerOnCollision, 9);
            mAttrMap.append(C0174R.styleable.KeyTrigger_motion_postLayoutCollision, 10);
            mAttrMap.append(C0174R.styleable.KeyTrigger_triggerReceiver, 11);
            mAttrMap.append(C0174R.styleable.KeyTrigger_viewTransitionOnCross, 12);
            mAttrMap.append(C0174R.styleable.KeyTrigger_viewTransitionOnNegativeCross, 13);
            mAttrMap.append(C0174R.styleable.KeyTrigger_viewTransitionOnPositiveCross, 14);
        }

        public static void read(KeyTrigger keyTrigger, TypedArray typedArray, Context context) {
            int indexCount = typedArray.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = typedArray.getIndex(i);
                switch (mAttrMap.get(index)) {
                    case 1:
                        String unused = keyTrigger.mNegativeCross = typedArray.getString(index);
                        break;
                    case 2:
                        String unused2 = keyTrigger.mPositiveCross = typedArray.getString(index);
                        break;
                    case 4:
                        String unused3 = keyTrigger.mCross = typedArray.getString(index);
                        break;
                    case 5:
                        keyTrigger.mTriggerSlack = typedArray.getFloat(index, keyTrigger.mTriggerSlack);
                        break;
                    case 6:
                        int unused4 = keyTrigger.mTriggerID = typedArray.getResourceId(index, keyTrigger.mTriggerID);
                        break;
                    case 7:
                        if (!MotionLayout.IS_IN_EDIT_MODE) {
                            if (typedArray.peekValue(index).type != 3) {
                                keyTrigger.mTargetId = typedArray.getResourceId(index, keyTrigger.mTargetId);
                                break;
                            } else {
                                keyTrigger.mTargetString = typedArray.getString(index);
                                break;
                            }
                        } else {
                            keyTrigger.mTargetId = typedArray.getResourceId(index, keyTrigger.mTargetId);
                            if (keyTrigger.mTargetId != -1) {
                                break;
                            } else {
                                keyTrigger.mTargetString = typedArray.getString(index);
                                break;
                            }
                        }
                    case 8:
                        keyTrigger.mFramePosition = typedArray.getInteger(index, keyTrigger.mFramePosition);
                        float unused5 = keyTrigger.mFireThreshold = (((float) keyTrigger.mFramePosition) + 0.5f) / 100.0f;
                        break;
                    case 9:
                        int unused6 = keyTrigger.mTriggerCollisionId = typedArray.getResourceId(index, keyTrigger.mTriggerCollisionId);
                        break;
                    case 10:
                        boolean unused7 = keyTrigger.mPostLayout = typedArray.getBoolean(index, keyTrigger.mPostLayout);
                        break;
                    case 11:
                        int unused8 = keyTrigger.mTriggerReceiver = typedArray.getResourceId(index, keyTrigger.mTriggerReceiver);
                        break;
                    case 12:
                        keyTrigger.mViewTransitionOnCross = typedArray.getResourceId(index, keyTrigger.mViewTransitionOnCross);
                        break;
                    case 13:
                        keyTrigger.mViewTransitionOnNegativeCross = typedArray.getResourceId(index, keyTrigger.mViewTransitionOnNegativeCross);
                        break;
                    case 14:
                        keyTrigger.mViewTransitionOnPositiveCross = typedArray.getResourceId(index, keyTrigger.mViewTransitionOnPositiveCross);
                        break;
                    default:
                        Log.e(TypedValues.TriggerType.NAME, "unused attribute 0x" + Integer.toHexString(index) + "   " + mAttrMap.get(index));
                        break;
                }
            }
        }
    }

    public Key copy(Key key) {
        super.copy(key);
        KeyTrigger keyTrigger = (KeyTrigger) key;
        this.mCurveFit = keyTrigger.mCurveFit;
        this.mCross = keyTrigger.mCross;
        this.mTriggerReceiver = keyTrigger.mTriggerReceiver;
        this.mNegativeCross = keyTrigger.mNegativeCross;
        this.mPositiveCross = keyTrigger.mPositiveCross;
        this.mTriggerID = keyTrigger.mTriggerID;
        this.mTriggerCollisionId = keyTrigger.mTriggerCollisionId;
        this.mTriggerCollisionView = keyTrigger.mTriggerCollisionView;
        this.mTriggerSlack = keyTrigger.mTriggerSlack;
        this.mFireCrossReset = keyTrigger.mFireCrossReset;
        this.mFireNegativeReset = keyTrigger.mFireNegativeReset;
        this.mFirePositiveReset = keyTrigger.mFirePositiveReset;
        this.mFireThreshold = keyTrigger.mFireThreshold;
        this.mFireLastPos = keyTrigger.mFireLastPos;
        this.mPostLayout = keyTrigger.mPostLayout;
        this.mCollisionRect = keyTrigger.mCollisionRect;
        this.mTargetRect = keyTrigger.mTargetRect;
        this.mMethodHashMap = keyTrigger.mMethodHashMap;
        return this;
    }

    public Key clone() {
        return new KeyTrigger().copy(this);
    }
}
