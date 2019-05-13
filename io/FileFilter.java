import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;


public class A3 {

// 扫描.png的图片
private static void getFile( File file ){
    MyFilenameFilter myFileFilter = new MyFilenameFilter( ".png") ;

    File[] files = file.listFiles( myFileFilter ) ;
    for( File f : files ){
        if ( f.isHidden() ) continue ;

        System.out.println( f.getAbsolutePath() );
    }
}
static class MyFilenameFilter implements FilenameFilter {
    //type为需要过滤的条件，比如如果type=".jpg"，则只能返回后缀为jpg的文件
    private String type;           
    MyFilenameFilter( String type){
        this.type = type ;
    }

    @Override
    public boolean accept(File dir, String name) {
        //dir表示文件的当前目录，name表示文件名；
        return name.endsWith( type ) ;
    }

}

// 找出java文件
public class DirFilter implements FilenameFilter {
    final static String REGEX = ".*\\.java";

    @Override
    public boolean accept(File dir, String name) {
        return Pattern.matches(REGEX, name);
    }
}
}