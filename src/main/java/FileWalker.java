import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class FileWalker implements Iterator<Path> {
    final BlockingQueue<Path> bq;

    FileWalker(final File fileStart, final int size) throws Exception {
        bq = new ArrayBlockingQueue<Path>(size);
        Thread thread = new Thread(new Runnable() {
            public void run() {
                try {
                    Files.walkFileTree(fileStart.toPath(), new FileVisitor<Path>() {
                        public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                            return FileVisitResult.CONTINUE;
                        }

                        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                            try {
                                bq.offer(file, 4242, TimeUnit.HOURS);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            return FileVisitResult.CONTINUE;
                        }

                        public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
                            return FileVisitResult.CONTINUE;
                        }

                        public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                            return FileVisitResult.CONTINUE;
                        }
                    });
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.setDaemon(true);
        thread.start();
        thread.join(200);
    }

    public Iterator<Path> iterator() {
        return this;
    }

    public boolean hasNext() {
        boolean hasNext = false;
        long dropDeadMS = System.currentTimeMillis() + 2000;
        while (System.currentTimeMillis() < dropDeadMS) {
            if (bq.peek() != null) {
                hasNext = true;
                break;
            }

        }
        return hasNext;
    }

    public Path next() {
        Path path = null;
        try {
            path = bq.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return path;
    }

    public void remove() {
        throw new UnsupportedOperationException();
    }

    public static void main(String[] args) throws Exception {
        long startTime = System.nanoTime();
        FileWalker z = new FileWalker(new File("/usr"), 1024); // start path, queue size
        List<File> targetFiles = new LinkedList<>();
        Iterator<Path> i = z.iterator();
        while (i.hasNext()) {
            Path p = i.next();
            if(p.toString().endsWith("1.gz")) {
                targetFiles.add(p.toFile());
            }
        }
        long endTime = System.nanoTime();
        long cost = endTime - startTime;
        System.out.println("File Vistor traditional const:(ms)" + cost/1000000 + "  count:" + targetFiles.size());
    }
}