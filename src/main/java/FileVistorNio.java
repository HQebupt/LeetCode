import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.LinkedList;
import java.util.List;

public class FileVistorNio {

    /**
     * 性能低
     * @param root
     * @return
     */
    public List<File> findTxt(File root) {
        if (root == null) {
            return null;
        }
        List<File> targetFiles = new LinkedList<>();
        LinkedList<File> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            File cur = queue.pollFirst();
            File[] files = cur.listFiles();
            for (File file : files) {
                if (file.isDirectory()) {
                    queue.addLast(file);
                } else if (file.isFile() && file.getName().endsWith(".java")) {
                    targetFiles.add(file);
                }
            }
        }
        return targetFiles;
    }

    /**
     *  NIO file visitor
     * @param root
     */
    public List<File> findTxtV2(File root) {
        if (root == null) {
            return null;
        }
        List<File> targetFiles = new LinkedList<>();
        Path path = Paths.get(root.toURI());
        FileVisitor<Path> fileVisitor = new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path path, BasicFileAttributes attrs)
                    throws IOException {
                if (path.toString().endsWith(".java")) {
                    targetFiles.add(path.toFile());
                }
                return FileVisitResult.CONTINUE;
            }
        };

        try {
            Files.walkFileTree(path, fileVisitor);
        } catch (IOException e) {
            System.err.println(e);
        }
        return targetFiles;
    }

    // Test
    public static void main(String[] args) {
        FileVistorNio sol = new FileVistorNio();
        List<File> res = sol.findTxt(new File("."));
        System.out.println("Files count:" + res.size());
        System.out.println("Target file list:");
        for (File file : res) {
            System.out.println(file.getName());
        }
    }
}