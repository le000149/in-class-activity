package com.college.converter;


import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class MainActivityTest {

    private MainActivity mainActivity;

    @Before
    public void setUp() {
        mainActivity = new MainActivity();
    }

    @Test
    public void testLogMessages() {
        // Mock LogWrapper class behavior
        MockLogWrapper mockLogWrapper = new MockLogWrapper();

        // Set the mock LogWrapper in MainActivity
        mainActivity.setLogWrapper(mockLogWrapper);

        // Call onCreate method
        mainActivity.onCreate(null);

        // Verify log messages
        assertTrue(mockLogWrapper.entryMessageLogged);
        assertTrue(mockLogWrapper.exitMessageLogged);
    }

    // Mock LogWrapper class to capture log messages
    static class MockLogWrapper extends MainActivity.LogWrapper {
        boolean entryMessageLogged = false;
        boolean exitMessageLogged = false;

        @Override
        public void log(String tag, String message) {
            if (message.contains("onCreate() method called")) {
                entryMessageLogged = true;
            } else if (message.contains("onCreate() method finished")) {
                exitMessageLogged = true;
            }
        }
    }
}


