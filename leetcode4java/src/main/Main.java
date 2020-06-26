import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello LeetCode!");
        System.out.println("从今以后无感情，只做一个刷题怪!");
        renameFile();
    }

    private static void renameFile() {
        File file = new File("F:\\LeetCode\\src");
        if (file.exists()) {
            System.out.println("存在");
            File[] files = file.listFiles();
            for (int i = 0; i < files.length; i++) {
                if (files[i].isDirectory()) {
                    String fileName = files[i].getName();
                    String[] s = fileName.replace("Problem", "").split("_");

                    if (s.length == 3) {
                        File classFile = new File(files[i].getAbsolutePath() + File.separator + "Solution.java");
                        if (classFile.exists()) {
                            List<String> contentList = new ArrayList<>();
                            try (
                                    BufferedReader br = new BufferedReader(new FileReader(classFile))
                            ) {
                                String tempStr;
                                while ((tempStr = br.readLine()) != null) {
                                    contentList.add(tempStr);
                                }
                                System.out.println(fileName + "：读取完成");



                                try (
                                        BufferedWriter bw = new BufferedWriter(new FileWriter(classFile, false))
                                ) {
                                    String pacakgeMessage = "package " + fileName + ";";
                                    if (contentList.size() == 0) {
                                        contentList.add(pacakgeMessage);
                                    } else {
                                        contentList.set(0, pacakgeMessage);
                                    }
                                    for (String s1 : contentList) {
                                        bw.write(s1, 0, s1.length());
                                        bw.newLine();
                                    }
                                    System.out.println(fileName + "：写入完成");
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            } catch (FileNotFoundException e) {
                                e.printStackTrace();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        }
    }
}

