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
                } else if (file.isFile() && file.getName().endsWith("gz")) {
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
        Path path = root.toPath();
        FileVisitor<Path> fileVisitor = new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path path, BasicFileAttributes attrs)
                    throws IOException {
                if (path.toString().endsWith("gz")) {
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

    public List<File> findTxt3(File root) {
        if (root == null) {
            return null;
        }
        List<File> targetFiles = new LinkedList<>();
        LinkedList<Path> queue = new LinkedList<>();
        queue.add(root.toPath());
        while (!queue.isEmpty()) {
            Path cur = queue.pollFirst();
            try (DirectoryStream<Path> stream = Files.newDirectoryStream(cur)) {
                for (Path entry : stream) {
                    if (entry.toFile().isDirectory()) {
                        queue.add(entry);
                    } else if (entry.toString().endsWith("gz")) {
                        targetFiles.add(entry.toFile());
                    }
                }
            } catch (DirectoryIteratorException ex) {
                ex.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return targetFiles;
    }


    // Test
    public static void main(String[] args) {

        FileVistorNio sol = new FileVistorNio();
        long startTime2 = System.nanoTime();
        List<File> res2 = sol.findTxtV2(new File("/usr"));
        long endTime2 = System.nanoTime();
        long cost2 = endTime2 - startTime2;
        System.out.println("File Vistor Nio const:(ms)" + cost2/1000000 + "  count:" + res2.size());

        long startTime3 = System.nanoTime();
        List<File> res3 = sol.findTxt3(new File("/usr"));
        long endTime3 = System.nanoTime();
        long cost3 = endTime3 - startTime3;
        System.out.println("File Vistor  newDirectoryStream  const:(ms)" + cost3/1000000 + "  count:" + res3.size());
        System.out.println("ratio:" + (cost3 / cost2));


        long startTime = System.nanoTime();
        List<File> res = sol.findTxt(new File("/usr"));
        long endTime = System.nanoTime();
        long cost = endTime - startTime;
        System.out.println("File Vistor traditional const:(ms)" + cost/1000000 + "  count:" + res.size());
        System.out.println("ratio:" + (cost / cost2));


//        System.out.println("Files count:" + res.size());
//        System.out.println("Target file list:");
//        for (File file : res) {
//            System.out.println(file.getName());
//        }
    }
}