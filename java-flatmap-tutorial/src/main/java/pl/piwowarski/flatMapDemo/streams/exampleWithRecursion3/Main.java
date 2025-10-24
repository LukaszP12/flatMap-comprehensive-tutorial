package pl.piwowarski.flatMapDemo.streams.exampleWithRecursion3;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Stream;

class Main {
    public static void main(String[] args) {
        Folder images = new Folder("Images",
                List.of(new FileEntry("photo1.jpg", 500),
                        new FileEntry("photo2.jpg", 800)),
                List.of()
        );

        Folder docs = new Folder("Documents",
                List.of(new FileEntry("cv.pdf", 200),
                        new FileEntry("notes.txt", 50)),
                List.of()
        );

        Folder root = new Folder("Root",
                List.of(new FileEntry("readme.md", 10)),
                List.of(images, docs)
        );

        Stream<FileEntry> flatten = flatten(root);
        int totalSize = flatten.mapToInt(file -> file.size).sum();
        System.out.println("Total size: " + totalSize + " KB");

        /// Count number of files
        long fileCount = flatten(root).count();
        System.out.println("Total number of files: " + fileCount);

        // Find the largest file
        Optional<FileEntry> largestFile = flatten(root)
                .max(Comparator.comparingInt(file -> file.size));


        Folder images2 = new Folder("Images",
                List.of(new FileEntry("photo1.jpg", 500),
                        new FileEntry("photo2.jpg", 800)),
                List.of()
        );

        Folder docs2 = new Folder("Documents",
                List.of(new FileEntry("cv.pdf", 200),
                        new FileEntry("notes.txt", 50)),
                List.of()
        );

        Folder root2 = new Folder("Root",
                List.of(new FileEntry("readme.md", 10)),
                List.of(images, docs)
        );

        Optional<FileEntry> largestFile2 = flatten(root2).max(Comparator.comparingInt(file -> file.size));

        largestFile2.ifPresent(file->
                System.out.println("Largest file: " + file.name + " (" + file.size + " KB)"));

        // check if a file exists by name
        boolean exists = flatten(root2)
                .anyMatch(file -> file.name.equalsIgnoreCase("photo1.jpg"));
        System.out.println("exists " + exists);

//        ✅ Calculate average file size
        OptionalDouble avgSize = flatten(root2)
                .mapToInt(file -> file.size)
                .average();
        System.out.println("avgSize " + avgSize);
    }

    static Stream<FileEntry> flatten(Folder folder) {
        return Stream.concat(
                folder.files.stream(),  // current folder's files
                folder.subFolders.stream()
                        .flatMap(Main::flatten) // recursively flatten subfolders
        );
    }
}
