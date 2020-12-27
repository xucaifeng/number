package com.cenozoic.number.util;

import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

@Slf4j
public class FileUtils {
    private static int BYTE_SIZE = 8;
    public static String CODE_UTF8 = "UTF-8";
    public static String CODE_UTF8_BOM = "UTF-8_BOM";
    public static String CODE_GBK = "GBK";

    /**
     * 获取文件夹下的指定的文件类型的绝对路径
     *
     * @param path       文件夹
     * @param fileTypeList   文件类型集合
     * @param returnList 返回的绝对路径的集合
     * @return
     */
    public static List<File> getFileNames(String path, ArrayList<String> fileTypeList, ArrayList<File> returnList) {
        File file = new File(path);
        File[] fs = file.listFiles();
        if(null == fs || fs.length<1){
            return returnList;
        }
        for (File f : fs) {
            if (!f.isDirectory()) {
                for (String fileType:fileTypeList) {
                    if (f.getName().endsWith(fileType)) {
                        returnList.add(f);
                    }
                }
            } else {
                getFileNames(f.getAbsolutePath(), fileTypeList, returnList);
            }
        }
        return returnList;
    }

    /**
     * 读取文件类容
     * @param file
     * @return
     * @throws Exception 返回文件内容
     */
    public static String txt2String(File file) {
        String returnStr = null;
        try {
            byte[] data = Files.readAllBytes(file.toPath());
            returnStr = new String(data, getEncode(file.getAbsolutePath(), true));
        } catch (Exception e) {
            log.info("读取文件类容异常",e);
        }
        return returnStr;
    }

    /**
     * 通过文件全名称获取编码集名称
     *
     * @param fullFileName
     * @param ignoreBom
     * @return
     * @throws Exception
     */
    public static String getEncode(String fullFileName, boolean ignoreBom) throws Exception {
        log.debug("fullFileName ; {}", fullFileName);
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(fullFileName));
        return getEncode(bis, ignoreBom);
    }

    /**
     * 通过文件缓存流获取编码集名称，文件流必须为未曾
     *
     * @param bis
     * @param ignoreBom 是否忽略utf-8 bom
     * @return
     * @throws Exception
     */
    public static String getEncode(BufferedInputStream bis, boolean ignoreBom) throws Exception {
        bis.mark(0);
        //默认utf-8
        String encodeType = CODE_UTF8;
        byte[] head = new byte[3];
        bis.read(head);
        if (head[0] == -1 && head[1] == -2) {
            encodeType = "UTF-16";
        } else if (head[0] == -2 && head[1] == -1) {
            encodeType = "Unicode";
        } else if (head[0] == -17 && head[1] == -69 && head[2] == -65) { //带BOM
            if (ignoreBom) {
                encodeType = CODE_UTF8;
            } else {
                encodeType = CODE_UTF8_BOM;
            }
        } else if ("Unicode".equals(encodeType)) {
            encodeType = "UTF-16";
        } else if (isUTF8(bis)) {
            encodeType = CODE_UTF8;
        } else {
            encodeType = CODE_GBK;
        }
        log.info("result encode type :{} " , encodeType);
        return encodeType;
    }

    /**
     * 是否是无BOM的UTF8格式，不判断常规场景，只区分无BOM UTF8和GBK
     *
     * @param bis
     * @return
     */
    public static boolean isUTF8(BufferedInputStream bis) throws Exception {
        bis.reset();
        //读取第一个字节
        int code = bis.read();
        do {
            BitSet bitSet = convert2BitSet(code);
            //判断是否为单字节
            if (bitSet.get(0)) {//多字节时，再读取N个字节
                if (!checkMultiByte(bis, bitSet)) {//未检测通过,直接返回
                    return false;
                }
            }
            //单字节时什么都不用做，再次读取字节
            code = bis.read();
        } while (code != -1);
        return true;
    }

    /**
     * 检测多字节，判断是否为utf8，已经读取了一个字节
     *
     * @param bis
     * @param bitSet
     * @return
     */
    private static boolean checkMultiByte(BufferedInputStream bis, BitSet bitSet) throws Exception {
        int count = getCountOfSequential(bitSet);
        byte[] bytes = new byte[count - 1];//已经读取了一个字节，不能再读取
        bis.read(bytes);
        for (byte b : bytes) {
            if (!checkUtf8Byte(b)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 检测单字节，判断是否为utf8
     *
     * @param b
     * @return
     */
    private static boolean checkUtf8Byte(byte b) throws Exception {
        BitSet bitSet = convert2BitSet(b);
        return bitSet.get(0) && !bitSet.get(1);
    }

    /**
     * 检测bitSet中从开始有多少个连续的1
     *
     * @param bitSet
     * @return
     */
    private static int getCountOfSequential(BitSet bitSet) {
        int count = 0;
        for (int i = 0; i < BYTE_SIZE; i++) {
            if (bitSet.get(i)) {
                count++;
            } else {
                break;
            }
        }
        return count;
    }

    /**
     * 将整形转为BitSet
     *
     * @param code
     * @return
     */
    private static BitSet convert2BitSet(int code) {
        BitSet bitSet = new BitSet(BYTE_SIZE);
        for (int i = 0; i < BYTE_SIZE; i++) {
            int tmp3 = code >> (BYTE_SIZE - i - 1);
            int tmp2 = 0x1 & tmp3;
            if (tmp2 == 1) {
                bitSet.set(i);
            }
        }
        return bitSet;
    }

    /**
     * 将一指定编码的文件转换为另一编码的文件
     *
     * @param oldFullFileName
     * @param oldCharsetName
     * @param newFullFileName
     * @param newCharsetName
     */
    public static void convert(String oldFullFileName, String oldCharsetName, String newFullFileName, String newCharsetName) throws Exception {
        log.info("the old file name is : {}, The oldCharsetName is : {}", oldFullFileName, oldCharsetName);
        log.info("the new file name is : {}, The newCharsetName is : {}", newFullFileName, newCharsetName);
        StringBuffer content = new StringBuffer();
        BufferedReader bin = new BufferedReader(new InputStreamReader(new FileInputStream(oldFullFileName), oldCharsetName));
        String line;
        while ((line = bin.readLine()) != null) {
            content.append(line);
            content.append(System.getProperty("line.separator"));
        }
        newFullFileName = newFullFileName.replace("\\", "/");
        File dir = new File(newFullFileName.substring(0, newFullFileName.lastIndexOf("/")));
        if (!dir.exists()) {
            dir.mkdirs();
        }
        Writer out = new OutputStreamWriter(new FileOutputStream(newFullFileName), newCharsetName);
        out.write(content.toString());
    }

    /**
     *  复制文件
     * @param source
     * @param dest
     * @throws Exception
     */
    private static void copyFile(File source,File dest) throws Exception {
        FileChannel inputChannel = null;
        FileChannel outputChannel = null;
        try {
            inputChannel = new FileInputStream(source).getChannel();
            outputChannel = new FileOutputStream(dest).getChannel();
            outputChannel.transferFrom(inputChannel,0,inputChannel.size());
        } finally {
            if(null != inputChannel){
                inputChannel.close();
            }
            if(null != outputChannel){
                outputChannel.close();
            }
        }
    }
    public static void saveAsFileWriter(String filePath, String content,boolean append) {
        FileWriter fwriter = null;
        try {
            // true表示不覆盖原来的内容，而是加到文件的后面。若要覆盖原来的内容，直接省略这个参数就好
            fwriter = new FileWriter(filePath, append);
            fwriter.write(content);
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                fwriter.flush();
                fwriter.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    /**
     * 根据路径读取文件，以每行为一条数据返回List
     * @param path
     * @return
     * @throws IOException
     */
    public static List<String> readFile(String path) throws IOException {
        List<String> list = new ArrayList<String>();
        FileInputStream fis = new FileInputStream(path);
        // 防止路径乱码   如果utf-8 乱码  改GBK
        InputStreamReader isr = new InputStreamReader(fis, "GBK");
        BufferedReader br = new BufferedReader(isr);
        String line = "";
        while ((line = br.readLine()) != null) {
            list.add(line);
        }
        br.close();
        isr.close();
        fis.close();
        return list;
    }

    /**
     *  创建文件
     * @param filePath 文件夹
     * @param fileName 文件名
     * @return
     */
    public static File createFile(String filePath,String fileName) {
        File file = null;
        try {
            File dir = new File(filePath);
            if (!dir.exists()) {
                dir.mkdirs();
            }
            file = new File(dir, fileName);
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (Exception e) {
            log.info("创建文件异常",e);
        }
        return file;
    }
    /**
     *创建文件
     * @param pathname 全路径名
     * @return
     */
    public static File createFile(String pathname) {
        File file = new File(pathname);
        File dir = file.getParentFile();
        if (!dir.exists()) {
            dir.mkdirs();
        }
        try {
            file.createNewFile();
        } catch (IOException e) {
           log.info("创建文件异常",e);
        }
        return file;
    }

    public static void main(String[] args) throws Exception {
        int a =1;
//        String s = "/Applications/24 Hour Wallpaper.app/Contents/Resources";
        /*String s = "/Applications/";
        List<File> jpg = getFileNames(s, ListUtil.newArrayList("jpg,png,JPG,PNG".split(",")), ListUtil.newArrayList());
        for (File f: jpg) {
            System.out.println("aaaaa:/Users/northlee/Pictures/screensaver/"+ a+ f.getName());
            File file = new File("/Users/northlee/Pictures/screensaver/" +a+ f.getName());
            copyFile(f, file);
            a ++;
//            System.out.println(f.getName());
//            System.out.println(f.getAbsolutePath());
        }*/
//        System.out.println(JSON.toJSON(jpg));


       /* String path = "/Users/northlee/Desktop";
        List<File> txtFileList = FileUtils.getFileNames(path, ListUtil.newArrayList("105104.txt"), ListUtil.newArrayList());
        for (File txtFile : txtFileList) {
            System.out.println(txt2String(txtFile));
//            System.out.println(  readToString(txtFile.getAbsolutePath()));
        }*/

        createFile("/Users/northlee/Desktop/aaa/bbb/aaa/bbb.tft");
    }
}
