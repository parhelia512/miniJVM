/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mini.zip;

/**
 *
 * byte[] b = javax.mini.zip.Zip.getEntry("../lib/minijvm_rt.jar",
 * "sys.properties"); for (int i = 0; i < b.length; i++) {
 * System.out.print((char) b[i]); }
 *
 * Zip.putEntry("../tmp.zip", "aaa/sys.properties", b);
 *
 * @author Gust
 */
public class Zip {

    /**
     * read file from zipFile
     *
     * @param zipFile
     * @param name
     * @return
     */
    public static byte[] getEntry(String zipFile, String name) {
        try {
            String z = zipFile + "\0";
            byte[] zpath = z.getBytes("utf-8");
            String n = name + "\0";
            byte[] npath = n.getBytes("utf-8");
            return getEntry0(zpath, npath);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    /**
     *
     * save file to zip File
     *
     * @param zipFile
     * @param name
     * @param contents
     * @return
     */
    public static int putEntry(String zipFile, String name, byte[] contents) {
        try {
            String z = zipFile + "\0";
            byte[] zpath = z.getBytes("utf-8");
            String n = name + "\0";
            byte[] npath = n.getBytes("utf-8");
            return putEntry0(zpath, npath, contents);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return 0;
    }

    public static int fileCount(String zipFile) {
        try {
            String z = zipFile + "\0";
            byte[] zpath = z.getBytes("utf-8");

            return fileCount0(zpath);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return 0;
    }

    public static String[] listFiles0(String zipFile) {
        try {
            String z = zipFile + "\0";
            byte[] zpath = z.getBytes("utf-8");

            return listFiles0(zpath);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public static boolean isDirectory0(String zipFile, int index) {
        try {
            String z = zipFile + "\0";
            byte[] zpath = z.getBytes("utf-8");

            return isDirectory0(zpath, index);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return true;
    }

    static native byte[] getEntry0(byte[] zippath, byte[] path);

    static native int putEntry0(byte[] zippath, byte[] path, byte[] contents);

    static native int fileCount0(byte[] zippath);

    static native String[] listFiles0(byte[] zippath);

    static native boolean isDirectory0(byte[] zippath, int index);
}
