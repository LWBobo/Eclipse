import java.util.ArrayList;

import java.io.File;
public class Test {

	//AD为广告内容
  //  public static final String AD = "要去除的字符";
    public static final String AD = "讲解-";
    public static int fileNum = 0;
 
    public static void main(String[] args) {
        //文件夹路径名
     //   String rootPath = "指定的文件（夹）路径";
        String rootPath = "G:\\Study\\Struts2";
        scanFile(rootPath);
        System.out.println("共去广告" + fileNum + "个文件");
    }
 
    /*
     * 递归调用查找指定文件夹下所有文件
     */
    public static void scanFile(String path) {
        File dirFile = reName(new File(path));
        System.out.println(dirFile.getAbsolutePath());
        if (dirFile.isDirectory()){
            String[] fileList = dirFile.list();
            for (int i = 0; i < fileList.length; i++) {
                path = dirFile.getAbsolutePath() + "\\" + fileList[i];
                scanFile(path);
            }
        }
    }
 
    public static File reName(File oldFile) {
        //不带路径的文件名
        String originalName = oldFile.getName();        
        if (originalName.contains(AD)) {
            //带路径的文件名
            String oldFilePath = oldFile.getAbsolutePath();// 目录路径
            String newFilePath = oldFilePath.replace(AD, "");
            File newFile = new File(newFilePath);
            if (oldFile.renameTo(newFile)) {
                fileNum++;
                return newFile;
            }
        }
        return oldFile;
    }


}
