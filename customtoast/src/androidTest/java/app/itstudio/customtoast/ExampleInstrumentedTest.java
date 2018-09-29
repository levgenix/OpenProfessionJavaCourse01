/*
 * Created by Evgeny V. Lobach on 22.09.18 21:42
 * Copyright (c) 2018 | www.itstudio.app | All rights reserved.
 * Last modified 22.09.18 21:41
 */

package app.itstudio.customtoast;

import android.content.Context;
import androidx.test.InstrumentationRegistry;
import androidx.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("app.itstudio.customtoast", appContext.getPackageName());
    }
}
