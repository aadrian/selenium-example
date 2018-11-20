package com.mycorp;

import java.io.File;
import java.io.IOException;

public class Utils {
    /**
     * Tries to fix the Application home where this app is running.
     *
     * @return the fixed cannonical path of the app.
     * @throws IOException if something goes wrong.
     */
    public static String fixAppHome() throws IOException {
        String appHome = System.getenv("APP_HOME");
        if(appHome==null) {
            appHome = ".";
        }
        System.out.println("appHome (from ENV) = " + appHome);
        File f = new File(appHome);
        String correctAppHome = f.getCanonicalPath().replace('\\','/');
        System.out.println("correctAppHome = " + correctAppHome);
        return correctAppHome;
    }
}
