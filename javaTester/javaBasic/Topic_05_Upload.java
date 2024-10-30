package javaBasic;

public class Topic_05_Upload {

    static String[] fileNames = {"avatar.jpg", "sua.jpg", "tho.jpg"};

    static String fullFileName = "";

    public static void main(String[] args) {
        String filePath = System.getProperty("user.dir") + "\\uploadFiles\\";
        System.out.println(filePath);

        for (String file : fileNames) {
            System.out.println(file);
            fullFileName = fullFileName + filePath + file + "\n";
            System.out.println(fullFileName);
        }

        System.out.println("Full file name: " + fullFileName);
        fullFileName = fullFileName.trim();

        System.out.println("Full file name: " + fullFileName);
    }

}
